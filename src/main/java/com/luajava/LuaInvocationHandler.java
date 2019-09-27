package com.luajava;

import com.androlua.LuaContext;
import java.lang.reflect.InvocationHandler;

public class LuaInvocationHandler implements InvocationHandler {

    /* renamed from: a */
    private final LuaContext f3378a;

    /* renamed from: b */
    private LuaObject f3379b;

    public LuaInvocationHandler(LuaObject luaObject) {
        this.f3379b = luaObject;
        this.f3378a = luaObject.getLuaState().getContext();
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r6, java.lang.reflect.Method r7, java.lang.Object[] r8) {
        /*
            r5 = this;
            com.luajava.LuaObject r6 = r5.f3379b
            com.luajava.LuaState r6 = r6.f3393b
            monitor-enter(r6)
            java.lang.String r0 = r7.getName()     // Catch:{ all -> 0x00b5 }
            com.luajava.LuaObject r1 = r5.f3379b     // Catch:{ all -> 0x00b5 }
            boolean r1 = r1.isFunction()     // Catch:{ all -> 0x00b5 }
            if (r1 == 0) goto L_0x0014
            com.luajava.LuaObject r1 = r5.f3379b     // Catch:{ all -> 0x00b5 }
            goto L_0x001a
        L_0x0014:
            com.luajava.LuaObject r1 = r5.f3379b     // Catch:{ all -> 0x00b5 }
            com.luajava.LuaObject r1 = r1.getField(r0)     // Catch:{ all -> 0x00b5 }
        L_0x001a:
            java.lang.Class r7 = r7.getReturnType()     // Catch:{ all -> 0x00b5 }
            boolean r2 = r1.isNil()     // Catch:{ all -> 0x00b5 }
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x0054
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00b5 }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x00b5 }
            if (r8 != 0) goto L_0x004e
            java.lang.Class<java.lang.Boolean> r8 = java.lang.Boolean.class
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x00b5 }
            if (r8 == 0) goto L_0x0037
            goto L_0x004e
        L_0x0037:
            boolean r8 = r7.isPrimitive()     // Catch:{ all -> 0x00b5 }
            if (r8 != 0) goto L_0x0048
            java.lang.Class<java.lang.Number> r8 = java.lang.Number.class
            boolean r7 = r8.isAssignableFrom(r7)     // Catch:{ all -> 0x00b5 }
            if (r7 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            monitor-exit(r6)     // Catch:{ all -> 0x00b5 }
            return r3
        L_0x0048:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00b5 }
            monitor-exit(r6)     // Catch:{ all -> 0x00b5 }
            return r7
        L_0x004e:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x00b5 }
            monitor-exit(r6)     // Catch:{ all -> 0x00b5 }
            return r7
        L_0x0054:
            java.lang.Class<java.lang.Void> r2 = java.lang.Void.class
            boolean r2 = r7.equals(r2)     // Catch:{ LuaException -> 0x0080 }
            if (r2 != 0) goto L_0x007c
            java.lang.Class r2 = java.lang.Void.TYPE     // Catch:{ LuaException -> 0x0080 }
            boolean r2 = r7.equals(r2)     // Catch:{ LuaException -> 0x0080 }
            if (r2 == 0) goto L_0x0065
            goto L_0x007c
        L_0x0065:
            java.lang.Object r8 = r1.call(r8)     // Catch:{ LuaException -> 0x0080 }
            if (r8 == 0) goto L_0x007a
            boolean r1 = r8 instanceof java.lang.Double     // Catch:{ LuaException -> 0x0077 }
            if (r1 == 0) goto L_0x007a
            r1 = r8
            java.lang.Double r1 = (java.lang.Double) r1     // Catch:{ LuaException -> 0x0077 }
            java.lang.Number r3 = com.luajava.LuaState.convertLuaNumber(r1, r7)     // Catch:{ LuaException -> 0x0077 }
            goto L_0x0086
        L_0x0077:
            r1 = move-exception
            r3 = r8
            goto L_0x0081
        L_0x007a:
            r3 = r8
            goto L_0x0086
        L_0x007c:
            r1.call(r8)     // Catch:{ LuaException -> 0x0080 }
            goto L_0x0086
        L_0x0080:
            r1 = move-exception
        L_0x0081:
            com.androlua.LuaContext r8 = r5.f3378a     // Catch:{ all -> 0x00b5 }
            r8.sendError(r0, r1)     // Catch:{ all -> 0x00b5 }
        L_0x0086:
            if (r3 != 0) goto L_0x00b3
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00b5 }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x00b5 }
            if (r8 != 0) goto L_0x00ad
            java.lang.Class<java.lang.Boolean> r8 = java.lang.Boolean.class
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x00b5 }
            if (r8 == 0) goto L_0x0099
            goto L_0x00ad
        L_0x0099:
            boolean r8 = r7.isPrimitive()     // Catch:{ all -> 0x00b5 }
            if (r8 != 0) goto L_0x00a7
            java.lang.Class<java.lang.Number> r8 = java.lang.Number.class
            boolean r7 = r8.isAssignableFrom(r7)     // Catch:{ all -> 0x00b5 }
            if (r7 == 0) goto L_0x00b3
        L_0x00a7:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00b5 }
            monitor-exit(r6)     // Catch:{ all -> 0x00b5 }
            return r7
        L_0x00ad:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x00b5 }
            monitor-exit(r6)     // Catch:{ all -> 0x00b5 }
            return r7
        L_0x00b3:
            monitor-exit(r6)     // Catch:{ all -> 0x00b5 }
            return r3
        L_0x00b5:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00b5 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaInvocationHandler.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }
}
