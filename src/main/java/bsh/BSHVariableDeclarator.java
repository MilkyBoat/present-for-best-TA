package bsh;

class BSHVariableDeclarator extends SimpleNode {
    public String name;

    BSHVariableDeclarator(int i) {
        super(i);
    }

    public Object eval(BSHType bSHType, CallStack callStack, Interpreter interpreter) {
        Object obj;
        if (jjtGetNumChildren() > 0) {
            SimpleNode simpleNode = (SimpleNode) jjtGetChild(0);
            obj = (bSHType == null || !(simpleNode instanceof BSHArrayInitializer)) ? simpleNode.eval(callStack, interpreter) : ((BSHArrayInitializer) simpleNode).eval(bSHType.getBaseType(), bSHType.getArrayDims(), callStack, interpreter);
        } else {
            obj = null;
        }
        if (obj != Primitive.VOID) {
            return obj;
        }
        throw new EvalError("Void initializer.", this, callStack);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("BSHVariableDeclarator ");
        stringBuffer.append(this.name);
        return stringBuffer.toString();
    }
}
