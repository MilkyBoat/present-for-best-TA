package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.c.c.q */
public final class C0272q extends C0270o {

    /* renamed from: a */
    public static final C0272q f2031a = m1905a(0);

    /* renamed from: b */
    public static final C0272q f2032b = m1905a(1);

    private C0272q(long j) {
        super(j);
    }

    /* renamed from: a */
    public static C0272q m1905a(long j) {
        return new C0272q(j);
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return Long.toString(mo1676h());
    }

    /* renamed from: b */
    public C0283c mo1589b() {
        return C0283c.f2121g;
    }

    /* renamed from: e */
    public String mo1649e() {
        return "long";
    }

    public String toString() {
        long h = mo1676h();
        StringBuilder sb = new StringBuilder();
        sb.append("long{0x");
        sb.append(C0295i.m2045a(h));
        sb.append(" / ");
        sb.append(h);
        sb.append('}');
        return sb.toString();
    }
}
