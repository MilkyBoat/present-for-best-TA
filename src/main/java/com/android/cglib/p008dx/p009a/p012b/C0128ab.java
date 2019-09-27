package com.android.cglib.p008dx.p009a.p012b;

import bsh.org.objectweb.asm.Constants;
import com.android.cglib.p008dx.p020d.C0292f;

/* renamed from: com.android.cglib.dx.a.b.ab */
public abstract class C0128ab extends C0149as {
    public C0128ab(String str, C0165l lVar) {
        super(str, lVar, 4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1352b() {
        if (mo1362a().size() > 65536) {
            String str = this instanceof C0131ae ? "methods" : "fields";
            StringBuilder sb = new StringBuilder();
            sb.append("Too many ");
            sb.append(str);
            sb.append(": ");
            sb.append(mo1362a().size());
            sb.append("; max is ");
            sb.append(Constants.ACC_SYNTHETIC);
            throw new C0292f(sb.toString());
        }
        int i = 0;
        for (C0127aa a : mo1362a()) {
            a.mo1511a(i);
            i++;
        }
    }
}
