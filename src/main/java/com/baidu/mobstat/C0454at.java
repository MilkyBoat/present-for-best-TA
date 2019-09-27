package com.baidu.mobstat;

import android.content.Context;
import android.content.Intent;
import com.baidu.bottom.service.BottomReceiver;

/* renamed from: com.baidu.mobstat.at */
public class C0454at extends Thread {

    /* renamed from: a */
    final /* synthetic */ Context f3094a;

    /* renamed from: b */
    final /* synthetic */ Intent f3095b;

    /* renamed from: c */
    final /* synthetic */ C0517db f3096c;

    /* renamed from: d */
    final /* synthetic */ BottomReceiver f3097d;

    public C0454at(BottomReceiver bottomReceiver, Context context, Intent intent, C0517db dbVar) {
        this.f3097d = bottomReceiver;
        this.f3094a = context;
        this.f3095b = intent;
        this.f3096c = dbVar;
    }

    public void run() {
        try {
            this.f3097d.m2764b(this.f3094a, this.f3095b);
            this.f3097d.m2762a(this.f3094a, this.f3095b);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - BottomReceiver.f3048b < 30000) {
                C0465bd.m2909a("No need to handle receiver due to time strategy");
                this.f3096c.mo3382b();
                BottomReceiver.f3047a = null;
                return;
            }
            BottomReceiver.f3048b = currentTimeMillis;
            C0449ao.RECEIVER.mo3212a(this.f3094a);
            this.f3096c.mo3382b();
            BottomReceiver.f3047a = null;
        } catch (Throwable th) {
            this.f3096c.mo3382b();
            BottomReceiver.f3047a = null;
            throw th;
        }
    }
}
