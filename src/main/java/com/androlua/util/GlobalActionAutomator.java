package com.androlua.util;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityService.GestureResultCallback;
import android.accessibilityservice.GestureDescription;
import android.accessibilityservice.GestureDescription.Builder;
import android.accessibilityservice.GestureDescription.StrokeDescription;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewConfiguration;

public class GlobalActionAutomator {

    /* renamed from: a */
    private AccessibilityService f2786a;

    /* renamed from: b */
    private ScreenMetrics f2787b;

    /* renamed from: c */
    private Handler f2788c;

    @TargetApi(24)
    public GlobalActionAutomator(AccessibilityService accessibilityService, Handler handler) {
        this.f2786a = accessibilityService;
        this.f2788c = handler;
    }

    /* renamed from: a */
    private Path m2364a(int[][] iArr) {
        Path path = new Path();
        path.moveTo((float) m2369b(iArr[0][0]), (float) m2372c(iArr[0][1]));
        for (int i = 1; i < iArr.length; i++) {
            int[] iArr2 = iArr[i];
            path.lineTo((float) m2369b(iArr2[0]), (float) m2372c(iArr2[1]));
        }
        return path;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2365a() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            myLooper.quit();
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    private boolean m2367a(int i) {
        if (this.f2786a == null) {
            return false;
        }
        return this.f2786a.performGlobalAction(i);
    }

    /* renamed from: a */
    private boolean m2368a(GestureDescription gestureDescription) {
        final VolatileDispose volatileDispose = new VolatileDispose();
        Log.i("GlobalActionAutomator", "dispatchGesture");
        return this.f2786a.dispatchGesture(gestureDescription, new GestureResultCallback() {
            public void onCancelled(GestureDescription gestureDescription) {
                Log.i("GlobalActionAutomator", "onCancelled");
                volatileDispose.setAndNotify(Boolean.valueOf(false));
            }

            public void onCompleted(GestureDescription gestureDescription) {
                Log.i("GlobalActionAutomator", "onCompleted");
                volatileDispose.setAndNotify(Boolean.valueOf(true));
            }
        }, this.f2788c);
    }

    /* renamed from: b */
    private int m2369b(int i) {
        return this.f2787b == null ? i : this.f2787b.scaleX(i);
    }

    /* renamed from: b */
    private void m2370b() {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
    }

    /* renamed from: b */
    private boolean m2371b(GestureDescription gestureDescription) {
        m2370b();
        final VolatileBox volatileBox = new VolatileBox(Boolean.valueOf(false));
        this.f2786a.dispatchGesture(gestureDescription, new GestureResultCallback() {
            public void onCancelled(GestureDescription gestureDescription) {
                volatileBox.set(Boolean.valueOf(false));
                GlobalActionAutomator.this.m2365a();
            }

            public void onCompleted(GestureDescription gestureDescription) {
                volatileBox.set(Boolean.valueOf(true));
                GlobalActionAutomator.this.m2365a();
            }
        }, new Handler(Looper.myLooper()));
        Looper.loop();
        return ((Boolean) volatileBox.get()).booleanValue();
    }

    /* renamed from: c */
    private int m2372c(int i) {
        return this.f2787b == null ? i : this.f2787b.scaleY(i);
    }

    public boolean back() {
        return m2367a(1);
    }

    public boolean click(int i, int i2) {
        return press(i, i2, ViewConfiguration.getTapTimeout());
    }

    public boolean gesture(long j, long j2, Path path) {
        StrokeDescription strokeDescription = new StrokeDescription(path, j, j2);
        return gestures(strokeDescription);
    }

    public boolean gesture(long j, long j2, int[]... iArr) {
        StrokeDescription strokeDescription = new StrokeDescription(m2364a(iArr), j, j2);
        return gestures(strokeDescription);
    }

    public void gestureAsync(long j, long j2, int[]... iArr) {
        StrokeDescription strokeDescription = new StrokeDescription(m2364a(iArr), j, j2);
        gesturesAsync(strokeDescription);
    }

    public boolean gestures(StrokeDescription... strokeDescriptionArr) {
        if (this.f2786a == null) {
            return false;
        }
        Builder builder = new Builder();
        for (StrokeDescription addStroke : strokeDescriptionArr) {
            builder.addStroke(addStroke);
        }
        return this.f2788c == null ? m2371b(builder.build()) : m2368a(builder.build());
    }

    public void gesturesAsync(StrokeDescription... strokeDescriptionArr) {
        if (this.f2786a != null) {
            Builder builder = new Builder();
            for (StrokeDescription addStroke : strokeDescriptionArr) {
                builder.addStroke(addStroke);
            }
            this.f2786a.dispatchGesture(builder.build(), null, null);
        }
    }

    public boolean home() {
        return m2367a(2);
    }

    public boolean longClick(int i, int i2) {
        return gesture(0, (long) (ViewConfiguration.getLongPressTimeout() + 200), new int[]{i, i2});
    }

    public boolean notifications() {
        return m2367a(4);
    }

    public boolean powerDialog() {
        return m2367a(6);
    }

    public boolean press(int i, int i2, int i3) {
        return gesture(0, (long) i3, new int[]{i, i2});
    }

    public boolean quickSettings() {
        return m2367a(5);
    }

    public boolean recents() {
        return m2367a(3);
    }

    public void setScreenMetrics(ScreenMetrics screenMetrics) {
        this.f2787b = screenMetrics;
    }

    public void setService(AccessibilityService accessibilityService) {
        this.f2786a = accessibilityService;
    }

    public boolean splitScreen() {
        return m2367a(7);
    }

    public boolean swipe(int i, int i2, int i3, int i4, int i5) {
        return gesture(0, (long) i5, new int[]{i, i2}, new int[]{i3, i4});
    }
}
