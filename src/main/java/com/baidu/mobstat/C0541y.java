package com.baidu.mobstat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.baidu.mobstat.y */
public enum C0541y {
    AP_LIST(0),
    APP_TRACE(2),
    APP_CHANGE(3),
    APP_APK(4);
    

    /* renamed from: f */
    private int f3374f;

    private C0541y(int i) {
        this.f3374f = i;
    }

    /* renamed from: a */
    private int m3249a(List<String> list, ArrayList<Long> arrayList, ArrayList<C0539w> arrayList2, int i, int i2) {
        int c = m3250c();
        int i3 = 0;
        int i4 = 0;
        while (c > 0) {
            if (c < i2) {
                i2 = c;
            }
            ArrayList a = mo3408a(i2, i4);
            if (i4 == 0 && a.size() != 0) {
                arrayList2.add((C0539w) a.get(0));
            }
            Iterator it = a.iterator();
            while (it.hasNext()) {
                C0539w wVar = (C0539w) it.next();
                long a2 = wVar.mo3397a();
                String b = wVar.mo3398b();
                int length = b.length() + i3;
                if (length > i) {
                    break;
                }
                arrayList.add(Long.valueOf(a2));
                list.add(b);
                i3 = length;
            }
            c -= i2;
            i4 += i2;
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        if (r1 != null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        if (r1 != null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002e, code lost:
        return 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0031  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m3250c() {
        /*
            r3 = this;
            r0 = 0
            com.baidu.mobstat.x r1 = r3.mo3189a()     // Catch:{ Exception -> 0x0021, all -> 0x001c }
            boolean r0 = r1.mo3402a()     // Catch:{ Exception -> 0x001a }
            if (r0 == 0) goto L_0x0015
            int r0 = r1.mo3404b()     // Catch:{ Exception -> 0x001a }
            if (r1 == 0) goto L_0x0014
            r1.close()
        L_0x0014:
            return r0
        L_0x0015:
            if (r1 == 0) goto L_0x002d
            goto L_0x002a
        L_0x0018:
            r0 = move-exception
            goto L_0x002f
        L_0x001a:
            r0 = move-exception
            goto L_0x0025
        L_0x001c:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x002f
        L_0x0021:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L_0x0025:
            com.baidu.mobstat.C0465bd.m2913b(r0)     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x002d
        L_0x002a:
            r1.close()
        L_0x002d:
            r0 = 0
            return r0
        L_0x002f:
            if (r1 == 0) goto L_0x0034
            r1.close()
        L_0x0034:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0541y.m3250c():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001c, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003a, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0040, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0041, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0049, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0067, code lost:
        return 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0049 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0058 A[SYNTHETIC, Splitter:B:45:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x005f A[SYNTHETIC, Splitter:B:50:0x005f] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int mo3406a(java.util.ArrayList<java.lang.Long> r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            if (r7 == 0) goto L_0x0066
            int r1 = r7.size()     // Catch:{ all -> 0x0063 }
            if (r1 != 0) goto L_0x000b
            goto L_0x0066
        L_0x000b:
            r1 = 0
            com.baidu.mobstat.x r2 = r6.mo3189a()     // Catch:{ Exception -> 0x0051 }
            boolean r1 = r2.mo3402a()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            if (r1 != 0) goto L_0x001d
            if (r2 == 0) goto L_0x001b
            r2.close()     // Catch:{ all -> 0x0063 }
        L_0x001b:
            monitor-exit(r6)
            return r0
        L_0x001d:
            int r1 = r7.size()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r3 = 0
        L_0x0022:
            if (r0 >= r1) goto L_0x0043
            java.lang.Object r4 = r7.get(r0)     // Catch:{ Exception -> 0x0040, all -> 0x0049 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x0040, all -> 0x0049 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0040, all -> 0x0049 }
            boolean r4 = r2.mo3207b(r4)     // Catch:{ Exception -> 0x0040, all -> 0x0049 }
            if (r4 != 0) goto L_0x003b
            if (r2 == 0) goto L_0x0039
            r2.close()     // Catch:{ all -> 0x0063 }
        L_0x0039:
            monitor-exit(r6)
            return r3
        L_0x003b:
            int r3 = r3 + 1
            int r0 = r0 + 1
            goto L_0x0022
        L_0x0040:
            r7 = move-exception
            r1 = r2
            goto L_0x0053
        L_0x0043:
            if (r2 == 0) goto L_0x005b
            r2.close()     // Catch:{ all -> 0x0063 }
            goto L_0x005b
        L_0x0049:
            r7 = move-exception
            goto L_0x005d
        L_0x004b:
            r7 = move-exception
            r1 = r2
            goto L_0x0052
        L_0x004e:
            r7 = move-exception
            r2 = r1
            goto L_0x005d
        L_0x0051:
            r7 = move-exception
        L_0x0052:
            r3 = 0
        L_0x0053:
            com.baidu.mobstat.C0465bd.m2913b(r7)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ all -> 0x0063 }
        L_0x005b:
            monitor-exit(r6)
            return r3
        L_0x005d:
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ all -> 0x0063 }
        L_0x0062:
            throw r7     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L_0x0066:
            monitor-exit(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0541y.mo3406a(java.util.ArrayList):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        return -1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0031 A[SYNTHETIC, Splitter:B:26:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0039 A[SYNTHETIC, Splitter:B:32:0x0039] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long mo3407a(long r5, java.lang.String r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = -1
            r2 = 0
            com.baidu.mobstat.x r3 = r4.mo3189a()     // Catch:{ Exception -> 0x002b }
            boolean r2 = r3.mo3402a()     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
            if (r2 != 0) goto L_0x0015
            if (r3 == 0) goto L_0x0013
            r3.close()     // Catch:{ all -> 0x003d }
        L_0x0013:
            monitor-exit(r4)
            return r0
        L_0x0015:
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
            long r5 = r3.mo3205a(r5, r7)     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
            if (r3 == 0) goto L_0x0035
            r3.close()     // Catch:{ all -> 0x003d }
            goto L_0x0035
        L_0x0023:
            r5 = move-exception
            goto L_0x0037
        L_0x0025:
            r5 = move-exception
            r2 = r3
            goto L_0x002c
        L_0x0028:
            r5 = move-exception
            r3 = r2
            goto L_0x0037
        L_0x002b:
            r5 = move-exception
        L_0x002c:
            com.baidu.mobstat.C0465bd.m2913b(r5)     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0034
            r2.close()     // Catch:{ all -> 0x003d }
        L_0x0034:
            r5 = r0
        L_0x0035:
            monitor-exit(r4)
            return r5
        L_0x0037:
            if (r3 == 0) goto L_0x003f
            r3.close()     // Catch:{ all -> 0x003d }
            goto L_0x003f
        L_0x003d:
            r5 = move-exception
            goto L_0x0040
        L_0x003f:
            throw r5     // Catch:{ all -> 0x003d }
        L_0x0040:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0541y.mo3407a(long, java.lang.String):long");
    }

    /* renamed from: a */
    public abstract C0540x mo3189a();

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0030 A[SYNTHETIC, Splitter:B:28:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0038 A[SYNTHETIC, Splitter:B:34:0x0038] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.ArrayList<com.baidu.mobstat.C0539w> mo3408a(int r4, int r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x003c }
            r0.<init>()     // Catch:{ all -> 0x003c }
            r1 = 0
            com.baidu.mobstat.x r2 = r3.mo3189a()     // Catch:{ Exception -> 0x002a }
            boolean r1 = r2.mo3402a()     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            if (r1 != 0) goto L_0x0018
            if (r2 == 0) goto L_0x0016
            r2.close()     // Catch:{ all -> 0x003c }
        L_0x0016:
            monitor-exit(r3)
            return r0
        L_0x0018:
            java.util.ArrayList r4 = r2.mo3206a(r4, r5)     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            if (r2 == 0) goto L_0x0034
            r2.close()     // Catch:{ all -> 0x003c }
            goto L_0x0034
        L_0x0022:
            r4 = move-exception
            r1 = r2
            goto L_0x0036
        L_0x0025:
            r4 = move-exception
            r1 = r2
            goto L_0x002b
        L_0x0028:
            r4 = move-exception
            goto L_0x0036
        L_0x002a:
            r4 = move-exception
        L_0x002b:
            com.baidu.mobstat.C0465bd.m2913b(r4)     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0033
            r1.close()     // Catch:{ all -> 0x003c }
        L_0x0033:
            r4 = r0
        L_0x0034:
            monitor-exit(r3)
            return r4
        L_0x0036:
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ all -> 0x003c }
        L_0x003b:
            throw r4     // Catch:{ all -> 0x003c }
        L_0x003c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0541y.mo3408a(int, int):java.util.ArrayList");
    }

    /* renamed from: a */
    public synchronized List<String> mo3409a(int i) {
        List<String> arrayList;
        arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        m3249a(arrayList, arrayList2, arrayList3, i, 500);
        if (arrayList3.size() != 0 && arrayList.size() == 0 && arrayList2.size() == 0) {
            C0539w wVar = (C0539w) arrayList3.get(0);
            long a = wVar.mo3397a();
            String b = wVar.mo3398b();
            arrayList2.add(Long.valueOf(a));
            arrayList.add(b);
        }
        int a2 = mo3406a(arrayList2);
        if (a2 != arrayList.size()) {
            arrayList = arrayList.subList(0, a2);
        }
        return arrayList;
    }

    /* renamed from: b */
    public synchronized boolean mo3410b() {
        return m3250c() == 0;
    }

    /* renamed from: b */
    public synchronized boolean mo3411b(int i) {
        return m3250c() >= i;
    }

    public String toString() {
        return String.valueOf(this.f3374f);
    }
}
