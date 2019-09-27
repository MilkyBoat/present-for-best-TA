package com.luajava;

import android.util.Log;
import com.androlua.LuaContext;
import java.io.PrintStream;

public class LuaState {
    public static final int LUAI_MAXSTACK = 1000000;
    public static final int LUA_ERRERR = 6;
    public static final int LUA_ERRGCMM = 5;
    public static final int LUA_ERRMEM = 4;
    public static final int LUA_ERRRUN = 2;
    public static final int LUA_ERRSYNTAX = 3;
    public static final int LUA_GCCOLLECT = 2;
    public static final int LUA_GCCOUNT = 3;
    public static final int LUA_GCCOUNTB = 4;
    public static final int LUA_GCRESTART = 1;
    public static final int LUA_GCSETPAUSE = 6;
    public static final int LUA_GCSETSTEPMUL = 7;
    public static final int LUA_GCSTEP = 5;
    public static final int LUA_GCSTOP = 0;
    public static final int LUA_MULTRET = -1;
    public static final int LUA_OPEQ = 0;
    public static final int LUA_OPLE = 2;
    public static final int LUA_OPLT = 1;
    public static final int LUA_REGISTRYINDEX = -1001000;
    public static final int LUA_RIDX_GLOBALS = 2;
    public static final int LUA_RIDX_LAST = 2;
    public static final int LUA_RIDX_MAINTHREAD = 1;
    public static final int LUA_TBOOLEAN = 1;
    public static final int LUA_TFUNCTION = 6;
    public static final int LUA_TINTEGER = 9;
    public static final int LUA_TLIGHTUSERDATA = 2;
    public static final int LUA_TNIL = 0;
    public static final int LUA_TNONE = -1;
    public static final int LUA_TNUMBER = 3;
    public static final int LUA_TSTRING = 4;
    public static final int LUA_TTABLE = 5;
    public static final int LUA_TTHREAD = 8;
    public static final int LUA_TUSERDATA = 7;
    public static final int LUA_YIELD = 1;

    /* renamed from: a */
    private static Class<?> f3395a = Number.class;

    /* renamed from: b */
    private static Class<?> f3396b = Byte.class;

    /* renamed from: c */
    private static Class<?> f3397c = Short.class;

    /* renamed from: d */
    private static Class<?> f3398d = Integer.class;

    /* renamed from: e */
    private static Class<?> f3399e = Long.class;

    /* renamed from: f */
    private static Class<?> f3400f = Float.class;

    /* renamed from: g */
    private static Class<?> f3401g = Double.class;

    /* renamed from: h */
    private long f3402h;

    /* renamed from: i */
    private LuaContext f3403i;

    static {
        System.loadLibrary("luajava");
    }

    protected LuaState() {
        this.f3402h = _newstate();
    }

    protected LuaState(long j) {
        this.f3402h = j;
        LuaStateFactory.insertLuaState(this);
    }

    private native synchronized int _LargError(long j, int i, String str);

    private native synchronized int _LcallMeta(long j, int i, String str);

    private native synchronized void _LcheckAny(long j, int i);

    private native synchronized int _LcheckInteger(long j, int i);

    private native synchronized double _LcheckNumber(long j, int i);

    private native synchronized void _LcheckStack(long j, int i, String str);

    private native synchronized String _LcheckString(long j, int i);

    private native synchronized void _LcheckType(long j, int i, int i2);

    private native synchronized int _LdoFile(long j, String str);

    private native synchronized int _LdoString(long j, String str);

    private native synchronized int _LgetMetaField(long j, int i, String str);

    private native synchronized void _LgetMetatable(long j, String str);

    private native synchronized String _Lgsub(long j, String str, String str2, String str3);

    private native synchronized int _LloadBuffer(long j, byte[] bArr, long j2, String str);

    private native synchronized int _LloadFile(long j, String str);

    private native synchronized int _LloadString(long j, String str);

    private native synchronized int _LnewMetatable(long j, String str);

    private native synchronized int _LoptInteger(long j, int i, int i2);

    private native synchronized double _LoptNumber(long j, int i, double d);

    private native synchronized String _LoptString(long j, int i, String str);

    private native synchronized int _Lref(long j, int i);

    private native synchronized void _LunRef(long j, int i, int i2);

