package com.luajava;

import com.androlua.BuildConfig;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Proxy;
import java.util.StringTokenizer;

public class LuaObject implements Serializable {

    /* renamed from: a */
    protected int f3392a;

    /* renamed from: b */
    protected final LuaState f3393b;

    protected LuaObject(LuaObject luaObject, LuaObject luaObject2) {
        if (luaObject.getLuaState() != luaObject2.getLuaState()) {
            throw new LuaException("LuaStates must be the same!");
        }
        synchronized (luaObject.getLuaState()) {
            if (luaObject.isTable() || luaObject.isUserdata()) {
                this.f3393b = luaObject.getLuaState();
                luaObject.push();
                luaObject2.push();
                this.f3393b.getTable(-2);
                this.f3393b.remove(-2);
                mo3442a(-1);
                this.f3393b.pop(1);
            } else {
                throw new LuaException("Object parent should be a table or userdata .");
            }
        }
    }

    protected LuaObject(LuaObject luaObject, Number number) {
        synchronized (luaObject.getLuaState()) {
            this.f3393b = luaObject.getLuaState();
            if (luaObject.isTable() || luaObject.isUserdata()) {
                luaObject.push();
                this.f3393b.pushNumber(number.doubleValue());
                this.f3393b.getTable(-2);
                this.f3393b.remove(-2);
                mo3442a(-1);
                this.f3393b.pop(1);
            } else {
                throw new LuaException("Object parent should be a table or userdata .");
            }
        }
    }

    protected LuaObject(LuaObject luaObject, String str) {
        synchronized (luaObject.getLuaState()) {
            this.f3393b = luaObject.getLuaState();
            if (luaObject.isTable() || luaObject.isUserdata()) {
                luaObject.push();
                this.f3393b.pushString(str);
                this.f3393b.getTable(-2);
                this.f3393b.remove(-2);
                mo3442a(-1);
                this.f3393b.pop(1);
            } else {
                throw new LuaException("Object parent should be a table or userdata .");
            }
        }
    }

    protected LuaObject(LuaState luaState) {
        this.f3393b = luaState;
    }

    protected LuaObject(LuaState luaState, int i) {
        synchronized (luaState) {
            this.f3393b = luaState;
            mo3442a(i);
        }
    }

    protected LuaObject(LuaState luaState, String str) {
        synchronized (luaState) {
            this.f3393b = luaState;
            luaState.getGlobal(str);
            mo3442a(-1);
            luaState.pop(1);
        }
    }

    public LuaObject _call(Object... objArr) {
        return _call_aux(objArr, 1)[0];
    }

