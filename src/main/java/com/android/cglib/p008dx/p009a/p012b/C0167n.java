package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p017b.C0229a;
import com.android.cglib.p008dx.p015c.p018c.C0265j;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import com.android.cglib.p008dx.p020d.C0300n;

/* renamed from: com.android.cglib.dx.a.b.n */
public final class C0167n extends C0168o implements Comparable<C0167n> {

    /* renamed from: a */
    private final C0265j f1366a;

    public C0167n(C0265j jVar, int i) {
        super(i);
        if (jVar == null) {
            throw new NullPointerException("field == null");
        }
        this.f1366a = jVar;
    }

    /* renamed from: a */
    public int mo1485a(C0165l lVar, C0286a aVar, int i, int i2) {
        int b = lVar.mo1478l().mo1509b(this.f1366a);
        int i3 = b - i;
        int c = mo1493c();
        if (aVar.mo1741a()) {
            aVar.mo1739a(0, String.format("  [%x] %s", new Object[]{Integer.valueOf(i2), this.f1366a.mo1218a_()}));
            int a = C0300n.m2071a(i3);
            StringBuilder sb = new StringBuilder();
            sb.append("    field_idx:    ");
            sb.append(C0295i.m2044a(b));
            aVar.mo1739a(a, sb.toString());
            int a2 = C0300n.m2071a(c);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("    access_flags: ");
            sb2.append(C0229a.m1660b(c));
            aVar.mo1739a(a2, sb2.toString());
        }
        aVar.mo1756e(i3);
        aVar.mo1756e(c);
        return b;
    }

    /* renamed from: a */
    public int compareTo(C0167n nVar) {
        return this.f1366a.compareTo(nVar.f1366a);
    }

    /* renamed from: a */
    public void mo1487a(C0165l lVar) {
        lVar.mo1478l().mo1506a(this.f1366a);
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return this.f1366a.mo1218a_();
    }

    /* renamed from: b */
    public C0265j mo1488b() {
        return this.f1366a;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C0167n)) {
            return false;
        }
        if (compareTo((C0167n) obj) == 0) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.f1366a.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(C0295i.m2048c(mo1493c()));
        stringBuffer.append(' ');
        stringBuffer.append(this.f1366a);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
