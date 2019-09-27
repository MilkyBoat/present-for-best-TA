package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p019d.C0281a;
import com.android.cglib.p008dx.p015c.p019d.C0282b;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.a.b.ai */
public final class C0138ai extends C0176w {

    /* renamed from: a */
    private final C0281a f1263a;

    /* renamed from: b */
    private final C0277v f1264b;

    /* renamed from: c */
    private C0148ar f1265c;

    public C0138ai(C0281a aVar) {
        if (aVar == null) {
            throw new NullPointerException("prototype == null");
        }
        this.f1263a = aVar;
        this.f1264b = m1368a(aVar);
        C0282b c = aVar.mo1714c();
        this.f1265c = c.mo1772a() == 0 ? null : new C0148ar(c);
    }

    /* renamed from: a */
    private static char m1367a(C0283c cVar) {
        char charAt = cVar.mo1726e().charAt(0);
        if (charAt == '[') {
            return 'L';
        }
        return charAt;
    }

    /* renamed from: a */
    private static C0277v m1368a(C0281a aVar) {
        C0282b c = aVar.mo1714c();
        int a = c.mo1772a();
        StringBuilder sb = new StringBuilder(a + 1);
        sb.append(m1367a(aVar.mo1713b()));
        for (int i = 0; i < a; i++) {
            sb.append(m1367a(c.mo1215a(i)));
        }
        return new C0277v(sb.toString());
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_PROTO_ID_ITEM;
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        C0145ao g = lVar.mo1473g();
        C0147aq j = lVar.mo1476j();
        C0132af e = lVar.mo1471e();
        j.mo1418a(this.f1263a.mo1713b());
        g.mo1413a(this.f1264b);
        if (this.f1265c != null) {
            this.f1265c = (C0148ar) e.mo1369b(this.f1265c);
        }
    }

    /* renamed from: a */
    public void mo1347a(C0165l lVar, C0286a aVar) {
        int b = lVar.mo1473g().mo1415b(this.f1264b);
        int b2 = lVar.mo1476j().mo1421b(this.f1263a.mo1713b());
        int b3 = C0136ag.m1350b(this.f1265c);
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1263a.mo1713b().mo1218a_());
            sb.append(" proto(");
            C0282b c = this.f1263a.mo1714c();
            int a = c.mo1772a();
            for (int i = 0; i < a; i++) {
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(c.mo1215a(i).mo1218a_());
            }
            sb.append(")");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mo1514h());
            sb2.append(' ');
            sb2.append(sb.toString());
            aVar.mo1739a(0, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("  shorty_idx:      ");
            sb3.append(C0295i.m2044a(b));
            sb3.append(" // ");
            sb3.append(this.f1264b.mo1698f());
            aVar.mo1739a(4, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("  return_type_idx: ");
            sb4.append(C0295i.m2044a(b2));
            sb4.append(" // ");
            sb4.append(this.f1263a.mo1713b().mo1218a_());
            aVar.mo1739a(4, sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("  parameters_off:  ");
            sb5.append(C0295i.m2044a(b3));
            aVar.mo1739a(4, sb5.toString());
        }
        aVar.mo1755d(b);
        aVar.mo1755d(b2);
        aVar.mo1755d(b3);
    }

    /* renamed from: b_ */
    public int mo1349b_() {
        return 12;
    }
}
