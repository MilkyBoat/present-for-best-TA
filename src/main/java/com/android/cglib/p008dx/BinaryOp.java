package com.android.cglib.p008dx;

import com.android.cglib.p008dx.p015c.p017b.C0249p;
import com.android.cglib.p008dx.p015c.p017b.C0251r;
import com.android.cglib.p008dx.p015c.p019d.C0285e;

/* renamed from: com.android.cglib.dx.BinaryOp */
public enum BinaryOp {
    ADD {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1803g(eVar);
        }
    },
    SUBTRACT {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1805h(eVar);
        }
    },
    MULTIPLY {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1807i(eVar);
        }
    },
    DIVIDE {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1809j(eVar);
        }
    },
    REMAINDER {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1811k(eVar);
        }
    },
    AND {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1813l(eVar);
        }
    },
    OR {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1815m(eVar);
        }
    },
    XOR {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1817n(eVar);
        }
    },
    SHIFT_LEFT {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1819o(eVar);
        }
    },
    SHIFT_RIGHT {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1821p(eVar);
        }
    },
    UNSIGNED_SHIFT_RIGHT {
        /* access modifiers changed from: 0000 */
        public C0249p rop(C0285e eVar) {
            return C0251r.m1823q(eVar);
        }
    };

    /* access modifiers changed from: 0000 */
    public abstract C0249p rop(C0285e eVar);
}
