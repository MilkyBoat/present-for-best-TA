package bsh;

import java.util.Vector;

class BSHTryStatement extends SimpleNode {
    BSHTryStatement(int i) {
        super(i);
    }

    /* JADX INFO: finally extract failed */
    public Object eval(CallStack callStack, Interpreter interpreter) {
        Node node;
        Object obj;
        BSHFormalParameter bSHFormalParameter;
        Object obj2;
        int i = 0;
        BSHBlock bSHBlock = (BSHBlock) jjtGetChild(0);
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        int jjtGetNumChildren = jjtGetNumChildren();
        int i2 = 1;
        while (true) {
            if (i2 >= jjtGetNumChildren) {
                node = null;
                break;
            }
            int i3 = i2 + 1;
            node = jjtGetChild(i2);
            if (!(node instanceof BSHFormalParameter)) {
                break;
            }
            vector.addElement(node);
            i2 = i3 + 1;
            vector2.addElement(jjtGetChild(i3));
        }
        BSHBlock bSHBlock2 = node != null ? (BSHBlock) node : null;
        int depth = callStack.depth();
        try {
            obj = bSHBlock.eval(callStack, interpreter);
            e = null;
        } catch (TargetError e) {
            e = e;
            String str = "Bsh Stack: ";
            while (callStack.depth() > depth) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append("\t");
                stringBuffer.append(callStack.pop());
                stringBuffer.append("\n");
                str = stringBuffer.toString();
            }
            obj = null;
        }
        Object target = e != null ? e.getTarget() : null;
        if (target != null) {
            int size = vector.size();
            while (true) {
                if (i >= size) {
                    break;
                }
                bSHFormalParameter = (BSHFormalParameter) vector.elementAt(i);
                bSHFormalParameter.eval(callStack, interpreter);
                if (bSHFormalParameter.type != null || !interpreter.getStrictJava()) {
                    if (bSHFormalParameter.type == null) {
                        obj2 = target;
                        break;
                    }
                    try {
                        obj2 = (Throwable) Types.castObject(target, bSHFormalParameter.type, 1);
                        break;
                    } catch (UtilEvalError unused) {
                        i++;
                    }
                } else {
                    throw new EvalError("(Strict Java) Untyped catch block", this, callStack);
                }
            }
            BSHBlock bSHBlock3 = (BSHBlock) vector2.elementAt(i);
            NameSpace pVar = callStack.top();
            BlockNameSpace blockNameSpace = new BlockNameSpace(pVar);
            try {
                if (bSHFormalParameter.type == BSHFormalParameter.UNTYPED) {
                    blockNameSpace.setBlockVariable(bSHFormalParameter.name, obj2);
                } else {
                    new Modifiers();
                    blockNameSpace.setTypedVariable(bSHFormalParameter.name, bSHFormalParameter.type, obj2, new Modifiers());
                }
                callStack.swap(blockNameSpace);
                try {
                    obj = bSHBlock3.eval(callStack, interpreter);
                    callStack.swap(pVar);
                    e = null;
                } catch (Throwable th) {
                    callStack.swap(pVar);
                    throw th;
                }
            } catch (UtilEvalError unused2) {
                throw new InterpreterError("Unable to set var in catch block namespace.");
            }
        }
        if (bSHBlock2 != null) {
            obj = bSHBlock2.eval(callStack, interpreter);
        }
        if (e == null) {
            return obj instanceof ReturnControl ? obj : Primitive.VOID;
        }
        throw e;
    }
}
