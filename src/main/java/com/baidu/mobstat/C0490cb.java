package com.baidu.mobstat;

import android.content.Context;
import java.util.TimerTask;

/* renamed from: com.baidu.mobstat.cb */
class C0490cb extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Context f3245a;

    /* renamed from: b */
    final /* synthetic */ C0486by f3246b;

    C0490cb(C0486by byVar, Context context) {
        this.f3246b = byVar;
        this.f3245a = context;
    }

    public void run() {
        if (!DataCore.instance().isPartEmpty()) {
            this.f3246b.m3005c(this.f3245a);
        }
    }
}
