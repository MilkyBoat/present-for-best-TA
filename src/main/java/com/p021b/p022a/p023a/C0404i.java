package com.p021b.p022a.p023a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.p021b.p022a.p024b.C0408b;
import com.p021b.p022a.p024b.C0408b.C0409a;
import com.p021b.p022a.p024b.C0424m;

/* renamed from: com.b.a.a.i */
public class C0404i extends C0402g {

    /* renamed from: e */
    private final C0405a f2949e;

    /* renamed from: f */
    private final C0405a f2950f;

    /* renamed from: g */
    private final C0405a f2951g;

    /* renamed from: h */
    private boolean f2952h = false;

    /* renamed from: i */
    private boolean f2953i = false;

    /* renamed from: j */
    private boolean f2954j = false;

    /* renamed from: k */
    private boolean f2955k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f2956l;

    /* renamed from: com.b.a.a.i$a */
    private class C0405a {

        /* renamed from: a */
        public final Rect f2957a = new Rect(mo2944a(), 0, 0, this.f2960d.bottom + this.f2959c);

        /* renamed from: c */
        private final int f2959c = (C0404i.this.f2956l / 3);

        /* renamed from: d */
        private final Rect f2960d = new Rect(0, 0, C0404i.this.f2956l, C0404i.this.f2956l);

        /* renamed from: e */
        private int f2961e = 0;

        /* renamed from: f */
        private int f2962f = 0;

        /* renamed from: g */
        private int f2963g = 0;

        /* renamed from: h */
        private int f2964h = 0;

        /* renamed from: i */
        private int f2965i = 0;

        /* renamed from: j */
        private int f2966j = 0;

        /* renamed from: k */
        private final Paint f2967k = new Paint();

        /* renamed from: l */
        private boolean f2968l;

        public C0405a() {
            this.f2967k.setColor(C0404i.this.f2937c.getColorScheme().mo2957a(C0409a.CARET_BACKGROUND));
            this.f2967k.setAntiAlias(true);
        }

        /* renamed from: f */
        private void m2549f() {
            int i;
            int i2;
            int i3;
            int a = this.f2963g + mo2944a();
            if (a >= this.f2961e) {
                i = a + 1;
                a = this.f2961e;
            } else {
                i = this.f2961e + 1;
            }
            if (this.f2964h >= this.f2962f) {
                i3 = this.f2962f;
                i2 = this.f2964h;
            } else {
                i3 = this.f2964h;
                i2 = this.f2962f;
            }
            C0404i.this.f2937c.invalidate(a, i3, i, i2);
            mo2948b();
        }

        /* renamed from: a */
        public final int mo2944a() {
            return this.f2960d.right / 2;
        }

        /* renamed from: a */
        public void mo2945a(int i) {
            this.f2967k.setColor(i);
        }

        /* renamed from: a */
        public void mo2946a(int i, int i2) {
            m2549f();
            mo2949b(i, i2);
            m2549f();
        }

        /* renamed from: a */
        public void mo2947a(Canvas canvas, boolean z) {
            int a = mo2944a();
            canvas.drawLine((float) this.f2961e, (float) this.f2962f, (float) (this.f2963g + a), (float) (this.f2964h + a), this.f2967k);
            int i = a / 2;
            canvas.drawArc(new RectF((float) (this.f2961e - a), (float) ((this.f2962f - i) - this.f2959c), (float) (this.f2963g + (a * 2)), (float) (this.f2964h + i)), 60.0f, 60.0f, true, this.f2967k);
            canvas.drawOval(new RectF((float) this.f2963g, (float) this.f2964h, (float) (this.f2963g + this.f2960d.right), (float) (this.f2964h + this.f2960d.bottom)), this.f2967k);
        }

        /* renamed from: b */
        public void mo2948b() {
            C0404i.this.f2937c.invalidate(new Rect(this.f2963g, this.f2964h, this.f2963g + this.f2960d.right, this.f2964h + this.f2960d.bottom));
        }

        /* renamed from: b */
        public void mo2949b(int i, int i2) {
            this.f2961e = i;
            this.f2962f = i2;
            this.f2963g = i - mo2944a();
            this.f2964h = i2 + this.f2959c;
        }

        /* renamed from: c */
        public C0424m mo2950c(int i, int i2) {
            int a = (C0404i.this.mo2925a(i) - this.f2965i) + mo2944a();
            int b = ((C0404i.this.mo2933b(i2) - this.f2966j) - this.f2959c) - 2;
            return new C0424m(C0404i.this.f2937c.mo2753a(a, b), C0404i.this.f2937c.mo2755b(a, b));
        }

        /* renamed from: c */
        public void mo2951c() {
            this.f2965i = 0;
            this.f2966j = 0;
        }

        /* renamed from: d */
        public void mo2952d() {
            this.f2968l = true;
        }

        /* renamed from: d */
        public void mo2953d(int i, int i2) {
            this.f2965i = i - this.f2963g;
            this.f2966j = i2 - this.f2964h;
        }

        /* renamed from: e */
        public void mo2954e() {
            this.f2968l = false;
        }

        /* renamed from: e */
        public boolean mo2955e(int i, int i2) {
            return this.f2968l && i >= this.f2963g && i < this.f2963g + this.f2960d.right && i2 >= this.f2964h && i2 < this.f2964h + this.f2960d.bottom;
        }
    }

