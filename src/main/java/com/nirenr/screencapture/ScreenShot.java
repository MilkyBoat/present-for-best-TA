package com.nirenr.screencapture;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.hardware.display.VirtualDisplay;
import android.hardware.display.VirtualDisplay.Callback;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import com.androlua.LuaAccessibilityService;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.nio.ByteBuffer;

@TargetApi(21)
public class ScreenShot {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static LuaAccessibilityService f3433a = null;
    public static String appName = "";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static ScreenCaptureListener f3434b;

    /* renamed from: c */
    private static Intent f3435c;

    /* renamed from: h */
    private static ScreenShot f3436h;
    public static Bitmap mScreenCaptureBitmap;

    /* renamed from: d */
    private final Context f3437d;

    /* renamed from: e */
    private final Callback f3438e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ScreenCaptureListener f3439f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Image f3440g;

    /* renamed from: i */
    private MediaProjection f3441i;

    /* renamed from: j */
    private VirtualDisplay f3442j;

    /* renamed from: k */
    private ImageReader f3443k;

    /* renamed from: l */
    private int f3444l;

    /* renamed from: m */
    private int f3445m;

    /* renamed from: n */
    private int f3446n;

    public class SaveTask extends AsyncTask<Image, Void, Bitmap> {
        public SaveTask() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bitmap doInBackground(Image... imageArr) {
            if (imageArr == null || imageArr.length < 1 || imageArr[0] == null) {
                return null;
            }
            Image image = imageArr[0];
            int width = image.getWidth();
            int height = image.getHeight();
            Plane[] planes = image.getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            int pixelStride = planes[0].getPixelStride();
            Bitmap createBitmap = Bitmap.createBitmap(((planes[0].getRowStride() - (pixelStride * width)) / pixelStride) + width, height, Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(buffer);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, width, height);
            image.close();
            ScreenShot.this.f3440g = null;
            if (ScreenShot.this.f3439f != null) {
                ScreenShot.this.f3439f.onScreenCaptureDone(createBitmap2);
                ScreenShot.this.f3439f = null;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null) {
                ScreenShot.this.setScreenCaptureBitmap(bitmap);
                Log.e("ryze", "获取图片成功");
            }
        }
    }

    public ScreenShot(Context context, Callback callback) {
        this.f3437d = context;
        this.f3438e = callback;
        m3302c();
        if (f3435c == null) {
            Intent intent = new Intent(this.f3437d, ScreenCaptureActivity.class);
            intent.setFlags(268435456);
            this.f3437d.startActivity(intent);
            return;
        }
        startVirtual();
    }

    /* renamed from: c */
    private void m3302c() {
        WindowManager windowManager = (WindowManager) this.f3437d.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        this.f3446n = displayMetrics.densityDpi;
        this.f3444l = displayMetrics.widthPixels;
        this.f3445m = displayMetrics.heightPixels;
        m3303d();
    }

    /* renamed from: d */
    private void m3303d() {
        this.f3443k = ImageReader.newInstance(this.f3444l, this.f3445m, 1, 1);
    }

    /* renamed from: e */
    private MediaProjectionManager m3304e() {
        return (MediaProjectionManager) this.f3437d.getSystemService("media_projection");
    }

