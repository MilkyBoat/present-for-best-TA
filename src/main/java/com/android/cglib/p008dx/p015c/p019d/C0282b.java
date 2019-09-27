package com.android.cglib.p008dx.p015c.p019d;

import com.android.cglib.p008dx.p020d.C0294h;

/* renamed from: com.android.cglib.dx.c.d.b */
public final class C0282b extends C0294h implements C0285e {

    /* renamed from: A */
    public static final C0282b f2068A = m1956a(C0283c.f2113J, C0283c.f2120f);

    /* renamed from: B */
    public static final C0282b f2069B = m1957a(C0283c.f2120f, C0283c.f2110G, C0283c.f2120f);

    /* renamed from: C */
    public static final C0282b f2070C = m1957a(C0283c.f2121g, C0283c.f2111H, C0283c.f2120f);

    /* renamed from: D */
    public static final C0282b f2071D = m1957a(C0283c.f2119e, C0283c.f2109F, C0283c.f2120f);

    /* renamed from: E */
    public static final C0282b f2072E = m1957a(C0283c.f2118d, C0283c.f2108E, C0283c.f2120f);

    /* renamed from: F */
    public static final C0282b f2073F = m1957a(C0283c.f2129o, C0283c.f2112I, C0283c.f2120f);

    /* renamed from: G */
    public static final C0282b f2074G = m1957a(C0283c.f2120f, C0283c.f2105B, C0283c.f2120f);

    /* renamed from: H */
    public static final C0282b f2075H = m1957a(C0283c.f2120f, C0283c.f2106C, C0283c.f2120f);

    /* renamed from: I */
    public static final C0282b f2076I = m1957a(C0283c.f2120f, C0283c.f2107D, C0283c.f2120f);

    /* renamed from: J */
    public static final C0282b f2077J = m1957a(C0283c.f2120f, C0283c.f2113J, C0283c.f2120f);

    /* renamed from: a */
    public static final C0282b f2078a = new C0282b(0);

    /* renamed from: b */
    public static final C0282b f2079b = m1955a(C0283c.f2120f);

    /* renamed from: c */
    public static final C0282b f2080c = m1955a(C0283c.f2121g);

    /* renamed from: d */
    public static final C0282b f2081d = m1955a(C0283c.f2119e);

    /* renamed from: e */
    public static final C0282b f2082e = m1955a(C0283c.f2118d);

    /* renamed from: f */
    public static final C0282b f2083f = m1955a(C0283c.f2129o);

    /* renamed from: g */
    public static final C0282b f2084g = m1955a(C0283c.f2125k);

    /* renamed from: h */
    public static final C0282b f2085h = m1955a(C0283c.f2132r);

    /* renamed from: i */
    public static final C0282b f2086i = m1956a(C0283c.f2120f, C0283c.f2120f);

    /* renamed from: j */
    public static final C0282b f2087j = m1956a(C0283c.f2121g, C0283c.f2121g);

    /* renamed from: k */
    public static final C0282b f2088k = m1956a(C0283c.f2119e, C0283c.f2119e);

    /* renamed from: l */
    public static final C0282b f2089l = m1956a(C0283c.f2118d, C0283c.f2118d);

    /* renamed from: m */
    public static final C0282b f2090m = m1956a(C0283c.f2129o, C0283c.f2129o);

    /* renamed from: n */
    public static final C0282b f2091n = m1956a(C0283c.f2120f, C0283c.f2129o);

    /* renamed from: o */
    public static final C0282b f2092o = m1956a(C0283c.f2121g, C0283c.f2129o);

    /* renamed from: p */
    public static final C0282b f2093p = m1956a(C0283c.f2119e, C0283c.f2129o);

    /* renamed from: q */
    public static final C0282b f2094q = m1956a(C0283c.f2118d, C0283c.f2129o);

    /* renamed from: r */
    public static final C0282b f2095r = m1956a(C0283c.f2121g, C0283c.f2120f);

    /* renamed from: s */
    public static final C0282b f2096s = m1956a(C0283c.f2110G, C0283c.f2120f);

