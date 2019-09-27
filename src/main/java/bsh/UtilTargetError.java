package bsh;

public class UtilTargetError extends UtilEvalError {

    /* renamed from: t */
    public Throwable f710t;

    public UtilTargetError(String str, Throwable th) {
        super(str);
        this.f710t = th;
    }

    public UtilTargetError(Throwable th) {
        this(null, th);
    }

    public EvalError toEvalError(String str, SimpleNode simpleNode, CallStack callStack) {
        String stringBuffer;
        if (str == null) {
            stringBuffer = getMessage();
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str);
            stringBuffer2.append(": ");
            stringBuffer2.append(getMessage());
            stringBuffer = stringBuffer2.toString();
        }
        TargetError targetError = new TargetError(stringBuffer, this.f710t, simpleNode, callStack, false);
        return targetError;
    }
}
