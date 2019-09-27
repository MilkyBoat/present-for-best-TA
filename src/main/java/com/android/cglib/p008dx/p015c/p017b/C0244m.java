package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p015c.p019d.C0284d;
import com.android.cglib.p008dx.p020d.C0304r;
import java.util.HashMap;

/* renamed from: com.android.cglib.dx.c.b.m */
public final class C0244m implements C0284d, C0304r, Comparable<C0244m> {

    /* renamed from: a */
    private static final HashMap<Object, C0244m> f1770a = new HashMap<>(1000);

    /* renamed from: b */
    private static final C0246a f1771b = new C0246a();

    /* renamed from: c */
    private final int f1772c;

    /* renamed from: d */
    private final C0284d f1773d;

    /* renamed from: e */
    private final C0239h f1774e;

    /* renamed from: com.android.cglib.dx.c.b.m$a */
    private static class C0246a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f1775a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public C0284d f1776b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public C0239h f1777c;

        private C0246a() {
        }

        /* renamed from: a */
        public C0244m mo1606a() {
            return new C0244m(this.f1775a, this.f1776b, this.f1777c);
        }

        /* renamed from: a */
        public void mo1607a(int i, C0284d dVar, C0239h hVar) {
            this.f1775a = i;
            this.f1776b = dVar;
            this.f1777c = hVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0244m)) {
                return false;
            }
            return ((C0244m) obj).m1729d(this.f1775a, this.f1776b, this.f1777c);
        }

        public int hashCode() {
            return C0244m.m1730e(this.f1775a, this.f1776b, this.f1777c);
        }
    }

    private C0244m(int i, C0284d dVar, C0239h hVar) {
        if (i < 0) {
            throw new IllegalArgumentException("reg < 0");
        } else if (dVar == null) {
            throw new NullPointerException("type == null");
        } else {
            this.f1772c = i;
            this.f1773d = dVar;
            this.f1774e = hVar;
        }
    }

    /* renamed from: a */
    public static C0244m m1722a(int i, C0284d dVar) {
        return m1728c(i, dVar, null);
    }

    /* renamed from: a */
    public static C0244m m1723a(int i, C0284d dVar, C0239h hVar) {
        return m1728c(i, dVar, hVar);
    }

    /* renamed from: a */
    public static String m1724a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("v");
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: a */
    private String m1725a(boolean z) {
        String a_;
        StringBuffer stringBuffer = new StringBuffer(40);
        stringBuffer.append(mo1604k());
        stringBuffer.append(":");
        if (this.f1774e != null) {
            stringBuffer.append(this.f1774e.toString());
        }
        C0283c b = this.f1773d.mo1589b();
        stringBuffer.append(b);
        if (b != this.f1773d) {
            stringBuffer.append("=");
            if (z && (this.f1773d instanceof C0277v)) {
                a_ = ((C0277v) this.f1773d).mo1698f();
            } else if (!z || !(this.f1773d instanceof C0255a)) {
                stringBuffer.append(this.f1773d);
            } else {
                a_ = this.f1773d.mo1218a_();
            }
            stringBuffer.append(a_);
        }
        return stringBuffer.toString();
    }

    /* renamed from: c */
    private static C0244m m1728c(int i, C0284d dVar, C0239h hVar) {
        synchronized (f1770a) {
            f1771b.mo1607a(i, dVar, hVar);
            C0244m mVar = (C0244m) f1770a.get(f1771b);
            if (mVar != null) {
                return mVar;
            }
            C0244m a = f1771b.mo1606a();
            f1770a.put(a, a);
            return a;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m1729d(int i, C0284d dVar, C0239h hVar) {
        return this.f1772c == i && this.f1773d.equals(dVar) && (this.f1774e == hVar || (this.f1774e != null && this.f1774e.equals(hVar)));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static int m1730e(int i, C0284d dVar, C0239h hVar) {
        return ((((hVar != null ? hVar.hashCode() : 0) * 31) + dVar.hashCode()) * 31) + i;
    }

    /* renamed from: a */
    public C0244m mo1586a(C0284d dVar) {
        return m1723a(this.f1772c, dVar, this.f1774e);
    }

    /* renamed from: a */
    public boolean mo1587a(C0244m mVar) {
        boolean z = false;
        if (!mo1590b(mVar)) {
            return false;
        }
        if (this.f1772c == mVar.f1772c) {
            z = true;
        }
        return z;
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        return m1725a(true);
    }

    /* renamed from: b */
    public C0244m mo1588b(int i) {
        return this.f1772c == i ? this : m1723a(i, this.f1773d, this.f1774e);
    }

    /* renamed from: b */
    public C0283c mo1589b() {
        return this.f1773d.mo1589b();
    }

    /* renamed from: b */
    public boolean mo1590b(C0244m mVar) {
        boolean z = false;
        if (mVar == null) {
            return false;
        }
        if (this.f1773d.mo1589b().equals(mVar.f1773d.mo1589b()) && (this.f1774e == mVar.f1774e || (this.f1774e != null && this.f1774e.equals(mVar.f1774e)))) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public final int mo1591c() {
        return this.f1773d.mo1591c();
    }

    /* renamed from: c */
    public int compareTo(C0244m mVar) {
        int i = -1;
        if (this.f1772c < mVar.f1772c) {
            return -1;
        }
        if (this.f1772c > mVar.f1772c) {
            return 1;
        }
        int a = this.f1773d.mo1589b().compareTo(mVar.f1773d.mo1589b());
        if (a != 0) {
            return a;
        }
        if (this.f1774e == null) {
            if (mVar.f1774e == null) {
                i = 0;
            }
            return i;
        } else if (mVar.f1774e == null) {
            return 1;
        } else {
            return this.f1774e.compareTo(mVar.f1774e);
        }
    }

    /* renamed from: c */
    public C0244m mo1593c(int i) {
        return i == 0 ? this : mo1588b(this.f1772c + i);
    }

    /* renamed from: d */
    public final int mo1595d() {
        return this.f1773d.mo1595d();
    }

    /* renamed from: e */
    public int mo1596e() {
        return this.f1772c;
    }

    public boolean equals(Object obj) {
        int i;
        C0284d dVar;
        C0239h hVar;
        if (obj instanceof C0244m) {
            C0244m mVar = (C0244m) obj;
            i = mVar.f1772c;
            dVar = mVar.f1773d;
            hVar = mVar.f1774e;
        } else if (!(obj instanceof C0246a)) {
            return false;
        } else {
            C0246a aVar = (C0246a) obj;
            i = aVar.f1775a;
            dVar = aVar.f1776b;
            hVar = aVar.f1777c;
        }
        return m1729d(i, dVar, hVar);
    }

    /* renamed from: f */
    public C0284d mo1598f() {
        return this.f1773d;
    }

    /* renamed from: g */
    public C0239h mo1599g() {
        return this.f1774e;
    }

    /* renamed from: h */
    public int mo1600h() {
        return this.f1772c + mo1602i();
    }

    public int hashCode() {
        return m1730e(this.f1772c, this.f1773d, this.f1774e);
    }

    /* renamed from: i */
    public int mo1602i() {
        return this.f1773d.mo1589b().mo1729g();
    }

    /* renamed from: j */
    public boolean mo1603j() {
        return this.f1773d.mo1589b().mo1730h();
    }

    /* renamed from: k */
    public String mo1604k() {
        return m1724a(this.f1772c);
    }

    public String toString() {
        return m1725a(false);
    }
}
