package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.v */
public class C0538v {
    /* renamed from: a */
    public static JSONObject m3236a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", VERSION.SDK_INT);
            jSONObject.put(Config.OS_SYSVERSION, VERSION.RELEASE);
            jSONObject.put(Config.CUID_SEC, C0518dc.m3130a(2, context));
            jSONObject.put(Config.DEVICE_WIDTH, C0518dc.m3134b(context));
            jSONObject.put("h", C0518dc.m3138c(context));
            jSONObject.put("ly", C0464bc.f3131c);
            jSONObject.put("pv", "13");
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                jSONObject.put(Config.PACKAGE_NAME, C0518dc.m3149h(2, context));
                jSONObject.put(Config.APP_VERSION_CODE, packageInfo.versionCode);
                jSONObject.put("n", packageInfo.versionName);
            } catch (Exception e) {
                C0465bd.m2910a((Throwable) e);
            }
            jSONObject.put(Config.DEVICE_MAC_ID, C0518dc.m3136b(2, context));
            jSONObject.put(Config.DEVICE_BLUETOOTH_MAC, C0518dc.m3145f(2, context));
            jSONObject.put(Config.MODEL, Build.MODEL);
            jSONObject.put(Config.DEVICE_NAME, C0518dc.m3132a(context, 2));
            return jSONObject;
        } catch (JSONException e2) {
            C0465bd.m2913b((Throwable) e2);
            return jSONObject;
        }
    }
}
