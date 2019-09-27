package bsh;

import java.io.Serializable;
import java.util.Hashtable;

public final class Primitive implements ParserConstants, Serializable {
    public static final Primitive NULL = new Primitive((Object) Special.NULL_VALUE);
    public static final Primitive VOID = new Primitive((Object) Special.VOID_TYPE);

    /* renamed from: a */
    static Hashtable f681a = new Hashtable();

    /* renamed from: b */
    static Class f682b;

    /* renamed from: c */
    static Class f683c;

    /* renamed from: d */
    static Class f684d;

    /* renamed from: e */
    static Class f685e;

    /* renamed from: f */
    static Class f686f;

    /* renamed from: g */
    static Class f687g;

    /* renamed from: h */
    static Class f688h;

    /* renamed from: i */
    static Class f689i;

    /* renamed from: j */
    static Class f690j;

    /* renamed from: k */
    private Object f691k;

    private static class Special implements Serializable {
        public static final Special NULL_VALUE = new Special();
        public static final Special VOID_TYPE = new Special();

        private Special() {
        }
    }

    static {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        Class cls5;
        Class cls6;
        Class cls7;
        Class cls8;
        Class cls9;
        Class cls10;
        Class cls11;
        Class cls12;
        Class cls13;
        Class cls14;
        Class cls15;
        Class cls16;
        Hashtable hashtable = f681a;
        Class cls17 = Boolean.TYPE;
        if (f682b == null) {
            cls = m715a("java.lang.Boolean");
            f682b = cls;
        } else {
            cls = f682b;
        }
        hashtable.put(cls17, cls);
        Hashtable hashtable2 = f681a;
        Class cls18 = Byte.TYPE;
        if (f683c == null) {
            cls2 = m715a("java.lang.Byte");
            f683c = cls2;
        } else {
            cls2 = f683c;
        }
        hashtable2.put(cls18, cls2);
        Hashtable hashtable3 = f681a;
        Class cls19 = Short.TYPE;
        if (f684d == null) {
            cls3 = m715a("java.lang.Short");
            f684d = cls3;
        } else {
            cls3 = f684d;
        }
        hashtable3.put(cls19, cls3);
        Hashtable hashtable4 = f681a;
        Class cls20 = Character.TYPE;
        if (f685e == null) {
            cls4 = m715a("java.lang.Character");
            f685e = cls4;
        } else {
            cls4 = f685e;
        }
        hashtable4.put(cls20, cls4);
        Hashtable hashtable5 = f681a;
        Class cls21 = Integer.TYPE;
        if (f686f == null) {
            cls5 = m715a("java.lang.Integer");
            f686f = cls5;
        } else {
            cls5 = f686f;
        }
        hashtable5.put(cls21, cls5);
        Hashtable hashtable6 = f681a;
        Class cls22 = Long.TYPE;
        if (f687g == null) {
            cls6 = m715a("java.lang.Long");
            f687g = cls6;
        } else {
            cls6 = f687g;
        }
        hashtable6.put(cls22, cls6);
        Hashtable hashtable7 = f681a;
        Class cls23 = Float.TYPE;
        if (f688h == null) {
            cls7 = m715a("java.lang.Float");
            f688h = cls7;
        } else {
            cls7 = f688h;
        }
        hashtable7.put(cls23, cls7);
        Hashtable hashtable8 = f681a;
        Class cls24 = Double.TYPE;
        if (f689i == null) {
            cls8 = m715a("java.lang.Double");
            f689i = cls8;
        } else {
            cls8 = f689i;
        }
        hashtable8.put(cls24, cls8);
        Hashtable hashtable9 = f681a;
        if (f682b == null) {
            cls9 = m715a("java.lang.Boolean");
            f682b = cls9;
        } else {
            cls9 = f682b;
        }
        hashtable9.put(cls9, Boolean.TYPE);
        Hashtable hashtable10 = f681a;
        if (f683c == null) {
            cls10 = m715a("java.lang.Byte");
            f683c = cls10;
        } else {
            cls10 = f683c;
        }
        hashtable10.put(cls10, Byte.TYPE);
        Hashtable hashtable11 = f681a;
        if (f684d == null) {
            cls11 = m715a("java.lang.Short");
            f684d = cls11;
        } else {
            cls11 = f684d;
        }
        hashtable11.put(cls11, Short.TYPE);
        Hashtable hashtable12 = f681a;
        if (f685e == null) {
            cls12 = m715a("java.lang.Character");
            f685e = cls12;
        } else {
            cls12 = f685e;
        }
        hashtable12.put(cls12, Character.TYPE);
        Hashtable hashtable13 = f681a;
        if (f686f == null) {
            cls13 = m715a("java.lang.Integer");
            f686f = cls13;
        } else {
            cls13 = f686f;
        }
        hashtable13.put(cls13, Integer.TYPE);
        Hashtable hashtable14 = f681a;
        if (f687g == null) {
            cls14 = m715a("java.lang.Long");
            f687g = cls14;
        } else {
            cls14 = f687g;
        }
        hashtable14.put(cls14, Long.TYPE);
        Hashtable hashtable15 = f681a;
        if (f688h == null) {
            cls15 = m715a("java.lang.Float");
            f688h = cls15;
        } else {
            cls15 = f688h;
        }
        hashtable15.put(cls15, Float.TYPE);
        Hashtable hashtable16 = f681a;
        if (f689i == null) {
            cls16 = m715a("java.lang.Double");
            f689i = cls16;
        } else {
            cls16 = f689i;
        }
        hashtable16.put(cls16, Double.TYPE);
    }