    private native synchronized void _Lwhere(long j, int i);

    private native synchronized void _call(long j, int i, int i2);

    private native synchronized int _checkStack(long j, int i);

    private native synchronized void _close(long j);

    private native synchronized int _compare(long j, int i, int i2, int i3);

    private native synchronized void _concat(long j, int i);

    private native synchronized void _copy(long j, int i, int i2);

    private native synchronized void _createTable(long j, int i, int i2);

    private native synchronized byte[] _dump(long j, int i);

    private native synchronized int _equal(long j, int i, int i2);

    private native synchronized int _error(long j);

    private native synchronized int _gc(long j, int i, int i2);

    private native synchronized int _getField(long j, int i, String str);

    private native synchronized int _getGlobal(long j, String str);

    private native synchronized int _getI(long j, int i, long j2);

    private native synchronized int _getMetaTable(long j, int i);

    private native synchronized Object _getObjectFromUserdata(long j, int i);

    private native synchronized int _getTable(long j, int i);

    private native synchronized int _getTop(long j);

    private native synchronized String _getUpValue(long j, int i, int i2);

    private native synchronized int _getUserValue(long j, int i);

    private native synchronized void _insert(long j, int i);

    private native synchronized int _isBoolean(long j, int i);

    private native synchronized int _isCFunction(long j, int i);

    private native synchronized int _isFunction(long j, int i);

    private native synchronized int _isInteger(long j, int i);

    private native synchronized boolean _isJavaFunction(long j, int i);

    private native synchronized int _isNil(long j, int i);

    private native synchronized int _isNone(long j, int i);

    private native synchronized int _isNoneOrNil(long j, int i);

    private native synchronized int _isNumber(long j, int i);

    private native synchronized boolean _isObject(long j, int i);

    private native synchronized int _isString(long j, int i);

    private native synchronized int _isTable(long j, int i);

    private native synchronized int _isThread(long j, int i);

    private native synchronized int _isUserdata(long j, int i);

    private native synchronized int _isYieldable(long j);

    private native synchronized int _lessThan(long j, int i, int i2);

    private native synchronized void _newTable(long j);

    private native synchronized long _newstate();

    private native synchronized long _newthread(long j);

    private native synchronized int _next(long j, int i);

    private native synchronized int _objlen(long j, int i);

    private native synchronized void _openBase(long j);

    private native synchronized void _openDebug(long j);

    private native synchronized void _openIo(long j);

    private native synchronized void _openLibs(long j);

    private native synchronized void _openLuajava(long j);

    private native synchronized void _openMath(long j);

    private native synchronized void _openOs(long j);

    private native synchronized void _openPackage(long j);

    private native synchronized void _openString(long j);

    private native synchronized void _openTable(long j);

    private native synchronized int _pcall(long j, int i, int i2, int i3);

    private native synchronized void _pop(long j, int i);

    private native synchronized void _pushBoolean(long j, int i);

    private native synchronized void _pushGlobalTable(long j);

    private native synchronized void _pushInteger(long j, long j2);

    private native synchronized void _pushJavaFunction(long j, JavaFunction javaFunction);

    private native synchronized void _pushJavaObject(long j, Object obj);

    private native synchronized void _pushLString(long j, byte[] bArr, int i);

    private native synchronized void _pushNil(long j);

    private native synchronized void _pushNumber(long j, double d);

    private native synchronized void _pushString(long j, String str);

    private native synchronized void _pushValue(long j, int i);

    private native synchronized int _rawGet(long j, int i);

    private native synchronized int _rawGetI(long j, int i, long j2);

    private native synchronized void _rawSet(long j, int i);

    private native synchronized void _rawSetI(long j, int i, long j2);

    private native synchronized int _rawequal(long j, int i, int i2);

    private native synchronized int _rawlen(long j, int i);

    private native synchronized void _remove(long j, int i);

    private native synchronized void _replace(long j, int i);

    private native synchronized int _resume(long j, long j2, int i);

    private native synchronized void _rotate(long j, int i, int i2);

    private native synchronized void _setField(long j, int i, String str);

    private native synchronized void _setGlobal(long j, String str);

    private native synchronized void _setI(long j, int i, long j2);

    private native synchronized int _setMetaTable(long j, int i);

