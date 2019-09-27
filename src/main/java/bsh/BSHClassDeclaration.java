package bsh;

class BSHClassDeclaration extends SimpleNode {

    /* renamed from: a */
    String f472a;

    /* renamed from: b */
    Modifiers f473b;

    /* renamed from: c */
    int f474c;

    /* renamed from: d */
    boolean f475d;

    /* renamed from: e */
    boolean f476e;

    BSHClassDeclaration(int i) {
        super(i);
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        Class cls;
        int i;
        int i2 = 0;
        if (this.f475d) {
            i = 1;
            cls = ((BSHAmbiguousName) jjtGetChild(0)).toClass(callStack, interpreter);
        } else {
            cls = null;
            i = 0;
        }
        Class[] clsArr = new Class[this.f474c];
        while (i2 < this.f474c) {
            int i3 = i + 1;
            BSHAmbiguousName bSHAmbiguousName = (BSHAmbiguousName) jjtGetChild(i);
            clsArr[i2] = bSHAmbiguousName.toClass(callStack, interpreter);
            if (!clsArr[i2].isInterface()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Type: ");
                stringBuffer.append(bSHAmbiguousName.text);
                stringBuffer.append(" is not an interface!");
                throw new EvalError(stringBuffer.toString(), this, callStack);
            }
            i2++;
            i = i3;
        }
        try {
            return ClassGenerator.getClassGenerator().generateClass(this.f472a, this.f473b, clsArr, cls, i < jjtGetNumChildren() ? (BSHBlock) jjtGetChild(i) : new BSHBlock(25), this.f476e, callStack, interpreter);
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callStack);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClassDeclaration: ");
        stringBuffer.append(this.f472a);
        return stringBuffer.toString();
    }
}
