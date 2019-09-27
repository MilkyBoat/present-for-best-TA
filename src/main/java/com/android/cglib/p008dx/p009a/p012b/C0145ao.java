package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import java.util.Collection;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.a.b.ao */
public final class C0145ao extends C0149as {

    /* renamed from: a */
    private final TreeMap<C0277v, C0144an> f1281a = new TreeMap<>();

    public C0145ao(C0165l lVar) {
        super("string_ids", lVar, 4);
    }

    /* renamed from: a */
    public C0144an mo1412a(C0144an anVar) {
        if (anVar == null) {
            throw new NullPointerException("string == null");
        }
        mo1401j();
        C0277v c = anVar.mo1408c();
        C0144an anVar2 = (C0144an) this.f1281a.get(c);
        if (anVar2 != null) {
            return anVar2;
        }
        this.f1281a.put(c, anVar);
        return anVar;
    }

    /* renamed from: a */
    public C0144an mo1413a(C0277v vVar) {
        return mo1412a(new C0144an(vVar));
    }

    /* renamed from: a */
    public C0176w mo1414a(C0255a aVar) {
        if (aVar == null) {
            throw new NullPointerException("cst == null");
        }
        mo1400i();
        C0176w wVar = (C0176w) this.f1281a.get((C0277v) aVar);
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalArgumentException("not found");
    }

    /* renamed from: a */
    public Collection<? extends C0177x> mo1362a() {
        return this.f1281a.values();
    }

    /* renamed from: b */
    public int mo1415b(C0277v vVar) {
        if (vVar == null) {
            throw new NullPointerException("string == null");
        }
        mo1400i();
        C0144an anVar = (C0144an) this.f1281a.get(vVar);
        if (anVar != null) {
            return anVar.mo1513g();
        }
        throw new IllegalArgumentException("not found");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1352b() {
        int i = 0;
        for (C0144an a : this.f1281a.values()) {
            a.mo1511a(i);
            i++;
        }
    }

    /* renamed from: b */
    public void mo1416b(C0286a aVar) {
        mo1400i();
        int size = this.f1281a.size();
        int g = size == 0 ? 0 : mo1398g();
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("string_ids_size: ");
            sb.append(C0295i.m2044a(size));
            aVar.mo1739a(4, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("string_ids_off:  ");
            sb2.append(C0295i.m2044a(g));
            aVar.mo1739a(4, sb2.toString());
        }
        aVar.mo1755d(size);
        aVar.mo1755d(g);
    }
}
