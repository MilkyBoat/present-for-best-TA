package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p020d.C0294h;
import com.android.cglib.p008dx.p020d.C0295i;
import com.androlua.BuildConfig;

/* renamed from: com.android.cglib.dx.a.a.c */
public final class C0089c extends C0294h implements Comparable<C0089c> {

    /* renamed from: a */
    public static final C0089c f893a = new C0089c(0);

    /* renamed from: com.android.cglib.dx.a.a.c$a */
    public static class C0090a implements Comparable<C0090a> {

        /* renamed from: a */
        private final C0278w f894a;

        /* renamed from: b */
        private final int f895b;

        public C0090a(C0278w wVar, int i) {
            if (i < 0) {
                throw new IllegalArgumentException("handler < 0");
            } else if (wVar == null) {
                throw new NullPointerException("exceptionType == null");
            } else {
                this.f895b = i;
                this.f894a = wVar;
            }
        }

        /* renamed from: a */
        public int compareTo(C0090a aVar) {
            if (this.f895b < aVar.f895b) {
                return -1;
            }
            if (this.f895b > aVar.f895b) {
                return 1;
            }
            return this.f894a.compareTo(aVar.f894a);
        }

        /* renamed from: a */
        public C0278w mo1222a() {
            return this.f894a;
        }

        /* renamed from: b */
        public int mo1223b() {
            return this.f895b;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0090a) && compareTo((C0090a) obj) == 0;
        }

        public int hashCode() {
            return (this.f895b * 31) + this.f894a.hashCode();
        }
    }

    public C0089c(int i) {
        super(i);
    }

    /* renamed from: a */
    public int compareTo(C0089c cVar) {
        if (this == cVar) {
            return 0;
        }
        int a = mo1772a();
        int a2 = cVar.mo1772a();
        int min = Math.min(a, a2);
        for (int i = 0; i < min; i++) {
            int a3 = mo1215a(i).compareTo(cVar.mo1215a(i));
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
    public C0090a mo1215a(int i) {
        return (C0090a) mo1776d(i);
    }

    /* renamed from: a */
    public String mo1216a(String str, String str2) {
        StringBuilder sb = new StringBuilder(100);
        int a = mo1772a();
        sb.append(str);
        sb.append(str2);
        sb.append("catch ");
        int i = 0;
        while (i < a) {
            C0090a a2 = mo1215a(i);
            if (i != 0) {
                sb.append(",\n");
                sb.append(str);
                sb.append("  ");
            }
            sb.append((i != a + -1 || !mo1219b()) ? a2.mo1222a().mo1218a_() : "<any>");
            sb.append(" -> ");
            sb.append(C0295i.m2049d(a2.mo1223b()));
            i++;
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1217a(int i, C0278w wVar, int i2) {
        mo1774a(i, new C0090a(wVar, i2));
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return mo1216a(BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    /* renamed from: b */
    public boolean mo1219b() {
        int a = mo1772a();
        if (a == 0) {
            return false;
        }
        return mo1215a(a - 1).mo1222a().equals(C0278w.f2042a);
    }
}
