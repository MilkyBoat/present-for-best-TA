package com.androlua;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class LoadingDrawable extends Drawable {

    /* renamed from: a */
    private final DisplayMetrics f2259a;

    /* renamed from: b */
    private int f2260b = 0;

    /* renamed from: c */
    private int f2261c = 0;

    /* renamed from: d */
    private int f2262d = 0;

    /* renamed from: e */
    private int f2263e = 0;

    /* renamed from: f */
    private int f2264f = 3;

    /* renamed from: g */
    private int f2265g = 1;

    /* renamed from: h */
    private Paint f2266h;

    /* renamed from: i */
    private int f2267i;

    public LoadingDrawable(Context context) {
        this.f2259a = context.getResources().getDisplayMetrics();
        this.f2266h = new Paint();
        this.f2266h.setStyle(Style.STROKE);
        this.f2266h.setAntiAlias(true);
        this.f2266h.setStrokeWidth((float) m2133a(8.0f));
        this.f2266h.setColor(-2004318072);
    }

    /* renamed from: a */
    private int m2133a(float f) {
        return (int) TypedValue.applyDimension(1, f, this.f2259a);
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        Rect rect = new Rect(getBounds());
        int min = (int) ((float) Math.min(rect.right, rect.bottom));
        int i3 = rect.right - min;
        int i4 = rect.bottom - min;
        rect.right = min;
        rect.bottom = min;
        canvas.save();
        canvas.translate((float) (i3 / 2), (float) (i4 / 2));
        float f = (float) min;
        float f2 = 0.15f * f;
        float f3 = f * 0.85f;
        RectF rectF = new RectF(f2, f2, f3, f3);
        if (this.f2260b >= 360 && this.f2267i == 0) {
            this.f2265g = 8;
            this.f2264f = -6;
        } else if (this.f2260b <= 6) {
            this.f2264f = 6;
            this.f2265g = 2;
        }
        if (this.f2260b < 360 || this.f2267i == 0) {
            if (this.f2267i == 0) {
                this.f2260b += this.f2264f;
                i = this.f2261c;
                i2 = this.f2265g;
            } else {
                this.f2260b += this.f2264f * 2;
                i = this.f2261c;
                i2 = this.f2265g * 2;
            }
            this.f2261c = i + i2;
            this.f2261c %= 360;
        }
        canvas.drawArc(rectF, (float) this.f2261c, (float) this.f2260b, false, this.f2266h);
        if (this.f2260b >= 360) {
            this.f2264f = -6;
            this.f2265g = 8;
            if (this.f2267i == 1) {
                Path path = new Path();
                path.moveTo(((float) rect.right) * 0.3f, ((float) rect.bottom) * 0.5f);
                path.lineTo(((float) rect.right) * 0.45f, ((float) rect.bottom) * 0.7f);
                path.lineTo(((float) rect.right) * 0.75f, ((float) rect.bottom) * 0.4f);
                canvas.drawPath(path, this.f2266h);
            } else if (this.f2267i == -1) {
                Canvas canvas2 = canvas;
                canvas2.drawLine((float) (rect.right / 2), ((float) rect.bottom) * 0.25f, (float) (rect.right / 2), ((float) rect.bottom) * 0.65f, this.f2266h);
                canvas2.drawLine((float) (rect.right / 2), ((float) rect.bottom) * 0.7f, (float) (rect.right / 2), ((float) rect.bottom) * 0.75f, this.f2266h);
            }
        }
        canvas.restore();
        invalidateSelf();
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
        this.f2266h.setAlpha(i);
    }

    public void setColor(int i) {
        this.f2266h.setColor(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2266h.setColorFilter(colorFilter);
    }

    public void setState(int i) {
        this.f2267i = i;
    }

    public void setStrokeWidth(float f) {
        this.f2266h.setStrokeWidth(f);
    }
}
