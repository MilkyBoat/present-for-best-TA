package android.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;

public class CardView extends FrameLayout implements CardViewDelegate {

    /* renamed from: a */
    private static final CardViewImpl f54a;

    /* renamed from: b */
    private DisplayMetrics f55b;

    /* renamed from: c */
    private boolean f56c;

    /* renamed from: d */
    private boolean f57d;

    /* renamed from: e */
    private final Rect f58e = new Rect();

    /* renamed from: f */
    private final Rect f59f = new Rect();

    @SuppressLint({"NewApi"})
    static class CardViewApi21 implements CardViewImpl {
        CardViewApi21() {
        }

        public float getElevation(CardViewDelegate cardViewDelegate) {
            return ((View) cardViewDelegate).getElevation();
        }

        public float getMaxElevation(CardViewDelegate cardViewDelegate) {
            return ((RoundRectDrawable) cardViewDelegate.getBackground()).mo501a();
        }

        public float getMinHeight(CardViewDelegate cardViewDelegate) {
            return getRadius(cardViewDelegate) * 2.0f;
        }

        public float getMinWidth(CardViewDelegate cardViewDelegate) {
            return getRadius(cardViewDelegate) * 2.0f;
        }

        public float getRadius(CardViewDelegate cardViewDelegate) {
            return ((RoundRectDrawable) cardViewDelegate.getBackground()).getRadius();
        }

        public void initStatic() {
        }

        public void initialize(CardViewDelegate cardViewDelegate, Context context, int i, float f, float f2, float f3) {
            cardViewDelegate.setBackgroundDrawable(new RoundRectDrawable(i, f));
            View view = (View) cardViewDelegate;
            view.setClipToOutline(true);
            view.setElevation(f2);
            setMaxElevation(cardViewDelegate, f3);
        }

        public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
            setMaxElevation(cardViewDelegate, getMaxElevation(cardViewDelegate));
        }

