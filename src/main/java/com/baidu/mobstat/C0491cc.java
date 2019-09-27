package com.baidu.mobstat;

import android.content.Context;
import java.io.File;
import java.util.Arrays;

/* renamed from: com.baidu.mobstat.cc */
class C0491cc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f3247a;

    /* renamed from: b */
    final /* synthetic */ C0486by f3248b;

    C0491cc(C0486by byVar, Context context) {
        this.f3248b = byVar;
        this.f3247a = context;
    }

    public void run() {
        try {
            File filesDir = this.f3247a.getFilesDir();
            if (filesDir != null && filesDir.exists()) {
                String[] list = filesDir.list(new C0492cd(this));
                if (list != null && list.length != 0) {
                    try {
                        Arrays.sort(list, new C0493ce(this));
                    } catch (Exception e) {
                        C0514cz.m3116b((Throwable) e);
                    }
                    int i = 0;
                    for (String str : list) {
                        if (this.f3248b.m3002b(this.f3247a, C0507cs.m3082a(this.f3247a, str))) {
                            C0507cs.m3088b(this.f3247a, str);
                            i = 0;
                        } else {
                            i++;
                            if (i >= 5) {
                                return;
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            C0514cz.m3116b((Throwable) e2);
        }
    }
}
