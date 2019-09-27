package com.baidu.mobstat;

import android.util.Log;
import com.androlua.BuildConfig;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* renamed from: com.baidu.mobstat.cz */
public final class C0514cz {

    /* renamed from: a */
    public static int f3321a = 7;

    /* renamed from: a */
    private static String m3108a() {
        return "sdkstat";
    }

    /* renamed from: a */
    private static void m3109a(int i, String str) {
        if (m3113a(i)) {
            Log.println(i, m3108a(), str);
        }
    }

    /* renamed from: a */
    public static void m3110a(String str) {
        m3109a(3, str);
    }

    /* renamed from: a */
    public static void m3111a(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(10);
        sb.append(m3119d(th));
        m3109a(3, sb.toString());
    }

    /* renamed from: a */
    public static void m3112a(Throwable th) {
        m3109a(3, m3119d(th));
    }

    /* renamed from: a */
    private static boolean m3113a(int i) {
        return i >= f3321a;
    }

    /* renamed from: b */
    public static void m3114b(String str) {
        m3109a(5, str);
    }

    /* renamed from: b */
    public static void m3115b(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(10);
        sb.append(m3119d(th));
        m3109a(5, sb.toString());
    }

    /* renamed from: b */
    public static void m3116b(Throwable th) {
        m3109a(5, m3119d(th));
    }

    /* renamed from: c */
    public static void m3117c(String str) {
        m3109a(6, str);
    }

    /* renamed from: c */
    public static void m3118c(Throwable th) {
        m3109a(6, m3119d(th));
    }

    /* renamed from: d */
    private static String m3119d(Throwable th) {
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
