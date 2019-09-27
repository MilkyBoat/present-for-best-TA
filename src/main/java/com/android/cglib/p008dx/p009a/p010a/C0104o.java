package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p017b.C0252s;

/* renamed from: com.android.cglib.dx.a.a.o */
public final class C0104o extends C0087ab {

    /* renamed from: a */
    private final C0244m f1181a;

    public C0104o(C0252s sVar, C0244m mVar) {
        super(sVar);
        if (mVar == null) {
            throw new NullPointerException("local == null");
        }
        this.f1181a = mVar;
    }

    /* renamed from: a */
    public C0097h mo1237a(C0247n nVar) {
        return new C0104o(mo1265h(), this.f1181a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo1238a() {
        return this.f1181a.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo1239a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("local-end ");
        sb.append(C0110r.m1222a(this.f1181a));
        return sb.toString();
    }

    /* renamed from: b */
    public C0244m mo1286b() {
        return this.f1181a;
    }

    /* renamed from: d */
    public C0097h mo1208d(int i) {
        return new C0104o(mo1265h(), this.f1181a.mo1593c(i));
    }
}
