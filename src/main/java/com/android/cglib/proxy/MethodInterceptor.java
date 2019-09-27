package com.android.cglib.proxy;

public interface MethodInterceptor {
    Object intercept(Object obj, Object[] objArr, MethodProxy methodProxy);
}
