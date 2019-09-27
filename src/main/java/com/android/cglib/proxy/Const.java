package com.android.cglib.proxy;

public class Const {
    public static final String SUBCLASS_INVOKE_SUPER_SUFFIX = "_Super";
    public static final String SUBCLASS_SUFFIX = "_Enhancer";

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class, code=java.lang.Class<java.lang.Short>, for r1v0, types: [java.lang.Class] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class getPackedType(java.lang.Class<java.lang.Short> r1) {
        /*
            java.lang.Class r0 = java.lang.Boolean.TYPE
            if (r1 != r0) goto L_0x0007
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            return r1
        L_0x0007:
            java.lang.Class r0 = java.lang.Byte.TYPE
            if (r1 != r0) goto L_0x000e
            java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
            return r1
        L_0x000e:
            java.lang.Class r0 = java.lang.Character.TYPE
            if (r1 != r0) goto L_0x0015
            java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
            return r1
        L_0x0015:
            java.lang.Class r0 = java.lang.Double.TYPE
            if (r1 != r0) goto L_0x001c
            java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
            return r1
        L_0x001c:
            java.lang.Class r0 = java.lang.Float.TYPE
            if (r1 != r0) goto L_0x0023
            java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
            return r1
        L_0x0023:
            java.lang.Class r0 = java.lang.Integer.TYPE
            if (r1 != r0) goto L_0x002a
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            return r1
        L_0x002a:
            java.lang.Class r0 = java.lang.Long.TYPE
            if (r1 != r0) goto L_0x0031
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            return r1
        L_0x0031:
            java.lang.Class r0 = java.lang.Short.TYPE
            if (r1 != r0) goto L_0x0037
            java.lang.Class<java.lang.Short> r1 = java.lang.Short.class
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.cglib.proxy.Const.getPackedType(java.lang.Class):java.lang.Class");
    }

    public static String getPrimitiveValueMethodName(Class cls) {
        if (cls == Boolean.TYPE) {
            return "booleanValue";
        }
        if (cls == Byte.TYPE) {
            return "byteValue";
        }
        if (cls == Character.TYPE) {
            return "charValue";
        }
        if (cls == Double.TYPE) {
            return "doubleValue";
        }
        if (cls == Float.TYPE) {
            return "floatValue";
        }
        if (cls == Integer.TYPE) {
            return "intValue";
        }
        if (cls == Long.TYPE) {
            return "longValue";
        }
        if (cls == Short.TYPE) {
            return "shortValue";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append(" dit not primitive class");
        throw new ProxyException(sb.toString());
    }
}
