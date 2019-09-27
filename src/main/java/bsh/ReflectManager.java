package bsh;

import bsh.Capabilities.Unavailable;

public abstract class ReflectManager {

    /* renamed from: a */
    private static ReflectManager f692a;

    public static boolean RMSetAccessible(Object obj) {
        return getReflectManager().setAccessible(obj);
    }

    public static ReflectManager getReflectManager() {
        if (f692a == null) {
            try {
                f692a = (ReflectManager) Class.forName("bsh.reflect.ReflectManagerImpl").newInstance();
            } catch (Exception e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Reflect Manager unavailable: ");
                stringBuffer.append(e);
                throw new Unavailable(stringBuffer.toString());
            }
        }
        return f692a;
    }

    public abstract boolean setAccessible(Object obj);
}
