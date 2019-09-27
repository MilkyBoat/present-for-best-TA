package com.android.cglib.p008dx.p015c.p018c;

/* renamed from: com.android.cglib.dx.c.c.o */
public abstract class C0270o extends C0271p {

    /* renamed from: a */
    private final long f2030a;

    C0270o(long j) {
        this.f2030a = j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo1647b(C0255a aVar) {
        long j = ((C0270o) aVar).f2030a;
        if (this.f2030a < j) {
            return -1;
        }
        return this.f2030a > j ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.f2030a == ((C0270o) obj).f2030a;
    }

    /* renamed from: f */
    public final boolean mo1674f() {
        return ((long) ((int) this.f2030a)) == this.f2030a;
    }

    /* renamed from: g */
    public final int mo1675g() {
        return (int) this.f2030a;
    }

    /* renamed from: h */
    public final long mo1676h() {
        return this.f2030a;
    }

    public final int hashCode() {
        return ((int) this.f2030a) ^ ((int) (this.f2030a >> 32));
    }
}
