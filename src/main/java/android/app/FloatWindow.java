package android.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import bsh.org.objectweb.asm.Constants;

public class FloatWindow {

    /* renamed from: a */
    private Context f0a;

    /* renamed from: b */
    private TitleBar f1b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WindowManager f2c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LayoutParams f3d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LinearLayout f4e;

    /* renamed from: f */
    private FrameLayout f5f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f6g;

    /* renamed from: h */
    private DisplayMetrics f7h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f8i = m0a();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f9j = m7b();

    private class ContentView extends LinearLayout {

        /* renamed from: b */
        private int f11b = 0;

        /* renamed from: c */
        private int f12c = 0;

        /* renamed from: d */
        private int f13d;

        /* renamed from: e */
        private int f14e;

        /* renamed from: f */
        private int f15f;

        /* renamed from: g */
        private int f16g;

        /* renamed from: h */
        private int f17h;

        /* renamed from: i */
        private int f18i;

        /* renamed from: j */
        private boolean f19j;

        /* renamed from: k */
        private int f20k;

        /* renamed from: l */
        private boolean f21l;

        public ContentView(Context context) {
            super(context);
            this.f20k = FloatWindow.this.m1a(8.0f);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            FloatWindow floatWindow;
            boolean z;
            if (motionEvent.getAction() == 4) {
                floatWindow = FloatWindow.this;
                z = false;
            } else {
                if (motionEvent.getAction() == 0) {
                    floatWindow = FloatWindow.this;
                    z = true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
            floatWindow.m6a(z);
            return super.onInterceptTouchEvent(motionEvent);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            this.f13d = (int) motionEvent.getRawY();
            this.f14e = (int) motionEvent.getRawX();
            if (motionEvent.getAction() == 4) {
                FloatWindow.this.m6a(false);
            } else if (motionEvent.getAction() == 0) {
                FloatWindow.this.m6a(true);
            }
            if (motionEvent.getAction() == 0) {
                if (((float) getWidth()) - motionEvent.getX() < ((float) this.f20k)) {
                    this.f19j = true;
                }
                if (((float) getHeight()) - motionEvent.getY() < ((float) this.f20k)) {
                    this.f21l = true;
                }
                this.f15f = getWidth();
                this.f16g = getHeight();
                this.f12c = this.f13d;
                this.f11b = this.f14e;
                this.f17h = FloatWindow.this.f3d.x;
                this.f18i = FloatWindow.this.f3d.y;
                return true;
            } else if (motionEvent.getAction() == 2) {
                FloatWindow.this.f3d.x = this.f17h;
                FloatWindow.this.f3d.y = this.f18i;
                if (this.f19j) {
                    FloatWindow.this.f3d.width = Math.min(this.f15f + (this.f14e - this.f11b), FloatWindow.this.f8i);
                }
                if (this.f21l) {
                    FloatWindow.this.f3d.height = Math.min(this.f16g + (this.f13d - this.f12c), FloatWindow.this.f9j);
                }
                FloatWindow.this.f2c.updateViewLayout(FloatWindow.this.f4e, FloatWindow.this.f3d);
                return true;
            } else {
                if (motionEvent.getAction() == 1) {
                    this.f19j = false;
                    this.f21l = false;
                }
                return true;
            }
        }
    }

    private class TitleBar extends LinearLayout {

        /* renamed from: b */
        private TextView f23b;

        public TitleBar(Context context) {
            super(context);
            this.f23b = new TitleView(context);
            this.f23b.setSingleLine(true);
            TextView textView = new TextView(context);
            textView.setText("X");
            textView.setGravity(17);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(1140850943);
            gradientDrawable.setCornerRadius(4.0f);
            gradientDrawable.setStroke(2, FloatWindow.this.f6g);
            gradientDrawable.setAlpha(Constants.L2I);
            textView.setBackgroundDrawable(gradientDrawable);
            textView.setTextSize(1, 18.0f);
            textView.setOnClickListener(new OnClickListener(FloatWindow.this) {
                public void onClick(View view) {
                    FloatWindow.this.dismiss();
                }
            });
            addView(this.f23b, new LinearLayout.LayoutParams(-1, FloatWindow.this.m1a(24.0f), 1.0f));
            addView(textView, new LinearLayout.LayoutParams(FloatWindow.this.m1a(24.0f), FloatWindow.this.m1a(24.0f)));
        }

        public void setTitle(CharSequence charSequence) {
            this.f23b.setText(charSequence);
        }
    }

    private class TitleView extends TextView {

        /* renamed from: b */
        private int f27b = 0;

        /* renamed from: c */
        private int f28c = 0;

        /* renamed from: d */
        private int f29d = 0;

        /* renamed from: e */
        private int f30e = 0;

        /* renamed from: f */
        private int f31f = 0;

        /* renamed from: g */
        private int f32g;

        /* renamed from: h */
        private int f33h;

        public TitleView(Context context) {
            super(context);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            this.f31f = rect.top;
            this.f32g = (int) motionEvent.getRawY();
            this.f33h = (int) motionEvent.getRawX();
            if (motionEvent.getAction() == 0) {
                this.f30e = this.f32g - ((int) motionEvent.getY());
                this.f29d = this.f33h - ((int) motionEvent.getX());
                this.f28c = this.f32g;
                this.f27b = this.f33h;
            } else if (motionEvent.getAction() == 2) {
                FloatWindow.this.f3d.gravity = 51;
                FloatWindow.this.f3d.x = this.f29d + (this.f33h - this.f27b);
                FloatWindow.this.f3d.y = ((this.f30e + (this.f32g - this.f28c)) - this.f31f) + 3;
                FloatWindow.this.f2c.updateViewLayout(FloatWindow.this.f4e, FloatWindow.this.f3d);
            }
            return true;
        }
    }

    public FloatWindow(Context context) {
        this.f0a = context;
        this.f7h = context.getResources().getDisplayMetrics();
        m5a(context);
    }

    /* renamed from: a */
    private int m0a() {
        return this.f0a.getResources().getDisplayMetrics().widthPixels;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m1a(float f) {
        return (int) TypedValue.applyDimension(1, f, this.f7h);
    }

    /* renamed from: a */
    private void m5a(Context context) {
        this.f2c = (WindowManager) context.getApplicationContext().getSystemService("window");
        this.f3d = new LayoutParams();
        this.f3d.format = 1;
        this.f3d.flags = 262176;
        this.f3d.type = 2002;
        this.f3d.width = -2;
        this.f3d.height = -2;
        this.f4e = new ContentView(context);
        this.f4e.setPadding(m1a(8.0f), m1a(8.0f), m1a(8.0f), m1a(8.0f));
        this.f4e.setOrientation(1);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842801, 16842806});
        int color = obtainStyledAttributes.getColor(0, 16711935);
        this.f6g = obtainStyledAttributes.getColor(1, 16711935);
        obtainStyledAttributes.recycle();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(4.0f);
        gradientDrawable.setStroke(2, this.f6g);
        gradientDrawable.setAlpha(Constants.L2I);
        this.f4e.setBackgroundDrawable(gradientDrawable);
        this.f2c.addView(this.f4e, this.f3d);
        this.f4e.setVisibility(8);
        this.f1b = new TitleBar(context);
        this.f5f = new FrameLayout(context);
        this.f4e.addView(this.f1b);
        this.f4e.addView(this.f5f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6a(boolean z) {
        LayoutParams layoutParams;
        int i = 8;
        if (!z) {
            layoutParams = this.f3d;
        } else if (this.f3d.flags == 8) {
            this.f2c.removeView(this.f4e);
            this.f2c.addView(this.f4e, this.f3d);
            layoutParams = this.f3d;
            i = 262176;
        } else {
            return;
        }
        layoutParams.flags = i;
        this.f2c.updateViewLayout(this.f4e, this.f3d);
    }

    /* renamed from: b */
    private int m7b() {
        return this.f0a.getResources().getDisplayMetrics().heightPixels;
    }

    public void dismiss() {
        this.f2c.removeView(this.f4e);
    }

    public Drawable getBackground() {
        return this.f4e.getBackground();
    }

    public void hide() {
        this.f4e.setVisibility(8);
    }

    public void setBackground(Drawable drawable) {
        this.f4e.setBackgroundDrawable(drawable);
    }

    public void setContentView(View view) {
        this.f5f.removeAllViews();
        this.f5f.addView(view);
    }

    public void setFlags(int i) {
        this.f3d.flags = i;
        this.f2c.updateViewLayout(this.f4e, this.f3d);
    }

    public void setFormat(int i) {
        this.f3d.format = i;
        this.f2c.updateViewLayout(this.f4e, this.f3d);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1b.setTitle(charSequence);
    }

    public void setType(int i) {
        this.f3d.type = i;
        this.f2c.updateViewLayout(this.f4e, this.f3d);
    }

    public void show() {
        this.f4e.setVisibility(0);
    }
}
