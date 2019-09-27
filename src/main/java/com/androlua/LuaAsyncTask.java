package com.androlua;

import com.androlua.util.AsyncTaskX;
import com.androlua.util.AsyncTaskX.Status;
import com.luajava.LuaException;
import com.luajava.LuaObject;
import com.luajava.LuaState;

public class LuaAsyncTask extends AsyncTaskX implements LuaGcable {

    /* renamed from: a */
    private Object[] f2398a;

    /* renamed from: b */
    private boolean f2399b;

    /* renamed from: c */
    private LuaState f2400c;

    /* renamed from: d */
    private LuaContext f2401d;

    /* renamed from: e */
    private byte[] f2402e;

    /* renamed from: f */
    private long f2403f = 0;

    /* renamed from: g */
    private LuaObject f2404g;

    /* renamed from: h */
    private LuaObject f2405h;

    static {
        AsyncTaskX.setDefaultExecutor(AsyncTaskX.THREAD_POOL_EXECUTOR);
    }

    public LuaAsyncTask(LuaContext luaContext, long j, LuaObject luaObject) {
        luaContext.regGc(this);
        this.f2401d = luaContext;
        this.f2403f = j;
        this.f2404g = luaObject;
    }

    public LuaAsyncTask(LuaContext luaContext, LuaObject luaObject, LuaObject luaObject2) {
        luaContext.regGc(this);
        this.f2401d = luaContext;
        this.f2402e = luaObject.dump();
        this.f2404g = luaObject2;
        LuaObject field = luaObject.getLuaState().getLuaObject("luajava").getField("imported");
        if (!field.isNil()) {
            this.f2398a = field.asArray();
        }
    }

    public LuaAsyncTask(LuaContext luaContext, LuaObject luaObject, LuaObject luaObject2, LuaObject luaObject3) {
        luaContext.regGc(this);
        this.f2401d = luaContext;
        this.f2402e = luaObject.dump();
        this.f2405h = luaObject2;
        this.f2404g = luaObject3;
    }

    public LuaAsyncTask(LuaContext luaContext, String str, LuaObject luaObject) {
        luaContext.regGc(this);
        this.f2401d = luaContext;
        this.f2402e = str.getBytes();
        this.f2404g = luaObject;
    }

