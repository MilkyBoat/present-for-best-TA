package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.c.b.s */
public final class C0252s {

    /* renamed from: a */
    public static final C0252s f2000a = new C0252s(null, -1, -1);

    /* renamed from: b */
    private final C0277v f2001b;

    /* renamed from: c */
    private final int f2002c;

    /* renamed from: d */
    private final int f2003d;

    public C0252s(C0277v vVar, int i, int i2) {
        if (i < -1) {
            throw new IllegalArgumentException("address < -1");
        } else if (i2 < -1) {
            throw new IllegalArgumentException("line < -1");
        } else {
            this.f2001b = vVar;
            this.f2002c = i;
            this.f2003d = i2;
        }
    }

    /* renamed from: a */
    public int mo1640a() {
        return this.f2003d;
    }

    /* renamed from: a */
    public boolean mo1641a(C0252s sVar) {
        return this.f2003d == sVar.f2003d;
    }

    /* renamed from: b */
    public boolean mo1642b(C0252s sVar) {
        return this.f2003d == sVar.f2003d && (this.f2001b == sVar.f2001b || (this.f2001b != null && this.f2001b.equals(sVar.f2001b)));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0252s)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C0252s sVar = (C0252s) obj;
        return this.f2002c == sVar.f2002c && mo1642b(sVar);
    }

    public int hashCode() {
        return this.f2001b.hashCode() + this.f2002c + this.f2003d;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        if (this.f2001b != null) {
            stringBuffer.append(this.f2001b.mo1218a_());
            stringBuffer.append(":");
        }
        if (this.f2003d >= 0) {
            stringBuffer.append(this.f2003d);
        }
        stringBuffer.append('@');
        stringBuffer.append(this.f2002c < 0 ? "????" : C0295i.m2048c(this.f2002c));
        return stringBuffer.toString();
    }
}
