package bsh;

class SimpleNode implements Node {
    public static SimpleNode JAVACODE = new SimpleNode(-1) {
        public int getLineNumber() {
            return -1;
        }

        public String getSourceFile() {
            return "<Called from Java Code>";
        }

        public String getText() {
            return "<Compiled Java Code>";
        }
    };

    /* renamed from: g */
    protected Node f693g;

    /* renamed from: h */
    protected Node[] f694h;

    /* renamed from: i */
    protected int f695i;

    /* renamed from: j */
    Token f696j;

    /* renamed from: k */
    Token f697k;

    /* renamed from: l */
    String f698l;

    public SimpleNode(int i) {
        this.f695i = i;
    }

    public void dump(String str) {
        System.out.println(toString(str));
        if (this.f694h != null) {
            for (Node node : this.f694h) {
                SimpleNode simpleNode = (SimpleNode) node;
                if (simpleNode != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str);
                    stringBuffer.append(" ");
                    simpleNode.dump(stringBuffer.toString());
                }
            }
        }
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unimplemented or inappropriate for ");
        stringBuffer.append(getClass().getName());
        throw new InterpreterError(stringBuffer.toString());
    }

    public SimpleNode getChild(int i) {
        return (SimpleNode) jjtGetChild(i);
    }

    public int getLineNumber() {
        return this.f696j.beginLine;
    }

    public String getSourceFile() {
        return this.f698l == null ? this.f693g != null ? ((SimpleNode) this.f693g).getSourceFile() : "<unknown file>" : this.f698l;
    }

    public String getText() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Token token = this.f696j; token != null; token = token.next) {
            stringBuffer.append(token.image);
            if (!token.image.equals(".")) {
                stringBuffer.append(" ");
            }
            if (token == this.f697k || token.image.equals("{") || token.image.equals(";")) {
                break;
            }
        }
        return stringBuffer.toString();
    }

    public void jjtAddChild(Node node, int i) {
        Node[] nodeArr;
        if (this.f694h == null) {
            nodeArr = new Node[(i + 1)];
        } else {
            if (i >= this.f694h.length) {
                nodeArr = new Node[(i + 1)];
                System.arraycopy(this.f694h, 0, nodeArr, 0, this.f694h.length);
            }
            this.f694h[i] = node;
        }
        this.f694h = nodeArr;
        this.f694h[i] = node;
    }

    public void jjtClose() {
    }

    public Node jjtGetChild(int i) {
        return this.f694h[i];
    }

    public int jjtGetNumChildren() {
        if (this.f694h == null) {
            return 0;
        }
        return this.f694h.length;
    }

    public Node jjtGetParent() {
        return this.f693g;
    }

    public void jjtOpen() {
    }

    public void jjtSetParent(Node node) {
        this.f693g = node;
    }

    public void prune() {
        jjtSetParent(null);
    }

    public void setSourceFile(String str) {
        this.f698l = str;
    }

    public String toString() {
        return ParserTreeConstants.jjtNodeName[this.f695i];
    }

    public String toString(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(toString());
        return stringBuffer.toString();
    }
}
