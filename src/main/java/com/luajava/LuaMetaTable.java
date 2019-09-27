package com.luajava;

public interface LuaMetaTable {
    Object __call(Object... objArr);

    Object __index(String str);

    void __newIndex(String str, Object obj);
}
