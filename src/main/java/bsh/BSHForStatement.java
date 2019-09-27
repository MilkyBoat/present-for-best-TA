package bsh;

class BSHForStatement extends SimpleNode implements ParserConstants {

    /* renamed from: a */
    private SimpleNode f478a;

    /* renamed from: b */
    private SimpleNode f479b;

    /* renamed from: c */
    private SimpleNode f480c;

    /* renamed from: d */
    private SimpleNode f481d;
    public boolean hasExpression;
    public boolean hasForInit;
    public boolean hasForUpdate;

    BSHForStatement(int i) {
        super(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        if (r5 == 46) goto L_0x0082;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0088 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object eval(bsh.CallStack r8, bsh.Interpreter r9) {
        /*
            r7 = this;
            boolean r0 = r7.hasForInit
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0010
            bsh.Node r0 = r7.jjtGetChild(r1)
            bsh.SimpleNode r0 = (bsh.SimpleNode) r0
            r7.f478a = r0
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            boolean r3 = r7.hasExpression
            if (r3 == 0) goto L_0x0020
            int r3 = r0 + 1
            bsh.Node r0 = r7.jjtGetChild(r0)
            bsh.SimpleNode r0 = (bsh.SimpleNode) r0
            r7.f479b = r0
            r0 = r3
        L_0x0020:
            boolean r3 = r7.hasForUpdate
            if (r3 == 0) goto L_0x002f
            int r3 = r0 + 1
            bsh.Node r0 = r7.jjtGetChild(r0)
            bsh.SimpleNode r0 = (bsh.SimpleNode) r0
            r7.f480c = r0
            r0 = r3
        L_0x002f:
            int r3 = r7.jjtGetNumChildren()
            if (r0 >= r3) goto L_0x003d
            bsh.Node r0 = r7.jjtGetChild(r0)
            bsh.SimpleNode r0 = (bsh.SimpleNode) r0
            r7.f481d = r0
        L_0x003d:
            bsh.NameSpace r0 = r8.top()
            bsh.BlockNameSpace r3 = new bsh.BlockNameSpace
            r3.<init>(r0)
            r8.swap(r3)
            boolean r3 = r7.hasForInit
            if (r3 == 0) goto L_0x0052
            bsh.SimpleNode r3 = r7.f478a
            r3.eval(r8, r9)
        L_0x0052:
            bsh.Primitive r3 = bsh.Primitive.VOID
        L_0x0054:
            boolean r4 = r7.hasExpression
            if (r4 == 0) goto L_0x0061
            bsh.SimpleNode r4 = r7.f479b
            boolean r4 = bsh.BSHIfStatement.evaluateCondition(r4, r8, r9)
            if (r4 != 0) goto L_0x0061
            goto L_0x0089
        L_0x0061:
            bsh.SimpleNode r4 = r7.f481d
            if (r4 == 0) goto L_0x0084
            bsh.SimpleNode r4 = r7.f481d
            java.lang.Object r4 = r4.eval(r8, r9)
            boolean r5 = r4 instanceof bsh.ReturnControl
            if (r5 == 0) goto L_0x0084
            r5 = r4
            bsh.ReturnControl r5 = (bsh.ReturnControl) r5
            int r5 = r5.kind
            r6 = 12
            if (r5 == r6) goto L_0x0081
            r6 = 19
            if (r5 == r6) goto L_0x0084
            r6 = 46
            if (r5 == r6) goto L_0x0082
            goto L_0x0084
        L_0x0081:
            r4 = r3
        L_0x0082:
            r3 = 1
            goto L_0x0086
        L_0x0084:
            r4 = r3
            r3 = 0
        L_0x0086:
            if (r3 == 0) goto L_0x008d
            r3 = r4
        L_0x0089:
            r8.swap(r0)
            return r3
        L_0x008d:
            boolean r3 = r7.hasForUpdate
            if (r3 == 0) goto L_0x0096
            bsh.SimpleNode r3 = r7.f480c
            r3.eval(r8, r9)
        L_0x0096:
            r3 = r4
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.BSHForStatement.eval(bsh.CallStack, bsh.Interpreter):java.lang.Object");
    }
}
