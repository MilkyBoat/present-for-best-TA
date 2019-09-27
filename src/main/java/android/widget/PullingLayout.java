package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.util.Timer;
import java.util.TimerTask;

public class PullingLayout extends RelativeLayout {
    public static final int DONE = 5;
    public static final int FAIL = 1;
    public static final int INIT = 0;
    public static final int LOADING = 4;
    public static final int NOTHING = 2;
    public static final int REFRESHING = 2;
    public static final int RELEASE_TO_LOAD = 3;
    public static final int RELEASE_TO_REFRESH = 1;
    public static final int SUCCEED = 0;
    public static final String TAG = "PullToRefreshLayout";

    /* renamed from: A */
    private View f270A;

    /* renamed from: B */
    private int f271B;

    /* renamed from: C */
    private boolean f272C = true;

    /* renamed from: D */
    private boolean f273D = true;

    /* renamed from: E */
    private Context f274E;

    /* renamed from: F */
    private boolean f275F;

    /* renamed from: G */
    private boolean f276G;

    /* renamed from: H */
    private LayoutInflater f277H;

    /* renamed from: I */
    private OnLoadMoreListener f278I;

    /* renamed from: J */
    private OnPullUpListener f279J;

    /* renamed from: K */
    private OnPullDownListener f280K;

    /* renamed from: L */
    private DisplayMetrics f281L;

    /* renamed from: M */
    private int f282M;
    public float MOVE_SPEED = 8.0f;

    /* renamed from: N */
    private int f283N;

    /* renamed from: O */
    private String f284O = "刷新成功";

    /* renamed from: P */
    private String f285P = "暂无更新";

    /* renamed from: Q */
    private String f286Q = "刷新失败";

    /* renamed from: R */
    private String f287R = "加载成功";

    /* renamed from: S */
    private String f288S = "没有更多内容";

    /* renamed from: T */
    private String f289T = "加载失败";
    /* access modifiers changed from: private */

    /* renamed from: U */
    public String f290U = "上拉加载更多";

    /* renamed from: V */
    private String f291V = "释放立即刷新";

    /* renamed from: W */
    private String f292W = "正在刷新...";

    /* renamed from: a */
    Handler f293a = new Handler() {
        public void handleMessage(Message message) {
            PullingLayout.this.MOVE_SPEED = (float) ((Math.tan((1.5707963267948966d / ((double) PullingLayout.this.getMeasuredHeight())) * ((double) (PullingLayout.this.pullDownY + Math.abs(PullingLayout.this.f307f)))) * 5.0d) + 8.0d);
            if (!PullingLayout.this.f312k) {
                if (PullingLayout.this.f303b == 2 && PullingLayout.this.pullDownY <= PullingLayout.this.f308g) {
                    PullingLayout.this.pullDownY = PullingLayout.this.f308g;
                } else if (PullingLayout.this.f303b == 4 && (-PullingLayout.this.f307f) <= PullingLayout.this.f309h) {
                    PullingLayout.this.f307f = -PullingLayout.this.f309h;
                }
                PullingLayout.this.f310i.cancel();
            }
            if (PullingLayout.this.pullDownY > 0.0f) {
                PullingLayout.this.pullDownY -= PullingLayout.this.MOVE_SPEED;
            } else if (PullingLayout.this.f307f < 0.0f) {
                PullingLayout.this.f307f = PullingLayout.this.f307f + PullingLayout.this.MOVE_SPEED;
            }
            if (PullingLayout.this.pullDownY < 0.0f) {
                PullingLayout.this.pullDownY = 0.0f;
                PullingLayout.this.f317p.clearAnimation();
                if (!(PullingLayout.this.f303b == 2 || PullingLayout.this.f303b == 4)) {
                    PullingLayout.this.m151a(0);
                }
                PullingLayout.this.f310i.cancel();
                PullingLayout.this.requestLayout();
            }
            if (PullingLayout.this.f307f > 0.0f) {
                PullingLayout.this.f307f = 0.0f;
                PullingLayout.this.f322u.clearAnimation();
                if (!(PullingLayout.this.f303b == 2 || PullingLayout.this.f303b == 4)) {
                    PullingLayout.this.m151a(0);
                }
                PullingLayout.this.f310i.cancel();
                PullingLayout.this.requestLayout();
            }
            PullingLayout.this.requestLayout();
            if (PullingLayout.this.pullDownY + Math.abs(PullingLayout.this.f307f) == 0.0f) {
                PullingLayout.this.f310i.cancel();
            }
        }
    };

    /* renamed from: aa */
    private String f294aa = "释放立即加载";
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public String f295ab = "下拉刷新";

    /* renamed from: ac */
    private String f296ac = "正在加载...";
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public int f297ad = 0;
    /* access modifiers changed from: private */

    /* renamed from: ae */
    public int f298ae = 0;

    /* renamed from: af */
    private int f299af = 0;

    /* renamed from: ag */
    private int f300ag = 0;
    /* access modifiers changed from: private */

    /* renamed from: ah */
    public int f301ah = 6;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public int f302ai = 2;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f303b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnRefreshListener f304c;

    /* renamed from: d */
    private float f305d;

    /* renamed from: e */
    private float f306e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f307f = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f308g = 200.0f;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f309h = 200.0f;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MyTimer f310i;

    /* renamed from: j */
    private boolean f311j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f312k = false;

    /* renamed from: l */
    private float f313l = 2.0f;

    /* renamed from: m */
    private RotateAnimation f314m;

    /* renamed from: n */
    private RotateAnimation f315n;

    /* renamed from: o */
    private HeadView f316o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public View f317p;
    public float pullDownY = 0.0f;

