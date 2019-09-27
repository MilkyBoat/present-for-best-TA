package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p009a.p010a.C0105p;
import com.android.cglib.p008dx.p009a.p010a.C0105p.C0106a;
import com.android.cglib.p008dx.p009a.p010a.C0105p.C0107b;
import com.android.cglib.p008dx.p009a.p010a.C0113u;
import com.android.cglib.p008dx.p009a.p010a.C0113u.C0114a;
import com.android.cglib.p008dx.p015c.p018c.C0274s;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p015c.p019d.C0281a;
import com.android.cglib.p008dx.p015c.p019d.C0282b;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0289d;
import com.android.cglib.p008dx.p020d.C0293g;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.android.cglib.dx.a.b.j */
public final class C0161j {

    /* renamed from: a */
    private final C0113u f1326a;

    /* renamed from: b */
    private final C0105p f1327b;

    /* renamed from: c */
    private final C0289d f1328c;

    /* renamed from: d */
    private final C0165l f1329d;

    /* renamed from: e */
    private final int f1330e;

    /* renamed from: f */
    private final int f1331f;

    /* renamed from: g */
    private final C0281a f1332g;

    /* renamed from: h */
    private final boolean f1333h;

    /* renamed from: i */
    private int f1334i = 0;

    /* renamed from: j */
    private int f1335j = 1;

    /* renamed from: k */
    private C0286a f1336k;

    /* renamed from: l */
    private PrintWriter f1337l;

    /* renamed from: m */
    private String f1338m;

    /* renamed from: n */
    private boolean f1339n;

    /* renamed from: o */
    private final C0107b[] f1340o;

    public C0161j(C0113u uVar, C0105p pVar, C0165l lVar, int i, int i2, boolean z, C0274s sVar) {
        this.f1326a = uVar;
        this.f1327b = pVar;
        this.f1329d = lVar;
        this.f1332g = sVar.mo1663f();
        this.f1333h = z;
        this.f1330e = i;
        this.f1331f = i2;
        this.f1328c = new C0289d();
        this.f1340o = new C0107b[i2];
    }

    /* renamed from: a */
    private int m1528a(int i) {
        int a = this.f1327b.mo1772a();
        while (i < a && this.f1327b.mo1215a(i).mo1288a() == this.f1334i) {
            int i2 = i + 1;
            C0107b a2 = this.f1327b.mo1215a(i);
            int g = a2.mo1300g();
            C0107b bVar = this.f1340o[g];
            if (a2 != bVar) {
                this.f1340o[g] = a2;
                if (a2.mo1294c()) {
                    if (bVar == null || !a2.mo1293b(bVar)) {
                        m1542c(a2);
                    } else if (bVar.mo1294c()) {
                        throw new RuntimeException("shouldn't happen");
                    } else {
                        m1538b(a2);
                    }
                } else if (a2.mo1292b() != C0106a.END_REPLACED) {
                    m1547e(a2);
                }
            }
            i = i2;
        }
        return i;
    }

    /* renamed from: a */
    private static int m1529a(int i, int i2) {
        if (i >= -4 && i <= 10) {
            return (i - -4) + (i2 * 15) + 10;
        }
        throw new RuntimeException("Parameter out of range");
    }

    /* renamed from: a */
    private int m1530a(int i, ArrayList<C0114a> arrayList) {
        int size = arrayList.size();
        while (i < size && ((C0114a) arrayList.get(i)).mo1321a() == this.f1334i) {
            int i2 = i + 1;
            m1533a((C0114a) arrayList.get(i));
            i = i2;
        }
        return i;
    }

    /* renamed from: a */
    private String m1531a(C0107b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("v");
        sb.append(bVar.mo1300g());
        sb.append(' ');
        C0277v d = bVar.mo1296d();
        sb.append(d == null ? "null" : d.mo1218a_());
        sb.append(' ');
        C0278w f = bVar.mo1299f();
        sb.append(f == null ? "null" : f.mo1218a_());
        C0277v e = bVar.mo1297e();
        if (e != null) {
            sb.append(' ');
            sb.append(e.mo1218a_());
        }
        return sb.toString();
    }

