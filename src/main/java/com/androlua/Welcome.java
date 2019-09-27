package com.androlua;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.TextView;
import com.luajava.LuaFunction;
import com.luajava.LuaState;
import com.luajava.LuaStateFactory;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Welcome extends Activity {

    /* renamed from: a */
    private boolean f2743a;

    /* renamed from: b */
    private LuaApplication f2744b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f2745c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f2746d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f2747e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f2748f;

    /* renamed from: g */
    private boolean f2749g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f2750h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f2751i;

    /* renamed from: j */
    private ArrayList<String> f2752j;

    @SuppressLint({"StaticFieldLeak"})
    private class UpdateTask extends AsyncTask<String, String, String> {
        private UpdateTask() {
        }

        /* renamed from: a */
        private void m2339a(long j, long j2) {
            LuaState newLuaState = LuaStateFactory.newLuaState();
            newLuaState.openLibs();
            try {
                if (newLuaState.LloadBuffer(LuaUtil.readAsset(Welcome.this, "update.lua"), "update") == 0 && newLuaState.pcall(0, 0, 0) == 0) {
                    LuaFunction function = newLuaState.getFunction("onUpdate");
                    if (function != null) {
                        function.call(Welcome.this.f2750h, Welcome.this.f2751i);
                    }
                }
            } catch (Exception e) {
                C0029a.m806a(e);
            }
            try {
                m2340a("assets", Welcome.this.f2746d);
                m2340a("lua", Welcome.this.f2745c);
            } catch (IOException e2) {
                m2341b(e2.getMessage());
            }
        }

        /* renamed from: a */
        private void m2340a(String str, String str2) {
            int length = str.length() + 1;
            ZipFile zipFile = new ZipFile(Welcome.this.getApplicationInfo().publicSourceDir);
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                String name = zipEntry.getName();
                if (name.indexOf(str) == 0) {
                    String substring = name.substring(length);
                    if (zipEntry.isDirectory()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append(File.separator);
                        sb.append(substring);
                        File file = new File(sb.toString());
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(File.separator);
                        sb2.append(substring);
                        String sb3 = sb2.toString();
                        File file2 = new File(sb3);
                        File parentFile = new File(sb3).getParentFile();
                        if (parentFile.exists() || parentFile.mkdirs()) {
                            try {
                                if (file2.exists() && zipEntry.getSize() == file2.length() && LuaUtil.getFileMD5(zipFile.getInputStream(zipEntry)).equals(LuaUtil.getFileMD5(file2))) {
                                }
                            } catch (NullPointerException unused) {
                            }
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str2);
                            sb4.append(File.separator);
                            sb4.append(substring);
                            FileOutputStream fileOutputStream = new FileOutputStream(sb4.toString());
                            InputStream inputStream = zipFile.getInputStream(zipEntry);
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.close();
                            inputStream.close();
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("create file ");
                            sb5.append(parentFile.getName());
                            sb5.append(" fail");
                            throw new RuntimeException(sb5.toString());
                        }
                    }
                }
            }
            zipFile.close();
        }

        /* renamed from: b */
        private void m2341b(String str) {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String[] strArr) {
            m2339a(Welcome.this.f2747e, Welcome.this.f2748f);
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(String str) {
            Welcome.this.startActivity();
        }
    }

    /* renamed from: a */
    private void m2333a(String str) {
        if (checkCallingOrSelfPermission(str) != 0) {
            this.f2752j.add(str);
        }
    }

    public boolean checkInfo() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            long j = packageInfo.lastUpdateTime;
            String str = packageInfo.versionName;
            SharedPreferences sharedPreferences = getSharedPreferences("appInfo", 0);
            String string = sharedPreferences.getString("versionName", BuildConfig.FLAVOR);
            if (!str.equals(string)) {
                Editor edit = sharedPreferences.edit();
                edit.putString("versionName", str);
                edit.apply();
                this.f2749g = true;
                this.f2750h = str;
                this.f2751i = string;
            }
            long j2 = sharedPreferences.getLong("lastUpdateTime", 0);
            if (j2 != j) {
                Editor edit2 = sharedPreferences.edit();
                edit2.putLong("lastUpdateTime", j);
                edit2.apply();
                this.f2743a = true;
                this.f2747e = j;
                this.f2748f = j2;
                return true;
            }
        } catch (NameNotFoundException e) {
            C0029a.m806a(e);
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TextView textView = new TextView(this);
        textView.setText(new String("Powered by AndoLua+"));
        textView.setTextColor(-7829368);
        textView.setGravity(48);
        this.f2744b = (LuaApplication) getApplication();
        this.f2745c = this.f2744b.f2379d;
        this.f2746d = this.f2744b.f2376a;
        try {
            if (new File(this.f2744b.getLuaPath("setup.png")).exists()) {
                getWindow().setBackgroundDrawable(new LuaBitmapDrawable(this.f2744b, this.f2744b.getLuaPath("setup.png"), getResources().getDrawable(C0364R.drawable.welcome)));
            }
        } catch (Exception e) {
            C0029a.m806a(e);
        }
        if (checkInfo()) {
            if (VERSION.SDK_INT >= 23) {
                try {
                    this.f2752j = new ArrayList<>();
                    for (String a : getPackageManager().getPackageInfo(getPackageName(), 4096).requestedPermissions) {
                        try {
                            m2333a(a);
                        } catch (Exception e2) {
                            C0029a.m806a(e2);
                        }
                    }
                    if (!this.f2752j.isEmpty()) {
                        String[] strArr = new String[this.f2752j.size()];
                        this.f2752j.toArray(strArr);
                        requestPermissions(strArr, 0);
                        return;
                    }
                } catch (Exception e3) {
                    C0029a.m806a(e3);
                }
            }
            new UpdateTask().execute(new String[0]);
            return;
        }
        startActivity();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        new UpdateTask().execute(new String[0]);
    }

    public void startActivity() {
        Intent intent = new Intent(this, Main.class);
        if (this.f2749g) {
            intent.putExtra("isVersionChanged", this.f2749g);
            intent.putExtra("newVersionName", this.f2750h);
            intent.putExtra("oldVersionName", this.f2751i);
        }
        startActivity(intent);
        finish();
    }
}
