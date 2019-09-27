package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.bz */
class C0487bz implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f3242a;

    /* renamed from: b */
    final /* synthetic */ C0486by f3243b;

    C0487bz(C0486by byVar, Context context) {
        this.f3243b = byVar;
        this.f3242a = context;
    }

    public void run() {
        if (this.f3243b.f3240f != null) {
            this.f3243b.f3240f.cancel();
            this.f3243b.f3240f = null;
        }
        this.f3243b.f3239e = SendStrategyEnum.values()[C0471bj.m2935a().mo3271a(this.f3242a)];
        this.f3243b.f3238d = C0471bj.m2935a().mo3275b(this.f3242a);
        this.f3243b.f3236b = C0471bj.m2935a().mo3281c(this.f3242a);
        if (this.f3243b.f3239e.equals(SendStrategyEnum.SET_TIME_INTERVAL) || this.f3243b.f3239e.equals(SendStrategyEnum.ONCE_A_DAY)) {
            this.f3243b.mo3328b(this.f3242a);
        }
        this.f3243b.f3241g.postDelayed(new C0489ca(this), (long) (this.f3243b.f3237c * 1000));
    }
}
