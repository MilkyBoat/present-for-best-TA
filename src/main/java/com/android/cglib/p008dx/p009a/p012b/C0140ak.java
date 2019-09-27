package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p020d.C0286a;
import java.util.Collection;

/* renamed from: com.android.cglib.dx.a.b.ak */
public abstract class C0140ak {

    /* renamed from: a */
    private final String f1267a;

    /* renamed from: b */
    private final C0165l f1268b;

    /* renamed from: c */
    private final int f1269c;

    /* renamed from: d */
    private int f1270d;

    /* renamed from: e */
    private boolean f1271e;

    public C0140ak(String str, C0165l lVar, int i) {
        if (lVar == null) {
            throw new NullPointerException("file == null");
        }
        m1378a(i);
        this.f1267a = str;
        this.f1268b = lVar;
        this.f1269c = i;
        this.f1270d = -1;
        this.f1271e = false;
    }

    /* renamed from: a */
    public static void m1378a(int i) {
        if (i <= 0 || (i & (i - 1)) != 0) {
            throw new IllegalArgumentException("invalid alignment");
        }
    }

    /* renamed from: a */
    public abstract int mo1365a(C0177x xVar);

    /* renamed from: a */
    public abstract Collection<? extends C0177x> mo1362a();

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public abstract void mo1368a_(C0286a aVar);

    /* renamed from: b */
    public final int mo1392b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("fileOffset < 0");
        } else if (this.f1270d >= 0) {
            throw new RuntimeException("fileOffset already set");
        } else {
            int i2 = this.f1269c - 1;
            int i3 = (i + i2) & (i2 ^ -1);
            this.f1270d = i3;
            return i3;
        }
    }

    /* renamed from: c */
    public final int mo1393c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("relative < 0");
        } else if (this.f1270d >= 0) {
            return this.f1270d + i;
        } else {
            throw new RuntimeException("fileOffset not yet set");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo1370c();

    /* renamed from: c */
    public final void mo1394c(C0286a aVar) {
        String str;
        mo1400i();
        mo1395d(aVar);
        int g = aVar.mo1760g();
        if (this.f1270d < 0) {
            this.f1270d = g;
        } else if (this.f1270d != g) {
            StringBuilder sb = new StringBuilder();
            sb.append("alignment mismatch: for ");
            sb.append(this);
            sb.append(", at ");
            sb.append(g);
            sb.append(", but expected ");
            sb.append(this.f1270d);
            throw new RuntimeException(sb.toString());
        }
        if (aVar.mo1741a()) {
            if (this.f1267a != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\n");
                sb2.append(this.f1267a);
                sb2.append(":");
                str = sb2.toString();
            } else if (g != 0) {
                str = "\n";
            }
            aVar.mo1739a(0, str);
        }
        mo1368a_(aVar);
    }

    /* renamed from: c_ */
    public abstract int mo1371c_();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo1395d(C0286a aVar) {
        aVar.mo1763h(this.f1269c);
    }

    /* renamed from: e */
    public final C0165l mo1396e() {
        return this.f1268b;
    }

    /* renamed from: f */
    public final int mo1397f() {
        return this.f1269c;
    }

    /* renamed from: g */
    public final int mo1398g() {
        if (this.f1270d >= 0) {
            return this.f1270d;
        }
        throw new RuntimeException("fileOffset not set");
    }

    /* renamed from: h */
    public final void mo1399h() {
        mo1401j();
        mo1370c();
        this.f1271e = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public final void mo1400i() {
        if (!this.f1271e) {
            throw new RuntimeException("not prepared");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final void mo1401j() {
        if (this.f1271e) {
            throw new RuntimeException("already prepared");
        }
    }
}
