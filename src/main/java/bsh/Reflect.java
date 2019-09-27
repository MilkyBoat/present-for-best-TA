package bsh;

import com.androlua.BuildConfig;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Vector;

class Reflect {
    Reflect() {
    }

    /* renamed from: a */
    static int m725a(Class[] clsArr, Class[][] clsArr2) {
        int i = 1;
        while (true) {
            int i2 = -1;
            if (i > 4) {
                return -1;
            }
            Class[] clsArr3 = null;
            for (int i3 = 0; i3 < clsArr2.length; i3++) {
                Class[] clsArr4 = clsArr2[i3];
                if (Types.m761a(clsArr, clsArr4, i) && (clsArr3 == null || Types.m761a(clsArr4, clsArr3, 1))) {
                    i2 = i3;
                    clsArr3 = clsArr4;
                }
            }
            if (clsArr3 != null) {
                return i2;
            }
            i++;
        }
    }

    /* renamed from: a */
    static LHS m726a(Class cls, String str) {
        return new LHS(m749b(cls, str, true));
    }

    /* renamed from: a */
    static LHS m727a(Object obj, String str) {
        if (obj instanceof This) {
            return new LHS(((This) obj).f701a, str, false);
        }
        try {
            return new LHS(obj, m749b(obj.getClass(), str, false));
        } catch (ReflectError e) {
            if (hasObjectPropertySetter(obj.getClass(), str)) {
                return new LHS(obj, str);
            }
            throw e;
        }
    }

    /* renamed from: a */
    private static ReflectError m728a(Class cls, Class[] clsArr) {
        if (clsArr.length == 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Can't find default constructor for: ");
            stringBuffer.append(cls);
            return new ReflectError(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Can't find constructor: ");
        stringBuffer2.append(StringUtil.methodString(cls.getName(), clsArr));
        stringBuffer2.append(" in class: ");
        stringBuffer2.append(cls.getName());
        return new ReflectError(stringBuffer2.toString());
    }

    /* renamed from: a */
    private static Object m729a(Class cls, Object obj, String str, boolean z) {
        try {
            Field b = m749b(cls, str, z);
            return Primitive.wrap(b.get(obj), b.getType());
        } catch (NullPointerException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("???");
            stringBuffer.append(str);
            stringBuffer.append(" is not a static field.");
            throw new ReflectError(stringBuffer.toString());
        } catch (IllegalAccessException unused2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Can't access field: ");
            stringBuffer2.append(str);
            throw new ReflectError(stringBuffer2.toString());
        }
    }

    /* renamed from: a */
    static Object m730a(Class cls, Object[] objArr) {
        if (cls.isInterface()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Can't create instance of an interface: ");
            stringBuffer.append(cls);
            throw new ReflectError(stringBuffer.toString());
        }
        Class[] types = Types.getTypes(objArr);
        Constructor[] declaredConstructors = Capabilities.haveAccessibility() ? cls.getDeclaredConstructors() : cls.getConstructors();
        if (Interpreter.DEBUG) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Looking for most specific constructor: ");
            stringBuffer2.append(cls);
            Interpreter.debug(stringBuffer2.toString());
        }
        Constructor a = m733a(types, declaredConstructors);
        if (a == null) {
            throw m728a(cls, types);
        }
        if (!m744a(a)) {
            try {
                ReflectManager.RMSetAccessible(a);
            } catch (UtilEvalError unused) {
            }
        }
        try {
            Object newInstance = a.newInstance(Primitive.unwrap(objArr));
            if (newInstance != null) {
                return newInstance;
            }
            throw new ReflectError("Couldn't construct the object");
        } catch (InstantiationException unused2) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("The class ");
            stringBuffer3.append(cls);
            stringBuffer3.append(" is abstract ");
            throw new ReflectError(stringBuffer3.toString());
        } catch (IllegalAccessException unused3) {
            throw new ReflectError("We don't have permission to create an instance.Use setAccessibility(true) to enable access.");
        } catch (IllegalArgumentException unused4) {
            throw new ReflectError("The number of arguments was wrong");
        }
    }

