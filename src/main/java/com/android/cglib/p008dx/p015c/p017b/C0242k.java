package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p015c.p017b.C0235f.C0237b;
import com.android.cglib.p008dx.p015c.p019d.C0282b;
import com.android.cglib.p008dx.p015c.p019d.C0285e;

/* renamed from: com.android.cglib.dx.c.b.k */
public final class C0242k extends C0235f {
    public C0242k(C0249p pVar, C0252s sVar, C0244m mVar, C0244m mVar2) {
        this(pVar, sVar, mVar, C0247n.m1753a(mVar2));
    }

    public C0242k(C0249p pVar, C0252s sVar, C0244m mVar, C0247n nVar) {
        super(pVar, sVar, mVar, nVar);
        switch (pVar.mo1629b()) {
            case 5:
            case 6:
                throw new IllegalArgumentException("bogus branchingness");
            default:
                if (mVar != null && pVar.mo1629b() != 1) {
                    throw new IllegalArgumentException("can't mix branchingness with result");
                }
                return;
        }
    }

    /* renamed from: a */
    public void mo1561a(C0237b bVar) {
        bVar.mo1325a(this);
    }

    /* renamed from: i */
    public C0285e mo1570i() {
        return C0282b.f2078a;
    }
}
