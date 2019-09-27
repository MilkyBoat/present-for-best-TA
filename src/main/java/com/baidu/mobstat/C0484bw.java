package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.bw */
class C0484bw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f3232a;

    /* renamed from: b */
    final /* synthetic */ C0483bv f3233b;

    C0484bw(C0483bv bvVar, Context context) {
        this.f3233b = bvVar;
        this.f3232a = context;
    }

    public void run() {
        try {
            if (!C0449ao.m2835b(this.f3232a)) {
                C0449ao.m2834a(2).mo3212a(this.f3232a);
            }
        } catch (Throwable unused) {
        }
        this.f3233b.f3229e = false;
    }
}
