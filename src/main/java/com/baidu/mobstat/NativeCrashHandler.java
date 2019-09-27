package com.baidu.mobstat;

import android.content.Context;
import android.util.Log;
import java.io.File;

public final class NativeCrashHandler {

    /* renamed from: a */
    private static boolean f3074a = true;

    /* renamed from: b */
    private static Context f3075b;

    static {
        try {
            System.loadLibrary("crash_analysis");
        } catch (Throwable unused) {
            Log.w("NativeCrashHandler", "Load library failed.");
        }
    }

    private NativeCrashHandler() {
    }

    public static void doNativeCrash() {
        if (f3074a) {
            try {
                nativeException();
            } catch (Throwable unused) {
                Log.w("NativeCrashHandler", "Invoke method nativeException failed.");
            }
        }
    }

    public static void init(Context context) {
        if (context != null) {
            f3075b = context.getApplicationContext();
            if (f3074a) {
                File cacheDir = context.getCacheDir();
                if (cacheDir.exists() && cacheDir.isDirectory()) {
                    try {
                        nativeInit(cacheDir.getAbsolutePath());
                    } catch (Throwable unused) {
                        Log.w("NativeCrashHandler", "Invoke method nativeInit failed.");
                    }
                }
            }
        }
    }

    private static native void nativeException();

    private static native void nativeInit(String str);

    private static native void nativeProcess(String str);

    private static native void nativeUnint();

    public static void onCrashCallbackFromNative(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("crash: ");
        sb.append(str);
        Log.w("NativeCrashHandler", sb.toString());
        C0473bl.m2962a().mo3295a(System.currentTimeMillis(), str, "NativeException", 1);
    }

    public static void process(String str) {
        if (!(str == null || str.length() == 0 || !f3074a)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                try {
                    nativeProcess(str);
                } catch (Throwable unused) {
                    Log.w("NativeCrashHandler", "Invoke method nativeProcess failed.");
                }
            }
        }
    }

    public static void uninit() {
        if (f3074a) {
            try {
                nativeUnint();
            } catch (Throwable unused) {
                Log.w("NativeCrashHandler", "Invoke method nativeUnint failed.");
            }
        }
    }
}
