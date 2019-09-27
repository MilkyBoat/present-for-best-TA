package com.baidu.mobstat;

import android.content.Context;
import android.content.Intent;

/* 'enum' access flag removed */
/* renamed from: com.baidu.mobstat.ap */
final class C0450ap extends C0449ao {
    C0450ap(String str, int i, int i2) {
        super(str, i, i2, null);
    }

    /* renamed from: a */
    public void mo3212a(Context context) {
        if (C0455au.m2841a(context).mo3220b(context)) {
            try {
                Intent intent = new Intent(context, Class.forName("com.baidu.bottom.service.BottomService"));
                intent.putExtra("SDK_PRODUCT_LY", "MS");
                context.startService(intent);
            } catch (Throwable th) {
                C0514cz.m3116b(th);
            }
        }
    }
}
