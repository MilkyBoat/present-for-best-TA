package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p015c.p017b.C0235f.C0237b;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p019d.C0285e;

/* renamed from: com.android.cglib.dx.c.b.t */
public final class C0253t extends C0233d {

    /* renamed from: a */
    private final C0285e f2004a;

    public C0253t(C0249p pVar, C0252s sVar, C0247n nVar, C0285e eVar, C0255a aVar) {
        super(pVar, sVar, null, nVar, aVar);
        if (pVar.mo1629b() != 6) {
            throw new IllegalArgumentException("bogus branchingness");
        } else if (eVar == null) {
            throw new NullPointerException("catches == null");
        } else {
            this.f2004a = eVar;
        }
    }

    /* renamed from: a */
    public void mo1561a(C0237b bVar) {
        bVar.mo1326a(this);
    }

    /* renamed from: b */
    public String mo1558b() {
        C0255a c = mo1559c();
        String a_ = c.mo1218a_();
        if (c instanceof C0277v) {
            a_ = ((C0277v) c).mo1698f();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a_);
        sb.append(" ");
        sb.append(C0254u.m1832a(this.f2004a));
        return sb.toString();
    }

    /* renamed from: i */
    public C0285e mo1570i() {
        return this.f2004a;
    }
}
