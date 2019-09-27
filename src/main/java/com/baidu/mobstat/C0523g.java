package com.baidu.mobstat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.androlua.BuildConfig;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.g */
public final class C0523g {

    /* renamed from: a */
    private static final String f3327a;

    /* renamed from: e */
    private static C0526j f3328e;

    /* renamed from: b */
    private final Context f3329b;

    /* renamed from: c */
    private int f3330c = 0;

    /* renamed from: d */
    private PublicKey f3331d;

    static {
        String str = new String(C0461b.m2891a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
        String str2 = new String(C0461b.m2891a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        f3327a = sb.toString();
    }

    private C0523g(Context context) {
        this.f3329b = context.getApplicationContext();
        m3173a();
    }

    /* renamed from: a */
    public static String m3169a(Context context) {
        return m3185c(context).mo3388b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0035 A[SYNTHETIC, Splitter:B:25:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0041 A[SYNTHETIC, Splitter:B:33:0x0041] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m3170a(java.io.File r5) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ Exception -> 0x002e, all -> 0x002b }
            r1.<init>(r5)     // Catch:{ Exception -> 0x002e, all -> 0x002b }
            r5 = 8192(0x2000, float:1.14794E-41)
            char[] r5 = new char[r5]     // Catch:{ Exception -> 0x0029 }
            java.io.CharArrayWriter r2 = new java.io.CharArrayWriter     // Catch:{ Exception -> 0x0029 }
            r2.<init>()     // Catch:{ Exception -> 0x0029 }
        L_0x000f:
            int r3 = r1.read(r5)     // Catch:{ Exception -> 0x0029 }
            if (r3 <= 0) goto L_0x001a
            r4 = 0
            r2.write(r5, r4, r3)     // Catch:{ Exception -> 0x0029 }
            goto L_0x000f
        L_0x001a:
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x0029 }
            if (r1 == 0) goto L_0x0028
            r1.close()     // Catch:{ Exception -> 0x0024 }
            return r5
        L_0x0024:
            r0 = move-exception
            m3184b(r0)
        L_0x0028:
            return r5
        L_0x0029:
            r5 = move-exception
            goto L_0x0030
        L_0x002b:
            r5 = move-exception
            r1 = r0
            goto L_0x003f
        L_0x002e:
            r5 = move-exception
            r1 = r0
        L_0x0030:
            m3184b(r5)     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ Exception -> 0x0039 }
            return r0
        L_0x0039:
            r5 = move-exception
            m3184b(r5)
        L_0x003d:
            return r0
        L_0x003e:
            r5 = move-exception
        L_0x003f:
            if (r1 == 0) goto L_0x0049
            r1.close()     // Catch:{ Exception -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r0 = move-exception
            m3184b(r0)
        L_0x0049:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0523g.m3170a(java.io.File):java.lang.String");
    }

