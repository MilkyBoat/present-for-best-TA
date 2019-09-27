package com.p021b.p022a.p024b;

import android.util.Log;

/* renamed from: com.b.a.b.q */
public class C0428q extends Exception {
    /* renamed from: a */
    public static void m2726a(String str) {
        m2727a(false, str);
    }

    /* renamed from: a */
    public static void m2727a(boolean z, String str) {
        if (!z) {
            System.err.print("TextWarrior assertion failed: ");
            System.err.println(str);
            Log.i("lua", str);
        }
    }
}
