package com.android.cglib.p008dx.p020d;

/* renamed from: com.android.cglib.dx.d.o */
public class C0301o {

    /* renamed from: a */
    private boolean f2174a;

    public C0301o() {
        this.f2174a = true;
    }

    public C0301o(boolean z) {
        this.f2174a = z;
    }

    /* renamed from: e */
    public void mo1799e() {
        this.f2174a = false;
    }

    /* renamed from: f */
    public final boolean mo1800f() {
        return !this.f2174a;
    }

    /* renamed from: g */
    public final boolean mo1801g() {
        return this.f2174a;
    }

    /* renamed from: h */
    public final void mo1802h() {
        if (!this.f2174a) {
            throw new C0302p("immutable instance");
        }
    }

    /* renamed from: i */
    public final void mo1803i() {
        if (this.f2174a) {
            throw new C0302p("mutable instance");
        }
    }
}
