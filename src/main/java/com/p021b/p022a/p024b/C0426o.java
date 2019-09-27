package com.p021b.p022a.p024b;

import java.util.List;
import java.util.Vector;

/* renamed from: com.b.a.b.o */
public class C0426o implements CharSequence {

    /* renamed from: a */
    protected char[] f3025a = new char[51];

    /* renamed from: b */
    protected int f3026b;

    /* renamed from: c */
    protected int f3027c;

    /* renamed from: d */
    protected int f3028d;

    /* renamed from: e */
    protected List<C0424m> f3029e;

    /* renamed from: f */
    private int f3030f;

    /* renamed from: g */
    private C0427p f3031g;

    /* renamed from: h */
    private C0429r f3032h;

    public C0426o() {
        this.f3025a[50] = 65535;
        this.f3030f = 1;
        this.f3026b = 0;
        this.f3027c = 50;
        this.f3028d = 1;
        this.f3031g = new C0427p();
        this.f3032h = new C0429r(this);
    }

    /* renamed from: a */
    private int m2686a(int i, int i2, int i3) {
        int p = mo3072p(i3);
        C0428q.m2727a(mo3071o(i3), "findCharOffsetBackward: Invalid startingOffset given");
        while (i2 < i && p < this.f3025a.length) {
            if (this.f3025a[p] == 10) {
                i2++;
            }
            p++;
            if (p == this.f3026b) {
                p = this.f3027c;
            }
        }
        if (i2 != i) {
            return -1;
        }
        return mo3073q(p);
    }

    /* renamed from: a */
    private void m2687a(int i, int i2) {
        C0424m mVar = (C0424m) this.f3029e.get(mo2965b(i).mo3047a());
        mVar.mo3048a(mVar.mo3047a() + i2);
    }

    /* renamed from: b */
    private int m2688b(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        C0428q.m2727a(mo3071o(i3), "findCharOffsetBackward: Invalid startOffset given");
        int p = mo3072p(i3);
        while (i2 > i - 1 && p >= 0) {
            if (p == this.f3027c) {
                p = this.f3026b;
            }
            p--;
            if (this.f3025a[p] == 10) {
                i2--;
            }
        }
        if (p >= 0) {
            return mo3073q(p) + 1;
        }
        C0428q.m2727a(false, "findCharOffsetBackward: Invalid cache entry or line arguments");
        return -1;
    }

