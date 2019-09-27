package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0094f;
import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p018c.C0270o;
import com.android.cglib.p008dx.p015c.p018c.C0271p;
import com.android.cglib.p008dx.p020d.C0286a;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.a.y */
public final class C0084y extends C0103n {

    /* renamed from: b */
    public static final C0103n f891b = new C0084y();

    private C0084y() {
    }

    /* renamed from: a */
    public int mo1200a() {
        return 5;
    }

    /* renamed from: a */
    public String mo1201a(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        C0271p pVar = (C0271p) ((C0094f) hVar).mo1241b();
        StringBuilder sb = new StringBuilder();
        sb.append(i.mo1614b(0).mo1604k());
        sb.append(", ");
        sb.append(m1151a(pVar));
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        C0247n i = hVar.mo1266i();
        m1160a(aVar, m1155a(hVar, i.mo1614b(0).mo1596e()), ((C0270o) ((C0094f) hVar).mo1241b()).mo1676h());
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return m1152a((C0271p) ((C0094f) hVar).mo1241b(), 64);
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        if (!(hVar instanceof C0094f) || i.mo1772a() != 1 || !m1172d(i.mo1614b(0).mo1596e())) {
            return false;
        }
        return ((C0094f) hVar).mo1241b() instanceof C0270o;
    }

    /* renamed from: c */
    public BitSet mo1206c(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        BitSet bitSet = new BitSet(1);
        bitSet.set(0, m1172d(i.mo1614b(0).mo1596e()));
        return bitSet;
    }
}
