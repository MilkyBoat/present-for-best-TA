package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p017b.C0229a;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0257c;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p015c.p019d.C0282b;
import com.android.cglib.p008dx.p015c.p019d.C0285e;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.a.b.g */
public final class C0157g extends C0176w {

    /* renamed from: a */
    private final C0278w f1308a;

    /* renamed from: b */
    private final int f1309b;

    /* renamed from: c */
    private final C0278w f1310c;

    /* renamed from: d */
    private C0148ar f1311d;

    /* renamed from: e */
    private final C0277v f1312e;

    /* renamed from: f */
    private final C0156f f1313f;

    /* renamed from: g */
    private C0166m f1314g;

    /* renamed from: h */
    private C0154d f1315h;

    public C0157g(C0278w wVar, int i, C0278w wVar2, C0285e eVar, C0277v vVar) {
        if (wVar == null) {
            throw new NullPointerException("thisClass == null");
        } else if (eVar == null) {
            throw new NullPointerException("interfaces == null");
        } else {
            this.f1308a = wVar;
            this.f1309b = i;
            this.f1310c = wVar2;
            this.f1311d = eVar.mo1738a() == 0 ? null : new C0148ar(eVar);
            this.f1312e = vVar;
            this.f1313f = new C0156f(wVar);
            this.f1314g = null;
            this.f1315h = new C0154d();
        }
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_CLASS_DEF_ITEM;
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        C0147aq j = lVar.mo1476j();
        C0132af n = lVar.mo1480n();
        C0132af d = lVar.mo1470d();
        C0132af e = lVar.mo1471e();
        C0145ao g = lVar.mo1473g();
        j.mo1417a(this.f1308a);
        if (!this.f1313f.mo1442c()) {
            lVar.mo1475i().mo1366a((C0136ag) this.f1313f);
            C0257c d2 = this.f1313f.mo1443d();
            if (d2 != null) {
                this.f1314g = (C0166m) n.mo1369b(new C0166m(d2));
            }
        }
        if (this.f1310c != null) {
            j.mo1417a(this.f1310c);
        }
        if (this.f1311d != null) {
            this.f1311d = (C0148ar) e.mo1369b(this.f1311d);
        }
        if (this.f1312e != null) {
            g.mo1413a(this.f1312e);
        }
        if (!this.f1315h.mo1431c()) {
            if (this.f1315h.mo1432d()) {
                this.f1315h = (C0154d) d.mo1369b(this.f1315h);
                return;
            }
            d.mo1366a((C0136ag) this.f1315h);
        }
    }

    /* renamed from: a */
    public void mo1347a(C0165l lVar, C0286a aVar) {
        boolean a = aVar.mo1741a();
        C0147aq j = lVar.mo1476j();
        int b = j.mo1420b(this.f1308a);
        int i = -1;
        int b2 = this.f1310c == null ? -1 : j.mo1420b(this.f1310c);
        int b3 = C0136ag.m1350b(this.f1311d);
        int e = this.f1315h.mo1431c() ? 0 : this.f1315h.mo1379e();
        if (this.f1312e != null) {
            i = lVar.mo1473g().mo1415b(this.f1312e);
        }
        int e2 = this.f1313f.mo1442c() ? 0 : this.f1313f.mo1379e();
        int b4 = C0136ag.m1350b(this.f1314g);
        if (a) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1514h());
            sb.append(' ');
            sb.append(this.f1308a.mo1218a_());
            aVar.mo1739a(0, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  class_idx:           ");
            sb2.append(C0295i.m2044a(b));
            aVar.mo1739a(4, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("  access_flags:        ");
            sb3.append(C0229a.m1658a(this.f1309b));
            aVar.mo1739a(4, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("  superclass_idx:      ");
            sb4.append(C0295i.m2044a(b2));
            sb4.append(" // ");
            sb4.append(this.f1310c == null ? "<none>" : this.f1310c.mo1218a_());
            aVar.mo1739a(4, sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("  interfaces_off:      ");
            sb5.append(C0295i.m2044a(b3));
            aVar.mo1739a(4, sb5.toString());
            if (b3 != 0) {
                C0285e c = this.f1311d.mo1423c();
                int a2 = c.mo1738a();
                for (int i2 = 0; i2 < a2; i2++) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("    ");
                    sb6.append(c.mo1215a(i2).mo1218a_());
                    aVar.mo1739a(0, sb6.toString());
                }
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append("  source_file_idx:     ");
            sb7.append(C0295i.m2044a(i));
            sb7.append(" // ");
            sb7.append(this.f1312e == null ? "<none>" : this.f1312e.mo1218a_());
            aVar.mo1739a(4, sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append("  annotations_off:     ");
            sb8.append(C0295i.m2044a(e));
            aVar.mo1739a(4, sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append("  class_data_off:      ");
            sb9.append(C0295i.m2044a(e2));
            aVar.mo1739a(4, sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append("  static_values_off:   ");
            sb10.append(C0295i.m2044a(b4));
            aVar.mo1739a(4, sb10.toString());
        }
        aVar.mo1755d(b);
        aVar.mo1755d(this.f1309b);
        aVar.mo1755d(b2);
        aVar.mo1755d(b3);
        aVar.mo1755d(i);
        aVar.mo1755d(e);
        aVar.mo1755d(e2);
        aVar.mo1755d(b4);
    }

    /* renamed from: a */
    public void mo1444a(C0167n nVar) {
        this.f1313f.mo1438a(nVar);
    }

    /* renamed from: a */
    public void mo1445a(C0167n nVar, C0255a aVar) {
        this.f1313f.mo1439a(nVar, aVar);
    }

    /* renamed from: a */
    public void mo1446a(C0169p pVar) {
        this.f1313f.mo1440a(pVar);
    }

    /* renamed from: b */
    public void mo1447b(C0169p pVar) {
        this.f1313f.mo1441b(pVar);
    }

    /* renamed from: b_ */
    public int mo1349b_() {
        return 32;
    }

    /* renamed from: c */
    public C0278w mo1448c() {
        return this.f1308a;
    }

    /* renamed from: d */
    public C0278w mo1449d() {
        return this.f1310c;
    }

    /* renamed from: e */
    public C0285e mo1450e() {
        return this.f1311d == null ? C0282b.f2078a : this.f1311d.mo1423c();
    }
}
