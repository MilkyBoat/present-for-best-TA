package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p015c.p017b.C0235f.C0237b;
import com.android.cglib.p008dx.p020d.C0295i;
import com.android.cglib.p008dx.p020d.C0297k;
import com.android.cglib.p008dx.p020d.C0298l;
import com.android.cglib.p008dx.p020d.C0299m;

/* renamed from: com.android.cglib.dx.c.b.c */
public final class C0231c extends C0299m {

    /* renamed from: a */
    private int f1742a = -1;

    /* renamed from: com.android.cglib.dx.c.b.c$a */
    private static class C0232a implements C0237b {

        /* renamed from: a */
        private int f1743a = 0;

        /* renamed from: a */
        private void m1676a(C0235f fVar) {
            C0244m f = fVar.mo1566f();
            if (f != null) {
                m1677a(f);
            }
            C0247n g = fVar.mo1567g();
            int a = g.mo1772a();
            for (int i = 0; i < a; i++) {
                m1677a(g.mo1614b(i));
            }
        }

        /* renamed from: a */
        private void m1677a(C0244m mVar) {
            int h = mVar.mo1600h();
            if (h > this.f1743a) {
                this.f1743a = h;
            }
        }

        /* renamed from: a */
        public int mo1557a() {
            return this.f1743a;
        }

        /* renamed from: a */
        public void mo1323a(C0241j jVar) {
            m1676a((C0235f) jVar);
        }

        /* renamed from: a */
        public void mo1325a(C0242k kVar) {
            m1676a((C0235f) kVar);
        }

        /* renamed from: a */
        public void mo1326a(C0253t tVar) {
            m1676a((C0235f) tVar);
        }

        /* renamed from: a */
        public void mo1327a(C0254u uVar) {
            m1676a((C0235f) uVar);
        }
    }

    public C0231c(int i) {
        super(i);
    }

    /* renamed from: a */
    public C0230b mo1215a(int i) {
        return (C0230b) mo1776d(i);
    }

    /* renamed from: a */
    public C0230b mo1551a(C0230b bVar) {
        int d = bVar.mo1544d();
        C0297k c = bVar.mo1543c();
        switch (c.mo1784a()) {
            case 0:
                return null;
            case 1:
                break;
            default:
                if (d != -1) {
                    return mo1555b(d);
                }
                break;
        }
        return mo1555b(c.mo1785a(0));
    }

    /* renamed from: a */
    public void mo1552a(int i, C0230b bVar) {
        super.mo1796a(i, (C0298l) bVar);
        this.f1742a = -1;
    }

    /* renamed from: a */
    public void mo1553a(C0237b bVar) {
        int a = mo1772a();
        for (int i = 0; i < a; i++) {
            mo1215a(i).mo1542b().mo1573a(bVar);
        }
    }

    /* renamed from: b */
    public int mo1554b() {
        if (this.f1742a == -1) {
            C0232a aVar = new C0232a();
            mo1553a((C0237b) aVar);
            this.f1742a = aVar.mo1557a();
        }
        return this.f1742a;
    }

    /* renamed from: b */
    public C0230b mo1555b(int i) {
        int c = mo1797c(i);
        if (c >= 0) {
            return mo1215a(c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("no such label: ");
        sb.append(C0295i.m2048c(i));
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: c */
    public int mo1556c() {
        int a = mo1772a();
        int i = 0;
        for (int i2 = 0; i2 < a; i2++) {
            C0230b bVar = (C0230b) mo1777e(i2);
            if (bVar != null) {
                i += bVar.mo1542b().mo1772a();
            }
        }
        return i;
    }
}
