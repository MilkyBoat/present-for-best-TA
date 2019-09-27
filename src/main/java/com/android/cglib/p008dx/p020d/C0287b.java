package com.android.cglib.p008dx.p020d;

/* renamed from: com.android.cglib.dx.d.b */
public final class C0287b {
    /* renamed from: a */
    public static int m1994a(int i, int i2) {
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i & (((1 << i2) - 1) ^ -1));
        if (numberOfTrailingZeros == 32) {
            return -1;
        }
        return numberOfTrailingZeros;
    }

    /* renamed from: a */
    public static boolean m1995a(int[] iArr, int i) {
        return (iArr[i >> 5] & (1 << (i & 31))) != 0;
    }

    /* renamed from: a */
    public static int[] m1996a(int i) {
        return new int[((i + 31) >> 5)];
    }

    /* renamed from: b */
    public static void m1997b(int[] iArr, int i) {
        int i2 = i >> 5;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    /* renamed from: c */
    public static void m1998c(int[] iArr, int i) {
        int i2 = i >> 5;
        iArr[i2] = ((1 << (i & 31)) ^ -1) & iArr[i2];
    }

    /* renamed from: d */
    public static int m1999d(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = i & 31;
        for (int i3 = i >> 5; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i4 != 0) {
                int a = m1994a(i4, i2);
                if (a >= 0) {
                    return (i3 << 5) + a;
                }
            }
            i2 = 0;
        }
        return -1;
    }
}
