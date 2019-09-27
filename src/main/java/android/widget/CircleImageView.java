package android.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;

public class CircleImageView extends ImageView {

    /* renamed from: a */
    private static final ScaleType f63a = ScaleType.CENTER_CROP;

    /* renamed from: b */
    private static final Config f64b = Config.ARGB_8888;

    /* renamed from: c */
    private final RectF f65c;

    /* renamed from: d */
    private final RectF f66d;

    /* renamed from: e */
    private final Matrix f67e;

    /* renamed from: f */
    private final Paint f68f;

    /* renamed from: g */
    private final Paint f69g;

    /* renamed from: h */
    private final Paint f70h;

    /* renamed from: i */
    private int f71i;

    /* renamed from: j */
    private int f72j;

    /* renamed from: k */
    private int f73k;

    /* renamed from: l */
    private Bitmap f74l;

    /* renamed from: m */
    private BitmapShader f75m;

    /* renamed from: n */
    private int f76n;

    /* renamed from: o */
    private int f77o;

    /* renamed from: p */
    private float f78p;

    /* renamed from: q */
    private float f79q;

    /* renamed from: r */
    private ColorFilter f80r;

    /* renamed from: s */
    private boolean f81s;

    /* renamed from: t */
    private boolean f82t;

    /* renamed from: u */
    private boolean f83u;

    /* renamed from: v */
    private boolean f84v;

    /* renamed from: w */
    private float f85w;

    public CircleImageView(Context context) {
        super(context);
        this.f65c = new RectF();
        this.f66d = new RectF();
        this.f67e = new Matrix();
        this.f68f = new Paint();
        this.f69g = new Paint();
        this.f70h = new Paint();
        this.f71i = -16777216;
        this.f72j = 0;
        this.f73k = 0;
        m26a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f65c = new RectF();
        this.f66d = new RectF();
        this.f67e = new Matrix();
        this.f68f = new Paint();
        this.f69g = new Paint();
        this.f70h = new Paint();
        this.f71i = -16777216;
        this.f72j = 0;
        this.f73k = 0;
        this.f72j = 0;
        this.f71i = -16777216;
        this.f83u = false;
        this.f73k = 0;
        m26a();
    }

