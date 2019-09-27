package com.luajava;

import com.android.cglib.proxy.MethodInterceptor;
import com.androlua.LuaContext;

public class LuaAbstractMethodInterceptor implements MethodInterceptor {

    /* renamed from: a */
    private final LuaContext f3376a;

    /* renamed from: b */
    private LuaObject f3377b;

    public LuaAbstractMethodInterceptor(LuaObject luaObject) {
        this.f3377b = luaObject;
        this.f3376a = luaObject.getLuaState().getContext();
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object intercept(java.lang.Object r6, java.lang.Object[] r7, com.android.cglib.proxy.MethodProxy r8) {
        /*
            r5 = this;
            com.luajava.LuaObject r6 = r5.f3377b
            com.luajava.LuaState r6 = r6.f3393b
            monitor-enter(r6)
            java.lang.reflect.Method r8 = r8.getOriginalMethod()     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = r8.getName()     // Catch:{ all -> 0x00b9 }
            com.luajava.LuaObject r1 = r5.f3377b     // Catch:{ all -> 0x00b9 }
            boolean r1 = r1.isFunction()     // Catch:{ all -> 0x00b9 }
            if (r1 == 0) goto L_0x0018
            com.luajava.LuaObject r1 = r5.f3377b     // Catch:{ all -> 0x00b9 }
            goto L_0x001e
        L_0x0018:
            com.luajava.LuaObject r1 = r5.f3377b     // Catch:{ all -> 0x00b9 }
            com.luajava.LuaObject r1 = r1.getField(r0)     // Catch:{ all -> 0x00b9 }
        L_0x001e:
            java.lang.Class r8 = r8.getReturnType()     // Catch:{ all -> 0x00b9 }
            boolean r2 = r1.isNil()     // Catch:{ all -> 0x00b9 }
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x0058
            java.lang.Class r7 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00b9 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x00b9 }
            if (r7 != 0) goto L_0x0052
            java.lang.Class<java.lang.Boolean> r7 = java.lang.Boolean.class
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x00b9 }
            if (r7 == 0) goto L_0x003b
            goto L_0x0052
        L_0x003b:
            boolean r7 = r8.isPrimitive()     // Catch:{ all -> 0x00b9 }
            if (r7 != 0) goto L_0x004c
            java.lang.Class<java.lang.Number> r7 = java.lang.Number.class
            boolean r7 = r7.isAssignableFrom(r8)     // Catch:{ all -> 0x00b9 }
            if (r7 == 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            monitor-exit(r6)     // Catch:{ all -> 0x00b9 }
            return r3
        L_0x004c:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r6)     // Catch:{ all -> 0x00b9 }
            return r7
        L_0x0052:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r6)     // Catch:{ all -> 0x00b9 }
            return r7
        L_0x0058:
            java.lang.Class<java.lang.Void> r2 = java.lang.Void.class
            boolean r2 = r8.equals(r2)     // Catch:{ LuaException -> 0x0084 }
            if (r2 != 0) goto L_0x0080
            java.lang.Class r2 = java.lang.Void.TYPE     // Catch:{ LuaException -> 0x0084 }
            boolean r2 = r8.equals(r2)     // Catch:{ LuaException -> 0x0084 }
            if (r2 == 0) goto L_0x0069
            goto L_0x0080
        L_0x0069:
            java.lang.Object r7 = r1.call(r7)     // Catch:{ LuaException -> 0x0084 }
            if (r7 == 0) goto L_0x007e
            boolean r1 = r7 instanceof java.lang.Double     // Catch:{ LuaException -> 0x007b }
            if (r1 == 0) goto L_0x007e
            r1 = r7
            java.lang.Double r1 = (java.lang.Double) r1     // Catch:{ LuaException -> 0x007b }
            java.lang.Number r3 = com.luajava.LuaState.convertLuaNumber(r1, r8)     // Catch:{ LuaException -> 0x007b }
            goto L_0x008a
        L_0x007b:
            r1 = move-exception
            r3 = r7
            goto L_0x0085
        L_0x007e:
            r3 = r7
            goto L_0x008a
        L_0x0080:
            r1.call(r7)     // Catch:{ LuaException -> 0x0084 }
            goto L_0x008a
        L_0x0084:
            r1 = move-exception
        L_0x0085:
            com.androlua.LuaContext r7 = r5.f3376a     // Catch:{ all -> 0x00b9 }
            r7.sendError(r0, r1)     // Catch:{ all -> 0x00b9 }
        L_0x008a:
            if (r3 != 0) goto L_0x00b7
            java.lang.Class r7 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00b9 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x00b9 }
            if (r7 != 0) goto L_0x00b1
            java.lang.Class<java.lang.Boolean> r7 = java.lang.Boolean.class
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x00b9 }
            if (r7 == 0) goto L_0x009d
            goto L_0x00b1
        L_0x009d:
            boolean r7 = r8.isPrimitive()     // Catch:{ all -> 0x00b9 }
            if (r7 != 0) goto L_0x00ab
            java.lang.Class<java.lang.Number> r7 = java.lang.Number.class
            boolean r7 = r7.isAssignableFrom(r8)     // Catch:{ all -> 0x00b9 }
            if (r7 == 0) goto L_0x00b7
        L_0x00ab:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r6)     // Catch:{ all -> 0x00b9 }
            return r7
        L_0x00b1:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r6)     // Catch:{ all -> 0x00b9 }
            return r7
        L_0x00b7:
            monitor-exit(r6)     // Catch:{ all -> 0x00b9 }
            return r3
        L_0x00b9:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00b9 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaAbstractMethodInterceptor.intercept(java.lang.Object, java.lang.Object[], com.android.cglib.proxy.MethodProxy):java.lang.Object");
    }
}
