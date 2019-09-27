package com.androlua;

import android.app.Application;
import android.content.Context;
import android.content.FileProvider;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.luajava.LuaState;
import com.luajava.LuaTable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LuaApplication extends Application implements LuaContext {

    /* renamed from: h */
    private static LuaApplication f2374h;

    /* renamed from: i */
    private static HashMap<String, Object> f2375i = new HashMap<>();

    /* renamed from: a */
    protected String f2376a;

    /* renamed from: b */
    protected String f2377b;

    /* renamed from: c */
    protected String f2378c;

    /* renamed from: d */
    protected String f2379d;

    /* renamed from: e */
    protected String f2380e;

    /* renamed from: f */
    protected String f2381f;

    /* renamed from: g */
    protected String f2382g;

    /* renamed from: j */
    private SharedPreferences f2383j;

    /* renamed from: a */
    private static SharedPreferences m2176a(Context context) {
        if (VERSION.SDK_INT < 24) {
            return PreferenceManager.getDefaultSharedPreferences(context);
        }
        Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        return createDeviceProtectedStorageContext != null ? PreferenceManager.getDefaultSharedPreferences(createDeviceProtectedStorageContext) : PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static LuaApplication getInstance() {
        return f2374h;
    }

    public void call(String str, Object[] objArr) {
    }

    public Object doFile(String str, Object[] objArr) {
        return null;
    }

    public Object get(String str) {
        return f2375i.get(str);
    }

    public ArrayList<ClassLoader> getClassLoaders() {
        return null;
    }

    public Context getContext() {
        return this;
    }

    public Map getGlobalData() {
        return f2375i;
    }

    public int getHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    public String getLibDir() {
        return this.f2378c;
    }

    public String getLocalDir() {
        return this.f2376a;
    }

    public String getLuaCpath() {
        return this.f2380e;
    }

    public String getLuaDir() {
        return this.f2376a;
    }

    public String getLuaDir(String str) {
        return this.f2376a;
    }

    public String getLuaExtDir() {
        return this.f2382g;
    }

    public String getLuaExtDir(String str) {
        File file = new File(getLuaExtDir(), str);
        return (file.exists() || file.mkdirs()) ? file.getAbsolutePath() : file.getAbsolutePath();
    }

    public String getLuaExtPath(String str) {
        return new File(getLuaExtDir(), str).getAbsolutePath();
    }

    public String getLuaExtPath(String str, String str2) {
        return new File(getLuaExtDir(str), str2).getAbsolutePath();
    }

    public String getLuaLpath() {
        return this.f2381f;
    }

    public String getLuaPath() {
        return null;
    }

    public String getLuaPath(String str) {
        return new File(getLuaDir(), str).getAbsolutePath();
    }

    public String getLuaPath(String str, String str2) {
        return new File(getLuaDir(str), str2).getAbsolutePath();
    }

    public LuaState getLuaState() {
        return null;
    }

    public String getMdDir() {
        return this.f2379d;
    }

    public String getOdexDir() {
        return this.f2377b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
        if (r1.equals("file") != false) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getPathFromUri(android.net.Uri r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x0062
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            java.lang.String r1 = r7.getPackageName()
            r2 = 0
            r3[r2] = r1
            java.lang.String r1 = r8.getScheme()
            r4 = -1
            int r5 = r1.hashCode()
            r6 = 3143036(0x2ff57c, float:4.404332E-39)
            if (r5 == r6) goto L_0x002a
            r0 = 951530617(0x38b73479, float:8.735894E-5)
            if (r5 == r0) goto L_0x0020
            goto L_0x0033
        L_0x0020:
            java.lang.String r0 = "content"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 0
            goto L_0x0034
        L_0x002a:
            java.lang.String r2 = "file"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r0 = -1
        L_0x0034:
            switch(r0) {
                case 0: goto L_0x003d;
                case 1: goto L_0x0038;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x0062
        L_0x0038:
            java.lang.String r8 = r8.getPath()
            return r8
        L_0x003d:
            android.content.ContentResolver r1 = r7.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r8
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            if (r8 == 0) goto L_0x0062
            java.lang.String r0 = r7.getPackageName()
            int r0 = r8.getColumnIndexOrThrow(r0)
            if (r0 >= 0) goto L_0x0056
            goto L_0x0062
        L_0x0056:
            java.lang.String r0 = r8.getString(r0)
            r8.moveToFirst()
            r8.close()
            r8 = r0
            return r8
        L_0x0062:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaApplication.getPathFromUri(android.net.Uri):java.lang.String");
    }

    public Object getSharedData(String str) {
        return this.f2383j.getAll().get(str);
    }

    public Object getSharedData(String str, Object obj) {
        Object obj2 = this.f2383j.getAll().get(str);
        return obj2 == null ? obj : obj2;
    }

    public Uri getUriForFile(File file) {
        return FileProvider.getUriForFile(this, getPackageName(), file);
    }

    public Uri getUriForPath(String str) {
        return FileProvider.getUriForFile(this, getPackageName(), new File(str));
    }

    public int getWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate() {
        /*
            r7 = this;
            super.onCreate()
            f2374h = r7
            com.androlua.CrashHandler r0 = com.androlua.CrashHandler.getInstance()
            android.content.Context r1 = r7.getApplicationContext()
            r0.init(r1)
            android.content.SharedPreferences r0 = m2176a(r7)
            r7.f2383j = r0
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 == 0) goto L_0x003f
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "/AndroLua"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
        L_0x003c:
            r7.f2382g = r0
            goto L_0x0084
        L_0x003f:
            java.io.File r0 = new java.io.File
            java.lang.String r2 = "/storage"
            r0.<init>(r2)
            java.io.File[] r0 = r0.listFiles()
            int r2 = r0.length
            r3 = 0
        L_0x004c:
            if (r3 >= r2) goto L_0x0075
            r4 = r0[r3]
            java.lang.String[] r5 = r4.list()
            if (r5 != 0) goto L_0x0057
            goto L_0x0072
        L_0x0057:
            int r5 = r5.length
            r6 = 5
            if (r5 <= r6) goto L_0x0072
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r4 = r4.getAbsolutePath()
            r5.append(r4)
            java.lang.String r4 = "/AndroLua"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r7.f2382g = r4
        L_0x0072:
            int r3 = r3 + 1
            goto L_0x004c
        L_0x0075:
            java.lang.String r0 = r7.f2382g
            if (r0 != 0) goto L_0x0084
            java.lang.String r0 = "AndroLua"
            java.io.File r0 = r7.getDir(r0, r1)
            java.lang.String r0 = r0.getAbsolutePath()
            goto L_0x003c
        L_0x0084:
            java.io.File r0 = new java.io.File
            java.lang.String r2 = r7.f2382g
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x0094
            r0.mkdirs()
        L_0x0094:
            java.io.File r0 = r7.getFilesDir()
            java.lang.String r0 = r0.getAbsolutePath()
            r7.f2376a = r0
            java.lang.String r0 = "odex"
            java.io.File r0 = r7.getDir(r0, r1)
            java.lang.String r0 = r0.getAbsolutePath()
            r7.f2377b = r0
            java.lang.String r0 = "lib"
            java.io.File r0 = r7.getDir(r0, r1)
            java.lang.String r0 = r0.getAbsolutePath()
            r7.f2378c = r0
            java.lang.String r0 = "lua"
            java.io.File r0 = r7.getDir(r0, r1)
            java.lang.String r0 = r0.getAbsolutePath()
            r7.f2379d = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.pm.ApplicationInfo r1 = r7.getApplicationInfo()
            java.lang.String r1 = r1.nativeLibraryDir
            r0.append(r1)
            java.lang.String r1 = "/lib?.so;"
            r0.append(r1)
            java.lang.String r1 = r7.f2378c
            r0.append(r1)
            java.lang.String r1 = "/lib?.so"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.f2380e = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r7.f2379d
            r0.append(r1)
            java.lang.String r1 = "/?.lua;"
            r0.append(r1)
            java.lang.String r1 = r7.f2379d
            r0.append(r1)
            java.lang.String r1 = "/lua/?.lua;"
            r0.append(r1)
            java.lang.String r1 = r7.f2379d
            r0.append(r1)
            java.lang.String r1 = "/?/init.lua;"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.f2381f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaApplication.onCreate():void");
    }

    public void regGc(LuaGcable luaGcable) {
    }

    public void sendError(String str, Exception exc) {
    }

    public void sendMsg(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public void set(String str, Object obj) {
        f2375i.put(str, obj);
    }

    public void setLuaExtDir(String str) {
        File[] listFiles;
        String absolutePath;
        if (Environment.getExternalStorageState().equals("mounted")) {
            absolutePath = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), str).getAbsolutePath();
        } else {
            for (File file : new File("/storage").listFiles()) {
                String[] list = file.list();
                if (list != null && list.length > 5) {
                    this.f2382g = new File(file, str).getAbsolutePath();
                }
            }
            if (this.f2382g == null) {
                absolutePath = getDir(str, 0).getAbsolutePath();
            } else {
                return;
            }
        }
        this.f2382g = absolutePath;
    }

    public boolean setSharedData(String str, Object obj) {
        Set set;
        Editor edit = this.f2383j.edit();
        if (obj == null) {
            edit.remove(str);
        } else if (obj instanceof String) {
            edit.putString(str, obj.toString());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else {
            if (obj instanceof Set) {
                set = (Set) obj;
            } else if (obj instanceof LuaTable) {
                set = (HashSet) ((LuaTable) obj).values();
            } else if (!(obj instanceof Boolean)) {
                return false;
            } else {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            }
            edit.putStringSet(str, set);
        }
        edit.apply();
        return true;
    }
}
