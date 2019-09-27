package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.ay */
class C0459ay extends Thread {

    /* renamed from: a */
    private Context f3105a;

    /* renamed from: b */
    private C0528l f3106b;

    public C0459ay(Context context, C0528l lVar) {
        this.f3105a = context;
        this.f3106b = lVar;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ca A[Catch:{ all -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d3 A[Catch:{ all -> 0x00e0 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x00aa=Splitter:B:16:0x00aa, B:26:0x00ba=Splitter:B:26:0x00ba} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m2866a() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "start get config and download jar"
            com.baidu.mobstat.C0465bd.m2909a(r0)     // Catch:{ all -> 0x00e5 }
            android.content.Context r0 = r9.f3105a     // Catch:{ all -> 0x00e5 }
            com.baidu.mobstat.l r1 = r9.f3106b     // Catch:{ all -> 0x00e5 }
            java.lang.String r2 = r9.m2868b(r0)     // Catch:{ all -> 0x00e5 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            r3.<init>()     // Catch:{ all -> 0x00e5 }
            java.lang.String r4 = "update req url is:"
            r3.append(r4)     // Catch:{ all -> 0x00e5 }
            r3.append(r2)     // Catch:{ all -> 0x00e5 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00e5 }
            com.baidu.mobstat.C0465bd.m2914c(r3)     // Catch:{ all -> 0x00e5 }
            java.net.HttpURLConnection r2 = com.baidu.mobstat.C0507cs.m3091d(r0, r2)     // Catch:{ all -> 0x00e5 }
            r2.connect()     // Catch:{ all -> 0x00e0 }
            java.lang.String r3 = "X-CONFIG"
            java.lang.String r3 = r2.getHeaderField(r3)     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r4.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r5 = "config is: "
            r4.append(r5)     // Catch:{ all -> 0x00e0 }
            r4.append(r3)     // Catch:{ all -> 0x00e0 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00e0 }
            com.baidu.mobstat.C0465bd.m2909a(r4)     // Catch:{ all -> 0x00e0 }
            java.lang.String r4 = "X-SIGN"
            java.lang.String r4 = r2.getHeaderField(r4)     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r5.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r6 = "sign is: "
            r5.append(r6)     // Catch:{ all -> 0x00e0 }
            r5.append(r4)     // Catch:{ all -> 0x00e0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e0 }
            com.baidu.mobstat.C0465bd.m2909a(r5)     // Catch:{ all -> 0x00e0 }
            int r5 = r2.getResponseCode()     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r6.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r7 = "update response code is: "
            r6.append(r7)     // Catch:{ all -> 0x00e0 }
            r6.append(r5)     // Catch:{ all -> 0x00e0 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00e0 }
            com.baidu.mobstat.C0465bd.m2909a(r6)     // Catch:{ all -> 0x00e0 }
            int r6 = r2.getContentLength()     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r7.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r8 = "update response content length is: "
            r7.append(r8)     // Catch:{ all -> 0x00e0 }
            r7.append(r6)     // Catch:{ all -> 0x00e0 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00e0 }
            com.baidu.mobstat.C0465bd.m2909a(r7)     // Catch:{ all -> 0x00e0 }
            r7 = 200(0xc8, float:2.8E-43)
            r8 = 0
            if (r5 != r7) goto L_0x00be
            if (r6 <= 0) goto L_0x00be
            java.lang.String r5 = ".remote.jar"
            r6 = 0
            java.io.FileOutputStream r5 = r0.openFileOutput(r5, r6)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            java.io.InputStream r6 = r2.getInputStream()     // Catch:{ IOException -> 0x00ae }
            boolean r6 = com.baidu.mobstat.C0513cy.m3107a(r6, r5)     // Catch:{ IOException -> 0x00ae }
            if (r6 == 0) goto L_0x00aa
            java.lang.String r6 = "save remote jar success"
            com.baidu.mobstat.C0465bd.m2909a(r6)     // Catch:{ IOException -> 0x00ae }
        L_0x00aa:
            com.baidu.mobstat.C0513cy.m3106a(r5)     // Catch:{ all -> 0x00e0 }
            goto L_0x00be
        L_0x00ae:
            r6 = move-exception
            goto L_0x00b5
        L_0x00b0:
            r0 = move-exception
            r5 = r8
            goto L_0x00ba
        L_0x00b3:
            r6 = move-exception
            r5 = r8
        L_0x00b5:
            com.baidu.mobstat.C0465bd.m2913b(r6)     // Catch:{ all -> 0x00b9 }
            goto L_0x00aa
        L_0x00b9:
            r0 = move-exception
        L_0x00ba:
            com.baidu.mobstat.C0513cy.m3106a(r5)     // Catch:{ all -> 0x00e0 }
            throw r0     // Catch:{ all -> 0x00e0 }
        L_0x00be:
            com.baidu.mobstat.C0458ax.f3103a = r8     // Catch:{ all -> 0x00e0 }
            com.baidu.mobstat.C0455au.m2842a()     // Catch:{ all -> 0x00e0 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00e0 }
            if (r5 != 0) goto L_0x00cd
            r1.mo3216a(r0, r3)     // Catch:{ all -> 0x00e0 }
        L_0x00cd:
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00e0 }
            if (r3 != 0) goto L_0x00d6
            r1.mo3219b(r0, r4)     // Catch:{ all -> 0x00e0 }
        L_0x00d6:
            r2.disconnect()     // Catch:{ all -> 0x00e5 }
            java.lang.String r0 = "finish get config and download jar"
            com.baidu.mobstat.C0465bd.m2909a(r0)     // Catch:{ all -> 0x00e5 }
            monitor-exit(r9)
            return
        L_0x00e0:
            r0 = move-exception
            r2.disconnect()     // Catch:{ all -> 0x00e5 }
            throw r0     // Catch:{ all -> 0x00e5 }
        L_0x00e5:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0459ay.m2866a():void");
    }

    /* renamed from: a */
    private void m2867a(Context context) {
        this.f3106b.mo3215a(context, System.currentTimeMillis());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0038, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x003c;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m2868b(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = ".remote.jar"
            java.io.File r0 = r7.getFileStreamPath(r0)
            java.lang.String r1 = "13"
            if (r0 == 0) goto L_0x003b
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = ".remote.jar"
            java.io.File r0 = r7.getFileStreamPath(r0)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.String r0 = com.baidu.mobstat.C0458ax.m2862b(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "startDownload remote jar file version = "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.baidu.mobstat.C0465bd.m2909a(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r0 = r1
        L_0x003c:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            org.apache.http.message.BasicNameValuePair r2 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r3 = "dynamicVersion"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = ""
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2.<init>(r3, r0)
            r1.add(r2)
            org.apache.http.message.BasicNameValuePair r0 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r2 = "packageName"
            java.lang.String r3 = com.baidu.mobstat.C0518dc.m3158p(r7)
            r0.<init>(r2, r3)
            r1.add(r0)
            org.apache.http.message.BasicNameValuePair r0 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r2 = "appVersion"
            java.lang.String r3 = com.baidu.mobstat.C0518dc.m3146f(r7)
            r0.<init>(r2, r3)
            r1.add(r0)
            org.apache.http.message.BasicNameValuePair r0 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r2 = "cuid"
            java.lang.String r7 = com.baidu.mobstat.C0518dc.m3131a(r7)
            r0.<init>(r2, r7)
            r1.add(r0)
            org.apache.http.message.BasicNameValuePair r7 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r0 = "platform"
            java.lang.String r2 = "Android"
            r7.<init>(r0, r2)
            r1.add(r7)
            org.apache.http.message.BasicNameValuePair r7 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r0 = "m"
            java.lang.String r2 = android.os.Build.MODEL
            r7.<init>(r0, r2)
            r1.add(r7)
            org.apache.http.message.BasicNameValuePair r7 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r0 = "s"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r3 = android.os.Build.VERSION.SDK_INT
            r2.append(r3)
            java.lang.String r3 = ""
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r7.<init>(r0, r2)
            r1.add(r7)
            org.apache.http.message.BasicNameValuePair r7 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r0 = "o"
            java.lang.String r2 = android.os.Build.VERSION.RELEASE
            r7.<init>(r0, r2)
            r1.add(r7)
            org.apache.http.message.BasicNameValuePair r7 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r0 = "i"
            java.lang.String r2 = "13"
            r7.<init>(r0, r2)
            r1.add(r7)
            java.lang.String r7 = "utf-8"
            java.lang.String r7 = org.apache.http.client.utils.URLEncodedUtils.format(r1, r7)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.baidu.mobstat.C0463bb.f3128c
            r0.append(r1)
            java.lang.String r1 = "?"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0459ay.m2868b(android.content.Context):java.lang.String");
    }

    public void run() {
        try {
            int i = C0463bb.f3126a ? 3 : 10;
            StringBuilder sb = new StringBuilder();
            sb.append("start version check in ");
            sb.append(i);
            sb.append("s");
            C0465bd.m2909a(sb.toString());
            sleep((long) (i * 1000));
            m2866a();
            m2867a(this.f3105a);
        } catch (Exception e) {
            C0465bd.m2910a((Throwable) e);
        }
        C0458ax.f3104b = false;
    }
}
