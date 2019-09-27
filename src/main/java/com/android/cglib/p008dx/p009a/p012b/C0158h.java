package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p015c.p019d.C0285e;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.a.b.h */
public final class C0158h extends C0149as {

    /* renamed from: a */
    private final TreeMap<C0283c, C0157g> f1316a = new TreeMap<>();

    /* renamed from: b */
    private ArrayList<C0157g> f1317b = null;

    public C0158h(C0165l lVar) {
        super("class_defs", lVar, 4);
    }

    /* renamed from: a */
    private int m1513a(C0283c cVar, int i, int i2) {
        C0157g gVar = (C0157g) this.f1316a.get(cVar);
        if (gVar != null) {
            if (gVar.mo1512f()) {
                return i;
            }
            if (i2 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("class circularity with ");
                sb.append(cVar);
                throw new RuntimeException(sb.toString());
            }
            int i3 = i2 - 1;
            C0278w d = gVar.mo1449d();
            if (d != null) {
                i = m1513a(d.mo1706f(), i, i3);
            }
            C0285e e = gVar.mo1450e();
            int a = e.mo1738a();
            for (int i4 = 0; i4 < a; i4++) {
                i = m1513a(e.mo1215a(i4), i, i3);
            }
            gVar.mo1511a(i);
            this.f1317b.add(gVar);
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public Collection<? extends C0177x> mo1362a() {
        return this.f1317b != null ? this.f1317b : this.f1316a.values();
    }

    /* renamed from: a */
    public void mo1451a(C0157g gVar) {
        try {
            C0283c f = gVar.mo1448c().mo1706f();
            mo1401j();
            if (this.f1316a.get(f) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("already added: ");
                sb.append(f);
                throw new IllegalArgumentException(sb.toString());
            }
            this.f1316a.put(f, gVar);
        } catch (NullPointerException unused) {
            throw new NullPointerException("clazz == null");
        }
    }

    /* renamed from: a */
    public void mo1452a(C0286a aVar) {
        mo1400i();
        int size = this.f1316a.size();
        int g = size == 0 ? 0 : mo1398g();
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("class_defs_size: ");
            sb.append(C0295i.m2044a(size));
            aVar.mo1739a(4, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("class_defs_off:  ");
            sb2.append(C0295i.m2044a(g));
            aVar.mo1739a(4, sb2.toString());
        }
        aVar.mo1755d(size);
        aVar.mo1755d(g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1352b() {
        int size = this.f1316a.size();
        this.f1317b = new ArrayList<>(size);
        int i = 0;
        for (C0283c a : this.f1316a.keySet()) {
            i = m1513a(a, i, size - i);
        }
    }
}
