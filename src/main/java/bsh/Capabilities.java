package bsh;

import java.util.Hashtable;

public class Capabilities {

    /* renamed from: a */
    static Class f522a;

    /* renamed from: b */
    private static boolean f523b;

    /* renamed from: c */
    private static Hashtable f524c = new Hashtable();

    public static class Unavailable extends UtilEvalError {
        public Unavailable(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    static Class m312a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static boolean canGenerateInterfaces() {
        return classExists("java.lang.reflect.Proxy");
    }

    public static boolean classExists(String str) {
        Object obj = f524c.get(str);
        if (obj == null) {
            try {
                obj = Class.forName(str);
            } catch (ClassNotFoundException unused) {
            }
            if (obj != null) {
                f524c.put(obj, "unused");
            }
        }
        return obj != null;
    }

    public static boolean haveAccessibility() {
        return f523b;
    }

    public static boolean haveSwing() {
        return classExists("javax.swing.JButton");
    }

    public static void setAccessibility(boolean z) {
        Class cls;
        boolean z2;
        if (!z) {
            z2 = false;
        } else if (!classExists("java.lang.reflect.AccessibleObject") || !classExists("bsh.reflect.ReflectManagerImpl")) {
            throw new Unavailable("Accessibility unavailable");
        } else {
            try {
                if (f522a == null) {
                    cls = m312a("java.lang.String");
                    f522a = cls;
                } else {
                    cls = f522a;
                }
                cls.getDeclaredMethods();
                z2 = true;
            } catch (SecurityException e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Accessibility unavailable: ");
                stringBuffer.append(e);
                throw new Unavailable(stringBuffer.toString());
            }
        }
        f523b = z2;
    }
}
