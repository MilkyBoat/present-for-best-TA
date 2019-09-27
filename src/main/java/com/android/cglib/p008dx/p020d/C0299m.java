package com.android.cglib.p008dx.p020d;

/* renamed from: com.android.cglib.dx.d.m */
public class C0299m extends C0294h {

    /* renamed from: a */
    private final C0297k f2173a;

    public C0299m(int i) {
        super(i);
        this.f2173a = new C0297k(i);
    }

    /* renamed from: a */
    private void mo1215a(int i) {
        this.f2173a.mo1786a(i, -1);
    }

    /* renamed from: a */
    private void m2067a(int i, int i2) {
        int a = this.f2173a.mo1784a();
        for (int i3 = 0; i3 <= i - a; i3++) {
            this.f2173a.mo1788b(-1);
        }
        this.f2173a.mo1786a(i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1796a(int i, C0298l lVar) {
        C0298l lVar2 = (C0298l) mo1777e(i);
        mo1774a(i, lVar);
        if (lVar2 != null) {
            mo1215a(lVar2.mo1541a());
        }
        if (lVar != null) {
            m2067a(lVar.mo1541a(), i);
        }
    }

    /* renamed from: c */
    public final int mo1797c(int i) {
        if (i >= this.f2173a.mo1784a()) {
            return -1;
        }
        return this.f2173a.mo1785a(i);
    }

    /* renamed from: d */
    public final int mo1798d() {
        int a = this.f2173a.mo1784a() - 1;
        while (a >= 0 && this.f2173a.mo1785a(a) < 0) {
            a--;
        }
        int i = a + 1;
        this.f2173a.mo1789c(i);
        return i;
    }
}
