package com.luajava;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import com.android.cglib.proxy.EnhancerInterface;
import com.android.cglib.proxy.MethodFilter;
import com.androlua.BuildConfig;
import com.androlua.LuaBitmap;
import com.androlua.LuaEnhancer;
import com.androlua.LuaGcable;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class LuaJavaAPI {

    /* renamed from: a */
    private static final HashMap<Class<?>, HashMap<String, ArrayList<Method>>> f3380a = new HashMap<>();

    /* renamed from: b */
    private static HashMap<String, Method> f3381b = new HashMap<>();

    /* renamed from: c */
    private static HashMap<String, Method> f3382c = new HashMap<>();

    /* renamed from: d */
    private static HashMap<String, Method> f3383d = new HashMap<>();

    /* renamed from: e */
    private static HashMap<String, Method> f3384e = new HashMap<>();

    /* renamed from: f */
    private static HashMap<String, Method> f3385f = new HashMap<>();
    public static final HashMap<String, Method[]> methodCache = new HashMap<>();
    public static final HashMap<Class<?>, Method[]> methodsMap = new HashMap<>();

    private LuaJavaAPI() {
    }

    /* renamed from: a */
    private static int m3259a(LuaState luaState, Class<?> cls) {
        try {
            EnhancerInterface enhancerInterface = (EnhancerInterface) new LuaEnhancer(cls).create(new MethodFilter() {
                public boolean filter(Method method, String str) {
                    return (method.getModifiers() & 1024) == 0;
                }
            }).newInstance();
            enhancerInterface.setMethodInterceptor_Enhancer(new LuaAbstractMethodInterceptor(luaState.getLuaObject(-1)));
            luaState.pushJavaObject(enhancerInterface);
            return 1;
        } catch (Exception e) {
            C0029a.m806a(e);
            return 0;
        }
    }

    /* renamed from: a */
    private static int m3260a(LuaState luaState, Object obj) {
        synchronized (luaState) {
            try {
                luaState.newTable();
                if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    int i = 0;
                    while (i <= length - 1) {
                        m3260a(luaState, Array.get(obj, i));
                        i++;
                        luaState.rawSetI(-2, (long) i);
                    }
                } else if (obj instanceof Collection) {
                    int i2 = 1;
                    for (Object a : (Collection) obj) {
                        m3260a(luaState, a);
                        int i3 = i2 + 1;
                        luaState.rawSetI(-2, (long) i2);
                        i2 = i3;
                    }
                } else if (obj instanceof Map) {
                    for (Entry entry : ((Map) obj).entrySet()) {
                        luaState.pushObjectValue(entry.getKey());
                        m3260a(luaState, entry.getValue());
                        luaState.setTable(-3);
                    }
                } else {
                    luaState.pop(1);
                    luaState.pushObjectValue(obj);
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("can not astable: ");
                sb.append(e.getMessage());
                throw new LuaException(sb.toString());
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a2, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a8, code lost:
        throw new com.luajava.LuaException(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a9, code lost:
        m3267a(r9, r11, 3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b0, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0006, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:3:0x0004, B:42:0x0089] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m3261a(com.luajava.LuaState r9, java.lang.Object r10, java.lang.String r11) {
        /*
            monitor-enter(r9)
            r0 = 0
            if (r10 != 0) goto L_0x0009
            monitor-exit(r9)     // Catch:{ all -> 0x0006 }
            return r0
        L_0x0006:
            r10 = move-exception
            goto L_0x00af
        L_0x0009:
            boolean r1 = r10 instanceof java.lang.Class     // Catch:{ all -> 0x0006 }
            r2 = 1
            if (r1 == 0) goto L_0x0014
            r1 = r10
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x0006 }
            r3 = r1
            r1 = 1
            goto L_0x001a
        L_0x0014:
            java.lang.Class r1 = r10.getClass()     // Catch:{ all -> 0x0006 }
            r3 = r1
            r1 = 0
        L_0x001a:
            java.lang.String r4 = "m"
            boolean r4 = r11.startsWith(r4)     // Catch:{ all -> 0x0006 }
            r5 = 0
            if (r4 != 0) goto L_0x005b
            char r4 = r11.charAt(r0)     // Catch:{ all -> 0x0006 }
            boolean r6 = java.lang.Character.isLowerCase(r4)     // Catch:{ all -> 0x0006 }
            if (r6 == 0) goto L_0x0045
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0006 }
            r6.<init>()     // Catch:{ all -> 0x0006 }
            char r4 = java.lang.Character.toUpperCase(r4)     // Catch:{ all -> 0x0006 }
            r6.append(r4)     // Catch:{ all -> 0x0006 }
            java.lang.String r4 = r11.substring(r2)     // Catch:{ all -> 0x0006 }
            r6.append(r4)     // Catch:{ all -> 0x0006 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0006 }
            goto L_0x0046
        L_0x0045:
            r4 = r5
        L_0x0046:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0006 }
            r6.<init>()     // Catch:{ all -> 0x0006 }
            java.lang.String r7 = "m"
            r6.append(r7)     // Catch:{ all -> 0x0006 }
            r6.append(r4)     // Catch:{ all -> 0x0006 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0006 }
            r8 = r5
            r5 = r4
            r4 = r8
            goto L_0x005c
        L_0x005b:
            r4 = r5
        L_0x005c:
            if (r3 == 0) goto L_0x0073
            java.lang.reflect.Field r6 = r3.getDeclaredField(r11)     // Catch:{ NoSuchFieldException -> 0x0064 }
        L_0x0062:
            r4 = r6
            goto L_0x006b
        L_0x0064:
            if (r5 == 0) goto L_0x006b
            java.lang.reflect.Field r6 = r3.getDeclaredField(r5)     // Catch:{ NoSuchFieldException -> 0x006b }
            goto L_0x0062
        L_0x006b:
            if (r4 == 0) goto L_0x006e
            goto L_0x0073
        L_0x006e:
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ all -> 0x0006 }
            goto L_0x005c
        L_0x0073:
            if (r4 != 0) goto L_0x0077
            monitor-exit(r9)     // Catch:{ all -> 0x0006 }
            return r0
        L_0x0077:
            if (r1 == 0) goto L_0x0085
            int r1 = r4.getModifiers()     // Catch:{ all -> 0x0006 }
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)     // Catch:{ all -> 0x0006 }
            if (r1 != 0) goto L_0x0085
            monitor-exit(r9)     // Catch:{ all -> 0x0006 }
            return r0
        L_0x0085:
            java.lang.Class r0 = r4.getType()     // Catch:{ all -> 0x0006 }
            int r1 = r4.getModifiers()     // Catch:{ LuaException -> 0x00a9, Exception -> 0x00a2 }
            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)     // Catch:{ LuaException -> 0x00a9, Exception -> 0x00a2 }
            if (r1 != 0) goto L_0x0096
            r4.setAccessible(r2)     // Catch:{ LuaException -> 0x00a9, Exception -> 0x00a2 }
        L_0x0096:
            int r1 = r9.getTop()     // Catch:{ LuaException -> 0x00a9, Exception -> 0x00a2 }
            java.lang.Object r1 = m3277e(r9, r0, r1)     // Catch:{ LuaException -> 0x00a9, Exception -> 0x00a2 }
            r4.set(r10, r1)     // Catch:{ LuaException -> 0x00a9, Exception -> 0x00a2 }
            goto L_0x00ad
        L_0x00a2:
            r10 = move-exception
            com.luajava.LuaException r11 = new com.luajava.LuaException     // Catch:{ all -> 0x0006 }
            r11.<init>(r10)     // Catch:{ all -> 0x0006 }
            throw r11     // Catch:{ all -> 0x0006 }
        L_0x00a9:
            r10 = 3
            m3267a(r9, r11, r10, r0)     // Catch:{ all -> 0x0006 }
        L_0x00ad:
            monitor-exit(r9)     // Catch:{ all -> 0x0006 }
            return r2
        L_0x00af:
            monitor-exit(r9)     // Catch:{ all -> 0x0006 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaJavaAPI.m3261a(com.luajava.LuaState, java.lang.Object, java.lang.String):int");
    }

    /* renamed from: a */
    private static int m3262a(LuaState luaState, Object obj, String str, boolean z) {
        synchronized (luaState) {
            StringBuilder sb = new StringBuilder();
            sb.append("setOn");
            sb.append(str.substring(2));
            sb.append("Listener");
            Iterator it = getMethod(obj.getClass(), sb.toString(), z).iterator();
            while (it.hasNext()) {
                Method method = (Method) it.next();
                if (!z || Modifier.isStatic(method.getModifiers())) {
                    Class[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1 && parameterTypes[0].isInterface()) {
                        luaState.newTable();
                        luaState.pushValue(-2);
                        luaState.setField(-2, str);
                        try {
                            Object createProxy = luaState.getLuaObject(-1).createProxy(parameterTypes[0]);
                            luaState.pop(1);
                            method.invoke(obj, new Object[]{createProxy});
                            return 1;
                        } catch (Exception e) {
                            throw new LuaException(e);
                        }
                    }
                }
            }
            return 0;
        }
    }

    /* renamed from: a */
    private static int m3263a(LuaState luaState, String str) {
        synchronized (luaState) {
            try {
                luaState.pushJavaObject(luaState.getLuaObject(2).createProxy(str));
            } catch (Exception e) {
                throw new LuaException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    /* renamed from: a */
    private static Object m3264a(LuaState luaState, Class cls, int i) {
        Object createProxy;
        synchronized (luaState) {
            try {
                createProxy = luaState.getLuaObject(i).createProxy(cls);
            } catch (Exception e) {
                throw new LuaException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return createProxy;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x007d, code lost:
        if (r4.isAssignableFrom(com.luajava.LuaObject.class) == false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0086, code lost:
        r0 = m3264a(r3, (java.lang.Class) r4, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0092, code lost:
        if (r4.isAssignableFrom(com.luajava.LuaFunction.class) == false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x009d, code lost:
        r0 = r3.getLuaObject(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00d3, code lost:
        if (r4.isInterface() != false) goto L_0x0086;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object m3265a(com.luajava.LuaState r3, java.lang.Class<?> r4, int r5, int r6) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1
            r2 = 0
            if (r5 == r1) goto L_0x011a
            switch(r5) {
                case 3: goto L_0x00e5;
                case 4: goto L_0x00d6;
                case 5: goto L_0x0095;
                case 6: goto L_0x0080;
                case 7: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            com.luajava.LuaException r3 = new com.luajava.LuaException
            java.lang.String r4 = "Invalid Parameters."
            r3.<init>(r4)
            throw r3
        L_0x0013:
            boolean r5 = r3.isObject(r6)
            if (r5 == 0) goto L_0x0077
            java.lang.Object r3 = r3.getObjectFromUserdata(r6)
            if (r3 != 0) goto L_0x0020
            return r0
        L_0x0020:
            boolean r5 = r4.isPrimitive()
            if (r5 == 0) goto L_0x0068
            r3.getClass()
            java.lang.Class r5 = java.lang.Byte.TYPE
            if (r4 != r5) goto L_0x0032
            boolean r5 = r3 instanceof java.lang.Byte
            if (r5 == 0) goto L_0x0032
            goto L_0x0067
        L_0x0032:
            java.lang.Class r5 = java.lang.Short.TYPE
            if (r4 != r5) goto L_0x003b
            boolean r5 = r3 instanceof java.lang.Short
            if (r5 == 0) goto L_0x003b
            goto L_0x0067
        L_0x003b:
            java.lang.Class r5 = java.lang.Integer.TYPE
            if (r4 != r5) goto L_0x0044
            boolean r5 = r3 instanceof java.lang.Integer
            if (r5 == 0) goto L_0x0044
            goto L_0x0067
        L_0x0044:
            java.lang.Class r5 = java.lang.Long.TYPE
            if (r4 != r5) goto L_0x004d
            boolean r5 = r3 instanceof java.lang.Long
            if (r5 == 0) goto L_0x004d
            goto L_0x0067
        L_0x004d:
            java.lang.Class r5 = java.lang.Float.TYPE
            if (r4 != r5) goto L_0x0056
            boolean r5 = r3 instanceof java.lang.Float
            if (r5 == 0) goto L_0x0056
            goto L_0x0067
        L_0x0056:
            java.lang.Class r5 = java.lang.Double.TYPE
            if (r4 != r5) goto L_0x005f
            boolean r5 = r3 instanceof java.lang.Double
            if (r5 == 0) goto L_0x005f
            goto L_0x0067
        L_0x005f:
            java.lang.Class r5 = java.lang.Character.TYPE
            if (r4 != r5) goto L_0x0068
            boolean r5 = r3 instanceof java.lang.Character
            if (r5 == 0) goto L_0x0068
        L_0x0067:
            r0 = r3
        L_0x0068:
            if (r0 != 0) goto L_0x0135
            java.lang.Class r5 = r3.getClass()
            boolean r4 = r4.isAssignableFrom(r5)
            if (r4 == 0) goto L_0x00de
            r0 = r3
            goto L_0x0135
        L_0x0077:
            java.lang.Class<com.luajava.LuaObject> r5 = com.luajava.LuaObject.class
            boolean r4 = r4.isAssignableFrom(r5)
            if (r4 != 0) goto L_0x009d
            goto L_0x00de
        L_0x0080:
            boolean r5 = r4.isInterface()
            if (r5 == 0) goto L_0x008c
        L_0x0086:
            java.lang.Object r0 = m3264a(r3, r4, r6)
            goto L_0x0135
        L_0x008c:
            java.lang.Class<com.luajava.LuaFunction> r5 = com.luajava.LuaFunction.class
            boolean r4 = r4.isAssignableFrom(r5)
            if (r4 != 0) goto L_0x009d
            goto L_0x00de
        L_0x0095:
            java.lang.Class<com.luajava.LuaTable> r5 = com.luajava.LuaTable.class
            boolean r5 = r4.isAssignableFrom(r5)
            if (r5 == 0) goto L_0x00a3
        L_0x009d:
            com.luajava.LuaObject r0 = r3.getLuaObject(r6)
            goto L_0x0135
        L_0x00a3:
            boolean r5 = r4.isArray()
            if (r5 == 0) goto L_0x00b3
            java.lang.Class r4 = r4.getComponentType()
            java.lang.Object r0 = m3271b(r3, r4, r6)
            goto L_0x0135
        L_0x00b3:
            java.lang.Class<java.util.List> r5 = java.util.List.class
            boolean r5 = r5.isAssignableFrom(r4)
            if (r5 == 0) goto L_0x00c1
            java.lang.Object r0 = m3273c(r3, r4, r6)
            goto L_0x0135
        L_0x00c1:
            java.lang.Class<java.util.Map> r5 = java.util.Map.class
            boolean r5 = r5.isAssignableFrom(r4)
            if (r5 == 0) goto L_0x00cf
            java.lang.Object r0 = m3275d(r3, r4, r6)
            goto L_0x0135
        L_0x00cf:
            boolean r5 = r4.isInterface()
            if (r5 == 0) goto L_0x00de
            goto L_0x0086
        L_0x00d6:
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            boolean r4 = r4.isAssignableFrom(r5)
            if (r4 != 0) goto L_0x00e0
        L_0x00de:
            r1 = 0
            goto L_0x0135
        L_0x00e0:
            java.lang.String r0 = r3.toString(r6)
            goto L_0x0135
        L_0x00e5:
            boolean r5 = r4.isPrimitive()
            if (r5 != 0) goto L_0x00f4
            java.lang.Class<java.lang.Number> r5 = java.lang.Number.class
            boolean r5 = r4.isAssignableFrom(r5)
            if (r5 != 0) goto L_0x00f4
            goto L_0x00de
        L_0x00f4:
            boolean r5 = r3.isInteger(r6)
            if (r5 == 0) goto L_0x0107
            long r5 = r3.toInteger(r6)
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            java.lang.Number r0 = com.luajava.LuaState.convertLuaNumber(r3, r4)
            goto L_0x0135
        L_0x0107:
            boolean r5 = r3.isNumber(r6)
            if (r5 == 0) goto L_0x0135
            double r5 = r3.toNumber(r6)
            java.lang.Double r3 = java.lang.Double.valueOf(r5)
            java.lang.Number r0 = com.luajava.LuaState.convertLuaNumber(r3, r4)
            goto L_0x0135
        L_0x011a:
            boolean r5 = r4.isPrimitive()
            if (r5 == 0) goto L_0x012d
            java.lang.Class r5 = java.lang.Boolean.TYPE
            if (r4 == r5) goto L_0x012d
            java.lang.Class<java.lang.Boolean> r5 = java.lang.Boolean.class
            boolean r4 = r4.isAssignableFrom(r5)
            if (r4 != 0) goto L_0x012d
            goto L_0x00de
        L_0x012d:
            boolean r3 = r3.toBoolean(r6)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
        L_0x0135:
            if (r1 == 0) goto L_0x013b
            if (r0 != 0) goto L_0x013a
            goto L_0x013b
        L_0x013a:
            return r0
        L_0x013b:
            com.luajava.LuaException r3 = new com.luajava.LuaException
            java.lang.String r4 = "Invalid Parameter."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaJavaAPI.m3265a(com.luajava.LuaState, java.lang.Class, int, int):java.lang.Object");
    }

    /* renamed from: a */
    private static String m3266a(LuaState luaState, int i) {
        if (luaState.isObject(i)) {
            return luaState.getObjectFromUserdata(i).getClass().getName();
        }
        switch (luaState.type(i)) {
            case 1:
                return "boolean";
            case 2:
            case 7:
                return "userdata";
            case 3:
                return "number";
            case 4:
                return "string";
            case 5:
                return "table";
            case 6:
                return "function";
            case 8:
                return "thread";
            default:
                return "unkown";
        }
    }

    /* renamed from: a */
    private static String m3267a(LuaState luaState, String str, int i, Class cls) {
        StringBuilder sb = new StringBuilder();
        sb.append("bad argument to '");
        sb.append(str);
        sb.append("' (");
        sb.append(cls.getName());
        sb.append(" expected, got ");
        sb.append(m3266a(luaState, i));
        sb.append(" value)");
        throw new LuaException(sb.toString());
    }

    /* renamed from: a */
    private static String m3268a(LuaState luaState, String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("bad argument #");
        sb.append(i);
        sb.append(" to '");
        sb.append(str);
        sb.append("' (");
        sb.append(str2);
        sb.append(" expected, got ");
        sb.append(m3266a(luaState, i + 1));
        sb.append(" value)");
        throw new LuaException(sb.toString());
    }

    public static int asTable(long j, Object obj) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            if (!existingState.isBoolean(-1) || !existingState.toBoolean(-1)) {
                try {
                    existingState.newTable();
                    if (obj.getClass().isArray()) {
                        int length = Array.getLength(obj);
                        int i = 0;
                        while (i <= length - 1) {
                            existingState.pushObjectValue(Array.get(obj, i));
                            i++;
                            existingState.rawSetI(-2, (long) i);
                        }
                    } else if (obj instanceof Collection) {
                        int i2 = 1;
                        for (Object pushObjectValue : (Collection) obj) {
                            existingState.pushObjectValue(pushObjectValue);
                            int i3 = i2 + 1;
                            existingState.rawSetI(-2, (long) i2);
                            i2 = i3;
                        }
                    } else if (obj instanceof Map) {
                        for (Entry entry : ((Map) obj).entrySet()) {
                            existingState.pushObjectValue(entry.getKey());
                            existingState.pushObjectValue(entry.getValue());
                            existingState.setTable(-3);
                        }
                    }
                    existingState.pushValue(-1);
                    return 1;
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("can not astable: ");
                    sb.append(e.getMessage());
                    throw new LuaException(sb.toString());
                }
            } else {
                existingState.pop(1);
                int a = m3260a(existingState, obj);
                return a;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r8v5, types: [java.lang.Throwable] */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r12.pushJavaObject(r13.getConstructor(new java.lang.Class[]{android.content.Context.class}).newInstance(new java.lang.Object[]{r12.getContext().getContext()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        return 1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0012 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m3269b(com.luajava.LuaState r12, java.lang.Class<?> r13) {
        /*
            monitor-enter(r12)
            int r0 = r12.getTop()     // Catch:{ all -> 0x00dd }
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L_0x0031
            java.lang.Object r3 = r13.newInstance()     // Catch:{ Exception -> 0x0012 }
            r12.pushJavaObject(r3)     // Catch:{ Exception -> 0x0012 }
            monitor-exit(r12)     // Catch:{ all -> 0x00dd }
            return r2
        L_0x0012:
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0031 }
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r3[r1] = r4     // Catch:{ Exception -> 0x0031 }
            java.lang.reflect.Constructor r3 = r13.getConstructor(r3)     // Catch:{ Exception -> 0x0031 }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0031 }
            com.androlua.LuaContext r5 = r12.getContext()     // Catch:{ Exception -> 0x0031 }
            android.content.Context r5 = r5.getContext()     // Catch:{ Exception -> 0x0031 }
            r4[r1] = r5     // Catch:{ Exception -> 0x0031 }
            java.lang.Object r3 = r3.newInstance(r4)     // Catch:{ Exception -> 0x0031 }
            r12.pushJavaObject(r3)     // Catch:{ Exception -> 0x0031 }
            monitor-exit(r12)     // Catch:{ all -> 0x00dd }
            return r2
        L_0x0031:
            int r0 = r0 - r2
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ all -> 0x00dd }
            java.lang.reflect.Constructor[] r13 = r13.getConstructors()     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
            r4.<init>()     // Catch:{ all -> 0x00dd }
            int r5 = r13.length     // Catch:{ all -> 0x00dd }
            r6 = 0
        L_0x003f:
            if (r6 >= r5) goto L_0x008d
            r7 = r13[r6]     // Catch:{ all -> 0x00dd }
            java.lang.Class[] r8 = r7.getParameterTypes()     // Catch:{ all -> 0x00dd }
            int r9 = r8.length     // Catch:{ all -> 0x00dd }
            if (r9 == r0) goto L_0x004b
            goto L_0x008a
        L_0x004b:
            r9 = 0
        L_0x004c:
            int r10 = r8.length     // Catch:{ all -> 0x00dd }
            if (r9 >= r10) goto L_0x005e
            r10 = r8[r9]     // Catch:{ Exception -> 0x005c }
            int r11 = r9 + 2
            java.lang.Object r10 = m3277e(r12, r10, r11)     // Catch:{ Exception -> 0x005c }
            r3[r9] = r10     // Catch:{ Exception -> 0x005c }
            int r9 = r9 + 1
            goto L_0x004c
        L_0x005c:
            r8 = 0
            goto L_0x005f
        L_0x005e:
            r8 = 1
        L_0x005f:
            if (r8 == 0) goto L_0x008a
            java.lang.Object r8 = r7.newInstance(r3)     // Catch:{ Exception -> 0x006a }
            r12.pushJavaObject(r8)     // Catch:{ all -> 0x00dd }
            monitor-exit(r12)     // Catch:{ all -> 0x00dd }
            return r2
        L_0x006a:
            r8 = move-exception
            java.lang.String r9 = "  at "
            r4.append(r9)     // Catch:{ all -> 0x00dd }
            r4.append(r7)     // Catch:{ all -> 0x00dd }
            java.lang.String r7 = "\n  -> "
            r4.append(r7)     // Catch:{ all -> 0x00dd }
            java.lang.Throwable r7 = r8.getCause()     // Catch:{ all -> 0x00dd }
            if (r7 == 0) goto L_0x0082
            java.lang.Throwable r8 = r8.getCause()     // Catch:{ all -> 0x00dd }
        L_0x0082:
            r4.append(r8)     // Catch:{ all -> 0x00dd }
            java.lang.String r7 = "\n"
            r4.append(r7)     // Catch:{ all -> 0x00dd }
        L_0x008a:
            int r6 = r6 + 1
            goto L_0x003f
        L_0x008d:
            int r0 = r4.length()     // Catch:{ all -> 0x00dd }
            if (r0 <= 0) goto L_0x00ae
            com.luajava.LuaException r13 = new com.luajava.LuaException     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
            r0.<init>()     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "Invalid constructor method call.\n"
            r0.append(r1)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00dd }
            r0.append(r1)     // Catch:{ all -> 0x00dd }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00dd }
            r13.<init>(r0)     // Catch:{ all -> 0x00dd }
            throw r13     // Catch:{ all -> 0x00dd }
        L_0x00ae:
            int r0 = r13.length     // Catch:{ all -> 0x00dd }
        L_0x00af:
            if (r1 >= r0) goto L_0x00c2
            r2 = r13[r1]     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00dd }
            r4.append(r2)     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = "\n"
            r4.append(r2)     // Catch:{ all -> 0x00dd }
            int r1 = r1 + 1
            goto L_0x00af
        L_0x00c2:
            com.luajava.LuaException r13 = new com.luajava.LuaException     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
            r0.<init>()     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = "Invalid constructor method call. Invalid Parameters.\n"
            r0.append(r1)     // Catch:{ all -> 0x00dd }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00dd }
            r0.append(r1)     // Catch:{ all -> 0x00dd }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00dd }
            r13.<init>(r0)     // Catch:{ all -> 0x00dd }
            throw r13     // Catch:{ all -> 0x00dd }
        L_0x00dd:
            r13 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00dd }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaJavaAPI.m3269b(com.luajava.LuaState, java.lang.Class):int");
    }

    /* renamed from: b */
    private static int m3270b(LuaState luaState, Object obj, String str, boolean z) {
        char c;
        HashMap<String, Method> hashMap;
        LuaState luaState2 = luaState;
        Object obj2 = obj;
        String str2 = str;
        boolean z2 = z;
        synchronized (luaState) {
            char c2 = 0;
            try {
                char charAt = str2.charAt(0);
                if (Character.isLowerCase(charAt)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Character.toUpperCase(charAt));
                    sb.append(str2.substring(1));
                    str2 = sb.toString();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("set");
                sb2.append(str2);
                String sb3 = sb2.toString();
                Method method = null;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(obj.getClass().getName());
                sb4.append("@->");
                sb4.append(sb3);
                String sb5 = sb4.toString();
                Object[] objArr = new Object[1];
                int type = luaState2.type(-1);
                if (type != 1) {
                    switch (type) {
                        case 3:
                            if (!luaState2.isInteger(-1)) {
                                Method method2 = (Method) f3383d.get(sb5);
                                if (method2 != null) {
                                    objArr[0] = LuaState.convertLuaNumber(Double.valueOf(luaState2.toNumber(-1)), method2.getParameterTypes()[0]);
                                }
                                method = method2;
                                c = 3;
                                break;
                            } else {
                                method = (Method) f3382c.get(sb5);
                                if (method != null) {
                                    objArr[0] = LuaState.convertLuaNumber(Long.valueOf(luaState2.toInteger(-1)), method.getParameterTypes()[0]);
                                }
                                c = 9;
                                break;
                            }
                        case 4:
                            Method method3 = (Method) f3381b.get(sb5);
                            if (method3 != null) {
                                objArr[0] = luaState2.toString(-1);
                            }
                            method = method3;
                            c = 4;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                } else {
                    method = (Method) f3384e.get(sb5);
                    if (method != null) {
                        objArr[0] = Boolean.valueOf(luaState2.toBoolean(-1));
                    }
                    c = 1;
                }
                if (method != null) {
                    method.invoke(obj2, objArr);
                    return 1;
                }
                ArrayList method4 = getMethod(obj.getClass(), sb3, z2);
                StringBuilder sb6 = new StringBuilder();
                Iterator it = method4.iterator();
                while (it.hasNext()) {
                    Method method5 = (Method) it.next();
                    if (!z2 || Modifier.isStatic(method5.getModifiers())) {
                        Class[] parameterTypes = method5.getParameterTypes();
                        if (parameterTypes.length == 1) {
                            try {
                                Object e = m3277e(luaState2, parameterTypes[c2], luaState.getTop());
                                if (c == 1) {
                                    hashMap = f3384e;
                                } else if (c != 9) {
                                    switch (c) {
                                        case 3:
                                            hashMap = f3383d;
                                            break;
                                        case 4:
                                            hashMap = f3381b;
                                            break;
                                    }
                                } else {
                                    hashMap = f3382c;
                                }
                                hashMap.put(sb5, method5);
                                method5.invoke(obj2, new Object[]{e});
                                return 1;
                            } catch (LuaException unused) {
                                sb6.append("-> ");
                                sb6.append(parameterTypes[0]);
                                sb6.append("\n");
                                c2 = 0;
                            }
                        }
                    }
                }
                int top = luaState.getTop();
                if (luaState2.type(top) == 5) {
                    luaState2.getField(1, sb3);
                    LuaFunction function = luaState2.getFunction(-1);
                    if (luaState2.type(-1) == 6 && function != null) {
                        int rawLen = luaState2.rawLen(top);
                        int i = 0;
                        while (i < rawLen) {
                            i++;
                            luaState2.getI(top, (long) i);
                        }
                        if (luaState2.pcall(rawLen, 0, 0) == 0) {
                            return 1;
                        }
                        throw new LuaException(luaState2.toString(-1));
                    }
                }
                if (sb6.length() <= 0) {
                    return 0;
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Invalid setter ");
                sb7.append(str2);
                sb7.append(". Invalid Parameters.\n");
                sb7.append(sb6.toString());
                sb7.append(luaState2.toJavaObject(-1).getClass());
                throw new LuaException(sb7.toString());
            } catch (Exception e2) {
                throw new LuaException(e2);
            } catch (Exception e3) {
                throw new LuaException(e3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    private static Object m3271b(LuaState luaState, Class<?> cls, int i) {
        Object newInstance;
        synchronized (luaState) {
            try {
                int objLen = luaState.objLen(i);
                newInstance = Array.newInstance(cls, objLen);
                if (cls == String.class) {
                    for (int i2 = 1; i2 <= objLen; i2++) {
                        luaState.pushNumber((double) i2);
                        luaState.getTable(i);
                        Array.set(newInstance, i2 - 1, luaState.toString(-1));
                        luaState.pop(1);
                    }
                } else if (cls == Double.TYPE) {
                    for (int i3 = 1; i3 <= objLen; i3++) {
                        luaState.pushNumber((double) i3);
                        luaState.getTable(i);
                        Array.set(newInstance, i3 - 1, Double.valueOf(luaState.toNumber(-1)));
                        luaState.pop(1);
                    }
                } else if (cls == Float.TYPE) {
                    for (int i4 = 1; i4 <= objLen; i4++) {
                        luaState.pushNumber((double) i4);
                        luaState.getTable(i);
                        Array.set(newInstance, i4 - 1, Float.valueOf((float) luaState.toNumber(-1)));
                        luaState.pop(1);
                    }
                } else if (cls == Long.TYPE) {
                    for (int i5 = 1; i5 <= objLen; i5++) {
                        luaState.pushNumber((double) i5);
                        luaState.getTable(i);
                        Array.set(newInstance, i5 - 1, Long.valueOf(luaState.toInteger(-1)));
                        luaState.pop(1);
                    }
                } else if (cls == Integer.TYPE) {
                    for (int i6 = 1; i6 <= objLen; i6++) {
                        luaState.pushNumber((double) i6);
                        luaState.getTable(i);
                        Array.set(newInstance, i6 - 1, Integer.valueOf((int) luaState.toInteger(-1)));
                        luaState.pop(1);
                    }
                } else if (cls == Short.TYPE) {
                    for (int i7 = 1; i7 <= objLen; i7++) {
                        luaState.pushNumber((double) i7);
                        luaState.getTable(i);
                        Array.set(newInstance, i7 - 1, Short.valueOf((short) ((int) luaState.toInteger(-1))));
                        luaState.pop(1);
                    }
                } else if (cls == Character.TYPE) {
                    for (int i8 = 1; i8 <= objLen; i8++) {
                        luaState.pushNumber((double) i8);
                        luaState.getTable(i);
                        Array.set(newInstance, i8 - 1, Character.valueOf((char) ((int) luaState.toInteger(-1))));
                        luaState.pop(1);
                    }
                } else if (cls == Byte.TYPE) {
                    for (int i9 = 1; i9 <= objLen; i9++) {
                        luaState.pushNumber((double) i9);
                        luaState.getTable(i);
                        Array.set(newInstance, i9 - 1, Byte.valueOf((byte) ((int) luaState.toInteger(-1))));
                        luaState.pop(1);
                    }
                } else {
                    for (int i10 = 1; i10 <= objLen; i10++) {
                        luaState.pushNumber((double) i10);
                        luaState.getTable(i);
                        Array.set(newInstance, i10 - 1, m3277e(luaState, cls, luaState.getTop()));
                        luaState.pop(1);
                    }
                }
            } catch (Exception e) {
                throw new LuaException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return newInstance;
    }

    /* renamed from: c */
    private static int m3272c(LuaState luaState, Class cls) {
        synchronized (luaState) {
            luaState.pushJavaObject(m3264a(luaState, cls, 2));
        }
        return 1;
    }

    /* renamed from: c */
    private static Object m3273c(LuaState luaState, Class<List<Object>> cls, int i) {
        List arrayList;
        synchronized (luaState) {
            int objLen = luaState.objLen(i);
            try {
                arrayList = cls.equals(List.class) ? new ArrayList() : (List) cls.newInstance();
                for (int i2 = 1; i2 <= objLen; i2++) {
                    luaState.pushNumber((double) i2);
                    luaState.getTable(i);
                    arrayList.add(luaState.toJavaObject(-1));
                    luaState.pop(1);
                }
            } catch (Exception e) {
                throw new LuaException(e);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r9v3, types: [java.lang.Exception] */
    /* JADX WARNING: type inference failed for: r9v4, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v6, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Exception] */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Exception] */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Exception] */
    /* JADX WARNING: type inference failed for: r1v14, types: [java.lang.Exception] */
    /* JADX WARNING: type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v18, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.lang.Exception] */
    /* JADX WARNING: type inference failed for: r1v20, types: [java.lang.Exception] */
    /* JADX WARNING: type inference failed for: r1v21, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v24, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r1v27 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v7
  assigns: [?[OBJECT, ARRAY], java.lang.Throwable]
  uses: [java.lang.Exception, java.lang.Object]
  mth insns count: 262
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01b4 A[SYNTHETIC, Splitter:B:97:0x01b4] */
    /* JADX WARNING: Unknown variable types count: 10 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int callMethod(long r19, java.lang.Object r21, java.lang.String r22) {
        /*
            r1 = r21
            r2 = r22
            com.luajava.LuaState r3 = com.luajava.LuaStateFactory.getExistingState(r19)
            monitor-enter(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0277 }
            r4.<init>()     // Catch:{ all -> 0x0277 }
            r5 = 0
            int r6 = r3.getTop()     // Catch:{ all -> 0x0277 }
            r7 = -1
            r8 = 0
            r9 = 1
            if (r6 != 0) goto L_0x007a
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r5 = f3385f     // Catch:{ all -> 0x0277 }
            java.lang.Object r5 = r5.get(r2)     // Catch:{ all -> 0x0277 }
            java.lang.reflect.Method r5 = (java.lang.reflect.Method) r5     // Catch:{ all -> 0x0277 }
            if (r5 == 0) goto L_0x0079
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x003d }
            java.lang.Object r1 = r5.invoke(r1, r2)     // Catch:{ Exception -> 0x003d }
            if (r1 != 0) goto L_0x0038
            java.lang.Class r2 = r5.getReturnType()     // Catch:{ all -> 0x0277 }
            java.lang.Class r4 = java.lang.Void.TYPE     // Catch:{ all -> 0x0277 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0277 }
            if (r2 == 0) goto L_0x0038
            monitor-exit(r3)     // Catch:{ all -> 0x0277 }
            return r8
        L_0x0038:
            r3.pushObjectValue(r1)     // Catch:{ all -> 0x0277 }
            monitor-exit(r3)     // Catch:{ all -> 0x0277 }
            return r9
        L_0x003d:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "  at "
            r4.append(r2)     // Catch:{ all -> 0x0277 }
            r4.append(r5)     // Catch:{ all -> 0x0277 }
            java.lang.String r2 = "\n  -> "
            r4.append(r2)     // Catch:{ all -> 0x0277 }
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0277 }
            if (r2 == 0) goto L_0x0056
            java.lang.Throwable r1 = r1.getCause()     // Catch:{ all -> 0x0277 }
        L_0x0056:
            r4.append(r1)     // Catch:{ all -> 0x0277 }
            java.lang.String r1 = "\n"
            r4.append(r1)     // Catch:{ all -> 0x0277 }
            com.luajava.LuaException r1 = new com.luajava.LuaException     // Catch:{ all -> 0x0277 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0277 }
            r2.<init>()     // Catch:{ all -> 0x0277 }
            java.lang.String r5 = "Invalid method call.\n"
            r2.append(r5)     // Catch:{ all -> 0x0277 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0277 }
            r2.append(r4)     // Catch:{ all -> 0x0277 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0277 }
            r1.<init>(r2)     // Catch:{ all -> 0x0277 }
            throw r1     // Catch:{ all -> 0x0277 }
        L_0x0079:
            r7 = 0
        L_0x007a:
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x0277 }
            if (r6 != r9) goto L_0x0160
            int r11 = r3.type(r9)     // Catch:{ all -> 0x0277 }
            if (r11 == r9) goto L_0x00e6
            switch(r11) {
                case 3: goto L_0x009f;
                case 4: goto L_0x008d;
                default: goto L_0x0087;
            }     // Catch:{ all -> 0x0277 }
        L_0x0087:
            r18 = r7
            r7 = r5
            r5 = r18
            goto L_0x00fc
        L_0x008d:
            r5 = 4
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r7 = f3381b     // Catch:{ all -> 0x0277 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x0277 }
            java.lang.reflect.Method r7 = (java.lang.reflect.Method) r7     // Catch:{ all -> 0x0277 }
            if (r7 == 0) goto L_0x00fc
            java.lang.String r11 = r3.toString(r9)     // Catch:{ all -> 0x0277 }
            r10[r8] = r11     // Catch:{ all -> 0x0277 }
            goto L_0x00fc
        L_0x009f:
            boolean r5 = r3.isInteger(r9)     // Catch:{ all -> 0x0277 }
            if (r5 == 0) goto L_0x00c6
            r5 = 9
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r7 = f3382c     // Catch:{ all -> 0x0277 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x0277 }
            java.lang.reflect.Method r7 = (java.lang.reflect.Method) r7     // Catch:{ all -> 0x0277 }
            if (r7 == 0) goto L_0x00fc
            long r11 = r3.toInteger(r9)     // Catch:{ all -> 0x0277 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0277 }
            java.lang.Class[] r12 = r7.getParameterTypes()     // Catch:{ all -> 0x0277 }
            r12 = r12[r8]     // Catch:{ all -> 0x0277 }
            java.lang.Number r11 = com.luajava.LuaState.convertLuaNumber(r11, r12)     // Catch:{ all -> 0x0277 }
            r10[r8] = r11     // Catch:{ all -> 0x0277 }
            goto L_0x00fc
        L_0x00c6:
            r5 = 3
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r7 = f3383d     // Catch:{ all -> 0x0277 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x0277 }
            java.lang.reflect.Method r7 = (java.lang.reflect.Method) r7     // Catch:{ all -> 0x0277 }
            if (r7 == 0) goto L_0x00fc
            double r11 = r3.toNumber(r9)     // Catch:{ all -> 0x0277 }
            java.lang.Double r11 = java.lang.Double.valueOf(r11)     // Catch:{ all -> 0x0277 }
            java.lang.Class[] r12 = r7.getParameterTypes()     // Catch:{ all -> 0x0277 }
            r12 = r12[r8]     // Catch:{ all -> 0x0277 }
            java.lang.Number r11 = com.luajava.LuaState.convertLuaNumber(r11, r12)     // Catch:{ all -> 0x0277 }
            r10[r8] = r11     // Catch:{ all -> 0x0277 }
            goto L_0x00fc
        L_0x00e6:
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r5 = f3384e     // Catch:{ all -> 0x0277 }
            java.lang.Object r5 = r5.get(r2)     // Catch:{ all -> 0x0277 }
            java.lang.reflect.Method r5 = (java.lang.reflect.Method) r5     // Catch:{ all -> 0x0277 }
            if (r5 == 0) goto L_0x00fa
            boolean r7 = r3.toBoolean(r9)     // Catch:{ all -> 0x0277 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x0277 }
            r10[r8] = r7     // Catch:{ all -> 0x0277 }
        L_0x00fa:
            r7 = r5
            r5 = 1
        L_0x00fc:
            if (r7 == 0) goto L_0x0161
            int r2 = r7.getModifiers()     // Catch:{ Exception -> 0x0124 }
            boolean r2 = java.lang.reflect.Modifier.isPublic(r2)     // Catch:{ Exception -> 0x0124 }
            if (r2 != 0) goto L_0x010b
            r7.setAccessible(r9)     // Catch:{ Exception -> 0x0124 }
        L_0x010b:
            java.lang.Object r1 = r7.invoke(r1, r10)     // Catch:{ Exception -> 0x0124 }
            if (r1 != 0) goto L_0x011f
            java.lang.Class r2 = r7.getReturnType()     // Catch:{ all -> 0x0277 }
            java.lang.Class r4 = java.lang.Void.TYPE     // Catch:{ all -> 0x0277 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0277 }
            if (r2 == 0) goto L_0x011f
            monitor-exit(r3)     // Catch:{ all -> 0x0277 }
            return r8
        L_0x011f:
            r3.pushObjectValue(r1)     // Catch:{ all -> 0x0277 }
            monitor-exit(r3)     // Catch:{ all -> 0x0277 }
            return r9
        L_0x0124:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "  at "
            r4.append(r2)     // Catch:{ all -> 0x0277 }
            r4.append(r7)     // Catch:{ all -> 0x0277 }
            java.lang.String r2 = "\n  -> "
            r4.append(r2)     // Catch:{ all -> 0x0277 }
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ all -> 0x0277 }
            if (r2 == 0) goto L_0x013d
            java.lang.Throwable r1 = r1.getCause()     // Catch:{ all -> 0x0277 }
        L_0x013d:
            r4.append(r1)     // Catch:{ all -> 0x0277 }
            java.lang.String r1 = "\n"
            r4.append(r1)     // Catch:{ all -> 0x0277 }
            com.luajava.LuaException r1 = new com.luajava.LuaException     // Catch:{ all -> 0x0277 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0277 }
            r2.<init>()     // Catch:{ all -> 0x0277 }
            java.lang.String r5 = "Invalid method call.\n"
            r2.append(r5)     // Catch:{ all -> 0x0277 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0277 }
            r2.append(r4)     // Catch:{ all -> 0x0277 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0277 }
            r1.<init>(r2)     // Catch:{ all -> 0x0277 }
            throw r1     // Catch:{ all -> 0x0277 }
        L_0x0160:
            r5 = r7
        L_0x0161:
            java.util.HashMap<java.lang.String, java.lang.reflect.Method[]> r7 = methodCache     // Catch:{ all -> 0x0277 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x0277 }
            java.lang.reflect.Method[] r7 = (java.lang.reflect.Method[]) r7     // Catch:{ all -> 0x0277 }
            int[] r11 = new int[r6]     // Catch:{ all -> 0x0277 }
            r12 = 0
        L_0x016c:
            if (r12 >= r6) goto L_0x0178
            int r13 = r12 + 1
            int r14 = r3.type(r13)     // Catch:{ all -> 0x0277 }
            r11[r12] = r14     // Catch:{ all -> 0x0277 }
            r12 = r13
            goto L_0x016c
        L_0x0178:
            int r12 = r7.length     // Catch:{ all -> 0x0277 }
            r13 = 0
        L_0x017a:
            if (r13 >= r12) goto L_0x0226
            r14 = r7[r13]     // Catch:{ all -> 0x0277 }
            java.lang.Class[] r15 = r14.getParameterTypes()     // Catch:{ all -> 0x0277 }
            int r8 = r15.length     // Catch:{ all -> 0x0277 }
            if (r8 == r6) goto L_0x018d
            r16 = r6
            r17 = r11
        L_0x0189:
            r6 = 0
            r8 = 1
            goto L_0x021c
        L_0x018d:
            r8 = 0
        L_0x018e:
            int r9 = r15.length     // Catch:{ all -> 0x0277 }
            if (r8 >= r9) goto L_0x01ad
            r9 = r15[r8]     // Catch:{ Exception -> 0x01a7 }
            r16 = r6
            r6 = r11[r8]     // Catch:{ Exception -> 0x01a9 }
            r17 = r11
            int r11 = r8 + 1
            java.lang.Object r6 = m3265a(r3, r9, r6, r11)     // Catch:{ Exception -> 0x01ab }
            r10[r8] = r6     // Catch:{ Exception -> 0x01ab }
            r8 = r11
            r6 = r16
            r11 = r17
            goto L_0x018e
        L_0x01a7:
            r16 = r6
        L_0x01a9:
            r17 = r11
        L_0x01ab:
            r6 = 0
            goto L_0x01b2
        L_0x01ad:
            r16 = r6
            r17 = r11
            r6 = 1
        L_0x01b2:
            if (r6 == 0) goto L_0x0189
            int r6 = r14.getModifiers()     // Catch:{ Exception -> 0x01f9 }
            boolean r6 = java.lang.reflect.Modifier.isPublic(r6)     // Catch:{ Exception -> 0x01f9 }
            if (r6 != 0) goto L_0x01c8
            r6 = 1
            r14.setAccessible(r6)     // Catch:{ Exception -> 0x01c3 }
            goto L_0x01c8
        L_0x01c3:
            r0 = move-exception
            r9 = r0
            r6 = 0
            r8 = 1
            goto L_0x01fd
        L_0x01c8:
            java.lang.Object r6 = r14.invoke(r1, r10)     // Catch:{ Exception -> 0x01f9 }
            switch(r5) {
                case 0: goto L_0x01df;
                case 1: goto L_0x01dc;
                case 3: goto L_0x01d9;
                case 4: goto L_0x01d6;
                case 9: goto L_0x01d0;
                default: goto L_0x01cf;
            }
        L_0x01cf:
            goto L_0x01e2
        L_0x01d0:
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r1 = f3382c     // Catch:{ all -> 0x0277 }
        L_0x01d2:
            r1.put(r2, r14)     // Catch:{ all -> 0x0277 }
            goto L_0x01e2
        L_0x01d6:
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r1 = f3381b     // Catch:{ all -> 0x0277 }
            goto L_0x01d2
        L_0x01d9:
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r1 = f3383d     // Catch:{ all -> 0x0277 }
            goto L_0x01d2
        L_0x01dc:
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r1 = f3384e     // Catch:{ all -> 0x0277 }
            goto L_0x01d2
        L_0x01df:
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r1 = f3385f     // Catch:{ all -> 0x0277 }
            goto L_0x01d2
        L_0x01e2:
            if (r6 != 0) goto L_0x01f3
            java.lang.Class r1 = r14.getReturnType()     // Catch:{ all -> 0x0277 }
            java.lang.Class r2 = java.lang.Void.TYPE     // Catch:{ all -> 0x0277 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0277 }
            if (r1 == 0) goto L_0x01f3
            monitor-exit(r3)     // Catch:{ all -> 0x0277 }
            r6 = 0
            return r6
        L_0x01f3:
            r3.pushObjectValue(r6)     // Catch:{ all -> 0x0277 }
            monitor-exit(r3)     // Catch:{ all -> 0x0277 }
            r8 = 1
            return r8
        L_0x01f9:
            r0 = move-exception
            r6 = 0
            r8 = 1
            r9 = r0
        L_0x01fd:
            java.lang.String r11 = "  at "
            r4.append(r11)     // Catch:{ all -> 0x0277 }
            r4.append(r14)     // Catch:{ all -> 0x0277 }
            java.lang.String r11 = "\n  -> "
            r4.append(r11)     // Catch:{ all -> 0x0277 }
            java.lang.Throwable r11 = r9.getCause()     // Catch:{ all -> 0x0277 }
            if (r11 == 0) goto L_0x0214
            java.lang.Throwable r9 = r9.getCause()     // Catch:{ all -> 0x0277 }
        L_0x0214:
            r4.append(r9)     // Catch:{ all -> 0x0277 }
            java.lang.String r9 = "\n"
            r4.append(r9)     // Catch:{ all -> 0x0277 }
        L_0x021c:
            int r13 = r13 + 1
            r6 = r16
            r11 = r17
            r8 = 0
            r9 = 1
            goto L_0x017a
        L_0x0226:
            r6 = 0
            int r1 = r4.length()     // Catch:{ all -> 0x0277 }
            if (r1 <= 0) goto L_0x0248
            com.luajava.LuaException r1 = new com.luajava.LuaException     // Catch:{ all -> 0x0277 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0277 }
            r2.<init>()     // Catch:{ all -> 0x0277 }
            java.lang.String r5 = "Invalid method call.\n"
            r2.append(r5)     // Catch:{ all -> 0x0277 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0277 }
            r2.append(r4)     // Catch:{ all -> 0x0277 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0277 }
            r1.<init>(r2)     // Catch:{ all -> 0x0277 }
            throw r1     // Catch:{ all -> 0x0277 }
        L_0x0248:
            int r1 = r7.length     // Catch:{ all -> 0x0277 }
        L_0x0249:
            if (r6 >= r1) goto L_0x025c
            r2 = r7[r6]     // Catch:{ all -> 0x0277 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0277 }
            r4.append(r2)     // Catch:{ all -> 0x0277 }
            java.lang.String r2 = "\n"
            r4.append(r2)     // Catch:{ all -> 0x0277 }
            int r6 = r6 + 1
            goto L_0x0249
        L_0x025c:
            com.luajava.LuaException r1 = new com.luajava.LuaException     // Catch:{ all -> 0x0277 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0277 }
            r2.<init>()     // Catch:{ all -> 0x0277 }
            java.lang.String r5 = "Invalid method call. Invalid Parameters.\n"
            r2.append(r5)     // Catch:{ all -> 0x0277 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0277 }
            r2.append(r4)     // Catch:{ all -> 0x0277 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0277 }
            r1.<init>(r2)     // Catch:{ all -> 0x0277 }
            throw r1     // Catch:{ all -> 0x0277 }
        L_0x0277:
            r0 = move-exception
            r1 = r0
            monitor-exit(r3)     // Catch:{ all -> 0x0277 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaJavaAPI.callMethod(long, java.lang.Object, java.lang.String):int");
    }

    public static int checkClass(LuaState luaState, Object obj, String str) {
        Class[] classes;
        synchronized (luaState) {
            if (!(obj instanceof Class)) {
                return 0;
            }
            for (Class cls : ((Class) obj).getClasses()) {
                if (cls.getSimpleName().equals(str)) {
                    luaState.pushJavaObject(cls);
                    return 3;
                }
            }
            return 0;
        }
    }

    public static int checkField(LuaState luaState, Object obj, String str) {
        boolean z;
        Class cls;
        synchronized (luaState) {
            if (obj instanceof Class) {
                cls = (Class) obj;
                z = true;
            } else {
                cls = obj.getClass();
                z = false;
            }
            try {
                Field field = cls.getField(str);
                if (field == null) {
                    return 0;
                }
                if (z && !Modifier.isStatic(field.getModifiers())) {
                    return 0;
                }
                try {
                    if (!Modifier.isPublic(field.getModifiers())) {
                        field.setAccessible(true);
                    }
                    luaState.pushObjectValue(field.get(obj));
                    return Modifier.isFinal(field.getModifiers()) ? 5 : 1;
                } catch (Exception e) {
                    throw new LuaException(e);
                }
            } catch (NoSuchFieldException unused) {
                return 0;
            }
        }
    }

    public static int checkMethod(LuaState luaState, Object obj, String str) {
        Class cls;
        boolean z;
        synchronized (luaState) {
            if (obj instanceof Class) {
                cls = (Class) obj;
                z = true;
            } else {
                cls = obj.getClass();
                z = false;
            }
            String luaState2 = luaState.toString(-1);
            Method[] methodArr = (Method[]) methodCache.get(luaState2);
            if (methodArr == null) {
                ArrayList method = getMethod(cls, str, z);
                methodArr = new Method[method.size()];
                method.toArray(methodArr);
                methodCache.put(luaState2, methodArr);
            }
            return methodArr.length == 0 ? 0 : 2;
        }
    }

    public static void clearCaches() {
        methodCache.clear();
        methodsMap.clear();
        f3381b.clear();
        f3382c.clear();
        f3383d.clear();
        f3384e.clear();
        f3385f.clear();
    }

    public static int createArray(long j, String str) {
        int d;
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            d = m3274d(existingState, javaBindClass(str));
        }
        return d;
    }

    public static int createProxy(long j, String str) {
        int a;
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            a = m3263a(existingState, str);
        }
        return a;
    }

    /* renamed from: d */
    private static int m3274d(LuaState luaState, Class<?> cls) {
        synchronized (luaState) {
            luaState.pushJavaObject(m3271b(luaState, cls, 2));
        }
        return 1;
    }

    /* renamed from: d */
    private static Object m3275d(LuaState luaState, Class<Map<Object, Object>> cls, int i) {
        Map hashMap;
        synchronized (luaState) {
            try {
                hashMap = cls.equals(Map.class) ? new HashMap() : (Map) cls.newInstance();
                luaState.pushNil();
                while (luaState.next(i) != 0) {
                    hashMap.put(luaState.toJavaObject(-2), luaState.toJavaObject(-1));
                    luaState.pop(1);
                }
            } catch (Exception e) {
                throw new LuaException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return hashMap;
    }

    /* renamed from: e */
    private static int m3276e(LuaState luaState, Class<?> cls) {
        synchronized (luaState) {
            luaState.pushJavaObject(m3273c(luaState, cls, 2));
        }
        return 1;
    }

    /* renamed from: e */
    private static Object m3277e(LuaState luaState, Class<?> cls, int i) {
        return m3265a(luaState, cls, luaState.type(i), i);
    }

    /* renamed from: f */
    private static int m3278f(LuaState luaState, Class<?> cls) {
        synchronized (luaState) {
            luaState.pushJavaObject(m3275d(luaState, cls, 2));
        }
        return 1;
    }

    /* renamed from: f */
    private static int m3279f(LuaState luaState, Class cls, int i) {
        Object obj;
        char c;
        if (cls == Character.TYPE && luaState.type(i) == 4) {
            String luaState2 = luaState.toString(i);
            if (luaState2.length() == 1) {
                c = luaState2.charAt(0);
            } else {
                obj = luaState2.toCharArray();
                luaState.pushJavaObject(obj);
                return 1;
            }
        } else if (!luaState.isNumber(i)) {
            StringBuilder sb = new StringBuilder();
            sb.append(luaState.toString(i));
            sb.append(" is not number");
            throw new LuaException(sb.toString());
        } else {
            if (cls == Double.TYPE) {
                obj = Double.valueOf(luaState.toNumber(i));
            } else if (cls == Float.TYPE) {
                obj = Float.valueOf((float) luaState.toNumber(i));
            } else if (cls == Long.TYPE) {
                obj = Long.valueOf(luaState.toInteger(i));
            } else if (cls == Integer.TYPE) {
                obj = Integer.valueOf((int) luaState.toInteger(i));
            } else if (cls == Short.TYPE) {
                obj = Short.valueOf((short) ((int) luaState.toInteger(i)));
            } else if (cls == Character.TYPE) {
                c = (char) ((int) luaState.toInteger(i));
            } else {
                obj = cls == Byte.TYPE ? Byte.valueOf((byte) ((int) luaState.toInteger(i))) : cls == Boolean.TYPE ? Boolean.valueOf(luaState.toBoolean(i)) : null;
            }
            luaState.pushJavaObject(obj);
            return 1;
        }
        obj = Character.valueOf(c);
        luaState.pushJavaObject(obj);
        return 1;
    }

    public static int getArrayValue(long j, Object obj, int i) {
        Object obj2;
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            if (obj.getClass().isArray()) {
                obj2 = Array.get(obj, i);
            } else if (obj instanceof List) {
                obj2 = ((List) obj).get(i);
            } else if (obj instanceof Map) {
                obj2 = ((Map) obj).get(Long.valueOf((long) i));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("can not get ");
                sb.append(obj.getClass().getName());
                sb.append(" value in ");
                sb.append(i);
                throw new LuaException(sb.toString());
            }
            existingState.pushObjectValue(obj2);
        }
        return 1;
    }

    public static int getContext(long j) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            existingState.pushJavaObject(existingState.getContext());
        }
        return 1;
    }

    public static ArrayList<Method> getMethod(Class<?> cls, String str, boolean z) {
        HashMap hashMap = (HashMap) f3380a.get(cls);
        if (hashMap == null) {
            hashMap = new HashMap();
            f3380a.put(cls, hashMap);
        }
        ArrayList<Method> arrayList = (ArrayList) hashMap.get(str);
        if (arrayList == null) {
            Method[] methodArr = (Method[]) methodsMap.get(cls);
            if (methodArr == null) {
                methodArr = cls.getMethods();
                methodsMap.put(cls, methodArr);
            }
            for (Method method : methodArr) {
                String name = method.getName();
                ArrayList arrayList2 = (ArrayList) hashMap.get(name);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    hashMap.put(name, arrayList2);
                }
                arrayList2.add(method);
            }
            arrayList = (ArrayList) hashMap.get(str);
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (!z) {
            return arrayList;
        }
        ArrayList<Method> arrayList3 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Method method2 = (Method) it.next();
            if (Modifier.isStatic(method2.getModifiers())) {
                arrayList3.add(method2);
            }
        }
        if (arrayList3.isEmpty()) {
            arrayList3 = getMethod(Class.class, str, false);
        }
        return arrayList3;
    }

    public static Class javaBindClass(String str) {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1325958191:
                    if (str.equals("double")) {
                        c = 7;
                        break;
                    }
                    break;
                case 104431:
                    if (str.equals("int")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3039496:
                    if (str.equals("byte")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3052374:
                    if (str.equals("char")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3327612:
                    if (str.equals("long")) {
                        c = 5;
                        break;
                    }
                    break;
                case 64711720:
                    if (str.equals("boolean")) {
                        c = 0;
                        break;
                    }
                    break;
                case 97526364:
                    if (str.equals("float")) {
                        c = 6;
                        break;
                    }
                    break;
                case 109413500:
                    if (str.equals("short")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return Boolean.TYPE;
                case 1:
                    return Byte.TYPE;
                case 2:
                    return Character.TYPE;
                case 3:
                    return Short.TYPE;
                case 4:
                    return Integer.TYPE;
                case 5:
                    return Long.TYPE;
                case 6:
                    return Float.TYPE;
                case 7:
                    return Double.TYPE;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Class not found: ");
                    sb.append(str);
                    throw new LuaException(sb.toString());
            }
        }
    }

    public static int javaCreate(long j, Class<?> cls) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            if (!cls.isPrimitive()) {
                if (cls != String.class) {
                    if (cls.isArray()) {
                        int d = m3274d(existingState, cls);
                        return d;
                    } else if (List.class.isAssignableFrom(cls)) {
                        int e = m3276e(existingState, cls);
                        return e;
                    } else if (Map.class.isAssignableFrom(cls)) {
                        int f = m3278f(existingState, cls);
                        return f;
                    } else if (cls.isInterface()) {
                        int c = m3272c(existingState, cls);
                        return c;
                    } else if ((cls.getModifiers() & 1024) != 0) {
                        int a = m3259a(existingState, cls);
                        return a;
                    } else if (existingState.objLen(-1) == 0) {
                        int d2 = m3274d(existingState, cls);
                        return d2;
                    } else {
                        existingState.getI(-1, 1);
                        Object javaObject = existingState.toJavaObject(-1);
                        existingState.pop(1);
                        if (cls.isAssignableFrom(javaObject.getClass())) {
                            int d3 = m3274d(existingState, cls);
                            return d3;
                        }
                        int b = m3269b(existingState, cls);
                        return b;
                    }
                }
            }
            int d4 = m3274d(existingState, cls);
            return d4;
        }
    }

    public static int javaEquals(long j, Object obj, Object obj2) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            existingState.pushBoolean(obj.equals(obj2));
        }
        return 1;
    }

    public static void javaGc(Object obj) {
        Bitmap bitmap;
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(BuildConfig.FLAVOR);
        Log.i("javaGc: ", sb.toString());
        if (obj != null) {
            try {
                if (obj instanceof LuaGcable) {
                    ((LuaGcable) obj).mo2151gc();
                    return;
                }
                if (obj instanceof Bitmap) {
                    LuaBitmap.removeBitmap((Bitmap) obj);
                    bitmap = (Bitmap) obj;
                } else if (obj instanceof BitmapDrawable) {
                    bitmap = ((BitmapDrawable) obj).getBitmap();
                } else {
                    if (obj instanceof AutoCloseable) {
                        ((AutoCloseable) obj).close();
                        return;
                    }
                    return;
                }
                bitmap.recycle();
            } catch (Exception e) {
                C0029a.m806a(e);
            }
        }
    }

    public static int javaGetType(long j, Object obj) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            try {
                existingState.pushString(obj == null ? "null" : obj.getClass().getName());
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:21|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append("is");
        r0.append(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0095, code lost:
        r0 = r1.getMethod(r0.toString(), new java.lang.Class[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ab, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c2, code lost:
        return 1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int javaGetter(com.luajava.LuaState r7, java.lang.Object r8, java.lang.String r9) {
        /*
            monitor-enter(r7)
            r0 = 0
            boolean r1 = r8 instanceof java.util.Map     // Catch:{ all -> 0x00ca }
            r2 = 1
            if (r1 == 0) goto L_0x0012
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ all -> 0x00ca }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ all -> 0x00ca }
            r7.pushObjectValue(r8)     // Catch:{ all -> 0x00ca }
            monitor-exit(r7)     // Catch:{ all -> 0x00ca }
            return r2
        L_0x0012:
            boolean r1 = r8 instanceof java.lang.Class     // Catch:{ all -> 0x00ca }
            r3 = 0
            if (r1 == 0) goto L_0x001c
            r1 = r8
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x00ca }
            r4 = 1
            goto L_0x0021
        L_0x001c:
            java.lang.Class r1 = r8.getClass()     // Catch:{ all -> 0x00ca }
            r4 = 0
        L_0x0021:
            char r5 = r9.charAt(r3)     // Catch:{ all -> 0x00ca }
            boolean r6 = java.lang.Character.isLowerCase(r5)     // Catch:{ all -> 0x00ca }
            if (r6 == 0) goto L_0x0042
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            r6.<init>()     // Catch:{ all -> 0x00ca }
            char r5 = java.lang.Character.toUpperCase(r5)     // Catch:{ all -> 0x00ca }
            r6.append(r5)     // Catch:{ all -> 0x00ca }
            java.lang.String r9 = r9.substring(r2)     // Catch:{ all -> 0x00ca }
            r6.append(r9)     // Catch:{ all -> 0x00ca }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x00ca }
        L_0x0042:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            r5.<init>()     // Catch:{ all -> 0x00ca }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x00ca }
            r5.append(r6)     // Catch:{ all -> 0x00ca }
            java.lang.String r6 = "@<-"
            r5.append(r6)     // Catch:{ all -> 0x00ca }
            r5.append(r9)     // Catch:{ all -> 0x00ca }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00ca }
            if (r4 != 0) goto L_0x0064
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r0 = f3385f     // Catch:{ all -> 0x00ca }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x00ca }
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch:{ all -> 0x00ca }
        L_0x0064:
            if (r0 != 0) goto L_0x00ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NoSuchMethodException -> 0x007e }
            r0.<init>()     // Catch:{ NoSuchMethodException -> 0x007e }
            java.lang.String r6 = "get"
            r0.append(r6)     // Catch:{ NoSuchMethodException -> 0x007e }
            r0.append(r9)     // Catch:{ NoSuchMethodException -> 0x007e }
            java.lang.String r0 = r0.toString()     // Catch:{ NoSuchMethodException -> 0x007e }
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x007e }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r6)     // Catch:{ NoSuchMethodException -> 0x007e }
            goto L_0x0096
        L_0x007e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NoSuchMethodException -> 0x00aa }
            r0.<init>()     // Catch:{ NoSuchMethodException -> 0x00aa }
            java.lang.String r6 = "is"
            r0.append(r6)     // Catch:{ NoSuchMethodException -> 0x00aa }
            r0.append(r9)     // Catch:{ NoSuchMethodException -> 0x00aa }
            java.lang.String r9 = r0.toString()     // Catch:{ NoSuchMethodException -> 0x00aa }
            java.lang.Class[] r0 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x00aa }
            java.lang.reflect.Method r9 = r1.getMethod(r9, r0)     // Catch:{ NoSuchMethodException -> 0x00aa }
            r0 = r9
        L_0x0096:
            if (r4 == 0) goto L_0x00a4
            int r9 = r0.getModifiers()     // Catch:{ all -> 0x00ca }
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)     // Catch:{ all -> 0x00ca }
            if (r9 != 0) goto L_0x00a4
            monitor-exit(r7)     // Catch:{ all -> 0x00ca }
            return r3
        L_0x00a4:
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r9 = f3385f     // Catch:{ all -> 0x00ca }
            r9.put(r5, r0)     // Catch:{ all -> 0x00ca }
            goto L_0x00ac
        L_0x00aa:
            monitor-exit(r7)     // Catch:{ all -> 0x00ca }
            return r3
        L_0x00ac:
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00c3 }
            java.lang.Object r8 = r0.invoke(r8, r9)     // Catch:{ Exception -> 0x00c3 }
            boolean r9 = r8 instanceof java.lang.CharSequence     // Catch:{ all -> 0x00ca }
            if (r9 == 0) goto L_0x00be
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00ca }
            r7.pushString(r8)     // Catch:{ all -> 0x00ca }
            goto L_0x00c1
        L_0x00be:
            r7.pushObjectValue(r8)     // Catch:{ all -> 0x00ca }
        L_0x00c1:
            monitor-exit(r7)     // Catch:{ all -> 0x00ca }
            return r2
        L_0x00c3:
            r8 = move-exception
            com.luajava.LuaException r9 = new com.luajava.LuaException     // Catch:{ all -> 0x00ca }
            r9.<init>(r8)     // Catch:{ all -> 0x00ca }
            throw r9     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00ca }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaJavaAPI.javaGetter(com.luajava.LuaState, java.lang.Object, java.lang.String):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int javaLoadLib(long r3, java.lang.String r5, java.lang.String r6) {
        /*
            com.luajava.LuaState r3 = com.luajava.LuaStateFactory.getExistingState(r3)
            monitor-enter(r3)
            java.lang.Class r4 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x004c }
            r5 = 1
            java.lang.Class[] r0 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x002e }
            java.lang.Class<com.luajava.LuaState> r1 = com.luajava.LuaState.class
            r2 = 0
            r0[r2] = r1     // Catch:{ Exception -> 0x002e }
            java.lang.reflect.Method r4 = r4.getMethod(r6, r0)     // Catch:{ Exception -> 0x002e }
            r6 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x002e }
            r5[r2] = r3     // Catch:{ Exception -> 0x002e }
            java.lang.Object r4 = r4.invoke(r6, r5)     // Catch:{ Exception -> 0x002e }
            if (r4 == 0) goto L_0x002c
            boolean r5 = r4 instanceof java.lang.Integer     // Catch:{ Exception -> 0x002e }
            if (r5 == 0) goto L_0x002c
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x002e }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x002e }
            monitor-exit(r3)     // Catch:{ all -> 0x004a }
            return r4
        L_0x002c:
            monitor-exit(r3)     // Catch:{ all -> 0x004a }
            return r2
        L_0x002e:
            r4 = move-exception
            com.luajava.LuaException r5 = new com.luajava.LuaException     // Catch:{ all -> 0x004a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r6.<init>()     // Catch:{ all -> 0x004a }
            java.lang.String r0 = "Error on calling method. Library could not be loaded. "
            r6.append(r0)     // Catch:{ all -> 0x004a }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x004a }
            r6.append(r4)     // Catch:{ all -> 0x004a }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x004a }
            r5.<init>(r4)     // Catch:{ all -> 0x004a }
            throw r5     // Catch:{ all -> 0x004a }
        L_0x004a:
            r4 = move-exception
            goto L_0x0053
        L_0x004c:
            r4 = move-exception
            com.luajava.LuaException r5 = new com.luajava.LuaException     // Catch:{ all -> 0x004a }
            r5.<init>(r4)     // Catch:{ all -> 0x004a }
            throw r5     // Catch:{ all -> 0x004a }
        L_0x0053:
            monitor-exit(r3)     // Catch:{ all -> 0x004a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaJavaAPI.javaLoadLib(long, java.lang.String, java.lang.String):int");
    }

    public static int javaNew(long j, Class<?> cls) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            if (cls.isPrimitive()) {
                int top = existingState.getTop();
                for (int i = 2; i <= top; i++) {
                    m3279f(existingState, cls, i);
                }
                int i2 = top - 1;
                return i2;
            } else if ((cls.getModifiers() & 1024) != 0) {
                if (!existingState.isTable(2)) {
                    m3268a(existingState, "javaOverride", 1, "table");
                }
                int javaOverride = javaOverride(j, cls);
                return javaOverride;
            } else {
                int b = m3269b(existingState, cls);
                return b;
            }
        }
    }

    public static int javaNewInstance(long j, String str) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            Class javaBindClass = javaBindClass(str);
            if (javaBindClass.isPrimitive()) {
                int f = m3279f(existingState, javaBindClass, -1);
                return f;
            }
            int b = m3269b(existingState, javaBindClass);
            return b;
        }
    }

    public static int javaObjectLength(long j, Object obj) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            try {
                int i = obj instanceof CharSequence ? ((CharSequence) obj).length() : obj instanceof Collection ? ((Collection) obj).size() : obj instanceof Map ? ((Map) obj).size() : Array.getLength(obj);
                existingState.pushInteger((long) i);
            } catch (Exception e) {
                throw new LuaException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    public static int javaOverride(long j, Class<?> cls) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            final LuaTable luaTable = new LuaTable(existingState, 2);
            existingState.remove(2);
            if (m3269b(existingState, new LuaEnhancer(cls).create(new MethodFilter() {
                public boolean filter(Method method, String str) {
                    return luaTable.containsKey(str);
                }
            })) == 0) {
                return 0;
            }
            EnhancerInterface enhancerInterface = (EnhancerInterface) existingState.toJavaObject(-1);
            enhancerInterface.setMethodInterceptor_Enhancer(new LuaMethodInterceptor(luaTable));
            existingState.pushJavaObject(enhancerInterface);
            return 1;
        }
    }

    public static int javaSetter(LuaState luaState, Object obj, String str) {
        synchronized (luaState) {
            boolean z = true;
            if (obj instanceof Map) {
                ((Map) obj).put(str, luaState.toJavaObject(-1));
                return 1;
            }
            if (obj instanceof Class) {
                Class cls = (Class) obj;
            } else {
                obj.getClass();
                z = false;
            }
            if (str.length() <= 2 || !str.substring(0, 2).equals("on") || luaState.type(-1) != 6) {
                int b = m3270b(luaState, obj, str, z);
                if (b != 0) {
                    return b;
                }
                int a = m3261a(luaState, obj, str);
                return a;
            }
            int a2 = m3262a(luaState, obj, str, z);
            return a2;
        }
    }

    public static int javaSetter(LuaState luaState, Object obj, String str, Object obj2) {
        luaState.pushObjectValue(obj2);
        int javaSetter = javaSetter(luaState, obj, str);
        luaState.pop(1);
        return javaSetter;
    }

    public static int javaToString(long j, Object obj) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            try {
                existingState.pushString(obj == null ? "null" : obj.toString());
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    public static int newArray(long j, Class<?> cls) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            try {
                int top = existingState.getTop() - 1;
                int[] iArr = new int[top];
                for (int i = 0; i < top; i++) {
                    iArr[i] = (int) existingState.toInteger(i + 2);
                }
                existingState.pushJavaObject(Array.newInstance(cls, iArr));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("can not create a array: ");
                sb.append(e.getMessage());
                throw new LuaException(sb.toString());
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    public static int newArray(long j, Class<?> cls, int i) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            try {
                existingState.pushJavaObject(Array.newInstance(cls, i));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("can not create a array: ");
                sb.append(e.getMessage());
                throw new LuaException(sb.toString());
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }

    public static int objectCall(long j, Object obj) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            if (obj instanceof LuaMetaTable) {
                int top = existingState.getTop();
                Object[] objArr = new Object[(top - 1)];
                for (int i = 2; i <= top; i++) {
                    objArr[i - 2] = existingState.toJavaObject(i);
                }
                existingState.pushObjectValue(((LuaMetaTable) obj).__call(objArr));
                return 1;
            } else if (!existingState.isTable(2)) {
                return 0;
            } else {
                if (!obj.getClass().isArray() || Array.getLength(obj) != 0) {
                    existingState.pushNil();
                    if (obj instanceof List) {
                        List list = (List) obj;
                        while (existingState.next(2) != 0) {
                            list.add(existingState.toJavaObject(-1));
                            existingState.pop(1);
                        }
                    } else {
                        while (existingState.next(2) != 0) {
                            if (existingState.isNumber(-2)) {
                                setArrayValue(existingState, obj, (int) existingState.toInteger(-2));
                            } else {
                                javaSetter(existingState, obj, existingState.toString(-2));
                            }
                            existingState.pop(1);
                        }
                    }
                    existingState.setTop(1);
                    return 1;
                }
                int d = m3274d(existingState, obj.getClass());
                return d;
            }
        }
    }

    public static int objectIndex(long j, Object obj, String str, int i) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            if (i == 0) {
                try {
                    if (checkMethod(existingState, obj, str) != 0) {
                        return 2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (i == 0 || i == 1 || i == 5) {
                int checkField = checkField(existingState, obj, str);
                if (checkField != 0) {
                    return checkField;
                }
            }
            if ((i == 0 || i == 4) && javaGetter(existingState, obj, str) != 0) {
                return 4;
            }
            if ((i == 0 || i == 3) && checkClass(existingState, obj, str) != 0) {
                return 3;
            }
            if ((i != 0 && i != 6) || !(obj instanceof LuaMetaTable)) {
                return 0;
            }
            existingState.pushObjectValue(((LuaMetaTable) obj).__index(str));
            return 6;
        }
    }

    public static int objectNewIndex(long j, Object obj, String str, int i) {
        LuaState existingState = LuaStateFactory.getExistingState(j);
        synchronized (existingState) {
            if (i == 0 || i == 1) {
                if (setFieldValue(existingState, obj, str) != 0) {
                    return 1;
                }
            }
            if ((i == 0 || i == 2) && javaSetter(existingState, obj, str) != 0) {
                return 2;
            }
            if ((i != 0 && i != 3) || !(obj instanceof LuaMetaTable)) {
                return 0;
            }
            ((LuaMetaTable) obj).__newIndex(str, existingState.toJavaObject(-1));
            return 3;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int setArrayValue(long r3, java.lang.Object r5, int r6) {
        /*
            com.luajava.LuaState r3 = com.luajava.LuaStateFactory.getExistingState(r3)
            monitor-enter(r3)
            java.lang.Class r4 = r5.getClass()     // Catch:{ all -> 0x009b }
            boolean r4 = r4.isArray()     // Catch:{ all -> 0x009b }
            r0 = 3
            if (r4 == 0) goto L_0x0045
            java.lang.Class r4 = r5.getClass()     // Catch:{ all -> 0x009b }
            java.lang.Class r4 = r4.getComponentType()     // Catch:{ all -> 0x009b }
            java.lang.Object r1 = m3277e(r3, r4, r0)     // Catch:{ LuaException -> 0x0020 }
            java.lang.reflect.Array.set(r5, r6, r1)     // Catch:{ LuaException -> 0x0020 }
            goto L_0x0065
        L_0x0020:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r1.<init>()     // Catch:{ all -> 0x009b }
            java.lang.Class r5 = r5.getClass()     // Catch:{ all -> 0x009b }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x009b }
            r1.append(r5)     // Catch:{ all -> 0x009b }
            java.lang.String r5 = " ["
            r1.append(r5)     // Catch:{ all -> 0x009b }
            r1.append(r6)     // Catch:{ all -> 0x009b }
            java.lang.String r5 = "]"
            r1.append(r5)     // Catch:{ all -> 0x009b }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x009b }
            m3267a(r3, r5, r0, r4)     // Catch:{ all -> 0x009b }
            goto L_0x0065
        L_0x0045:
            boolean r4 = r5 instanceof java.util.List     // Catch:{ all -> 0x009b }
            if (r4 == 0) goto L_0x0053
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x009b }
            java.lang.Object r4 = r3.toJavaObject(r0)     // Catch:{ all -> 0x009b }
            r5.set(r6, r4)     // Catch:{ all -> 0x009b }
            goto L_0x0065
        L_0x0053:
            boolean r4 = r5 instanceof java.util.Map     // Catch:{ all -> 0x009b }
            if (r4 == 0) goto L_0x0068
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x009b }
            long r1 = (long) r6     // Catch:{ all -> 0x009b }
            java.lang.Long r4 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x009b }
            java.lang.Object r6 = r3.toJavaObject(r0)     // Catch:{ all -> 0x009b }
            r5.put(r4, r6)     // Catch:{ all -> 0x009b }
        L_0x0065:
            r4 = 0
            monitor-exit(r3)     // Catch:{ all -> 0x009b }
            return r4
        L_0x0068:
            com.luajava.LuaException r4 = new com.luajava.LuaException     // Catch:{ all -> 0x009b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r1.<init>()     // Catch:{ all -> 0x009b }
            java.lang.String r2 = "can not set "
            r1.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.Class r5 = r5.getClass()     // Catch:{ all -> 0x009b }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x009b }
            r1.append(r5)     // Catch:{ all -> 0x009b }
            java.lang.String r5 = " value: "
            r1.append(r5)     // Catch:{ all -> 0x009b }
            java.lang.Object r5 = r3.toJavaObject(r0)     // Catch:{ all -> 0x009b }
            r1.append(r5)     // Catch:{ all -> 0x009b }
            java.lang.String r5 = " in "
            r1.append(r5)     // Catch:{ all -> 0x009b }
            r1.append(r6)     // Catch:{ all -> 0x009b }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x009b }
            r4.<init>(r5)     // Catch:{ all -> 0x009b }
            throw r4     // Catch:{ all -> 0x009b }
        L_0x009b:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x009b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaJavaAPI.setArrayValue(long, java.lang.Object, int):int");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:4|5|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int setArrayValue(com.luajava.LuaState r4, java.lang.Object r5, int r6) {
        /*
            monitor-enter(r4)
            java.lang.Class r0 = r5.getClass()     // Catch:{ all -> 0x0098 }
            boolean r0 = r0.isArray()     // Catch:{ all -> 0x0098 }
            r1 = -1
            if (r0 == 0) goto L_0x0042
            java.lang.Class r0 = r5.getClass()     // Catch:{ all -> 0x0098 }
            java.lang.Class r0 = r0.getComponentType()     // Catch:{ all -> 0x0098 }
            java.lang.Object r1 = m3277e(r4, r0, r1)     // Catch:{ LuaException -> 0x001c }
            java.lang.reflect.Array.set(r5, r6, r1)     // Catch:{ LuaException -> 0x001c }
            goto L_0x0062
        L_0x001c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r1.<init>()     // Catch:{ all -> 0x0098 }
            java.lang.Class r5 = r5.getClass()     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0098 }
            r1.append(r5)     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = " ["
            r1.append(r5)     // Catch:{ all -> 0x0098 }
            r1.append(r6)     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = "]"
            r1.append(r5)     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0098 }
            r6 = 3
            m3267a(r4, r5, r6, r0)     // Catch:{ all -> 0x0098 }
            goto L_0x0062
        L_0x0042:
            boolean r0 = r5 instanceof java.util.List     // Catch:{ all -> 0x0098 }
            if (r0 == 0) goto L_0x0050
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x0098 }
            java.lang.Object r0 = r4.toJavaObject(r1)     // Catch:{ all -> 0x0098 }
            r5.set(r6, r0)     // Catch:{ all -> 0x0098 }
            goto L_0x0062
        L_0x0050:
            boolean r0 = r5 instanceof java.util.Map     // Catch:{ all -> 0x0098 }
            if (r0 == 0) goto L_0x0065
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x0098 }
            long r2 = (long) r6     // Catch:{ all -> 0x0098 }
            java.lang.Long r6 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0098 }
            java.lang.Object r0 = r4.toJavaObject(r1)     // Catch:{ all -> 0x0098 }
            r5.put(r6, r0)     // Catch:{ all -> 0x0098 }
        L_0x0062:
            r5 = 0
            monitor-exit(r4)     // Catch:{ all -> 0x0098 }
            return r5
        L_0x0065:
            com.luajava.LuaException r0 = new com.luajava.LuaException     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r2.<init>()     // Catch:{ all -> 0x0098 }
            java.lang.String r3 = "can not set "
            r2.append(r3)     // Catch:{ all -> 0x0098 }
            java.lang.Class r5 = r5.getClass()     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0098 }
            r2.append(r5)     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = " value: "
            r2.append(r5)     // Catch:{ all -> 0x0098 }
            java.lang.Object r5 = r4.toJavaObject(r1)     // Catch:{ all -> 0x0098 }
            r2.append(r5)     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = " in "
            r2.append(r5)     // Catch:{ all -> 0x0098 }
            r2.append(r6)     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0098 }
            r0.<init>(r5)     // Catch:{ all -> 0x0098 }
            throw r0     // Catch:{ all -> 0x0098 }
        L_0x0098:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0098 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaJavaAPI.setArrayValue(com.luajava.LuaState, java.lang.Object, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0050, code lost:
        throw new com.luajava.LuaException(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0051, code lost:
        m3267a(r4, r6, -1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005a, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0006, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:3:0x0004, B:25:0x0031] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int setFieldValue(com.luajava.LuaState r4, java.lang.Object r5, java.lang.String r6) {
        /*
            monitor-enter(r4)
            r0 = 0
            if (r5 != 0) goto L_0x0008
            monitor-exit(r4)     // Catch:{ all -> 0x0006 }
            return r0
        L_0x0006:
            r5 = move-exception
            goto L_0x0059
        L_0x0008:
            boolean r1 = r5 instanceof java.lang.Class     // Catch:{ all -> 0x0006 }
            r2 = 1
            if (r1 == 0) goto L_0x0012
            r1 = r5
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x0006 }
            r3 = 1
            goto L_0x0017
        L_0x0012:
            java.lang.Class r1 = r5.getClass()     // Catch:{ all -> 0x0006 }
            r3 = 0
        L_0x0017:
            java.lang.reflect.Field r1 = r1.getField(r6)     // Catch:{ NoSuchFieldException -> 0x0057 }
            if (r1 != 0) goto L_0x001f
            monitor-exit(r4)     // Catch:{ all -> 0x0006 }
            return r0
        L_0x001f:
            if (r3 == 0) goto L_0x002d
            int r3 = r1.getModifiers()     // Catch:{ all -> 0x0006 }
            boolean r3 = java.lang.reflect.Modifier.isStatic(r3)     // Catch:{ all -> 0x0006 }
            if (r3 != 0) goto L_0x002d
            monitor-exit(r4)     // Catch:{ all -> 0x0006 }
            return r0
        L_0x002d:
            java.lang.Class r0 = r1.getType()     // Catch:{ all -> 0x0006 }
            int r3 = r1.getModifiers()     // Catch:{ LuaException -> 0x0051, Exception -> 0x004a }
            boolean r3 = java.lang.reflect.Modifier.isPublic(r3)     // Catch:{ LuaException -> 0x0051, Exception -> 0x004a }
            if (r3 != 0) goto L_0x003e
            r1.setAccessible(r2)     // Catch:{ LuaException -> 0x0051, Exception -> 0x004a }
        L_0x003e:
            int r3 = r4.getTop()     // Catch:{ LuaException -> 0x0051, Exception -> 0x004a }
            java.lang.Object r3 = m3277e(r4, r0, r3)     // Catch:{ LuaException -> 0x0051, Exception -> 0x004a }
            r1.set(r5, r3)     // Catch:{ LuaException -> 0x0051, Exception -> 0x004a }
            goto L_0x0055
        L_0x004a:
            r5 = move-exception
            com.luajava.LuaException r6 = new com.luajava.LuaException     // Catch:{ all -> 0x0006 }
            r6.<init>(r5)     // Catch:{ all -> 0x0006 }
            throw r6     // Catch:{ all -> 0x0006 }
        L_0x0051:
            r5 = -1
            m3267a(r4, r6, r5, r0)     // Catch:{ all -> 0x0006 }
        L_0x0055:
            monitor-exit(r4)     // Catch:{ all -> 0x0006 }
            return r2
        L_0x0057:
            monitor-exit(r4)     // Catch:{ all -> 0x0006 }
            return r0
        L_0x0059:
            monitor-exit(r4)     // Catch:{ all -> 0x0006 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaJavaAPI.setFieldValue(com.luajava.LuaState, java.lang.Object, java.lang.String):int");
    }
}
