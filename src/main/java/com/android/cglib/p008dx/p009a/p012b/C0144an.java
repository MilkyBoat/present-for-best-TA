package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.a.b.an */
public final class C0144an extends C0176w implements Comparable {

    /* renamed from: a */
    private final C0277v f1279a;

    /* renamed from: b */
    private C0143am f1280b;

    public C0144an(C0277v vVar) {
        if (vVar == null) {
            throw new NullPointerException("value == null");
        }
        this.f1279a = vVar;
        this.f1280b = null;
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_STRING_ID_ITEM;
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        if (this.f1280b == null) {
            C0132af c = lVar.mo1469c();
            this.f1280b = new C0143am(this.f1279a);
            c.mo1366a((C0136ag) this.f1280b);
        }
    }

    /* renamed from: a */
    public void mo1347a(C0165l lVar, C0286a aVar) {
        int e = this.f1280b.mo1379e();
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1514h());
            sb.append(' ');
            sb.append(this.f1279a.mo1696a(100));
            aVar.mo1739a(0, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  string_data_off: ");
            sb2.append(C0295i.m2044a(e));
            aVar.mo1739a(4, sb2.toString());
        }
        aVar.mo1755d(e);
    }

    /* renamed from: b_ */
    public int mo1349b_() {
        return 4;
    }

    /* renamed from: c */
    public C0277v mo1408c() {
        return this.f1279a;
    }

    public int compareTo(Object obj) {
        return this.f1279a.compareTo(((C0144an) obj).f1279a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0144an)) {
            return false;
        }
        return this.f1279a.equals(((C0144an) obj).f1279a);
    }

    public int hashCode() {
        return this.f1279a.hashCode();
    }
}
