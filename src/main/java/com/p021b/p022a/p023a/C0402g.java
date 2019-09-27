package com.p021b.p022a.p023a;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.p021b.p022a.p024b.C0408b;
import com.p021b.p022a.p024b.C0414f;

/* renamed from: com.b.a.a.g */
public class C0402g extends SimpleOnGestureListener {

    /* renamed from: a */
    protected static int f2934a = 10;

    /* renamed from: b */
    protected static int f2935b = 12;

    /* renamed from: e */
    private static final Rect f2936e = new Rect(0, 0, 0, 0);

    /* renamed from: c */
    protected C0383c f2937c;

    /* renamed from: d */
    protected boolean f2938d = false;

    /* renamed from: f */
    private GestureDetector f2939f;

    /* renamed from: g */
    private float f2940g;

    /* renamed from: h */
    private float f2941h;

    /* renamed from: i */
    private float f2942i;

    /* renamed from: j */
    private float f2943j;

    /* renamed from: k */
    private int f2944k;

    private C0402g() {
    }

    public C0402g(C0383c cVar) {
        this.f2937c = cVar;
        this.f2939f = new GestureDetector(cVar.getContext(), this);
        this.f2939f.setIsLongpressEnabled(true);
    }

    /* renamed from: a */
    private void m2525a(float f, float f2) {
        int scrollX = ((int) f) + this.f2937c.getScrollX();
        int scrollY = ((int) f2) + this.f2937c.getScrollY();
        int max = Math.max(this.f2937c.getMaxScrollX(), this.f2937c.getScrollX());
        if (scrollX > max) {
            scrollX = max;
        } else if (scrollX < 0) {
            scrollX = 0;
        }
        int max2 = Math.max(this.f2937c.getMaxScrollY(), this.f2937c.getScrollY());
        if (scrollY > max2) {
            scrollY = max2;
        } else if (scrollY < 0) {
            scrollY = 0;
        }
        this.f2937c.smoothScrollTo(scrollX, scrollY);
    }

    /* renamed from: b */
    private final boolean m2526b() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2527c(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.b.a.a.c r0 = r6.f2937c
            boolean r0 = r0.isSelectText()
            r1 = 1
            if (r0 != 0) goto L_0x0014
            boolean r0 = r6.m2526b()
            if (r0 == 0) goto L_0x0014
            com.b.a.a.c r0 = r6.f2937c
            r0.selectText(r1)
        L_0x0014:
            float r0 = r7.getX()
            int r0 = (int) r0
            com.b.a.a.c r2 = r6.f2937c
            int r2 = r2.getPaddingLeft()
            int r0 = r0 - r2
            float r2 = r7.getY()
            int r2 = (int) r2
            com.b.a.a.c r3 = r6.f2937c
            int r3 = r3.getPaddingTop()
            int r2 = r2 - r3
            int r3 = f2934a
            r4 = 0
            if (r0 >= r3) goto L_0x0039
            com.b.a.a.c r0 = r6.f2937c
            r1 = 2
        L_0x0034:
            boolean r4 = r0.mo2772d(r1)
            goto L_0x0061
        L_0x0039:
            com.b.a.a.c r3 = r6.f2937c
            int r3 = r3.getContentWidth()
            int r5 = f2934a
            int r3 = r3 - r5
            if (r0 < r3) goto L_0x0048
            com.b.a.a.c r0 = r6.f2937c
            r1 = 3
            goto L_0x0034
        L_0x0048:
            int r0 = f2934a
            if (r2 >= r0) goto L_0x0053
            com.b.a.a.c r0 = r6.f2937c
            boolean r4 = r0.mo2772d(r4)
            goto L_0x0061
        L_0x0053:
            com.b.a.a.c r0 = r6.f2937c
            int r0 = r0.getContentHeight()
            int r3 = f2934a
            int r0 = r0 - r3
            if (r2 < r0) goto L_0x0061
            com.b.a.a.c r0 = r6.f2937c
            goto L_0x0034
        L_0x0061:
            if (r4 != 0) goto L_0x0087
            com.b.a.a.c r0 = r6.f2937c
            r0.mo2757b()
            com.b.a.a.c r0 = r6.f2937c
            float r1 = r7.getX()
            int r1 = (int) r1
            int r1 = r6.mo2925a(r1)
            float r7 = r7.getY()
            int r7 = (int) r7
            int r7 = r6.mo2933b(r7)
            int r7 = r0.mo2753a(r1, r7)
            if (r7 < 0) goto L_0x0087
            com.b.a.a.c r0 = r6.f2937c
            r0.moveCaret(r7)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p023a.C0402g.m2527c(android.view.MotionEvent):void");
    }

