package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0265j;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import java.util.Collection;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.a.b.s */
public final class C0172s extends C0128ab {

    /* renamed from: a */
    private final TreeMap<C0265j, C0171r> f1372a = new TreeMap<>();

    public C0172s(C0165l lVar) {
        super("field_ids", lVar);
    }

    /* renamed from: a */
    public C0171r mo1506a(C0265j jVar) {
        if (jVar == null) {
            throw new NullPointerException("field == null");
        }
        mo1401j();
        C0171r rVar = (C0171r) this.f1372a.get(jVar);
        if (rVar != null) {
            return rVar;
        }
        C0171r rVar2 = new C0171r(jVar);
        this.f1372a.put(jVar, rVar2);
        return rVar2;
    }

    /* renamed from: a */
    public C0176w mo1507a(C0255a aVar) {
        if (aVar == null) {
            throw new NullPointerException("cst == null");
        }
        mo1400i();
        C0176w wVar = (C0176w) this.f1372a.get((C0265j) aVar);
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalArgumentException("not found");
    }

    /* renamed from: a */
    public Collection<? extends C0177x> mo1362a() {
        return this.f1372a.values();
    }

    /* renamed from: a */
    public void mo1508a(C0286a aVar) {
        mo1400i();
        int size = this.f1372a.size();
        int g = size == 0 ? 0 : mo1398g();
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("field_ids_size:  ");
            sb.append(C0295i.m2044a(size));
            aVar.mo1739a(4, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("field_ids_off:   ");
            sb2.append(C0295i.m2044a(g));
            aVar.mo1739a(4, sb2.toString());
        }
        aVar.mo1755d(size);
        aVar.mo1755d(g);
    }

    /* renamed from: b */
    public int mo1509b(C0265j jVar) {
        if (jVar == null) {
            throw new NullPointerException("ref == null");
        }
        mo1400i();
        C0171r rVar = (C0171r) this.f1372a.get(jVar);
        if (rVar != null) {
            return rVar.mo1513g();
        }
        throw new IllegalArgumentException("not found");
    }
}
