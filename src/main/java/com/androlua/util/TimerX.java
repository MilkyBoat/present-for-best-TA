package com.androlua.util;

import bsh.org.objectweb.asm.Constants;
import java.util.Date;

public class TimerX {

    /* renamed from: a */
    private static long f2810a;

    /* renamed from: b */
    private final TimerImpl f2811b;

    /* renamed from: c */
    private final FinalizerHelper f2812c;

    private static final class FinalizerHelper {

        /* renamed from: a */
        private final TimerImpl f2813a;

        FinalizerHelper(TimerImpl timerImpl) {
            this.f2813a = timerImpl;
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            try {
                synchronized (this.f2813a) {
                    this.f2813a.f2815b = true;
                    this.f2813a.notify();
                }
                super.finalize();
            } catch (Throwable th) {
                super.finalize();
                throw th;
            }
        }
    }

    private static final class TimerImpl extends Thread {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f2814a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public boolean f2815b;

        /* renamed from: c */
        private TimerHeap f2816c = new TimerHeap();

        private static final class TimerHeap {

            /* renamed from: a */
            private int f2817a;

            /* renamed from: b */
            private TimerTaskX[] f2818b;

            /* renamed from: c */
            private int f2819c;
            /* access modifiers changed from: private */

            /* renamed from: d */
            public int f2820d;

