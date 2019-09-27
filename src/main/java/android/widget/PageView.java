package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PageView extends ViewGroup {
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final int[] f195a = {16842931};

    /* renamed from: b */
    private static final Comparator<ItemInfo> f196b = new Comparator<ItemInfo>() {
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f258b - itemInfo2.f258b;
        }
    };

    /* renamed from: c */
    private static final Interpolator f197c = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: d */
    private static final ViewPositionComparator f198d = new ViewPositionComparator();

    /* renamed from: A */
    private int f199A = 1;

    /* renamed from: B */
    private boolean f200B;

    /* renamed from: C */
    private boolean f201C;

    /* renamed from: D */
    private int f202D;

    /* renamed from: E */
    private int f203E;

    /* renamed from: F */
    private int f204F;

    /* renamed from: G */
    private float f205G;

    /* renamed from: H */
    private float f206H;

    /* renamed from: I */
    private float f207I;

    /* renamed from: J */
    private float f208J;

    /* renamed from: K */
    private int f209K = -1;

    /* renamed from: L */
    private VelocityTracker f210L;

    /* renamed from: M */
    private int f211M;

    /* renamed from: N */
    private int f212N;

    /* renamed from: O */
    private int f213O;

    /* renamed from: P */
    private int f214P;

    /* renamed from: Q */
    private boolean f215Q;

    /* renamed from: R */
    private long f216R;

    /* renamed from: S */
    private EdgeEffect f217S;

    /* renamed from: T */
    private EdgeEffect f218T;

    /* renamed from: U */
    private boolean f219U = true;

    /* renamed from: V */
    private boolean f220V = false;

    /* renamed from: W */
    private boolean f221W;

    /* renamed from: aa */
    private int f222aa;

    /* renamed from: ab */
    private List<OnPageChangeListener> f223ab;

    /* renamed from: ac */
    private OnPageChangeListener f224ac;

    /* renamed from: ad */
    private OnPageChangeListener f225ad;

    /* renamed from: ae */
    private OnAdapterChangeListener f226ae;

    /* renamed from: af */
    private PageTransformer f227af;

    /* renamed from: ag */
    private Method f228ag;

    /* renamed from: ah */
    private int f229ah;

    /* renamed from: ai */
    private ArrayList<View> f230ai;

    /* renamed from: aj */
    private int f231aj = 0;

    /* renamed from: ak */
    private final Runnable f232ak = new Runnable() {
        public void run() {
            PageView.this.setScrollState(0);
            PageView.this.mo323c();
        }
    };

    /* renamed from: al */
    private boolean f233al = true;

    /* renamed from: e */
    private final ArrayList<ItemInfo> f234e = new ArrayList<>();

    /* renamed from: f */
    private final ItemInfo f235f = new ItemInfo();

    /* renamed from: g */
    private final Rect f236g = new Rect();

    /* renamed from: h */
    private int f237h;

    /* renamed from: i */
    private BasePageAdapter f238i;

    /* renamed from: j */
    private int f239j;

    /* renamed from: k */
    private int f240k = -1;

    /* renamed from: l */
    private Parcelable f241l = null;

    /* renamed from: m */
    private ClassLoader f242m = null;

    /* renamed from: n */
    private Scroller f243n;

    /* renamed from: o */
    private PageObserver f244o;

    /* renamed from: p */
    private int f245p;

    /* renamed from: q */
    private Drawable f246q;

    /* renamed from: r */
    private int f247r;

    /* renamed from: s */
    private int f248s;

    /* renamed from: t */
    private float f249t = -3.4028235E38f;

    /* renamed from: u */
    private float f250u = Float.MAX_VALUE;

    /* renamed from: v */
    private int f251v;

    /* renamed from: w */
    private int f252w;

    /* renamed from: x */
    private boolean f253x;

    /* renamed from: y */
    private boolean f254y;

    /* renamed from: z */
    private boolean f255z;

    interface Decor {
    }

    static class ItemInfo {

        /* renamed from: a */
        Object f257a;

        /* renamed from: b */
        int f258b;

        /* renamed from: c */
        boolean f259c;

        /* renamed from: d */
        float f260d;

        /* renamed from: e */
        float f261e;

        ItemInfo() {
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {

        /* renamed from: a */
        float f262a = 0.0f;

        /* renamed from: b */
        boolean f263b;

        /* renamed from: c */
        int f264c;

        /* renamed from: d */
        int f265d;
        public int gravity;
        public boolean isDecor;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, PageView.f195a);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(-1, -1);
        }
    }

    interface OnAdapterChangeListener {
        void onAdapterChanged(BasePageAdapter basePageAdapter, BasePageAdapter basePageAdapter2);
    }

    public interface OnPageChangeListener {
        void onPageChange(View view, int i);

        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    private class PageObserver extends DataSetObserver {
        private PageObserver() {
        }

        public void onChanged() {
            PageView.this.mo321b();
        }

        public void onInvalidated() {
            PageView.this.mo321b();
        }
    }

    public interface PageTransformer {
        void transformPage(View view, float f);
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        int f267a;

        /* renamed from: b */
        Parcelable f268b;

        /* renamed from: c */
        ClassLoader f269c;

        SavedState(Parcel parcel) {
            super(parcel);
            ClassLoader classLoader = getClass().getClassLoader();
            this.f267a = parcel.readInt();
            this.f268b = parcel.readParcelable(classLoader);
            this.f269c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FragmentPage.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" position=");
            sb.append(this.f267a);
            sb.append("}");
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f267a);
            parcel.writeParcelable(this.f268b, i);
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void onPageChange(View view, int i) {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            return layoutParams.isDecor != layoutParams2.isDecor ? layoutParams.isDecor ? 1 : -1 : layoutParams.f264c - layoutParams2.f264c;
        }
    }

    public PageView(Context context) {
        super(context);
        mo307a();
    }

    public PageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo307a();
    }

    /* renamed from: a */
    private int m109a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f213O || Math.abs(i2) <= this.f211M) {
            i = (int) (((float) i) + f + (i >= this.f239j ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f234e.size() <= 0) {
            return i;
        }
        return Math.max(((ItemInfo) this.f234e.get(0)).f258b, Math.min(i, ((ItemInfo) this.f234e.get(this.f234e.size() - 1)).f258b));
    }

    /* renamed from: a */
    private Rect m110a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* renamed from: a */
    private void m111a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f234e.isEmpty()) {
            ItemInfo b = mo319b(this.f239j);
            int min = (int) ((b != null ? Math.min(b.f261e, this.f250u) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m116a(false);
                scrollTo(min, getScrollY());
            }
        } else {
            int scrollX = (int) ((((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))) * ((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)));
            scrollTo(scrollX, getScrollY());
            if (!this.f243n.isFinished()) {
                this.f243n.startScroll(scrollX, 0, (int) (mo319b(this.f239j).f261e * ((float) i)), 0, this.f243n.getDuration() - this.f243n.timePassed());
            }
        }
    }

    /* renamed from: a */
    private void m112a(int i, boolean z, int i2, boolean z2) {
        ItemInfo b = mo319b(i);
        int clientWidth = b != null ? (int) (((float) getClientWidth()) * Math.max(this.f249t, Math.min(b.f261e, this.f250u))) : 0;
        if (z) {
            mo310a(clientWidth, 0, i2);
            if (z2) {
                m123d(i);
            }
        } else {
            if (z2) {
                m123d(i);
            }
            m116a(false);
            scrollTo(clientWidth, 0);
            m122c(clientWidth);
        }
    }

    /* renamed from: a */
    private void m113a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f209K) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f205G = motionEvent.getX(i);
            this.f209K = motionEvent.getPointerId(i);
            if (this.f210L != null) {
                this.f210L.clear();
            }
        }
    }

    /* renamed from: a */
    private void m114a(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.f238i.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.f245p) / ((float) clientWidth) : 0.0f;
        if (itemInfo2 != null) {
            int i2 = itemInfo2.f258b;
            if (i2 < itemInfo.f258b) {
                float f2 = itemInfo2.f261e + itemInfo2.f260d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= itemInfo.f258b && i4 < this.f234e.size()) {
                    while (true) {
                        itemInfo4 = (ItemInfo) this.f234e.get(i4);
                        if (i3 > itemInfo4.f258b && i4 < this.f234e.size() - 1) {
                            i4++;
                        }
                    }
                    while (i3 < itemInfo4.f258b) {
                        f2 += this.f238i.getPageWidth(i3) + f;
                        i3++;
                    }
                    itemInfo4.f261e = f2;
                    f2 += itemInfo4.f260d + f;
                    i3++;
                }
            } else if (i2 > itemInfo.f258b) {
                int size = this.f234e.size() - 1;
                float f3 = itemInfo2.f261e;
                while (true) {
                    i2--;
                    if (i2 < itemInfo.f258b || size < 0) {
                        break;
                    }
                    while (true) {
                        itemInfo3 = (ItemInfo) this.f234e.get(size);
                        if (i2 < itemInfo3.f258b && size > 0) {
                            size--;
                        }
                    }
                    while (i2 > itemInfo3.f258b) {
                        f3 -= this.f238i.getPageWidth(i2) + f;
                        i2--;
                    }
                    f3 -= itemInfo3.f260d + f;
                    itemInfo3.f261e = f3;
                }
            }
        }
        int size2 = this.f234e.size();
        float f4 = itemInfo.f261e;
        int i5 = itemInfo.f258b - 1;
        this.f249t = itemInfo.f258b == 0 ? itemInfo.f261e : -3.4028235E38f;
        int i6 = count - 1;
        this.f250u = itemInfo.f258b == i6 ? (itemInfo.f261e + itemInfo.f260d) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            ItemInfo itemInfo5 = (ItemInfo) this.f234e.get(i7);
            while (i5 > itemInfo5.f258b) {
                f4 -= this.f238i.getPageWidth(i5) + f;
                i5--;
            }
            f4 -= itemInfo5.f260d + f;
            itemInfo5.f261e = f4;
            if (itemInfo5.f258b == 0) {
                this.f249t = f4;
            }
            i7--;
            i5--;
        }
        float f5 = itemInfo.f261e + itemInfo.f260d + f;
        int i8 = itemInfo.f258b + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            ItemInfo itemInfo6 = (ItemInfo) this.f234e.get(i9);
            while (i8 < itemInfo6.f258b) {
                f5 += this.f238i.getPageWidth(i8) + f;
                i8++;
            }
            if (itemInfo6.f258b == i6) {
                this.f250u = (itemInfo6.f260d + f5) - 1.0f;
            }
            itemInfo6.f261e = f5;
            f5 += itemInfo6.f260d + f;
            i9++;
            i8++;
        }
        this.f220V = false;
    }

    /* renamed from: a */
    private void m116a(boolean z) {
        boolean z2 = this.f231aj == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f243n.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f243n.getCurrX();
            int currY = this.f243n.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
                if (currX != scrollX) {
                    m122c(currX);
                }
            }
        }
        this.f255z = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f234e.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.f234e.get(i);
            if (itemInfo.f259c) {
                itemInfo.f259c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                postOnAnimation(this.f232ak);
                return;
            }
            this.f232ak.run();
        }
    }

    /* renamed from: a */
    private boolean m117a(float f, float f2) {
        return (f < ((float) this.f203E) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f203E)) && f2 < 0.0f);
    }

    /* renamed from: b */
    private void m118b(int i, float f, int i2) {
        if (this.f224ac != null) {
            this.f224ac.onPageScrolled(i, f, i2);
        }
        if (this.f223ab != null) {
            int size = this.f223ab.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.f223ab.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i, f, i2);
                }
            }
        }
        if (this.f225ad != null) {
            this.f225ad.onPageScrolled(i, f, i2);
        }
    }

    /* renamed from: b */
    private void m119b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? 2 : 0, null);
        }
    }

    /* renamed from: b */
    private boolean m120b(float f) {
        boolean z;
        float f2 = this.f205G - f;
        this.f205G = f;
        float scrollX = ((float) getScrollX()) + f2;
        float clientWidth = (float) getClientWidth();
        float f3 = this.f249t * clientWidth;
        float f4 = this.f250u * clientWidth;
        ItemInfo itemInfo = (ItemInfo) this.f234e.get(0);
        boolean z2 = true;
        ItemInfo itemInfo2 = (ItemInfo) this.f234e.get(this.f234e.size() - 1);
        if (itemInfo.f258b != 0) {
            f3 = itemInfo.f261e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.f258b != this.f238i.getCount() - 1) {
            f4 = itemInfo2.f261e * clientWidth;
            z2 = false;
        }
        if (scrollX < f3) {
            if (z) {
                this.f217S.onPull(Math.abs(f3 - scrollX) / clientWidth);
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.f218T.onPull(Math.abs(scrollX - f4) / clientWidth);
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.f205G += scrollX - ((float) i);
        scrollTo(i, getScrollY());
        m122c(i);
        return false;
    }

    /* renamed from: c */
    private void m121c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: c */
    private boolean m122c(int i) {
        if (this.f234e.size() == 0) {
            this.f221W = false;
            mo309a(0, 0.0f, 0);
            if (this.f221W) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo j = m129j();
        int clientWidth = getClientWidth();
        int i2 = this.f245p + clientWidth;
        float f = (float) clientWidth;
        float f2 = ((float) this.f245p) / f;
        int i3 = j.f258b;
        float f3 = ((((float) i) / f) - j.f261e) / (j.f260d + f2);
        int i4 = (int) (((float) i2) * f3);
        this.f221W = false;
        mo309a(i3, f3, i4);
        if (this.f221W) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* renamed from: d */
    private void m123d(int i) {
        if (this.f224ac != null) {
            this.f224ac.onPageSelected(i);
            this.f224ac.onPageChange(getChildAt(i), i);
        }
        if (this.f223ab != null) {
            int size = this.f223ab.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.f223ab.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
            }
        }
        if (this.f225ad != null) {
            this.f225ad.onPageSelected(i);
        }
    }

    /* renamed from: e */
    private void m124e(int i) {
        if (this.f224ac != null) {
            this.f224ac.onPageScrollStateChanged(i);
        }
        if (this.f223ab != null) {
            int size = this.f223ab.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.f223ab.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i);
                }
            }
        }
        if (this.f225ad != null) {
            this.f225ad.onPageScrollStateChanged(i);
        }
    }

    /* renamed from: g */
    private void m126g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).isDecor) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* renamed from: h */
    private void m127h() {
        if (this.f229ah != 0) {
            if (this.f230ai == null) {
                this.f230ai = new ArrayList<>();
            } else {
                this.f230ai.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f230ai.add(getChildAt(i));
            }
            Collections.sort(this.f230ai, f198d);
        }
    }

    /* renamed from: i */
    private boolean m128i() {
        this.f209K = -1;
        m130k();
        this.f217S.onRelease();
        this.f218T.onRelease();
        return true;
    }

    /* renamed from: j */
    private ItemInfo m129j() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.f245p) / ((float) clientWidth) : 0.0f;
        ItemInfo itemInfo = null;
        int i = 0;
        boolean z = true;
        int i2 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i < this.f234e.size()) {
            ItemInfo itemInfo2 = (ItemInfo) this.f234e.get(i);
            if (!z) {
                int i3 = i2 + 1;
                if (itemInfo2.f258b != i3) {
                    itemInfo2 = this.f235f;
                    itemInfo2.f261e = f2 + f3 + f;
                    itemInfo2.f258b = i3;
                    itemInfo2.f260d = this.f238i.getPageWidth(itemInfo2.f258b);
                    i--;
                }
            }
            f2 = itemInfo2.f261e;
            float f4 = itemInfo2.f260d + f2 + f;
            if (!z && scrollX < f2) {
                return itemInfo;
            }
            if (scrollX < f4 || i == this.f234e.size() - 1) {
                return itemInfo2;
            }
            i2 = itemInfo2.f258b;
            f3 = itemInfo2.f260d;
            i++;
            itemInfo = itemInfo2;
            z = false;
        }
        return itemInfo;
    }

    /* renamed from: k */
    private void m130k() {
        this.f200B = false;
        this.f201C = false;
        if (this.f210L != null) {
            this.f210L.recycle();
            this.f210L = null;
        }
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.f231aj != i) {
            this.f231aj = i;
            if (this.f227af != null) {
                m119b(i != 0);
            }
            m124e(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f254y != z) {
            this.f254y = z;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public float mo304a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ItemInfo mo305a(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f258b = i;
        itemInfo.f257a = this.f238i.instantiateItem((ViewGroup) this, i);
        itemInfo.f260d = this.f238i.getPageWidth(i);
        if (i2 < 0 || i2 >= this.f234e.size()) {
            this.f234e.add(itemInfo);
            return itemInfo;
        }
        this.f234e.add(i2, itemInfo);
        return itemInfo;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ItemInfo mo306a(View view) {
        for (int i = 0; i < this.f234e.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.f234e.get(i);
            if (this.f238i.isViewFromObject(view, itemInfo.f257a)) {
                return itemInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo307a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f243n = new Scroller(context, f197c);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f204F = viewConfiguration.getScaledPagingTouchSlop();
        this.f211M = (int) (400.0f * f);
        this.f212N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f217S = new EdgeEffect(context);
        this.f218T = new EdgeEffect(context);
        this.f213O = (int) (25.0f * f);
        this.f214P = (int) (2.0f * f);
        this.f202D = (int) (f * 16.0f);
        setAccessibilityDelegate(new AccessibilityDelegate());
        if (VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        if (r9.f258b == r0.f239j) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00cc, code lost:
        if (r11 >= 0) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00da, code lost:
        if (r11 >= 0) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e8, code lost:
        if (r11 >= 0) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f3, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0148, code lost:
        if (r5 < r0.f234e.size()) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0153, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0166, code lost:
        if (r5 < r0.f234e.size()) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0178, code lost:
        if (r5 < r0.f234e.size()) goto L_0x014a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo308a(int r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            int r2 = r0.f239j
            if (r2 == r1) goto L_0x001a
            int r2 = r0.f239j
            if (r2 >= r1) goto L_0x000f
            r2 = 66
            goto L_0x0011
        L_0x000f:
            r2 = 17
        L_0x0011:
            int r4 = r0.f239j
            android.widget.PageView$ItemInfo r4 = r0.mo319b(r4)
            r0.f239j = r1
            goto L_0x001c
        L_0x001a:
            r2 = 2
            r4 = 0
        L_0x001c:
            android.widget.BasePageAdapter r1 = r0.f238i
            if (r1 != 0) goto L_0x0024
            r18.m127h()
            return
        L_0x0024:
            boolean r1 = r0.f255z
            if (r1 == 0) goto L_0x002c
            r18.m127h()
            return
        L_0x002c:
            android.os.IBinder r1 = r18.getWindowToken()
            if (r1 != 0) goto L_0x0033
            return
        L_0x0033:
            android.widget.BasePageAdapter r1 = r0.f238i
            r1.startUpdate(r0)
            int r1 = r0.f199A
            int r5 = r0.f239j
            int r5 = r5 - r1
            r6 = 0
            int r5 = java.lang.Math.max(r6, r5)
            android.widget.BasePageAdapter r7 = r0.f238i
            int r7 = r7.getCount()
            int r8 = r7 + -1
            int r9 = r0.f239j
            int r9 = r9 + r1
            int r1 = java.lang.Math.min(r8, r9)
            r8 = 0
        L_0x0052:
            java.util.ArrayList<android.widget.PageView$ItemInfo> r9 = r0.f234e
            int r9 = r9.size()
            if (r8 >= r9) goto L_0x0072
            java.util.ArrayList<android.widget.PageView$ItemInfo> r9 = r0.f234e
            java.lang.Object r9 = r9.get(r8)
            android.widget.PageView$ItemInfo r9 = (android.widget.PageView.ItemInfo) r9
            int r10 = r9.f258b
            int r11 = r0.f239j
            if (r10 < r11) goto L_0x006f
            int r10 = r9.f258b
            int r11 = r0.f239j
            if (r10 != r11) goto L_0x0072
            goto L_0x0073
        L_0x006f:
            int r8 = r8 + 1
            goto L_0x0052
        L_0x0072:
            r9 = 0
        L_0x0073:
            if (r9 != 0) goto L_0x007d
            if (r7 <= 0) goto L_0x007d
            int r9 = r0.f239j
            android.widget.PageView$ItemInfo r9 = r0.mo305a(r9, r8)
        L_0x007d:
            if (r9 == 0) goto L_0x017f
            int r11 = r8 + -1
            if (r11 < 0) goto L_0x008c
            java.util.ArrayList<android.widget.PageView$ItemInfo> r12 = r0.f234e
            java.lang.Object r12 = r12.get(r11)
            android.widget.PageView$ItemInfo r12 = (android.widget.PageView.ItemInfo) r12
            goto L_0x008d
        L_0x008c:
            r12 = 0
        L_0x008d:
            int r13 = r18.getClientWidth()
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 > 0) goto L_0x0097
            r3 = 0
            goto L_0x00a3
        L_0x0097:
            float r15 = r9.f260d
            float r15 = r14 - r15
            int r3 = r18.getPaddingLeft()
            float r3 = (float) r3
            float r6 = (float) r13
            float r3 = r3 / r6
            float r3 = r3 + r15
        L_0x00a3:
            int r6 = r0.f239j
            int r6 = r6 + -1
            r15 = r8
            r8 = 0
        L_0x00a9:
            if (r6 < 0) goto L_0x00f8
            int r16 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r16 < 0) goto L_0x00cf
            if (r6 >= r5) goto L_0x00cf
            if (r12 != 0) goto L_0x00b4
            goto L_0x00f8
        L_0x00b4:
            int r10 = r12.f258b
            if (r6 != r10) goto L_0x00f5
            boolean r10 = r12.f259c
            if (r10 != 0) goto L_0x00f5
            java.util.ArrayList<android.widget.PageView$ItemInfo> r10 = r0.f234e
            r10.remove(r11)
            android.widget.BasePageAdapter r10 = r0.f238i
            java.lang.Object r12 = r12.f257a
            r10.destroyItem(r0, r6, r12)
            int r11 = r11 + -1
            int r15 = r15 + -1
            if (r11 < 0) goto L_0x00f3
            goto L_0x00ea
        L_0x00cf:
            if (r12 == 0) goto L_0x00dd
            int r10 = r12.f258b
            if (r6 != r10) goto L_0x00dd
            float r10 = r12.f260d
            float r8 = r8 + r10
            int r11 = r11 + -1
            if (r11 < 0) goto L_0x00f3
            goto L_0x00ea
        L_0x00dd:
            int r10 = r11 + 1
            android.widget.PageView$ItemInfo r10 = r0.mo305a(r6, r10)
            float r10 = r10.f260d
            float r8 = r8 + r10
            int r15 = r15 + 1
            if (r11 < 0) goto L_0x00f3
        L_0x00ea:
            java.util.ArrayList<android.widget.PageView$ItemInfo> r10 = r0.f234e
            java.lang.Object r10 = r10.get(r11)
            android.widget.PageView$ItemInfo r10 = (android.widget.PageView.ItemInfo) r10
            goto L_0x00f4
        L_0x00f3:
            r10 = 0
        L_0x00f4:
            r12 = r10
        L_0x00f5:
            int r6 = r6 + -1
            goto L_0x00a9
        L_0x00f8:
            float r3 = r9.f260d
            int r5 = r15 + 1
            int r6 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r6 >= 0) goto L_0x017c
            java.util.ArrayList<android.widget.PageView$ItemInfo> r6 = r0.f234e
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0111
            java.util.ArrayList<android.widget.PageView$ItemInfo> r6 = r0.f234e
            java.lang.Object r6 = r6.get(r5)
            android.widget.PageView$ItemInfo r6 = (android.widget.PageView.ItemInfo) r6
            goto L_0x0112
        L_0x0111:
            r6 = 0
        L_0x0112:
            if (r13 > 0) goto L_0x0116
            r10 = 0
            goto L_0x011f
        L_0x0116:
            int r8 = r18.getPaddingRight()
            float r8 = (float) r8
            float r10 = (float) r13
            float r8 = r8 / r10
            float r10 = r8 + r14
        L_0x011f:
            int r8 = r0.f239j
        L_0x0121:
            int r8 = r8 + 1
            if (r8 >= r7) goto L_0x017c
            int r11 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r11 < 0) goto L_0x0155
            if (r8 <= r1) goto L_0x0155
            if (r6 != 0) goto L_0x012e
            goto L_0x017c
        L_0x012e:
            int r11 = r6.f258b
            if (r8 != r11) goto L_0x017b
            boolean r11 = r6.f259c
            if (r11 != 0) goto L_0x017b
            java.util.ArrayList<android.widget.PageView$ItemInfo> r11 = r0.f234e
            r11.remove(r5)
            android.widget.BasePageAdapter r11 = r0.f238i
            java.lang.Object r6 = r6.f257a
            r11.destroyItem(r0, r8, r6)
            java.util.ArrayList<android.widget.PageView$ItemInfo> r6 = r0.f234e
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0153
        L_0x014a:
            java.util.ArrayList<android.widget.PageView$ItemInfo> r6 = r0.f234e
            java.lang.Object r6 = r6.get(r5)
            android.widget.PageView$ItemInfo r6 = (android.widget.PageView.ItemInfo) r6
            goto L_0x017b
        L_0x0153:
            r6 = 0
            goto L_0x017b
        L_0x0155:
            if (r6 == 0) goto L_0x0169
            int r11 = r6.f258b
            if (r8 != r11) goto L_0x0169
            float r6 = r6.f260d
            float r3 = r3 + r6
            int r5 = r5 + 1
            java.util.ArrayList<android.widget.PageView$ItemInfo> r6 = r0.f234e
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0153
            goto L_0x014a
        L_0x0169:
            android.widget.PageView$ItemInfo r6 = r0.mo305a(r8, r5)
            int r5 = r5 + 1
            float r6 = r6.f260d
            float r3 = r3 + r6
            java.util.ArrayList<android.widget.PageView$ItemInfo> r6 = r0.f234e
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0153
            goto L_0x014a
        L_0x017b:
            goto L_0x0121
        L_0x017c:
            r0.m114a(r9, r15, r4)
        L_0x017f:
            android.widget.BasePageAdapter r1 = r0.f238i
            int r3 = r0.f239j
            if (r9 == 0) goto L_0x0188
            java.lang.Object r4 = r9.f257a
            goto L_0x0189
        L_0x0188:
            r4 = 0
        L_0x0189:
            r1.setPrimaryItem(r0, r3, r4)
            android.widget.BasePageAdapter r1 = r0.f238i
            r1.finishUpdate(r0)
            int r1 = r18.getChildCount()
            r3 = 0
        L_0x0196:
            if (r3 >= r1) goto L_0x01c2
            android.view.View r4 = r0.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            android.widget.PageView$LayoutParams r5 = (android.widget.PageView.LayoutParams) r5
            r5.f265d = r3
            boolean r6 = r5.isDecor
            if (r6 != 0) goto L_0x01be
            float r6 = r5.f262a
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x01bf
            android.widget.PageView$ItemInfo r4 = r0.mo306a(r4)
            if (r4 == 0) goto L_0x01bf
            float r6 = r4.f260d
            r5.f262a = r6
            int r4 = r4.f258b
            r5.f264c = r4
            goto L_0x01bf
        L_0x01be:
            r7 = 0
        L_0x01bf:
            int r3 = r3 + 1
            goto L_0x0196
        L_0x01c2:
            r18.m127h()
            boolean r1 = r18.hasFocus()
            if (r1 == 0) goto L_0x0200
            android.view.View r1 = r18.findFocus()
            if (r1 == 0) goto L_0x01d6
            android.widget.PageView$ItemInfo r3 = r0.mo320b(r1)
            goto L_0x01d7
        L_0x01d6:
            r3 = 0
        L_0x01d7:
            if (r3 == 0) goto L_0x01df
            int r1 = r3.f258b
            int r3 = r0.f239j
            if (r1 == r3) goto L_0x0200
        L_0x01df:
            r1 = 0
        L_0x01e0:
            int r3 = r18.getChildCount()
            if (r1 >= r3) goto L_0x0200
            android.view.View r3 = r0.getChildAt(r1)
            android.widget.PageView$ItemInfo r4 = r0.mo306a(r3)
            if (r4 == 0) goto L_0x01fd
            int r4 = r4.f258b
            int r5 = r0.f239j
            if (r4 != r5) goto L_0x01fd
            boolean r3 = r3.requestFocus(r2)
            if (r3 == 0) goto L_0x01fd
            return
        L_0x01fd:
            int r1 = r1 + 1
            goto L_0x01e0
        L_0x0200:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.PageView.mo308a(int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo309a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.f222aa
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L_0x001d:
            if (r3 >= r6) goto L_0x006d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            android.widget.PageView$LayoutParams r9 = (android.widget.PageView.LayoutParams) r9
            boolean r10 = r9.isDecor
            if (r10 != 0) goto L_0x002e
            goto L_0x006a
        L_0x002e:
            int r9 = r9.gravity
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004f
            r10 = 3
            if (r9 == r10) goto L_0x0049
            r10 = 5
            if (r9 == r10) goto L_0x003c
            r9 = r4
            goto L_0x005e
        L_0x003c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L_0x005b
        L_0x0049:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L_0x005e
        L_0x004f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L_0x005b:
            r11 = r9
            r9 = r4
            r4 = r11
        L_0x005e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L_0x0069
            r8.offsetLeftAndRight(r4)
        L_0x0069:
            r4 = r9
        L_0x006a:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x006d:
            r12.m118b(r13, r14, r15)
            android.widget.PageView$PageTransformer r13 = r12.f227af
            if (r13 == 0) goto L_0x00a1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007c:
            if (r1 >= r14) goto L_0x00a1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            android.widget.PageView$LayoutParams r0 = (android.widget.PageView.LayoutParams) r0
            boolean r0 = r0.isDecor
            if (r0 == 0) goto L_0x008d
            goto L_0x009e
        L_0x008d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            android.widget.PageView$PageTransformer r3 = r12.f227af
            r3.transformPage(r15, r0)
        L_0x009e:
            int r1 = r1 + 1
            goto L_0x007c
        L_0x00a1:
            r12.f221W = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.PageView.mo309a(int, float, int):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo310a(int i, int i2, int i3) {
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i - scrollX;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m116a(false);
            mo323c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = (float) clientWidth;
        float f2 = (float) i7;
        float a = f2 + (mo304a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / f)) * f2);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i4 = Math.round(Math.abs(a / ((float) abs)) * 1000.0f) * 4;
        } else {
            i4 = (int) (((((float) Math.abs(i5)) / ((f * this.f238i.getPageWidth(this.f239j)) + ((float) this.f245p))) + 1.0f) * 100.0f);
        }
        this.f243n.startScroll(scrollX, scrollY, i5, i6, Math.min(i4, 600));
        postInvalidateOnAnimation();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo311a(int i, boolean z, boolean z2) {
        mo312a(i, z, z2, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo312a(int i, boolean z, boolean z2, int i2) {
        if (this.f238i == null || this.f238i.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f239j != i || this.f234e.size() == 0) {
            boolean z3 = true;
            if (i < 0) {
                i = 0;
            } else if (i >= this.f238i.getCount()) {
                i = this.f238i.getCount() - 1;
            }
            int i3 = this.f199A;
            if (i > this.f239j + i3 || i < this.f239j - i3) {
                for (int i4 = 0; i4 < this.f234e.size(); i4++) {
                    ((ItemInfo) this.f234e.get(i4)).f259c = true;
                }
            }
            if (this.f239j == i) {
                z3 = false;
            }
            if (this.f219U) {
                this.f239j = i;
                if (z3) {
                    m123d(i);
                }
                requestLayout();
                return;
            }
            mo308a(i);
            m112a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo313a(View view, boolean z, int i, int i2, int i3) {
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view2.getScrollX();
            int scrollY = view2.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i4 = i2 + scrollX;
                if (i4 >= childAt.getLeft() && i4 < childAt.getRight()) {
                    int i5 = i3 + scrollY;
                    if (i5 >= childAt.getTop() && i5 < childAt.getBottom()) {
                        if (mo313a(childAt, true, i, i4 - childAt.getLeft(), i5 - childAt.getTop())) {
                            return true;
                        }
                    }
                }
            }
        }
        return z && view2.canScrollHorizontally(-i);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    ItemInfo a = mo306a(childAt);
                    if (a != null && a.f258b == this.f239j) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.f223ab == null) {
            this.f223ab = new ArrayList();
        }
        this.f223ab.add(onPageChangeListener);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo a = mo306a(childAt);
                if (a != null && a.f258b == this.f239j) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.isDecor |= view instanceof Decor;
        if (!this.f253x) {
            super.addView(view, i, layoutParams);
        } else if (layoutParams2 == null || !layoutParams2.isDecor) {
            layoutParams2.f263b = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add page decor view during layout");
        }
    }

    public boolean arrowScroll(int i) {
        boolean e;
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("arrowScroll tried to find focus based on non-child current focused view ");
                    sb2.append(sb.toString());
                    Log.e("PageView", sb2.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 17) {
                int i2 = m110a(this.f236g, findNextFocus).left;
                int i3 = m110a(this.f236g, view).left;
                if (view != null && i2 >= i3) {
                    e = mo328d();
                    z2 = e;
                }
            } else if (i == 66) {
                int i4 = m110a(this.f236g, findNextFocus).left;
                int i5 = m110a(this.f236g, view).left;
                if (view != null && i4 <= i5) {
                    e = mo333e();
                    z2 = e;
                }
            }
            e = findNextFocus.requestFocus();
            z2 = e;
        } else if (i == 17 || i == 1) {
            z2 = mo328d();
        } else if (i == 66 || i == 2) {
            z2 = mo333e();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ItemInfo mo319b(int i) {
        for (int i2 = 0; i2 < this.f234e.size(); i2++) {
            ItemInfo itemInfo = (ItemInfo) this.f234e.get(i2);
            if (itemInfo.f258b == i) {
                return itemInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ItemInfo mo320b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return mo306a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = (View) parent;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo321b() {
        int count = this.f238i.getCount();
        this.f237h = count;
        boolean z = this.f234e.size() < (this.f199A * 2) + 1 && this.f234e.size() < count;
        int i = this.f239j;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.f234e.size()) {
            ItemInfo itemInfo = (ItemInfo) this.f234e.get(i2);
            int itemPosition = this.f238i.getItemPosition(itemInfo.f257a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f234e.remove(i2);
                    i2--;
                    if (!z2) {
                        this.f238i.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.f238i.destroyItem((ViewGroup) this, itemInfo.f258b, itemInfo.f257a);
                    if (this.f239j == itemInfo.f258b) {
                        i = Math.max(0, Math.min(this.f239j, count - 1));
                    }
                } else if (itemInfo.f258b != itemPosition) {
                    if (itemInfo.f258b == this.f239j) {
                        i = itemPosition;
                    }
                    itemInfo.f258b = itemPosition;
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.f238i.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f234e, f196b);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.f262a = 0.0f;
                }
            }
            mo311a(i, false, true);
            requestLayout();
        }
    }

    public boolean beginFakeDrag() {
        if (this.f200B) {
            return false;
        }
        this.f215Q = true;
        setScrollState(1);
        this.f205G = 0.0f;
        this.f207I = 0.0f;
        if (this.f210L == null) {
            this.f210L = VelocityTracker.obtain();
        } else {
            this.f210L.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.f210L.addMovement(obtain);
        obtain.recycle();
        this.f216R = uptimeMillis;
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo323c() {
        mo308a(this.f239j);
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = false;
        if (this.f238i == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.f249t))) {
                z = true;
            }
            return z;
        }
        if (i > 0 && scrollX < ((int) (((float) clientWidth) * this.f250u))) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        if (this.f223ab != null) {
            this.f223ab.clear();
        }
    }

    public void computeScroll() {
        if (this.f243n.isFinished() || !this.f243n.computeScrollOffset()) {
            m116a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f243n.getCurrX();
        int currY = this.f243n.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m122c(currX)) {
                this.f243n.abortAnimation();
                scrollTo(0, currY);
            }
        }
        postInvalidateOnAnimation();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo328d() {
        if (this.f239j <= 0) {
            return false;
        }
        setCurrentItem(this.f239j - 1, true);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo a = mo306a(childAt);
                if (a != null && a.f258b == this.f239j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f238i != null && this.f238i.getCount() > 1)) {
            if (!this.f217S.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f249t * ((float) width));
                this.f217S.setSize(height, width);
                z = false | this.f217S.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f218T.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f250u + 1.0f)) * ((float) width2));
                this.f218T.setSize(height2, width2);
                z |= this.f218T.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.f217S.finish();
            this.f218T.finish();
        }
        if (z) {
            postInvalidateOnAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f246q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo333e() {
        if (this.f238i == null || this.f239j >= this.f238i.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.f239j + 1, true);
        return true;
    }

    public void endFakeDrag() {
        if (!this.f215Q) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        VelocityTracker velocityTracker = this.f210L;
        velocityTracker.computeCurrentVelocity(1000, (float) this.f212N);
        int xVelocity = (int) velocityTracker.getXVelocity(this.f209K);
        this.f255z = true;
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        ItemInfo j = m129j();
        mo312a(m109a(j.f258b, ((((float) scrollX) / ((float) clientWidth)) - j.f261e) / j.f260d, xVelocity, (int) (this.f205G - this.f207I)), true, true, xVelocity);
        m130k();
        this.f215Q = false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int i;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                switch (keyCode) {
                    case 21:
                        i = 17;
                        break;
                    case 22:
                        i = 66;
                        break;
                }
            } else if (VERSION.SDK_INT >= 11) {
                if (keyEvent.hasNoModifiers()) {
                    i = 2;
                } else if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
            return arrowScroll(i);
        }
        return false;
    }

    public void fakeDragBy(float f) {
        if (!this.f215Q) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        this.f205G += f;
        float scrollX = ((float) getScrollX()) - f;
        float clientWidth = (float) getClientWidth();
        float f2 = this.f249t * clientWidth;
        float f3 = this.f250u * clientWidth;
        ItemInfo itemInfo = (ItemInfo) this.f234e.get(0);
        ItemInfo itemInfo2 = (ItemInfo) this.f234e.get(this.f234e.size() - 1);
        if (itemInfo.f258b != 0) {
            f2 = itemInfo.f261e * clientWidth;
        }
        if (itemInfo2.f258b != this.f238i.getCount() - 1) {
            f3 = itemInfo2.f261e * clientWidth;
        }
        if (scrollX < f2) {
            scrollX = f2;
        } else if (scrollX > f3) {
            scrollX = f3;
        }
        int i = (int) scrollX;
        this.f205G += scrollX - ((float) i);
        scrollTo(i, getScrollY());
        m122c(i);
        MotionEvent obtain = MotionEvent.obtain(this.f216R, SystemClock.uptimeMillis(), 2, this.f205G, 0.0f, 0);
        this.f210L.addMovement(obtain);
        obtain.recycle();
    }

    /* access modifiers changed from: protected */
    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public BasePageAdapter getAdapter() {
        return this.f238i;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f229ah == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.f230ai.get(i2)).getLayoutParams()).f265d;
    }

    public int getCurrentItem() {
        return this.f239j;
    }

    public int getOffscreenPageLimit() {
        return this.f199A;
    }

    public int getPageMargin() {
        return this.f245p;
    }

    public boolean isFakeDragging() {
        return this.f215Q;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f219U = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f232ak);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.f245p > 0 && this.f246q != null && this.f234e.size() > 0 && this.f238i != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f3 = (float) width;
            float f4 = ((float) this.f245p) / f3;
            int i = 0;
            ItemInfo itemInfo = (ItemInfo) this.f234e.get(0);
            float f5 = itemInfo.f261e;
            int size = this.f234e.size();
            int i2 = itemInfo.f258b;
            int i3 = ((ItemInfo) this.f234e.get(size - 1)).f258b;
            while (i2 < i3) {
                while (i2 > itemInfo.f258b && i < size) {
                    i++;
                    itemInfo = (ItemInfo) this.f234e.get(i);
                }
                if (i2 == itemInfo.f258b) {
                    f = (itemInfo.f261e + itemInfo.f260d) * f3;
                    f5 = itemInfo.f261e + itemInfo.f260d + f4;
                } else {
                    float pageWidth = this.f238i.getPageWidth(i2);
                    f = (f5 + pageWidth) * f3;
                    f5 += pageWidth + f4;
                }
                if (((float) this.f245p) + f > ((float) scrollX)) {
                    f2 = f4;
                    this.f246q.setBounds((int) f, this.f247r, (int) (((float) this.f245p) + f + 0.5f), this.f248s);
                    this.f246q.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f2 = f4;
                }
                if (f <= ((float) (scrollX + width))) {
                    i2++;
                    f4 = f2;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        if (!this.f233al) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m128i();
            return false;
        }
        if (action != 0) {
            if (this.f200B) {
                return true;
            }
            if (this.f201C) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.f207I = x;
            this.f205G = x;
            float y = motionEvent.getY();
            this.f208J = y;
            this.f206H = y;
            this.f209K = motionEvent2.getPointerId(0);
            this.f201C = false;
            this.f243n.computeScrollOffset();
            if (this.f231aj != 2 || Math.abs(this.f243n.getFinalX() - this.f243n.getCurrX()) <= this.f214P) {
                m116a(false);
                this.f200B = false;
            } else {
                this.f243n.abortAnimation();
                this.f255z = false;
                mo323c();
                this.f200B = true;
                m121c(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.f209K;
            if (i != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i);
                float x2 = motionEvent2.getX(findPointerIndex);
                float f = x2 - this.f205G;
                float abs = Math.abs(f);
                float y2 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.f208J);
                if (f != 0.0f && !m117a(this.f205G, f)) {
                    if (mo313a(this, false, (int) f, (int) x2, (int) y2)) {
                        this.f205G = x2;
                        this.f206H = y2;
                        this.f201C = true;
                        return false;
                    }
                }
                if (abs > ((float) this.f204F) && abs * 0.5f > abs2) {
                    this.f200B = true;
                    m121c(true);
                    setScrollState(1);
                    this.f205G = f > 0.0f ? this.f207I + ((float) this.f204F) : this.f207I - ((float) this.f204F);
                    this.f206H = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) this.f204F)) {
                    this.f201C = true;
                }
                if (this.f200B && m120b(x2)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            m113a(motionEvent);
        }
        if (this.f210L == null) {
            this.f210L = VelocityTracker.obtain();
        }
        this.f210L.addMovement(motionEvent2);
        return this.f200B;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        int i6;
        int childCount = getChildCount();
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i9 = paddingBottom;
        int i10 = 0;
        int i11 = paddingTop;
        int i12 = paddingLeft;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i14 = layoutParams.gravity & 7;
                    int i15 = layoutParams.gravity & 112;
                    if (i14 == 1) {
                        i5 = Math.max((i7 - childAt.getMeasuredWidth()) / 2, i12);
                    } else if (i14 == 3) {
                        i5 = i12;
                        i12 = childAt.getMeasuredWidth() + i12;
                    } else if (i14 != 5) {
                        i5 = i12;
                    } else {
                        i5 = (i7 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i15 == 16) {
                        i6 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, i11);
                    } else if (i15 == 48) {
                        i6 = i11;
                        i11 = childAt.getMeasuredHeight() + i11;
                    } else if (i15 != 80) {
                        i6 = i11;
                    } else {
                        i6 = (i8 - i9) - childAt.getMeasuredHeight();
                        i9 += childAt.getMeasuredHeight();
                    }
                    int i16 = i5 + scrollX;
                    childAt.layout(i16, i6, childAt.getMeasuredWidth() + i16, i6 + childAt.getMeasuredHeight());
                    i10++;
                }
            }
        }
        int i17 = (i7 - i12) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor) {
                    ItemInfo a = mo306a(childAt2);
                    if (a != null) {
                        float f = (float) i17;
                        int i19 = ((int) (a.f261e * f)) + i12;
                        if (layoutParams2.f263b) {
                            layoutParams2.f263b = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.f262a), 1073741824), MeasureSpec.makeMeasureSpec((i8 - i11) - i9, 1073741824));
                        }
                        childAt2.layout(i19, i11, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + i11);
                    }
                }
            }
        }
        this.f247r = i11;
        this.f248s = i8 - i9;
        this.f222aa = i10;
        if (this.f219U) {
            z2 = false;
            m112a(this.f239j, false, 0, true);
        } else {
            z2 = false;
        }
        this.f219U = z2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r18, int r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = 0
            r2 = r18
            int r2 = getDefaultSize(r1, r2)
            r3 = r19
            int r3 = getDefaultSize(r1, r3)
            r0.setMeasuredDimension(r2, r3)
            int r2 = r17.getMeasuredWidth()
            int r3 = r2 / 10
            int r4 = r0.f202D
            int r3 = java.lang.Math.min(r3, r4)
            r0.f203E = r3
            int r3 = r17.getPaddingLeft()
            int r2 = r2 - r3
            int r3 = r17.getPaddingRight()
            int r2 = r2 - r3
            int r3 = r17.getMeasuredHeight()
            int r4 = r17.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r17.getPaddingBottom()
            int r3 = r3 - r4
            int r4 = r17.getChildCount()
            r5 = r3
            r3 = r2
            r2 = 0
        L_0x003f:
            r6 = 8
            r7 = 1
            r8 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r4) goto L_0x00c6
            android.view.View r9 = r0.getChildAt(r2)
            int r10 = r9.getVisibility()
            if (r10 == r6) goto L_0x00c1
            android.view.ViewGroup$LayoutParams r6 = r9.getLayoutParams()
            android.widget.PageView$LayoutParams r6 = (android.widget.PageView.LayoutParams) r6
            if (r6 == 0) goto L_0x00c1
            boolean r10 = r6.isDecor
            if (r10 == 0) goto L_0x00c1
            int r10 = r6.gravity
            r10 = r10 & 7
            int r11 = r6.gravity
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 48
            if (r11 == r12) goto L_0x006f
            r12 = 80
            if (r11 != r12) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r11 = 0
            goto L_0x0070
        L_0x006f:
            r11 = 1
        L_0x0070:
            r12 = 3
            if (r10 == r12) goto L_0x0078
            r12 = 5
            if (r10 != r12) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r7 = 0
        L_0x0078:
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r11 == 0) goto L_0x0081
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x007e:
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0085
        L_0x0081:
            if (r7 == 0) goto L_0x007e
            r12 = 1073741824(0x40000000, float:2.0)
        L_0x0085:
            int r13 = r6.width
            r14 = -1
            r15 = -2
            if (r13 == r15) goto L_0x0097
            int r10 = r6.width
            if (r10 == r14) goto L_0x0093
            int r10 = r6.width
            r13 = r10
            goto L_0x0094
        L_0x0093:
            r13 = r3
        L_0x0094:
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0098
        L_0x0097:
            r13 = r3
        L_0x0098:
            int r1 = r6.height
            if (r1 == r15) goto L_0x00a5
            int r1 = r6.height
            if (r1 == r14) goto L_0x00a3
            int r1 = r6.height
            goto L_0x00a7
        L_0x00a3:
            r1 = r5
            goto L_0x00a7
        L_0x00a5:
            r1 = r5
            r8 = r12
        L_0x00a7:
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r10)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            r9.measure(r6, r1)
            if (r11 == 0) goto L_0x00ba
            int r1 = r9.getMeasuredHeight()
            int r5 = r5 - r1
            goto L_0x00c1
        L_0x00ba:
            if (r7 == 0) goto L_0x00c1
            int r1 = r9.getMeasuredWidth()
            int r3 = r3 - r1
        L_0x00c1:
            int r2 = r2 + 1
            r1 = 0
            goto L_0x003f
        L_0x00c6:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r8)
            r0.f251v = r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            r0.f252w = r1
            r0.f253x = r7
            r17.mo323c()
            r1 = 0
            r0.f253x = r1
            int r2 = r17.getChildCount()
        L_0x00de:
            if (r1 >= r2) goto L_0x0108
            android.view.View r4 = r0.getChildAt(r1)
            int r5 = r4.getVisibility()
            if (r5 == r6) goto L_0x0105
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            android.widget.PageView$LayoutParams r5 = (android.widget.PageView.LayoutParams) r5
            if (r5 == 0) goto L_0x00f6
            boolean r7 = r5.isDecor
            if (r7 != 0) goto L_0x0105
        L_0x00f6:
            float r7 = (float) r3
            float r5 = r5.f262a
            float r7 = r7 * r5
            int r5 = (int) r7
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            int r7 = r0.f252w
            r4.measure(r5, r7)
        L_0x0105:
            int r1 = r1 + 1
            goto L_0x00de
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.PageView.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = childCount - 1;
            i2 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                ItemInfo a = mo306a(childAt);
                if (a != null && a.f258b == this.f239j && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i3 += i2;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f238i != null) {
            this.f238i.restoreState(savedState.f268b, savedState.f269c);
            mo311a(savedState.f267a, false, true);
            return;
        }
        this.f240k = savedState.f267a;
        this.f241l = savedState.f268b;
        this.f242m = savedState.f269c;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f267a = this.f239j;
        if (this.f238i != null) {
            savedState.f268b = this.f238i.saveState();
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m111a(i, i3, this.f245p, this.f245p);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011d, code lost:
        r2 = m128i();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.f215Q
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r8.getAction()
            r2 = 0
            if (r0 != 0) goto L_0x0014
            int r0 = r8.getEdgeFlags()
            if (r0 == 0) goto L_0x0014
            return r2
        L_0x0014:
            android.widget.BasePageAdapter r0 = r7.f238i
            if (r0 == 0) goto L_0x0148
            android.widget.BasePageAdapter r0 = r7.f238i
            int r0 = r0.getCount()
            if (r0 != 0) goto L_0x0021
            return r2
        L_0x0021:
            android.view.VelocityTracker r0 = r7.f210L
            if (r0 != 0) goto L_0x002b
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r7.f210L = r0
        L_0x002b:
            android.view.VelocityTracker r0 = r7.f210L
            r0.addMovement(r8)
            int r0 = r8.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            switch(r0) {
                case 0: goto L_0x0122;
                case 1: goto L_0x00da;
                case 2: goto L_0x0067;
                case 3: goto L_0x005c;
                case 4: goto L_0x0039;
                case 5: goto L_0x004c;
                case 6: goto L_0x003b;
                default: goto L_0x0039;
            }
        L_0x0039:
            goto L_0x0142
        L_0x003b:
            r7.m113a(r8)
            int r0 = r7.f209K
            int r0 = r8.findPointerIndex(r0)
            float r8 = r8.getX(r0)
            r7.f205G = r8
            goto L_0x0142
        L_0x004c:
            int r0 = r8.getActionIndex()
            float r3 = r8.getX(r0)
            r7.f205G = r3
            int r8 = r8.getPointerId(r0)
            goto L_0x0140
        L_0x005c:
            boolean r8 = r7.f200B
            if (r8 == 0) goto L_0x0142
            int r8 = r7.f239j
            r7.m112a(r8, r1, r2, r2)
            goto L_0x011d
        L_0x0067:
            boolean r0 = r7.f200B
            if (r0 != 0) goto L_0x00c6
            int r0 = r7.f209K
            int r0 = r8.findPointerIndex(r0)
            r3 = -1
            if (r0 != r3) goto L_0x0076
            goto L_0x011d
        L_0x0076:
            float r3 = r8.getX(r0)
            float r4 = r7.f205G
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            float r0 = r8.getY(r0)
            float r5 = r7.f206H
            float r5 = r0 - r5
            float r5 = java.lang.Math.abs(r5)
            int r6 = r7.f204F
            float r6 = (float) r6
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00c6
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00c6
            r7.f200B = r1
            r7.m121c(r1)
            float r4 = r7.f207I
            float r3 = r3 - r4
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x00ad
            float r3 = r7.f207I
            int r4 = r7.f204F
            float r4 = (float) r4
            float r3 = r3 + r4
            goto L_0x00b3
        L_0x00ad:
            float r3 = r7.f207I
            int r4 = r7.f204F
            float r4 = (float) r4
            float r3 = r3 - r4
        L_0x00b3:
            r7.f205G = r3
            r7.f206H = r0
            r7.setScrollState(r1)
            r7.setScrollingCacheEnabled(r1)
            android.view.ViewParent r0 = r7.getParent()
            if (r0 == 0) goto L_0x00c6
            r0.requestDisallowInterceptTouchEvent(r1)
        L_0x00c6:
            boolean r0 = r7.f200B
            if (r0 == 0) goto L_0x0142
            int r0 = r7.f209K
            int r0 = r8.findPointerIndex(r0)
            float r8 = r8.getX(r0)
            boolean r8 = r7.m120b(r8)
            r2 = r2 | r8
            goto L_0x0142
        L_0x00da:
            boolean r0 = r7.f200B
            if (r0 == 0) goto L_0x0142
            android.view.VelocityTracker r0 = r7.f210L
            r2 = 1000(0x3e8, float:1.401E-42)
            int r3 = r7.f212N
            float r3 = (float) r3
            r0.computeCurrentVelocity(r2, r3)
            int r2 = r7.f209K
            float r0 = r0.getXVelocity(r2)
            int r0 = (int) r0
            r7.f255z = r1
            int r2 = r7.getClientWidth()
            int r3 = r7.getScrollX()
            android.widget.PageView$ItemInfo r4 = r7.m129j()
            int r5 = r4.f258b
            float r3 = (float) r3
            float r2 = (float) r2
            float r3 = r3 / r2
            float r2 = r4.f261e
            float r3 = r3 - r2
            float r2 = r4.f260d
            float r3 = r3 / r2
            int r2 = r7.f209K
            int r2 = r8.findPointerIndex(r2)
            float r8 = r8.getX(r2)
            float r2 = r7.f207I
            float r8 = r8 - r2
            int r8 = (int) r8
            int r8 = r7.m109a(r5, r3, r0, r8)
            r7.mo312a(r8, r1, r1, r0)
        L_0x011d:
            boolean r2 = r7.m128i()
            goto L_0x0142
        L_0x0122:
            android.widget.Scroller r0 = r7.f243n
            r0.abortAnimation()
            r7.f255z = r2
            r7.mo323c()
            float r0 = r8.getX()
            r7.f207I = r0
            r7.f205G = r0
            float r0 = r8.getY()
            r7.f208J = r0
            r7.f206H = r0
            int r8 = r8.getPointerId(r2)
        L_0x0140:
            r7.f209K = r8
        L_0x0142:
            if (r2 == 0) goto L_0x0147
            r7.postInvalidateOnAnimation()
        L_0x0147:
            return r1
        L_0x0148:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.PageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.f223ab != null) {
            this.f223ab.remove(onPageChangeListener);
        }
    }

    public void removeView(View view) {
        if (this.f253x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(BasePageAdapter basePageAdapter) {
        if (this.f238i != null) {
            this.f238i.unregisterDataSetObserver(this.f244o);
            this.f238i.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f234e.size(); i++) {
                ItemInfo itemInfo = (ItemInfo) this.f234e.get(i);
                this.f238i.destroyItem((ViewGroup) this, itemInfo.f258b, itemInfo.f257a);
            }
            this.f238i.finishUpdate((ViewGroup) this);
            this.f234e.clear();
            m126g();
            this.f239j = 0;
            scrollTo(0, 0);
        }
        BasePageAdapter basePageAdapter2 = this.f238i;
        this.f238i = basePageAdapter;
        this.f237h = 0;
        if (this.f238i != null) {
            if (this.f244o == null) {
                this.f244o = new PageObserver();
            }
            this.f238i.registerDataSetObserver(this.f244o);
            this.f255z = false;
            boolean z = this.f219U;
            this.f219U = true;
            this.f237h = this.f238i.getCount();
            if (this.f240k >= 0) {
                this.f238i.restoreState(this.f241l, this.f242m);
                mo311a(this.f240k, false, true);
                this.f240k = -1;
                this.f241l = null;
                this.f242m = null;
            } else if (!z) {
                mo323c();
            } else {
                requestLayout();
            }
        }
        if (this.f226ae != null && basePageAdapter2 != basePageAdapter) {
            this.f226ae.onAdapterChanged(basePageAdapter2, basePageAdapter);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.f228ag == null) {
                try {
                    this.f228ag = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e) {
                    Log.e("PageView", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.f228ag.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e2) {
                Log.e("PageView", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f255z = false;
        mo311a(i, !this.f219U, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.f255z = false;
        mo311a(i, z, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested offscreen page limit ");
            sb.append(i);
            sb.append(" too small; defaulting to ");
            sb.append(1);
            Log.w("PageView", sb.toString());
            i = 1;
        }
        if (i != this.f199A) {
            this.f199A = i;
            mo323c();
        }
    }

    /* access modifiers changed from: 0000 */
    public void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        this.f226ae = onAdapterChangeListener;
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f224ac = onPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.f245p;
        this.f245p = i;
        int width = getWidth();
        m111a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f246q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        if (VERSION.SDK_INT >= 11) {
            int i = 1;
            boolean z2 = pageTransformer != null;
            boolean z3 = z2 != (this.f227af != null);
            this.f227af = pageTransformer;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                if (z) {
                    i = 2;
                }
                this.f229ah = i;
            } else {
                this.f229ah = 0;
            }
            if (z3) {
                mo323c();
            }
        }
    }

    public void setScrollEnabled(boolean z) {
        this.f233al = z;
    }

    public void setTouchEnabled(boolean z) {
        this.f233al = z;
    }

    public void showPage(int i) {
        setCurrentItem(i, true);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f246q;
    }
}
