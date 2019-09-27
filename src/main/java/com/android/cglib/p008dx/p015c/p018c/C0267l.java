package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.c.c.l */
public final class C0267l extends C0269n {

    /* renamed from: a */
    public static final C0267l f2020a = m1882a(-1);

    /* renamed from: b */
    public static final C0267l f2021b = m1882a(0);

    /* renamed from: c */
    public static final C0267l f2022c = m1882a(1);

    /* renamed from: d */
    public static final C0267l f2023d = m1882a(2);

    /* renamed from: e */
    public static final C0267l f2024e = m1882a(3);

    /* renamed from: f */
    public static final C0267l f2025f = m1882a(4);

    /* renamed from: g */
    public static final C0267l f2026g = m1882a(5);

    /* renamed from: h */
    private static final C0267l[] f2027h = new C0267l[511];

    private C0267l(int i) {
        super(i);
    }

    /* renamed from: a */
    public static C0267l m1882a(int i) {
        int length = (Integer.MAX_VALUE & i) % f2027h.length;
        C0267l lVar = f2027h[length];
        if (lVar != null && lVar.mo1671e_() == i) {
            return lVar;
        }
        C0267l lVar2 = new C0267l(i);
        f2027h[length] = lVar2;
        return lVar2;
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return Integer.toString(mo1675g());
    }

    /* renamed from: b */
    public C0283c mo1589b() {
        return C0283c.f2120f;
    }

    /* renamed from: e */
    public String mo1649e() {
        return "int";
    }

    /* renamed from: e_ */
    public int mo1671e_() {
        return mo1675g();
    }

    public String toString() {
        int g = mo1675g();
        StringBuilder sb = new StringBuilder();
        sb.append("int{0x");
        sb.append(C0295i.m2044a(g));
        sb.append(" / ");
        sb.append(g);
        sb.append('}');
        return sb.toString();
    }
}
