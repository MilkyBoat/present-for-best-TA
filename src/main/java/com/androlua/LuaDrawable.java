package com.androlua;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.luajava.LuaException;
import com.luajava.LuaFunction;
import com.luajava.LuaObject;

public class LuaDrawable extends Drawable {

    /* renamed from: a */
    private final LuaContext f2463a = this.f2464b.getLuaState().getContext();

    /* renamed from: b */
    private LuaObject f2464b;

    /* renamed from: c */
    private Paint f2465c = new Paint();

    /* renamed from: d */
    private LuaFunction f2466d;

    public LuaDrawable(LuaFunction luaFunction) {
        this.f2464b = luaFunction;
    }

    public void draw(Canvas canvas) {
        try {
            if (this.f2466d == null) {
                Object call = this.f2464b.call(canvas, this.f2465c, this);
                if (call != null && (call instanceof LuaFunction)) {
                    this.f2466d = (LuaFunction) call;
                }
            }
            if (this.f2466d != null) {
                this.f2466d.call(canvas);
            }
        } catch (LuaException e) {
            this.f2463a.sendError("onDraw", e);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public Paint getPaint() {
        return this.f2465c;
    }

    public void setAlpha(int i) {
        this.f2465c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2465c.setColorFilter(colorFilter);
    }
}
