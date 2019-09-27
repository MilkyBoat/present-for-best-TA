package com.android.cglib.p008dx.p015c.p019d;

import java.util.HashMap;

/* renamed from: com.android.cglib.dx.c.d.a */
public final class C0281a implements Comparable<C0281a> {

    /* renamed from: a */
    private static final HashMap<String, C0281a> f2063a = new HashMap<>(500);

    /* renamed from: b */
    private final String f2064b;

    /* renamed from: c */
    private final C0283c f2065c;

    /* renamed from: d */
    private final C0282b f2066d;

    /* renamed from: e */
    private C0282b f2067e;

    private C0281a(String str, C0283c cVar, C0282b bVar) {
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        } else if (cVar == null) {
            throw new NullPointerException("returnType == null");
        } else if (bVar == null) {
            throw new NullPointerException("parameterTypes == null");
        } else {
            this.f2064b = str;
            this.f2065c = cVar;
            this.f2066d = bVar;
            this.f2067e = null;
        }
    }

    /* renamed from: a */
    public static C0281a m1945a(String str) {
        C0281a aVar;
        int i;
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        }
        synchronized (f2063a) {
            aVar = (C0281a) f2063a.get(str);
        }
        if (aVar != null) {
            return aVar;
        }
        C0283c[] b = m1947b(str);
        int i2 = 1;
        int i3 = 0;
        while (true) {
            char charAt = str.charAt(i2);
            if (charAt == ')') {
                C0283c b2 = C0283c.m1968b(str.substring(i2 + 1));
                C0282b bVar = new C0282b(i3);
                for (int i4 = 0; i4 < i3; i4++) {
                    bVar.mo1720a(i4, b[i4]);
                }
                return m1946b(new C0281a(str, b2, bVar));
            }
            int i5 = i2;
            while (charAt == '[') {
                i5++;
                charAt = str.charAt(i5);
            }
            if (charAt == 'L') {
                int indexOf = str.indexOf(59, i5);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("bad descriptor");
                }
                i = indexOf + 1;
            } else {
                i = i5 + 1;
            }
            b[i3] = C0283c.m1966a(str.substring(i2, i));
            i3++;
            i2 = i;
        }
    }

    /* renamed from: b */
    private static C0281a m1946b(C0281a aVar) {
        synchronized (f2063a) {
            String a = aVar.mo1712a();
            C0281a aVar2 = (C0281a) f2063a.get(a);
            if (aVar2 != null) {
                return aVar2;
            }
            f2063a.put(a, aVar);
            return aVar;
        }
    }

    /* renamed from: b */
    private static C0283c[] m1947b(String str) {
        int length = str.length();
        int i = 0;
        if (str.charAt(0) != '(') {
            throw new IllegalArgumentException("bad descriptor");
        }
        int i2 = 1;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = str.charAt(i2);
            if (charAt == ')') {
                i = i2;
                break;
            }
            if (charAt >= 'A' && charAt <= 'Z') {
                i3++;
            }
            i2++;
        }
        if (i == 0 || i == length - 1) {
            throw new IllegalArgumentException("bad descriptor");
        } else if (str.indexOf(41, i + 1) == -1) {
            return new C0283c[i3];
        } else {
            throw new IllegalArgumentException("bad descriptor");
        }
    }

    /* renamed from: a */
    public int compareTo(C0281a aVar) {
        if (this == aVar) {
            return 0;
        }
        int a = this.f2065c.compareTo(aVar.f2065c);
        if (a != 0) {
            return a;
        }
        int a2 = this.f2066d.mo1772a();
        int a3 = aVar.f2066d.mo1772a();
        int min = Math.min(a2, a3);
        for (int i = 0; i < min; i++) {
            int a4 = this.f2066d.mo1723b(i).compareTo(aVar.f2066d.mo1723b(i));
            if (a4 != 0) {
                return a4;
            }
        }
        if (a2 < a3) {
            return -1;
        }
        return a2 > a3 ? 1 : 0;
    }

    /* renamed from: a */
    public C0281a mo1711a(C0283c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(cVar.mo1726e());
        sb.append(this.f2064b.substring(1));
        String sb2 = sb.toString();
        C0282b b = this.f2066d.mo1722b(cVar);
        b.mo1799e();
        return m1946b(new C0281a(sb2, this.f2065c, b));
    }

    /* renamed from: a */
    public String mo1712a() {
        return this.f2064b;
    }

    /* renamed from: b */
    public C0283c mo1713b() {
        return this.f2065c;
    }

    /* renamed from: c */
    public C0282b mo1714c() {
        return this.f2066d;
    }

    /* renamed from: d */
    public C0282b mo1716d() {
        if (this.f2067e == null) {
            int a = this.f2066d.mo1772a();
            C0282b bVar = new C0282b(a);
            boolean z = false;
            for (int i = 0; i < a; i++) {
                C0283c b = this.f2066d.mo1723b(i);
                if (b.mo1732i()) {
                    b = C0283c.f2120f;
                    z = true;
                }
                bVar.mo1720a(i, b);
            }
            if (!z) {
                bVar = this.f2066d;
            }
            this.f2067e = bVar;
        }
        return this.f2067e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0281a)) {
            return false;
        }
        return this.f2064b.equals(((C0281a) obj).f2064b);
    }

    public int hashCode() {
        return this.f2064b.hashCode();
    }

    public String toString() {
        return this.f2064b;
    }
}
