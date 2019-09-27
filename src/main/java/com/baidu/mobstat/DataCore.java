package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.androlua.BuildConfig;
import com.baidu.mobstat.StatService.WearListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataCore {

    /* renamed from: a */
    private static JSONObject f3055a = new JSONObject();

    /* renamed from: b */
    private static DataCore f3056b = new DataCore();

    /* renamed from: c */
    private JSONArray f3057c = new JSONArray();

    /* renamed from: d */
    private JSONArray f3058d = new JSONArray();

    /* renamed from: e */
    private JSONArray f3059e = new JSONArray();

    /* renamed from: f */
    private boolean f3060f = false;

    /* renamed from: g */
    private volatile int f3061g = 0;

    /* renamed from: h */
    private WearListener f3062h;

    private DataCore() {
    }

    /* renamed from: a */
    private void m2772a(Context context) {
        clearCache(context);
        CooperService.m2766a().setHeadSqCounted(true);
        C0496ch.m3039a().mo3372d();
    }

    /* renamed from: a */
    private void m2773a(Context context, String str) {
        if (this.f3062h == null || !this.f3062h.onSendLogData(str)) {
            C0486by.m2993a().mo3327a(context, str);
        } else {
            C0514cz.m3110a("log data has been passed to app level");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r3.equals(com.androlua.BuildConfig.FLAVOR) != false) goto L_0x0019;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2774a(org.json.JSONObject r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, long r27, java.lang.String r29, java.lang.String r30, int r31, boolean r32) {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            r3 = r26
            org.json.JSONArray r4 = r1.f3058d
            monitor-enter(r4)
            org.json.JSONArray r5 = r1.f3058d     // Catch:{ all -> 0x0138 }
            int r5 = r5.length()     // Catch:{ all -> 0x0138 }
            if (r3 == 0) goto L_0x0019
            java.lang.String r6 = ""
            boolean r3 = r3.equals(r6)     // Catch:{ JSONException -> 0x0021 }
            if (r3 == 0) goto L_0x0026
        L_0x0019:
            java.lang.String r3 = "s"
            java.lang.String r6 = "0|"
            r2.put(r3, r6)     // Catch:{ JSONException -> 0x0021 }
            goto L_0x0026
        L_0x0021:
            java.lang.String r3 = "event put s fail"
            com.baidu.mobstat.C0514cz.m3110a(r3)     // Catch:{ all -> 0x0138 }
        L_0x0026:
            r7 = r5
            r6 = 0
        L_0x0028:
            if (r6 >= r5) goto L_0x0123
            org.json.JSONArray r8 = r1.f3058d     // Catch:{ JSONException -> 0x010e }
            org.json.JSONObject r8 = r8.getJSONObject(r6)     // Catch:{ JSONException -> 0x010e }
            java.lang.String r9 = "i"
            java.lang.String r9 = r8.getString(r9)     // Catch:{ JSONException -> 0x010e }
            java.lang.String r10 = "l"
            java.lang.String r10 = r8.getString(r10)     // Catch:{ JSONException -> 0x010e }
            java.lang.String r11 = "t"
            long r11 = r8.getLong(r11)     // Catch:{ JSONException -> 0x010e }
            r13 = 3600000(0x36ee80, double:1.7786363E-317)
            long r11 = r11 / r13
            java.lang.String r13 = "d"
            int r13 = r8.getInt(r13)     // Catch:{ JSONException -> 0x004d }
            goto L_0x0053
        L_0x004d:
            java.lang.String r13 = "old version data, No duration Tag"
            com.baidu.mobstat.C0514cz.m3110a(r13)     // Catch:{ JSONException -> 0x010e }
            r13 = 0
        L_0x0053:
            java.lang.String r14 = "h"
            java.lang.String r14 = r8.optString(r14)     // Catch:{ JSONException -> 0x010e }
            java.lang.String r15 = "p"
            java.lang.String r15 = r8.optString(r15)     // Catch:{ JSONException -> 0x010e }
            java.lang.String r3 = "v"
            int r3 = r8.optInt(r3)     // Catch:{ JSONException -> 0x010e }
            r16 = r7
            java.lang.String r7 = "at"
            boolean r7 = r8.optBoolean(r7)     // Catch:{ JSONException -> 0x0104 }
            int r17 = (r11 > r27 ? 1 : (r11 == r27 ? 0 : -1))
            if (r17 != 0) goto L_0x0101
            if (r13 == 0) goto L_0x0075
            goto L_0x0101
        L_0x0075:
            r11 = r24
            boolean r9 = r9.equals(r11)     // Catch:{ JSONException -> 0x00ff }
            if (r9 == 0) goto L_0x00f8
            r9 = r25
            boolean r10 = r10.equals(r9)     // Catch:{ JSONException -> 0x00ff }
            if (r10 == 0) goto L_0x00f8
            r10 = r29
            boolean r12 = r14.equals(r10)     // Catch:{ JSONException -> 0x00ff }
            if (r12 == 0) goto L_0x00f8
            r12 = r30
            boolean r13 = r15.equals(r12)     // Catch:{ JSONException -> 0x00f6 }
            if (r13 == 0) goto L_0x00fa
            r13 = r31
            if (r3 != r13) goto L_0x00fc
            r3 = r32
            if (r7 != r3) goto L_0x011d
            java.lang.String r7 = "c"
            int r7 = r2.getInt(r7)     // Catch:{ JSONException -> 0x00f4 }
            java.lang.String r14 = "c"
            int r14 = r8.getInt(r14)     // Catch:{ JSONException -> 0x00f4 }
            int r7 = r7 + r14
            java.lang.String r14 = "s"
            java.lang.String r14 = r8.optString(r14)     // Catch:{ JSONException -> 0x00f4 }
            if (r14 == 0) goto L_0x00ba
            java.lang.String r15 = ""
            boolean r15 = r14.equalsIgnoreCase(r15)     // Catch:{ JSONException -> 0x00f4 }
            if (r15 == 0) goto L_0x00bc
        L_0x00ba:
            java.lang.String r14 = "0|"
        L_0x00bc:
            java.lang.String r15 = "t"
            long r17 = r2.getLong(r15)     // Catch:{ JSONException -> 0x00f4 }
            java.lang.String r15 = "t"
            long r19 = r8.getLong(r15)     // Catch:{ JSONException -> 0x00f4 }
            r15 = 0
            long r9 = r17 - r19
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00f4 }
            r15.<init>()     // Catch:{ JSONException -> 0x00f4 }
            r15.append(r14)     // Catch:{ JSONException -> 0x00f4 }
            r15.append(r9)     // Catch:{ JSONException -> 0x00f4 }
            java.lang.String r9 = "|"
            r15.append(r9)     // Catch:{ JSONException -> 0x00f4 }
            java.lang.String r9 = r15.toString()     // Catch:{ JSONException -> 0x00f4 }
            java.lang.String r10 = "c"
            r8.remove(r10)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r10 = "c"
            r8.put(r10, r7)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r7 = "s"
            r8.put(r7, r9)     // Catch:{ JSONException -> 0x00ef }
            goto L_0x0127
        L_0x00ef:
            r0 = move-exception
            r7 = r0
            r16 = r6
            goto L_0x011a
        L_0x00f4:
            r0 = move-exception
            goto L_0x0119
        L_0x00f6:
            r0 = move-exception
            goto L_0x0109
        L_0x00f8:
            r12 = r30
        L_0x00fa:
            r13 = r31
        L_0x00fc:
            r3 = r32
            goto L_0x011d
        L_0x00ff:
            r0 = move-exception
            goto L_0x0107
        L_0x0101:
            r11 = r24
            goto L_0x00f8
        L_0x0104:
            r0 = move-exception
            r11 = r24
        L_0x0107:
            r12 = r30
        L_0x0109:
            r13 = r31
            r3 = r32
            goto L_0x0119
        L_0x010e:
            r0 = move-exception
            r11 = r24
            r12 = r30
            r13 = r31
            r3 = r32
            r16 = r7
        L_0x0119:
            r7 = r0
        L_0x011a:
            com.baidu.mobstat.C0514cz.m3112a(r7)     // Catch:{ all -> 0x0138 }
        L_0x011d:
            r7 = r16
            int r6 = r6 + 1
            goto L_0x0028
        L_0x0123:
            r16 = r7
            r6 = r16
        L_0x0127:
            if (r6 >= r5) goto L_0x012b
            monitor-exit(r4)     // Catch:{ all -> 0x0138 }
            return
        L_0x012b:
            org.json.JSONArray r3 = r1.f3058d     // Catch:{ JSONException -> 0x0131 }
            r3.put(r5, r2)     // Catch:{ JSONException -> 0x0131 }
            goto L_0x0136
        L_0x0131:
            r0 = move-exception
            r2 = r0
            com.baidu.mobstat.C0514cz.m3112a(r2)     // Catch:{ all -> 0x0138 }
        L_0x0136:
            monitor-exit(r4)     // Catch:{ all -> 0x0138 }
            return
        L_0x0138:
            r0 = move-exception
            r2 = r0
            monitor-exit(r4)     // Catch:{ all -> 0x0138 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.DataCore.m2774a(org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, java.lang.String, int, boolean):void");
    }

    /* renamed from: a */
    private void m2775a(boolean z) {
        this.f3060f = z;
    }

    /* renamed from: a */
    private boolean m2776a() {
        return this.f3060f;
    }

    /* renamed from: a */
    private boolean m2777a(String str) {
        return (str.getBytes().length + C0496ch.m3039a().mo3364b()) + this.f3061g > 204800;
    }

    /* renamed from: b */
    private void m2778b(Context context) {
        synchronized (this.f3058d) {
            this.f3058d = new JSONArray();
        }
        synchronized (this.f3057c) {
            this.f3057c = new JSONArray();
        }
        synchronized (this.f3059e) {
            this.f3059e = new JSONArray();
        }
        flush(context);
    }

    public static DataCore instance() {
        return f3056b;
    }

    public void clearCache(Context context) {
        m2775a(false);
        synchronized (f3055a) {
            f3055a = new JSONObject();
        }
        installHeader(context);
        m2778b(context);
    }

    public String constructLogWithEmptyBody(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        C0482bu headObject = CooperService.m2766a().getHeadObject();
        if (TextUtils.isEmpty(headObject.f3204f)) {
            headObject.mo3313a(context, jSONObject2);
        } else {
            headObject.mo3315b(context, jSONObject2);
        }
        JSONArray jSONArray = new JSONArray();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject2.put("t", currentTimeMillis);
            jSONObject2.put(Config.SESSION_STARTTIME, currentTimeMillis);
            jSONObject2.put(Config.WIFI_LOCATION, jSONArray);
            jSONObject2.put(Config.SEQUENCE_INDEX, 0);
            jSONObject2.put(Config.SIGN, CooperService.m2766a().getUUID());
            jSONObject2.put(Config.APP_KEY, str);
            jSONObject.put(Config.HEADER_PART, jSONObject2);
            try {
                jSONObject.put(Config.PRINCIPAL_PART, jSONArray);
                try {
                    jSONObject.put(Config.EVENT_PART, jSONArray);
                    try {
                        jSONObject.put(Config.EXCEPTION_PART, jSONArray);
                        return jSONObject.toString();
                    } catch (JSONException e) {
                        C0514cz.m3112a((Throwable) e);
                        return null;
                    }
                } catch (JSONException e2) {
                    C0514cz.m3112a((Throwable) e2);
                    return null;
                }
            } catch (JSONException e3) {
                C0514cz.m3112a((Throwable) e3);
                return null;
            }
        } catch (Exception e4) {
            C0514cz.m3112a((Throwable) e4);
            return null;
        }
    }

    public synchronized void flush(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            synchronized (this.f3057c) {
                jSONObject.put(Config.PRINCIPAL_PART, new JSONArray(this.f3057c.toString()));
            }
            synchronized (this.f3058d) {
                jSONObject.put(Config.EVENT_PART, new JSONArray(this.f3058d.toString()));
            }
            synchronized (f3055a) {
                jSONObject.put(Config.HEADER_PART, new JSONObject(f3055a.toString()));
            }
        } catch (Exception unused) {
            C0514cz.m3110a("flushLogWithoutHeader() construct cache error");
        }
        String jSONObject2 = jSONObject.toString();
        if (m2776a()) {
            C0514cz.m3110a("cache.json exceed 204800B,stop flush.");
            return;
        }
        int length = jSONObject2.getBytes().length;
        if (length >= 204800) {
            m2775a(true);
            return;
        }
        this.f3061g = length;
        StringBuilder sb = new StringBuilder();
        sb.append("flush:cacheFileSize is:");
        sb.append(this.f3061g);
        sb.append(", capacity is:");
        sb.append(Config.MAX_CACHE_JSON_CAPACITY);
        C0514cz.m3110a(sb.toString());
        String q = C0518dc.m3159q(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(q);
        sb2.append(Config.STAT_CACHE_FILE_NAME);
        C0507cs.m3084a(context, sb2.toString(), jSONObject2, false);
        synchronized (this.f3059e) {
            String jSONArray = this.f3059e.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("flush wifi data: ");
            sb3.append(jSONArray);
            C0514cz.m3110a(sb3.toString());
            C0507cs.m3084a(context, Config.LAST_AP_INFO_FILE_NAME, jSONArray, false);
        }
    }

    public int getCacheFileSzie() {
        return this.f3061g;
    }

    public void installHeader(Context context) {
        synchronized (f3055a) {
            CooperService.m2766a().getHeadObject().mo3313a(context, f3055a);
        }
    }

    public boolean isPartEmpty() {
        boolean z;
        synchronized (this.f3057c) {
            z = this.f3057c.length() == 0;
        }
        return z;
    }

    public void loadLastSession(Context context) {
        if (context != null) {
            String q = C0518dc.m3159q(context);
            StringBuilder sb = new StringBuilder();
            sb.append(q);
            sb.append(Config.LAST_SESSION_FILE_NAME);
            String sb2 = sb.toString();
            if (C0507cs.m3089c(context, sb2)) {
                String a = C0507cs.m3082a(context, sb2);
                if (TextUtils.isEmpty(a)) {
                    C0514cz.m3110a("loadLastSession(): last_session.json file not found.");
                    return;
                }
                C0507cs.m3084a(context, sb2, new JSONObject().toString(), false);
                putSession(a);
                flush(context);
            }
        }
    }

    public void loadStatData(Context context) {
        if (context != null) {
            String q = C0518dc.m3159q(context);
            StringBuilder sb = new StringBuilder();
            sb.append(q);
            sb.append(Config.STAT_CACHE_FILE_NAME);
            String sb2 = sb.toString();
            if (C0507cs.m3089c(context, sb2)) {
                String a = C0507cs.m3082a(context, sb2);
                if (a.equals(BuildConfig.FLAVOR)) {
                    C0514cz.m3110a("stat_cache file not found.");
                    return;
                }
                C0514cz.m3110a("loadStatData, ");
                try {
                    this.f3061g = a.getBytes().length;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("load Stat Data:cacheFileSize is:");
                    sb3.append(this.f3061g);
                    C0514cz.m3110a(sb3.toString());
                    JSONObject jSONObject = new JSONObject(a);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Load cache:");
                    sb4.append(a);
                    C0514cz.m3110a(sb4.toString());
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONArray jSONArray = jSONObject.getJSONArray(Config.PRINCIPAL_PART);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (currentTimeMillis - jSONObject2.getLong("s") <= Config.MAX_LOG_DATA_EXSIT_TIME) {
                            putSession(jSONObject2);
                        }
                    }
                    JSONArray jSONArray2 = jSONObject.getJSONArray(Config.EVENT_PART);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                        if (currentTimeMillis - jSONObject3.getLong("t") <= Config.MAX_LOG_DATA_EXSIT_TIME) {
                            putEvent(context, jSONObject3, true);
                        }
                    }
                    if (!isPartEmpty()) {
                        try {
                            JSONObject jSONObject4 = jSONObject.getJSONObject(Config.HEADER_PART);
                            synchronized (f3055a) {
                                f3055a = jSONObject4;
                            }
                        } catch (JSONException e) {
                            C0514cz.m3112a((Throwable) e);
                        }
                    }
                } catch (JSONException e2) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Load stat data error:");
                    sb5.append(e2);
                    C0514cz.m3110a(sb5.toString());
                }
            }
        }
    }

    public void loadWifiData(Context context) {
        if (context != null && C0507cs.m3089c(context, Config.LAST_AP_INFO_FILE_NAME)) {
            try {
                JSONArray jSONArray = new JSONArray(C0507cs.m3082a(context, Config.LAST_AP_INFO_FILE_NAME));
                int length = jSONArray.length();
                if (length >= 10) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = length - 10; i < length; i++) {
                        jSONArray2.put(jSONArray.get(i));
                    }
                    jSONArray = jSONArray2;
                }
                String g = C0518dc.m3147g(1, context);
                if (!TextUtils.isEmpty(g)) {
                    jSONArray.put(g);
                }
                synchronized (this.f3059e) {
                    this.f3059e = jSONArray;
                    StringBuilder sb = new StringBuilder();
                    sb.append("wifiPart: ");
                    sb.append(this.f3059e.toString());
                    C0514cz.m3110a(sb.toString());
                }
            } catch (JSONException e) {
                C0514cz.m3116b((Throwable) e);
            }
        }
    }

    public void putEvent(Context context, String str, String str2, int i, long j, long j2, String str3, String str4, int i2, boolean z, ExtraInfo extraInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("i", str);
            jSONObject.put("l", str2);
            jSONObject.put("c", i);
            jSONObject.put("t", j);
            jSONObject.put("d", j2);
            jSONObject.put("h", str3);
            jSONObject.put("p", str4);
            jSONObject.put("v", i2);
            jSONObject.put("at", z ? 1 : 0);
            if (!(extraInfo == null || extraInfo.dumpToJson().length() == 0)) {
                jSONObject.put("ext", extraInfo.dumpToJson());
            }
            putEvent(context, jSONObject, false);
            StringBuilder sb = new StringBuilder();
            sb.append("put event:");
            sb.append(jSONObject.toString());
            C0514cz.m3110a(sb.toString());
        } catch (JSONException e) {
            C0514cz.m3112a((Throwable) e);
        }
    }

    public void putEvent(Context context, JSONObject jSONObject, boolean z) {
        int i;
        if (jSONObject != null) {
            if (m2777a(jSONObject.toString())) {
                C0514cz.m3114b("data to put exceed limit, will not put");
                return;
            }
            try {
                String string = jSONObject.getString("i");
                String string2 = jSONObject.getString("l");
                long j = jSONObject.getLong("t") / 3600000;
                String optString = jSONObject.optString("s");
                String optString2 = jSONObject.optString("h");
                String optString3 = jSONObject.optString("p");
                int optInt = jSONObject.optInt("v");
                boolean optBoolean = jSONObject.optBoolean("at");
                String optString4 = jSONObject.optString("ext");
                boolean z2 = false;
                try {
                    i = jSONObject.getInt("d");
                } catch (JSONException unused) {
                    C0514cz.m3110a("old version data, No duration Tag");
                    i = 0;
                }
                if (!TextUtils.isEmpty(optString4) && !new JSONObject().toString().equals(optString4)) {
                    z2 = true;
                }
                if (i != 0 || z2) {
                    synchronized (this.f3058d) {
                        int length = this.f3058d.length();
                        try {
                            jSONObject.put("s", "0");
                            this.f3058d.put(length, jSONObject);
                        } catch (JSONException e) {
                            C0514cz.m3112a((Throwable) e);
                        }
                    }
                    return;
                }
                m2774a(jSONObject, string, string2, optString, j, optString2, optString3, optInt, optBoolean);
            } catch (JSONException e2) {
                C0514cz.m3112a((Throwable) e2);
            }
        }
    }

    public void putSession(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(new JSONObject().toString())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                putSession(jSONObject);
                StringBuilder sb = new StringBuilder();
                sb.append("Load last session:");
                sb.append(jSONObject);
                C0514cz.m3110a(sb.toString());
            } catch (JSONException e) {
                C0514cz.m3112a((Throwable) e);
            }
        }
    }

    public void putSession(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (m2777a(jSONObject.toString())) {
                C0514cz.m3114b("data to put exceed limit, will not put");
                return;
            }
            synchronized (this.f3057c) {
                try {
                    this.f3057c.put(this.f3057c.length(), jSONObject);
                } catch (JSONException e) {
                    C0514cz.m3112a((Throwable) e);
                }
            }
        }
    }

    public void saveLogDataToSend(Context context) {
        C0514cz.m3110a("sendLogData() begin.");
        C0482bu headObject = CooperService.m2766a().getHeadObject();
        if (headObject != null && TextUtils.isEmpty(headObject.f3204f)) {
            synchronized (f3055a) {
                headObject.mo3313a(context, f3055a);
                StringBuilder sb = new StringBuilder();
                sb.append("constructHeader() begin.");
                sb.append(f3055a);
                sb.append(f3055a.length());
                C0514cz.m3110a(sb.toString());
            }
            if (TextUtils.isEmpty(headObject.f3204f)) {
                C0514cz.m3117c("不能在manifest.xml中找到APP Key||can't find app key in manifest.xml.");
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        synchronized (f3055a) {
            try {
                f3055a.put("t", System.currentTimeMillis());
                f3055a.put(Config.SESSION_STARTTIME, C0496ch.m3039a().mo3375g());
                synchronized (this.f3059e) {
                    f3055a.put(Config.WIFI_LOCATION, this.f3059e);
                }
                f3055a.put(Config.SIGN, CooperService.m2766a().getUUID());
                jSONObject.put(Config.HEADER_PART, f3055a);
                synchronized (this.f3057c) {
                    try {
                        jSONObject.put(Config.PRINCIPAL_PART, this.f3057c);
                        try {
                            synchronized (this.f3058d) {
                                try {
                                    jSONObject.put(Config.EVENT_PART, this.f3058d);
                                    try {
                                        jSONObject.put(Config.EXCEPTION_PART, new JSONArray());
                                        String jSONObject2 = jSONObject.toString();
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("---Send Data Is:");
                                        sb2.append(jSONObject2);
                                        C0514cz.m3110a(sb2.toString());
                                        m2773a(context, jSONObject2);
                                        m2772a(context);
                                    } catch (JSONException e) {
                                        C0514cz.m3112a((Throwable) e);
                                        return;
                                    }
                                } catch (JSONException e2) {
                                    C0514cz.m3112a((Throwable) e2);
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            while (true) {
                            }
                            throw th;
                        }
                    } catch (JSONException e3) {
                        C0514cz.m3112a((Throwable) e3);
                        return;
                    }
                }
            } catch (Exception e4) {
                C0514cz.m3112a((Throwable) e4);
                return;
            }
        }
        return;
    }
}