    public LuaObject[] _call_aux(Object[] objArr, int i) {
        int i2;
        LuaObject[] luaObjectArr;
        String str;
        String str2;
        StringBuilder sb;
        synchronized (this.f3393b) {
            if (isFunction() || isTable() || isUserdata()) {
                int top = this.f3393b.getTop();
                push();
                if (objArr != null) {
                    for (Object pushObjectValue : objArr) {
                        this.f3393b.pushObjectValue(pushObjectValue);
                    }
                } else {
                    i2 = 0;
                }
                int pcall = this.f3393b.pcall(i2, i, 0);
                if (pcall != 0) {
                    if (this.f3393b.isString(-1)) {
                        str = this.f3393b.toString(-1);
                        this.f3393b.pop(1);
                    } else {
                        str = BuildConfig.FLAVOR;
                    }
                    if (pcall == 2) {
                        sb = new StringBuilder();
                        sb.append("Runtime error. ");
                        sb.append(str);
                    } else if (pcall == 4) {
                        sb = new StringBuilder();
                        sb.append("Memory allocation error. ");
                        sb.append(str);
                    } else if (pcall == 6) {
                        sb = new StringBuilder();
                        sb.append("Error while running the error handler function. ");
                        sb.append(str);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Lua Error code ");
                        sb2.append(pcall);
                        sb2.append(". ");
                        sb2.append(str);
                        str2 = sb2.toString();
                        throw new LuaException(str2);
                    }
                    str2 = sb.toString();
                    throw new LuaException(str2);
                }
                if (i == -1) {
                    i = this.f3393b.getTop() - top;
                }
                if (this.f3393b.getTop() - top < i) {
                    throw new LuaException("Invalid Number of Results .");
                }
                luaObjectArr = new LuaObject[i];
                while (i > 0) {
                    luaObjectArr[i - 1] = this.f3393b.getLuaObject(-1);
                    this.f3393b.pop(1);
                    i--;
                }
            } else {
                throw new LuaException("Invalid object. Not a function, table or userdata .");
            }
        }
        return luaObjectArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3442a(int i) {
        synchronized (this.f3393b) {
            this.f3393b.pushValue(i);
            this.f3392a = this.f3393b.Lref(LuaState.LUA_REGISTRYINDEX);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|11|12|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object[] asArray() {
        /*
            r9 = this;
            com.luajava.LuaState r0 = r9.f3393b
            monitor-enter(r0)
            boolean r1 = r9.isTable()     // Catch:{ all -> 0x004d }
            if (r1 != 0) goto L_0x0011
            com.luajava.LuaException r1 = new com.luajava.LuaException     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "Invalid object. Not a table ."
            r1.<init>(r2)     // Catch:{ all -> 0x004d }
            throw r1     // Catch:{ all -> 0x004d }
        L_0x0011:
            r9.push()     // Catch:{ all -> 0x004d }
            com.luajava.LuaState r1 = r9.f3393b     // Catch:{ all -> 0x004d }
            r2 = -1
            int r1 = r1.objLen(r2)     // Catch:{ all -> 0x004d }
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            java.lang.Object r3 = java.lang.reflect.Array.newInstance(r3, r1)     // Catch:{ all -> 0x004d }
            r4 = 1
            r5 = 1
        L_0x0023:
            if (r5 > r1) goto L_0x0044
            com.luajava.LuaState r6 = r9.f3393b     // Catch:{ all -> 0x004d }
            long r7 = (long) r5     // Catch:{ all -> 0x004d }
            r6.pushInteger(r7)     // Catch:{ all -> 0x004d }
            com.luajava.LuaState r6 = r9.f3393b     // Catch:{ all -> 0x004d }
            r7 = -2
            r6.getTable(r7)     // Catch:{ all -> 0x004d }
            int r6 = r5 + -1
            com.luajava.LuaState r7 = r9.f3393b     // Catch:{ LuaException -> 0x003c }
            java.lang.Object r7 = r7.toJavaObject(r2)     // Catch:{ LuaException -> 0x003c }
            java.lang.reflect.Array.set(r3, r6, r7)     // Catch:{ LuaException -> 0x003c }
        L_0x003c:
            com.luajava.LuaState r6 = r9.f3393b     // Catch:{ all -> 0x004d }
            r6.pop(r4)     // Catch:{ all -> 0x004d }
            int r5 = r5 + 1
            goto L_0x0023
        L_0x0044:
            com.luajava.LuaState r1 = r9.f3393b     // Catch:{ all -> 0x004d }
            r1.pop(r4)     // Catch:{ all -> 0x004d }
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch:{ all -> 0x004d }
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return r3
        L_0x004d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaObject.asArray():java.lang.Object[]");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|14|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map asMap(com.luajava.LuaState r4, java.lang.Class<?> r5, int r6) {
        /*
            r3 = this;
            monitor-enter(r4)
            boolean r5 = r3.isTable()     // Catch:{ all -> 0x0037 }
            if (r5 != 0) goto L_0x000f
            com.luajava.LuaException r5 = new com.luajava.LuaException     // Catch:{ all -> 0x0037 }
            java.lang.String r6 = "Invalid object. Not a table ."
            r5.<init>(r6)     // Catch:{ all -> 0x0037 }
            throw r5     // Catch:{ all -> 0x0037 }
        L_0x000f:
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0037 }
            r5.<init>()     // Catch:{ all -> 0x0037 }
            r3.push()     // Catch:{ all -> 0x0037 }
            r4.pushNil()     // Catch:{ all -> 0x0037 }
        L_0x001a:
            int r0 = r4.next(r6)     // Catch:{ all -> 0x0037 }
            r1 = 1
            if (r0 == 0) goto L_0x0032
            r0 = -2
            java.lang.Object r0 = r4.toJavaObject(r0)     // Catch:{ LuaException -> 0x002e }
            r2 = -1
            java.lang.Object r2 = r4.toJavaObject(r2)     // Catch:{ LuaException -> 0x002e }
            r5.put(r0, r2)     // Catch:{ LuaException -> 0x002e }
        L_0x002e:
            r4.pop(r1)     // Catch:{ all -> 0x0037 }
            goto L_0x001a
        L_0x0032:
            r4.pop(r1)     // Catch:{ all -> 0x0037 }
            monitor-exit(r4)     // Catch:{ all -> 0x0037 }
            return r5
        L_0x0037:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0037 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaObject.asMap(com.luajava.LuaState, java.lang.Class, int):java.util.Map");
    }

    public Object call(Object... objArr) {
        return call_aux(objArr, 1)[0];
    }

    public Object[] call_aux(Object[] objArr, int i) {
        int i2;
        Object[] objArr2;
        String str;
        String str2;
        StringBuilder sb;
        synchronized (this.f3393b) {
            if (isFunction() || isTable() || isUserdata()) {
                int top = this.f3393b.getTop();
                push();
                if (objArr != null) {
                    for (Object pushObjectValue : objArr) {
                        this.f3393b.pushObjectValue(pushObjectValue);
                    }
                } else {
                    i2 = 0;
                }
                int pcall = this.f3393b.pcall(i2, i, 0);
                if (pcall != 0) {
                    if (this.f3393b.isString(-1)) {
                        str = this.f3393b.toString(-1);
                        this.f3393b.pop(1);
                    } else {
                        str = BuildConfig.FLAVOR;
                    }
                    if (pcall == 2) {
                        sb = new StringBuilder();
                        sb.append("Runtime error. ");
                        sb.append(str);
                    } else if (pcall == 4) {
                        sb = new StringBuilder();
                        sb.append("Memory allocation error. ");
                        sb.append(str);
                    } else if (pcall == 6) {
                        sb = new StringBuilder();
                        sb.append("Error while running the error handler function. ");
                        sb.append(str);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Lua Error code ");
                        sb2.append(pcall);
                        sb2.append(". ");
                        sb2.append(str);
                        str2 = sb2.toString();
                        throw new LuaException(str2);
                    }
                    str2 = sb.toString();
                    throw new LuaException(str2);
                }
                if (i == -1) {
                    i = this.f3393b.getTop() - top;
                }
                if (this.f3393b.getTop() - top < i) {
                    throw new LuaException("Invalid Number of Results .");
                }
                objArr2 = new Object[i];
                while (i > 0) {
                    objArr2[i - 1] = this.f3393b.toJavaObject(-1);
                    this.f3393b.pop(1);
                    i--;
                }
            } else {
                throw new LuaException("Invalid object. Not a function, table or userdata .");
            }
        }
        return objArr2;
    }

    public Object createProxy(Class cls) {
        Object newProxyInstance;
        synchronized (this.f3393b) {
            if (!isTable() && !isFunction()) {
                throw new LuaException("Invalid Object. Must be Table or Function.");
            } else if (isFunction() && cls.getMethods().length != 1) {
                throw new LuaException("Invalid Object. Must be a interface Method of Function.");
            } else if (!isTable() || !getTable().isList()) {
                newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new LuaInvocationHandler(this));
            } else {
                throw new LuaException("Invalid Object. Must be Table is Not Array.");
            }
        }
        return newProxyInstance;
    }

    public Object createProxy(String str) {
        Object newProxyInstance;
        synchronized (this.f3393b) {
            if (!isTable()) {
                throw new LuaException("Invalid Object. Must be Table.");
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            Class[] clsArr = new Class[stringTokenizer.countTokens()];
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                clsArr[i] = Class.forName(stringTokenizer.nextToken());
                i++;
            }
            newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), clsArr, new LuaInvocationHandler(this));
        }
        return newProxyInstance;
    }

    public byte[] dump() {
        byte[] dump;
        synchronized (this.f3393b) {
            if (!isFunction()) {
                throw new LuaException("Invalid object. Not a function .");
            }
            push();
            dump = this.f3393b.dump(-1);
            this.f3393b.pop(1);
        }
        return dump;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            synchronized (this.f3393b) {
                if (this.f3393b.getPointer() != 0) {
                    this.f3393b.LunRef(LuaState.LUA_REGISTRYINDEX, this.f3392a);
                }
            }
        } catch (Exception unused) {
            PrintStream printStream = System.err;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to release object ");
            sb.append(this.f3392a);
            printStream.println(sb.toString());
        }
    }

    public boolean getBoolean() {
        boolean z;
        synchronized (this.f3393b) {
            push();
            z = this.f3393b.toBoolean(-1);
            this.f3393b.pop(1);
        }
        return z;
    }

    public LuaObject getField(String str) {
        return this.f3393b.getLuaObject(this, str);
    }

    public LuaFunction<?> getFunction() {
        LuaFunction<?> luaFunction;
        synchronized (this.f3393b) {
            push();
            luaFunction = new LuaFunction<>(this.f3393b, -1);
            this.f3393b.pop(1);
        }
        return luaFunction;
    }

    public LuaObject getI(long j) {
        return this.f3393b.getLuaObject(this, (Number) Long.valueOf(j));
    }

    public long getInteger() {
        long integer;
        synchronized (this.f3393b) {
            push();
            integer = this.f3393b.toInteger(-1);
            this.f3393b.pop(1);
        }
        return integer;
    }

    public LuaState getLuaState() {
        return this.f3393b;
    }

    public double getNumber() {
        double number;
        synchronized (this.f3393b) {
            push();
            number = this.f3393b.toNumber(-1);
            this.f3393b.pop(1);
        }
        return number;
    }

    public Object getObject() {
        Object objectFromUserdata;
        synchronized (this.f3393b) {
            push();
            objectFromUserdata = this.f3393b.getObjectFromUserdata(-1);
            this.f3393b.pop(1);
        }
        return objectFromUserdata;
    }

    public String getString() {
        String luaState;
        synchronized (this.f3393b) {
            push();
            luaState = this.f3393b.toString(-1);
            this.f3393b.pop(1);
        }
        return luaState;
    }

    public LuaTable<?, ?> getTable() {
        LuaTable<?, ?> luaTable;
        synchronized (this.f3393b) {
            push();
            luaTable = new LuaTable<>(this.f3393b, -1);
            this.f3393b.pop(1);
        }
        return luaTable;
    }

    public boolean isBoolean() {
        boolean isBoolean;
        synchronized (this.f3393b) {
            push();
            isBoolean = this.f3393b.isBoolean(-1);
            this.f3393b.pop(1);
        }
        return isBoolean;
    }

    public boolean isFunction() {
        boolean isFunction;
        synchronized (this.f3393b) {
            push();
            isFunction = this.f3393b.isFunction(-1);
            this.f3393b.pop(1);
        }
        return isFunction;
    }

    public boolean isInteger() {
        boolean isInteger;
        synchronized (this.f3393b) {
            push();
            isInteger = this.f3393b.isInteger(-1);
            this.f3393b.pop(1);
        }
        return isInteger;
    }

    public boolean isJavaFunction() {
        boolean isJavaFunction;
        synchronized (this.f3393b) {
            push();
            isJavaFunction = this.f3393b.isJavaFunction(-1);
            this.f3393b.pop(1);
        }
        return isJavaFunction;
    }

    public boolean isJavaObject() {
        boolean isObject;
        synchronized (this.f3393b) {
            push();
            isObject = this.f3393b.isObject(-1);
            this.f3393b.pop(1);
        }
        return isObject;
    }

    public boolean isNil() {
        boolean isNil;
        synchronized (this.f3393b) {
            push();
            isNil = this.f3393b.isNil(-1);
            this.f3393b.pop(1);
        }
        return isNil;
    }

    public boolean isNumber() {
        boolean isNumber;
        synchronized (this.f3393b) {
            push();
            isNumber = this.f3393b.isNumber(-1);
            this.f3393b.pop(1);
        }
        return isNumber;
    }

    public boolean isString() {
        boolean isString;
        synchronized (this.f3393b) {
            push();
            isString = this.f3393b.isString(-1);
            this.f3393b.pop(1);
        }
        return isString;
    }

    public boolean isTable() {
        boolean isTable;
        synchronized (this.f3393b) {
            push();
            isTable = this.f3393b.isTable(-1);
            this.f3393b.pop(1);
        }
        return isTable;
    }

    public boolean isUserdata() {
        boolean isUserdata;
        synchronized (this.f3393b) {
            push();
            isUserdata = this.f3393b.isUserdata(-1);
            this.f3393b.pop(1);
        }
        return isUserdata;
    }

    public void pop() {
        this.f3393b.pop(1);
    }

    public void push() {
        this.f3393b.rawGetI(LuaState.LUA_REGISTRYINDEX, (long) this.f3392a);
    }

    public void setField(String str, Object obj) {
        push();
        try {
            this.f3393b.pushObjectValue(obj);
        } catch (LuaException unused) {
            this.f3393b.pushNil();
        }
        this.f3393b.setField(-2, str);
        this.f3393b.pop(1);
    }

    public void setI(long j, Object obj) {
        push();
        try {
            this.f3393b.pushObjectValue(obj);
        } catch (LuaException unused) {
            this.f3393b.pushNil();
        }
        this.f3393b.setI(-2, j);
        this.f3393b.pop(1);
    }

    public String toString() {
        synchronized (this.f3393b) {
            try {
                if (isNil()) {
                    String str = "nil";
                    return str;
                } else if (isBoolean()) {
                    String valueOf = String.valueOf(getBoolean());
                    return valueOf;
                } else if (isNumber()) {
                    String valueOf2 = String.valueOf(getNumber());
                    return valueOf2;
                } else if (isString()) {
                    String string = getString();
                    return string;
                } else if (isFunction()) {
                    String str2 = "Lua Function";
                    return str2;
                } else if (isJavaObject()) {
                    String obj = getObject().toString();
                    return obj;
                } else if (isUserdata()) {
                    String str3 = "Userdata";
                    return str3;
                } else if (isTable()) {
                    String str4 = "Lua Table";
                    return str4;
                } else if (!isJavaFunction()) {
                    return null;
                } else {
                    String str5 = "Java Function";
                    return str5;
                }
            } catch (LuaException unused) {
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int type() {
        int type;
        synchronized (this.f3393b) {
            push();
            type = this.f3393b.type(-1);
            this.f3393b.pop(1);
        }
        return type;
    }
}
