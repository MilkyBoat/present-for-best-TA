package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.androlua.BuildConfig;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CooperService extends C0472bk implements ICooperService {

    /* renamed from: a */
    private static CooperService f3053a;

    /* renamed from: b */
    private C0482bu f3054b = new C0482bu();

    /* renamed from: a */
    static synchronized CooperService m2766a() {
        CooperService cooperService;
        synchronized (CooperService.class) {
            if (f3053a == null) {
                f3053a = new CooperService();
            }
            cooperService = f3053a;
        }
        return cooperService;
    }

    /* renamed from: a */
    private static String m2767a(Context context) {
        String j = C0518dc.m3152j(context);
        return !TextUtils.isEmpty(j) ? j.replaceAll(":", BuildConfig.FLAVOR) : j;
    }

    /* renamed from: a */
    private String m2768a(Context context, boolean z) {
        String b = z ? m2769b(context) : m2767a(context);
        return TextUtils.isEmpty(b) ? BuildConfig.FLAVOR : b;
    }

    /* renamed from: b */
    private static String m2769b(Context context) {
        String i = C0518dc.m3151i(context);
        return !TextUtils.isEmpty(i) ? i.replaceAll(":", BuildConfig.FLAVOR) : i;
    }

    /* renamed from: c */
    private static String m2770c(Context context) {
        String k = C0518dc.m3153k(context);
        return !TextUtils.isEmpty(k) ? k.replaceAll(":", BuildConfig.FLAVOR) : k;
    }

    /* renamed from: d */
    private String m2771d(Context context) {
        try {
            if (this.f3054b.f3211m == null || this.f3054b.f3211m.equals(BuildConfig.FLAVOR)) {
                boolean g = C0471bj.m2935a().mo3289g(context);
                if (g) {
                    this.f3054b.f3211m = C0471bj.m2935a().mo3287f(context);
                }
                if (!g || this.f3054b.f3211m == null || this.f3054b.f3211m.equals(BuildConfig.FLAVOR)) {
                    this.f3054b.f3211m = C0518dc.m3133a(context, Config.CHANNEL_META_NAME);
                }
            }
        } catch (Exception e) {
            C0514cz.m3112a((Throwable) e);
        }
        return this.f3054b.f3211m;
    }

    public boolean checkCellLocationSetting(Context context) {
        return "true".equalsIgnoreCase(C0518dc.m3133a(context, Config.GET_CELL_LOCATION));
    }

    public boolean checkGPSLocationSetting(Context context) {
        return "true".equals(C0518dc.m3133a(context, Config.GET_GPS_LOCATION));
    }

    public boolean checkWifiLocationSetting(Context context) {
        return "true".equalsIgnoreCase(C0518dc.m3133a(context, Config.GET_WIFI_LOCATION));
    }

    public void enableDeviceMac(Context context, boolean z) {
        C0471bj.m2935a().mo3284d(context, z);
    }

    public String getAppChannel(Context context) {
        return m2771d(context);
    }

    public String getAppKey(Context context) {
        if (this.f3054b.f3204f == null) {
            this.f3054b.f3204f = C0518dc.m3133a(context, Config.APPKEY_META_NAME);
        }
        return this.f3054b.f3204f;
    }

    public int getAppVersionCode(Context context) {
        if (this.f3054b.f3206h == -1) {
            this.f3054b.f3206h = C0518dc.m3143e(context);
        }
        return this.f3054b.f3206h;
    }

    public String getAppVersionName(Context context) {
        if (TextUtils.isEmpty(this.f3054b.f3207i)) {
            this.f3054b.f3207i = C0518dc.m3146f(context);
        }
        return this.f3054b.f3207i;
    }

    public /* bridge */ /* synthetic */ boolean getBoolean(Context context, String str, boolean z) {
        return super.getBoolean(context, str, z);
    }

    public String getCUID(Context context, boolean z) {
        if (this.f3054b.f3205g == null) {
            this.f3054b.f3205g = C0471bj.m2935a().mo3285e(context);
            if (this.f3054b.f3205g == null || BuildConfig.FLAVOR.equalsIgnoreCase(this.f3054b.f3205g)) {
                try {
                    this.f3054b.f3205g = C0520de.m3166a(context);
                    Matcher matcher = Pattern.compile("\\s*|\t|\r|\n").matcher(this.f3054b.f3205g);
                    this.f3054b.f3205g = matcher.replaceAll(BuildConfig.FLAVOR);
                    this.f3054b.f3205g = getSecretValue(this.f3054b.f3205g);
                    C0471bj.m2935a().mo3277b(context, this.f3054b.f3205g);
                } catch (Exception e) {
                    C0514cz.m3117c(e.getMessage());
                }
            }
        }
        if (z) {
            return this.f3054b.f3205g;
        }
        try {
            String str = this.f3054b.f3205g;
            if (!TextUtils.isEmpty(str)) {
                return new String(C0506cr.m3077b(1, C0508ct.m3094a(str.getBytes())));
            }
        } catch (Exception e2) {
            C0514cz.m3112a((Throwable) e2);
        }
        return null;
    }

    public String getDeviceId(TelephonyManager telephonyManager, Context context) {
        String str;
        C0482bu buVar;
        String secretValue;
        String str2 = this.f3054b.f3208j;
        if (TextUtils.isEmpty(str2)) {
            if (C0471bj.m2935a().mo3291i(context)) {
                buVar = this.f3054b;
                secretValue = getMacIdForTv(context);
            } else if (telephonyManager != null) {
                Pattern compile = Pattern.compile("\\s*|\t|\r|\n");
                try {
                    String deviceId = telephonyManager.getDeviceId();
                    if (deviceId != null) {
                        str2 = compile.matcher(deviceId).replaceAll(BuildConfig.FLAVOR);
                    }
                } catch (Exception e) {
                    C0514cz.m3112a((Throwable) e);
                }
                if (str2 == null || str2.equals(Config.NULL_DEVICE_ID)) {
                    str2 = m2767a(context);
                }
                if (C0518dc.m3161s(context) && (TextUtils.isEmpty(str2) || str2.equals(Config.NULL_DEVICE_ID))) {
                    try {
                        str = m2770c(context);
                    } catch (Exception e2) {
                        C0514cz.m3112a((Throwable) e2);
                    }
                    if (TextUtils.isEmpty(str) || str.equals(Config.NULL_DEVICE_ID)) {
                        str = C0471bj.m2935a().mo3282d(context);
                    }
                    if (TextUtils.isEmpty(str) || str.equals(Config.NULL_DEVICE_ID)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(new Date().getTime());
                        sb.append(BuildConfig.FLAVOR);
                        String sb2 = sb.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("hol");
                        sb3.append(sb2.hashCode());
                        sb3.append("mes");
                        str = sb3.toString();
                        C0471bj.m2935a().mo3273a(context, str);
                    }
                    this.f3054b.f3208j = str;
                    buVar = this.f3054b;
                    secretValue = getSecretValue(this.f3054b.f3208j);
                }
                str = str2;
                str = C0471bj.m2935a().mo3282d(context);
                StringBuilder sb4 = new StringBuilder();
                sb4.append(new Date().getTime());
                sb4.append(BuildConfig.FLAVOR);
                String sb22 = sb4.toString();
                StringBuilder sb32 = new StringBuilder();
                sb32.append("hol");
                sb32.append(sb22.hashCode());
                sb32.append("mes");
                str = sb32.toString();
                C0471bj.m2935a().mo3273a(context, str);
                this.f3054b.f3208j = str;
                buVar = this.f3054b;
                secretValue = getSecretValue(this.f3054b.f3208j);
            }
            buVar.f3208j = secretValue;
        }
        return this.f3054b.f3208j;
    }

    public /* bridge */ /* synthetic */ Float getFloatt(Context context, String str, int i) {
        return super.getFloatt(context, str, i);
    }

    public C0482bu getHeadObject() {
        return this.f3054b;
    }

    public JSONObject getHeaderExt(Context context) {
        String k = C0471bj.m2935a().mo3293k(context);
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(k)) {
            return jSONObject;
        }
        try {
            return new JSONObject(k);
        } catch (JSONException unused) {
            return jSONObject;
        }
    }

    public String getHost() {
        return Config.LOG_SEND_URL;
    }

    public /* bridge */ /* synthetic */ int getInt(Context context, String str, int i) {
        return super.getInt(context, str, i);
    }

    public String getLinkedWay(Context context) {
        if (TextUtils.isEmpty(this.f3054b.f3217s)) {
            this.f3054b.f3217s = C0518dc.m3157o(context);
        }
        return this.f3054b.f3217s;
    }

    public /* bridge */ /* synthetic */ long getLong(Context context, String str, long j) {
        return super.getLong(context, str, j);
    }

    public String getMTJSDKVersion() {
        return "3.7.5.5";
    }

    public String getMacAddress(Context context, boolean z) {
        String replace = Config.DEF_MAC_ID.replace(":", BuildConfig.FLAVOR);
        if (!z && VERSION.SDK_INT >= 23) {
            return getSecretValue(replace);
        }
        if (TextUtils.isEmpty(this.f3054b.f3218t)) {
            String h = C0471bj.m2935a().mo3290h(context);
            if (!TextUtils.isEmpty(h)) {
                this.f3054b.f3218t = h;
            } else {
                String a = m2768a(context, z);
                if (TextUtils.isEmpty(a) || replace.equals(a)) {
                    this.f3054b.f3218t = BuildConfig.FLAVOR;
                } else {
                    this.f3054b.f3218t = getSecretValue(a);
                    C0471bj.m2935a().mo3283d(context, this.f3054b.f3218t);
                }
            }
        }
        return this.f3054b.f3218t;
    }

    public String getMacIdForTv(Context context) {
        C0482bu buVar;
        if (TextUtils.isEmpty(this.f3054b.f3219u)) {
            String j = C0471bj.m2935a().mo3292j(context);
            if (!TextUtils.isEmpty(j)) {
                buVar = this.f3054b;
            } else {
                String c = C0518dc.m3139c(1, context);
                if (!TextUtils.isEmpty(c)) {
                    this.f3054b.f3219u = c;
                    C0471bj.m2935a().mo3286e(context, c);
                } else {
                    buVar = this.f3054b;
                    j = BuildConfig.FLAVOR;
                }
            }
            buVar.f3219u = j;
        }
        return this.f3054b.f3219u;
    }

    public String getManufacturer() {
        if (TextUtils.isEmpty(this.f3054b.f3214p)) {
            this.f3054b.f3214p = Build.MANUFACTURER;
        }
        return this.f3054b.f3214p;
    }

    public String getOSSysVersion() {
        if (TextUtils.isEmpty(this.f3054b.f3202d)) {
            this.f3054b.f3202d = VERSION.RELEASE;
        }
        return this.f3054b.f3202d;
    }

    public String getOSVersion() {
        if (TextUtils.isEmpty(this.f3054b.f3201c)) {
            this.f3054b.f3201c = Integer.toString(VERSION.SDK_INT);
        }
        return this.f3054b.f3201c;
    }

    public String getOperator(TelephonyManager telephonyManager) {
        if (TextUtils.isEmpty(this.f3054b.f3212n)) {
            this.f3054b.f3212n = telephonyManager.getNetworkOperator();
        }
        return this.f3054b.f3212n;
    }

    public String getPhoneModel() {
        if (TextUtils.isEmpty(this.f3054b.f3213o)) {
            this.f3054b.f3213o = Build.MODEL;
        }
        return this.f3054b.f3213o;
    }

    public String getSecretValue(String str) {
        return C0506cr.m3078c(1, str.getBytes());
    }

    public /* bridge */ /* synthetic */ boolean getSharedBoolean(Context context, String str, boolean z) {
        return super.getSharedBoolean(context, str, z);
    }

    public /* bridge */ /* synthetic */ int getSharedInt(Context context, String str, int i) {
        return super.getSharedInt(context, str, i);
    }

    public /* bridge */ /* synthetic */ long getSharedLong(Context context, String str, long j) {
        return super.getSharedLong(context, str, j);
    }

    public /* bridge */ /* synthetic */ String getSharedString(Context context, String str, String str2) {
        return super.getSharedString(context, str, str2);
    }

    public /* bridge */ /* synthetic */ String getString(Context context, String str, String str2) {
        return super.getString(context, str, str2);
    }

    public int getTagValue() {
        return 1;
    }

    public String getUUID() {
        return UUID.randomUUID().toString().replace("-", BuildConfig.FLAVOR);
    }

    public void installHeader(Context context, JSONObject jSONObject) {
        this.f3054b.mo3313a(context, jSONObject);
    }

    public boolean isDeviceMacEnabled(Context context) {
        return C0471bj.m2935a().mo3294l(context);
    }

    public /* bridge */ /* synthetic */ void putBoolean(Context context, String str, boolean z) {
        super.putBoolean(context, str, z);
    }

    public /* bridge */ /* synthetic */ void putFloat(Context context, String str, Float f) {
        super.putFloat(context, str, f);
    }

    public /* bridge */ /* synthetic */ void putInt(Context context, String str, int i) {
        super.putInt(context, str, i);
    }

    public /* bridge */ /* synthetic */ void putLong(Context context, String str, long j) {
        super.putLong(context, str, j);
    }

    public /* bridge */ /* synthetic */ void putSharedBoolean(Context context, String str, boolean z) {
        super.putSharedBoolean(context, str, z);
    }

    public /* bridge */ /* synthetic */ void putSharedInt(Context context, String str, int i) {
        super.putSharedInt(context, str, i);
    }

    public /* bridge */ /* synthetic */ void putSharedLong(Context context, String str, long j) {
        super.putSharedLong(context, str, j);
    }

    public /* bridge */ /* synthetic */ void putSharedString(Context context, String str, String str2) {
        super.putSharedString(context, str, str2);
    }

    public /* bridge */ /* synthetic */ void putString(Context context, String str, String str2) {
        super.putString(context, str, str2);
    }

    public /* bridge */ /* synthetic */ void removeShare(Context context, String str) {
        super.removeShare(context, str);
    }

    public /* bridge */ /* synthetic */ void removeString(Context context, String str) {
        super.removeString(context, str);
    }

    public void resetHeadSign() {
        this.f3054b.f3222x = m2766a().getUUID();
    }

    public void setHeadSqCounted(boolean z) {
        C0482bu buVar;
        int i;
        if (z) {
            buVar = this.f3054b;
            i = 0;
        } else {
            buVar = this.f3054b;
            i = buVar.f3224z + 1;
        }
        buVar.f3224z = i;
    }

    public void setHeaderExt(Context context, ExtraInfo extraInfo) {
        JSONObject jSONObject = new JSONObject();
        if (extraInfo != null) {
            jSONObject = extraInfo.dumpToJson();
        }
        this.f3054b.mo3314a(jSONObject);
        C0471bj.m2935a().mo3288f(context, jSONObject.toString());
    }

    public /* bridge */ /* synthetic */ boolean updateShareBoolean(Intent intent, Activity activity, String str) {
        return super.updateShareBoolean(intent, activity, str);
    }

    public /* bridge */ /* synthetic */ boolean updateShareBoolean(Intent intent, Activity activity, String str, boolean z) {
        return super.updateShareBoolean(intent, activity, str, z);
    }

    public /* bridge */ /* synthetic */ boolean updateShareInt(Intent intent, Activity activity, String str, int i) {
        return super.updateShareInt(intent, activity, str, i);
    }

    public /* bridge */ /* synthetic */ boolean updateShareString(Intent intent, Activity activity, String str) {
        return super.updateShareString(intent, activity, str);
    }
}
