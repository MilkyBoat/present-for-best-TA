package com.luajava;

import java.util.HashMap;
import java.util.Map;

public final class LuaStateFactory {

    /* renamed from: a */
    private static final Map<Long, LuaState> f3404a = new HashMap();

    private LuaStateFactory() {
    }

    public static synchronized LuaState getExistingState(long j) {
        LuaState luaState;
        synchronized (LuaStateFactory.class) {
            luaState = (LuaState) f3404a.get(Long.valueOf(j));
            if (luaState == null) {
                luaState = new LuaState(j);
                f3404a.put(Long.valueOf(j), luaState);
            }
        }
        return luaState;
    }

    public static synchronized long insertLuaState(LuaState luaState) {
        long pointer;
        synchronized (LuaStateFactory.class) {
            f3404a.put(Long.valueOf(luaState.getPointer()), luaState);
            pointer = luaState.getPointer();
        }
        return pointer;
    }

    public static synchronized LuaState newLuaState() {
        LuaState luaState;
        synchronized (LuaStateFactory.class) {
            luaState = new LuaState();
            f3404a.put(Long.valueOf(luaState.getPointer()), luaState);
        }
        return luaState;
    }

    public static synchronized void removeLuaState(long j) {
        synchronized (LuaStateFactory.class) {
            f3404a.put(Long.valueOf(j), null);
        }
    }
}
