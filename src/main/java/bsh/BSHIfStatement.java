package bsh;

class BSHIfStatement extends SimpleNode {
    BSHIfStatement(int i) {
        super(i);
    }

    public static boolean evaluateCondition(SimpleNode simpleNode, CallStack callStack, Interpreter interpreter) {
        Object eval = simpleNode.eval(callStack, interpreter);
        if (eval instanceof Primitive) {
            if (eval == Primitive.VOID) {
                throw new EvalError("Condition evaluates to void type", simpleNode, callStack);
            }
            eval = ((Primitive) eval).getValue();
        }
        if (eval instanceof Boolean) {
            return ((Boolean) eval).booleanValue();
        }
        throw new EvalError("Condition must evaluate to a Boolean or boolean.", simpleNode, callStack);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object eval(bsh.CallStack r3, bsh.Interpreter r4) {
        /*
            r2 = this;
            r0 = 0
            bsh.Node r0 = r2.jjtGetChild(r0)
            bsh.SimpleNode r0 = (bsh.SimpleNode) r0
            boolean r0 = evaluateCondition(r0, r3, r4)
            if (r0 == 0) goto L_0x0019
            r0 = 1
            bsh.Node r0 = r2.jjtGetChild(r0)
        L_0x0012:
            bsh.SimpleNode r0 = (bsh.SimpleNode) r0
            java.lang.Object r3 = r0.eval(r3, r4)
            goto L_0x0026
        L_0x0019:
            int r0 = r2.jjtGetNumChildren()
            r1 = 2
            if (r0 <= r1) goto L_0x0025
            bsh.Node r0 = r2.jjtGetChild(r1)
            goto L_0x0012
        L_0x0025:
            r3 = 0
        L_0x0026:
            boolean r4 = r3 instanceof bsh.ReturnControl
            if (r4 == 0) goto L_0x002b
            return r3
        L_0x002b:
            bsh.Primitive r3 = bsh.Primitive.VOID
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.BSHIfStatement.eval(bsh.CallStack, bsh.Interpreter):java.lang.Object");
    }
}
