package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.a.b.c */
public final class C0153c extends C0136ag {

    /* renamed from: a */
    private C0152b f1290a;

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_ANNOTATION_SET_REF_ITEM;
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        this.f1290a = (C0152b) lVar.mo1470d().mo1369b(this.f1290a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        int e = this.f1290a.mo1379e();
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("  annotations_off: ");
            sb.append(C0295i.m2044a(e));
            aVar.mo1739a(4, sb.toString());
        }
        aVar.mo1755d(e);
    }

    /* renamed from: b */
    public String mo1343b() {
        return this.f1290a.mo1343b();
    }
}
