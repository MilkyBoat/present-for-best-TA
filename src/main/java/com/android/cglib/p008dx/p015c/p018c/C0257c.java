package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p020d.C0294h;

/* renamed from: com.android.cglib.dx.c.c.c */
public final class C0257c extends C0255a {

    /* renamed from: a */
    private final C0258a f2007a;

    /* renamed from: com.android.cglib.dx.c.c.c$a */
    public static final class C0258a extends C0294h implements Comparable<C0258a> {
        public C0258a(int i) {
            super(i);
        }

        /* renamed from: a */
        public int compareTo(C0258a aVar) {
            int a = mo1772a();
            int a2 = aVar.mo1772a();
            int i = a < a2 ? a : a2;
            for (int i2 = 0; i2 < i; i2++) {
                int a3 = ((C0255a) mo1776d(i2)).compareTo((C0255a) aVar.mo1776d(i2));
                if (a3 != 0) {
                    return a3;
                }
            }
            if (a < a2) {
                return -1;
            }
            return a > a2 ? 1 : 0;
        }

        /* renamed from: a */
        public C0255a mo1215a(int i) {
            return (C0255a) mo1776d(i);
        }

        /* renamed from: a */
        public void mo1659a(int i, C0255a aVar) {
            mo1774a(i, aVar);
        }
    }

    public C0257c(C0258a aVar) {
        if (aVar == null) {
            throw new NullPointerException("list == null");
        }
        aVar.mo1803i();
        this.f2007a = aVar;
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return this.f2007a.mo1775b("{", ", ", "}");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo1647b(C0255a aVar) {
        return this.f2007a.compareTo(((C0257c) aVar).f2007a);
    }

    /* renamed from: b */
    public C0258a mo1654b() {
        return this.f2007a;
    }

    /* renamed from: e */
    public String mo1649e() {
        return "array";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0257c)) {
            return false;
        }
        return this.f2007a.equals(((C0257c) obj).f2007a);
    }

    public int hashCode() {
        return this.f2007a.hashCode();
    }

    public String toString() {
        return this.f2007a.mo1773a("array{", ", ", "}");
    }
}
