package bsh;

class BSHTernaryExpression extends SimpleNode {
    BSHTernaryExpression(int i) {
        super(i);
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        return BSHIfStatement.evaluateCondition((SimpleNode) jjtGetChild(0), callStack, interpreter) ? ((SimpleNode) jjtGetChild(1)).eval(callStack, interpreter) : ((SimpleNode) jjtGetChild(2)).eval(callStack, interpreter);
    }
}