    public C0404i(C0383c cVar) {
        super(cVar);
        this.f2956l = (int) TypedValue.applyDimension(2, (float) (((double) C0383c.f2851d) * 1.5d), cVar.getContext().getResources().getDisplayMetrics());
        this.f2949e = new C0405a();
        this.f2950f = new C0405a();
        this.f2951g = new C0405a();
    }

    /* renamed from: a */
    private void m2544a(C0405a aVar, MotionEvent motionEvent) {
        int a = aVar.mo2950c((int) motionEvent.getX(), (int) motionEvent.getY()).mo3047a();
        if (a >= 0) {
            this.f2937c.moveCaret(a);
            Rect c = this.f2937c.mo2758c(a);
            aVar.mo2946a(c.left + this.f2937c.getPaddingLeft(), c.bottom + this.f2937c.getPaddingTop());
        }
    }

    /* renamed from: a */
    public Rect mo2926a() {
        return this.f2949e.f2957a;
    }

    /* renamed from: a */
    public void mo2927a(Canvas canvas) {
        if (!this.f2937c.isSelectText2()) {
            this.f2949e.mo2952d();
            this.f2950f.mo2954e();
            this.f2951g.mo2954e();
            if (!this.f2954j) {
                Rect c = this.f2937c.mo2758c(this.f2937c.getCaretPosition());
                this.f2949e.mo2949b(c.left + this.f2937c.getPaddingLeft(), c.bottom + this.f2937c.getPaddingTop());
            }
            if (this.f2955k) {
                this.f2949e.mo2947a(canvas, this.f2954j);
            }
            this.f2955k = false;
            return;
        }
        this.f2949e.mo2954e();
        this.f2950f.mo2952d();
        this.f2951g.mo2952d();
        if (!this.f2952h || !this.f2953i) {
            Rect c2 = this.f2937c.mo2758c(this.f2937c.getSelectionStart());
            this.f2950f.mo2949b(c2.left + this.f2937c.getPaddingLeft(), c2.bottom + this.f2937c.getPaddingTop());
            Rect c3 = this.f2937c.mo2758c(this.f2937c.getSelectionEnd());
            this.f2951g.mo2949b(c3.left + this.f2937c.getPaddingLeft(), c3.bottom + this.f2937c.getPaddingTop());
        }
        this.f2950f.mo2947a(canvas, this.f2952h);
        this.f2951g.mo2947a(canvas, this.f2952h);
    }

    /* renamed from: a */
    public void mo2928a(C0408b bVar) {
        this.f2949e.mo2945a(bVar.mo2957a(C0409a.CARET_BACKGROUND));
    }

    /* renamed from: a */
    public boolean mo2932a(MotionEvent motionEvent) {
        this.f2954j = false;
        this.f2952h = false;
        this.f2953i = false;
        this.f2949e.mo2951c();
        this.f2950f.mo2951c();
        this.f2951g.mo2951c();
        super.mo2932a(motionEvent);
        return true;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        int x = ((int) motionEvent.getX()) + this.f2937c.getScrollX();
        int y = ((int) motionEvent.getY()) + this.f2937c.getScrollY();
        if (this.f2949e.mo2955e(x, y)) {
            this.f2937c.selectText(true);
            return true;
        } else if (this.f2950f.mo2955e(x, y)) {
            return true;
        } else {
            return super.onDoubleTap(motionEvent);
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        C0405a aVar;
        super.onDown(motionEvent);
        if (!this.f2938d) {
            int x = ((int) motionEvent.getX()) + this.f2937c.getScrollX();
            int y = ((int) motionEvent.getY()) + this.f2937c.getScrollY();
            this.f2954j = this.f2949e.mo2955e(x, y);
            this.f2952h = this.f2950f.mo2955e(x, y);
            this.f2953i = this.f2951g.mo2955e(x, y);
            if (this.f2954j) {
                this.f2955k = true;
                this.f2949e.mo2953d(x, y);
                aVar = this.f2949e;
            } else if (this.f2952h) {
                this.f2950f.mo2953d(x, y);
                this.f2937c.focusSelectionStart();
                aVar = this.f2950f;
            } else if (this.f2953i) {
                this.f2951g.mo2953d(x, y);
                this.f2937c.focusSelectionEnd();
                aVar = this.f2951g;
            }
            aVar.mo2948b();
            return true;
        }
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.f2954j && !this.f2952h && !this.f2953i) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
        mo2932a(motionEvent2);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        onDoubleTap(motionEvent);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f2954j) {
            if ((motionEvent2.getAction() & 255) == 1) {
                mo2932a(motionEvent2);
                return true;
            }
            this.f2955k = true;
            m2544a(this.f2949e, motionEvent2);
            return true;
        } else if (this.f2952h) {
            if ((motionEvent2.getAction() & 255) == 1) {
                mo2932a(motionEvent2);
                return true;
            }
            m2544a(this.f2950f, motionEvent2);
            return true;
        } else if (!this.f2953i) {
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        } else {
            if ((motionEvent2.getAction() & 255) == 1) {
                mo2932a(motionEvent2);
                return true;
            }
            m2544a(this.f2951g, motionEvent2);
            return true;
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int x = ((int) motionEvent.getX()) + this.f2937c.getScrollX();
        int y = ((int) motionEvent.getY()) + this.f2937c.getScrollY();
        if (this.f2949e.mo2955e(x, y) || this.f2950f.mo2955e(x, y) || this.f2951g.mo2955e(x, y)) {
            return true;
        }
        this.f2955k = true;
        return super.onSingleTapUp(motionEvent);
    }
}
