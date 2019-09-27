package bsh;

class BSHThrowStatement extends SimpleNode {
    BSHThrowStatement(int i) {
        super(i);
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        Object eval = ((SimpleNode) jjtGetChild(0)).eval(callStack, interpreter);
        if (!(eval instanceof Exception)) {
            throw new EvalError("Expression in 'throw' must be Exception type", this, callStack);
        }
        throw new TargetError((Exception) eval, this, callStack);
    }
}
