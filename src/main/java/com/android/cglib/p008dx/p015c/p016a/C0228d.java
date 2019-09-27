package com.android.cglib.p008dx.p015c.p016a;

import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0277v;

/* renamed from: com.android.cglib.dx.c.a.d */
public final class C0228d implements Comparable<C0228d> {

    /* renamed from: a */
    private final C0277v f1736a;

    /* renamed from: b */
    private final C0255a f1737b;

    /* renamed from: a */
    public int compareTo(C0228d dVar) {
        int a = this.f1736a.compareTo(dVar.f1736a);
        return a != 0 ? a : this.f1737b.compareTo(dVar.f1737b);
    }

    /* renamed from: a */
    public C0277v mo1535a() {
        return this.f1736a;
    }

    /* renamed from: b */
    public C0255a mo1536b() {
        return this.f1737b;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C0228d)) {
            return false;
        }
        C0228d dVar = (C0228d) obj;
        if (this.f1736a.equals(dVar.f1736a) && this.f1737b.equals(dVar.f1737b)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (this.f1736a.hashCode() * 31) + this.f1737b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1736a.mo1218a_());
        sb.append(":");
        sb.append(this.f1737b);
        return sb.toString();
    }
}
