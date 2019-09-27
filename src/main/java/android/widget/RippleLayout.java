package android.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

public class RippleLayout extends FrameLayout {

    /* renamed from: a */
    private int f387a;

    /* renamed from: b */
    private int f388b;

    /* renamed from: c */
    private int f389c = 1152035498;

    /* renamed from: d */
    private boolean f390d;

    /* renamed from: e */
    private boolean f391e;

    /* renamed from: f */
    private int f392f;

    public RippleLayout(Context context) {
        super(context);
    }

    private void setRippleDrawable(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (!(childAt instanceof RippleLayout)) {
                    setRippleDrawable(childAt);
                }
            }
            return;
        }
        Drawable background = view.getBackground();
        RippleHelper rippleHelper = background instanceof RippleHelper ? (RippleHelper) background : new RippleHelper(view);
        rippleHelper.setRippleColor(this.f389c);
        rippleHelper.setRippleLineColor(this.f392f);
        rippleHelper.setCircle(this.f390d);
        rippleHelper.setSingle(this.f391e);
    }

    public boolean isCircle() {
        return this.f390d;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f388b = getChildCount();
        if (this.f387a != this.f388b) {
            this.f387a = this.f388b;
            setRippleDrawable(this);
        }
    }

    public void setCircle(boolean z) {
        this.f390d = z;
    }

    public void setRippleColor(int i) {
        this.f389c = i;
    }

    public void setRippleLineColor(int i) {
        this.f392f = i;
    }

    public void setSingle(boolean z) {
        this.f391e = z;
    }
}
