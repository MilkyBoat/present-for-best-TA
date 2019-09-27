package com.androlua;

import com.android.cglib.proxy.Enhancer;
import com.android.cglib.proxy.EnhancerInterface;
import com.android.cglib.proxy.MethodFilter;
import com.android.cglib.proxy.MethodInterceptor;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;

public class LuaEnhancer {

    /* renamed from: a */
    private Enhancer f2487a;

    public LuaEnhancer(Class<?> cls) {
        this.f2487a = new Enhancer(LuaApplication.getInstance());
        this.f2487a.setSuperclass(cls);
    }

    public LuaEnhancer(String str) {
        this(Class.forName(str));
    }

    public Class<?> create() {
        try {
            return this.f2487a.create();
        } catch (Exception e) {
            C0029a.m806a(e);
            return null;
        }
    }

    public Class<?> create(MethodFilter methodFilter) {
        try {
            this.f2487a.setMethodFilter(methodFilter);
            return this.f2487a.create();
        } catch (Exception e) {
            C0029a.m806a(e);
            return null;
        }
    }

    public void setInterceptor(EnhancerInterface enhancerInterface, MethodInterceptor methodInterceptor) {
        enhancerInterface.setMethodInterceptor_Enhancer(methodInterceptor);
    }
}
