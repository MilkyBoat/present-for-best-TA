package com.baidu.mobstat;

/* renamed from: com.baidu.mobstat.au */
public class C0455au {

    /* renamed from: a */
    private static C0528l f3098a;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.baidu.mobstat.C0528l m2841a(android.content.Context r4) {
        /*
            java.lang.Class<com.baidu.mobstat.au> r0 = com.baidu.mobstat.C0455au.class
            monitor-enter(r0)
            java.lang.String r1 = "getBPStretegyController begin"
            com.baidu.mobstat.C0465bd.m2909a(r1)     // Catch:{ all -> 0x0044 }
            com.baidu.mobstat.l r1 = f3098a     // Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x002c
            java.lang.String r2 = "com.baidu.bottom.remote.BPStretegyController2"
            java.lang.Class r2 = com.baidu.mobstat.C0458ax.m2858a(r4, r2)     // Catch:{ Exception -> 0x0028 }
            if (r2 == 0) goto L_0x002c
            java.lang.Object r2 = r2.newInstance()     // Catch:{ Exception -> 0x0028 }
            com.baidu.mobstat.aw r3 = new com.baidu.mobstat.aw     // Catch:{ Exception -> 0x0028 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r1 = "Get BPStretegyController load remote class v2"
            com.baidu.mobstat.C0465bd.m2909a(r1)     // Catch:{ Exception -> 0x0024 }
            r1 = r3
            goto L_0x002c
        L_0x0024:
            r1 = move-exception
            r2 = r1
            r1 = r3
            goto L_0x0029
        L_0x0028:
            r2 = move-exception
        L_0x0029:
            com.baidu.mobstat.C0465bd.m2910a(r2)     // Catch:{ all -> 0x0044 }
        L_0x002c:
            if (r1 != 0) goto L_0x0038
            com.baidu.mobstat.av r1 = new com.baidu.mobstat.av     // Catch:{ all -> 0x0044 }
            r1.<init>()     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "Get BPStretegyController load local class"
            com.baidu.mobstat.C0465bd.m2909a(r2)     // Catch:{ all -> 0x0044 }
        L_0x0038:
            f3098a = r1     // Catch:{ all -> 0x0044 }
            com.baidu.mobstat.C0458ax.m2860a(r4, r1)     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = "getBPStretegyController end"
            com.baidu.mobstat.C0465bd.m2909a(r4)     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)
            return r1
        L_0x0044:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0455au.m2841a(android.content.Context):com.baidu.mobstat.l");
    }

    /* renamed from: a */
    public static synchronized void m2842a() {
        synchronized (C0455au.class) {
            f3098a = null;
        }
    }
}