    /* renamed from: a */
    static Object m731a(Method method, Object obj, Object[] objArr) {
        int i = 0;
        if (objArr == null) {
            objArr = new Object[0];
        }
        m741a("Invoking method (entry): ", method, objArr);
        Object[] objArr2 = new Object[objArr.length];
        Class[] parameterTypes = method.getParameterTypes();
        while (i < objArr.length) {
            try {
                objArr2[i] = Types.castObject(objArr[i], parameterTypes[i], 1);
                i++;
            } catch (UtilEvalError e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("illegal argument type in method invocation: ");
                stringBuffer.append(e);
                throw new InterpreterError(stringBuffer.toString());
            }
        }
        Object[] unwrap = Primitive.unwrap(objArr2);
        m741a("Invoking method (after massaging values): ", method, unwrap);
        try {
            Object invoke = method.invoke(obj, unwrap);
            if (invoke == null) {
                invoke = Primitive.NULL;
            }
            return Primitive.wrap(invoke, method.getReturnType());
        } catch (IllegalAccessException e2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Cannot access method ");
            stringBuffer2.append(StringUtil.methodString(method.getName(), method.getParameterTypes()));
            stringBuffer2.append(" in '");
            stringBuffer2.append(method.getDeclaringClass());
            stringBuffer2.append("' :");
            stringBuffer2.append(e2);
            throw new ReflectError(stringBuffer2.toString());
        }
    }

