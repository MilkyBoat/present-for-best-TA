package bsh.org.objectweb.asm;

import bsh.ParserConstants;
import java.lang.reflect.Method;

public class Type {
    public static final int ARRAY = 9;
    public static final int BOOLEAN = 1;
    public static final Type BOOLEAN_TYPE = new Type(1);
    public static final int BYTE = 3;
    public static final Type BYTE_TYPE = new Type(3);
    public static final int CHAR = 2;
    public static final Type CHAR_TYPE = new Type(2);
    public static final int DOUBLE = 8;
    public static final Type DOUBLE_TYPE = new Type(8);
    public static final int FLOAT = 6;
    public static final Type FLOAT_TYPE = new Type(6);
    public static final int INT = 5;
    public static final Type INT_TYPE = new Type(5);
    public static final int LONG = 7;
    public static final Type LONG_TYPE = new Type(7);
    public static final int OBJECT = 10;
    public static final int SHORT = 4;
    public static final Type SHORT_TYPE = new Type(4);
    public static final int VOID = 0;
    public static final Type VOID_TYPE = new Type(0);

    /* renamed from: a */
    private final int f794a;

    /* renamed from: b */
    private char[] f795b;

    /* renamed from: c */
    private int f796c;

    /* renamed from: d */
    private int f797d;

    private Type(int i) {
        this.f794a = i;
        this.f797d = 1;
    }

    private Type(int i, char[] cArr, int i2, int i3) {
        this.f794a = i;
        this.f795b = cArr;
        this.f796c = i2;
        this.f797d = i3;
    }

    /* renamed from: a */
    private static Type m803a(char[] cArr, int i) {
        switch (cArr[i]) {
            case ParserConstants.CHARACTER_LITERAL /*66*/:
                return BYTE_TYPE;
            case ParserConstants.STRING_LITERAL /*67*/:
                return CHAR_TYPE;
            case ParserConstants.FORMAL_COMMENT /*68*/:
                return DOUBLE_TYPE;
            case ParserConstants.LETTER /*70*/:
                return FLOAT_TYPE;
            case ParserConstants.RPAREN /*73*/:
                return INT_TYPE;
            case ParserConstants.LBRACE /*74*/:
                return LONG_TYPE;
            case 'S':
                return SHORT_TYPE;
            case 'V':
                return VOID_TYPE;
            case 'Z':
                return BOOLEAN_TYPE;
            case '[':
                int i2 = 1;
                while (true) {
                    int i3 = i + i2;
                    if (cArr[i3] != '[') {
                        if (cArr[i3] == 'L') {
                            do {
                                i2++;
                            } while (cArr[i + i2] != ';');
                        }
                        return new Type(9, cArr, i, i2 + 1);
                    }
                    i2++;
                }
            default:
                int i4 = 1;
                while (cArr[i + i4] != ';') {
                    i4++;
                }
                return new Type(10, cArr, i, i4 + 1);
        }
    }

    /* renamed from: a */
    private void m804a(StringBuffer stringBuffer) {
        switch (this.f794a) {
            case 0:
                stringBuffer.append('V');
                return;
            case 1:
                stringBuffer.append('Z');
                return;
            case 2:
                stringBuffer.append('C');
                return;
            case 3:
                stringBuffer.append('B');
                return;
            case 4:
                stringBuffer.append('S');
                return;
            case 5:
                stringBuffer.append('I');
                return;
            case 6:
                stringBuffer.append('F');
                return;
            case 7:
                stringBuffer.append('J');
                return;
            case 8:
                stringBuffer.append('D');
                return;
            default:
                stringBuffer.append(this.f795b, this.f796c, this.f797d);
                return;
        }
    }

    /* renamed from: a */
    private static void m805a(StringBuffer stringBuffer, Class cls) {
        while (!cls.isPrimitive()) {
            if (cls.isArray()) {
                stringBuffer.append('[');
                cls = cls.getComponentType();
            } else {
                stringBuffer.append('L');
                String name = cls.getName();
                int length = name.length();
                for (int i = 0; i < length; i++) {
                    char charAt = name.charAt(i);
                    if (charAt == '.') {
                        charAt = '/';
                    }
                    stringBuffer.append(charAt);
                }
                stringBuffer.append(';');
                return;
            }
        }
        char c = cls == Integer.TYPE ? 'I' : cls == Void.TYPE ? 'V' : cls == Boolean.TYPE ? 'Z' : cls == Byte.TYPE ? 'B' : cls == Character.TYPE ? 'C' : cls == Short.TYPE ? 'S' : cls == Double.TYPE ? 'D' : cls == Float.TYPE ? 'F' : 'J';
        stringBuffer.append(c);
    }

