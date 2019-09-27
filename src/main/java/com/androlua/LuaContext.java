package com.androlua;

import android.content.Context;
import com.luajava.LuaState;
import java.util.ArrayList;
import java.util.Map;

public interface LuaContext {
    void call(String str, Object... objArr);

    Object doFile(String str, Object... objArr);

    ArrayList<ClassLoader> getClassLoaders();

    Context getContext();

    Map getGlobalData();

    int getHeight();

    String getLuaCpath();

    String getLuaDir();

    String getLuaDir(String str);

    String getLuaExtDir();

    String getLuaExtDir(String str);

    String getLuaExtPath(String str);

    String getLuaExtPath(String str, String str2);

    String getLuaLpath();

    String getLuaPath();

    String getLuaPath(String str);

    String getLuaPath(String str, String str2);

    LuaState getLuaState();

    Object getSharedData(String str);

    Object getSharedData(String str, Object obj);

    int getWidth();

    void regGc(LuaGcable luaGcable);

    void sendError(String str, Exception exc);

    void sendMsg(String str);

    void set(String str, Object obj);

    void setLuaExtDir(String str);

    boolean setSharedData(String str, Object obj);
}
