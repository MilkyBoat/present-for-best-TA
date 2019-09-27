package com.android.cglib.p008dx.p020d;

/* renamed from: com.android.cglib.dx.d.c */
public final class C0288c {

    /* renamed from: a */
    private final byte[] f2148a;

    /* renamed from: b */
    private final int f2149b;

    /* renamed from: c */
    private final int f2150c;

    public C0288c(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public C0288c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("start < 0");
        } else if (i2 < i) {
            throw new IllegalArgumentException("end < start");
        } else if (i2 > bArr.length) {
            throw new IllegalArgumentException("end > bytes.length");
        } else {
            this.f2148a = bArr;
            this.f2149b = i;
            this.f2150c = i2 - i;
        }
    }

    /* renamed from: a */
    public int mo1745a() {
        return this.f2150c;
    }

    /* renamed from: a */
    public void mo1746a(byte[] bArr, int i) {
        if (bArr.length - i < this.f2150c) {
            throw new IndexOutOfBoundsException("(out.length - offset) < size()");
        }
        System.arraycopy(this.f2148a, this.f2149b, bArr, i, this.f2150c);
    }
}
