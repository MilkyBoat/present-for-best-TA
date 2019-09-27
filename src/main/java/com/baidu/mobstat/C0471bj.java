package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.bj */
class C0471bj extends C0472bk {

    /* renamed from: a */
    static C0471bj f3150a = new C0471bj();

    private C0471bj() {
    }

    /* renamed from: a */
    public static C0471bj m2935a() {
        return f3150a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo3271a(Context context) {
        return getInt(context, "sendLogtype", 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3272a(Context context, int i) {
        putInt(context, "sendLogtype", i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3273a(Context context, String str) {
        putString(context, "device_id_1", str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3274a(Context context, boolean z) {
        putBoolean(context, "onlywifi", z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo3275b(Context context) {
        return getInt(context, "timeinterval", 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3276b(Context context, int i) {
        putInt(context, "timeinterval", i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3277b(Context context, String str) {
        if (getString(context, "cuid", null) != null) {
            removeString(context, "cuid");
        }
        putString(context, "cuidsec_1", str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3278b(Context context, boolean z) {
        putBoolean(context, "setchannelwithcode", z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo3279c(Context context, String str) {
        putString(context, "setchannelwithcodevalue", str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo3280c(Context context, boolean z) {
        putBoolean(context, "mtjtv", z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo3281c(Context context) {
        return getBoolean(context, "onlywifi", false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo3282d(Context context) {
        return getString(context, "device_id_1", null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo3283d(Context context, String str) {
        putString(context, "mtjsdkmacss2_1", str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo3284d(Context context, boolean z) {
        putBoolean(context, "mtjsdkmactrick", z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo3285e(Context context) {
        return getString(context, "cuidsec_1", null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo3286e(Context context, String str) {
        putString(context, "mtjsdkmacsstv_1", str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public String mo3287f(Context context) {
        return getString(context, "setchannelwithcodevalue", null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo3288f(Context context, String str) {
        putString(context, "he.ext", str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public boolean mo3289g(Context context) {
        return getBoolean(context, "setchannelwithcode", false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo3290h(Context context) {
        return getString(context, "mtjsdkmacss2_1", null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public boolean mo3291i(Context context) {
        return getBoolean(context, "mtjtv", false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String mo3292j(Context context) {
        return getString(context, "mtjsdkmacsstv_1", null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String mo3293k(Context context) {
        return getString(context, "he.ext", null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public boolean mo3294l(Context context) {
        return getBoolean(context, "mtjsdkmactrick", true);
    }
}
