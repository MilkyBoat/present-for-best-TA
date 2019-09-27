package com.androlua;

import com.androlua.util.TimerTaskX;
import com.androlua.util.TimerX;
import com.luajava.LuaObject;

public class LuaTimer extends TimerX implements LuaGcable {

    /* renamed from: a */
    private boolean f2639a;

    /* renamed from: b */
    private LuaTimerTask f2640b;

    public LuaTimer(LuaContext luaContext, LuaObject luaObject) {
        this(luaContext, luaObject, (Object[]) null);
    }

    public LuaTimer(LuaContext luaContext, LuaObject luaObject, Object[] objArr) {
        super("LuaTimer");
        luaContext.regGc(this);
        this.f2640b = new LuaTimerTask(luaContext, luaObject, objArr);
    }

    public LuaTimer(LuaContext luaContext, String str) {
        this(luaContext, str, (Object[]) null);
    }

    public LuaTimer(LuaContext luaContext, String str, Object[] objArr) {
        super("LuaTimer");
        luaContext.regGc(this);
        this.f2640b = new LuaTimerTask(luaContext, str, objArr);
    }

    /* renamed from: gc */
    public void mo2151gc() {
        stop();
        this.f2639a = true;
    }

    public boolean getEnabled() {
        return this.f2640b.isEnabled();
    }

    public long getPeriod() {
        return this.f2640b.getPeriod();
    }

    public boolean isEnabled() {
        return this.f2640b.isEnabled();
    }

    public boolean isGc() {
        return this.f2639a;
    }

    public void setEnabled(boolean z) {
        this.f2640b.setEnabled(z);
    }

    public void setPeriod(long j) {
        this.f2640b.setPeriod(j);
    }

    public void start(long j) {
        schedule((TimerTaskX) this.f2640b, j);
    }

    public void start(long j, long j2) {
        schedule((TimerTaskX) this.f2640b, j, j2);
    }

    public void stop() {
        this.f2640b.cancel();
    }
}
