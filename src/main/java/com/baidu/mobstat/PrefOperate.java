package com.baidu.mobstat;

import android.content.Context;
import com.androlua.BuildConfig;

public class PrefOperate {
    public static String getAppKey(Context context) {
        return CooperService.m2766a().getAppKey(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x009b A[Catch:{ Exception -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c7 A[Catch:{ Exception -> 0x00e8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void loadMetaDataConfig(android.content.Context r6) {
        /*
            com.baidu.mobstat.SendStrategyEnum r0 = com.baidu.mobstat.SendStrategyEnum.APP_START
            r1 = 0
            java.lang.String r2 = "BaiduMobAd_EXCEPTION_LOG"
            java.lang.String r2 = com.baidu.mobstat.C0518dc.m3133a(r6, r2)     // Catch:{ Exception -> 0x001f }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x001f }
            if (r3 != 0) goto L_0x0023
            java.lang.String r3 = "true"
            boolean r2 = r3.equals(r2)     // Catch:{ Exception -> 0x001f }
            if (r2 == 0) goto L_0x0023
            com.baidu.mobstat.bt r2 = com.baidu.mobstat.C0481bt.m2974a()     // Catch:{ Exception -> 0x001f }
            r2.mo3311a(r6, r1)     // Catch:{ Exception -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r2 = move-exception
            com.baidu.mobstat.C0514cz.m3112a(r2)
        L_0x0023:
            r2 = 24
            java.lang.String r3 = "BaiduMobAd_SEND_STRATEGY"
            java.lang.String r3 = com.baidu.mobstat.C0518dc.m3133a(r6, r3)     // Catch:{ Exception -> 0x008b }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x008b }
            if (r4 != 0) goto L_0x0088
            com.baidu.mobstat.SendStrategyEnum r4 = com.baidu.mobstat.SendStrategyEnum.APP_START     // Catch:{ Exception -> 0x008b }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x008b }
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x008b }
            if (r4 == 0) goto L_0x0050
            com.baidu.mobstat.SendStrategyEnum r3 = com.baidu.mobstat.SendStrategyEnum.APP_START     // Catch:{ Exception -> 0x008b }
            com.baidu.mobstat.bj r0 = com.baidu.mobstat.C0471bj.m2935a()     // Catch:{ Exception -> 0x004b }
            int r4 = r3.ordinal()     // Catch:{ Exception -> 0x004b }
        L_0x0047:
            r0.mo3272a(r6, r4)     // Catch:{ Exception -> 0x004b }
            goto L_0x0089
        L_0x004b:
            r0 = move-exception
            r5 = r3
            r3 = r0
            r0 = r5
            goto L_0x008c
        L_0x0050:
            com.baidu.mobstat.SendStrategyEnum r4 = com.baidu.mobstat.SendStrategyEnum.ONCE_A_DAY     // Catch:{ Exception -> 0x008b }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x008b }
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x008b }
            if (r4 == 0) goto L_0x0071
            com.baidu.mobstat.SendStrategyEnum r3 = com.baidu.mobstat.SendStrategyEnum.ONCE_A_DAY     // Catch:{ Exception -> 0x008b }
            com.baidu.mobstat.bj r0 = com.baidu.mobstat.C0471bj.m2935a()     // Catch:{ Exception -> 0x004b }
            int r4 = r3.ordinal()     // Catch:{ Exception -> 0x004b }
            r0.mo3272a(r6, r4)     // Catch:{ Exception -> 0x004b }
            com.baidu.mobstat.bj r0 = com.baidu.mobstat.C0471bj.m2935a()     // Catch:{ Exception -> 0x004b }
            r0.mo3276b(r6, r2)     // Catch:{ Exception -> 0x004b }
            goto L_0x0089
        L_0x0071:
            com.baidu.mobstat.SendStrategyEnum r4 = com.baidu.mobstat.SendStrategyEnum.SET_TIME_INTERVAL     // Catch:{ Exception -> 0x008b }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x008b }
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x008b }
            if (r3 == 0) goto L_0x0088
            com.baidu.mobstat.SendStrategyEnum r3 = com.baidu.mobstat.SendStrategyEnum.SET_TIME_INTERVAL     // Catch:{ Exception -> 0x008b }
            com.baidu.mobstat.bj r0 = com.baidu.mobstat.C0471bj.m2935a()     // Catch:{ Exception -> 0x004b }
            int r4 = r3.ordinal()     // Catch:{ Exception -> 0x004b }
            goto L_0x0047
        L_0x0088:
            r3 = r0
        L_0x0089:
            r0 = r3
            goto L_0x008f
        L_0x008b:
            r3 = move-exception
        L_0x008c:
            com.baidu.mobstat.C0514cz.m3112a(r3)
        L_0x008f:
            java.lang.String r3 = "BaiduMobAd_TIME_INTERVAL"
            java.lang.String r3 = com.baidu.mobstat.C0518dc.m3133a(r6, r3)     // Catch:{ Exception -> 0x00b7 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00b7 }
            if (r4 != 0) goto L_0x00bb
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x00b7 }
            int r0 = r0.ordinal()     // Catch:{ Exception -> 0x00b7 }
            com.baidu.mobstat.SendStrategyEnum r4 = com.baidu.mobstat.SendStrategyEnum.SET_TIME_INTERVAL     // Catch:{ Exception -> 0x00b7 }
            int r4 = r4.ordinal()     // Catch:{ Exception -> 0x00b7 }
            if (r0 != r4) goto L_0x00bb
            if (r3 <= 0) goto L_0x00bb
            if (r3 > r2) goto L_0x00bb
            com.baidu.mobstat.bj r0 = com.baidu.mobstat.C0471bj.m2935a()     // Catch:{ Exception -> 0x00b7 }
            r0.mo3276b(r6, r3)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r0 = move-exception
            com.baidu.mobstat.C0514cz.m3112a(r0)
        L_0x00bb:
            java.lang.String r0 = "BaiduMobAd_ONLY_WIFI"
            java.lang.String r0 = com.baidu.mobstat.C0518dc.m3133a(r6, r0)     // Catch:{ Exception -> 0x00e8 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00e8 }
            if (r2 != 0) goto L_0x00ec
            java.lang.String r2 = "true"
            boolean r2 = r2.equals(r0)     // Catch:{ Exception -> 0x00e8 }
            if (r2 == 0) goto L_0x00d8
            com.baidu.mobstat.bj r0 = com.baidu.mobstat.C0471bj.m2935a()     // Catch:{ Exception -> 0x00e8 }
            r1 = 1
            r0.mo3274a(r6, r1)     // Catch:{ Exception -> 0x00e8 }
            return
        L_0x00d8:
            java.lang.String r2 = "false"
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x00e8 }
            if (r0 == 0) goto L_0x00ec
            com.baidu.mobstat.bj r0 = com.baidu.mobstat.C0471bj.m2935a()     // Catch:{ Exception -> 0x00e8 }
            r0.mo3274a(r6, r1)     // Catch:{ Exception -> 0x00e8 }
            return
        L_0x00e8:
            r6 = move-exception
            com.baidu.mobstat.C0514cz.m3112a(r6)
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.PrefOperate.loadMetaDataConfig(android.content.Context):void");
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        if (str == null || str.equals(BuildConfig.FLAVOR)) {
            C0514cz.m3117c("设置的渠道不能为空或者为null || The channel that you have been set is null or empty, please check it.");
        }
        CooperService.m2766a().getHeadObject().f3211m = str;
        if (z && str != null && !str.equals(BuildConfig.FLAVOR)) {
            C0471bj.m2935a().mo3279c(context, str);
            C0471bj.m2935a().mo3278b(context, true);
        }
        if (!z) {
            C0471bj.m2935a().mo3279c(context, BuildConfig.FLAVOR);
            C0471bj.m2935a().mo3278b(context, false);
        }
    }

    public static void setAppChannel(String str) {
        if (str == null || str.equals(BuildConfig.FLAVOR)) {
            C0514cz.m3117c("设置的渠道不能为空或者为null || The channel that you have been set is null or empty, please check it.");
        }
        CooperService.m2766a().getHeadObject().f3211m = str;
    }

    public static void setAppKey(String str) {
        CooperService.m2766a().getHeadObject().f3204f = str;
    }
}
