package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.p000a.p001a.C0001a;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.androlua.BuildConfig;

public class StatService {
    public static final int EXCEPTION_LOG = 1;
    public static final int JAVA_EXCEPTION_LOG = 16;

    /* renamed from: a */
    private static boolean f3077a;

    /* renamed from: b */
    private static long f3078b;

    public interface WearListener {
        boolean onSendLogData(String str);
    }

    /* renamed from: a */
    private static String m2781a(boolean z) {
        Class cls;
        String str = BuildConfig.FLAVOR;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement className : stackTrace) {
            String className2 = className.getClassName();
            if (!TextUtils.isEmpty(className2)) {
                try {
                    cls = Class.forName(className2);
                } catch (Throwable unused) {
                    cls = null;
                }
                if (cls != null && Activity.class.isAssignableFrom(cls)) {
                    return z ? cls.getName() : cls.getSimpleName();
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    private static void m2782a(Context context) {
        C0467bf.m2919a().mo3247a(context);
    }

    /* renamed from: a */
    private static synchronized void m2783a(Context context, ExtraInfo extraInfo) {
        synchronized (StatService.class) {
            if (m2789a(context, "onPause(...)")) {
                if (!m2790a(Activity.class, "onPause")) {
                    throw new SecurityException("onPause(Context context)不在Activity.onPause()中被调用||onPause(Context context)is not called in Activity.onPause().");
                }
                C0496ch.m3039a().mo3362a(context, System.currentTimeMillis(), false, extraInfo);
            }
        }
    }

    /* renamed from: a */
    private static synchronized void m2784a(Context context, String str, ExtraInfo extraInfo) {
        synchronized (StatService.class) {
            if (!(context == null || str == null)) {
                if (!str.equals(BuildConfig.FLAVOR)) {
                    String a = m2781a(false);
                    StringBuilder sb = new StringBuilder();
                    sb.append("pageName is:");
                    sb.append(str);
                    sb.append("; activityName is:");
                    sb.append(a);
                    C0514cz.m3110a(sb.toString());
                    C0496ch.m3039a().mo3360a(context, System.currentTimeMillis(), a, str, extraInfo);
                    return;
                }
            }
            C0514cz.m3117c("onPageEnd :parame=null || empty");
        }
    }

    /* renamed from: a */
    private static void m2785a(Context context, String str, String str2, int i, ExtraInfo extraInfo) {
        if (m2789a(context, "onEvent(...)") && str != null && !str.equals(BuildConfig.FLAVOR)) {
            m2782a(context);
            C0483bv.m2981a().mo3316a(context);
            C0474bm.m2965a().mo3301a(context.getApplicationContext(), str, str2, i, System.currentTimeMillis(), extraInfo);
        }
    }

    /* renamed from: a */
    private static void m2786a(Context context, String str, String str2, long j, ExtraInfo extraInfo) {
        if (!m2789a(context, "onEventDuration(...)") || str == null || str.equals(BuildConfig.FLAVOR)) {
            return;
        }
        if (j <= 0) {
            C0514cz.m3114b("onEventDuration: duration must be greater than zero");
            return;
        }
        m2782a(context);
        C0483bv.m2981a().mo3316a(context);
        C0474bm.m2965a().mo3305b(context.getApplicationContext(), str, str2, j, extraInfo);
    }

    /* renamed from: a */
    private static void m2787a(Context context, String str, String str2, ExtraInfo extraInfo) {
        m2785a(context, str, str2, 1, extraInfo);
    }

    /* renamed from: a */
    private static void m2788a(Context context, boolean z) {
        if (m2789a(context, "onError(...)")) {
            C0481bt.m2974a().mo3311a(context.getApplicationContext(), z);
        }
    }

    /* renamed from: a */
    private static boolean m2789a(Context context, String str) {
        if (context != null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(":context=null");
        C0514cz.m3114b(sb.toString());
        return false;
    }

    /* renamed from: a */
    private static boolean m2790a(Class<?> cls, String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z = false;
        for (int i = 2; i < stackTrace.length; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.getMethodName().equals(str)) {
                try {
                    Class cls2 = Class.forName(stackTraceElement.getClassName());
                    while (cls2.getSuperclass() != null && cls2.getSuperclass() != cls) {
                        cls2 = cls2.getSuperclass();
                    }
                    z = true;
                } catch (Exception e) {
                    C0514cz.m3112a((Throwable) e);
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    private static void m2791b(Context context, String str, String str2, ExtraInfo extraInfo) {
        if (m2789a(context, "onEventEnd(...)") && str != null && !str.equals(BuildConfig.FLAVOR)) {
            C0474bm.m2965a().mo3304a(context.getApplicationContext(), str, str2, System.currentTimeMillis(), extraInfo);
        }
    }

    public static void bindJSInterface(Context context, WebView webView) {
        bindJSInterface(context, webView, null);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static void bindJSInterface(Context context, WebView webView, WebViewClient webViewClient) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null.");
        } else if (webView == null) {
            throw new IllegalArgumentException("webview can't be null.");
        } else {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            webView.setWebViewClient(new C0470bi(context, webViewClient));
            m2782a(context);
        }
    }

    public static void enableDeviceMac(Context context, boolean z) {
        CooperService.m2766a().enableDeviceMac(context, z);
        m2782a(context);
    }

    public static String getAppKey(Context context) {
        return PrefOperate.getAppKey(context);
    }

    public static String getSdkVersion() {
        return CooperService.m2766a().getMTJSDKVersion();
    }

    public static void onErised(Context context, String str, String str2, String str3) {
        Context context2 = context;
        String str4 = str;
        if (C0483bv.m2981a().mo3319b() || !m2789a(context2, "onErised(...)")) {
            return;
        }
        if (str4 == null || BuildConfig.FLAVOR.equals(str4)) {
            C0514cz.m3117c("AppKey is invalid");
            return;
        }
        C0483bv.m2981a().mo3317a(context2, false);
        long currentTimeMillis = System.currentTimeMillis();
        C0474bm.m2965a().mo3299a(context2, str2, str3, 1, currentTimeMillis, 0, null);
        DataCore.instance().saveLogDataToSend(context2);
        if (currentTimeMillis - f3078b > 30000 && C0518dc.m3156n(context2)) {
            C0486by.m2993a().mo3325a(context2);
            f3078b = currentTimeMillis;
        }
    }

    public static void onEvent(Context context, String str, String str2) {
        m2787a(context, str, str2, null);
    }

    public static void onEvent(Context context, String str, String str2, int i) {
        m2785a(context, str, str2, i, (ExtraInfo) null);
    }

    public static void onEventDuration(Context context, String str, String str2, long j) {
        m2786a(context, str, str2, j, (ExtraInfo) null);
    }

    public static void onEventEnd(Context context, String str, String str2) {
        m2791b(context, str, str2, null);
    }

    public static void onEventStart(Context context, String str, String str2) {
        if (m2789a(context, "onEventStart(...)") && str != null && !str.equals(BuildConfig.FLAVOR)) {
            m2782a(context);
            C0483bv.m2981a().mo3316a(context);
            C0474bm.m2965a().mo3303a(context.getApplicationContext(), str, str2, System.currentTimeMillis());
        }
    }

    public static synchronized void onPageEnd(Context context, String str) {
        synchronized (StatService.class) {
            m2784a(context, str, null);
        }
    }

    public static synchronized void onPageStart(Context context, String str) {
        synchronized (StatService.class) {
            if (!(context == null || str == null)) {
                if (!str.equals(BuildConfig.FLAVOR)) {
                    m2782a(context);
                    C0483bv.m2981a().mo3316a(context);
                    C0496ch.m3039a().mo3359a(context, System.currentTimeMillis(), str);
                    return;
                }
            }
            C0514cz.m3117c("onPageStart :parame=null || empty");
        }
    }

    @TargetApi(11)
    @Deprecated
    public static synchronized void onPause(Fragment fragment) {
        synchronized (StatService.class) {
            if (fragment == null) {
                C0514cz.m3117c("android.app.Fragment onResume :parame=null");
            } else if (!m2790a(fragment.getClass(), "onPause")) {
                throw new SecurityException("android.app.Fragment onPause(Context context)不在android.app.Fragment.onPause()中被调用||onPause(Context context)is not called in android.app.Fragment.onPause().");
            } else {
                C0496ch.m3039a().mo3367b(fragment, System.currentTimeMillis());
            }
        }
    }

    public static synchronized void onPause(Context context) {
        synchronized (StatService.class) {
            m2783a(context, (ExtraInfo) null);
        }
    }

    @Deprecated
    public static synchronized void onPause(C0001a aVar) {
        synchronized (StatService.class) {
            if (aVar == null) {
                C0514cz.m3117c("onResume :parame=null");
            } else if (!m2790a(C0001a.class, "onPause")) {
                throw new SecurityException("Fragment onPause(Context context)不在Fragment.onPause()中被调用||onPause(Context context)is not called in Fragment.onPause().");
            } else {
                C0496ch.m3039a().mo3369b(aVar, System.currentTimeMillis());
            }
        }
    }

    @TargetApi(11)
    @Deprecated
    public static synchronized void onResume(Fragment fragment) {
        synchronized (StatService.class) {
            if (fragment == null) {
                C0514cz.m3117c("onResume :parame=null");
            } else if (!m2790a(fragment.getClass(), "onResume")) {
                throw new SecurityException("onResume(Context context)不在Fragment.onResume()中被调用||onResume(Context context)is not called in Fragment.onResume().");
            } else {
                Context a = C0496ch.m3037a((Object) fragment);
                if (a == null) {
                    C0514cz.m3117c("can not get correct context, fragment may not attached to activity");
                    return;
                }
                m2782a(a);
                C0483bv.m2981a().mo3316a(a);
                C0496ch.m3039a().mo3356a(fragment, System.currentTimeMillis());
            }
        }
    }

    public static synchronized void onResume(Context context) {
        synchronized (StatService.class) {
            if (m2789a(context, "onResume(...)")) {
                if (!m2790a(Activity.class, "onResume")) {
                    throw new SecurityException("onResume(Context context)不在Activity.onResume()中被调用||onResume(Context context)is not called in Activity.onResume().");
                }
                m2782a(context);
                C0483bv.m2981a().mo3316a(context);
                C0496ch.m3039a().mo3361a(context, System.currentTimeMillis(), false);
            }
        }
    }

    @Deprecated
    public static synchronized void onResume(C0001a aVar) {
        synchronized (StatService.class) {
            if (aVar == null) {
                C0514cz.m3117c("onResume :parame=null");
            } else if (!m2790a(C0001a.class, "onResume")) {
                throw new SecurityException("onResume(Context context)不在Fragment.onResume()中被调用||onResume(Context context)is not called in Fragment.onResume().");
            } else {
                FragmentActivity activity = aVar.getActivity();
                if (activity == null) {
                    C0514cz.m3117c("can not get correct fragmentActivity, fragment may not attached to activity");
                    return;
                }
                m2782a((Context) activity);
                C0483bv.m2981a().mo3316a((Context) activity);
                C0496ch.m3039a().mo3363a(aVar, System.currentTimeMillis());
            }
        }
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        PrefOperate.setAppChannel(context, str, z);
        m2782a(context);
    }

    @Deprecated
    public static void setAppChannel(String str) {
        PrefOperate.setAppChannel(str);
    }

    public static void setAppKey(String str) {
        PrefOperate.setAppKey(str);
    }

    public static void setDebugOn(boolean z) {
        C0514cz.f3321a = z ? 2 : 7;
    }

    public static void setForTv(Context context, boolean z) {
        C0471bj.m2935a().mo3280c(context, z);
        m2782a(context);
    }

    public static void setLogSenderDelayed(int i) {
        C0486by.m2993a().mo3324a(i);
    }

    public static void setOn(Context context, int i) {
        if (m2789a(context, "setOn(...)") && !f3077a) {
            f3077a = true;
            if ((i & 1) != 0) {
                m2788a(context, false);
            } else if ((i & 16) != 0) {
                m2788a(context, true);
            }
            m2782a(context);
        }
    }

    @Deprecated
    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i) {
        setSendLogStrategy(context, sendStrategyEnum, i, false);
    }

    @Deprecated
    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i, boolean z) {
        if (m2789a(context, "setSendLogStrategy(...)")) {
            m2782a(context);
            C0483bv.m2981a().mo3316a(context);
            C0486by.m2993a().mo3326a(context.getApplicationContext(), sendStrategyEnum, i, z);
        }
    }

    public static void setSessionTimeOut(int i) {
        if (i <= 0) {
            C0514cz.m3114b("SessionTimeOut is between 1 and 600. Default value[30] is used");
        } else if (i <= 600) {
            C0496ch.m3039a().mo3354a(i);
        } else {
            C0514cz.m3114b("SessionTimeOut is between 1 and 600. Value[600] is used");
            C0496ch.m3039a().mo3354a(600);
        }
    }

    public static void start(Context context) {
        if (m2789a(context, "start(...)")) {
            m2782a(context);
            C0483bv.m2981a().mo3316a(context);
        }
    }
}
