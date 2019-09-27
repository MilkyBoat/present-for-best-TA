package com.android.cglib.p008dx.p015c.p016a;

import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p020d.C0301o;
import com.android.cglib.p008dx.p020d.C0304r;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.c.a.a */
public final class C0225a extends C0301o implements C0304r, Comparable<C0225a> {

    /* renamed from: a */
    private final C0278w f1725a;

    /* renamed from: b */
    private final C0226b f1726b;

    /* renamed from: c */
    private final TreeMap<C0277v, C0228d> f1727c;

    /* renamed from: a */
    public int compareTo(C0225a aVar) {
        int a = this.f1725a.compareTo(aVar.f1725a);
        if (a != 0) {
            return a;
        }
        int compareTo = this.f1726b.compareTo(aVar.f1726b);
        if (compareTo != 0) {
            return compareTo;
        }
        Iterator it = this.f1727c.values().iterator();
        Iterator it2 = aVar.f1727c.values().iterator();
        while (it.hasNext() && it2.hasNext()) {
            int a2 = ((C0228d) it.next()).compareTo((C0228d) it2.next());
            if (a2 != 0) {
                return a2;
            }
        }
        if (it.hasNext()) {
            return 1;
        }
        return it2.hasNext() ? -1 : 0;
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1726b.mo1218a_());
        sb.append("-annotation ");
        sb.append(this.f1725a.mo1218a_());
        sb.append(" {");
        boolean z = true;
        for (C0228d dVar : this.f1727c.values()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(dVar.mo1535a().mo1218a_());
            sb.append(": ");
            sb.append(dVar.mo1536b().mo1218a_());
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: b */
    public C0278w mo1522b() {
        return this.f1725a;
    }

    /* renamed from: c */
    public C0226b mo1523c() {
        return this.f1726b;
    }

    /* renamed from: d */
    public Collection<C0228d> mo1525d() {
        return Collections.unmodifiableCollection(this.f1727c.values());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0225a)) {
            return false;
        }
        C0225a aVar = (C0225a) obj;
        if (!this.f1725a.equals(aVar.f1725a) || this.f1726b != aVar.f1726b) {
            return false;
        }
        return this.f1727c.equals(aVar.f1727c);
    }

    public int hashCode() {
        return (((this.f1725a.hashCode() * 31) + this.f1727c.hashCode()) * 31) + this.f1726b.hashCode();
    }

    public String toString() {
        return mo1218a_();
    }
}
