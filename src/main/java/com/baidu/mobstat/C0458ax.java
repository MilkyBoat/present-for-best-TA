package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import java.io.File;

/* renamed from: com.baidu.mobstat.ax */
class C0458ax {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static volatile DexClassLoader f3103a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static volatile boolean f3104b;

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004f, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized dalvik.system.DexClassLoader m2856a(android.content.Context r5) {
        /*
            java.lang.Class<com.baidu.mobstat.ax> r0 = com.baidu.mobstat.C0458ax.class
            monitor-enter(r0)
            dalvik.system.DexClassLoader r1 = f3103a     // Catch:{ all -> 0x0073 }
            if (r1 == 0) goto L_0x000b
            dalvik.system.DexClassLoader r5 = f3103a     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)
            return r5
        L_0x000b:
            java.lang.String r1 = ".remote.jar"
            java.io.File r1 = r5.getFileStreamPath(r1)     // Catch:{ all -> 0x0073 }
            r2 = 0
            if (r1 == 0) goto L_0x001c
            boolean r3 = r1.isFile()     // Catch:{ all -> 0x0073 }
            if (r3 != 0) goto L_0x001c
            monitor-exit(r0)
            return r2
        L_0x001c:
            java.lang.String r3 = r1.getAbsolutePath()     // Catch:{ all -> 0x0073 }
            boolean r3 = m2863b(r5, r3)     // Catch:{ all -> 0x0073 }
            if (r3 != 0) goto L_0x0036
            java.lang.String r5 = "remote jar version lower than min limit, need delete"
            com.baidu.mobstat.C0465bd.m2909a(r5)     // Catch:{ all -> 0x0073 }
            boolean r5 = r1.isFile()     // Catch:{ all -> 0x0073 }
            if (r5 == 0) goto L_0x0034
            r1.delete()     // Catch:{ all -> 0x0073 }
        L_0x0034:
            monitor-exit(r0)
            return r2
        L_0x0036:
            java.lang.String r3 = r1.getAbsolutePath()     // Catch:{ all -> 0x0073 }
            boolean r3 = m2864c(r5, r3)     // Catch:{ all -> 0x0073 }
            if (r3 != 0) goto L_0x0050
            java.lang.String r5 = "remote jar md5 is not right, need delete"
            com.baidu.mobstat.C0465bd.m2909a(r5)     // Catch:{ all -> 0x0073 }
            boolean r5 = r1.isFile()     // Catch:{ all -> 0x0073 }
            if (r5 == 0) goto L_0x004e
            r1.delete()     // Catch:{ all -> 0x0073 }
        L_0x004e:
            monitor-exit(r0)
            return r2
        L_0x0050:
            java.lang.String r3 = "outdex"
            r4 = 0
            java.io.File r3 = r5.getDir(r3, r4)     // Catch:{ all -> 0x0073 }
            dalvik.system.DexClassLoader r4 = new dalvik.system.DexClassLoader     // Catch:{ Exception -> 0x006b }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x006b }
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ Exception -> 0x006b }
            r4.<init>(r1, r3, r2, r5)     // Catch:{ Exception -> 0x006b }
            f3103a = r4     // Catch:{ Exception -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r5 = move-exception
            com.baidu.mobstat.C0465bd.m2910a(r5)     // Catch:{ all -> 0x0073 }
        L_0x006f:
            dalvik.system.DexClassLoader r5 = f3103a     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)
            return r5
        L_0x0073:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0458ax.m2856a(android.content.Context):dalvik.system.DexClassLoader");
    }

    /* renamed from: a */
    public static Class<?> m2858a(Context context, String str) {
        DexClassLoader a = m2856a(context);
        if (a == null) {
            return null;
        }
        return a.loadClass(str);
    }

    /* renamed from: a */
    public static synchronized void m2860a(Context context, C0528l lVar) {
        synchronized (C0458ax.class) {
            if (!f3104b) {
                if (!C0518dc.m3156n(context)) {
                    C0465bd.m2909a("isWifiAvailable = false, will not to update");
                } else if (!lVar.mo3218a(context)) {
                    C0465bd.m2909a("check time, will not to update");
                } else {
                    C0465bd.m2909a("can start update config");
                    new C0459ay(context, lVar).start();
                    f3104b = true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061 A[SYNTHETIC, Splitter:B:22:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0069 A[SYNTHETIC, Splitter:B:28:0x0069] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m2862b(java.lang.String r6) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0047 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0047 }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x0047 }
            if (r2 == 0) goto L_0x0024
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0047 }
            r2.<init>()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r3 = "file size: "
            r2.append(r3)     // Catch:{ Exception -> 0x0047 }
            long r3 = r1.length()     // Catch:{ Exception -> 0x0047 }
            r2.append(r3)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0047 }
            com.baidu.mobstat.C0465bd.m2912b(r1)     // Catch:{ Exception -> 0x0047 }
        L_0x0024:
            java.util.jar.JarFile r1 = new java.util.jar.JarFile     // Catch:{ Exception -> 0x0047 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0047 }
            java.util.jar.Manifest r0 = r1.getManifest()     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            java.util.jar.Attributes r0 = r0.getMainAttributes()     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            java.lang.String r2 = "Plugin-Version"
            java.lang.String r0 = r0.getValue(r2)     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            return r0
        L_0x003d:
            r6 = move-exception
            r0 = r1
            goto L_0x0067
        L_0x0040:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0048
        L_0x0045:
            r6 = move-exception
            goto L_0x0067
        L_0x0047:
            r1 = move-exception
        L_0x0048:
            com.baidu.mobstat.C0465bd.m2910a(r1)     // Catch:{ all -> 0x0045 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r1.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = "baidu remote sdk is not ready"
            r1.append(r2)     // Catch:{ all -> 0x0045 }
            r1.append(r6)     // Catch:{ all -> 0x0045 }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x0045 }
            com.baidu.mobstat.C0465bd.m2909a(r6)     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0064
            r0.close()     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            java.lang.String r6 = ""
            return r6
        L_0x0067:
            if (r0 == 0) goto L_0x006c
            r0.close()     // Catch:{ Exception -> 0x006c }
        L_0x006c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0458ax.m2862b(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    private static boolean m2863b(Context context, String str) {
        int i;
        String b = m2862b(str);
        boolean z = false;
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        try {
            i = Integer.valueOf(b).intValue();
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            i = 0;
        }
        if (i >= 4) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    private static boolean m2864c(Context context, String str) {
        String str2;
        String a = C0512cx.m3104a(new File(str));
        StringBuilder sb = new StringBuilder();
        sb.append("remote.jar local file digest value digest = ");
        sb.append(a);
        C0465bd.m2909a(sb.toString());
        if (TextUtils.isEmpty(a)) {
            str2 = "remote.jar local file digest value fail";
        } else {
            String b = m2862b(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("remote.jar local file digest value version = ");
            sb2.append(b);
            C0465bd.m2909a(sb2.toString());
            if (TextUtils.isEmpty(b)) {
                return false;
            }
            String d = m2865d(context, b);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("remote.jar config digest value remoteJarMd5 = ");
            sb3.append(d);
            C0465bd.m2909a(sb3.toString());
            if (!TextUtils.isEmpty(d)) {
                return a.equals(d);
            }
            str2 = "remote.jar config digest value lost";
        }
        C0465bd.m2909a(str2);
        return false;
    }

    /* renamed from: d */
    private static String m2865d(Context context, String str) {
        return C0460az.m2869a(context).mo3230c(str);
    }
}
