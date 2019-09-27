package com.baidu.mobstat;

/* renamed from: com.baidu.mobstat.q */
class C0533q {

    /* renamed from: a */
    static C0533q f3346a = new C0533q();

    C0533q() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3392a(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            java.lang.String r0 = "unkown"
            java.lang.String r1 = "android.intent.action.PACKAGE_REMOVED"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x001b
            r1 = 8192(0x2000, float:1.14794E-41)
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r6, r1)     // Catch:{ NameNotFoundException -> 0x0017 }
            java.lang.String r4 = r4.versionName     // Catch:{ NameNotFoundException -> 0x0017 }
            goto L_0x001c
        L_0x0017:
            r4 = move-exception
            com.baidu.mobstat.C0465bd.m2910a(r4)
        L_0x001b:
            r4 = r0
        L_0x001c:
            java.lang.String r0 = ""
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0066 }
            r1.<init>()     // Catch:{ Exception -> 0x0066 }
            java.lang.String r2 = "n"
            r1.put(r2, r6)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r6 = "a"
            r1.put(r6, r5)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r5 = "v"
            r1.put(r5, r4)     // Catch:{ Exception -> 0x0066 }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x0066 }
            r4.<init>()     // Catch:{ Exception -> 0x0066 }
            r4.put(r1)     // Catch:{ Exception -> 0x0066 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0066 }
            r5.<init>()     // Catch:{ Exception -> 0x0066 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0066 }
            r5.append(r1)     // Catch:{ Exception -> 0x0066 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0066 }
            r6.<init>()     // Catch:{ Exception -> 0x0066 }
            java.lang.String r1 = "app_change"
            r6.put(r1, r4)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r4 = "meta-data"
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0066 }
            r6.put(r4, r5)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0066 }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0066 }
            java.lang.String r4 = com.baidu.mobstat.C0505cq.m3071a(r4)     // Catch:{ Exception -> 0x0066 }
            goto L_0x006f
        L_0x0066:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            com.baidu.mobstat.C0465bd.m2912b(r4)
            r4 = r0
        L_0x006f:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x007e
            long r5 = java.lang.System.currentTimeMillis()
            com.baidu.mobstat.y r0 = com.baidu.mobstat.C0541y.APP_CHANGE
            r0.mo3407a(r5, r4)
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0533q.mo3392a(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
