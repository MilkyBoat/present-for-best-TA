package com.android.cglib.p008dx.p020d;

import java.io.PrintStream;
import java.io.PrintWriter;

/* renamed from: com.android.cglib.dx.d.g */
public class C0293g extends RuntimeException {

    /* renamed from: a */
    private StringBuffer f2161a;

    public C0293g(String str) {
        this(str, null);
    }

    public C0293g(String str, Throwable th) {
        if (str == null) {
            str = th != null ? th.getMessage() : null;
        }
        super(str, th);
        if (th instanceof C0293g) {
            String stringBuffer = ((C0293g) th).f2161a.toString();
            this.f2161a = new StringBuffer(stringBuffer.length() + 200);
            this.f2161a.append(stringBuffer);
            return;
        }
        this.f2161a = new StringBuffer(200);
    }

    public C0293g(Throwable th) {
        this(null, th);
    }

    /* renamed from: a */
    public static C0293g m2033a(Throwable th, String str) {
        C0293g gVar = th instanceof C0293g ? (C0293g) th : new C0293g(th);
        gVar.mo1769a(str);
        return gVar;
    }

    /* renamed from: a */
    public void mo1769a(String str) {
        if (str == null) {
            throw new NullPointerException("str == null");
        }
        this.f2161a.append(str);
        if (!str.endsWith("\n")) {
            this.f2161a.append(10);
        }
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        printStream.println(this.f2161a);
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        printWriter.println(this.f2161a);
    }
}
