package com.baidu.mobstat;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* renamed from: com.baidu.mobstat.dd */
final class C0519dd implements Comparator<ScanResult> {
    C0519dd() {
    }

    /* renamed from: a */
    public int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
