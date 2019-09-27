package com.androlua.util;

public class VolatileDispose<T> {

    /* renamed from: a */
    private volatile T f2822a;

    public T blockedGet() {
        synchronized (this) {
            if (this.f2822a != null) {
                T t = this.f2822a;
                return t;
            }
            try {
                wait(1000);
                return this.f2822a;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0016, code lost:
        throw ((java.lang.RuntimeException) r2.newInstance());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0017, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x001d, code lost:
        throw new java.lang.RuntimeException(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x001e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0024, code lost:
        throw new java.lang.RuntimeException(r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T blockedGetOrThrow(java.lang.Class<? extends java.lang.RuntimeException> r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            T r0 = r1.f2822a     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0009
            T r2 = r1.f2822a     // Catch:{ all -> 0x0025 }
            monitor-exit(r1)     // Catch:{ all -> 0x0025 }
            return r2
        L_0x0009:
            r1.wait()     // Catch:{ InterruptedException -> 0x0010 }
            monitor-exit(r1)     // Catch:{ all -> 0x0025 }
            T r2 = r1.f2822a
            return r2
        L_0x0010:
            java.lang.Object r2 = r2.newInstance()     // Catch:{ InstantiationException -> 0x001e, IllegalAccessException -> 0x0017 }
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2     // Catch:{ InstantiationException -> 0x001e, IllegalAccessException -> 0x0017 }
            throw r2     // Catch:{ InstantiationException -> 0x001e, IllegalAccessException -> 0x0017 }
        L_0x0017:
            r2 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0025 }
            r0.<init>(r2)     // Catch:{ all -> 0x0025 }
            throw r0     // Catch:{ all -> 0x0025 }
        L_0x001e:
            r2 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0025 }
            r0.<init>(r2)     // Catch:{ all -> 0x0025 }
            throw r0     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0025 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.util.VolatileDispose.blockedGetOrThrow(java.lang.Class):java.lang.Object");
    }

    public void setAndNotify(T t) {
        synchronized (this) {
            this.f2822a = t;
            notify();
        }
    }
}
