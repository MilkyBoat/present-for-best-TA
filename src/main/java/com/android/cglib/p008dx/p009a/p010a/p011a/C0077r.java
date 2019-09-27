package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0094f;
import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0265j;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p020d.C0286a;
import com.androlua.BuildConfig;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.a.r */
public final class C0077r extends C0103n {

    /* renamed from: b */
    public static final C0103n f884b = new C0077r();

    private C0077r() {
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
        sb.append(m1175f(hVar));
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        C0247n i = hVar.mo1266i();
        m1157a(aVar, m1155a(hVar, i.mo1614b(0).mo1596e()), ((C0094f) hVar).mo1243c());
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return z ? m1177g(hVar) : BuildConfig.FLAVOR;
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        C0244m mVar;
        boolean z = false;
        if (!(hVar instanceof C0094f)) {
            return false;
        }
        C0247n i = hVar.mo1266i();
        switch (i.mo1772a()) {
            case 1:
                mVar = i.mo1614b(0);
                break;
            case 2:
                mVar = i.mo1614b(0);
                if (mVar.mo1596e() != i.mo1614b(1).mo1596e()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        if (!m1172d(mVar.mo1596e())) {
            return false;
        }
        C0255a b = ((C0094f) hVar).mo1241b();
        if ((b instanceof C0278w) || (b instanceof C0265j) || (b instanceof C0277v)) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public BitSet mo1206c(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        int a = i.mo1772a();
        BitSet bitSet = new BitSet(a);
        boolean d = m1172d(i.mo1614b(0).mo1596e());
        if (a == 1) {
            bitSet.set(0, d);
            return bitSet;
        }
        if (i.mo1614b(0).mo1596e() == i.mo1614b(1).mo1596e()) {
            bitSet.set(0, d);
            bitSet.set(1, d);
        }
        return bitSet;
    }
}
