package com.android.cglib.p008dx;

import com.android.cglib.p008dx.p015c.p017b.C0244m;

/* renamed from: com.android.cglib.dx.Local */
public final class Local<T> {

    /* renamed from: a */
    final TypeId<T> f846a;

    /* renamed from: b */
    private final Code f847b;

    /* renamed from: c */
    private int f848c = -1;

    /* renamed from: d */
    private C0244m f849d;

    private Local(Code code, TypeId<T> typeId) {
        this.f847b = code;
        this.f846a = typeId;
    }

    /* renamed from: a */
    static <T> Local<T> m860a(Code code, TypeId<T> typeId) {
        return new Local<>(code, typeId);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo1165a() {
        return this.f846a.f858b.mo1729g();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo1166a(int i) {
        this.f848c = i;
        this.f849d = C0244m.m1722a(i, this.f846a.f858b);
        return mo1165a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0244m mo1167b() {
        if (this.f849d == null) {
            this.f847b.mo1106a();
            if (this.f849d == null) {
                throw new AssertionError();
            }
        }
        return this.f849d;
    }

    public TypeId getType() {
        return this.f846a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("v");
        sb.append(this.f848c);
        sb.append("(");
        sb.append(this.f846a);
        sb.append(")");
        return sb.toString();
    }
}
