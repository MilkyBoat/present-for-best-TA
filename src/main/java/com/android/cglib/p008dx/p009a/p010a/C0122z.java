package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p017b.C0252s;

/* renamed from: com.android.cglib.dx.a.a.z */
public final class C0122z extends C0101l {

    /* renamed from: a */
    private C0093e f1236a;

    public C0122z(C0099j jVar, C0252s sVar, C0247n nVar, C0093e eVar) {
        super(jVar, sVar, nVar);
        if (eVar == null) {
            throw new NullPointerException("target == null");
        }
        this.f1236a = eVar;
    }

    /* renamed from: a */
    public C0097h mo1207a(C0099j jVar) {
        return new C0122z(jVar, mo1265h(), mo1266i(), this.f1236a);
    }

    /* renamed from: a */
    public C0097h mo1237a(C0247n nVar) {
        return new C0122z(mo1264g(), mo1265h(), nVar, this.f1236a);
    }

    /* renamed from: a */
    public C0122z mo1330a(C0093e eVar) {
        return new C0122z(mo1264g().mo1283g(), mo1265h(), mo1266i(), eVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo1238a() {
        return this.f1236a == null ? "????" : this.f1236a.mo1269l();
    }

    /* renamed from: b */
    public C0093e mo1331b() {
        return this.f1236a;
    }

    /* renamed from: c */
    public int mo1332c() {
        return this.f1236a.mo1263f();
    }

    /* renamed from: d */
    public int mo1333d() {
        return this.f1236a.mo1263f() - mo1263f();
    }

    /* renamed from: o */
    public boolean mo1334o() {
        return mo1262e() && this.f1236a.mo1262e();
    }
}
