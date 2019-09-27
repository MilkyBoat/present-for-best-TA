package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p009a.C0123b;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0259d;
import com.android.cglib.p008dx.p015c.p018c.C0264i;
import com.android.cglib.p008dx.p015c.p018c.C0265j;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0289d;
import com.android.cglib.p008dx.p020d.C0293g;
import java.io.Writer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Adler32;

/* renamed from: com.android.cglib.dx.a.b.l */
public final class C0165l {

    /* renamed from: a */
    private C0123b f1347a;

    /* renamed from: b */
    private final C0132af f1348b = new C0132af("word_data", this, 4, C0135a.TYPE);

    /* renamed from: c */
    private final C0132af f1349c = new C0132af(null, this, 4, C0135a.NONE);

    /* renamed from: d */
    private final C0132af f1350d = new C0132af("map", this, 4, C0135a.NONE);

    /* renamed from: e */
    private final C0132af f1351e = new C0132af("string_data", this, 1, C0135a.INSTANCE);

    /* renamed from: f */
    private final C0145ao f1352f = new C0145ao(this);

    /* renamed from: g */
    private final C0147aq f1353g = new C0147aq(this);

    /* renamed from: h */
    private final C0139aj f1354h = new C0139aj(this);

    /* renamed from: i */
    private final C0172s f1355i = new C0172s(this);

    /* renamed from: j */
    private final C0131ae f1356j = new C0131ae(this);

    /* renamed from: k */
    private final C0158h f1357k = new C0158h(this);

    /* renamed from: l */
    private final C0132af f1358l = new C0132af(null, this, 1, C0135a.NONE);

    /* renamed from: m */
    private final C0132af f1359m = new C0132af("byte_data", this, 1, C0135a.TYPE);

    /* renamed from: n */
    private final C0174u f1360n = new C0174u(this);

    /* renamed from: o */
    private final C0140ak[] f1361o = {this.f1360n, this.f1352f, this.f1353g, this.f1354h, this.f1355i, this.f1356j, this.f1357k, this.f1348b, this.f1349c, this.f1351e, this.f1359m, this.f1358l, this.f1350d};

    /* renamed from: p */
    private int f1362p = -1;

    /* renamed from: q */
    private int f1363q = 79;

    public C0165l(C0123b bVar) {
        this.f1347a = bVar;
    }

