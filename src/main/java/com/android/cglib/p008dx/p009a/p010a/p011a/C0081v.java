package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0094f;
import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0274s;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0286a;
import com.androlua.BuildConfig;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.a.v */
public final class C0081v extends C0103n {

    /* renamed from: b */
    public static final C0103n f888b = new C0081v();

    private C0081v() {
    }

    /* renamed from: d */
    private static int m1020d(C0247n nVar) {
        int a = nVar.mo1772a();
        int i = -1;
        if (a > 5) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < a; i3++) {
            C0244m b = nVar.mo1614b(i3);
            i2 += b.mo1602i();
            if (!m1168b((b.mo1596e() + b.mo1602i()) - 1)) {
                return -1;
            }
        }
        if (i2 <= 5) {
            i = i2;
        }
        return i;
    }

    /* renamed from: e */
    private static C0247n m1021e(C0247n nVar) {
        int d = m1020d(nVar);
        int a = nVar.mo1772a();
        if (d == a) {
            return nVar;
        }
        C0247n nVar2 = new C0247n(d);
        int i = 0;
        for (int i2 = 0; i2 < a; i2++) {
            C0244m b = nVar.mo1614b(i2);
            nVar2.mo1612a(i, b);
            if (b.mo1602i() == 2) {
                nVar2.mo1612a(i + 1, C0244m.m1722a(b.mo1596e() + 1, C0283c.f2123i));
                i += 2;
            } else {
                i++;
            }
        }
        nVar2.mo1799e();
        return nVar2;
    }

    /* renamed from: a */
    public int mo1200a() {
        return 3;
    }

    /* renamed from: a */
    public String mo1201a(C0097h hVar) {
        C0247n e = m1021e(hVar.mo1266i());
        StringBuilder sb = new StringBuilder();
        sb.append(m1150a(e));
        sb.append(", ");
        sb.append(m1175f(hVar));
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        int c = ((C0094f) hVar).mo1243c();
        C0247n e = m1021e(hVar.mo1266i());
        int a = e.mo1772a();
        int i = 0;
        int e2 = a > 0 ? e.mo1614b(0).mo1596e() : 0;
        int e3 = a > 1 ? e.mo1614b(1).mo1596e() : 0;
        int e4 = a > 2 ? e.mo1614b(2).mo1596e() : 0;
        int e5 = a > 3 ? e.mo1614b(3).mo1596e() : 0;
        if (a > 4) {
            i = e.mo1614b(4).mo1596e();
        }
        m1162a(aVar, m1155a(hVar, m1166b(i, a)), (short) c, m1154a(e2, e3, e4, e5));
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return z ? m1177g(hVar) : BuildConfig.FLAVOR;
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        boolean z = false;
        if (!(hVar instanceof C0094f)) {
            return false;
        }
        C0094f fVar = (C0094f) hVar;
        if (!m1176f(fVar.mo1243c())) {
            return false;
        }
        C0255a b = fVar.mo1241b();
        if (!(b instanceof C0274s) && !(b instanceof C0278w)) {
            return false;
        }
        if (m1020d(fVar.mo1266i()) >= 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public BitSet mo1206c(C0097h hVar) {
        C0247n i = hVar.mo1266i();
        int a = i.mo1772a();
        BitSet bitSet = new BitSet(a);
        for (int i2 = 0; i2 < a; i2++) {
            C0244m b = i.mo1614b(i2);
            bitSet.set(i2, m1168b((b.mo1596e() + b.mo1602i()) - 1));
        }
        return bitSet;
    }
}
