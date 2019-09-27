package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p009a.p010a.C0120x;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p020d.C0286a;
import com.androlua.BuildConfig;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.a.u */
public final class C0080u extends C0103n {

    /* renamed from: b */
    public static final C0103n f887b = new C0080u();

    private C0080u() {
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
        sb.append(i.mo1614b(1).mo1604k());
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        C0247n i = hVar.mo1266i();
        m1162a(aVar, m1155a(hVar, 0), (short) i.mo1614b(0).mo1596e(), (short) i.mo1614b(1).mo1596e());
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return BuildConfig.FLAVOR;
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        return (hVar instanceof C0120x) && i.mo1772a() == 2 && m1176f(i.mo1614b(0).mo1596e()) && m1176f(i.mo1614b(1).mo1596e());
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
