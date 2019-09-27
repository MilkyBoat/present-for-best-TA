package bsh;

class BSHUnaryExpression extends SimpleNode implements ParserConstants {
    public int kind;
    public boolean postfix = false;

    BSHUnaryExpression(int i) {
        super(i);
    }

    /* renamed from: a */
    private Object m290a(LHS lhs, boolean z) {
        if (Interpreter.DEBUG) {
            Interpreter.debug("lhsUnaryOperation");
        }
        Object value = lhs.getValue();
        Object a = m291a(value, this.kind);
        if (!this.postfix) {
            value = a;
        }
        lhs.assign(a, z);
        return value;
    }

    /* renamed from: a */
    private Object m291a(Object obj, int i) {
        if ((obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Number)) {
            return m292b(obj, i);
        }
        if (obj instanceof Primitive) {
            return Primitive.unaryOperation((Primitive) obj, i);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unary operation ");
        stringBuffer.append(ParserConstants.tokenImage[i]);
        stringBuffer.append(" inappropriate for object");
        throw new UtilEvalError(stringBuffer.toString());
    }

    /* renamed from: b */
    private Object m292b(Object obj, int i) {
        Class cls = obj.getClass();
        Object a = Primitive.m721a(obj);
        if (a instanceof Boolean) {
            return new Boolean(Primitive.m723a((Boolean) a, i));
        }
        if (a instanceof Integer) {
            int a2 = Primitive.m711a((Integer) a, i);
            if (i == 100 || i == 101) {
                if (cls == Byte.TYPE) {
                    return new Byte((byte) a2);
                }
                if (cls == Short.TYPE) {
                    return new Short((short) a2);
                }
                if (cls == Character.TYPE) {
                    return new Character((char) a2);
                }
            }
            return new Integer(a2);
        } else if (a instanceof Long) {
            return new Long(Primitive.m712a((Long) a, i));
        } else {
            if (a instanceof Float) {
                return new Float(Primitive.m710a((Float) a, i));
            }
            if (a instanceof Double) {
                return new Double(Primitive.m709a((Double) a, i));
            }
            throw new InterpreterError("An error occurred.  Please call technical support.");
        }
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        SimpleNode simpleNode = (SimpleNode) jjtGetChild(0);
        try {
            if (this.kind != 100) {
                if (this.kind != 101) {
                    return m291a(simpleNode.eval(callStack, interpreter), this.kind);
                }
            }
            return m290a(((BSHPrimaryExpression) simpleNode).toLHS(callStack, interpreter), interpreter.getStrictJava());
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callStack);
        }
    }
}
