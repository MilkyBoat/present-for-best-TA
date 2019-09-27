package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p009a.p010a.C0120x;
import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p020d.C0286a;
import com.androlua.BuildConfig;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.a.e */
public final class C0064e extends C0103n {

    /* renamed from: b */
    public static final C0103n f871b = new C0064e();

    private C0064e() {
    }

    /* renamed from: a */
    public int mo1200a() {
        return 1;
    }

    /* renamed from: a */
    public String mo1201a(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        int a = i.mo1772a();
        StringBuilder sb = new StringBuilder();
        sb.append(i.mo1614b(a - 2).mo1604k());
        sb.append(", ");
        sb.append(i.mo1614b(a - 1).mo1604k());
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        C0247n i = hVar.mo1266i();
        int a = i.mo1772a();
        m1156a(aVar, m1155a(hVar, m1166b(i.mo1614b(a - 2).mo1596e(), i.mo1614b(a - 1).mo1596e())));
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return BuildConfig.FLAVOR;
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        C0244m mVar;
        C0244m mVar2;
        boolean z = false;
        if (!(hVar instanceof C0120x)) {
            return false;
        }
        C0247n i = hVar.mo1266i();
        switch (i.mo1772a()) {
            case 2:
                mVar2 = i.mo1614b(0);
                mVar = i.mo1614b(1);
                break;
            case 3:
                mVar2 = i.mo1614b(1);
                mVar = i.mo1614b(2);
                if (mVar2.mo1596e() != i.mo1614b(0).mo1596e()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        if (m1168b(mVar2.mo1596e()) && m1168b(mVar.mo1596e())) {
            z = true;
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
