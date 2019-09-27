package com.android.cglib.p008dx.p015c.p018c;

/* renamed from: com.android.cglib.dx.c.c.n */
public abstract class C0269n extends C0271p {

    /* renamed from: a */
    private final int f2029a;

    C0269n(int i) {
        this.f2029a = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo1647b(C0255a aVar) {
        int i = ((C0269n) aVar).f2029a;
        if (this.f2029a < i) {
            return -1;
        }
        return this.f2029a > i ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.f2029a == ((C0269n) obj).f2029a;
    }

    /* renamed from: f */
    public final boolean mo1674f() {
        return true;
    }

    /* renamed from: g */
    public final int mo1675g() {
        return this.f2029a;
    }

    /* renamed from: h */
    public final long mo1676h() {
        return (long) this.f2029a;
    }

    public final int hashCode() {
        return this.f2029a;
    }
}
