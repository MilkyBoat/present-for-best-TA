package bsh;

import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

public class TargetError extends EvalError {

    /* renamed from: d */
    Throwable f699d;

    /* renamed from: e */
    boolean f700e;

    public TargetError(String str, Throwable th, SimpleNode simpleNode, CallStack callStack, boolean z) {
        super(str, simpleNode, callStack);
        this.f699d = th;
        this.f700e = z;
    }

    public TargetError(Throwable th, SimpleNode simpleNode, CallStack callStack) {
        this("TargetError", th, simpleNode, callStack, false);
    }

    public Throwable getTarget() {
        return this.f699d instanceof InvocationTargetException ? ((InvocationTargetException) this.f699d).getTargetException() : this.f699d;
    }

    public boolean inNativeCode() {
        return this.f700e;
    }

    public void printStackTrace() {
        printStackTrace(false, System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace(false, printStream);
    }

    public void printStackTrace(boolean z, PrintStream printStream) {
        if (z) {
            super.printStackTrace(printStream);
            printStream.println("--- Target Stack Trace ---");
        }
        C0029a.m807a(this.f699d, printStream);
    }

    public String printTargetError(Throwable th) {
        String th2 = this.f699d.toString();
        if (!Capabilities.canGenerateInterfaces()) {
            return th2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(th2);
        stringBuffer.append("\n");
        stringBuffer.append(xPrintTargetError(th));
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append("\nTarget exception: ");
        stringBuffer.append(printTargetError(this.f699d));
        return stringBuffer.toString();
    }

    public String xPrintTargetError(Throwable th) {
        String str = "import java.lang.reflect.UndeclaredThrowableException;String result=\"\";while ( target instanceof UndeclaredThrowableException ) {\ttarget=target.getUndeclaredThrowable(); \tresult+=\"Nested: \"+target.toString();}return result;";
        Interpreter interpreter = new Interpreter();
        try {
            interpreter.set("target", (Object) th);
            return (String) interpreter.eval(str);
        } catch (EvalError e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("xprintarget: ");
            stringBuffer.append(e.toString());
            throw new InterpreterError(stringBuffer.toString());
        }
    }
}
