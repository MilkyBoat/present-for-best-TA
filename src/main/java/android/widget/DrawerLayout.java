package android.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import android.widget.ViewDragHelper.Callback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class DrawerLayout extends ViewGroup implements DrawerLayoutImpl {
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNLOCKED = 0;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: a */
    static final DrawerLayoutCompatImpl f86a = (VERSION.SDK_INT >= 21 ? new DrawerLayoutCompatImplApi21() : new DrawerLayoutCompatImplBase());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int[] f87b = {16842931};

    /* renamed from: c */
    private static final boolean f88c = (VERSION.SDK_INT >= 19);

    /* renamed from: d */
    private static final boolean f89d;

    /* renamed from: A */
    private Drawable f90A;

    /* renamed from: B */
    private CharSequence f91B;

    /* renamed from: C */
    private CharSequence f92C;

    /* renamed from: D */
    private Object f93D;

    /* renamed from: E */
    private boolean f94E;

    /* renamed from: F */
    private Drawable f95F;

    /* renamed from: G */
    private Drawable f96G;

    /* renamed from: H */
    private Drawable f97H;

    /* renamed from: I */
    private Drawable f98I;

    /* renamed from: J */
    private final ArrayList<View> f99J;

    /* renamed from: e */
    private final AccessibilityDelegate f100e;

    /* renamed from: f */
    private float f101f;

    /* renamed from: g */
    private int f102g;

    /* renamed from: h */
    private int f103h;

    /* renamed from: i */
    private float f104i;

    /* renamed from: j */
    private Paint f105j;

    /* renamed from: k */
    private final ViewDragHelper f106k;

    /* renamed from: l */
    private final ViewDragHelper f107l;

    /* renamed from: m */
    private final ViewDragCallback f108m;

    /* renamed from: n */
    private final ViewDragCallback f109n;

    /* renamed from: o */
    private int f110o;

    /* renamed from: p */
    private boolean f111p;

    /* renamed from: q */
    private boolean f112q;

    /* renamed from: r */
    private int f113r;

    /* renamed from: s */
    private int f114s;

    /* renamed from: t */
    private boolean f115t;

    /* renamed from: u */
    private boolean f116u;

    /* renamed from: v */
    private DrawerListener f117v;

    /* renamed from: w */
    private float f118w;

    /* renamed from: x */
    private float f119x;

    /* renamed from: y */
    private Drawable f120y;

    /* renamed from: z */
    private Drawable f121z;

    @SuppressLint({"NewApi"})
    public static class DrawerLayoutCompatApi21 {

        /* renamed from: a */
        private static final int[] f122a = {16843828};

        static class InsetsListener implements OnApplyWindowInsetsListener {
            InsetsListener() {
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                ((DrawerLayoutImpl) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                return windowInsets.consumeSystemWindowInsets();
            }
        }

        public static void applyMarginInsets(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            WindowInsets windowInsets = (WindowInsets) obj;
            if (i == 3) {
                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
            } else if (i == 5) {
                windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            }
            marginLayoutParams.leftMargin = windowInsets.getSystemWindowInsetLeft();
            marginLayoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
            marginLayoutParams.rightMargin = windowInsets.getSystemWindowInsetRight();
            marginLayoutParams.bottomMargin = windowInsets.getSystemWindowInsetBottom();
        }

        public static void configureApplyInsets(View view) {
            if (view instanceof DrawerLayoutImpl) {
                view.setOnApplyWindowInsetsListener(new InsetsListener());
                view.setSystemUiVisibility(1280);
            }
        }

        public static void dispatchChildInsets(View view, Object obj, int i) {
            WindowInsets windowInsets = (WindowInsets) obj;
            if (i == 3) {
                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
            } else if (i == 5) {
                windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            }
            view.dispatchApplyWindowInsets(windowInsets);
        }

        public static Drawable getDefaultStatusBarBackground(Context context) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f122a);
            try {
                return obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public static int getTopInset(Object obj) {
            if (obj != null) {
                return ((WindowInsets) obj).getSystemWindowInsetTop();
            }
            return 0;
        }
    }

    interface DrawerLayoutCompatImpl {
        void applyMarginInsets(MarginLayoutParams marginLayoutParams, Object obj, int i);

        void configureApplyInsets(View view);

        void dispatchChildInsets(View view, Object obj, int i);

        Drawable getDefaultStatusBarBackground(Context context);

        int getTopInset(Object obj);
    }

    @SuppressLint({"NewApi"})
    static class DrawerLayoutCompatImplApi21 implements DrawerLayoutCompatImpl {
        DrawerLayoutCompatImplApi21() {
        }

        public void applyMarginInsets(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            DrawerLayoutCompatApi21.applyMarginInsets(marginLayoutParams, obj, i);
        }

        public void configureApplyInsets(View view) {
            DrawerLayoutCompatApi21.configureApplyInsets(view);
        }

        public void dispatchChildInsets(View view, Object obj, int i) {
            DrawerLayoutCompatApi21.dispatchChildInsets(view, obj, i);
        }

        public Drawable getDefaultStatusBarBackground(Context context) {
            return DrawerLayoutCompatApi21.getDefaultStatusBarBackground(context);
        }

        public int getTopInset(Object obj) {
            return DrawerLayoutCompatApi21.getTopInset(obj);
        }
    }

    @SuppressLint({"NewApi"})
    static class DrawerLayoutCompatImplBase implements DrawerLayoutCompatImpl {
        DrawerLayoutCompatImplBase() {
        }

        public void applyMarginInsets(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        public void configureApplyInsets(View view) {
        }

        public void dispatchChildInsets(View view, Object obj, int i) {
        }

        public Drawable getDefaultStatusBarBackground(Context context) {
            return null;
        }

        public int getTopInset(Object obj) {
            return 0;
        }
    }

    public interface DrawerListener {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);

        void onDrawerStateChanged(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface EdgeGravity {
    }

    public static class LayoutParams extends MarginLayoutParams {

        /* renamed from: a */
        float f123a;

        /* renamed from: b */
        boolean f124b;

        /* renamed from: c */
        boolean f125c;
        public int gravity;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 0;
        }

        public LayoutParams(int i, int i2, int i3) {
            this(i, i2);
            this.gravity = i3;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f87b);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface LockMode {
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        int f126a = 0;

        /* renamed from: b */
        int f127b = 0;

        /* renamed from: c */
        int f128c = 0;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f126a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f126a);
        }
    }

    public static abstract class SimpleDrawerListener implements DrawerListener {
        public void onDrawerClosed(View view) {
        }

        public void onDrawerOpened(View view) {
        }

        public void onDrawerSlide(View view, float f) {
        }

        public void onDrawerStateChanged(int i) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface State {
    }

    private class ViewDragCallback extends Callback {

        /* renamed from: b */
        private final int f130b;

        /* renamed from: c */
        private ViewDragHelper f131c;

        /* renamed from: d */
        private final Runnable f132d = new Runnable() {
            public void run() {
                ViewDragCallback.this.m59b();
            }
        };

        public ViewDragCallback(int i) {
            this.f130b = i;
        }

        /* renamed from: a */
        private void m57a() {
            int i = 3;
            if (this.f130b == 3) {
                i = 5;
            }
            View a = DrawerLayout.this.mo155a(i);
            if (a != null) {
                DrawerLayout.this.closeDrawer(a);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m59b() {
            View view;
            int i;
            int edgeSize = this.f131c.getEdgeSize();
            int i2 = 0;
            boolean z = this.f130b == 3;
            if (z) {
                view = DrawerLayout.this.mo155a(3);
                if (view != null) {
                    i2 = -view.getWidth();
                }
                i = i2 + edgeSize;
            } else {
                view = DrawerLayout.this.mo155a(5);
                i = DrawerLayout.this.getWidth() - edgeSize;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && DrawerLayout.this.getDrawerLockMode(view) == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                this.f131c.smoothSlideViewTo(view, i, view.getTop());
                layoutParams.f124b = true;
                DrawerLayout.this.invalidate();
                m57a();
                DrawerLayout.this.mo163b();
            }
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int width;
            int width2;
            if (DrawerLayout.this.mo160a(view, 3)) {
                width2 = -view.getWidth();
                width = 0;
            } else {
                width = DrawerLayout.this.getWidth();
                width2 = width - view.getWidth();
            }
            return Math.max(width2, Math.min(i, width));
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.mo175f(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
            DrawerLayout drawerLayout;
            int i3;
            if ((i & 1) == 1) {
                drawerLayout = DrawerLayout.this;
                i3 = 3;
            } else {
                drawerLayout = DrawerLayout.this;
                i3 = 5;
            }
            View a = drawerLayout.mo155a(i3);
            if (a != null && DrawerLayout.this.getDrawerLockMode(a) == 0) {
                this.f131c.captureChildView(a, i2);
            }
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f132d, 160);
        }

        public void onViewCaptured(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f124b = false;
            m57a();
        }

        public void onViewDragStateChanged(int i) {
            DrawerLayout.this.mo156a(this.f130b, i, this.f131c.getCapturedView());
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.mo160a(view, 3) ? (float) (i + width) : (float) (DrawerLayout.this.getWidth() - i)) / ((float) width);
            DrawerLayout.this.mo165b(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            float c = DrawerLayout.this.mo166c(view);
            int width = view.getWidth();
            if (DrawerLayout.this.mo160a(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && c > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && c > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f131c.settleCapturedViewAt(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public void removeCallbacks() {
            DrawerLayout.this.removeCallbacks(this.f132d);
        }

        public void setDragger(ViewDragHelper viewDragHelper) {
            this.f131c = viewDragHelper;
        }

        public boolean tryCaptureView(View view, int i) {
            return DrawerLayout.this.mo175f(view) && DrawerLayout.this.mo160a(view, this.f130b) && DrawerLayout.this.getDrawerLockMode(view) == 0;
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        f89d = z;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f100e = new AccessibilityDelegate();
        this.f103h = -1728053248;
        this.f105j = new Paint();
        this.f112q = true;
        this.f95F = null;
        this.f96G = null;
        this.f97H = null;
        this.f98I = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f102g = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.f108m = new ViewDragCallback(3);
        this.f109n = new ViewDragCallback(5);
        this.f106k = ViewDragHelper.create(this, 1.0f, this.f108m);
        this.f106k.setEdgeTrackingEnabled(1);
        this.f106k.setMinVelocity(f2);
        this.f108m.setDragger(this.f106k);
        this.f107l = ViewDragHelper.create(this, 1.0f, this.f109n);
        this.f107l.setEdgeTrackingEnabled(2);
        this.f107l.setMinVelocity(f2);
        this.f109n.setDragger(this.f107l);
        setFocusableInTouchMode(true);
        setImportantForAccessibility(1);
        setAccessibilityDelegate(new AccessibilityDelegate());
        setMotionEventSplittingEnabled(false);
        if (getFitsSystemWindows()) {
            f86a.configureApplyInsets(this);
            this.f120y = f86a.getDefaultStatusBarBackground(context);
        }
        this.f101f = f * 10.0f;
        this.f99J = new ArrayList<>();
    }

    /* renamed from: a */
    private void m32a(View view, boolean z) {
        int i;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((!z && !mo175f(childAt)) || (z && childAt == view)) {
                i = 1;
            } else if (VERSION.SDK_INT >= 19) {
                i = 4;
            }
            childAt.setImportantForAccessibility(i);
        }
    }

    /* renamed from: a */
    private boolean m33a(Drawable drawable, int i) {
        if (drawable == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 19 && !drawable.isAutoMirrored()) {
            return false;
        }
        setLayoutDirection(i);
        return true;
    }

    /* renamed from: b */
    static String m34b(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    /* renamed from: d */
    private void m36d() {
        if (!f89d) {
            this.f121z = m37e();
            this.f90A = m38f();
        }
    }

    /* renamed from: e */
    private Drawable m37e() {
        int layoutDirection = getLayoutDirection();
        if (layoutDirection == 0) {
            if (this.f95F != null) {
                m33a(this.f95F, layoutDirection);
                return this.f95F;
            }
        } else if (this.f96G != null) {
            m33a(this.f96G, layoutDirection);
            return this.f96G;
        }
        return this.f97H;
    }

    /* renamed from: f */
    private Drawable m38f() {
        int layoutDirection = getLayoutDirection();
        if (layoutDirection == 0) {
            if (this.f96G != null) {
                m33a(this.f96G, layoutDirection);
                return this.f96G;
            }
        } else if (this.f95F != null) {
            m33a(this.f95F, layoutDirection);
            return this.f95F;
        }
        return this.f98I;
    }

    /* renamed from: g */
    private boolean m39g() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).f124b) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    private static boolean m40g(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* renamed from: h */
    private boolean m41h() {
        return m42i() != null;
    }

    /* renamed from: i */
    private View m42i() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (mo175f(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public View mo154a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((LayoutParams) childAt.getLayoutParams()).f125c) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public View mo155a(int i) {
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection()) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((mo172d(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo156a(int i, int i2, View view) {
        int viewDragState = this.f106k.getViewDragState();
        int viewDragState2 = this.f107l.getViewDragState();
        int i3 = 2;
        if (viewDragState == 1 || viewDragState2 == 1) {
            i3 = 1;
        } else if (!(viewDragState == 2 || viewDragState2 == 2)) {
            i3 = 0;
        }
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f123a == 0.0f) {
                mo157a(view);
            } else if (layoutParams.f123a == 1.0f) {
                mo164b(view);
            }
        }
        if (i3 != this.f110o) {
            this.f110o = i3;
            if (this.f117v != null) {
                this.f117v.onDrawerStateChanged(i3);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo157a(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f125c) {
            layoutParams.f125c = false;
            if (this.f117v != null) {
                this.f117v.onDrawerClosed(view);
            }
            m32a(view, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo158a(View view, float f) {
        if (this.f117v != null) {
            this.f117v.onDrawerSlide(view, f);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo159a(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (mo175f(childAt) && (!z || layoutParams.f124b)) {
                z2 |= mo160a(childAt, 3) ? this.f106k.smoothSlideViewTo(childAt, -childAt.getWidth(), childAt.getTop()) : this.f107l.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                layoutParams.f124b = false;
            }
        }
        this.f108m.removeCallbacks();
        this.f109n.removeCallbacks();
        if (z2) {
            invalidate();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo160a(View view, int i) {
        return (mo172d(view) & i) == i;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!mo175f(childAt)) {
                    this.f99J.add(childAt);
                } else if (isDrawerOpen(childAt)) {
                    childAt.addFocusables(arrayList, i, i2);
                    z = true;
                }
            }
            if (!z) {
                int size = this.f99J.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = (View) this.f99J.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.f99J.clear();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addView(android.view.View r1, int r2, android.view.ViewGroup.LayoutParams r3) {
        /*
            r0 = this;
            super.addView(r1, r2, r3)
            android.view.View r2 = r0.mo154a()
            if (r2 != 0) goto L_0x0015
            boolean r2 = r0.mo175f(r1)
            if (r2 == 0) goto L_0x0010
            goto L_0x0015
        L_0x0010:
            r2 = 1
        L_0x0011:
            r1.setImportantForAccessibility(r2)
            goto L_0x001d
        L_0x0015:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 19
            if (r2 < r3) goto L_0x001d
            r2 = 4
            goto L_0x0011
        L_0x001d:
            boolean r2 = f88c
            if (r2 != 0) goto L_0x0026
            android.view.View$AccessibilityDelegate r2 = r0.f100e
            r1.setAccessibilityDelegate(r2)
        L_0x0026:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.DrawerLayout.addView(android.view.View, int, android.view.ViewGroup$LayoutParams):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo163b() {
        if (!this.f116u) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f116u = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo164b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f125c) {
            layoutParams.f125c = true;
            if (this.f117v != null) {
                this.f117v.onDrawerOpened(view);
            }
            m32a(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
            view.requestFocus();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo165b(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.f123a) {
            layoutParams.f123a = f;
            mo158a(view, f);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public float mo166c(View view) {
        return ((LayoutParams) view.getLayoutParams()).f123a;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void closeDrawer(int i) {
        View a = mo155a(i);
        if (a == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No drawer view found with gravity ");
            sb.append(m34b(i));
            throw new IllegalArgumentException(sb.toString());
        }
        closeDrawer(a);
    }

    public void closeDrawer(View view) {
        ViewDragHelper viewDragHelper;
        int width;
        if (!mo175f(view)) {
            StringBuilder sb = new StringBuilder();
            sb.append("View ");
            sb.append(view);
            sb.append(" is not a sliding drawer");
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.f112q) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f123a = 0.0f;
            layoutParams.f125c = false;
        } else {
            if (mo160a(view, 3)) {
                viewDragHelper = this.f106k;
                width = -view.getWidth();
            } else {
                viewDragHelper = this.f107l;
                width = getWidth();
            }
            viewDragHelper.smoothSlideViewTo(view, width, view.getTop());
        }
        invalidate();
    }

    public void closeDrawers() {
        mo159a(false);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f123a);
        }
        this.f104i = f;
        if (this.f106k.continueSettling(true) || this.f107l.continueSettling(true)) {
            postInvalidateOnAnimation();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo172d(View view) {
        return Gravity.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, getLayoutDirection());
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int i2;
        Drawable drawable;
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean e = mo174e(view2);
        int width = getWidth();
        int save = canvas2.save();
        if (e) {
            int childCount = getChildCount();
            i = width;
            i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view2 && childAt.getVisibility() == 0 && m40g(childAt) && mo175f(childAt) && childAt.getHeight() >= height) {
                    if (mo160a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < i) {
                            i = left;
                        }
                    }
                }
            }
            canvas2.clipRect(i2, 0, i, getHeight());
        } else {
            i = width;
            i2 = 0;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas2.restoreToCount(save);
        if (this.f104i <= 0.0f || !e) {
            if (this.f121z != null && mo160a(view2, 3)) {
                int intrinsicWidth = this.f121z.getIntrinsicWidth();
                int right2 = view.getRight();
                float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.f106k.getEdgeSize()), 1.0f));
                this.f121z.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
                this.f121z.setAlpha((int) (max * 255.0f));
                drawable = this.f121z;
            } else if (this.f90A == null || !mo160a(view2, 5)) {
                return drawChild;
            } else {
                int intrinsicWidth2 = this.f90A.getIntrinsicWidth();
                int left2 = view.getLeft();
                float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.f107l.getEdgeSize()), 1.0f));
                this.f90A.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.f90A.setAlpha((int) (max2 * 255.0f));
                drawable = this.f90A;
            }
            drawable.draw(canvas2);
            return drawChild;
        }
        this.f105j.setColor((((int) (((float) ((this.f103h & -16777216) >>> 24)) * this.f104i)) << 24) | (this.f103h & 16777215));
        canvas2.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.f105j);
        return drawChild;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo174e(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo175f(View view) {
        return (Gravity.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, view.getLayoutDirection()) & 7) != 0;
    }

    /* access modifiers changed from: protected */
    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (f89d) {
            return this.f101f;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int i) {
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        if (absoluteGravity == 3) {
            return this.f113r;
        }
        if (absoluteGravity == 5) {
            return this.f114s;
        }
        return 0;
    }

    public int getDrawerLockMode(View view) {
        int d = mo172d(view);
        if (d == 3) {
            return this.f113r;
        }
        if (d == 5) {
            return this.f114s;
        }
        return 0;
    }

    public CharSequence getDrawerTitle(int i) {
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        if (absoluteGravity == 3) {
            return this.f91B;
        }
        if (absoluteGravity == 5) {
            return this.f92C;
        }
        return null;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f120y;
    }

    public boolean isDrawerOpen(int i) {
        View a = mo155a(i);
        if (a != null) {
            return isDrawerOpen(a);
        }
        return false;
    }

    public boolean isDrawerOpen(View view) {
        if (mo175f(view)) {
            return ((LayoutParams) view.getLayoutParams()).f125c;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a drawer");
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean isDrawerVisible(int i) {
        View a = mo155a(i);
        if (a != null) {
            return isDrawerVisible(a);
        }
        return false;
    }

    public boolean isDrawerVisible(View view) {
        if (mo175f(view)) {
            return ((LayoutParams) view.getLayoutParams()).f123a > 0.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a drawer");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f112q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f112q = true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f94E && this.f120y != null) {
            int topInset = f86a.getTopInset(this.f93D);
            if (topInset > 0) {
                this.f120y.setBounds(0, 0, getWidth(), topInset);
                this.f120y.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean shouldInterceptTouchEvent = this.f106k.shouldInterceptTouchEvent(motionEvent) | this.f107l.shouldInterceptTouchEvent(motionEvent);
        boolean z2 = true;
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f118w = x;
                this.f119x = y;
                if (this.f104i > 0.0f) {
                    View findTopChildUnder = this.f106k.findTopChildUnder((int) x, (int) y);
                    if (findTopChildUnder != null && mo174e(findTopChildUnder)) {
                        z = true;
                        this.f115t = false;
                        this.f116u = false;
                        break;
                    }
                }
                z = false;
                this.f115t = false;
                this.f116u = false;
            case 1:
            case 3:
                mo159a(true);
                this.f115t = false;
                this.f116u = false;
                break;
            case 2:
                if (this.f106k.checkTouchSlop(3)) {
                    this.f108m.removeCallbacks();
                    this.f109n.removeCallbacks();
                    break;
                }
                break;
        }
        z = false;
        if (!shouldInterceptTouchEvent && !z && !m39g()) {
            if (this.f116u) {
                return true;
            }
            z2 = false;
        }
        return z2;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m41h()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View i2 = m42i();
        if (i2 != null && getDrawerLockMode(i2) == 0) {
            closeDrawers();
        }
        return i2 != null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        this.f111p = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (mo174e(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (mo160a(childAt, 3)) {
                        float f2 = (float) measuredWidth;
                        i5 = (-measuredWidth) + ((int) (layoutParams.f123a * f2));
                        f = ((float) (measuredWidth + i5)) / f2;
                    } else {
                        float f3 = (float) measuredWidth;
                        int i8 = i6 - ((int) (layoutParams.f123a * f3));
                        f = ((float) (i6 - i8)) / f3;
                        i5 = i8;
                    }
                    boolean z2 = f != layoutParams.f123a;
                    int i9 = layoutParams.gravity & 112;
                    if (i9 == 16) {
                        int i10 = i4 - i2;
                        int i11 = (i10 - measuredHeight) / 2;
                        if (i11 < layoutParams.topMargin) {
                            i11 = layoutParams.topMargin;
                        } else if (i11 + measuredHeight > i10 - layoutParams.bottomMargin) {
                            i11 = (i10 - layoutParams.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i5, i11, measuredWidth + i5, measuredHeight + i11);
                    } else if (i9 != 80) {
                        childAt.layout(i5, layoutParams.topMargin, measuredWidth + i5, layoutParams.topMargin + measuredHeight);
                    } else {
                        int i12 = i4 - i2;
                        childAt.layout(i5, (i12 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i12 - layoutParams.bottomMargin);
                    }
                    if (z2) {
                        mo165b(childAt, f);
                    }
                    int i13 = layoutParams.f123a > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i13) {
                        childAt.setVisibility(i13);
                    }
                }
            }
        }
        this.f111p = false;
        this.f112q = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int childMeasureSpec;
        int childMeasureSpec2;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        boolean z = this.f93D != null && getFitsSystemWindows();
        int layoutDirection = getLayoutDirection();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(layoutParams.gravity, layoutDirection);
                    if (childAt.getFitsSystemWindows()) {
                        f86a.dispatchChildInsets(childAt, this.f93D, absoluteGravity);
                    } else {
                        f86a.applyMarginInsets(layoutParams, this.f93D, absoluteGravity);
                    }
                }
                if (mo174e(childAt)) {
                    childMeasureSpec = MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824);
                    childMeasureSpec2 = MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824);
                } else if (mo175f(childAt)) {
                    if (f89d && childAt.getElevation() != this.f101f) {
                        childAt.setElevation(this.f101f);
                    }
                    int d = mo172d(childAt) & 7;
                    if ((0 & d) != 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Child drawer has absolute gravity ");
                        sb.append(m34b(d));
                        sb.append(" but this ");
                        sb.append("DrawerLayout");
                        sb.append(" already has a drawer view along that edge");
                        throw new IllegalStateException(sb.toString());
                    }
                    childMeasureSpec = getChildMeasureSpec(i, this.f102g + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width);
                    childMeasureSpec2 = getChildMeasureSpec(i2, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Child ");
                    sb2.append(childAt);
                    sb2.append(" at index ");
                    sb2.append(i3);
                    sb2.append(" does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    throw new IllegalStateException(sb2.toString());
                }
                childAt.measure(childMeasureSpec, childMeasureSpec2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f126a != 0) {
            View a = mo155a(savedState.f126a);
            if (a != null) {
                openDrawer(a);
            }
        }
        setDrawerLockMode(savedState.f127b, 3);
        setDrawerLockMode(savedState.f128c, 5);
    }

    public void onRtlPropertiesChanged(int i) {
        m36d();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        View a = mo154a();
        if (a != null) {
            savedState.f126a = ((LayoutParams) a.getLayoutParams()).gravity;
        }
        savedState.f127b = this.f113r;
        savedState.f128c = this.f114s;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        this.f106k.processTouchEvent(motionEvent);
        this.f107l.processTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 3) {
            switch (action) {
                case 0:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.f118w = x;
                    this.f119x = y;
                    break;
                case 1:
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    View findTopChildUnder = this.f106k.findTopChildUnder((int) x2, (int) y2);
                    if (findTopChildUnder != null && mo174e(findTopChildUnder)) {
                        float f = x2 - this.f118w;
                        float f2 = y2 - this.f119x;
                        int touchSlop = this.f106k.getTouchSlop();
                        if ((f * f) + (f2 * f2) < ((float) (touchSlop * touchSlop))) {
                            View a = mo154a();
                            if (!(a == null || getDrawerLockMode(a) == 2)) {
                                z = false;
                                mo159a(z);
                                this.f115t = false;
                                return true;
                            }
                        }
                    }
                    z = true;
                    mo159a(z);
                    this.f115t = false;
                    return true;
                default:
                    return true;
            }
        } else {
            mo159a(true);
        }
        this.f115t = false;
        this.f116u = false;
        return true;
    }

    public void openDrawer(int i) {
        View a = mo155a(i);
        if (a == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No drawer view found with gravity ");
            sb.append(m34b(i));
            throw new IllegalArgumentException(sb.toString());
        }
        openDrawer(a);
    }

    public void openDrawer(View view) {
        ViewDragHelper viewDragHelper;
        int width;
        if (!mo175f(view)) {
            StringBuilder sb = new StringBuilder();
            sb.append("View ");
            sb.append(view);
            sb.append(" is not a sliding drawer");
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.f112q) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f123a = 1.0f;
            layoutParams.f125c = true;
            m32a(view, true);
        } else {
            if (mo160a(view, 3)) {
                viewDragHelper = this.f106k;
                width = 0;
            } else {
                viewDragHelper = this.f107l;
                width = getWidth() - view.getWidth();
            }
            viewDragHelper.smoothSlideViewTo(view, width, view.getTop());
        }
        invalidate();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f115t = z;
        if (z) {
            mo159a(true);
        }
    }

    public void requestLayout() {
        if (!this.f111p) {
            super.requestLayout();
        }
    }

    public void setChildInsets(Object obj, boolean z) {
        this.f93D = obj;
        this.f94E = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.f101f = f;
        if (VERSION.SDK_INT >= 21) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (mo175f(childAt)) {
                    childAt.setElevation(this.f101f);
                }
            }
        }
    }

    public void setDrawerListener(DrawerListener drawerListener) {
        this.f117v = drawerListener;
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerLockMode(int i, int i2) {
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, getLayoutDirection());
        if (absoluteGravity == 3) {
            this.f113r = i;
        } else if (absoluteGravity == 5) {
            this.f114s = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.f106k : this.f107l).cancel();
        }
        switch (i) {
            case 1:
                View a = mo155a(absoluteGravity);
                if (a != null) {
                    closeDrawer(a);
                    break;
                }
                break;
            case 2:
                View a2 = mo155a(absoluteGravity);
                if (a2 != null) {
                    openDrawer(a2);
                    return;
                }
                break;
            default:
                return;
        }
    }

    public void setDrawerLockMode(int i, View view) {
        if (!mo175f(view)) {
            StringBuilder sb = new StringBuilder();
            sb.append("View ");
            sb.append(view);
            sb.append(" is not a drawer with appropriate layout_gravity");
            throw new IllegalArgumentException(sb.toString());
        }
        setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).gravity);
    }

    public void setDrawerShadow(int i, int i2) {
        setDrawerShadow(getResources().getDrawable(i), i2);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (!f89d) {
            if ((i & 8388611) == 8388611) {
                this.f95F = drawable;
            } else if ((i & 8388613) == 8388613) {
                this.f96G = drawable;
            } else if ((i & 3) == 3) {
                this.f97H = drawable;
            } else {
                if ((i & 5) == 5) {
                    this.f98I = drawable;
                }
            }
            m36d();
            invalidate();
        }
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        if (absoluteGravity == 3) {
            this.f91B = charSequence;
            return;
        }
        if (absoluteGravity == 5) {
            this.f92C = charSequence;
        }
    }

    public void setScrimColor(int i) {
        this.f103h = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.f120y = i != 0 ? getContext().getResources().getDrawable(i) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f120y = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f120y = new ColorDrawable(i);
        invalidate();
    }
}
