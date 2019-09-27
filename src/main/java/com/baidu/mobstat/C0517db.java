package com.baidu.mobstat;

import android.net.LocalServerSocket;
import java.io.IOException;

/* renamed from: com.baidu.mobstat.db */
public final class C0517db {

    /* renamed from: a */
    private LocalServerSocket f3322a;

    /* renamed from: a */
    public final synchronized boolean mo3381a() {
        boolean z;
        try {
            if (this.f3322a == null) {
                this.f3322a = new LocalServerSocket("com.baidu.mobstat.bplus");
                z = true;
            }
        } catch (IOException unused) {
        }
        z = false;
        return z;
    }

    /* renamed from: b */
    public final synchronized void mo3382b() {
        if (this.f3322a != null) {
            try {
                this.f3322a.close();
                this.f3322a = null;
            } catch (IOException unused) {
            }
        }
    }
}
