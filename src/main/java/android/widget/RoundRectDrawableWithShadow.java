package android.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;

class RoundRectDrawableWithShadow extends Drawable {

    /* renamed from: a */
    static final double f400a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: c */
    static RoundRectHelper f401c;

    /* renamed from: b */
    final int f402b;

    /* renamed from: d */
    Paint f403d;

    /* renamed from: e */
    Paint f404e;

    /* renamed from: f */
    Paint f405f;

    /* renamed from: g */
    final RectF f406g;

    /* renamed from: h */
    float f407h;

    /* renamed from: i */
    Path f408i;

    /* renamed from: j */
    float f409j;

    /* renamed from: k */
    float f410k;

    /* renamed from: l */
    float f411l;

    /* renamed from: m */
    float f412m;

    /* renamed from: n */
    private boolean f413n = true;

    /* renamed from: o */
    private final int f414o = 922746880;

    /* renamed from: p */
    private final int f415p = 50331648;

    /* renamed from: q */
    private boolean f416q = true;

    /* renamed from: r */
    private boolean f417r = false;

    /* renamed from: s */
    private DisplayMetrics f418s;

    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    RoundRectDrawableWithShadow(Resources resources, int i, float f, float f2, float f3) {
        this.f418s = resources.getDisplayMetrics();
        this.f402b = (int) m215d(1.0f);
        this.f403d = new Paint(5);
        this.f403d.setColor(i);
        this.f404e = new Paint(5);
        this.f404e.setStyle(Style.FILL);
        this.f407h = (float) ((int) (f + 0.5f));
        this.f406g = new RectF();
        this.f405f = new Paint(this.f404e);
        this.f405f.setAntiAlias(false);
        mo514a(f2, f3);
    }

    /* renamed from: a */
    static float m211a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - f400a) * ((double) f2))) : f * 1.5f;
    }

    /* renamed from: a */
    private void m212a(Canvas canvas) {
        float f = (-this.f407h) - this.f411l;
        float f2 = this.f407h + ((float) this.f402b) + (this.f412m / 2.0f);
        float f3 = f2 * 2.0f;
        boolean z = this.f406g.width() - f3 > 0.0f;
        boolean z2 = this.f406g.height() - f3 > 0.0f;
        int save = canvas.save();
        canvas.translate(this.f406g.left + f2, this.f406g.top + f2);
        canvas.drawPath(this.f408i, this.f404e);
        if (z) {
            canvas.drawRect(0.0f, f, this.f406g.width() - f3, -this.f407h, this.f405f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f406g.right - f2, this.f406g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f408i, this.f404e);
        if (z) {
            canvas.drawRect(0.0f, f, this.f406g.width() - f3, (-this.f407h) + this.f411l, this.f405f);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f406g.left + f2, this.f406g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f408i, this.f404e);
        if (z2) {
            canvas.drawRect(0.0f, f, this.f406g.height() - f3, -this.f407h, this.f405f);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.f406g.right - f2, this.f406g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f408i, this.f404e);
        if (z2) {
            canvas.drawRect(0.0f, f, this.f406g.height() - f3, -this.f407h, this.f405f);
        }
        canvas.restoreToCount(save4);
    }

    /* renamed from: b */
    static float m213b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f400a) * ((double) f2))) : f;
    }

    /* renamed from: b */
    private void m214b(Rect rect) {
        float f = this.f410k * 1.5f;
        this.f406g.set(((float) rect.left) + this.f410k, ((float) rect.top) + f, ((float) rect.right) - this.f410k, ((float) rect.bottom) - f);
        m217f();
    }

    /* renamed from: d */
    private float m215d(float f) {
        return TypedValue.applyDimension(1, f, this.f418s);
    }

    /* renamed from: e */
    private int m216e(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    /* renamed from: f */
    private void m217f() {
        RectF rectF = new RectF(-this.f407h, -this.f407h, this.f407h, this.f407h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f411l, -this.f411l);
        if (this.f408i == null) {
            this.f408i = new Path();
        } else {
            this.f408i.reset();
        }
        this.f408i.setFillType(FillType.EVEN_ODD);
        this.f408i.moveTo(-this.f407h, 0.0f);
        this.f408i.rLineTo(-this.f411l, 0.0f);
        this.f408i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f408i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f408i.close();
        float f = this.f407h / (this.f407h + this.f411l);
        Paint paint = this.f404e;
        RadialGradient radialGradient = new RadialGradient(0.0f, 0.0f, this.f407h + this.f411l, new int[]{this.f414o, this.f414o, this.f415p}, new float[]{0.0f, f, 1.0f}, TileMode.CLAMP);
        paint.setShader(radialGradient);
        Paint paint2 = this.f405f;
        LinearGradient linearGradient = new LinearGradient(0.0f, (-this.f407h) + this.f411l, 0.0f, (-this.f407h) - this.f411l, new int[]{this.f414o, this.f414o, this.f415p}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP);
        paint2.setShader(linearGradient);
        this.f405f.setAntiAlias(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public float mo512a() {
        return this.f407h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo513a(float f) {
        float f2 = (float) ((int) (f + 0.5f));
        if (this.f407h != f2) {
            this.f407h = f2;
            this.f413n = true;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo514a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float e = (float) m216e(f);
        float e2 = (float) m216e(f2);
        if (e > e2) {
            if (!this.f417r) {
                this.f417r = true;
            }
            e = e2;
        }
        if (this.f412m != e || this.f410k != e2) {
            this.f412m = e;
            this.f410k = e2;
            this.f411l = (float) ((int) ((e * 1.5f) + ((float) this.f402b) + 0.5f));
            this.f409j = e2 + ((float) this.f402b);
            this.f413n = true;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo515a(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public float mo516b() {
        return this.f412m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo517b(float f) {
        mo514a(f, this.f410k);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public float mo518c() {
        return this.f410k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo519c(float f) {
        mo514a(this.f412m, f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public float mo520d() {
        return (Math.max(this.f410k, this.f407h + ((float) this.f402b) + (this.f410k / 2.0f)) * 2.0f) + ((this.f410k + ((float) this.f402b)) * 2.0f);
    }

    public void draw(Canvas canvas) {
        if (this.f413n) {
            m214b(getBounds());
            this.f413n = false;
        }
        canvas.translate(0.0f, this.f412m / 2.0f);
        m212a(canvas);
        canvas.translate(0.0f, (-this.f412m) / 2.0f);
        f401c.drawRoundRect(canvas, this.f406g, this.f407h, this.f403d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public float mo522e() {
        return (Math.max(this.f410k, this.f407h + ((float) this.f402b) + ((this.f410k * 1.5f) / 2.0f)) * 2.0f) + (((this.f410k * 1.5f) + ((float) this.f402b)) * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m211a(this.f410k, this.f407h, this.f416q));
        int ceil2 = (int) Math.ceil((double) m213b(this.f410k, this.f407h, this.f416q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f413n = true;
    }

    public void setAddPaddingForCorners(boolean z) {
        this.f416q = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.f403d.setAlpha(i);
        this.f404e.setAlpha(i);
        this.f405f.setAlpha(i);
    }

    public void setColor(int i) {
        this.f403d.setColor(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f403d.setColorFilter(colorFilter);
        this.f404e.setColorFilter(colorFilter);
        this.f405f.setColorFilter(colorFilter);
    }
}
