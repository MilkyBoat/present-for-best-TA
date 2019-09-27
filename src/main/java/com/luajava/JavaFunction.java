package com.luajava;

public abstract class JavaFunction {

    /* renamed from: b */
    protected LuaState f3375b;

    public JavaFunction(LuaState luaState) {
        this.f3375b = luaState;
    }

    public abstract int execute();

    public LuaObject getParam(int i) {
        return this.f3375b.getLuaObject(i);
    }

    public void register(String str) {
        synchronized (this.f3375b) {
            this.f3375b.pushJavaFunction(this);
            this.f3375b.setGlobal(str);
        }
    }
}
