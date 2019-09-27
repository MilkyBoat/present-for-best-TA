package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p019d.C0281a;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import java.util.Collection;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.a.b.aj */
public final class C0139aj extends C0149as {

    /* renamed from: a */
    private final TreeMap<C0281a, C0138ai> f1266a = new TreeMap<>();

    public C0139aj(C0165l lVar) {
        super("proto_ids", lVar, 4);
    }

    /* renamed from: a */
    public C0138ai mo1389a(C0281a aVar) {
        if (aVar == null) {
            throw new NullPointerException("prototype == null");
        }
        mo1401j();
        C0138ai aiVar = (C0138ai) this.f1266a.get(aVar);
        if (aiVar != null) {
            return aiVar;
        }
        C0138ai aiVar2 = new C0138ai(aVar);
        this.f1266a.put(aVar, aiVar2);
        return aiVar2;
    }

    /* renamed from: a */
    public Collection<? extends C0177x> mo1362a() {
        return this.f1266a.values();
    }

    /* renamed from: b */
    public int mo1390b(C0281a aVar) {
        if (aVar == null) {
            throw new NullPointerException("prototype == null");
        }
        mo1400i();
        C0138ai aiVar = (C0138ai) this.f1266a.get(aVar);
        if (aiVar != null) {
            return aiVar.mo1513g();
        }
        throw new IllegalArgumentException("not found");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1352b() {
        int i = 0;
        for (C0138ai a : mo1362a()) {
            a.mo1511a(i);
            i++;
        }
    }

    /* renamed from: b */
    public void mo1391b(C0286a aVar) {
        mo1400i();
        int size = this.f1266a.size();
        int g = size == 0 ? 0 : mo1398g();
        if (size > 65536) {
            throw new UnsupportedOperationException("too many proto ids");
        }
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("proto_ids_size:  ");
            sb.append(C0295i.m2044a(size));
            aVar.mo1739a(4, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("proto_ids_off:   ");
            sb2.append(C0295i.m2044a(g));
            aVar.mo1739a(4, sb2.toString());
        }
        aVar.mo1755d(size);
        aVar.mo1755d(g);
    }
}
