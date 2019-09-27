package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p016a.C0225a;
import com.android.cglib.p008dx.p015c.p016a.C0226b;
import com.android.cglib.p008dx.p015c.p016a.C0228d;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0289d;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.android.cglib.dx.a.b.a */
public final class C0124a extends C0136ag {

    /* renamed from: a */
    private static final C0126a f1238a = new C0126a();

    /* renamed from: b */
    private final C0225a f1239b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0146ap f1240c;

    /* renamed from: d */
    private byte[] f1241d;

    /* renamed from: com.android.cglib.dx.a.b.a$a */
    private static class C0126a implements Comparator<C0124a> {
        private C0126a() {
        }

        /* renamed from: a */
        public int compare(C0124a aVar, C0124a aVar2) {
            int g = aVar.f1240c.mo1513g();
            int g2 = aVar2.f1240c.mo1513g();
            if (g < g2) {
                return -1;
            }
            return g > g2 ? 1 : 0;
        }
    }

    /* renamed from: a */
    public static void m1310a(C0124a[] aVarArr) {
        Arrays.sort(aVarArr, f1238a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo1337a(C0136ag agVar) {
        return this.f1239b.compareTo(((C0124a) agVar).f1239b);
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_ANNOTATION_ITEM;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1339a(C0140ak akVar, int i) {
        C0289d dVar = new C0289d();
        new C0151au(akVar.mo1396e(), dVar).mo1427a(this.f1239b, false);
        this.f1241d = dVar.mo1759f();
        mo1375a(this.f1241d.length + 1);
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        this.f1240c = lVar.mo1476j().mo1417a(this.f1239b.mo1522b());
        C0151au.m1452a(lVar, this.f1239b);
    }

    /* renamed from: a */
    public void mo1341a(C0286a aVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("visibility: ");
        sb.append(this.f1239b.mo1523c().mo1218a_());
        aVar.mo1739a(0, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("type: ");
        sb2.append(this.f1239b.mo1522b().mo1218a_());
        aVar.mo1739a(0, sb2.toString());
        for (C0228d dVar : this.f1239b.mo1525d()) {
            C0277v a = dVar.mo1535a();
            C0255a b = dVar.mo1536b();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(a.mo1218a_());
            sb3.append(": ");
            sb3.append(C0151au.m1454b(b));
            aVar.mo1739a(0, sb3.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        boolean a = aVar.mo1741a();
        C0226b c = this.f1239b.mo1523c();
        if (a) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1382g());
            sb.append(" annotation");
            aVar.mo1739a(0, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  visibility: VISBILITY_");
            sb2.append(c);
            aVar.mo1739a(1, sb2.toString());
        }
        switch (c) {
            case BUILD:
                aVar.mo1753b(0);
                break;
            case RUNTIME:
                aVar.mo1753b(1);
                break;
            case SYSTEM:
                aVar.mo1753b(2);
                break;
            default:
                throw new RuntimeException("shouldn't happen");
        }
        if (a) {
            new C0151au(lVar, aVar).mo1427a(this.f1239b, true);
        } else {
            aVar.mo1751a(this.f1241d);
        }
    }

    /* renamed from: b */
    public String mo1343b() {
        return this.f1239b.mo1218a_();
    }

    public int hashCode() {
        return this.f1239b.hashCode();
    }
}
