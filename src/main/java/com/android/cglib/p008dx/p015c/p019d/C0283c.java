package com.android.cglib.p008dx.p015c.p019d;

import bsh.ParserConstants;
import java.util.HashMap;

/* renamed from: com.android.cglib.dx.c.d.c */
public final class C0283c implements C0284d, Comparable<C0283c> {

    /* renamed from: A */
    public static final C0283c f2104A = m1966a("Ljava/lang/Void;");

    /* renamed from: B */
    public static final C0283c f2105B = f2115a.mo1735l();

    /* renamed from: C */
    public static final C0283c f2106C = f2116b.mo1735l();

    /* renamed from: D */
    public static final C0283c f2107D = f2117c.mo1735l();

    /* renamed from: E */
    public static final C0283c f2108E = f2118d.mo1735l();

    /* renamed from: F */
    public static final C0283c f2109F = f2119e.mo1735l();

    /* renamed from: G */
    public static final C0283c f2110G = f2120f.mo1735l();

    /* renamed from: H */
    public static final C0283c f2111H = f2121g.mo1735l();

    /* renamed from: I */
    public static final C0283c f2112I = f2129o.mo1735l();

    /* renamed from: J */
    public static final C0283c f2113J = f2122h.mo1735l();

    /* renamed from: K */
    private static final HashMap<String, C0283c> f2114K = new HashMap<>(500);

    /* renamed from: a */
    public static final C0283c f2115a = new C0283c("Z", 1);

    /* renamed from: b */
    public static final C0283c f2116b = new C0283c("B", 2);

    /* renamed from: c */
    public static final C0283c f2117c = new C0283c("C", 3);

    /* renamed from: d */
    public static final C0283c f2118d = new C0283c("D", 4);

    /* renamed from: e */
    public static final C0283c f2119e = new C0283c("F", 5);

    /* renamed from: f */
    public static final C0283c f2120f = new C0283c("I", 6);

    /* renamed from: g */
    public static final C0283c f2121g = new C0283c("J", 7);

    /* renamed from: h */
    public static final C0283c f2122h = new C0283c("S", 8);

    /* renamed from: i */
    public static final C0283c f2123i = new C0283c("V", 0);

    /* renamed from: j */
    public static final C0283c f2124j = new C0283c("<null>", 9);

    /* renamed from: k */
    public static final C0283c f2125k = new C0283c("<addr>", 10);

    /* renamed from: l */
    public static final C0283c f2126l = m1966a("Ljava/lang/annotation/Annotation;");

    /* renamed from: m */
    public static final C0283c f2127m = m1966a("Ljava/lang/Class;");

    /* renamed from: n */
    public static final C0283c f2128n = m1966a("Ljava/lang/Cloneable;");

    /* renamed from: o */
    public static final C0283c f2129o = m1966a("Ljava/lang/Object;");

    /* renamed from: p */
    public static final C0283c f2130p = m1966a("Ljava/io/Serializable;");

    /* renamed from: q */
    public static final C0283c f2131q = m1966a("Ljava/lang/String;");

    /* renamed from: r */
    public static final C0283c f2132r = m1966a("Ljava/lang/Throwable;");

    /* renamed from: s */
    public static final C0283c f2133s = m1966a("Ljava/lang/Boolean;");

    /* renamed from: t */
    public static final C0283c f2134t = m1966a("Ljava/lang/Byte;");

    /* renamed from: u */
    public static final C0283c f2135u = m1966a("Ljava/lang/Character;");

    /* renamed from: v */
    public static final C0283c f2136v = m1966a("Ljava/lang/Double;");

    /* renamed from: w */
    public static final C0283c f2137w = m1966a("Ljava/lang/Float;");

    /* renamed from: x */
    public static final C0283c f2138x = m1966a("Ljava/lang/Integer;");

    /* renamed from: y */
    public static final C0283c f2139y = m1966a("Ljava/lang/Long;");

    /* renamed from: z */
    public static final C0283c f2140z = m1966a("Ljava/lang/Short;");

    /* renamed from: L */
    private final String f2141L;

    /* renamed from: M */
    private final int f2142M;

    /* renamed from: N */
    private final int f2143N;

    /* renamed from: O */
    private String f2144O;

    /* renamed from: P */
    private C0283c f2145P;

    /* renamed from: Q */
    private C0283c f2146Q;

    /* renamed from: R */
    private C0283c f2147R;

    static {
        m1967b(f2115a);
        m1967b(f2116b);
        m1967b(f2117c);
        m1967b(f2118d);
        m1967b(f2119e);
        m1967b(f2120f);
        m1967b(f2121g);
        m1967b(f2122h);
    }

    private C0283c(String str, int i) {
        this(str, i, -1);
    }