    /* renamed from: a */
    private String m2182a(int i) {
        switch (i) {
            case 1:
                return "Yield error";
            case 2:
                return "Runtime error";
            case 3:
                return "Syntax error";
            case 4:
                return "Out of memory";
            case 5:
                return "GC error";
            case 6:
                return "error error";
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown error ");
                sb.append(i);
                return sb.toString();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00f3 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0105 A[Catch:{ LuaException -> 0x0171 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object mo1858a(java.lang.Object[] r10) {
        /*
            r9 = this;
            long r0 = r9.f2403f
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x000e
            long r0 = r9.f2403f     // Catch:{ InterruptedException -> 0x000d }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x000d }
        L_0x000d:
            return r10
        L_0x000e:
            com.luajava.LuaState r0 = com.luajava.LuaStateFactory.newLuaState()
            r9.f2400c = r0
            com.luajava.LuaState r0 = r9.f2400c
            r0.openLibs()
            com.luajava.LuaState r0 = r9.f2400c
            com.androlua.LuaContext r1 = r9.f2401d
            r0.pushJavaObject(r1)
            com.androlua.LuaContext r0 = r9.f2401d
            boolean r0 = r0 instanceof com.androlua.LuaActivity
            if (r0 == 0) goto L_0x002e
            com.luajava.LuaState r0 = r9.f2400c
            java.lang.String r1 = "activity"
        L_0x002a:
            r0.setGlobal(r1)
            goto L_0x0039
        L_0x002e:
            com.androlua.LuaContext r0 = r9.f2401d
            boolean r0 = r0 instanceof com.androlua.LuaService
            if (r0 == 0) goto L_0x0039
            com.luajava.LuaState r0 = r9.f2400c
            java.lang.String r1 = "service"
            goto L_0x002a
        L_0x0039:
            com.luajava.LuaState r0 = r9.f2400c
            r0.pushJavaObject(r9)
            com.luajava.LuaState r0 = r9.f2400c
            java.lang.String r1 = "this"
            r0.setGlobal(r1)
            com.luajava.LuaState r0 = r9.f2400c
            com.androlua.LuaContext r1 = r9.f2401d
            r0.pushContext(r1)
            com.luajava.LuaState r0 = r9.f2400c
            java.lang.String r1 = "luajava"
            r0.getGlobal(r1)
            com.luajava.LuaState r0 = r9.f2400c
            com.androlua.LuaContext r1 = r9.f2401d
            java.lang.String r1 = r1.getLuaDir()
            r0.pushString(r1)
            com.luajava.LuaState r0 = r9.f2400c
            java.lang.String r1 = "luadir"
            r2 = -2
            r0.setField(r2, r1)
            com.luajava.LuaState r0 = r9.f2400c
            r1 = 1
            r0.pop(r1)
            com.androlua.LuaPrint r0 = new com.androlua.LuaPrint     // Catch:{ LuaException -> 0x00b7 }
            com.androlua.LuaContext r3 = r9.f2401d     // Catch:{ LuaException -> 0x00b7 }
            com.luajava.LuaState r4 = r9.f2400c     // Catch:{ LuaException -> 0x00b7 }
            r0.<init>(r3, r4)     // Catch:{ LuaException -> 0x00b7 }
            java.lang.String r3 = "print"
            r0.register(r3)     // Catch:{ LuaException -> 0x00b7 }
            com.androlua.LuaAsyncTask$1 r0 = new com.androlua.LuaAsyncTask$1     // Catch:{ LuaException -> 0x00b7 }
            com.luajava.LuaState r3 = r9.f2400c     // Catch:{ LuaException -> 0x00b7 }
            r0.<init>(r3)     // Catch:{ LuaException -> 0x00b7 }
            java.lang.String r3 = "update"
            r0.register(r3)     // Catch:{ LuaException -> 0x00b7 }
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x00b7 }
            java.lang.String r3 = "package"
            r0.getGlobal(r3)     // Catch:{ LuaException -> 0x00b7 }
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x00b7 }
            com.androlua.LuaContext r3 = r9.f2401d     // Catch:{ LuaException -> 0x00b7 }
            java.lang.String r3 = r3.getLuaLpath()     // Catch:{ LuaException -> 0x00b7 }
            r0.pushString(r3)     // Catch:{ LuaException -> 0x00b7 }
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x00b7 }
            java.lang.String r3 = "path"
            r0.setField(r2, r3)     // Catch:{ LuaException -> 0x00b7 }
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x00b7 }
            com.androlua.LuaContext r3 = r9.f2401d     // Catch:{ LuaException -> 0x00b7 }
            java.lang.String r3 = r3.getLuaCpath()     // Catch:{ LuaException -> 0x00b7 }
            r0.pushString(r3)     // Catch:{ LuaException -> 0x00b7 }
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x00b7 }
            java.lang.String r3 = "cpath"
            r0.setField(r2, r3)     // Catch:{ LuaException -> 0x00b7 }
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x00b7 }
            r0.pop(r1)     // Catch:{ LuaException -> 0x00b7 }
            goto L_0x00bf
        L_0x00b7:
            r0 = move-exception
            com.androlua.LuaContext r3 = r9.f2401d
            java.lang.String r4 = "AsyncTask"
            r3.sendError(r4, r0)
        L_0x00bf:
            java.lang.Object[] r0 = r9.f2398a
            r3 = 0
            if (r0 == 0) goto L_0x00f3
            com.luajava.LuaState r0 = r9.f2400c
            java.lang.String r4 = "require"
            com.luajava.LuaObject r0 = r0.getLuaObject(r4)
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ LuaException -> 0x00f3 }
            java.lang.String r5 = "import"
            r4[r3] = r5     // Catch:{ LuaException -> 0x00f3 }
            r0.call(r4)     // Catch:{ LuaException -> 0x00f3 }
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x00f3 }
            java.lang.String r4 = "import"
            com.luajava.LuaObject r0 = r0.getLuaObject(r4)     // Catch:{ LuaException -> 0x00f3 }
            java.lang.Object[] r4 = r9.f2398a     // Catch:{ LuaException -> 0x00f3 }
            int r5 = r4.length     // Catch:{ LuaException -> 0x00f3 }
            r6 = 0
        L_0x00e1:
            if (r6 >= r5) goto L_0x00f3
            r7 = r4[r6]     // Catch:{ LuaException -> 0x00f3 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ LuaException -> 0x00f3 }
            java.lang.String r7 = r7.toString()     // Catch:{ LuaException -> 0x00f3 }
            r8[r3] = r7     // Catch:{ LuaException -> 0x00f3 }
            r0.call(r8)     // Catch:{ LuaException -> 0x00f3 }
            int r6 = r6 + 1
            goto L_0x00e1
        L_0x00f3:
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x0171 }
            r0.setTop(r3)     // Catch:{ LuaException -> 0x0171 }
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x0171 }
            byte[] r4 = r9.f2402e     // Catch:{ LuaException -> 0x0171 }
            java.lang.String r5 = "LuaAsyncTask"
            int r0 = r0.LloadBuffer(r4, r5)     // Catch:{ LuaException -> 0x0171 }
            r4 = -1
            if (r0 != 0) goto L_0x014d
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x0171 }
            java.lang.String r5 = "debug"
            r0.getGlobal(r5)     // Catch:{ LuaException -> 0x0171 }
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x0171 }
            java.lang.String r5 = "traceback"
            r0.getField(r4, r5)     // Catch:{ LuaException -> 0x0171 }
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x0171 }
            r0.remove(r2)     // Catch:{ LuaException -> 0x0171 }
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x0171 }
            r0.insert(r2)     // Catch:{ LuaException -> 0x0171 }
            int r0 = r10.length     // Catch:{ LuaException -> 0x0171 }
            r5 = 0
        L_0x011f:
            if (r5 >= r0) goto L_0x012b
            com.luajava.LuaState r6 = r9.f2400c     // Catch:{ LuaException -> 0x0171 }
            r7 = r10[r5]     // Catch:{ LuaException -> 0x0171 }
            r6.pushObjectValue(r7)     // Catch:{ LuaException -> 0x0171 }
            int r5 = r5 + 1
            goto L_0x011f
        L_0x012b:
            com.luajava.LuaState r10 = r9.f2400c     // Catch:{ LuaException -> 0x0171 }
            int r2 = r2 - r0
            int r0 = r10.pcall(r0, r4, r2)     // Catch:{ LuaException -> 0x0171 }
            if (r0 != 0) goto L_0x014d
            com.luajava.LuaState r10 = r9.f2400c     // Catch:{ LuaException -> 0x0171 }
            int r10 = r10.getTop()     // Catch:{ LuaException -> 0x0171 }
            int r10 = r10 - r1
            java.lang.Object[] r0 = new java.lang.Object[r10]     // Catch:{ LuaException -> 0x0171 }
        L_0x013d:
            if (r3 >= r10) goto L_0x014c
            com.luajava.LuaState r1 = r9.f2400c     // Catch:{ LuaException -> 0x0171 }
            int r2 = r3 + 2
            java.lang.Object r1 = r1.toJavaObject(r2)     // Catch:{ LuaException -> 0x0171 }
            r0[r3] = r1     // Catch:{ LuaException -> 0x0171 }
            int r3 = r3 + 1
            goto L_0x013d
        L_0x014c:
            return r0
        L_0x014d:
            com.luajava.LuaException r10 = new com.luajava.LuaException     // Catch:{ LuaException -> 0x0171 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ LuaException -> 0x0171 }
            r1.<init>()     // Catch:{ LuaException -> 0x0171 }
            java.lang.String r0 = r9.m2182a(r0)     // Catch:{ LuaException -> 0x0171 }
            r1.append(r0)     // Catch:{ LuaException -> 0x0171 }
            java.lang.String r0 = ": "
            r1.append(r0)     // Catch:{ LuaException -> 0x0171 }
            com.luajava.LuaState r0 = r9.f2400c     // Catch:{ LuaException -> 0x0171 }
            java.lang.String r0 = r0.toString(r4)     // Catch:{ LuaException -> 0x0171 }
            r1.append(r0)     // Catch:{ LuaException -> 0x0171 }
            java.lang.String r0 = r1.toString()     // Catch:{ LuaException -> 0x0171 }
            r10.<init>(r0)     // Catch:{ LuaException -> 0x0171 }
            throw r10     // Catch:{ LuaException -> 0x0171 }
        L_0x0171:
            r10 = move-exception
            com.androlua.LuaContext r0 = r9.f2401d
            java.lang.String r1 = "doInBackground"
            r0.sendError(r1, r10)
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaAsyncTask.mo1858a(java.lang.Object[]):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1859a(Object obj) {
        if (!isCancelled()) {
            try {
                if (this.f2404g != null) {
                    this.f2404g.call((Object[]) obj);
                }
            } catch (LuaException e) {
                this.f2401d.sendError("onPostExecute", e);
            }
            if (this.f2400c != null) {
                this.f2400c.mo3510gc(2, 1);
            }
            System.gc();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo2149b(Object[] objArr) {
        try {
            if (this.f2405h != null) {
                this.f2405h.call(objArr);
            }
        } catch (LuaException e) {
            this.f2401d.sendError("onProgressUpdate", e);
        }
        super.mo2149b((Progress[]) objArr);
    }

    public void execute() {
        super.execute((Params[]) new Object[0]);
    }

    /* renamed from: gc */
    public void mo2151gc() {
        if (getStatus() == Status.RUNNING) {
            cancel(true);
        }
        this.f2399b = true;
    }

    public boolean isGc() {
        return this.f2399b;
    }

    public void update(int i) {
        mo2646c((Progress[]) new Object[]{Integer.valueOf(i)});
    }

    public void update(Object obj) {
        mo2646c((Progress[]) new Object[]{obj});
    }

    public void update(String str) {
        mo2646c((Progress[]) new Object[]{str});
    }
}
