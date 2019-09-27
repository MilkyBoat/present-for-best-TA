package com.androlua;

import com.androlua.util.TimerTaskX;
import com.luajava.JavaFunction;
import com.luajava.LuaException;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import com.luajava.LuaStateFactory;
import java.util.regex.Pattern;

public class LuaTimerTask extends TimerTaskX {

    /* renamed from: a */
    private LuaState f2641a;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LuaContext f2642g;

    /* renamed from: h */
    private String f2643h;

    /* renamed from: i */
    private Object[] f2644i;

    /* renamed from: j */
    private boolean f2645j;

    /* renamed from: k */
    private byte[] f2646k;

    public LuaTimerTask(LuaContext luaContext, LuaObject luaObject) {
        this(luaContext, luaObject, (Object[]) null);
    }

    public LuaTimerTask(LuaContext luaContext, LuaObject luaObject, Object[] objArr) {
        this.f2644i = new Object[0];
        this.f2645j = true;
        this.f2642g = luaContext;
        if (objArr != null) {
            this.f2644i = objArr;
        }
        this.f2646k = luaObject.dump();
    }

    public LuaTimerTask(LuaContext luaContext, String str) {
        this(luaContext, str, (Object[]) null);
    }

    public LuaTimerTask(LuaContext luaContext, String str, Object[] objArr) {
        this.f2644i = new Object[0];
        this.f2645j = true;
        this.f2642g = luaContext;
        this.f2643h = str;
        if (objArr != null) {
            this.f2644i = objArr;
        }
    }

