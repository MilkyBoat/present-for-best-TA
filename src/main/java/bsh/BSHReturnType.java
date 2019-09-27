package bsh;

class BSHReturnType extends SimpleNode {
    public boolean isVoid;

    BSHReturnType(int i) {
        super(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public BSHType mo632a() {
        return (BSHType) jjtGetChild(0);
    }

    public Class evalReturnType(CallStack callStack, Interpreter interpreter) {
        return this.isVoid ? Void.TYPE : mo632a().getType(callStack, interpreter);
    }

    public String getTypeDescriptor(CallStack callStack, Interpreter interpreter, String str) {
        return this.isVoid ? "V" : mo632a().getTypeDescriptor(callStack, interpreter, str);
    }
}
