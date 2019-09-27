package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p009a.C0123b;
import com.android.cglib.p008dx.p009a.p010a.C0095g.C0096a;
import com.android.cglib.p008dx.p015c.p017b.C0239h;
import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p017b.C0248o;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0273r;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0292f;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.android.cglib.dx.a.a.t */
public final class C0112t {

    /* renamed from: a */
    private final C0123b f1203a;

    /* renamed from: b */
    private final int f1204b;

    /* renamed from: c */
    private ArrayList<C0097h> f1205c;

    /* renamed from: d */
    private boolean f1206d = false;

    /* renamed from: e */
    private boolean f1207e = false;

    /* renamed from: f */
    private int f1208f = -1;

    public C0112t(C0123b bVar, int i, int i2) {
        this.f1203a = bVar;
        this.f1204b = i2;
        this.f1205c = new ArrayList<>(i);
    }

    /* renamed from: a */
    private C0099j m1232a(C0097h hVar, C0099j jVar) {
        while (jVar != null && !jVar.mo1279c().mo1205b(hVar)) {
            jVar = C0100k.m1137a(jVar, this.f1203a);
        }
        return jVar;
    }

    /* renamed from: a */
    private static void m1233a(C0094f fVar, C0096a aVar) {
        C0255a b = fVar.mo1241b();
        int a = aVar.mo1255a(b);
        if (a >= 0) {
            fVar.mo1240a(a);
        }
        if (b instanceof C0273r) {
            int a2 = aVar.mo1255a(((C0273r) b).mo1685g());
            if (a2 >= 0) {
                fVar.mo1242b(a2);
            }
        }
    }

    /* renamed from: a */
    private static void m1234a(HashSet<C0255a> hashSet, C0097h hVar) {
        if (hVar instanceof C0094f) {
            hashSet.add(((C0094f) hVar).mo1241b());
            return;
        }
        if (hVar instanceof C0109q) {
            C0248o b = ((C0109q) hVar).mo1308b();
            int b2 = b.mo1621b();
            for (int i = 0; i < b2; i++) {
                m1235a(hashSet, b.mo1618a(i));
            }
        } else if (hVar instanceof C0110r) {
            m1235a(hashSet, ((C0110r) hVar).mo1309b());
        }
    }

    /* renamed from: a */
    private static void m1235a(HashSet<C0255a> hashSet, C0244m mVar) {
        if (mVar != null) {
            C0239h g = mVar.mo1599g();
            C0277v a = g.mo1576a();
            C0277v b = g.mo1577b();
            C0283c b2 = mVar.mo1589b();
            if (b2 != C0283c.f2124j) {
                hashSet.add(C0278w.m1935a(b2));
            }
            if (a != null) {
                hashSet.add(a);
            }
            if (b != null) {
                hashSet.add(b);
            }
        }
    }

