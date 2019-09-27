package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0259d;
import com.android.cglib.p008dx.p015c.p018c.C0274s;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import com.android.cglib.p008dx.p020d.C0304r;

/* renamed from: com.android.cglib.dx.a.b.ac */
public final class C0129ac implements C0304r, Comparable<C0129ac> {

    /* renamed from: a */
    private final C0274s f1244a;

    /* renamed from: b */
    private C0152b f1245b;

    /* renamed from: a */
    public int compareTo(C0129ac acVar) {
        return this.f1244a.compareTo(acVar.f1244a);
    }

    /* renamed from: a */
    public void mo1354a(C0165l lVar) {
        C0131ae m = lVar.mo1479m();
        C0132af d = lVar.mo1470d();
        m.mo1360a((C0259d) this.f1244a);
        this.f1245b = (C0152b) d.mo1369b(this.f1245b);
    }

    /* renamed from: a */
    public void mo1355a(C0165l lVar, C0286a aVar) {
        int b = lVar.mo1479m().mo1364b(this.f1244a);
        int e = this.f1245b.mo1379e();
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("    ");
            sb.append(this.f1244a.mo1218a_());
            aVar.mo1739a(0, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("      method_idx:      ");
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
        sb.append(this.f1244a.mo1218a_());
        sb.append(": ");
        sb.append(this.f1245b);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0129ac)) {
            return false;
        }
        return this.f1244a.equals(((C0129ac) obj).f1244a);
    }

    public int hashCode() {
        return this.f1244a.hashCode();
    }
}
