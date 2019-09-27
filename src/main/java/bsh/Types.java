package bsh;

class Types {

    /* renamed from: a */
    static Primitive f704a = new Primitive(1);

    /* renamed from: b */
    static Primitive f705b = new Primitive(-1);

    /* renamed from: c */
    static Class f706c;

    /* renamed from: d */
    static Class f707d;

    /* renamed from: e */
    static Class f708e;

    /* renamed from: f */
    static Class f709f;

    Types() {
    }

    /* renamed from: a */
    static UtilEvalError m755a(Class cls, Class cls2, int i) {
        return m756a(Reflect.normalizeClassName(cls), Reflect.normalizeClassName(cls2), i);
    }

    /* renamed from: a */
    static UtilEvalError m756a(String str, String str2, int i) {
        if (i == 1) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Can't assign ");
            stringBuffer.append(str2);
            stringBuffer.append(" to ");
            stringBuffer.append(str);
            return new UtilEvalError(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Cannot cast ");
        stringBuffer2.append(str2);
        stringBuffer2.append(" to ");
        stringBuffer2.append(str);
        return new UtilTargetError(new ClassCastException(stringBuffer2.toString()));
    }

    /* renamed from: a */
    static Class m757a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* renamed from: a */
    private static Object m758a(Class cls, Class cls2, Object obj, int i, boolean z) {
        Class cls3;
        Class cls4;
        Class cls5;
        if (z && obj != null) {
            throw new InterpreterError("bad cast params 1");
        } else if (z || obj != null) {
            if (f708e == null) {
                cls3 = m757a("bsh.Primitive");
                f708e = cls3;
            } else {
                cls3 = f708e;
            }
            if (cls2 == cls3) {
                throw new InterpreterError("bad from Type, need to unwrap");
            } else if (obj == Primitive.NULL && cls2 != null) {
                throw new InterpreterError("inconsistent args 1");
            } else if (obj == Primitive.VOID && cls2 != Void.TYPE) {
                throw new InterpreterError("inconsistent args 2");
            } else if (cls == Void.TYPE) {
                throw new InterpreterError("loose toType should be null");
            } else if (cls == null || cls == cls2) {
                if (z) {
                    obj = f704a;
                }
                return obj;
            } else {
                if (cls.isPrimitive()) {
                    if (!(cls2 == Void.TYPE || cls2 == null || cls2.isPrimitive())) {
                        if (Primitive.isWrapperType(cls2)) {
                            Class unboxType = Primitive.unboxType(cls2);
                            return Primitive.m713a(cls, unboxType, z ? null : (Primitive) Primitive.wrap(obj, unboxType), z, i);
                        } else if (z) {
                            return f705b;
                        } else {
                            throw m755a(cls, cls2, i);
                        }
                    }
                } else if (cls2 == Void.TYPE || cls2 == null || cls2.isPrimitive()) {
                    if (Primitive.isWrapperType(cls) && cls2 != Void.TYPE && cls2 != null) {
                        return z ? f704a : Primitive.m716a(Primitive.unboxType(cls), ((Primitive) obj).getValue());
                    }
                    if (f706c == null) {
                        cls4 = m757a("java.lang.Object");
                        f706c = cls4;
                    } else {
                        cls4 = f706c;
                    }
                    if (!(cls != cls4 || cls2 == Void.TYPE || cls2 == null)) {
                        return z ? f704a : ((Primitive) obj).getValue();
                    }
                } else if (cls.isAssignableFrom(cls2)) {
                    if (z) {
                        obj = f704a;
                    }
                    return obj;
                } else {
                    if (cls.isInterface()) {
                        if (f709f == null) {
                            cls5 = m757a("bsh.This");
                            f709f = cls5;
                        } else {
                            cls5 = f709f;
                        }
                        if (cls5.isAssignableFrom(cls2) && Capabilities.canGenerateInterfaces()) {
                            return z ? f704a : ((This) obj).getInterface(cls);
                        }
                    }
                    if (Primitive.isWrapperType(cls) && Primitive.isWrapperType(cls2)) {
                        return z ? f704a : Primitive.m716a(cls, obj);
                    }
                    if (z) {
                        return f705b;
                    }
                    throw m755a(cls, cls2, i);
                }
                return Primitive.m713a(cls, cls2, (Primitive) obj, z, i);
            }
        } else {
            throw new InterpreterError("bad cast params 2");
        }
    }

    /* renamed from: a */
    static boolean m759a(Class cls, Class cls2) {
        return m762b(cls, cls2) || m763c(cls, cls2);
    }

    /* renamed from: a */
    private static boolean m760a(Class[] clsArr, Class[] clsArr2) {
        return false;
    }

    /* renamed from: a */
    static boolean m761a(Class[] clsArr, Class[] clsArr2, int i) {
        if (i != 3 && clsArr.length != clsArr2.length) {
            return false;
        }
        switch (i) {
            case 1:
                for (int i2 = 0; i2 < clsArr.length; i2++) {
                    if (!m762b(clsArr2[i2], clsArr[i2])) {
                        return false;
                    }
                }
                return true;
            case 2:
                for (int i3 = 0; i3 < clsArr.length; i3++) {
                    if (!m763c(clsArr2[i3], clsArr[i3])) {
                        return false;
                    }
                }
                return true;
            case 3:
                return m760a(clsArr, clsArr2);
            case 4:
                for (int i4 = 0; i4 < clsArr.length; i4++) {
                    if (!m764d(clsArr2[i4], clsArr[i4])) {
                        return false;
                    }
                }
                return true;
            default:
                throw new InterpreterError("bad case");
        }
    }

    /* renamed from: b */
    static boolean m762b(Class cls, Class cls2) {
        if (cls == null) {
            return false;
        }
        if (cls2 == null) {
            return !cls.isPrimitive();
        }
        if (!cls.isPrimitive() || !cls2.isPrimitive()) {
            if (cls.isAssignableFrom(cls2)) {
                return true;
            }
        } else if (cls == cls2) {
            return true;
        } else {
            if (cls2 == Byte.TYPE && (cls == Short.TYPE || cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE)) {
                return true;
            }
            if (cls2 == Short.TYPE && (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE)) {
                return true;
            }
            if (cls2 == Character.TYPE && (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE)) {
                return true;
            }
            if (cls2 == Integer.TYPE && (cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE)) {
                return true;
            }
            if (cls2 == Long.TYPE && (cls == Float.TYPE || cls == Double.TYPE)) {
                return true;
            }
            return cls2 == Float.TYPE && cls == Double.TYPE;
        }
    }

    /* renamed from: c */
    static boolean m763c(Class cls, Class cls2) {
        Class cls3;
        Class cls4;
        if (cls == null) {
            return false;
        }
        if (f706c == null) {
            cls3 = m757a("java.lang.Object");
            f706c = cls3;
        } else {
            cls3 = f706c;
        }
        if (cls == cls3) {
            return true;
        }
        if (f707d == null) {
            cls4 = m757a("java.lang.Number");
            f707d = cls4;
        } else {
            cls4 = f707d;
        }
        return !(cls != cls4 || cls2 == Character.TYPE || cls2 == Boolean.TYPE) || Primitive.f681a.get(cls) == cls2;
    }

    public static Object castObject(Object obj, Class cls, int i) {
        if (obj == null) {
            throw new InterpreterError("null fromValue");
        }
        return m758a(cls, obj instanceof Primitive ? ((Primitive) obj).getType() : obj.getClass(), obj, i, false);
    }

    /* renamed from: d */
    static boolean m764d(Class cls, Class cls2) {
        try {
            return m758a(cls, cls2, null, 1, true) == f704a;
        } catch (UtilEvalError e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("err in cast check: ");
            stringBuffer.append(e);
            throw new InterpreterError(stringBuffer.toString());
        }
    }

    public static Class[] getTypes(Object[] objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] == null) {
                clsArr[i] = null;
            } else if (objArr[i] instanceof Primitive) {
                clsArr[i] = objArr[i].getType();
            } else {
                clsArr[i] = objArr[i].getClass();
            }
        }
        return clsArr;
    }
}
