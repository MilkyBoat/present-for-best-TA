package com.android.cglib.p008dx.p015c.p017b;

import bsh.org.objectweb.asm.Constants;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.c.b.a */
public final class C0229a {
    /* renamed from: a */
    public static String m1658a(int i) {
        return m1659a(i, 30257, 1);
    }

    /* renamed from: a */
    private static String m1659a(int i, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer(80);
        int i4 = (i2 ^ -1) & i;
        int i5 = i & i2;
        if ((i5 & 1) != 0) {
            stringBuffer.append("|public");
        }
        if ((i5 & 2) != 0) {
            stringBuffer.append("|private");
        }
        if ((i5 & 4) != 0) {
            stringBuffer.append("|protected");
        }
        if ((i5 & 8) != 0) {
            stringBuffer.append("|static");
        }
        if ((i5 & 16) != 0) {
            stringBuffer.append("|final");
        }
        if ((i5 & 32) != 0) {
            stringBuffer.append(i3 == 1 ? "|super" : "|synchronized");
        }
        if ((i5 & 64) != 0) {
            stringBuffer.append(i3 == 3 ? "|bridge" : "|volatile");
        }
        if ((i5 & 128) != 0) {
            stringBuffer.append(i3 == 3 ? "|varargs" : "|transient");
        }
        if ((i5 & Constants.ACC_NATIVE) != 0) {
            stringBuffer.append("|native");
        }
        if ((i5 & Constants.ACC_INTERFACE) != 0) {
            stringBuffer.append("|interface");
        }
        if ((i5 & 1024) != 0) {
            stringBuffer.append("|abstract");
        }
        if ((i5 & Constants.ACC_STRICT) != 0) {
            stringBuffer.append("|strictfp");
        }
        if ((i5 & 4096) != 0) {
            stringBuffer.append("|synthetic");
        }
        if ((i5 & 8192) != 0) {
            stringBuffer.append("|annotation");
        }
        if ((i5 & 16384) != 0) {
            stringBuffer.append("|enum");
        }
        if ((65536 & i5) != 0) {
            stringBuffer.append("|constructor");
        }
        if ((i5 & Constants.ACC_DEPRECATED) != 0) {
            stringBuffer.append("|declared_synchronized");
        }
        if (i4 != 0 || stringBuffer.length() == 0) {
            stringBuffer.append('|');
            stringBuffer.append(C0295i.m2048c(i4));
        }
        return stringBuffer.substring(1);
    }

    /* renamed from: b */
    public static String m1660b(int i) {
        return m1659a(i, 20703, 2);
    }

    /* renamed from: c */
    public static String m1661c(int i) {
        return m1659a(i, 204287, 3);
    }
}
