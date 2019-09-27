package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0257c;
import com.android.cglib.p008dx.p015c.p018c.C0257c.C0258a;
import com.android.cglib.p008dx.p015c.p018c.C0271p;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p015c.p018c.C0280y;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0289d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.android.cglib.dx.a.b.f */
public final class C0156f extends C0136ag {

    /* renamed from: a */
    private final C0278w f1300a;

    /* renamed from: b */
    private final ArrayList<C0167n> f1301b;

    /* renamed from: c */
    private final HashMap<C0167n, C0255a> f1302c;

    /* renamed from: d */
    private final ArrayList<C0167n> f1303d;

    /* renamed from: e */
    private final ArrayList<C0169p> f1304e;

    /* renamed from: f */
    private final ArrayList<C0169p> f1305f;

    /* renamed from: g */
    private C0257c f1306g;

    /* renamed from: h */
    private byte[] f1307h;

    public C0156f(C0278w wVar) {
        super(1, -1);
        if (wVar == null) {
            throw new NullPointerException("thisClass == null");
        }
        this.f1300a = wVar;
        this.f1301b = new ArrayList<>(20);
        this.f1302c = new HashMap<>(40);
        this.f1303d = new ArrayList<>(20);
        this.f1304e = new ArrayList<>(20);
        this.f1305f = new ArrayList<>(20);
        this.f1306g = null;
    }

    /* renamed from: a */
    private static void m1487a(C0165l lVar, C0286a aVar, String str, int i) {
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_size:");
            aVar.mo1740a(String.format("  %-21s %08x", new Object[]{sb.toString(), Integer.valueOf(i)}));
        }
        aVar.mo1756e(i);
    }

    /* renamed from: a */
    private static void m1488a(C0165l lVar, C0286a aVar, String str, ArrayList<? extends C0168o> arrayList) {
        int size = arrayList.size();
        if (size != 0) {
            if (aVar.mo1741a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("  ");
                sb.append(str);
                sb.append(":");
                aVar.mo1739a(0, sb.toString());
            }
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i = ((C0168o) arrayList.get(i2)).mo1485a(lVar, aVar, i, i2);
            }
        }
    }

    /* renamed from: b */
    private void m1489b(C0165l lVar, C0286a aVar) {
        boolean a = aVar.mo1741a();
        if (a) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1382g());
            sb.append(" class data for ");
            sb.append(this.f1300a.mo1218a_());
            aVar.mo1739a(0, sb.toString());
        }
        m1487a(lVar, aVar, "static_fields", this.f1301b.size());
        m1487a(lVar, aVar, "instance_fields", this.f1303d.size());
        m1487a(lVar, aVar, "direct_methods", this.f1304e.size());
        m1487a(lVar, aVar, "virtual_methods", this.f1305f.size());
        m1488a(lVar, aVar, "static_fields", this.f1301b);
        m1488a(lVar, aVar, "instance_fields", this.f1303d);
        m1488a(lVar, aVar, "direct_methods", this.f1304e);
        m1488a(lVar, aVar, "virtual_methods", this.f1305f);
        if (a) {
            aVar.mo1743c();
        }
    }

    /* renamed from: h */
    private C0257c m1490h() {
        Collections.sort(this.f1301b);
        int size = this.f1301b.size();
        while (size > 0) {
            C0255a aVar = (C0255a) this.f1302c.get((C0167n) this.f1301b.get(size - 1));
            if (aVar instanceof C0271p) {
                if (((C0271p) aVar).mo1676h() != 0) {
                    break;
                }
            } else if (aVar != null) {
                break;
            }
            size--;
        }
        if (size == 0) {
            return null;
        }
        C0258a aVar2 = new C0258a(size);
        for (int i = 0; i < size; i++) {
            C0167n nVar = (C0167n) this.f1301b.get(i);
            C0255a aVar3 = (C0255a) this.f1302c.get(nVar);
            if (aVar3 == null) {
                aVar3 = C0280y.m1944a(nVar.mo1488b().mo1589b());
            }
            aVar2.mo1659a(i, aVar3);
        }
        aVar2.mo1799e();
        return new C0257c(aVar2);
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_CLASS_DATA_ITEM;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1339a(C0140ak akVar, int i) {
        C0289d dVar = new C0289d();
        m1489b(akVar.mo1396e(), dVar);
        this.f1307h = dVar.mo1759f();
        mo1375a(this.f1307h.length);
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
        if (!this.f1301b.isEmpty()) {
            mo1443d();
            Iterator it = this.f1301b.iterator();
            while (it.hasNext()) {
                ((C0167n) it.next()).mo1487a(lVar);
            }
        }
        if (!this.f1303d.isEmpty()) {
            Collections.sort(this.f1303d);
            Iterator it2 = this.f1303d.iterator();
            while (it2.hasNext()) {
                ((C0167n) it2.next()).mo1487a(lVar);
            }
        }
        if (!this.f1304e.isEmpty()) {
            Collections.sort(this.f1304e);
            Iterator it3 = this.f1304e.iterator();
            while (it3.hasNext()) {
                ((C0169p) it3.next()).mo1495a(lVar);
            }
        }
        if (!this.f1305f.isEmpty()) {
            Collections.sort(this.f1305f);
            Iterator it4 = this.f1305f.iterator();
            while (it4.hasNext()) {
                ((C0169p) it4.next()).mo1495a(lVar);
            }
        }
    }

    /* renamed from: a */
    public void mo1438a(C0167n nVar) {
        if (nVar == null) {
            throw new NullPointerException("field == null");
        }
        this.f1303d.add(nVar);
    }

    /* renamed from: a */
    public void mo1439a(C0167n nVar, C0255a aVar) {
        if (nVar == null) {
            throw new NullPointerException("field == null");
        } else if (this.f1306g != null) {
            throw new UnsupportedOperationException("static fields already sorted");
        } else {
            this.f1301b.add(nVar);
            this.f1302c.put(nVar, aVar);
        }
    }

    /* renamed from: a */
    public void mo1440a(C0169p pVar) {
        if (pVar == null) {
            throw new NullPointerException("method == null");
        }
        this.f1304e.add(pVar);
    }

    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        if (aVar.mo1741a()) {
            m1489b(lVar, aVar);
        } else {
            aVar.mo1751a(this.f1307h);
        }
    }

    /* renamed from: b */
    public String mo1343b() {
        return toString();
    }

    /* renamed from: b */
    public void mo1441b(C0169p pVar) {
        if (pVar == null) {
            throw new NullPointerException("method == null");
        }
        this.f1305f.add(pVar);
    }

    /* renamed from: c */
    public boolean mo1442c() {
        return this.f1301b.isEmpty() && this.f1303d.isEmpty() && this.f1304e.isEmpty() && this.f1305f.isEmpty();
    }

    /* renamed from: d */
    public C0257c mo1443d() {
        if (this.f1306g == null && this.f1301b.size() != 0) {
            this.f1306g = m1490h();
        }
        return this.f1306g;
    }
}