    /* renamed from: a */
    private void m1532a(int i, String str) {
        if (this.f1338m != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1338m);
            sb.append(str);
            str = sb.toString();
        }
        if (this.f1336k != null) {
            C0286a aVar = this.f1336k;
            if (!this.f1339n) {
                i = 0;
            }
            aVar.mo1739a(i, str);
        }
        if (this.f1337l != null) {
            this.f1337l.println(str);
        }
    }

    /* renamed from: a */
    private void m1533a(C0114a aVar) {
        int a = aVar.mo1322b().mo1640a();
        int i = a - this.f1335j;
        int a2 = aVar.mo1321a() - this.f1334i;
        if (a2 < 0) {
            throw new RuntimeException("Position entries must be in ascending address order");
        }
        if (i < -4 || i > 10) {
            m1537b(i);
            i = 0;
        }
        int a3 = m1529a(i, a2);
        if ((a3 & -256) > 0) {
            m1541c(a2);
            a3 = m1529a(i, 0);
            if ((a3 & -256) > 0) {
                m1537b(i);
                a3 = m1529a(0, 0);
                a2 = 0;
                i = 0;
            } else {
                a2 = 0;
            }
        }
        this.f1328c.mo1753b(a3);
        this.f1335j += i;
        this.f1334i += a2;
        if (this.f1336k != null || this.f1337l != null) {
            m1532a(1, String.format("%04x: line %d", new Object[]{Integer.valueOf(this.f1334i), Integer.valueOf(this.f1335j)}));
        }
    }

    /* renamed from: a */
    private void m1534a(C0277v vVar) {
        if (vVar == null || this.f1329d == null) {
            this.f1328c.mo1756e(0);
        } else {
            this.f1328c.mo1756e(this.f1329d.mo1473g().mo1415b(vVar) + 1);
        }
    }

    /* renamed from: a */
    private void m1535a(C0278w wVar) {
        if (wVar == null || this.f1329d == null) {
            this.f1328c.mo1756e(0);
        } else {
            this.f1328c.mo1756e(this.f1329d.mo1476j().mo1420b(wVar) + 1);
        }
    }

    /* renamed from: a */
    private void m1536a(ArrayList<C0114a> arrayList, ArrayList<C0107b> arrayList2) {
        C0107b[] bVarArr;
        C0107b bVar;
        boolean z = (this.f1336k == null && this.f1337l == null) ? false : true;
        int g = this.f1328c.mo1760g();
        if (arrayList.size() > 0) {
            this.f1335j = ((C0114a) arrayList.get(0)).mo1322b().mo1640a();
        }
        this.f1328c.mo1756e(this.f1335j);
        if (z) {
            int g2 = this.f1328c.mo1760g() - g;
            StringBuilder sb = new StringBuilder();
            sb.append("line_start: ");
            sb.append(this.f1335j);
            m1532a(g2, sb.toString());
        }
        int d = m1543d();
        C0282b c = this.f1332g.mo1714c();
        int a = c.mo1772a();
        if (!this.f1333h) {
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0107b bVar2 = (C0107b) it.next();
                if (d == bVar2.mo1300g()) {
                    this.f1340o[d] = bVar2;
                    break;
                }
            }
            d++;
        }
        int g3 = this.f1328c.mo1760g();
        this.f1328c.mo1756e(a);
        if (z) {
            m1532a(this.f1328c.mo1760g() - g3, String.format("parameters_size: %04x", new Object[]{Integer.valueOf(a)}));
        }
        int i = d;
        for (int i2 = 0; i2 < a; i2++) {
            C0283c b = c.mo1723b(i2);
            int g4 = this.f1328c.mo1760g();
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    bVar = null;
                    break;
                }
                bVar = (C0107b) it2.next();
                if (i == bVar.mo1300g()) {
                    if (bVar.mo1297e() != null) {
                        m1534a((C0277v) null);
                    } else {
                        m1534a(bVar.mo1296d());
                    }
                    this.f1340o[i] = bVar;
                }
            }
            if (bVar == null) {
                m1534a((C0277v) null);
            }
            if (z) {
                String a_ = (bVar == null || bVar.mo1297e() != null) ? "<unnamed>" : bVar.mo1296d().mo1218a_();
                int g5 = this.f1328c.mo1760g() - g4;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("parameter ");
                sb2.append(a_);
                sb2.append(" ");
                sb2.append("v");
                sb2.append(i);
                m1532a(g5, sb2.toString());
            }
            i += b.mo1729g();
        }
        for (C0107b bVar3 : this.f1340o) {
            if (!(bVar3 == null || bVar3.mo1297e() == null)) {
                m1545d(bVar3);
            }
        }
    }

    /* renamed from: b */
    private void m1537b(int i) {
        int g = this.f1328c.mo1760g();
        this.f1328c.mo1753b(2);
        this.f1328c.mo1758f(i);
        this.f1335j += i;
        if (this.f1336k != null || this.f1337l != null) {
            m1532a(this.f1328c.mo1760g() - g, String.format("line = %d", new Object[]{Integer.valueOf(this.f1335j)}));
        }
    }

    /* renamed from: b */
    private void m1538b(C0107b bVar) {
        int g = this.f1328c.mo1760g();
        this.f1328c.mo1753b(6);
        m1544d(bVar.mo1300g());
        if (this.f1336k != null || this.f1337l != null) {
            m1532a(this.f1328c.mo1760g() - g, String.format("%04x: +local restart %s", new Object[]{Integer.valueOf(this.f1334i), m1531a(bVar)}));
        }
    }

    /* renamed from: b */
    private byte[] m1539b() {
        ArrayList c = m1540c();
        m1536a(c, m1546e());
        this.f1328c.mo1753b(7);
        int i = 0;
        if (!(this.f1336k == null && this.f1337l == null)) {
            m1532a(1, String.format("%04x: prologue end", new Object[]{Integer.valueOf(this.f1334i)}));
        }
        int size = c.size();
        int a = this.f1327b.mo1772a();
        int i2 = 0;
        while (true) {
            i = m1528a(i);
            i2 = m1530a(i2, c);
            int a2 = i < a ? this.f1327b.mo1215a(i).mo1288a() : Integer.MAX_VALUE;
            int a3 = i2 < size ? ((C0114a) c.get(i2)).mo1321a() : Integer.MAX_VALUE;
            int min = Math.min(a3, a2);
            if (!(min == Integer.MAX_VALUE || (min == this.f1330e && a2 == Integer.MAX_VALUE && a3 == Integer.MAX_VALUE))) {
                if (min == a3) {
                    int i3 = i2 + 1;
                    m1533a((C0114a) c.get(i2));
                    i2 = i3;
                } else {
                    m1541c(min - this.f1334i);
                }
            }
        }
        m1548f();
        return this.f1328c.mo1759f();
    }

    /* renamed from: c */
    private ArrayList<C0114a> m1540c() {
        int a = this.f1326a == null ? 0 : this.f1326a.mo1772a();
        ArrayList<C0114a> arrayList = new ArrayList<>(a);
        for (int i = 0; i < a; i++) {
            arrayList.add(this.f1326a.mo1215a(i));
        }
        Collections.sort(arrayList, new Comparator<C0114a>() {
            /* renamed from: a */
            public int compare(C0114a aVar, C0114a aVar2) {
                return aVar.mo1321a() - aVar2.mo1321a();
            }

            public boolean equals(Object obj) {
                return obj == this;
            }
        });
        return arrayList;
    }

    /* renamed from: c */
    private void m1541c(int i) {
        int g = this.f1328c.mo1760g();
        this.f1328c.mo1753b(1);
        this.f1328c.mo1756e(i);
        this.f1334i += i;
        if (this.f1336k != null || this.f1337l != null) {
            m1532a(this.f1328c.mo1760g() - g, String.format("%04x: advance pc", new Object[]{Integer.valueOf(this.f1334i)}));
        }
    }

    /* renamed from: c */
    private void m1542c(C0107b bVar) {
        if (bVar.mo1297e() != null) {
            m1545d(bVar);
            return;
        }
        int g = this.f1328c.mo1760g();
        this.f1328c.mo1753b(3);
        m1544d(bVar.mo1300g());
        m1534a(bVar.mo1296d());
        m1535a(bVar.mo1299f());
        if (!(this.f1336k == null && this.f1337l == null)) {
            m1532a(this.f1328c.mo1760g() - g, String.format("%04x: +local %s", new Object[]{Integer.valueOf(this.f1334i), m1531a(bVar)}));
        }
    }

    /* renamed from: d */
    private int m1543d() {
        return (this.f1331f - this.f1332g.mo1714c().mo1721b()) - (this.f1333h ^ true ? 1 : 0);
    }

    /* renamed from: d */
    private void m1544d(int i) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Signed value where unsigned required: ");
            sb.append(i);
            throw new RuntimeException(sb.toString());
        }
        this.f1328c.mo1756e(i);
    }

    /* renamed from: d */
    private void m1545d(C0107b bVar) {
        int g = this.f1328c.mo1760g();
        this.f1328c.mo1753b(4);
        m1544d(bVar.mo1300g());
        m1534a(bVar.mo1296d());
        m1535a(bVar.mo1299f());
        m1534a(bVar.mo1297e());
        if (this.f1336k != null || this.f1337l != null) {
            m1532a(this.f1328c.mo1760g() - g, String.format("%04x: +localx %s", new Object[]{Integer.valueOf(this.f1334i), m1531a(bVar)}));
        }
    }

    /* renamed from: e */
    private ArrayList<C0107b> m1546e() {
        ArrayList<C0107b> arrayList = new ArrayList<>(this.f1332g.mo1714c().mo1772a());
        int d = m1543d();
        BitSet bitSet = new BitSet(this.f1331f - d);
        int a = this.f1327b.mo1772a();
        for (int i = 0; i < a; i++) {
            C0107b a2 = this.f1327b.mo1215a(i);
            int g = a2.mo1300g();
            if (g >= d) {
                int i2 = g - d;
                if (!bitSet.get(i2)) {
                    bitSet.set(i2);
                    arrayList.add(a2);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<C0107b>() {
            /* renamed from: a */
            public int compare(C0107b bVar, C0107b bVar2) {
                return bVar.mo1300g() - bVar2.mo1300g();
            }

            public boolean equals(Object obj) {
                return obj == this;
            }
        });
        return arrayList;
    }

    /* renamed from: e */
    private void m1547e(C0107b bVar) {
        int g = this.f1328c.mo1760g();
        this.f1328c.mo1753b(5);
        this.f1328c.mo1756e(bVar.mo1300g());
        if (this.f1336k != null || this.f1337l != null) {
            m1532a(this.f1328c.mo1760g() - g, String.format("%04x: -local %s", new Object[]{Integer.valueOf(this.f1334i), m1531a(bVar)}));
        }
    }

    /* renamed from: f */
    private void m1548f() {
        this.f1328c.mo1753b(0);
        if (this.f1336k != null || this.f1337l != null) {
            m1532a(1, "end sequence");
        }
    }

    /* renamed from: a */
    public byte[] mo1454a() {
        try {
            return m1539b();
        } catch (IOException e) {
            throw C0293g.m2033a(e, "...while encoding debug info");
        }
    }

    /* renamed from: a */
    public byte[] mo1455a(String str, PrintWriter printWriter, C0286a aVar, boolean z) {
        this.f1338m = str;
        this.f1337l = printWriter;
        this.f1336k = aVar;
        this.f1339n = z;
        return mo1454a();
    }
}
