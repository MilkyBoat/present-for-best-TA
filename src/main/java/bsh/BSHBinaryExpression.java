package bsh;

class BSHBinaryExpression extends SimpleNode implements ParserConstants {

    /* renamed from: a */
    static Class f471a;
    public int kind;

    BSHBinaryExpression(int i) {
        super(i);
    }

    /* renamed from: a */
    static Class m266a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* renamed from: a */
    private boolean m267a(Object obj) {
        return (!(obj instanceof Primitive) || obj == Primitive.VOID || obj == Primitive.NULL) ? false : true;
    }

    /* renamed from: b */
    private boolean m268b(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Number);
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        Class cls;
        boolean z = false;
        Object eval = ((SimpleNode) jjtGetChild(0)).eval(callStack, interpreter);
        if (this.kind != 35) {
            if (this.kind == 98 || this.kind == 99) {
                Object value = m267a(eval) ? ((Primitive) eval).getValue() : eval;
                if ((value instanceof Boolean) && !((Boolean) value).booleanValue()) {
                    return new Primitive(false);
                }
            }
            if (this.kind == 96 || this.kind == 97) {
                Object value2 = m267a(eval) ? ((Primitive) eval).getValue() : eval;
                if ((value2 instanceof Boolean) && ((Boolean) value2).booleanValue()) {
                    return new Primitive(true);
                }
            }
            boolean b = m268b(eval);
            Object eval2 = ((SimpleNode) jjtGetChild(1)).eval(callStack, interpreter);
            boolean b2 = m268b(eval2);
            if ((b || m267a(eval)) && ((b2 || m267a(eval2)) && (!b || !b2 || this.kind != 90))) {
                try {
                    return Primitive.binaryOperation(eval, eval2, this.kind);
                } catch (UtilEvalError e) {
                    throw e.toEvalError(this, callStack);
                }
            } else {
                int i = this.kind;
                if (i == 90) {
                    if (eval == eval2) {
                        z = true;
                    }
                    return new Primitive(z);
                } else if (i == 95) {
                    if (eval != eval2) {
                        z = true;
                    }
                    return new Primitive(z);
                } else if (i == 102 && ((eval instanceof String) || (eval2 instanceof String))) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(eval.toString());
                    stringBuffer.append(eval2.toString());
                    return stringBuffer.toString();
                } else {
                    if ((eval instanceof Primitive) || (eval2 instanceof Primitive)) {
                        if (eval == Primitive.VOID || eval2 == Primitive.VOID) {
                            throw new EvalError("illegal use of undefined variable, class, or 'void' literal", this, callStack);
                        } else if (eval == Primitive.NULL || eval2 == Primitive.NULL) {
                            throw new EvalError("illegal use of null value or 'null' literal", this, callStack);
                        }
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Operator: '");
                    stringBuffer2.append(ParserConstants.tokenImage[this.kind]);
                    stringBuffer2.append("' inappropriate for objects");
                    throw new EvalError(stringBuffer2.toString(), this, callStack);
                }
            }
        } else if (eval == Primitive.NULL) {
            return new Primitive(false);
        } else {
            Class type = ((BSHType) jjtGetChild(1)).getType(callStack, interpreter);
            if (!(eval instanceof Primitive)) {
                return new Primitive(Types.m762b(type, eval.getClass()));
            }
            if (f471a == null) {
                cls = m266a("bsh.Primitive");
                f471a = cls;
            } else {
                cls = f471a;
            }
            return type == cls ? new Primitive(true) : new Primitive(false);
        }
    }
}
