package com.p021b.p022a.p024b;

/* renamed from: com.b.a.b.p */
public class C0427p {

    /* renamed from: a */
    private C0424m[] f3033a = new C0424m[4];

    public C0427p() {
        this.f3033a[0] = new C0424m(0, 0);
        for (int i = 1; i < 4; i++) {
            this.f3033a[i] = new C0424m(-1, -1);
        }
    }

    /* renamed from: b */
    private boolean m2719b(int i, int i2) {
        for (int i3 = 1; i3 < 4; i3++) {
            if (this.f3033a[i3].mo3047a() == i) {
                this.f3033a[i3].mo3050b(i2);
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m2720c(int i, int i2) {
        m2721d(3);
        this.f3033a[1] = new C0424m(i, i2);
    }

    /* renamed from: d */
    private void m2721d(int i) {
        if (i != 0) {
            C0424m mVar = this.f3033a[i];
            while (i > 1) {
                this.f3033a[i] = this.f3033a[i - 1];
                i--;
            }
            this.f3033a[1] = mVar;
        }
    }

    /* renamed from: a */
    public C0424m mo3077a(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            int abs = Math.abs(i - this.f3033a[i4].mo3047a());
            if (abs < i2) {
                i3 = i4;
                i2 = abs;
            }
        }
        C0424m mVar = this.f3033a[i3];
        m2721d(i3);
        return mVar;
    }

    /* renamed from: a */
    public void mo3078a(int i, int i2) {
        if (i > 0 && !m2719b(i, i2)) {
            m2720c(i, i2);
        }
    }

    /* renamed from: b */
    public C0424m mo3079b(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            int abs = Math.abs(i - this.f3033a[i4].mo3049b());
            if (abs < i2) {
                i3 = i4;
                i2 = abs;
            }
        }
        C0424m mVar = this.f3033a[i3];
        m2721d(i3);
        return mVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo3080c(int i) {
        for (int i2 = 1; i2 < 4; i2++) {
            if (this.f3033a[i2].mo3049b() >= i) {
                this.f3033a[i2] = new C0424m(-1, -1);
            }
        }
    }
}
