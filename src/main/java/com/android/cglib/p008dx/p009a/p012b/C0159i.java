package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p009a.p010a.C0095g;
import com.android.cglib.p008dx.p009a.p010a.C0095g.C0096a;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0274s;
import com.android.cglib.p008dx.p015c.p019d.C0282b;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p015c.p019d.C0285e;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0293g;
import com.android.cglib.p008dx.p020d.C0295i;
import java.util.Iterator;

/* renamed from: com.android.cglib.dx.a.b.i */
public final class C0159i extends C0136ag {

    /* renamed from: a */
    private final C0274s f1318a;

    /* renamed from: b */
    private final C0095g f1319b;

    /* renamed from: c */
    private C0155e f1320c;

    /* renamed from: d */
    private final boolean f1321d;

    /* renamed from: e */
    private final C0285e f1322e;

    /* renamed from: f */
    private C0164k f1323f;

    public C0159i(C0274s sVar, C0095g gVar, boolean z, C0285e eVar) {
        super(4, -1);
        if (sVar == null) {
            throw new NullPointerException("ref == null");
        } else if (gVar == null) {
            throw new NullPointerException("code == null");
        } else if (eVar == null) {
            throw new NullPointerException("throwsList == null");
        } else {
            this.f1318a = sVar;
            this.f1319b = gVar;
            this.f1321d = z;
            this.f1322e = eVar;
            this.f1320c = null;
            this.f1323f = null;
        }
    }

    /* renamed from: b */
    private void m1518b(C0165l lVar, C0286a aVar) {
        try {
            this.f1319b.mo1251f().mo1273a(aVar);
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("...while writing instructions for ");
            sb.append(this.f1318a.mo1218a_());
            throw C0293g.m2033a(e, sb.toString());
        }
    }

    /* renamed from: c */
    private int m1519c() {
        return this.f1318a.mo1662b(this.f1321d);
    }

    /* renamed from: d */
    private int m1520d() {
        return this.f1319b.mo1251f().mo1276d();
    }

    /* renamed from: h */
    private int m1521h() {
        return this.f1319b.mo1251f().mo1275c();
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_CODE_ITEM;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1339a(C0140ak akVar, int i) {
        int i2;
        final C0165l e = akVar.mo1396e();
        this.f1319b.mo1245a(new C0096a() {
            /* renamed from: a */
            public int mo1255a(C0255a aVar) {
                C0176w b = e.mo1468b(aVar);
                if (b == null) {
                    return -1;
                }
                return b.mo1513g();
            }
        });
        if (this.f1320c != null) {
            this.f1320c.mo1435a(e);
            i2 = this.f1320c.mo1437b();
        } else {
            i2 = 0;
        }
        int b = this.f1319b.mo1251f().mo1274b();
        if ((b & 1) != 0) {
            b++;
        }
        mo1375a((b * 2) + 16 + i2);
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        C0132af n = lVar.mo1480n();
        C0147aq j = lVar.mo1476j();
        if (this.f1319b.mo1246a() || this.f1319b.mo1247b()) {
            this.f1323f = new C0164k(this.f1319b, this.f1321d, this.f1318a);
            n.mo1366a((C0136ag) this.f1323f);
        }
        if (this.f1319b.mo1248c()) {
            Iterator it = this.f1319b.mo1249d().iterator();
            while (it.hasNext()) {
                j.mo1418a((C0283c) it.next());
            }
            this.f1320c = new C0155e(this.f1319b);
        }
        Iterator it2 = this.f1319b.mo1250e().iterator();
        while (it2.hasNext()) {
            lVar.mo1465a((C0255a) it2.next());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        boolean a = aVar.mo1741a();
        int h = m1521h();
        int d = m1520d();
        int c = m1519c();
        int b = this.f1319b.mo1251f().mo1274b();
        boolean z = (b & 1) != 0;
        int a2 = this.f1320c == null ? 0 : this.f1320c.mo1434a();
        int e = this.f1323f == null ? 0 : this.f1323f.mo1379e();
        if (a) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1382g());
            sb.append(' ');
            sb.append(this.f1318a.mo1218a_());
            aVar.mo1739a(0, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  registers_size: ");
            sb2.append(C0295i.m2048c(h));
            aVar.mo1739a(2, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("  ins_size:       ");
            sb3.append(C0295i.m2048c(c));
            aVar.mo1739a(2, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("  outs_size:      ");
            sb4.append(C0295i.m2048c(d));
            aVar.mo1739a(2, sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("  tries_size:     ");
            sb5.append(C0295i.m2048c(a2));
            aVar.mo1739a(2, sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("  debug_off:      ");
            sb6.append(C0295i.m2044a(e));
            aVar.mo1739a(4, sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("  insns_size:     ");
            sb7.append(C0295i.m2044a(b));
            aVar.mo1739a(4, sb7.toString());
            if (this.f1322e.mo1738a() != 0) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("  throws ");
                sb8.append(C0282b.m1959a(this.f1322e));
                aVar.mo1739a(0, sb8.toString());
            }
        }
        aVar.mo1754c(h);
        aVar.mo1754c(c);
        aVar.mo1754c(d);
        aVar.mo1754c(a2);
        aVar.mo1755d(e);
        aVar.mo1755d(b);
        m1518b(lVar, aVar);
        if (this.f1320c != null) {
            if (z) {
                if (a) {
                    aVar.mo1739a(2, "  padding: 0");
                }
                aVar.mo1754c(0);
            }
            this.f1320c.mo1436a(lVar, aVar);
        }
        if (a && this.f1323f != null) {
            aVar.mo1739a(0, "  debug info");
            this.f1323f.mo1462a(lVar, aVar, "    ");
        }
    }

    /* renamed from: b */
    public String mo1343b() {
        return this.f1318a.mo1218a_();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CodeItem{");
        sb.append(mo1343b());
        sb.append("}");
        return sb.toString();
    }
}
