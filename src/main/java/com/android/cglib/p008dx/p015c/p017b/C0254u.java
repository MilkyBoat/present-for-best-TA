package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p015c.p017b.C0235f.C0237b;
import com.android.cglib.p008dx.p015c.p019d.C0285e;

/* renamed from: com.android.cglib.dx.c.b.u */
public final class C0254u extends C0235f {

    /* renamed from: a */
    private final C0285e f2005a;

    public C0254u(C0249p pVar, C0252s sVar, C0247n nVar, C0285e eVar) {
        super(pVar, sVar, null, nVar);
        if (pVar.mo1629b() != 6) {
            throw new IllegalArgumentException("bogus branchingness");
        } else if (eVar == null) {
            throw new NullPointerException("catches == null");
        } else {
            this.f2005a = eVar;
        }
    }

    /* renamed from: a */
    public static String m1832a(C0285e eVar) {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("catch");
        int a = eVar.mo1738a();
        for (int i = 0; i < a; i++) {
            stringBuffer.append(" ");
            stringBuffer.append(eVar.mo1215a(i).mo1218a_());
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public void mo1561a(C0237b bVar) {
        bVar.mo1327a(this);
    }

    /* renamed from: b */
    public String mo1558b() {
        return m1832a(this.f2005a);
    }

    /* renamed from: i */
    public C0285e mo1570i() {
        return this.f2005a;
    }
}
