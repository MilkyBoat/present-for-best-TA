package com.p021b.p022a.p024b;

import java.util.LinkedList;

/* renamed from: com.b.a.b.r */
public class C0429r {

    /* renamed from: a */
    long f3034a = -1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0426o f3035b;

    /* renamed from: c */
    private LinkedList<C0431a> f3036c = new LinkedList<>();

    /* renamed from: d */
    private boolean f3037d = false;

    /* renamed from: e */
    private int f3038e = 0;

    /* renamed from: f */
    private int f3039f = 0;

    /* renamed from: com.b.a.b.r$a */
    private abstract class C0431a {

        /* renamed from: a */
        public int f3040a;

        /* renamed from: b */
        public int f3041b;

        /* renamed from: c */
        public String f3042c;

        /* renamed from: d */
        public int f3043d;

        private C0431a() {
        }

        /* renamed from: a */
        public abstract void mo3090a();

        /* renamed from: a */
        public abstract boolean mo3091a(int i, int i2, long j);

        /* renamed from: b */
        public abstract void mo3092b();

        /* renamed from: c */
        public abstract void mo3093c();

        /* renamed from: d */
        public abstract int mo3094d();

        /* renamed from: e */
        public abstract int mo3095e();
    }

    /* renamed from: com.b.a.b.r$b */
    private class C0432b extends C0431a {
        public C0432b(int i, int i2, int i3) {
            super();
            this.f3040a = i;
            this.f3041b = i2;
            this.f3043d = i3;
        }

        /* renamed from: a */
        public void mo3090a() {
            if (this.f3042c == null) {
                mo3093c();
                C0429r.this.f3035b.mo2959a(this.f3041b);
                return;
            }
            C0429r.this.f3035b.mo2963a(this.f3042c.toCharArray(), this.f3040a, 0, false);
        }

        /* renamed from: a */
        public boolean mo3091a(int i, int i2, long j) {
            if (C0429r.this.f3034a < 0 || j - C0429r.this.f3034a >= 1000000000 || i != ((this.f3040a - this.f3041b) - i2) + 1) {
                return false;
            }
            this.f3040a = i;
            this.f3041b += i2;
            C0429r.this.m2731h();
            return true;
        }

        /* renamed from: b */
        public void mo3092b() {
            C0429r.this.f3035b.mo2960a(this.f3040a, this.f3041b, 0, false);
        }

        /* renamed from: c */
        public void mo3093c() {
            this.f3042c = new String(C0429r.this.f3035b.mo3063j(this.f3041b));
        }

        /* renamed from: d */
        public int mo3094d() {
            return this.f3040a + this.f3041b;
        }

        /* renamed from: e */
        public int mo3095e() {
            return this.f3040a;
        }
    }

    /* renamed from: com.b.a.b.r$c */
    private class C0433c extends C0431a {
        public C0433c(int i, int i2, int i3) {
            super();
            this.f3040a = i;
            this.f3041b = i2;
            this.f3043d = i3;
        }

        /* renamed from: a */
        public void mo3090a() {
            if (this.f3042c == null) {
                mo3093c();
                C0429r.this.f3035b.mo2959a(-this.f3041b);
                return;
            }
            C0429r.this.f3035b.mo2960a(this.f3040a, this.f3041b, 0, false);
        }

        /* renamed from: a */
        public boolean mo3091a(int i, int i2, long j) {
            if (C0429r.this.f3034a < 0 || j - C0429r.this.f3034a >= 1000000000 || i != this.f3040a + this.f3041b) {
                return false;
            }
            this.f3041b += i2;
            C0429r.this.m2731h();
            return true;
        }

        /* renamed from: b */
        public void mo3092b() {
            C0429r.this.f3035b.mo2963a(this.f3042c.toCharArray(), this.f3040a, 0, false);
        }

        /* renamed from: c */
        public void mo3093c() {
            this.f3042c = C0429r.this.f3035b.subSequence(this.f3040a, this.f3041b).toString();
        }

        /* renamed from: d */
        public int mo3094d() {
            return this.f3040a;
        }

        /* renamed from: e */
        public int mo3095e() {
            return this.f3040a + this.f3041b;
        }
    }

    public C0429r(C0426o oVar) {
        this.f3035b = oVar;
    }

