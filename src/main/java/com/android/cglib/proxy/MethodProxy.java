package com.android.cglib.proxy;

import java.lang.reflect.Method;

public class MethodProxy {

    /* renamed from: a */
    private Class f2185a;

    /* renamed from: b */
    private String f2186b;

    /* renamed from: c */
    private Class[] f2187c;

    public MethodProxy(Class cls, String str, Class[] clsArr) {
        this.f2185a = cls;
        this.f2186b = str;
        this.f2187c = clsArr;
    }

    public String getMethodName() {
        return this.f2186b;
    }

    public Method getOriginalMethod() {
        try {
            return this.f2185a.getMethod(this.f2186b, this.f2187c);
        } catch (NoSuchMethodException e) {
            throw new ProxyException(e.getMessage());
        }
    }

    public Method getProxyMethod() {
        try {
            Class cls = this.f2185a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f2186b);
            sb.append(Const.SUBCLASS_INVOKE_SUPER_SUFFIX);
            return cls.getMethod(sb.toString(), this.f2187c);
        } catch (NoSuchMethodException e) {
            throw new ProxyException(e.getMessage());
        }
    }

    public Object invokeSuper(Object obj, Object[] objArr) {
        return ((EnhancerInterface) obj).executeSuperMethod_Enhancer(this.f2186b, this.f2187c, objArr);
    }
}
