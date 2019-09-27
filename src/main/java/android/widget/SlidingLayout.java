package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class SlidingLayout extends HorizontalScrollView {

    /* renamed from: a */
    private int f419a;

    /* renamed from: b */
    private int f420b = 0;

    /* renamed from: c */
    private int f421c = 0;

    /* renamed from: d */
    private int f422d = 0;

    /* renamed from: e */
    private boolean f423e;

    /* renamed from: f */
    private boolean f424f;

    /* renamed from: g */
    private LinearLayout f425g;

    /* renamed from: h */
    private OnMenuOpenedListener f426h;

    /* renamed from: i */
    private OnMenuClosedListener f427i;

    /* renamed from: j */
    private OnMenuStateChangeListener f428j;

    /* renamed from: k */
    private boolean f429k;

    public interface OnMenuClosedListener {
        void onMenuClosed(View view);
    }

    public interface OnMenuOpenedListener {
        void onMenuOpened(View view);
    }

    public interface OnMenuStateChangeListener {
        void onMenuStateChange(View view, boolean z);
    }

    public SlidingLayout(Context context) {
        super(context);
        m228a(context);
    }

    public SlidingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m228a(context);
    }

    /* renamed from: a */
    private void m228a(Context context) {
        setHorizontalScrollBarEnabled(false);
        this.f419a = context.getResources().getDisplayMetrics().widthPixels;
        this.f420b = this.f419a / 10;
        this.f425g = new LinearLayout(context);
        super.addView(this.f425g);
    }

    public void addView(View view) {
        this.f425g.addView(view);
    }

    public void addView(View view, LayoutParams layoutParams) {
        this.f425g.addView(view, layoutParams);
    }

    public void closeMenu() {
        smoothScrollTo(this.f421c, 0);
        if (this.f424f && this.f427i != null) {
            this.f427i.onMenuClosed(this);
        }
        this.f424f = false;
    }

    public int getMenuWidth() {
        return this.f421c;
    }

    public int getTouchScale() {
        return this.f420b;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f424f || motionEvent.getX() < ((float) this.f420b)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (!this.f423e) {
                scrollTo(this.f421c, 0);
            } else {
                closeMenu();
            }
            this.f423e = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!this.f423e) {
            View childAt = this.f425g.getChildAt(0);
            View childAt2 = this.f425g.getChildAt(1);
            LayoutParams layoutParams = childAt.getLayoutParams();
            if (this.f421c == 0 && layoutParams.width < 0) {
                layoutParams.width = (int) (((double) this.f419a) * 0.8d);
            }
            this.f421c = layoutParams.width;
            this.f422d = layoutParams.width / 2;
            childAt2.getLayoutParams().width = this.f419a;
            this.f425g.getLayoutParams().width = this.f419a + this.f421c;
        }
        if (this.f424f) {
            openMenu();
        } else {
            closeMenu();
        }
        super.onMeasure(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                int scrollX = getScrollX();
                if (!this.f424f ? ((double) scrollX) <= ((double) this.f422d) * 1.5d : scrollX <= this.f422d / 2) {
                    openMenu();
                } else {
                    closeMenu();
                }
                this.f429k = false;
                return true;
            case 2:
                if (!this.f429k && this.f428j != null) {
                    this.f428j.onMenuStateChange(this, this.f424f);
                }
                this.f429k = true;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void openMenu() {
        smoothScrollTo(0, 0);
        if (!this.f424f && this.f426h != null) {
            this.f426h.onMenuOpened(this);
        }
        this.f424f = true;
    }

    public void setMenuWidth(int i) {
        this.f421c = i;
    }

    public void setOnMenuClosedListener(OnMenuClosedListener onMenuClosedListener) {
        this.f427i = onMenuClosedListener;
    }

    public void setOnMenuOpenedListener(OnMenuOpenedListener onMenuOpenedListener) {
        this.f426h = onMenuOpenedListener;
    }

    public void setOnMenuStateChangeListener(OnMenuStateChangeListener onMenuStateChangeListener) {
        this.f428j = onMenuStateChangeListener;
    }

    public void setTouchScale(int i) {
        this.f420b = i;
    }

    public void toggle() {
        if (this.f424f) {
            closeMenu();
        } else {
            openMenu();
        }
    }
}
