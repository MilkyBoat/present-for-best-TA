package bsh;

import java.lang.reflect.Array;

class BSHArrayDimensions extends SimpleNode {
    public Class baseType;
    public int[] definedDimensions;
    public int numDefinedDims;
    public int numUndefinedDims;

    BSHArrayDimensions(int i) {
        super(i);
    }

    public void addDefinedDimension() {
        this.numDefinedDims++;
    }

    public void addUndefinedDimension() {
        this.numUndefinedDims++;
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        int i = 0;
        SimpleNode simpleNode = (SimpleNode) jjtGetChild(0);
        if (!(simpleNode instanceof BSHArrayInitializer)) {
            this.definedDimensions = new int[this.numDefinedDims];
            while (i < this.numDefinedDims) {
                try {
                    this.definedDimensions[i] = ((Primitive) ((SimpleNode) jjtGetChild(i)).eval(callStack, interpreter)).intValue();
                    i++;
                } catch (Exception unused) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Array index: ");
                    stringBuffer.append(i);
                    stringBuffer.append(" does not evaluate to an integer");
                    throw new EvalError(stringBuffer.toString(), this, callStack);
                }
            }
            return Primitive.VOID;
        } else if (this.baseType == null) {
            throw new EvalError("Internal Array Eval err:  unknown base type", this, callStack);
        } else {
            Object eval = ((BSHArrayInitializer) simpleNode).eval(this.baseType, this.numUndefinedDims, callStack, interpreter);
            int arrayDimensions = Reflect.getArrayDimensions(eval.getClass());
            this.definedDimensions = new int[arrayDimensions];
            if (this.definedDimensions.length != this.numUndefinedDims) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Incompatible initializer. Allocation calls for a ");
                stringBuffer2.append(this.numUndefinedDims);
                stringBuffer2.append(" dimensional array, but initializer is a ");
                stringBuffer2.append(arrayDimensions);
                stringBuffer2.append(" dimensional array");
                throw new EvalError(stringBuffer2.toString(), this, callStack);
            }
            Object obj = eval;
            for (int i2 = 0; i2 < this.definedDimensions.length; i2++) {
                this.definedDimensions[i2] = Array.getLength(obj);
                if (this.definedDimensions[i2] > 0) {
                    obj = Array.get(obj, 0);
                }
            }
            return eval;
        }
    }

    public Object eval(Class cls, CallStack callStack, Interpreter interpreter) {
        if (Interpreter.DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("array base type = ");
            stringBuffer.append(cls);
            Interpreter.debug(stringBuffer.toString());
        }
        this.baseType = cls;
        return eval(callStack, interpreter);
    }
}
