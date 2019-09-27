package com.baidu.mobstat;

import android.system.ErrnoException;
import android.system.Os;

/* renamed from: com.baidu.mobstat.k */
class C0527k {
    /* renamed from: a */
    static boolean m3200a(String str, int i) {
        try {
            Os.chmod(str, i);
            return true;
        } catch (ErrnoException e) {
            C0523g.m3184b((Throwable) e);
            return false;
        }
    }
}