        public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
            setMaxElevation(cardViewDelegate, getMaxElevation(cardViewDelegate));
        }

        public void setBackgroundColor(CardViewDelegate cardViewDelegate, int i) {
            ((RoundRectDrawable) cardViewDelegate.getBackground()).setColor(i);
        }

        public void setElevation(CardViewDelegate cardViewDelegate, float f) {
            ((View) cardViewDelegate).setElevation(f);
        }

        public void setMaxElevation(CardViewDelegate cardViewDelegate, float f) {
            ((RoundRectDrawable) cardViewDelegate.getBackground()).mo503a(f, cardViewDelegate.getUseCompatPadding(), cardViewDelegate.getPreventCornerOverlap());
            updatePadding(cardViewDelegate);
        }

        public void setRadius(CardViewDelegate cardViewDelegate, float f) {
            ((RoundRectDrawable) cardViewDelegate.getBackground()).mo502a(f);
        }

        public void updatePadding(CardViewDelegate cardViewDelegate) {
            if (!cardViewDelegate.getUseCompatPadding()) {
                cardViewDelegate.setShadowPadding(0, 0, 0, 0);
                return;
            }
            float maxElevation = getMaxElevation(cardViewDelegate);
            float radius = getRadius(cardViewDelegate);
            int ceil = (int) Math.ceil((double) RoundRectDrawableWithShadow.m213b(maxElevation, radius, cardViewDelegate.getPreventCornerOverlap()));
            int ceil2 = (int) Math.ceil((double) RoundRectDrawableWithShadow.m211a(maxElevation, radius, cardViewDelegate.getPreventCornerOverlap()));
            cardViewDelegate.setShadowPadding(ceil, ceil2, ceil, ceil2);
        }
    }

    static class CardViewEclairMr1 implements CardViewImpl {

        /* renamed from: a */
        final RectF f60a = new RectF();

        CardViewEclairMr1() {
        }

        /* renamed from: a */
        private RoundRectDrawableWithShadow m23a(CardViewDelegate cardViewDelegate) {
            return (RoundRectDrawableWithShadow) cardViewDelegate.getBackground();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public RoundRectDrawableWithShadow mo125a(Context context, int i, float f, float f2, float f3) {
            RoundRectDrawableWithShadow roundRectDrawableWithShadow = new RoundRectDrawableWithShadow(context.getResources(), i, f, f2, f3);
            return roundRectDrawableWithShadow;
        }

        public float getElevation(CardViewDelegate cardViewDelegate) {
            return m23a(cardViewDelegate).mo516b();
        }

        public float getMaxElevation(CardViewDelegate cardViewDelegate) {
            return m23a(cardViewDelegate).mo518c();
        }

        public float getMinHeight(CardViewDelegate cardViewDelegate) {
            return m23a(cardViewDelegate).mo522e();
        }

        public float getMinWidth(CardViewDelegate cardViewDelegate) {
            return m23a(cardViewDelegate).mo520d();
        }

        public float getRadius(CardViewDelegate cardViewDelegate) {
            return m23a(cardViewDelegate).mo512a();
        }

        public void initStatic() {
            RoundRectDrawableWithShadow.f401c = new RoundRectHelper() {
                public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
                    float f2;
                    Canvas canvas2 = canvas;
                    RectF rectF2 = rectF;
                    float f3 = 2.0f * f;
                    float width = (rectF.width() - f3) - 1.0f;
                    float height = (rectF.height() - f3) - 1.0f;
                    if (f >= 1.0f) {
                        f2 = f + 0.5f;
                        float f4 = -f2;
                        CardViewEclairMr1.this.f60a.set(f4, f4, f2, f2);
                        int save = canvas.save();
                        canvas2.translate(rectF2.left + f2, rectF2.top + f2);
                        Paint paint2 = paint;
                        canvas2.drawArc(CardViewEclairMr1.this.f60a, 180.0f, 90.0f, true, paint2);
                        canvas2.translate(width, 0.0f);
                        canvas2.rotate(90.0f);
                        canvas2.drawArc(CardViewEclairMr1.this.f60a, 180.0f, 90.0f, true, paint2);
                        canvas2.translate(height, 0.0f);
                        canvas2.rotate(90.0f);
                        canvas2.drawArc(CardViewEclairMr1.this.f60a, 180.0f, 90.0f, true, paint2);
                        canvas2.translate(width, 0.0f);
                        canvas2.rotate(90.0f);
                        canvas2.drawArc(CardViewEclairMr1.this.f60a, 180.0f, 90.0f, true, paint2);
                        canvas2.restoreToCount(save);
                        canvas2.drawRect((rectF2.left + f2) - 1.0f, rectF2.top, (rectF2.right - f2) + 1.0f, rectF2.top + f2, paint2);
                        canvas2.drawRect((rectF2.left + f2) - 1.0f, (rectF2.bottom - f2) + 1.0f, (rectF2.right - f2) + 1.0f, rectF2.bottom, paint2);
                    } else {
                        f2 = f;
                    }
                    canvas2.drawRect(rectF2.left, Math.max(0.0f, f2 - 1.0f) + rectF2.top, rectF2.right, (rectF2.bottom - f2) + 1.0f, paint);
                }
            };
        }

        public void initialize(CardViewDelegate cardViewDelegate, Context context, int i, float f, float f2, float f3) {
            RoundRectDrawableWithShadow a = mo125a(context, i, f, f2, f3);
            a.setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
            cardViewDelegate.setBackgroundDrawable(a);
            updatePadding(cardViewDelegate);
        }

        public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
        }

        public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
            m23a(cardViewDelegate).setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
            updatePadding(cardViewDelegate);
        }

        public void setBackgroundColor(CardViewDelegate cardViewDelegate, int i) {
            m23a(cardViewDelegate).setColor(i);
        }

        public void setElevation(CardViewDelegate cardViewDelegate, float f) {
            m23a(cardViewDelegate).mo517b(f);
        }

        public void setMaxElevation(CardViewDelegate cardViewDelegate, float f) {
            m23a(cardViewDelegate).mo519c(f);
            updatePadding(cardViewDelegate);
        }

        public void setRadius(CardViewDelegate cardViewDelegate, float f) {
            m23a(cardViewDelegate).mo513a(f);
            updatePadding(cardViewDelegate);
        }

        public void updatePadding(CardViewDelegate cardViewDelegate) {
            Rect rect = new Rect();
            m23a(cardViewDelegate).mo515a(rect);
            View view = (View) cardViewDelegate;
            view.setMinimumHeight((int) Math.ceil((double) getMinHeight(cardViewDelegate)));
            view.setMinimumWidth((int) Math.ceil((double) getMinWidth(cardViewDelegate)));
            cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    static class CardViewJellybeanMr1 extends CardViewEclairMr1 {
        CardViewJellybeanMr1() {
        }

        public void initStatic() {
            RoundRectDrawableWithShadow.f401c = new RoundRectHelper() {
                public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
                    canvas.drawRoundRect(rectF, f, f, paint);
                }
            };
        }
    }

    static {
        CardViewImpl cardViewEclairMr1 = VERSION.SDK_INT >= 21 ? new CardViewApi21() : VERSION.SDK_INT >= 17 ? new CardViewJellybeanMr1() : new CardViewEclairMr1();
        f54a = cardViewEclairMr1;
        f54a.initStatic();
    }

    public CardView(Context context) {
        super(context);
        m22a(context, null, 0);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22a(context, attributeSet, i);
    }

    /* renamed from: a */
    private float m21a(float f) {
        return TypedValue.applyDimension(1, f, this.f55b);
    }

    /* renamed from: a */
    private void m22a(Context context, AttributeSet attributeSet, int i) {
        this.f55b = context.getResources().getDisplayMetrics();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842801});
        int color = obtainStyledAttributes.getColor(0, -328966);
        obtainStyledAttributes.recycle();
        float a = m21a(2.0f);
        float a2 = m21a(2.0f);
        float a3 = m21a(2.0f);
        this.f56c = false;
        this.f57d = true;
        this.f58e.left = 0;
        this.f58e.top = 0;
        this.f58e.right = 0;
        this.f58e.bottom = 0;
        f54a.initialize(this, context, color, a, a2, a2 > a3 ? a2 : a3);
    }

    public float getCardElevation() {
        return f54a.getElevation(this);
    }

    public int getContentPaddingBottom() {
        return this.f58e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f58e.left;
    }

    public int getContentPaddingRight() {
        return this.f58e.right;
    }

    public int getContentPaddingTop() {
        return this.f58e.top;
    }

    public float getMaxCardElevation() {
        return f54a.getMaxElevation(this);
    }

    public boolean getPreventCornerOverlap() {
        return this.f57d;
    }

    public float getRadius() {
        return f54a.getRadius(this);
    }

    public boolean getUseCompatPadding() {
        return this.f56c;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SwitchIntDef"})
    public void onMeasure(int i, int i2) {
        if (!(f54a instanceof CardViewApi21)) {
            int mode = MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f54a.getMinWidth(this)), MeasureSpec.getSize(i)), mode);
            }
            int mode2 = MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f54a.getMinHeight(this)), MeasureSpec.getSize(i2)), mode2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setBackgroundColor(int i) {
        f54a.setBackgroundColor(this, i);
    }

    public void setCardBackgroundColor(int i) {
        f54a.setBackgroundColor(this, i);
    }

    public void setCardElevation(float f) {
        f54a.setElevation(this, f);
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.f58e.set(i, i2, i3, i4);
        f54a.updatePadding(this);
    }

    public void setMaxCardElevation(float f) {
        f54a.setMaxElevation(this, f);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f57d) {
            this.f57d = z;
            f54a.onPreventCornerOverlapChanged(this);
        }
    }

    public void setRadius(float f) {
        f54a.setRadius(this, f);
    }

    public void setShadowPadding(int i, int i2, int i3, int i4) {
        this.f59f.set(i, i2, i3, i4);
        super.setPadding(i + this.f58e.left, i2 + this.f58e.top, i3 + this.f58e.right, i4 + this.f58e.bottom);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f56c != z) {
            this.f56c = z;
            f54a.onCompatPaddingChanged(this);
        }
    }
}
