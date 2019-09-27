package com.androlua;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.luajava.LuaException;
import com.luajava.LuaFunction;
import com.luajava.LuaJavaAPI;
import com.luajava.LuaState;
import com.luajava.LuaTable;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class LuaAdapter extends BaseAdapter implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final LuaTable<Integer, LuaTable<String, Object>> f2344a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Resources f2345b;

    /* renamed from: c */
    private LuaState f2346c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LuaContext f2347d;

    /* renamed from: e */
    private final Object f2348e;

    /* renamed from: f */
    private LuaTable f2349f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LuaTable<Integer, LuaTable<String, Object>> f2350g;

    /* renamed from: h */
    private LuaTable<String, Object> f2351h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CharSequence f2352i;

    /* renamed from: j */
    private LuaFunction<View> f2353j;

    /* renamed from: k */
    private LuaFunction f2354k;

    /* renamed from: l */
    private LuaFunction f2355l;

    /* renamed from: m */
    private LuaFunction<Animation> f2356m;

    /* renamed from: n */
    private HashMap<View, Animation> f2357n;

    /* renamed from: o */
    private HashMap<View, Boolean> f2358o;

    /* renamed from: p */
    private boolean f2359p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f2360q;
    /* access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})

    /* renamed from: r */
    public Handler f2361r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public HashMap<String, Boolean> f2362s;

    /* renamed from: t */
    private ArrayFilter f2363t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public LuaFunction f2364u;

    private class ArrayFilter extends Filter {
        private ArrayFilter() {
        }

        /* access modifiers changed from: protected */
        public FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            LuaAdapter.this.f2352i = charSequence;
            if (LuaAdapter.this.f2350g == null) {
                return filterResults;
            }
            if (LuaAdapter.this.f2364u != null) {
                LuaAdapter.this.f2361r.sendEmptyMessage(1);
                return null;
            }
            filterResults.values = LuaAdapter.this.f2350g;
            filterResults.count = LuaAdapter.this.f2350g.size();
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence charSequence, FilterResults filterResults) {
        }
    }

    private class AsyncLoader extends Thread {

        /* renamed from: b */
        private String f2369b;

        /* renamed from: c */
        private LuaContext f2370c;

        private AsyncLoader() {
        }

        public Drawable getBitmap(LuaContext luaContext, String str) {
            this.f2370c = luaContext;
            this.f2369b = str;
            if (!str.toLowerCase().startsWith("http://") && !str.toLowerCase().startsWith("https://")) {
                return new BitmapDrawable(LuaAdapter.this.f2345b, LuaBitmap.getBitmap(luaContext, str));
            }
            if (LuaBitmap.checkCache(luaContext, str)) {
                return new BitmapDrawable(LuaAdapter.this.f2345b, LuaBitmap.getBitmap(luaContext, str));
            }
            if (!LuaAdapter.this.f2362s.containsKey(this.f2369b)) {
                start();
                LuaAdapter.this.f2362s.put(this.f2369b, Boolean.valueOf(true));
            }
            return new LoadingDrawable(this.f2370c.getContext());
        }

        public void run() {
            try {
                LuaBitmap.getBitmap(this.f2370c, this.f2369b);
                LuaAdapter.this.f2361r.sendEmptyMessage(0);
            } catch (IOException e) {
                this.f2370c.sendError("AsyncLoader", e);
            }
        }
    }

    public LuaAdapter(LuaContext luaContext, LuaTable luaTable) {
        this(luaContext, null, luaTable);
    }

    public LuaAdapter(LuaContext luaContext, LuaTable<Integer, LuaTable<String, Object>> luaTable, LuaTable luaTable2) {
        this.f2348e = new Object();
        this.f2357n = new HashMap<>();
        this.f2358o = new HashMap<>();
        this.f2359p = true;
        this.f2361r = new Handler() {
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    LuaAdapter.this.notifyDataSetChanged();
                    return;
                }
                try {
                    LuaTable luaTable = new LuaTable(LuaAdapter.this.f2350g.getLuaState());
                    LuaAdapter.this.f2364u.call(LuaAdapter.this.f2344a, luaTable, LuaAdapter.this.f2352i);
                    LuaAdapter.this.f2350g = luaTable;
                    LuaAdapter.this.notifyDataSetChanged();
                } catch (LuaException e) {
                    C0029a.m806a(e);
                    LuaAdapter.this.f2347d.sendError("performFiltering", e);
                }
            }
        };
        this.f2362s = new HashMap<>();
        this.f2347d = luaContext;
        this.f2349f = luaTable2;
        this.f2345b = this.f2347d.getContext().getResources();
        this.f2346c = luaContext.getLuaState();
        if (luaTable == null) {
            luaTable = new LuaTable<>(this.f2346c);
        }
        this.f2350g = luaTable;
        this.f2344a = this.f2350g;
        this.f2353j = this.f2346c.getLuaObject("loadlayout").getFunction();
        this.f2354k = this.f2346c.getLuaObject("table").getField("insert").getFunction();
        this.f2355l = this.f2346c.getLuaObject("table").getField("remove").getFunction();
        this.f2346c.newTable();
        this.f2353j.call(this.f2349f, this.f2346c.getLuaObject(-1), AbsListView.class);
        this.f2346c.pop(1);
    }

    /* renamed from: a */
    private int m2160a(Object obj, String str, Object obj2) {
        return (str.length() <= 2 || !str.substring(0, 2).equals("on") || !(obj2 instanceof LuaFunction)) ? m2169c(obj, str, obj2) : m2167b(obj, str, obj2);
    }

    /* renamed from: a */
    private void m2164a(View view, LuaTable<String, Object> luaTable) {
        for (Entry entry : luaTable.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (str.toLowerCase().equals("src")) {
                m2165a(view, value);
            } else {
                m2160a(view, str, value);
            }
        }
    }

    /* renamed from: a */
    private void m2165a(View view, Object obj) {
        ImageView imageView;
        Drawable drawable;
        TextView textView;
        CharSequence obj2;
        try {
            if (obj instanceof LuaTable) {
                m2164a(view, (LuaTable) obj);
            } else if (view instanceof TextView) {
                if (obj instanceof CharSequence) {
                    textView = (TextView) view;
                    obj2 = (CharSequence) obj;
                } else {
                    textView = (TextView) view;
                    obj2 = obj.toString();
                }
                textView.setText(obj2);
            } else {
                if (view instanceof ImageView) {
                    if (obj instanceof Bitmap) {
                        ((ImageView) view).setImageBitmap((Bitmap) obj);
                        return;
                    }
                    if (obj instanceof String) {
                        imageView = (ImageView) view;
                        drawable = new AsyncLoader().getBitmap(this.f2347d, (String) obj);
                    } else if (obj instanceof Drawable) {
                        imageView = (ImageView) view;
                        drawable = (Drawable) obj;
                    } else if (obj instanceof Number) {
                        ((ImageView) view).setImageResource(((Number) obj).intValue());
                        return;
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        } catch (Exception e) {
            this.f2347d.sendError("setHelper", e);
        }
    }

    /* renamed from: b */
    private int m2167b(Object obj, String str, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append("setOn");
        sb.append(str.substring(2));
        sb.append("Listener");
        Iterator it = LuaJavaAPI.getMethod(obj.getClass(), sb.toString(), false).iterator();
        while (it.hasNext()) {
            Method method = (Method) it.next();
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].isInterface()) {
                this.f2346c.newTable();
                this.f2346c.pushObjectValue(obj2);
                this.f2346c.setField(-2, str);
                try {
                    method.invoke(obj, new Object[]{this.f2346c.getLuaObject(-1).createProxy(parameterTypes[0])});
                    return 1;
                } catch (Exception e) {
                    throw new LuaException(e);
                }
            }
        }
        return 0;
    }

    /* renamed from: c */
    private int m2169c(Object obj, String str, Object obj2) {
        Object[] objArr;
        if (Character.isLowerCase(str.charAt(0))) {
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toUpperCase(str.charAt(0)));
            sb.append(str.substring(1));
            str = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("set");
        sb2.append(str);
        String sb3 = sb2.toString();
        Class cls = obj2.getClass();
        StringBuilder sb4 = new StringBuilder();
        Iterator it = LuaJavaAPI.getMethod(obj.getClass(), sb3, false).iterator();
        while (it.hasNext()) {
            Method method = (Method) it.next();
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                if (parameterTypes[0].isPrimitive()) {
                    try {
                        if (obj2 instanceof Double) {
                            objArr = new Object[]{LuaState.convertLuaNumber(Double.valueOf(((Number) obj2).doubleValue()), parameterTypes[0])};
                        } else if (obj2 instanceof Float) {
                            objArr = new Object[]{LuaState.convertLuaNumber(Double.valueOf(((Number) obj2).doubleValue()), parameterTypes[0])};
                        } else {
                            if (!(obj2 instanceof Long)) {
                                if (!(obj2 instanceof Integer)) {
                                    if (obj2 instanceof Boolean) {
                                        method.invoke(obj, new Object[]{(Boolean) obj2});
                                        return 1;
                                    }
                                }
                            }
                            objArr = new Object[]{LuaState.convertLuaNumber(Long.valueOf(((Number) obj2).longValue()), parameterTypes[0])};
                        }
                        method.invoke(obj, objArr);
                        return 1;
                    } catch (Exception e) {
                        sb4.append(e.getMessage());
                        sb4.append("\n");
                    }
                } else if (!parameterTypes[0].isAssignableFrom(cls)) {
                    continue;
                } else {
                    method.invoke(obj, new Object[]{obj2});
                    return 1;
                }
            }
        }
        if (sb4.length() > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Invalid setter ");
            sb5.append(str);
            sb5.append(". Invalid Parameters.\n");
            sb5.append(sb4.toString());
            sb5.append(cls.toString());
            throw new LuaException(sb5.toString());
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("Invalid setter ");
        sb6.append(str);
        sb6.append(" is not a method.\n");
        throw new LuaException(sb6.toString());
    }

    public void add(LuaTable<String, Object> luaTable) {
        this.f2354k.call(this.f2344a, luaTable);
        if (this.f2359p) {
            notifyDataSetChanged();
        }
    }

    public void addAll(LuaTable<Integer, LuaTable<String, Object>> luaTable) {
        int length = luaTable.length();
        for (int i = 1; i <= length; i++) {
            this.f2354k.call(this.f2344a, luaTable.get(Integer.valueOf(i)));
        }
        if (this.f2359p) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        this.f2344a.clear();
        if (this.f2359p) {
            notifyDataSetChanged();
        }
    }

    public void filter(CharSequence charSequence) {
        getFilter().filter(charSequence);
    }

    public int getCount() {
        return this.f2350g.length();
    }

    public LuaTable<Integer, LuaTable<String, Object>> getData() {
        return this.f2350g;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup);
    }

    public Filter getFilter() {
        if (this.f2363t == null) {
            this.f2363t = new ArrayFilter();
        }
        return this.f2363t;
    }

    public Object getItem(int i) {
        return this.f2350g.get(Integer.valueOf(i + 1));
    }

    public long getItemId(int i) {
        return (long) (i + 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            r8 = this;
            r11 = 0
            r0 = 1
            if (r10 != 0) goto L_0x003b
            com.luajava.LuaState r1 = r8.f2346c     // Catch:{ LuaException -> 0x002f }
            r1.newTable()     // Catch:{ LuaException -> 0x002f }
            com.luajava.LuaState r1 = r8.f2346c     // Catch:{ LuaException -> 0x002f }
            r2 = -1
            com.luajava.LuaObject r1 = r1.getLuaObject(r2)     // Catch:{ LuaException -> 0x002f }
            com.luajava.LuaState r2 = r8.f2346c     // Catch:{ LuaException -> 0x002f }
            r2.pop(r0)     // Catch:{ LuaException -> 0x002f }
            com.luajava.LuaFunction<android.view.View> r2 = r8.f2353j     // Catch:{ LuaException -> 0x002f }
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ LuaException -> 0x002f }
            com.luajava.LuaTable r4 = r8.f2349f     // Catch:{ LuaException -> 0x002f }
            r3[r11] = r4     // Catch:{ LuaException -> 0x002f }
            r3[r0] = r1     // Catch:{ LuaException -> 0x002f }
            r4 = 2
            java.lang.Class<android.widget.AbsListView> r5 = android.widget.AbsListView.class
            r3[r4] = r5     // Catch:{ LuaException -> 0x002f }
            java.lang.Object r2 = r2.call(r3)     // Catch:{ LuaException -> 0x002f }
            android.view.View r2 = (android.view.View) r2     // Catch:{ LuaException -> 0x002f }
            r2.setTag(r1)     // Catch:{ LuaException -> 0x002f }
            goto L_0x0042
        L_0x002f:
            android.view.View r9 = new android.view.View
            com.androlua.LuaContext r10 = r8.f2347d
            android.content.Context r10 = r10.getContext()
            r9.<init>(r10)
            return r9
        L_0x003b:
            java.lang.Object r1 = r10.getTag()
            com.luajava.LuaObject r1 = (com.luajava.LuaObject) r1
            r2 = r10
        L_0x0042:
            com.luajava.LuaTable<java.lang.Integer, com.luajava.LuaTable<java.lang.String, java.lang.Object>> r3 = r8.f2350g
            int r4 = r9 + 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r3 = r3.get(r4)
            com.luajava.LuaTable r3 = (com.luajava.LuaTable) r3
            if (r3 != 0) goto L_0x0069
            java.lang.String r10 = "lua"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " is null"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            android.util.Log.i(r10, r9)
            return r2
        L_0x0069:
            java.util.HashMap<android.view.View, java.lang.Boolean> r9 = r8.f2358o
            java.lang.Object r9 = r9.get(r2)
            if (r9 != 0) goto L_0x0073
            r9 = 1
            goto L_0x0074
        L_0x0073:
            r9 = 0
        L_0x0074:
            if (r9 == 0) goto L_0x007f
            java.util.HashMap<android.view.View, java.lang.Boolean> r4 = r8.f2358o
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r4.put(r2, r0)
        L_0x007f:
            java.util.Set r0 = r3.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0087:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00d1
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00c6 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x00c6 }
            com.luajava.LuaObject r5 = r1.getField(r4)     // Catch:{ Exception -> 0x00c6 }
            boolean r6 = r5.isJavaObject()     // Catch:{ Exception -> 0x00c6 }
            if (r6 == 0) goto L_0x0087
            com.luajava.LuaTable<java.lang.String, java.lang.Object> r6 = r8.f2351h     // Catch:{ Exception -> 0x00c6 }
            if (r6 == 0) goto L_0x00bc
            if (r9 == 0) goto L_0x00bc
            java.lang.Object r6 = r5.getObject()     // Catch:{ Exception -> 0x00c6 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ Exception -> 0x00c6 }
            com.luajava.LuaTable<java.lang.String, java.lang.Object> r7 = r8.f2351h     // Catch:{ Exception -> 0x00c6 }
            java.lang.Object r4 = r7.get(r4)     // Catch:{ Exception -> 0x00c6 }
            r8.m2165a(r6, r4)     // Catch:{ Exception -> 0x00c6 }
        L_0x00bc:
            java.lang.Object r4 = r5.getObject()     // Catch:{ Exception -> 0x00c6 }
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x00c6 }
            r8.m2165a(r4, r3)     // Catch:{ Exception -> 0x00c6 }
            goto L_0x0087
        L_0x00c6:
            r3 = move-exception
            java.lang.String r4 = "lua"
            java.lang.String r3 = r3.getMessage()
            android.util.Log.i(r4, r3)
            goto L_0x0087
        L_0x00d1:
            boolean r9 = r8.f2360q
            if (r9 == 0) goto L_0x00d6
            return r2
        L_0x00d6:
            com.luajava.LuaFunction<android.view.animation.Animation> r9 = r8.f2356m
            if (r9 == 0) goto L_0x010b
            if (r10 == 0) goto L_0x010b
            java.util.HashMap<android.view.View, android.view.animation.Animation> r9 = r8.f2357n
            java.lang.Object r9 = r9.get(r10)
            android.view.animation.Animation r9 = (android.view.animation.Animation) r9
            if (r9 != 0) goto L_0x0103
            com.luajava.LuaFunction<android.view.animation.Animation> r0 = r8.f2356m     // Catch:{ Exception -> 0x00fb }
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x00fb }
            java.lang.Object r11 = r0.call(r11)     // Catch:{ Exception -> 0x00fb }
            android.view.animation.Animation r11 = (android.view.animation.Animation) r11     // Catch:{ Exception -> 0x00fb }
            java.util.HashMap<android.view.View, android.view.animation.Animation> r9 = r8.f2357n     // Catch:{ Exception -> 0x00f7 }
            r9.put(r10, r11)     // Catch:{ Exception -> 0x00f7 }
            r9 = r11
            goto L_0x0103
        L_0x00f7:
            r9 = move-exception
            r10 = r9
            r9 = r11
            goto L_0x00fc
        L_0x00fb:
            r10 = move-exception
        L_0x00fc:
            com.androlua.LuaContext r11 = r8.f2347d
            java.lang.String r0 = "setAnimation"
            r11.sendError(r0, r10)
        L_0x0103:
            if (r9 == 0) goto L_0x010b
            r2.clearAnimation()
            r2.startAnimation(r9)
        L_0x010b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public void insert(int i, LuaTable<String, Object> luaTable) {
        this.f2354k.call(this.f2344a, Integer.valueOf(i + 1), luaTable);
        if (this.f2359p) {
            notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (!this.f2360q) {
            this.f2360q = true;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    LuaAdapter.this.f2360q = false;
                }
            }, 500);
        }
    }

    public void remove(int i) {
        this.f2355l.call(this.f2344a, Integer.valueOf(i + 1));
        if (this.f2359p) {
            notifyDataSetChanged();
        }
    }

    public void setAnimation(LuaFunction<Animation> luaFunction) {
        setAnimationUtil(luaFunction);
    }

    public void setAnimationUtil(LuaFunction<Animation> luaFunction) {
        this.f2357n.clear();
        this.f2356m = luaFunction;
    }

    public void setFilter(LuaFunction luaFunction) {
        this.f2364u = luaFunction;
    }

    public void setNotifyOnChange(boolean z) {
        this.f2359p = z;
        if (this.f2359p) {
            notifyDataSetChanged();
        }
    }

    public void setStyle(LuaTable<String, Object> luaTable) {
        this.f2358o.clear();
        this.f2351h = luaTable;
    }
}
