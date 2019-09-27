package bsh;

import bsh.BshClassManager.Listener;
import java.lang.reflect.Array;

class BSHType extends SimpleNode implements Listener {

    /* renamed from: a */
    String f493a;

    /* renamed from: b */
    private Class f494b;

    /* renamed from: c */
    private int f495c;

    /* renamed from: d */
    private Class f496d;

    BSHType(int i) {
        super(i);
    }

    public static String getTypeDescriptor(Class cls) {
        if (cls == Boolean.TYPE) {
            return "Z";
        }
        if (cls == Character.TYPE) {
            return "C";
        }
        if (cls == Byte.TYPE) {
            return "B";
        }
        if (cls == Short.TYPE) {
            return "S";
        }
        if (cls == Integer.TYPE) {
            return "I";
        }
        if (cls == Long.TYPE) {
            return "J";
        }
        if (cls == Float.TYPE) {
            return "F";
        }
        if (cls == Double.TYPE) {
            return "D";
        }
        if (cls == Void.TYPE) {
            return "V";
        }
        String replace = cls.getName().replace('.', '/');
        if (!replace.startsWith("[")) {
            if (replace.endsWith(";")) {
                return replace;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("L");
            stringBuffer.append(replace.replace('.', '/'));
            stringBuffer.append(";");
            replace = stringBuffer.toString();
        }
        return replace;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public SimpleNode mo635a() {
        return (SimpleNode) jjtGetChild(0);
    }

    public void addArrayDimension() {
        this.f495c++;
    }

    public void classLoaderChanged() {
        this.f496d = null;
        this.f494b = null;
    }

    public int getArrayDims() {
        return this.f495c;
    }

    public Class getBaseType() {
        return this.f494b;
    }

    public Class getType(CallStack callStack, Interpreter interpreter) {
        if (this.f496d != null) {
            return this.f496d;
        }
        SimpleNode a = mo635a();
        this.f494b = a instanceof BSHPrimitiveType ? ((BSHPrimitiveType) a).getType() : ((BSHAmbiguousName) a).toClass(callStack, interpreter);
        if (this.f495c > 0) {
            try {
                this.f496d = Array.newInstance(this.f494b, new int[this.f495c]).getClass();
            } catch (Exception unused) {
                throw new EvalError("Couldn't construct array type", this, callStack);
            }
        } else {
            this.f496d = this.f494b;
        }
        interpreter.getClassManager().addListener(this);
        return this.f496d;
    }

    public String getTypeDescriptor(CallStack callStack, Interpreter interpreter, String str) {
        String str2;
        if (this.f493a != null) {
            return this.f493a;
        }
        SimpleNode a = mo635a();
        if (a instanceof BSHPrimitiveType) {
            str2 = getTypeDescriptor(((BSHPrimitiveType) a).type);
        } else {
            String str3 = ((BSHAmbiguousName) a).text;
            String e = interpreter.getClassManager().mo669e(str3);
            Class cls = null;
            if (e == null) {
                try {
                    cls = ((BSHAmbiguousName) a).toClass(callStack, interpreter);
                } catch (EvalError unused) {
                }
            } else {
                str3 = e;
            }
            if (cls != null) {
                str2 = getTypeDescriptor(cls);
            } else if (str == null || Name.isCompound(str3)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("L");
                stringBuffer.append(str3.replace('.', '/'));
                stringBuffer.append(";");
                str2 = stringBuffer.toString();
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("L");
                stringBuffer2.append(str.replace('.', '/'));
                stringBuffer2.append("/");
                stringBuffer2.append(str3);
                stringBuffer2.append(";");
                str2 = stringBuffer2.toString();
            }
        }
        for (int i = 0; i < this.f495c; i++) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("[");
            stringBuffer3.append(str2);
            str2 = stringBuffer3.toString();
        }
        this.f493a = str2;
        return str2;
    }
}