    /* renamed from: a */
    private String m2292a(int i) {
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
    private void m2293a(String str, Object... objArr) {
        try {
            if (Pattern.matches("^\\w+$", str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(".lua");
                doAsset(sb.toString(), objArr);
            } else if (Pattern.matches("^[\\w\\.\\_/]+$", str)) {
                this.f2641a.getGlobal("luajava");
                this.f2641a.pushString(this.f2642g.getLuaDir());
                this.f2641a.setField(-2, "luadir");
                this.f2641a.pushString(str);
                this.f2641a.setField(-2, "luapath");
                this.f2641a.pop(1);
                m2296b(str, objArr);
            } else {
                m2297c(str, objArr);
            }
        } catch (Exception e) {
            this.f2642g.sendError(toString(), e);
        }
    }

    /* renamed from: a */
    private void m2294a(byte[] bArr, Object... objArr) {
        this.f2641a.setTop(0);
        int LloadBuffer = this.f2641a.LloadBuffer(bArr, "TimerTask");
        if (LloadBuffer == 0) {
            this.f2641a.getGlobal("debug");
            this.f2641a.getField(-1, "traceback");
            this.f2641a.remove(-2);
            this.f2641a.insert(-2);
            for (Object pushObjectValue : objArr) {
                this.f2641a.pushObjectValue(pushObjectValue);
            }
            LloadBuffer = this.f2641a.pcall(r7, 0, -2 - r7);
            if (LloadBuffer == 0) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m2292a(LloadBuffer));
        sb.append(": ");
        sb.append(this.f2641a.toString(-1));
        throw new LuaException(sb.toString());
    }

    /* renamed from: b */
    private void m2295b() {
        LuaState luaState;
        String str;
        this.f2641a = LuaStateFactory.newLuaState();
        this.f2641a.openLibs();
        this.f2641a.pushJavaObject(this.f2642g);
        if (this.f2642g instanceof LuaActivity) {
            luaState = this.f2641a;
            str = "activity";
        } else {
            if (this.f2642g instanceof LuaService) {
                luaState = this.f2641a;
                str = "service";
            }
            this.f2641a.pushJavaObject(this);
            this.f2641a.setGlobal("this");
            this.f2641a.pushContext(this.f2642g);
            new LuaPrint(this.f2642g, this.f2641a).register("print");
            this.f2641a.getGlobal("package");
            this.f2641a.pushString(this.f2642g.getLuaLpath());
            this.f2641a.setField(-2, "path");
            this.f2641a.pushString(this.f2642g.getLuaCpath());
            this.f2641a.setField(-2, "cpath");
            this.f2641a.pop(1);
            new JavaFunction(this.f2641a) {
                public int execute() {
                    LuaTimerTask.this.f2642g.set(this.f3375b.toString(2), this.f3375b.toJavaObject(3));
                    return 0;
                }
            }.register("set");
            new JavaFunction(this.f2641a) {
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
                        luaContext = LuaTimerTask.this.f2642g;
                        str = this.f3375b.toString(2);
                    } else {
                        if (top == 2) {
                            luaContext = LuaTimerTask.this.f2642g;
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
        this.f2641a.pushJavaObject(this);
        this.f2641a.setGlobal("this");
        this.f2641a.pushContext(this.f2642g);
        new LuaPrint(this.f2642g, this.f2641a).register("print");
        this.f2641a.getGlobal("package");
        this.f2641a.pushString(this.f2642g.getLuaLpath());
        this.f2641a.setField(-2, "path");
        this.f2641a.pushString(this.f2642g.getLuaCpath());
        this.f2641a.setField(-2, "cpath");
        this.f2641a.pop(1);
        new JavaFunction(this.f2641a) {
            public int execute() {
                LuaTimerTask.this.f2642g.set(this.f3375b.toString(2), this.f3375b.toJavaObject(3));
                return 0;
            }
        }.register("set");
        new JavaFunction(this.f2641a) {
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
                    luaContext = LuaTimerTask.this.f2642g;
                    str = this.f3375b.toString(2);
                } else {
                    if (top == 2) {
                        luaContext = LuaTimerTask.this.f2642g;
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

    /* renamed from: b */
    private void m2296b(String str, Object... objArr) {
        this.f2641a.setTop(0);
        int LloadFile = this.f2641a.LloadFile(str);
        if (LloadFile == 0) {
            this.f2641a.getGlobal("debug");
            this.f2641a.getField(-1, "traceback");
            this.f2641a.remove(-2);
            this.f2641a.insert(-2);
            for (Object pushObjectValue : objArr) {
                this.f2641a.pushObjectValue(pushObjectValue);
            }
            LloadFile = this.f2641a.pcall(r7, 0, -2 - r7);
            if (LloadFile == 0) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m2292a(LloadFile));
        sb.append(": ");
        sb.append(this.f2641a.toString(-1));
        throw new LuaException(sb.toString());
    }

    /* renamed from: c */
    private void m2297c(String str, Object... objArr) {
        this.f2641a.setTop(0);
        int LloadString = this.f2641a.LloadString(str);
        if (LloadString == 0) {
            this.f2641a.getGlobal("debug");
            this.f2641a.getField(-1, "traceback");
            this.f2641a.remove(-2);
            this.f2641a.insert(-2);
            for (Object pushObjectValue : objArr) {
                this.f2641a.pushObjectValue(pushObjectValue);
            }
            LloadString = this.f2641a.pcall(r7, 0, -2 - r7);
            if (LloadString == 0) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m2292a(LloadString));
        sb.append(": ");
        sb.append(this.f2641a.toString(-1));
        throw new LuaException(sb.toString());
    }

    /* renamed from: d */
    private void m2298d(String str, Object... objArr) {
        try {
            this.f2641a.setTop(0);
            this.f2641a.getGlobal(str);
            if (this.f2641a.isFunction(-1)) {
                this.f2641a.getGlobal("debug");
                this.f2641a.getField(-1, "traceback");
                this.f2641a.remove(-2);
                this.f2641a.insert(-2);
                for (Object pushObjectValue : objArr) {
                    this.f2641a.pushObjectValue(pushObjectValue);
                }
                int pcall = this.f2641a.pcall(r0, 1, -2 - r0);
                if (pcall != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(m2292a(pcall));
                    sb.append(": ");
                    sb.append(this.f2641a.toString(-1));
                    throw new LuaException(sb.toString());
                }
            }
        } catch (LuaException e) {
            LuaContext luaContext = this.f2642g;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(toString());
            sb2.append(" ");
            sb2.append(str);
            luaContext.sendError(sb2.toString(), e);
        }
    }

    public boolean cancel() {
        return super.cancel();
    }

    public void doAsset(String str, Object... objArr) {
        byte[] readAsset = LuaUtil.readAsset(this.f2642g.getContext(), str);
        this.f2641a.setTop(0);
        int LloadBuffer = this.f2641a.LloadBuffer(readAsset, str);
        if (LloadBuffer == 0) {
            this.f2641a.getGlobal("debug");
            this.f2641a.getField(-1, "traceback");
            this.f2641a.remove(-2);
            this.f2641a.insert(-2);
            for (Object pushObjectValue : objArr) {
                this.f2641a.pushObjectValue(pushObjectValue);
            }
            LloadBuffer = this.f2641a.pcall(r7, 0, -2 - r7);
            if (LloadBuffer == 0) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m2292a(LloadBuffer));
        sb.append(": ");
        sb.append(this.f2641a.toString(-1));
        throw new LuaException(sb.toString());
    }

    public Object get(String str) {
        this.f2641a.getGlobal(str);
        return this.f2641a.toJavaObject(-1);
    }

    public boolean isEnabled() {
        return this.f2645j;
    }

    public void run() {
        String str;
        Object[] objArr;
        byte[] bArr;
        Object[] objArr2;
        if (this.f2645j) {
            try {
                if (this.f2641a == null) {
                    m2295b();
                    if (this.f2646k != null) {
                        bArr = this.f2646k;
                        objArr2 = this.f2644i;
                    } else {
                        str = this.f2643h;
                        objArr = this.f2644i;
                        m2293a(str, objArr);
                        this.f2641a.mo3510gc(2, 1);
                        System.gc();
                    }
                } else {
                    this.f2641a.getGlobal("run");
                    if (!this.f2641a.isNil(-1)) {
                        m2298d("run", new Object[0]);
                        this.f2641a.mo3510gc(2, 1);
                        System.gc();
                    } else if (this.f2646k != null) {
                        bArr = this.f2646k;
                        objArr2 = this.f2644i;
                    } else {
                        str = this.f2643h;
                        objArr = this.f2644i;
                        m2293a(str, objArr);
                        this.f2641a.mo3510gc(2, 1);
                        System.gc();
                    }
                }
                m2294a(bArr, objArr2);
            } catch (LuaException e) {
                this.f2642g.sendError(toString(), e);
            }
            this.f2641a.mo3510gc(2, 1);
            System.gc();
        }
    }

    public void set(String str, Object obj) {
        this.f2641a.pushObjectValue(obj);
        this.f2641a.setGlobal(str);
    }

    public void setArg(LuaObject luaObject) {
        this.f2644i = luaObject.asArray();
    }

    public void setArg(Object[] objArr) {
        this.f2644i = objArr;
    }

    public void setEnabled(boolean z) {
        this.f2645j = z;
    }
}
