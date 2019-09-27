package com.baidu.mobstat;

import java.util.Comparator;

/* renamed from: com.baidu.mobstat.h */
class C0524h implements Comparator<C0525i> {

    /* renamed from: a */
    final /* synthetic */ C0523g f3332a;

    C0524h(C0523g gVar) {
        this.f3332a = gVar;
    }

    /* renamed from: a */
    public int compare(C0525i iVar, C0525i iVar2) {
        int i = iVar2.f3334b - iVar.f3334b;
        if (i == 0) {
            if (iVar.f3336d && iVar2.f3336d) {
                return 0;
            }
            if (iVar.f3336d) {
                return -1;
            }
            if (iVar2.f3336d) {
                return 1;
            }
        }
        return i;
    }
}
