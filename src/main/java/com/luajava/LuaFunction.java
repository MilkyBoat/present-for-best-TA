package com.luajava;

public class LuaFunction<T> extends LuaObject implements LuaMetaTable {
    protected LuaFunction(LuaState luaState, int i) {
        super(luaState, i);
    }

    protected LuaFunction(LuaState luaState, String str) {
        super(luaState, str);
    }

    public T __call(Object[] objArr) {
        return super.call(objArr);
    }

    public Object __index(String str) {
        return null;
    }

    public void __newIndex(String str, Object obj) {
    }

    public T call(Object... objArr) {
        return super.call(objArr);
    }
}
