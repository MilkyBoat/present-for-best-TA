package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.bt */
class C0481bt {

    /* renamed from: a */
    private static C0481bt f3197a = new C0481bt();

    /* renamed from: b */
    private boolean f3198b = false;

    private C0481bt() {
    }

    /* renamed from: a */
    public static C0481bt m2974a() {
        return f3197a;
    }

    /* renamed from: a */
    public void mo3311a(Context context, boolean z) {
        C0514cz.m3110a("openExceptonAnalysis");
        if (!this.f3198b) {
            this.f3198b = true;
            C0473bl.m2962a().mo3296a(context);
            if (!z) {
                NativeCrashHandler.init(context);
            }
        }
    }
}
