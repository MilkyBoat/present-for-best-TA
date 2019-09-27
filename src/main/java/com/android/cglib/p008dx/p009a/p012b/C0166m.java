package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0257c;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0289d;

/* renamed from: com.android.cglib.dx.a.b.m */
public final class C0166m extends C0136ag {

    /* renamed from: a */
    private final C0257c f1364a;

    /* renamed from: b */
    private byte[] f1365b;

    public C0166m(C0257c cVar) {
        super(1, -1);
        if (cVar == null) {
            throw new NullPointerException("array == null");
        }
        this.f1364a = cVar;
        this.f1365b = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo1337a(C0136ag agVar) {
        return this.f1364a.compareTo(((C0166m) agVar).f1364a);
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_ENCODED_ARRAY_ITEM;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1339a(C0140ak akVar, int i) {
        C0289d dVar = new C0289d();
        new C0151au(akVar.mo1396e(), dVar).mo1429a(this.f1364a, false);
        this.f1365b = dVar.mo1759f();
        mo1375a(this.f1365b.length);
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        C0151au.m1453a(lVar, (C0255a) this.f1364a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1382g());
            sb.append(" encoded array");
            aVar.mo1739a(0, sb.toString());
            new C0151au(lVar, aVar).mo1429a(this.f1364a, true);
            return;
        }
        aVar.mo1751a(this.f1365b);
    }

    /* renamed from: b */
    public String mo1343b() {
        return this.f1364a.mo1218a_();
    }

    public int hashCode() {
        return this.f1364a.hashCode();
    }
}
