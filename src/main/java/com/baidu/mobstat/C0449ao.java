package com.baidu.mobstat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import java.util.List;

/* renamed from: com.baidu.mobstat.ao */
public enum C0449ao {
    SERVICE(1),
    NO_SERVICE(2),
    RECEIVER(3),
    ERISED(4);
    

    /* renamed from: e */
    private int f3093e;

    private C0449ao(int i) {
        this.f3093e = i;
    }

    /* renamed from: a */
    public static C0449ao m2834a(int i) {
        C0449ao[] values;
        for (C0449ao aoVar : values()) {
            if (aoVar.f3093e == i) {
                return aoVar;
            }
        }
        return NO_SERVICE;
    }

    /* renamed from: b */
    public static boolean m2835b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            try {
                List runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
                int i = 0;
                while (runningServices != null && i < runningServices.size()) {
                    if ("com.baidu.bottom.service.BottomService".equals(((RunningServiceInfo) runningServices.get(i)).service.getClassName())) {
                        return true;
                    }
                    i++;
                }
            } catch (Exception e) {
                C0514cz.m3112a((Throwable) e);
            }
        }
        return false;
    }

    /* renamed from: a */
    public abstract void mo3212a(Context context);

    public String toString() {
        return String.valueOf(this.f3093e);
    }
}
