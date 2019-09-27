package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.am */
class C0447am implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f3084a;

    /* renamed from: b */
    final /* synthetic */ Context f3085b;

    /* renamed from: c */
    final /* synthetic */ C0446al f3086c;

    C0447am(C0446al alVar, String str, Context context) {
        this.f3086c = alVar;
        this.f3084a = str;
        this.f3085b = context;
    }

    public void run() {
        try {
            this.f3086c.m2829a(this.f3084a);
            if (this.f3085b != null) {
                this.f3086c.m2826a(this.f3085b.getApplicationContext());
            }
        } catch (Throwable th) {
            C0465bd.m2913b(th);
        }
    }
}
