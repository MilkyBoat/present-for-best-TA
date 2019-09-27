package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0259d;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import java.util.Collection;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.a.b.ae */
public final class C0131ae extends C0128ab {

    /* renamed from: a */
    private final TreeMap<C0259d, C0130ad> f1246a = new TreeMap<>();

    public C0131ae(C0165l lVar) {
        super("method_ids", lVar);
    }

    /* renamed from: a */
    public C0130ad mo1360a(C0259d dVar) {
        if (dVar == null) {
            throw new NullPointerException("method == null");
        }
        mo1401j();
        C0130ad adVar = (C0130ad) this.f1246a.get(dVar);
        if (adVar != null) {
            return adVar;
        }
        C0130ad adVar2 = new C0130ad(dVar);
        this.f1246a.put(dVar, adVar2);
        return adVar2;
    }

    /* renamed from: a */
    public C0176w mo1361a(C0255a aVar) {
        if (aVar == null) {
            throw new NullPointerException("cst == null");
        }
        mo1400i();
        C0176w wVar = (C0176w) this.f1246a.get((C0259d) aVar);
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalArgumentException("not found");
    }

    /* renamed from: a */
    public Collection<? extends C0177x> mo1362a() {
        return this.f1246a.values();
    }

    /* renamed from: a */
    public void mo1363a(C0286a aVar) {
        mo1400i();
        int size = this.f1246a.size();
        int g = size == 0 ? 0 : mo1398g();
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("method_ids_size: ");
            sb.append(C0295i.m2044a(size));
            aVar.mo1739a(4, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("method_ids_off:  ");
            sb2.append(C0295i.m2044a(g));
            aVar.mo1739a(4, sb2.toString());
        }
        aVar.mo1755d(size);
        aVar.mo1755d(g);
    }

    /* renamed from: b */
    public int mo1364b(C0259d dVar) {
        if (dVar == null) {
            throw new NullPointerException("ref == null");
        }
        mo1400i();
        C0130ad adVar = (C0130ad) this.f1246a.get(dVar);
        if (adVar != null) {
            return adVar.mo1513g();
        }
        throw new IllegalArgumentException("not found");
    }
}
