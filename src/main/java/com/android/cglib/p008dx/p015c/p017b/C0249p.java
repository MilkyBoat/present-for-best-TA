package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p015c.p019d.C0282b;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p015c.p019d.C0285e;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.c.b.p */
public final class C0249p {

    /* renamed from: a */
    private final int f1782a;

    /* renamed from: b */
    private final C0283c f1783b;

    /* renamed from: c */
    private final C0285e f1784c;

    /* renamed from: d */
    private final C0285e f1785d;

    /* renamed from: e */
    private final int f1786e;

    /* renamed from: f */
    private final boolean f1787f;

    /* renamed from: g */
    private final String f1788g;

    public C0249p(int i, C0283c cVar, C0285e eVar, int i2, String str) {
        this(i, cVar, eVar, C0282b.f2078a, i2, false, str);
    }

    public C0249p(int i, C0283c cVar, C0285e eVar, C0285e eVar2, int i2, boolean z, String str) {
        if (cVar == null) {
            throw new NullPointerException("result == null");
        } else if (eVar == null) {
            throw new NullPointerException("sources == null");
        } else if (eVar2 == null) {
            throw new NullPointerException("exceptions == null");
        } else if (i2 < 1 || i2 > 6) {
            throw new IllegalArgumentException("bogus branchingness");
        } else if (eVar2.mo1738a() == 0 || i2 == 6) {
            this.f1782a = i;
            this.f1783b = cVar;
            this.f1784c = eVar;
            this.f1785d = eVar2;
            this.f1786e = i2;
            this.f1787f = z;
            this.f1788g = str;
        } else {
            throw new IllegalArgumentException("exceptions / branchingness mismatch");
        }
    }

    public C0249p(int i, C0283c cVar, C0285e eVar, C0285e eVar2, String str) {
        this(i, cVar, eVar, eVar2, 6, false, str);
    }

    public C0249p(int i, C0283c cVar, C0285e eVar, String str) {
        this(i, cVar, eVar, C0282b.f2078a, 1, false, str);
    }

    public C0249p(int i, C0285e eVar, C0285e eVar2) {
        this(i, C0283c.f2123i, eVar, eVar2, 6, true, null);
    }

    /* renamed from: a */
    public int mo1628a() {
        return this.f1782a;
    }

    /* renamed from: b */
    public int mo1629b() {
        return this.f1786e;
    }

    /* renamed from: c */
    public boolean mo1630c() {
        return this.f1787f;
    }

    /* renamed from: d */
    public boolean mo1631d() {
        int i = this.f1782a;
        if (!(i == 14 || i == 16)) {
            switch (i) {
                case 20:
                case 21:
                case 22:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public String mo1632e() {
        return this.f1788g != null ? this.f1788g : toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0249p)) {
            return false;
        }
        C0249p pVar = (C0249p) obj;
        return this.f1782a == pVar.f1782a && this.f1786e == pVar.f1786e && this.f1783b == pVar.f1783b && this.f1784c.equals(pVar.f1784c) && this.f1785d.equals(pVar.f1785d);
    }

    /* renamed from: f */
    public final boolean mo1634f() {
        return this.f1785d.mo1738a() != 0;
    }

    public int hashCode() {
        return (((((((this.f1782a * 31) + this.f1786e) * 31) + this.f1783b.hashCode()) * 31) + this.f1784c.hashCode()) * 31) + this.f1785d.hashCode();
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer(40);
        stringBuffer.append("Rop{");
        stringBuffer.append(C0243l.m1721a(this.f1782a));
        if (this.f1783b != C0283c.f2123i) {
            stringBuffer.append(" ");
            stringBuffer.append(this.f1783b);
        } else {
            stringBuffer.append(" .");
        }
        stringBuffer.append(" <-");
        int a = this.f1784c.mo1738a();
        if (a == 0) {
            stringBuffer.append(" .");
        } else {
            for (int i = 0; i < a; i++) {
                stringBuffer.append(' ');
                stringBuffer.append(this.f1784c.mo1215a(i));
            }
        }
        if (this.f1787f) {
            stringBuffer.append(" call");
        }
        int a2 = this.f1785d.mo1738a();
        if (a2 != 0) {
            stringBuffer.append(" throws");
            for (int i2 = 0; i2 < a2; i2++) {
                stringBuffer.append(' ');
                if (this.f1785d.mo1215a(i2) == C0283c.f2132r) {
                    stringBuffer.append("<any>");
                } else {
                    stringBuffer.append(this.f1785d.mo1215a(i2));
                }
            }
        } else {
            switch (this.f1786e) {
                case 1:
                    str = " flows";
                    break;
                case 2:
                    str = " returns";
                    break;
                case 3:
                    str = " gotos";
                    break;
                case 4:
                    str = " ifs";
                    break;
                case 5:
                    str = " switches";
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append(" ");
                    sb.append(C0295i.m2050e(this.f1786e));
                    str = sb.toString();
                    break;
            }
            stringBuffer.append(str);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
