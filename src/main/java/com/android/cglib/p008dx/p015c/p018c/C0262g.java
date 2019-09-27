package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.c.c.g */
public final class C0262g extends C0269n {

    /* renamed from: a */
    public static final C0262g f2013a = m1864a(0);

    private C0262g(char c) {
        super(c);
    }

    /* renamed from: a */
    public static C0262g m1864a(char c) {
        return new C0262g(c);
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return Integer.toString(mo1675g());
    }

    /* renamed from: b */
    public C0283c mo1589b() {
        return C0283c.f2117c;
    }

    /* renamed from: e */
    public String mo1649e() {
        return "char";
    }

    public String toString() {
        int g = mo1675g();
        StringBuilder sb = new StringBuilder();
        sb.append("char{0x");
        sb.append(C0295i.m2048c(g));
        sb.append(" / ");
        sb.append(g);
        sb.append('}');
        return sb.toString();
    }
}
