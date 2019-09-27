package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.c.c.u */
public final class C0276u extends C0269n {

    /* renamed from: a */
    public static final C0276u f2038a = m1920a(0);

    private C0276u(short s) {
        super(s);
    }

    /* renamed from: a */
    public static C0276u m1920a(short s) {
        return new C0276u(s);
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return Integer.toString(mo1675g());
    }

    /* renamed from: b */
    public C0283c mo1589b() {
        return C0283c.f2122h;
    }

    /* renamed from: e */
    public String mo1649e() {
        return "short";
    }

    public String toString() {
        int g = mo1675g();
        StringBuilder sb = new StringBuilder();
        sb.append("short{0x");
        sb.append(C0295i.m2048c(g));
        sb.append(" / ");
        sb.append(g);
        sb.append('}');
        return sb.toString();
    }
}
