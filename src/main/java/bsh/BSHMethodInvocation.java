package bsh;

import java.lang.reflect.InvocationTargetException;

class BSHMethodInvocation extends SimpleNode {
    BSHMethodInvocation(int i) {
        super(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public BSHAmbiguousName mo627a() {
        return (BSHAmbiguousName) jjtGetChild(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public BSHArguments mo628b() {
        return (BSHArguments) jjtGetChild(1);
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        NameSpace pVar = callStack.top();
        BSHAmbiguousName a = mo627a();
        if (pVar.getParent() != null && pVar.getParent().f622d && (a.text.equals("super") || a.text.equals("this"))) {
            return Primitive.VOID;
        }
        Name name = a.getName(pVar);
        try {
            return name.invokeMethod(interpreter, mo628b().getArguments(callStack, interpreter), callStack, this);
        } catch (ReflectError e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error in method invocation: ");
            stringBuffer.append(e.getMessage());
            throw new EvalError(stringBuffer.toString(), this, callStack);
        } catch (InvocationTargetException e2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Method Invocation ");
            stringBuffer2.append(name);
            String stringBuffer3 = stringBuffer2.toString();
            Throwable targetException = e2.getTargetException();
            boolean z = targetException instanceof EvalError ? targetException instanceof TargetError ? ((TargetError) targetException).inNativeCode() : false : true;
            TargetError targetError = new TargetError(stringBuffer3, targetException, this, callStack, z);
            throw targetError;
        } catch (UtilEvalError e3) {
            throw e3.toEvalError(this, callStack);
        }
    }
}