            private TimerHeap() {
                this.f2817a = Constants.ACC_NATIVE;
                this.f2818b = new TimerTaskX[this.f2817a];
                this.f2819c = 0;
                this.f2820d = 0;
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public int m2380a(TimerTaskX timerTaskX) {
                for (int i = 0; i < this.f2818b.length; i++) {
                    if (this.f2818b[i] == timerTaskX) {
                        return i;
                    }
                }
                return -1;
            }

            /* renamed from: a */
            private void m2384a() {
                int i = this.f2819c - 1;
                int i2 = (i - 1) / 2;
                while (this.f2818b[i].f2806d < this.f2818b[i2].f2806d) {
                    TimerTaskX timerTaskX = this.f2818b[i];
                    this.f2818b[i] = this.f2818b[i2];
                    this.f2818b[i2] = timerTaskX;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            /* renamed from: a */
            private void m2385a(int i) {
                int i2 = (i * 2) + 1;
                while (i2 < this.f2819c && this.f2819c > 0) {
                    int i3 = i2 + 1;
                    if (i3 < this.f2819c && this.f2818b[i3].f2806d < this.f2818b[i2].f2806d) {
                        i2 = i3;
                    }
                    if (this.f2818b[i].f2806d >= this.f2818b[i2].f2806d) {
                        TimerTaskX timerTaskX = this.f2818b[i];
                        this.f2818b[i] = this.f2818b[i2];
                        this.f2818b[i2] = timerTaskX;
                        int i4 = i2;
                        i2 = (i2 * 2) + 1;
                        i = i4;
                    } else {
                        return;
                    }
                }
            }

            public void adjustMinimum() {
                m2385a(0);
            }

            public void delete(int i) {
                if (i >= 0 && i < this.f2819c) {
                    TimerTaskX[] timerTaskXArr = this.f2818b;
                    TimerTaskX[] timerTaskXArr2 = this.f2818b;
                    int i2 = this.f2819c - 1;
                    this.f2819c = i2;
                    timerTaskXArr[i] = timerTaskXArr2[i2];
                    this.f2818b[this.f2819c] = null;
                    m2385a(i);
                }
            }

            public void deleteIfCancelled() {
                int i = 0;
                while (i < this.f2819c) {
                    if (this.f2818b[i].f2805c) {
                        this.f2820d++;
                        delete(i);
                        i--;
                    }
                    i++;
                }
            }

            public void insert(TimerTaskX timerTaskX) {
                if (this.f2818b.length == this.f2819c) {
                    TimerTaskX[] timerTaskXArr = new TimerTaskX[(this.f2819c * 2)];
                    System.arraycopy(this.f2818b, 0, timerTaskXArr, 0, this.f2819c);
                    this.f2818b = timerTaskXArr;
                }
                TimerTaskX[] timerTaskXArr2 = this.f2818b;
                int i = this.f2819c;
                this.f2819c = i + 1;
                timerTaskXArr2[i] = timerTaskX;
                m2384a();
            }

            public boolean isEmpty() {
                return this.f2819c == 0;
            }

            public TimerTaskX minimum() {
                return this.f2818b[0];
            }

            public void reset() {
                this.f2818b = new TimerTaskX[this.f2817a];
                this.f2819c = 0;
            }
        }

        TimerImpl(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m2376a(TimerTaskX timerTaskX) {
            this.f2816c.insert(timerTaskX);
            notify();
        }

        public synchronized void cancel() {
            this.f2814a = true;
            this.f2816c.reset();
            notify();
        }

        public int purge() {
            if (this.f2816c.isEmpty()) {
                return 0;
            }
            this.f2816c.f2820d = 0;
            this.f2816c.deleteIfCancelled();
            return this.f2816c.f2820d;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|(2:8|(3:84|10|11)(2:12|13))(2:17|26)|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a0, code lost:
            if (r2.isEnabled() == false) goto L_0x0000;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a2, code lost:
            r2.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a7, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a8, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            r10.f2814a = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00b1, code lost:
            throw r0;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0018 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
            L_0x0000:
                monitor-enter(r10)
                boolean r0 = r10.f2814a     // Catch:{ all -> 0x00b8 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r10)     // Catch:{ all -> 0x00b8 }
                return
            L_0x0007:
                com.androlua.util.TimerX$TimerImpl$TimerHeap r0 = r10.f2816c     // Catch:{ all -> 0x00b8 }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00b8 }
                if (r0 == 0) goto L_0x001a
                boolean r0 = r10.f2815b     // Catch:{ all -> 0x00b8 }
                if (r0 == 0) goto L_0x0015
                monitor-exit(r10)     // Catch:{ all -> 0x00b8 }
                return
            L_0x0015:
                r10.wait()     // Catch:{ InterruptedException -> 0x0018 }
            L_0x0018:
                monitor-exit(r10)     // Catch:{ all -> 0x00b8 }
                goto L_0x0000
            L_0x001a:
                long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00b8 }
                com.androlua.util.TimerX$TimerImpl$TimerHeap r2 = r10.f2816c     // Catch:{ all -> 0x00b8 }
                com.androlua.util.TimerTaskX r2 = r2.minimum()     // Catch:{ all -> 0x00b8 }
                java.lang.Object r3 = r2.f2804b     // Catch:{ all -> 0x00b8 }
                monitor-enter(r3)     // Catch:{ all -> 0x00b8 }
                boolean r4 = r2.f2805c     // Catch:{ all -> 0x00b5 }
                r5 = 0
                if (r4 == 0) goto L_0x0033
                com.androlua.util.TimerX$TimerImpl$TimerHeap r0 = r10.f2816c     // Catch:{ all -> 0x00b5 }
                r0.delete(r5)     // Catch:{ all -> 0x00b5 }
                monitor-exit(r3)     // Catch:{ all -> 0x00b5 }
                goto L_0x0018
            L_0x0033:
                long r6 = r2.f2806d     // Catch:{ all -> 0x00b5 }
                r4 = 0
                long r8 = r6 - r0
                monitor-exit(r3)     // Catch:{ all -> 0x00b5 }
                r0 = 0
                int r3 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r3 <= 0) goto L_0x0043
                r10.wait(r8)     // Catch:{ InterruptedException -> 0x0018 }
                goto L_0x0018
            L_0x0043:
                java.lang.Object r3 = r2.f2804b     // Catch:{ all -> 0x00b8 }
                monitor-enter(r3)     // Catch:{ all -> 0x00b8 }
                com.androlua.util.TimerX$TimerImpl$TimerHeap r4 = r10.f2816c     // Catch:{ all -> 0x00b2 }
                com.androlua.util.TimerTaskX r4 = r4.minimum()     // Catch:{ all -> 0x00b2 }
                long r6 = r4.f2806d     // Catch:{ all -> 0x00b2 }
                long r8 = r2.f2806d     // Catch:{ all -> 0x00b2 }
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x005a
                com.androlua.util.TimerX$TimerImpl$TimerHeap r4 = r10.f2816c     // Catch:{ all -> 0x00b2 }
                int r5 = r4.m2380a(r2)     // Catch:{ all -> 0x00b2 }
            L_0x005a:
                boolean r4 = r2.f2805c     // Catch:{ all -> 0x00b2 }
                if (r4 == 0) goto L_0x006b
                com.androlua.util.TimerX$TimerImpl$TimerHeap r0 = r10.f2816c     // Catch:{ all -> 0x00b2 }
                com.androlua.util.TimerX$TimerImpl$TimerHeap r1 = r10.f2816c     // Catch:{ all -> 0x00b2 }
                int r1 = r1.m2380a(r2)     // Catch:{ all -> 0x00b2 }
                r0.delete(r1)     // Catch:{ all -> 0x00b2 }
                monitor-exit(r3)     // Catch:{ all -> 0x00b2 }
                goto L_0x0018
            L_0x006b:
                long r6 = r2.f2806d     // Catch:{ all -> 0x00b2 }
                r2.setScheduledTime(r6)     // Catch:{ all -> 0x00b2 }
                com.androlua.util.TimerX$TimerImpl$TimerHeap r4 = r10.f2816c     // Catch:{ all -> 0x00b2 }
                r4.delete(r5)     // Catch:{ all -> 0x00b2 }
                long r4 = r2.f2807e     // Catch:{ all -> 0x00b2 }
                int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r6 < 0) goto L_0x0098
                boolean r0 = r2.f2808f     // Catch:{ all -> 0x00b2 }
                if (r0 == 0) goto L_0x0089
                long r0 = r2.f2806d     // Catch:{ all -> 0x00b2 }
                long r4 = r2.f2807e     // Catch:{ all -> 0x00b2 }
                r6 = 0
                long r6 = r0 + r4
                r2.f2806d = r6     // Catch:{ all -> 0x00b2 }
                goto L_0x0094
            L_0x0089:
                long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00b2 }
                long r4 = r2.f2807e     // Catch:{ all -> 0x00b2 }
                r6 = 0
                long r6 = r0 + r4
                r2.f2806d = r6     // Catch:{ all -> 0x00b2 }
            L_0x0094:
                r10.m2376a(r2)     // Catch:{ all -> 0x00b2 }
                goto L_0x009a
            L_0x0098:
                r2.f2806d = r0     // Catch:{ all -> 0x00b2 }
            L_0x009a:
                monitor-exit(r3)     // Catch:{ all -> 0x00b2 }
                monitor-exit(r10)     // Catch:{ all -> 0x00b8 }
                boolean r0 = r2.isEnabled()     // Catch:{ all -> 0x00a7 }
                if (r0 == 0) goto L_0x0000
                r2.run()     // Catch:{ all -> 0x00a7 }
                goto L_0x0000
            L_0x00a7:
                r0 = move-exception
                monitor-enter(r10)
                r1 = 1
                r10.f2814a = r1     // Catch:{ all -> 0x00ae }
                monitor-exit(r10)     // Catch:{ all -> 0x00ae }
                goto L_0x00b1
            L_0x00ae:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00ae }
                throw r0
            L_0x00b1:
                throw r0
            L_0x00b2:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x00b2 }
                throw r0     // Catch:{ all -> 0x00b8 }
            L_0x00b5:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x00b5 }
                throw r0     // Catch:{ all -> 0x00b8 }
            L_0x00b8:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00b8 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.androlua.util.TimerX.TimerImpl.run():void");
        }
    }

    public TimerX() {
        this(false);
    }

    public TimerX(String str) {
        this(str, false);
    }

    public TimerX(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f2811b = new TimerImpl(str, z);
        this.f2812c = new FinalizerHelper(this.f2811b);
    }

    public TimerX(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("Timer-");
        sb.append(m2374a());
        this(sb.toString(), z);
    }

    /* renamed from: a */
    private static synchronized long m2374a() {
        long j;
        synchronized (TimerX.class) {
            j = f2810a;
            f2810a = j + 1;
        }
        return j;
    }

    /* renamed from: a */
    private void m2375a(TimerTaskX timerTaskX, long j, long j2, boolean z) {
        synchronized (this.f2811b) {
            if (this.f2811b.f2814a) {
                throw new IllegalStateException("Timer was canceled");
            }
            long currentTimeMillis = j + System.currentTimeMillis();
            if (currentTimeMillis < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Illegal delay to start the TimerTask: ");
                sb.append(currentTimeMillis);
                throw new IllegalArgumentException(sb.toString());
            }
            synchronized (timerTaskX.f2804b) {
                if (timerTaskX.mo2694a()) {
                    throw new IllegalStateException("TimerTask is scheduled already");
                } else if (timerTaskX.f2805c) {
                    throw new IllegalStateException("TimerTask is canceled");
                } else {
                    timerTaskX.f2806d = currentTimeMillis;
                    timerTaskX.f2807e = j2;
                    timerTaskX.f2808f = z;
                }
            }
            this.f2811b.m2376a(timerTaskX);
        }
    }

    public void cancel() {
        this.f2811b.cancel();
    }

    public int purge() {
        int purge;
        synchronized (this.f2811b) {
            purge = this.f2811b.purge();
        }
        return purge;
    }

    public void schedule(TimerTaskX timerTaskX, long j) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        m2375a(timerTaskX, j, -1, false);
    }

    public void schedule(TimerTaskX timerTaskX, long j, long j2) {
        if (j < 0 || j2 <= 0) {
            throw new IllegalArgumentException();
        }
        m2375a(timerTaskX, j, j2, false);
    }

    public void schedule(TimerTaskX timerTaskX, Date date) {
        if (date.getTime() < 0) {
            throw new IllegalArgumentException();
        }
        long time = date.getTime() - System.currentTimeMillis();
        m2375a(timerTaskX, time < 0 ? 0 : time, -1, false);
    }

    public void schedule(TimerTaskX timerTaskX, Date date, long j) {
        if (j <= 0 || date.getTime() < 0) {
            throw new IllegalArgumentException();
        }
        long time = date.getTime() - System.currentTimeMillis();
        m2375a(timerTaskX, time < 0 ? 0 : time, j, false);
    }

    public void scheduleAtFixedRate(TimerTaskX timerTaskX, long j, long j2) {
        if (j < 0 || j2 <= 0) {
            throw new IllegalArgumentException();
        }
        m2375a(timerTaskX, j, j2, true);
    }

    public void scheduleAtFixedRate(TimerTaskX timerTaskX, Date date, long j) {
        if (j <= 0 || date.getTime() < 0) {
            throw new IllegalArgumentException();
        }
        m2375a(timerTaskX, date.getTime() - System.currentTimeMillis(), j, true);
    }
}
