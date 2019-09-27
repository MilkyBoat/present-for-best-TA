package bsh;

import com.androlua.BuildConfig;

public class EvalError extends Exception {

    /* renamed from: a */
    SimpleNode f561a;

    /* renamed from: b */
    String f562b;

    /* renamed from: c */
    CallStack f563c;

    public EvalError(String str, SimpleNode simpleNode, CallStack callStack) {
        setMessage(str);
        this.f561a = simpleNode;
        if (callStack != null) {
            this.f563c = callStack.copy();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public SimpleNode mo744a() {
        return this.f561a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo745a(SimpleNode simpleNode) {
        this.f561a = simpleNode;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo746a(String str) {
        if (str != null) {
            if (this.f562b != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append(" : ");
                stringBuffer.append(this.f562b);
                str = stringBuffer.toString();
            }
            this.f562b = str;
        }
    }

    public int getErrorLineNumber() {
        if (this.f561a != null) {
            return this.f561a.getLineNumber();
        }
        return -1;
    }

    public String getErrorSourceFile() {
        return this.f561a != null ? this.f561a.getSourceFile() : "<unknown file>";
    }

    public String getErrorText() {
        return this.f561a != null ? this.f561a.getText() : "<unknown error>";
    }

    public String getMessage() {
        return this.f562b;
    }

    public String getScriptStackTrace() {
        if (this.f563c == null) {
            return "<Unknown>";
        }
        String str = BuildConfig.FLAVOR;
        CallStack copy = this.f563c.copy();
        while (copy.depth() > 0) {
            NameSpace pop = copy.pop();
            SimpleNode b = pop.mo861b();
            if (pop.f621c) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append("\nCalled from method: ");
                stringBuffer.append(pop.getName());
                str = stringBuffer.toString();
                if (b != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str);
                    stringBuffer2.append(" : at Line: ");
                    stringBuffer2.append(b.getLineNumber());
                    stringBuffer2.append(" : in file: ");
                    stringBuffer2.append(b.getSourceFile());
                    stringBuffer2.append(" : ");
                    stringBuffer2.append(b.getText());
                    str = stringBuffer2.toString();
                }
            }
        }
        return str;
    }

    public void reThrow(String str) {
        mo746a(str);
        throw this;
    }

    public void setMessage(String str) {
        this.f562b = str;
    }

    public String toString() {
        String str;
        if (this.f561a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" : at Line: ");
            stringBuffer.append(this.f561a.getLineNumber());
            stringBuffer.append(" : in file: ");
            stringBuffer.append(this.f561a.getSourceFile());
            stringBuffer.append(" : ");
            stringBuffer.append(this.f561a.getText());
            str = stringBuffer.toString();
        } else {
            str = ": <at unknown location>";
        }
        if (this.f563c != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str);
            stringBuffer2.append("\n");
            stringBuffer2.append(getScriptStackTrace());
            str = stringBuffer2.toString();
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(getMessage());
        stringBuffer3.append(str);
        return stringBuffer3.toString();
    }
}
