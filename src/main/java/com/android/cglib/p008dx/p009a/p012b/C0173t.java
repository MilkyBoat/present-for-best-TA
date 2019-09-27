package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.a.b.t */
public final class C0173t extends C0176w {
    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_HEADER_ITEM;
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
    }

    /* renamed from: a */
    public void mo1347a(C0165l lVar, C0286a aVar) {
        int g = lVar.mo1472f().mo1398g();
        C0140ak o = lVar.mo1481o();
        C0140ak p = lVar.mo1482p();
        int g2 = o.mo1398g();
        int g3 = (p.mo1398g() + p.mo1371c_()) - g2;
        String a = lVar.mo1463a().mo1335a();
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("magic: ");
            sb.append(new C0277v(a).mo1698f());
            aVar.mo1739a(8, sb.toString());
            aVar.mo1739a(4, "checksum");
            aVar.mo1739a(20, "signature");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("file_size:       ");
            sb2.append(C0295i.m2044a(lVar.mo1467b()));
            aVar.mo1739a(4, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("header_size:     ");
            sb3.append(C0295i.m2044a(112));
            aVar.mo1739a(4, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("endian_tag:      ");
            sb4.append(C0295i.m2044a(305419896));
            aVar.mo1739a(4, sb4.toString());
            aVar.mo1739a(4, "link_size:       0");
            aVar.mo1739a(4, "link_off:        0");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("map_off:         ");
            sb5.append(C0295i.m2044a(g));
            aVar.mo1739a(4, sb5.toString());
        }
        for (int i = 0; i < 8; i++) {
            aVar.mo1753b(a.charAt(i));
        }
        aVar.mo1761g(24);
        aVar.mo1755d(lVar.mo1467b());
        aVar.mo1755d(112);
        aVar.mo1755d(305419896);
        aVar.mo1761g(8);
        aVar.mo1755d(g);
        lVar.mo1473g().mo1416b(aVar);
        lVar.mo1476j().mo1422b(aVar);
        lVar.mo1477k().mo1391b(aVar);
        lVar.mo1478l().mo1508a(aVar);
        lVar.mo1479m().mo1363a(aVar);
        lVar.mo1474h().mo1452a(aVar);
        if (aVar.mo1741a()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("data_size:       ");
            sb6.append(C0295i.m2044a(g3));
            aVar.mo1739a(4, sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("data_off:        ");
            sb7.append(C0295i.m2044a(g2));
            aVar.mo1739a(4, sb7.toString());
        }
        aVar.mo1755d(g3);
        aVar.mo1755d(g2);
    }

    /* renamed from: b_ */
    public int mo1349b_() {
        return 112;
    }
}
