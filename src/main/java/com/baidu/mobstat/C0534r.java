package com.baidu.mobstat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.androlua.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.r */
class C0534r {

    /* renamed from: a */
    static final C0534r f3347a = new C0534r();

    C0534r() {
    }

    /* renamed from: a */
    private long m3220a(String str) {
        if (str != null) {
            File file = new File(str);
            if (file != null && file.exists()) {
                return file.lastModified();
            }
        }
        return 0;
    }

    /* renamed from: a */
    private void m3221a(boolean z, String str, String str2, PackageInfo packageInfo, JSONArray jSONArray) {
        long j;
        if (!z || !packageInfo.packageName.startsWith("com.android.")) {
            long j2 = 0;
            try {
                j = packageInfo.firstInstallTime;
            } catch (Throwable th) {
                C0465bd.m2913b(th);
                j = 0;
            }
            try {
                j2 = packageInfo.lastUpdateTime;
            } catch (Throwable th2) {
                C0465bd.m2913b(th2);
            }
            long a = m3220a(str2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", packageInfo.packageName);
                jSONObject.put(Config.APP_VERSION_CODE, str);
                jSONObject.put("v", String.valueOf(packageInfo.versionName));
                jSONObject.put("f", j);
                jSONObject.put("l", j2);
                jSONObject.put(Config.MODEL, a);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                C0465bd.m2913b((Throwable) e);
            }
        }
    }

    /* renamed from: b */
    private void m3222b(Context context, boolean z) {
        String str;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            List<PackageInfo> arrayList = new ArrayList<>(1);
            try {
                arrayList = packageManager.getInstalledPackages(0);
            } catch (Exception e) {
                C0465bd.m2913b((Throwable) e);
            }
            JSONArray jSONArray = new JSONArray();
            for (PackageInfo packageInfo : arrayList) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo != null) {
                    boolean z2 = (applicationInfo.flags & 1) != 0;
                    String charSequence = applicationInfo.loadLabel(packageManager).toString();
                    String str2 = applicationInfo.sourceDir;
                    if (z == z2) {
                        m3221a(z, charSequence, str2, packageInfo, jSONArray);
                    }
                }
            }
            if (jSONArray.length() != 0) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(System.currentTimeMillis());
                sb2.append("|");
                sb.append(sb2.toString());
                sb.append(z ? 1 : 0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_list", jSONArray);
                    jSONObject.put("meta-data", sb.toString());
                    str = C0505cq.m3071a(jSONObject.toString().getBytes());
                } catch (Exception unused) {
                    str = BuildConfig.FLAVOR;
                }
                if (!TextUtils.isEmpty(str)) {
                    C0541y.f3369b.mo3407a(System.currentTimeMillis(), str);
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo3393a(Context context, boolean z) {
        m3222b(context, z);
    }
}
