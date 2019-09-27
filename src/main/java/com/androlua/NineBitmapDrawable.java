package com.androlua;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;

public class NineBitmapDrawable extends Drawable implements LuaGcable {

    /* renamed from: a */
    private Paint f2717a;

    /* renamed from: b */
    private Bitmap f2718b;

    /* renamed from: c */
    private int f2719c;

    /* renamed from: d */
    private int f2720d;

    /* renamed from: e */
    private int f2721e;

    /* renamed from: f */
    private int f2722f;

    /* renamed from: g */
    private Rect f2723g;

    /* renamed from: h */
    private Rect f2724h;

    /* renamed from: i */
    private Rect f2725i;

    /* renamed from: j */
    private Rect f2726j;

    /* renamed from: k */
    private Rect f2727k;

    /* renamed from: l */
    private Rect f2728l;

    /* renamed from: m */
    private Rect f2729m;

    /* renamed from: n */
    private Rect f2730n;

    /* renamed from: o */
    private Rect f2731o;

    /* renamed from: p */
    private boolean f2732p;

    public NineBitmapDrawable(Bitmap bitmap) {
        int i;
        int i2;
        int i3;
        int i4;
        this.f2717a = new Paint();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i5 = 0;
        while (true) {
            if (i5 >= width) {
                i = 0;
                break;
            } else if (bitmap.getPixel(i5, 0) == -16777216) {
                i = i5;
                break;
            } else {
                i5++;
            }
        }
        if (i == 0 || i == width - 1) {
            throw new IllegalArgumentException("not found x1");
        }
        int i6 = i;
        while (true) {
            if (i6 >= width) {
                i2 = 0;
                break;
            } else if (bitmap.getPixel(i6, 0) != -16777216) {
                i2 = width - i6;
                break;
            } else {
                i6++;
            }
        }
        if (i2 == 0 || i2 == 1) {
            throw new IllegalArgumentException("not found x2");
        }
        int i7 = 0;
        while (true) {
            if (i7 >= height) {
                i3 = 0;
                break;
            } else if (bitmap.getPixel(0, i7) == -16777216) {
                i3 = i7;
                break;
            } else {
                i7++;
            }
        }
        if (i3 == 0 || i3 == height - 1) {
            throw new IllegalArgumentException("not found y1");
        }
        int i8 = i3;
        while (true) {
            if (i8 >= height) {
                i4 = 0;
                break;
            } else if (bitmap.getPixel(0, i8) != -16777216) {
                i4 = height - i8;
                break;
            } else {
                i8++;
            }
        }
        if (i4 == 0 || i4 == 1) {
            throw new IllegalArgumentException("not found y2");
        }
        m2320a(bitmap, i, i3, i2, i4);
    }

    public NineBitmapDrawable(Bitmap bitmap, int i, int i2, int i3, int i4) {
        this.f2717a = new Paint();
        m2320a(bitmap, i, i2, i3, i4);
    }

    public NineBitmapDrawable(String str) {
        this(LuaBitmap.getLocalBitmap(str));
    }

    /* renamed from: a */
    private void m2320a(Bitmap bitmap, int i, int i2, int i3, int i4) {
        this.f2718b = bitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f2719c = i;
        this.f2720d = i2;
        this.f2721e = i3;
        this.f2722f = i4;
        int i5 = width - i3;
        int i6 = height - i4;
        this.f2723g = new Rect(1, 1, i, i2);
        this.f2724h = new Rect(i, 1, i5, i2);
        int i7 = width - 1;
        this.f2725i = new Rect(i5, 1, i7, i2);
        this.f2726j = new Rect(1, i2, i, i6);
        this.f2727k = new Rect(i, i2, i5, i6);
        this.f2728l = new Rect(i5, i2, i7, i6);
        int i8 = height - 1;
        this.f2729m = new Rect(1, i6, i, i8);
        this.f2730n = new Rect(i, i6, i5, i8);
        this.f2731o = new Rect(i5, i6, i7, i8);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = bounds.right;
        int i2 = bounds.bottom;
        Rect rect = new Rect(0, 0, this.f2719c, this.f2720d);
        Rect rect2 = new Rect(this.f2719c, 0, i - this.f2721e, this.f2720d);
        Rect rect3 = new Rect(i - this.f2721e, 0, i, this.f2720d);
        Rect rect4 = new Rect(0, this.f2720d, this.f2719c, i2 - this.f2722f);
        Rect rect5 = new Rect(this.f2719c, this.f2720d, i - this.f2721e, i2 - this.f2722f);
        Rect rect6 = new Rect(i - this.f2721e, this.f2720d, i, i2 - this.f2722f);
        Rect rect7 = new Rect(0, i2 - this.f2722f, this.f2719c, i2);
        Rect rect8 = new Rect(this.f2719c, i2 - this.f2722f, i - this.f2721e, i2);
        Rect rect9 = new Rect(i - this.f2721e, i2 - this.f2722f, i, i2);
        canvas.drawBitmap(this.f2718b, this.f2723g, rect, this.f2717a);
        canvas.drawBitmap(this.f2718b, this.f2724h, rect2, this.f2717a);
        canvas.drawBitmap(this.f2718b, this.f2725i, rect3, this.f2717a);
        canvas.drawBitmap(this.f2718b, this.f2726j, rect4, this.f2717a);
        canvas.drawBitmap(this.f2718b, this.f2727k, rect5, this.f2717a);
        canvas.drawBitmap(this.f2718b, this.f2728l, rect6, this.f2717a);
        canvas.drawBitmap(this.f2718b, this.f2729m, rect7, this.f2717a);
        canvas.drawBitmap(this.f2718b, this.f2730n, rect8, this.f2717a);
        canvas.drawBitmap(this.f2718b, this.f2731o, rect9, this.f2717a);
    }

    /* renamed from: gc */
    public void mo2151gc() {
        try {
            this.f2718b.recycle();
            this.f2732p = true;
        } catch (Exception e) {
            C0029a.m806a(e);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public boolean isGc() {
        return this.f2732p;
    }

    public void setAlpha(int i) {
        this.f2717a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2717a.setColorFilter(colorFilter);
    }
}
