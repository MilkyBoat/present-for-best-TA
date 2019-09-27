package com.androlua;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import com.luajava.LuaException;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class LuaDexLoader {

    /* renamed from: a */
    private static HashMap<String, LuaDexClassLoader> f2448a = new HashMap<>();

    /* renamed from: b */
    private ArrayList<ClassLoader> f2449b = new ArrayList<>();

    /* renamed from: c */
    private HashMap<String, String> f2450c = new HashMap<>();

    /* renamed from: d */
    private LuaContext f2451d;

    /* renamed from: e */
    private String f2452e;

    /* renamed from: f */
    private AssetManager f2453f;

    /* renamed from: g */
    private LuaResources f2454g;

    /* renamed from: h */
    private Theme f2455h;

    /* renamed from: i */
    private String f2456i;

    public LuaDexLoader(LuaContext luaContext) {
        this.f2451d = luaContext;
        this.f2452e = luaContext.getLuaDir();
        this.f2456i = LuaApplication.getInstance().getOdexDir();
    }

    public AssetManager getAssets() {
        return this.f2453f;
    }

    public ArrayList<ClassLoader> getClassLoaders() {
        return this.f2449b;
    }

    public HashMap<String, String> getLibrarys() {
        return this.f2450c;
    }

    public Resources getResources() {
        return this.f2454g;
    }

    public Theme getTheme() {
        return this.f2455h;
    }

    public LuaDexClassLoader loadApp(String str) {
        try {
            LuaDexClassLoader luaDexClassLoader = (LuaDexClassLoader) f2448a.get(str);
            if (luaDexClassLoader == null) {
                ApplicationInfo applicationInfo = this.f2451d.getContext().getPackageManager().getPackageInfo(str, 0).applicationInfo;
                LuaDexClassLoader luaDexClassLoader2 = new LuaDexClassLoader(applicationInfo.publicSourceDir, LuaApplication.getInstance().getOdexDir(), applicationInfo.nativeLibraryDir, this.f2451d.getContext().getClassLoader());
                f2448a.put(str, luaDexClassLoader2);
                luaDexClassLoader = luaDexClassLoader2;
            }
            if (!this.f2449b.contains(luaDexClassLoader)) {
                this.f2449b.add(luaDexClassLoader);
            }
            return luaDexClassLoader;
        } catch (NameNotFoundException e) {
            C0029a.m806a(e);
            return null;
        }
    }

    public DexClassLoader loadDex(String str) {
        LuaDexClassLoader luaDexClassLoader;
        String str2;
        StringBuilder sb;
        String str3;
        LuaDexClassLoader luaDexClassLoader2 = (LuaDexClassLoader) f2448a.get(str);
        if (luaDexClassLoader2 == null) {
            luaDexClassLoader2 = loadApp(str);
        }
        if (luaDexClassLoader2 == null) {
            if (str.charAt(0) != '/') {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f2452e);
                sb2.append("/");
                sb2.append(str);
                str2 = sb2.toString();
            } else {
                str2 = str;
            }
            if (!new File(str2).exists()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(".dex");
                if (new File(sb3.toString()).exists()) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str3 = ".dex";
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str2);
                    sb4.append(".jar");
                    if (new File(sb4.toString()).exists()) {
                        sb = new StringBuilder();
                        sb.append(str2);
                        str3 = ".jar";
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str2);
                        sb5.append(" not found");
                        throw new LuaException(sb5.toString());
                    }
                }
                sb.append(str3);
                str2 = sb.toString();
            }
            String fileMD5 = LuaUtil.getFileMD5(str2);
            if (fileMD5 == null || !fileMD5.equals("0")) {
                str = fileMD5;
            }
            luaDexClassLoader = (LuaDexClassLoader) f2448a.get(str);
            if (luaDexClassLoader == null) {
                luaDexClassLoader = new LuaDexClassLoader(str2, this.f2456i, LuaApplication.getInstance().getApplicationInfo().nativeLibraryDir, this.f2451d.getContext().getClassLoader());
                f2448a.put(str, luaDexClassLoader);
            }
        } else {
            luaDexClassLoader = luaDexClassLoader2;
        }
        if (!this.f2449b.contains(luaDexClassLoader)) {
            this.f2449b.add(luaDexClassLoader);
            String dexPath = luaDexClassLoader.getDexPath();
            if (dexPath.endsWith(".jar")) {
                loadResources(dexPath);
            }
        }
        return luaDexClassLoader;
    }

    public void loadLib(String str) {
        int indexOf = str.indexOf(".");
        String substring = indexOf > 0 ? str.substring(0, indexOf) : str;
        if (substring.startsWith("lib")) {
            substring = substring.substring(3);
        }
        String absolutePath = this.f2451d.getContext().getDir(substring, 0).getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        sb.append(absolutePath);
        sb.append("/lib");
        sb.append(substring);
        sb.append(".so");
        String sb2 = sb.toString();
        if (!new File(sb2).exists()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f2452e);
            sb3.append("/libs/lib");
            sb3.append(substring);
            sb3.append(".so");
            if (!new File(sb3.toString()).exists()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("can not find lib ");
                sb4.append(str);
                throw new LuaException(sb4.toString());
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f2452e);
            sb5.append("/libs/lib");
            sb5.append(substring);
            sb5.append(".so");
            LuaUtil.copyFile(sb5.toString(), sb2);
        }
        this.f2450c.put(substring, sb2);
    }

    public void loadLibs() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2451d.getLuaDir());
        sb.append("/libs");
        File[] listFiles = new File(sb.toString()).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!file.isDirectory()) {
                    if (file.getAbsolutePath().endsWith(".so")) {
                        loadLib(file.getName());
                    } else {
                        loadDex(file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void loadResources(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            if (((Integer) assetManager.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{str})).intValue() != 0) {
                this.f2453f = assetManager;
                Resources resources = this.f2451d.getContext().getResources();
                this.f2454g = new LuaResources(this.f2453f, resources.getDisplayMetrics(), resources.getConfiguration());
                this.f2454g.setSuperResources(resources);
                this.f2455h = this.f2454g.newTheme();
                this.f2455h.setTo(this.f2451d.getContext().getTheme());
            }
        } catch (Exception e) {
            C0029a.m806a(e);
        }
    }
}
