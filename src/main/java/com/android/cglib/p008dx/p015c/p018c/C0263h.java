package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.c.c.h */
public final class C0263h extends C0270o {

    /* renamed from: a */
    public static final C0263h f2014a = new C0263h(Double.doubleToLongBits(0.0d));

    /* renamed from: b */
    public static final C0263h f2015b = new C0263h(Double.doubleToLongBits(1.0d));

    private C0263h(long j) {
        super(j);
    }

    /* renamed from: a */
    public static C0263h m1868a(long j) {
        return new C0263h(j);
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return Double.toString(Double.longBitsToDouble(mo1676h()));
    }

    /* renamed from: b */
    public C0283c mo1589b() {
        return C0283c.f2118d;
    }

    /* renamed from: e */
    public String mo1649e() {
        return "double";
    }

    public String toString() {
        long h = mo1676h();
        StringBuilder sb = new StringBuilder();
        sb.append("double{0x");
        sb.append(C0295i.m2045a(h));
        sb.append(" / ");
        sb.append(Double.longBitsToDouble(h));
        sb.append('}');
        return sb.toString();
    }
}
