package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p009a.C0123b;
import java.util.ArrayList;

/* renamed from: com.android.cglib.dx.a.a.s */
public final class C0111s {

    /* renamed from: a */
    private final C0112t f1201a;

    /* renamed from: b */
    private ArrayList<C0097h> f1202b;

    public C0111s(C0123b bVar, int i, int i2, int i3) {
        this.f1201a = new C0112t(bVar, i, i3);
        this.f1202b = new ArrayList<>(i2);
    }

    /* renamed from: b */
    private void m1228b() {
        int size = this.f1202b.size();
        for (int i = 0; i < size; i++) {
            this.f1201a.mo1315a((C0097h) this.f1202b.get(i));
        }
        this.f1202b = null;
    }

    /* renamed from: a */
    public C0112t mo1310a() {
        if (this.f1202b == null) {
            throw new UnsupportedOperationException("already processed");
        }
        m1228b();
        return this.f1201a;
    }

    /* renamed from: a */
    public void mo1311a(int i, C0093e eVar) {
        this.f1201a.mo1313a(i, eVar);
    }

    /* renamed from: a */
    public void mo1312a(C0097h hVar) {
        this.f1201a.mo1315a(hVar);
    }
}
