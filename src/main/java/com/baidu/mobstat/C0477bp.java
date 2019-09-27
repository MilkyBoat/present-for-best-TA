package com.baidu.mobstat;

/* renamed from: com.baidu.mobstat.bp */
class C0477bp implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f3178a;

    /* renamed from: b */
    final /* synthetic */ String f3179b;

    /* renamed from: c */
    final /* synthetic */ String f3180c;

    /* renamed from: d */
    final /* synthetic */ C0474bm f3181d;

    C0477bp(C0474bm bmVar, long j, String str, String str2) {
        this.f3181d = bmVar;
        this.f3178a = j;
        this.f3179b = str;
        this.f3180c = str2;
    }

    public void run() {
        C0483bv.m2981a().mo3321d();
        C0480bs bsVar = new C0480bs();
        bsVar.f3196c = this.f3178a;
        bsVar.f3194a = this.f3179b;
        bsVar.f3195b = this.f3180c;
        String a = this.f3181d.mo3298a(this.f3179b, this.f3180c);
        if (this.f3181d.f3160a.get(a) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EventStat: event_id[");
            sb.append(this.f3179b);
            sb.append("] with label[");
            sb.append(this.f3180c);
            sb.append("] is duplicated, older is removed");
            C0514cz.m3114b(sb.toString());
        }
        this.f3181d.f3160a.put(a, bsVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("put a keyword[");
        sb2.append(a);
        sb2.append("] into durationlist");
        C0514cz.m3110a(sb2.toString());
    }
}
