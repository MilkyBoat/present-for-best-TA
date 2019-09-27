package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p009a.p012b.C0136ag;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import java.util.List;

/* renamed from: com.android.cglib.dx.a.b.at */
public final class C0150at<T extends C0136ag> extends C0136ag {

    /* renamed from: a */
    private final C0178y f1284a;

    /* renamed from: b */
    private final List<T> f1285b;

    public C0150at(C0178y yVar, List<T> list) {
        super(m1442a(list), m1443b(list));
        if (yVar == null) {
            throw new NullPointerException("itemType == null");
        }
        this.f1285b = list;
        this.f1284a = yVar;
    }

    /* renamed from: a */
    private static int m1442a(List<? extends C0136ag> list) {
        try {
            return Math.max(4, ((C0136ag) list.get(0)).mo1381f());
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("items.size() == 0");
        } catch (NullPointerException unused2) {
            throw new NullPointerException("items == null");
        }
    }

    /* renamed from: b */
    private static int m1443b(List<? extends C0136ag> list) {
        return (list.size() * ((C0136ag) list.get(0)).mo1349b_()) + m1442a(list);
    }

    /* renamed from: d */
    private int m1444d() {
        return mo1381f();
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return this.f1284a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1339a(C0140ak akVar, int i) {
        int d = i + m1444d();
        int i2 = -1;
        boolean z = true;
        int i3 = d;
        int i4 = -1;
        for (T t : this.f1285b) {
            int b_ = t.mo1349b_();
            if (z) {
                i4 = t.mo1381f();
                i2 = b_;
                z = false;
            } else if (b_ != i2) {
                throw new UnsupportedOperationException("item size mismatch");
            } else if (t.mo1381f() != i4) {
                throw new UnsupportedOperationException("item alignment mismatch");
            }
            i3 = t.mo1376b(akVar, i3) + b_;
        }
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        for (T a : this.f1285b) {
            a.mo1340a(lVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        int size = this.f1285b.size();
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1382g());
            sb.append(" ");
            sb.append(mo1515i());
            aVar.mo1739a(0, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  size: ");
            sb2.append(C0295i.m2044a(size));
            aVar.mo1739a(4, sb2.toString());
        }
        aVar.mo1755d(size);
        for (T a : this.f1285b) {
            a.mo1347a(lVar, aVar);
        }
    }

    /* renamed from: b */
    public final String mo1343b() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("{");
        boolean z = true;
        for (T t : this.f1285b) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(", ");
            }
            stringBuffer.append(t.mo1343b());
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    /* renamed from: c */
    public final List<T> mo1425c() {
        return this.f1285b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append(this.f1285b);
        return stringBuffer.toString();
    }
}
