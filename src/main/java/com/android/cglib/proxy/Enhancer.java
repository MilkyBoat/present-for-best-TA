package com.android.cglib.proxy;

import android.content.Context;
import bsh.org.objectweb.asm.Constants;
import com.android.cglib.p008dx.Code;
import com.android.cglib.p008dx.Comparison;
import com.android.cglib.p008dx.DexMaker;
import com.android.cglib.p008dx.FieldId;
import com.android.cglib.p008dx.Label;
import com.android.cglib.p008dx.Local;
import com.android.cglib.p008dx.MethodId;
import com.android.cglib.p008dx.TypeId;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Enhancer {

    /* renamed from: a */
    private Context f2181a;

    /* renamed from: b */
    private Class<?> f2182b;

    /* renamed from: c */
    private MethodInterceptor f2183c;

    /* renamed from: d */
    private MethodFilter f2184d;

    public Enhancer(Context context) {
        this.f2181a = context;
    }

    /* renamed from: a */
    private <S> void m2099a(DexMaker dexMaker, TypeId<?> typeId, TypeId<S> typeId2) {
        Method[] methods;
        TypeId typeId3;
        FieldId fieldId;
        Constructor[] constructorArr;
        TypeId typeId4;
        int i;
        DexMaker dexMaker2 = dexMaker;
        TypeId<S> typeId5 = typeId2;
        TypeId typeId6 = TypeId.get(MethodInterceptor.class);
        TypeId typeId7 = TypeId.get(MethodProxyExecuter.class);
        TypeId typeId8 = TypeId.get(Class.class);
        TypeId typeId9 = TypeId.get(Class[].class);
        TypeId typeId10 = TypeId.get(String.class);
        TypeId typeId11 = TypeId.get(Object.class);
        TypeId typeId12 = TypeId.get(Object[].class);
        FieldId field = typeId5.getField(typeId6, "methodInterceptor");
        dexMaker2.declare(field, 2, null);
        Constructor[] declaredConstructors = this.f2182b.getDeclaredConstructors();
        int length = declaredConstructors.length;
        TypeId typeId13 = typeId7;
        int i2 = 0;
        while (i2 < length) {
            FieldId fieldId2 = field;
            Constructor constructor = declaredConstructors[i2];
            if ((constructor.getModifiers() & 8) == 0 && (constructor.getModifiers() & 16) == 0) {
                typeId4 = typeId8;
                i = length;
                constructorArr = declaredConstructors;
                fieldId = fieldId2;
                typeId3 = typeId12;
                try {
                    m2100a(dexMaker2, typeId, typeId5, constructor, fieldId);
                } catch (Exception e) {
                    C0029a.m806a(e);
                }
            } else {
                i = length;
                constructorArr = declaredConstructors;
                typeId3 = typeId12;
                typeId4 = typeId8;
                fieldId = fieldId2;
            }
            i2++;
            length = i;
            typeId8 = typeId4;
            declaredConstructors = constructorArr;
            field = fieldId;
            typeId12 = typeId3;
        }
        FieldId fieldId3 = field;
        TypeId typeId14 = typeId12;
        TypeId typeId15 = typeId8;
        Code declare = dexMaker2.declare(typeId5.getMethod(TypeId.VOID, EnhancerInterface.SET_METHOD_INTERCEPTOR_ENHANCER, typeId6), 1);
        FieldId fieldId4 = fieldId3;
        declare.iput(fieldId4, declare.getThis(typeId5), declare.getParameter(0, typeId6));
        declare.returnVoid();
        Code declare2 = dexMaker2.declare(typeId5.getMethod(TypeId.OBJECT, EnhancerInterface.EXECUTE_SUPER_METHOD_ENHANCER, typeId10, typeId9, typeId12), 1);
        Local newLocal = declare2.newLocal(typeId11);
        TypeId typeId16 = typeId15;
        Local newLocal2 = declare2.newLocal(typeId16);
        Local local = declare2.getThis(typeId5);
        FieldId fieldId5 = fieldId4;
        declare2.invokeVirtual(typeId5.getMethod(typeId16, "getClass", new TypeId[0]), newLocal2, local, new Local[0]);
        declare2.invokeStatic(typeId13.getMethod(TypeId.OBJECT, MethodProxyExecuter.EXECUTE_METHOD, typeId16, typeId10, typeId9, typeId12, typeId11), newLocal, newLocal2, declare2.getParameter(0, typeId10), declare2.getParameter(1, typeId9), declare2.getParameter(2, typeId12), local);
        declare2.returnValue(newLocal);
        for (Method method : this.f2182b.getMethods()) {
            String name = method.getName();
            if (!name.contains(Const.SUBCLASS_SUFFIX) && !name.contains(Const.SUBCLASS_INVOKE_SUPER_SUFFIX) && (method.getModifiers() & 8) == 0 && (method.getModifiers() & 16) == 0 && (method.getModifiers() & Constants.ACC_NATIVE) == 0 && ((method.getModifiers() & 1024) != 0 || this.f2184d == null || this.f2184d.filter(method, name))) {
                try {
                    m2101a(dexMaker, typeId, typeId2, method, name, fieldId5);
                } catch (Exception e2) {
                    C0029a.m806a(e2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m2100a(DexMaker dexMaker, TypeId<?> typeId, TypeId<?> typeId2, Constructor constructor, FieldId<?, MethodInterceptor> fieldId) {
        TypeId[] typeIdArr;
        MethodId methodId;
        MethodId methodId2;
        Local[] localArr;
        TypeId.get(MethodInterceptor.class);
        TypeId.get(Class.class);
        TypeId.get(Class[].class);
        TypeId.get(String.class);
        TypeId.get(Object.class);
        TypeId.get(Object[].class);
        Class[] parameterTypes = constructor.getParameterTypes();
        boolean z = parameterTypes != null && parameterTypes.length > 0;
        if (z) {
            typeIdArr = new TypeId[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                typeIdArr[i] = TypeId.get(parameterTypes[i]);
            }
        } else {
            typeIdArr = null;
        }
        if (z) {
            methodId2 = typeId2.getConstructor(typeIdArr);
            methodId = typeId.getConstructor(typeIdArr);
        } else {
            methodId2 = typeId2.getConstructor(new TypeId[0]);
            methodId = typeId.getConstructor(new TypeId[0]);
        }
        Code declare = dexMaker.declare(methodId2, constructor.getModifiers());
        Local local = declare.getThis(typeId2);
        if (z) {
            localArr = new Local[parameterTypes.length];
            for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                localArr[i2] = declare.getParameter(i2, typeIdArr[i2]);
            }
        } else {
            localArr = new Local[0];
        }
        declare.invokeDirect(methodId, null, local, localArr);
        declare.returnVoid();
    }

    /* renamed from: a */
    private void m2101a(DexMaker dexMaker, TypeId<?> typeId, TypeId<?> typeId2, Method method, String str, FieldId<?, MethodInterceptor> fieldId) {
        TypeId typeId3;
        boolean z;
        MethodId methodId;
        TypeId[] typeIdArr;
        Local local;
        Local local2;
        Class[] clsArr;
        TypeId typeId4;
        Local local3;
        Local local4;
        MethodId methodId2;
        MethodId methodId3;
        Local local5;
        Class[] clsArr2;
        Local local6;
        Local local7;
        DexMaker dexMaker2 = dexMaker;
        TypeId<?> typeId5 = typeId;
        TypeId<?> typeId6 = typeId2;
        String str2 = str;
        TypeId typeId7 = TypeId.get(MethodInterceptor.class);
        TypeId typeId8 = TypeId.get(MethodProxyExecuter.class);
        TypeId typeId9 = TypeId.get(Class.class);
        TypeId typeId10 = TypeId.get(Class[].class);
        TypeId typeId11 = TypeId.get(String.class);
        TypeId typeId12 = TypeId.get(Object.class);
        TypeId typeId13 = TypeId.get(Object[].class);
        Class returnType = method.getReturnType();
        boolean equals = returnType.getSimpleName().equals("void");
        TypeId typeId14 = TypeId.get(returnType);
        Class[] parameterTypes = method.getParameterTypes();
        boolean z2 = parameterTypes != null && parameterTypes.length > 0;
        if (z2) {
            typeIdArr = new TypeId[parameterTypes.length];
            typeId3 = typeId8;
            z = equals;
            for (int i = 0; i < parameterTypes.length; i++) {
                typeIdArr[i] = TypeId.get(parameterTypes[i]);
            }
            methodId = typeId6.getMethod(typeId14, str2, typeIdArr);
        } else {
            typeId3 = typeId8;
            z = equals;
            methodId = typeId6.getMethod(typeId14, str2, new TypeId[0]);
            typeIdArr = null;
        }
        Code declare = dexMaker2.declare(methodId, method.getModifiers() & -1025);
        Local newLocal = declare.newLocal(typeId14);
        if (returnType.isPrimitive()) {
            local2 = declare.newLocal(TypeId.get(Const.getPackedType(returnType)));
            local = newLocal;
        } else {
            local = newLocal;
            local2 = null;
        }
        Local newLocal2 = declare.newLocal(TypeId.INT);
        TypeId typeId15 = typeId14;
        Local newLocal3 = declare.newLocal(typeId7);
        Local local8 = local2;
        Local newLocal4 = declare.newLocal(TypeId.get(String.class));
        Class cls = returnType;
        Local newLocal5 = declare.newLocal(typeId9);
        TypeId typeId16 = typeId11;
        Local newLocal6 = declare.newLocal(typeId9);
        TypeId typeId17 = typeId7;
        Local newLocal7 = declare.newLocal(typeId10);
        TypeId typeId18 = typeId10;
        Local newLocal8 = declare.newLocal(typeId13);
        TypeId typeId19 = typeId13;
        Local newLocal9 = declare.newLocal(typeId12);
        TypeId typeId20 = typeId12;
        Local newLocal10 = declare.newLocal(TypeId.OBJECT);
        Local local9 = declare.getThis(typeId6);
        Local local10 = newLocal9;
        declare.iget(fieldId, newLocal3, local9);
        declare.loadConstant(newLocal4, str2);
        Local local11 = newLocal4;
        declare.invokeVirtual(typeId6.getMethod(typeId9, "getClass", new TypeId[0]), newLocal6, local9, new Local[0]);
        if (z2) {
            declare.loadConstant(newLocal2, Integer.valueOf(parameterTypes.length));
            declare.newArray(newLocal7, newLocal2);
            declare.newArray(newLocal8, newLocal2);
            int i2 = 0;
            while (i2 < parameterTypes.length) {
                declare.loadConstant(newLocal2, Integer.valueOf(i2));
                declare.loadConstant(newLocal5, parameterTypes[i2]);
                declare.aput(newLocal7, newLocal2, newLocal5);
                if (parameterTypes[i2].isPrimitive()) {
                    TypeId typeId21 = TypeId.get(Const.getPackedType(parameterTypes[i2]));
                    local6 = newLocal5;
                    clsArr2 = parameterTypes;
                    local7 = local10;
                    declare.invokeStatic(typeId21.getMethod(typeId21, "valueOf", typeIdArr[i2]), local7, declare.getParameter(i2, typeIdArr[i2]));
                    declare.aput(newLocal8, newLocal2, local7);
                } else {
                    local6 = newLocal5;
                    clsArr2 = parameterTypes;
                    local7 = local10;
                    declare.aput(newLocal8, newLocal2, declare.getParameter(i2, typeIdArr[i2]));
                }
                i2++;
                local10 = local7;
                newLocal5 = local6;
                parameterTypes = clsArr2;
            }
            clsArr = parameterTypes;
        } else {
            clsArr = parameterTypes;
            declare.loadConstant(newLocal7, null);
            declare.loadConstant(newLocal8, null);
        }
        declare.invokeStatic(typeId3.getMethod(TypeId.OBJECT, MethodProxyExecuter.EXECUTE_INTERCEPTOR, typeId17, typeId9, typeId16, typeId18, typeId19, typeId20), z ? null : newLocal10, newLocal3, newLocal6, local11, newLocal7, newLocal8, local9);
        if (z) {
            declare.returnVoid();
            typeId4 = typeId15;
            local3 = null;
        } else {
            Class cls2 = cls;
            if (cls2.isPrimitive()) {
                Label label = new Label();
                Local local12 = local8;
                local3 = null;
                declare.loadConstant(local12, null);
                Local local13 = newLocal10;
                declare.compare(Comparison.EQ, label, local13, local12);
                declare.cast(local12, local13);
                typeId4 = typeId15;
                local5 = local;
                declare.invokeVirtual(TypeId.get(Const.getPackedType(cls2)).getMethod(typeId4, Const.getPrimitiveValueMethodName(cls2), new TypeId[0]), local5, local12, new Local[0]);
                declare.returnValue(local5);
                declare.mark(label);
                declare.loadConstant(local5, Integer.valueOf(0));
            } else {
                local5 = local;
                typeId4 = typeId15;
                local3 = null;
                declare.cast(local5, newLocal10);
            }
            declare.returnValue(local5);
        }
        if (z2) {
            StringBuilder sb = new StringBuilder();
            String str3 = str;
            sb.append(str3);
            sb.append(Const.SUBCLASS_INVOKE_SUPER_SUFFIX);
            methodId3 = typeId6.getMethod(typeId4, sb.toString(), typeIdArr);
            local4 = local3;
            methodId2 = typeId.getMethod(typeId4, str3, typeIdArr);
        } else {
            local4 = local3;
            String str4 = str;
            TypeId<?> typeId22 = typeId;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str4);
            sb2.append(Const.SUBCLASS_INVOKE_SUPER_SUFFIX);
            methodId3 = typeId6.getMethod(typeId4, sb2.toString(), new TypeId[0]);
            methodId2 = typeId22.getMethod(typeId4, str4, new TypeId[0]);
        }
        Code declare2 = dexMaker.declare(methodId3, method.getModifiers());
        Local newLocal11 = declare2.newLocal(typeId4);
        Local local14 = declare2.getThis(typeId6);
        if (z2) {
            Class[] clsArr3 = clsArr;
            Local[] localArr = new Local[clsArr3.length];
            for (int i3 = 0; i3 < clsArr3.length; i3++) {
                localArr[i3] = declare2.getParameter(i3, typeIdArr[i3]);
            }
            if (!z) {
                local4 = newLocal11;
            }
            declare2.invokeSuper(methodId2, local4, local14, localArr);
        } else {
            if (!z) {
                local4 = newLocal11;
            }
            declare2.invokeSuper(methodId2, local4, local14, new Local[0]);
        }
        if (z) {
            declare2.returnVoid();
        } else {
            declare2.returnValue(newLocal11);
        }
    }

    public Class<?> create() {
        String replace = this.f2182b.getName().replace(".", "/");
        StringBuilder sb = new StringBuilder();
        sb.append(replace);
        sb.append(Const.SUBCLASS_SUFFIX);
        sb.append("_");
        sb.append(hashCode());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("L");
        sb3.append(replace);
        sb3.append(";");
        TypeId typeId = TypeId.get(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("L");
        sb4.append(sb2);
        sb4.append(";");
        TypeId typeId2 = TypeId.get(sb4.toString());
        TypeId typeId3 = TypeId.get(EnhancerInterface.class);
        String absolutePath = this.f2181a.getExternalFilesDir("dexfiles").getAbsolutePath();
        DexMaker dexMaker = new DexMaker();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(replace);
        sb5.append(".proxy");
        dexMaker.declare(typeId2, sb5.toString(), 1, typeId, typeId3);
        m2099a(dexMaker, typeId, typeId2);
        try {
            return dexMaker.generateAndLoad(Enhancer.class.getClassLoader(), new File(absolutePath)).loadClass(sb2);
        } catch (IOException | ClassNotFoundException e) {
            C0029a.m806a(e);
            return null;
        }
    }

    public void setInterceptor(MethodInterceptor methodInterceptor) {
        this.f2183c = methodInterceptor;
    }

    public void setMethodFilter(MethodFilter methodFilter) {
        this.f2184d = methodFilter;
    }

    public void setSuperclass(Class<?> cls) {
        this.f2182b = cls;
    }
}