    /* renamed from: q */
    private View f318q;

    /* renamed from: r */
    private ImageView f319r;

    /* renamed from: s */
    private TextView f320s;

    /* renamed from: t */
    private FootView f321t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public View f322u;

    /* renamed from: v */
    private View f323v;

    /* renamed from: w */
    private ImageView f324w;

    /* renamed from: x */
    private TextView f325x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f326y;

    /* renamed from: z */
    private FrameLayout f327z;

    private class AutoRefreshAndLoadTask extends AsyncTask<Integer, Float, String> {
        private AutoRefreshAndLoadTask() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            while (PullingLayout.this.pullDownY < PullingLayout.this.f308g * 1.0f) {
                PullingLayout.this.pullDownY += PullingLayout.this.MOVE_SPEED;
                publishProgress(new Float[]{Float.valueOf(PullingLayout.this.pullDownY)});
                try {
                    Thread.sleep((long) numArr[0].intValue());
                } catch (InterruptedException e) {
                    C0029a.m806a(e);
                }
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(String str) {
            PullingLayout.this.m151a(2);
            if (PullingLayout.this.f304c != null) {
                PullingLayout.this.f304c.onRefresh(PullingLayout.this);
            }
            PullingLayout.this.m150a();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onProgressUpdate(Float... fArr) {
            if (PullingLayout.this.pullDownY > PullingLayout.this.f308g) {
                PullingLayout.this.m151a(1);
            }
            PullingLayout.this.requestLayout();
        }
    }

    private class FailDrawable extends LoadingDrawable {
        FailDrawable() {
            super();
            mo453b();
        }
    }

    private class FailDrawable2 extends Drawable {

        /* renamed from: a */
        final /* synthetic */ PullingLayout f333a;

        /* renamed from: b */
        private Paint f334b;

        public void draw(Canvas canvas) {
            this.f334b.setColor(this.f333a.f326y);
            Rect bounds = getBounds();
            canvas.drawCircle((float) (bounds.right / 2), (float) (bounds.bottom / 2), (float) ((int) (((double) ((float) Math.min(bounds.right, bounds.bottom))) * 0.35d)), this.f334b);
            canvas.drawLine((float) (bounds.right / 2), ((float) bounds.bottom) * 0.25f, (float) (bounds.right / 2), ((float) bounds.bottom) * 0.65f, this.f334b);
            canvas.drawLine((float) (bounds.right / 2), ((float) bounds.bottom) * 0.7f, (float) (bounds.right / 2), ((float) bounds.bottom) * 0.75f, this.f334b);
        }

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i) {
            this.f334b.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.f334b.setColorFilter(colorFilter);
        }
    }

    public class FootView extends RelativeLayout {

        /* renamed from: b */
        private ImageView f336b;

        /* renamed from: c */
        private TextView f337c;

        /* renamed from: d */
        private ImageView f338d;

        /* renamed from: e */
        private ImageView f339e;

        public FootView(Context context) {
            super(context);
            m189a(context);
        }

        public FootView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            m189a(context);
        }

        public FootView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            m189a(context);
        }

        /* renamed from: a */
        private void m189a(Context context) {
            int b = PullingLayout.this.m149a(30.0f);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setPadding(0, PullingLayout.this.m149a(20.0f), 0, PullingLayout.this.m149a(20.0f));
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(10);
            addView(relativeLayout, layoutParams);
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            LayoutParams layoutParams2 = new LayoutParams(-1, -2);
            layoutParams2.addRule(13);
            relativeLayout.addView(relativeLayout2, layoutParams2);
            this.f339e = new ImageView(context);
            this.f339e.setBackgroundDrawable(new PullUpDrawable());
            LayoutParams layoutParams3 = new LayoutParams(b, b);
            layoutParams3.setMargins(PullingLayout.this.m149a(60.0f), 0, 0, 0);
            layoutParams3.addRule(15);
            relativeLayout2.addView(this.f339e, layoutParams3);
            this.f336b = new ImageView(context);
            this.f336b.setVisibility(8);
            this.f336b.setBackgroundDrawable(new LoadingDrawable());
            LayoutParams layoutParams4 = new LayoutParams(b, b);
            layoutParams4.setMargins(PullingLayout.this.m149a(60.0f), 0, 0, 0);
            layoutParams4.addRule(15);
            relativeLayout2.addView(this.f336b, layoutParams4);
            this.f337c = new TextView(context);
            this.f337c.setText(PullingLayout.this.f290U);
            this.f337c.setTextSize(16.0f);
            LayoutParams layoutParams5 = new LayoutParams(-2, -2);
            layoutParams5.addRule(13);
            relativeLayout2.addView(this.f337c, layoutParams5);
            this.f338d = new ImageView(context);
            this.f338d.setVisibility(8);
            LayoutParams layoutParams6 = new LayoutParams(b, b);
            layoutParams6.setMargins(PullingLayout.this.m149a(60.0f), 0, 0, 0);
            layoutParams6.addRule(15);
            relativeLayout2.addView(this.f338d, layoutParams6);
        }

        public ImageView getLoadingView() {
            return this.f336b;
        }

        public ImageView getPullView() {
            return this.f339e;
        }

        public TextView getStateText() {
            return this.f337c;
        }