    public Primitive(byte b) {
        this((Object) new Byte(b));
    }

    public Primitive(char c) {
        this((Object) new Character(c));
    }

    public Primitive(double d) {
        this((Object) new Double(d));
    }

    public Primitive(float f) {
        this((Object) new Float(f));
    }

    public Primitive(int i) {
        this((Object) new Integer(i));
    }

    public Primitive(long j) {
        this((Object) new Long(j));
    }

    public Primitive(Object obj) {
        if (obj == null) {
            throw new InterpreterError("Use Primitve.NULL instead of Primitive(null)");
        } else if (obj == Special.NULL_VALUE || obj == Special.VOID_TYPE || isWrapperType(obj.getClass())) {
            this.f691k = obj;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Not a wrapper type: ");
            stringBuffer.append(obj);
            throw new InterpreterError(stringBuffer.toString());
        }
    }

    public Primitive(short s) {
        this((Object) new Short(s));
    }

    public Primitive(boolean z) {
        this((Object) new Boolean(z));
    }

    /* renamed from: a */
    static double m709a(Double d, int i) {
        double doubleValue = d.doubleValue();
        switch (i) {
            case 102:
                return doubleValue;
            case 103:
                return -doubleValue;
            default:
                throw new InterpreterError("bad double unaryOperation");
        }
    }

    /* renamed from: a */
    static float m710a(Float f, int i) {
        float floatValue = f.floatValue();
        switch (i) {
            case 102:
                return floatValue;
            case 103:
                return -floatValue;
            default:
                throw new InterpreterError("bad float unaryOperation");
        }
    }

    /* renamed from: a */
    static int m711a(Integer num, int i) {
        int intValue = num.intValue();
        if (i == 87) {
            return intValue ^ -1;
        }
        switch (i) {
            case 100:
                return intValue + 1;
            case 101:
                return intValue - 1;
            case 102:
                break;
            case 103:
                intValue = -intValue;
                break;
            default:
                throw new InterpreterError("bad integer unaryOperation");
        }
        return intValue;
    }

    /* renamed from: a */
    static long m712a(Long l, int i) {
        long longValue = l.longValue();
        if (i == 87) {
            return longValue ^ -1;
        }
        switch (i) {
            case 100:
                return longValue + 1;
            case 101:
                return longValue - 1;
            case 102:
                return longValue;
            case 103:
                return -longValue;
            default:
                throw new InterpreterError("bad long unaryOperation");
        }
    }

