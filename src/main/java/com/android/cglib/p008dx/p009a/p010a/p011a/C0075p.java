package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p009a.p010a.C0120x;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p020d.C0286a;
import com.androlua.BuildConfig;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.a.p */
public final class C0075p extends C0103n {

    /* renamed from: b */
    public static final C0103n f882b = new C0075p();

    private C0075p() {
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
        sb.append(i.mo1614b(2).mo1604k());
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        C0247n i = hVar.mo1266i();
        m1161a(aVar, m1155a(hVar, i.mo1614b(0).mo1596e()), m1153a(i.mo1614b(1).mo1596e(), i.mo1614b(2).mo1596e()));
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return BuildConfig.FLAVOR;
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        return (hVar instanceof C0120x) && i.mo1772a() == 3 && m1172d(i.mo1614b(0).mo1596e()) && m1172d(i.mo1614b(1).mo1596e()) && m1172d(i.mo1614b(2).mo1596e());
    }

    /* renamed from: c */
    public BitSet mo1206c(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        BitSet bitSet = new BitSet(3);
        bitSet.set(0, m1172d(i.mo1614b(0).mo1596e()));
        bitSet.set(1, m1172d(i.mo1614b(1).mo1596e()));
        bitSet.set(2, m1172d(i.mo1614b(2).mo1596e()));
        return bitSet;
    }
}
