package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.baidu.mobstat.m */
class C0529m {

    /* renamed from: a */
    static C0529m f3340a = new C0529m();

    C0529m() {
    }

    /* renamed from: a */
    public synchronized void mo3389a(Context context) {
        String l = C0518dc.m3154l(context);
        if (!TextUtils.isEmpty(l)) {
            C0541y.AP_LIST.mo3407a(System.currentTimeMillis(), l);
        }
    }
}
