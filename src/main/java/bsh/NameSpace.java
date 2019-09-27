package bsh;

import bsh.BshClassManager.Listener;
import com.androlua.BuildConfig;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class NameSpace implements Listener, NameSource, Serializable {
    public static final NameSpace JAVACODE = new NameSpace((BshClassManager) null, "Called from compiled Java code.");

    /* renamed from: a */
    protected Hashtable f619a;

    /* renamed from: b */
    SimpleNode f620b;

    /* renamed from: c */
    boolean f621c;

    /* renamed from: d */
    boolean f622d;

    /* renamed from: e */
    Class f623e;

    /* renamed from: f */
    Object f624f;

    /* renamed from: g */
    Vector f625g;

    /* renamed from: h */
    private String f626h;

    /* renamed from: i */
    private NameSpace f627i;

    /* renamed from: j */
    private Hashtable f628j;

    /* renamed from: k */
    private Hashtable f629k;

    /* renamed from: l */
    private Vector f630l;

    /* renamed from: m */
    private Vector f631m;

    /* renamed from: n */
    private Vector f632n;

    /* renamed from: o */
    private Vector f633o;

    /* renamed from: p */
    private String f634p;

    /* renamed from: q */
    private transient BshClassManager f635q;

    /* renamed from: r */
    private This f636r;

    /* renamed from: s */
    private Hashtable f637s;

    /* renamed from: t */
    private transient Hashtable f638t;

    static {
        JAVACODE.f621c = true;
    }

    public NameSpace(BshClassManager bshClassManager, String str) {
        this(null, bshClassManager, str);
    }

    public NameSpace(NameSpace nameSpace, BshClassManager bshClassManager, String str) {
        setName(str);
        setParent(nameSpace);
        mo854a(bshClassManager);
        if (bshClassManager != null) {
            bshClassManager.addListener(this);
        }
    }

    public NameSpace(NameSpace nameSpace, String str) {
        this(nameSpace, null, str);
    }

    /* renamed from: a */
    private BshMethod m380a(InputStream inputStream, String str, Class[] clsArr, String str2, Interpreter interpreter) {
        try {
            interpreter.eval(new InputStreamReader(inputStream), this, str2);
            return getMethod(str, clsArr);
        } catch (EvalError e) {
            Interpreter.debug(e.toString());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error loading script: ");
            stringBuffer.append(e.getMessage());
            throw new UtilEvalError(stringBuffer.toString());
        }
    }

    /* renamed from: a */
    private String[] m381a(Enumeration enumeration) {
        Vector vector = new Vector();
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    /* renamed from: b */
    private BshMethod[] m382b(Enumeration enumeration) {
        Vector vector = new Vector();
        while (enumeration.hasMoreElements()) {
            Object nextElement = enumeration.nextElement();
            if (nextElement instanceof BshMethod) {
                vector.addElement(nextElement);
            } else {
                Vector vector2 = (Vector) nextElement;
                for (int i = 0; i < vector2.size(); i++) {
                    vector.addElement(vector2.elementAt(i));
                }
            }
        }
        BshMethod[] bshMethodArr = new BshMethod[vector.size()];
        vector.copyInto(bshMethodArr);
        return bshMethodArr;
    }

    /* renamed from: d */
    private Class m383d(String str) {
        Class cls;
        if (this.f638t != null) {
            cls = (Class) this.f638t.get(str);
            if (cls != null) {
                return cls;
            }
        } else {
            cls = null;
        }
        boolean z = !Name.isCompound(str);
        if (z) {
            if (cls == null) {
                cls = m384e(str);
            }
            if (cls != null) {
                mo858a(str, cls);
                return cls;
            }
        }
        Class f = m385f(str);
        if (f != null) {
            if (z) {
                mo858a(str, f);
            }
            return f;
        }
        if (Interpreter.DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("getClass(): ");
            stringBuffer.append(str);
            stringBuffer.append(" not\tfound in ");
            stringBuffer.append(this);
            Interpreter.debug(stringBuffer.toString());
        }
        return null;
    }

    /* renamed from: e */
    private Class m384e(String str) {
        String str2 = this.f619a != null ? (String) this.f619a.get(str) : null;
        if (str2 != null) {
            Class f = m385f(str2);
            if (f != null) {
                return f;
            }
            if (Name.isCompound(str2)) {
                try {
                    f = mo860b(str2).toClass();
                } catch (ClassNotFoundException unused) {
                }
            } else if (Interpreter.DEBUG) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("imported unpackaged name not found:");
                stringBuffer.append(str2);
                Interpreter.debug(stringBuffer.toString());
            }
            if (f == null) {
                return null;
            }
            getClassManager().cacheClassInfo(str2, f);
            return f;
        }
        if (this.f630l != null) {
            for (int size = this.f630l.size() - 1; size >= 0; size--) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append((String) this.f630l.elementAt(size));
                stringBuffer2.append(".");
                stringBuffer2.append(str);
                Class f2 = m385f(stringBuffer2.toString());
                if (f2 != null) {
                    return f2;
                }
            }
        }
        BshClassManager classManager = getClassManager();
        if (classManager.mo660c()) {
            String b = classManager.mo657b(str);
            if (b != null) {
                return m385f(b);
            }
        }
        return null;
    }

    /* renamed from: f */
    private Class m385f(String str) {
        return getClassManager().classForName(str);
    }

    public static Class identifierToClass(ClassIdentifier classIdentifier) {
        return classIdentifier.getTargetClass();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public BshMethod mo850a(String str, Class[] clsArr) {
        if (this.f632n != null) {
            for (int i = 0; i < this.f632n.size(); i++) {
                Object elementAt = this.f632n.elementAt(i);
                Method a = Reflect.m736a(getClassManager(), elementAt.getClass(), str, clsArr, false);
                if (a != null) {
                    return new BshMethod(a, elementAt);
                }
            }
        }
        if (this.f633o == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.f633o.size(); i2++) {
            Method a2 = Reflect.m736a(getClassManager(), (Class) this.f633o.elementAt(i2), str, clsArr, true);
            if (a2 != null) {
                return new BshMethod(a2, null);
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public This mo645a(Interpreter interpreter) {
        if (this.f636r == null) {
            this.f636r = This.m751a(this, interpreter);
        }
        return this.f636r;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Variable mo851a(String str) {
        if (this.f632n != null) {
            for (int i = 0; i < this.f632n.size(); i++) {
                Object elementAt = this.f632n.elementAt(i);
                Field a = Reflect.m734a(elementAt.getClass(), str, false);
                if (a != null) {
                    return new Variable(str, a.getType(), new LHS(elementAt, a));
                }
            }
        }
        if (this.f633o != null) {
            for (int i2 = 0; i2 < this.f633o.size(); i2++) {
                Field a2 = Reflect.m734a((Class) this.f633o.elementAt(i2), str, true);
                if (a2 != null) {
                    return new Variable(str, a2.getType(), new LHS(a2));
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Variable mo755a(String str, boolean z) {
        Variable a = this.f622d ? mo851a(str) : null;
        if (a == null && this.f628j != null) {
            a = (Variable) this.f628j.get(str);
        }
        if (a == null && !this.f622d) {
            a = mo851a(str);
        }
        return (!z || a != null || this.f627i == null) ? a : this.f627i.mo755a(str, z);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo852a() {
        if (this.f624f != null) {
            return this.f624f;
        }
        if (this.f623e != null) {
            throw new UtilEvalError("Can't refer to class instance from static context.");
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Can't resolve class instance 'this' in: ");
        stringBuffer.append(this);
        throw new InterpreterError(stringBuffer.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo853a(Variable variable) {
        return variable == null ? Primitive.VOID : variable.mo1035a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo854a(BshClassManager bshClassManager) {
        this.f635q = bshClassManager;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo855a(SimpleNode simpleNode) {
        this.f620b = simpleNode;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo856a(Class cls) {
        this.f623e = cls;
        importStatic(cls);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo857a(Object obj) {
        this.f624f = obj;
        importObject(obj);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo858a(String str, Class cls) {
        if (this.f638t == null) {
            this.f638t = new Hashtable();
        }
        this.f638t.put(str, cls);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo859a(String str, Object obj, boolean z) {
        setVariable(str, obj, z, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo757a(Vector vector) {
        Enumeration keys = this.f628j.keys();
        while (keys.hasMoreElements()) {
            vector.addElement(keys.nextElement());
        }
        Enumeration keys2 = this.f629k.keys();
        while (keys2.hasMoreElements()) {
            vector.addElement(keys2.nextElement());
        }
        if (this.f627i != null) {
            this.f627i.mo757a(vector);
        }
    }

    public void addNameSourceListener(NameSource.Listener listener) {
        if (this.f625g == null) {
            this.f625g = new Vector();
        }
        this.f625g.addElement(listener);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Name mo860b(String str) {
        if (this.f637s == null) {
            this.f637s = new Hashtable();
        }
        Name name = (Name) this.f637s.get(str);
        if (name != null) {
            return name;
        }
        Name name2 = new Name(this, str);
        this.f637s.put(str, name2);
        return name2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public SimpleNode mo861b() {
        if (this.f620b != null) {
            return this.f620b;
        }
        if (this.f627i != null) {
            return this.f627i.mo861b();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo862c() {
        if (this.f634p != null) {
            return this.f634p;
        }
        if (this.f627i != null) {
            return this.f627i.mo862c();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo863c(String str) {
        this.f634p = str;
    }

    public void classLoaderChanged() {
        nameSpaceChanged();
    }

    public void clear() {
        this.f628j = null;
        this.f629k = null;
        this.f619a = null;
        this.f630l = null;
        this.f631m = null;
        this.f632n = null;
        if (this.f627i == null) {
            loadDefaultImports();
        }
        this.f638t = null;
        this.f637s = null;
    }

    public void doSuperImport() {
        getClassManager().mo658b();
    }

    public Object get(String str, Interpreter interpreter) {
        return mo860b(str).toObject(new CallStack(this), interpreter);
    }

    public String[] getAllNames() {
        Vector vector = new Vector();
        mo757a(vector);
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    public Class getClass(String str) {
        Class d = m383d(str);
        if (d != null) {
            return d;
        }
        if (this.f627i != null) {
            return this.f627i.getClass(str);
        }
        return null;
    }

    public BshClassManager getClassManager() {
        if (this.f635q != null) {
            return this.f635q;
        }
        if (this.f627i != null && this.f627i != JAVACODE) {
            return this.f627i.getClassManager();
        }
        System.out.println("experiment: creating class manager");
        this.f635q = BshClassManager.createClassManager(null);
        return this.f635q;
    }

    public Object getCommand(String str, Class[] clsArr, Interpreter interpreter) {
        StringBuffer stringBuffer;
        String str2;
        if (Interpreter.DEBUG) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("getCommand: ");
            stringBuffer2.append(str);
            Interpreter.debug(stringBuffer2.toString());
        }
        BshClassManager classManager = interpreter.getClassManager();
        if (this.f631m != null) {
            for (int size = this.f631m.size() - 1; size >= 0; size--) {
                String str3 = (String) this.f631m.elementAt(size);
                if (str3.equals("/")) {
                    stringBuffer = new StringBuffer();
                    stringBuffer.append(str3);
                } else {
                    stringBuffer = new StringBuffer();
                    stringBuffer.append(str3);
                    stringBuffer.append("/");
                }
                stringBuffer.append(str);
                stringBuffer.append(".bsh");
                String stringBuffer3 = stringBuffer.toString();
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("searching for script: ");
                stringBuffer4.append(stringBuffer3);
                Interpreter.debug(stringBuffer4.toString());
                InputStream resourceAsStream = classManager.getResourceAsStream(stringBuffer3);
                if (resourceAsStream != null) {
                    return m380a(resourceAsStream, str, clsArr, stringBuffer3, interpreter);
                }
                if (str3.equals("/")) {
                    str2 = str;
                } else {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append(str3.substring(1).replace('/', '.'));
                    stringBuffer5.append(".");
                    stringBuffer5.append(str);
                    str2 = stringBuffer5.toString();
                }
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append("searching for class: ");
                stringBuffer6.append(str2);
                Interpreter.debug(stringBuffer6.toString());
                Class classForName = classManager.classForName(str2);
                if (classForName != null) {
                    return classForName;
                }
            }
        }
        if (this.f627i != null) {
            return this.f627i.getCommand(str, clsArr, interpreter);
        }
        return null;
    }

    public Variable[] getDeclaredVariables() {
        int i = 0;
        if (this.f628j == null) {
            return new Variable[0];
        }
        Variable[] variableArr = new Variable[this.f628j.size()];
        Enumeration elements = this.f628j.elements();
        while (elements.hasMoreElements()) {
            int i2 = i + 1;
            variableArr[i] = (Variable) elements.nextElement();
            i = i2;
        }
        return variableArr;
    }

    public This getGlobal(Interpreter interpreter) {
        return this.f627i != null ? this.f627i.getGlobal(interpreter) : mo645a(interpreter);
    }

    public int getInvocationLine() {
        SimpleNode b = mo861b();
        if (b != null) {
            return b.getLineNumber();
        }
        return -1;
    }

    public String getInvocationText() {
        SimpleNode b = mo861b();
        return b != null ? b.getText() : "<invoked from Java code>";
    }

    public BshMethod getMethod(String str, Class[] clsArr) {
        return getMethod(str, clsArr, false);
    }

    public BshMethod getMethod(String str, Class[] clsArr, boolean z) {
        BshMethod[] bshMethodArr;
        BshMethod a = (!this.f622d || z) ? null : mo850a(str, clsArr);
        if (a == null && this.f629k != null) {
            Object obj = this.f629k.get(str);
            if (obj != null) {
                if (obj instanceof Vector) {
                    Vector vector = (Vector) obj;
                    bshMethodArr = new BshMethod[vector.size()];
                    vector.copyInto(bshMethodArr);
                } else {
                    bshMethodArr = new BshMethod[]{(BshMethod) obj};
                }
                Class[][] clsArr2 = new Class[bshMethodArr.length][];
                for (int i = 0; i < bshMethodArr.length; i++) {
                    clsArr2[i] = bshMethodArr[i].getParameterTypes();
                }
                int a2 = Reflect.m725a(clsArr, clsArr2);
                if (a2 != -1) {
                    a = bshMethodArr[a2];
                }
            }
        }
        if (a == null && !this.f622d && !z) {
            a = mo850a(str, clsArr);
        }
        return (z || a != null || this.f627i == null) ? a : this.f627i.getMethod(str, clsArr);
    }

    public String[] getMethodNames() {
        return this.f629k == null ? new String[0] : m381a(this.f629k.keys());
    }

    public BshMethod[] getMethods() {
        return this.f629k == null ? new BshMethod[0] : m382b(this.f629k.elements());
    }

    public String getName() {
        return this.f626h;
    }

    public NameSpace getParent() {
        return this.f627i;
    }

    public This getSuper(Interpreter interpreter) {
        return this.f627i != null ? this.f627i.mo645a(interpreter) : mo645a(interpreter);
    }

    public Object getVariable(String str) {
        return getVariable(str, true);
    }

    public Object getVariable(String str, boolean z) {
        return mo853a(mo755a(str, z));
    }

    public String[] getVariableNames() {
        return this.f628j == null ? new String[0] : m381a(this.f628j.keys());
    }

    public void importClass(String str) {
        if (this.f619a == null) {
            this.f619a = new Hashtable();
        }
        this.f619a.put(Name.suffix(str, 1), str);
        nameSpaceChanged();
    }

    public void importCommands(String str) {
        if (this.f631m == null) {
            this.f631m = new Vector();
        }
        String replace = str.replace('.', '/');
        if (!replace.startsWith("/")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("/");
            stringBuffer.append(replace);
            replace = stringBuffer.toString();
        }
        if (replace.length() > 1 && replace.endsWith("/")) {
            replace = replace.substring(0, replace.length() - 1);
        }
        if (this.f631m.contains(replace)) {
            this.f631m.remove(replace);
        }
        this.f631m.addElement(replace);
        nameSpaceChanged();
    }

    public void importObject(Object obj) {
        if (this.f632n == null) {
            this.f632n = new Vector();
        }
        if (this.f632n.contains(obj)) {
            this.f632n.remove(obj);
        }
        this.f632n.addElement(obj);
        nameSpaceChanged();
    }

    public void importPackage(String str) {
        if (this.f630l == null) {
            this.f630l = new Vector();
        }
        if (this.f630l.contains(str)) {
            this.f630l.remove(str);
        }
        this.f630l.addElement(str);
        nameSpaceChanged();
    }

    public void importStatic(Class cls) {
        if (this.f633o == null) {
            this.f633o = new Vector();
        }
        if (this.f633o.contains(cls)) {
            this.f633o.remove(cls);
        }
        this.f633o.addElement(cls);
        nameSpaceChanged();
    }

    public Object invokeMethod(String str, Object[] objArr, Interpreter interpreter) {
        return invokeMethod(str, objArr, interpreter, null, null);
    }

    public Object invokeMethod(String str, Object[] objArr, Interpreter interpreter, CallStack callStack, SimpleNode simpleNode) {
        return mo645a(interpreter).invokeMethod(str, objArr, interpreter, callStack, simpleNode, false);
    }

    public void loadDefaultImports() {
        importClass("bsh.EvalError");
        importClass("bsh.Interpreter");
        importPackage("javax.swing.event");
        importPackage("javax.swing");
        importPackage("java.awt.event");
        importPackage("java.awt");
        importPackage("java.net");
        importPackage("java.util");
        importPackage("java.io");
        importPackage("java.lang");
        importCommands("/bsh/commands");
    }

    public void nameSpaceChanged() {
        this.f638t = null;
        this.f637s = null;
    }

    public void prune() {
        if (this.f635q == null) {
            mo854a(BshClassManager.createClassManager(null));
        }
        setParent(null);
    }

    public void setMethod(String str, BshMethod bshMethod) {
        if (this.f629k == null) {
            this.f629k = new Hashtable();
        }
        Object obj = this.f629k.get(str);
        if (obj == null) {
            this.f629k.put(str, bshMethod);
        } else if (obj instanceof BshMethod) {
            Vector vector = new Vector();
            vector.addElement(obj);
            vector.addElement(bshMethod);
            this.f629k.put(str, vector);
        } else {
            ((Vector) obj).addElement(bshMethod);
        }
    }

    public void setName(String str) {
        this.f626h = str;
    }

    public void setParent(NameSpace nameSpace) {
        this.f627i = nameSpace;
        if (nameSpace == null) {
            loadDefaultImports();
        }
    }

    public void setTypedVariable(String str, Class cls, Object obj, Modifiers modifiers) {
        if (this.f628j == null) {
            this.f628j = new Hashtable();
        }
        Variable a = mo755a(str, false);
        if (a == null || a.getType() == null) {
            this.f628j.put(str, new Variable(str, cls, obj, modifiers));
        } else if (a.getType() != cls) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Typed variable: ");
            stringBuffer.append(str);
            stringBuffer.append(" was previously declared with type: ");
            stringBuffer.append(a.getType());
            throw new UtilEvalError(stringBuffer.toString());
        } else {
            a.setValue(obj, 0);
        }
    }

    public void setTypedVariable(String str, Class cls, Object obj, boolean z) {
        Modifiers modifiers = new Modifiers();
        if (z) {
            modifiers.addModifier(2, "final");
        }
        setTypedVariable(str, cls, obj, modifiers);
    }

    public void setVariable(String str, Object obj, boolean z) {
        setVariable(str, obj, z, Interpreter.LOCALSCOPING ? z : true);
    }

    /* access modifiers changed from: 0000 */
    public void setVariable(String str, Object obj, boolean z, boolean z2) {
        if (this.f628j == null) {
            this.f628j = new Hashtable();
        }
        if (obj == null) {
            throw new InterpreterError("null variable value");
        }
        Variable a = mo755a(str, z2);
        if (a != null) {
            try {
                a.setValue(obj, 1);
            } catch (UtilEvalError e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Variable assignment: ");
                stringBuffer.append(str);
                stringBuffer.append(": ");
                stringBuffer.append(e.getMessage());
                throw new UtilEvalError(stringBuffer.toString());
            }
        } else if (z) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("(Strict Java mode) Assignment to undeclared variable: ");
            stringBuffer2.append(str);
            throw new UtilEvalError(stringBuffer2.toString());
        } else {
            this.f628j.put(str, new Variable(str, obj, (Modifiers) null));
            nameSpaceChanged();
        }
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NameSpace: ");
        if (this.f626h == null) {
            str = super.toString();
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(this.f626h);
            stringBuffer2.append(" (");
            stringBuffer2.append(super.toString());
            stringBuffer2.append(")");
            str = stringBuffer2.toString();
        }
        stringBuffer.append(str);
        stringBuffer.append(this.f622d ? " (isClass) " : BuildConfig.FLAVOR);
        stringBuffer.append(this.f621c ? " (method) " : BuildConfig.FLAVOR);
        stringBuffer.append(this.f623e != null ? " (class static) " : BuildConfig.FLAVOR);
        stringBuffer.append(this.f624f != null ? " (class instance) " : BuildConfig.FLAVOR);
        return stringBuffer.toString();
    }

    public void unsetVariable(String str) {
        if (this.f628j != null) {
            this.f628j.remove(str);
            nameSpaceChanged();
        }
    }
}
