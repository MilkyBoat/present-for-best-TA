package com.luajava;

import java.util.HashMap;

public class LuaStack {

    /* renamed from: a */
    private static final HashMap<String, LuaState> f3394a = new HashMap<>();

    public static Object call(String str, String str2, Object[] objArr) {
        return new LuaFunction(get(str), str2).call(objArr);
    }

    public static LuaState get(String str) {
        return (LuaState) f3394a.get(str);
    }

    public static void put(String str, LuaState luaState) {
        f3394a.put(str, luaState);
    }
}
