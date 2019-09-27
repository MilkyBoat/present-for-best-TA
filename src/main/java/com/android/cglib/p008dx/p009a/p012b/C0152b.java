package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p016a.C0227c;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.a.b.b */
public final class C0152b extends C0136ag {

    /* renamed from: a */
    private final C0227c f1288a;

    /* renamed from: b */
    private final C0124a[] f1289b;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo1337a(C0136ag agVar) {
        return this.f1288a.compareTo(((C0152b) agVar).f1288a);
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_ANNOTATION_SET_ITEM;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1339a(C0140ak akVar, int i) {
        C0124a.m1310a(this.f1289b);
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        C0132af n = lVar.mo1480n();
        int length = this.f1289b.length;
        for (int i = 0; i < length; i++) {
            this.f1289b[i] = (C0124a) n.mo1369b(this.f1289b[i]);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        boolean a = aVar.mo1741a();
        int length = this.f1289b.length;
        if (a) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1382g());
            sb.append(" annotation set");
            aVar.mo1739a(0, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  size: ");
            sb2.append(C0295i.m2044a(length));
            aVar.mo1739a(4, sb2.toString());
        }
        aVar.mo1755d(length);
        for (int i = 0; i < length; i++) {
            int e = this.f1289b[i].mo1379e();
            if (a) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("  entries[");
                sb3.append(Integer.toHexString(i));
                sb3.append("]: ");
                sb3.append(C0295i.m2044a(e));
                aVar.mo1739a(4, sb3.toString());
                this.f1289b[i].mo1341a(aVar, "    ");
            }
            aVar.mo1755d(e);
        }
    }

    /* renamed from: b */
    public String mo1343b() {
        return this.f1288a.toString();
    }

    public int hashCode() {
        return this.f1288a.hashCode();
    }
}
