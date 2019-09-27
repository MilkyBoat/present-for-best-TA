package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.bo */
class C0476bo implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f3171a;

    /* renamed from: b */
    final /* synthetic */ String f3172b;

    /* renamed from: c */
    final /* synthetic */ String f3173c;

    /* renamed from: d */
    final /* synthetic */ int f3174d;

    /* renamed from: e */
    final /* synthetic */ long f3175e;

    /* renamed from: f */
    final /* synthetic */ ExtraInfo f3176f;

    /* renamed from: g */
    final /* synthetic */ C0474bm f3177g;

    C0476bo(C0474bm bmVar, Context context, String str, String str2, int i, long j, ExtraInfo extraInfo) {
        this.f3177g = bmVar;
        this.f3171a = context;
        this.f3172b = str;
        this.f3173c = str2;
        this.f3174d = i;
        this.f3175e = j;
        this.f3176f = extraInfo;
    }

    public void run() {
        C0483bv.m2981a().mo3321d();
        this.f3177g.mo3299a(this.f3171a, this.f3172b, this.f3173c, this.f3174d, this.f3175e, 0, this.f3176f);
    }
}
