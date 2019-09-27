package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p020d.C0294h;

/* renamed from: com.android.cglib.dx.a.a.d */
public final class C0091d extends C0294h implements Comparable<C0091d> {

    /* renamed from: a */
    public static final C0091d f896a = new C0091d(0);

    /* renamed from: com.android.cglib.dx.a.a.d$a */
    public static class C0092a implements Comparable<C0092a> {

        /* renamed from: a */
        private final int f897a;

        /* renamed from: b */
        private final int f898b;

        /* renamed from: c */
        private final C0089c f899c;

        public C0092a(int i, int i2, C0089c cVar) {
            if (i < 0) {
                throw new IllegalArgumentException("start < 0");
            } else if (i2 <= i) {
                throw new IllegalArgumentException("end <= start");
            } else if (cVar.mo1801g()) {
                throw new IllegalArgumentException("handlers.isMutable()");
            } else {
                this.f897a = i;
                this.f898b = i2;
                this.f899c = cVar;
            }
        }

        /* renamed from: a */
        public int mo1230a() {
            return this.f897a;
        }

        /* renamed from: a */
        public int compareTo(C0092a aVar) {
            if (this.f897a < aVar.f897a) {
                return -1;
            }
            if (this.f897a > aVar.f897a) {
                return 1;
            }
            if (this.f898b < aVar.f898b) {
                return -1;
            }
            if (this.f898b > aVar.f898b) {
                return 1;
            }
            return this.f899c.compareTo(aVar.f899c);
        }

        /* renamed from: b */
        public int mo1232b() {
            return this.f898b;
        }

        /* renamed from: c */
        public C0089c mo1233c() {
            return this.f899c;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0092a) && compareTo((C0092a) obj) == 0;
        }

        public int hashCode() {
            return (((this.f897a * 31) + this.f898b) * 31) + this.f899c.hashCode();
        }
    }

    public C0091d(int i) {
        super(i);
    }

    /* renamed from: a */
    public int compareTo(C0091d dVar) {
        if (this == dVar) {
            return 0;
        }
        int a = mo1772a();
        int a2 = dVar.mo1772a();
        int min = Math.min(a, a2);
        for (int i = 0; i < min; i++) {
            int a3 = mo1215a(i).compareTo(dVar.mo1215a(i));
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
    public C0092a mo1215a(int i) {
        return (C0092a) mo1776d(i);
    }

    /* renamed from: a */
    public void mo1228a(int i, C0092a aVar) {
        mo1774a(i, aVar);
    }
}
