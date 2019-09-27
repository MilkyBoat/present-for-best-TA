package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p009a.C0123b;
import com.android.cglib.p008dx.p015c.p017b.C0230b;
import com.android.cglib.p008dx.p015c.p017b.C0231c;
import com.android.cglib.p008dx.p015c.p017b.C0235f;
import com.android.cglib.p008dx.p015c.p017b.C0235f.C0236a;
import com.android.cglib.p008dx.p015c.p017b.C0235f.C0237b;
import com.android.cglib.p008dx.p015c.p017b.C0240i;
import com.android.cglib.p008dx.p015c.p017b.C0241j;
import com.android.cglib.p008dx.p015c.p017b.C0242k;
import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p017b.C0249p;
import com.android.cglib.p008dx.p015c.p017b.C0250q;
import com.android.cglib.p008dx.p015c.p017b.C0252s;
import com.android.cglib.p008dx.p015c.p017b.C0253t;
import com.android.cglib.p008dx.p015c.p017b.C0254u;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0267l;
import com.android.cglib.p008dx.p020d.C0287b;
import com.android.cglib.p008dx.p020d.C0297k;

/* renamed from: com.android.cglib.dx.a.a.w */
public final class C0116w {

    /* renamed from: a */
    private final C0123b f1213a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0250q f1214b;

    /* renamed from: c */
    private final int f1215c;

    /* renamed from: d */
    private final C0240i f1216d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C0057a f1217e;

    /* renamed from: f */
    private final C0111s f1218f;

    /* renamed from: g */
    private final C0119b f1219g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final int f1220h;

    /* renamed from: i */
    private int[] f1221i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final int f1222j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f1223k;

    /* renamed from: com.android.cglib.dx.a.a.w$a */
    private class C0118a extends C0119b {

        /* renamed from: c */
        private C0240i f1228c;

        public C0118a(C0111s sVar, C0240i iVar) {
            super(sVar);
            this.f1228c = iVar;
        }

        /* renamed from: a */
        public void mo1324a(C0235f fVar) {
            C0244m a = this.f1228c.mo1583a(fVar);
            if (a != null) {
                mo1328a((C0097h) new C0110r(fVar.mo1564e(), a));
            }
        }

        /* renamed from: a */
        public void mo1323a(C0241j jVar) {
            super.mo1323a(jVar);
            mo1324a((C0235f) jVar);
        }

        /* renamed from: a */
        public void mo1325a(C0242k kVar) {
            super.mo1325a(kVar);
            mo1324a((C0235f) kVar);
        }

        /* renamed from: a */
        public void mo1326a(C0253t tVar) {
            super.mo1326a(tVar);
            mo1324a((C0235f) tVar);
        }

        /* renamed from: a */
        public void mo1327a(C0254u uVar) {
            super.mo1327a(uVar);
            mo1324a((C0235f) uVar);
        }
    }

    /* renamed from: com.android.cglib.dx.a.a.w$b */
    private class C0119b implements C0237b {

        /* renamed from: a */
        private final C0111s f1229a;

        /* renamed from: c */
        private C0230b f1231c;

        /* renamed from: d */
        private C0093e f1232d;

        public C0119b(C0111s sVar) {
            this.f1229a = sVar;
        }

