package android.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

class RoundRectDrawable extends Drawable {

    /* renamed from: a */
    private float f393a;

    /* renamed from: b */
    private final Paint f394b;

    /* renamed from: c */
    private final RectF f395c;

    /* renamed from: d */
    private final Rect f396d;

    /* renamed from: e */
    private float f397e;

    /* renamed from: f */
    private boolean f398f = false;

    /* renamed from: g */
    private boolean f399g = true;

    public RoundRectDrawable(int i, float f) {
        this.f393a = f;
        this.f394b = new Paint(5);
        this.f394b.setColor(i);
        this.f395c = new RectF();
        this.f396d = new Rect();
    }

    /* renamed from: a */
    private void m207a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f395c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f396d.set(rect);
        if (this.f398f) {
            float a = RoundRectDrawableWithShadow.m211a(this.f397e, this.f393a, this.f399g);
            this.f396d.inset((int) Math.ceil((double) RoundRectDrawableWithShadow.m213b(this.f397e, this.f393a, this.f399g)), (int) Math.ceil((double) a));
            this.f395c.set(this.f396d);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public float mo501a() {
        return this.f397e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo502a(float f) {
        if (f != this.f393a) {
            this.f393a = f;
            m207a((Rect) null);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo503a(float f, boolean z, boolean z2) {
        if (f != this.f397e || this.f398f != z || this.f399g != z2) {
            this.f397e = f;
            this.f398f = z;
            this.f399g = z2;
            m207a((Rect) null);
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawRoundRect(this.f395c, this.f393a, this.f393a, this.f394b);
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        if (VERSION.SDK_INT >= 21) {
            outline.setRoundRect(this.f396d, this.f393a);
        }
    }

    public float getRadius() {
        return this.f393a;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m207a(rect);
    }

    public void setAlpha(int i) {
    }

    public void setColor(int i) {
        this.f394b.setColor(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
