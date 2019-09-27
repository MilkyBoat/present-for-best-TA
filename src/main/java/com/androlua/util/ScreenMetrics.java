package com.androlua.util;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

public class ScreenMetrics {

    /* renamed from: a */
    private static int f2796a;

    /* renamed from: b */
    private static int f2797b;

    /* renamed from: c */
    private static boolean f2798c;

    /* renamed from: d */
    private static int f2799d;

    /* renamed from: e */
    private static Display f2800e;

    /* renamed from: f */
    private int f2801f;

    /* renamed from: g */
    private int f2802g;

    public ScreenMetrics() {
    }

    public ScreenMetrics(int i, int i2) {
        this.f2801f = i;
        this.f2802g = i2;
    }

    public static int getDeviceScreenDensity() {
        return f2799d;
    }

    public static int getDeviceScreenHeight() {
        return f2796a;
    }

    public static int getDeviceScreenWidth() {
        return f2797b;
    }

    public static void initIfNeeded(Activity activity) {
        if (!f2798c) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            f2796a = displayMetrics.heightPixels;
            f2797b = displayMetrics.widthPixels;
            f2799d = displayMetrics.densityDpi;
            f2800e = activity.getWindowManager().getDefaultDisplay();
            f2798c = true;
        }
    }

    public static int rescaleX(int i, int i2) {
        if (i2 != 0) {
            if (!f2798c) {
                return i;
            }
            i = (i * i2) / f2797b;
        }
        return i;
    }

    public static int rescaleY(int i, int i2) {
        if (i2 != 0) {
            if (!f2798c) {
                return i;
            }
            i = (i * i2) / f2796a;
        }
        return i;
    }

    public static int scaleX(int i, int i2) {
        if (i2 != 0) {
            if (!f2798c) {
                return i;
            }
            i = (i * f2797b) / i2;
        }
        return i;
    }

    public static int scaleY(int i, int i2) {
        if (i2 != 0) {
            if (!f2798c) {
                return i;
            }
            i = (i * f2796a) / i2;
        }
        return i;
    }

    public int rescaleX(int i) {
        return rescaleX(i, this.f2801f);
    }

    public int rescaleY(int i) {
        return rescaleY(i, this.f2802g);
    }

    public int scaleX(int i) {
        return scaleX(i, this.f2801f);
    }

    public int scaleY(int i) {
        return scaleY(i, this.f2802g);
    }

    public void setDesignHeight(int i) {
        this.f2802g = i;
    }

    public void setDesignWidth(int i) {
        this.f2801f = i;
    }

    public void setScreenMetrics(int i, int i2) {
        this.f2801f = i;
        this.f2802g = i2;
    }
}
