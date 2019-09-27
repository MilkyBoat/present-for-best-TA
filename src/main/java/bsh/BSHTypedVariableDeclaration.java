package bsh;

class BSHTypedVariableDeclaration extends SimpleNode {
    public Modifiers modifiers;

    BSHTypedVariableDeclaration(int i) {
        super(i);
    }

    /* renamed from: b */
    private BSHType m288b() {
        return (BSHType) jjtGetChild(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public BSHVariableDeclarator[] mo642a() {
        int jjtGetNumChildren = jjtGetNumChildren();
        BSHVariableDeclarator[] bSHVariableDeclaratorArr = new BSHVariableDeclarator[(jjtGetNumChildren - 1)];
        for (int i = 1; i < jjtGetNumChildren; i++) {
            bSHVariableDeclaratorArr[i - 1] = (BSHVariableDeclarator) jjtGetChild(i);
        }
        return bSHVariableDeclaratorArr;
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        try {
            NameSpace pVar = callStack.top();
            BSHType b = m288b();
            Class type = b.getType(callStack, interpreter);
            BSHVariableDeclarator[] a = mo642a();
            for (BSHVariableDeclarator bSHVariableDeclarator : a) {
                pVar.setTypedVariable(bSHVariableDeclarator.name, type, bSHVariableDeclarator.eval(b, callStack, interpreter), this.modifiers);
            }
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callStack);
        } catch (EvalError e2) {
            e2.reThrow("Typed variable declaration");
        }
        return Primitive.VOID;
    }

    public String getTypeDescriptor(CallStack callStack, Interpreter interpreter, String str) {
        return m288b().getTypeDescriptor(callStack, interpreter, str);
    }
}