        public ImageView getStateView() {
            return this.f338d;
        }
    }

    public class HeadView extends RelativeLayout {

        /* renamed from: b */
        private ImageView f341b;

        /* renamed from: c */
        private TextView f342c;

        /* renamed from: d */
        private ImageView f343d;

        /* renamed from: e */
        private ImageView f344e;

        public HeadView(Context context) {
            super(context);
            m190a(context);
        }

        public HeadView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            m190a(context);
        }

        public HeadView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            m190a(context);
        }

        /* renamed from: a */
        private void m190a(Context context) {
            int b = PullingLayout.this.m149a(30.0f);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setPadding(0, PullingLayout.this.m149a(20.0f), 0, PullingLayout.this.m149a(20.0f));
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(12);
            addView(relativeLayout, layoutParams);
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            LayoutParams layoutParams2 = new LayoutParams(-1, -2);
            layoutParams2.addRule(13);
            relativeLayout.addView(relativeLayout2, layoutParams2);
            this.f344e = new ImageView(context);
            this.f344e.setBackgroundDrawable(new PullDownDrawable());
            LayoutParams layoutParams3 = new LayoutParams(b, b);
            layoutParams3.setMargins(PullingLayout.this.m149a(60.0f), 0, 0, 0);
            layoutParams3.addRule(15);
            relativeLayout2.addView(this.f344e, layoutParams3);
            this.f341b = new ImageView(context);
            this.f341b.setVisibility(8);
            this.f341b.setBackgroundDrawable(new LoadingDrawable());
            LayoutParams layoutParams4 = new LayoutParams(b, b);
            layoutParams4.setMargins(PullingLayout.this.m149a(60.0f), 0, 0, 0);
            layoutParams4.addRule(15);
            relativeLayout2.addView(this.f341b, layoutParams4);
            this.f342c = new TextView(context);
            this.f342c.setText(PullingLayout.this.f295ab);
            this.f342c.setTextSize(16.0f);
            LayoutParams layoutParams5 = new LayoutParams(-2, -2);
            layoutParams5.addRule(13);
            relativeLayout2.addView(this.f342c, layoutParams5);
            this.f343d = new ImageView(context);
            this.f343d.setVisibility(8);
            LayoutParams layoutParams6 = new LayoutParams(b, b);
            layoutParams6.setMargins(PullingLayout.this.m149a(60.0f), 0, 0, 0);
            layoutParams6.addRule(15);
            relativeLayout2.addView(this.f343d, layoutParams6);
        }

        public ImageView getLoadingView() {
            return this.f341b;
        }

        public ImageView getPullView() {
            return this.f344e;
        }

        public TextView getStateText() {
            return this.f342c;
        }

        public ImageView getStateView() {
            return this.f343d;
        }
    }

    private class LoadingDrawable extends Drawable {

        /* renamed from: a */
        private Paint f345a = new Paint();

        /* renamed from: c */
        private int f347c;

        LoadingDrawable() {
            this.f345a.setStyle(Style.STROKE);
            this.f345a.setAntiAlias(true);
            this.f345a.setStrokeWidth((float) PullingLayout.this.m149a(2.0f));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo452a() {
            this.f347c = 1;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo453b() {
            this.f347c = -1;
        }

        public void draw(Canvas canvas) {
            PullingLayout pullingLayout;
            int p;
            int q;
            this.f345a.setColor(PullingLayout.this.f326y);
            Rect bounds = getBounds();
            float min = (float) ((int) ((float) Math.min(bounds.right, bounds.bottom)));
            float f = 0.15f * min;
            float f2 = min * 0.85f;
            RectF rectF = new RectF(f, f, f2, f2);
            if (PullingLayout.this.f297ad >= 360 && this.f347c == 0) {
                PullingLayout.this.f302ai = 8;
                PullingLayout.this.f301ah = -6;
            } else if (PullingLayout.this.f297ad <= 6) {
                PullingLayout.this.f301ah = 6;
                PullingLayout.this.f302ai = 2;
            }
            if (PullingLayout.this.f297ad < 360 || this.f347c == 0) {
                if (this.f347c == 0) {
                    PullingLayout.this.f297ad = PullingLayout.this.f297ad + PullingLayout.this.f301ah;
                    pullingLayout = PullingLayout.this;
                    p = PullingLayout.this.f298ae;
                    q = PullingLayout.this.f302ai;
                } else {
                    PullingLayout.this.f297ad = PullingLayout.this.f297ad + (PullingLayout.this.f301ah * 2);
                    pullingLayout = PullingLayout.this;
                    p = PullingLayout.this.f298ae;
                    q = PullingLayout.this.f302ai * 2;
                }
                pullingLayout.f298ae = p + q;
                PullingLayout.this.f298ae = PullingLayout.this.f298ae % 360;
            }
            canvas.drawArc(rectF, (float) PullingLayout.this.f298ae, (float) PullingLayout.this.f297ad, false, this.f345a);
            if (PullingLayout.this.f297ad >= 360) {
                PullingLayout.this.f301ah = -6;
                PullingLayout.this.f302ai = 8;
                if (this.f347c == 1) {
                    Path path = new Path();
                    path.moveTo(((float) bounds.right) * 0.3f, ((float) bounds.bottom) * 0.5f);
                    path.lineTo(((float) bounds.right) * 0.45f, ((float) bounds.bottom) * 0.7f);
                    path.lineTo(((float) bounds.right) * 0.75f, ((float) bounds.bottom) * 0.4f);
                    canvas.drawPath(path, this.f345a);
                } else if (this.f347c == -1) {
                    Canvas canvas2 = canvas;
                    canvas2.drawLine((float) (bounds.right / 2), ((float) bounds.bottom) * 0.25f, (float) (bounds.right / 2), ((float) bounds.bottom) * 0.65f, this.f345a);
                    canvas2.drawLine((float) (bounds.right / 2), ((float) bounds.bottom) * 0.7f, (float) (bounds.right / 2), ((float) bounds.bottom) * 0.75f, this.f345a);
                }
            }
            invalidateSelf();
        }

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i) {
            this.f345a.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.f345a.setColorFilter(colorFilter);
        }
    }

    private class LoadingDrawable2 extends Drawable {

        /* renamed from: a */
        final /* synthetic */ PullingLayout f348a;

        /* renamed from: b */
        private Paint f349b;

        /* renamed from: c */
        private int f350c;

        /* renamed from: d */
        private int f351d;

        /* renamed from: e */
        private int f352e;

        /* renamed from: f */
        private int f353f;

        public void draw(Canvas canvas) {
            this.f349b.setColor(this.f348a.f326y);
            Rect bounds = getBounds();
            int min = (int) (((double) ((float) Math.min(bounds.right, bounds.bottom))) * 0.35d);
            float f = (float) (min / 2);
            float f2 = ((float) min) * 2.5f;
            RectF rectF = new RectF(f, f, f2, f2);
            if (this.f350c > 360) {
                this.f353f += this.f352e;
                this.f352e = 0 - this.f352e;
            } else if (this.f350c < 6) {
                this.f352e = 6;
                this.f353f = 2;
            }
            this.f350c += this.f352e;
            this.f351d += this.f353f;
            canvas.drawArc(rectF, (float) (this.f351d % 360), (float) this.f350c, false, this.f349b);
            invalidateSelf();
        }

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i) {
            this.f349b.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.f349b.setColorFilter(colorFilter);
        }
    }

    class MyTimer {

        /* renamed from: b */
        private Handler f355b;

        /* renamed from: c */
        private Timer f356c = new Timer();

        /* renamed from: d */
        private MyTask f357d;

        class MyTask extends TimerTask {

            /* renamed from: b */
            private Handler f359b;

            public MyTask(Handler handler) {
                this.f359b = handler;
            }

            public void run() {
                this.f359b.obtainMessage().sendToTarget();
            }
        }

        public MyTimer(Handler handler) {
            this.f355b = handler;
        }

        public void cancel() {
            if (this.f357d != null) {
                this.f357d.cancel();
                this.f357d = null;
            }
        }

        public void schedule(long j) {
            if (this.f357d != null) {
                this.f357d.cancel();
                this.f357d = null;
            }
            this.f357d = new MyTask(this.f355b);
            this.f356c.schedule(this.f357d, 0, j);
        }
    }

    public interface OnLoadMoreListener {
        void onLoadMore(PullingLayout pullingLayout);
    }

    public interface OnPullDownListener {
        boolean onPullDown(View view);
    }

    public interface OnPullUpListener {
        boolean onPullUp(View view);
    }

    public interface OnRefreshListener {
        void onRefresh(PullingLayout pullingLayout);
    }

    private class PullDownDrawable extends Drawable {

        /* renamed from: b */
        private Paint f361b = new Paint();

        PullDownDrawable() {
            this.f361b.setStyle(Style.STROKE);
            this.f361b.setAntiAlias(true);
            this.f361b.setStrokeWidth((float) PullingLayout.this.m149a(2.0f));
        }

        public void draw(Canvas canvas) {
            this.f361b.setColor(PullingLayout.this.f326y);
            Rect bounds = getBounds();
            canvas.drawCircle((float) (bounds.right / 2), (float) (bounds.bottom / 2), (float) ((int) (((double) ((float) Math.min(bounds.right, bounds.bottom))) * 0.35d)), this.f361b);
            Path path = new Path();
            path.moveTo(((float) bounds.right) * 0.5f, ((float) bounds.bottom) * 0.25f);
            path.lineTo(((float) bounds.right) * 0.5f, ((float) bounds.bottom) * 0.75f);
            path.moveTo(((float) bounds.right) * 0.25f, ((float) bounds.bottom) * 0.5f);
            path.lineTo(((float) bounds.right) * 0.5f, ((float) bounds.bottom) * 0.75f);
            path.lineTo(((float) bounds.right) * 0.75f, ((float) bounds.bottom) * 0.5f);
            canvas.drawPath(path, this.f361b);
        }

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i) {
            this.f361b.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.f361b.setColorFilter(colorFilter);
        }
    }

    private class PullUpDrawable extends Drawable {

        /* renamed from: b */
        private Paint f363b = new Paint();

        PullUpDrawable() {
            this.f363b.setStyle(Style.STROKE);
            this.f363b.setAntiAlias(true);
            this.f363b.setStrokeWidth((float) PullingLayout.this.m149a(2.0f));
        }

        public void draw(Canvas canvas) {
            this.f363b.setColor(PullingLayout.this.f326y);
            Rect bounds = getBounds();
            canvas.drawCircle((float) (bounds.right / 2), (float) (bounds.bottom / 2), (float) ((int) (((double) ((float) Math.min(bounds.right, bounds.bottom))) * 0.35d)), this.f363b);
            Path path = new Path();
            path.moveTo(((float) bounds.right) * 0.5f, ((float) bounds.bottom) * 0.25f);
            path.lineTo(((float) bounds.right) * 0.5f, ((float) bounds.bottom) * 0.75f);
            path.moveTo(((float) bounds.right) * 0.25f, ((float) bounds.bottom) * 0.5f);
            path.lineTo(((float) bounds.right) * 0.5f, ((float) bounds.bottom) * 0.25f);
            path.lineTo(((float) bounds.right) * 0.75f, ((float) bounds.bottom) * 0.5f);
            canvas.drawPath(path, this.f363b);
        }

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i) {
            this.f363b.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.f363b.setColorFilter(colorFilter);
        }
    }

    private class SucceedDrawable extends LoadingDrawable {
        SucceedDrawable() {
            super();
            mo452a();
        }
    }

    private class SucceedDrawable2 extends Drawable {

        /* renamed from: a */
        final /* synthetic */ PullingLayout f365a;

        /* renamed from: b */
        private Paint f366b;

        public void draw(Canvas canvas) {
            this.f366b.setColor(this.f365a.f326y);
            Rect bounds = getBounds();
            canvas.drawCircle((float) (bounds.right / 2), (float) (bounds.bottom / 2), (float) ((int) (((double) ((float) Math.min(bounds.right, bounds.bottom))) * 0.35d)), this.f366b);
            Path path = new Path();
            path.moveTo(((float) bounds.right) * 0.3f, ((float) bounds.bottom) * 0.5f);
            path.lineTo(((float) bounds.right) * 0.45f, ((float) bounds.bottom) * 0.7f);
            path.lineTo(((float) bounds.right) * 0.75f, ((float) bounds.bottom) * 0.4f);
            canvas.drawPath(path, this.f366b);
        }

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i) {
            this.f366b.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.f366b.setColorFilter(colorFilter);
        }
    }

    public PullingLayout(Context context) {
        super(context);
        m152a(context);
    }

    public PullingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m152a(context);
    }

    public PullingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m152a(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m149a(float f) {
        return (int) TypedValue.applyDimension(1, f, this.f281L);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m150a() {
        this.f310i.schedule(5);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003b, code lost:
        r4.setText(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0048, code lost:
        r4.startAnimation(r3.f314m);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m151a(int r4) {
        /*
            r3 = this;
            r3.f303b = r4
            int r4 = r3.f303b
            r0 = 4
            r1 = 0
            switch(r4) {
                case 0: goto L_0x004e;
                case 1: goto L_0x003f;
                case 2: goto L_0x0028;
                case 3: goto L_0x001e;
                case 4: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            return
        L_0x000a:
            android.view.View r4 = r3.f322u
            r4.clearAnimation()
            android.view.View r4 = r3.f323v
            r4.setVisibility(r1)
            android.view.View r4 = r3.f322u
            r4.setVisibility(r0)
            android.widget.TextView r4 = r3.f325x
            java.lang.String r0 = r3.f296ac
            goto L_0x003b
        L_0x001e:
            android.widget.TextView r4 = r3.f325x
            java.lang.String r0 = r3.f294aa
            r4.setText(r0)
            android.view.View r4 = r3.f322u
            goto L_0x0048
        L_0x0028:
            android.view.View r4 = r3.f317p
            r4.clearAnimation()
            android.view.View r4 = r3.f318q
            r4.setVisibility(r1)
            android.view.View r4 = r3.f317p
            r4.setVisibility(r0)
            android.widget.TextView r4 = r3.f320s
            java.lang.String r0 = r3.f292W
        L_0x003b:
            r4.setText(r0)
            return
        L_0x003f:
            android.widget.TextView r4 = r3.f320s
            java.lang.String r0 = r3.f291V
            r4.setText(r0)
            android.view.View r4 = r3.f317p
        L_0x0048:
            android.view.animation.RotateAnimation r0 = r3.f314m
            r4.startAnimation(r0)
            return
        L_0x004e:
            android.widget.ImageView r4 = r3.f319r
            r0 = 8
            r4.setVisibility(r0)
            android.widget.TextView r4 = r3.f320s
            java.lang.String r2 = r3.f295ab
            r4.setText(r2)
            android.view.View r4 = r3.f317p
            r4.clearAnimation()
            android.view.View r4 = r3.f317p
            r4.setVisibility(r1)
            android.widget.ImageView r4 = r3.f324w
            r4.setVisibility(r0)
            android.widget.TextView r4 = r3.f325x
            java.lang.String r0 = r3.f290U
            r4.setText(r0)
            android.view.View r4 = r3.f322u
            r4.clearAnimation()
            android.view.View r4 = r3.f322u
            r4.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.PullingLayout.m151a(int):void");
    }

    /* renamed from: a */
    private void m152a(Context context) {
        this.f281L = context.getResources().getDisplayMetrics();
        this.f274E = context;
        TypedArray obtainStyledAttributes = this.f274E.getTheme().obtainStyledAttributes(new int[]{16842800, 16842801});
        this.f282M = obtainStyledAttributes.getColor(0, -1);
        this.f283N = obtainStyledAttributes.getColor(1, -16777216);
        obtainStyledAttributes.recycle();
        setStateColor(this.f282M);
        this.f277H = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f316o = new HeadView(this.f274E);
        super.addView(this.f316o, new LayoutParams(-1, -1));
        this.f327z = new FrameLayout(this.f274E);
        super.addView(this.f327z, new LayoutParams(-1, -1));
        this.f321t = new FootView(this.f274E);
        super.addView(this.f321t, new LayoutParams(-1, -1));
        this.f327z = (FrameLayout) getChildAt(1);
        m173e();
        this.f310i = new MyTimer(this.f293a);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        this.f314m = rotateAnimation;
        this.f314m.setDuration(100);
        this.f314m.setRepeatCount(0);
        this.f314m.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f315n = rotateAnimation2;
        this.f315n.setDuration(1500);
        this.f315n.setRepeatCount(-1);
        this.f315n.setFillAfter(true);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.f314m.setInterpolator(linearInterpolator);
        this.f315n.setInterpolator(linearInterpolator);
    }

    /* renamed from: a */
    private boolean m154a(View view) {
        return view.getScrollY() == 0;
    }

    /* renamed from: a */
    private boolean m155a(WebView webView) {
        return ((float) webView.getScrollY()) >= (((float) webView.getContentHeight()) * webView.getScale()) - ((float) webView.getMeasuredHeight());
    }

    /* renamed from: a */
    private boolean m156a(AbsListView absListView) {
        if (absListView.getCount() == 0) {
            return true;
        }
        return absListView.getFirstVisiblePosition() == 0 && absListView.getChildAt(0).getTop() >= 0;
    }

    /* renamed from: a */
    private boolean m157a(ExpandableListView expandableListView) {
        if (expandableListView.getCount() == 0) {
            return true;
        }
        return expandableListView.getLastVisiblePosition() == expandableListView.getCount() - 1 && expandableListView.getChildAt(expandableListView.getLastVisiblePosition() - expandableListView.getFirstVisiblePosition()) != null && expandableListView.getChildAt(expandableListView.getLastVisiblePosition() - expandableListView.getFirstVisiblePosition()).getBottom() <= expandableListView.getMeasuredHeight();
    }

    /* renamed from: a */
    private boolean m158a(GridView gridView) {
        if (gridView.getCount() == 0) {
            return true;
        }
        return gridView.getLastVisiblePosition() == gridView.getCount() - 1 && gridView.getChildAt(gridView.getLastVisiblePosition() - gridView.getFirstVisiblePosition()) != null && gridView.getChildAt(gridView.getLastVisiblePosition() - gridView.getFirstVisiblePosition()).getBottom() <= gridView.getMeasuredHeight();
    }

    /* renamed from: a */
    private boolean m159a(ListView listView) {
        if (listView.getCount() == 0) {
            return true;
        }
        return listView.getLastVisiblePosition() == listView.getCount() - 1 && listView.getChildAt(listView.getLastVisiblePosition() - listView.getFirstVisiblePosition()) != null && listView.getChildAt(listView.getLastVisiblePosition() - listView.getFirstVisiblePosition()).getBottom() <= listView.getMeasuredHeight();
    }

    /* renamed from: a */
    private boolean m160a(ScrollView scrollView) {
        return scrollView.getScrollY() >= scrollView.getChildAt(0).getHeight() - scrollView.getMeasuredHeight();
    }

    /* renamed from: b */
    private void m163b() {
        this.f272C = true;
        this.f273D = true;
    }

    /* renamed from: c */
    private boolean m167c() {
        if (!this.f275F || this.f270A == null) {
            return false;
        }
        if (this.f279J != null) {
            return this.f279J.onPullUp(this.f270A);
        }
        if (this.f270A instanceof ListView) {
            return m159a((ListView) this.f270A);
        }
        if (this.f270A instanceof GridView) {
            return m158a((GridView) this.f270A);
        }
        if (this.f270A instanceof ExpandableListView) {
            return m157a((ExpandableListView) this.f270A);
        }
        if (this.f270A instanceof ScrollView) {
            return m160a((ScrollView) this.f270A);
        }
        if (this.f270A instanceof WebView) {
            return m155a((WebView) this.f270A);
        }
        return true;
    }

    /* renamed from: d */
    private boolean m170d() {
        if (!this.f276G || this.f270A == null) {
            return false;
        }
        if (this.f280K != null) {
            return this.f280K.onPullDown(this.f270A);
        }
        if (this.f270A instanceof AbsListView) {
            return m156a((AbsListView) this.f270A);
        }
        if (this.f270A instanceof ScrollView) {
            return m154a((View) (ScrollView) this.f270A);
        }
        if (this.f270A instanceof WebView) {
            return m154a((View) (WebView) this.f270A);
        }
        return true;
    }

    /* renamed from: e */
    private void m173e() {
        this.f317p = this.f316o.getPullView();
        this.f320s = this.f316o.getStateText();
        this.f318q = this.f316o.getLoadingView();
        this.f319r = this.f316o.getStateView();
        this.f322u = this.f321t.getPullView();
        this.f325x = this.f321t.getStateText();
        this.f323v = this.f321t.getLoadingView();
        this.f324w = this.f321t.getStateView();
    }

    public void addView(View view) {
        this.f270A = view;
        this.f327z.addView(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        view.setLayoutParams(new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height));
        this.f270A = view;
        this.f327z.addView(view);
    }

    public void autoLoad() {
        this.f307f = -this.f309h;
        requestLayout();
        m151a(4);
        if (this.f278I != null) {
            this.f278I.onLoadMore(this);
        }
    }

    public void autoRefresh() {
        new AutoRefreshAndLoadTask().execute(new Integer[]{Integer.valueOf(20)});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
        if (r9.f303b == 4) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a9, code lost:
        if (r9.f303b == 2) goto L_0x00ab;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            int r0 = r10.getActionMasked()
            r1 = 2
            r2 = 4
            r3 = 3
            r4 = 0
            r5 = 1
            switch(r0) {
                case 0: goto L_0x0187;
                case 1: goto L_0x014f;
                case 2: goto L_0x0013;
                case 3: goto L_0x000c;
                case 4: goto L_0x000c;
                case 5: goto L_0x000e;
                case 6: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x019b
        L_0x000e:
            r0 = -1
            r9.f271B = r0
            goto L_0x019b
        L_0x0013:
            int r0 = r9.f271B
            r6 = 0
            if (r0 != 0) goto L_0x00ae
            float r0 = r9.pullDownY
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x007a
            boolean r0 = r9.m170d()
            if (r0 == 0) goto L_0x002d
            boolean r0 = r9.f272C
            if (r0 == 0) goto L_0x002d
            int r0 = r9.f303b
            if (r0 == r2) goto L_0x002d
            goto L_0x007a
        L_0x002d:
            float r0 = r9.f307f
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0046
            boolean r0 = r9.m167c()
            if (r0 == 0) goto L_0x0042
            boolean r0 = r9.f273D
            if (r0 == 0) goto L_0x0042
            int r0 = r9.f303b
            if (r0 == r1) goto L_0x0042
            goto L_0x0046
        L_0x0042:
            r9.m163b()
            goto L_0x00b0
        L_0x0046:
            float r0 = r9.f307f
            float r1 = r10.getY()
            float r7 = r9.f306e
            float r1 = r1 - r7
            float r7 = r9.f313l
            float r1 = r1 / r7
            float r0 = r0 + r1
            r9.f307f = r0
            float r0 = r9.f307f
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            r9.f307f = r6
            r9.f272C = r5
            r9.f273D = r4
        L_0x0061:
            float r0 = r9.f307f
            int r1 = r9.getMeasuredHeight()
            int r1 = -r1
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0075
            int r0 = r9.getMeasuredHeight()
            int r0 = -r0
            float r0 = (float) r0
            r9.f307f = r0
        L_0x0075:
            int r0 = r9.f303b
            if (r0 != r2) goto L_0x00b0
            goto L_0x00ab
        L_0x007a:
            float r0 = r9.pullDownY
            float r2 = r10.getY()
            float r7 = r9.f306e
            float r2 = r2 - r7
            float r7 = r9.f313l
            float r2 = r2 / r7
            float r0 = r0 + r2
            r9.pullDownY = r0
            float r0 = r9.pullDownY
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0095
            r9.pullDownY = r6
            r9.f272C = r4
            r9.f273D = r5
        L_0x0095:
            float r0 = r9.pullDownY
            int r2 = r9.getMeasuredHeight()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a7
            int r0 = r9.getMeasuredHeight()
            float r0 = (float) r0
            r9.pullDownY = r0
        L_0x00a7:
            int r0 = r9.f303b
            if (r0 != r1) goto L_0x00b0
        L_0x00ab:
            r9.f312k = r5
            goto L_0x00b0
        L_0x00ae:
            r9.f271B = r4
        L_0x00b0:
            float r0 = r10.getY()
            r9.f306e = r0
            r0 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            int r2 = r9.getMeasuredHeight()
            double r7 = (double) r2
            double r0 = r0 / r7
            float r2 = r9.pullDownY
            float r7 = r9.f307f
            float r7 = java.lang.Math.abs(r7)
            float r2 = r2 + r7
            double r7 = (double) r2
            double r0 = r0 * r7
            double r0 = java.lang.Math.tan(r0)
            r7 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r0 = r0 * r7
            double r0 = r0 + r7
            float r0 = (float) r0
            r9.f313l = r0
            float r0 = r9.pullDownY
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x00e5
            float r0 = r9.f307f
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x00e8
        L_0x00e5:
            r9.requestLayout()
        L_0x00e8:
            float r0 = r9.pullDownY
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            r1 = 5
            if (r0 <= 0) goto L_0x0112
            float r0 = r9.pullDownY
            float r2 = r9.f308g
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0102
            int r0 = r9.f303b
            if (r0 == r5) goto L_0x00ff
            int r0 = r9.f303b
            if (r0 != r1) goto L_0x0102
        L_0x00ff:
            r9.m151a(r4)
        L_0x0102:
            float r0 = r9.pullDownY
            float r1 = r9.f308g
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x013c
            int r0 = r9.f303b
            if (r0 != 0) goto L_0x013c
            r9.m151a(r5)
            goto L_0x013c
        L_0x0112:
            float r0 = r9.f307f
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x013c
            float r0 = r9.f307f
            float r0 = -r0
            float r2 = r9.f309h
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x012c
            int r0 = r9.f303b
            if (r0 == r3) goto L_0x0129
            int r0 = r9.f303b
            if (r0 != r1) goto L_0x012c
        L_0x0129:
            r9.m151a(r4)
        L_0x012c:
            float r0 = r9.f307f
            float r0 = -r0
            float r1 = r9.f309h
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x013c
            int r0 = r9.f303b
            if (r0 != 0) goto L_0x013c
            r9.m151a(r3)
        L_0x013c:
            float r0 = r9.pullDownY
            float r1 = r9.f307f
            float r1 = java.lang.Math.abs(r1)
            float r0 = r0 + r1
            r1 = 1090519040(0x41000000, float:8.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x019b
            r10.setAction(r3)
            goto L_0x019b
        L_0x014f:
            float r0 = r9.pullDownY
            float r6 = r9.f308g
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x0160
            float r0 = r9.f307f
            float r0 = -r0
            float r6 = r9.f309h
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0162
        L_0x0160:
            r9.f312k = r4
        L_0x0162:
            int r0 = r9.f303b
            if (r0 != r5) goto L_0x0173
            r9.m151a(r1)
            android.widget.PullingLayout$OnRefreshListener r0 = r9.f304c
            if (r0 == 0) goto L_0x0183
            android.widget.PullingLayout$OnRefreshListener r0 = r9.f304c
            r0.onRefresh(r9)
            goto L_0x0183
        L_0x0173:
            int r0 = r9.f303b
            if (r0 != r3) goto L_0x0183
            r9.m151a(r2)
            android.widget.PullingLayout$OnLoadMoreListener r0 = r9.f278I
            if (r0 == 0) goto L_0x0183
            android.widget.PullingLayout$OnLoadMoreListener r0 = r9.f278I
            r0.onLoadMore(r9)
        L_0x0183:
            r9.m150a()
            goto L_0x019b
        L_0x0187:
            float r0 = r10.getY()
            r9.f305d = r0
            float r0 = r9.f305d
            r9.f306e = r0
            android.widget.PullingLayout$MyTimer r0 = r9.f310i
            r0.cancel()
            r9.f271B = r4
            r9.m163b()
        L_0x019b:
            super.dispatchTouchEvent(r10)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.PullingLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public String getLoadFail() {
        return this.f289T;
    }

    public String getLoadNothing() {
        return this.f288S;
    }

    public String getLoadSucceed() {
        return this.f287R;
    }

    public String getLoading() {
        return this.f296ac;
    }

    public String getPulldownToRefresh() {
        return this.f295ab;
    }

    public String getPullupToLoad() {
        return this.f290U;
    }

    public String getRefreshFail() {
        return this.f286Q;
    }

    public String getRefreshNothing() {
        return this.f285P;
    }

    public String getRefreshSucceed() {
        return this.f284O;
    }

    public String getRefreshing() {
        return this.f292W;
    }

    public String getReleaseToLoad() {
        return this.f294aa;
    }

    public String getReleaseToRefresh() {
        return this.f291V;
    }

    public void loadmoreFinish(int i) {
        ImageView imageView;
        Drawable succeedDrawable;
        if (this.f303b == 4) {
            this.f323v.clearAnimation();
            this.f323v.setVisibility(8);
            if (i == 0) {
                this.f324w.setVisibility(0);
                this.f325x.setText(this.f287R);
                imageView = this.f324w;
                succeedDrawable = new SucceedDrawable();
            } else if (i != 2) {
                this.f324w.setVisibility(0);
                this.f325x.setText(this.f289T);
                imageView = this.f324w;
                succeedDrawable = new FailDrawable();
            } else {
                this.f324w.setVisibility(0);
                this.f325x.setText(this.f288S);
                imageView = this.f324w;
                succeedDrawable = new FailDrawable();
            }
            imageView.setBackgroundDrawable(succeedDrawable);
            if (this.f307f < 0.0f) {
                new Handler() {
                    public void handleMessage(Message message) {
                        PullingLayout.this.m151a(5);
                        PullingLayout.this.m150a();
                    }
                }.sendEmptyMessageDelayed(0, 1000);
                return;
            }
            m151a(5);
            m150a();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.f311j) {
            this.f311j = true;
            this.f308g = (float) this.f316o.getChildAt(0).getMeasuredHeight();
            this.f309h = (float) this.f321t.getChildAt(0).getMeasuredHeight();
            this.f325x.setTextColor(this.f326y);
            this.f320s.setTextColor(this.f326y);
        }
        this.f316o.layout(0, ((int) (this.pullDownY + this.f307f)) - this.f316o.getMeasuredHeight(), this.f316o.getMeasuredWidth(), (int) (this.pullDownY + this.f307f));
        this.f327z.layout(0, (int) (this.pullDownY + this.f307f), this.f327z.getMeasuredWidth(), ((int) (this.pullDownY + this.f307f)) + this.f327z.getMeasuredHeight());
        this.f321t.layout(0, ((int) (this.pullDownY + this.f307f)) + this.f327z.getMeasuredHeight(), this.f321t.getMeasuredWidth(), ((int) (this.pullDownY + this.f307f)) + this.f327z.getMeasuredHeight() + this.f321t.getMeasuredHeight());
    }

    public void refreshFinish(int i) {
        ImageView imageView;
        Drawable succeedDrawable;
        if (this.f303b == 2) {
            this.f318q.clearAnimation();
            this.f318q.setVisibility(8);
            if (i == 0) {
                this.f319r.setVisibility(0);
                this.f320s.setText(this.f284O);
                imageView = this.f319r;
                succeedDrawable = new SucceedDrawable();
            } else if (i != 2) {
                this.f319r.setVisibility(0);
                this.f320s.setText(this.f286Q);
                imageView = this.f319r;
                succeedDrawable = new FailDrawable();
            } else {
                this.f319r.setVisibility(0);
                this.f320s.setText(this.f285P);
                imageView = this.f319r;
                succeedDrawable = new FailDrawable();
            }
            imageView.setBackgroundDrawable(succeedDrawable);
            if (this.pullDownY > 0.0f) {
                new Handler() {
                    public void handleMessage(Message message) {
                        PullingLayout.this.m151a(5);
                        PullingLayout.this.m150a();
                    }
                }.sendEmptyMessageDelayed(0, 1000);
                return;
            }
            m151a(5);
            m150a();
        }
    }

    public void setLoadFail(String str) {
        this.f289T = str;
    }

    public void setLoadNothing(String str) {
        this.f288S = str;
    }

    public void setLoadSucceed(String str) {
        this.f287R = str;
    }

    public void setLoading(String str) {
        this.f296ac = str;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.f278I = onLoadMoreListener;
    }

    public void setOnPullDownListener(OnPullDownListener onPullDownListener) {
        this.f280K = onPullDownListener;
    }

    public void setOnPullUpListener(OnPullUpListener onPullUpListener) {
        this.f279J = onPullUpListener;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.f304c = onRefreshListener;
    }

    public void setPullDownEnabled(boolean z) {
        this.f276G = z;
    }

    public void setPullUpEnabled(boolean z) {
        this.f275F = z;
    }

    public void setPulldownToRefresh(String str) {
        this.f295ab = str;
    }

    public void setPullupToLoad(String str) {
        this.f290U = str;
    }

    public void setRefreshFail(String str) {
        this.f286Q = str;
    }

    public void setRefreshNothing(String str) {
        this.f285P = str;
    }

    public void setRefreshSucceed(String str) {
        this.f284O = str;
    }

    public void setRefreshing(String str) {
        this.f292W = str;
    }

    public void setReleaseToLoad(String str) {
        this.f294aa = str;
    }

    public void setReleaseToRefresh(String str) {
        this.f291V = str;
    }

    public void setStateColor(int i) {
        this.f326y = i;
    }
}
