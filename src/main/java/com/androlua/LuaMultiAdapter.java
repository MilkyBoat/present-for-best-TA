package com.androlua;

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
import android.widget.ImageView;
import android.widget.TextView;
import com.luajava.LuaException;
import com.luajava.LuaFunction;
import com.luajava.LuaJavaAPI;
import com.luajava.LuaState;
import com.luajava.LuaTable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class LuaMultiAdapter extends BaseAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Resources f2540a;

    /* renamed from: b */
    private LuaState f2541b;

    /* renamed from: c */
    private LuaContext f2542c;

    /* renamed from: d */
    private LuaTable<Integer, LuaTable> f2543d;

    /* renamed from: e */
    private LuaTable<Integer, LuaTable<String, Object>> f2544e;

    /* renamed from: f */
    private LuaTable<String, Object> f2545f;

    /* renamed from: g */
    private LuaFunction<View> f2546g;

    /* renamed from: h */
    private LuaFunction f2547h;

    /* renamed from: i */
    private LuaFunction f2548i;

    /* renamed from: j */
    private LuaTable<Integer, LuaFunction<Animation>> f2549j;

    /* renamed from: k */
    private HashMap<View, Animation> f2550k;

    /* renamed from: l */
    private HashMap<View, Boolean> f2551l;

    /* renamed from: m */
    private boolean f2552m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f2553n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Handler f2554o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public HashMap<String, Boolean> f2555p;

    private class AsyncLoader extends Thread {

        /* renamed from: b */
        private String f2559b;

        /* renamed from: c */
        private LuaContext f2560c;

        private AsyncLoader() {
        }

        public Drawable getBitmap(LuaContext luaContext, String str) {
            this.f2560c = luaContext;
            this.f2559b = str;
            if (!str.toLowerCase().startsWith("http://") && !str.toLowerCase().startsWith("https://")) {
                return new BitmapDrawable(LuaMultiAdapter.this.f2540a, LuaBitmap.getBitmap(luaContext, str));
            }
            if (LuaBitmap.checkCache(luaContext, str)) {
                return new BitmapDrawable(LuaMultiAdapter.this.f2540a, LuaBitmap.getBitmap(luaContext, str));
            }
            if (!LuaMultiAdapter.this.f2555p.containsKey(this.f2559b)) {
                start();
                LuaMultiAdapter.this.f2555p.put(this.f2559b, Boolean.valueOf(true));
            }
            return new LoadingDrawable(this.f2560c.getContext());
        }

        public void run() {
            try {
                LuaBitmap.getBitmap(this.f2560c, this.f2559b);
                LuaMultiAdapter.this.f2554o.sendEmptyMessage(0);
            } catch (IOException e) {
                this.f2560c.sendError("AsyncLoader", e);
            }
        }
    }

    public LuaMultiAdapter(LuaContext luaContext, LuaTable luaTable) {
        this(luaContext, null, luaTable);
    }

    public LuaMultiAdapter(LuaContext luaContext, LuaTable<Integer, LuaTable<String, Object>> luaTable, LuaTable<Integer, LuaTable> luaTable2) {
        this.f2550k = new HashMap<>();
        this.f2551l = new HashMap<>();
        this.f2552m = true;
        this.f2554o = new Handler() {
            public void handleMessage(Message message) {
                LuaMultiAdapter.this.notifyDataSetChanged();
            }
        };
        this.f2555p = new HashMap<>();
        this.f2542c = luaContext;
        this.f2543d = luaTable2;
        this.f2540a = this.f2542c.getContext().getResources();
        this.f2541b = luaContext.getLuaState();
        if (luaTable == null) {
            luaTable = new LuaTable<>(this.f2541b);
        }
        this.f2544e = luaTable;
        this.f2546g = this.f2541b.getLuaObject("loadlayout").getFunction();
        this.f2547h = this.f2541b.getLuaObject("table").getField("insert").getFunction();
        this.f2548i = this.f2541b.getLuaObject("table").getField("remove").getFunction();
        int length = this.f2543d.length();
        for (int i = 1; i <= length; i++) {
            this.f2541b.newTable();
            this.f2546g.call(this.f2543d.get(Integer.valueOf(i)), this.f2541b.getLuaObject(-1), AbsListView.class);
            this.f2541b.pop(1);
        }
    }

    /* renamed from: a */
    private int m2244a(Object obj, String str, Object obj2) {
        return (str.length() <= 2 || !str.substring(0, 2).equals("on") || !(obj2 instanceof LuaFunction)) ? m2251c(obj, str, obj2) : m2249b(obj, str, obj2);
    }

    /* renamed from: a */
    private void m2246a(View view, LuaTable<String, Object> luaTable) {
        for (Entry entry : luaTable.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (str.toLowerCase().equals("src")) {
                m2247a(view, value);
            } else {
                m2244a(view, str, value);
            }
        }
    }

    /* renamed from: a */
    private void m2247a(View view, Object obj) {
        ImageView imageView;
        Drawable drawable;
        TextView textView;
        CharSequence obj2;
        try {
            if (obj instanceof LuaTable) {
                m2246a(view, (LuaTable) obj);
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
                        drawable = new AsyncLoader().getBitmap(this.f2542c, (String) obj);
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
            this.f2542c.sendError("setHelper", e);
        }
    }

    /* renamed from: b */
    private int m2249b(Object obj, String str, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append("setOn");
        sb.append(str.substring(2));
        sb.append("Listener");
        Iterator it = LuaJavaAPI.getMethod(obj.getClass(), sb.toString(), false).iterator();
        while (it.hasNext()) {
            Method method = (Method) it.next();
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].isInterface()) {
                this.f2541b.newTable();
                this.f2541b.pushObjectValue(obj2);
                this.f2541b.setField(-2, str);
                try {
                    method.invoke(obj, new Object[]{this.f2541b.getLuaObject(-1).createProxy(parameterTypes[0])});
                    return 1;
                } catch (Exception e) {
                    throw new LuaException(e);
                }
            }
        }
        return 0;
    }

    /* renamed from: c */
    private int m2251c(Object obj, String str, Object obj2) {
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
        this.f2547h.call(this.f2544e, luaTable);
        if (this.f2552m) {
            notifyDataSetChanged();
        }
    }

    public void addAll(LuaTable<Integer, LuaTable<String, Object>> luaTable) {
        int length = luaTable.length();
        for (int i = 1; i <= length; i++) {
            this.f2547h.call(this.f2544e, luaTable.get(Integer.valueOf(i)));
        }
        if (this.f2552m) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        this.f2544e.clear();
        if (this.f2552m) {
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.f2544e.length();
    }

    public LuaTable<Integer, LuaTable<String, Object>> getData() {
        return this.f2544e;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup);
    }

    public Object getItem(int i) {
        return this.f2544e.get(Integer.valueOf(i + 1));
    }

    public long getItemId(int i) {
        return (long) (i + 1);
    }

    public int getItemViewType(int i) {
        int intValue = ((Long) ((LuaTable) this.f2544e.get(Integer.valueOf(i + 1))).get("__type")).intValue() - 1;
        if (intValue < 0) {
            return 0;
        }
        return intValue;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r10, android.view.View r11, android.view.ViewGroup r12) {
        /*
            r9 = this;
            com.luajava.LuaTable<java.lang.Integer, com.luajava.LuaTable<java.lang.String, java.lang.Object>> r12 = r9.f2544e
            int r0 = r10 + 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Object r12 = r12.get(r1)
            com.luajava.LuaTable r12 = (com.luajava.LuaTable) r12
            java.lang.String r1 = "__type"
            java.lang.Object r12 = r12.get(r1)
            java.lang.Long r12 = (java.lang.Long) r12
            int r12 = r12.intValue()
            r1 = 1
            if (r12 >= r1) goto L_0x001e
            r12 = 1
        L_0x001e:
            r2 = 0
            if (r11 != 0) goto L_0x0062
            com.luajava.LuaTable<java.lang.Integer, com.luajava.LuaTable> r3 = r9.f2543d     // Catch:{ LuaException -> 0x0056 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)     // Catch:{ LuaException -> 0x0056 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ LuaException -> 0x0056 }
            com.luajava.LuaTable r3 = (com.luajava.LuaTable) r3     // Catch:{ LuaException -> 0x0056 }
            com.luajava.LuaState r4 = r9.f2541b     // Catch:{ LuaException -> 0x0056 }
            r4.newTable()     // Catch:{ LuaException -> 0x0056 }
            com.luajava.LuaState r4 = r9.f2541b     // Catch:{ LuaException -> 0x0056 }
            r5 = -1
            com.luajava.LuaObject r4 = r4.getLuaObject(r5)     // Catch:{ LuaException -> 0x0056 }
            com.luajava.LuaState r5 = r9.f2541b     // Catch:{ LuaException -> 0x0056 }
            r5.pop(r1)     // Catch:{ LuaException -> 0x0056 }
            com.luajava.LuaFunction<android.view.View> r5 = r9.f2546g     // Catch:{ LuaException -> 0x0056 }
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ LuaException -> 0x0056 }
            r6[r2] = r3     // Catch:{ LuaException -> 0x0056 }
            r6[r1] = r4     // Catch:{ LuaException -> 0x0056 }
            r3 = 2
            java.lang.Class<android.widget.AbsListView> r7 = android.widget.AbsListView.class
            r6[r3] = r7     // Catch:{ LuaException -> 0x0056 }
            java.lang.Object r3 = r5.call(r6)     // Catch:{ LuaException -> 0x0056 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ LuaException -> 0x0056 }
            r3.setTag(r4)     // Catch:{ LuaException -> 0x0056 }
            goto L_0x006a
        L_0x0056:
            android.view.View r10 = new android.view.View
            com.androlua.LuaContext r11 = r9.f2542c
            android.content.Context r11 = r11.getContext()
            r10.<init>(r11)
            return r10
        L_0x0062:
            java.lang.Object r3 = r11.getTag()
            r4 = r3
            com.luajava.LuaObject r4 = (com.luajava.LuaObject) r4
            r3 = r11
        L_0x006a:
            com.luajava.LuaTable<java.lang.Integer, com.luajava.LuaTable<java.lang.String, java.lang.Object>> r5 = r9.f2544e
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r5.get(r0)
            com.luajava.LuaTable r0 = (com.luajava.LuaTable) r0
            if (r0 != 0) goto L_0x008f
            java.lang.String r11 = "lua"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r10)
            java.lang.String r10 = " is null"
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            android.util.Log.i(r11, r10)
            return r3
        L_0x008f:
            java.util.HashMap<android.view.View, java.lang.Boolean> r10 = r9.f2551l
            java.lang.Object r10 = r10.get(r3)
            if (r10 != 0) goto L_0x0099
            r10 = 1
            goto L_0x009a
        L_0x0099:
            r10 = 0
        L_0x009a:
            if (r10 == 0) goto L_0x00a5
            java.util.HashMap<android.view.View, java.lang.Boolean> r5 = r9.f2551l
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r5.put(r3, r1)
        L_0x00a5:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x00ad:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0100
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r5 = r1.getKey()     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r6 = "type"
            boolean r6 = r5.equals(r6)     // Catch:{ Exception -> 0x00f5 }
            if (r6 == 0) goto L_0x00c8
            goto L_0x00ad
        L_0x00c8:
            java.lang.Object r1 = r1.getValue()     // Catch:{ Exception -> 0x00f5 }
            com.luajava.LuaObject r6 = r4.getField(r5)     // Catch:{ Exception -> 0x00f5 }
            boolean r7 = r6.isJavaObject()     // Catch:{ Exception -> 0x00f5 }
            if (r7 == 0) goto L_0x00ad
            com.luajava.LuaTable<java.lang.String, java.lang.Object> r7 = r9.f2545f     // Catch:{ Exception -> 0x00f5 }
            if (r7 == 0) goto L_0x00eb
            if (r10 == 0) goto L_0x00eb
            java.lang.Object r7 = r6.getObject()     // Catch:{ Exception -> 0x00f5 }
            android.view.View r7 = (android.view.View) r7     // Catch:{ Exception -> 0x00f5 }
            com.luajava.LuaTable<java.lang.String, java.lang.Object> r8 = r9.f2545f     // Catch:{ Exception -> 0x00f5 }
            java.lang.Object r5 = r8.get(r5)     // Catch:{ Exception -> 0x00f5 }
            r9.m2247a(r7, r5)     // Catch:{ Exception -> 0x00f5 }
        L_0x00eb:
            java.lang.Object r5 = r6.getObject()     // Catch:{ Exception -> 0x00f5 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ Exception -> 0x00f5 }
            r9.m2247a(r5, r1)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x00ad
        L_0x00f5:
            r1 = move-exception
            java.lang.String r5 = "lua"
            java.lang.String r1 = r1.getMessage()
            android.util.Log.i(r5, r1)
            goto L_0x00ad
        L_0x0100:
            boolean r10 = r9.f2553n
            if (r10 == 0) goto L_0x0105
            return r3
        L_0x0105:
            com.luajava.LuaTable<java.lang.Integer, com.luajava.LuaFunction<android.view.animation.Animation>> r10 = r9.f2549j
            if (r10 == 0) goto L_0x0144
            if (r11 == 0) goto L_0x0144
            java.util.HashMap<android.view.View, android.view.animation.Animation> r10 = r9.f2550k
            java.lang.Object r10 = r10.get(r11)
            android.view.animation.Animation r10 = (android.view.animation.Animation) r10
            if (r10 != 0) goto L_0x013c
            com.luajava.LuaTable<java.lang.Integer, com.luajava.LuaFunction<android.view.animation.Animation>> r0 = r9.f2549j     // Catch:{ Exception -> 0x0134 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0134 }
            java.lang.Object r12 = r0.get(r12)     // Catch:{ Exception -> 0x0134 }
            com.luajava.LuaFunction r12 = (com.luajava.LuaFunction) r12     // Catch:{ Exception -> 0x0134 }
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0134 }
            java.lang.Object r12 = r12.call(r0)     // Catch:{ Exception -> 0x0134 }
            android.view.animation.Animation r12 = (android.view.animation.Animation) r12     // Catch:{ Exception -> 0x0134 }
            java.util.HashMap<android.view.View, android.view.animation.Animation> r10 = r9.f2550k     // Catch:{ Exception -> 0x0130 }
            r10.put(r11, r12)     // Catch:{ Exception -> 0x0130 }
            r10 = r12
            goto L_0x013c
        L_0x0130:
            r10 = move-exception
            r11 = r10
            r10 = r12
            goto L_0x0135
        L_0x0134:
            r11 = move-exception
        L_0x0135:
            com.androlua.LuaContext r12 = r9.f2542c
            java.lang.String r0 = "setAnimation"
            r12.sendError(r0, r11)
        L_0x013c:
            if (r10 == 0) goto L_0x0144
            r3.clearAnimation()
            r3.startAnimation(r10)
        L_0x0144:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaMultiAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public int getViewTypeCount() {
        return this.f2543d.length();
    }

    public void insert(int i, LuaTable<String, Object> luaTable) {
        this.f2547h.call(this.f2544e, Integer.valueOf(i + 1), luaTable);
        if (this.f2552m) {
            notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (!this.f2553n) {
            this.f2553n = true;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    LuaMultiAdapter.this.f2553n = false;
                }
            }, 500);
        }
    }

    public void remove(int i) {
        this.f2548i.call(this.f2544e, Integer.valueOf(i + 1));
        if (this.f2552m) {
            notifyDataSetChanged();
        }
    }

    public void setAnimation(LuaTable<Integer, LuaFunction<Animation>> luaTable) {
        setAnimationUtil(luaTable);
    }

    public void setAnimationUtil(LuaTable<Integer, LuaFunction<Animation>> luaTable) {
        this.f2550k.clear();
        this.f2549j = luaTable;
    }

    public void setNotifyOnChange(boolean z) {
        this.f2552m = z;
        if (this.f2552m) {
            notifyDataSetChanged();
        }
    }

    public void setStyle(LuaTable<String, Object> luaTable) {
        this.f2551l.clear();
        this.f2545f = luaTable;
    }
}
