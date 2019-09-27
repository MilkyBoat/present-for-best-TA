package bsh;

class BSHMethodDeclaration extends SimpleNode {

    /* renamed from: a */
    BSHReturnType f486a;

    /* renamed from: b */
    BSHFormalParameters f487b;

    /* renamed from: c */
    BSHBlock f488c;

    /* renamed from: d */
    int f489d;

    /* renamed from: e */
    Class f490e;

    /* renamed from: f */
    int f491f = 0;
    public Modifiers modifiers;
    public String name;

    BSHMethodDeclaration(int i) {
        super(i);
    }

    /* renamed from: b */
    private void m273b(CallStack callStack, Interpreter interpreter) {
        mo625a();
        for (int i = this.f489d; i < this.f491f + this.f489d; i++) {
            ((BSHAmbiguousName) jjtGetChild(i)).toClass(callStack, interpreter);
        }
        this.f487b.eval(callStack, interpreter);
        if (interpreter.getStrictJava()) {
            for (int i2 = 0; i2 < this.f487b.f482a.length; i2++) {
                if (this.f487b.f482a[i2] == null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("(Strict Java Mode) Undeclared argument type, parameter: ");
                    stringBuffer.append(this.f487b.getParamNames()[i2]);
                    stringBuffer.append(" in method: ");
                    stringBuffer.append(this.name);
                    throw new EvalError(stringBuffer.toString(), this, null);
                }
            }
            if (this.f490e == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("(Strict Java Mode) Undeclared return type for method: ");
                stringBuffer2.append(this.name);
                throw new EvalError(stringBuffer2.toString(), this, null);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Class mo623a(CallStack callStack, Interpreter interpreter) {
        mo625a();
        if (this.f486a != null) {
            return this.f486a.evalReturnType(callStack, interpreter);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo624a(CallStack callStack, Interpreter interpreter, String str) {
        mo625a();
        if (this.f486a == null) {
            return null;
        }
        return this.f486a.getTypeDescriptor(callStack, interpreter, str);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo625a() {
        /*
            r4 = this;
            monitor-enter(r4)
            bsh.BSHFormalParameters r0 = r4.f487b     // Catch:{ all -> 0x0050 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            r0 = 0
            bsh.Node r1 = r4.jjtGetChild(r0)     // Catch:{ all -> 0x0050 }
            r2 = 1
            r4.f489d = r2     // Catch:{ all -> 0x0050 }
            boolean r3 = r1 instanceof bsh.BSHReturnType     // Catch:{ all -> 0x0050 }
            if (r3 == 0) goto L_0x003b
            bsh.BSHReturnType r1 = (bsh.BSHReturnType) r1     // Catch:{ all -> 0x0050 }
            r4.f486a = r1     // Catch:{ all -> 0x0050 }
            bsh.Node r0 = r4.jjtGetChild(r2)     // Catch:{ all -> 0x0050 }
            bsh.BSHFormalParameters r0 = (bsh.BSHFormalParameters) r0     // Catch:{ all -> 0x0050 }
            r4.f487b = r0     // Catch:{ all -> 0x0050 }
            int r0 = r4.jjtGetNumChildren()     // Catch:{ all -> 0x0050 }
            int r1 = r4.f491f     // Catch:{ all -> 0x0050 }
            int r1 = r1 + 2
            if (r0 <= r1) goto L_0x0035
            int r0 = r4.f491f     // Catch:{ all -> 0x0050 }
            int r0 = r0 + 2
            bsh.Node r0 = r4.jjtGetChild(r0)     // Catch:{ all -> 0x0050 }
            bsh.BSHBlock r0 = (bsh.BSHBlock) r0     // Catch:{ all -> 0x0050 }
            r4.f488c = r0     // Catch:{ all -> 0x0050 }
        L_0x0035:
            int r0 = r4.f489d     // Catch:{ all -> 0x0050 }
            int r0 = r0 + r2
            r4.f489d = r0     // Catch:{ all -> 0x0050 }
            goto L_0x004e
        L_0x003b:
            bsh.Node r0 = r4.jjtGetChild(r0)     // Catch:{ all -> 0x0050 }
            bsh.BSHFormalParameters r0 = (bsh.BSHFormalParameters) r0     // Catch:{ all -> 0x0050 }
            r4.f487b = r0     // Catch:{ all -> 0x0050 }
            int r0 = r4.f491f     // Catch:{ all -> 0x0050 }
            int r0 = r0 + r2
            bsh.Node r0 = r4.jjtGetChild(r0)     // Catch:{ all -> 0x0050 }
            bsh.BSHBlock r0 = (bsh.BSHBlock) r0     // Catch:{ all -> 0x0050 }
            r4.f488c = r0     // Catch:{ all -> 0x0050 }
        L_0x004e:
            monitor-exit(r4)
            return
        L_0x0050:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.BSHMethodDeclaration.mo625a():void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public BSHReturnType mo626b() {
        mo625a();
        return this.f486a;
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        this.f490e = mo623a(callStack, interpreter);
        m273b(callStack, interpreter);
        NameSpace pVar = callStack.top();
        try {
            pVar.setMethod(this.name, new BshMethod(this, pVar, this.modifiers));
            return Primitive.VOID;
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callStack);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MethodDeclaration: ");
        stringBuffer.append(this.name);
        return stringBuffer.toString();
    }
}
