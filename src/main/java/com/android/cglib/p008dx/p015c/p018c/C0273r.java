package com.android.cglib.p008dx.p015c.p018c;

/* renamed from: com.android.cglib.dx.c.c.r */
public abstract class C0273r extends C0279x {

    /* renamed from: a */
    private final C0278w f2033a;

    /* renamed from: b */
    private final C0275t f2034b;

    C0273r(C0278w wVar, C0275t tVar) {
        if (wVar == null) {
            throw new NullPointerException("definingClass == null");
        } else if (tVar == null) {
            throw new NullPointerException("nat == null");
        } else {
            this.f2033a = wVar;
            this.f2034b = tVar;
        }
    }

    /* renamed from: a_ */
    public final String mo1218a_() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2033a.mo1218a_());
        sb.append('.');
        sb.append(this.f2034b.mo1218a_());
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo1647b(C0255a aVar) {
        C0273r rVar = (C0273r) aVar;
        int a = this.f2033a.compareTo(rVar.f2033a);
        return a != 0 ? a : this.f2034b.mo1689b().compareTo(rVar.f2034b.mo1689b());
    }

    public final boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            if (getClass() != obj.getClass()) {
                return false;
            }
            C0273r rVar = (C0273r) obj;
            if (this.f2033a.equals(rVar.f2033a) && this.f2034b.equals(rVar.f2034b)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: g */
    public final C0278w mo1685g() {
        return this.f2033a;
    }

    /* renamed from: h */
    public final C0275t mo1686h() {
        return this.f2034b;
    }

    public final int hashCode() {
        return (this.f2033a.hashCode() * 31) ^ this.f2034b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo1649e());
        sb.append('{');
        sb.append(mo1218a_());
        sb.append('}');
        return sb.toString();
    }
}
