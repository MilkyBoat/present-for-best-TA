package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p017b.C0252s;
import com.android.cglib.p008dx.p015c.p018c.C0255a;

/* renamed from: com.android.cglib.dx.a.a.f */
public final class C0094f extends C0101l {

    /* renamed from: a */
    private final C0255a f900a;

    /* renamed from: b */
    private int f901b;

    /* renamed from: c */
    private int f902c;

    public C0094f(C0099j jVar, C0252s sVar, C0247n nVar, C0255a aVar) {
        super(jVar, sVar, nVar);
        if (aVar == null) {
            throw new NullPointerException("constant == null");
        }
        this.f900a = aVar;
        this.f901b = -1;
        this.f902c = -1;
    }

    /* renamed from: a */
    public C0097h mo1207a(C0099j jVar) {
        C0094f fVar = new C0094f(jVar, mo1265h(), mo1266i(), this.f900a);
        if (this.f901b >= 0) {
            fVar.mo1240a(this.f901b);
        }
        if (this.f902c >= 0) {
            fVar.mo1242b(this.f902c);
        }
        return fVar;
    }

    /* renamed from: a */
    public C0097h mo1237a(C0247n nVar) {
        C0094f fVar = new C0094f(mo1264g(), mo1265h(), nVar, this.f900a);
        if (this.f901b >= 0) {
            fVar.mo1240a(this.f901b);
        }
        if (this.f902c >= 0) {
            fVar.mo1242b(this.f902c);
        }
        return fVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo1238a() {
        return this.f900a.mo1218a_();
    }

    /* renamed from: a */
    public void mo1240a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index < 0");
        } else if (this.f901b >= 0) {
            throw new RuntimeException("index already set");
        } else {
            this.f901b = i;
        }
    }

    /* renamed from: b */
    public C0255a mo1241b() {
        return this.f900a;
    }

    /* renamed from: b */
    public void mo1242b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index < 0");
        } else if (this.f902c >= 0) {
            throw new RuntimeException("class index already set");
        } else {
            this.f902c = i;
        }
    }

    /* renamed from: c */
    public int mo1243c() {
        if (this.f901b >= 0) {
            return this.f901b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("index not yet set for ");
        sb.append(this.f900a);
        throw new RuntimeException(sb.toString());
    }

    /* renamed from: d */
    public boolean mo1244d() {
        return this.f901b >= 0;
    }
}
