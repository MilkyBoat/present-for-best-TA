package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.androlua.BuildConfig;

/* renamed from: com.android.cglib.dx.c.b.h */
public class C0239h implements Comparable<C0239h> {

    /* renamed from: a */
    private final C0277v f1765a;

    /* renamed from: b */
    private final C0277v f1766b;

    /* renamed from: a */
    private static int m1708a(C0277v vVar, C0277v vVar2) {
        if (vVar == vVar2) {
            return 0;
        }
        if (vVar == null) {
            return -1;
        }
        if (vVar2 == null) {
            return 1;
        }
        return vVar.compareTo(vVar2);
    }

    /* renamed from: a */
    public int compareTo(C0239h hVar) {
        int a = m1708a(this.f1765a, hVar.f1765a);
        return a != 0 ? a : m1708a(this.f1766b, hVar.f1766b);
    }

    /* renamed from: a */
    public C0277v mo1576a() {
        return this.f1765a;
    }

    /* renamed from: b */
    public C0277v mo1577b() {
        return this.f1766b;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C0239h)) {
            return false;
        }
        if (compareTo((C0239h) obj) == 0) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f1765a == null ? 0 : this.f1765a.hashCode()) * 31;
        if (this.f1766b != null) {
            i = this.f1766b.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        if (this.f1765a != null && this.f1766b == null) {
            return this.f1765a.mo1698f();
        }
        if (this.f1765a == null && this.f1766b == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(this.f1765a == null ? BuildConfig.FLAVOR : this.f1765a.mo1698f());
        sb.append("|");
        sb.append(this.f1766b == null ? BuildConfig.FLAVOR : this.f1766b.mo1698f());
        return sb.toString();
    }
}
