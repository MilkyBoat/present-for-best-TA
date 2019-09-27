package bsh;

public class DelayedEvalBshMethod extends BshMethod {

    /* renamed from: d */
    String f555d;

    /* renamed from: e */
    BSHReturnType f556e;

    /* renamed from: f */
    String[] f557f;

    /* renamed from: g */
    BSHFormalParameters f558g;

    /* renamed from: h */
    transient CallStack f559h;

    /* renamed from: i */
    transient Interpreter f560i;

    DelayedEvalBshMethod(String str, String str2, BSHReturnType bSHReturnType, String[] strArr, String[] strArr2, BSHFormalParameters bSHFormalParameters, BSHBlock bSHBlock, NameSpace nameSpace, Modifiers modifiers, CallStack callStack, Interpreter interpreter) {
        super(str, null, strArr, null, bSHBlock, nameSpace, modifiers);
        this.f555d = str2;
        this.f556e = bSHReturnType;
        this.f557f = strArr2;
        this.f558g = bSHFormalParameters;
        this.f559h = callStack;
        this.f560i = interpreter;
    }

    public String[] getParamTypeDescriptors() {
        return this.f557f;
    }

    public Class[] getParameterTypes() {
        try {
            return (Class[]) this.f558g.eval(this.f559h, this.f560i);
        } catch (EvalError e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("can't eval param types: ");
            stringBuffer.append(e);
            throw new InterpreterError(stringBuffer.toString());
        }
    }

    public Class getReturnType() {
        if (this.f556e == null) {
            return null;
        }
        try {
            return this.f556e.evalReturnType(this.f559h, this.f560i);
        } catch (EvalError e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("can't eval return type: ");
            stringBuffer.append(e);
            throw new InterpreterError(stringBuffer.toString());
        }
    }

    public String getReturnTypeDescriptor() {
        return this.f555d;
    }
}