    /* renamed from: b */
    private C0424m mo2965b(int i) {
        int size = this.f3029e.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int a = ((C0424m) this.f3029e.get(i3)).mo3047a();
            i2 += a;
            if (i2 >= i) {
                return new C0424m(i3, i2 - a);
            }
        }
        return new C0424m(0, 0);
    }

    /* renamed from: b */
    private void m2690b(int i, int i2) {
        if (length() == 0) {
            mo3056f();
            return;
        }
        C0424m c = mo2968c(i);
        if (i2 == 1) {
            C0424m mVar = (C0424m) this.f3029e.get(c.mo3047a());
            if (mVar.mo3047a() > 1) {
                mVar.mo3048a(mVar.mo3047a() - 1);
            } else {
                this.f3029e.remove(c.mo3047a());
            }
        } else {
            int b = i - c.mo3049b();
            C0424m mVar2 = (C0424m) this.f3029e.get(c.mo3047a());
            if (mVar2.mo3047a() > b) {
                mVar2.mo3048a(mVar2.mo3047a() - b);
            } else {
                this.f3029e.remove(c.mo3047a());
            }
            int i3 = i2 - b;
            if (i3 > 0) {
                int a = c.mo3047a();
                while (true) {
                    if (a < 0) {
                        break;
                    }
                    C0424m mVar3 = (C0424m) this.f3029e.get(a);
                    int a2 = mVar3.mo3047a();
                    if (i3 <= a2) {
                        mVar3.mo3048a(mVar3.mo3047a() - i3);
                        break;
                    }
                    i3 -= a2;
                    this.f3029e.remove(a);
                    a--;
                }
            }
        }
    }

    /* renamed from: c */
    private int m2691c(int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            if (this.f3025a[i4] == 10) {
                i3++;
            }
        }
        return i3;
    }

    /* renamed from: c */
    private C0424m mo2968c(int i) {
        int size = this.f3029e.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int a = ((C0424m) this.f3029e.get(i3)).mo3047a();
            i2 += a;
            if (i2 > i) {
                return new C0424m(i3, i2 - a);
            }
        }
        return new C0424m(0, 0);
    }

    /* renamed from: g */
    public static int m2693g(int i) {
        long j = (long) (i + 50 + 1);
        if (j < 2147483647L) {
            return (int) j;
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo2959a(int i) {
        if (i >= 0) {
            try {
                m2687a(this.f3026b, i);
                this.f3028d += m2691c(this.f3026b, i);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            m2690b(this.f3026b, 0 - i);
            this.f3028d -= m2691c(this.f3026b + i, -i);
        }
        this.f3026b += i;
        this.f3031g.mo3080c(mo3073q(this.f3026b - 1) + 1);
    }

    /* renamed from: a */
    public synchronized void mo2960a(int i, int i2, long j, boolean z) {
        if (z) {
            try {
                this.f3032h.mo3084b(i, i2, j);
            } catch (Throwable th) {
                throw th;
            }
        }
        int i3 = i + i2;
        if (i3 != this.f3026b) {
            if (mo3074r(i3)) {
                mo3065k(i3);
            } else {
                mo3067l(i3 + mo3055e());
            }
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.f3026b--;
            if (this.f3025a[this.f3026b] == 10) {
                this.f3028d--;
            }
        }
        this.f3031g.mo3080c(i);
        m2690b(i, i2);
    }

    /* renamed from: a */
    public void mo3051a(List<C0424m> list) {
        this.f3029e = list;
    }

    /* renamed from: a */
    public synchronized void mo3052a(char[] cArr, int i, int i2) {
        this.f3025a = cArr;
        mo3069m(i);
        this.f3028d = i2;
        this.f3030f = 1;
    }

    /* renamed from: a */
    public synchronized void mo2963a(char[] cArr, int i, long j, boolean z) {
        if (z) {
            try {
                this.f3032h.mo3082a(i, cArr.length, j);
            } catch (Throwable th) {
                throw th;
            }
        }
        int p = mo3072p(i);
        if (p != this.f3027c) {
            if (mo3074r(p)) {
                mo3065k(p);
            } else {
                mo3067l(p);
            }
        }
        if (cArr.length >= mo3055e()) {
            mo3070n(cArr.length - mo3055e());
        }
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (cArr[i2] == 10) {
                this.f3028d++;
            }
            this.f3025a[this.f3026b] = cArr[i2];
            this.f3026b++;
        }
        this.f3031g.mo3080c(i);
        m2687a(i, cArr.length);
    }

    public synchronized char charAt(int i) {
        return this.f3025a[mo3072p(i)];
    }

    /* renamed from: d */
    public final synchronized int mo3054d() {
        return this.f3025a.length - mo3055e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final int mo3055e() {
        return this.f3027c - this.f3026b;
    }

    /* renamed from: f */
    public void mo3056f() {
        this.f3029e = new Vector();
        this.f3029e.add(new C0424m(length(), 0));
    }

    /* renamed from: g */
    public List<C0424m> mo3057g() {
        return this.f3029e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        return r0;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int mo3058h(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 >= 0) goto L_0x0006
            r3 = -1
            monitor-exit(r2)
            return r3
        L_0x0006:
            com.b.a.b.p r0 = r2.f3031g     // Catch:{ all -> 0x002a }
            com.b.a.b.m r0 = r0.mo3077a(r3)     // Catch:{ all -> 0x002a }
            int r1 = r0.mo3047a()     // Catch:{ all -> 0x002a }
            int r0 = r0.mo3049b()     // Catch:{ all -> 0x002a }
            if (r3 <= r1) goto L_0x001b
            int r0 = r2.m2686a(r3, r1, r0)     // Catch:{ all -> 0x002a }
            goto L_0x0021
        L_0x001b:
            if (r3 >= r1) goto L_0x0021
            int r0 = r2.m2688b(r3, r1, r0)     // Catch:{ all -> 0x002a }
        L_0x0021:
            if (r0 < 0) goto L_0x0028
            com.b.a.b.p r1 = r2.f3031g     // Catch:{ all -> 0x002a }
            r1.mo3078a(r3, r0)     // Catch:{ all -> 0x002a }
        L_0x0028:
            monitor-exit(r2)
            return r0
        L_0x002a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p024b.C0426o.mo3058h(int):int");
    }

    /* renamed from: h */
    public boolean mo3059h() {
        return this.f3032h.mo3087e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0075, code lost:
        return r5;
     */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int mo3060i(int r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.mo3071o(r9)     // Catch:{ all -> 0x0078 }
            r1 = -1
            if (r0 != 0) goto L_0x000a
            monitor-exit(r8)
            return r1
        L_0x000a:
            com.b.a.b.p r0 = r8.f3031g     // Catch:{ all -> 0x0078 }
            com.b.a.b.m r0 = r0.mo3079b(r9)     // Catch:{ all -> 0x0078 }
            int r2 = r0.mo3047a()     // Catch:{ all -> 0x0078 }
            int r0 = r0.mo3049b()     // Catch:{ all -> 0x0078 }
            int r0 = r8.mo3072p(r0)     // Catch:{ all -> 0x0078 }
            int r9 = r8.mo3072p(r9)     // Catch:{ all -> 0x0078 }
            r3 = 10
            if (r9 <= r0) goto L_0x0046
            r5 = r2
            r2 = -1
            r4 = -1
        L_0x0027:
            if (r0 >= r9) goto L_0x006b
            char[] r6 = r8.f3025a     // Catch:{ all -> 0x0078 }
            int r6 = r6.length     // Catch:{ all -> 0x0078 }
            if (r0 >= r6) goto L_0x006b
            char[] r6 = r8.f3025a     // Catch:{ all -> 0x0078 }
            char r6 = r6[r0]     // Catch:{ all -> 0x0078 }
            if (r6 != r3) goto L_0x003d
            int r2 = r5 + 1
            int r4 = r8.mo3073q(r0)     // Catch:{ all -> 0x0078 }
            int r4 = r4 + 1
            r5 = r2
        L_0x003d:
            int r0 = r0 + 1
            int r6 = r8.f3026b     // Catch:{ all -> 0x0078 }
            if (r0 != r6) goto L_0x0027
            int r0 = r8.f3027c     // Catch:{ all -> 0x0078 }
            goto L_0x0027
        L_0x0046:
            if (r9 >= r0) goto L_0x0068
            r5 = r2
            r2 = -1
            r4 = -1
        L_0x004b:
            if (r0 <= r9) goto L_0x006b
            if (r0 <= 0) goto L_0x006b
            int r6 = r8.f3027c     // Catch:{ all -> 0x0078 }
            if (r0 != r6) goto L_0x0055
            int r0 = r8.f3026b     // Catch:{ all -> 0x0078 }
        L_0x0055:
            int r0 = r0 + r1
            char[] r6 = r8.f3025a     // Catch:{ all -> 0x0078 }
            char r6 = r6[r0]     // Catch:{ all -> 0x0078 }
            if (r6 != r3) goto L_0x004b
            int r2 = r8.mo3073q(r0)     // Catch:{ all -> 0x0078 }
            int r4 = r2 + 1
            int r2 = r5 + -1
            r7 = r5
            r5 = r2
            r2 = r7
            goto L_0x004b
        L_0x0068:
            r5 = r2
            r2 = -1
            r4 = -1
        L_0x006b:
            if (r0 != r9) goto L_0x0076
            if (r2 == r1) goto L_0x0074
            com.b.a.b.p r9 = r8.f3031g     // Catch:{ all -> 0x0078 }
            r9.mo3078a(r2, r4)     // Catch:{ all -> 0x0078 }
        L_0x0074:
            monitor-exit(r8)
            return r5
        L_0x0076:
            monitor-exit(r8)
            return r1
        L_0x0078:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p024b.C0426o.mo3060i(int):int");
    }

    /* renamed from: i */
    public void mo3061i() {
        this.f3032h.mo3088f();
    }

    /* renamed from: j */
    public void mo3062j() {
        this.f3032h.mo3089g();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public char[] mo3063j(int i) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = this.f3025a[this.f3026b + i2];
        }
        return cArr;
    }

    /* renamed from: k */
    public int mo3064k() {
        return this.f3032h.mo3081a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final void mo3065k(int i) {
        while (this.f3026b > i) {
            this.f3027c--;
            this.f3026b--;
            this.f3025a[this.f3027c] = this.f3025a[this.f3026b];
        }
    }

    /* renamed from: l */
    public int mo3066l() {
        return this.f3032h.mo3083b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public final void mo3067l(int i) {
        while (this.f3027c < i) {
            this.f3025a[this.f3026b] = this.f3025a[this.f3027c];
            this.f3026b++;
            this.f3027c++;
        }
    }

    public int length() {
        return mo3054d() - 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo3069m(int i) {
        int length = this.f3025a.length - 1;
        int i2 = length - 1;
        this.f3025a[length] = 65535;
        int i3 = i - 1;
        while (i3 >= 0) {
            int i4 = i2 - 1;
            int i5 = i3 - 1;
            this.f3025a[i2] = this.f3025a[i3];
            i2 = i4;
            i3 = i5;
        }
        this.f3026b = 0;
        this.f3027c = i2 + 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo3070n(int i) {
        int i2 = i + (this.f3030f * 50);
        char[] cArr = new char[(this.f3025a.length + i2)];
        for (int i3 = 0; i3 < this.f3026b; i3++) {
            cArr[i3] = this.f3025a[i3];
        }
        for (int i4 = this.f3027c; i4 < this.f3025a.length; i4++) {
            cArr[i4 + i2] = this.f3025a[i4];
        }
        this.f3027c += i2;
        this.f3025a = cArr;
        this.f3030f <<= 1;
    }

    /* renamed from: o */
    public final synchronized boolean mo3071o(int i) {
        boolean z;
        if (i >= 0) {
            if (i < mo3054d()) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public final int mo3072p(int i) {
        return mo3074r(i) ? i : i + mo3055e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public final int mo3073q(int i) {
        return mo3074r(i) ? i : i - mo3055e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public final boolean mo3074r(int i) {
        return i < this.f3026b;
    }

    public synchronized CharSequence subSequence(int i, int i2) {
        if (mo3071o(i)) {
            if (i2 > 0) {
                if (i + i2 > mo3054d()) {
                    i2 = mo3054d() - i;
                }
                int p = mo3072p(i);
                char[] cArr = new char[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    cArr[i3] = this.f3025a[p];
                    p++;
                    if (p == this.f3026b) {
                        p = this.f3027c;
                    }
                }
                return new String(cArr);
            }
        }
        return new String();
    }

    public String toString() {
        int d = mo3054d();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < d; i++) {
            char charAt = charAt(i);
            if (charAt == 65535) {
                break;
            }
            stringBuffer.append(charAt);
        }
        return new String(stringBuffer);
    }
}
