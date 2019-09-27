package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p019d.C0282b;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p015c.p019d.C0285e;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.a.b.ar */
public final class C0148ar extends C0136ag {

    /* renamed from: a */
    private final C0285e f1283a;

    public C0148ar(C0285e eVar) {
        super(4, (eVar.mo1738a() * 2) + 4);
        this.f1283a = eVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo1337a(C0136ag agVar) {
        return C0282b.m1954a(this.f1283a, ((C0148ar) agVar).f1283a);
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_TYPE_LIST;
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        C0147aq j = lVar.mo1476j();
        int a = this.f1283a.mo1738a();
        for (int i = 0; i < a; i++) {
            j.mo1418a(this.f1283a.mo1215a(i));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        C0147aq j = lVar.mo1476j();
        int a = this.f1283a.mo1738a();
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1382g());
            sb.append(" type_list");
            aVar.mo1739a(0, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  size: ");
            sb2.append(C0295i.m2044a(a));
            aVar.mo1739a(4, sb2.toString());
            for (int i = 0; i < a; i++) {
                C0283c a2 = this.f1283a.mo1215a(i);
                int b = j.mo1421b(a2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("  ");
                sb3.append(C0295i.m2048c(b));
                sb3.append(" // ");
                sb3.append(a2.mo1218a_());
                aVar.mo1739a(2, sb3.toString());
            }
        }
        aVar.mo1755d(a);
        for (int i2 = 0; i2 < a; i2++) {
            aVar.mo1754c(j.mo1421b(this.f1283a.mo1215a(i2)));
        }
    }

    /* renamed from: b */
    public String mo1343b() {
        throw new RuntimeException("unsupported");
    }

    /* renamed from: c */
    public C0285e mo1423c() {
        return this.f1283a;
    }

    public int hashCode() {
        return C0282b.m1960b(this.f1283a);
    }
}
