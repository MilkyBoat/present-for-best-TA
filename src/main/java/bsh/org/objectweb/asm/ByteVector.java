package bsh.org.objectweb.asm;

final class ByteVector {

    /* renamed from: a */
    byte[] f721a;

    /* renamed from: b */
    int f722b;

    public ByteVector() {
        this.f721a = new byte[64];
    }

    public ByteVector(int i) {
        this.f721a = new byte[i];
    }

    /* renamed from: a */
    private void m767a(int i) {
        byte[] bArr = new byte[Math.max(this.f721a.length * 2, this.f722b + i)];
        System.arraycopy(this.f721a, 0, bArr, 0, this.f722b);
        this.f721a = bArr;
    }

    public ByteVector put1(int i) {
        int i2 = this.f722b;
        int i3 = i2 + 1;
        if (i3 > this.f721a.length) {
            m767a(1);
        }
        this.f721a[i2] = (byte) i;
        this.f722b = i3;
        return this;
    }

    public ByteVector put11(int i, int i2) {
        int i3 = this.f722b;
        if (i3 + 2 > this.f721a.length) {
            m767a(2);
        }
        byte[] bArr = this.f721a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        int i5 = i4 + 1;
        bArr[i4] = (byte) i2;
        this.f722b = i5;
        return this;
    }

    public ByteVector put12(int i, int i2) {
        int i3 = this.f722b;
        if (i3 + 3 > this.f721a.length) {
            m767a(3);
        }
        byte[] bArr = this.f721a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        this.f722b = i6;
        return this;
    }

    public ByteVector put2(int i) {
        int i2 = this.f722b;
        if (i2 + 2 > this.f721a.length) {
            m767a(2);
        }
        byte[] bArr = this.f721a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        this.f722b = i4;
        return this;
    }

    public ByteVector put4(int i) {
        int i2 = this.f722b;
        if (i2 + 4 > this.f721a.length) {
            m767a(4);
        }
        byte[] bArr = this.f721a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i;
        this.f722b = i6;
        return this;
    }

    public ByteVector put8(long j) {
        int i = this.f722b;
        if (i + 8 > this.f721a.length) {
            m767a(8);
        }
        byte[] bArr = this.f721a;
        int i2 = (int) (j >>> 32);
        int i3 = i + 1;
        bArr[i] = (byte) (i2 >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        int i7 = (int) j;
        int i8 = i6 + 1;
        bArr[i6] = (byte) (i7 >>> 24);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i7 >>> 16);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i7 >>> 8);
        int i11 = i10 + 1;
        bArr[i10] = (byte) i7;
        this.f722b = i11;
        return this;
    }

    public ByteVector putByteArray(byte[] bArr, int i, int i2) {
        if (this.f722b + i2 > this.f721a.length) {
            m767a(i2);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i, this.f721a, this.f722b, i2);
        }
        this.f722b += i2;
        return this;
    }

    public ByteVector putUTF(String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            i2 = (charAt < 1 || charAt > 127) ? charAt > 2047 ? i2 + 3 : i2 + 2 : i2 + 1;
        }
        if (i2 > 65535) {
            throw new IllegalArgumentException();
        }
        int i4 = this.f722b;
        if (i4 + 2 + i2 > this.f721a.length) {
            m767a(i2 + 2);
        }
        byte[] bArr = this.f721a;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        for (int i7 = 0; i7 < length; i7++) {
            char charAt2 = str.charAt(i7);
            if (charAt2 >= 1 && charAt2 <= 127) {
                i = i6 + 1;
                bArr[i6] = (byte) charAt2;
            } else if (charAt2 > 2047) {
                int i8 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >> 12) & 15) | 224);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((charAt2 >> 6) & 63) | 128);
                i = i9 + 1;
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
            } else {
                int i10 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >> 6) & 31) | Constants.CHECKCAST);
                i6 = i10 + 1;
                bArr[i10] = (byte) ((charAt2 & '?') | 128);
            }
            i6 = i;
        }
        this.f722b = i6;
        return this;
    }
}
