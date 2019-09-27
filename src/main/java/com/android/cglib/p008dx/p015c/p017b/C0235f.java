package com.android.cglib.p008dx.p015c.p017b;

import com.android.cglib.p008dx.p015c.p019d.C0285e;
import com.android.cglib.p008dx.p020d.C0304r;

/* renamed from: com.android.cglib.dx.c.b.f */
public abstract class C0235f implements C0304r {

    /* renamed from: a */
    private final C0249p f1761a;

    /* renamed from: b */
    private final C0252s f1762b;

    /* renamed from: c */
    private final C0244m f1763c;

    /* renamed from: d */
    private final C0247n f1764d;

    /* renamed from: com.android.cglib.dx.c.b.f$a */
    public static class C0236a implements C0237b {
        /* renamed from: a */
        public void mo1323a(C0241j jVar) {
        }

        /* renamed from: a */
        public void mo1325a(C0242k kVar) {
        }

        /* renamed from: a */
        public void mo1326a(C0253t tVar) {
        }

        /* renamed from: a */
        public void mo1327a(C0254u uVar) {
        }
    }

    /* renamed from: com.android.cglib.dx.c.b.f$b */
    public interface C0237b {
        /* renamed from: a */
        void mo1323a(C0241j jVar);

        /* renamed from: a */
        void mo1325a(C0242k kVar);

        /* renamed from: a */
        void mo1326a(C0253t tVar);

        /* renamed from: a */
        void mo1327a(C0254u uVar);
    }

    public C0235f(C0249p pVar, C0252s sVar, C0244m mVar, C0247n nVar) {
        if (pVar == null) {
            throw new NullPointerException("opcode == null");
        } else if (sVar == null) {
            throw new NullPointerException("position == null");
        } else if (nVar == null) {
            throw new NullPointerException("sources == null");
        } else {
            this.f1761a = pVar;
            this.f1762b = sVar;
            this.f1763c = mVar;
            this.f1764d = nVar;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String mo1560a(String str) {
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append("Insn{");
        stringBuffer.append(this.f1762b);
        stringBuffer.append(' ');
        stringBuffer.append(this.f1761a);
        if (str != null) {
            stringBuffer.append(' ');
            stringBuffer.append(str);
        }
        stringBuffer.append(" :: ");
        if (this.f1763c != null) {
            stringBuffer.append(this.f1763c);
            stringBuffer.append(" <- ");
        }
        stringBuffer.append(this.f1764d);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public abstract void mo1561a(C0237b bVar);

    /* renamed from: a_ */
    public String mo1218a_() {
        return mo1562b(mo1558b());
    }

    /* renamed from: b */
    public String mo1558b() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final String mo1562b(String str) {
        String a_;
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append(this.f1762b);
        stringBuffer.append(": ");
        stringBuffer.append(this.f1761a.mo1632e());
        if (str != null) {
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")");
        }
        if (this.f1763c == null) {
            a_ = " .";
        } else {
            stringBuffer.append(" ");
            a_ = this.f1763c.mo1218a_();
        }
        stringBuffer.append(a_);
        stringBuffer.append(" <-");
        int a = this.f1764d.mo1772a();
        if (a == 0) {
            stringBuffer.append(" .");
        } else {
            for (int i = 0; i < a; i++) {
                stringBuffer.append(" ");
                stringBuffer.append(this.f1764d.mo1614b(i).mo1218a_());
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: d */
    public final C0249p mo1563d() {
        return this.f1761a;
    }

    /* renamed from: e */
    public final C0252s mo1564e() {
        return this.f1762b;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    /* renamed from: f */
    public final C0244m mo1566f() {
        return this.f1763c;
    }

    /* renamed from: g */
    public final C0247n mo1567g() {
        return this.f1764d;
    }

    /* renamed from: h */
    public final boolean mo1568h() {
        return this.f1761a.mo1634f();
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    /* renamed from: i */
    public abstract C0285e mo1570i();

    public String toString() {
        return mo1560a(mo1558b());
    }
}
