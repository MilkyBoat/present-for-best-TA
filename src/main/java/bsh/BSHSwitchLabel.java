package bsh;

class BSHSwitchLabel extends SimpleNode {

    /* renamed from: a */
    boolean f492a;

    public BSHSwitchLabel(int i) {
        super(i);
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        if (this.f492a) {
            return null;
        }
        return ((SimpleNode) jjtGetChild(0)).eval(callStack, interpreter);
    }
}