    /* renamed from: f */
    private void m3305f() {
        if (this.f3441i == null) {
            setUpMediaProjection();
        }
        if (this.f3441i != null && this.f3442j == null) {
            try {
                this.f3442j = this.f3441i.createVirtualDisplay("screen-mirror", this.f3444l, this.f3445m, this.f3446n, 16, this.f3443k.getSurface(), this.f3438e, null);
            } catch (Exception e) {
                C0029a.m806a(e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m3306g() {
        if (this.f3440g == null) {
            this.f3440g = this.f3443k.acquireLatestImage();
            if (this.f3440g != null) {
                new SaveTask().execute(new Image[]{this.f3440g});
            } else if (this.f3439f != null) {
                this.f3439f.onScreenCaptureDone(null);
                this.f3439f = null;
            }
        }
    }

    public static void getResultData(LuaAccessibilityService luaAccessibilityService) {
        if (luaAccessibilityService != null && f3435c == null) {
            Intent intent = new Intent(luaAccessibilityService, ScreenCaptureActivity.class);
            intent.setFlags(268435456);
            luaAccessibilityService.startActivity(intent);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00da, code lost:
        if (r13 != null) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0112, code lost:
        if (r13 == null) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0114, code lost:
        r13.stop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0117, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void getScreenCaptureBitmap(com.androlua.LuaAccessibilityService r13, com.nirenr.screencapture.ScreenCaptureListener r14) {
        /*
            if (r13 != 0) goto L_0x0003
            return
        L_0x0003:
            f3433a = r13
            f3434b = r14
            r0 = 0
            android.content.Intent r1 = f3435c     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            if (r1 != 0) goto L_0x001f
            android.content.Intent r14 = new android.content.Intent     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            java.lang.Class<com.nirenr.screencapture.ScreenCaptureActivity> r1 = com.nirenr.screencapture.ScreenCaptureActivity.class
            r14.<init>(r13, r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r14.setFlags(r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            r13.startActivity(r14)     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            r13 = r0
            r1 = r13
            goto L_0x00d0
        L_0x001f:
            java.lang.String r1 = "window"
            java.lang.Object r1 = r13.getSystemService(r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            android.view.WindowManager r1 = (android.view.WindowManager) r1     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            android.util.DisplayMetrics r2 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            r2.<init>()     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            if (r1 == 0) goto L_0x003c
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            r1.getRealMetrics(r2)     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            int r1 = r2.densityDpi     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            int r3 = r2.widthPixels     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            int r2 = r2.heightPixels     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            goto L_0x0048
        L_0x003c:
            int r2 = r13.getHeight()     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            int r3 = r13.getWidth()     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            int r1 = r13.getDensity()     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
        L_0x0048:
            r8 = r1
            r7 = r2
            r6 = r3
            r1 = 1
            android.media.ImageReader r1 = android.media.ImageReader.newInstance(r6, r7, r1, r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00ef }
            java.lang.String r2 = "media_projection"
            java.lang.Object r13 = r13.getSystemService(r2)     // Catch:{ Exception -> 0x00ea, all -> 0x00e5 }
            android.media.projection.MediaProjectionManager r13 = (android.media.projection.MediaProjectionManager) r13     // Catch:{ Exception -> 0x00ea, all -> 0x00e5 }
            r2 = -1
            android.content.Intent r3 = f3435c     // Catch:{ Exception -> 0x00ea, all -> 0x00e5 }
            android.media.projection.MediaProjection r13 = r13.getMediaProjection(r2, r3)     // Catch:{ Exception -> 0x00ea, all -> 0x00e5 }
            java.lang.String r5 = "screen-mirror"
            r9 = 16
            android.view.Surface r10 = r1.getSurface()     // Catch:{ Exception -> 0x00e2, all -> 0x00df }
            r11 = 0
            r12 = 0
            r4 = r13
            android.hardware.display.VirtualDisplay r2 = r4.createVirtualDisplay(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00e2, all -> 0x00df }
            android.media.Image r3 = r1.acquireLatestImage()     // Catch:{ Exception -> 0x00dd }
            r4 = 0
            r5 = r3
            r3 = 0
        L_0x0075:
            r6 = 40
            if (r3 >= r6) goto L_0x008d
            r5 = 5
            java.lang.Thread.sleep(r5)     // Catch:{ InterruptedException -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r5 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r5)     // Catch:{ Exception -> 0x00dd }
        L_0x0083:
            android.media.Image r5 = r1.acquireLatestImage()     // Catch:{ Exception -> 0x00dd }
            if (r5 == 0) goto L_0x008a
            goto L_0x008d
        L_0x008a:
            int r3 = r3 + 1
            goto L_0x0075
        L_0x008d:
            if (r5 != 0) goto L_0x0095
            java.lang.String r3 = "请重试"
            r14.onScreenCaptureError(r3)     // Catch:{ Exception -> 0x00dd }
            goto L_0x00cb
        L_0x0095:
            int r3 = r5.getWidth()     // Catch:{ Exception -> 0x00dd }
            int r6 = r5.getHeight()     // Catch:{ Exception -> 0x00dd }
            android.media.Image$Plane[] r7 = r5.getPlanes()     // Catch:{ Exception -> 0x00dd }
            r8 = r7[r4]     // Catch:{ Exception -> 0x00dd }
            java.nio.ByteBuffer r8 = r8.getBuffer()     // Catch:{ Exception -> 0x00dd }
            r9 = r7[r4]     // Catch:{ Exception -> 0x00dd }
            int r9 = r9.getPixelStride()     // Catch:{ Exception -> 0x00dd }
            r7 = r7[r4]     // Catch:{ Exception -> 0x00dd }
            int r7 = r7.getRowStride()     // Catch:{ Exception -> 0x00dd }
            int r10 = r9 * r3
            int r7 = r7 - r10
            int r7 = r7 / r9
            int r7 = r7 + r3
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ Exception -> 0x00dd }
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createBitmap(r7, r6, r9)     // Catch:{ Exception -> 0x00dd }
            r7.copyPixelsFromBuffer(r8)     // Catch:{ Exception -> 0x00dd }
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r7, r4, r4, r3, r6)     // Catch:{ Exception -> 0x00dd }
            r5.close()     // Catch:{ Exception -> 0x00dd }
            r14.onScreenCaptureDone(r3)     // Catch:{ Exception -> 0x00dd }
        L_0x00cb:
            f3433a = r0     // Catch:{ Exception -> 0x00dd }
            f3434b = r0     // Catch:{ Exception -> 0x00dd }
            r0 = r2
        L_0x00d0:
            if (r0 == 0) goto L_0x00d5
            r0.release()
        L_0x00d5:
            if (r1 == 0) goto L_0x00da
            r1.close()
        L_0x00da:
            if (r13 == 0) goto L_0x0117
            goto L_0x0114
        L_0x00dd:
            r14 = move-exception
            goto L_0x00fa
        L_0x00df:
            r14 = move-exception
            r2 = r0
            goto L_0x0119
        L_0x00e2:
            r14 = move-exception
            r2 = r0
            goto L_0x00fa
        L_0x00e5:
            r13 = move-exception
            r14 = r13
            r13 = r0
            r2 = r13
            goto L_0x0119
        L_0x00ea:
            r13 = move-exception
            r14 = r13
            r13 = r0
            r2 = r13
            goto L_0x00fa
        L_0x00ef:
            r13 = move-exception
            r14 = r13
            r13 = r0
            r1 = r13
            r2 = r1
            goto L_0x0119
        L_0x00f5:
            r13 = move-exception
            r14 = r13
            r13 = r0
            r1 = r13
            r2 = r1
        L_0x00fa:
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r14)     // Catch:{ all -> 0x0118 }
            com.nirenr.screencapture.ScreenCaptureListener r14 = f3434b     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = "请重试"
            r14.onScreenCaptureError(r3)     // Catch:{ all -> 0x0118 }
            f3433a = r0     // Catch:{ all -> 0x0118 }
            f3434b = r0     // Catch:{ all -> 0x0118 }
            if (r2 == 0) goto L_0x010d
            r2.release()
        L_0x010d:
            if (r1 == 0) goto L_0x0112
            r1.close()
        L_0x0112:
            if (r13 == 0) goto L_0x0117
        L_0x0114:
            r13.stop()
        L_0x0117:
            return
        L_0x0118:
            r14 = move-exception
        L_0x0119:
            if (r2 == 0) goto L_0x011e
            r2.release()
        L_0x011e:
            if (r1 == 0) goto L_0x0123
            r1.close()
        L_0x0123:
            if (r13 == 0) goto L_0x0128
            r13.stop()
        L_0x0128:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nirenr.screencapture.ScreenShot.getScreenCaptureBitmap(com.androlua.LuaAccessibilityService, com.nirenr.screencapture.ScreenCaptureListener):void");
    }

    /* renamed from: h */
    private Bitmap m3307h() {
        if (this.f3443k == null) {
            return null;
        }
        this.f3440g = this.f3443k.acquireLatestImage();
        if (this.f3440g == null) {
            return null;
        }
        int width = this.f3440g.getWidth();
        int height = this.f3440g.getHeight();
        Plane[] planes = this.f3440g.getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        int pixelStride = planes[0].getPixelStride();
        Bitmap createBitmap = Bitmap.createBitmap(((planes[0].getRowStride() - (pixelStride * width)) / pixelStride) + width, height, Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(buffer);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, width, height);
        this.f3440g.close();
        this.f3440g = null;
        return createBitmap2;
    }

    /* renamed from: i */
    private void m3308i() {
        if (this.f3441i != null) {
            this.f3441i.stop();
            this.f3441i = null;
        }
    }

    /* renamed from: j */
    private void m3309j() {
        if (this.f3442j != null) {
            this.f3442j.release();
            this.f3442j = null;
        }
    }

    /* renamed from: k */
    private void m3310k() {
        if (this.f3443k != null) {
            this.f3443k.close();
        }
        this.f3443k = null;
    }

    public static void setResultData(Intent intent) {
        if (intent == null) {
            if (f3433a != null) {
                Toast.makeText(f3433a, "未获得权限", 0).show();
            }
            if (f3434b != null) {
                f3434b.onScreenCaptureError("未获得权限");
            }
            return;
        }
        f3435c = intent;
        if (f3433a != null) {
            f3433a.getHandler().postDelayed(new Runnable() {
                public void run() {
                    ScreenShot.getScreenCaptureBitmap(ScreenShot.f3433a, ScreenShot.f3434b);
                }
            }, 500);
        }
    }

    public Bitmap getScreenShot() {
        return m3307h();
    }

    public void reSize() {
        m3309j();
        m3310k();
        m3302c();
        startVirtual();
    }

    public void release() {
        m3309j();
        m3308i();
        m3310k();
        f3436h = null;
    }

    public void setScreenCaptureBitmap(Bitmap bitmap) {
        mScreenCaptureBitmap = bitmap;
    }

    public void setUpMediaProjection() {
        if (this.f3441i == null) {
            if (f3435c == null) {
                Intent intent = new Intent(this.f3437d, ScreenCaptureActivity.class);
                intent.setFlags(268435456);
                this.f3437d.startActivity(intent);
                return;
            }
            this.f3441i = m3304e().getMediaProjection(-1, f3435c);
        }
    }

    public void startScreenShot() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                ScreenShot.this.startVirtual();
            }
        }, 5);
        handler.postDelayed(new Runnable() {
            public void run() {
                ScreenShot.this.m3306g();
            }
        }, 100);
    }

    public void startScreenShot(ScreenCaptureListener screenCaptureListener) {
        if (this.f3439f == null) {
            this.f3439f = screenCaptureListener;
            startScreenShot();
        }
    }

    public void startVirtual() {
        if (this.f3441i == null) {
            setUpMediaProjection();
        }
        m3305f();
    }
}
