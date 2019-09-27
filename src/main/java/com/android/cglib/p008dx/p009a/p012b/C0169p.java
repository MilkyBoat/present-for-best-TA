package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p009a.p010a.C0095g;
import com.android.cglib.p008dx.p015c.p017b.C0229a;
import com.android.cglib.p008dx.p015c.p018c.C0259d;
import com.android.cglib.p008dx.p015c.p018c.C0274s;
import com.android.cglib.p008dx.p015c.p019d.C0285e;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import com.android.cglib.p008dx.p020d.C0300n;

/* renamed from: com.android.cglib.dx.a.b.p */
public final class C0169p extends C0168o implements Comparable<C0169p> {

    /* renamed from: a */
    private final C0274s f1368a;

    /* renamed from: b */
    private final C0159i f1369b;

    public C0169p(C0274s sVar, int i, C0095g gVar, C0285e eVar) {
        super(i);
        if (sVar == null) {
            throw new NullPointerException("method == null");
        }
        this.f1368a = sVar;
        if (gVar == null) {
            this.f1369b = null;
        } else {
            this.f1369b = new C0159i(sVar, gVar, (i & 8) != 0, eVar);
        }
    }

    /* renamed from: a */
    public int mo1485a(C0165l lVar, C0286a aVar, int i, int i2) {
        int b = lVar.mo1479m().mo1364b(this.f1368a);
        int i3 = b - i;
        int c = mo1493c();
        int b2 = C0136ag.m1350b(this.f1369b);
        if ((b2 != 0) != ((c & 1280) == 0)) {
            throw new UnsupportedOperationException("code vs. access_flags mismatch");
        }
        if (aVar.mo1741a()) {
            aVar.mo1739a(0, String.format("  [%x] %s", new Object[]{Integer.valueOf(i2), this.f1368a.mo1218a_()}));
            int a = C0300n.m2071a(i3);
            StringBuilder sb = new StringBuilder();
            sb.append("    method_idx:   ");
            sb.append(C0295i.m2044a(b));
            aVar.mo1739a(a, sb.toString());
            int a2 = C0300n.m2071a(c);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("    access_flags: ");
            sb2.append(C0229a.m1661c(c));
            aVar.mo1739a(a2, sb2.toString());
            int a3 = C0300n.m2071a(b2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("    code_off:     ");
            sb3.append(C0295i.m2044a(b2));
            aVar.mo1739a(a3, sb3.toString());
        }
        aVar.mo1756e(i3);
        aVar.mo1756e(c);
        aVar.mo1756e(b2);
        return b;
    }

    /* renamed from: a */
    public int compareTo(C0169p pVar) {
        return this.f1368a.compareTo(pVar.f1368a);
    }

    /* renamed from: a */
    public void mo1495a(C0165l lVar) {
        C0131ae m = lVar.mo1479m();
        C0132af d = lVar.mo1470d();
        m.mo1360a((C0259d) this.f1368a);
        if (this.f1369b != null) {
            d.mo1366a((C0136ag) this.f1369b);
        }
    }

    /* renamed from: a_ */
    public final String mo1218a_() {
        return this.f1368a.mo1218a_();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C0169p)) {
            return false;
        }
        if (compareTo((C0169p) obj) == 0) {
            z = true;
        }
        return z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(C0295i.m2048c(mo1493c()));
        stringBuffer.append(' ');
        stringBuffer.append(this.f1368a);
        if (this.f1369b != null) {
            stringBuffer.append(' ');
            stringBuffer.append(this.f1369b);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
