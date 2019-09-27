package bsh;

class BSHBlock extends SimpleNode {
    public boolean isSynchronized = false;

    public interface NodeFilter {
        boolean isVisible(SimpleNode simpleNode);
    }

    BSHBlock(int i) {
        super(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo614a(CallStack callStack, Interpreter interpreter, boolean z, NodeFilter nodeFilter) {
        NameSpace nameSpace;
        Object obj = Primitive.VOID;
        if (!z) {
            nameSpace = callStack.top();
            callStack.swap(new BlockNameSpace(nameSpace));
        } else {
            nameSpace = null;
        }
        int i = this.isSynchronized;
        int jjtGetNumChildren = jjtGetNumChildren();
        for (int i2 = i; i2 < jjtGetNumChildren; i2++) {
            SimpleNode simpleNode = (SimpleNode) jjtGetChild(i2);
            if (nodeFilter == null || nodeFilter.isVisible(simpleNode)) {
                if (simpleNode instanceof BSHClassDeclaration) {
                    simpleNode.eval(callStack, interpreter);
                }
            }
        }
        while (i < jjtGetNumChildren) {
            try {
                SimpleNode simpleNode2 = (SimpleNode) jjtGetChild(i);
                if (!(simpleNode2 instanceof BSHClassDeclaration)) {
                    if (nodeFilter == null || nodeFilter.isVisible(simpleNode2)) {
                        obj = simpleNode2.eval(callStack, interpreter);
                        if (obj instanceof ReturnControl) {
                            break;
                        }
                    }
                }
                i++;
            } catch (Throwable th) {
                if (!z) {
                    callStack.swap(nameSpace);
                }
                throw th;
            }
        }
        if (!z) {
            callStack.swap(nameSpace);
        }
        return obj;
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        return eval(callStack, interpreter, false);
    }

    public Object eval(CallStack callStack, Interpreter interpreter, boolean z) {
        Object a;
        Object eval = this.isSynchronized ? ((SimpleNode) jjtGetChild(0)).eval(callStack, interpreter) : null;
        if (!this.isSynchronized) {
            return mo614a(callStack, interpreter, z, null);
        }
        synchronized (eval) {
            a = mo614a(callStack, interpreter, z, null);
        }
        return a;
    }
}
