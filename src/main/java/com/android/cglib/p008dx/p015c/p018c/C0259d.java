package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p015c.p019d.C0281a;
import com.android.cglib.p008dx.p015c.p019d.C0283c;

/* renamed from: com.android.cglib.dx.c.c.d */
public abstract class C0259d extends C0273r {

    /* renamed from: a */
    private final C0281a f2008a = C0281a.m1945a(mo1686h().mo1690c().mo1699g());

    /* renamed from: b */
    private C0281a f2009b = null;

    C0259d(C0278w wVar, C0275t tVar) {
        super(wVar, tVar);
    }

    /* renamed from: a */
    public final C0281a mo1661a(boolean z) {
        if (z) {
            return this.f2008a;
        }
        if (this.f2009b == null) {
            this.f2009b = this.f2008a.mo1711a(mo1685g().mo1706f());
        }
        return this.f2009b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final int mo1647b(C0255a aVar) {
        int b = super.mo1647b(aVar);
        if (b != 0) {
            return b;
        }
        return this.f2008a.compareTo(((C0259d) aVar).f2008a);
    }

    /* renamed from: b */
    public final int mo1662b(boolean z) {
        return mo1661a(z).mo1714c().mo1721b();
    }

    /* renamed from: b */
    public final C0283c mo1589b() {
        return this.f2008a.mo1713b();
    }

    /* renamed from: f */
    public final C0281a mo1663f() {
        return this.f2008a;
    }
}
