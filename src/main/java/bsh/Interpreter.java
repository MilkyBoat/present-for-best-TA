package bsh;

import com.androlua.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Interpreter implements ConsoleInterface, Serializable, Runnable {
    public static boolean DEBUG = false;
    public static boolean LOCALSCOPING = false;
    public static boolean TRACE = false;
    public static final String VERSION = "2.0b4";

    /* renamed from: a */
    static transient PrintStream f565a = null;

    /* renamed from: b */
    static String f566b = "\n";

    /* renamed from: c */
    static This f567c;

    /* renamed from: n */
    static Class f568n;

    /* renamed from: d */
    transient Parser f569d;

    /* renamed from: e */
    NameSpace f570e;

    /* renamed from: f */
    transient Reader f571f;

    /* renamed from: g */
    transient PrintStream f572g;

    /* renamed from: h */
    transient PrintStream f573h;

    /* renamed from: i */
    ConsoleInterface f574i;

    /* renamed from: j */
    Interpreter f575j;

    /* renamed from: k */
    String f576k;

    /* renamed from: l */
    protected boolean f577l;

    /* renamed from: m */
    protected boolean f578m;

    /* renamed from: o */
    private boolean f579o;

    /* renamed from: p */
    private boolean f580p;

    /* renamed from: q */
    private boolean f581q;

    static {
        m342b();
    }

    public Interpreter() {
        this(new StringReader(BuildConfig.FLAVOR), System.out, System.err, false, null);
        this.f577l = true;
        mo768a("bsh.evalOnly", new Primitive(true));
    }

    public Interpreter(ConsoleInterface consoleInterface) {
        this(consoleInterface, null);
    }

    public Interpreter(ConsoleInterface consoleInterface, NameSpace nameSpace) {
        this(consoleInterface.getIn(), consoleInterface.getOut(), consoleInterface.getErr(), true, nameSpace);
        setConsole(consoleInterface);
    }

    public Interpreter(Reader reader, PrintStream printStream, PrintStream printStream2, boolean z) {
        this(reader, printStream, printStream2, z, null);
    }

    public Interpreter(Reader reader, PrintStream printStream, PrintStream printStream2, boolean z, NameSpace nameSpace) {
        this(reader, printStream, printStream2, z, nameSpace, null, null);
    }

    public Interpreter(Reader reader, PrintStream printStream, PrintStream printStream2, boolean z, NameSpace nameSpace, Interpreter interpreter, String str) {
        this.f579o = false;
        this.f580p = true;
        this.f569d = new Parser(reader);
        long currentTimeMillis = System.currentTimeMillis();
        this.f571f = reader;
        this.f572g = printStream;
        this.f573h = printStream2;
        this.f578m = z;
        f565a = printStream2;
        this.f575j = interpreter;
        if (interpreter != null) {
            setStrictJava(interpreter.getStrictJava());
        }
        this.f576k = str;
        BshClassManager createClassManager = BshClassManager.createClassManager(this);
        if (nameSpace == null) {
            this.f570e = new NameSpace(createClassManager, "global");
        } else {
            this.f570e = nameSpace;
        }
        if (!(mo766a("bsh") instanceof This)) {
            m344c();
        }
        if (z) {
            mo767a();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Time to initialize interpreter: ");
            stringBuffer.append(currentTimeMillis2 - currentTimeMillis);
            debug(stringBuffer.toString());
        }
    }

    /* renamed from: b */
    static Class m341b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* renamed from: b */
    static void m342b() {
        String str;
        StringBuffer stringBuffer;
        PrintStream printStream;
        try {
            f566b = System.getProperty("line.separator");
            f565a = System.err;
            DEBUG = Boolean.getBoolean("debug");
            TRACE = Boolean.getBoolean("trace");
            LOCALSCOPING = Boolean.getBoolean("localscoping");
            String property = System.getProperty("outfile");
            if (property != null) {
                redirectOutputToFile(property);
            }
        } catch (SecurityException e) {
            th = e;
            printStream = System.err;
            stringBuffer = new StringBuffer();
            str = "Could not init static:";
            stringBuffer.append(str);
            stringBuffer.append(th);
            printStream.println(stringBuffer.toString());
        } catch (Exception e2) {
            th = e2;
            printStream = System.err;
            stringBuffer = new StringBuffer();
            str = "Could not init static(2):";
            stringBuffer.append(str);
            stringBuffer.append(th);
            printStream.println(stringBuffer.toString());
        } catch (Throwable th) {
            th = th;
            printStream = System.err;
            stringBuffer = new StringBuffer();
            str = "Could not init static(3):";
            stringBuffer.append(str);
            stringBuffer.append(th);
            printStream.println(stringBuffer.toString());
        }
    }

    /* renamed from: c */
    private String m343c(String str) {
        String replace = str.replace(10, ' ').replace(13, ' ');
        if (replace.length() <= 80) {
            return replace;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(replace.substring(0, 80));
        stringBuffer.append(" . . . ");
        return stringBuffer.toString();
    }

    /* renamed from: c */
    private void m344c() {
        BshClassManager classManager = getClassManager();
        mo768a("bsh", new NameSpace(classManager, "Bsh Object").mo645a(this));
        if (f567c == null) {
            f567c = new NameSpace(classManager, "Bsh Shared System Object").mo645a(this);
        }
        mo768a("bsh.system", f567c);
        mo768a("bsh.shared", f567c);
        mo768a("bsh.help", new NameSpace(classManager, "Bsh Command Help Text").mo645a(this));
        try {
            mo768a("bsh.cwd", System.getProperty("user.dir"));
        } catch (SecurityException unused) {
            mo768a("bsh.cwd", ".");
        }
        mo768a("bsh.interactive", new Primitive(this.f578m));
        mo768a("bsh.evalOnly", new Primitive(this.f577l));
    }

    /* renamed from: d */
    private JJTParserState m345d() {
        return this.f569d.f642a;
    }

    public static final void debug(String str) {
        if (DEBUG) {
            PrintStream printStream = f565a;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("// Debug: ");
            stringBuffer.append(str);
            printStream.println(stringBuffer.toString());
        }
    }

    /* renamed from: e */
    private boolean m346e() {
        return this.f569d.Line();
    }

    /* renamed from: f */
    private String m347f() {
        try {
            return (String) eval("getBshPrompt()");
        } catch (Exception unused) {
            return "bsh % ";
        }
    }

    public static void invokeMain(Class cls, String[] strArr) {
        Class cls2;
        String str = "main";
        Class[] clsArr = new Class[1];
        if (f568n == null) {
            cls2 = m341b("[Ljava.lang.String;");
            f568n = cls2;
        } else {
            cls2 = f568n;
        }
        clsArr[0] = cls2;
        Method a = Reflect.m736a((BshClassManager) null, cls, str, clsArr, true);
        if (a != null) {
            a.invoke(null, new Object[]{strArr});
        }
    }

    public static void main(String[] strArr) {
        String[] strArr2;
        String str;
        StringBuffer stringBuffer;
        PrintStream printStream;
        if (strArr.length > 0) {
            String str2 = strArr[0];
            if (strArr.length > 1) {
                strArr2 = new String[(strArr.length - 1)];
                System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
            } else {
                strArr2 = new String[0];
            }
            Interpreter interpreter = new Interpreter();
            interpreter.mo768a("bsh.args", strArr2);
            try {
                Object source = interpreter.source(str2, interpreter.f570e);
                if (source instanceof Class) {
                    try {
                        invokeMain((Class) source, strArr2);
                    } catch (Exception e) {
                        e = e;
                        if (e instanceof InvocationTargetException) {
                            e = ((InvocationTargetException) e).getTargetException();
                        }
                        PrintStream printStream2 = System.err;
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Class: ");
                        stringBuffer2.append(source);
                        stringBuffer2.append(" main method threw exception:");
                        stringBuffer2.append(e);
                        printStream2.println(stringBuffer2.toString());
                    }
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                printStream = System.out;
                stringBuffer = new StringBuffer();
                str = "File not found: ";
                stringBuffer.append(str);
                stringBuffer.append(e);
                printStream.println(stringBuffer.toString());
            } catch (TargetError e3) {
                PrintStream printStream3 = System.out;
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Script threw exception: ");
                stringBuffer3.append(e3);
                printStream3.println(stringBuffer3.toString());
                if (e3.inNativeCode()) {
                    e3.printStackTrace(DEBUG, System.err);
                }
            } catch (EvalError e4) {
                e = e4;
                printStream = System.out;
                stringBuffer = new StringBuffer();
                str = "Evaluation Error: ";
                stringBuffer.append(str);
                stringBuffer.append(e);
                printStream.println(stringBuffer.toString());
            } catch (IOException e5) {
                e = e5;
                printStream = System.out;
                stringBuffer = new StringBuffer();
                str = "I/O Error: ";
                stringBuffer.append(str);
                stringBuffer.append(e);
                printStream.println(stringBuffer.toString());
            }
        } else {
            new Interpreter(new CommandLineReader(new InputStreamReader((!System.getProperty("os.name").startsWith("Windows") || !System.getProperty("java.version").startsWith("1.1.")) ? System.in : new FilterInputStream(System.in) {
                public int available() {
                    return 0;
                }
            })), System.out, System.err, true).run();
        }
    }

    public static void redirectOutputToFile(String str) {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(str));
            System.setOut(printStream);
            System.setErr(printStream);
        } catch (IOException unused) {
            PrintStream printStream2 = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Can't redirect output to file: ");
            stringBuffer.append(str);
            printStream2.println(stringBuffer.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo766a(String str) {
        try {
            return get(str);
        } catch (EvalError e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("set: ");
            stringBuffer.append(e);
            throw new InterpreterError(stringBuffer.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo767a() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(System.getProperty("user.home"));
            stringBuffer.append(File.separator);
            stringBuffer.append(".bshrc");
            source(stringBuffer.toString(), this.f570e);
        } catch (Exception e) {
            if (DEBUG) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not find rc file: ");
                stringBuffer2.append(e);
                debug(stringBuffer2.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo768a(String str, Object obj) {
        try {
            set(str, obj);
        } catch (EvalError e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("set: ");
            stringBuffer.append(e);
            throw new InterpreterError(stringBuffer.toString());
        }
    }

    public final void error(Object obj) {
        if (this.f574i != null) {
            ConsoleInterface consoleInterface = this.f574i;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("// Error: ");
            stringBuffer.append(obj);
            stringBuffer.append("\n");
            consoleInterface.error(stringBuffer.toString());
            return;
        }
        PrintStream printStream = this.f573h;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("// Error: ");
        stringBuffer2.append(obj);
        printStream.println(stringBuffer2.toString());
        this.f573h.flush();
    }

    public Object eval(Reader reader) {
        return eval(reader, this.f570e, "eval stream");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0203, code lost:
        r1.m345d().mo801a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x020e, code lost:
        if (r11.depth() > 1) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0210, code lost:
        r11.clear();
        r11.push(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0216, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cf, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d2, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d5, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d7, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d9, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00dc, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00df, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f8, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fa, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fd, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0100, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0101, code lost:
        r2 = r1;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r5 = new java.lang.StringBuffer();
        r5.append("Sourced file: ");
        r5.append(r13);
        r5.append(" Token Parsing Error: ");
        r5.append(r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0126, code lost:
        throw new bsh.EvalError(r5.toString(), r1, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0127, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0128, code lost:
        r2 = r1;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012d, code lost:
        if (DEBUG != false) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012f, code lost:
        com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0132, code lost:
        r5 = new java.lang.StringBuffer();
        r5.append("Sourced file: ");
        r5.append(r13);
        r5.append(" unknown error: ");
        r5.append(r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        throw new bsh.EvalError(r5.toString(), r1, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x015f, code lost:
        com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0168, code lost:
        r3.mo745a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x018a, code lost:
        if (r11.depth() > 1) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0199, code lost:
        r3.mo745a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01bb, code lost:
        if (r11.depth() > 1) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01bd, code lost:
        r11.clear();
        r11.push(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c3, code lost:
        r1 = r5;
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c7, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c8, code lost:
        r2 = r1;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r2);
        r5 = new java.lang.StringBuffer();
        r5.append("Sourced file: ");
        r5.append(r13);
        r5.append(" internal Error: ");
        r5.append(r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01f0, code lost:
        throw new bsh.EvalError(r5.toString(), r1, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01f1, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01f4, code lost:
        if (DEBUG != false) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f6, code lost:
        error(r1.getMessage(DEBUG));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ff, code lost:
        r1.setErrorSourceFile(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0202, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d5 A[ExcHandler: TokenMgrError (e bsh.TokenMgrError), Splitter:B:12:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d7 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:12:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00df A[ExcHandler: InterpreterError (e bsh.InterpreterError), Splitter:B:12:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0100 A[ExcHandler: TokenMgrError (r1v27 'e' bsh.TokenMgrError A[CUSTOM_DECLARE]), Splitter:B:6:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0127 A[Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5, ParseException -> 0x01f1, InterpreterError -> 0x01c7, TargetError -> 0x00fa, EvalError -> 0x00f8, Exception -> 0x0127, TokenMgrError -> 0x0100, all -> 0x00fd }, ExcHandler: Exception (r1v24 'e' java.lang.Exception A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:6:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012f A[Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5, ParseException -> 0x01f1, InterpreterError -> 0x01c7, TargetError -> 0x00fa, EvalError -> 0x00f8, Exception -> 0x0127, TokenMgrError -> 0x0100, all -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x015f A[Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5, ParseException -> 0x01f1, InterpreterError -> 0x01c7, TargetError -> 0x00fa, EvalError -> 0x00f8, Exception -> 0x0127, TokenMgrError -> 0x0100, all -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0168 A[Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5, ParseException -> 0x01f1, InterpreterError -> 0x01c7, TargetError -> 0x00fa, EvalError -> 0x00f8, Exception -> 0x0127, TokenMgrError -> 0x0100, all -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0199 A[Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5, ParseException -> 0x01f1, InterpreterError -> 0x01c7, TargetError -> 0x00fa, EvalError -> 0x00f8, Exception -> 0x0127, TokenMgrError -> 0x0100, all -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01c7 A[ExcHandler: InterpreterError (r1v6 'e' bsh.InterpreterError A[CUSTOM_DECLARE]), Splitter:B:6:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f1 A[Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5, ParseException -> 0x01f1, InterpreterError -> 0x01c7, TargetError -> 0x00fa, EvalError -> 0x00f8, Exception -> 0x0127, TokenMgrError -> 0x0100, all -> 0x00fd }, ExcHandler: ParseException (r1v4 'e' bsh.ParseException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:6:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object eval(java.io.Reader r11, bsh.NameSpace r12, java.lang.String r13) {
        /*
            r10 = this;
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0018
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "eval: nameSpace = "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            debug(r0)
        L_0x0018:
            bsh.Interpreter r0 = new bsh.Interpreter
            java.io.PrintStream r3 = r10.f572g
            java.io.PrintStream r4 = r10.f573h
            r5 = 0
            r1 = r0
            r2 = r11
            r6 = r12
            r7 = r10
            r8 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            bsh.CallStack r11 = new bsh.CallStack
            r11.<init>(r12)
            r1 = 0
            r2 = 0
            r3 = r2
        L_0x002f:
            if (r1 == 0) goto L_0x0032
            goto L_0x00a7
        L_0x0032:
            r4 = 1
            boolean r5 = r0.m346e()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x01c7, TargetError -> 0x018d, EvalError -> 0x0155, Exception -> 0x0127, TokenMgrError -> 0x0100 }
            bsh.JJTParserState r1 = r0.m345d()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x01c7, TargetError -> 0x00fa, EvalError -> 0x00f8, Exception -> 0x0127, TokenMgrError -> 0x0100 }
            int r1 = r1.mo809d()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x01c7, TargetError -> 0x00fa, EvalError -> 0x00f8, Exception -> 0x0127, TokenMgrError -> 0x0100 }
            if (r1 <= 0) goto L_0x00e2
            bsh.JJTParserState r1 = r0.m345d()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x01c7, TargetError -> 0x00fa, EvalError -> 0x00f8, Exception -> 0x0127, TokenMgrError -> 0x0100 }
            bsh.Node r1 = r1.mo805b()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x01c7, TargetError -> 0x00fa, EvalError -> 0x00f8, Exception -> 0x0127, TokenMgrError -> 0x0100 }
            bsh.SimpleNode r1 = (bsh.SimpleNode) r1     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x01c7, TargetError -> 0x00fa, EvalError -> 0x00f8, Exception -> 0x0127, TokenMgrError -> 0x0100 }
            r1.setSourceFile(r13)     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00dc, EvalError -> 0x00d9, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            boolean r6 = TRACE     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00dc, EvalError -> 0x00d9, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            if (r6 == 0) goto L_0x006a
            java.lang.StringBuffer r6 = new java.lang.StringBuffer     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00dc, EvalError -> 0x00d9, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            r6.<init>()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00dc, EvalError -> 0x00d9, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            java.lang.String r7 = "// "
            r6.append(r7)     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00dc, EvalError -> 0x00d9, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            java.lang.String r7 = r1.getText()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00dc, EvalError -> 0x00d9, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            r6.append(r7)     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00dc, EvalError -> 0x00d9, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            java.lang.String r6 = r6.toString()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00dc, EvalError -> 0x00d9, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            r10.println(r6)     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00dc, EvalError -> 0x00d9, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
        L_0x006a:
            java.lang.Object r6 = r1.eval(r11, r0)     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00dc, EvalError -> 0x00d9, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            int r3 = r11.depth()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            if (r3 <= r4) goto L_0x008b
            bsh.InterpreterError r3 = new bsh.InterpreterError     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            r7.<init>()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            java.lang.String r8 = "Callstack growing: "
            r7.append(r8)     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            r7.append(r11)     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            java.lang.String r7 = r7.toString()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            r3.<init>(r7)     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            throw r3     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
        L_0x008b:
            boolean r3 = r6 instanceof bsh.ReturnControl     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            if (r3 == 0) goto L_0x00ac
            r3 = r6
            bsh.ReturnControl r3 = (bsh.ReturnControl) r3     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            java.lang.Object r3 = r3.value     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            bsh.JJTParserState r13 = r0.m345d()
            r13.mo801a()
            int r13 = r11.depth()
            if (r13 <= r4) goto L_0x00a7
            r11.clear()
            r11.push(r12)
        L_0x00a7:
            java.lang.Object r11 = bsh.Primitive.unwrap(r3)
            return r11
        L_0x00ac:
            boolean r3 = r0.f581q     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            if (r3 == 0) goto L_0x00cd
            bsh.Primitive r3 = bsh.Primitive.VOID     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            if (r6 == r3) goto L_0x00cd
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            r3.<init>()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            java.lang.String r7 = "<"
            r3.append(r7)     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            r3.append(r6)     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            java.lang.String r7 = ">"
            r3.append(r7)     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            java.lang.String r3 = r3.toString()     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
            r10.println(r3)     // Catch:{ ParseException -> 0x01f1, InterpreterError -> 0x00df, TargetError -> 0x00d2, EvalError -> 0x00cf, Exception -> 0x00d7, TokenMgrError -> 0x00d5 }
        L_0x00cd:
            r3 = r6
            goto L_0x00e2
        L_0x00cf:
            r3 = move-exception
            goto L_0x015b
        L_0x00d2:
            r3 = move-exception
            goto L_0x0193
        L_0x00d5:
            r2 = move-exception
            goto L_0x0104
        L_0x00d7:
            r2 = move-exception
            goto L_0x012b
        L_0x00d9:
            r6 = move-exception
            goto L_0x0158
        L_0x00dc:
            r6 = move-exception
            goto L_0x0190
        L_0x00df:
            r2 = move-exception
            goto L_0x01cb
        L_0x00e2:
            bsh.JJTParserState r1 = r0.m345d()
            r1.mo801a()
            int r1 = r11.depth()
            if (r1 <= r4) goto L_0x00f5
            r11.clear()
            r11.push(r12)
        L_0x00f5:
            r1 = r5
            goto L_0x002f
        L_0x00f8:
            r6 = move-exception
            goto L_0x0157
        L_0x00fa:
            r6 = move-exception
            goto L_0x018f
        L_0x00fd:
            r13 = move-exception
            goto L_0x0203
        L_0x0100:
            r1 = move-exception
            r9 = r2
            r2 = r1
            r1 = r9
        L_0x0104:
            bsh.EvalError r3 = new bsh.EvalError     // Catch:{ all -> 0x00fd }
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x00fd }
            r5.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = "Sourced file: "
            r5.append(r6)     // Catch:{ all -> 0x00fd }
            r5.append(r13)     // Catch:{ all -> 0x00fd }
            java.lang.String r13 = " Token Parsing Error: "
            r5.append(r13)     // Catch:{ all -> 0x00fd }
            java.lang.String r13 = r2.getMessage()     // Catch:{ all -> 0x00fd }
            r5.append(r13)     // Catch:{ all -> 0x00fd }
            java.lang.String r13 = r5.toString()     // Catch:{ all -> 0x00fd }
            r3.<init>(r13, r1, r11)     // Catch:{ all -> 0x00fd }
            throw r3     // Catch:{ all -> 0x00fd }
        L_0x0127:
            r1 = move-exception
            r9 = r2
            r2 = r1
            r1 = r9
        L_0x012b:
            boolean r3 = DEBUG     // Catch:{ all -> 0x00fd }
            if (r3 == 0) goto L_0x0132
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r2)     // Catch:{ all -> 0x00fd }
        L_0x0132:
            bsh.EvalError r3 = new bsh.EvalError     // Catch:{ all -> 0x00fd }
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x00fd }
            r5.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = "Sourced file: "
            r5.append(r6)     // Catch:{ all -> 0x00fd }
            r5.append(r13)     // Catch:{ all -> 0x00fd }
            java.lang.String r13 = " unknown error: "
            r5.append(r13)     // Catch:{ all -> 0x00fd }
            java.lang.String r13 = r2.getMessage()     // Catch:{ all -> 0x00fd }
            r5.append(r13)     // Catch:{ all -> 0x00fd }
            java.lang.String r13 = r5.toString()     // Catch:{ all -> 0x00fd }
            r3.<init>(r13, r1, r11)     // Catch:{ all -> 0x00fd }
            throw r3     // Catch:{ all -> 0x00fd }
        L_0x0155:
            r6 = move-exception
            r5 = r1
        L_0x0157:
            r1 = r2
        L_0x0158:
            r9 = r6
            r6 = r3
            r3 = r9
        L_0x015b:
            boolean r7 = DEBUG     // Catch:{ all -> 0x00fd }
            if (r7 == 0) goto L_0x0162
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r3)     // Catch:{ all -> 0x00fd }
        L_0x0162:
            bsh.SimpleNode r7 = r3.mo744a()     // Catch:{ all -> 0x00fd }
            if (r7 != 0) goto L_0x016b
            r3.mo745a(r1)     // Catch:{ all -> 0x00fd }
        L_0x016b:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x00fd }
            r1.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r7 = "Sourced file: "
            r1.append(r7)     // Catch:{ all -> 0x00fd }
            r1.append(r13)     // Catch:{ all -> 0x00fd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00fd }
            r3.reThrow(r1)     // Catch:{ all -> 0x00fd }
            bsh.JJTParserState r1 = r0.m345d()
            r1.mo801a()
            int r1 = r11.depth()
            if (r1 <= r4) goto L_0x01c3
            goto L_0x01bd
        L_0x018d:
            r6 = move-exception
            r5 = r1
        L_0x018f:
            r1 = r2
        L_0x0190:
            r9 = r6
            r6 = r3
            r3 = r9
        L_0x0193:
            bsh.SimpleNode r7 = r3.mo744a()     // Catch:{ all -> 0x00fd }
            if (r7 != 0) goto L_0x019c
            r3.mo745a(r1)     // Catch:{ all -> 0x00fd }
        L_0x019c:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x00fd }
            r1.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r7 = "Sourced file: "
            r1.append(r7)     // Catch:{ all -> 0x00fd }
            r1.append(r13)     // Catch:{ all -> 0x00fd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00fd }
            r3.reThrow(r1)     // Catch:{ all -> 0x00fd }
            bsh.JJTParserState r1 = r0.m345d()
            r1.mo801a()
            int r1 = r11.depth()
            if (r1 <= r4) goto L_0x01c3
        L_0x01bd:
            r11.clear()
            r11.push(r12)
        L_0x01c3:
            r1 = r5
            r3 = r6
            goto L_0x002f
        L_0x01c7:
            r1 = move-exception
            r9 = r2
            r2 = r1
            r1 = r9
        L_0x01cb:
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r2)     // Catch:{ all -> 0x00fd }
            bsh.EvalError r3 = new bsh.EvalError     // Catch:{ all -> 0x00fd }
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x00fd }
            r5.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = "Sourced file: "
            r5.append(r6)     // Catch:{ all -> 0x00fd }
            r5.append(r13)     // Catch:{ all -> 0x00fd }
            java.lang.String r13 = " internal Error: "
            r5.append(r13)     // Catch:{ all -> 0x00fd }
            java.lang.String r13 = r2.getMessage()     // Catch:{ all -> 0x00fd }
            r5.append(r13)     // Catch:{ all -> 0x00fd }
            java.lang.String r13 = r5.toString()     // Catch:{ all -> 0x00fd }
            r3.<init>(r13, r1, r11)     // Catch:{ all -> 0x00fd }
            throw r3     // Catch:{ all -> 0x00fd }
        L_0x01f1:
            r1 = move-exception
            boolean r2 = DEBUG     // Catch:{ all -> 0x00fd }
            if (r2 == 0) goto L_0x01ff
            boolean r2 = DEBUG     // Catch:{ all -> 0x00fd }
            java.lang.String r2 = r1.getMessage(r2)     // Catch:{ all -> 0x00fd }
            r10.error(r2)     // Catch:{ all -> 0x00fd }
        L_0x01ff:
            r1.setErrorSourceFile(r13)     // Catch:{ all -> 0x00fd }
            throw r1     // Catch:{ all -> 0x00fd }
        L_0x0203:
            bsh.JJTParserState r0 = r0.m345d()
            r0.mo801a()
            int r0 = r11.depth()
            if (r0 <= r4) goto L_0x0216
            r11.clear()
            r11.push(r12)
        L_0x0216:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Interpreter.eval(java.io.Reader, bsh.NameSpace, java.lang.String):java.lang.Object");
    }

    public Object eval(String str) {
        if (DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("eval(String): ");
            stringBuffer.append(str);
            debug(stringBuffer.toString());
        }
        return eval(str, this.f570e);
    }

    public Object eval(String str, NameSpace nameSpace) {
        if (!str.endsWith(";")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(";");
            str = stringBuffer.toString();
        }
        StringReader stringReader = new StringReader(str);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("inline evaluation of: ``");
        stringBuffer2.append(m343c(str));
        stringBuffer2.append("''");
        return eval(stringReader, nameSpace, stringBuffer2.toString());
    }

    public Object get(String str) {
        try {
            return Primitive.unwrap(this.f570e.get(str, this));
        } catch (UtilEvalError e) {
            throw e.toEvalError(SimpleNode.JAVACODE, new CallStack());
        }
    }

    public BshClassManager getClassManager() {
        return getNameSpace().getClassManager();
    }

    public PrintStream getErr() {
        return this.f573h;
    }

    public Reader getIn() {
        return this.f571f;
    }

    public Object getInterface(Class cls) {
        try {
            return this.f570e.mo645a(this).getInterface(cls);
        } catch (UtilEvalError e) {
            throw e.toEvalError(SimpleNode.JAVACODE, new CallStack());
        }
    }

    public NameSpace getNameSpace() {
        return this.f570e;
    }

    public PrintStream getOut() {
        return this.f572g;
    }

    public Interpreter getParent() {
        return this.f575j;
    }

    public boolean getShowResults() {
        return this.f581q;
    }

    public String getSourceFileInfo() {
        return this.f576k != null ? this.f576k : "<unknown source>";
    }

    public boolean getStrictJava() {
        return this.f579o;
    }

    public File pathToFile(String str) {
        File file = new File(str);
        if (!file.isAbsolute()) {
            String str2 = (String) mo766a("bsh.cwd");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2);
            stringBuffer.append(File.separator);
            stringBuffer.append(str);
            file = new File(stringBuffer.toString());
        }
        return new File(file.getCanonicalPath());
    }

    public final void print(Object obj) {
        if (this.f574i != null) {
            this.f574i.print(obj);
            return;
        }
        this.f572g.print(obj);
        this.f572g.flush();
    }

    public final void println(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(obj));
        stringBuffer.append(f566b);
        print(stringBuffer.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01e9, code lost:
        if (r0.depth() > 1) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c6, code lost:
        if (r0.depth() > 1) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c8, code lost:
        r0.clear();
        r0.push(r8.f570e);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d0, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01d4 A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0244 A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x024b A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x024d A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0024 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0024 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0024 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0024 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0024 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x013f A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015f A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0178 A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0192 A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c9 A[Catch:{ all -> 0x00e3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            boolean r0 = r8.f577l
            if (r0 == 0) goto L_0x000c
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "bsh Interpreter: No stream"
            r0.<init>(r1)
            throw r0
        L_0x000c:
            boolean r0 = r8.f578m
            if (r0 == 0) goto L_0x001b
            java.lang.String r0 = "printBanner();"
            r8.eval(r0)     // Catch:{ EvalError -> 0x0016 }
            goto L_0x001b
        L_0x0016:
            java.lang.String r0 = "BeanShell 2.0b4 - by Pat Niemeyer (pat@pat.net)"
            r8.println(r0)
        L_0x001b:
            bsh.CallStack r0 = new bsh.CallStack
            bsh.NameSpace r1 = r8.f570e
            r0.<init>(r1)
            r1 = 0
            r2 = 0
        L_0x0024:
            if (r2 == 0) goto L_0x0032
            boolean r0 = r8.f578m
            if (r0 == 0) goto L_0x0031
            boolean r0 = r8.f580p
            if (r0 == 0) goto L_0x0031
            java.lang.System.exit(r1)
        L_0x0031:
            return
        L_0x0032:
            r3 = 1
            java.io.PrintStream r4 = java.lang.System.out     // Catch:{ ParseException -> 0x0222, InterpreterError -> 0x01ed, TargetError -> 0x01ab, EvalError -> 0x0157, Exception -> 0x0123, TokenMgrError -> 0x00e6 }
            r4.flush()     // Catch:{ ParseException -> 0x0222, InterpreterError -> 0x01ed, TargetError -> 0x01ab, EvalError -> 0x0157, Exception -> 0x0123, TokenMgrError -> 0x00e6 }
            java.io.PrintStream r4 = java.lang.System.err     // Catch:{ ParseException -> 0x0222, InterpreterError -> 0x01ed, TargetError -> 0x01ab, EvalError -> 0x0157, Exception -> 0x0123, TokenMgrError -> 0x00e6 }
            r4.flush()     // Catch:{ ParseException -> 0x0222, InterpreterError -> 0x01ed, TargetError -> 0x01ab, EvalError -> 0x0157, Exception -> 0x0123, TokenMgrError -> 0x00e6 }
            java.lang.Thread.yield()     // Catch:{ ParseException -> 0x0222, InterpreterError -> 0x01ed, TargetError -> 0x01ab, EvalError -> 0x0157, Exception -> 0x0123, TokenMgrError -> 0x00e6 }
            boolean r4 = r8.f578m     // Catch:{ ParseException -> 0x0222, InterpreterError -> 0x01ed, TargetError -> 0x01ab, EvalError -> 0x0157, Exception -> 0x0123, TokenMgrError -> 0x00e6 }
            if (r4 == 0) goto L_0x004b
            java.lang.String r4 = r8.m347f()     // Catch:{ ParseException -> 0x0222, InterpreterError -> 0x01ed, TargetError -> 0x01ab, EvalError -> 0x0157, Exception -> 0x0123, TokenMgrError -> 0x00e6 }
            r8.print(r4)     // Catch:{ ParseException -> 0x0222, InterpreterError -> 0x01ed, TargetError -> 0x01ab, EvalError -> 0x0157, Exception -> 0x0123, TokenMgrError -> 0x00e6 }
        L_0x004b:
            boolean r4 = r8.m346e()     // Catch:{ ParseException -> 0x0222, InterpreterError -> 0x01ed, TargetError -> 0x01ab, EvalError -> 0x0157, Exception -> 0x0123, TokenMgrError -> 0x00e6 }
            bsh.JJTParserState r2 = r8.m345d()     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            int r2 = r2.mo809d()     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            if (r2 <= 0) goto L_0x00bb
            bsh.JJTParserState r2 = r8.m345d()     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            bsh.Node r2 = r2.mo805b()     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            bsh.SimpleNode r2 = (bsh.SimpleNode) r2     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            boolean r5 = DEBUG     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            if (r5 == 0) goto L_0x006c
            java.lang.String r5 = ">"
            r2.dump(r5)     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
        L_0x006c:
            java.lang.Object r2 = r2.eval(r0, r8)     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            int r5 = r0.depth()     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            if (r5 <= r3) goto L_0x008d
            bsh.InterpreterError r2 = new bsh.InterpreterError     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            r5.<init>()     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            java.lang.String r6 = "Callstack growing: "
            r5.append(r6)     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            r5.append(r0)     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            java.lang.String r5 = r5.toString()     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            r2.<init>(r5)     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            throw r2     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
        L_0x008d:
            boolean r5 = r2 instanceof bsh.ReturnControl     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            if (r5 == 0) goto L_0x0095
            bsh.ReturnControl r2 = (bsh.ReturnControl) r2     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            java.lang.Object r2 = r2.value     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
        L_0x0095:
            bsh.Primitive r5 = bsh.Primitive.VOID     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            if (r2 == r5) goto L_0x00bb
            java.lang.String r5 = "$_"
            r8.mo768a(r5, r2)     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            boolean r5 = r8.f581q     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            if (r5 == 0) goto L_0x00bb
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            r5.<init>()     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            java.lang.String r6 = "<"
            r5.append(r6)     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            r5.append(r2)     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            java.lang.String r2 = ">"
            r5.append(r2)     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            java.lang.String r2 = r5.toString()     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
            r8.println(r2)     // Catch:{ ParseException -> 0x00e0, InterpreterError -> 0x00dd, TargetError -> 0x00da, EvalError -> 0x00d7, Exception -> 0x00d5, TokenMgrError -> 0x00d3 }
        L_0x00bb:
            bsh.JJTParserState r2 = r8.m345d()
            r2.mo801a()
            int r2 = r0.depth()
            if (r2 <= r3) goto L_0x00d0
        L_0x00c8:
            r0.clear()
            bsh.NameSpace r2 = r8.f570e
            r0.push(r2)
        L_0x00d0:
            r2 = r4
            goto L_0x0024
        L_0x00d3:
            r2 = move-exception
            goto L_0x00ea
        L_0x00d5:
            r2 = move-exception
            goto L_0x0127
        L_0x00d7:
            r2 = move-exception
            goto L_0x015b
        L_0x00da:
            r2 = move-exception
            goto L_0x01af
        L_0x00dd:
            r2 = move-exception
            goto L_0x01f1
        L_0x00e0:
            r2 = move-exception
            goto L_0x0226
        L_0x00e3:
            r1 = move-exception
            goto L_0x0264
        L_0x00e6:
            r4 = move-exception
            r7 = r4
            r4 = r2
            r2 = r7
        L_0x00ea:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x00e3 }
            r5.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "Error parsing input: "
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            r5.append(r2)     // Catch:{ all -> 0x00e3 }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x00e3 }
            r8.error(r2)     // Catch:{ all -> 0x00e3 }
            bsh.Parser r2 = r8.f569d     // Catch:{ all -> 0x00e3 }
            java.io.Reader r5 = r8.f571f     // Catch:{ all -> 0x00e3 }
            r2.mo984b(r5)     // Catch:{ all -> 0x00e3 }
            boolean r2 = r8.f578m     // Catch:{ all -> 0x00e3 }
            if (r2 != 0) goto L_0x010b
            r2 = 1
            goto L_0x010c
        L_0x010b:
            r2 = r4
        L_0x010c:
            bsh.JJTParserState r4 = r8.m345d()
            r4.mo801a()
            int r4 = r0.depth()
            if (r4 <= r3) goto L_0x0024
        L_0x0119:
            r0.clear()
            bsh.NameSpace r3 = r8.f570e
            r0.push(r3)
            goto L_0x0024
        L_0x0123:
            r4 = move-exception
            r7 = r4
            r4 = r2
            r2 = r7
        L_0x0127:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x00e3 }
            r5.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "Unknown error: "
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            r5.append(r2)     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e3 }
            r8.error(r5)     // Catch:{ all -> 0x00e3 }
            boolean r5 = DEBUG     // Catch:{ all -> 0x00e3 }
            if (r5 == 0) goto L_0x0142
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r2)     // Catch:{ all -> 0x00e3 }
        L_0x0142:
            boolean r2 = r8.f578m     // Catch:{ all -> 0x00e3 }
            if (r2 != 0) goto L_0x0148
            r2 = 1
            goto L_0x0149
        L_0x0148:
            r2 = r4
        L_0x0149:
            bsh.JJTParserState r4 = r8.m345d()
            r4.mo801a()
            int r4 = r0.depth()
            if (r4 <= r3) goto L_0x0024
            goto L_0x0119
        L_0x0157:
            r4 = move-exception
            r7 = r4
            r4 = r2
            r2 = r7
        L_0x015b:
            boolean r5 = r8.f578m     // Catch:{ all -> 0x00e3 }
            if (r5 == 0) goto L_0x0178
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x00e3 }
            r5.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "EvalError: "
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x00e3 }
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e3 }
        L_0x0174:
            r8.error(r5)     // Catch:{ all -> 0x00e3 }
            goto L_0x018e
        L_0x0178:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x00e3 }
            r5.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "EvalError: "
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = r2.getMessage()     // Catch:{ all -> 0x00e3 }
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e3 }
            goto L_0x0174
        L_0x018e:
            boolean r5 = DEBUG     // Catch:{ all -> 0x00e3 }
            if (r5 == 0) goto L_0x0195
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r2)     // Catch:{ all -> 0x00e3 }
        L_0x0195:
            boolean r2 = r8.f578m     // Catch:{ all -> 0x00e3 }
            if (r2 != 0) goto L_0x019b
            r2 = 1
            goto L_0x019c
        L_0x019b:
            r2 = r4
        L_0x019c:
            bsh.JJTParserState r4 = r8.m345d()
            r4.mo801a()
            int r4 = r0.depth()
            if (r4 <= r3) goto L_0x0024
            goto L_0x0119
        L_0x01ab:
            r4 = move-exception
            r7 = r4
            r4 = r2
            r2 = r7
        L_0x01af:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x00e3 }
            r5.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "// Uncaught Exception: "
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            r5.append(r2)     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e3 }
            r8.error(r5)     // Catch:{ all -> 0x00e3 }
            boolean r5 = r2.inNativeCode()     // Catch:{ all -> 0x00e3 }
            if (r5 == 0) goto L_0x01d0
            boolean r5 = DEBUG     // Catch:{ all -> 0x00e3 }
            java.io.PrintStream r6 = r8.f573h     // Catch:{ all -> 0x00e3 }
            r2.printStackTrace(r5, r6)     // Catch:{ all -> 0x00e3 }
        L_0x01d0:
            boolean r5 = r8.f578m     // Catch:{ all -> 0x00e3 }
            if (r5 != 0) goto L_0x01d5
            r4 = 1
        L_0x01d5:
            java.lang.String r5 = "$_e"
            java.lang.Throwable r2 = r2.getTarget()     // Catch:{ all -> 0x00e3 }
            r8.mo768a(r5, r2)     // Catch:{ all -> 0x00e3 }
            bsh.JJTParserState r2 = r8.m345d()
            r2.mo801a()
            int r2 = r0.depth()
            if (r2 <= r3) goto L_0x00d0
            goto L_0x00c8
        L_0x01ed:
            r4 = move-exception
            r7 = r4
            r4 = r2
            r2 = r7
        L_0x01f1:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x00e3 }
            r5.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "Internal Error: "
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = r2.getMessage()     // Catch:{ all -> 0x00e3 }
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e3 }
            r8.error(r5)     // Catch:{ all -> 0x00e3 }
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r2)     // Catch:{ all -> 0x00e3 }
            boolean r2 = r8.f578m     // Catch:{ all -> 0x00e3 }
            if (r2 != 0) goto L_0x0212
            r2 = 1
            goto L_0x0213
        L_0x0212:
            r2 = r4
        L_0x0213:
            bsh.JJTParserState r4 = r8.m345d()
            r4.mo801a()
            int r4 = r0.depth()
            if (r4 <= r3) goto L_0x0024
            goto L_0x0119
        L_0x0222:
            r4 = move-exception
            r7 = r4
            r4 = r2
            r2 = r7
        L_0x0226:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x00e3 }
            r5.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "Parser Error: "
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            boolean r6 = DEBUG     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = r2.getMessage(r6)     // Catch:{ all -> 0x00e3 }
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e3 }
            r8.error(r5)     // Catch:{ all -> 0x00e3 }
            boolean r5 = DEBUG     // Catch:{ all -> 0x00e3 }
            if (r5 == 0) goto L_0x0247
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r2)     // Catch:{ all -> 0x00e3 }
        L_0x0247:
            boolean r2 = r8.f578m     // Catch:{ all -> 0x00e3 }
            if (r2 != 0) goto L_0x024d
            r2 = 1
            goto L_0x024e
        L_0x024d:
            r2 = r4
        L_0x024e:
            bsh.Parser r4 = r8.f569d     // Catch:{ all -> 0x00e3 }
            java.io.Reader r5 = r8.f571f     // Catch:{ all -> 0x00e3 }
            r4.mo981a(r5)     // Catch:{ all -> 0x00e3 }
            bsh.JJTParserState r4 = r8.m345d()
            r4.mo801a()
            int r4 = r0.depth()
            if (r4 <= r3) goto L_0x0024
            goto L_0x0119
        L_0x0264:
            bsh.JJTParserState r2 = r8.m345d()
            r2.mo801a()
            int r2 = r0.depth()
            if (r2 <= r3) goto L_0x0279
            r0.clear()
            bsh.NameSpace r2 = r8.f570e
            r0.push(r2)
        L_0x0279:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Interpreter.run():void");
    }

    public void set(String str, double d) {
        set(str, (Object) new Primitive(d));
    }

    public void set(String str, float f) {
        set(str, (Object) new Primitive(f));
    }

    public void set(String str, int i) {
        set(str, (Object) new Primitive(i));
    }

    public void set(String str, long j) {
        set(str, (Object) new Primitive(j));
    }

    public void set(String str, Object obj) {
        if (obj == null) {
            obj = Primitive.NULL;
        }
        CallStack callStack = new CallStack();
        try {
            if (Name.isCompound(str)) {
                this.f570e.mo860b(str).toLHS(callStack, this).assign(obj, false);
            } else {
                this.f570e.setVariable(str, obj, false);
            }
        } catch (UtilEvalError e) {
            throw e.toEvalError(SimpleNode.JAVACODE, callStack);
        }
    }

    public void set(String str, boolean z) {
        set(str, (Object) new Primitive(z));
    }

    public void setClassLoader(ClassLoader classLoader) {
        getClassManager().setClassLoader(classLoader);
    }

    public void setConsole(ConsoleInterface consoleInterface) {
        this.f574i = consoleInterface;
        mo768a("bsh.console", consoleInterface);
        setOut(consoleInterface.getOut());
        setErr(consoleInterface.getErr());
    }

    public void setErr(PrintStream printStream) {
        this.f573h = printStream;
    }

    public void setExitOnEOF(boolean z) {
        this.f580p = z;
    }

    public void setNameSpace(NameSpace nameSpace) {
        this.f570e = nameSpace;
    }

    public void setOut(PrintStream printStream) {
        this.f572g = printStream;
    }

    public void setShowResults(boolean z) {
        this.f581q = z;
    }

    public void setStrictJava(boolean z) {
        this.f579o = z;
    }

    public Object source(String str) {
        return source(str, this.f570e);
    }

    public Object source(String str, NameSpace nameSpace) {
        File pathToFile = pathToFile(str);
        if (DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Sourcing file: ");
            stringBuffer.append(pathToFile);
            debug(stringBuffer.toString());
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile));
        try {
            return eval(bufferedReader, nameSpace, str);
        } finally {
            bufferedReader.close();
        }
    }

    public void unset(String str) {
        try {
            LHS lhs = this.f570e.mo860b(str).toLHS(new CallStack(), this);
            if (lhs.f604c != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Can't unset, not a variable: ");
                stringBuffer.append(str);
                throw new EvalError(stringBuffer.toString(), SimpleNode.JAVACODE, new CallStack());
            }
            lhs.f602a.unsetVariable(str);
        } catch (UtilEvalError e) {
            throw new EvalError(e.getMessage(), SimpleNode.JAVACODE, new CallStack());
        }
    }
}
