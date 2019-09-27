package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p015c.p019d.C0283c;
import java.util.HashMap;

/* renamed from: com.android.cglib.dx.c.c.w */
public final class C0278w extends C0279x {

    /* renamed from: a */
    public static final C0278w f2042a = m1935a(C0283c.f2129o);

    /* renamed from: b */
    public static final C0278w f2043b = m1935a(C0283c.f2133s);

    /* renamed from: c */
    public static final C0278w f2044c = m1935a(C0283c.f2134t);

    /* renamed from: d */
    public static final C0278w f2045d = m1935a(C0283c.f2135u);

    /* renamed from: e */
    public static final C0278w f2046e = m1935a(C0283c.f2136v);

    /* renamed from: f */
    public static final C0278w f2047f = m1935a(C0283c.f2137w);

    /* renamed from: g */
    public static final C0278w f2048g = m1935a(C0283c.f2139y);

    /* renamed from: h */
    public static final C0278w f2049h = m1935a(C0283c.f2138x);

    /* renamed from: i */
    public static final C0278w f2050i = m1935a(C0283c.f2140z);

    /* renamed from: j */
    public static final C0278w f2051j = m1935a(C0283c.f2104A);

    /* renamed from: k */
    public static final C0278w f2052k = m1935a(C0283c.f2105B);

    /* renamed from: l */
    public static final C0278w f2053l = m1935a(C0283c.f2106C);

    /* renamed from: m */
    public static final C0278w f2054m = m1935a(C0283c.f2107D);

    /* renamed from: n */
    public static final C0278w f2055n = m1935a(C0283c.f2108E);

    /* renamed from: o */
    public static final C0278w f2056o = m1935a(C0283c.f2109F);

    /* renamed from: p */
    public static final C0278w f2057p = m1935a(C0283c.f2111H);

    /* renamed from: q */
    public static final C0278w f2058q = m1935a(C0283c.f2110G);

    /* renamed from: r */
    public static final C0278w f2059r = m1935a(C0283c.f2113J);

    /* renamed from: s */
    private static final HashMap<C0283c, C0278w> f2060s = new HashMap<>(100);

    /* renamed from: t */
    private final C0283c f2061t;

    /* renamed from: u */
    private C0277v f2062u;

    public C0278w(C0283c cVar) {
        if (cVar == null) {
            throw new NullPointerException("type == null");
        } else if (cVar == C0283c.f2124j) {
            throw new UnsupportedOperationException("KNOWN_NULL is not representable");
        } else {
            this.f2061t = cVar;
            this.f2062u = null;
        }
    }

    /* renamed from: a */
    public static C0278w m1935a(C0283c cVar) {
        C0278w wVar;
        synchronized (f2060s) {
            wVar = (C0278w) f2060s.get(cVar);
            if (wVar == null) {
                wVar = new C0278w(cVar);
                f2060s.put(cVar, wVar);
            }
        }
        return wVar;
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return this.f2061t.mo1218a_();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo1647b(C0255a aVar) {
        return this.f2061t.mo1726e().compareTo(((C0278w) aVar).f2061t.mo1726e());
    }

    /* renamed from: b */
    public C0283c mo1589b() {
        return C0283c.f2127m;
    }

    /* renamed from: e */
    public String mo1649e() {
        return "type";
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C0278w)) {
            return false;
        }
        if (this.f2061t == ((C0278w) obj).f2061t) {
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    public C0283c mo1706f() {
        return this.f2061t;
    }

    /* renamed from: g */
    public C0277v mo1707g() {
        if (this.f2062u == null) {
            this.f2062u = new C0277v(this.f2061t.mo1726e());
        }
        return this.f2062u;
    }

    public int hashCode() {
        return this.f2061t.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("type{");
        sb.append(mo1218a_());
        sb.append('}');
        return sb.toString();
    }
}
