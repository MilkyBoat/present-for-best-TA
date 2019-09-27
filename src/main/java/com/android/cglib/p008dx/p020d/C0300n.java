package com.android.cglib.p008dx.p020d;

/* renamed from: com.android.cglib.dx.d.n */
public final class C0300n {
    /* renamed from: a */
    public static int m2071a(int i) {
        int i2 = i >> 7;
        int i3 = 0;
        while (i2 != 0) {
            i2 >>= 7;
            i3++;
        }
        return i3 + 1;
    }

    /* renamed from: a */
    public static void m2072a(C0291e eVar, int i) {
        while (true) {
            int i2 = i;
            i >>>= 7;
            if (i != 0) {
                eVar.mo1753b((byte) ((i2 & 127) | 128));
            } else {
                eVar.mo1753b((byte) (i2 & 127));
                return;
            }
        }
    }

    /* renamed from: b */
    public static void m2073b(C0291e eVar, int i) {
        int i2 = i >> 7;
        int i3 = (Integer.MIN_VALUE & i) == 0 ? 0 : -1;
        int i4 = i;
        boolean z = true;
        while (z) {
            z = (i2 == i3 && (i2 & 1) == ((i4 >> 6) & 1)) ? false : true;
            eVar.mo1753b((byte) ((i4 & 127) | (z ? 128 : 0)));
            i4 = i2;
            i2 >>= 7;
        }
    }
}
