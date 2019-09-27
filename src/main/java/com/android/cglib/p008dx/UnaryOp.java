package com.android.cglib.p008dx;

import com.android.cglib.p008dx.p015c.p017b.C0249p;
import com.android.cglib.p008dx.p015c.p017b.C0251r;
import com.android.cglib.p008dx.p015c.p019d.C0284d;

/* renamed from: com.android.cglib.dx.UnaryOp */
public enum UnaryOp {
    NOT {
        /* access modifiers changed from: 0000 */
        public C0249p rop(TypeId<?> typeId) {
            return C0251r.m1802g((C0284d) typeId.f858b);
        }
    },
    NEGATE {
        /* access modifiers changed from: 0000 */
        public C0249p rop(TypeId<?> typeId) {
            return C0251r.m1800f((C0284d) typeId.f858b);
        }
    };

    /* access modifiers changed from: 0000 */
    public abstract C0249p rop(TypeId<?> typeId);
}
