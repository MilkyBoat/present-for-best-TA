package com.android.cglib.p008dx;

import com.android.cglib.p008dx.p015c.p017b.C0230b;
import com.android.cglib.p008dx.p015c.p017b.C0235f;
import com.android.cglib.p008dx.p015c.p017b.C0238g;
import com.android.cglib.p008dx.p020d.C0297k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.android.cglib.dx.Label */
public final class Label {

    /* renamed from: a */
    final List<C0235f> f839a = new ArrayList();

    /* renamed from: b */
    Code f840b;

    /* renamed from: c */
    boolean f841c = false;

    /* renamed from: d */
    List<Label> f842d = Collections.emptyList();

    /* renamed from: e */
    Label f843e;

    /* renamed from: f */
    Label f844f;

    /* renamed from: g */
    int f845g = -1;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo1162a() {
        return this.f839a.isEmpty();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo1163b() {
        for (int i = 0; i < this.f842d.size(); i++) {
            while (((Label) this.f842d.get(i)).mo1162a()) {
                this.f842d.set(i, ((Label) this.f842d.get(i)).f843e);
            }
        }
        while (this.f843e != null && this.f843e.mo1162a()) {
            this.f843e = this.f843e.f843e;
        }
        while (this.f844f != null && this.f844f.mo1162a()) {
            this.f844f = this.f844f.f843e;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C0230b mo1164c() {
        C0238g gVar = new C0238g(this.f839a.size());
        for (int i = 0; i < this.f839a.size(); i++) {
            gVar.mo1572a(i, (C0235f) this.f839a.get(i));
        }
        gVar.mo1799e();
        int i2 = -1;
        C0297k kVar = new C0297k();
        for (Label label : this.f842d) {
            kVar.mo1788b(label.f845g);
        }
        if (this.f843e != null) {
            i2 = this.f843e.f845g;
            kVar.mo1788b(i2);
        }
        if (this.f844f != null) {
            kVar.mo1788b(this.f844f.f845g);
        }
        kVar.mo1799e();
        return new C0230b(this.f845g, gVar, kVar, i2);
    }
}
