package com.luajava;

import com.android.cglib.proxy.MethodInterceptor;
import com.android.cglib.proxy.MethodProxy;
import com.androlua.LuaContext;

public class LuaMethodInterceptor implements MethodInterceptor {

    /* renamed from: a */
    private final LuaContext f3387a;

    /* renamed from: b */
    private LuaObject f3388b;

    private class SuperCall implements LuaMetaTable {

        /* renamed from: b */
        private final Object f3390b;

        /* renamed from: c */
        private final MethodProxy f3391c;

        public SuperCall(Object obj, MethodProxy methodProxy) {
            this.f3390b = obj;
            this.f3391c = methodProxy;
        }

        public Object __call(Object... objArr) {
            return this.f3391c.invokeSuper(this.f3390b, objArr);
        }

        public Object __index(String str) {
            return null;
        }

        public void __newIndex(String str, Object obj) {
        }
    }

    public LuaMethodInterceptor(LuaObject luaObject) {
        this.f3388b = luaObject;
        this.f3387a = luaObject.getLuaState().getContext();
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object intercept(java.lang.Object r10, java.lang.Object[] r11, com.android.cglib.proxy.MethodProxy r12) {
        /*
            r9 = this;
            com.luajava.LuaObject r0 = r9.f3388b
            com.luajava.LuaState r0 = r0.f3393b
            monitor-enter(r0)
            java.lang.reflect.Method r1 = r12.getOriginalMethod()     // Catch:{ all -> 0x00c9 }
            java.lang.String r2 = r1.getName()     // Catch:{ all -> 0x00c9 }
            com.luajava.LuaObject r3 = r9.f3388b     // Catch:{ all -> 0x00c9 }
            boolean r3 = r3.isFunction()     // Catch:{ all -> 0x00c9 }
            if (r3 == 0) goto L_0x0018
            com.luajava.LuaObject r3 = r9.f3388b     // Catch:{ all -> 0x00c9 }
            goto L_0x001e
        L_0x0018:
            com.luajava.LuaObject r3 = r9.f3388b     // Catch:{ all -> 0x00c9 }
            com.luajava.LuaObject r3 = r3.getField(r2)     // Catch:{ all -> 0x00c9 }
        L_0x001e:
            java.lang.Class r1 = r1.getReturnType()     // Catch:{ all -> 0x00c9 }
            boolean r4 = r3.isNil()     // Catch:{ all -> 0x00c9 }
            r5 = 0
            r6 = 0
            if (r4 == 0) goto L_0x0058
            java.lang.Class r10 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00c9 }
            boolean r10 = r1.equals(r10)     // Catch:{ all -> 0x00c9 }
            if (r10 != 0) goto L_0x0052
            java.lang.Class<java.lang.Boolean> r10 = java.lang.Boolean.class
            boolean r10 = r1.equals(r10)     // Catch:{ all -> 0x00c9 }
            if (r10 == 0) goto L_0x003b
            goto L_0x0052
        L_0x003b:
            boolean r10 = r1.isPrimitive()     // Catch:{ all -> 0x00c9 }
            if (r10 != 0) goto L_0x004c
            java.lang.Class<java.lang.Number> r10 = java.lang.Number.class
            boolean r10 = r10.isAssignableFrom(r1)     // Catch:{ all -> 0x00c9 }
            if (r10 == 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x00c9 }
            return r5
        L_0x004c:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00c9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c9 }
            return r10
        L_0x0052:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x00c9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c9 }
            return r10
        L_0x0058:
            int r4 = r11.length     // Catch:{ all -> 0x00c9 }
            r7 = 1
            int r4 = r4 + r7
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00c9 }
            int r8 = r11.length     // Catch:{ all -> 0x00c9 }
            java.lang.System.arraycopy(r11, r6, r4, r7, r8)     // Catch:{ all -> 0x00c9 }
            com.luajava.LuaMethodInterceptor$SuperCall r11 = new com.luajava.LuaMethodInterceptor$SuperCall     // Catch:{ all -> 0x00c9 }
            r11.<init>(r10, r12)     // Catch:{ all -> 0x00c9 }
            r4[r6] = r11     // Catch:{ all -> 0x00c9 }
            java.lang.Class<java.lang.Void> r10 = java.lang.Void.class
            boolean r10 = r1.equals(r10)     // Catch:{ LuaException -> 0x0094 }
            if (r10 != 0) goto L_0x0090
            java.lang.Class r10 = java.lang.Void.TYPE     // Catch:{ LuaException -> 0x0094 }
            boolean r10 = r1.equals(r10)     // Catch:{ LuaException -> 0x0094 }
            if (r10 == 0) goto L_0x0079
            goto L_0x0090
        L_0x0079:
            java.lang.Object r10 = r3.call(r4)     // Catch:{ LuaException -> 0x0094 }
            if (r10 == 0) goto L_0x008e
            boolean r11 = r10 instanceof java.lang.Double     // Catch:{ LuaException -> 0x008b }
            if (r11 == 0) goto L_0x008e
            r11 = r10
            java.lang.Double r11 = (java.lang.Double) r11     // Catch:{ LuaException -> 0x008b }
            java.lang.Number r5 = com.luajava.LuaState.convertLuaNumber(r11, r1)     // Catch:{ LuaException -> 0x008b }
            goto L_0x009a
        L_0x008b:
            r11 = move-exception
            r5 = r10
            goto L_0x0095
        L_0x008e:
            r5 = r10
            goto L_0x009a
        L_0x0090:
            r3.call(r4)     // Catch:{ LuaException -> 0x0094 }
            goto L_0x009a
        L_0x0094:
            r11 = move-exception
        L_0x0095:
            com.androlua.LuaContext r10 = r9.f3387a     // Catch:{ all -> 0x00c9 }
            r10.sendError(r2, r11)     // Catch:{ all -> 0x00c9 }
        L_0x009a:
            if (r5 != 0) goto L_0x00c7
            java.lang.Class r10 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00c9 }
            boolean r10 = r1.equals(r10)     // Catch:{ all -> 0x00c9 }
            if (r10 != 0) goto L_0x00c1
            java.lang.Class<java.lang.Boolean> r10 = java.lang.Boolean.class
            boolean r10 = r1.equals(r10)     // Catch:{ all -> 0x00c9 }
            if (r10 == 0) goto L_0x00ad
            goto L_0x00c1
        L_0x00ad:
            boolean r10 = r1.isPrimitive()     // Catch:{ all -> 0x00c9 }
            if (r10 != 0) goto L_0x00bb
            java.lang.Class<java.lang.Number> r10 = java.lang.Number.class
            boolean r10 = r10.isAssignableFrom(r1)     // Catch:{ all -> 0x00c9 }
            if (r10 == 0) goto L_0x00c7
        L_0x00bb:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00c9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c9 }
            return r10
        L_0x00c1:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x00c9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c9 }
            return r10
        L_0x00c7:
            monitor-exit(r0)     // Catch:{ all -> 0x00c9 }
            return r5
        L_0x00c9:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c9 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaMethodInterceptor.intercept(java.lang.Object, java.lang.Object[], com.android.cglib.proxy.MethodProxy):java.lang.Object");
    }
}
