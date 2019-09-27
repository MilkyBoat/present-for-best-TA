package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.cj */
class C0498cj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f3282a;

    /* renamed from: b */
    final /* synthetic */ Context f3283b;

    /* renamed from: c */
    final /* synthetic */ C0496ch f3284c;

    C0498cj(C0496ch chVar, long j, Context context) {
        this.f3284c = chVar;
        this.f3282a = j;
        this.f3283b = context;
    }

    public void run() {
        this.f3284c.mo3366b(this.f3282a);
        if (C0483bv.m2981a().mo3320c()) {
            this.f3284c.m3044b(this.f3283b);
        }
    }
}
