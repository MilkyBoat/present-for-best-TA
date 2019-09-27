package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p020d.C0301o;
import java.util.HashMap;

/* renamed from: com.android.cglib.dx.c.b.i */
public final class C0240i extends C0301o {

    /* renamed from: a */
    private final C0248o f1767a;

    /* renamed from: b */
    private final C0248o[] f1768b;

    /* renamed from: c */
    private final HashMap<C0235f, C0244m> f1769c;

    /* renamed from: b */
    private C0248o m1712b(int i) {
        try {
            return this.f1768b[i];
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("bogus label");
        }
    }

    /* renamed from: a */
    public int mo1582a() {
        return this.f1769c.size();
    }

    /* renamed from: a */
    public C0244m mo1583a(C0235f fVar) {
        return (C0244m) this.f1769c.get(fVar);
    }

    /* renamed from: a */
    public C0248o mo1584a(int i) {
        C0248o b = m1712b(i);
        return b != null ? b : this.f1767a;
    }

    /* renamed from: a */
    public C0248o mo1585a(C0230b bVar) {
        return mo1584a(bVar.mo1541a());
    }
}
