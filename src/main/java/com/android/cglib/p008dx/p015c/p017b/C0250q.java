package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p020d.C0295i;
import com.android.cglib.p008dx.p020d.C0297k;

/* renamed from: com.android.cglib.dx.c.b.q */
public final class C0250q {

    /* renamed from: a */
    private final C0231c f1789a;

    /* renamed from: b */
    private final int f1790b;

    /* renamed from: c */
    private C0297k[] f1791c;

    /* renamed from: d */
    private C0297k f1792d;

    public C0250q(C0231c cVar, int i) {
        if (cVar == null) {
            throw new NullPointerException("blocks == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("firstLabel < 0");
        } else {
            this.f1789a = cVar;
            this.f1790b = i;
            this.f1791c = null;
            this.f1792d = null;
        }
    }

    /* renamed from: c */
    private void m1778c() {
        int d = this.f1789a.mo1798d();
        C0297k[] kVarArr = new C0297k[d];
        C0297k kVar = new C0297k(10);
        int a = this.f1789a.mo1772a();
        for (int i = 0; i < a; i++) {
            C0230b a2 = this.f1789a.mo1215a(i);
            int a3 = a2.mo1541a();
            C0297k c = a2.mo1543c();
            int a4 = c.mo1784a();
            if (a4 == 0) {
                kVar.mo1788b(a3);
            } else {
                for (int i2 = 0; i2 < a4; i2++) {
                    int a5 = c.mo1785a(i2);
                    C0297k kVar2 = kVarArr[a5];
                    if (kVar2 == null) {
                        kVar2 = new C0297k(10);
                        kVarArr[a5] = kVar2;
                    }
                    kVar2.mo1788b(a3);
                }
            }
        }
        for (int i3 = 0; i3 < d; i3++) {
            C0297k kVar3 = kVarArr[i3];
            if (kVar3 != null) {
                kVar3.mo1787b();
                kVar3.mo1799e();
            }
        }
        kVar.mo1787b();
        kVar.mo1799e();
        if (kVarArr[this.f1790b] == null) {
            kVarArr[this.f1790b] = C0297k.f2169a;
        }
        this.f1791c = kVarArr;
        this.f1792d = kVar;
    }

    /* renamed from: a */
    public C0231c mo1637a() {
        return this.f1789a;
    }

    /* renamed from: a */
    public C0297k mo1638a(int i) {
        if (this.f1792d == null) {
            m1778c();
        }
        C0297k kVar = this.f1791c[i];
        if (kVar != null) {
            return kVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("no such block: ");
        sb.append(C0295i.m2048c(i));
        throw new RuntimeException(sb.toString());
    }

    /* renamed from: b */
    public int mo1639b() {
        return this.f1790b;
    }
}
