package com.android.cglib.p008dx.p009a.p010a.p011a;

import com.android.cglib.p008dx.p009a.p010a.C0097h;
import com.android.cglib.p008dx.p009a.p010a.C0103n;
import com.android.cglib.p008dx.p009a.p010a.C0122z;
import com.android.cglib.p008dx.p020d.C0286a;

/* renamed from: com.android.cglib.dx.a.a.a.f */
public final class C0065f extends C0103n {

    /* renamed from: b */
    public static final C0103n f872b = new C0065f();

    private C0065f() {
    }

    /* renamed from: a */
    public int mo1200a() {
        return 2;
    }

    /* renamed from: a */
    public String mo1201a(C0097h hVar) {
        return m1171d(hVar);
    }

    /* renamed from: a */
    public void mo1202a(C0286a aVar, C0097h hVar) {
        m1161a(aVar, m1155a(hVar, 0), (short) ((C0122z) hVar).mo1333d());
    }

    /* renamed from: a */
    public boolean mo1203a(C0122z zVar) {
        int d = zVar.mo1333d();
        return d != 0 && m1174e(d);
    }

    /* renamed from: b */
    public String mo1204b(C0097h hVar, boolean z) {
        return m1173e(hVar);
    }

    /* renamed from: b */
    public boolean mo1205b(C0097h hVar) {
        if (!(hVar instanceof C0122z) || hVar.mo1266i().mo1772a() != 0) {
            return false;
        }
        C0122z zVar = (C0122z) hVar;
        if (zVar.mo1334o()) {
            return mo1203a(zVar);
        }
        return true;
    }
}
