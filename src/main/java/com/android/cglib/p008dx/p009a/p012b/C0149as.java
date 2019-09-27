package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p020d.C0286a;
import java.util.Collection;

/* renamed from: com.android.cglib.dx.a.b.as */
public abstract class C0149as extends C0140ak {
    public C0149as(String str, C0165l lVar, int i) {
        super(str, lVar, i);
    }

    /* renamed from: a */
    public final int mo1365a(C0177x xVar) {
        C0176w wVar = (C0176w) xVar;
        return mo1393c(wVar.mo1513g() * wVar.mo1349b_());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public final void mo1368a_(C0286a aVar) {
        C0165l e = mo1396e();
        int f = mo1397f();
        for (C0177x a : mo1362a()) {
            a.mo1347a(e, aVar);
            aVar.mo1763h(f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo1352b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo1370c() {
        C0165l e = mo1396e();
        mo1352b();
        for (C0177x a : mo1362a()) {
            a.mo1340a(e);
        }
    }

    /* renamed from: c_ */
    public final int mo1371c_() {
        Collection a = mo1362a();
        int size = a.size();
        if (size == 0) {
            return 0;
        }
        return size * ((C0177x) a.iterator().next()).mo1349b_();
    }
}
