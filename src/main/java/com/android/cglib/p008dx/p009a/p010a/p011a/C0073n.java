package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p009a.p010a.C0122z;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p020d.C0286a;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.a.n */
public final class C0073n extends C0103n {

    /* renamed from: b */
    public static final C0103n f880b = new C0073n();

    private C0073n() {
    }

    /* renamed from: a */
    public int mo1200a() {
        return 2;
    }

    /* renamed from: a */
    public String mo1201a(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        StringBuilder sb = new StringBuilder();
        sb.append(i.mo1614b(0).mo1604k());
        sb.append(", ");
        sb.append(i.mo1614b(1).mo1604k());
        sb.append(", ");
        sb.append(m1171d(hVar));
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        C0247n i = hVar.mo1266i();
        m1161a(aVar, m1155a(hVar, m1166b(i.mo1614b(0).mo1596e(), i.mo1614b(1).mo1596e())), (short) ((C0122z) hVar).mo1333d());
    }

    /* renamed from: a */
    public boolean mo1203a(C0122z zVar) {
        int d = zVar.mo1333d();
        return d != 0 && m1174e(d);
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return m1173e(hVar);
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        if (!(hVar instanceof C0122z) || i.mo1772a() != 2 || !m1168b(i.mo1614b(0).mo1596e())) {
            return false;
        }
        boolean z = true;
        if (!m1168b(i.mo1614b(1).mo1596e())) {
            return false;
        }
        C0122z zVar = (C0122z) hVar;
        if (zVar.mo1334o()) {
            z = mo1203a(zVar);
        }
        return z;
    }

    /* renamed from: c */
    public BitSet mo1206c(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        BitSet bitSet = new BitSet(2);
        bitSet.set(0, m1168b(i.mo1614b(0).mo1596e()));
        bitSet.set(1, m1168b(i.mo1614b(1).mo1596e()));
        return bitSet;
    }
}
