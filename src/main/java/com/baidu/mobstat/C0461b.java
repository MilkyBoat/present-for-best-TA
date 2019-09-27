package com.baidu.mobstat;

/* renamed from: com.baidu.mobstat.b */
public final class C0461b {

    /* renamed from: a */
    private static final byte[] f3124a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: a */
    public static String m2890a(byte[] bArr, String str) {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[(length + (length / 76) + 3)];
        int length2 = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length2; i3 += 3) {
            int i4 = i + 1;
            bArr2[i] = f3124a[(bArr[i3] & 255) >> 2];
            int i5 = i4 + 1;
            int i6 = i3 + 1;
            bArr2[i4] = f3124a[((bArr[i3] & 3) << 4) | ((bArr[i6] & 255) >> 4)];
            int i7 = i5 + 1;
            int i8 = i3 + 2;
            bArr2[i5] = f3124a[((bArr[i6] & 15) << 2) | ((bArr[i8] & 255) >> 6)];
            i = i7 + 1;
            bArr2[i7] = f3124a[bArr[i8] & 63];
            if ((i - i2) % 76 == 0 && i != 0) {
                int i9 = i + 1;
                bArr2[i] = 10;
                i2++;
                i = i9;
            }
        }
        switch (bArr.length % 3) {
            case 1:
                int i10 = i + 1;
                bArr2[i] = f3124a[(bArr[length2] & 255) >> 2];
                int i11 = i10 + 1;
                bArr2[i10] = f3124a[(bArr[length2] & 3) << 4];
                int i12 = i11 + 1;
                bArr2[i11] = 61;
                i = i12 + 1;
                bArr2[i12] = 61;
                break;
            case 2:
                int i13 = i + 1;
                bArr2[i] = f3124a[(bArr[length2] & 255) >> 2];
                int i14 = i13 + 1;
                int i15 = length2 + 1;
                bArr2[i13] = f3124a[((bArr[length2] & 3) << 4) | ((bArr[i15] & 255) >> 4)];
                int i16 = i14 + 1;
                bArr2[i14] = f3124a[(bArr[i15] & 15) << 2];
                i = i16 + 1;
                bArr2[i16] = 61;
                break;
        }
        return new String(bArr2, 0, i, str);
    }

    /* renamed from: a */
    public static byte[] m2891a(byte[] bArr) {
        return m2892a(bArr, bArr.length);
    }

    /* renamed from: a */
    public static byte[] m2892a(byte[] bArr, int i) {
        byte b;
        int i2;
        int i3 = (i / 4) * 3;
        if (i3 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i3];
        int i4 = i;
        int i5 = 0;
        while (true) {
            byte b2 = bArr[i4 - 1];
            b = 10;
            if (!(b2 == 10 || b2 == 13 || b2 == 32 || b2 == 9)) {
                if (b2 != 61) {
                    break;
                }
                i5++;
            }
            i4--;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < i4) {
            byte b3 = bArr[i6];
            if (!(b3 == b || b3 == 13 || b3 == 32 || b3 == 9)) {
                if (b3 >= 65 && b3 <= 90) {
                    i2 = b3 - 65;
                } else if (b3 >= 97 && b3 <= 122) {
                    i2 = b3 - 71;
                } else if (b3 >= 48 && b3 <= 57) {
                    i2 = b3 + 4;
                } else if (b3 == 43) {
                    i2 = 62;
                } else if (b3 != 47) {
                    return null;
                } else {
                    i2 = 63;
                }
                byte b4 = ((byte) i2) | (i7 << 6);
                if (i9 % 4 == 3) {
                    int i10 = i8 + 1;
                    bArr2[i8] = (byte) ((b4 & 16711680) >> 16);
                    int i11 = i10 + 1;
                    bArr2[i10] = (byte) ((b4 & 65280) >> 8);
                    i8 = i11 + 1;
                    bArr2[i11] = (byte) (b4 & 255);
                }
                i9++;
                i7 = b4;
            }
            i6++;
            b = 10;
        }
        if (i5 > 0) {
            int i12 = i7 << (i5 * 6);
            int i13 = i8 + 1;
            bArr2[i8] = (byte) ((i12 & 16711680) >> 16);
            if (i5 == 1) {
                i8 = i13 + 1;
                bArr2[i13] = (byte) ((i12 & 65280) >> 8);
            } else {
                i8 = i13;
            }
        }
        byte[] bArr3 = new byte[i8];
        System.arraycopy(bArr2, 0, bArr3, 0, i8);
        return bArr3;
    }
}
