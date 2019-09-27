package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0094f;
import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0274s;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p020d.C0286a;
import com.androlua.BuildConfig;

/* renamed from: com.android.cglib.dx.a.a.a.aa */
public final class C0059aa extends C0103n {

    /* renamed from: b */
    public static final C0103n f866b = new C0059aa();

    private C0059aa() {
    }

    /* renamed from: a */
    public int mo1200a() {
        return 5;
    }

    /* renamed from: a */
    public String mo1201a(C0097h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(m1167b(hVar.mo1266i()));
        sb.append(", ");
        sb.append(m1175f(hVar));
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        C0247n i = hVar.mo1266i();
        int c = ((C0094f) hVar).mo1243c();
        int i2 = 0;
        if (i.mo1772a() != 0) {
            i2 = i.mo1614b(0).mo1596e();
        }
        m1159a(aVar, m1178h(hVar), c, (short) i.mo1613b(), (short) i2);
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return z ? m1177g(hVar) : BuildConfig.FLAVOR;
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        boolean z = false;
        if (!f1180a || !(hVar instanceof C0094f)) {
            return false;
        }
        C0094f fVar = (C0094f) hVar;
        C0255a b = fVar.mo1241b();
        if (!(b instanceof C0274s) && !(b instanceof C0278w)) {
            return false;
        }
        C0247n i = fVar.mo1266i();
        i.mo1772a();
        if (i.mo1772a() == 0 || (m1170c(i) && m1176f(i.mo1614b(0).mo1596e()) && m1176f(i.mo1613b()))) {
            z = true;
        }
        return z;
    }
}
