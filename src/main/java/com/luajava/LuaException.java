package com.luajava;

public class LuaException extends Exception {
    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LuaException(java.lang.Exception r2) {
        /*
            r1 = this;
            java.lang.Throwable r0 = r2.getCause()
            if (r0 == 0) goto L_0x000a
            java.lang.Throwable r2 = r2.getCause()
        L_0x000a:
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaException.<init>(java.lang.Exception):void");
    }

    public LuaException(String str) {
        super(str);
    }
}
