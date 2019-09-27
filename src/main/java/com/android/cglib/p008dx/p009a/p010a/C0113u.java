package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p017b.C0252s;
import com.android.cglib.p008dx.p020d.C0294h;

/* renamed from: com.android.cglib.dx.a.a.u */
public final class C0113u extends C0294h {

    /* renamed from: a */
    public static final C0113u f1209a = new C0113u(0);

    /* renamed from: com.android.cglib.dx.a.a.u$a */
    public static class C0114a {

        /* renamed from: a */
        private final int f1210a;

        /* renamed from: b */
        private final C0252s f1211b;

        public C0114a(int i, C0252s sVar) {
            if (i < 0) {
                throw new IllegalArgumentException("address < 0");
            } else if (sVar == null) {
                throw new NullPointerException("position == null");
            } else {
                this.f1210a = i;
                this.f1211b = sVar;
            }
        }

        /* renamed from: a */
        public int mo1321a() {
            return this.f1210a;
        }

        /* renamed from: b */
        public C0252s mo1322b() {
            return this.f1211b;
        }
    }

    public C0113u(int i) {
        super(i);
    }

    /* renamed from: a */
    public static C0113u m1255a(C0098i iVar, int i) {
        switch (i) {
            case 1:
                return f1209a;
            case 2:
            case 3:
                C0252s sVar = C0252s.f2000a;
                int a = iVar.mo1772a();
                C0114a[] aVarArr = new C0114a[a];
                C0252s sVar2 = sVar;
                int i2 = 0;
                boolean z = false;
                for (int i3 = 0; i3 < a; i3++) {
                    C0097h a2 = iVar.mo1215a(i3);
                    if (a2 instanceof C0093e) {
                        z = true;
                    } else {
                        C0252s h = a2.mo1265h();
                        if (!h.equals(sVar) && !h.mo1641a(sVar2) && (i != 3 || z)) {
                            aVarArr[i2] = new C0114a(a2.mo1263f(), h);
                            i2++;
                            sVar2 = h;
                            z = false;
                        }
                    }
                }
                C0113u uVar = new C0113u(i2);
                for (int i4 = 0; i4 < i2; i4++) {
                    uVar.mo1320a(i4, aVarArr[i4]);
                }
                uVar.mo1799e();
                return uVar;
            default:
                throw new IllegalArgumentException("bogus howMuch");
        }
    }

    /* renamed from: a */
    public C0114a mo1215a(int i) {
        return (C0114a) mo1776d(i);
    }

    /* renamed from: a */
    public void mo1320a(int i, C0114a aVar) {
        mo1774a(i, aVar);
    }
}
