package bsh;

import com.androlua.BuildConfig;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;

public class UtilEvalError extends Exception {
    protected UtilEvalError() {
    }

    public UtilEvalError(String str) {
        super(str);
    }

    public EvalError toEvalError(SimpleNode simpleNode, CallStack callStack) {
        return toEvalError(null, simpleNode, callStack);
    }

    public EvalError toEvalError(String str, SimpleNode simpleNode, CallStack callStack) {
        String str2;
        if (Interpreter.DEBUG) {
            C0029a.m806a(this);
        }
        if (str == null) {
            str2 = BuildConfig.FLAVOR;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(": ");
            str2 = stringBuffer.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(str2);
        stringBuffer2.append(getMessage());
        return new EvalError(stringBuffer2.toString(), simpleNode, callStack);
    }
}