    private native synchronized void _setTable(long j, int i);

    private native synchronized void _setTop(long j, int i);

    private native synchronized String _setUpValue(long j, int i, int i2);

    private native synchronized void _setUserValue(long j, int i);

    private native synchronized int _status(long j);

    private native synchronized int _strlen(long j, int i);

    private native synchronized int _toBoolean(long j, int i);

    private native synchronized byte[] _toBuffer(long j, int i);

    private native synchronized long _toInteger(long j, int i);

    private native synchronized double _toNumber(long j, int i);

    private native synchronized String _toString(long j, int i);

    private native synchronized long _toThread(long j, int i);

    private native synchronized int _type(long j, int i);

    private native synchronized String _typeName(long j, int i);

    private native synchronized void _xmove(long j, long j2, int i);

    private native synchronized int _yield(long j, int i);

    public static Number convertLuaNumber(Double d, Class<?> cls) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return Integer.valueOf(d.intValue());
            }
            if (cls == Long.TYPE) {
                return Long.valueOf(d.longValue());
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(d.floatValue());
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(d.doubleValue());
            }
            if (cls == Byte.TYPE) {
                return Byte.valueOf(d.byteValue());
            }
            if (cls == Short.TYPE) {
                return Short.valueOf(d.shortValue());
            }
        } else if (cls.isAssignableFrom(f3395a)) {
            if (cls.isAssignableFrom(f3398d)) {
                return new Integer(d.intValue());
            }
            if (cls.isAssignableFrom(f3399e)) {
                return new Long(d.longValue());
            }
            if (cls.isAssignableFrom(f3400f)) {
                return new Float(d.floatValue());
            }
            if (cls.isAssignableFrom(f3401g)) {
                return d;
            }
            if (cls.isAssignableFrom(f3396b)) {
                return new Byte(d.byteValue());
            }
            if (cls.isAssignableFrom(f3397c)) {
                return new Short(d.shortValue());
            }
        }
        return null;
    }

    public static Number convertLuaNumber(Long l, Class<?> cls) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return Integer.valueOf(l.intValue());
            }
            if (cls == Long.TYPE) {
                return Long.valueOf(l.longValue());
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(l.floatValue());
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(l.doubleValue());
            }
            if (cls == Byte.TYPE) {
                return Byte.valueOf(l.byteValue());
            }
            if (cls == Short.TYPE) {
                return Short.valueOf(l.shortValue());
            }
        } else if (cls.isAssignableFrom(f3395a)) {
            if (cls.isAssignableFrom(f3398d)) {
                return new Integer(l.intValue());
            }
            if (cls.isAssignableFrom(f3399e)) {
                return new Long(l.longValue());
            }
            if (cls.isAssignableFrom(f3400f)) {
                return new Float(l.floatValue());
            }
            if (cls.isAssignableFrom(f3401g)) {
                return l;
            }
            if (cls.isAssignableFrom(f3396b)) {
                return new Byte(l.byteValue());
            }
            if (cls.isAssignableFrom(f3397c)) {
                return new Short(l.shortValue());
            }
        }
        return null;
    }

    public int LargError(int i, String str) {
        return _LargError(this.f3402h, i, str);
    }

    public int LcallMeta(int i, String str) {
        return _LcallMeta(this.f3402h, i, str);
    }

    public void LcheckAny(int i) {
        _LcheckAny(this.f3402h, i);
    }

    public int LcheckInteger(int i) {
        return _LcheckInteger(this.f3402h, i);
    }

    public double LcheckNumber(int i) {
        return _LcheckNumber(this.f3402h, i);
    }

    public void LcheckStack(int i, String str) {
        _LcheckStack(this.f3402h, i, str);
    }

    public String LcheckString(int i) {
        return _LcheckString(this.f3402h, i);
    }

    public void LcheckType(int i, int i2) {
        _LcheckType(this.f3402h, i, i2);
    }

    public int LdoFile(String str) {
        return _LdoFile(this.f3402h, str);
    }

    public int LdoString(String str) {
        return _LdoString(this.f3402h, str);
    }

    public int LgetMetaField(int i, String str) {
        return _LgetMetaField(this.f3402h, i, str);
    }

    public void LgetMetatable(String str) {
        _LgetMetatable(this.f3402h, str);
    }

    public String Lgsub(String str, String str2, String str3) {
        return _Lgsub(this.f3402h, str, str2, str3);
    }

    public int LloadBuffer(byte[] bArr, String str) {
        return _LloadBuffer(this.f3402h, bArr, (long) bArr.length, str);
    }

    public int LloadFile(String str) {
        return _LloadFile(this.f3402h, str);
    }

    public int LloadString(String str) {
        return _LloadString(this.f3402h, str);
    }

    public int LnewMetatable(String str) {
        return _LnewMetatable(this.f3402h, str);
    }

    public int LoptInteger(int i, int i2) {
        return _LoptInteger(this.f3402h, i, i2);
    }

    public double LoptNumber(int i, double d) {
        return _LoptNumber(this.f3402h, i, d);
    }

    public String LoptString(int i, String str) {
        return _LoptString(this.f3402h, i, str);
    }

    public int Lref(int i) {
        return _Lref(this.f3402h, i);
    }

    public void LunRef(int i, int i2) {
        _LunRef(this.f3402h, i, i2);
    }

    public void Lwhere(int i) {
        _Lwhere(this.f3402h, i);
    }

    public void call(int i, int i2) {
        _call(this.f3402h, i, i2);
    }

    public int checkStack(int i) {
        return _checkStack(this.f3402h, i);
    }

    public synchronized void close() {
        LuaStateFactory.removeLuaState(this.f3402h);
        _close(this.f3402h);
        this.f3402h = 0;
    }

    public int compare(int i, int i2, int i3) {
        return _compare(this.f3402h, i, i2, i3);
    }

    public void concat(int i) {
        _concat(this.f3402h, i);
    }

    public void copy(int i, int i2) {
        _copy(this.f3402h, i, i2);
    }

    public void createTable(int i, int i2) {
        _createTable(this.f3402h, i, i2);
    }

    public byte[] dump(int i) {
        return _dump(this.f3402h, i);
    }

    public int equal(int i, int i2) {
        return _equal(this.f3402h, i, i2);
    }

    public int error() {
        return _error(this.f3402h);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        StringBuilder sb = new StringBuilder();
        sb.append("finalize: ");
        sb.append(this.f3402h);
        Log.i("luaState", sb.toString());
        try {
            close();
        } catch (Exception unused) {
            PrintStream printStream = System.err;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to release luaState ");
            sb2.append(this.f3402h);
            printStream.println(sb2.toString());
        }
    }

    /* renamed from: gc */
    public int mo3510gc(int i, int i2) {
        return _gc(this.f3402h, i, i2);
    }

    public LuaContext getContext() {
        return this.f3403i;
    }

    public int getField(int i, String str) {
        return _getField(this.f3402h, i, str);
    }

    public LuaFunction getFunction(int i) {
        LuaObject luaObject = getLuaObject(i);
        if (luaObject.isFunction()) {
            return luaObject.getFunction();
        }
        return null;
    }

    public LuaFunction getFunction(String str) {
        LuaObject luaObject = getLuaObject(str);
        if (luaObject.isFunction()) {
            return luaObject.getFunction();
        }
        return null;
    }

    public synchronized int getGlobal(String str) {
        return _getGlobal(this.f3402h, str);
    }

    public int getI(int i, long j) {
        return _getI(this.f3402h, i, j);
    }

    public LuaObject getLuaObject(int i) {
        return isFunction(i) ? new LuaFunction(this, i) : isTable(i) ? new LuaTable(this, i) : new LuaObject(this, i);
    }

    public LuaObject getLuaObject(LuaObject luaObject, LuaObject luaObject2) {
        if (luaObject.getLuaState().getPointer() == this.f3402h && luaObject.getLuaState().getPointer() == luaObject2.getLuaState().getPointer()) {
            return new LuaObject(luaObject, luaObject2);
        }
        throw new LuaException("Object must have the same LuaState as the parent!");
    }

    public LuaObject getLuaObject(LuaObject luaObject, Number number) {
        return new LuaObject(luaObject, number);
    }

    public LuaObject getLuaObject(LuaObject luaObject, String str) {
        return new LuaObject(luaObject, str);
    }

    public LuaObject getLuaObject(String str) {
        pushGlobalTable();
        pushString(str);
        rawGet(-2);
        LuaObject luaObject = getLuaObject(-1);
        pop(2);
        return luaObject;
    }

    public int getMetaTable(int i) {
        return _getMetaTable(this.f3402h, i);
    }

    public Object getObjectFromUserdata(int i) {
        return _getObjectFromUserdata(this.f3402h, i);
    }

    public long getPointer() {
        return this.f3402h;
    }

    public int getTable(int i) {
        return _getTable(this.f3402h, i);
    }

    public int getTop() {
        return _getTop(this.f3402h);
    }

    public String getUpValue(int i, int i2) {
        return _getUpValue(this.f3402h, i, i2);
    }

    public int getUserValue(int i) {
        return _getUserValue(this.f3402h, i);
    }

    public void insert(int i) {
        _insert(this.f3402h, i);
    }

    public boolean isBoolean(int i) {
        return _isBoolean(this.f3402h, i) != 0;
    }

    public boolean isCFunction(int i) {
        return _isCFunction(this.f3402h, i) != 0;
    }

    public synchronized boolean isClosed() {
        return this.f3402h == 0;
    }

    public boolean isFunction(int i) {
        return _isFunction(this.f3402h, i) != 0;
    }

    public boolean isInteger(int i) {
        return _isInteger(this.f3402h, i) != 0;
    }

    public boolean isJavaFunction(int i) {
        return _isJavaFunction(this.f3402h, i);
    }

    public boolean isNil(int i) {
        return _isNil(this.f3402h, i) != 0;
    }

    public boolean isNone(int i) {
        return _isNone(this.f3402h, i) != 0;
    }

    public boolean isNoneOrNil(int i) {
        return _isNoneOrNil(this.f3402h, i) != 0;
    }

    public boolean isNumber(int i) {
        return _isNumber(this.f3402h, i) != 0;
    }

    public boolean isObject(int i) {
        return _isObject(this.f3402h, i);
    }

    public boolean isString(int i) {
        return _isString(this.f3402h, i) != 0;
    }

    public boolean isTable(int i) {
        return _isTable(this.f3402h, i) != 0;
    }

    public boolean isThread(int i) {
        return _isThread(this.f3402h, i) != 0;
    }

    public boolean isUserdata(int i) {
        return _isUserdata(this.f3402h, i) != 0;
    }

    public int isYieldable() {
        return _isYieldable(this.f3402h);
    }

    public int lessThan(int i, int i2) {
        return _lessThan(this.f3402h, i, i2);
    }

    public void newTable() {
        _newTable(this.f3402h);
    }

    public LuaState newThread() {
        LuaState luaState = new LuaState(_newthread(this.f3402h));
        LuaStateFactory.insertLuaState(luaState);
        return luaState;
    }

    public int next(int i) {
        return _next(this.f3402h, i);
    }

    public int objLen(int i) {
        return _objlen(this.f3402h, i);
    }

    public void openBase() {
        _openBase(this.f3402h);
    }

    public void openDebug() {
        _openDebug(this.f3402h);
    }

    public void openIo() {
        _openIo(this.f3402h);
    }

    public void openLibs() {
        _openLibs(this.f3402h);
        _openLuajava(this.f3402h);
        pushPrimitive();
    }

    public void openLuajava() {
        _openLuajava(this.f3402h);
        pushPrimitive();
    }

    public void openMath() {
        _openMath(this.f3402h);
    }

    public void openOs() {
        _openOs(this.f3402h);
    }

    public void openPackage() {
        _openPackage(this.f3402h);
    }

    public void openString() {
        _openString(this.f3402h);
    }

    public void openTable() {
        _openTable(this.f3402h);
    }

    public int pcall(int i, int i2, int i3) {
        return _pcall(this.f3402h, i, i2, i3);
    }

    public void pop(int i) {
        _pop(this.f3402h, i);
    }

    public void pushBoolean(boolean z) {
        _pushBoolean(this.f3402h, z ? 1 : 0);
    }

    public void pushContext(LuaContext luaContext) {
        this.f3403i = luaContext;
        pushString("_LuaContext");
        pushJavaObject(luaContext);
        setTable(LUA_REGISTRYINDEX);
    }

    public synchronized void pushGlobalTable() {
        _pushGlobalTable(this.f3402h);
    }

    public void pushInteger(long j) {
        _pushInteger(this.f3402h, j);
    }

    public void pushJavaFunction(JavaFunction javaFunction) {
        _pushJavaFunction(this.f3402h, javaFunction);
    }

    public void pushJavaObject(Object obj) {
        _pushJavaObject(this.f3402h, obj);
    }

    public void pushNil() {
        _pushNil(this.f3402h);
    }

    public void pushNumber(double d) {
        _pushNumber(this.f3402h, d);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v2, types: [com.luajava.LuaObject] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object, code=null, for r3v0, types: [java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v2, types: [com.luajava.LuaObject]
  assigns: [com.luajava.LuaObject, java.lang.Object]
  uses: [com.luajava.LuaObject, java.lang.Object, ?[int, boolean, OBJECT, ARRAY, byte, short, char], ?[OBJECT, ARRAY]]
  mth insns count: 68
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
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pushObjectValue(java.lang.Object r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0006
            r2.pushNil()
            return
        L_0x0006:
            boolean r0 = r3 instanceof java.lang.Boolean
            if (r0 == 0) goto L_0x0014
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r2.pushBoolean(r3)
            return
        L_0x0014:
            boolean r0 = r3 instanceof java.lang.Long
            if (r0 == 0) goto L_0x0022
            java.lang.Long r3 = (java.lang.Long) r3
            long r0 = r3.longValue()
        L_0x001e:
            r2.pushInteger(r0)
            return
        L_0x0022:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 == 0) goto L_0x002e
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
        L_0x002c:
            long r0 = (long) r3
            goto L_0x001e
        L_0x002e:
            boolean r0 = r3 instanceof java.lang.Short
            if (r0 == 0) goto L_0x0039
            java.lang.Short r3 = (java.lang.Short) r3
            short r3 = r3.shortValue()
            goto L_0x002c
        L_0x0039:
            boolean r0 = r3 instanceof java.lang.Character
            if (r0 == 0) goto L_0x0044
            java.lang.Character r3 = (java.lang.Character) r3
            char r3 = r3.charValue()
            goto L_0x002c
        L_0x0044:
            boolean r0 = r3 instanceof java.lang.Byte
            if (r0 == 0) goto L_0x004f
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            goto L_0x002c
        L_0x004f:
            boolean r0 = r3 instanceof java.lang.Float
            if (r0 == 0) goto L_0x005e
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            double r0 = (double) r3
        L_0x005a:
            r2.pushNumber(r0)
            return
        L_0x005e:
            boolean r0 = r3 instanceof java.lang.Double
            if (r0 == 0) goto L_0x0069
            java.lang.Double r3 = (java.lang.Double) r3
            double r0 = r3.doubleValue()
            goto L_0x005a
        L_0x0069:
            boolean r0 = r3 instanceof java.lang.String
            if (r0 == 0) goto L_0x0073
            java.lang.String r3 = (java.lang.String) r3
            r2.pushString(r3)
            return
        L_0x0073:
            boolean r0 = r3 instanceof com.luajava.LuaString
            if (r0 == 0) goto L_0x0081
            com.luajava.LuaString r3 = (com.luajava.LuaString) r3
            byte[] r3 = r3.toByteArray()
            r2.pushString(r3)
            return
        L_0x0081:
            boolean r0 = r3 instanceof com.luajava.JavaFunction
            if (r0 == 0) goto L_0x008b
            com.luajava.JavaFunction r3 = (com.luajava.JavaFunction) r3
            r2.pushJavaFunction(r3)
            return
        L_0x008b:
            boolean r0 = r3 instanceof com.luajava.LuaObject
            if (r0 == 0) goto L_0x009b
            com.luajava.LuaObject r3 = (com.luajava.LuaObject) r3
            com.luajava.LuaState r0 = r3.getLuaState()
            if (r0 != r2) goto L_0x009b
            r3.push()
            return
        L_0x009b:
            r2.pushJavaObject(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luajava.LuaState.pushObjectValue(java.lang.Object):void");
    }

    public void pushPrimitive() {
        pushJavaObject(Boolean.TYPE);
        setGlobal("boolean");
        pushJavaObject(Byte.TYPE);
        setGlobal("byte");
        pushJavaObject(Character.TYPE);
        setGlobal("char");
        pushJavaObject(Short.TYPE);
        setGlobal("short");
        pushJavaObject(Integer.TYPE);
        setGlobal("int");
        pushJavaObject(Long.TYPE);
        setGlobal("long");
        pushJavaObject(Float.TYPE);
        setGlobal("float");
        pushJavaObject(Double.TYPE);
        setGlobal("double");
    }

    public void pushString(String str) {
        if (str == null) {
            _pushNil(this.f3402h);
        } else {
            _pushString(this.f3402h, str);
        }
    }

    public void pushString(byte[] bArr) {
        if (bArr == null) {
            _pushNil(this.f3402h);
        } else {
            _pushLString(this.f3402h, bArr, bArr.length);
        }
    }

    public void pushValue(int i) {
        _pushValue(this.f3402h, i);
    }

    public int rawGet(int i) {
        return _rawGet(this.f3402h, i);
    }

    public int rawGetI(int i, long j) {
        return _rawGetI(this.f3402h, i, j);
    }

    public int rawLen(int i) {
        return _rawlen(this.f3402h, i);
    }

    public void rawSet(int i) {
        _rawSet(this.f3402h, i);
    }

    public void rawSetI(int i, long j) {
        _rawSetI(this.f3402h, i, j);
    }

    public int rawequal(int i, int i2) {
        return _rawequal(this.f3402h, i, i2);
    }

    public void remove(int i) {
        _remove(this.f3402h, i);
    }

    public void replace(int i) {
        _replace(this.f3402h, i);
    }

    public int resume(LuaState luaState, int i) {
        return _resume(this.f3402h, luaState.getPointer(), i);
    }

    public void rotate(int i, int i2) {
        _rotate(this.f3402h, i, i2);
    }

    public void setField(int i, String str) {
        _setField(this.f3402h, i, str);
    }

    public synchronized void setGlobal(String str) {
        _setGlobal(this.f3402h, str);
    }

    public void setI(int i, long j) {
        _setI(this.f3402h, i, j);
    }

    public int setMetaTable(int i) {
        return _setMetaTable(this.f3402h, i);
    }

    public void setTable(int i) {
        _setTable(this.f3402h, i);
    }

    public void setTop(int i) {
        _setTop(this.f3402h, i);
    }

    public String setUpValue(int i, int i2) {
        return _setUpValue(this.f3402h, i, i2);
    }

    public void setUserValue(int i) {
        _setUserValue(this.f3402h, i);
    }

    public int status() {
        return _status(this.f3402h);
    }

    public int strLen(int i) {
        return _strlen(this.f3402h, i);
    }

    public boolean toBoolean(int i) {
        return _toBoolean(this.f3402h, i) != 0;
    }

    public byte[] toBuffer(int i) {
        return _toBuffer(this.f3402h, i);
    }

    public long toInteger(int i) {
        return _toInteger(this.f3402h, i);
    }

    public synchronized Object toJavaObject(int i) {
        Object obj;
        obj = null;
        if (isBoolean(i)) {
            obj = Boolean.valueOf(toBoolean(i));
        } else if (type(i) == 4) {
            obj = toString(i);
        } else if (isFunction(i)) {
            obj = getLuaObject(i).getFunction();
        } else if (isTable(i)) {
            obj = getLuaObject(i).getTable();
        } else if (type(i) == 3) {
            obj = isInteger(i) ? Long.valueOf(toInteger(i)) : Double.valueOf(toNumber(i));
        } else if (isUserdata(i)) {
            obj = isObject(i) ? getObjectFromUserdata(i) : getLuaObject(i);
        } else {
            boolean isNil = isNil(i);
        }
        return obj;
    }

    public double toNumber(int i) {
        return _toNumber(this.f3402h, i);
    }

    public String toString(int i) {
        return _toString(this.f3402h, i);
    }

    public LuaState toThread(int i) {
        return new LuaState(_toThread(this.f3402h, i));
    }

    public int type(int i) {
        return _type(this.f3402h, i);
    }

    public String typeName(int i) {
        return _typeName(this.f3402h, i);
    }

    public void xmove(LuaState luaState, int i) {
        _xmove(this.f3402h, luaState.f3402h, i);
    }

    public int yield(int i) {
        return _yield(this.f3402h, i);
    }
}
