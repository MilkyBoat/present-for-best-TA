package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p015c.p019d.C0283c;

/* renamed from: com.android.cglib.dx.c.c.t */
public final class C0275t extends C0255a {

    /* renamed from: a */
    public static final C0275t f2035a = new C0275t(new C0277v("TYPE"), new C0277v("Ljava/lang/Class;"));

    /* renamed from: b */
    private final C0277v f2036b;

    /* renamed from: c */
    private final C0277v f2037c;

    public C0275t(C0277v vVar, C0277v vVar2) {
        if (vVar == null) {
            throw new NullPointerException("name == null");
        } else if (vVar2 == null) {
            throw new NullPointerException("descriptor == null");
        } else {
            this.f2036b = vVar;
            this.f2037c = vVar2;
        }
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2036b.mo1218a_());
        sb.append(':');
        sb.append(this.f2037c.mo1218a_());
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo1647b(C0255a aVar) {
        C0275t tVar = (C0275t) aVar;
        int a = this.f2036b.compareTo(tVar.f2036b);
        return a != 0 ? a : this.f2037c.compareTo(tVar.f2037c);
    }

    /* renamed from: b */
    public C0277v mo1689b() {
        return this.f2036b;
    }

    /* renamed from: c */
    public C0277v mo1690c() {
        return this.f2037c;
    }

    /* renamed from: d */
    public C0283c mo1691d() {
        return C0283c.m1966a(this.f2037c.mo1699g());
    }

    /* renamed from: e */
    public String mo1649e() {
        return "nat";
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C0275t)) {
            return false;
        }
        C0275t tVar = (C0275t) obj;
        if (this.f2036b.equals(tVar.f2036b) && this.f2037c.equals(tVar.f2037c)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (this.f2036b.hashCode() * 31) ^ this.f2037c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nat{");
        sb.append(mo1218a_());
        sb.append('}');
        return sb.toString();
    }
}
