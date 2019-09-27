package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p015c.p019d.C0285e;
import com.android.cglib.p008dx.p020d.C0294h;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.c.b.n */
public final class C0247n extends C0294h implements C0285e {

    /* renamed from: a */
    public static final C0247n f1778a = new C0247n(0);

    public C0247n(int i) {
        super(i);
    }

    /* renamed from: a */
    public static C0247n m1753a(C0244m mVar) {
        C0247n nVar = new C0247n(1);
        nVar.mo1612a(0, mVar);
        return nVar;
    }

    /* renamed from: a */
    public static C0247n m1754a(C0244m mVar, C0244m mVar2) {
        C0247n nVar = new C0247n(2);
        nVar.mo1612a(0, mVar);
        nVar.mo1612a(1, mVar2);
        return nVar;
    }

    /* renamed from: a */
    public static C0247n m1755a(C0244m mVar, C0244m mVar2, C0244m mVar3) {
        C0247n nVar = new C0247n(3);
        nVar.mo1612a(0, mVar);
        nVar.mo1612a(1, mVar2);
        nVar.mo1612a(2, mVar3);
        return nVar;
    }

    /* renamed from: a */
    public C0247n mo1610a(int i, boolean z, BitSet bitSet) {
        int a = mo1772a();
        if (a == 0) {
            return this;
        }
        C0247n nVar = new C0247n(a);
        boolean z2 = z;
        int i2 = i;
        for (int i3 = 0; i3 < a; i3++) {
            C0244m mVar = (C0244m) mo1776d(i3);
            boolean z3 = true;
            if (bitSet != null && bitSet.get(i3)) {
                z3 = false;
            }
            if (z3) {
                nVar.mo1774a(i3, mVar.mo1588b(i2));
                if (!z2) {
                    i2 += mVar.mo1602i();
                }
            } else {
                nVar.mo1774a(i3, mVar);
            }
            if (z2) {
                z2 = false;
            }
        }
        if (mo1800f()) {
            nVar.mo1799e();
        }
        return nVar;
    }

    /* renamed from: a */
    public C0247n mo1611a(BitSet bitSet) {
        int a = mo1772a() - bitSet.cardinality();
        if (a == 0) {
            return f1778a;
        }
        C0247n nVar = new C0247n(a);
        int i = 0;
        for (int i2 = 0; i2 < mo1772a(); i2++) {
            if (!bitSet.get(i2)) {
                nVar.mo1774a(i, mo1776d(i2));
                i++;
            }
        }
        if (mo1800f()) {
            nVar.mo1799e();
        }
        return nVar;
    }

    /* renamed from: a */
    public C0283c mo1215a(int i) {
        return mo1614b(i).mo1589b().mo1589b();
    }

    /* renamed from: a */
    public void mo1612a(int i, C0244m mVar) {
        mo1774a(i, mVar);
    }

    /* renamed from: b */
    public int mo1613b() {
        int i = 0;
        for (int i2 = 0; i2 < mo1772a(); i2++) {
            i += mo1215a(i2).mo1729g();
        }
        return i;
    }

    /* renamed from: b */
    public C0244m mo1614b(int i) {
        return (C0244m) mo1776d(i);
    }

    /* renamed from: b */
    public C0247n mo1615b(C0244m mVar) {
        int a = mo1772a();
        C0247n nVar = new C0247n(a + 1);
        int i = 0;
        while (i < a) {
            int i2 = i + 1;
            nVar.mo1774a(i2, mo1776d(i));
            i = i2;
        }
        nVar.mo1774a(0, mVar);
        if (mo1800f()) {
            nVar.mo1799e();
        }
        return nVar;
    }

    /* renamed from: c */
    public C0247n mo1616c(int i) {
        int a = mo1772a();
        if (a == 0) {
            return this;
        }
        C0247n nVar = new C0247n(a);
        for (int i2 = 0; i2 < a; i2++) {
            C0244m mVar = (C0244m) mo1776d(i2);
            if (mVar != null) {
                nVar.mo1774a(i2, mVar.mo1593c(i));
            }
        }
        if (mo1800f()) {
            nVar.mo1799e();
        }
        return nVar;
    }
}
