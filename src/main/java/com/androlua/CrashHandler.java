package com.androlua;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CrashHandler implements UncaughtExceptionHandler {
    public static final String TAG = "CrashHandler";

    /* renamed from: b */
    private static CrashHandler f2188b = new CrashHandler();

    /* renamed from: a */
    private UncaughtExceptionHandler f2189a;

    /* renamed from: c */
    private Context f2190c;

    /* renamed from: d */
    private Map<String, String> f2191d = new LinkedHashMap();

    /* renamed from: e */
    private DateFormat f2192e = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    private CrashHandler() {
    }

    /* renamed from: a */
    private boolean m2102a(Throwable th) {
        if (th == null) {
            return false;
        }
        collectDeviceInfo(this.f2190c);
        m2103b(th);
        return true;
    }

    /* renamed from: b */
    private String m2103b(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : this.f2191d.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("=");
            sb.append(str2);
            sb.append("\n");
            stringBuffer.append(sb.toString());
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        do {
            C0029a.m808a(th, printWriter);
            th = th.getCause();
        } while (th != null);
        printWriter.close();
        stringBuffer.append(stringWriter.toString());
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String format = this.f2192e.format(new Date());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("crash-");
            sb2.append(format);
            sb2.append("-");
            sb2.append(currentTimeMillis);
            sb2.append(".log");
            String sb3 = sb2.toString();
            if (Environment.getExternalStorageState().equals("mounted")) {
                String str3 = "/sdcard/androlua/crash/";
                File file = new File(str3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str3);
                sb4.append(sb3);
                FileOutputStream fileOutputStream = new FileOutputStream(sb4.toString());
                fileOutputStream.write(stringBuffer.toString().getBytes());
                Log.e("crash", stringBuffer.toString());
                fileOutputStream.close();
            }
            return sb3;
        } catch (Exception e) {
            Log.e(TAG, "an error occured while writing file...", e);
            return null;
        }
    }

    public static CrashHandler getInstance() {
        return f2188b;
    }

    public void collectDeviceInfo(Context context) {
        Field[] declaredFields;
        Field[] declaredFields2;
        Map<String, String> map;
        String name;
        String obj;
        Map<String, String> map2;
        String name2;
        String obj2;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName == null ? "null" : packageInfo.versionName;
                StringBuilder sb = new StringBuilder();
                sb.append(packageInfo.versionCode);
                sb.append(BuildConfig.FLAVOR);
                String sb2 = sb.toString();
                this.f2191d.put("versionName", str);
                this.f2191d.put("versionCode", sb2);
            }
        } catch (NameNotFoundException e) {
            Log.e(TAG, "an error occured when collect package info", e);
        }
        for (Field field : Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object obj3 = field.get(null);
                if (obj3 instanceof String[]) {
                    map2 = this.f2191d;
                    name2 = field.getName();
                    obj2 = Arrays.toString((String[]) obj3);
                } else {
                    map2 = this.f2191d;
                    name2 = field.getName();
                    obj2 = obj3.toString();
                }
                map2.put(name2, obj2);
                String str2 = TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(field.getName());
                sb3.append(" : ");
                sb3.append(field.get(null));
                Log.d(str2, sb3.toString());
            } catch (Exception e2) {
                Log.e(TAG, "an error occured when collect crash info", e2);
            }
        }
        for (Field field2 : VERSION.class.getDeclaredFields()) {
            try {
                field2.setAccessible(true);
                Object obj4 = field2.get(null);
                if (obj4 instanceof String[]) {
                    map = this.f2191d;
                    name = field2.getName();
                    obj = Arrays.toString((String[]) obj4);
                } else {
                    map = this.f2191d;
                    name = field2.getName();
                    obj = obj4.toString();
                }
                map.put(name, obj);
                String str3 = TAG;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(field2.getName());
                sb4.append(" : ");
                sb4.append(field2.get(null));
                Log.d(str3, sb4.toString());
            } catch (Exception e3) {
                Log.e(TAG, "an error occured when collect crash info", e3);
            }
        }
    }

    public void init(Context context) {
        this.f2190c = context;
        this.f2189a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (!m2102a(th) && this.f2189a != null) {
            this.f2189a.uncaughtException(thread, th);
        }
    }
}
