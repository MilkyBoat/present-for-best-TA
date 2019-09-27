package com.baidu.mobstat;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.baidu.mobstat.an */
class C0448an implements Comparator<File> {

    /* renamed from: a */
    final /* synthetic */ C0446al f3087a;

    C0448an(C0446al alVar) {
        this.f3087a = alVar;
    }

    /* renamed from: a */
    public int compare(File file, File file2) {
        return (int) (file2.lastModified() - file.lastModified());
    }
}
