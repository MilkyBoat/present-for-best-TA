package com.baidu.mobstat;

import android.content.Context;

public class GetReverse {

    /* renamed from: a */
    private static ICooperService f3073a;

    private GetReverse() {
    }

    public static ICooperService getCooperService(Context context) {
        if (f3073a == null) {
            f3073a = CooperService.m2766a();
        }
        return f3073a;
    }
}
