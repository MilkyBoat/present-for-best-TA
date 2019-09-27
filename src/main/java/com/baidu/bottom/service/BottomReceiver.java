package com.baidu.bottom.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobstat.C0454at;
import com.baidu.mobstat.C0465bd;
import com.baidu.mobstat.C0517db;
import com.baidu.mobstat.C0530n;

public class BottomReceiver extends BroadcastReceiver {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static C0517db f3047a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static long f3048b;

    /* renamed from: c */
    private static long f3049c;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2762a(Context context, Intent intent) {
        String action = intent.getAction();
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(f3049c - currentTimeMillis) <= 30000) {
            return;
        }
        if ("android.net.wifi.STATE_CHANGE".equals(action) || "android.net.wifi.WIFI_STATE_CHANGED".equals(action) || "android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.net.wifi.SCAN_RESULTS".equals(action)) {
            f3049c = currentTimeMillis;
            C0530n.m3208a(context);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2764b(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action)) {
            String str = null;
            Uri data = intent.getData();
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (!TextUtils.isEmpty(str)) {
                C0530n.m3209a(context, action, str);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (f3047a != null) {
            C0465bd.m2909a("Bottom has alread analyzed.");
            return;
        }
        C0517db dbVar = new C0517db();
        if (dbVar.mo3381a()) {
            f3047a = dbVar;
            new C0454at(this, context, intent, dbVar).start();
        }
    }
}
