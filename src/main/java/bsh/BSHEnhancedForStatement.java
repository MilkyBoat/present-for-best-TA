package bsh;

class BSHEnhancedForStatement extends SimpleNode implements ParserConstants {

    /* renamed from: a */
    String f477a;

    BSHEnhancedForStatement(int i) {
        super(i);
    }

    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [bsh.SimpleNode] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v4, types: [bsh.SimpleNode] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r5v5, types: [bsh.SimpleNode] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b8, code lost:
        if (r9 == 46) goto L_0x00bc;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c7 A[LOOP:0: B:18:0x007c->B:42:0x00c7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c2 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object eval(bsh.CallStack r12, bsh.Interpreter r13) {
        /*
            r11 = this;
            bsh.NameSpace r0 = r12.top()
            r1 = 0
            bsh.Node r2 = r11.jjtGetChild(r1)
            bsh.SimpleNode r2 = (bsh.SimpleNode) r2
            int r3 = r11.jjtGetNumChildren()
            boolean r4 = r2 instanceof bsh.BSHType
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x002f
            bsh.BSHType r2 = (bsh.BSHType) r2
            java.lang.Class r2 = r2.getType(r12, r13)
            bsh.Node r4 = r11.jjtGetChild(r6)
            bsh.SimpleNode r4 = (bsh.SimpleNode) r4
            r7 = 2
            if (r3 <= r7) goto L_0x002b
            bsh.Node r3 = r11.jjtGetChild(r7)
            r5 = r3
            bsh.SimpleNode r5 = (bsh.SimpleNode) r5
        L_0x002b:
            r3 = r5
            r5 = r2
            r2 = r4
            goto L_0x0039
        L_0x002f:
            if (r3 <= r6) goto L_0x0038
            bsh.Node r3 = r11.jjtGetChild(r6)
            bsh.SimpleNode r3 = (bsh.SimpleNode) r3
            goto L_0x0039
        L_0x0038:
            r3 = r5
        L_0x0039:
            bsh.BlockNameSpace r4 = new bsh.BlockNameSpace
            r4.<init>(r0)
            r12.swap(r4)
            java.lang.Object r2 = r2.eval(r12, r13)
            bsh.Primitive r7 = bsh.Primitive.NULL
            if (r2 != r7) goto L_0x0051
            bsh.EvalError r13 = new bsh.EvalError
            java.lang.String r0 = "The collection, array, map, iterator, or enumeration portion of a for statement cannot be null."
            r13.<init>(r0, r11, r12)
            throw r13
        L_0x0051:
            bsh.CollectionManager r7 = bsh.CollectionManager.getCollectionManager()
            boolean r8 = r7.isBshIterable(r2)
            if (r8 != 0) goto L_0x0076
            bsh.EvalError r13 = new bsh.EvalError
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "Can't iterate over type: "
            r0.append(r1)
            java.lang.Class r1 = r2.getClass()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0, r11, r12)
            throw r13
        L_0x0076:
            bsh.BshIterator r2 = r7.getBshIterator(r2)
            bsh.Primitive r7 = bsh.Primitive.VOID
        L_0x007c:
            boolean r8 = r2.hasNext()
            if (r8 != 0) goto L_0x0083
            goto L_0x00c3
        L_0x0083:
            if (r5 == 0) goto L_0x0096
            java.lang.String r8 = r11.f477a     // Catch:{ UtilEvalError -> 0x0094 }
            java.lang.Object r9 = r2.next()     // Catch:{ UtilEvalError -> 0x0094 }
            bsh.Modifiers r10 = new bsh.Modifiers     // Catch:{ UtilEvalError -> 0x0094 }
            r10.<init>()     // Catch:{ UtilEvalError -> 0x0094 }
            r4.setTypedVariable(r8, r5, r9, r10)     // Catch:{ UtilEvalError -> 0x0094 }
            goto L_0x009f
        L_0x0094:
            r13 = move-exception
            goto L_0x00c9
        L_0x0096:
            java.lang.String r8 = r11.f477a     // Catch:{ UtilEvalError -> 0x0094 }
            java.lang.Object r9 = r2.next()     // Catch:{ UtilEvalError -> 0x0094 }
            r4.setVariable(r8, r9, r1)     // Catch:{ UtilEvalError -> 0x0094 }
        L_0x009f:
            if (r3 == 0) goto L_0x00be
            java.lang.Object r8 = r3.eval(r12, r13)
            boolean r9 = r8 instanceof bsh.ReturnControl
            if (r9 == 0) goto L_0x00be
            r9 = r8
            bsh.ReturnControl r9 = (bsh.ReturnControl) r9
            int r9 = r9.kind
            r10 = 12
            if (r9 == r10) goto L_0x00bb
            r10 = 19
            if (r9 == r10) goto L_0x00be
            r10 = 46
            if (r9 == r10) goto L_0x00bc
            goto L_0x00be
        L_0x00bb:
            r8 = r7
        L_0x00bc:
            r7 = 1
            goto L_0x00c0
        L_0x00be:
            r8 = r7
            r7 = 0
        L_0x00c0:
            if (r7 == 0) goto L_0x00c7
            r7 = r8
        L_0x00c3:
            r12.swap(r0)
            return r7
        L_0x00c7:
            r7 = r8
            goto L_0x007c
        L_0x00c9:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "for loop iterator variable:"
            r0.append(r1)
            java.lang.String r1 = r11.f477a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            bsh.EvalError r12 = r13.toEvalError(r0, r11, r12)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.BSHEnhancedForStatement.eval(bsh.CallStack, bsh.Interpreter):java.lang.Object");
    }
}
