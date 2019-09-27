package bsh;

import com.androlua.BuildConfig;
import java.io.Serializable;
import java.lang.reflect.Field;

class LHS implements ParserConstants, Serializable {

    /* renamed from: a */
    NameSpace f602a;

    /* renamed from: b */
    boolean f603b;

    /* renamed from: c */
    int f604c;

    /* renamed from: d */
    String f605d;

    /* renamed from: e */
    String f606e;

    /* renamed from: f */
    Field f607f;

    /* renamed from: g */
    Object f608g;

    /* renamed from: h */
    int f609h;

    LHS(NameSpace nameSpace, String str, boolean z) {
        this.f604c = 0;
        this.f603b = z;
        this.f605d = str;
        this.f602a = nameSpace;
    }

    LHS(Object obj, int i) {
        if (obj == null) {
            throw new NullPointerException("constructed empty LHS");
        }
        this.f604c = 3;
        this.f608g = obj;
        this.f609h = i;
    }

    LHS(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException("constructed empty LHS");
        }
        this.f604c = 2;
        this.f608g = obj;
        this.f606e = str;
    }

    LHS(Object obj, Field field) {
        if (obj == null) {
            throw new NullPointerException("constructed empty LHS");
        }
        this.f604c = 1;
        this.f608g = obj;
        this.f607f = field;
    }

    LHS(Field field) {
        this.f604c = 1;
        this.f608g = null;
        this.f607f = field;
    }

    public Object assign(Object obj, boolean z) {
        if (this.f604c == 0) {
            if (this.f603b) {
                this.f602a.mo859a(this.f605d, obj, z);
                return obj;
            }
            this.f602a.setVariable(this.f605d, obj, z);
            return obj;
        } else if (this.f604c == 1) {
            try {
                Object value = obj instanceof Primitive ? ((Primitive) obj).getValue() : obj;
                ReflectManager.RMSetAccessible(this.f607f);
                this.f607f.set(this.f608g, value);
                return obj;
            } catch (NullPointerException unused) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("LHS (");
                stringBuffer.append(this.f607f.getName());
                stringBuffer.append(") not a static field.");
                throw new UtilEvalError(stringBuffer.toString());
            } catch (IllegalAccessException e) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("LHS (");
                stringBuffer2.append(this.f607f.getName());
                stringBuffer2.append(") can't access field: ");
                stringBuffer2.append(e);
                throw new UtilEvalError(stringBuffer2.toString());
            } catch (IllegalArgumentException unused2) {
                String name = (obj instanceof Primitive ? ((Primitive) obj).getType() : obj.getClass()).getName();
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Argument type mismatch. ");
                if (obj == null) {
                    name = "null";
                }
                stringBuffer3.append(name);
                stringBuffer3.append(" not assignable to field ");
                stringBuffer3.append(this.f607f.getName());
                throw new UtilEvalError(stringBuffer3.toString());
            }
        } else if (this.f604c == 2) {
            CollectionManager collectionManager = CollectionManager.getCollectionManager();
            if (collectionManager.isMap(this.f608g)) {
                collectionManager.putInMap(this.f608g, this.f606e, obj);
                return obj;
            }
            try {
                Reflect.setObjectProperty(this.f608g, this.f606e, obj);
                return obj;
            } catch (ReflectError e2) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Assignment: ");
                stringBuffer4.append(e2.getMessage());
                Interpreter.debug(stringBuffer4.toString());
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("No such property: ");
                stringBuffer5.append(this.f606e);
                throw new UtilEvalError(stringBuffer5.toString());
            }
        } else if (this.f604c == 3) {
            try {
                Reflect.setIndex(this.f608g, this.f609h, obj);
                return obj;
            } catch (UtilTargetError e3) {
                throw e3;
            } catch (Exception e4) {
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append("Assignment: ");
                stringBuffer6.append(e4.getMessage());
                throw new UtilEvalError(stringBuffer6.toString());
            }
        } else {
            throw new InterpreterError("unknown lhs");
        }
    }

    public Object getValue() {
        if (this.f604c == 0) {
            return this.f602a.getVariable(this.f605d);
        }
        if (this.f604c == 1) {
            try {
                return Primitive.wrap(this.f607f.get(this.f608g), this.f607f.getType());
            } catch (IllegalAccessException unused) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Can't read field: ");
                stringBuffer.append(this.f607f);
                throw new UtilEvalError(stringBuffer.toString());
            }
        } else if (this.f604c == 2) {
            try {
                return Reflect.getObjectProperty(this.f608g, this.f606e);
            } catch (ReflectError e) {
                Interpreter.debug(e.getMessage());
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("No such property: ");
                stringBuffer2.append(this.f606e);
                throw new UtilEvalError(stringBuffer2.toString());
            }
        } else if (this.f604c == 3) {
            try {
                return Reflect.getIndex(this.f608g, this.f609h);
            } catch (Exception e2) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Array access: ");
                stringBuffer3.append(e2);
                throw new UtilEvalError(stringBuffer3.toString());
            }
        } else {
            throw new InterpreterError("LHS type");
        }
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LHS: ");
        if (this.f607f != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("field = ");
            stringBuffer2.append(this.f607f.toString());
            str = stringBuffer2.toString();
        } else {
            str = BuildConfig.FLAVOR;
        }
        stringBuffer.append(str);
        if (this.f605d != null) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(" varName = ");
            stringBuffer3.append(this.f605d);
            str2 = stringBuffer3.toString();
        } else {
            str2 = BuildConfig.FLAVOR;
        }
        stringBuffer.append(str2);
        if (this.f602a != null) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(" nameSpace = ");
            stringBuffer4.append(this.f602a.toString());
            str3 = stringBuffer4.toString();
        } else {
            str3 = BuildConfig.FLAVOR;
        }
        stringBuffer.append(str3);
        return stringBuffer.toString();
    }
}
