package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0273r;
import com.android.cglib.p008dx.p015c.p018c.C0275t;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.a.b.aa */
public abstract class C0127aa extends C0175v {

    /* renamed from: a */
    private final C0273r f1243a;

    public C0127aa(C0273r rVar) {
        super(rVar.mo1685g());
        this.f1243a = rVar;
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        super.mo1340a(lVar);
        lVar.mo1473g().mo1413a(mo1351j().mo1686h().mo1689b());
    }

    /* renamed from: a */
    public final void mo1347a(C0165l lVar, C0286a aVar) {
        C0147aq j = lVar.mo1476j();
        C0145ao g = lVar.mo1473g();
        C0275t h = this.f1243a.mo1686h();
        int b = j.mo1420b(mo1510e());
        int b2 = g.mo1415b(h.mo1689b());
        int b3 = mo1348b(lVar);
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1514h());
            sb.append(' ');
            sb.append(this.f1243a.mo1218a_());
            aVar.mo1739a(0, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  class_idx: ");
            sb2.append(C0295i.m2048c(b));
            aVar.mo1739a(2, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(mo1350d());
            sb3.append(':');
            aVar.mo1739a(2, String.format("  %-10s %s", new Object[]{sb3.toString(), C0295i.m2048c(b3)}));
            StringBuilder sb4 = new StringBuilder();
            sb4.append("  name_idx:  ");
            sb4.append(C0295i.m2044a(b2));
            aVar.mo1739a(4, sb4.toString());
        }
        aVar.mo1754c(b);
        aVar.mo1754c(b3);
        aVar.mo1755d(b2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo1348b(C0165l lVar);

    /* renamed from: b_ */
    public int mo1349b_() {
        return 8;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract String mo1350d();

    /* renamed from: j */
    public final C0273r mo1351j() {
        return this.f1243a;
    }
}
