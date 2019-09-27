package bsh;

class BSHFormalParameters extends SimpleNode {

    /* renamed from: a */
    Class[] f482a;

    /* renamed from: b */
    int f483b;

    /* renamed from: c */
    String[] f484c;

    /* renamed from: d */
    private String[] f485d;

    BSHFormalParameters(int i) {
        super(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo618a() {
        if (this.f485d == null) {
            this.f483b = jjtGetNumChildren();
            String[] strArr = new String[this.f483b];
            for (int i = 0; i < this.f483b; i++) {
                strArr[i] = ((BSHFormalParameter) jjtGetChild(i)).name;
            }
            this.f485d = strArr;
        }
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        if (this.f482a != null) {
            return this.f482a;
        }
        mo618a();
        Class[] clsArr = new Class[this.f483b];
        for (int i = 0; i < this.f483b; i++) {
            clsArr[i] = (Class) ((BSHFormalParameter) jjtGetChild(i)).eval(callStack, interpreter);
        }
        this.f482a = clsArr;
        return clsArr;
    }

    public String[] getParamNames() {
        mo618a();
        return this.f485d;
    }

    public String[] getTypeDescriptors(CallStack callStack, Interpreter interpreter, String str) {
        if (this.f484c != null) {
            return this.f484c;
        }
        mo618a();
        String[] strArr = new String[this.f483b];
        for (int i = 0; i < this.f483b; i++) {
            strArr[i] = ((BSHFormalParameter) jjtGetChild(i)).getTypeDescriptor(callStack, interpreter, str);
        }
        this.f484c = strArr;
        return strArr;
    }
}
