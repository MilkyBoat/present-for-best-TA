package com.androlua;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.luajava.JavaFunction;
import com.luajava.LuaException;
import com.luajava.LuaMetaTable;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import com.luajava.LuaStateFactory;
import java.util.regex.Pattern;

public class LuaThread extends Thread implements LuaGcable, LuaMetaTable, Runnable {

    /* renamed from: a */
    private boolean f2626a;

    /* renamed from: b */
    private LuaState f2627b;

    /* renamed from: c */
    private Handler f2628c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LuaContext f2629d;

    /* renamed from: e */
    private boolean f2630e;

    /* renamed from: f */
    private String f2631f;

    /* renamed from: g */
    private Object[] f2632g;

    /* renamed from: h */
    private byte[] f2633h;
    public boolean isRun;

    private class ThreadHandler extends Handler {
        private ThreadHandler() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            Bundle data = message.getData();
            switch (message.what) {
                case 0:
                    LuaThread.this.m2283a(data.getString("data"), (Object[]) data.getSerializable("args"));
                    return;
                case 1:
                    LuaThread.this.m2288d(data.getString("data"), (Object[]) data.getSerializable("args"));
                    return;
                case 2:
                    LuaThread.this.m2283a(data.getString("data"), new Object[0]);
                    return;
                case 3:
                    LuaThread.this.m2288d(data.getString("data"), new Object[0]);
                    return;
                case 4:
                    LuaThread.this.m2282a(data.getString("data"), ((Object[]) data.getSerializable("args"))[0]);
                    return;
                default:
                    return;
            }
        }
    }

    public LuaThread(LuaContext luaContext, LuaObject luaObject) {
        this(luaContext, luaObject, false, (Object[]) null);
    }

    public LuaThread(LuaContext luaContext, LuaObject luaObject, boolean z) {
        this(luaContext, luaObject, z, (Object[]) null);
    }

    public LuaThread(LuaContext luaContext, LuaObject luaObject, boolean z, Object[] objArr) {
        this.isRun = false;
        this.f2632g = new Object[0];
        this.f2629d = luaContext;
        if (objArr != null) {
            this.f2632g = objArr;
        }
        this.f2630e = z;
        this.f2633h = luaObject.dump();
    }

    public LuaThread(LuaContext luaContext, LuaObject luaObject, Object[] objArr) {
        this(luaContext, luaObject, false, objArr);
    }

    public LuaThread(LuaContext luaContext, String str) {
        this(luaContext, str, false, (Object[]) null);
    }

    public LuaThread(LuaContext luaContext, String str, boolean z) {
        this(luaContext, str, z, (Object[]) null);
    }

    public LuaThread(LuaContext luaContext, String str, boolean z, Object[] objArr) {
        this.isRun = false;
        this.f2632g = new Object[0];
        luaContext.regGc(this);
        this.f2629d = luaContext;
        this.f2631f = str;
        this.f2630e = z;
        if (objArr != null) {
            this.f2632g = objArr;
        }
    }

    public LuaThread(LuaContext luaContext, String str, Object[] objArr) {
        this(luaContext, str, false, objArr);
    }

    /* renamed from: a */
    private String m2278a(int i) {
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

    /* renamed from: a */
    private void m2279a() {
        LuaState luaState;
        String str;
        this.f2627b = LuaStateFactory.newLuaState();
        this.f2627b.openLibs();
        this.f2627b.pushJavaObject(this.f2629d.getContext());
        if (this.f2629d instanceof LuaActivity) {
            luaState = this.f2627b;
            str = "activity";
        } else {
            if (this.f2629d instanceof LuaService) {
                luaState = this.f2627b;
                str = "service";
            }
            this.f2627b.pushJavaObject(this);
            this.f2627b.setGlobal("this");
            this.f2627b.pushContext(this.f2629d);
            new LuaPrint(this.f2629d, this.f2627b).register("print");
            this.f2627b.getGlobal("package");
            this.f2627b.pushString(this.f2629d.getLuaLpath());
            this.f2627b.setField(-2, "path");
            this.f2627b.pushString(this.f2629d.getLuaCpath());
            this.f2627b.setField(-2, "cpath");
            this.f2627b.pop(1);
            new JavaFunction(this.f2627b) {
                public int execute() {
                    LuaThread.this.f2629d.set(this.f3375b.toString(2), this.f3375b.toJavaObject(3));
                    return 0;
                }
            }.register("set");
            new JavaFunction(this.f2627b) {
                public int execute() {
                    Object[] objArr;
                    String str;
                    LuaContext luaContext;
                    int top = this.f3375b.getTop();
                    if (top > 2) {
                        objArr = new Object[(top - 2)];
                        for (int i = 3; i <= top; i++) {
                            objArr[i - 3] = this.f3375b.toJavaObject(i);
                        }
                        luaContext = LuaThread.this.f2629d;
                        str = this.f3375b.toString(2);
                    } else {
                        if (top == 2) {
                            luaContext = LuaThread.this.f2629d;
                            str = this.f3375b.toString(2);
                            objArr = new Object[0];
                        }
                        return 0;
                    }
                    luaContext.call(str, objArr);
                    return 0;
                }
            }.register("call");
        }
        luaState.setGlobal(str);
        this.f2627b.pushJavaObject(this);
        this.f2627b.setGlobal("this");
        this.f2627b.pushContext(this.f2629d);
        new LuaPrint(this.f2629d, this.f2627b).register("print");
        this.f2627b.getGlobal("package");
        this.f2627b.pushString(this.f2629d.getLuaLpath());
        this.f2627b.setField(-2, "path");
        this.f2627b.pushString(this.f2629d.getLuaCpath());
        this.f2627b.setField(-2, "cpath");
        this.f2627b.pop(1);
        new JavaFunction(this.f2627b) {
            public int execute() {
                LuaThread.this.f2629d.set(this.f3375b.toString(2), this.f3375b.toJavaObject(3));
                return 0;
            }
        }.register("set");
        new JavaFunction(this.f2627b) {
            public int execute() {
                Object[] objArr;
                String str;
                LuaContext luaContext;
                int top = this.f3375b.getTop();
                if (top > 2) {
                    objArr = new Object[(top - 2)];
                    for (int i = 3; i <= top; i++) {
                        objArr[i - 3] = this.f3375b.toJavaObject(i);
                    }
                    luaContext = LuaThread.this.f2629d;
                    str = this.f3375b.toString(2);
                } else {
                    if (top == 2) {
                        luaContext = LuaThread.this.f2629d;
                        str = this.f3375b.toString(2);
                        objArr = new Object[0];
                    }
                    return 0;
                }
                luaContext.call(str, objArr);
                return 0;
            }
        }.register("call");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2282a(String str, Object obj) {
        try {
            this.f2627b.pushObjectValue(obj);
            this.f2627b.setGlobal(str);
        } catch (LuaException e) {
            this.f2629d.sendError(toString(), e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2283a(String str, Object... objArr) {
        try {
            if (Pattern.matches("^\\w+$", str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(".lua");
                doAsset(sb.toString(), objArr);
            } else if (Pattern.matches("^[\\w\\.\\_/]+$", str)) {
                this.f2627b.getGlobal("luajava");
                this.f2627b.pushString(this.f2629d.getLuaDir());
                this.f2627b.setField(-2, "luadir");
                this.f2627b.pushString(str);
                this.f2627b.setField(-2, "luapath");
                this.f2627b.pop(1);
                m2286b(str, objArr);
            } else {
                m2287c(str, objArr);
            }
        } catch (Exception e) {
            this.f2629d.sendError(toString(), e);
            quit();
        }
    }

    /* renamed from: a */
    private void m2284a(byte[] bArr, Object... objArr) {
        try {
            this.f2627b.setTop(0);
            int LloadBuffer = this.f2627b.LloadBuffer(bArr, "TimerTask");
            if (LloadBuffer == 0) {
                this.f2627b.getGlobal("debug");
                this.f2627b.getField(-1, "traceback");
                this.f2627b.remove(-2);
                this.f2627b.insert(-2);
                for (Object pushObjectValue : objArr) {
                    this.f2627b.pushObjectValue(pushObjectValue);
                }
                LloadBuffer = this.f2627b.pcall(r7, 0, -2 - r7);
                if (LloadBuffer == 0) {
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(m2278a(LloadBuffer));
            sb.append(": ");
            sb.append(this.f2627b.toString(-1));
            throw new LuaException(sb.toString());
        } catch (Exception e) {
            this.f2629d.sendError(toString(), e);
            quit();
        }
    }

    /* renamed from: b */
    private void m2286b(String str, Object... objArr) {
        this.f2627b.setTop(0);
        int LloadFile = this.f2627b.LloadFile(str);
        if (LloadFile == 0) {
            this.f2627b.getGlobal("debug");
            this.f2627b.getField(-1, "traceback");
            this.f2627b.remove(-2);
            this.f2627b.insert(-2);
            for (Object pushObjectValue : objArr) {
                this.f2627b.pushObjectValue(pushObjectValue);
            }
            LloadFile = this.f2627b.pcall(r7, 0, -2 - r7);
            if (LloadFile == 0) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m2278a(LloadFile));
        sb.append(": ");
        sb.append(this.f2627b.toString(-1));
        throw new LuaException(sb.toString());
    }

    /* renamed from: c */
    private void m2287c(String str, Object... objArr) {
        this.f2627b.setTop(0);
        int LloadString = this.f2627b.LloadString(str);
        if (LloadString == 0) {
            this.f2627b.getGlobal("debug");
            this.f2627b.getField(-1, "traceback");
            this.f2627b.remove(-2);
            this.f2627b.insert(-2);
            for (Object pushObjectValue : objArr) {
                this.f2627b.pushObjectValue(pushObjectValue);
            }
            LloadString = this.f2627b.pcall(r7, 0, -2 - r7);
            if (LloadString == 0) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m2278a(LloadString));
        sb.append(": ");
        sb.append(this.f2627b.toString(-1));
        throw new LuaException(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2288d(String str, Object... objArr) {
        try {
            this.f2627b.setTop(0);
            this.f2627b.getGlobal(str);
            if (this.f2627b.isFunction(-1)) {
                this.f2627b.getGlobal("debug");
                this.f2627b.getField(-1, "traceback");
                this.f2627b.remove(-2);
                this.f2627b.insert(-2);
                for (Object pushObjectValue : objArr) {
                    this.f2627b.pushObjectValue(pushObjectValue);
                }
                int pcall = this.f2627b.pcall(r0, 1, -2 - r0);
                if (pcall != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(m2278a(pcall));
                    sb.append(": ");
                    sb.append(this.f2627b.toString(-1));
                    throw new LuaException(sb.toString());
                }
            }
        } catch (LuaException e) {
            LuaContext luaContext = this.f2629d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(toString());
            sb2.append(" ");
            sb2.append(str);
            luaContext.sendError(sb2.toString(), e);
        }
    }

    public Object __call(Object[] objArr) {
        return null;
    }

    public Object __index(final String str) {
        return new LuaMetaTable() {
            public Object __call(Object[] objArr) {
                LuaThread.this.call(str, objArr);
                return null;
            }

            public Object __index(String str) {
                return null;
            }

            public void __newIndex(String str, Object obj) {
            }
        };
    }

    public void __newIndex(String str, Object obj) {
        set(str, obj);
    }

    public void call(String str) {
        push(3, str);
    }

    public void call(String str, Object[] objArr) {
        if (objArr.length == 0) {
            push(3, str);
        } else {
            push(1, str, objArr);
        }
    }

    public void doAsset(String str, Object... objArr) {
        byte[] readAsset = LuaUtil.readAsset(this.f2629d.getContext(), str);
        this.f2627b.setTop(0);
        int LloadBuffer = this.f2627b.LloadBuffer(readAsset, str);
        if (LloadBuffer == 0) {
            this.f2627b.getGlobal("debug");
            this.f2627b.getField(-1, "traceback");
            this.f2627b.remove(-2);
            this.f2627b.insert(-2);
            for (Object pushObjectValue : objArr) {
                this.f2627b.pushObjectValue(pushObjectValue);
            }
            LloadBuffer = this.f2627b.pcall(r7, 0, -2 - r7);
            if (LloadBuffer == 0) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m2278a(LloadBuffer));
        sb.append(": ");
        sb.append(this.f2627b.toString(-1));
        throw new LuaException(sb.toString());
    }

    /* renamed from: gc */
    public void mo2151gc() {
        quit();
        this.f2626a = true;
    }

    public Object get(String str) {
        this.f2627b.getGlobal(str);
        return this.f2627b.toJavaObject(-1);
    }

    public boolean isGc() {
        return this.f2626a;
    }

    public void push(int i, String str) {
        if (!this.isRun) {
            this.f2629d.sendMsg("thread is not running");
            return;
        }
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data", str);
        message.setData(bundle);
        message.what = i;
        this.f2628c.sendMessage(message);
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object[], code=null, for r6v0, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void push(int r4, java.lang.String r5, java.lang.Object[] r6) {
        /*
            r3 = this;
            boolean r0 = r3.isRun
            if (r0 != 0) goto L_0x000c
            com.androlua.LuaContext r4 = r3.f2629d
            java.lang.String r5 = "thread is not running"
            r4.sendMsg(r5)
            return
        L_0x000c:
            android.os.Message r0 = new android.os.Message
            r0.<init>()
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "data"
            r1.putString(r2, r5)
            java.lang.String r5 = "args"
            r1.putSerializable(r5, r6)
            r0.setData(r1)
            r0.what = r4
            android.os.Handler r4 = r3.f2628c
            r4.sendMessage(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaThread.push(int, java.lang.String, java.lang.Object[]):void");
    }

    public void quit() {
        if (this.isRun) {
            this.isRun = false;
            this.f2628c.getLooper().quit();
        }
    }

    public void run() {
        try {
            if (this.f2627b == null) {
                m2279a();
                if (this.f2633h != null) {
                    m2284a(this.f2633h, this.f2632g);
                } else {
                    m2283a(this.f2631f, this.f2632g);
                }
            }
            if (this.f2630e) {
                Looper.prepare();
                this.f2628c = new ThreadHandler();
                this.isRun = true;
                this.f2627b.getGlobal("run");
                if (!this.f2627b.isNil(-1)) {
                    this.f2627b.pop(1);
                    m2288d("run", new Object[0]);
                }
                Looper.loop();
            }
            this.isRun = false;
            this.f2627b.mo3510gc(2, 1);
            System.gc();
        } catch (LuaException e) {
            this.f2629d.sendError(toString(), e);
        }
    }

    public void set(String str, Object obj) {
        push(4, str, new Object[]{obj});
    }
}
