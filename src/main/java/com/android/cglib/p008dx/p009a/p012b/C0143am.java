package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0288c;
import com.android.cglib.p008dx.p020d.C0295i;
import com.android.cglib.p008dx.p020d.C0300n;

/* renamed from: com.android.cglib.dx.a.b.am */
public final class C0143am extends C0136ag {

    /* renamed from: a */
    private final C0277v f1278a;

    public C0143am(C0277v vVar) {
        super(1, m1401a(vVar));
        this.f1278a = vVar;
    }

    /* renamed from: a */
    private static int m1401a(C0277v vVar) {
        return C0300n.m2071a(vVar.mo1703j()) + vVar.mo1702i() + 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo1337a(C0136ag agVar) {
        return this.f1278a.compareTo(((C0143am) agVar).f1278a);
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_STRING_DATA_ITEM;
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
    }

    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        C0288c h = this.f1278a.mo1700h();
        int j = this.f1278a.mo1703j();
        if (aVar.mo1741a()) {
            int a = C0300n.m2071a(j);
            StringBuilder sb = new StringBuilder();
            sb.append("utf16_size: ");
            sb.append(C0295i.m2044a(j));
            aVar.mo1739a(a, sb.toString());
            aVar.mo1739a(h.mo1745a() + 1, this.f1278a.mo1698f());
        }
        aVar.mo1756e(j);
        aVar.mo1749a(h);
        aVar.mo1753b(0);
    }

    /* renamed from: b */
    public String mo1343b() {
        return this.f1278a.mo1698f();
    }
}
