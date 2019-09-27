package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0248o;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p015c.p019d.C0284d;
import com.android.cglib.p008dx.p020d.C0294h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: com.android.cglib.dx.a.a.p */
public final class C0105p extends C0294h {

    /* renamed from: a */
    public static final C0105p f1182a = new C0105p(0);

    /* renamed from: com.android.cglib.dx.a.a.p$a */
    public enum C0106a {
        START,
        END_SIMPLY,
        END_REPLACED,
        END_MOVED,
        END_CLOBBERED_BY_PREV,
        END_CLOBBERED_BY_NEXT
    }

    /* renamed from: com.android.cglib.dx.a.a.p$b */
    public static class C0107b implements Comparable<C0107b> {

        /* renamed from: a */
        private final int f1190a;

        /* renamed from: b */
        private final C0106a f1191b;

        /* renamed from: c */
        private final C0244m f1192c;

        /* renamed from: d */
        private final C0278w f1193d;

        public C0107b(int i, C0106a aVar, C0244m mVar) {
            if (i < 0) {
                throw new IllegalArgumentException("address < 0");
            } else if (aVar == null) {
                throw new NullPointerException("disposition == null");
            } else {
                try {
                    if (mVar.mo1599g() == null) {
                        throw new NullPointerException("spec.getLocalItem() == null");
                    }
                    this.f1190a = i;
                    this.f1191b = aVar;
                    this.f1192c = mVar;
                    this.f1193d = C0278w.m1935a(mVar.mo1589b());
                } catch (NullPointerException unused) {
                    throw new NullPointerException("spec == null");
                }
            }
        }

        /* renamed from: a */
        public int mo1288a() {
            return this.f1190a;
        }

        /* renamed from: a */
        public int compareTo(C0107b bVar) {
            int i = -1;
            if (this.f1190a < bVar.f1190a) {
                return -1;
            }
            if (this.f1190a > bVar.f1190a) {
                return 1;
            }
            boolean c = mo1294c();
            if (c == bVar.mo1294c()) {
                return this.f1192c.compareTo(bVar.f1192c);
            }
            if (c) {
                i = 1;
            }
            return i;
        }

        /* renamed from: a */
        public C0107b mo1290a(C0106a aVar) {
            return aVar == this.f1191b ? this : new C0107b(this.f1190a, aVar, this.f1192c);
        }

        /* renamed from: a */
        public boolean mo1291a(C0244m mVar) {
            return this.f1192c.mo1587a(mVar);
        }

        /* renamed from: b */
        public C0106a mo1292b() {
            return this.f1191b;
        }

        /* renamed from: b */
        public boolean mo1293b(C0107b bVar) {
            return mo1291a(bVar.f1192c);
        }

        /* renamed from: c */
        public boolean mo1294c() {
            return this.f1191b == C0106a.START;
        }

        /* renamed from: d */
        public C0277v mo1296d() {
            return this.f1192c.mo1599g().mo1576a();
        }

