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

/* renamed from: com.android.cglib.dx.a.a.a.z */
public final class C0085z extends C0103n {

    /* renamed from: b */
    public static final C0103n f892b = new C0085z();

    private C0085z() {
    }

    /* renamed from: a */
    public int mo1200a() {
        return 5;
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
        m1159a(aVar, m1178h(hVar), ((C0094f) hVar).mo1243c(), (short) i.mo1614b(0).mo1596e(), (short) i.mo1614b(1).mo1596e());
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return z ? m1177g(hVar) : BuildConfig.FLAVOR;
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        boolean z = false;
        if (!f1180a) {
            return false;
        }
        C0247n i = hVar.mo1266i();
        if ((hVar instanceof C0094f) && i.mo1772a() == 2 && m1176f(i.mo1614b(0).mo1596e())) {
            if (!m1176f(i.mo1614b(1).mo1596e())) {
                return false;
            }
            C0255a b = ((C0094f) hVar).mo1241b();
            if ((b instanceof C0278w) || (b instanceof C0265j)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: c */
    public BitSet mo1206c(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        BitSet bitSet = new BitSet(2);
        bitSet.set(0, m1176f(i.mo1614b(0).mo1596e()));
        bitSet.set(1, m1176f(i.mo1614b(1).mo1596e()));
        return bitSet;
    }
}
