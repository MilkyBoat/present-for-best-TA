package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0293g;

/* renamed from: com.android.cglib.dx.a.b.ag */
public abstract class C0136ag extends C0177x implements Comparable<C0136ag> {

    /* renamed from: a */
    private final int f1257a;

    /* renamed from: b */
    private int f1258b;

    /* renamed from: c */
    private C0140ak f1259c;

    /* renamed from: d */
    private int f1260d;

    public C0136ag(int i, int i2) {
        C0140ak.m1378a(i);
        if (i2 < -1) {
            throw new IllegalArgumentException("writeSize < -1");
        }
        this.f1257a = i;
        this.f1258b = i2;
        this.f1259c = null;
        this.f1260d = -1;
    }

    /* renamed from: b */
    public static int m1350b(C0136ag agVar) {
        if (agVar == null) {
            return 0;
        }
        return agVar.mo1379e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo1337a(C0136ag agVar) {
        throw new UnsupportedOperationException("unsupported");
    }

    /* renamed from: a */
    public final void mo1375a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("writeSize < 0");
        } else if (this.f1258b >= 0) {
            throw new UnsupportedOperationException("writeSize already set");
        } else {
            this.f1258b = i;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1339a(C0140ak akVar, int i) {
    }

    /* renamed from: a */
    public final void mo1347a(C0165l lVar, C0286a aVar) {
        aVar.mo1763h(this.f1257a);
        try {
            if (this.f1258b < 0) {
                throw new UnsupportedOperationException("writeSize is unknown");
            }
            aVar.mo1747a(mo1379e());
            mo1342a_(lVar, aVar);
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("...while writing ");
            sb.append(this);
            throw C0293g.m2033a(e, sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public abstract void mo1342a_(C0165l lVar, C0286a aVar);

    /* renamed from: b */
    public final int mo1376b(C0140ak akVar, int i) {
        if (akVar == null) {
            throw new NullPointerException("addedTo == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("offset < 0");
        } else if (this.f1259c != null) {
            throw new RuntimeException("already written");
        } else {
            int i2 = this.f1257a - 1;
            int i3 = (i + i2) & (i2 ^ -1);
            this.f1259c = akVar;
            this.f1260d = i3;
            mo1339a(akVar, i3);
            return i3;
        }
    }

    /* renamed from: b */
    public abstract String mo1343b();

    /* renamed from: b_ */
    public final int mo1349b_() {
        if (this.f1258b >= 0) {
            return this.f1258b;
        }
        throw new UnsupportedOperationException("writeSize is unknown");
    }

    /* renamed from: c */
    public final int compareTo(C0136ag agVar) {
        if (this == agVar) {
            return 0;
        }
        C0178y a = mo1338a();
        C0178y a2 = agVar.mo1338a();
        return a != a2 ? a.compareTo(a2) : mo1337a(agVar);
    }

    /* renamed from: e */
    public final int mo1379e() {
        if (this.f1260d >= 0) {
            return this.f1259c.mo1393c(this.f1260d);
        }
        throw new RuntimeException("offset not yet known");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        C0136ag agVar = (C0136ag) obj;
        if (mo1338a() != agVar.mo1338a()) {
            return false;
        }
        return mo1337a(agVar) == 0;
    }

    /* renamed from: f */
    public final int mo1381f() {
        return this.f1257a;
    }

    /* renamed from: g */
    public final String mo1382g() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(Integer.toHexString(mo1379e()));
        sb.append(']');
        return sb.toString();
    }
}
