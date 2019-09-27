package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0259d;
import com.android.cglib.p008dx.p015c.p018c.C0274s;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import com.android.cglib.p008dx.p020d.C0304r;

/* renamed from: com.android.cglib.dx.a.b.ah */
public final class C0137ah implements C0304r, Comparable<C0137ah> {

    /* renamed from: a */
    private final C0274s f1261a;

    /* renamed from: b */
    private final C0150at<C0153c> f1262b;

    /* renamed from: a */
    public int compareTo(C0137ah ahVar) {
        return this.f1261a.compareTo(ahVar.f1261a);
    }

    /* renamed from: a */
    public void mo1384a(C0165l lVar) {
        C0131ae m = lVar.mo1479m();
        C0132af d = lVar.mo1470d();
        m.mo1360a((C0259d) this.f1261a);
        d.mo1366a((C0136ag) this.f1262b);
    }

    /* renamed from: a */
    public void mo1385a(C0165l lVar, C0286a aVar) {
        int b = lVar.mo1479m().mo1364b(this.f1261a);
        int e = this.f1262b.mo1379e();
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("    ");
            sb.append(this.f1261a.mo1218a_());
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
        sb.append(this.f1261a.mo1218a_());
        sb.append(": ");
        boolean z = true;
        for (C0153c cVar : this.f1262b.mo1425c()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(cVar.mo1343b());
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0137ah)) {
            return false;
        }
        return this.f1261a.equals(((C0137ah) obj).f1261a);
    }

    public int hashCode() {
        return this.f1261a.hashCode();
    }
}