    /* renamed from: t */
    public static final C0282b f2097t = m1956a(C0283c.f2111H, C0283c.f2120f);

    /* renamed from: u */
    public static final C0282b f2098u = m1956a(C0283c.f2109F, C0283c.f2120f);

    /* renamed from: v */
    public static final C0282b f2099v = m1956a(C0283c.f2108E, C0283c.f2120f);

    /* renamed from: w */
    public static final C0282b f2100w = m1956a(C0283c.f2112I, C0283c.f2120f);

    /* renamed from: x */
    public static final C0282b f2101x = m1956a(C0283c.f2105B, C0283c.f2120f);

    /* renamed from: y */
    public static final C0282b f2102y = m1956a(C0283c.f2106C, C0283c.f2120f);

    /* renamed from: z */
    public static final C0282b f2103z = m1956a(C0283c.f2107D, C0283c.f2120f);

    public C0282b(int i) {
        super(i);
    }

    /* renamed from: a */
    public static int m1954a(C0285e eVar, C0285e eVar2) {
        int a = eVar.mo1738a();
        int a2 = eVar2.mo1738a();
        int min = Math.min(a, a2);
        for (int i = 0; i < min; i++) {
            int a3 = eVar.mo1215a(i).compareTo(eVar2.mo1215a(i));
            if (a3 != 0) {
                return a3;
            }
        }
        if (a == a2) {
            return 0;
        }
        return a < a2 ? -1 : 1;
    }

    /* renamed from: a */
    public static C0282b m1955a(C0283c cVar) {
        C0282b bVar = new C0282b(1);
        bVar.mo1720a(0, cVar);
        return bVar;
    }

    /* renamed from: a */
    public static C0282b m1956a(C0283c cVar, C0283c cVar2) {
        C0282b bVar = new C0282b(2);
        bVar.mo1720a(0, cVar);
        bVar.mo1720a(1, cVar2);
        return bVar;
    }

    /* renamed from: a */
    public static C0282b m1957a(C0283c cVar, C0283c cVar2, C0283c cVar3) {
        C0282b bVar = new C0282b(3);
        bVar.mo1720a(0, cVar);
        bVar.mo1720a(1, cVar2);
        bVar.mo1720a(2, cVar3);
        return bVar;
    }

    /* renamed from: a */
    public static C0282b m1958a(C0283c cVar, C0283c cVar2, C0283c cVar3, C0283c cVar4) {
        C0282b bVar = new C0282b(4);
        bVar.mo1720a(0, cVar);
        bVar.mo1720a(1, cVar2);
        bVar.mo1720a(2, cVar3);
        bVar.mo1720a(3, cVar4);
        return bVar;
    }

    /* renamed from: a */
    public static String m1959a(C0285e eVar) {
        int a = eVar.mo1738a();
        if (a == 0) {
            return "<empty>";
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        for (int i = 0; i < a; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(eVar.mo1215a(i).mo1218a_());
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static int m1960b(C0285e eVar) {
        int i = 0;
        for (int i2 = 0; i2 < eVar.mo1738a(); i2++) {
            i = (i * 31) + eVar.mo1215a(i2).hashCode();
        }
        return i;
    }

    /* renamed from: a */
    public C0283c mo1215a(int i) {
        return mo1723b(i);
    }

    /* renamed from: a */
    public void mo1720a(int i, C0283c cVar) {
        mo1774a(i, cVar);
    }

    /* renamed from: b */
    public int mo1721b() {
        int i = 0;
        for (int i2 = 0; i2 < mo1772a(); i2++) {
            i += mo1723b(i2).mo1729g();
        }
        return i;
    }

    /* renamed from: b */
    public C0282b mo1722b(C0283c cVar) {
        int a = mo1772a();
        C0282b bVar = new C0282b(a + 1);
        int i = 0;
        bVar.mo1774a(0, cVar);
        while (i < a) {
            int i2 = i + 1;
            bVar.mo1774a(i2, mo1777e(i));
            i = i2;
        }
        return bVar;
    }

    /* renamed from: b */
    public C0283c mo1723b(int i) {
        return (C0283c) mo1776d(i);
    }
}
