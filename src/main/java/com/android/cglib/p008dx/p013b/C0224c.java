package com.android.cglib.p008dx.p013b;

/* renamed from: com.android.cglib.dx.b.c */
public final class C0224c {
    /* renamed from: a */
    public static boolean m1646a(int i) {
        boolean z = false;
        if (i < -1) {
            return false;
        }
        if (i == -1) {
            return true;
        }
        int i2 = i & 255;
        if (i2 == 0 || i2 == 255) {
            return true;
        }
        if ((i & 65280) == 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m1647b(int i) {
        return i >= 255;
    }
}
