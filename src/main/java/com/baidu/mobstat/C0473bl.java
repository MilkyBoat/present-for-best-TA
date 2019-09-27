package com.baidu.mobstat;

import android.content.Context;
import com.androlua.BuildConfig;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.bl */
class C0473bl implements UncaughtExceptionHandler {

    /* renamed from: a */
    private static final C0473bl f3153a = new C0473bl();

    /* renamed from: b */
    private UncaughtExceptionHandler f3154b = null;

    /* renamed from: c */
    private Context f3155c = null;

    /* renamed from: d */
    private C0482bu f3156d = new C0482bu();

    private C0473bl() {
    }

    /* renamed from: a */
    public static C0473bl m2962a() {
        return f3153a;
    }

    /* renamed from: a */
    public void mo3295a(long j, String str, String str2, int i) {
        C0496ch.m3039a().mo3368b(this.f3155c, System.currentTimeMillis());
        if (this.f3155c != null && str != null && !str.trim().equals(BuildConfig.FLAVOR)) {
            try {
                String appVersionName = CooperService.m2766a().getAppVersionName(this.f3155c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("t", j);
                jSONObject.put("c", str);
                jSONObject.put(Config.EXCEPTION_TYPE, str2);
                jSONObject.put("v", appVersionName);
                jSONObject.put(Config.EXCEPTION_CRASH_TYPE, i);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                this.f3156d.mo3313a(this.f3155c, jSONObject2);
                jSONObject2.put(Config.SESSION_STARTTIME, 0);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(Config.HEADER_PART, jSONObject2);
                jSONObject3.put(Config.PRINCIPAL_PART, new JSONArray());
                jSONObject3.put(Config.EVENT_PART, new JSONArray());
                jSONObject3.put(Config.EXCEPTION_PART, jSONArray);
                StringBuilder sb = new StringBuilder();
                sb.append(Config.PREFIX_SEND_DATA);
                sb.append(System.currentTimeMillis());
                C0507cs.m3084a(this.f3155c, sb.toString(), jSONObject3.toString(), false);
                C0514cz.m3110a("Dump exception successlly");
            } catch (Exception e) {
                C0514cz.m3116b((Throwable) e);
            }
        }
    }

    /* renamed from: a */
    public void mo3296a(Context context) {
        if (this.f3154b == null) {
            this.f3154b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
        if (this.f3155c == null) {
            this.f3155c = context.getApplicationContext();
        }
        this.f3156d.mo3312a(this.f3155c);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String th2 = th.toString();
        String str = BuildConfig.FLAVOR;
        if (th2 != null && !th2.equals(BuildConfig.FLAVOR)) {
            try {
                str = th2.length() > 1 ? th2.split(":")[0] : th2;
            } catch (Exception e) {
                C0514cz.m3118c((Throwable) e);
                str = BuildConfig.FLAVOR;
            }
        }
        String str2 = (str == null || str.equals(BuildConfig.FLAVOR)) ? th2 : str;
        StringWriter stringWriter = new StringWriter();
        C0029a.m808a(th, new PrintWriter(stringWriter));
        String obj = stringWriter.toString();
        C0514cz.m3110a(obj);
        mo3295a(System.currentTimeMillis(), obj, str2, 0);
        if (!this.f3154b.equals(this)) {
            this.f3154b.uncaughtException(thread, th);
        }
    }
}