    public static Type[] getArgumentTypes(String str) {
        char[] charArray = str.toCharArray();
        int i = 1;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            char c = charArray[i];
            if (c == ')') {
                break;
            } else if (c == 'L') {
                while (true) {
                    i = i3 + 1;
                    if (charArray[i3] == ';') {
                        break;
                    }
                    i3 = i;
                }
                i2++;
            } else {
                if (c != '[') {
                    i2++;
                }
                i = i3;
            }
        }
        Type[] typeArr = new Type[i2];
        int i4 = 1;
        int i5 = 0;
        while (charArray[i4] != ')') {
            typeArr[i5] = m803a(charArray, i4);
            i4 += typeArr[i5].f797d;
            i5++;
        }
        return typeArr;
    }

    public static Type[] getArgumentTypes(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        Type[] typeArr = new Type[parameterTypes.length];
        for (int length = parameterTypes.length - 1; length >= 0; length--) {
            typeArr[length] = getType(parameterTypes[length]);
        }
        return typeArr;
    }

    public static String getDescriptor(Class cls) {
        StringBuffer stringBuffer = new StringBuffer();
        m805a(stringBuffer, cls);
        return stringBuffer.toString();
    }

    public static String getInternalName(Class cls) {
        return cls.getName().replace('.', '/');
    }

    public static String getMethodDescriptor(Type type, Type[] typeArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        for (Type a : typeArr) {
            a.m804a(stringBuffer);
        }
        stringBuffer.append(')');
        type.m804a(stringBuffer);
        return stringBuffer.toString();
    }

    public static String getMethodDescriptor(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        for (Class a : parameterTypes) {
            m805a(stringBuffer, a);
        }
        stringBuffer.append(')');
        m805a(stringBuffer, method.getReturnType());
        return stringBuffer.toString();
    }

    public static Type getReturnType(String str) {
        return m803a(str.toCharArray(), str.indexOf(41) + 1);
    }

    public static Type getReturnType(Method method) {
        return getType(method.getReturnType());
    }

    public static Type getType(Class cls) {
        return cls.isPrimitive() ? cls == Integer.TYPE ? INT_TYPE : cls == Void.TYPE ? VOID_TYPE : cls == Boolean.TYPE ? BOOLEAN_TYPE : cls == Byte.TYPE ? BYTE_TYPE : cls == Character.TYPE ? CHAR_TYPE : cls == Short.TYPE ? SHORT_TYPE : cls == Double.TYPE ? DOUBLE_TYPE : cls == Float.TYPE ? FLOAT_TYPE : LONG_TYPE : getType(getDescriptor(cls));
    }

    public static Type getType(String str) {
        return m803a(str.toCharArray(), 0);
    }

    public String getClassName() {
        return new String(this.f795b, this.f796c + 1, this.f797d - 2).replace('/', '.');
    }

    public String getDescriptor() {
        StringBuffer stringBuffer = new StringBuffer();
        m804a(stringBuffer);
        return stringBuffer.toString();
    }

    public int getDimensions() {
        int i = 1;
        while (this.f795b[this.f796c + i] == '[') {
            i++;
        }
        return i;
    }

    public Type getElementType() {
        return m803a(this.f795b, this.f796c + getDimensions());
    }

    public String getInternalName() {
        return new String(this.f795b, this.f796c + 1, this.f797d - 2);
    }

    public int getOpcode(int i) {
        if (i == 46 || i == 79) {
            switch (this.f794a) {
                case 0:
                    return i + 5;
                case 1:
                case 3:
                    return i + 6;
                case 2:
                    return i + 7;
                case 4:
                    return i + 8;
                case 5:
                    break;
                case 6:
                    i += 2;
                    break;
                case 7:
                    return i + 1;
                case 8:
                    return i + 3;
                default:
                    return i + 4;
            }
            return i;
        }
        switch (this.f794a) {
            case 0:
                return i + 5;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                break;
            case 6:
                i += 2;
                break;
            case 7:
                return i + 1;
            case 8:
                return i + 3;
            default:
                return i + 4;
        }
        return i;
    }

    public int getSize() {
        return (this.f794a == 7 || this.f794a == 8) ? 2 : 1;
    }

    public int getSort() {
        return this.f794a;
    }
}
