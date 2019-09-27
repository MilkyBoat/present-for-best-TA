package com.android.cglib.p008dx;

import com.android.cglib.p008dx.p015c.p017b.C0249p;
import com.android.cglib.p008dx.p015c.p017b.C0251r;
import com.android.cglib.p008dx.p015c.p019d.C0285e;

/* renamed from: com.android.cglib.dx.Comparison */
public enum Comparison {
    LT {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1793c(eVar);
        }
    },
    LE {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1801f(eVar);
        }
    },
    EQ {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1785a(eVar);
        }
    },
    GE {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1796d(eVar);
        }
    },
    GT {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1799e(eVar);
        }
    },
    NE {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1790b(eVar);
        }
    };

    /* access modifiers changed from: 0000 */
    public abstract C0249p rop(C0285e eVar);
}
