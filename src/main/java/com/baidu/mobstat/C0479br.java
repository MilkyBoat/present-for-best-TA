package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.br */
class C0479br implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f3188a;

    /* renamed from: b */
    final /* synthetic */ Context f3189b;

    /* renamed from: c */
    final /* synthetic */ String f3190c;

    /* renamed from: d */
    final /* synthetic */ String f3191d;

    /* renamed from: e */
    final /* synthetic */ ExtraInfo f3192e;

    /* renamed from: f */
    final /* synthetic */ C0474bm f3193f;

    C0479br(C0474bm bmVar, long j, Context context, String str, String str2, ExtraInfo extraInfo) {
        this.f3193f = bmVar;
        this.f3188a = j;
        this.f3189b = context;
        this.f3190c = str;
        this.f3191d = str2;
        this.f3192e = extraInfo;
    }

    public void run() {
        C0483bv.m2981a().mo3321d();
        if (this.f3188a <= 0) {
            C0514cz.m3110a("EventStat: Wrong Case, Duration must be positive");
        } else {
            this.f3193f.mo3299a(this.f3189b, this.f3190c, this.f3191d, 1, System.currentTimeMillis(), this.f3188a, this.f3192e);
        }
    }
}
