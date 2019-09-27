package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p017b.C0252s;

/* renamed from: com.android.cglib.dx.a.a.r */
public final class C0110r extends C0087ab {

    /* renamed from: a */
    private final C0244m f1200a;

    public C0110r(C0252s sVar, C0244m mVar) {
        super(sVar);
        if (mVar == null) {
            throw new NullPointerException("local == null");
        }
        this.f1200a = mVar;
    }

    /* renamed from: a */
    public static String m1222a(C0244m mVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(mVar.mo1604k());
        sb.append(' ');
        sb.append(mVar.mo1599g().toString());
        sb.append(": ");
        sb.append(mVar.mo1598f().mo1218a_());
        return sb.toString();
    }

    /* renamed from: a */
    public C0097h mo1237a(C0247n nVar) {
        return new C0110r(mo1265h(), this.f1200a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo1238a() {
        return this.f1200a.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo1239a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("local-start ");
        sb.append(m1222a(this.f1200a));
        return sb.toString();
    }

    /* renamed from: b */
    public C0244m mo1309b() {
        return this.f1200a;
    }

    /* renamed from: d */
    public C0097h mo1208d(int i) {
        return new C0110r(mo1265h(), this.f1200a.mo1593c(i));
    }
}
