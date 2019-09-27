package com.androlua;

import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.androlua.GifDecoder.GifAction;
import com.androlua.GifDecoder.GifFrame;
import com.androlua.util.AsyncTaskX;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LuaBitmapDrawable extends Drawable implements LuaGcable, Runnable {
    public static final int CENTER = 5;
    public static final int CENTER_CROP = 6;
    public static final int CENTER_INSIDE = 7;
    public static final int FIT_CENTER = 3;
    public static final int FIT_END = 4;
    public static final int FIT_START = 2;
    public static final int FIT_XY = 1;
    public static final int MATRIX = 0;

    /* renamed from: q */
    private static long f2409q = 604800000;

    /* renamed from: a */
    private LuaContext f2410a;

    /* renamed from: b */
    private int f2411b;

    /* renamed from: c */
    private long f2412c;

    /* renamed from: d */
    private int f2413d;

    /* renamed from: e */
    private Movie f2414e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LoadingDrawable f2415f;

    /* renamed from: g */
    private Drawable f2416g;

    /* renamed from: h */
    private NineBitmapDrawable f2417h;

    /* renamed from: i */
    private ColorFilter f2418i;

    /* renamed from: j */
    private int f2419j;

    /* renamed from: k */
    private int f2420k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public GifDecoder f2421l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public GifDecoder f2422m;

    /* renamed from: n */
    private GifFrame f2423n;

    /* renamed from: o */
    private int f2424o;

    /* renamed from: p */
    private boolean f2425p;

    public LuaBitmapDrawable(LuaContext luaContext, String str) {
        this.f2420k = 1;
        this.f2410a = luaContext;
        this.f2415f = new LoadingDrawable(luaContext.getContext());
        if (str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://")) {
            m2192a(luaContext, str);
            return;
        }
        if (!str.startsWith("/")) {
            str = luaContext.getLuaPath(str);
        }
        m2193a(str);
    }

    public LuaBitmapDrawable(LuaContext luaContext, String str, Drawable drawable) {
        this(luaContext, str);
        this.f2416g = drawable;
    }

    /* renamed from: a */
    private void m2192a(final LuaContext luaContext, final String str) {
        new AsyncTaskX<String, String, String>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public String mo1858a(String... strArr) {
                try {
                    return LuaBitmapDrawable.getHttpBitmap(luaContext, str);
                } catch (Exception e) {
                    C0029a.m806a(e);
                    return BuildConfig.FLAVOR;
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo1859a(String str) {
                LuaBitmapDrawable.this.m2193a(str);
            }
        }.execute((Params[]) new String[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2193a(final String str) {
        try {
            this.f2421l = new GifDecoder((InputStream) new FileInputStream(str), (GifAction) new GifAction() {
                public void parseOk(boolean z, int i) {
                    if (z || i >= 0) {
                        if (z && LuaBitmapDrawable.this.f2422m == null && LuaBitmapDrawable.this.f2421l.getFrameCount() > 1) {
                            LuaBitmapDrawable.this.f2422m = LuaBitmapDrawable.this.f2421l;
                        }
                        return;
                    }
                    LuaBitmapDrawable.this.m2196b(str);
                }
            });
            this.f2421l.start();
        } catch (Exception e) {
            C0029a.m806a(e);
            m2196b(str);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0036 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m2196b(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = r5.isEmpty()
            r1 = 1000(0x3e8, double:4.94E-321)
            if (r0 == 0) goto L_0x0019
            android.os.Handler r5 = new android.os.Handler
            r5.<init>()
            com.androlua.LuaBitmapDrawable$3 r0 = new com.androlua.LuaBitmapDrawable$3
            r0.<init>()
            r5.postDelayed(r0, r1)
            r4.invalidateSelf()
            return
        L_0x0019:
            android.graphics.Movie r0 = r4.f2414e
            if (r0 == 0) goto L_0x002e
            android.graphics.Movie r5 = r4.f2414e
            int r5 = r5.duration()
            r4.f2411b = r5
            int r5 = r4.f2411b
            if (r5 != 0) goto L_0x0048
            r5 = 1000(0x3e8, float:1.401E-42)
            r4.f2411b = r5
            goto L_0x0048
        L_0x002e:
            com.androlua.NineBitmapDrawable r0 = new com.androlua.NineBitmapDrawable     // Catch:{ Exception -> 0x0036 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0036 }
            r4.f2417h = r0     // Catch:{ Exception -> 0x0036 }
            goto L_0x0048
        L_0x0036:
            android.graphics.drawable.BitmapDrawable r0 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Exception -> 0x0044 }
            com.androlua.LuaContext r3 = r4.f2410a     // Catch:{ Exception -> 0x0044 }
            android.graphics.Bitmap r5 = com.androlua.LuaBitmap.getLocalBitmap(r3, r5)     // Catch:{ Exception -> 0x0044 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0044 }
            r4.f2416g = r0     // Catch:{ Exception -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r5 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r5)
        L_0x0048:
            android.graphics.Movie r5 = r4.f2414e
            if (r5 != 0) goto L_0x0061
            android.graphics.drawable.Drawable r5 = r4.f2416g
            if (r5 != 0) goto L_0x0061
            com.androlua.NineBitmapDrawable r5 = r4.f2417h
            if (r5 != 0) goto L_0x0061
            android.os.Handler r5 = new android.os.Handler
            r5.<init>()
            com.androlua.LuaBitmapDrawable$4 r0 = new com.androlua.LuaBitmapDrawable$4
            r0.<init>()
            r5.postDelayed(r0, r1)
        L_0x0061:
            r4.invalidateSelf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaBitmapDrawable.m2196b(java.lang.String):void");
    }

    public static long getCacheTime() {
        return f2409q;
    }

    public static String getHttpBitmap(LuaContext luaContext, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(luaContext.getLuaExtDir("cache"));
        sb.append("/");
        sb.append(str.hashCode());
        String sb2 = sb.toString();
        File file = new File(sb2);
        if (file.exists() && System.currentTimeMillis() - file.lastModified() < f2409q) {
            return sb2;
        }
        new File(sb2).delete();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(120000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(sb2);
        if (!LuaUtil.copyFile(inputStream, (OutputStream) fileOutputStream)) {
            fileOutputStream.close();
            inputStream.close();
            new File(sb2).delete();
            throw new RuntimeException("LoadHttpBitmap Error.");
        }
        fileOutputStream.close();
        inputStream.close();
        return sb2;
    }

    public static void setCacheTime(long j) {
        f2409q = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r11) {
        /*
            r10 = this;
            int r0 = r10.f2419j
            r11.drawColor(r0)
            com.androlua.GifDecoder r0 = r10.f2422m
            r1 = 0
            r3 = 1
            if (r0 == 0) goto L_0x00d2
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r10.f2412c
            int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003e
            com.androlua.GifDecoder$GifFrame r0 = r10.f2423n
            if (r0 != 0) goto L_0x001b
            goto L_0x003e
        L_0x001b:
            long r0 = r10.f2412c
            long r6 = r4 - r0
            int r0 = r10.f2424o
            long r0 = (long) r0
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x004e
            com.androlua.GifDecoder r0 = r10.f2422m
            com.androlua.GifDecoder$GifFrame r0 = r0.next()
            r10.f2423n = r0
            com.androlua.GifDecoder$GifFrame r0 = r10.f2423n
            int r0 = r0.delay
            r10.f2424o = r0
            long r0 = r10.f2412c
            int r2 = r10.f2424o
            long r6 = (long) r2
            long r8 = r0 + r6
            r10.f2412c = r8
            goto L_0x001b
        L_0x003e:
            com.androlua.GifDecoder r0 = r10.f2422m
            com.androlua.GifDecoder$GifFrame r0 = r0.next()
            r10.f2423n = r0
            com.androlua.GifDecoder$GifFrame r0 = r10.f2423n
            int r0 = r0.delay
            r10.f2424o = r0
            r10.f2412c = r4
        L_0x004e:
            com.androlua.GifDecoder$GifFrame r0 = r10.f2423n
            if (r0 == 0) goto L_0x00ce
            android.graphics.Rect r0 = r10.getBounds()
            android.graphics.drawable.BitmapDrawable r1 = new android.graphics.drawable.BitmapDrawable
            com.androlua.GifDecoder$GifFrame r2 = r10.f2423n
            android.graphics.Bitmap r2 = r2.image
            r1.<init>(r2)
            int r2 = r1.getIntrinsicWidth()
            int r4 = r1.getIntrinsicHeight()
            int r5 = r10.f2420k
            if (r5 != r3) goto L_0x0082
            int r3 = r0.right
            int r5 = r0.left
            int r3 = r3 - r5
            float r3 = (float) r3
            float r2 = (float) r2
            float r3 = r3 / r2
            int r5 = r0.bottom
            int r6 = r0.top
            int r5 = r5 - r6
            float r5 = (float) r5
            float r4 = (float) r4
            float r5 = r5 / r4
            float r2 = r2 * r3
            int r2 = (int) r2
            float r4 = r4 * r5
        L_0x0080:
            int r4 = (int) r4
            goto L_0x00a0
        L_0x0082:
            int r3 = r10.f2420k
            if (r3 == 0) goto L_0x00a0
            int r3 = r0.bottom
            int r5 = r0.top
            int r3 = r3 - r5
            float r3 = (float) r3
            float r4 = (float) r4
            float r3 = r3 / r4
            int r5 = r0.right
            int r6 = r0.left
            int r5 = r5 - r6
            float r5 = (float) r5
            float r2 = (float) r2
            float r5 = r5 / r2
            float r3 = java.lang.Math.min(r3, r5)
            float r2 = r2 * r3
            int r2 = (int) r2
            float r4 = r4 * r3
            goto L_0x0080
        L_0x00a0:
            int r3 = r0.left
            int r5 = r0.top
            int r6 = r10.f2420k
            switch(r6) {
                case 3: goto L_0x00b1;
                case 4: goto L_0x00aa;
                default: goto L_0x00a9;
            }
        L_0x00a9:
            goto L_0x00c1
        L_0x00aa:
            int r5 = r0.bottom
            int r0 = r0.top
            int r5 = r5 - r0
            int r5 = r5 - r4
            goto L_0x00c1
        L_0x00b1:
            int r3 = r0.right
            int r5 = r0.left
            int r3 = r3 - r5
            int r3 = r3 - r2
            int r3 = r3 / 2
            int r5 = r0.bottom
            int r0 = r0.top
            int r5 = r5 - r0
            int r5 = r5 - r4
            int r5 = r5 / 2
        L_0x00c1:
            android.graphics.Rect r0 = new android.graphics.Rect
            int r2 = r2 + r3
            int r4 = r4 + r5
            r0.<init>(r3, r5, r2, r4)
            r1.setBounds(r0)
            r1.draw(r11)
        L_0x00ce:
            r10.invalidateSelf()
            return
        L_0x00d2:
            android.graphics.Movie r0 = r10.f2414e
            if (r0 == 0) goto L_0x0185
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r10.f2412c
            int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x00e2
            r10.f2412c = r4
        L_0x00e2:
            long r0 = r10.f2412c
            long r6 = r4 - r0
            int r0 = r10.f2411b
            long r0 = (long) r0
            long r6 = r6 % r0
            int r0 = (int) r6
            r10.f2413d = r0
            android.graphics.Movie r0 = r10.f2414e
            int r1 = r10.f2413d
            r0.setTime(r1)
            android.graphics.Rect r0 = r10.getBounds()
            r11.save()
            android.graphics.Movie r1 = r10.f2414e
            int r1 = r1.width()
            android.graphics.Movie r2 = r10.f2414e
            int r2 = r2.height()
            r4 = 1065353216(0x3f800000, float:1.0)
            int r5 = r10.f2420k
            if (r5 != r3) goto L_0x0127
            int r3 = r0.right
            int r5 = r0.left
            int r3 = r3 - r5
            float r3 = (float) r3
            float r1 = (float) r1
            float r3 = r3 / r1
            int r5 = r0.bottom
            int r6 = r0.top
            int r5 = r5 - r6
            float r5 = (float) r5
            float r2 = (float) r2
            float r5 = r5 / r2
            r11.scale(r3, r5)
            float r1 = r1 * r3
            int r1 = (int) r1
            float r2 = r2 * r5
        L_0x0125:
            int r2 = (int) r2
            goto L_0x0148
        L_0x0127:
            int r3 = r10.f2420k
            if (r3 == 0) goto L_0x0148
            int r3 = r0.bottom
            int r4 = r0.top
            int r3 = r3 - r4
            float r3 = (float) r3
            float r2 = (float) r2
            float r3 = r3 / r2
            int r4 = r0.right
            int r5 = r0.left
            int r4 = r4 - r5
            float r4 = (float) r4
            float r1 = (float) r1
            float r4 = r4 / r1
            float r4 = java.lang.Math.min(r3, r4)
            r11.scale(r4, r4)
            float r1 = r1 * r4
            int r1 = (int) r1
            float r2 = r2 * r4
            goto L_0x0125
        L_0x0148:
            int r3 = r0.left
            int r5 = r0.top
            int r6 = r10.f2420k
            switch(r6) {
                case 3: goto L_0x015d;
                case 4: goto L_0x0152;
                default: goto L_0x0151;
            }
        L_0x0151:
            goto L_0x0174
        L_0x0152:
            int r1 = r0.bottom
            int r0 = r0.top
            int r1 = r1 - r0
            float r0 = (float) r1
            float r1 = (float) r2
            float r1 = r1 / r4
            float r0 = r0 - r1
            int r5 = (int) r0
            goto L_0x0174
        L_0x015d:
            int r3 = r0.right
            int r5 = r0.left
            int r3 = r3 - r5
            int r3 = r3 - r1
            float r1 = (float) r3
            float r1 = r1 / r4
            r3 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r3
            int r1 = (int) r1
            int r5 = r0.bottom
            int r0 = r0.top
            int r5 = r5 - r0
            int r5 = r5 - r2
            float r0 = (float) r5
            float r0 = r0 / r4
            float r0 = r0 / r3
            int r5 = (int) r0
            r3 = r1
        L_0x0174:
            android.graphics.Movie r0 = r10.f2414e
            float r1 = (float) r3
            float r2 = (float) r5
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            r0.draw(r11, r1, r2, r3)
            r11.restore()
            goto L_0x00ce
        L_0x0185:
            android.graphics.drawable.Drawable r0 = r10.f2416g
            if (r0 == 0) goto L_0x0205
            android.graphics.Rect r0 = r10.getBounds()
            android.graphics.drawable.Drawable r1 = r10.f2416g
            int r1 = r1.getIntrinsicWidth()
            android.graphics.drawable.Drawable r2 = r10.f2416g
            int r2 = r2.getIntrinsicHeight()
            int r4 = r10.f2420k
            if (r4 != r3) goto L_0x01b4
            int r3 = r0.right
            int r4 = r0.left
            int r3 = r3 - r4
            float r3 = (float) r3
            float r1 = (float) r1
            float r3 = r3 / r1
            int r4 = r0.bottom
            int r5 = r0.top
            int r4 = r4 - r5
            float r4 = (float) r4
            float r2 = (float) r2
            float r4 = r4 / r2
            float r1 = r1 * r3
            int r1 = (int) r1
            float r2 = r2 * r4
        L_0x01b2:
            int r2 = (int) r2
            goto L_0x01d2
        L_0x01b4:
            int r3 = r10.f2420k
            if (r3 == 0) goto L_0x01d2
            int r3 = r0.bottom
            int r4 = r0.top
            int r3 = r3 - r4
            float r3 = (float) r3
            float r2 = (float) r2
            float r3 = r3 / r2
            int r4 = r0.right
            int r5 = r0.left
            int r4 = r4 - r5
            float r4 = (float) r4
            float r1 = (float) r1
            float r4 = r4 / r1
            float r3 = java.lang.Math.min(r3, r4)
            float r1 = r1 * r3
            int r1 = (int) r1
            float r2 = r2 * r3
            goto L_0x01b2
        L_0x01d2:
            int r3 = r0.left
            int r4 = r0.top
            int r5 = r10.f2420k
            switch(r5) {
                case 3: goto L_0x01e3;
                case 4: goto L_0x01dc;
                default: goto L_0x01db;
            }
        L_0x01db:
            goto L_0x01f3
        L_0x01dc:
            int r4 = r0.bottom
            int r0 = r0.top
            int r4 = r4 - r0
            int r4 = r4 - r2
            goto L_0x01f3
        L_0x01e3:
            int r3 = r0.right
            int r4 = r0.left
            int r3 = r3 - r4
            int r3 = r3 - r1
            int r3 = r3 / 2
            int r4 = r0.bottom
            int r0 = r0.top
            int r4 = r4 - r0
            int r4 = r4 - r2
            int r4 = r4 / 2
        L_0x01f3:
            android.graphics.drawable.Drawable r0 = r10.f2416g
            android.graphics.Rect r5 = new android.graphics.Rect
            int r1 = r1 + r3
            int r2 = r2 + r4
            r5.<init>(r3, r4, r1, r2)
            r0.setBounds(r5)
            android.graphics.drawable.Drawable r0 = r10.f2416g
            r0.draw(r11)
            return
        L_0x0205:
            com.androlua.NineBitmapDrawable r0 = r10.f2417h
            if (r0 == 0) goto L_0x0218
            com.androlua.NineBitmapDrawable r0 = r10.f2417h
            android.graphics.Rect r1 = r10.getBounds()
            r0.setBounds(r1)
            com.androlua.NineBitmapDrawable r0 = r10.f2417h
            r0.draw(r11)
            return
        L_0x0218:
            com.androlua.LoadingDrawable r0 = r10.f2415f
            if (r0 == 0) goto L_0x022c
            com.androlua.LoadingDrawable r0 = r10.f2415f
            android.graphics.Rect r1 = r10.getBounds()
            r0.setBounds(r1)
            com.androlua.LoadingDrawable r0 = r10.f2415f
            r0.draw(r11)
            goto L_0x00ce
        L_0x022c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaBitmapDrawable.draw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.f2422m != null) {
            this.f2422m.free();
        }
    }

    /* renamed from: gc */
    public void mo2151gc() {
        if (this.f2422m != null) {
            this.f2422m.free();
        }
        if (this.f2416g != null && (this.f2416g instanceof BitmapDrawable)) {
            ((BitmapDrawable) this.f2416g).getBitmap().recycle();
        }
        if (this.f2417h != null) {
            this.f2417h.mo2151gc();
        }
        this.f2422m = null;
        this.f2416g = null;
        this.f2417h = null;
        this.f2415f.setState(-1);
        this.f2425p = true;
    }

    public int getIntrinsicHeight() {
        if (this.f2414e != null) {
            return this.f2414e.height();
        }
        if (this.f2416g != null) {
            this.f2416g.getIntrinsicHeight();
        } else if (this.f2417h != null) {
            this.f2417h.getIntrinsicHeight();
        }
        return super.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        if (this.f2414e != null) {
            return this.f2414e.width();
        }
        if (this.f2416g != null) {
            this.f2416g.getIntrinsicWidth();
        } else if (this.f2417h != null) {
            this.f2417h.getIntrinsicWidth();
        }
        return super.getIntrinsicWidth();
    }

    public int getOpacity() {
        return 0;
    }

    public boolean isGc() {
        return this.f2425p;
    }

    public void run() {
        invalidateSelf();
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2418i = colorFilter;
    }

    public void setFillColor(int i) {
        if (i != this.f2419j) {
            this.f2419j = i;
        }
    }

    public void setScaleType(int i) {
        if (this.f2420k != i) {
            this.f2420k = i;
            invalidateSelf();
        }
    }
}
