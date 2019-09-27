package com.baidu.mobstat;

import android.util.Log;
import com.androlua.BuildConfig;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* renamed from: com.baidu.mobstat.bd */
public final class C0465bd {

    /* renamed from: a */
    public static int f3134a = 7;

    /* renamed from: a */
    private static String m2907a() {
        return "Bottom";
    }

    /* renamed from: a */
    private static void m2908a(int i, String str) {
        if (m2911a(i)) {
            Log.println(i, m2907a(), str);
        }
    }

    /* renamed from: a */
    public static void m2909a(String str) {
        m2908a(3, str);
    }

    /* renamed from: a */
    public static void m2910a(Throwable th) {
        m2908a(3, m2916d(th));
    }

    /* renamed from: a */
    private static boolean m2911a(int i) {
        return i >= f3134a;
    }

    /* renamed from: b */
    public static void m2912b(String str) {
        m2908a(5, str);
    }

    /* renamed from: b */
    public static void m2913b(Throwable th) {
        m2908a(5, m2916d(th));
    }

    /* renamed from: c */
    public static void m2914c(String str) {
        m2908a(6, str);
    }

    /* renamed from: c */
    public static void m2915c(Throwable th) {
        m2908a(6, m2916d(th));
    }

    /* renamed from: d */
    private static String m2916d(Throwable th) {
        if (th == null) {
            return BuildConfig.FLAVOR;
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return BuildConfig.FLAVOR;
            }
        }
        StringWriter stringWriter = new StringWriter();
        C0029a.m808a(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
