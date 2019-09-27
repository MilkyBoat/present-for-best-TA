package com.baidu.mobstat;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.androlua.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.bu */
class C0482bu {

    /* renamed from: a */
    static String f3199a = "Android";

    /* renamed from: b */
    boolean f3200b = false;

    /* renamed from: c */
    String f3201c;

    /* renamed from: d */
    String f3202d;

    /* renamed from: e */
    String f3203e = "0";

    /* renamed from: f */
    String f3204f = null;

    /* renamed from: g */
    String f3205g = null;

    /* renamed from: h */
    int f3206h = -1;

    /* renamed from: i */
    String f3207i;

    /* renamed from: j */
    String f3208j;

    /* renamed from: k */
    int f3209k;

    /* renamed from: l */
    int f3210l;

    /* renamed from: m */
    String f3211m = null;

    /* renamed from: n */
    String f3212n;

    /* renamed from: o */
    String f3213o;

    /* renamed from: p */
    String f3214p;

    /* renamed from: q */
    String f3215q;

    /* renamed from: r */
    String f3216r;

    /* renamed from: s */
    String f3217s;

    /* renamed from: t */
    String f3218t;

    /* renamed from: u */
    String f3219u;

    /* renamed from: v */
    String f3220v;

    /* renamed from: w */
    String f3221w;

    /* renamed from: x */
    String f3222x;

    /* renamed from: y */
    JSONObject f3223y;

    /* renamed from: z */
    int f3224z = 0;

    C0482bu() {
    }

    /* renamed from: a */
    public synchronized void mo3312a(Context context) {
        if (!this.f3200b) {
            C0507cs.m3092e(context, "android.permission.READ_PHONE_STATE");
            C0507cs.m3092e(context, "android.permission.INTERNET");
            C0507cs.m3092e(context, "android.permission.ACCESS_NETWORK_STATE");
            C0507cs.m3092e(context, "android.permission.WRITE_SETTINGS");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            this.f3201c = CooperService.m2766a().getOSVersion();
            this.f3202d = CooperService.m2766a().getOSSysVersion();
            this.f3213o = CooperService.m2766a().getPhoneModel();
            this.f3214p = CooperService.m2766a().getManufacturer();
            this.f3222x = CooperService.m2766a().getUUID();
            this.f3223y = CooperService.m2766a().getHeaderExt(context);
            this.f3208j = CooperService.m2766a().getDeviceId(telephonyManager, context);
            this.f3203e = C0471bj.m2935a().mo3291i(context) ? "1" : "0";
            if (C0518dc.m3161s(context)) {
                this.f3203e = "2";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3203e);
            sb.append("-0");
            this.f3203e = sb.toString();
            try {
                this.f3218t = CooperService.m2766a().getMacAddress(context, CooperService.m2766a().isDeviceMacEnabled(context));
            } catch (Exception e) {
                C0514cz.m3112a((Throwable) e);
            }
            try {
                this.f3220v = C0518dc.m3145f(1, context);
            } catch (Exception e2) {
                C0514cz.m3112a((Throwable) e2);
            }
            try {
                this.f3221w = C0518dc.m3132a(context, 1);
            } catch (Exception e3) {
                C0514cz.m3112a((Throwable) e3);
            }
            this.f3205g = CooperService.m2766a().getCUID(context, true);
            try {
                this.f3212n = CooperService.m2766a().getOperator(telephonyManager);
            } catch (Exception e4) {
                C0514cz.m3112a((Throwable) e4);
            }
            try {
                this.f3209k = C0518dc.m3134b(context);
                this.f3210l = C0518dc.m3138c(context);
                if (context.getResources().getConfiguration().orientation == 2) {
                    this.f3209k ^= this.f3210l;
                    this.f3210l = this.f3209k ^ this.f3210l;
                    this.f3209k ^= this.f3210l;
                }
            } catch (Exception e5) {
                C0514cz.m3112a((Throwable) e5);
            }
            this.f3211m = CooperService.m2766a().getAppChannel(context);
            this.f3204f = CooperService.m2766a().getAppKey(context);
            try {
                this.f3206h = CooperService.m2766a().getAppVersionCode(context);
                this.f3207i = CooperService.m2766a().getAppVersionName(context);
            } catch (Exception e6) {
                C0514cz.m3112a((Throwable) e6);
            }
            try {
                this.f3215q = CooperService.m2766a().checkCellLocationSetting(context) ? C0518dc.m3148g(context) : "0_0_0";
            } catch (Exception e7) {
                C0514cz.m3112a((Throwable) e7);
            }
            try {
                this.f3216r = CooperService.m2766a().checkGPSLocationSetting(context) ? C0518dc.m3150h(context) : BuildConfig.FLAVOR;
            } catch (Exception e8) {
                C0514cz.m3112a((Throwable) e8);
            }
            try {
                this.f3217s = CooperService.m2766a().getLinkedWay(context);
            } catch (Exception e9) {
                C0514cz.m3112a((Throwable) e9);
            }
            this.f3200b = true;
            return;
        }
        return;
    }

