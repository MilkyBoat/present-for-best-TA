package com.android.cglib.p008dx.p015c.p016a;

import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p020d.C0301o;
import java.util.Iterator;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.c.a.c */
public final class C0227c extends C0301o implements Comparable<C0227c> {

    /* renamed from: a */
    public static final C0227c f1734a = new C0227c();

    /* renamed from: b */
    private final TreeMap<C0278w, C0225a> f1735b = new TreeMap<>();

    static {
        f1734a.mo1799e();
    }

    /* renamed from: a */
    public int compareTo(C0227c cVar) {
        Iterator it = this.f1735b.values().iterator();
        Iterator it2 = cVar.f1735b.values().iterator();
        while (it.hasNext() && it2.hasNext()) {
            int a = ((C0225a) it.next()).compareTo((C0225a) it2.next());
            if (a != 0) {
                return a;
            }
        }
        if (it.hasNext()) {
            return 1;
        }
        return it2.hasNext() ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0227c)) {
            return false;
        }
        return this.f1735b.equals(((C0227c) obj).f1735b);
    }

    public int hashCode() {
        return this.f1735b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("annotations{");
        boolean z = true;
        for (C0225a aVar : this.f1735b.values()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(aVar.mo1218a_());
        }
        sb.append("}");
        return sb.toString();
    }
}
