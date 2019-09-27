package com.baidu.mobstat;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* renamed from: com.baidu.mobstat.bg */
class C0468bg implements ActivityLifecycleCallbacks {

    /* renamed from: a */
    final /* synthetic */ C0467bf f3142a;

    C0468bg(C0467bf bfVar) {
        this.f3142a = bfVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        C0496ch.m3039a().mo3368b(activity.getApplicationContext(), System.currentTimeMillis());
        if (this.f3142a.f3140c) {
            this.f3142a.m2925a(activity, false);
        }
    }

    public void onActivityResumed(Activity activity) {
        C0496ch.m3039a().mo3358a(activity.getApplicationContext(), System.currentTimeMillis());
        if (this.f3142a.f3140c) {
            this.f3142a.m2925a(activity, true);
            this.f3142a.m2921a(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
