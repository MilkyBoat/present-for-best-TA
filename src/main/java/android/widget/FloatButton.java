package android.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.androlua.C0364R;

public class FloatButton extends ImageView {

    /* renamed from: a */
    private PopupWindow f134a;

    /* renamed from: b */
    private CircleImageView f135b;

    /* renamed from: c */
    private int f136c;

    /* renamed from: d */
    private CardView f137d;

    /* renamed from: e */
    private DisplayMetrics f138e;

    /* renamed from: f */
    private RippleHelper f139f;

    public FloatButton(Context context) {
        super(context);
        m61a(context);
    }

    /* renamed from: a */
    private int m60a(float f) {
        return (int) TypedValue.applyDimension(1, f, this.f138e);
    }

    /* renamed from: a */
    private void m61a(Context context) {
        this.f138e = context.getResources().getDisplayMetrics();
        FrameLayout frameLayout = new FrameLayout(context);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.setMargins(m60a(16.0f), m60a(16.0f), m60a(16.0f), m60a(16.0f));
        this.f137d = new CardView(context);
        this.f137d.setCardElevation((float) m60a(8.0f));
        this.f135b = new CircleImageView(context);
        this.f135b.setImageResource(C0364R.drawable.icon);
        this.f139f = new RippleHelper(this.f135b);
        LayoutParams layoutParams2 = new LayoutParams(m60a(64.0f), m60a(64.0f));
        frameLayout.addView(this.f137d, layoutParams);
        this.f137d.addView(this.f135b, layoutParams2);
        this.f137d.setRadius((float) m60a(32.0f));
        this.f134a = new PopupWindow(-2, -2);
        this.f134a.setContentView(frameLayout);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i, i2);
        if (!this.f134a.isShowing()) {
            this.f134a.showAtLocation((View) getParent(), this.f136c, 0, 0);
        }
        this.f134a.update();
    }

    public void setGravity(int i) {
        this.f136c = i;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f135b.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f135b.setImageDrawable(drawable);
    }

    public void setImageResource(int i) {
        this.f135b.setImageResource(i);
    }

    public void setRippleColor(int i) {
        this.f139f.setRippleColor(i);
    }
}
