package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.n */
public class C0530n {
    /* renamed from: a */
    public static void m3208a(Context context) {
        C0529m.f3340a.mo3389a(context);
        C0460az.m2869a(context).mo3223a(C0537u.AP_LIST, System.currentTimeMillis());
    }

    /* renamed from: a */
    public static void m3209a(Context context, String str, String str2) {
        C0533q.f3346a.mo3392a(context, str, str2);
        C0460az.m2869a(context).mo3223a(C0537u.APP_CHANGE, System.currentTimeMillis());
    }

    /* renamed from: a */
    public static void m3210a(Context context, boolean z) {
        C0534r.f3347a.mo3393a(context, z);
        C0460az.m2869a(context).mo3223a(z ? C0537u.APP_SYS_LIST : C0537u.APP_USER_LIST, System.currentTimeMillis());
    }

    /* renamed from: b */
    public static void m3211b(Context context) {
        C0531o.f3341a.mo3390a(context);
        C0460az.m2869a(context).mo3223a(C0537u.APP_APK, System.currentTimeMillis());
    }

    /* renamed from: b */
    public static void m3212b(Context context, boolean z) {
        C0535s.f3348a.mo3394a(context, z);
        C0460az.m2869a(context).mo3223a(z ? C0537u.APP_TRACE_CURRENT : C0537u.APP_TRACE_HIS, System.currentTimeMillis());
    }
}
