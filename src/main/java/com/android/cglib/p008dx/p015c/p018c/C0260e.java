package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p015c.p019d.C0283c;

/* renamed from: com.android.cglib.dx.c.c.e */
public final class C0260e extends C0269n {

    /* renamed from: a */
    public static final C0260e f2010a = new C0260e(false);

    /* renamed from: b */
    public static final C0260e f2011b = new C0260e(true);

    private C0260e(boolean z) {
        super(z ? 1 : 0);
    }

    /* renamed from: a */
    public static C0260e m1855a(boolean z) {
        return z ? f2011b : f2010a;
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return mo1664d_() ? "true" : "false";
    }

    /* renamed from: b */
    public C0283c mo1589b() {
        return C0283c.f2115a;
    }

    /* renamed from: d_ */
    public boolean mo1664d_() {
        return mo1675g() != 0;
    }

    /* renamed from: e */
    public String mo1649e() {
        return "boolean";
    }

    public String toString() {
        return mo1664d_() ? "boolean{true}" : "boolean{false}";
    }
}
