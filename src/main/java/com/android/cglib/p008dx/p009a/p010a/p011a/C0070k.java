package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0094f;
import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0271p;
import com.android.cglib.p008dx.p020d.C0286a;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.a.k */
public final class C0070k extends C0103n {

    /* renamed from: b */
    public static final C0103n f877b = new C0070k();

    private C0070k() {
    }

    /* renamed from: a */
    public int mo1200a() {
        return 2;
    }

    /* renamed from: a */
    public String mo1201a(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        C0271p pVar = (C0271p) ((C0094f) hVar).mo1241b();
        StringBuilder sb = new StringBuilder();
        sb.append(i.mo1614b(0).mo1604k());
        sb.append(", ");
        sb.append(i.mo1614b(1).mo1604k());
        sb.append(", ");
        sb.append(m1151a(pVar));
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        C0247n i = hVar.mo1266i();
        m1161a(aVar, m1155a(hVar, i.mo1614b(0).mo1596e()), m1153a(i.mo1614b(1).mo1596e(), ((C0271p) ((C0094f) hVar).mo1241b()).mo1675g() & 255));
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return m1152a((C0271p) ((C0094f) hVar).mo1241b(), 8);
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        if (!(hVar instanceof C0094f) || i.mo1772a() != 2 || !m1172d(i.mo1614b(0).mo1596e()) || !m1172d(i.mo1614b(1).mo1596e())) {
            return false;
        }
        C0255a b = ((C0094f) hVar).mo1241b();
        if (!(b instanceof C0271p)) {
            return false;
        }
        C0271p pVar = (C0271p) b;
        return pVar.mo1674f() && m1169c(pVar.mo1675g());
    }

    /* renamed from: c */
    public BitSet mo1206c(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        BitSet bitSet = new BitSet(2);
        bitSet.set(0, m1172d(i.mo1614b(0).mo1596e()));
        bitSet.set(1, m1172d(i.mo1614b(1).mo1596e()));
        return bitSet;
    }
}
