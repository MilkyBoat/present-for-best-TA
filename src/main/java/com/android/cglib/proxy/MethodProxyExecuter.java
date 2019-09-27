package com.android.cglib.proxy;

import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.lang.reflect.Method;

public class MethodProxyExecuter {
    public static final String EXECUTE_INTERCEPTOR = "executeInterceptor";
    public static final String EXECUTE_METHOD = "executeMethod";

    public static Object executeInterceptor(MethodInterceptor methodInterceptor, Class<?> cls, String str, Class[] clsArr, Object[] objArr, Object obj) {
        if (objArr == null) {
            objArr = new Object[0];
        }
        if (clsArr == null) {
            clsArr = new Class[0];
        }
        if (methodInterceptor == null) {
            return executeMethod(cls, str, clsArr, objArr, obj);
        }
        try {
            return methodInterceptor.intercept(obj, objArr, new MethodProxy(cls, str, clsArr));
        } catch (Exception e) {
            C0029a.m806a(e);
            throw new ProxyException(e.getMessage());
        }
    }

    public static Object executeMethod(Class cls, String str, Class[] clsArr, Object[] objArr, Object obj) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(Const.SUBCLASS_INVOKE_SUPER_SUFFIX);
            Method method = cls.getMethod(sb.toString(), clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            C0029a.m806a(e);
            throw new ProxyException(e.getCause());
        }
    }
}
