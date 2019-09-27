package com.android.cglib.p008dx.p020d;

import com.androlua.BuildConfig;

/* renamed from: com.android.cglib.dx.d.i */
public final class C0295i {
    /* renamed from: a */
    public static String m2044a(int i) {
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 8; i2++) {
            cArr[7 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m2045a(long j) {
        char[] cArr = new char[16];
        for (int i = 0; i < 16; i++) {
            cArr[15 - i] = Character.forDigit(((int) j) & 15, 16);
            j >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m2046a(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        int i6 = i + i2;
        if ((i | i2 | i6) < 0 || i6 > bArr.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("arr.length ");
            sb.append(bArr.length);
            sb.append("; ");
            sb.append(i);
            sb.append("..!");
            sb.append(i6);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i3 < 0) {
            throw new IllegalArgumentException("outOffset < 0");
        } else if (i2 == 0) {
            return BuildConfig.FLAVOR;
        } else {
            StringBuffer stringBuffer = new StringBuffer((i2 * 4) + 6);
            int i7 = i;
            int i8 = 0;
            while (i2 > 0) {
                if (i8 == 0) {
                    String str = i5 != 2 ? i5 != 4 ? i5 != 6 ? m2044a(i3) : m2047b(i3) : m2048c(i3) : m2050e(i3);
                    stringBuffer.append(str);
                    stringBuffer.append(": ");
                } else if ((i8 & 1) == 0) {
                    stringBuffer.append(' ');
                }
                stringBuffer.append(m2050e(bArr[i7]));
                i3++;
                i7++;
                i8++;
                if (i8 == i4) {
                    stringBuffer.append(10);
                    i8 = 0;
                }
                i2--;
            }
            if (i8 != 0) {
                stringBuffer.append(10);
            }
            return stringBuffer.toString();
        }
    }

    /* renamed from: b */
    public static String m2047b(int i) {
        char[] cArr = new char[6];
        for (int i2 = 0; i2 < 6; i2++) {
            cArr[5 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: c */
    public static String m2048c(int i) {
        char[] cArr = new char[4];
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[3 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: d */
    public static String m2049d(int i) {
        return i == ((char) i) ? m2048c(i) : m2044a(i);
    }

    /* renamed from: e */
    public static String m2050e(int i) {
        char[] cArr = new char[2];
        for (int i2 = 0; i2 < 2; i2++) {
            cArr[1 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: f */
    public static String m2051f(int i) {
        return new String(new char[]{Character.forDigit(i & 15, 16)});
    }

    /* renamed from: g */
    public static String m2052g(int i) {
        char[] cArr = new char[9];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        for (int i2 = 0; i2 < 8; i2++) {
            cArr[8 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* renamed from: h */
    public static String m2053h(int i) {
        char[] cArr = new char[5];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[4 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }
}