    /* renamed from: a */
    private void m1236a(C0099j[] jVarArr) {
        int i = this.f1208f < 0 ? 0 : this.f1208f;
        while (true) {
            int b = m1238b(jVarArr);
            if (i >= b) {
                this.f1208f = i;
                return;
            }
            int i2 = b - i;
            int size = this.f1205c.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0097h hVar = (C0097h) this.f1205c.get(i3);
                if (!(hVar instanceof C0093e)) {
                    this.f1205c.set(i3, hVar.mo1208d(i2));
                }
            }
            i = b;
        }
    }

    /* renamed from: a */
    private static boolean m1237a(C0244m mVar) {
        return (mVar == null || mVar.mo1599g().mo1576a() == null) ? false : true;
    }

    /* renamed from: b */
    private int m1238b(C0099j[] jVarArr) {
        int size = this.f1205c.size();
        int i = this.f1208f;
        for (int i2 = 0; i2 < size; i2++) {
            C0097h hVar = (C0097h) this.f1205c.get(i2);
            C0099j jVar = jVarArr[i2];
            C0099j a = m1232a(hVar, jVar);
            if (a == null) {
                int a2 = hVar.mo1256a(m1242d(hVar).mo1279c().mo1206c(hVar));
                if (a2 > i) {
                    i = a2;
                }
            } else if (jVar == a) {
            }
            jVarArr[i2] = a;
        }
        return i;
    }

    /* renamed from: b */
    private static boolean m1239b(C0097h hVar) {
        if (!(hVar instanceof C0109q)) {
            return (hVar instanceof C0110r) && m1237a(((C0110r) hVar).mo1309b());
        }
        C0248o b = ((C0109q) hVar).mo1308b();
        int b2 = b.mo1621b();
        for (int i = 0; i < b2; i++) {
            if (m1237a(b.mo1618a(i))) {
                return true;
            }
        }
    }

    /* renamed from: c */
    private void m1240c(C0097h hVar) {
        if (!this.f1206d && hVar.mo1265h().mo1640a() >= 0) {
            this.f1206d = true;
        }
        if (!this.f1207e && m1239b(hVar)) {
            this.f1207e = true;
        }
    }

    /* renamed from: c */
    private void m1241c(C0099j[] jVarArr) {
        if (this.f1208f == 0) {
            int size = this.f1205c.size();
            for (int i = 0; i < size; i++) {
                C0097h hVar = (C0097h) this.f1205c.get(i);
                C0099j g = hVar.mo1264g();
                C0099j jVar = jVarArr[i];
                if (g != jVar) {
                    this.f1205c.set(i, hVar.mo1207a(jVar));
                }
            }
            return;
        }
        this.f1205c = m1243d(jVarArr);
    }

    /* renamed from: d */
    private C0099j m1242d(C0097h hVar) {
        C0099j a = m1232a(hVar.mo1268k(), hVar.mo1264g());
        if (a != null) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No expanded opcode for ");
        sb.append(hVar);
        throw new C0292f(sb.toString());
    }

    /* renamed from: d */
    private ArrayList<C0097h> m1243d(C0099j[] jVarArr) {
        Object obj;
        int size = this.f1205c.size();
        ArrayList<C0097h> arrayList = new ArrayList<>(size * 2);
        for (int i = 0; i < size; i++) {
            C0097h hVar = (C0097h) this.f1205c.get(i);
            C0099j g = hVar.mo1264g();
            C0099j jVar = jVarArr[i];
            Object obj2 = null;
            if (jVar != null) {
                obj = null;
            } else {
                jVar = m1242d(hVar);
                BitSet c = jVar.mo1279c().mo1206c(hVar);
                C0097h b = hVar.mo1258b(c);
                obj = hVar.mo1259c(c);
                hVar = hVar.mo1261d(c);
                obj2 = b;
            }
            if (obj2 != null) {
                arrayList.add(obj2);
            }
            if (jVar != g) {
                hVar = hVar.mo1207a(jVar);
            }
            arrayList.add(hVar);
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    private C0099j[] m1244e() {
        int size = this.f1205c.size();
        C0099j[] jVarArr = new C0099j[size];
        for (int i = 0; i < size; i++) {
            jVarArr[i] = ((C0097h) this.f1205c.get(i)).mo1264g();
        }
        return jVarArr;
    }

    /* renamed from: f */
    private void m1245f() {
        do {
            m1246g();
        } while (m1247h());
    }

    /* renamed from: g */
    private void m1246g() {
        int size = this.f1205c.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            C0097h hVar = (C0097h) this.f1205c.get(i2);
            hVar.mo1260c(i);
            i += hVar.mo1210n();
        }
    }

    /* renamed from: h */
    private boolean m1247h() {
        int size = this.f1205c.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            C0097h hVar = (C0097h) this.f1205c.get(i);
            if (hVar instanceof C0122z) {
                C0099j g = hVar.mo1264g();
                C0122z zVar = (C0122z) hVar;
                if (!g.mo1279c().mo1203a(zVar)) {
                    if (g.mo1278b() == 40) {
                        C0099j a = m1232a(hVar, g);
                        if (a == null) {
                            throw new UnsupportedOperationException("method too long");
                        }
                        this.f1205c.set(i, hVar.mo1207a(a));
                    } else {
                        try {
                            int i2 = i + 1;
                            C0093e eVar = (C0093e) this.f1205c.get(i2);
                            this.f1205c.set(i, new C0122z(C0100k.f935P, zVar.mo1265h(), C0247n.f1778a, zVar.mo1331b()));
                            this.f1205c.add(i, zVar.mo1330a(eVar));
                            size++;
                            i = i2;
                        } catch (IndexOutOfBoundsException unused) {
                            throw new IllegalStateException("unpaired TargetInsn (dangling)");
                        } catch (ClassCastException unused2) {
                            throw new IllegalStateException("unpaired TargetInsn");
                        }
                    }
                    z = true;
                } else {
                    continue;
                }
            }
            i++;
        }
        return z;
    }

    /* renamed from: a */
    public void mo1313a(int i, C0093e eVar) {
        int size = (this.f1205c.size() - i) - 1;
        try {
            this.f1205c.set(size, ((C0122z) this.f1205c.get(size)).mo1330a(eVar));
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("too few instructions");
        } catch (ClassCastException unused2) {
            throw new IllegalArgumentException("non-reversible instruction");
        }
    }

    /* renamed from: a */
    public void mo1314a(C0096a aVar) {
        Iterator it = this.f1205c.iterator();
        while (it.hasNext()) {
            C0097h hVar = (C0097h) it.next();
            if (hVar instanceof C0094f) {
                m1233a((C0094f) hVar, aVar);
            }
        }
    }

    /* renamed from: a */
    public void mo1315a(C0097h hVar) {
        this.f1205c.add(hVar);
        m1240c(hVar);
    }

    /* renamed from: a */
    public boolean mo1316a() {
        return this.f1206d;
    }

    /* renamed from: b */
    public boolean mo1317b() {
        return this.f1207e;
    }

    /* renamed from: c */
    public HashSet<C0255a> mo1318c() {
        HashSet<C0255a> hashSet = new HashSet<>(20);
        Iterator it = this.f1205c.iterator();
        while (it.hasNext()) {
            m1234a(hashSet, (C0097h) it.next());
        }
        return hashSet;
    }

    /* renamed from: d */
    public C0098i mo1319d() {
        if (this.f1208f >= 0) {
            throw new UnsupportedOperationException("already processed");
        }
        C0099j[] e = m1244e();
        m1236a(e);
        m1241c(e);
        m1245f();
        return C0098i.m1122a(this.f1205c, this.f1208f + this.f1204b);
    }
}