    /* renamed from: a */
    private static String m732a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(String.valueOf(Character.toUpperCase(str2.charAt(0))));
        stringBuffer.append(str2.substring(1));
        return stringBuffer.toString();
    }

    /* renamed from: a */
    static Constructor m733a(Class[] clsArr, Constructor[] constructorArr) {
        int b = m747b(clsArr, constructorArr);
        if (b == -1) {
            return null;
        }
        return constructorArr[b];
    }

    /* renamed from: a */
    protected static Field m734a(Class cls, String str, boolean z) {
        try {
            return m749b(cls, str, z);
        } catch (ReflectError unused) {
            return null;
        }
    }

    /* renamed from: a */
    protected static Method m735a(BshClassManager bshClassManager, Class cls, Object obj, String str, Object[] objArr, boolean z) {
        if (obj == Primitive.NULL) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Attempt to invoke method ");
            stringBuffer.append(str);
            stringBuffer.append(" on null value");
            throw new UtilTargetError(new NullPointerException(stringBuffer.toString()));
        }
        Class[] types = Types.getTypes(objArr);
        Method a = m736a(bshClassManager, cls, str, types, z);
        if (a != null) {
            return a;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(z ? "Static method " : "Method ");
        stringBuffer2.append(StringUtil.methodString(str, types));
        stringBuffer2.append(" not found in class'");
        stringBuffer2.append(cls.getName());
        stringBuffer2.append("'");
        throw new ReflectError(stringBuffer2.toString());
    }

    /* renamed from: a */
    protected static Method m736a(BshClassManager bshClassManager, Class cls, String str, Class[] clsArr, boolean z) {
        Method method;
        if (cls == null) {
            throw new InterpreterError("null class");
        }
        Method method2 = null;
        if (bshClassManager == null) {
            Interpreter.debug("resolveJavaMethod UNOPTIMIZED lookup");
        } else {
            method2 = bshClassManager.mo653a(cls, str, clsArr, z);
        }
        if (method2 == null) {
            boolean z2 = !Capabilities.haveAccessibility();
            try {
                method = m737a(cls, str, clsArr, z2);
                m742a(method, z, cls);
                if (method != null && !z2) {
                    try {
                        ReflectManager.RMSetAccessible(method);
                    } catch (UtilEvalError unused) {
                    }
                }
                if (!(method == null || bshClassManager == null)) {
                    bshClassManager.cacheResolvedMethod(cls, clsArr, method);
                    return method;
                }
            } catch (SecurityException e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Security Exception while searching methods of: ");
                stringBuffer.append(cls);
                throw new UtilTargetError(stringBuffer.toString(), e);
            }
        } else {
            method = method2;
        }
        return method;
    }

    /* renamed from: a */
    private static Method m737a(Class cls, String str, Class[] clsArr, boolean z) {
        if (Interpreter.DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Searching for method: ");
            stringBuffer.append(StringUtil.methodString(str, clsArr));
            stringBuffer.append(" in '");
            stringBuffer.append(cls.getName());
            stringBuffer.append("'");
            Interpreter.debug(stringBuffer.toString());
        }
        Method[] a = m746a(cls, str, clsArr.length, z);
        if (Interpreter.DEBUG) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Looking for most specific method: ");
            stringBuffer2.append(str);
            Interpreter.debug(stringBuffer2.toString());
        }
        return m738a(clsArr, a);
    }

    /* renamed from: a */
    static Method m738a(Class[] clsArr, Method[] methodArr) {
        Class[][] clsArr2 = new Class[methodArr.length][];
        for (int i = 0; i < methodArr.length; i++) {
            clsArr2[i] = methodArr[i].getParameterTypes();
        }
        int a = m725a(clsArr, clsArr2);
        if (a == -1) {
            return null;
        }
        return methodArr[a];
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d A[LOOP:0: B:9:0x0020->B:15:0x002d, LOOP_END] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Vector m739a(java.lang.Class r3, java.lang.String r4, int r5, boolean r6, java.util.Vector r7) {
        /*
            if (r7 != 0) goto L_0x0007
            java.util.Vector r7 = new java.util.Vector
            r7.<init>()
        L_0x0007:
            if (r6 == 0) goto L_0x0014
            boolean r0 = m743a(r3)
            if (r0 == 0) goto L_0x001b
            java.lang.reflect.Method[] r0 = r3.getMethods()
            goto L_0x0018
        L_0x0014:
            java.lang.reflect.Method[] r0 = r3.getDeclaredMethods()
        L_0x0018:
            m740a(r0, r4, r5, r6, r7)
        L_0x001b:
            java.lang.Class[] r0 = r3.getInterfaces()
            r1 = 0
        L_0x0020:
            int r2 = r0.length
            if (r1 < r2) goto L_0x002d
            java.lang.Class r3 = r3.getSuperclass()
            if (r3 == 0) goto L_0x002c
            m739a(r3, r4, r5, r6, r7)
        L_0x002c:
            return r7
        L_0x002d:
            r2 = r0[r1]
            m739a(r2, r4, r5, r6, r7)
            int r1 = r1 + 1
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Reflect.m739a(java.lang.Class, java.lang.String, int, boolean, java.util.Vector):java.util.Vector");
    }

    /* renamed from: a */
    private static Vector m740a(Method[] methodArr, String str, int i, boolean z, Vector vector) {
        for (Method method : methodArr) {
            if (method.getName().equals(str) && method.getParameterTypes().length == i && (!z || m745a(method))) {
                vector.add(method);
            }
        }
        return vector;
    }

    /* renamed from: a */
    private static void m741a(String str, Method method, Object[] objArr) {
        if (Interpreter.DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(method);
            stringBuffer.append(" with args:");
            Interpreter.debug(stringBuffer.toString());
            for (int i = 0; i < objArr.length; i++) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("args[");
                stringBuffer2.append(i);
                stringBuffer2.append("] = ");
                stringBuffer2.append(objArr[i]);
                stringBuffer2.append(" type = ");
                stringBuffer2.append(objArr[i].getClass());
                Interpreter.debug(stringBuffer2.toString());
            }
        }
    }

    /* renamed from: a */
    private static void m742a(Method method, boolean z, Class cls) {
        if (method != null && z && !m750b(method)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot reach instance method: ");
            stringBuffer.append(StringUtil.methodString(method.getName(), method.getParameterTypes()));
            stringBuffer.append(" from static context: ");
            stringBuffer.append(cls.getName());
            throw new UtilEvalError(stringBuffer.toString());
        }
    }

    /* renamed from: a */
    private static boolean m743a(Class cls) {
        return Modifier.isPublic(cls.getModifiers());
    }

    /* renamed from: a */
    private static boolean m744a(Constructor constructor) {
        return Modifier.isPublic(constructor.getModifiers());
    }

    /* renamed from: a */
    private static boolean m745a(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    /* renamed from: a */
    static Method[] m746a(Class cls, String str, int i, boolean z) {
        Vector a = m739a(cls, str, i, z, (Vector) null);
        Method[] methodArr = new Method[a.size()];
        a.copyInto(methodArr);
        return methodArr;
    }

    /* renamed from: b */
    static int m747b(Class[] clsArr, Constructor[] constructorArr) {
        Class[][] clsArr2 = new Class[constructorArr.length][];
        for (int i = 0; i < clsArr2.length; i++) {
            clsArr2[i] = constructorArr[i].getParameterTypes();
        }
        return m725a(clsArr, clsArr2);
    }

    /* renamed from: b */
    private static Field m748b(Class cls, String str) {
        try {
            Field field = cls.getField(str);
            ReflectManager.RMSetAccessible(field);
            return field;
        } catch (NoSuchFieldException unused) {
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    ReflectManager.RMSetAccessible(declaredField);
                    return declaredField;
                } catch (NoSuchFieldException unused2) {
                    cls = cls.getSuperclass();
                }
            }
            throw new NoSuchFieldException(str);
        }
    }

    /* renamed from: b */
    protected static Field m749b(Class cls, String str, boolean z) {
        try {
            Field b = Capabilities.haveAccessibility() ? m748b(cls, str) : cls.getField(str);
            if (!z || Modifier.isStatic(b.getModifiers())) {
                return b;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Can't reach instance field: ");
            stringBuffer.append(str);
            stringBuffer.append(" from static context: ");
            stringBuffer.append(cls.getName());
            throw new UtilEvalError(stringBuffer.toString());
        } catch (NoSuchFieldException unused) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("No such field: ");
            stringBuffer2.append(str);
            throw new ReflectError(stringBuffer2.toString());
        } catch (SecurityException e) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Security Exception while searching fields of: ");
            stringBuffer3.append(cls);
            throw new UtilTargetError(stringBuffer3.toString(), e);
        }
    }

    /* renamed from: b */
    private static boolean m750b(Method method) {
        return Modifier.isStatic(method.getModifiers());
    }

    public static Class getArrayBaseType(Class cls) {
        if (cls.isArray()) {
            return cls.getComponentType();
        }
        throw new ReflectError("The class is not an array.");
    }

    public static int getArrayDimensions(Class cls) {
        if (!cls.isArray()) {
            return 0;
        }
        return cls.getName().lastIndexOf(91) + 1;
    }

    public static Object getIndex(Object obj, int i) {
        if (Interpreter.DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("getIndex: ");
            stringBuffer.append(obj);
            stringBuffer.append(", index=");
            stringBuffer.append(i);
            Interpreter.debug(stringBuffer.toString());
        }
        try {
            return Primitive.wrap(Array.get(obj, i), obj.getClass().getComponentType());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UtilTargetError(e);
        } catch (Exception e2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Array access:");
            stringBuffer2.append(e2);
            throw new ReflectError(stringBuffer2.toString());
        }
    }

    public static Object getObjectFieldValue(Object obj, String str) {
        if (obj instanceof This) {
            return ((This) obj).f701a.getVariable(str);
        }
        try {
            return m729a(obj.getClass(), obj, str, false);
        } catch (ReflectError e) {
            if (hasObjectPropertyGetter(obj.getClass(), str)) {
                return getObjectProperty(obj, str);
            }
            throw e;
        }
    }

    public static Object getObjectProperty(Object obj, String str) {
        Object obj2;
        Method method;
        String str2;
        Object[] objArr = new Object[0];
        Interpreter.debug("property access: ");
        Object obj3 = null;
        try {
            method = m735a(null, obj.getClass(), obj, m732a("get", str), objArr, false);
            obj2 = null;
        } catch (Exception e) {
            obj2 = e;
            method = null;
        }
        if (method == null) {
            try {
                Method a = m735a(null, obj.getClass(), obj, m732a("is", str), objArr, false);
                try {
                    method = a.getReturnType() != Boolean.TYPE ? null : a;
                } catch (Exception e2) {
                    method = a;
                    obj3 = e2;
                }
            } catch (Exception e3) {
                obj3 = e3;
            }
        }
        if (method == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error in property getter: ");
            stringBuffer.append(obj2);
            if (obj3 != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(" : ");
                stringBuffer2.append(obj3);
                str2 = stringBuffer2.toString();
            } else {
                str2 = BuildConfig.FLAVOR;
            }
            stringBuffer.append(str2);
            throw new ReflectError(stringBuffer.toString());
        }
        try {
            return m731a(method, obj, objArr);
        } catch (InvocationTargetException e4) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Property accessor threw exception: ");
            stringBuffer3.append(e4.getTargetException());
            throw new UtilEvalError(stringBuffer3.toString());
        }
    }

    public static Object getStaticFieldValue(Class cls, String str) {
        return m729a(cls, (Object) null, str, true);
    }

    public static boolean hasObjectPropertyGetter(Class cls, String str) {
        try {
            cls.getMethod(m732a("get", str), new Class[0]);
            return true;
        } catch (NoSuchMethodException unused) {
            try {
                return cls.getMethod(m732a("is", str), new Class[0]).getReturnType() == Boolean.TYPE;
            } catch (NoSuchMethodException unused2) {
                return false;
            }
        }
    }

    public static boolean hasObjectPropertySetter(Class cls, String str) {
        String a = m732a("set", str);
        Method[] methods = cls.getMethods();
        for (Method name : methods) {
            if (name.getName().equals(a)) {
                return true;
            }
        }
        return false;
    }

    public static Object invokeCompiledCommand(Class cls, Object[] objArr, Interpreter interpreter, CallStack callStack) {
        Object[] objArr2 = new Object[(objArr.length + 2)];
        objArr2[0] = interpreter;
        objArr2[1] = callStack;
        System.arraycopy(objArr, 0, objArr2, 2, objArr.length);
        try {
            return invokeStaticMethod(interpreter.getClassManager(), cls, "invoke", objArr2);
        } catch (InvocationTargetException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error in compiled command: ");
            stringBuffer.append(e.getTargetException());
            throw new UtilEvalError(stringBuffer.toString());
        } catch (ReflectError e2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Error invoking compiled command: ");
            stringBuffer2.append(e2);
            throw new UtilEvalError(stringBuffer2.toString());
        }
    }

    public static Object invokeObjectMethod(Object obj, String str, Object[] objArr, Interpreter interpreter, CallStack callStack, SimpleNode simpleNode) {
        BshClassManager classManager;
        if ((obj instanceof This) && !This.m752a(str)) {
            return ((This) obj).invokeMethod(str, objArr, interpreter, callStack, simpleNode, false);
        }
        if (interpreter == null) {
            classManager = null;
        } else {
            try {
                classManager = interpreter.getClassManager();
            } catch (UtilEvalError e) {
                throw e.toEvalError(simpleNode, callStack);
            }
        }
        return m731a(m735a(classManager, obj.getClass(), obj, str, objArr, false), obj, objArr);
    }

    public static Object invokeStaticMethod(BshClassManager bshClassManager, Class cls, String str, Object[] objArr) {
        Interpreter.debug("invoke static Method");
        return m731a(m735a(bshClassManager, cls, null, str, objArr, true), (Object) null, objArr);
    }

    public static String normalizeClassName(Class cls) {
        if (!cls.isArray()) {
            return cls.getName();
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(getArrayBaseType(cls).getName());
            stringBuffer2.append(" ");
            stringBuffer.append(stringBuffer2.toString());
            for (int i = 0; i < getArrayDimensions(cls); i++) {
                stringBuffer.append("[]");
            }
        } catch (ReflectError unused) {
        }
        return stringBuffer.toString();
    }

    public static void setIndex(Object obj, int i, Object obj2) {
        try {
            Array.set(obj, i, Primitive.unwrap(obj2));
        } catch (ArrayStoreException e) {
            throw new UtilTargetError(e);
        } catch (IllegalArgumentException e2) {
            throw new UtilTargetError(new ArrayStoreException(e2.toString()));
        } catch (Exception e3) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Array access:");
            stringBuffer.append(e3);
            throw new ReflectError(stringBuffer.toString());
        }
    }

    public static void setObjectProperty(Object obj, String str, Object obj2) {
        String a = m732a("set", str);
        Object[] objArr = {obj2};
        Interpreter.debug("property access: ");
        try {
            m731a(m735a(null, obj.getClass(), obj, a, objArr, false), obj, objArr);
        } catch (InvocationTargetException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Property accessor threw exception: ");
            stringBuffer.append(e.getTargetException());
            throw new UtilEvalError(stringBuffer.toString());
        }
    }
}
