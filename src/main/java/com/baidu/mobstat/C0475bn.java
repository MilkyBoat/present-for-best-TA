package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.bn */
class C0475bn implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f3161a;

    /* renamed from: b */
    final /* synthetic */ String f3162b;

    /* renamed from: c */
    final /* synthetic */ String f3163c;

    /* renamed from: d */
    final /* synthetic */ int f3164d;

    /* renamed from: e */
    final /* synthetic */ long f3165e;

    /* renamed from: f */
    final /* synthetic */ String f3166f;

    /* renamed from: g */
    final /* synthetic */ String f3167g;

    /* renamed from: h */
    final /* synthetic */ int f3168h;

    /* renamed from: i */
    final /* synthetic */ boolean f3169i;

    /* renamed from: j */
    final /* synthetic */ C0474bm f3170j;

    C0475bn(C0474bm bmVar, Context context, String str, String str2, int i, long j, String str3, String str4, int i2, boolean z) {
        this.f3170j = bmVar;
        this.f3161a = context;
        this.f3162b = str;
        this.f3163c = str2;
        this.f3164d = i;
        this.f3165e = j;
        this.f3166f = str3;
        this.f3167g = str4;
        this.f3168h = i2;
        this.f3169i = z;
    }

    public void run() {
        C0483bv.m2981a().mo3321d();
        this.f3170j.mo3300a(this.f3161a, this.f3162b, this.f3163c, this.f3164d, this.f3165e, 0, this.f3166f, this.f3167g, this.f3168h, this.f3169i);
    }
}
