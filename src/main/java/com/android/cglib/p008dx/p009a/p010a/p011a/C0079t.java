package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p009a.p010a.C0122z;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p020d.C0286a;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.a.t */
public final class C0079t extends C0103n {

    /* renamed from: b */
    public static final C0103n f886b = new C0079t();

    private C0079t() {
    }

    /* renamed from: a */
    public int mo1200a() {
        return 3;
    }

    /* renamed from: a */
    public String mo1201a(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        StringBuilder sb = new StringBuilder();
        sb.append(i.mo1614b(0).mo1604k());
        sb.append(", ");
        sb.append(m1171d(hVar));
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        C0247n i = hVar.mo1266i();
        m1157a(aVar, m1155a(hVar, i.mo1614b(0).mo1596e()), ((C0122z) hVar).mo1333d());
    }

    /* renamed from: a */
    public boolean mo1203a(C0122z zVar) {
        return true;
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return m1173e(hVar);
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        return (hVar instanceof C0122z) && i.mo1772a() == 1 && m1172d(i.mo1614b(0).mo1596e());
    }

    /* renamed from: c */
    public BitSet mo1206c(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        BitSet bitSet = new BitSet(1);
        bitSet.set(0, m1172d(i.mo1614b(0).mo1596e()));
        return bitSet;
    }
}
