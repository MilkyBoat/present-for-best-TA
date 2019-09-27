package android.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.androlua.C0364R;

public class ToolBar extends LinearLayout {

    /* renamed from: a */
    private TextView f430a;

    /* renamed from: b */
    private TextView f431b;

    /* renamed from: c */
    private ImageView f432c;

    /* renamed from: d */
    private ImageView f433d;

    /* renamed from: e */
    private ImageView f434e;

    /* renamed from: f */
    private LinearLayout f435f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public PopupMenu f436g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnLogoClickListener f437h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnNaviClickListener f438i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public OnMenuItemClickListener f439j;

    /* renamed from: k */
    private DisplayMetrics f440k;

    /* renamed from: l */
    private int f441l;

    public interface OnLogoClickListener {
        void onLogoClick(View view);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public interface OnNaviClickListener {
        void onNaviClick(View view);
    }

    public ToolBar(Context context) {
        super(context);
        m231a(context);
    }

    /* renamed from: a */
    private int m229a(float f) {
        return (int) TypedValue.applyDimension(1, f, this.f440k);
    }

    /* renamed from: a */
    private void m231a(Context context) {
        Context context2 = context;
        this.f440k = context.getResources().getDisplayMetrics();
        this.f441l = m229a(48.0f);
        LayoutParams layoutParams = new LayoutParams(this.f441l, this.f441l);
        setMinimumHeight(this.f441l);
        this.f432c = new ImageView(context2);
        this.f432c.setScaleType(ScaleType.FIT_CENTER);
        this.f432c.setVisibility(8);
        super.addView(this.f432c, layoutParams);
        this.f433d = new ImageView(context2);
        this.f433d.setScaleType(ScaleType.FIT_CENTER);
        this.f433d.setImageResource(C0364R.drawable.icon);
        this.f433d.setVisibility(8);
        super.addView(this.f433d, layoutParams);
        LinearLayout linearLayout = new LinearLayout(context2);
        int a = m229a(1.0f);
        linearLayout.setPadding(a * 4, a, a, a);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        super.addView(linearLayout, new LayoutParams(-1, this.f441l, 1.0f));
        this.f430a = new TextView(context2);
        this.f430a.setTextSize(1, 20.0f);
        this.f430a.setSingleLine(true);
        this.f430a.setTypeface(Typeface.DEFAULT_BOLD);
        linearLayout.addView(this.f430a, new LayoutParams(-1, m229a(26.0f)));
        this.f431b = new TextView(context2);
        this.f431b.setTextSize(1, 14.0f);
        this.f431b.setSingleLine(true);
        this.f431b.setVisibility(8);
        linearLayout.addView(this.f431b, new LayoutParams(-1, m229a(20.0f)));
        this.f435f = new LinearLayout(context2);
        super.addView(this.f435f, new LayoutParams(-2, this.f441l));
        this.f434e = new ImageView(context2);
        this.f434e.setScaleType(ScaleType.FIT_CENTER);
        this.f434e.setVisibility(8);
        super.addView(this.f434e, layoutParams);
        new RippleHelper(this.f432c);
        new RippleHelper(this.f434e);
        Paint paint = new Paint();
        paint.setColor(-7829368);
        Bitmap createBitmap = Bitmap.createBitmap(this.f441l, this.f441l, Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        double d = (double) this.f441l;
        double d2 = d / 4.0d;
        float f = (float) ((int) d2);
        double d3 = d / 32.0d;
        float f2 = (float) ((int) (d2 * 3.0d));
        Canvas canvas2 = canvas;
        float f3 = f;
        float f4 = f2;
        float f5 = f2;
        Paint paint2 = paint;
        canvas2.drawRect(f3, (float) ((int) (10.0d * d3)), f4, (float) ((int) (12.0d * d3)), paint2);
        float f6 = f5;
        canvas.drawRect(f, (float) ((int) (15.0d * d3)), f6, (float) ((int) (17.0d * d3)), paint2);
        canvas.drawRect(f, (float) ((int) (20.0d * d3)), f6, (float) ((int) (d3 * 22.0d)), paint2);
        this.f432c.setImageBitmap(createBitmap);
        Bitmap createBitmap2 = Bitmap.createBitmap(this.f441l, this.f441l, Config.ARGB_4444);
        Canvas canvas3 = new Canvas(createBitmap2);
        float f7 = (float) ((int) (d / 2.0d));
        double d4 = d / 3.0d;
        float f8 = (float) ((int) (d / 16.0d));
        canvas3.drawCircle(f7, (float) ((int) d4), f8, paint);
        canvas3.drawCircle(f7, f7, f8, paint);
        canvas3.drawCircle(f7, (float) ((int) (d4 * 2.0d)), f8, paint);
        this.f434e.setImageBitmap(createBitmap2);
        this.f432c.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (ToolBar.this.f438i != null) {
                    ToolBar.this.f438i.onNaviClick(view);
                }
            }
        });
        this.f433d.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (ToolBar.this.f437h != null) {
                    ToolBar.this.f437h.onLogoClick(view);
                }
            }
        });
        this.f434e.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (ToolBar.this.f436g != null) {
                    ToolBar.this.f436g.show();
                }
            }
        });
        this.f436g = new PopupMenu(getContext(), this.f434e);
        this.f436g.setOnMenuItemClickListener(new android.widget.PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (ToolBar.this.f439j != null) {
                    return ToolBar.this.f439j.onMenuItemClick(menuItem);
                }
                return false;
            }
        });
    }

    public void addView(View view) {
        this.f435f.addView(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        this.f435f.addView(view, layoutParams);
    }

    public Menu getMenu() {
        setMenuEnabled(true);
        return this.f436g.getMenu();
    }

    public void setLogo(Drawable drawable) {
        this.f433d.setImageDrawable(drawable);
    }

    public void setLogoEnabled(boolean z) {
        this.f433d.setVisibility(z ? 0 : 8);
    }

    public void setMenuEnabled(boolean z) {
        this.f434e.setVisibility(z ? 0 : 8);
    }

    public void setNaviEnabled(boolean z) {
        this.f432c.setVisibility(z ? 0 : 8);
    }

    public void setNaviIcon(Drawable drawable) {
        this.f432c.setImageDrawable(drawable);
    }

    public void setOnLogoClickListener(OnLogoClickListener onLogoClickListener) {
        this.f437h = onLogoClickListener;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f439j = onMenuItemClickListener;
    }

    public void setOnNaviClickListener(OnNaviClickListener onNaviClickListener) {
        this.f438i = onNaviClickListener;
    }

    public void setSubtitle(CharSequence charSequence) {
        int i;
        TextView textView;
        if (charSequence == null || charSequence.length() == 0) {
            textView = this.f431b;
            i = 8;
        } else {
            textView = this.f431b;
            i = 0;
        }
        textView.setVisibility(i);
        this.f431b.setText(charSequence);
    }

    public void setSubtitleColor(int i) {
        this.f431b.setTextColor(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f430a.setText(charSequence);
    }

    public void setTitleColor(int i) {
        this.f430a.setTextColor(i);
    }
}
