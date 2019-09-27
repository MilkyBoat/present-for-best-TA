package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* renamed from: com.baidu.mobstat.bv */
class C0483bv {

    /* renamed from: a */
    private static final C0483bv f3225a = new C0483bv();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f3226b;

    /* renamed from: c */
    private volatile boolean f3227c = false;

    /* renamed from: d */
    private volatile boolean f3228d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f3229e = false;

    /* renamed from: f */
    private HandlerThread f3230f;

    /* renamed from: g */
    private Handler f3231g;

    private C0483bv() {
    }

    /* renamed from: a */
    public static C0483bv m2981a() {
        return f3225a;
    }

    /* renamed from: c */
    private void m2983c(Context context) {
        if (context != null && !this.f3227c) {
            this.f3226b = context.getApplicationContext();
            m2984e();
            this.f3227c = true;
        }
    }

    /* renamed from: e */
    private synchronized void m2984e() {
        C0485bx bxVar = new C0485bx(this, null);
        bxVar.setPriority(10);
        bxVar.start();
    }

    /* renamed from: a */
    public void mo3316a(Context context) {
        try {
            m2981a().mo3318b(context.getApplicationContext());
        } catch (Throwable unused) {
        }
        m2983c(context.getApplicationContext());
    }

    /* renamed from: a */
    public void mo3317a(Context context, boolean z) {
        if (!this.f3228d) {
            PrefOperate.loadMetaDataConfig(context);
            DataCore.instance().loadStatData(context);
            DataCore.instance().loadLastSession(context);
            DataCore.instance().installHeader(context);
            if (z) {
                DataCore.instance().saveLogDataToSend(context);
            }
            this.f3228d = true;
        }
    }

    /* renamed from: b */
    public void mo3318b(Context context) {
        if (!this.f3229e && context != null) {
            if (this.f3230f == null || !this.f3230f.isAlive()) {
                this.f3230f = new HandlerThread("dataAnalyzeThread");
                this.f3230f.start();
                Looper looper = this.f3230f.getLooper();
                if (looper != null) {
                    this.f3231g = new Handler(looper);
                }
            }
            if (this.f3231g != null) {
                this.f3231g.postDelayed(new C0484bw(this, context), Config.BPLUS_DELAY_TIME);
                this.f3229e = true;
            }
        }
    }

    /* renamed from: b */
    public synchronized boolean mo3319b() {
        return this.f3227c;
    }

    /* renamed from: c */
    public synchronized boolean mo3320c() {
        return this.f3228d;
    }

    /* renamed from: d */
    public void mo3321d() {
        if (!this.f3228d) {
            synchronized (this) {
                while (!this.f3228d) {
                    try {
                        wait(50);
                    } catch (InterruptedException e) {
                        C0514cz.m3114b(e.getMessage());
                    }
                }
            }
        }
    }
}
