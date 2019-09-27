package com.android.cglib.p008dx.p020d;

import java.util.Arrays;

/* renamed from: com.android.cglib.dx.d.k */
public final class C0297k extends C0301o {

    /* renamed from: a */
    public static final C0297k f2169a = new C0297k(0);

    /* renamed from: b */
    private int[] f2170b;

    /* renamed from: c */
    private int f2171c;

    /* renamed from: d */
    private boolean f2172d;

    static {
        f2169a.mo1799e();
    }

    public C0297k() {
        this(4);
    }

    public C0297k(int i) {
        super(true);
        try {
            this.f2170b = new int[i];
            this.f2171c = 0;
            this.f2172d = true;
        } catch (NegativeArraySizeException unused) {
            throw new IllegalArgumentException("size < 0");
        }
    }

    /* renamed from: c */
    private void m2055c() {
        if (this.f2171c == this.f2170b.length) {
            int[] iArr = new int[(((this.f2171c * 3) / 2) + 10)];
            System.arraycopy(this.f2170b, 0, iArr, 0, this.f2171c);
            this.f2170b = iArr;
        }
    }

    /* renamed from: a */
    public int mo1784a() {
        return this.f2171c;
    }

    /* renamed from: a */
    public int mo1785a(int i) {
        if (i >= this.f2171c) {
            throw new IndexOutOfBoundsException("n >= size()");
        }
        try {
            return this.f2170b[i];
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IndexOutOfBoundsException("n < 0");
        }
    }

    /* renamed from: a */
    public void mo1786a(int i, int i2) {
        mo1802h();
        if (i >= this.f2171c) {
            throw new IndexOutOfBoundsException("n >= size()");
        }
        try {
            this.f2170b[i] = i2;
            this.f2172d = false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            if (i < 0) {
                throw new IllegalArgumentException("n < 0");
            }
        }
    }

    /* renamed from: b */
    public void mo1787b() {
        mo1802h();
        if (!this.f2172d) {
            Arrays.sort(this.f2170b, 0, this.f2171c);
            this.f2172d = true;
        }
    }

    /* renamed from: b */
    public void mo1788b(int i) {
        mo1802h();
        m2055c();
        int[] iArr = this.f2170b;
        int i2 = this.f2171c;
        this.f2171c = i2 + 1;
        iArr[i2] = i;
        if (this.f2172d) {
            boolean z = true;
            if (this.f2171c > 1) {
                if (i < this.f2170b[this.f2171c - 2]) {
                    z = false;
                }
                this.f2172d = z;
            }
        }
    }

    /* renamed from: c */
    public void mo1789c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("newSize < 0");
        } else if (i > this.f2171c) {
            throw new IllegalArgumentException("newSize > size");
        } else {
            mo1802h();
            this.f2171c = i;
        }
    }

    /* renamed from: d */
    public int mo1790d(int i) {
        int e = mo1791e(i);
        if (e >= 0) {
            return e;
        }
        return -1;
    }

    /* renamed from: e */
    public int mo1791e(int i) {
        int i2 = this.f2171c;
        if (!this.f2172d) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.f2170b[i3] == i) {
                    return i3;
                }
            }
            return -i2;
        }
        int i4 = i2;
        int i5 = -1;
        while (i4 > i5 + 1) {
            int i6 = ((i4 - i5) >> 1) + i5;
            if (i <= this.f2170b[i6]) {
                i4 = i6;
            } else {
                i5 = i6;
            }
        }
        return i4 != i2 ? i == this.f2170b[i4] ? i4 : (-i4) - 1 : (-i2) - 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0297k)) {
            return false;
        }
        C0297k kVar = (C0297k) obj;
        if (this.f2172d != kVar.f2172d || this.f2171c != kVar.f2171c) {
            return false;
        }
        for (int i = 0; i < this.f2171c; i++) {
            if (this.f2170b[i] != kVar.f2170b[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public boolean mo1793f(int i) {
        return mo1790d(i) >= 0;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.f2171c; i2++) {
            i = (i * 31) + this.f2170b[i2];
        }
        return i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.f2171c * 5) + 10);
        stringBuffer.append('{');
        for (int i = 0; i < this.f2171c; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.f2170b[i]);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
