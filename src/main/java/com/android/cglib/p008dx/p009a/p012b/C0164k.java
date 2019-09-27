package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p009a.p010a.C0095g;
import com.android.cglib.p008dx.p009a.p010a.C0098i;
import com.android.cglib.p008dx.p009a.p010a.C0105p;
import com.android.cglib.p008dx.p009a.p010a.C0113u;
import com.android.cglib.p008dx.p015c.p018c.C0274s;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0293g;
import java.io.PrintWriter;

/* renamed from: com.android.cglib.dx.a.b.k */
public class C0164k extends C0136ag {

    /* renamed from: a */
    private final C0095g f1343a;

    /* renamed from: b */
    private byte[] f1344b;

    /* renamed from: c */
    private final boolean f1345c;

    /* renamed from: d */
    private final C0274s f1346d;

    public C0164k(C0095g gVar, boolean z, C0274s sVar) {
        super(1, -1);
        if (gVar == null) {
            throw new NullPointerException("code == null");
        }
        this.f1343a = gVar;
        this.f1345c = z;
        this.f1346d = sVar;
    }

    /* renamed from: a */
    private byte[] m1553a(C0165l lVar, String str, PrintWriter printWriter, C0286a aVar, boolean z) {
        return m1554b(lVar, str, printWriter, aVar, z);
    }

    /* renamed from: b */
    private byte[] m1554b(C0165l lVar, String str, PrintWriter printWriter, C0286a aVar, boolean z) {
        C0113u h = this.f1343a.mo1253h();
        C0105p i = this.f1343a.mo1254i();
        C0098i f = this.f1343a.mo1251f();
        C0161j jVar = new C0161j(h, i, lVar, f.mo1274b(), f.mo1275c(), this.f1345c, this.f1346d);
        return (printWriter == null && aVar == null) ? jVar.mo1454a() : jVar.mo1455a(str, printWriter, aVar, z);
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_DEBUG_INFO_ITEM;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1339a(C0140ak akVar, int i) {
        try {
            this.f1344b = m1553a(akVar.mo1396e(), null, null, null, false);
            mo1375a(this.f1344b.length);
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("...while placing debug info for ");
            sb.append(this.f1346d.mo1218a_());
            throw C0293g.m2033a(e, sb.toString());
        }
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
    }

    /* renamed from: a */
    public void mo1462a(C0165l lVar, C0286a aVar, String str) {
        m1553a(lVar, str, null, aVar, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1382g());
            sb.append(" debug info");
            aVar.mo1740a(sb.toString());
            m1553a(lVar, null, null, aVar, true);
        }
        aVar.mo1751a(this.f1344b);
    }

    /* renamed from: b */
    public String mo1343b() {
        throw new RuntimeException("unsupported");
    }
}
