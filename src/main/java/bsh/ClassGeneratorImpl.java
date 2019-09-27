package bsh;

import bsh.BSHBlock.NodeFilter;
import bsh.Capabilities.Unavailable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ClassGeneratorImpl extends ClassGenerator {

    static class ClassNodeFilter implements NodeFilter {
        public static ClassNodeFilter CLASSCLASSES = new ClassNodeFilter(2);
        public static final int CLASSES = 2;
        public static ClassNodeFilter CLASSINSTANCE = new ClassNodeFilter(1);
        public static ClassNodeFilter CLASSSTATIC = new ClassNodeFilter(0);
        public static final int INSTANCE = 1;
        public static final int STATIC = 0;

        /* renamed from: a */
        int f526a;

        private ClassNodeFilter(int i) {
            this.f526a = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo709a(SimpleNode simpleNode) {
            if (simpleNode instanceof BSHTypedVariableDeclaration) {
                BSHTypedVariableDeclaration bSHTypedVariableDeclaration = (BSHTypedVariableDeclaration) simpleNode;
                return bSHTypedVariableDeclaration.modifiers != null && bSHTypedVariableDeclaration.modifiers.hasModifier("static");
            } else if (simpleNode instanceof BSHMethodDeclaration) {
                BSHMethodDeclaration bSHMethodDeclaration = (BSHMethodDeclaration) simpleNode;
                return bSHMethodDeclaration.modifiers != null && bSHMethodDeclaration.modifiers.hasModifier("static");
            } else {
                if (simpleNode instanceof BSHBlock) {
                }
                return false;
            }
        }

        public boolean isVisible(SimpleNode simpleNode) {
            if (this.f526a == 2) {
                return simpleNode instanceof BSHClassDeclaration;
            }
            if (simpleNode instanceof BSHClassDeclaration) {
                return false;
            }
            if (this.f526a == 0) {
                return mo709a(simpleNode);
            }
            if (this.f526a == 1) {
                return !mo709a(simpleNode);
            }
            return true;
        }
    }

    /* renamed from: a */
    static Variable[] m313a(BSHBlock bSHBlock, CallStack callStack, Interpreter interpreter, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bSHBlock.jjtGetNumChildren(); i++) {
            SimpleNode simpleNode = (SimpleNode) bSHBlock.jjtGetChild(i);
            if (simpleNode instanceof BSHTypedVariableDeclaration) {
                BSHTypedVariableDeclaration bSHTypedVariableDeclaration = (BSHTypedVariableDeclaration) simpleNode;
                Modifiers modifiers = bSHTypedVariableDeclaration.modifiers;
                String typeDescriptor = bSHTypedVariableDeclaration.getTypeDescriptor(callStack, interpreter, str);
                BSHVariableDeclarator[] a = bSHTypedVariableDeclaration.mo642a();
                for (BSHVariableDeclarator bSHVariableDeclarator : a) {
                    try {
                        arrayList.add(new Variable(bSHVariableDeclarator.name, typeDescriptor, (Object) null, modifiers));
                    } catch (UtilEvalError unused) {
                    }
                }
            }
        }
        return (Variable[]) arrayList.toArray(new Variable[0]);
    }

    /* renamed from: b */
    static DelayedEvalBshMethod[] m314b(BSHBlock bSHBlock, CallStack callStack, Interpreter interpreter, String str) {
        int i;
        CallStack callStack2 = callStack;
        Interpreter interpreter2 = interpreter;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (i3 < bSHBlock.jjtGetNumChildren()) {
            SimpleNode simpleNode = (SimpleNode) bSHBlock.jjtGetChild(i3);
            if (simpleNode instanceof BSHMethodDeclaration) {
                BSHMethodDeclaration bSHMethodDeclaration = (BSHMethodDeclaration) simpleNode;
                bSHMethodDeclaration.mo625a();
                Modifiers modifiers = bSHMethodDeclaration.modifiers;
                String str3 = bSHMethodDeclaration.name;
                String a = bSHMethodDeclaration.mo624a(callStack2, interpreter2, str2);
                BSHReturnType b = bSHMethodDeclaration.mo626b();
                BSHFormalParameters bSHFormalParameters = bSHMethodDeclaration.f487b;
                String[] typeDescriptors = bSHFormalParameters.getTypeDescriptors(callStack2, interpreter2, str2);
                DelayedEvalBshMethod delayedEvalBshMethod = r0;
                i = i3;
                DelayedEvalBshMethod delayedEvalBshMethod2 = new DelayedEvalBshMethod(str3, a, b, bSHMethodDeclaration.f487b.getParamNames(), typeDescriptors, bSHFormalParameters, bSHMethodDeclaration.f488c, null, modifiers, callStack2, interpreter2);
                arrayList.add(delayedEvalBshMethod);
            } else {
                i = i3;
            }
            i3 = i + 1;
            i2 = 0;
            str2 = str;
        }
        return (DelayedEvalBshMethod[]) arrayList.toArray(new DelayedEvalBshMethod[i2]);
    }

    public static Class generateClassImpl(String str, Modifiers modifiers, Class[] clsArr, Class cls, BSHBlock bSHBlock, boolean z, CallStack callStack, Interpreter interpreter) {
        String str2;
        String str3;
        BSHBlock bSHBlock2 = bSHBlock;
        CallStack callStack2 = callStack;
        Interpreter interpreter2 = interpreter;
        try {
            Capabilities.setAccessibility(true);
            NameSpace pVar = callStack.top();
            String c = pVar.mo862c();
            if (pVar.f622d) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(pVar.getName());
                stringBuffer.append("$");
                stringBuffer.append(str);
                str2 = stringBuffer.toString();
            } else {
                str2 = str;
            }
            if (c == null) {
                str3 = str2;
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(c);
                stringBuffer2.append(".");
                stringBuffer2.append(str2);
                str3 = stringBuffer2.toString();
            }
            BshClassManager classManager = interpreter.getClassManager();
            classManager.mo659c(str3);
            NameSpace nameSpace = new NameSpace(pVar, str2);
            nameSpace.f622d = true;
            callStack2.push(nameSpace);
            bSHBlock2.mo614a(callStack2, interpreter2, true, ClassNodeFilter.CLASSCLASSES);
            Variable[] a = m313a(bSHBlock2, callStack2, interpreter2, c);
            DelayedEvalBshMethod[] b = m314b(bSHBlock2, callStack2, interpreter2, c);
            ClassGeneratorUtil classGeneratorUtil = r6;
            NameSpace nameSpace2 = nameSpace;
            BshClassManager bshClassManager = classManager;
            String str4 = str3;
            String str5 = str2;
            ClassGeneratorUtil classGeneratorUtil2 = new ClassGeneratorUtil(modifiers, str2, c, cls, clsArr, a, b, nameSpace2, z);
            byte[] generateClass = classGeneratorUtil.generateClass();
            String property = System.getProperty("debugClasses");
            if (property != null) {
                try {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(property);
                    stringBuffer3.append("/");
                    stringBuffer3.append(str5);
                    stringBuffer3.append(".class");
                    FileOutputStream fileOutputStream = new FileOutputStream(stringBuffer3.toString());
                    fileOutputStream.write(generateClass);
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
            }
            Class defineClass = bshClassManager.defineClass(str4, generateClass);
            pVar.importClass(str4.replace('$', '.'));
            String str6 = str5;
            NameSpace nameSpace3 = nameSpace2;
            BSHBlock bSHBlock3 = bSHBlock;
            try {
                nameSpace3.mo859a("_bshInstanceInitializer", bSHBlock3, false);
                nameSpace3.mo856a(defineClass);
                BshClassManager bshClassManager2 = bshClassManager;
                String str7 = str4;
                Interpreter interpreter3 = interpreter;
                bSHBlock3.mo614a(callStack, interpreter3, true, ClassNodeFilter.CLASSSTATIC);
                callStack.pop();
                if (!defineClass.isInterface()) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("_bshStatic");
                    stringBuffer4.append(str6);
                    try {
                        Reflect.m726a(defineClass, stringBuffer4.toString()).assign(nameSpace3.mo645a(interpreter3), false);
                    } catch (Exception e) {
                        Exception exc = e;
                        StringBuffer stringBuffer5 = new StringBuffer();
                        stringBuffer5.append("Error in class gen setup: ");
                        stringBuffer5.append(exc);
                        throw new InterpreterError(stringBuffer5.toString());
                    }
                }
                bshClassManager2.mo670f(str7);
                return defineClass;
            } catch (UtilEvalError e2) {
                UtilEvalError utilEvalError = e2;
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append("unable to init static: ");
                stringBuffer6.append(utilEvalError);
                throw new InterpreterError(stringBuffer6.toString());
            }
        } catch (Unavailable unused2) {
            throw new EvalError("Defining classes currently requires reflective Accessibility.", bSHBlock2, callStack2);
        }
    }

    public static Object invokeSuperclassMethodImpl(BshClassManager bshClassManager, Object obj, String str, Object[] objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_bshSuper");
        stringBuffer.append(str);
        String stringBuffer2 = stringBuffer.toString();
        Class cls = obj.getClass();
        Method a = Reflect.m736a(bshClassManager, cls, stringBuffer2, Types.getTypes(objArr), false);
        if (a != null) {
            return Reflect.m731a(a, obj, objArr);
        }
        return Reflect.m731a(Reflect.m735a(bshClassManager, cls.getSuperclass(), obj, str, objArr, false), obj, objArr);
    }

    public Class generateClass(String str, Modifiers modifiers, Class[] clsArr, Class cls, BSHBlock bSHBlock, boolean z, CallStack callStack, Interpreter interpreter) {
        return generateClassImpl(str, modifiers, clsArr, cls, bSHBlock, z, callStack, interpreter);
    }

    public Object invokeSuperclassMethod(BshClassManager bshClassManager, Object obj, String str, Object[] objArr) {
        return invokeSuperclassMethodImpl(bshClassManager, obj, str, objArr);
    }

    public void setInstanceNameSpaceParent(Object obj, String str, NameSpace nameSpace) {
        ClassGeneratorUtil.m318a(obj, str).getNameSpace().setParent(nameSpace);
    }
}
