package com.baidu.mobstat;

import android.content.Context;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.ba */
public class C0462ba {

    /* renamed from: a */
    public static final C0462ba f3125a = new C0462ba();

    /* renamed from: a */
    private void m2893a(JSONObject jSONObject) {
        C0466be beVar = new C0466be(jSONObject);
        C0464bc.f3130b = beVar.f3135a;
        C0464bc.f3131c = beVar.f3136b;
        C0464bc.f3132d = beVar.f3137c;
    }

    /* renamed from: a */
    private boolean m2894a() {
        return !C0541y.AP_LIST.mo3410b() || !C0541y.f3369b.mo3410b() || !C0541y.APP_TRACE.mo3410b() || !C0541y.APP_CHANGE.mo3410b() || !C0541y.APP_APK.mo3410b();
    }

    /* renamed from: b */
    private void m2895b(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        int i = 0;
        try {
            jSONObject2.put(Config.HEADER_PART, jSONObject);
            i = 0 + jSONObject.toString().length();
        } catch (JSONException e) {
            C0465bd.m2910a((Throwable) e);
        }
        C0465bd.m2909a("APP_MEM");
        if (!C0460az.m2869a(context).mo3228b()) {
            String t = C0518dc.m3162t(context);
            JSONArray jSONArray = new JSONArray();
            C0465bd.m2909a(t);
            jSONArray.put(t);
            if (jSONArray.length() > 0) {
                try {
                    jSONObject2.put("app_mem3", jSONArray);
                    i += jSONArray.toString().length();
                } catch (JSONException e2) {
                    C0465bd.m2910a((Throwable) e2);
                }
            }
        }
        C0465bd.m2909a("APP_APK");
        List<String> a = C0541y.APP_APK.mo3409a(20480);
        JSONArray jSONArray2 = new JSONArray();
        for (String str : a) {
            C0465bd.m2909a(str);
            jSONArray2.put(str);
        }
        if (jSONArray2.length() > 0) {
            try {
                jSONObject2.put("app_apk3", jSONArray2);
                i += jSONArray2.toString().length();
            } catch (JSONException e3) {
                C0465bd.m2910a((Throwable) e3);
            }
        }
        C0465bd.m2909a("APP_CHANGE");
        List<String> a2 = C0541y.APP_CHANGE.mo3409a(10240);
        JSONArray jSONArray3 = new JSONArray();
        for (String str2 : a2) {
            C0465bd.m2909a(str2);
            jSONArray3.put(str2);
        }
        if (jSONArray3.length() > 0) {
            try {
                jSONObject2.put("app_change3", jSONArray3);
                i += jSONArray3.toString().length();
            } catch (JSONException e4) {
                C0465bd.m2910a((Throwable) e4);
            }
        }
        C0465bd.m2909a("APP_TRACE");
        List<String> a3 = C0541y.APP_TRACE.mo3409a(15360);
        JSONArray jSONArray4 = new JSONArray();
        for (String str3 : a3) {
            C0465bd.m2909a(str3);
            jSONArray4.put(str3);
        }
        if (jSONArray4.length() > 0) {
            try {
                jSONObject2.put("app_trace3", jSONArray4);
                i += jSONArray4.toString().length();
            } catch (JSONException e5) {
                C0465bd.m2910a((Throwable) e5);
            }
        }
        C0465bd.m2909a("APP_LIST");
        List<String> a4 = C0541y.f3369b.mo3409a(46080);
        JSONArray jSONArray5 = new JSONArray();
        for (String str4 : a4) {
            C0465bd.m2909a(str4);
            jSONArray5.put(str4);
        }
        if (jSONArray5.length() > 0) {
            try {
                jSONObject2.put("app_list3", jSONArray5);
                i += jSONArray5.toString().length();
            } catch (JSONException e6) {
                C0465bd.m2910a((Throwable) e6);
            }
        }
        C0465bd.m2909a("AP_LIST");
        List<String> a5 = C0541y.AP_LIST.mo3409a(184320 - i);
        JSONArray jSONArray6 = new JSONArray();
        for (String str5 : a5) {
            C0465bd.m2909a(str5);
            jSONArray6.put(str5);
        }
        if (jSONArray6.length() > 0) {
            try {
                jSONObject2.put("ap_list3", jSONArray6);
                i += jSONArray6.toString().length();
            } catch (JSONException e7) {
                C0465bd.m2910a((Throwable) e7);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("log in bytes is almost :");
        sb.append(i);
        C0465bd.m2909a(sb.toString());
        JSONArray jSONArray7 = new JSONArray();
        jSONArray7.put(jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("payload", jSONArray7);
            C0446al.m2824a().mo3208a(context, jSONObject3.toString());
        } catch (Exception e8) {
            C0465bd.m2910a((Throwable) e8);
        }
    }

    /* renamed from: c */
    private void m2896c(Context context) {
        C0465bd.m2909a("collectAPWithStretegy 1");
        C0460az a = C0460az.m2869a(context);
        long a2 = a.mo3222a(C0537u.AP_LIST);
        long currentTimeMillis = System.currentTimeMillis();
        long e = a.mo3232e();
        StringBuilder sb = new StringBuilder();
        sb.append("now time: ");
        sb.append(currentTimeMillis);
        sb.append(": last time: ");
        sb.append(a2);
        sb.append("; time interval: ");
        sb.append(e);
        C0465bd.m2909a(sb.toString());
        if (a2 == 0 || currentTimeMillis - a2 > e) {
            C0465bd.m2909a("collectAPWithStretegy 2");
            C0530n.m3208a(context);
        }
    }

    /* renamed from: d */
    private void m2897d(Context context) {
        C0465bd.m2909a("collectAPPListWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        C0460az a = C0460az.m2869a(context);
        long a2 = a.mo3222a(C0537u.APP_USER_LIST);
        long f = a.mo3233f();
        StringBuilder sb = new StringBuilder();
        sb.append("now time: ");
        sb.append(currentTimeMillis);
        sb.append(": last time: ");
        sb.append(a2);
        sb.append("; userInterval : ");
        sb.append(f);
        C0465bd.m2909a(sb.toString());
        if (a2 == 0 || currentTimeMillis - a2 > f || !a.mo3226a(a2)) {
            C0465bd.m2909a("collectUserAPPListWithStretegy 2");
            C0530n.m3210a(context, false);
        }
        long a3 = a.mo3222a(C0537u.APP_SYS_LIST);
        long g = a.mo3234g();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("now time: ");
        sb2.append(currentTimeMillis);
        sb2.append(": last time: ");
        sb2.append(a3);
        sb2.append("; sysInterval : ");
        sb2.append(g);
        C0465bd.m2909a(sb2.toString());
        if (a3 == 0 || currentTimeMillis - a3 > g) {
            C0465bd.m2909a("collectSysAPPListWithStretegy 2");
            C0530n.m3210a(context, true);
        }
    }

    /* renamed from: e */
    private void m2898e(Context context) {
        C0465bd.m2909a("collectAPPTraceWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        C0460az a = C0460az.m2869a(context);
        long a2 = a.mo3222a(C0537u.APP_TRACE_HIS);
        long i = a.mo3236i();
        StringBuilder sb = new StringBuilder();
        sb.append("now time: ");
        sb.append(currentTimeMillis);
        sb.append(": last time: ");
        sb.append(a2);
        sb.append("; time interval: ");
        sb.append(i);
        C0465bd.m2909a(sb.toString());
        if (a2 == 0 || currentTimeMillis - a2 > i) {
            C0465bd.m2909a("collectAPPTraceWithStretegy 2");
            C0530n.m3212b(context, false);
        }
    }

    /* renamed from: f */
    private void m2899f(Context context) {
        C0465bd.m2909a("collectAPKWithStretegy 1");
        long currentTimeMillis = System.currentTimeMillis();
        C0460az a = C0460az.m2869a(context);
        long a2 = a.mo3222a(C0537u.APP_APK);
        long h = a.mo3235h();
        StringBuilder sb = new StringBuilder();
        sb.append("now time: ");
        sb.append(currentTimeMillis);
        sb.append(": last time: ");
        sb.append(a2);
        sb.append("; interval : ");
        sb.append(h);
        C0465bd.m2909a(sb.toString());
        if (a2 == 0 || currentTimeMillis - a2 > h) {
            C0465bd.m2909a("collectAPKWithStretegy 2");
            C0530n.m3211b(context);
        }
    }

    /* renamed from: g */
    private void m2900g(Context context) {
        C0460az.m2869a(context).mo3223a(C0537u.LAST_SEND, System.currentTimeMillis());
        JSONObject a = C0538v.m3236a(context);
        StringBuilder sb = new StringBuilder();
        sb.append("header: ");
        sb.append(a);
        C0465bd.m2909a(sb.toString());
        while (m2894a()) {
            m2895b(context, a);
        }
    }

    /* renamed from: a */
    public void mo3240a(Context context, long j) {
        C0460az.m2869a(context).mo3223a(C0537u.LAST_UPDATE, j);
    }

    /* renamed from: a */
    public void mo3241a(Context context, String str) {
        C0460az.m2869a(context).mo3224a(str);
    }

    /* renamed from: a */
    public void mo3242a(Context context, JSONObject jSONObject) {
        C0465bd.m2909a("startDataAnynalyzed start");
        m2893a(jSONObject);
        C0460az a = C0460az.m2869a(context);
        boolean a2 = a.mo3225a();
        StringBuilder sb = new StringBuilder();
        sb.append("is data collect closed:");
        sb.append(a2);
        C0465bd.m2909a(sb.toString());
        if (!a2) {
            if (!C0541y.AP_LIST.mo3411b(10000)) {
                m2896c(context);
            }
            if (!C0541y.f3369b.mo3411b(10000)) {
                m2897d(context);
            }
            if (!C0541y.APP_TRACE.mo3411b(10000)) {
                m2898e(context);
            }
            if (C0464bc.f3133e && !C0541y.APP_APK.mo3411b(10000)) {
                m2899f(context);
            }
            boolean n = C0518dc.m3156n(context);
            if (!n || !a.mo3239l()) {
                C0465bd.m2909a(!n ? "isWifiAvailable = false, will not sendLog" : "can not sendLog due to time stratergy");
            } else {
                C0465bd.m2909a("sendLog");
                m2900g(context);
            }
        }
        C0465bd.m2909a("startDataAnynalyzed finished");
    }

    /* renamed from: a */
    public boolean mo3243a(Context context) {
        C0460az a = C0460az.m2869a(context);
        long a2 = a.mo3222a(C0537u.LAST_UPDATE);
        long c = a.mo3229c();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a2 > c) {
            StringBuilder sb = new StringBuilder();
            sb.append("need to update, checkWithLastUpdateTime lastUpdateTime =");
            sb.append(a2);
            sb.append("nowTime=");
            sb.append(currentTimeMillis);
            sb.append(";timeInteveral=");
            sb.append(c);
            C0465bd.m2909a(sb.toString());
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("no need to update, checkWithLastUpdateTime lastUpdateTime =");
        sb2.append(a2);
        sb2.append("nowTime=");
        sb2.append(currentTimeMillis);
        sb2.append(";timeInteveral=");
        sb2.append(c);
        C0465bd.m2909a(sb2.toString());
        return false;
    }

    /* renamed from: b */
    public void mo3244b(Context context, String str) {
        C0460az.m2869a(context).mo3227b(str);
    }

    /* renamed from: b */
    public boolean mo3245b(Context context) {
        return !C0460az.m2869a(context).mo3225a() || mo3243a(context);
    }
}
