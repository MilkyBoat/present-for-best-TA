package com.p021b.p022a.p023a;

import android.view.MotionEvent;

/* renamed from: com.b.a.a.h */
public class C0403h extends C0402g {

    /* renamed from: f */
    private static int f2945f = 16;

    /* renamed from: e */
    private int f2946e;

    /* renamed from: g */
    private float f2947g = 0.0f;

    /* renamed from: h */
    private float f2948h = 0.0f;

    public C0403h(C0383c cVar) {
        super(cVar);
        f2945f = this.f2937c.mo2751a() * 2;
    }

    /* renamed from: a */
    private void m2541a(float f, float f2) {
        if ((this.f2947g < 0.0f && f > 0.0f) || (this.f2947g > 0.0f && f < 0.0f)) {
            this.f2947g = 0.0f;
        }
        if ((this.f2948h < 0.0f && f2 > 0.0f) || (this.f2948h > 0.0f && f2 < 0.0f)) {
            this.f2948h = 0.0f;
        }
        double atan2 = Math.atan2((double) Math.abs(f), (double) Math.abs(f2));
        if (atan2 >= 0.322d) {
            float f3 = this.f2947g + f;
            int i = ((int) f3) / f2945f;
            this.f2947g = f3 - ((float) (f2945f * i));
            while (i > 0) {
                this.f2937c.moveCaretRight();
                i--;
                if (this.f2946e == 0) {
                    this.f2946e = 1;
                }
            }
            while (i < 0) {
                this.f2937c.moveCaretLeft();
                i++;
                if (this.f2946e == 0) {
                    this.f2946e = 1;
                }
            }
        }
        if (1.5707963267948966d - atan2 >= 0.322d) {
            float f4 = this.f2948h + f2;
            int i2 = ((int) f4) / f2945f;
            this.f2948h = f4 - ((float) (f2945f * i2));
            for (int i3 = i2; i3 > 0; i3--) {
                this.f2937c.moveCaretDown();
                if (this.f2946e == 0) {
                    this.f2946e = -1;
                }
            }
            while (i2 < 0) {
                this.f2937c.moveCaretUp();
                if (this.f2946e == 0) {
                    this.f2946e = -1;
                }
                i2++;
            }
        }
    }

    /* renamed from: a */
    public boolean mo2932a(MotionEvent motionEvent) {
        this.f2947g = 0.0f;
        this.f2948h = 0.0f;
        this.f2946e = 0;
        super.mo2932a(motionEvent);
        return true;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.f2937c.setSelected(!this.f2937c.isSelectText());
        this.f2937c.setSelectionRange(this.f2937c.getCaretPosition(), 0);
        return true;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.f2946e = 0;
        f2945f = this.f2937c.mo2751a() * 2;
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        mo2932a(motionEvent2);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.f2937c.setSelected(!this.f2937c.isSelectText());
        this.f2937c.setSelectionRange(this.f2937c.getCaretPosition(), 0);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f2946e == 1) {
            f2 = 0.0f;
        } else if (this.f2946e == -1) {
            f = 0.0f;
        }
        m2541a(-f, -f2);
        if ((motionEvent2.getAction() & 255) == 1) {
            mo2932a(motionEvent2);
        }
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return super.onSingleTapConfirmed(motionEvent);
    }
}
