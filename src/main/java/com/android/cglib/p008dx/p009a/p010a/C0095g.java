package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import java.util.HashSet;

/* renamed from: com.android.cglib.dx.a.a.g */
public final class C0095g {

    /* renamed from: a */
    private final int f903a;

    /* renamed from: b */
    private C0112t f904b;

    /* renamed from: c */
    private C0088b f905c;

    /* renamed from: d */
    private C0091d f906d;

    /* renamed from: e */
    private C0113u f907e;

    /* renamed from: f */
    private C0105p f908f;

    /* renamed from: g */
    private C0098i f909g;

    /* renamed from: com.android.cglib.dx.a.a.g$a */
    public interface C0096a {
        /* renamed from: a */
        int mo1255a(C0255a aVar);
    }

    public C0095g(int i, C0112t tVar, C0088b bVar) {
        if (tVar == null) {
            throw new NullPointerException("unprocessedInsns == null");
        } else if (bVar == null) {
            throw new NullPointerException("unprocessedCatches == null");
        } else {
            this.f903a = i;
            this.f904b = tVar;
            this.f905c = bVar;
            this.f906d = null;
            this.f907e = null;
            this.f908f = null;
            this.f909g = null;
        }
    }

    /* renamed from: j */
    private void m1087j() {
        if (this.f909g == null) {
            this.f909g = this.f904b.mo1319d();
            this.f907e = C0113u.m1255a(this.f909g, this.f903a);
            this.f908f = C0105p.m1192a(this.f909g);
            this.f906d = this.f905c.mo1211a();
            this.f904b = null;
            this.f905c = null;
        }
    }

    /* renamed from: a */
    public void mo1245a(C0096a aVar) {
        this.f904b.mo1314a(aVar);
    }

    /* renamed from: a */
    public boolean mo1246a() {
        return this.f903a != 1 && this.f904b.mo1316a();
    }

    /* renamed from: b */
    public boolean mo1247b() {
        return this.f904b.mo1317b();
    }

    /* renamed from: c */
    public boolean mo1248c() {
        return this.f905c.mo1212b();
    }

    /* renamed from: d */
    public HashSet<C0283c> mo1249d() {
        return this.f905c.mo1213c();
    }

    /* renamed from: e */
    public HashSet<C0255a> mo1250e() {
        return this.f904b.mo1318c();
    }

    /* renamed from: f */
    public C0098i mo1251f() {
        m1087j();
        return this.f909g;
    }

    /* renamed from: g */
    public C0091d mo1252g() {
        m1087j();
        return this.f906d;
    }

    /* renamed from: h */
    public C0113u mo1253h() {
        m1087j();
        return this.f907e;
    }

    /* renamed from: i */
    public C0105p mo1254i() {
        m1087j();
        return this.f908f;
    }
}
