package com.androlua;

import com.luajava.JavaFunction;
import com.luajava.LuaState;

public class LuaPrint extends JavaFunction {

    /* renamed from: a */
    private LuaState f2564a;

    /* renamed from: c */
    private LuaContext f2565c;

    /* renamed from: d */
    private StringBuilder f2566d = new StringBuilder();

    public LuaPrint(LuaContext luaContext, LuaState luaState) {
        super(luaState);
        this.f2564a = luaState;
        this.f2565c = luaContext;
    }

    public int execute() {
        int i = 2;
        if (this.f2564a.getTop() < 2) {
            this.f2565c.sendMsg(BuildConfig.FLAVOR);
            return 0;
        }
        while (i <= this.f2564a.getTop()) {
            String str = null;
            String typeName = this.f2564a.typeName(this.f2564a.type(i));
            if (typeName.equals("userdata")) {
                Object javaObject = this.f2564a.toJavaObject(i);
                if (javaObject != null) {
                    str = javaObject.toString();
                }
            } else {
                str = typeName.equals("boolean") ? this.f2564a.toBoolean(i) ? "true" : "false" : this.f2564a.toString(i);
            }
            if (str != null) {
                typeName = str;
            }
            this.f2566d.append("\t");
            this.f2566d.append(typeName);
            this.f2566d.append("\t");
            i++;
        }
        this.f2565c.sendMsg(this.f2566d.toString().substring(1, this.f2566d.length() - 1));
        this.f2566d.setLength(0);
        return 0;
    }
}
