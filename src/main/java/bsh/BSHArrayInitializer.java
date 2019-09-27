package bsh;

import java.lang.reflect.Array;

class BSHArrayInitializer extends SimpleNode {
    BSHArrayInitializer(int i) {
        super(i);
    }

    /* renamed from: a */
    private void m264a(Class cls, Object obj, int i, CallStack callStack) {
        String name = obj instanceof Primitive ? ((Primitive) obj).getType().getName() : Reflect.normalizeClassName(obj.getClass());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Incompatible type: ");
        stringBuffer.append(name);
        stringBuffer.append(" in initializer of array type: ");
        stringBuffer.append(cls);
        stringBuffer.append(" at position: ");
        stringBuffer.append(i);
        throw new EvalError(stringBuffer.toString(), this, callStack);
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        throw new EvalError("Array initializer has no base type.", this, callStack);
    }

    public Object eval(Class cls, int i, CallStack callStack, Interpreter interpreter) {
        Object obj;
        Object obj2;
        String str;
        StringBuffer stringBuffer;
        int jjtGetNumChildren = jjtGetNumChildren();
        int[] iArr = new int[i];
        iArr[0] = jjtGetNumChildren;
        Object newInstance = Array.newInstance(cls, iArr);
        int i2 = 0;
        while (i2 < jjtGetNumChildren) {
            SimpleNode simpleNode = (SimpleNode) jjtGetChild(i2);
            if (!(simpleNode instanceof BSHArrayInitializer)) {
                obj = simpleNode.eval(callStack, interpreter);
            } else if (i < 2) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Invalid Location for Intializer, position: ");
                stringBuffer2.append(i2);
                throw new EvalError(stringBuffer2.toString(), this, callStack);
            } else {
                obj = ((BSHArrayInitializer) simpleNode).eval(cls, i - 1, callStack, interpreter);
            }
            if (obj == Primitive.VOID) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Void in array initializer, position");
                stringBuffer3.append(i2);
                throw new EvalError(stringBuffer3.toString(), this, callStack);
            }
            if (i == 1) {
                try {
                    obj2 = Primitive.unwrap(Types.castObject(obj, cls, 0));
                } catch (UtilEvalError e) {
                    throw e.toEvalError("Error in array initializer", this, callStack);
                }
            } else {
                obj2 = obj;
            }
            try {
                Array.set(newInstance, i2, obj2);
            } catch (IllegalArgumentException e2) {
                e = e2;
                stringBuffer = new StringBuffer();
                str = "illegal arg";
            } catch (ArrayStoreException e3) {
                e = e3;
                stringBuffer = new StringBuffer();
                str = "arraystore";
            }
            i2++;
        }
        return newInstance;
        stringBuffer.append(str);
        stringBuffer.append(e);
        Interpreter.debug(stringBuffer.toString());
        m264a(cls, obj, i2, callStack);
        i2++;
    }
}
