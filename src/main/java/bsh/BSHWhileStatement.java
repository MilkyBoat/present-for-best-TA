package bsh;

class BSHWhileStatement extends SimpleNode implements ParserConstants {
    public boolean isDoStatement;

    BSHWhileStatement(int i) {
        super(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0058 A[EDGE_INSN: B:30:0x0058->B:24:0x0058 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object eval(bsh.CallStack r10, bsh.Interpreter r11) {
        /*
            r9 = this;
            int r0 = r9.jjtGetNumChildren()
            boolean r1 = r9.isDoStatement
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001a
            bsh.Node r0 = r9.jjtGetChild(r3)
            bsh.SimpleNode r0 = (bsh.SimpleNode) r0
            bsh.Node r1 = r9.jjtGetChild(r2)
            bsh.SimpleNode r1 = (bsh.SimpleNode) r1
            r8 = r1
            r1 = r0
            r0 = r8
            goto L_0x002a
        L_0x001a:
            bsh.Node r1 = r9.jjtGetChild(r2)
            bsh.SimpleNode r1 = (bsh.SimpleNode) r1
            if (r0 <= r3) goto L_0x0029
            bsh.Node r0 = r9.jjtGetChild(r3)
            bsh.SimpleNode r0 = (bsh.SimpleNode) r0
            goto L_0x002a
        L_0x0029:
            r0 = 0
        L_0x002a:
            boolean r4 = r9.isDoStatement
        L_0x002c:
            if (r4 != 0) goto L_0x0035
            boolean r5 = bsh.BSHIfStatement.evaluateCondition(r1, r10, r11)
            if (r5 != 0) goto L_0x0035
            goto L_0x0058
        L_0x0035:
            if (r0 != 0) goto L_0x0038
            goto L_0x002c
        L_0x0038:
            java.lang.Object r5 = r0.eval(r10, r11)
            boolean r6 = r5 instanceof bsh.ReturnControl
            if (r6 == 0) goto L_0x0055
            r6 = r5
            bsh.ReturnControl r6 = (bsh.ReturnControl) r6
            int r6 = r6.kind
            r7 = 12
            if (r6 == r7) goto L_0x0053
            r7 = 19
            if (r6 == r7) goto L_0x002c
            r4 = 46
            if (r6 == r4) goto L_0x0052
            goto L_0x0055
        L_0x0052:
            return r5
        L_0x0053:
            r4 = 1
            goto L_0x0056
        L_0x0055:
            r4 = 0
        L_0x0056:
            if (r4 == 0) goto L_0x005b
        L_0x0058:
            bsh.Primitive r10 = bsh.Primitive.VOID
            return r10
        L_0x005b:
            r4 = 0
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.BSHWhileStatement.eval(bsh.CallStack, bsh.Interpreter):java.lang.Object");
    }
}
