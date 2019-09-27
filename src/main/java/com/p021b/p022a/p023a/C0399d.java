package com.p021b.p022a.p023a;

import android.view.KeyEvent;

/* renamed from: com.b.a.a.d */
public class C0399d {
    /* renamed from: a */
    public static char m2515a(KeyEvent keyEvent) {
        if (m2519e(keyEvent)) {
            return 10;
        }
        if (m2518d(keyEvent)) {
            return 8;
        }
        if (m2517c(keyEvent)) {
            return 9;
        }
        if (m2520f(keyEvent)) {
            return ' ';
        }
        if (keyEvent.isPrintingKey()) {
            return (char) keyEvent.getUnicodeChar(keyEvent.getMetaState());
        }
        return 0;
    }

    /* renamed from: b */
    public static boolean m2516b(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 20 || keyCode == 19 || keyCode == 22 || keyCode == 21;
    }

    /* renamed from: c */
    private static boolean m2517c(KeyEvent keyEvent) {
        return (keyEvent.isShiftPressed() && keyEvent.getKeyCode() == 62) || keyEvent.getKeyCode() == 61;
    }

    /* renamed from: d */
    private static boolean m2518d(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 67;
    }

    /* renamed from: e */
    private static boolean m2519e(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 66;
    }

    /* renamed from: f */
    private static boolean m2520f(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 62;
    }
}
