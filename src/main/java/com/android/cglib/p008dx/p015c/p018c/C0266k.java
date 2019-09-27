package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.c.c.k */
public final class C0266k extends C0269n {

    /* renamed from: a */
    public static final C0266k f2017a = m1878a(Float.floatToIntBits(0.0f));

    /* renamed from: b */
    public static final C0266k f2018b = m1878a(Float.floatToIntBits(1.0f));

    /* renamed from: c */
    public static final C0266k f2019c = m1878a(Float.floatToIntBits(2.0f));

    private C0266k(int i) {
        super(i);
    }

    /* renamed from: a */
    public static C0266k m1878a(int i) {
        return new C0266k(i);
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return Float.toString(Float.intBitsToFloat(mo1675g()));
    }

    /* renamed from: b */
    public C0283c mo1589b() {
        return C0283c.f2119e;
    }

    /* renamed from: e */
    public String mo1649e() {
        return "float";
    }

    public String toString() {
        int g = mo1675g();
        StringBuilder sb = new StringBuilder();
        sb.append("float{0x");
        sb.append(C0295i.m2044a(g));
        sb.append(" / ");
        sb.append(Float.intBitsToFloat(g));
        sb.append('}');
        return sb.toString();
    }
}
