package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class PageLayout extends HorizontalScrollView {

    /* renamed from: a */
    private int f184a = 0;

    /* renamed from: b */
    private LinearLayout f185b;

    /* renamed from: c */
    private OnPageChangeListener f186c;

    /* renamed from: d */
    private int f187d;

    /* renamed from: e */
    private Scroller f188e;

    /* renamed from: f */
    private int f189f;

    /* renamed from: g */
    private int f190g;

    /* renamed from: h */
    private int f191h;

    /* renamed from: i */
    private VelocityTracker f192i;

    /* renamed from: j */
    private int f193j;

    /* renamed from: k */
    private int f194k;

    public interface OnPageChangeListener {
        void onPageChange(View view, int i);
    }

    public PageLayout(Context context) {
        super(context);
        m107a(context);
    }

    public PageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m107a(context);
    }

    /* renamed from: a */
    private void m106a() {
        if (this.f192i != null) {
            this.f192i.recycle();
            this.f192i = null;
        }
    }

    /* renamed from: a */
    private void m107a(Context context) {
        setHorizontalScrollBarEnabled(false);
        this.f194k = context.getResources().getDisplayMetrics().widthPixels;
        this.f184a = this.f194k / 2;
        this.f185b = new LinearLayout(context);
        super.addView(this.f185b);
        this.f188e = new Scroller(getContext());
        setFocusable(true);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f189f = viewConfiguration.getScaledTouchSlop();
        this.f190g = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f191h = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    /* renamed from: a */
    private void m108a(MotionEvent motionEvent) {
        if (this.f192i == null) {
            this.f192i = VelocityTracker.obtain();
        }
        this.f192i.addMovement(motionEvent);
    }

    public void addView(View view) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(view);
        this.f185b.addView(frameLayout);
    }

    public void addView(View view, LayoutParams layoutParams) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(view, layoutParams);
        this.f185b.addView(frameLayout);
    }

    public View getPage(int i) {
        return this.f185b.getChildAt(i);
    }

    public int getTouchScale() {
        return this.f184a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getX() < ((float) this.f184a) || motionEvent.getX() > ((float) (this.f194k - this.f184a))) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            showPage(this.f187d);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int measuredWidth = getMeasuredWidth();
        int childCount = this.f185b.getChildCount();
        if (!(this.f193j == childCount && this.f194k == measuredWidth)) {
            this.f193j = childCount;
            this.f194k = measuredWidth;
            for (int i3 = 0; i3 < childCount; i3++) {
                ViewGroup viewGroup = (ViewGroup) this.f185b.getChildAt(i3);
                LayoutParams layoutParams = viewGroup.getLayoutParams();
                layoutParams.width = this.f194k;
                viewGroup.setLayoutParams(layoutParams);
                viewGroup.requestLayout();
            }
            LayoutParams layoutParams2 = this.f185b.getLayoutParams();
            layoutParams2.width = this.f194k * childCount;
            this.f185b.setLayoutParams(layoutParams2);
            this.f185b.requestLayout();
            requestLayout();
        }
        super.onMeasure(i, i2);
        showPage(this.f187d);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        m108a(motionEvent);
        if (action != 1) {
            return super.onTouchEvent(motionEvent);
        }
        VelocityTracker velocityTracker = this.f192i;
        velocityTracker.computeCurrentVelocity(1000, (float) this.f191h);
        int yVelocity = (int) velocityTracker.getYVelocity();
        int xVelocity = (int) velocityTracker.getXVelocity();
        m106a();
        int abs = Math.abs(xVelocity);
        int abs2 = Math.abs(yVelocity);
        if (abs <= this.f190g || abs <= abs2) {
            int scrollX = getScrollX();
            showPage(scrollX % this.f194k < this.f194k / 2 ? scrollX / this.f194k : (scrollX / this.f194k) + 1);
            return true;
        }
        showPage(xVelocity > 0 ? Math.max(0, this.f187d - 1) : Math.min(this.f185b.getChildCount() - 1, this.f187d + 1));
        return true;
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f186c = onPageChangeListener;
    }

    public void setTouchScale(int i) {
        this.f184a = i;
    }

    public void showPage(int i) {
        smoothScrollTo(this.f194k * i, 0);
        if (!(this.f186c == null || this.f187d == i)) {
            this.f186c.onPageChange(this, i);
        }
        this.f187d = i;
    }

    public void showPage(View view) {
        int childCount = this.f185b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (this.f185b.getChildAt(i).equals(view)) {
                showPage(i);
            }
        }
    }
}