        /* renamed from: a */
        private C0244m m1282a() {
            int d = this.f1231c.mo1544d();
            if (d < 0) {
                return null;
            }
            C0235f a = C0116w.this.f1214b.mo1637a().mo1555b(d).mo1542b().mo1215a(0);
            if (a.mo1563d().mo1628a() != 56) {
                return null;
            }
            return a.mo1566f();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo1328a(C0097h hVar) {
            this.f1229a.mo1312a(hVar);
        }

        /* renamed from: a */
        public void mo1329a(C0230b bVar, C0093e eVar) {
            this.f1231c = bVar;
            this.f1232d = eVar;
        }

        /* renamed from: a */
        public void mo1323a(C0241j jVar) {
            C0097h hVar;
            C0252s e = jVar.mo1564e();
            C0099j a = C0115v.m1260a(jVar);
            C0249p d = jVar.mo1563d();
            int a2 = d.mo1628a();
            if (d.mo1629b() != 1) {
                throw new RuntimeException("shouldn't happen");
            }
            if (a2 != 3) {
                hVar = new C0094f(a, e, C0116w.m1268b((C0235f) jVar), jVar.mo1559c());
            } else if (!C0116w.this.f1223k) {
                C0244m f = jVar.mo1566f();
                hVar = new C0120x(a, e, C0247n.m1754a(f, C0244m.m1722a((C0116w.this.f1220h - C0116w.this.f1222j) + ((C0267l) jVar.mo1559c()).mo1671e_(), f.mo1589b())));
            } else {
                return;
            }
            mo1328a(hVar);
        }

        /* renamed from: a */
        public void mo1325a(C0242k kVar) {
            C0097h hVar;
            C0249p d = kVar.mo1563d();
            if (d.mo1628a() != 54 && d.mo1628a() != 56) {
                C0252s e = kVar.mo1564e();
                C0099j a = C0115v.m1260a(kVar);
                int b = d.mo1629b();
                if (b != 6) {
                    switch (b) {
                        case 1:
                        case 2:
                            break;
                        case 3:
                            return;
                        case 4:
                            hVar = new C0122z(a, e, C0116w.m1268b((C0235f) kVar), C0116w.this.f1217e.mo1196a(this.f1231c.mo1543c().mo1785a(1)));
                            break;
                        default:
                            throw new RuntimeException("shouldn't happen");
                    }
                }
                hVar = new C0120x(a, e, C0116w.m1268b((C0235f) kVar));
                mo1328a(hVar);
            }
        }

        /* renamed from: a */
        public void mo1326a(C0253t tVar) {
            C0252s e = tVar.mo1564e();
            C0099j a = C0115v.m1260a(tVar);
            C0249p d = tVar.mo1563d();
            C0255a c = tVar.mo1559c();
            if (d.mo1629b() != 6) {
                throw new RuntimeException("shouldn't happen");
            }
            mo1328a((C0097h) this.f1232d);
            if (d.mo1630c()) {
                mo1328a((C0097h) new C0094f(a, e, tVar.mo1567g(), c));
                return;
            }
            C0244m a2 = m1282a();
            C0247n a3 = C0116w.m1269b(tVar, a2);
            boolean z = true;
            boolean z2 = a.mo1280d() || d.mo1628a() == 43;
            if (a2 == null) {
                z = false;
            }
            if (z2 != z) {
                StringBuilder sb = new StringBuilder();
                sb.append("Insn with result/move-result-pseudo mismatch ");
                sb.append(tVar);
                throw new RuntimeException(sb.toString());
            }
            mo1328a((d.mo1628a() != 41 || a.mo1277a() == 35) ? new C0094f(a, e, a3, c) : new C0120x(a, e, a3));
        }

        /* renamed from: a */
        public void mo1327a(C0254u uVar) {
            C0252s e = uVar.mo1564e();
            C0099j a = C0115v.m1260a(uVar);
            if (uVar.mo1563d().mo1629b() != 6) {
                throw new RuntimeException("shouldn't happen");
            }
            C0244m a2 = m1282a();
            if (a.mo1280d() != (a2 != null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Insn with result/move-result-pseudo mismatch");
                sb.append(uVar);
                throw new RuntimeException(sb.toString());
            }
            mo1328a((C0097h) this.f1232d);
            mo1328a((C0097h) new C0120x(a, e, C0116w.m1269b(uVar, a2)));
        }
    }

    private C0116w(C0250q qVar, int i, C0240i iVar, int i2, C0123b bVar) {
        this.f1213a = bVar;
        this.f1214b = qVar;
        this.f1215c = i;
        this.f1216d = iVar;
        this.f1217e = new C0057a(qVar);
        this.f1222j = i2;
        this.f1223k = m1267a(qVar, i2);
        C0231c a = qVar.mo1637a();
        int a2 = a.mo1772a();
        int i3 = a2 * 3;
        int c = a.mo1556c() + i3;
        if (iVar != null) {
            c += a2 + iVar.mo1582a();
        }
        this.f1220h = a.mo1554b() + (this.f1223k ? 0 : this.f1222j);
        this.f1218f = new C0111s(bVar, c, i3, this.f1220h);
        this.f1219g = iVar != null ? new C0118a(this.f1218f, iVar) : new C0119b(this.f1218f);
    }

    /* renamed from: a */
    private C0095g m1262a() {
        m1273c();
        m1270b();
        return new C0095g(this.f1215c, this.f1218f.mo1310a(), new C0121y(this.f1214b, this.f1221i, this.f1217e));
    }

    /* renamed from: a */
    public static C0095g m1263a(C0250q qVar, int i, C0240i iVar, int i2, C0123b bVar) {
        C0116w wVar = new C0116w(qVar, i, iVar, i2, bVar);
        return wVar.m1262a();
    }

    /* renamed from: a */
    private void m1266a(C0230b bVar, int i) {
        C0093e a = this.f1217e.mo1197a(bVar);
        this.f1218f.mo1312a(a);
        if (this.f1216d != null) {
            this.f1218f.mo1312a(new C0109q(a.mo1265h(), this.f1216d.mo1585a(bVar)));
        }
        this.f1219g.mo1329a(bVar, this.f1217e.mo1198b(bVar));
        bVar.mo1542b().mo1573a((C0237b) this.f1219g);
        this.f1218f.mo1312a(this.f1217e.mo1199c(bVar));
        int d = bVar.mo1544d();
        C0235f f = bVar.mo1547f();
        if (d >= 0 && d != i) {
            if (f.mo1563d().mo1629b() == 4 && bVar.mo1545e() == i) {
                this.f1218f.mo1311a(1, this.f1217e.mo1196a(d));
            } else {
                this.f1218f.mo1312a(new C0122z(C0100k.f935P, f.mo1564e(), C0247n.f1778a, this.f1217e.mo1196a(d)));
            }
        }
    }

    /* renamed from: a */
    private static boolean m1267a(C0250q qVar, final int i) {
        final boolean[] zArr = {true};
        final int b = qVar.mo1637a().mo1554b();
        qVar.mo1637a().mo1553a((C0237b) new C0236a() {
            /* renamed from: a */
            public void mo1323a(C0241j jVar) {
                if (jVar.mo1563d().mo1628a() == 3) {
                    zArr[0] = zArr[0] && (b - i) + ((C0267l) jVar.mo1559c()).mo1671e_() == jVar.mo1566f().mo1596e();
                }
            }
        });
        return zArr[0];
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static C0247n m1268b(C0235f fVar) {
        return m1269b(fVar, fVar.mo1566f());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static C0247n m1269b(C0235f fVar, C0244m mVar) {
        C0247n g = fVar.mo1567g();
        if (fVar.mo1563d().mo1631d() && g.mo1772a() == 2 && mVar.mo1596e() == g.mo1614b(1).mo1596e()) {
            g = C0247n.m1754a(g.mo1614b(1), g.mo1614b(0));
        }
        return mVar == null ? g : g.mo1615b(mVar);
    }

    /* renamed from: b */
    private void m1270b() {
        C0231c a = this.f1214b.mo1637a();
        int[] iArr = this.f1221i;
        int length = iArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            m1266a(a.mo1555b(iArr[i]), i2 == iArr.length ? -1 : iArr[i2]);
            i = i2;
        }
    }

    /* renamed from: c */
    private void m1273c() {
        int i;
        C0231c a = this.f1214b.mo1637a();
        int a2 = a.mo1772a();
        int d = a.mo1798d();
        int[] a3 = C0287b.m1996a(d);
        int[] a4 = C0287b.m1996a(d);
        for (int i2 = 0; i2 < a2; i2++) {
            C0287b.m1997b(a3, a.mo1215a(i2).mo1541a());
        }
        int[] iArr = new int[a2];
        int b = this.f1214b.mo1639b();
        int i3 = 0;
        while (b != -1) {
            while (true) {
                C0297k a5 = this.f1214b.mo1638a(i);
                int a6 = a5.mo1784a();
                int i4 = 0;
                while (i4 < a6) {
                    int a7 = a5.mo1785a(i4);
                    if (C0287b.m1995a(a4, a7)) {
                        break;
                    } else if (C0287b.m1995a(a3, a7) && a.mo1555b(a7).mo1544d() == i) {
                        C0287b.m1997b(a4, a7);
                        b = a7;
                    } else {
                        i4++;
                    }
                }
                break;
            }
            while (i != -1) {
                C0287b.m1998c(a3, i);
                C0287b.m1998c(a4, i);
                iArr[i3] = i;
                i3++;
                C0230b b2 = a.mo1555b(i);
                C0230b a8 = a.mo1551a(b2);
                if (a8 == null) {
                    break;
                }
                int a9 = a8.mo1541a();
                int d2 = b2.mo1544d();
                if (C0287b.m1995a(a3, a9)) {
                    i = a9;
                } else if (d2 == a9 || d2 < 0 || !C0287b.m1995a(a3, d2)) {
                    C0297k c = b2.mo1543c();
                    int a10 = c.mo1784a();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= a10) {
                            i = -1;
                            break;
                        }
                        int a11 = c.mo1785a(i5);
                        if (C0287b.m1995a(a3, a11)) {
                            i = a11;
                            break;
                        }
                        i5++;
                    }
                } else {
                    i = d2;
                }
            }
            b = C0287b.m1999d(a3, 0);
        }
        if (i3 != a2) {
            throw new RuntimeException("shouldn't happen");
        }
        this.f1221i = iArr;
    }
}
