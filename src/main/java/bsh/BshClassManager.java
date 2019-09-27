package bsh;

import bsh.Capabilities.Unavailable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.Hashtable;

public class BshClassManager {

    /* renamed from: h */
    static Class f497h;

    /* renamed from: i */
    private static Object f498i = new Object();

    /* renamed from: a */
    protected ClassLoader f499a;

    /* renamed from: b */
    protected transient Hashtable f500b = new Hashtable();

    /* renamed from: c */
    protected transient Hashtable f501c = new Hashtable();

    /* renamed from: d */
    protected transient Hashtable f502d = new Hashtable();

    /* renamed from: e */
    protected transient Hashtable f503e = new Hashtable();

    /* renamed from: f */
    protected transient Hashtable f504f = new Hashtable();

    /* renamed from: g */
    protected transient Hashtable f505g = new Hashtable();

    /* renamed from: j */
    private Interpreter f506j;

    public interface Listener {
        void classLoaderChanged();
    }

    static class SignatureKey {

        /* renamed from: a */
        Class f507a;

        /* renamed from: b */
        Class[] f508b;

        /* renamed from: c */
        String f509c;

        /* renamed from: d */
        int f510d = 0;

        SignatureKey(Class cls, String str, Class[] clsArr) {
            this.f507a = cls;
            this.f509c = str;
            this.f508b = clsArr;
        }

        public boolean equals(Object obj) {
            SignatureKey signatureKey = (SignatureKey) obj;
            if (this.f508b == null) {
                return signatureKey.f508b == null;
            }
            if (this.f507a != signatureKey.f507a || !this.f509c.equals(signatureKey.f509c) || this.f508b.length != signatureKey.f508b.length) {
                return false;
            }
            for (int i = 0; i < this.f508b.length; i++) {
                if (this.f508b[i] == null) {
                    if (signatureKey.f508b[i] != null) {
                        return false;
                    }
                } else if (!this.f508b[i].equals(signatureKey.f508b[i])) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            if (this.f510d == 0) {
                this.f510d = this.f507a.hashCode() * this.f509c.hashCode();
                if (this.f508b == null) {
                    return this.f510d;
                }
                int i = 0;
                while (i < this.f508b.length) {
                    int hashCode = this.f508b[i] == null ? 21 : this.f508b[i].hashCode();
                    i++;
                    this.f510d = (this.f510d * i) + hashCode;
                }
            }
            return this.f510d;
        }
    }

    /* renamed from: a */
    protected static Error m296a(String str, Error error) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("A class required by class: ");
        stringBuffer.append(str);
        stringBuffer.append(" could not be loaded:\n");
        stringBuffer.append(error.toString());
        return new NoClassDefFoundError(stringBuffer.toString());
    }

    public static BshClassManager createClassManager(Interpreter interpreter) {
        BshClassManager bshClassManager;
        if (!Capabilities.classExists("java.lang.ref.WeakReference") || !Capabilities.classExists("java.util.HashMap") || !Capabilities.classExists("bsh.classpath.ClassManagerImpl")) {
            bshClassManager = new BshClassManager();
        } else {
            try {
                bshClassManager = (BshClassManager) Class.forName("bsh.classpath.ClassManagerImpl").newInstance();
            } catch (Exception e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Error loading classmanager: ");
                stringBuffer.append(e);
                throw new InterpreterError(stringBuffer.toString());
            }
        }
        if (interpreter == null) {
            interpreter = new Interpreter();
        }
        bshClassManager.f506j = interpreter;
        return bshClassManager;
    }

    /* renamed from: e */
    protected static UtilEvalError m297e() {
        return new Unavailable("ClassLoading features unavailable.");
    }

