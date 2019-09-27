package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.bq */
class C0478bq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f3182a;

    /* renamed from: b */
    final /* synthetic */ String f3183b;

    /* renamed from: c */
    final /* synthetic */ long f3184c;

    /* renamed from: d */
    final /* synthetic */ Context f3185d;

    /* renamed from: e */
    final /* synthetic */ ExtraInfo f3186e;

    /* renamed from: f */
    final /* synthetic */ C0474bm f3187f;

    C0478bq(C0474bm bmVar, String str, String str2, long j, Context context, ExtraInfo extraInfo) {
        this.f3187f = bmVar;
        this.f3182a = str;
        this.f3183b = str2;
        this.f3184c = j;
        this.f3185d = context;
        this.f3186e = extraInfo;
    }

    public void run() {
        C0483bv.m2981a().mo3321d();
        String a = this.f3187f.mo3298a(this.f3182a, this.f3183b);
        C0480bs bsVar = (C0480bs) this.f3187f.f3160a.get(a);
        if (bsVar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EventStat: event_id[");
            sb.append(this.f3182a);
            sb.append("] with label[");
            sb.append(this.f3183b);
            sb.append("] is not started or alread done.");
            C0514cz.m3114b(sb.toString());
        } else if (!this.f3182a.equals(bsVar.f3194a) || !this.f3183b.equals(bsVar.f3195b)) {
            C0514cz.m3110a("EventStat: Wrong Case, eventId/label pair not match");
        } else {
            this.f3187f.f3160a.remove(a);
            long j = this.f3184c - bsVar.f3196c;
            if (j <= 0) {
                C0514cz.m3110a("EventStat: Wrong Case, Duration must be positive");
            } else {
                this.f3187f.mo3299a(this.f3185d, this.f3182a, this.f3183b, 1, bsVar.f3196c, j, this.f3186e);
            }
        }
    }
}
