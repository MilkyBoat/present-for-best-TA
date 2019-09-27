package com.androlua;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.ArrayListAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.luajava.LuaException;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import java.io.IOException;
import java.util.HashMap;

public class LuaArrayAdapter extends ArrayListAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Resources f2384a;

    /* renamed from: b */
    private LuaContext f2385b;

    /* renamed from: c */
    private LuaState f2386c;

    /* renamed from: d */
    private LuaObject f2387d;

    /* renamed from: e */
    private LuaObject f2388e;

    /* renamed from: f */
    private Animation f2389f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f2390g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public HashMap<String, Boolean> f2391h;

    private class AsyncLoader extends Thread {

        /* renamed from: b */
        private String f2394b;

        /* renamed from: c */
        private LuaContext f2395c;

        private AsyncLoader() {
        }

        public Drawable getBitmap(LuaContext luaContext, String str) {
            this.f2395c = luaContext;
            this.f2394b = str;
            if (!str.toLowerCase().startsWith("http://") && !str.toLowerCase().startsWith("https://")) {
                return new BitmapDrawable(LuaArrayAdapter.this.f2384a, LuaBitmap.getBitmap(luaContext, str));
            }
            if (LuaBitmap.checkCache(luaContext, str)) {
                return new BitmapDrawable(LuaArrayAdapter.this.f2384a, LuaBitmap.getBitmap(luaContext, str));
            }
            if (!LuaArrayAdapter.this.f2391h.containsKey(this.f2394b)) {
                start();
                LuaArrayAdapter.this.f2391h.put(this.f2394b, Boolean.valueOf(true));
            }
            return new LoadingDrawable(this.f2395c.getContext());
        }

        public void run() {
            try {
                LuaBitmap.getBitmap(this.f2395c, this.f2394b);
                LuaArrayAdapter.this.f2390g.sendEmptyMessage(0);
            } catch (IOException e) {
                this.f2395c.sendError("AsyncLoader", e);
            }
        }
    }

    public LuaArrayAdapter(LuaContext luaContext, LuaObject luaObject) {
        this(luaContext, luaObject, new String[0]);
    }

    public LuaArrayAdapter(LuaContext luaContext, LuaObject luaObject, Object[] objArr) {
        super(luaContext.getContext(), 0, (T[]) objArr);
        this.f2390g = new Handler() {
            public void handleMessage(Message message) {
                LuaArrayAdapter.this.notifyDataSetChanged();
            }
        };
        this.f2391h = new HashMap<>();
        this.f2385b = luaContext;
        this.f2387d = luaObject;
        this.f2384a = this.f2385b.getContext().getResources();
        this.f2386c = luaContext.getLuaState();
        this.f2388e = this.f2386c.getLuaObject("loadlayout");
        this.f2386c.newTable();
        this.f2388e.call(this.f2387d, this.f2386c.getLuaObject(-1), AbsListView.class);
        this.f2386c.pop(1);
    }

    /* renamed from: a */
    private void m2178a(View view, Object obj) {
        TextView textView;
        CharSequence obj2;
        if (view instanceof TextView) {
            if (obj instanceof CharSequence) {
                textView = (TextView) view;
                obj2 = (CharSequence) obj;
            } else {
                textView = (TextView) view;
                obj2 = obj.toString();
            }
            textView.setText(obj2);
            return;
        }
        if (view instanceof ImageView) {
            try {
                ImageView imageView = (ImageView) view;
                Drawable drawable = null;
                if (obj instanceof Bitmap) {
                    drawable = new BitmapDrawable(this.f2384a, (Bitmap) obj);
                } else if (obj instanceof String) {
                    drawable = new AsyncLoader().getBitmap(this.f2385b, (String) obj);
                } else if (obj instanceof Drawable) {
                    drawable = (Drawable) obj;
                } else if (obj instanceof Number) {
                    drawable = this.f2384a.getDrawable(((Number) obj).intValue());
                }
                imageView.setImageDrawable(drawable);
                if (drawable instanceof BitmapDrawable) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    if (imageView.getScaleType() == ScaleType.FIT_XY) {
                        imageView.setLayoutParams(new LayoutParams(this.f2385b.getWidth(), (int) ((((float) this.f2385b.getWidth()) * ((float) height)) / ((float) width))));
                    }
                }
            } catch (Exception e) {
                Log.i("lua", e.getMessage());
            }
        }
    }

    public Animation getAnimation() {
        return this.f2389f;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f2386c.newTable();
            LuaObject luaObject = this.f2386c.getLuaObject(-1);
            this.f2386c.pop(1);
            try {
                view = (View) this.f2388e.call(this.f2387d, luaObject, AbsListView.class);
            } catch (LuaException unused) {
                return new View(this.f2385b.getContext());
            }
        }
        m2178a(view, getItem(i));
        if (this.f2389f != null) {
            view.startAnimation(this.f2389f);
        }
        return view;
    }

    public void setAnimation(Animation animation) {
        this.f2389f = animation;
    }
}
