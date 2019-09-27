package bsh;

class BSHPrimaryExpression extends SimpleNode {
    BSHPrimaryExpression(int i) {
        super(i);
    }

    /* renamed from: a */
    private Object m280a(boolean z, CallStack callStack, Interpreter interpreter) {
        Object jjtGetChild = jjtGetChild(0);
        int jjtGetNumChildren = jjtGetNumChildren();
        for (int i = 1; i < jjtGetNumChildren; i++) {
            jjtGetChild = ((BSHPrimarySuffix) jjtGetChild(i)).doSuffix(jjtGetChild, z, callStack, interpreter);
        }
        if (jjtGetChild instanceof SimpleNode) {
            if (jjtGetChild instanceof BSHAmbiguousName) {
                jjtGetChild = z ? ((BSHAmbiguousName) jjtGetChild).toLHS(callStack, interpreter) : ((BSHAmbiguousName) jjtGetChild).toObject(callStack, interpreter);
            } else if (z) {
                throw new EvalError("Can't assign to prefix.", this, callStack);
            } else {
                jjtGetChild = ((SimpleNode) jjtGetChild).eval(callStack, interpreter);
            }
        }
        if (!(jjtGetChild instanceof LHS) || z) {
            return jjtGetChild;
        }
        try {
            return ((LHS) jjtGetChild).getValue();
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callStack);
        }
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        return m280a(false, callStack, interpreter);
    }

    public LHS toLHS(CallStack callStack, Interpreter interpreter) {
        Object a = m280a(true, callStack, interpreter);
        if (a instanceof LHS) {
            return (LHS) a;
        }
        throw new EvalError("Can't assign to:", this, callStack);
    }
}
