package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p020d.C0295i;
import com.android.cglib.p008dx.p020d.C0297k;
import com.android.cglib.p008dx.p020d.C0298l;

/* renamed from: com.android.cglib.dx.c.b.b */
public final class C0230b implements C0298l {

    /* renamed from: a */
    private final int f1738a;

    /* renamed from: b */
    private final C0238g f1739b;

    /* renamed from: c */
    private final C0297k f1740c;

    /* renamed from: d */
    private final int f1741d;

    public C0230b(int i, C0238g gVar, C0297k kVar, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("label < 0");
        }
        try {
            gVar.mo1803i();
            int a = gVar.mo1772a();
            if (a == 0) {
                throw new IllegalArgumentException("insns.size() == 0");
            }
            for (int i3 = a - 2; i3 >= 0; i3--) {
                if (gVar.mo1215a(i3).mo1563d().mo1629b() != 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("insns[");
                    sb.append(i3);
                    sb.append("] is a branch or can throw");
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            if (gVar.mo1215a(a - 1).mo1563d().mo1629b() == 1) {
                throw new IllegalArgumentException("insns does not end with a branch or throwing instruction");
            }
            try {
                kVar.mo1803i();
                if (i2 < -1) {
                    throw new IllegalArgumentException("primarySuccessor < -1");
                } else if (i2 < 0 || kVar.mo1793f(i2)) {
                    this.f1738a = i;
                    this.f1739b = gVar;
                    this.f1740c = kVar;
                    this.f1741d = i2;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("primarySuccessor ");
                    sb2.append(i2);
                    sb2.append(" not in successors ");
                    sb2.append(kVar);
                    throw new IllegalArgumentException(sb2.toString());
                }
            } catch (NullPointerException unused) {
                throw new NullPointerException("successors == null");
            }
        } catch (NullPointerException unused2) {
            throw new NullPointerException("insns == null");
        }
    }

    /* renamed from: a */
    public int mo1541a() {
        return this.f1738a;
    }

    /* renamed from: b */
    public C0238g mo1542b() {
        return this.f1739b;
    }

    /* renamed from: c */
    public C0297k mo1543c() {
        return this.f1740c;
    }

    /* renamed from: d */
    public int mo1544d() {
        return this.f1741d;
    }

    /* renamed from: e */
    public int mo1545e() {
        if (this.f1740c.mo1784a() != 2) {
            throw new UnsupportedOperationException("block doesn't have exactly two successors");
        }
        int a = this.f1740c.mo1785a(0);
        return a == this.f1741d ? this.f1740c.mo1785a(1) : a;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    /* renamed from: f */
    public C0235f mo1547f() {
        return this.f1739b.mo1574b();
    }

    /* renamed from: g */
    public boolean mo1548g() {
        return this.f1739b.mo1574b().mo1568h();
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append(C0295i.m2048c(this.f1738a));
        sb.append('}');
        return sb.toString();
    }
}
