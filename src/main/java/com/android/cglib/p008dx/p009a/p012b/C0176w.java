package com.android.cglib.p008dx.p009a.p012b;

/* renamed from: com.android.cglib.dx.a.b.w */
public abstract class C0176w extends C0177x {

    /* renamed from: a */
    private int f1375a = -1;

    /* renamed from: a */
    public final void mo1511a(int i) {
        if (this.f1375a != -1) {
            throw new RuntimeException("index already set");
        }
        this.f1375a = i;
    }

    /* renamed from: f */
    public final boolean mo1512f() {
        return this.f1375a >= 0;
    }

    /* renamed from: g */
    public final int mo1513g() {
        if (this.f1375a >= 0) {
            return this.f1375a;
        }
        throw new RuntimeException("index not yet set");
    }

    /* renamed from: h */
    public final String mo1514h() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(Integer.toHexString(this.f1375a));
        sb.append(']');
        return sb.toString();
    }
}
