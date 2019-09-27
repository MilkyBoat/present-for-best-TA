package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0265j;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import com.android.cglib.p008dx.p020d.C0304r;

/* renamed from: com.android.cglib.dx.a.b.q */
public final class C0170q implements C0304r, Comparable<C0170q> {

    /* renamed from: a */
    private final C0265j f1370a;

    /* renamed from: b */
    private C0152b f1371b;

    /* renamed from: a */
    public int compareTo(C0170q qVar) {
        return this.f1370a.compareTo(qVar.f1370a);
    }

    /* renamed from: a */
    public void mo1500a(C0165l lVar) {
        C0172s l = lVar.mo1478l();
        C0132af d = lVar.mo1470d();
        l.mo1506a(this.f1370a);
        this.f1371b = (C0152b) d.mo1369b(this.f1371b);
    }

    /* renamed from: a */
    public void mo1501a(C0165l lVar, C0286a aVar) {
        int b = lVar.mo1478l().mo1509b(this.f1370a);
        int e = this.f1371b.mo1379e();
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("    ");
            sb.append(this.f1370a.mo1218a_());
            aVar.mo1739a(0, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("      field_idx:       ");
            sb2.append(C0295i.m2044a(b));
            aVar.mo1739a(4, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("      annotations_off: ");
            sb3.append(C0295i.m2044a(e));
            aVar.mo1739a(4, sb3.toString());
        }
        aVar.mo1755d(b);
        aVar.mo1755d(e);
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1370a.mo1218a_());
        sb.append(": ");
        sb.append(this.f1371b);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0170q)) {
            return false;
        }
        return this.f1370a.equals(((C0170q) obj).f1370a);
    }

    public int hashCode() {
        return this.f1370a.hashCode();
    }
}
