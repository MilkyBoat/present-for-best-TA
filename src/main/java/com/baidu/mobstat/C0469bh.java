package com.baidu.mobstat;

import android.app.Activity;
import android.view.View;
import android.view.View.AccessibilityDelegate;

/* renamed from: com.baidu.mobstat.bh */
class C0469bh extends AccessibilityDelegate {

    /* renamed from: a */
    final /* synthetic */ C0467bf f3143a;

    /* renamed from: b */
    private AccessibilityDelegate f3144b;

    /* renamed from: c */
    private Activity f3145c;

    /* renamed from: d */
    private View f3146d;

    /* renamed from: e */
    private String f3147e;

    public C0469bh(C0467bf bfVar, Activity activity, View view, String str, AccessibilityDelegate accessibilityDelegate) {
        this.f3143a = bfVar;
        this.f3144b = accessibilityDelegate;
        this.f3145c = activity;
        this.f3146d = view;
        this.f3147e = str;
    }

    public void sendAccessibilityEvent(View view, int i) {
        if (view == this.f3146d && i == 1) {
            this.f3143a.m2931b(this.f3145c, this.f3146d, this.f3147e);
        }
        if (this.f3144b != null && !(this.f3144b instanceof C0469bh)) {
            this.f3144b.sendAccessibilityEvent(view, i);
        }
    }
}
