package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/* renamed from: com.baidu.mobstat.bk */
class C0472bk {

    /* renamed from: a */
    private SharedPreferences f3151a;

    /* renamed from: b */
    private SharedPreferences f3152b;

    C0472bk() {
    }

    /* renamed from: a */
    private SharedPreferences mo3271a(Context context) {
        if (this.f3151a == null) {
            this.f3151a = context.getSharedPreferences("__Baidu_Stat_SDK_SendRem", 0);
        }
        return this.f3151a;
    }

    /* renamed from: b */
    private SharedPreferences mo3275b(Context context) {
        if (this.f3152b == null) {
            this.f3152b = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return this.f3152b;
    }

    public boolean getBoolean(Context context, String str, boolean z) {
        return mo3271a(context).getBoolean(str, z);
    }

    public Float getFloatt(Context context, String str, int i) {
        return Float.valueOf(mo3271a(context).getFloat(str, (float) i));
    }

    public int getInt(Context context, String str, int i) {
        return mo3271a(context).getInt(str, i);
    }

    public long getLong(Context context, String str, long j) {
        return mo3271a(context).getLong(str, j);
    }

    public boolean getSharedBoolean(Context context, String str, boolean z) {
        return mo3275b(context).getBoolean(str, z);
    }

    public int getSharedInt(Context context, String str, int i) {
        return mo3275b(context).getInt(str, i);
    }

    public long getSharedLong(Context context, String str, long j) {
        return mo3275b(context).getLong(str, j);
    }

    public String getSharedString(Context context, String str, String str2) {
        return mo3275b(context).getString(str, str2);
    }

    public String getString(Context context, String str, String str2) {
        return mo3271a(context).getString(str, str2);
    }

    public void putBoolean(Context context, String str, boolean z) {
        mo3271a(context).edit().putBoolean(str, z).commit();
    }

    public void putFloat(Context context, String str, Float f) {
        mo3271a(context).edit().putFloat(str, f.floatValue()).commit();
    }

    public void putInt(Context context, String str, int i) {
        mo3271a(context).edit().putInt(str, i).commit();
    }

    public void putLong(Context context, String str, long j) {
        mo3271a(context).edit().putLong(str, j).commit();
    }

    public void putSharedBoolean(Context context, String str, boolean z) {
        mo3275b(context).edit().putBoolean(str, z).commit();
    }

    public void putSharedInt(Context context, String str, int i) {
        mo3275b(context).edit().putInt(str, i).commit();
    }

    public void putSharedLong(Context context, String str, long j) {
        mo3275b(context).edit().putLong(str, j).commit();
    }

    public void putSharedString(Context context, String str, String str2) {
        mo3275b(context).edit().putString(str, str2).commit();
    }

    public void putString(Context context, String str, String str2) {
        mo3271a(context).edit().putString(str, str2).commit();
    }

    public void removeShare(Context context, String str) {
        mo3275b(context).edit().remove(str).commit();
    }

    public void removeString(Context context, String str) {
        mo3271a(context).edit().remove(str).commit();
    }

    public boolean updateShareBoolean(Intent intent, Activity activity, String str) {
        return updateShareBoolean(intent, activity, str, true);
    }

    public boolean updateShareBoolean(Intent intent, Activity activity, String str, boolean z) {
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra(str, z);
            if (booleanExtra != getSharedBoolean(activity, str, z)) {
                putSharedBoolean(activity, str, booleanExtra);
                return true;
            }
        }
        return false;
    }

    public boolean updateShareInt(Intent intent, Activity activity, String str, int i) {
        if (intent != null) {
            int intExtra = intent.getIntExtra(str, i);
            if (intExtra != getSharedInt(activity, str, i)) {
                putSharedInt(activity, str, intExtra);
                return true;
            }
        }
        return false;
    }

    public boolean updateShareString(Intent intent, Activity activity, String str) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(str);
            if (stringExtra != null) {
                stringExtra = stringExtra.trim();
                if (stringExtra.length() == 0) {
                    stringExtra = null;
                }
            }
            if (!TextUtils.equals(stringExtra, getSharedString(activity, str, null))) {
                putSharedString(activity, str, stringExtra);
                return true;
            }
        }
        return false;
    }
}
