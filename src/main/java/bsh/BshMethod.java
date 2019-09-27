package bsh;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BshMethod implements Serializable {

    /* renamed from: a */
    NameSpace f511a;

    /* renamed from: b */
    Modifiers f512b;

    /* renamed from: c */
    BSHBlock f513c;

    /* renamed from: d */
    private String f514d;

    /* renamed from: e */
    private Class f515e;

    /* renamed from: f */
    private String[] f516f;

    /* renamed from: g */
    private int f517g;

    /* renamed from: h */
    private Class[] f518h;

    /* renamed from: i */
    private Method f519i;

    /* renamed from: j */
    private Object f520j;

    BshMethod(BSHMethodDeclaration bSHMethodDeclaration, NameSpace nameSpace, Modifiers modifiers) {
        this(bSHMethodDeclaration.name, bSHMethodDeclaration.f490e, bSHMethodDeclaration.f487b.getParamNames(), bSHMethodDeclaration.f487b.f482a, bSHMethodDeclaration.f488c, nameSpace, modifiers);
    }

    BshMethod(String str, Class cls, String[] strArr, Class[] clsArr, BSHBlock bSHBlock, NameSpace nameSpace, Modifiers modifiers) {
        this.f514d = str;
        this.f515e = cls;
        this.f516f = strArr;
        if (strArr != null) {
            this.f517g = strArr.length;
        }
        this.f518h = clsArr;
        this.f513c = bSHBlock;
        this.f511a = nameSpace;
        this.f512b = modifiers;
    }

    BshMethod(Method method, Object obj) {
        this(method.getName(), method.getReturnType(), null, method.getParameterTypes(), null, null, null);
        this.f519i = method;
        this.f520j = obj;
    }

    /* renamed from: b */
    private Object m310b(Object[] objArr, Interpreter interpreter, CallStack callStack, SimpleNode simpleNode, boolean z) {
        NameSpace nameSpace;
        Class returnType = getReturnType();
        Class[] parameterTypes = getParameterTypes();
        if (callStack == null) {
            callStack = new CallStack(this.f511a);
        }
        int i = 0;
        if (objArr == null) {
            objArr = new Object[0];
        }
        if (objArr.length != this.f517g) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Wrong number of arguments for local method: ");
            stringBuffer.append(this.f514d);
            throw new EvalError(stringBuffer.toString(), simpleNode, callStack);
        }
        if (z) {
            nameSpace = callStack.top();
        } else {
            nameSpace = new NameSpace(this.f511a, this.f514d);
            nameSpace.f621c = true;
        }
        nameSpace.mo855a(simpleNode);
        while (true) {
            ReturnControl returnControl = null;
            if (i >= this.f517g) {
                if (!z) {
                    callStack.push(nameSpace);
                }
                Object eval = this.f513c.eval(callStack, interpreter, true);
                CallStack copy = callStack.copy();
                if (!z) {
                    callStack.pop();
                }
                if (eval instanceof ReturnControl) {
                    returnControl = (ReturnControl) eval;
                    if (returnControl.kind == 46) {
                        eval = returnControl.value;
                        if (returnType == Void.TYPE && eval != Primitive.VOID) {
                            throw new EvalError("Cannot return value from void method", returnControl.returnPoint, copy);
                        }
                    } else {
                        throw new EvalError("'continue' or 'break' in method body", returnControl.returnPoint, copy);
                    }
                }
                if (returnType == null) {
                    return eval;
                }
                if (returnType == Void.TYPE) {
                    return Primitive.VOID;
                }
                try {
                    return Types.castObject(eval, returnType, 1);
                } catch (UtilEvalError e) {
                    if (returnControl != null) {
                        simpleNode = returnControl.returnPoint;
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Incorrect type returned from method: ");
                    stringBuffer2.append(this.f514d);
                    stringBuffer2.append(e.getMessage());
                    throw e.toEvalError(stringBuffer2.toString(), simpleNode, callStack);
                }
            } else {
                if (parameterTypes[i] != null) {
                    try {
                        objArr[i] = Types.castObject(objArr[i], parameterTypes[i], 1);
                        try {
                            nameSpace.setTypedVariable(this.f516f[i], parameterTypes[i], objArr[i], (Modifiers) null);
                        } catch (UtilEvalError e2) {
                            throw e2.toEvalError("Typed method parameter assignment", simpleNode, callStack);
                        }
                    } catch (UtilEvalError e3) {
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append("Invalid argument: `");
                        stringBuffer3.append(this.f516f[i]);
                        stringBuffer3.append("'");
                        stringBuffer3.append(" for method: ");
                        stringBuffer3.append(this.f514d);
                        stringBuffer3.append(" : ");
                        stringBuffer3.append(e3.getMessage());
                        throw new EvalError(stringBuffer3.toString(), simpleNode, callStack);
                    }
                } else if (objArr[i] == Primitive.VOID) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("Undefined variable or class name, parameter: ");
                    stringBuffer4.append(this.f516f[i]);
                    stringBuffer4.append(" to method: ");
                    stringBuffer4.append(this.f514d);
                    throw new EvalError(stringBuffer4.toString(), simpleNode, callStack);
                } else {
                    try {
                        nameSpace.mo859a(this.f516f[i], objArr[i], interpreter.getStrictJava());
                    } catch (UtilEvalError e4) {
                        throw e4.toEvalError(simpleNode, callStack);
                    }
                }
                i++;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo685a(Object[] objArr, Interpreter interpreter, CallStack callStack, SimpleNode simpleNode, boolean z) {
        Object obj;
        Object b;
        if (objArr != null) {
            for (Object obj2 : objArr) {
                if (obj2 == null) {
                    throw new Error("HERE!");
                }
            }
        }
        if (this.f519i != null) {
            try {
                return Reflect.m731a(this.f519i, this.f520j, objArr);
            } catch (ReflectError e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Error invoking Java method: ");
                stringBuffer.append(e);
                throw new EvalError(stringBuffer.toString(), simpleNode, callStack);
            } catch (InvocationTargetException e2) {
                TargetError targetError = new TargetError("Exception invoking imported object method.", e2, simpleNode, callStack, true);
                throw targetError;
            }
        } else if (this.f512b == null || !this.f512b.hasModifier("synchronized")) {
            return m310b(objArr, interpreter, callStack, simpleNode, z);
        } else {
            if (this.f511a.f622d) {
                try {
                    obj = this.f511a.mo852a();
                } catch (UtilEvalError unused) {
                    throw new InterpreterError("Can't get class instance for synchronized method.");
                }
            } else {
                obj = this.f511a.mo645a(interpreter);
            }
            synchronized (obj) {
                b = m310b(objArr, interpreter, callStack, simpleNode, z);
            }
            return b;
        }
    }

    public Modifiers getModifiers() {
        return this.f512b;
    }

    public String getName() {
        return this.f514d;
    }

    public String[] getParameterNames() {
        return this.f516f;
    }

    public Class[] getParameterTypes() {
        return this.f518h;
    }

    public Class getReturnType() {
        return this.f515e;
    }

    public boolean hasModifier(String str) {
        return this.f512b != null && this.f512b.hasModifier(str);
    }

    public Object invoke(Object[] objArr, Interpreter interpreter) {
        return mo685a(objArr, interpreter, null, null, false);
    }

    public Object invoke(Object[] objArr, Interpreter interpreter, CallStack callStack, SimpleNode simpleNode) {
        return mo685a(objArr, interpreter, callStack, simpleNode, false);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scripted Method: ");
        stringBuffer.append(StringUtil.methodString(this.f514d, getParameterTypes()));
        return stringBuffer.toString();
    }
}
