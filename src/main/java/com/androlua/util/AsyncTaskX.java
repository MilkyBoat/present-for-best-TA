package com.androlua.util;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTaskX<Params, Progress, Result> {
    public static final Executor SERIAL_EXECUTOR = new SerialExecutor();
    public static final Executor THREAD_POOL_EXECUTOR;

    /* renamed from: a */
    private static final int f2754a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    private static final ThreadFactory f2755b = new ThreadFactory() {

        /* renamed from: a */
        private final AtomicInteger f2765a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncTask #");
            sb.append(this.f2765a.getAndIncrement());
            return new Thread(runnable, sb.toString());
        }
    };

    /* renamed from: c */
    private static final BlockingQueue<Runnable> f2756c = new LinkedBlockingQueue(1024);

    /* renamed from: d */
    private static volatile Executor f2757d = THREAD_POOL_EXECUTOR;

    /* renamed from: e */
    private static InternalHandler f2758e;

    /* renamed from: f */
    private final WorkerRunnable<Params, Result> f2759f;

    /* renamed from: g */
    private final FutureTask<Result> f2760g;

    /* renamed from: h */
    private volatile Status f2761h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final AtomicBoolean f2762i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final AtomicBoolean f2763j;

    /* renamed from: k */
    private final Handler f2764k;

    private static class AsyncTaskResult<Data> {

        /* renamed from: a */
        final AsyncTaskX f2769a;

        /* renamed from: b */
        final Data[] f2770b;

        AsyncTaskResult(AsyncTaskX asyncTaskX, Data... dataArr) {
            this.f2769a = asyncTaskX;
            this.f2770b = dataArr;
        }
    }

    private static class InternalHandler extends Handler {
        public InternalHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            switch (message.what) {
                case 1:
                    asyncTaskResult.f2769a.m2353e(asyncTaskResult.f2770b[0]);
                    return;
                case 2:
                    asyncTaskResult.f2769a.mo2149b((Progress[]) asyncTaskResult.f2770b);
                    return;
                default:
                    return;
            }
        }
    }

    private static class SerialExecutor implements Executor {

        /* renamed from: a */
        final ArrayDeque<Runnable> f2771a;

        /* renamed from: b */
        Runnable f2772b;

        private SerialExecutor() {
            this.f2771a = new ArrayDeque<>();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public synchronized void mo2658a() {
            Runnable runnable = (Runnable) this.f2771a.poll();
            this.f2772b = runnable;
            if (runnable != null) {
                AsyncTaskX.THREAD_POOL_EXECUTOR.execute(this.f2772b);
            }
        }

        public synchronized void execute(final Runnable runnable) {
            this.f2771a.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.mo2658a();
                    }
                }
            });
            if (this.f2772b == null) {
                mo2658a();
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {

        /* renamed from: b */
        Params[] f2776b;

        private WorkerRunnable() {
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 128, 30, TimeUnit.SECONDS, f2756c, f2755b);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    public AsyncTaskX() {
        this((Looper) null);
    }

    public AsyncTaskX(Handler handler) {
        this(handler != null ? handler.getLooper() : null);
    }

    public AsyncTaskX(Looper looper) {
        this.f2761h = Status.PENDING;
        this.f2762i = new AtomicBoolean();
        this.f2763j = new AtomicBoolean();
        this.f2764k = (looper == null || looper == Looper.getMainLooper()) ? m2348c() : new Handler(looper);
        this.f2759f = new WorkerRunnable<Params, Result>() {
            public Result call() {
                AsyncTaskX.this.f2763j.set(true);
                Object obj = null;
                try {
                    Process.setThreadPriority(10);
                    Result a = AsyncTaskX.this.mo1858a((Params[]) this.f2776b);
                    try {
                        Binder.flushPendingCommands();
                        AsyncTaskX.this.m2352d(a);
                        return a;
                    } catch (Throwable th) {
                        th = th;
                        obj = a;
                        AsyncTaskX.this.m2352d(obj);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    AsyncTaskX.this.f2762i.set(true);
                    throw th;
                }
            }
        };
        this.f2760g = new FutureTask<Result>(this.f2759f) {
            /* access modifiers changed from: protected */
            public void done() {
                try {
                    AsyncTaskX.this.m2350c(get());
                } catch (InterruptedException e) {
                    Log.w("AsyncTaskX", e);
                } catch (ExecutionException e2) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
                } catch (CancellationException unused) {
                    AsyncTaskX.this.m2350c(null);
                }
            }
        };
    }

    /* renamed from: c */
    private static Handler m2348c() {
        InternalHandler internalHandler;
        synchronized (AsyncTaskX.class) {
            if (f2758e == null) {
                f2758e = new InternalHandler(Looper.getMainLooper());
            }
            internalHandler = f2758e;
        }
        return internalHandler;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2350c(Result result) {
        if (!this.f2763j.get()) {
            m2352d(result);
        }
    }

    /* renamed from: d */
    private Handler m2351d() {
        return this.f2764k;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public Result m2352d(Result result) {
        m2351d().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2353e(Result result) {
        if (isCancelled()) {
            mo2645b(result);
        } else {
            mo1859a(result);
        }
        this.f2761h = Status.FINISHED;
    }

    public static void execute(Runnable runnable) {
        f2757d.execute(runnable);
    }

    public static void setDefaultExecutor(Executor executor) {
        f2757d = executor;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Result mo1858a(Params... paramsArr);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo2643a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1859a(Result result) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo2644b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo2645b(Result result) {
        mo2644b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo2149b(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo2646c(Progress... progressArr) {
        if (!isCancelled()) {
            m2351d().obtainMessage(2, new AsyncTaskResult(this, progressArr)).sendToTarget();
        }
    }

    public final boolean cancel(boolean z) {
        this.f2762i.set(true);
        return this.f2760g.cancel(z);
    }

    public final AsyncTaskX<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(f2757d, paramsArr);
    }

    public final AsyncTaskX<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.f2761h != Status.PENDING) {
            switch (this.f2761h) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f2761h = Status.RUNNING;
        mo2643a();
        this.f2759f.f2776b = paramsArr;
        executor.execute(this.f2760g);
        return this;
    }

    public final Result get() {
        return this.f2760g.get();
    }

    public final Result get(long j, TimeUnit timeUnit) {
        return this.f2760g.get(j, timeUnit);
    }

    public final Status getStatus() {
        return this.f2761h;
    }

    public final boolean isCancelled() {
        return this.f2762i.get();
    }
}