    /* renamed from: a */
    static Primitive m713a(Class cls, Class cls2, Primitive primitive, boolean z, int i) {
        if (z && primitive != null) {
            throw new InterpreterError("bad cast param 1");
        } else if (!z && primitive == null) {
            throw new InterpreterError("bad cast param 2");
        } else if (cls2 != null && !cls2.isPrimitive()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("bad fromType:");
            stringBuffer.append(cls2);
            throw new InterpreterError(stringBuffer.toString());
        } else if (primitive == NULL && cls2 != null) {
            throw new InterpreterError("inconsistent args 1");
        } else if (primitive == VOID && cls2 != Void.TYPE) {
            throw new InterpreterError("inconsistent args 2");
        } else if (cls2 != Void.TYPE) {
            Object obj = null;
            if (primitive != null) {
                obj = primitive.getValue();
            }
            if (cls.isPrimitive()) {
                if (cls2 == null) {
                    if (z) {
                        return Types.f705b;
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("primitive type:");
                    stringBuffer2.append(cls);
                    throw Types.m756a(stringBuffer2.toString(), "Null value", i);
                } else if (cls2 == Boolean.TYPE) {
                    if (cls == Boolean.TYPE) {
                        if (z) {
                            primitive = Types.f704a;
                        }
                        return primitive;
                    } else if (z) {
                        return Types.f705b;
                    } else {
                        throw Types.m755a(cls, cls2, i);
                    }
                } else if (i != 1 || Types.m759a(cls, cls2)) {
                    return z ? Types.f704a : new Primitive(m716a(cls, obj));
                } else {
                    if (z) {
                        return Types.f705b;
                    }
                    throw Types.m755a(cls, cls2, i);
                }
            } else if (cls2 == null) {
                return z ? Types.f704a : NULL;
            } else {
                if (z) {
                    return Types.f705b;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("object type:");
                stringBuffer3.append(cls);
                throw Types.m756a(stringBuffer3.toString(), "primitive value", i);
            }
        } else if (z) {
            return Types.f705b;
        } else {
            throw Types.m756a(Reflect.normalizeClassName(cls), "void value", i);
        }
    }

    /* renamed from: a */
    static Boolean m714a(Boolean bool, Boolean bool2, int i) {
        boolean booleanValue = bool.booleanValue();
        boolean booleanValue2 = bool2.booleanValue();
        boolean z = false;
        if (i != 90) {
            switch (i) {
                case 95:
                    if (booleanValue != booleanValue2) {
                        z = true;
                    }
                    return new Boolean(z);
                case 96:
                case 97:
                    if (booleanValue || booleanValue2) {
                        z = true;
                    }
                    return new Boolean(z);
                case 98:
                case 99:
                    if (booleanValue && booleanValue2) {
                        z = true;
                    }
                    return new Boolean(z);
                default:
                    throw new InterpreterError("unimplemented binary operator");
            }
        } else {
            if (booleanValue == booleanValue2) {
                z = true;
            }
            return new Boolean(z);
        }
    }

    /* renamed from: a */
    static Class m715a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* renamed from: a */
    static Object m716a(Class cls, Object obj) {
        if (!cls.isPrimitive()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("invalid type in castWrapper: ");
            stringBuffer.append(cls);
            throw new InterpreterError(stringBuffer.toString());
        } else if (obj == null) {
            throw new InterpreterError("null value in castWrapper, guard");
        } else if (!(obj instanceof Boolean)) {
            if (obj instanceof Character) {
                obj = new Integer(((Character) obj).charValue());
            }
            if (!(obj instanceof Number)) {
                throw new InterpreterError("bad type in cast");
            }
            Number number = (Number) obj;
            if (cls == Byte.TYPE) {
                return new Byte(number.byteValue());
            }
            if (cls == Short.TYPE) {
                return new Short(number.shortValue());
            }
            if (cls == Character.TYPE) {
                return new Character((char) number.intValue());
            }
            if (cls == Integer.TYPE) {
                return new Integer(number.intValue());
            }
            if (cls == Long.TYPE) {
                return new Long(number.longValue());
            }
            if (cls == Float.TYPE) {
                return new Float(number.floatValue());
            }
            if (cls == Double.TYPE) {
                return new Double(number.doubleValue());
            }
            throw new InterpreterError("error in wrapper cast");
        } else if (cls == Boolean.TYPE) {
            return obj;
        } else {
            throw new InterpreterError("bad wrapper cast of boolean");
        }
    }

    /* renamed from: a */
    static Object m717a(Double d, Double d2, int i) {
        double doubleValue = d.doubleValue();
        double doubleValue2 = d2.doubleValue();
        boolean z = false;
        switch (i) {
            case 82:
            case 83:
                if (doubleValue > doubleValue2) {
                    z = true;
                }
                return new Boolean(z);
            case 84:
            case 85:
                if (doubleValue < doubleValue2) {
                    z = true;
                }
                return new Boolean(z);
            default:
                switch (i) {
                    case 90:
                        if (doubleValue == doubleValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    case 91:
                    case 92:
                        if (doubleValue <= doubleValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    case 93:
                    case 94:
                        if (doubleValue >= doubleValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    case 95:
                        if (doubleValue != doubleValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    default:
                        switch (i) {
                            case 102:
                                return new Double(doubleValue + doubleValue2);
                            case 103:
                                return new Double(doubleValue - doubleValue2);
                            case 104:
                                return new Double(doubleValue * doubleValue2);
                            case 105:
                                return new Double(doubleValue / doubleValue2);
                            default:
                                switch (i) {
                                    case 111:
                                        return new Double(doubleValue % doubleValue2);
                                    case 112:
                                    case 113:
                                    case 114:
                                    case 115:
                                    case 116:
                                    case 117:
                                        throw new UtilEvalError("Can't shift doubles");
                                    default:
                                        throw new InterpreterError("Unimplemented binary double operator");
                                }
                        }
                }
        }
    }

    /* renamed from: a */
    static Object m718a(Float f, Float f2, int i) {
        float floatValue = f.floatValue();
        float floatValue2 = f2.floatValue();
        boolean z = false;
        switch (i) {
            case 82:
            case 83:
                if (floatValue > floatValue2) {
                    z = true;
                }
                return new Boolean(z);
            case 84:
            case 85:
                if (floatValue < floatValue2) {
                    z = true;
                }
                return new Boolean(z);
            default:
                switch (i) {
                    case 90:
                        if (floatValue == floatValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    case 91:
                    case 92:
                        if (floatValue <= floatValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    case 93:
                    case 94:
                        if (floatValue >= floatValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    case 95:
                        if (floatValue != floatValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    default:
                        switch (i) {
                            case 102:
                                return new Float(floatValue + floatValue2);
                            case 103:
                                return new Float(floatValue - floatValue2);
                            case 104:
                                return new Float(floatValue * floatValue2);
                            case 105:
                                return new Float(floatValue / floatValue2);
                            default:
                                switch (i) {
                                    case 111:
                                        return new Float(floatValue % floatValue2);
                                    case 112:
                                    case 113:
                                    case 114:
                                    case 115:
                                    case 116:
                                    case 117:
                                        throw new UtilEvalError("Can't shift floats ");
                                    default:
                                        throw new InterpreterError("Unimplemented binary float operator");
                                }
                        }
                }
        }
    }

    /* renamed from: a */
    static Object m719a(Integer num, Integer num2, int i) {
        int intValue = num.intValue();
        int intValue2 = num2.intValue();
        boolean z = false;
        switch (i) {
            case 82:
            case 83:
                if (intValue > intValue2) {
                    z = true;
                }
                return new Boolean(z);
            case 84:
            case 85:
                if (intValue < intValue2) {
                    z = true;
                }
                return new Boolean(z);
            default:
                switch (i) {
                    case 90:
                        if (intValue == intValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    case 91:
                    case 92:
                        if (intValue <= intValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    case 93:
                    case 94:
                        if (intValue >= intValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    case 95:
                        if (intValue != intValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    default:
                        switch (i) {
                            case 102:
                                return new Integer(intValue + intValue2);
                            case 103:
                                return new Integer(intValue - intValue2);
                            case 104:
                                return new Integer(intValue * intValue2);
                            case 105:
                                return new Integer(intValue / intValue2);
                            case 106:
                            case 107:
                                return new Integer(intValue & intValue2);
                            case 108:
                            case 109:
                                return new Integer(intValue | intValue2);
                            case 110:
                                return new Integer(intValue ^ intValue2);
                            case 111:
                                return new Integer(intValue % intValue2);
                            case 112:
                            case 113:
                                return new Integer(intValue << intValue2);
                            case 114:
                            case 115:
                                return new Integer(intValue >> intValue2);
                            case 116:
                            case 117:
                                return new Integer(intValue >>> intValue2);
                            default:
                                throw new InterpreterError("Unimplemented binary integer operator");
                        }
                }
        }
    }

    /* renamed from: a */
    static Object m720a(Long l, Long l2, int i) {
        long longValue = l.longValue();
        long longValue2 = l2.longValue();
        boolean z = false;
        switch (i) {
            case 82:
            case 83:
                if (longValue > longValue2) {
                    z = true;
                }
                return new Boolean(z);
            case 84:
            case 85:
                if (longValue < longValue2) {
                    z = true;
                }
                return new Boolean(z);
            default:
                switch (i) {
                    case 90:
                        if (longValue == longValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    case 91:
                    case 92:
                        if (longValue <= longValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    case 93:
                    case 94:
                        if (longValue >= longValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    case 95:
                        if (longValue != longValue2) {
                            z = true;
                        }
                        return new Boolean(z);
                    default:
                        switch (i) {
                            case 102:
                                return new Long(longValue + longValue2);
                            case 103:
                                return new Long(longValue - longValue2);
                            case 104:
                                return new Long(longValue * longValue2);
                            case 105:
                                return new Long(longValue / longValue2);
                            case 106:
                            case 107:
                                return new Long(longValue & longValue2);
                            case 108:
                            case 109:
                                return new Long(longValue | longValue2);
                            case 110:
                                return new Long(longValue ^ longValue2);
                            case 111:
                                return new Long(longValue % longValue2);
                            case 112:
                            case 113:
                                return new Long(longValue << ((int) longValue2));
                            case 114:
                            case 115:
                                return new Long(longValue >> ((int) longValue2));
                            case 116:
                            case 117:
                                return new Long(longValue >>> ((int) longValue2));
                            default:
                                throw new InterpreterError("Unimplemented binary long operator");
                        }
                }
        }
    }

    /* renamed from: a */
    static Object m721a(Object obj) {
        return obj instanceof Character ? new Integer(((Character) obj).charValue()) : ((obj instanceof Byte) || (obj instanceof Short)) ? new Integer(((Number) obj).intValue()) : obj;
    }

    /* renamed from: a */
    static Object m722a(Object obj, Object obj2, int i) {
        if (obj instanceof Boolean) {
            return m714a((Boolean) obj, (Boolean) obj2, i);
        }
        if (obj instanceof Integer) {
            return m719a((Integer) obj, (Integer) obj2, i);
        }
        if (obj instanceof Long) {
            return m720a((Long) obj, (Long) obj2, i);
        }
        if (obj instanceof Float) {
            return m718a((Float) obj, (Float) obj2, i);
        }
        if (obj instanceof Double) {
            return m717a((Double) obj, (Double) obj2, i);
        }
        throw new UtilEvalError("Invalid types in binary operator");
    }

    /* renamed from: a */
    static boolean m723a(Boolean bool, int i) {
        boolean booleanValue = bool.booleanValue();
        if (i == 86) {
            return !booleanValue;
        }
        throw new UtilEvalError("Operator inappropriate for boolean");
    }

    /* renamed from: a */
    static Object[] m724a(Object obj, Object obj2) {
        Object a = m721a(obj);
        Object a2 = m721a(obj2);
        if ((a instanceof Number) && (a2 instanceof Number)) {
            Number number = (Number) a;
            Number number2 = (Number) a2;
            boolean z = number instanceof Double;
            if (!z && !(number2 instanceof Double)) {
                boolean z2 = number instanceof Float;
                if (!z2 && !(number2 instanceof Float)) {
                    boolean z3 = number instanceof Long;
                    if (z3 || (number2 instanceof Long)) {
                        if (z3) {
                            a2 = new Long(number2.longValue());
                        } else {
                            a = new Long(number.longValue());
                        }
                    }
                } else if (z2) {
                    a2 = new Float(number2.floatValue());
                } else {
                    a = new Float(number.floatValue());
                }
            } else if (z) {
                a2 = new Double(number2.doubleValue());
            } else {
                a = new Double(number.doubleValue());
            }
        }
        return new Object[]{a, a2};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008f, code lost:
        if (r1 != r5) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object binaryOperation(java.lang.Object r4, java.lang.Object r5, int r6) {
        /*
            bsh.Primitive r0 = NULL
            if (r4 == r0) goto L_0x00ad
            bsh.Primitive r0 = NULL
            if (r5 != r0) goto L_0x000a
            goto L_0x00ad
        L_0x000a:
            bsh.Primitive r0 = VOID
            if (r4 == r0) goto L_0x00a5
            bsh.Primitive r0 = VOID
            if (r5 != r0) goto L_0x0014
            goto L_0x00a5
        L_0x0014:
            java.lang.Class r0 = r4.getClass()
            java.lang.Class r1 = r5.getClass()
            boolean r2 = r4 instanceof bsh.Primitive
            if (r2 == 0) goto L_0x0026
            bsh.Primitive r4 = (bsh.Primitive) r4
            java.lang.Object r4 = r4.getValue()
        L_0x0026:
            boolean r2 = r5 instanceof bsh.Primitive
            if (r2 == 0) goto L_0x0030
            bsh.Primitive r5 = (bsh.Primitive) r5
            java.lang.Object r5 = r5.getValue()
        L_0x0030:
            java.lang.Object[] r4 = m724a(r4, r5)
            r5 = 0
            r5 = r4[r5]
            r2 = 1
            r4 = r4[r2]
            java.lang.Class r2 = r5.getClass()
            java.lang.Class r3 = r4.getClass()
            if (r2 == r3) goto L_0x006b
            bsh.UtilEvalError r6 = new bsh.UtilEvalError
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "Type mismatch in operator.  "
            r0.append(r1)
            java.lang.Class r5 = r5.getClass()
            r0.append(r5)
            java.lang.String r5 = " cannot be used with "
            r0.append(r5)
            java.lang.Class r4 = r4.getClass()
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r6.<init>(r4)
            throw r6
        L_0x006b:
            java.lang.Object r4 = m722a(r5, r4, r6)     // Catch:{ ArithmeticException -> 0x009c }
            java.lang.Class r5 = f690j
            if (r5 != 0) goto L_0x007c
            java.lang.String r5 = "bsh.Primitive"
            java.lang.Class r5 = m715a(r5)
            f690j = r5
            goto L_0x007e
        L_0x007c:
            java.lang.Class r5 = f690j
        L_0x007e:
            if (r0 != r5) goto L_0x0091
            java.lang.Class r5 = f690j
            if (r5 != 0) goto L_0x008d
            java.lang.String r5 = "bsh.Primitive"
            java.lang.Class r5 = m715a(r5)
            f690j = r5
            goto L_0x008f
        L_0x008d:
            java.lang.Class r5 = f690j
        L_0x008f:
            if (r1 == r5) goto L_0x0095
        L_0x0091:
            boolean r5 = r4 instanceof java.lang.Boolean
            if (r5 == 0) goto L_0x009b
        L_0x0095:
            bsh.Primitive r5 = new bsh.Primitive
            r5.<init>(r4)
            return r5
        L_0x009b:
            return r4
        L_0x009c:
            r4 = move-exception
            bsh.UtilTargetError r5 = new bsh.UtilTargetError
            java.lang.String r6 = "Arithemetic Exception in binary op"
            r5.<init>(r6, r4)
            throw r5
        L_0x00a5:
            bsh.UtilEvalError r4 = new bsh.UtilEvalError
            java.lang.String r5 = "Undefined variable, class, or 'void' literal in binary operation"
            r4.<init>(r5)
            throw r4
        L_0x00ad:
            bsh.UtilEvalError r4 = new bsh.UtilEvalError
            java.lang.String r5 = "Null value or 'null' literal in binary operation"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Primitive.binaryOperation(java.lang.Object, java.lang.Object, int):java.lang.Object");
    }

    public static Class boxType(Class cls) {
        Class cls2 = (Class) f681a.get(cls);
        if (cls2 != null) {
            return cls2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Not a primitive type: ");
        stringBuffer.append(cls);
        throw new InterpreterError(stringBuffer.toString());
    }

    public static Primitive getDefaultValue(Class cls) {
        if (cls == null || !cls.isPrimitive()) {
            return NULL;
        }
        if (cls == Boolean.TYPE) {
            return new Primitive(false);
        }
        try {
            return new Primitive(0).castToType(cls, 0);
        } catch (UtilEvalError unused) {
            throw new InterpreterError("bad cast");
        }
    }

    public static boolean isWrapperType(Class cls) {
        return f681a.get(cls) != null && !cls.isPrimitive();
    }

    public static Primitive unaryOperation(Primitive primitive, int i) {
        if (primitive == NULL) {
            throw new UtilEvalError("illegal use of null object or 'null' literal");
        } else if (primitive == VOID) {
            throw new UtilEvalError("illegal use of undefined object or 'void' literal");
        } else {
            Class type = primitive.getType();
            Object a = m721a(primitive.getValue());
            if (a instanceof Boolean) {
                return new Primitive(m723a((Boolean) a, i));
            }
            if (a instanceof Integer) {
                int a2 = m711a((Integer) a, i);
                if (i == 100 || i == 101) {
                    if (type == Byte.TYPE) {
                        return new Primitive((byte) a2);
                    }
                    if (type == Short.TYPE) {
                        return new Primitive((short) a2);
                    }
                    if (type == Character.TYPE) {
                        return new Primitive((char) a2);
                    }
                }
                return new Primitive(a2);
            } else if (a instanceof Long) {
                return new Primitive(m712a((Long) a, i));
            } else {
                if (a instanceof Float) {
                    return new Primitive(m710a((Float) a, i));
                }
                if (a instanceof Double) {
                    return new Primitive(m709a((Double) a, i));
                }
                throw new InterpreterError("An error occurred.  Please call technical support.");
            }
        }
    }

    public static Class unboxType(Class cls) {
        Class cls2 = (Class) f681a.get(cls);
        if (cls2 != null) {
            return cls2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Not a primitive wrapper type: ");
        stringBuffer.append(cls);
        throw new InterpreterError(stringBuffer.toString());
    }

    public static Object unwrap(Object obj) {
        if (obj == VOID) {
            return null;
        }
        if (obj instanceof Primitive) {
            obj = ((Primitive) obj).getValue();
        }
        return obj;
    }

    public static Object[] unwrap(Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            objArr2[i] = unwrap(objArr[i]);
        }
        return objArr2;
    }

    public static Object wrap(Object obj, Class cls) {
        return cls == Void.TYPE ? VOID : obj == null ? NULL : cls.isPrimitive() ? new Primitive(obj) : obj;
    }

    public static Object[] wrap(Object[] objArr, Class[] clsArr) {
        if (objArr == null) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            objArr2[i] = wrap(objArr[i], clsArr[i]);
        }
        return objArr2;
    }

    public boolean booleanValue() {
        if (this.f691k instanceof Boolean) {
            return ((Boolean) this.f691k).booleanValue();
        }
        throw new UtilEvalError("Primitive not a boolean");
    }

    public Primitive castToType(Class cls, int i) {
        return m713a(cls, getType(), this, false, i);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Primitive) {
            return ((Primitive) obj).f691k.equals(this.f691k);
        }
        return false;
    }

    public Class getType() {
        if (this == VOID) {
            return Void.TYPE;
        }
        if (this == NULL) {
            return null;
        }
        return unboxType(this.f691k.getClass());
    }

    public Object getValue() {
        if (this.f691k == Special.NULL_VALUE) {
            return null;
        }
        if (this.f691k != Special.VOID_TYPE) {
            return this.f691k;
        }
        throw new InterpreterError("attempt to unwrap void type");
    }

    public int hashCode() {
        return this.f691k.hashCode() * 21;
    }

    public int intValue() {
        if (this.f691k instanceof Number) {
            return ((Number) this.f691k).intValue();
        }
        throw new UtilEvalError("Primitive not a number");
    }

    public boolean isNumber() {
        return ((this.f691k instanceof Boolean) || this == NULL || this == VOID) ? false : true;
    }

    public Number numberValue() {
        Object obj = this.f691k;
        if (obj instanceof Character) {
            obj = new Integer(((Character) obj).charValue());
        }
        if (obj instanceof Number) {
            return (Number) obj;
        }
        throw new UtilEvalError("Primitive not a number");
    }

    public String toString() {
        return this.f691k == Special.NULL_VALUE ? "null" : this.f691k == Special.VOID_TYPE ? "void" : this.f691k.toString();
    }
}