        /* renamed from: e */
        public C0277v mo1297e() {
            return this.f1192c.mo1599g().mo1577b();
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof C0107b)) {
                return false;
            }
            if (compareTo((C0107b) obj) == 0) {
                z = true;
            }
            return z;
        }

        /* renamed from: f */
        public C0278w mo1299f() {
            return this.f1193d;
        }

        /* renamed from: g */
        public int mo1300g() {
            return this.f1192c.mo1596e();
        }

        /* renamed from: h */
        public C0244m mo1301h() {
            return this.f1192c;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(this.f1190a));
            sb.append(" ");
            sb.append(this.f1191b);
            sb.append(" ");
            sb.append(this.f1192c);
            return sb.toString();
        }
    }

    /* renamed from: com.android.cglib.dx.a.a.p$c */
    public static class C0108c {

        /* renamed from: a */
        private final ArrayList<C0107b> f1194a;

        /* renamed from: b */
        private int f1195b = 0;

        /* renamed from: c */
        private C0248o f1196c = null;

        /* renamed from: d */
        private int[] f1197d = null;

        /* renamed from: e */
        private int f1198e = 0;

        public C0108c(int i) {
            this.f1194a = new ArrayList<>(i);
        }

        /* renamed from: a */
        private static C0244m m1207a(C0244m mVar) {
            return (mVar == null || mVar.mo1589b() != C0283c.f2124j) ? mVar : mVar.mo1586a((C0284d) C0283c.f2129o);
        }

        /* renamed from: a */
        private void m1208a(int i, int i2) {
            boolean z = this.f1197d == null;
            if (i == this.f1198e && !z) {
                return;
            }
            if (i < this.f1198e) {
                throw new RuntimeException("shouldn't happen");
            }
            if (z || i2 >= this.f1197d.length) {
                int i3 = i2 + 1;
                C0248o oVar = new C0248o(i3);
                int[] iArr = new int[i3];
                Arrays.fill(iArr, -1);
                if (!z) {
                    oVar.mo1620a(this.f1196c);
                    System.arraycopy(this.f1197d, 0, iArr, 0, this.f1197d.length);
                }
                this.f1196c = oVar;
                this.f1197d = iArr;
            }
        }

        /* renamed from: a */
        private void m1209a(int i, C0106a aVar, C0244m mVar) {
            int e = mVar.mo1596e();
            this.f1194a.add(new C0107b(i, aVar, mVar));
            if (aVar == C0106a.START) {
                this.f1196c.mo1624c(mVar);
                this.f1197d[e] = -1;
                return;
            }
            this.f1196c.mo1623b(mVar);
            this.f1197d[e] = this.f1194a.size() - 1;
        }

        /* renamed from: b */
        private void m1210b(int i, C0106a aVar, C0244m mVar) {
            if (aVar == C0106a.START) {
                throw new RuntimeException("shouldn't happen");
            }
            int i2 = this.f1197d[mVar.mo1596e()];
            if (i2 >= 0) {
                C0107b bVar = (C0107b) this.f1194a.get(i2);
                if (bVar.mo1288a() == i && bVar.mo1301h().equals(mVar)) {
                    this.f1194a.set(i2, bVar.mo1290a(aVar));
                    this.f1196c.mo1623b(mVar);
                    return;
                }
            }
            mo1305a(i, mVar, aVar);
        }

        /* renamed from: c */
        private boolean m1211c(int i, C0244m mVar) {
            boolean z;
            int size = this.f1194a.size() - 1;
            while (true) {
                z = false;
                if (size < 0) {
                    break;
                }
                C0107b bVar = (C0107b) this.f1194a.get(size);
                if (bVar != null) {
                    if (bVar.mo1288a() != i) {
                        return false;
                    }
                    if (bVar.mo1291a(mVar)) {
                        break;
                    }
                }
                size--;
            }
            this.f1196c.mo1623b(mVar);
            C0107b bVar2 = null;
            this.f1194a.set(size, null);
            this.f1195b++;
            int e = mVar.mo1596e();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                bVar2 = (C0107b) this.f1194a.get(size);
                if (bVar2 != null && bVar2.mo1301h().mo1596e() == e) {
                    z = true;
                    break;
                }
            }
            if (z) {
                this.f1197d[e] = size;
                if (bVar2.mo1288a() == i) {
                    this.f1194a.set(size, bVar2.mo1290a(C0106a.END_SIMPLY));
                }
            }
            return true;
        }

        /* renamed from: a */
        public C0105p mo1303a() {
            m1208a(Integer.MAX_VALUE, 0);
            int size = this.f1194a.size();
            int i = size - this.f1195b;
            if (i == 0) {
                return C0105p.f1182a;
            }
            C0107b[] bVarArr = new C0107b[i];
            if (size == i) {
                this.f1194a.toArray(bVarArr);
            } else {
                Iterator it = this.f1194a.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    C0107b bVar = (C0107b) it.next();
                    if (bVar != null) {
                        int i3 = i2 + 1;
                        bVarArr[i2] = bVar;
                        i2 = i3;
                    }
                }
            }
            Arrays.sort(bVarArr);
            C0105p pVar = new C0105p(i);
            for (int i4 = 0; i4 < i; i4++) {
                pVar.mo1287a(i4, bVarArr[i4]);
            }
            pVar.mo1799e();
            return pVar;
        }

        /* renamed from: a */
        public void mo1304a(int i, C0244m mVar) {
            int e = mVar.mo1596e();
            C0244m a = m1207a(mVar);
            m1208a(i, e);
            C0244m a2 = this.f1196c.mo1618a(e);
            if (!a.mo1587a(a2)) {
                C0244m a3 = this.f1196c.mo1619a(a);
                if (a3 != null) {
                    m1210b(i, C0106a.END_MOVED, a3);
                }
                int i2 = this.f1197d[e];
                if (a2 != null) {
                    m1209a(i, C0106a.END_REPLACED, a2);
                } else if (i2 >= 0) {
                    C0107b bVar = (C0107b) this.f1194a.get(i2);
                    if (bVar.mo1288a() == i) {
                        if (bVar.mo1291a(a)) {
                            this.f1194a.set(i2, null);
                            this.f1195b++;
                            this.f1196c.mo1624c(a);
                            this.f1197d[e] = -1;
                            return;
                        }
                        this.f1194a.set(i2, bVar.mo1290a(C0106a.END_REPLACED));
                    }
                }
                if (e > 0) {
                    C0244m a4 = this.f1196c.mo1618a(e - 1);
                    if (a4 != null && a4.mo1603j()) {
                        m1210b(i, C0106a.END_CLOBBERED_BY_NEXT, a4);
                    }
                }
                if (a.mo1603j()) {
                    C0244m a5 = this.f1196c.mo1618a(e + 1);
                    if (a5 != null) {
                        m1210b(i, C0106a.END_CLOBBERED_BY_PREV, a5);
                    }
                }
                m1209a(i, C0106a.START, a);
            }
        }

        /* renamed from: a */
        public void mo1305a(int i, C0244m mVar, C0106a aVar) {
            int e = mVar.mo1596e();
            C0244m a = m1207a(mVar);
            m1208a(i, e);
            if (this.f1197d[e] < 0 && !m1211c(i, a)) {
                m1209a(i, aVar, a);
            }
        }

        /* renamed from: a */
        public void mo1306a(int i, C0248o oVar) {
            int a = oVar.mo1617a();
            m1208a(i, a - 1);
            for (int i2 = 0; i2 < a; i2++) {
                C0244m a2 = this.f1196c.mo1618a(i2);
                C0244m a3 = m1207a(oVar.mo1618a(i2));
                if (a2 != null) {
                    if (a3 == null) {
                        mo1307b(i, a2);
                    } else if (!a3.mo1587a(a2)) {
                        mo1307b(i, a2);
                    }
                } else if (a3 == null) {
                }
                mo1304a(i, a3);
            }
        }

        /* renamed from: b */
        public void mo1307b(int i, C0244m mVar) {
            mo1305a(i, mVar, C0106a.END_SIMPLY);
        }
    }

    public C0105p(int i) {
        super(i);
    }

    /* renamed from: a */
    public static C0105p m1192a(C0098i iVar) {
        int a = iVar.mo1772a();
        C0108c cVar = new C0108c(a);
        for (int i = 0; i < a; i++) {
            C0097h a2 = iVar.mo1215a(i);
            if (a2 instanceof C0109q) {
                cVar.mo1306a(a2.mo1263f(), ((C0109q) a2).mo1308b());
            } else if (a2 instanceof C0110r) {
                cVar.mo1304a(a2.mo1263f(), ((C0110r) a2).mo1309b());
            } else if (a2 instanceof C0104o) {
                cVar.mo1307b(a2.mo1263f(), ((C0104o) a2).mo1286b());
            }
        }
        return cVar.mo1303a();
    }

    /* renamed from: a */
    public C0107b mo1215a(int i) {
        return (C0107b) mo1776d(i);
    }

    /* renamed from: a */
    public void mo1287a(int i, C0107b bVar) {
        mo1774a(i, bVar);
    }
}
