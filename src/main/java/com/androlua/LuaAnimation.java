package com.androlua;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.luajava.LuaException;
import com.luajava.LuaFunction;

public class LuaAnimation extends Animation {

    /* renamed from: a */
    private final LuaContext f2371a = this.f2372b.getLuaState().getContext();

    /* renamed from: b */
    private LuaFunction f2372b;

    /* renamed from: c */
    private LuaFunction f2373c;

    public LuaAnimation(LuaFunction luaFunction) {
        this.f2372b = luaFunction;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        try {
            this.f2372b.call(Float.valueOf(f), transformation);
            if (this.f2373c == null) {
                Object call = this.f2372b.call(Float.valueOf(f), transformation, this);
                if (call != null && (call instanceof LuaFunction)) {
                    this.f2373c = (LuaFunction) call;
                }
            }
            if (this.f2373c != null) {
                this.f2373c.call(Float.valueOf(f), transformation);
            }
        } catch (LuaException e) {
            this.f2371a.sendError("applyTransformation", e);
        }
    }

    /* access modifiers changed from: protected */
    public float resolveSize(int i, float f, int i2, int i3) {
        return super.resolveSize(i, f, i2, i3);
    }
}
