package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p009a.p010a.C0120x;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p020d.C0286a;
import com.androlua.BuildConfig;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.a.d */
public final class C0063d extends C0103n {

    /* renamed from: b */
    public static final C0103n f870b = new C0063d();

    private C0063d() {
    }

    /* renamed from: a */
    public int mo1200a() {
        return 1;
    }

    /* renamed from: a */
    public String mo1201a(C0097h hVar) {
        return hVar.mo1266i().mo1614b(0).mo1604k();
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        m1156a(aVar, m1155a(hVar, hVar.mo1266i().mo1614b(0).mo1596e()));
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return BuildConfig.FLAVOR;
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        return (hVar instanceof C0120x) && i.mo1772a() == 1 && m1172d(i.mo1614b(0).mo1596e());
    }

    /* renamed from: c */
    public BitSet mo1206c(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        BitSet bitSet = new BitSet(1);
        bitSet.set(0, m1172d(i.mo1614b(0).mo1596e()));
        return bitSet;
    }
}
