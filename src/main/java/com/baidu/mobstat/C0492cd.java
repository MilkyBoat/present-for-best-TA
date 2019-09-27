package com.baidu.mobstat;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.baidu.mobstat.cd */
class C0492cd implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ C0491cc f3249a;

    C0492cd(C0491cc ccVar) {
        this.f3249a = ccVar;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(Config.PREFIX_SEND_DATA);
    }
}
