package com.androlua;

import android.content.Context;
import android.view.View;
import com.luajava.LuaException;
import com.luajava.LuaObject;
import com.luajava.LuaTable;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;

public class LuaView extends View {

    /* renamed from: a */
    private LuaTable f2662a;

    /* renamed from: b */
    private LuaObject f2663b;

    public LuaView(Context context) {
        super(context);
    }

    public LuaView(Context context, LuaTable luaTable) {
        super(context);
        this.f2662a = luaTable;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f2662a != null) {
            try {
                this.f2663b = this.f2662a.getField("onMeasure");
                if (this.f2663b.isFunction()) {
                    this.f2663b.call(Integer.valueOf(i), Integer.valueOf(i2), this);
                    return;
                }
            } catch (LuaException e) {
                C0029a.m806a(e);
            }
        }
        super.onMeasure(i, i2);
    }
}