    /* renamed from: d */
    private float m2528d(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    /* renamed from: e */
    private boolean m2529e(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 && motionEvent.getPointerCount() == 2) {
            if (this.f2940g == 0.0f) {
                float x = motionEvent.getX(0) - motionEvent.getX(1);
                float y = motionEvent.getY(0) - motionEvent.getY(1);
                this.f2940g = (float) Math.sqrt((double) ((x * x) + (y * y)));
                this.f2941h = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                this.f2942i = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                this.f2943j = this.f2937c.getTextSize();
            }
            float d = m2528d(motionEvent);
            if (this.f2940g != 0.0f) {
                this.f2937c.setTextSize((int) (this.f2943j * (d / this.f2940g)));
            }
            return true;
        }
        this.f2940g = 0.0f;
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo2925a(int i) {
        return (i - this.f2937c.getPaddingLeft()) + this.f2937c.getScrollX();
    }

    /* renamed from: a */
    public Rect mo2926a() {
        return f2936e;
    }

    /* renamed from: a */
    public void mo2927a(Canvas canvas) {
    }

    /* renamed from: a */
    public void mo2928a(C0408b bVar) {
    }

    /* renamed from: a */
    public void mo2929a(boolean z) {
    }

    /* renamed from: a */
    public boolean mo2930a(int i, int i2, int i3) {
        Rect c = this.f2937c.mo2758c(i3);
        return i2 >= c.top - f2935b && i2 < c.bottom + f2935b && i >= c.left - f2935b && i < c.right + f2935b;
    }

    /* renamed from: a */
    public boolean mo2931a(int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: a */
    public boolean mo2932a(MotionEvent motionEvent) {
        this.f2937c.mo2757b();
        this.f2938d = false;
        this.f2940g = 0.0f;
        this.f2944k = 0;
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final int mo2933b(int i) {
        return (i - this.f2937c.getPaddingTop()) + this.f2937c.getScrollY();
    }

    /* renamed from: b */
    public boolean mo2934b(int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: b */
    public boolean mo2935b(MotionEvent motionEvent) {
        m2529e(motionEvent);
        boolean onTouchEvent = this.f2939f.onTouchEvent(motionEvent);
        return (onTouchEvent || (motionEvent.getAction() & 255) != 1) ? onTouchEvent : mo2932a(motionEvent);
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        int i;
        this.f2938d = true;
        int a = this.f2937c.mo2753a(mo2925a((int) motionEvent.getX()), mo2933b((int) motionEvent.getY()));
        if (this.f2937c.isSelectText() && this.f2937c.inSelectionRange(a)) {
            C0414f createDocumentProvider = this.f2937c.createDocumentProvider();
            int c = createDocumentProvider.mo2982c(a);
            i = createDocumentProvider.mo2987e(c);
            a = createDocumentProvider.mo2987e(c + 1) - 1;
        } else if (a < 0) {
            return true;
        } else {
            this.f2937c.moveCaret(a);
            C0414f createDocumentProvider2 = this.f2937c.createDocumentProvider();
            i = a;
            while (i >= 0 && Character.isJavaIdentifierPart(createDocumentProvider2.charAt(i))) {
                i--;
            }
            if (i != a) {
                i++;
            }
            while (a >= 0 && Character.isJavaIdentifierPart(createDocumentProvider2.charAt(a))) {
                a++;
            }
            this.f2937c.selectText(true);
        }
        this.f2937c.setSelectionRange(i, a - i);
        return true;
    }

    public boolean onDown(MotionEvent motionEvent) {
        int a = mo2925a((int) motionEvent.getX());
        int b = mo2933b((int) motionEvent.getY());
        this.f2938d = mo2930a(a, b, this.f2937c.getCaretPosition());
        if (this.f2937c.isFlingScrolling()) {
            this.f2937c.stopFlingScrolling();
        } else if (this.f2937c.isSelectText()) {
            if (mo2930a(a, b, this.f2937c.getSelectionStart())) {
                this.f2937c.focusSelectionStart();
            } else if (mo2930a(a, b, this.f2937c.getSelectionEnd())) {
                this.f2937c.focusSelectionEnd();
            }
            this.f2937c.performHapticFeedback(0);
            this.f2938d = true;
        }
        if (this.f2938d) {
            this.f2937c.performHapticFeedback(0);
        }
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.f2938d) {
            if (this.f2944k == 1) {
                f2 = 0.0f;
            } else if (this.f2944k == -1) {
                f = 0.0f;
            }
            this.f2937c.mo2759c(((int) (-f)) * 2, ((int) (-f2)) * 2);
        }
        mo2932a(motionEvent2);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        onDoubleTap(motionEvent);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f2938d) {
            m2527c(motionEvent2);
        } else if (motionEvent2.getPointerCount() == 1) {
            if (this.f2944k == 0) {
                if (Math.abs(f) > Math.abs(f2)) {
                    this.f2944k = 1;
                } else {
                    this.f2944k = -1;
                }
            }
            if (this.f2944k == 1) {
                f2 = 0.0f;
            } else if (this.f2944k == -1) {
                f = 0.0f;
            }
            m2525a(f, f2);
        }
        if ((motionEvent2.getAction() & 255) == 1) {
            mo2932a(motionEvent2);
        }
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (r3 >= 0) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0064, code lost:
        if (r2 >= 0) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onSingleTapUp(android.view.MotionEvent r6) {
        /*
            r5 = this;
            com.b.a.a.c r0 = r5.f2937c
            boolean r0 = r0.isAccessibilityEnabled()
            r1 = 1
            if (r0 == 0) goto L_0x000f
            com.b.a.a.c r6 = r5.f2937c
            r6.mo2754a(r1)
            return r1
        L_0x000f:
            float r0 = r6.getX()
            int r0 = (int) r0
            int r0 = r5.mo2925a(r0)
            float r6 = r6.getY()
            int r6 = (int) r6
            int r6 = r5.mo2933b(r6)
            com.b.a.a.c r2 = r5.f2937c
            int r2 = r2.mo2753a(r0, r6)
            com.b.a.a.c r3 = r5.f2937c
            boolean r3 = r3.isSelectText()
            if (r3 == 0) goto L_0x0064
            com.b.a.a.c r3 = r5.f2937c
            int r3 = r3.mo2755b(r0, r6)
            com.b.a.a.c r4 = r5.f2937c
            boolean r4 = r4.inSelectionRange(r3)
            if (r4 != 0) goto L_0x0067
            com.b.a.a.c r4 = r5.f2937c
            int r4 = r4.getSelectionStart()
            boolean r4 = r5.mo2930a(r0, r6, r4)
            if (r4 != 0) goto L_0x0067
            com.b.a.a.c r4 = r5.f2937c
            int r4 = r4.getSelectionEnd()
            boolean r6 = r5.mo2930a(r0, r6, r4)
            if (r6 == 0) goto L_0x0056
            goto L_0x0067
        L_0x0056:
            com.b.a.a.c r6 = r5.f2937c
            r0 = 0
            r6.selectText(r0)
            if (r3 < 0) goto L_0x0067
        L_0x005e:
            com.b.a.a.c r6 = r5.f2937c
            r6.moveCaret(r2)
            goto L_0x0067
        L_0x0064:
            if (r2 < 0) goto L_0x0067
            goto L_0x005e
        L_0x0067:
            com.b.a.a.c r6 = r5.f2937c
            r6.mo2754a(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p023a.C0402g.onSingleTapUp(android.view.MotionEvent):boolean");
    }
}
