package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0094f;
import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0265j;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p020d.C0286a;
import com.androlua.BuildConfig;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.a.l */
public final class C0071l extends C0103n {

    /* renamed from: b */
    public static final C0103n f878b = new C0071l();

    private C0071l() {
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
        sb.append(m1175f(hVar));
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        C0247n i = hVar.mo1266i();
        m1161a(aVar, m1155a(hVar, m1166b(i.mo1614b(0).mo1596e(), i.mo1614b(1).mo1596e())), (short) ((C0094f) hVar).mo1243c());
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return z ? m1177g(hVar) : BuildConfig.FLAVOR;
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        if (!(hVar instanceof C0094f) || i.mo1772a() != 2 || !m1168b(i.mo1614b(0).mo1596e())) {
            return false;
        }
        boolean z = true;
        if (!m1168b(i.mo1614b(1).mo1596e())) {
            return false;
        }
        C0094f fVar = (C0094f) hVar;
        if (!m1176f(fVar.mo1243c())) {
            return false;
        }
        C0255a b = fVar.mo1241b();
        if (!(b instanceof C0278w)) {
            if (b instanceof C0265j) {
                return true;
            }
            z = false;
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