    /* renamed from: a */
    private void m2728a(C0431a aVar) {
        m2731h();
        this.f3039f++;
        this.f3036c.add(aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m2731h() {
        while (this.f3036c.size() > this.f3039f) {
            this.f3036c.removeLast();
        }
    }

    /* renamed from: a */
    public int mo3081a() {
        if (!mo3085c()) {
            return -1;
        }
        C0431a aVar = (C0431a) this.f3036c.get(this.f3039f - 1);
        int i = aVar.f3043d;
        while (true) {
            C0431a aVar2 = (C0431a) this.f3036c.get(this.f3039f - 1);
            if (aVar2.f3043d != i) {
                break;
            }
            aVar2.mo3090a();
            this.f3039f--;
            if (!mo3085c()) {
                aVar = aVar2;
                break;
            }
            aVar = aVar2;
        }
        return aVar.mo3094d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3082a(int r4, int r5, long r6) {
        /*
            r3 = this;
            boolean r0 = r3.mo3085c()
            r1 = 1
            if (r0 == 0) goto L_0x0021
            java.util.LinkedList<com.b.a.b.r$a> r0 = r3.f3036c
            int r2 = r3.f3039f
            int r2 = r2 - r1
            java.lang.Object r0 = r0.get(r2)
            com.b.a.b.r$a r0 = (com.p021b.p022a.p024b.C0429r.C0431a) r0
            boolean r2 = r0 instanceof com.p021b.p022a.p024b.C0429r.C0433c
            if (r2 == 0) goto L_0x001e
            boolean r2 = r0.mo3091a(r4, r5, r6)
            if (r2 == 0) goto L_0x001e
            r0 = 1
            goto L_0x0022
        L_0x001e:
            r0.mo3093c()
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 != 0) goto L_0x0037
            com.b.a.b.r$c r0 = new com.b.a.b.r$c
            int r2 = r3.f3038e
            r0.<init>(r4, r5, r2)
            r3.m2728a(r0)
            boolean r4 = r3.f3037d
            if (r4 != 0) goto L_0x0037
            int r4 = r3.f3038e
            int r4 = r4 + r1
            r3.f3038e = r4
        L_0x0037:
            r3.f3034a = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p024b.C0429r.mo3082a(int, int, long):void");
    }

    /* renamed from: b */
    public int mo3083b() {
        if (!mo3086d()) {
            return -1;
        }
        C0431a aVar = (C0431a) this.f3036c.get(this.f3039f);
        int i = aVar.f3043d;
        while (true) {
            C0431a aVar2 = (C0431a) this.f3036c.get(this.f3039f);
            if (aVar2.f3043d != i) {
                break;
            }
            aVar2.mo3092b();
            this.f3039f++;
            if (!mo3086d()) {
                aVar = aVar2;
                break;
            }
            aVar = aVar2;
        }
        return aVar.mo3095e();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3084b(int r4, int r5, long r6) {
        /*
            r3 = this;
            boolean r0 = r3.mo3085c()
            r1 = 1
            if (r0 == 0) goto L_0x0021
            java.util.LinkedList<com.b.a.b.r$a> r0 = r3.f3036c
            int r2 = r3.f3039f
            int r2 = r2 - r1
            java.lang.Object r0 = r0.get(r2)
            com.b.a.b.r$a r0 = (com.p021b.p022a.p024b.C0429r.C0431a) r0
            boolean r2 = r0 instanceof com.p021b.p022a.p024b.C0429r.C0432b
            if (r2 == 0) goto L_0x001e
            boolean r2 = r0.mo3091a(r4, r5, r6)
            if (r2 == 0) goto L_0x001e
            r0 = 1
            goto L_0x0022
        L_0x001e:
            r0.mo3093c()
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 != 0) goto L_0x0037
            com.b.a.b.r$b r0 = new com.b.a.b.r$b
            int r2 = r3.f3038e
            r0.<init>(r4, r5, r2)
            r3.m2728a(r0)
            boolean r4 = r3.f3037d
            if (r4 != 0) goto L_0x0037
            int r4 = r3.f3038e
            int r4 = r4 + r1
            r3.f3038e = r4
        L_0x0037:
            r3.f3034a = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p024b.C0429r.mo3084b(int, int, long):void");
    }

    /* renamed from: c */
    public final boolean mo3085c() {
        return this.f3039f > 0;
    }

    /* renamed from: d */
    public final boolean mo3086d() {
        return this.f3039f < this.f3036c.size();
    }

    /* renamed from: e */
    public boolean mo3087e() {
        return this.f3037d;
    }

    /* renamed from: f */
    public void mo3088f() {
        this.f3037d = true;
    }

    /* renamed from: g */
    public void mo3089g() {
        this.f3037d = false;
        this.f3038e++;
    }
}
