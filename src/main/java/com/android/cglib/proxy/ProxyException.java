package com.android.cglib.proxy;

public class ProxyException extends RuntimeException {
    public ProxyException() {
    }

    public ProxyException(String str) {
        super(str);
    }

    public ProxyException(Throwable th) {
        super(th);
    }
}