    /* renamed from: g */
    static Class m298g(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Class mo652a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("/");
        stringBuffer.append(str.replace('.', '/'));
        stringBuffer.append(".java");
        String stringBuffer2 = stringBuffer.toString();
        InputStream resourceAsStream = getResourceAsStream(stringBuffer2);
        if (resourceAsStream == null) {
            return null;
        }
        try {
            PrintStream printStream = System.out;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Loading class from source file: ");
            stringBuffer3.append(stringBuffer2);
            printStream.println(stringBuffer3.toString());
            this.f506j.eval((Reader) new InputStreamReader(resourceAsStream));
        } catch (EvalError e) {
            System.err.println(e);
        }
        try {
            return plainClassForName(str);
        } catch (ClassNotFoundException unused) {
            PrintStream printStream2 = System.err;
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Class not found in source file: ");
            stringBuffer4.append(str);
            printStream2.println(stringBuffer4.toString());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Method mo653a(Class cls, String str, Class[] clsArr, boolean z) {
        String stringBuffer;
        SignatureKey signatureKey = new SignatureKey(cls, str, clsArr);
        Method method = (Method) this.f503e.get(signatureKey);
        if (method == null && !z) {
            method = (Method) this.f502d.get(signatureKey);
        }
        if (!Interpreter.DEBUG) {
            return method;
        }
        if (method == null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("getResolvedMethod cache MISS: ");
            stringBuffer2.append(cls);
            stringBuffer2.append(" - ");
            stringBuffer2.append(str);
            stringBuffer = stringBuffer2.toString();
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("getResolvedMethod cache HIT: ");
            stringBuffer3.append(cls);
            stringBuffer3.append(" - ");
            stringBuffer3.append(method);
            stringBuffer = stringBuffer3.toString();
        }
        Interpreter.debug(stringBuffer);
        return method;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo654a() {
        this.f501c = new Hashtable();
        this.f500b = new Hashtable();
        this.f502d = new Hashtable();
        this.f503e = new Hashtable();
    }

    public void addClassPath(URL url) {
    }

    public void addListener(Listener listener) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo657b(String str) {
        throw m297e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo658b() {
        throw m297e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo659c(String str) {
        String suffix = Name.suffix(str, 1);
        int indexOf = suffix.indexOf("$");
        if (indexOf != -1) {
            suffix = suffix.substring(indexOf + 1);
        }
        String str2 = (String) this.f505g.get(suffix);
        if (str2 != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Defining class problem: ");
            stringBuffer.append(str);
            stringBuffer.append(": BeanShell cannot yet simultaneously define two or more ");
            stringBuffer.append("dependant classes of the same name.  Attempt to define: ");
            stringBuffer.append(str);
            stringBuffer.append(" while defining: ");
            stringBuffer.append(str2);
            throw new InterpreterError(stringBuffer.toString());
        }
        this.f504f.put(str, f498i);
        this.f505g.put(suffix, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo660c() {
        return false;
    }

    public void cacheClassInfo(String str, Class cls) {
        if (cls != null) {
            this.f500b.put(str, cls);
        } else {
            this.f501c.put(str, f498i);
        }
    }

    public void cacheResolvedMethod(Class cls, Class[] clsArr, Method method) {
        if (Interpreter.DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("cacheResolvedMethod putting: ");
            stringBuffer.append(cls);
            stringBuffer.append(" ");
            stringBuffer.append(method);
            Interpreter.debug(stringBuffer.toString());
        }
        (Modifier.isStatic(method.getModifiers()) ? this.f503e : this.f502d).put(new SignatureKey(cls, method.getName(), clsArr), method);
    }

    public boolean classExists(String str) {
        return classForName(str) != null;
    }

    public Class classForName(String str) {
        if (mo666d(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Attempting to load class in the process of being defined: ");
            stringBuffer.append(str);
            throw new InterpreterError(stringBuffer.toString());
        }
        Class cls = null;
        try {
            cls = plainClassForName(str);
        } catch (ClassNotFoundException unused) {
        }
        return cls == null ? mo652a(str) : cls;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo665d() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo666d(String str) {
        return this.f504f.get(str) != null;
    }

    public Class defineClass(String str, byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Can't create class (");
        stringBuffer.append(str);
        stringBuffer.append(") without class manager package.");
        throw new InterpreterError(stringBuffer.toString());
    }

    public void dump(PrintWriter printWriter) {
        printWriter.println("BshClassManager: no class manager.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo669e(String str) {
        return (String) this.f505g.get(Name.suffix(str, 1));
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo670f(String str) {
        String suffix = Name.suffix(str, 1);
        this.f504f.remove(str);
        this.f505g.remove(suffix);
    }

    public URL getResource(String str) {
        Class cls;
        URL resource = this.f499a != null ? this.f499a.getResource(str.substring(1)) : null;
        if (resource != null) {
            return resource;
        }
        if (f497h == null) {
            cls = m298g("bsh.Interpreter");
            f497h = cls;
        } else {
            cls = f497h;
        }
        return cls.getResource(str);
    }

    public InputStream getResourceAsStream(String str) {
        Class cls;
        InputStream resourceAsStream = this.f499a != null ? this.f499a.getResourceAsStream(str.substring(1)) : null;
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        if (f497h == null) {
            cls = m298g("bsh.Interpreter");
            f497h = cls;
        } else {
            cls = f497h;
        }
        return cls.getResourceAsStream(str);
    }

    public Class plainClassForName(String str) {
        try {
            Class loadClass = this.f499a != null ? this.f499a.loadClass(str) : Class.forName(str);
            cacheClassInfo(str, loadClass);
            return loadClass;
        } catch (NoClassDefFoundError e) {
            throw m296a(str, e);
        }
    }

    public void reloadAllClasses() {
        throw m297e();
    }

    public void reloadClasses(String[] strArr) {
        throw m297e();
    }

    public void reloadPackage(String str) {
        throw m297e();
    }

    public void removeListener(Listener listener) {
    }

    public void reset() {
        mo654a();
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.f499a = classLoader;
        mo665d();
    }

    public void setClassPath(URL[] urlArr) {
        throw m297e();
    }
}