    /* renamed from: a */
    private Bitmap m25a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, f64b) : Bitmap.createBitmap(drawable.getIntrinsicWidth() - ((int) (this.f85w * 2.0f)), drawable.getIntrinsicHeight() - ((int) (this.f85w * 2.0f)), f64b);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            C0029a.m806a(e);
            return null;
        }
    }

    /* renamed from: a */
    private void m26a() {
        super.setScaleType(f63a);
        this.f81s = true;
        if (this.f82t) {
            m29d();
            this.f82t = false;
        }
    }

    /* renamed from: b */
    private void m27b() {
        if (this.f68f != null) {
            this.f68f.setColorFilter(this.f80r);
        }
    }

    /* renamed from: c */
    private void m28c() {
        this.f74l = this.f84v ? null : m25a(getDrawable());
        m29d();
    }

    /* renamed from: d */
    private void m29d() {
        if (!this.f81s) {
            this.f82t = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f74l == null) {
                invalidate();
                return;
            }
            this.f75m = new BitmapShader(this.f74l, TileMode.CLAMP, TileMode.CLAMP);
            this.f68f.setAntiAlias(true);
            this.f68f.setShader(this.f75m);
            this.f69g.setStyle(Style.STROKE);
            this.f69g.setAntiAlias(true);
            this.f69g.setColor(this.f71i);
            this.f69g.setStrokeWidth((float) this.f72j);
            this.f70h.setStyle(Style.FILL);
            this.f70h.setAntiAlias(true);
            this.f70h.setColor(this.f73k);
            this.f77o = this.f74l.getHeight();
            this.f76n = this.f74l.getWidth();
            this.f66d.set(m30e());
            this.f79q = Math.min((this.f66d.height() - ((float) this.f72j)) / 2.0f, (this.f66d.width() - ((float) this.f72j)) / 2.0f);
            this.f65c.set(this.f66d);
            if (!this.f83u && this.f72j > 0) {
                this.f65c.inset(((float) this.f72j) - 1.0f, ((float) this.f72j) - 1.0f);
            }
            this.f78p = Math.min(this.f65c.height() / 2.0f, this.f65c.width() / 2.0f);
            m27b();
            m31f();
            invalidate();
        }
    }

    /* renamed from: e */
    private RectF m30e() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) (width - min)) / 2.0f);
        float paddingTop = ((float) getPaddingTop()) + (((float) (height - min)) / 2.0f);
        float f = (float) min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    /* renamed from: f */
    private void m31f() {
        float f;
        float f2;
        this.f67e.set(null);
        float f3 = 0.0f;
        if (((float) this.f76n) * this.f65c.height() > this.f65c.width() * ((float) this.f77o)) {
            f2 = this.f65c.height() / ((float) this.f77o);
            f3 = (this.f65c.width() - (((float) this.f76n) * f2)) * 0.5f;
            f = 0.0f;
        } else {
            f2 = this.f65c.width() / ((float) this.f76n);
            f = (this.f65c.height() - (((float) this.f77o) * f2)) * 0.5f;
        }
        this.f67e.setScale(f2, f2);
        this.f67e.postTranslate(((float) ((int) (f3 + 0.5f))) + this.f65c.left, ((float) ((int) (f + 0.5f))) + this.f65c.top);
        this.f75m.setLocalMatrix(this.f67e);
    }

    public int getBorderColor() {
        return this.f71i;
    }

    public int getBorderWidth() {
        return this.f72j;
    }

    public ColorFilter getColorFilter() {
        return this.f80r;
    }

    @Deprecated
    public int getFillColor() {
        return this.f73k;
    }

    public ScaleType getScaleType() {
        return f63a;
    }

    public boolean isBorderOverlay() {
        return this.f83u;
    }

    public boolean isDisableCircularTransformation() {
        return this.f84v;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f84v) {
            super.onDraw(canvas);
        } else if (this.f74l != null) {
            if (this.f73k != 0) {
                canvas.drawCircle(this.f65c.centerX(), this.f65c.centerY(), this.f78p - this.f85w, this.f70h);
            }
            canvas.drawCircle(this.f65c.centerX(), this.f65c.centerY(), this.f78p - this.f85w, this.f68f);
            if (this.f72j > 0) {
                canvas.drawCircle(this.f66d.centerX(), this.f66d.centerY(), this.f79q - this.f85w, this.f69g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m29d();
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBackgroundColor(int i) {
        setFillColor(i);
    }

    public void setBorderColor(int i) {
        if (i != this.f71i) {
            this.f71i = i;
            this.f69g.setColor(this.f71i);
            invalidate();
        }
    }

    @Deprecated
    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.f83u) {
            this.f83u = z;
            m29d();
        }
    }

    public void setBorderWidth(int i) {
        if (i != this.f72j) {
            this.f72j = i;
            m29d();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f80r) {
            this.f80r = colorFilter;
            m27b();
            invalidate();
        }
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.f84v != z) {
            this.f84v = z;
            m28c();
        }
    }

    public void setElevation2(float f) {
        this.f85w = f;
        this.f70h.setShadowLayer(f, 0.0f, f / 2.0f, -16777216);
        invalidate();
    }

    @Deprecated
    public void setFillColor(int i) {
        if (i != this.f73k) {
            this.f73k = i;
            this.f70h.setColor(i);
            invalidate();
        }
    }

    @Deprecated
    public void setFillColorResource(int i) {
        setFillColor(getContext().getResources().getColor(i));
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m28c();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m28c();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        m28c();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m28c();
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != f63a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }
}
