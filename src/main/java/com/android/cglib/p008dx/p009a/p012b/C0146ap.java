package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.a.b.ap */
public final class C0146ap extends C0175v {
    public C0146ap(C0278w wVar) {
        super(wVar);
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_TYPE_ID_ITEM;
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        lVar.mo1473g().mo1413a(mo1510e().mo1707g());
    }

    /* renamed from: a */
    public void mo1347a(C0165l lVar, C0286a aVar) {
        C0277v g = mo1510e().mo1707g();
        int b = lVar.mo1473g().mo1415b(g);
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1514h());
            sb.append(' ');
            sb.append(g.mo1218a_());
            aVar.mo1739a(0, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  descriptor_idx: ");
            sb2.append(C0295i.m2044a(b));
            aVar.mo1739a(4, sb2.toString());
        }
        aVar.mo1755d(b);
    }

    /* renamed from: b_ */
    public int mo1349b_() {
        return 4;
    }
}
