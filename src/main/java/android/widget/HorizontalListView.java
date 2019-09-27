package android.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListView extends AdapterView<ListAdapter> {

    /* renamed from: A */
    private int f140A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f141B;

    /* renamed from: C */
    private boolean f142C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public OnClickListener f143D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public Rect f144E;

    /* renamed from: F */
    private int f145F;

    /* renamed from: G */
    private Drawable f146G;

    /* renamed from: H */
    private int f147H;

    /* renamed from: I */
    private DataSetObserver f148I;

    /* renamed from: J */
    private Runnable f149J;

    /* renamed from: a */
    protected Scroller f150a;

    /* renamed from: b */
    protected ListAdapter f151b;

    /* renamed from: c */
    protected int f152c;

    /* renamed from: d */
    protected int f153d;

    /* renamed from: e */
    private final DisplayMetrics f154e;

    /* renamed from: f */
    private final GestureListener f155f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public GestureDetector f156g;

    /* renamed from: h */
    private int f157h;

    /* renamed from: i */
    private List<Queue<View>> f158i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f159j;

    /* renamed from: k */
    private Rect f160k;

    /* renamed from: l */
    private View f161l;

    /* renamed from: m */
    private int f162m;

    /* renamed from: n */
    private Drawable f163n;

    /* renamed from: o */
    private Integer f164o;

    /* renamed from: p */
    private int f165p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f166q;

    /* renamed from: r */
    private int f167r;

    /* renamed from: s */
    private int f168s;

    /* renamed from: t */
    private RunningOutOfDataListener f169t;

    /* renamed from: u */
    private int f170u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f171v;

    /* renamed from: w */
    private OnScrollStateChangedListener f172w;

    /* renamed from: x */
    private ScrollState f173x;

    /* renamed from: y */
    private EdgeEffect f174y;

    /* renamed from: z */
    private EdgeEffect f175z;

    /* renamed from: android.widget.HorizontalListView$1 */
    class C00071 implements OnTouchListener {

        /* renamed from: a */
        final /* synthetic */ HorizontalListView f176a;

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f176a.f156g.onTouchEvent(motionEvent);
        }
    }

    private class GestureListener extends SimpleOnGestureListener {
        private GestureListener() {
        }

        /* synthetic */ GestureListener(HorizontalListView horizontalListView, C00071 r2) {
            this();
        }

        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.mo250a(motionEvent);
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            HorizontalListView.this.f144E = null;
            return HorizontalListView.this.mo251a(motionEvent, motionEvent2, f, f2);
        }

        public void onLongPress(MotionEvent motionEvent) {
            HorizontalListView.this.m94e();
            int a = HorizontalListView.this.m87c((int) motionEvent.getX(), (int) motionEvent.getY());
            if (a >= 0 && !HorizontalListView.this.f141B) {
                View childAt = HorizontalListView.this.getChildAt(a);
                OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.getOnItemLongClickListener();
                if (onItemLongClickListener != null) {
                    int e = HorizontalListView.this.f166q + a;
                    if (onItemLongClickListener.onItemLongClick(HorizontalListView.this, childAt, e, HorizontalListView.this.f151b.getItemId(e))) {
                        HorizontalListView.this.performHapticFeedback(0);
                    }
                }
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            HorizontalListView.this.f144E = null;
            HorizontalListView.this.m77a(Boolean.valueOf(true));
            HorizontalListView.this.setCurrentScrollState(ScrollState.SCROLL_STATE_TOUCH_SCROLL);
            HorizontalListView.this.m94e();
            HorizontalListView.this.f153d += (int) f;
            HorizontalListView.this.m103i(Math.round(f));
            HorizontalListView.this.requestLayout();
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            HorizontalListView.this.m94e();
            OnItemClickListener onItemClickListener = HorizontalListView.this.getOnItemClickListener();
            int a = HorizontalListView.this.m87c((int) motionEvent.getX(), (int) motionEvent.getY());
            if (a >= 0 && !HorizontalListView.this.f141B) {
                View childAt = HorizontalListView.this.getChildAt(a);
                int e = HorizontalListView.this.f166q + a;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(HorizontalListView.this, childAt, e, HorizontalListView.this.f151b.getItemId(e));
                    return true;
                }
            }
            if (HorizontalListView.this.f143D != null && !HorizontalListView.this.f141B) {
                HorizontalListView.this.f143D.onClick(HorizontalListView.this);
            }
            return false;
        }
    }

    @TargetApi(11)
    private static final class HoneycombPlus {
        static {
            if (VERSION.SDK_INT < 11) {
                throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
            }
        }

        private HoneycombPlus() {
        }

        public static void setFriction(Scroller scroller, float f) {
            if (scroller != null) {
                scroller.setFriction(f);
            }
        }
    }

    @TargetApi(14)
    private static final class IceCreamSandwichPlus {
        static {
            if (VERSION.SDK_INT < 14) {
                throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
            }
        }

        private IceCreamSandwichPlus() {
        }

        public static float getCurrVelocity(Scroller scroller) {
            return scroller.getCurrVelocity();
        }
    }

    public interface OnScrollStateChangedListener {

        public enum ScrollState {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING
        }

        void onScrollStateChanged(ScrollState scrollState);
    }

    public interface RunningOutOfDataListener {
        void onRunningOutOfData();
    }

    public HorizontalListView(Context context) {
        this(context, null);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f150a = new Scroller(getContext());
        this.f155f = new GestureListener(this, null);
        this.f158i = new ArrayList();
        this.f159j = false;
        this.f160k = new Rect();
        this.f161l = null;
        this.f162m = 0;
        this.f163n = null;
        this.f164o = null;
        this.f165p = Integer.MAX_VALUE;
        this.f169t = null;
        this.f170u = 0;
        this.f171v = false;
        this.f172w = null;
        this.f173x = ScrollState.SCROLL_STATE_IDLE;
        this.f141B = false;
        this.f142C = false;
        this.f145F = -2004318072;
        this.f148I = new DataSetObserver() {
            public void onChanged() {
                HorizontalListView.this.f159j = true;
                HorizontalListView.this.f171v = false;
                HorizontalListView.this.m94e();
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
            }

            public void onInvalidated() {
                HorizontalListView.this.f171v = false;
                HorizontalListView.this.m94e();
                HorizontalListView.this.m81b();
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
            }
        };
        this.f149J = new Runnable() {
            public void run() {
                HorizontalListView.this.requestLayout();
            }
        };
        this.f154e = context.getResources().getDisplayMetrics();
        this.f174y = new EdgeEffect(context);
        this.f175z = new EdgeEffect(context);
        this.f156g = new GestureDetector(context, this.f155f);
        m66a();
        setWillNotDraw(false);
        HoneycombPlus.setFriction(this.f150a, 0.009f);
    }

    /* renamed from: a */
    private int m62a(float f) {
        return (int) TypedValue.applyDimension(1, f, this.f154e);
    }

    /* renamed from: a */
    private void m66a() {
        this.f166q = -1;
        this.f167r = -1;
        this.f168s = -1;
        this.f157h = 0;
        this.f152c = 0;
        this.f153d = 0;
        this.f165p = Integer.MAX_VALUE;
        setCurrentScrollState(ScrollState.SCROLL_STATE_IDLE);
    }

    /* renamed from: a */
    private void m67a(int i) {
        this.f158i.clear();
        for (int i2 = 0; i2 < i; i2++) {
            this.f158i.add(new LinkedList());
        }
    }

    /* renamed from: a */
    private void m68a(int i, int i2) {
        while (i + i2 + this.f162m < getWidth() && this.f167r + 1 < this.f151b.getCount()) {
            this.f167r++;
            if (this.f166q < 0) {
                this.f166q = this.f167r;
            }
            View view = this.f151b.getView(this.f167r, m79b(this.f167r), this);
            m73a(view, -1);
            i += (this.f167r == 0 ? 0 : this.f162m) + view.getMeasuredWidth();
            m100g();
        }
    }

    /* renamed from: a */
    private void m69a(int i, View view) {
        int itemViewType = this.f151b.getItemViewType(i);
        if (m89c(itemViewType)) {
            ((Queue) this.f158i.get(itemViewType)).offer(view);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0082, code lost:
        if (r4.f175z.draw(r5) != false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003d, code lost:
        if (r4.f174y.draw(r5) != false) goto L_0x003f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m70a(android.graphics.Canvas r5) {
        /*
            r4 = this;
            android.widget.EdgeEffect r0 = r4.f174y
            r1 = 0
            if (r0 == 0) goto L_0x0046
            android.widget.EdgeEffect r0 = r4.f174y
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x0046
            boolean r0 = r4.m101h()
            if (r0 == 0) goto L_0x0046
            int r0 = r5.save()
            int r2 = r4.getHeight()
            r3 = -1028390912(0xffffffffc2b40000, float:-90.0)
            r5.rotate(r3, r1, r1)
            int r2 = -r2
            int r3 = r4.getPaddingBottom()
            int r2 = r2 + r3
            float r2 = (float) r2
            r5.translate(r2, r1)
            android.widget.EdgeEffect r1 = r4.f174y
            int r2 = r4.getRenderHeight()
            int r3 = r4.getRenderWidth()
            r1.setSize(r2, r3)
            android.widget.EdgeEffect r1 = r4.f174y
            boolean r1 = r1.draw(r5)
            if (r1 == 0) goto L_0x0042
        L_0x003f:
            r4.invalidate()
        L_0x0042:
            r5.restoreToCount(r0)
            return
        L_0x0046:
            android.widget.EdgeEffect r0 = r4.f175z
            if (r0 == 0) goto L_0x0085
            android.widget.EdgeEffect r0 = r4.f175z
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x0085
            boolean r0 = r4.m101h()
            if (r0 == 0) goto L_0x0085
            int r0 = r5.save()
            int r2 = r4.getWidth()
            r3 = 1119092736(0x42b40000, float:90.0)
            r5.rotate(r3, r1, r1)
            int r1 = r4.getPaddingTop()
            float r1 = (float) r1
            int r2 = -r2
            float r2 = (float) r2
            r5.translate(r1, r2)
            android.widget.EdgeEffect r1 = r4.f175z
            int r2 = r4.getRenderHeight()
            int r3 = r4.getRenderWidth()
            r1.setSize(r2, r3)
            android.widget.EdgeEffect r1 = r4.f175z
            boolean r1 = r1.draw(r5)
            if (r1 == 0) goto L_0x0042
            goto L_0x003f
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.HorizontalListView.m70a(android.graphics.Canvas):void");
    }

    /* renamed from: a */
    private void m71a(Canvas canvas, Rect rect) {
        if (this.f163n != null) {
            this.f163n.setBounds(rect);
            this.f163n.draw(canvas);
        }
    }

    /* renamed from: a */
    private void m72a(View view) {
        LayoutParams b = m80b(view);
        view.measure(b.width > 0 ? MeasureSpec.makeMeasureSpec(b.width, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0), ViewGroup.getChildMeasureSpec(this.f140A, getPaddingTop() + getPaddingBottom(), b.height));
    }

    /* renamed from: a */
    private void m73a(View view, int i) {
        addViewInLayout(view, i, m80b(view), true);
        m72a(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m77a(Boolean bool) {
        if (this.f142C != bool.booleanValue()) {
            for (View view = this; view.getParent() instanceof View; view = (View) view.getParent()) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.f142C = bool.booleanValue();
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    private View m79b(int i) {
        int itemViewType = this.f151b.getItemViewType(i);
        if (m89c(itemViewType)) {
            return (View) ((Queue) this.f158i.get(itemViewType)).poll();
        }
        return null;
    }

    /* renamed from: b */
    private LayoutParams m80b(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams == null ? new LayoutParams(-2, -1) : layoutParams;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m81b() {
        m66a();
        removeAllViewsInLayout();
        requestLayout();
    }

    /* renamed from: b */
    private void m82b(int i, int i2) {
        while ((i + i2) - this.f162m >= 0 && this.f166q >= 1) {
            this.f166q--;
            View view = this.f151b.getView(this.f166q, m79b(this.f166q), this);
            m73a(view, 0);
            i -= this.f166q == 0 ? view.getMeasuredWidth() : this.f162m + view.getMeasuredWidth();
            this.f157h -= i + i2 == 0 ? view.getMeasuredWidth() : view.getMeasuredWidth() + this.f162m;
        }
    }

    /* renamed from: b */
    private void m83b(Canvas canvas) {
        int childCount = getChildCount();
        Rect rect = this.f160k;
        this.f160k.top = getPaddingTop();
        this.f160k.bottom = this.f160k.top + getRenderHeight();
        for (int i = 0; i < childCount; i++) {
            if (i != childCount - 1 || !m102h(this.f167r)) {
                View childAt = getChildAt(i);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.f162m;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                m71a(canvas, rect);
                if (i == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    m71a(canvas, rect);
                }
            }
        }
    }

    /* renamed from: c */
    private float m86c() {
        if (VERSION.SDK_INT >= 14) {
            return IceCreamSandwichPlus.getCurrVelocity(this.f150a);
        }
        return 30.0f;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m87c(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getHitRect(this.f160k);
            if (this.f160k.contains(i, i2)) {
                return i3;
            }
        }
        return -1;
    }

    /* renamed from: c */
    private boolean m89c(int i) {
        return i < this.f158i.size();
    }

    /* renamed from: d */
    private void m90d(int i) {
        View rightmostChild = getRightmostChild();
        int i2 = 0;
        m68a(rightmostChild != null ? rightmostChild.getRight() : 0, i);
        View leftmostChild = getLeftmostChild();
        if (leftmostChild != null) {
            i2 = leftmostChild.getLeft();
        }
        m82b(i2, i);
    }

    /* renamed from: d */
    private boolean m91d() {
        if (m102h(this.f167r)) {
            View rightmostChild = getRightmostChild();
            if (rightmostChild != null) {
                int i = this.f165p;
                this.f165p = (this.f152c + (rightmostChild.getRight() - getPaddingLeft())) - getRenderWidth();
                if (this.f165p < 0) {
                    this.f165p = 0;
                }
                if (this.f165p != i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m94e() {
        if (this.f161l != null) {
            this.f161l.setPressed(false);
            refreshDrawableState();
            this.f161l = null;
        }
    }

    /* renamed from: e */
    private void m95e(int i) {
        while (true) {
            View leftmostChild = getLeftmostChild();
            if (leftmostChild != null && leftmostChild.getRight() + i <= 0) {
                this.f157h += m102h(this.f166q) ? leftmostChild.getMeasuredWidth() : this.f162m + leftmostChild.getMeasuredWidth();
                m69a(this.f166q, leftmostChild);
                removeViewInLayout(leftmostChild);
                this.f166q++;
            }
        }
        while (true) {
            View rightmostChild = getRightmostChild();
            if (rightmostChild != null && rightmostChild.getLeft() + i >= getWidth()) {
                m69a(this.f167r, rightmostChild);
                removeViewInLayout(rightmostChild);
                this.f167r--;
            } else {
                return;
            }
        }
    }

    /* renamed from: f */
    private void m97f() {
        if (this.f174y != null) {
            this.f174y.onRelease();
        }
        if (this.f175z != null) {
            this.f175z.onRelease();
        }
    }

    /* renamed from: f */
    private void m98f(int i) {
        int childCount = getChildCount();
        int i2 = this.f147H;
        this.f147H = 0;
        if (childCount > 0) {
            this.f157h += i;
            int i3 = this.f157h;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                int paddingLeft = getPaddingLeft() + i3;
                int paddingTop = getPaddingTop();
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                int measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                this.f147H = Math.max(this.f147H, getPaddingBottom() + measuredHeight);
                childAt.layout(paddingLeft, paddingTop, measuredWidth, measuredHeight);
                i3 += childAt.getMeasuredWidth() + this.f162m;
            }
            if (i2 == 0) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        HorizontalListView.this.requestLayout();
                    }
                }, 96);
            }
        }
    }

    /* renamed from: g */
    private View m99g(int i) {
        if (i < this.f166q || i > this.f167r) {
            return null;
        }
        return getChildAt(i - this.f166q);
    }

    /* renamed from: g */
    private void m100g() {
        if (this.f169t != null && this.f151b != null && this.f151b.getCount() - (this.f167r + 1) < this.f170u && !this.f171v) {
            this.f171v = true;
            this.f169t.onRunningOutOfData();
        }
    }

    private View getLeftmostChild() {
        return getChildAt(0);
    }

    private int getRenderHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getRenderWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private View getRightmostChild() {
        return getChildAt(getChildCount() - 1);
    }

    /* renamed from: h */
    private boolean m101h() {
        boolean z = false;
        if (this.f151b != null) {
            if (this.f151b.isEmpty()) {
                return false;
            }
            if (this.f165p > 0) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: h */
    private boolean m102h(int i) {
        return i == this.f151b.getCount() - 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m103i(int i) {
        EdgeEffect edgeEffect;
        if (this.f174y != null && this.f175z != null) {
            int i2 = this.f152c + i;
            if (this.f150a == null || this.f150a.isFinished()) {
                if (i2 < 0) {
                    this.f174y.onPull(((float) Math.abs(i)) / ((float) getRenderWidth()));
                    if (!this.f175z.isFinished()) {
                        edgeEffect = this.f175z;
                    }
                } else if (i2 > this.f165p) {
                    this.f175z.onPull(((float) Math.abs(i)) / ((float) getRenderWidth()));
                    if (!this.f174y.isFinished()) {
                        edgeEffect = this.f174y;
                    }
                }
                edgeEffect.onRelease();
            }
        }
    }

    /* access modifiers changed from: private */
    public void setCurrentScrollState(ScrollState scrollState) {
        if (!(this.f173x == scrollState || this.f172w == null)) {
            this.f172w.onScrollStateChanged(scrollState);
        }
        this.f173x = scrollState;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo250a(MotionEvent motionEvent) {
        this.f141B = !this.f150a.isFinished();
        this.f150a.forceFinished(true);
        setCurrentScrollState(ScrollState.SCROLL_STATE_IDLE);
        m94e();
        if (!this.f141B) {
            int c = m87c((int) motionEvent.getX(), (int) motionEvent.getY());
            if (c >= 0) {
                this.f161l = getChildAt(c);
                if (this.f161l != null) {
                    this.f161l.setPressed(true);
                    refreshDrawableState();
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo251a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f150a.fling(this.f153d, 0, (int) (-f), 0, 0, this.f165p, 0, 0);
        setCurrentScrollState(ScrollState.SCROLL_STATE_FLING);
        requestLayout();
        return true;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f144E != null) {
            Paint paint = new Paint();
            paint.setColor(-2004318072);
            canvas.drawRect(this.f144E, paint);
        }
        if (this.f168s >= 0 && this.f166q <= this.f168s && this.f167r >= this.f168s && this.f146G != null) {
            View selectedView = getSelectedView();
            if (selectedView != null) {
                this.f146G.setBounds(new Rect(selectedView.getLeft(), selectedView.getTop(), selectedView.getRight(), selectedView.getBottom()));
                this.f146G.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
        if (this.f168s >= 0 && this.f166q <= this.f168s && this.f167r >= this.f168s) {
            View selectedView2 = getSelectedView();
            if (selectedView2 != null) {
                Rect rect = new Rect(selectedView2.getLeft(), selectedView2.getBottom() - m62a(2.0f), selectedView2.getRight(), selectedView2.getBottom());
                Paint paint2 = new Paint();
                paint2.setColor(this.f145F);
                canvas.drawRect(rect, paint2);
            }
        }
        m70a(canvas);
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z) {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent) | this.f156g.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 3) {
            switch (action) {
                case 0:
                    int c = m87c((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (c >= 0) {
                        View childAt = getChildAt(c);
                        this.f144E = new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                        break;
                    } else {
                        return dispatchTouchEvent;
                    }
                case 1:
                    break;
                default:
                    return dispatchTouchEvent;
            }
        }
        this.f144E = null;
        invalidate();
        return dispatchTouchEvent;
    }

    public ListAdapter getAdapter() {
        return this.f151b;
    }

    public int getFirstVisiblePosition() {
        return this.f166q;
    }

    public int getLastVisiblePosition() {
        return this.f167r;
    }

    /* access modifiers changed from: protected */
    public float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.f152c == 0) {
            return 0.0f;
        }
        if (this.f152c < horizontalFadingEdgeLength) {
            return ((float) this.f152c) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.f152c == this.f165p) {
            return 0.0f;
        }
        if (this.f165p - this.f152c < horizontalFadingEdgeLength) {
            return ((float) (this.f165p - this.f152c)) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    public View getSelectedView() {
        return m99g(this.f168s);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m83b(canvas);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0090  */
    @android.annotation.SuppressLint({"WrongCall"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            r3 = this;
            super.onLayout(r4, r5, r6, r7, r8)
            android.widget.ListAdapter r0 = r3.f151b
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            r3.invalidate()
            boolean r0 = r3.f159j
            r1 = 0
            if (r0 == 0) goto L_0x001c
            int r0 = r3.f152c
            r3.m66a()
            r3.removeAllViewsInLayout()
            r3.f153d = r0
            r3.f159j = r1
        L_0x001c:
            java.lang.Integer r0 = r3.f164o
            if (r0 == 0) goto L_0x002b
            java.lang.Integer r0 = r3.f164o
            int r0 = r0.intValue()
            r3.f153d = r0
            r0 = 0
            r3.f164o = r0
        L_0x002b:
            android.widget.Scroller r0 = r3.f150a
            boolean r0 = r0.computeScrollOffset()
            if (r0 == 0) goto L_0x003b
            android.widget.Scroller r0 = r3.f150a
            int r0 = r0.getCurrX()
            r3.f153d = r0
        L_0x003b:
            int r0 = r3.f153d
            r2 = 1
            if (r0 >= 0) goto L_0x005f
            r3.f153d = r1
            android.widget.EdgeEffect r0 = r3.f174y
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x0054
            android.widget.EdgeEffect r0 = r3.f174y
        L_0x004c:
            float r1 = r3.m86c()
            int r1 = (int) r1
            r0.onAbsorb(r1)
        L_0x0054:
            android.widget.Scroller r0 = r3.f150a
            r0.forceFinished(r2)
            android.widget.HorizontalListView$OnScrollStateChangedListener$ScrollState r0 = android.widget.HorizontalListView.OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE
            r3.setCurrentScrollState(r0)
            goto L_0x0074
        L_0x005f:
            int r0 = r3.f153d
            int r1 = r3.f165p
            if (r0 <= r1) goto L_0x0074
            int r0 = r3.f165p
            r3.f153d = r0
            android.widget.EdgeEffect r0 = r3.f175z
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x0054
            android.widget.EdgeEffect r0 = r3.f175z
            goto L_0x004c
        L_0x0074:
            int r0 = r3.f152c
            int r1 = r3.f153d
            int r0 = r0 - r1
            r3.m95e(r0)
            r3.m90d(r0)
            r3.m98f(r0)
            int r0 = r3.f153d
            r3.f152c = r0
            boolean r0 = r3.m91d()
            if (r0 == 0) goto L_0x0090
            r3.onLayout(r4, r5, r6, r7, r8)
            return
        L_0x0090:
            android.widget.Scroller r4 = r3.f150a
            boolean r4 = r4.isFinished()
            if (r4 == 0) goto L_0x00a4
            android.widget.HorizontalListView$OnScrollStateChangedListener$ScrollState r4 = r3.f173x
            android.widget.HorizontalListView$OnScrollStateChangedListener$ScrollState r5 = android.widget.HorizontalListView.OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING
            if (r4 != r5) goto L_0x00a9
            android.widget.HorizontalListView$OnScrollStateChangedListener$ScrollState r4 = android.widget.HorizontalListView.OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE
            r3.setCurrentScrollState(r4)
            return
        L_0x00a4:
            java.lang.Runnable r4 = r3.f149J
            r3.postOnAnimation(r4)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.HorizontalListView.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(i, MeasureSpec.makeMeasureSpec(this.f147H, 1073741824));
        }
        this.f140A = i2;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f164o = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.f152c);
        return bundle;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            if (this.f150a == null || this.f150a.isFinished()) {
                setCurrentScrollState(ScrollState.SCROLL_STATE_IDLE);
            }
            m77a(Boolean.valueOf(false));
            m97f();
        } else if (action == 3) {
            m94e();
            m97f();
            m77a(Boolean.valueOf(false));
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scrollTo(int i) {
        this.f150a.startScroll(this.f153d, 0, i - this.f153d, 0);
        setCurrentScrollState(ScrollState.SCROLL_STATE_FLING);
        requestLayout();
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.f151b != null) {
            this.f151b.unregisterDataSetObserver(this.f148I);
        }
        if (listAdapter != null) {
            this.f171v = false;
            this.f151b = listAdapter;
            this.f151b.registerDataSetObserver(this.f148I);
        }
        m67a(this.f151b.getViewTypeCount());
        m81b();
    }

    public void setDivider(Drawable drawable) {
        this.f163n = drawable;
        setDividerWidth(drawable != null ? drawable.getIntrinsicWidth() : 0);
    }

    public void setDividerWidth(int i) {
        this.f162m = i;
        requestLayout();
        invalidate();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f143D = onClickListener;
    }

    public void setOnScrollStateChangedListener(OnScrollStateChangedListener onScrollStateChangedListener) {
        this.f172w = onScrollStateChangedListener;
    }

    public void setRunningOutOfDataListener(RunningOutOfDataListener runningOutOfDataListener, int i) {
        this.f169t = runningOutOfDataListener;
        this.f170u = i;
    }

    public void setSelectedBackground(Drawable drawable) {
        this.f146G = drawable;
        invalidate();
    }

    public void setSelectedBackgroundColor(int i) {
        this.f146G = new ColorDrawable(i);
        invalidate();
    }

    public void setSelectedColor(int i) {
        this.f145F = i;
        invalidate();
    }

    public void setSelection(int i) {
        this.f168s = i;
        if (this.f151b == null || i < 0 || i > this.f151b.getCount()) {
            invalidate();
            return;
        }
        View selectedView = getSelectedView();
        if (selectedView == null || selectedView.getRight() > getWidth() || selectedView.getLeft() < 0) {
            View view = null;
            int i2 = 0;
            int i3 = 0;
            while (i2 < i - 1) {
                view = this.f151b.getView(i2, view, this);
                m72a(view);
                i3 += i2 == 0 ? view.getMeasuredWidth() : this.f162m + view.getMeasuredWidth();
                i2++;
            }
            scrollTo(i3);
        }
        invalidate();
    }
}
