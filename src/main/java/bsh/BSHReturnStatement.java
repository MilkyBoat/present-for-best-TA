package bsh;

class BSHReturnStatement extends SimpleNode implements ParserConstants {
    public int kind;

    BSHReturnStatement(int i) {
        super(i);
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        return new ReturnControl(this.kind, jjtGetNumChildren() > 0 ? ((SimpleNode) jjtGetChild(0)).eval(callStack, interpreter) : Primitive.VOID, this);
    }
}
