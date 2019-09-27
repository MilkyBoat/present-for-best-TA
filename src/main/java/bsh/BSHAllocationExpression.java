package bsh;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

class BSHAllocationExpression extends SimpleNode {

    /* renamed from: a */
    private static int f470a;

    BSHAllocationExpression(int i) {
        super(i);
    }

    /* renamed from: a */
    private Object m255a(BSHAmbiguousName bSHAmbiguousName, BSHArguments bSHArguments, CallStack callStack, Interpreter interpreter) {
        callStack.top();
        Object[] arguments = bSHArguments.getArguments(callStack, interpreter);
        if (arguments == null) {
            throw new EvalError("Null args in new.", this, callStack);
        }
        boolean z = false;
        bSHAmbiguousName.mo603a(callStack, interpreter, false);
        Object a = bSHAmbiguousName.mo603a(callStack, interpreter, true);
        if (a instanceof ClassIdentifier) {
            Class targetClass = ((ClassIdentifier) a).getTargetClass();
            if (jjtGetNumChildren() > 2) {
                z = true;
            }
            if (!z) {
                return m261a(targetClass, arguments, callStack);
            }
            BSHBlock bSHBlock = (BSHBlock) jjtGetChild(2);
            return targetClass.isInterface() ? m262b(targetClass, arguments, bSHBlock, callStack, interpreter) : m260a(targetClass, arguments, bSHBlock, callStack, interpreter);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unknown class: ");
        stringBuffer.append(bSHAmbiguousName.text);
        throw new EvalError(stringBuffer.toString(), this, callStack);
    }

    /* renamed from: a */
    private Object m256a(BSHAmbiguousName bSHAmbiguousName, BSHArrayDimensions bSHArrayDimensions, CallStack callStack, Interpreter interpreter) {
        NameSpace pVar = callStack.top();
        Class cls = bSHAmbiguousName.toClass(callStack, interpreter);
        if (cls != null) {
            return m257a(bSHArrayDimensions, cls, callStack, interpreter);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Class ");
        stringBuffer.append(bSHAmbiguousName.getName(pVar));
        stringBuffer.append(" not found.");
        throw new EvalError(stringBuffer.toString(), this, callStack);
    }

    /* renamed from: a */
    private Object m257a(BSHArrayDimensions bSHArrayDimensions, Class cls, CallStack callStack, Interpreter interpreter) {
        Object eval = bSHArrayDimensions.eval(cls, callStack, interpreter);
        return eval != Primitive.VOID ? eval : m259a(cls, bSHArrayDimensions, callStack);
    }

    /* renamed from: a */
    private Object m258a(BSHPrimitiveType bSHPrimitiveType, BSHArrayDimensions bSHArrayDimensions, CallStack callStack, Interpreter interpreter) {
        return m257a(bSHArrayDimensions, bSHPrimitiveType.getType(), callStack, interpreter);
    }

    /* renamed from: a */
    private Object m259a(Class cls, BSHArrayDimensions bSHArrayDimensions, CallStack callStack) {
        if (bSHArrayDimensions.numUndefinedDims > 0) {
            cls = Array.newInstance(cls, new int[bSHArrayDimensions.numUndefinedDims]).getClass();
        }
        try {
            return Array.newInstance(cls, bSHArrayDimensions.definedDimensions);
        } catch (NegativeArraySizeException e) {
            throw new TargetError(e, this, callStack);
        } catch (Exception e2) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Can't construct primitive array: ");
            stringBuffer.append(e2.getMessage());
            throw new EvalError(stringBuffer.toString(), this, callStack);
        }
    }

    /* renamed from: a */
    private Object m260a(Class cls, Object[] objArr, BSHBlock bSHBlock, CallStack callStack, Interpreter interpreter) {
        CallStack callStack2 = callStack;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(callStack.top().getName());
        stringBuffer.append("$");
        int i = f470a + 1;
        f470a = i;
        stringBuffer.append(i);
        String stringBuffer2 = stringBuffer.toString();
        Modifiers modifiers = new Modifiers();
        modifiers.addModifier(0, "public");
        try {
            try {
                return Reflect.m730a(ClassGenerator.getClassGenerator().generateClass(stringBuffer2, modifiers, null, cls, bSHBlock, false, callStack2, interpreter), objArr);
            } catch (Exception e) {
                Exception exc = e instanceof InvocationTargetException ? (Exception) ((InvocationTargetException) e).getTargetException() : e;
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Error constructing inner class instance: ");
                stringBuffer3.append(exc);
                throw new EvalError(stringBuffer3.toString(), this, callStack2);
            }
        } catch (UtilEvalError e2) {
            throw e2.toEvalError(this, callStack2);
        }
    }

    /* renamed from: a */
    private Object m261a(Class cls, Object[] objArr, CallStack callStack) {
        try {
            Object a = Reflect.m730a(cls, objArr);
            String name = cls.getName();
            if (name.indexOf("$") == -1) {
                return a;
            }
            NameSpace a2 = Name.m371a(callStack.top().mo645a((Interpreter) null).getNameSpace());
            if (a2 != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(a2.getName());
                stringBuffer.append("$");
                if (name.startsWith(stringBuffer.toString())) {
                    try {
                        ClassGenerator.getClassGenerator().setInstanceNameSpaceParent(a, name, a2);
                        return a;
                    } catch (UtilEvalError e) {
                        throw e.toEvalError(this, callStack);
                    }
                }
            }
            return a;
        } catch (ReflectError e2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Constructor error: ");
            stringBuffer2.append(e2.getMessage());
            throw new EvalError(stringBuffer2.toString(), this, callStack);
        } catch (InvocationTargetException e3) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("The constructor threw an exception:\n\t");
            stringBuffer3.append(e3.getTargetException());
            Interpreter.debug(stringBuffer3.toString());
            TargetError targetError = new TargetError("Object constructor", e3.getTargetException(), this, callStack, true);
            throw targetError;
        }
    }

    /* renamed from: b */
    private Object m262b(Class cls, Object[] objArr, BSHBlock bSHBlock, CallStack callStack, Interpreter interpreter) {
        NameSpace nameSpace = new NameSpace(callStack.top(), "AnonymousBlock");
        callStack.push(nameSpace);
        bSHBlock.eval(callStack, interpreter, true);
        callStack.pop();
        nameSpace.importStatic(cls);
        try {
            return nameSpace.mo645a(interpreter).getInterface(cls);
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callStack);
        }
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        SimpleNode simpleNode = (SimpleNode) jjtGetChild(0);
        SimpleNode simpleNode2 = (SimpleNode) jjtGetChild(1);
        if (!(simpleNode instanceof BSHAmbiguousName)) {
            return m258a((BSHPrimitiveType) simpleNode, (BSHArrayDimensions) simpleNode2, callStack, interpreter);
        }
        BSHAmbiguousName bSHAmbiguousName = (BSHAmbiguousName) simpleNode;
        return simpleNode2 instanceof BSHArguments ? m255a(bSHAmbiguousName, (BSHArguments) simpleNode2, callStack, interpreter) : m256a(bSHAmbiguousName, (BSHArrayDimensions) simpleNode2, callStack, interpreter);
    }
}
