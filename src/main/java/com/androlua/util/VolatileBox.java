package com.androlua.util;

public class VolatileBox<T> {

    /* renamed from: a */
    private volatile T f2821a;

    public VolatileBox() {
    }

    public VolatileBox(T t) {
        set(t);
    }

    public T blockedGet() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return this.f2821a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        throw ((java.lang.RuntimeException) r2.newInstance());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
        throw new java.lang.RuntimeException(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0018, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        throw new java.lang.RuntimeException(r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T blockedGetOrThrow(java.lang.Class<? extends java.lang.RuntimeException> r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            r1.wait()     // Catch:{ InterruptedException -> 0x000a }
            monitor-exit(r1)     // Catch:{ all -> 0x0008 }
            T r2 = r1.f2821a
            return r2
        L_0x0008:
            r2 = move-exception
            goto L_0x001f
        L_0x000a:
            java.lang.Object r2 = r2.newInstance()     // Catch:{ InstantiationException -> 0x0018, IllegalAccessException -> 0x0011 }
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2     // Catch:{ InstantiationException -> 0x0018, IllegalAccessException -> 0x0011 }
            throw r2     // Catch:{ InstantiationException -> 0x0018, IllegalAccessException -> 0x0011 }
        L_0x0011:
            r2 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0008 }
            r0.<init>(r2)     // Catch:{ all -> 0x0008 }
            throw r0     // Catch:{ all -> 0x0008 }
        L_0x0018:
            r2 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0008 }
            r0.<init>(r2)     // Catch:{ all -> 0x0008 }
            throw r0     // Catch:{ all -> 0x0008 }
        L_0x001f:
            monitor-exit(r1)     // Catch:{ all -> 0x0008 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.util.VolatileBox.blockedGetOrThrow(java.lang.Class):java.lang.Object");
    }

    public T get() {
        return this.f2821a;
    }

    public boolean isNull() {
        return this.f2821a == null;
    }

    public boolean notNull() {
        return this.f2821a != null;
    }

    public void set(T t) {
        this.f2821a = t;
    }

    public void setAndNotify(T t) {
        this.f2821a = t;
        synchronized (this) {
            notify();
        }
    }
}
