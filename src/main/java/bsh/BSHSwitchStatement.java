package bsh;

class BSHSwitchStatement extends SimpleNode implements ParserConstants {
    public BSHSwitchStatement(int i) {
        super(i);
    }

    /* renamed from: a */
    private boolean m286a(Object obj, Object obj2, CallStack callStack, SimpleNode simpleNode) {
        if (!(obj instanceof Primitive) && !(obj2 instanceof Primitive)) {
            return obj.equals(obj2);
        }
        try {
            return Primitive.unwrap(Primitive.binaryOperation(obj, obj2, 90)).equals(Boolean.TRUE);
        } catch (UtilEvalError e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Switch value: ");
            stringBuffer.append(simpleNode.getText());
            stringBuffer.append(": ");
            throw e.toEvalError(stringBuffer.toString(), this, callStack);
        }
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        int i;
        int jjtGetNumChildren = jjtGetNumChildren();
        SimpleNode simpleNode = (SimpleNode) jjtGetChild(0);
        Object eval = simpleNode.eval(callStack, interpreter);
        if (1 >= jjtGetNumChildren) {
            throw new EvalError("Empty switch statement.", this, callStack);
        }
        int i2 = 2;
        BSHSwitchLabel bSHSwitchLabel = (BSHSwitchLabel) jjtGetChild(1);
        ReturnControl returnControl = null;
        while (i2 < jjtGetNumChildren && returnControl == null) {
            if (bSHSwitchLabel.f492a || m286a(eval, bSHSwitchLabel.eval(callStack, interpreter), callStack, simpleNode)) {
                while (true) {
                    if (i2 >= jjtGetNumChildren) {
                        break;
                    }
                    i = i2 + 1;
                    Node jjtGetChild = jjtGetChild(i2);
                    if (!(jjtGetChild instanceof BSHSwitchLabel)) {
                        Object eval2 = ((SimpleNode) jjtGetChild).eval(callStack, interpreter);
                        if (eval2 instanceof ReturnControl) {
                            returnControl = (ReturnControl) eval2;
                            break;
                        }
                    }
                    i2 = i;
                }
            } else {
                while (true) {
                    if (i2 >= jjtGetNumChildren) {
                        break;
                    }
                    i = i2 + 1;
                    Node jjtGetChild2 = jjtGetChild(i2);
                    if (jjtGetChild2 instanceof BSHSwitchLabel) {
                        bSHSwitchLabel = (BSHSwitchLabel) jjtGetChild2;
                        break;
                    }
                    i2 = i;
                }
            }
            i2 = i;
        }
        return (returnControl == null || returnControl.kind != 46) ? Primitive.VOID : returnControl;
    }
}
