package android.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.androlua.util.TimerTaskX;
import com.androlua.util.TimerX;

public class RippleHelper extends Drawable implements OnTouchListener {

    /* renamed from: a */
    private final DisplayMetrics f367a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f368b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f369c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f370d;

    /* renamed from: e */
    private boolean f371e;

    /* renamed from: f */
    private boolean f372f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f373g;

    /* renamed from: h */
    private TimerX f374h;

    /* renamed from: i */
    private task f375i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Paint f376j;

    /* renamed from: k */
    private float f377k;

    /* renamed from: l */
    private float f378l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View f379m;

    /* renamed from: n */
    private Drawable f380n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f381o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f382p;

    /* renamed from: q */
    private int f383q;

    /* renamed from: r */
    private int f384r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f385s;

    private class task extends TimerTaskX {
        private task() {
        }

        public void run() {
            RippleHelper rippleHelper;
            int c;
            int d;
            switch (RippleHelper.this.f368b) {
                case 1:
                    if (RippleHelper.this.f382p) {
                        rippleHelper = RippleHelper.this;
                        c = RippleHelper.this.f373g;
                        d = Math.max(RippleHelper.this.f373g / 16, RippleHelper.this.f370d);
                    } else {
                        rippleHelper = RippleHelper.this;
                        c = RippleHelper.this.f373g;
                        d = RippleHelper.this.f370d;
                    }
                    rippleHelper.f373g = c + d;
                    RippleHelper.this.f385s = Math.min(RippleHelper.this.f381o, RippleHelper.this.f373g / RippleHelper.this.f370d);
                    RippleHelper.this.f379m.postInvalidate();
                    break;
                case 2:
                    RippleHelper.this.f373g = RippleHelper.this.f373g + (RippleHelper.this.f370d * 4);
                    RippleHelper.this.f385s = Math.min(RippleHelper.this.f381o, (RippleHelper.this.f373g / RippleHelper.this.f370d) * 2);
                    RippleHelper.this.f379m.postInvalidate();
                    if (RippleHelper.this.f373g / RippleHelper.this.f369c >= 1) {
                        RippleHelper.this.f373g = RippleHelper.this.f369c;
                        RippleHelper.this.f385s = RippleHelper.this.f381o;
                        RippleHelper.this.f368b = 3;
                        return;
                    }
                    break;
                case 3:
                    RippleHelper.this.f385s = RippleHelper.this.f385s - Math.max(RippleHelper.this.f385s / 16, 4);
                    RippleHelper.this.f376j.setAlpha(RippleHelper.this.f385s);
                    RippleHelper.this.f379m.postInvalidate();
                    if (RippleHelper.this.f385s < 4) {
                        RippleHelper.this.f368b = 0;
                        return;
                    }
                    break;
                default:
                    RippleHelper.this.f373g = 0;
                    setEnabled(false);
                    return;
            }
        }
    }

    public RippleHelper(View view) {
        this.f379m = view;
        this.f367a = view.getResources().getDisplayMetrics();
        m196a();
    }

    /* renamed from: a */
    private int m193a(float f) {
        return (int) TypedValue.applyDimension(1, f, this.f367a);
    }

    /* renamed from: a */
    private void m196a() {
        if (this.f379m.isClickable()) {
            this.f372f = true;
        }
        this.f380n = this.f379m.getBackground();
        this.f379m.setBackgroundDrawable(this);
        this.f379m.setOnTouchListener(this);
        this.f376j = new Paint();
        this.f376j.setColor(1152035498);
        this.f376j.setAntiAlias(true);
        this.f376j.setStrokeWidth((float) m193a(4.0f));
        this.f381o = this.f376j.getAlpha();
        this.f374h = new TimerX();
        this.f375i = new task();
        this.f374h.schedule((TimerTaskX) this.f375i, 0, 16);
        this.f375i.setEnabled(false);
        this.f373g = 0;
    }

    public void draw(Canvas canvas) {
        if (this.f380n != null) {
            this.f380n.setBounds(getBounds());
            this.f380n.draw(canvas);
        }
        this.f376j.setColor(this.f384r);
        this.f376j.setAlpha(this.f385s);
        if (this.f368b != 0) {
            if (this.f371e) {
                canvas.drawCircle(this.f377k, this.f378l, (float) this.f369c, this.f376j);
            } else {
                canvas.drawRect(getBounds(), this.f376j);
            }
            int i = this.f369c;
            if (this.f382p) {
                canvas.drawCircle(this.f377k, this.f378l, (float) Math.min(this.f373g, this.f369c), this.f376j);
                return;
            }
            int i2 = this.f373g;
            int i3 = 0;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                canvas.drawCircle(this.f377k, this.f378l, (float) Math.min(i2, i), this.f376j);
                i3++;
                if (i3 >= 2) {
                    Paint paint = this.f376j;
                    RadialGradient radialGradient = new RadialGradient(this.f377k, this.f378l, (float) m193a(6.0f), new int[]{1157627903, this.f383q, 1140850688}, null, TileMode.MIRROR);
                    paint.setShader(radialGradient);
                    this.f376j.setStyle(Style.STROKE);
                    this.f376j.setColor(this.f383q);
                    canvas.drawCircle(this.f377k, this.f378l, (float) (this.f373g % i), this.f376j);
                    break;
                }
                i2 -= i;
            }
            this.f376j.setShader(null);
            this.f376j.setStyle(Style.FILL);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public boolean isCircle() {
        return this.f371e;
    }

    public boolean isSingle() {
        return this.f382p;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        onTouchEvent(motionEvent);
        return false;
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        int hypot;
        if (this.f379m.hasOnClickListeners() || this.f372f) {
            switch (motionEvent.getAction()) {
                case 0:
                    Rect bounds = getBounds();
                    if (this.f371e) {
                        this.f378l = (float) (bounds.bottom / 2);
                        this.f377k = (float) (bounds.right / 2);
                        hypot = Math.max(bounds.bottom, bounds.right) / 2;
                    } else {
                        this.f377k = motionEvent.getX();
                        this.f378l = motionEvent.getY();
                        hypot = (int) Math.hypot((double) bounds.bottom, (double) bounds.right);
                    }
                    this.f369c = hypot;
                    this.f370d = Math.max(this.f369c / 60, 1);
                    this.f373g = 0;
                    this.f375i.setEnabled(true);
                    this.f376j.setAlpha(this.f381o);
                    this.f368b = 1;
                    return;
                case 1:
                case 3:
                case 4:
                    this.f368b = 2;
                    return;
                default:
                    return;
            }
        }
    }

    public void setAlpha(int i) {
        this.f381o = i;
        this.f376j.setAlpha(i);
    }

    public void setBackgroundColor(int i) {
        this.f380n = new ColorDrawable(i);
    }

    public void setCircle(boolean z) {
        this.f371e = z;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f376j.setColorFilter(colorFilter);
    }

    public void setRippleColor(int i) {
        this.f384r = i;
        this.f376j.setColor(i);
        this.f381o = this.f376j.getAlpha();
    }

    public void setRippleLineColor(int i) {
        this.f383q = i;
    }

    public void setSingle(boolean z) {
        this.f382p = z;
    }
}
