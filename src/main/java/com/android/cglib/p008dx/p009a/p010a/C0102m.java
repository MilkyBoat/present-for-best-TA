package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p017b.C0252s;
import com.android.cglib.p008dx.p020d.C0286a;

/* renamed from: com.android.cglib.dx.a.a.m */
public final class C0102m extends C0086aa {

    /* renamed from: a */
    private C0120x[] f1179a;

    public C0102m(C0252s sVar, C0247n nVar) {
        super(sVar, nVar);
        if (nVar.mo1772a() == 0) {
            throw new IllegalArgumentException("registers.size() == 0");
        }
        this.f1179a = null;
    }

    /* renamed from: a */
    private static C0120x m1143a(C0244m mVar, int i) {
        return C0097h.m1099a(C0252s.f2000a, C0244m.m1722a(i, mVar.mo1589b()), mVar);
    }

    /* renamed from: b */
    private void m1144b() {
        if (this.f1179a == null) {
            C0247n i = mo1266i();
            int a = i.mo1772a();
            this.f1179a = new C0120x[a];
            int i2 = 0;
            for (int i3 = 0; i3 < a; i3++) {
                C0244m b = i.mo1614b(i3);
                this.f1179a[i3] = m1143a(b, i2);
                i2 += b.mo1602i();
            }
        }
    }

    /* renamed from: a */
    public C0097h mo1237a(C0247n nVar) {
        return new C0102m(mo1265h(), nVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo1238a() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo1239a(boolean z) {
        C0247n i = mo1266i();
        int a = i.mo1772a();
        StringBuffer stringBuffer = new StringBuffer(100);
        int i2 = 0;
        for (int i3 = 0; i3 < a; i3++) {
            C0244m b = i.mo1614b(i3);
            C0120x a2 = m1143a(b, i2);
            if (i3 != 0) {
                stringBuffer.append(10);
            }
            stringBuffer.append(a2.mo1239a(z));
            i2 += b.mo1602i();
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public void mo1209a(C0286a aVar) {
        m1144b();
        for (C0120x a : this.f1179a) {
            a.mo1209a(aVar);
        }
    }

    /* renamed from: n */
    public int mo1210n() {
        m1144b();
        int i = 0;
        for (C0120x n : this.f1179a) {
            i += n.mo1210n();
        }
        return i;
    }
}
