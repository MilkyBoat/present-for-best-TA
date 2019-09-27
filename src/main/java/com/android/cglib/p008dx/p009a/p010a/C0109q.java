package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p017b.C0248o;
import com.android.cglib.p008dx.p015c.p017b.C0252s;

/* renamed from: com.android.cglib.dx.a.a.q */
public final class C0109q extends C0087ab {

    /* renamed from: a */
    private final C0248o f1199a;

    public C0109q(C0252s sVar, C0248o oVar) {
        super(sVar);
        if (oVar == null) {
            throw new NullPointerException("locals == null");
        }
        this.f1199a = oVar;
    }

    /* renamed from: a */
    public C0097h mo1237a(C0247n nVar) {
        return new C0109q(mo1265h(), this.f1199a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo1238a() {
        return this.f1199a.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo1239a(boolean z) {
        int b = this.f1199a.mo1621b();
        int a = this.f1199a.mo1617a();
        StringBuffer stringBuffer = new StringBuffer((b * 40) + 100);
        stringBuffer.append("local-snapshot");
        for (int i = 0; i < a; i++) {
            C0244m a2 = this.f1199a.mo1618a(i);
            if (a2 != null) {
                stringBuffer.append("\n  ");
                stringBuffer.append(C0110r.m1222a(a2));
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public C0248o mo1308b() {
        return this.f1199a;
    }

    /* renamed from: d */
    public C0097h mo1208d(int i) {
        return new C0109q(mo1265h(), this.f1199a.mo1622b(i));
    }
}