    private C0283c(String str, int i, int i2) {
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        } else if (i < 0 || i >= 11) {
            throw new IllegalArgumentException("bad basicType");
        } else if (i2 < -1) {
            throw new IllegalArgumentException("newAt < -1");
        } else {
            this.f2141L = str;
            this.f2142M = i;
            this.f2143N = i2;
            this.f2145P = null;
            this.f2146Q = null;
            this.f2147R = null;
        }
    }

    /* renamed from: a */
    public static C0283c m1966a(String str) {
        C0283c cVar;
        synchronized (f2114K) {
            cVar = (C0283c) f2114K.get(str);
        }
        if (cVar != null) {
            return cVar;
        }
        try {
            char charAt = str.charAt(0);
            if (charAt == '[') {
                return m1966a(str.substring(1)).mo1735l();
            }
            int length = str.length();
            if (charAt == 'L') {
                int i = length - 1;
                if (str.charAt(i) == ';') {
                    for (int i2 = 1; i2 < i; i2++) {
                        switch (str.charAt(i2)) {
                            case ParserConstants.NEW /*40*/:
                            case ParserConstants.NULL /*41*/:
                            case '.':
                            case ParserConstants.WHILE /*59*/:
                            case '[':
                                StringBuilder sb = new StringBuilder();
                                sb.append("bad descriptor: ");
                                sb.append(str);
                                throw new IllegalArgumentException(sb.toString());
                            case '/':
                                if (i2 != 1 && i2 != i && str.charAt(i2 - 1) != '/') {
                                    break;
                                } else {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("bad descriptor: ");
                                    sb2.append(str);
                                    throw new IllegalArgumentException(sb2.toString());
                                }
                                break;
                        }
                    }
                    return m1967b(new C0283c(str, 9));
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("bad descriptor: ");
            sb3.append(str);
            throw new IllegalArgumentException(sb3.toString());
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("descriptor is empty");
        } catch (NullPointerException unused2) {
            throw new NullPointerException("descriptor == null");
        }
    }

    /* renamed from: b */
    private static C0283c m1967b(C0283c cVar) {
        synchronized (f2114K) {
            String e = cVar.mo1726e();
            C0283c cVar2 = (C0283c) f2114K.get(e);
            if (cVar2 != null) {
                return cVar2;
            }
            f2114K.put(e, cVar);
            return cVar;
        }
    }

    /* renamed from: b */
    public static C0283c m1968b(String str) {
        try {
            return str.equals("V") ? f2123i : m1966a(str);
        } catch (NullPointerException unused) {
            throw new NullPointerException("descriptor == null");
        }
    }

    /* renamed from: a */
    public int compareTo(C0283c cVar) {
        return this.f2141L.compareTo(cVar.f2141L);
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        switch (this.f2142M) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "byte";
            case 3:
                return "char";
            case 4:
                return "double";
            case 5:
                return "float";
            case 6:
                return "int";
            case 7:
                return "long";
            case 8:
                return "short";
            case 9:
                if (!mo1734k()) {
                    return mo1728f().replace("/", ".");
                }
                StringBuilder sb = new StringBuilder();
                sb.append(mo1736m().mo1218a_());
                sb.append("[]");
                return sb.toString();
            default:
                return this.f2141L;
        }
    }

    /* renamed from: b */
    public C0283c mo1589b() {
        return this;
    }

    /* renamed from: c */
    public int mo1591c() {
        return this.f2142M;
    }

    /* renamed from: d */
    public int mo1595d() {
        int i = this.f2142M;
        if (!(i == 6 || i == 8)) {
            switch (i) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    return this.f2142M;
            }
        }
        return 6;
    }

    /* renamed from: e */
    public String mo1726e() {
        return this.f2141L;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0283c)) {
            return false;
        }
        return this.f2141L.equals(((C0283c) obj).f2141L);
    }

    /* renamed from: f */
    public String mo1728f() {
        if (this.f2144O == null) {
            if (!mo1733j()) {
                StringBuilder sb = new StringBuilder();
                sb.append("not an object type: ");
                sb.append(this.f2141L);
                throw new IllegalArgumentException(sb.toString());
            }
            this.f2144O = this.f2141L.charAt(0) == '[' ? this.f2141L : this.f2141L.substring(1, this.f2141L.length() - 1);
        }
        return this.f2144O;
    }

    /* renamed from: g */
    public int mo1729g() {
        int i = this.f2142M;
        return (i == 4 || i == 7) ? 2 : 1;
    }

    /* renamed from: h */
    public boolean mo1730h() {
        int i = this.f2142M;
        return i == 4 || i == 7;
    }

    public int hashCode() {
        return this.f2141L.hashCode();
    }

    /* renamed from: i */
    public boolean mo1732i() {
        int i = this.f2142M;
        if (!(i == 6 || i == 8)) {
            switch (i) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /* renamed from: j */
    public boolean mo1733j() {
        return this.f2142M == 9;
    }

    /* renamed from: k */
    public boolean mo1734k() {
        return this.f2141L.charAt(0) == '[';
    }

    /* renamed from: l */
    public C0283c mo1735l() {
        if (this.f2145P == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(this.f2141L);
            this.f2145P = m1967b(new C0283c(sb.toString(), 9));
        }
        return this.f2145P;
    }

    /* renamed from: m */
    public C0283c mo1736m() {
        if (this.f2146Q == null) {
            if (this.f2141L.charAt(0) != '[') {
                StringBuilder sb = new StringBuilder();
                sb.append("not an array type: ");
                sb.append(this.f2141L);
                throw new IllegalArgumentException(sb.toString());
            }
            this.f2146Q = m1966a(this.f2141L.substring(1));
        }
        return this.f2146Q;
    }

    public String toString() {
        return this.f2141L;
    }
}