    /* renamed from: a */
    private C0289d m1561a(boolean z, boolean z2) {
        this.f1357k.mo1399h();
        this.f1358l.mo1399h();
        this.f1348b.mo1399h();
        this.f1359m.mo1399h();
        this.f1356j.mo1399h();
        this.f1355i.mo1399h();
        this.f1354h.mo1399h();
        this.f1349c.mo1399h();
        this.f1353g.mo1399h();
        this.f1352f.mo1399h();
        this.f1351e.mo1399h();
        this.f1360n.mo1399h();
        int length = this.f1361o.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            C0140ak akVar = this.f1361o[i2];
            int b = akVar.mo1392b(i3);
            if (b < i3) {
                StringBuilder sb = new StringBuilder();
                sb.append("bogus placement for section ");
                sb.append(i2);
                throw new RuntimeException(sb.toString());
            }
            try {
                if (akVar == this.f1350d) {
                    C0179z.m1636a(this.f1361o, this.f1350d);
                    this.f1350d.mo1399h();
                }
                if (akVar instanceof C0132af) {
                    ((C0132af) akVar).mo1372d();
                }
                i3 = akVar.mo1371c_() + b;
                i2++;
            } catch (RuntimeException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("...while writing section ");
                sb2.append(i2);
                throw C0293g.m2033a(e, sb2.toString());
            }
        }
        this.f1362p = i3;
        byte[] bArr = new byte[this.f1362p];
        C0289d dVar = new C0289d(bArr);
        if (z) {
            dVar.mo1748a(this.f1363q, z2);
        }
        while (i < length) {
            try {
                C0140ak akVar2 = this.f1361o[i];
                int g = akVar2.mo1398g() - dVar.mo1760g();
                if (g < 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("excess write of ");
                    sb3.append(-g);
                    throw new C0293g(sb3.toString());
                }
                dVar.mo1761g(akVar2.mo1398g() - dVar.mo1760g());
                akVar2.mo1394c((C0286a) dVar);
                i++;
            } catch (RuntimeException e2) {
                C0293g gVar = e2 instanceof C0293g ? (C0293g) e2 : new C0293g((Throwable) e2);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("...while writing section ");
                sb4.append(i);
                gVar.mo1769a(sb4.toString());
                throw gVar;
            }
        }
        if (dVar.mo1760g() != this.f1362p) {
            throw new RuntimeException("foreshortened write");
        }
        m1562a(bArr);
        m1563b(bArr);
        if (z) {
            this.f1348b.mo1367a(dVar, C0178y.TYPE_CODE_ITEM, "\nmethod code index:\n\n");
            mo1483q().mo1404a((C0286a) dVar);
            dVar.mo1762h();
        }
        return dVar;
    }

    /* renamed from: a */
    private static void m1562a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr, 32, bArr.length - 32);
            try {
                int digest = instance.digest(bArr, 12, 20);
                if (digest != 20) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unexpected digest write: ");
                    sb.append(digest);
                    sb.append(" bytes");
                    throw new RuntimeException(sb.toString());
                }
            } catch (DigestException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: b */
    private static void m1563b(byte[] bArr) {
        Adler32 adler32 = new Adler32();
        adler32.update(bArr, 12, bArr.length - 12);
        int value = (int) adler32.getValue();
        bArr[8] = (byte) value;
        bArr[9] = (byte) (value >> 8);
        bArr[10] = (byte) (value >> 16);
        bArr[11] = (byte) (value >> 24);
    }

    /* renamed from: a */
    public C0123b mo1463a() {
        return this.f1347a;
    }

    /* renamed from: a */
    public void mo1464a(C0157g gVar) {
        this.f1357k.mo1451a(gVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo1465a(C0255a aVar) {
        C0172s sVar;
        C0265j f;
        if (aVar instanceof C0277v) {
            this.f1352f.mo1413a((C0277v) aVar);
        } else if (aVar instanceof C0278w) {
            this.f1353g.mo1417a((C0278w) aVar);
        } else if (aVar instanceof C0259d) {
            this.f1356j.mo1360a((C0259d) aVar);
        } else {
            if (aVar instanceof C0265j) {
                sVar = this.f1355i;
                f = (C0265j) aVar;
            } else if (aVar instanceof C0264i) {
                sVar = this.f1355i;
                f = ((C0264i) aVar).mo1669f();
            } else if (aVar == null) {
                throw new NullPointerException("cst == null");
            } else {
                return;
            }
            sVar.mo1506a(f);
        }
    }

    /* renamed from: a */
    public byte[] mo1466a(Writer writer, boolean z) {
        boolean z2 = writer != null;
        C0289d a = m1561a(z2, z);
        if (z2) {
            a.mo1750a(writer);
        }
        return a.mo1757e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo1467b() {
        if (this.f1362p >= 0) {
            return this.f1362p;
        }
        throw new RuntimeException("file size not yet known");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0176w mo1468b(C0255a aVar) {
        if (aVar instanceof C0277v) {
            return this.f1352f.mo1414a(aVar);
        }
        if (aVar instanceof C0278w) {
            return this.f1353g.mo1419a(aVar);
        }
        if (aVar instanceof C0259d) {
            return this.f1356j.mo1361a(aVar);
        }
        if (aVar instanceof C0265j) {
            return this.f1355i.mo1507a(aVar);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C0132af mo1469c() {
        return this.f1351e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C0132af mo1470d() {
        return this.f1348b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C0132af mo1471e() {
        return this.f1349c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C0132af mo1472f() {
        return this.f1350d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public C0145ao mo1473g() {
        return this.f1352f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public C0158h mo1474h() {
        return this.f1357k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public C0132af mo1475i() {
        return this.f1358l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public C0147aq mo1476j() {
        return this.f1353g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public C0139aj mo1477k() {
        return this.f1354h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public C0172s mo1478l() {
        return this.f1355i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public C0131ae mo1479m() {
        return this.f1356j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public C0132af mo1480n() {
        return this.f1359m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public C0140ak mo1481o() {
        return this.f1348b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public C0140ak mo1482p() {
        return this.f1350d;
    }

    /* renamed from: q */
    public C0141al mo1483q() {
        C0141al alVar = new C0141al();
        for (C0140ak a : this.f1361o) {
            alVar.mo1402a(a);
        }
        return alVar;
    }
}
