package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.c.c.f */
public final class C0261f extends C0269n {

    /* renamed from: a */
    public static final C0261f f2012a = m1860a(0);

    private C0261f(byte b) {
        super(b);
    }

    /* renamed from: a */
    public static C0261f m1860a(byte b) {
        return new C0261f(b);
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return Integer.toString(mo1675g());
    }

    /* renamed from: b */
    public C0283c mo1589b() {
        return C0283c.f2116b;
    }

    /* renamed from: e */
    public String mo1649e() {
        return "byte";
    }

    public String toString() {
        int g = mo1675g();
        StringBuilder sb = new StringBuilder();
        sb.append("byte{0x");
        sb.append(C0295i.m2050e(g));
        sb.append(" / ");
        sb.append(g);
        sb.append('}');
        return sb.toString();
    }
}
