package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p020d.C0286a;
import com.androlua.BuildConfig;
import java.util.HashMap;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.a.b.al */
public final class C0141al {

    /* renamed from: a */
    private final HashMap<String, C0142a> f1272a = new HashMap<>(50);

    /* renamed from: com.android.cglib.dx.a.b.al$a */
    private static class C0142a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f1273a;

        /* renamed from: b */
        private int f1274b = 1;

        /* renamed from: c */
        private int f1275c;

        /* renamed from: d */
        private int f1276d;

        /* renamed from: e */
        private int f1277e;

        public C0142a(C0177x xVar, String str) {
            int b_ = xVar.mo1349b_();
            this.f1273a = str;
            this.f1275c = b_;
            this.f1276d = b_;
            this.f1277e = b_;
        }

        /* renamed from: a */
        public String mo1405a() {
            String sb;
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("  ");
            sb3.append(this.f1273a);
            sb3.append(": ");
            sb3.append(this.f1274b);
            sb3.append(" item");
            sb3.append(this.f1274b == 1 ? BuildConfig.FLAVOR : "s");
            sb3.append("; ");
            sb3.append(this.f1275c);
            sb3.append(" bytes total\n");
            sb2.append(sb3.toString());
            if (this.f1277e == this.f1276d) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("    ");
                sb4.append(this.f1277e);
                sb4.append(" bytes/item\n");
                sb = sb4.toString();
            } else {
                int i = this.f1275c / this.f1274b;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("    ");
                sb5.append(this.f1277e);
                sb5.append("..");
                sb5.append(this.f1276d);
                sb5.append(" bytes/item; average ");
                sb5.append(i);
                sb5.append("\n");
                sb = sb5.toString();
            }
            sb2.append(sb);
            return sb2.toString();
        }

        /* renamed from: a */
        public void mo1406a(C0177x xVar) {
            int b_ = xVar.mo1349b_();
            this.f1274b++;
            this.f1275c += b_;
            if (b_ > this.f1276d) {
                this.f1276d = b_;
            }
            if (b_ < this.f1277e) {
                this.f1277e = b_;
            }
        }

        /* renamed from: a */
        public void mo1407a(C0286a aVar) {
            aVar.mo1740a(mo1405a());
        }
    }

    /* renamed from: a */
    public void mo1402a(C0140ak akVar) {
        for (C0177x a : akVar.mo1362a()) {
            mo1403a(a);
        }
    }

    /* renamed from: a */
    public void mo1403a(C0177x xVar) {
        String i = xVar.mo1515i();
        C0142a aVar = (C0142a) this.f1272a.get(i);
        if (aVar == null) {
            this.f1272a.put(i, new C0142a(xVar, i));
        } else {
            aVar.mo1406a(xVar);
        }
    }

    /* renamed from: a */
    public final void mo1404a(C0286a aVar) {
        if (this.f1272a.size() != 0) {
            aVar.mo1739a(0, "\nstatistics:\n");
            TreeMap treeMap = new TreeMap();
            for (C0142a aVar2 : this.f1272a.values()) {
                treeMap.put(aVar2.f1273a, aVar2);
            }
            for (C0142a a : treeMap.values()) {
                a.mo1407a(aVar);
            }
        }
    }
}
