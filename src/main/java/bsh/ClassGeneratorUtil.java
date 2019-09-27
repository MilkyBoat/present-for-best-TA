package bsh;

import bsh.org.objectweb.asm.ClassWriter;
import bsh.org.objectweb.asm.CodeVisitor;
import bsh.org.objectweb.asm.Constants;
import bsh.org.objectweb.asm.Label;
import bsh.org.objectweb.asm.Type;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ClassGeneratorUtil implements Constants {

    /* renamed from: m */
    static Class f527m;

    /* renamed from: n */
    static Class f528n;

    /* renamed from: o */
    static Class f529o;

    /* renamed from: p */
    static Class f530p;

    /* renamed from: q */
    static Class f531q;

    /* renamed from: r */
    static Class f532r;

    /* renamed from: a */
    String f533a;

    /* renamed from: b */
    String f534b;

    /* renamed from: c */
    Class f535c;

    /* renamed from: d */
    String f536d;

    /* renamed from: e */
    Class[] f537e;

    /* renamed from: f */
    Variable[] f538f;

    /* renamed from: g */
    Constructor[] f539g;

    /* renamed from: h */
    DelayedEvalBshMethod[] f540h;

    /* renamed from: i */
    DelayedEvalBshMethod[] f541i;

    /* renamed from: j */
    NameSpace f542j;

    /* renamed from: k */
    Modifiers f543k;

    /* renamed from: l */
    boolean f544l;

    public static class ConstructorArgs {
        public static ConstructorArgs DEFAULT = new ConstructorArgs();

        /* renamed from: a */
        Object[] f545a;

        /* renamed from: b */
        int f546b = 0;
        public int selector = -1;

        ConstructorArgs() {
        }

        ConstructorArgs(int i, Object[] objArr) {
            this.selector = i;
            this.f545a = objArr;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Object mo714a() {
            Object[] objArr = this.f545a;
            int i = this.f546b;
            this.f546b = i + 1;
            return objArr[i];
        }

        public boolean getBoolean() {
            return ((Boolean) mo714a()).booleanValue();
        }

        public byte getByte() {
            return ((Byte) mo714a()).byteValue();
        }

        public char getChar() {
            return ((Character) mo714a()).charValue();
        }

        public double getDouble() {
            return ((Double) mo714a()).doubleValue();
        }

        public float getFloat() {
            return ((Float) mo714a()).floatValue();
        }

        public int getInt() {
            return ((Integer) mo714a()).intValue();
        }

        public long getLong() {
            return ((Long) mo714a()).longValue();
        }

        public Object getObject() {
            return mo714a();
        }

        public short getShort() {
            return ((Short) mo714a()).shortValue();
        }
    }

    public ClassGeneratorUtil(Modifiers modifiers, String str, String str2, Class cls, Class[] clsArr, Variable[] variableArr, DelayedEvalBshMethod[] delayedEvalBshMethodArr, NameSpace nameSpace, boolean z) {
        Class cls2;
        this.f543k = modifiers;
        this.f533a = str;
        if (str2 != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2.replace('.', '/'));
            stringBuffer.append("/");
            stringBuffer.append(str);
            this.f534b = stringBuffer.toString();
        } else {
            this.f534b = str;
        }
        if (cls == null) {
            if (f527m == null) {
                cls2 = m319a("java.lang.Object");
                f527m = cls2;
            } else {
                cls2 = f527m;
            }
            cls = cls2;
        }
        this.f535c = cls;
        this.f536d = Type.getInternalName(cls);
        if (clsArr == null) {
            clsArr = new Class[0];
        }
        this.f537e = clsArr;
        this.f538f = variableArr;
        this.f542j = nameSpace;
        this.f539g = cls.getDeclaredConstructors();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String d = m329d(str);
        for (int i = 0; i < delayedEvalBshMethodArr.length; i++) {
            if (delayedEvalBshMethodArr[i].getName().equals(d)) {
                arrayList.add(delayedEvalBshMethodArr[i]);
            } else {
                arrayList2.add(delayedEvalBshMethodArr[i]);
            }
        }
        this.f540h = (DelayedEvalBshMethod[]) arrayList.toArray(new DelayedEvalBshMethod[0]);
        this.f541i = (DelayedEvalBshMethod[]) arrayList2.toArray(new DelayedEvalBshMethod[0]);
        try {
            nameSpace.mo859a("_bshConstructors", this.f540h, false);
            this.f544l = z;
        } catch (UtilEvalError unused) {
            throw new InterpreterError("can't set cons var");
        }
    }

    /* renamed from: a */
    static int m316a(Modifiers modifiers) {
        int i = 0;
        if (modifiers == null) {
            return 0;
        }
        if (modifiers.hasModifier("public")) {
            i = 1;
        }
        if (modifiers.hasModifier("protected")) {
            i += 4;
        }
        if (modifiers.hasModifier("static")) {
            i += 8;
        }
        if (modifiers.hasModifier("synchronized")) {
            i += 32;
        }
        if (modifiers.hasModifier("abstract")) {
            i += 1024;
        }
        return i;
    }

    /* renamed from: a */
    static This m317a(Class cls, String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("_bshStatic");
            stringBuffer.append(str);
            return (This) Reflect.getStaticFieldValue(cls, stringBuffer.toString());
        } catch (Exception e) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unable to get class static space: ");
            stringBuffer2.append(e);
            throw new InterpreterError(stringBuffer2.toString());
        }
    }

    /* renamed from: a */
    static This m318a(Object obj, String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("_bshThis");
            stringBuffer.append(str);
            return (This) Primitive.unwrap(Reflect.getObjectFieldValue(obj, stringBuffer.toString()));
        } catch (Exception e) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Generated class: Error getting This");
            stringBuffer2.append(e);
            throw new InterpreterError(stringBuffer2.toString());
        }
    }

    /* renamed from: a */
    static Class m319a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* renamed from: a */
    static String m320a(String str, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer("(");
        for (String append : strArr) {
            stringBuffer.append(append);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(")");
        stringBuffer2.append(str);
        stringBuffer.append(stringBuffer2.toString());
        return stringBuffer.toString();
    }

    /* renamed from: a */
    static void m321a(int i, String str, String[] strArr, Label label, Label[] labelArr, int i2, CodeVisitor codeVisitor) {
        codeVisitor.visitLabel(labelArr[i]);
        codeVisitor.visitVarInsn(25, 0);
        for (String str2 : strArr) {
            String str3 = str2.equals("Z") ? "getBoolean" : str2.equals("B") ? "getByte" : str2.equals("C") ? "getChar" : str2.equals("S") ? "getShort" : str2.equals("I") ? "getInt" : str2.equals("J") ? "getLong" : str2.equals("D") ? "getDouble" : str2.equals("F") ? "getFloat" : "getObject";
            codeVisitor.visitVarInsn(25, i2);
            String str4 = "bsh/ClassGeneratorUtil$ConstructorArgs";
            String str5 = str3.equals("getObject") ? "Ljava/lang/Object;" : str2;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("()");
            stringBuffer.append(str5);
            codeVisitor.visitMethodInsn(Constants.INVOKEVIRTUAL, str4, str3, stringBuffer.toString());
            if (str3.equals("getObject")) {
                codeVisitor.visitTypeInsn(Constants.CHECKCAST, m328c(str2));
            }
        }
        codeVisitor.visitMethodInsn(Constants.INVOKESPECIAL, str, "<init>", m320a("V", strArr));
        codeVisitor.visitJumpInsn(Constants.GOTO, label);
    }

    /* renamed from: a */
    static void m322a(String str, CodeVisitor codeVisitor) {
        int i;
        if (str.equals("V")) {
            i = Constants.RETURN;
        } else if (m327b(str)) {
            int i2 = Constants.IRETURN;
            if (str.equals("D")) {
                i2 = Constants.DRETURN;
            } else if (str.equals("F")) {
                i2 = Constants.FRETURN;
            } else if (str.equals("J")) {
                i2 = Constants.LRETURN;
            }
            codeVisitor.visitInsn(i2);
            return;
        } else {
            codeVisitor.visitTypeInsn(Constants.CHECKCAST, m328c(str));
            i = Constants.ARETURN;
        }
        codeVisitor.visitInsn(i);
    }

    /* renamed from: a */
    static void m323a(String str, String str2, int i, ClassWriter classWriter) {
        classWriter.visitField(i, str, str2, null);
    }

    /* renamed from: a */
    static void m324a(String str, String str2, String str3, String str4, String[] strArr, int i, ClassWriter classWriter) {
        int i2;
        StringBuffer stringBuffer;
        String str5;
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        Class cls5;
        Class cls6;
        boolean z = (i & 8) != 0;
        if (str4 == null) {
            str4 = "Ljava/lang/Object;";
        }
        CodeVisitor visitMethod = classWriter.visitMethod(i, str3, m320a(str4, strArr), null);
        if ((i & 1024) == 0) {
            if (z) {
                i2 = Constants.GETSTATIC;
                stringBuffer = new StringBuffer();
                str5 = "_bshStatic";
            } else {
                visitMethod.visitVarInsn(25, 0);
                i2 = Constants.GETFIELD;
                stringBuffer = new StringBuffer();
                str5 = "_bshThis";
            }
            stringBuffer.append(str5);
            stringBuffer.append(str);
            visitMethod.visitFieldInsn(i2, str2, stringBuffer.toString(), "Lbsh/This;");
            visitMethod.visitLdcInsn(str3);
            generateParameterReifierCode(strArr, z, visitMethod);
            visitMethod.visitInsn(1);
            visitMethod.visitInsn(1);
            visitMethod.visitInsn(1);
            visitMethod.visitInsn(4);
            String str6 = "bsh/This";
            String str7 = "invokeMethod";
            if (f527m == null) {
                cls = m319a("java.lang.Object");
                f527m = cls;
            } else {
                cls = f527m;
            }
            Type type = Type.getType(cls);
            Type[] typeArr = new Type[6];
            if (f528n == null) {
                cls2 = m319a("java.lang.String");
                f528n = cls2;
            } else {
                cls2 = f528n;
            }
            typeArr[0] = Type.getType(cls2);
            if (f529o == null) {
                cls3 = m319a("[Ljava.lang.Object;");
                f529o = cls3;
            } else {
                cls3 = f529o;
            }
            typeArr[1] = Type.getType(cls3);
            if (f530p == null) {
                cls4 = m319a("bsh.Interpreter");
                f530p = cls4;
            } else {
                cls4 = f530p;
            }
            typeArr[2] = Type.getType(cls4);
            if (f531q == null) {
                cls5 = m319a("bsh.CallStack");
                f531q = cls5;
            } else {
                cls5 = f531q;
            }
            typeArr[3] = Type.getType(cls5);
            if (f532r == null) {
                cls6 = m319a("bsh.SimpleNode");
                f532r = cls6;
            } else {
                cls6 = f532r;
            }
            typeArr[4] = Type.getType(cls6);
            typeArr[5] = Type.getType(Boolean.TYPE);
            visitMethod.visitMethodInsn(Constants.INVOKEVIRTUAL, str6, str7, Type.getMethodDescriptor(type, typeArr));
            visitMethod.visitMethodInsn(Constants.INVOKESTATIC, "bsh/Primitive", "unwrap", "(Ljava/lang/Object;)Ljava/lang/Object;");
            generateReturnCode(str4, visitMethod);
            visitMethod.visitMaxs(20, 20);
        }
    }

    /* renamed from: a */
    static void m325a(String str, String str2, String str3, String[] strArr, int i, ClassWriter classWriter) {
        if (str3 == null) {
            str3 = "Ljava/lang/Object;";
        }
        String a = m320a(str3, strArr);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_bshSuper");
        stringBuffer.append(str2);
        CodeVisitor visitMethod = classWriter.visitMethod(i, stringBuffer.toString(), a, null);
        visitMethod.visitVarInsn(25, 0);
        int i2 = 1;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (m327b(strArr[i3])) {
                visitMethod.visitVarInsn(21, i2);
            } else {
                visitMethod.visitVarInsn(25, i2);
            }
            i2 += (strArr[i3].equals("D") || strArr[i3].equals("J")) ? 2 : 1;
        }
        visitMethod.visitMethodInsn(Constants.INVOKESPECIAL, str, str2, a);
        m322a(str3, visitMethod);
        visitMethod.visitMaxs(20, 20);
    }

    /* renamed from: a */
    static String[] m326a(Class[] clsArr) {
        String[] strArr = new String[clsArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = BSHType.getTypeDescriptor(clsArr[i]);
        }
        return strArr;
    }

    /* renamed from: b */
    private static boolean m327b(String str) {
        return str.length() == 1;
    }

    /* renamed from: c */
    private static String m328c(String str) {
        if (!str.startsWith("[")) {
            if (!str.startsWith("L")) {
                return str;
            }
            str = str.substring(1, str.length() - 1);
        }
        return str;
    }

    /* renamed from: d */
    private static String m329d(String str) {
        int indexOf = str.indexOf("$");
        return indexOf == -1 ? str : str.substring(indexOf + 1);
    }

    public static void generateParameterReifierCode(String[] strArr, boolean z, CodeVisitor codeVisitor) {
        codeVisitor.visitIntInsn(17, strArr.length);
        codeVisitor.visitTypeInsn(Constants.ANEWARRAY, "java/lang/Object");
        int i = !z;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            codeVisitor.visitInsn(89);
            codeVisitor.visitIntInsn(17, i2);
            if (m327b(str)) {
                int i3 = str.equals("F") ? 23 : str.equals("D") ? 24 : str.equals("J") ? 22 : 21;
                String str2 = "bsh/Primitive";
                codeVisitor.visitTypeInsn(Constants.NEW, str2);
                codeVisitor.visitInsn(89);
                codeVisitor.visitVarInsn(i3, i);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("(");
                stringBuffer.append(str);
                stringBuffer.append(")V");
                codeVisitor.visitMethodInsn(Constants.INVOKESPECIAL, str2, "<init>", stringBuffer.toString());
            } else {
                codeVisitor.visitVarInsn(25, i);
            }
            codeVisitor.visitInsn(83);
            i += (str.equals("D") || str.equals("J")) ? 2 : 1;
        }
    }

    public static void generateReturnCode(String str, CodeVisitor codeVisitor) {
        int i;
        String str2;
        String str3;
        if (str.equals("V")) {
            codeVisitor.visitInsn(87);
            i = Constants.RETURN;
        } else if (m327b(str)) {
            int i2 = Constants.IRETURN;
            if (str.equals("B")) {
                str3 = "java/lang/Byte";
                str2 = "byteValue";
            } else if (str.equals("I")) {
                str3 = "java/lang/Integer";
                str2 = "intValue";
            } else if (str.equals("Z")) {
                str3 = "java/lang/Boolean";
                str2 = "booleanValue";
            } else if (str.equals("D")) {
                i2 = Constants.DRETURN;
                str3 = "java/lang/Double";
                str2 = "doubleValue";
            } else if (str.equals("F")) {
                i2 = Constants.FRETURN;
                str3 = "java/lang/Float";
                str2 = "floatValue";
            } else if (str.equals("J")) {
                i2 = Constants.LRETURN;
                str3 = "java/lang/Long";
                str2 = "longValue";
            } else if (str.equals("C")) {
                str3 = "java/lang/Character";
                str2 = "charValue";
            } else {
                str3 = "java/lang/Short";
                str2 = "shortValue";
            }
            codeVisitor.visitTypeInsn(Constants.CHECKCAST, str3);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("()");
            stringBuffer.append(str);
            codeVisitor.visitMethodInsn(Constants.INVOKEVIRTUAL, str3, str2, stringBuffer.toString());
            codeVisitor.visitInsn(i2);
            return;
        } else {
            codeVisitor.visitTypeInsn(Constants.CHECKCAST, m328c(str));
            i = Constants.ARETURN;
        }
        codeVisitor.visitInsn(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static bsh.ClassGeneratorUtil.ConstructorArgs getConstructorArgs(java.lang.String r17, bsh.This r18, java.lang.Object[] r19, int r20) {
        /*
            r1 = r17
            r2 = r19
            r3 = r20
            bsh.NameSpace r4 = r18.getNameSpace()     // Catch:{ Exception -> 0x014a }
            java.lang.String r5 = "_bshConstructors"
            java.lang.Object r4 = r4.getVariable(r5)     // Catch:{ Exception -> 0x014a }
            bsh.DelayedEvalBshMethod[] r4 = (bsh.DelayedEvalBshMethod[]) r4     // Catch:{ Exception -> 0x014a }
            r5 = -1
            if (r3 != r5) goto L_0x0018
            bsh.ClassGeneratorUtil$ConstructorArgs r1 = bsh.ClassGeneratorUtil.ConstructorArgs.DEFAULT
            return r1
        L_0x0018:
            r6 = r4[r3]
            bsh.BSHBlock r7 = r6.f513c
            int r7 = r7.jjtGetNumChildren()
            if (r7 != 0) goto L_0x0025
            bsh.ClassGeneratorUtil$ConstructorArgs r1 = bsh.ClassGeneratorUtil.ConstructorArgs.DEFAULT
            return r1
        L_0x0025:
            bsh.BSHBlock r7 = r6.f513c
            r8 = 0
            bsh.Node r7 = r7.jjtGetChild(r8)
            bsh.SimpleNode r7 = (bsh.SimpleNode) r7
            boolean r9 = r7 instanceof bsh.BSHPrimaryExpression
            if (r9 == 0) goto L_0x0038
            bsh.Node r7 = r7.jjtGetChild(r8)
            bsh.SimpleNode r7 = (bsh.SimpleNode) r7
        L_0x0038:
            boolean r9 = r7 instanceof bsh.BSHMethodInvocation
            r10 = 0
            if (r9 == 0) goto L_0x005e
            bsh.BSHMethodInvocation r7 = (bsh.BSHMethodInvocation) r7
            bsh.BSHAmbiguousName r9 = r7.mo627a()
            java.lang.String r11 = r9.text
            java.lang.String r12 = "super"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0057
            java.lang.String r11 = r9.text
            java.lang.String r12 = "this"
            boolean r11 = r11.equals(r12)
            if (r11 == 0) goto L_0x005e
        L_0x0057:
            java.lang.String r9 = r9.text
            bsh.BSHArguments r7 = r7.mo628b()
            goto L_0x0060
        L_0x005e:
            r7 = r10
            r9 = r7
        L_0x0060:
            if (r9 != 0) goto L_0x0065
            bsh.ClassGeneratorUtil$ConstructorArgs r1 = bsh.ClassGeneratorUtil.ConstructorArgs.DEFAULT
            return r1
        L_0x0065:
            bsh.NameSpace r11 = new bsh.NameSpace
            bsh.NameSpace r12 = r18.getNameSpace()
            java.lang.String r13 = "consArgs"
            r11.<init>(r12, r13)
            java.lang.String[] r12 = r6.getParameterNames()
            java.lang.Class[] r6 = r6.getParameterTypes()
            r13 = 0
        L_0x0079:
            int r14 = r2.length
            if (r13 < r14) goto L_0x0120
            bsh.CallStack r2 = new bsh.CallStack
            r2.<init>()
            r2.push(r11)
            r14 = r18
            bsh.Interpreter r6 = r14.f702b
            java.lang.Object[] r2 = r7.getArguments(r2, r6)     // Catch:{ EvalError -> 0x0108 }
            java.lang.Class[] r7 = bsh.Types.getTypes(r2)
            java.lang.Object[] r2 = bsh.Primitive.unwrap(r2)
            bsh.BshClassManager r6 = r6.getClassManager()
            java.lang.Class r6 = r6.classForName(r1)
            if (r6 != 0) goto L_0x00b5
            bsh.InterpreterError r2 = new bsh.InterpreterError
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            java.lang.String r4 = "can't find superclass: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x00b5:
            java.lang.reflect.Constructor[] r1 = r6.getDeclaredConstructors()
            java.lang.String r6 = "super"
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L_0x00d5
            int r1 = bsh.Reflect.m747b(r7, r1)
            if (r1 != r5) goto L_0x00cf
            bsh.InterpreterError r1 = new bsh.InterpreterError
            java.lang.String r2 = "can't find constructor for args!"
            r1.<init>(r2)
            throw r1
        L_0x00cf:
            bsh.ClassGeneratorUtil$ConstructorArgs r3 = new bsh.ClassGeneratorUtil$ConstructorArgs
            r3.<init>(r1, r2)
            return r3
        L_0x00d5:
            int r6 = r4.length
            java.lang.Class[][] r6 = new java.lang.Class[r6][]
        L_0x00d8:
            int r9 = r6.length
            if (r8 < r9) goto L_0x00fd
            int r4 = bsh.Reflect.m725a(r7, r6)
            if (r4 != r5) goto L_0x00e9
            bsh.InterpreterError r1 = new bsh.InterpreterError
            java.lang.String r2 = "can't find constructor for args 2!"
            r1.<init>(r2)
            throw r1
        L_0x00e9:
            int r5 = r1.length
            int r4 = r4 + r5
            int r1 = r1.length
            int r1 = r1 + r3
            if (r4 != r1) goto L_0x00f7
            bsh.InterpreterError r1 = new bsh.InterpreterError
            java.lang.String r2 = "Recusive constructor call."
            r1.<init>(r2)
            throw r1
        L_0x00f7:
            bsh.ClassGeneratorUtil$ConstructorArgs r1 = new bsh.ClassGeneratorUtil$ConstructorArgs
            r1.<init>(r4, r2)
            return r1
        L_0x00fd:
            r9 = r4[r8]
            java.lang.Class[] r9 = r9.getParameterTypes()
            r6[r8] = r9
            int r8 = r8 + 1
            goto L_0x00d8
        L_0x0108:
            r0 = move-exception
            bsh.InterpreterError r1 = new bsh.InterpreterError
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            java.lang.String r3 = "Error evaluating constructor args: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0120:
            r14 = r18
            r15 = r12[r13]     // Catch:{ UtilEvalError -> 0x0131 }
            r5 = r6[r13]     // Catch:{ UtilEvalError -> 0x0131 }
            r8 = r2[r13]     // Catch:{ UtilEvalError -> 0x0131 }
            r11.setTypedVariable(r15, r5, r8, r10)     // Catch:{ UtilEvalError -> 0x0131 }
            int r13 = r13 + 1
            r5 = -1
            r8 = 0
            goto L_0x0079
        L_0x0131:
            r0 = move-exception
            r1 = r0
            bsh.InterpreterError r2 = new bsh.InterpreterError
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            java.lang.String r4 = "err setting local cons arg:"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x014a:
            r0 = move-exception
            r1 = r0
            bsh.InterpreterError r2 = new bsh.InterpreterError
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            java.lang.String r4 = "unable to get instance initializer: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.ClassGeneratorUtil.getConstructorArgs(java.lang.String, bsh.This, java.lang.Object[], int):bsh.ClassGeneratorUtil$ConstructorArgs");
    }

    public static void initInstance(Object obj, String str, Object[] objArr) {
        NameSpace nameSpace;
        Interpreter interpreter;
        Class[] types = Types.getTypes(objArr);
        CallStack callStack = new CallStack();
        This a = m318a(obj, str);
        if (a == null) {
            This a2 = m317a(obj.getClass(), str);
            interpreter = a2.f702b;
            try {
                BSHBlock bSHBlock = (BSHBlock) a2.getNameSpace().getVariable("_bshInstanceInitializer");
                nameSpace = new NameSpace(a2.getNameSpace(), str);
                nameSpace.f622d = true;
                This a3 = nameSpace.mo645a(interpreter);
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("_bshThis");
                    stringBuffer.append(str);
                    Reflect.m727a(obj, stringBuffer.toString()).assign(a3, false);
                    nameSpace.mo857a(obj);
                    callStack.push(nameSpace);
                    try {
                        bSHBlock.mo614a(callStack, interpreter, true, ClassNodeFilter.CLASSINSTANCE);
                        callStack.pop();
                    } catch (Exception e) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Error in class initialization: ");
                        stringBuffer2.append(e);
                        throw new InterpreterError(stringBuffer2.toString());
                    }
                } catch (Exception e2) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Error in class gen setup: ");
                    stringBuffer3.append(e2);
                    throw new InterpreterError(stringBuffer3.toString());
                }
            } catch (Exception e3) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("unable to get instance initializer: ");
                stringBuffer4.append(e3);
                throw new InterpreterError(stringBuffer4.toString());
            }
        } else {
            Interpreter interpreter2 = a.f702b;
            nameSpace = a.getNameSpace();
            interpreter = interpreter2;
        }
        try {
            BshMethod method = nameSpace.getMethod(m329d(str), types, true);
            if (objArr.length > 0 && method == null) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Can't find constructor: ");
                stringBuffer5.append(str);
                throw new InterpreterError(stringBuffer5.toString());
            } else if (method != null) {
                method.mo685a(objArr, interpreter, callStack, null, false);
            }
        } catch (Exception e4) {
            e = e4;
            if (e instanceof TargetError) {
                e = (Exception) ((TargetError) e).getTarget();
            }
            if (e instanceof InvocationTargetException) {
                e = (Exception) ((InvocationTargetException) e).getTargetException();
            }
            C0029a.m807a((Throwable) e, System.err);
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Error in class initialization: ");
            stringBuffer6.append(e);
            throw new InterpreterError(stringBuffer6.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo710a(int i, int i2, int i3, CodeVisitor codeVisitor) {
        int i4 = i3;
        CodeVisitor codeVisitor2 = codeVisitor;
        Label label = new Label();
        Label label2 = new Label();
        int length = this.f539g.length + this.f540h.length;
        Label[] labelArr = new Label[length];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i;
            int i7 = i2;
            labelArr[i5] = new Label();
        }
        codeVisitor2.visitLdcInsn(this.f535c.getName());
        String str = this.f534b;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_bshStatic");
        stringBuffer.append(this.f533a);
        codeVisitor2.visitFieldInsn(Constants.GETSTATIC, str, stringBuffer.toString(), "Lbsh/This;");
        codeVisitor2.visitVarInsn(25, i2);
        codeVisitor2.visitIntInsn(16, i);
        codeVisitor2.visitMethodInsn(Constants.INVOKESTATIC, "bsh/ClassGeneratorUtil", "getConstructorArgs", "(Ljava/lang/String;Lbsh/This;[Ljava/lang/Object;I)Lbsh/ClassGeneratorUtil$ConstructorArgs;");
        codeVisitor2.visitVarInsn(58, i4);
        codeVisitor2.visitVarInsn(25, i4);
        codeVisitor2.visitFieldInsn(Constants.GETFIELD, "bsh/ClassGeneratorUtil$ConstructorArgs", "selector", "I");
        codeVisitor2.visitTableSwitchInsn(0, length - 1, label, labelArr);
        int i8 = 0;
        int i9 = 0;
        while (i8 < this.f539g.length) {
            m321a(i9, this.f536d, m326a(this.f539g[i8].getParameterTypes()), label2, labelArr, i4, codeVisitor2);
            i8++;
            i9++;
        }
        int i10 = 0;
        while (i10 < this.f540h.length) {
            m321a(i9, this.f534b, this.f540h[i10].getParamTypeDescriptors(), label2, labelArr, i4, codeVisitor2);
            i10++;
            i9++;
        }
        codeVisitor2.visitLabel(label);
        codeVisitor2.visitVarInsn(25, 0);
        codeVisitor2.visitMethodInsn(Constants.INVOKESPECIAL, this.f536d, "<init>", "()V");
        codeVisitor2.visitLabel(label2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo711a(int i, String[] strArr, int i2, ClassWriter classWriter) {
        int length = strArr.length + 1;
        int length2 = strArr.length + 2;
        CodeVisitor visitMethod = classWriter.visitMethod(i2, "<init>", m320a("V", strArr), null);
        generateParameterReifierCode(strArr, false, visitMethod);
        visitMethod.visitVarInsn(58, length);
        mo710a(i, length, length2, visitMethod);
        visitMethod.visitVarInsn(25, 0);
        visitMethod.visitLdcInsn(this.f533a);
        visitMethod.visitVarInsn(25, length);
        visitMethod.visitMethodInsn(Constants.INVOKESTATIC, "bsh/ClassGeneratorUtil", "initInstance", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V");
        visitMethod.visitInsn(Constants.RETURN);
        visitMethod.visitMaxs(20, 20);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo712a(Class cls, String str, String[] strArr) {
        boolean z;
        while (cls != null) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (int i = 0; i < declaredMethods.length; i++) {
                if (declaredMethods[i].getName().equals(str)) {
                    String[] a = m326a(declaredMethods[i].getParameterTypes());
                    int i2 = 0;
                    while (true) {
                        if (i2 >= a.length) {
                            z = true;
                            break;
                        } else if (!strArr[i2].equals(a[i2])) {
                            z = false;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z) {
                        return true;
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return false;
    }

    public byte[] generateClass() {
        ClassWriter classWriter;
        int a = m316a(this.f543k) | 1;
        if (this.f544l) {
            a |= Constants.ACC_INTERFACE;
        }
        int i = a;
        String[] strArr = new String[this.f537e.length];
        for (int i2 = 0; i2 < this.f537e.length; i2++) {
            strArr[i2] = Type.getInternalName(this.f537e[i2]);
        }
        ClassWriter classWriter2 = new ClassWriter(false);
        classWriter2.visit(i, this.f534b, this.f536d, strArr, "BeanShell Generated via ASM (www.objectweb.org)");
        if (!this.f544l) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("_bshThis");
            stringBuffer.append(this.f533a);
            m323a(stringBuffer.toString(), "Lbsh/This;", 1, classWriter2);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("_bshStatic");
            stringBuffer2.append(this.f533a);
            m323a(stringBuffer2.toString(), "Lbsh/This;", 9, classWriter2);
        }
        int i3 = 0;
        while (i3 < this.f538f.length) {
            ClassWriter classWriter3 = classWriter2;
            String typeDescriptor = this.f538f[i3].getTypeDescriptor();
            if (!this.f538f[i3].hasModifier("private") && typeDescriptor != null) {
                m323a(this.f538f[i3].getName(), typeDescriptor, this.f544l ? 25 : m316a(this.f538f[i3].getModifiers()), classWriter3);
            }
            i3++;
            classWriter2 = classWriter3;
        }
        int i4 = 0;
        boolean z = false;
        while (i4 < this.f540h.length) {
            ClassWriter classWriter4 = classWriter2;
            if (!this.f540h[i4].hasModifier("private")) {
                mo711a(i4, this.f540h[i4].getParamTypeDescriptors(), m316a(this.f540h[i4].getModifiers()), classWriter4);
                z = true;
            }
            i4++;
            classWriter2 = classWriter4;
        }
        if (!this.f544l && !z) {
            mo711a(-1, new String[0], 1, classWriter2);
        }
        int i5 = 0;
        while (i5 < this.f541i.length) {
            String returnTypeDescriptor = this.f541i[i5].getReturnTypeDescriptor();
            if (this.f541i[i5].hasModifier("private")) {
                classWriter = classWriter2;
            } else {
                int a2 = m316a(this.f541i[i5].getModifiers());
                if (this.f544l) {
                    a2 |= 1025;
                }
                classWriter = classWriter2;
                m324a(this.f533a, this.f534b, this.f541i[i5].getName(), returnTypeDescriptor, this.f541i[i5].getParamTypeDescriptors(), a2, classWriter2);
                boolean z2 = (a2 & 8) > 0;
                boolean a3 = mo712a(this.f535c, this.f541i[i5].getName(), this.f541i[i5].getParamTypeDescriptors());
                if (!z2 && a3) {
                    m325a(this.f536d, this.f541i[i5].getName(), returnTypeDescriptor, this.f541i[i5].getParamTypeDescriptors(), a2, classWriter);
                }
            }
            i5++;
            classWriter2 = classWriter;
        }
        return classWriter2.toByteArray();
    }
}
