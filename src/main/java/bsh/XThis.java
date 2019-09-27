package bsh;

import com.androlua.BuildConfig;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Hashtable;

public class XThis extends This {

    /* renamed from: e */
    static Class f717e;

    /* renamed from: c */
    Hashtable f718c;

    /* renamed from: d */
    InvocationHandler f719d = new Handler(this);

    class Handler implements Serializable, InvocationHandler {

        /* renamed from: a */
        private final XThis f720a;

        Handler(XThis xThis) {
            this.f720a = xThis;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                return invokeImpl(obj, method, objArr);
            } catch (TargetError e) {
                throw e.getTarget();
            } catch (EvalError e2) {
                if (Interpreter.DEBUG) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("EvalError in scripted interface: ");
                    stringBuffer.append(this.f720a.toString());
                    stringBuffer.append(": ");
                    stringBuffer.append(e2);
                    Interpreter.debug(stringBuffer.toString());
                }
                throw e2;
            }
        }

        public Object invokeImpl(Object obj, Method method, Object[] objArr) {
            BshMethod bshMethod;
            Class cls;
            String name = method.getName();
            new CallStack(this.f720a.f701a);
            BshMethod bshMethod2 = null;
            boolean z = true;
            try {
                NameSpace nameSpace = this.f720a.f701a;
                String str = "equals";
                Class[] clsArr = new Class[1];
                if (XThis.f717e == null) {
                    cls = XThis.m766b("java.lang.Object");
                    XThis.f717e = cls;
                } else {
                    cls = XThis.f717e;
                }
                clsArr[0] = cls;
                bshMethod = nameSpace.getMethod(str, clsArr);
            } catch (UtilEvalError unused) {
                bshMethod = null;
            }
            if (!name.equals("equals") || bshMethod != null) {
                try {
                    bshMethod2 = this.f720a.f701a.getMethod("toString", new Class[0]);
                } catch (UtilEvalError unused2) {
                }
                if (!name.equals("toString") || bshMethod2 != null) {
                    return Primitive.unwrap(this.f720a.invokeMethod(name, Primitive.wrap(objArr, method.getParameterTypes())));
                }
                Class[] interfaces = obj.getClass().getInterfaces();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(this.f720a.toString());
                stringBuffer.append("\nimplements:");
                StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.toString());
                for (Class name2 : interfaces) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(" ");
                    stringBuffer3.append(name2.getName());
                    stringBuffer3.append(interfaces.length > 1 ? "," : BuildConfig.FLAVOR);
                    stringBuffer2.append(stringBuffer3.toString());
                }
                return stringBuffer2.toString();
            }
            if (obj != objArr[0]) {
                z = false;
            }
            return new Boolean(z);
        }
    }

    public XThis(NameSpace nameSpace, Interpreter interpreter) {
        super(nameSpace, interpreter);
    }

    /* renamed from: b */
    static Class m766b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public Object getInterface(Class cls) {
        return getInterface(new Class[]{cls});
    }

    public Object getInterface(Class[] clsArr) {
        if (this.f718c == null) {
            this.f718c = new Hashtable();
        }
        int i = 21;
        for (Class hashCode : clsArr) {
            i *= hashCode.hashCode() + 3;
        }
        Integer num = new Integer(i);
        Object obj = this.f718c.get(num);
        if (obj != null) {
            return obj;
        }
        Object newProxyInstance = Proxy.newProxyInstance(clsArr[0].getClassLoader(), clsArr, this.f719d);
        this.f718c.put(num, newProxyInstance);
        return newProxyInstance;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("'this' reference (XThis) to Bsh object: ");
        stringBuffer.append(this.f701a);
        return stringBuffer.toString();
    }
}
