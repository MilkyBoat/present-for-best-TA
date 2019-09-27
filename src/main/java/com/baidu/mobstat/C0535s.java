package com.baidu.mobstat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.androlua.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.s */
class C0535s {

    /* renamed from: a */
    static C0535s f3348a = new C0535s();

    /* renamed from: b */
    private String f3349b = BuildConfig.FLAVOR;

    C0535s() {
    }

    /* renamed from: a */
    private String m3224a(Context context, String str) {
        String str2;
        String str3 = BuildConfig.FLAVOR;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return str3;
        }
        try {
            str2 = packageManager.getPackageInfo(str, 0).versionName;
        } catch (NameNotFoundException e) {
            C0465bd.m2913b((Throwable) e);
            str2 = str3;
        }
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        return str2;
    }

    /* renamed from: a */
    private ArrayList<C0536t> m3225a(Context context, int i) {
        return VERSION.SDK_INT >= 21 ? m3232c(context, i) : m3230b(context, i);
    }

    /* renamed from: a */
    private void m3226a(Context context, ArrayList<C0536t> arrayList, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        sb2.append("|");
        sb.append(sb2.toString());
        sb.append(z ? 1 : 0);
        String str2 = BuildConfig.FLAVOR;
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject a = ((C0536t) it.next()).mo3395a();
                if (a != null) {
                    jSONArray.put(a);
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_trace", jSONArray);
            jSONObject.put("meta-data", sb.toString());
            str = C0505cq.m3071a(jSONObject.toString().getBytes());
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            C0541y.APP_TRACE.mo3407a(System.currentTimeMillis(), str);
        }
    }

    /* renamed from: a */
    private void m3227a(Context context, boolean z, int i) {
        ArrayList a = m3225a(context, i);
        if (a != null && a.size() != 0) {
            if (z) {
                String b = ((C0536t) a.get(0)).mo3396b();
                if (m3229a(b, this.f3349b)) {
                    this.f3349b = b;
                }
            }
            m3226a(context, a, z);
        }
    }

    /* renamed from: a */
    private boolean m3228a(int i) {
        return i == 100 || i == 200 || i == 130;
    }

    /* renamed from: a */
    private boolean m3229a(String str, String str2) {
        return !TextUtils.isEmpty(str) && !str.equals(this.f3349b);
    }

    /* renamed from: b */
    private ArrayList<C0536t> m3230b(Context context, int i) {
        List<RunningTaskInfo> list;
        try {
            list = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(50);
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            list = null;
        }
        if (list == null) {
            return new ArrayList<>();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (RunningTaskInfo runningTaskInfo : list) {
            if (linkedHashMap.size() > i) {
                break;
            }
            ComponentName componentName = runningTaskInfo.topActivity;
            if (componentName != null) {
                String packageName = componentName.getPackageName();
                if (!TextUtils.isEmpty(packageName) && !m3231b(context, packageName) && !linkedHashMap.containsKey(packageName)) {
                    linkedHashMap.put(packageName, new C0536t(packageName, m3224a(context, packageName), BuildConfig.FLAVOR));
                }
            }
        }
        return new ArrayList<>(linkedHashMap.values());
    }

    /* renamed from: b */
    private boolean m3231b(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(str, 0).applicationInfo;
            if (!(applicationInfo == null || (applicationInfo.flags & 1) == 0)) {
                return true;
            }
        } catch (NameNotFoundException e) {
            C0465bd.m2913b((Throwable) e);
        }
        return false;
    }

    /* renamed from: c */
    private ArrayList<C0536t> m3232c(Context context, int i) {
        List runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return new ArrayList<>();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < runningAppProcesses.size() && linkedHashMap.size() <= i; i2++) {
            RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) runningAppProcesses.get(i2);
            if (m3228a(runningAppProcessInfo.importance)) {
                String[] strArr = runningAppProcessInfo.pkgList;
                if (!(strArr == null || strArr.length == 0)) {
                    String str = runningAppProcessInfo.pkgList[0];
                    if (!TextUtils.isEmpty(str) && !m3231b(context, str) && !linkedHashMap.containsKey(str)) {
                        linkedHashMap.put(str, new C0536t(str, m3224a(context, str), String.valueOf(runningAppProcessInfo.importance)));
                    }
                }
            }
        }
        return new ArrayList<>(linkedHashMap.values());
    }

    /* renamed from: a */
    public synchronized void mo3394a(Context context, boolean z) {
        int i = 1;
        if (!z) {
            i = 20;
        }
        m3227a(context, z, i);
    }
}