    /* renamed from: a */
    public synchronized void mo3313a(Context context, JSONObject jSONObject) {
        mo3312a(context);
        if (jSONObject.length() > 10) {
            StringBuilder sb = new StringBuilder();
            sb.append("header has been installed; header is:");
            sb.append(jSONObject);
            C0514cz.m3110a(sb.toString());
            return;
        }
        mo3315b(context, jSONObject);
    }

    /* renamed from: a */
    public void mo3314a(JSONObject jSONObject) {
        this.f3223y = jSONObject;
    }

    /* renamed from: b */
    public synchronized void mo3315b(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(Config.f3050OS, f3199a == null ? BuildConfig.FLAVOR : f3199a);
            jSONObject.put(Config.STAT_SDK_TYPE, 0);
            jSONObject.put("s", this.f3201c == null ? BuildConfig.FLAVOR : this.f3201c);
            jSONObject.put(Config.OS_SYSVERSION, this.f3202d == null ? BuildConfig.FLAVOR : this.f3202d);
            jSONObject.put(Config.APP_KEY, this.f3204f == null ? BuildConfig.FLAVOR : this.f3204f);
            jSONObject.put(Config.PLATFORM_TYPE, this.f3203e == null ? "0" : this.f3203e);
            jSONObject.put("i", BuildConfig.FLAVOR);
            jSONObject.put("v", "3.7.5.5");
            jSONObject.put(Config.STAT_SDK_CHANNEL, 0);
            jSONObject.put(Config.APP_VERSION_CODE, this.f3206h);
            jSONObject.put("n", this.f3207i == null ? BuildConfig.FLAVOR : this.f3207i);
            jSONObject.put("d", BuildConfig.FLAVOR);
            jSONObject.put(Config.DEVICE_MAC_ID, this.f3218t == null ? BuildConfig.FLAVOR : this.f3218t);
            jSONObject.put(Config.DEVICE_BLUETOOTH_MAC, this.f3220v == null ? BuildConfig.FLAVOR : this.f3220v);
            jSONObject.put(Config.DEVICE_ID_SEC, this.f3208j == null ? BuildConfig.FLAVOR : this.f3208j);
            jSONObject.put(Config.CUID_SEC, this.f3205g == null ? BuildConfig.FLAVOR : this.f3205g);
            jSONObject.put(Config.SDK_TAG, 1);
            jSONObject.put(Config.DEVICE_WIDTH, this.f3209k);
            jSONObject.put("h", this.f3210l);
            jSONObject.put(Config.DEVICE_NAME, this.f3221w == null ? BuildConfig.FLAVOR : this.f3221w);
            jSONObject.put("c", this.f3211m == null ? BuildConfig.FLAVOR : this.f3211m);
            jSONObject.put(Config.OPERATOR, this.f3212n == null ? BuildConfig.FLAVOR : this.f3212n);
            jSONObject.put(Config.MODEL, this.f3213o == null ? BuildConfig.FLAVOR : this.f3213o);
            jSONObject.put(Config.MANUFACTURER, this.f3214p == null ? BuildConfig.FLAVOR : this.f3214p);
            jSONObject.put(Config.CELL_LOCATION, this.f3215q);
            jSONObject.put(Config.GPS_LOCATION, this.f3216r == null ? BuildConfig.FLAVOR : this.f3216r);
            jSONObject.put("l", this.f3217s == null ? BuildConfig.FLAVOR : this.f3217s);
            jSONObject.put("t", System.currentTimeMillis());
            jSONObject.put(Config.SEQUENCE_INDEX, this.f3224z);
            jSONObject.put(Config.PACKAGE_NAME, C0518dc.m3149h(1, context));
            String q = C0518dc.m3159q(context);
            jSONObject.put(Config.PROCESS_LABEL, q);
            String str = null;
            if (!TextUtils.isEmpty(q)) {
                str = C0518dc.m3160r(context);
            }
            String str2 = Config.PROCESS_CLASS;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            jSONObject.put(str2, str);
            jSONObject.put(Config.SIGN, this.f3222x == null ? BuildConfig.FLAVOR : this.f3222x);
            if (!(this.f3223y == null || this.f3223y.length() == 0)) {
                jSONObject.put("ext", this.f3223y);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("header is: ");
            sb.append(jSONObject.toString());
            sb.append("; len: ");
            sb.append(jSONObject.length());
            C0514cz.m3110a(sb.toString());
        } catch (JSONException unused) {
            C0514cz.m3110a("header ini error");
        }
        return;
    }
}
