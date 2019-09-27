package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p017b.C0230b;
import com.android.cglib.p008dx.p015c.p017b.C0231c;
import com.android.cglib.p008dx.p015c.p017b.C0250q;
import com.android.cglib.p008dx.p015c.p017b.C0252s;

/* renamed from: com.android.cglib.dx.a.a.a */
public final class C0057a {

    /* renamed from: a */
    private final C0093e[] f862a;

    /* renamed from: b */
    private final C0093e[] f863b;

    /* renamed from: c */
    private final C0093e[] f864c;

    public C0057a(C0250q qVar) {
        int d = qVar.mo1637a().mo1798d();
        this.f862a = new C0093e[d];
        this.f863b = new C0093e[d];
        this.f864c = new C0093e[d];
        m877a(qVar);
    }

    /* renamed from: a */
    private void m877a(C0250q qVar) {
        C0231c a = qVar.mo1637a();
        int a2 = a.mo1772a();
        for (int i = 0; i < a2; i++) {
            C0230b a3 = a.mo1215a(i);
            int a4 = a3.mo1541a();
            this.f862a[a4] = new C0093e(a3.mo1542b().mo1215a(0).mo1564e());
            C0252s e = a3.mo1547f().mo1564e();
            this.f863b[a4] = new C0093e(e);
            this.f864c[a4] = new C0093e(e);
        }
    }

    /* renamed from: a */
    public C0093e mo1196a(int i) {
        return this.f862a[i];
    }

    /* renamed from: a */
    public C0093e mo1197a(C0230b bVar) {
        return this.f862a[bVar.mo1541a()];
    }

    /* renamed from: b */
    public C0093e mo1198b(C0230b bVar) {
        return this.f863b[bVar.mo1541a()];
    }

    /* renamed from: c */
    public C0093e mo1199c(C0230b bVar) {
        return this.f864c[bVar.mo1541a()];
    }
}