    /* renamed from: a */
    private static String m3171a(byte[] bArr) {
        StringBuilder sb;
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = BuildConfig.FLAVOR;
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb = new StringBuilder();
                sb.append(str);
                str = "0";
            } else {
                sb = new StringBuilder();
            }
            sb.append(str);
            sb.append(hexString);
            str = sb.toString();
        }
        return str.toLowerCase();
    }

    /* renamed from: a */
    private List<C0525i> m3172a(Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.f3329b.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (!(resolveInfo.activityInfo == null || resolveInfo.activityInfo.applicationInfo == null)) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] a = C0461b.m2891a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(a));
                                C0525i iVar = new C0525i(null);
                                iVar.f3334b = jSONObject.getInt("priority");
                                iVar.f3333a = resolveInfo.activityInfo.applicationInfo;
                                if (this.f3329b.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    iVar.f3336d = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        String[] strArr = new String[jSONArray.length()];
                                        for (int i = 0; i < strArr.length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (m3177a(strArr, m3179a(packageInfo.signatures))) {
                                            byte[] a2 = m3178a(C0461b.m2891a(string2.getBytes()), this.f3331d);
                                            if (a2 != null && Arrays.equals(a2, C0515d.m3120a(a))) {
                                                iVar.f3335c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(iVar);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new C0524h(this));
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0028 A[SYNTHETIC, Splitter:B:14:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034 A[SYNTHETIC, Splitter:B:23:0x0034] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3173a() {
        /*
            r4 = this;
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0031, all -> 0x0022 }
            byte[] r2 = com.baidu.mobstat.C0522f.m3168a()     // Catch:{ Exception -> 0x0031, all -> 0x0022 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0031, all -> 0x0022 }
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch:{ Exception -> 0x0032, all -> 0x0020 }
            java.security.cert.Certificate r0 = r0.generateCertificate(r1)     // Catch:{ Exception -> 0x0032, all -> 0x0020 }
            java.security.PublicKey r0 = r0.getPublicKey()     // Catch:{ Exception -> 0x0032, all -> 0x0020 }
            r4.f3331d = r0     // Catch:{ Exception -> 0x0032, all -> 0x0020 }
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ Exception -> 0x0038 }
            return
        L_0x0020:
            r0 = move-exception
            goto L_0x0026
        L_0x0022:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x0026:
            if (r1 == 0) goto L_0x0030
            r1.close()     // Catch:{ Exception -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r1 = move-exception
            m3184b(r1)
        L_0x0030:
            throw r0
        L_0x0031:
            r1 = r0
        L_0x0032:
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ Exception -> 0x0038 }
            return
        L_0x0038:
            r0 = move-exception
            m3184b(r0)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0523g.m3173a():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051 A[SYNTHETIC, Splitter:B:27:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005c A[SYNTHETIC, Splitter:B:34:0x005c] */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3175a(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 0
            r3 = 24
            if (r0 < r3) goto L_0x000a
            r0 = 0
            goto L_0x000b
        L_0x000a:
            r0 = 1
        L_0x000b:
            r3 = 0
            android.content.Context r4 = r6.f3329b     // Catch:{ Exception -> 0x004b }
            java.lang.String r5 = "libcuid.so"
            java.io.FileOutputStream r4 = r4.openFileOutput(r5, r0)     // Catch:{ Exception -> 0x004b }
            byte[] r7 = r7.getBytes()     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r4.write(r7)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r4.flush()     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            if (r4 == 0) goto L_0x0028
            r4.close()     // Catch:{ Exception -> 0x0024 }
            goto L_0x0028
        L_0x0024:
            r7 = move-exception
            m3184b(r7)
        L_0x0028:
            if (r0 != 0) goto L_0x0042
            r7 = 436(0x1b4, float:6.11E-43)
            java.io.File r0 = new java.io.File
            android.content.Context r1 = r6.f3329b
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = "libcuid.so"
            r0.<init>(r1, r2)
            java.lang.String r0 = r0.getAbsolutePath()
            boolean r7 = com.baidu.mobstat.C0527k.m3200a(r0, r7)
            return r7
        L_0x0042:
            return r1
        L_0x0043:
            r7 = move-exception
            r3 = r4
            goto L_0x005a
        L_0x0046:
            r7 = move-exception
            r3 = r4
            goto L_0x004c
        L_0x0049:
            r7 = move-exception
            goto L_0x005a
        L_0x004b:
            r7 = move-exception
        L_0x004c:
            m3184b(r7)     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x0059
            r3.close()     // Catch:{ Exception -> 0x0055 }
            return r2
        L_0x0055:
            r7 = move-exception
            m3184b(r7)
        L_0x0059:
            return r2
        L_0x005a:
            if (r3 == 0) goto L_0x0064
            r3.close()     // Catch:{ Exception -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r0 = move-exception
            m3184b(r0)
        L_0x0064:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0523g.m3175a(java.lang.String):boolean");
    }

    /* renamed from: a */
    private boolean m3176a(String str, String str2) {
        try {
            return System.putString(this.f3329b.getContentResolver(), str, str2);
        } catch (Exception e) {
            m3184b((Throwable) e);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m3177a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String add : strArr) {
            hashSet.add(add);
        }
        HashSet hashSet2 = new HashSet();
        for (String add2 : strArr2) {
            hashSet2.add(add2);
        }
        return hashSet.equals(hashSet2);
    }

    /* renamed from: a */
    private static byte[] m3178a(byte[] bArr, PublicKey publicKey) {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, publicKey);
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    private String[] m3179a(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = m3171a(C0515d.m3120a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    /* renamed from: b */
    private C0526j m3180b() {
        boolean z;
        String str;
        String str2;
        List a = m3172a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.f3329b.getPackageName()), true);
        boolean z2 = false;
        if (a == null || a.size() == 0) {
            for (int i = 0; i < 3; i++) {
                Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            C0525i iVar = (C0525i) a.get(0);
            z = iVar.f3335c;
            if (!iVar.f3335c) {
                for (int i2 = 0; i2 < 3; i2++) {
                    Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
                }
            }
        }
        File file = new File(this.f3329b.getFilesDir(), "libcuid.so");
        String str3 = null;
        C0526j a2 = file.exists() ? C0526j.m3197a(m3192f(m3170a(file))) : null;
        if (a2 == null) {
            this.f3330c |= 16;
            List<C0525i> a3 = m3172a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (a3 != null) {
                String str4 = "files";
                File filesDir = this.f3329b.getFilesDir();
                if (!str4.equals(filesDir.getName())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("fetal error:: app files dir name is unexpectedly :: ");
                    sb.append(filesDir.getAbsolutePath());
                    Log.e("DeviceId", sb.toString());
                    str4 = filesDir.getName();
                }
                for (C0525i iVar2 : a3) {
                    if (!iVar2.f3336d) {
                        File file2 = new File(new File(iVar2.f3333a.dataDir, str4), "libcuid.so");
                        if (file2.exists()) {
                            a2 = C0526j.m3197a(m3192f(m3170a(file2)));
                            if (a2 != null) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        if (a2 == null) {
            a2 = C0526j.m3197a(m3192f(m3182b("com.baidu.deviceid.v2")));
        }
        boolean c = m3187c("android.permission.READ_EXTERNAL_STORAGE");
        if (a2 == null && c) {
            this.f3330c |= 2;
            a2 = m3190e();
        }
        if (a2 == null) {
            this.f3330c |= 8;
            a2 = m3188d();
        }
        if (a2 != null || !c) {
            str = null;
        } else {
            this.f3330c |= 1;
            String h = m3194h(BuildConfig.FLAVOR);
            z2 = true;
            str = h;
            a2 = m3189d(h);
        }
        if (a2 == null) {
            this.f3330c |= 4;
            if (!z2) {
                str = m3194h(BuildConfig.FLAVOR);
            }
            a2 = new C0526j(null);
            String b = m3181b(this.f3329b);
            if (VERSION.SDK_INT < 23) {
                String uuid = UUID.randomUUID().toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(b);
                sb2.append(uuid);
                str2 = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("com.baidu");
                sb3.append(b);
                str2 = sb3.toString();
            }
            a2.f3337a = C0488c.m3013a(str2.getBytes(), true);
            a2.f3338b = str;
        }
        File file3 = new File(this.f3329b.getFilesDir(), "libcuid.so");
        if ((this.f3330c & 16) != 0 || !file3.exists()) {
            if (TextUtils.isEmpty(null)) {
                str3 = m3191e(a2.mo3387a());
            }
            m3175a(str3);
        }
        boolean c2 = m3186c();
        if (c2 && ((this.f3330c & 2) != 0 || TextUtils.isEmpty(m3182b("com.baidu.deviceid.v2")))) {
            if (TextUtils.isEmpty(str3)) {
                str3 = m3191e(a2.mo3387a());
            }
            m3176a("com.baidu.deviceid.v2", str3);
        }
        if (m3187c("android.permission.WRITE_EXTERNAL_STORAGE")) {
            File file4 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if ((this.f3330c & 8) != 0 || !file4.exists()) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = m3191e(a2.mo3387a());
                }
                m3193g(str3);
            }
        }
        if (c2 && ((1 & this.f3330c) != 0 || TextUtils.isEmpty(m3182b("com.baidu.deviceid")))) {
            m3176a("com.baidu.deviceid", a2.f3337a);
            m3176a("bd_setting_i", a2.f3338b);
        }
        if (c2 && !TextUtils.isEmpty(a2.f3338b)) {
            File file5 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            if ((this.f3330c & 2) != 0 || !file5.exists()) {
                m3183b(a2.f3338b, a2.f3337a);
            }
        }
        return a2;
    }

    /* renamed from: b */
    public static String m3181b(Context context) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? BuildConfig.FLAVOR : string;
    }

    /* renamed from: b */
    private String m3182b(String str) {
        try {
            return System.getString(this.f3329b.getContentResolver(), str);
        } catch (Exception e) {
            m3184b((Throwable) e);
            return null;
        }
    }

    /* renamed from: b */
    private static void m3183b(String str, String str2) {
        File file;
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("=");
            sb.append(str2);
            File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
            File file3 = new File(file2, ".cuid");
            try {
                if (file2.exists() && !file2.isDirectory()) {
                    Random random = new Random();
                    File parentFile = file2.getParentFile();
                    String name = file2.getName();
                    do {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(name);
                        sb2.append(random.nextInt());
                        sb2.append(".tmp");
                        file = new File(parentFile, sb2.toString());
                    } while (file.exists());
                    file2.renameTo(file);
                    file.delete();
                }
                file2.mkdirs();
                FileWriter fileWriter = new FileWriter(file3, false);
                fileWriter.write(C0461b.m2890a(C0434a.m2792a(f3327a, f3327a, sb.toString().getBytes()), "utf-8"));
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException | Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m3184b(Throwable th) {
    }

    /* renamed from: c */
    private static C0526j m3185c(Context context) {
        if (f3328e == null) {
            synchronized (C0526j.class) {
                if (f3328e == null) {
                    SystemClock.uptimeMillis();
                    f3328e = new C0523g(context).m3180b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f3328e;
    }

    /* renamed from: c */
    private boolean m3186c() {
        return m3187c("android.permission.WRITE_SETTINGS");
    }

    /* renamed from: c */
    private boolean m3187c(String str) {
        return this.f3329b.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    /* renamed from: d */
    private C0526j m3188d() {
        String b = m3182b("com.baidu.deviceid");
        String b2 = m3182b("bd_setting_i");
        if (TextUtils.isEmpty(b2)) {
            b2 = m3194h(BuildConfig.FLAVOR);
            if (!TextUtils.isEmpty(b2)) {
                m3176a("bd_setting_i", b2);
            }
        }
        if (TextUtils.isEmpty(b)) {
            String b3 = m3181b(this.f3329b);
            StringBuilder sb = new StringBuilder();
            sb.append("com.baidu");
            sb.append(b2);
            sb.append(b3);
            b = m3182b(C0488c.m3013a(sb.toString().getBytes(), true));
        }
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        C0526j jVar = new C0526j(null);
        jVar.f3337a = b;
        jVar.f3338b = b2;
        return jVar;
    }

    /* renamed from: d */
    private C0526j m3189d(String str) {
        boolean z;
        String str2;
        boolean z2 = VERSION.SDK_INT < 23;
        if (z2 && TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = BuildConfig.FLAVOR;
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (file.exists()) {
            z = false;
        } else {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            z = true;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\r\n");
            }
            bufferedReader.close();
            String[] split = new String(C0434a.m2793b(f3327a, f3327a, C0461b.m2891a(sb.toString().getBytes()))).split("=");
            if (split != null && split.length == 2) {
                if (z2 && str.equals(split[0])) {
                    str2 = split[1];
                } else if (!z2) {
                    if (TextUtils.isEmpty(str)) {
                        str = split[1];
                    }
                    str2 = split[1];
                }
                str3 = str2;
            }
            if (!z) {
                m3183b(str, str3);
            }
        } catch (FileNotFoundException | IOException | Exception unused) {
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        C0526j jVar = new C0526j(null);
        jVar.f3337a = str3;
        jVar.f3338b = str;
        return jVar;
    }

    /* renamed from: e */
    private C0526j m3190e() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            String a = m3170a(file);
            if (!TextUtils.isEmpty(a)) {
                try {
                    return C0526j.m3197a(new String(C0434a.m2793b(f3327a, f3327a, C0461b.m2891a(a.getBytes()))));
                } catch (Exception e) {
                    C0029a.m806a(e);
                }
            }
        }
        return null;
    }

    /* renamed from: e */
    private static String m3191e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return C0461b.m2890a(C0434a.m2792a(f3327a, f3327a, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e) {
            m3184b(e);
            return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: f */
    private static String m3192f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(C0434a.m2793b(f3327a, f3327a, C0461b.m2891a(str.getBytes())));
        } catch (Exception e) {
            m3184b((Throwable) e);
            return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: g */
    private static void m3193g(String str) {
        File file;
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid2");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    StringBuilder sb = new StringBuilder();
                    sb.append(name);
                    sb.append(random.nextInt());
                    sb.append(".tmp");
                    file = new File(parentFile, sb.toString());
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    /* renamed from: h */
    private String m3194h(String str) {
        String str2 = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f3329b.getSystemService("phone");
            if (telephonyManager != null) {
                str2 = telephonyManager.getDeviceId();
            }
        } catch (Exception e) {
            Log.e("DeviceId", "Read IMEI failed", e);
        }
        String i = m3195i(str2);
        return TextUtils.isEmpty(i) ? str : i;
    }

    /* renamed from: i */
    private static String m3195i(String str) {
        return (str == null || !str.contains(":")) ? str : BuildConfig.FLAVOR;
    }
}
