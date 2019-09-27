package bsh;

class BSHStatementExpressionList extends SimpleNode {
    BSHStatementExpressionList(int i) {
        super(i);
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        int jjtGetNumChildren = jjtGetNumChildren();
        for (int i = 0; i < jjtGetNumChildren; i++) {
            ((SimpleNode) jjtGetChild(i)).eval(callStack, interpreter);
        }
        return Primitive.VOID;
    }
}
