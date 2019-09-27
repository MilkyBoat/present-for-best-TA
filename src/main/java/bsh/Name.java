package bsh;

import java.io.Serializable;
import java.lang.reflect.Array;

class Name implements Serializable {

    /* renamed from: f */
    private static String f611f;

    /* renamed from: a */
    String f612a = null;

    /* renamed from: b */
    Class f613b;

    /* renamed from: c */
    Class f614c;

    /* renamed from: d */
    private String f615d;

    /* renamed from: e */
    private String f616e;

    /* renamed from: g */
    private Object f617g;

    /* renamed from: h */
    private int f618h;
    public NameSpace namespace;

    Name(NameSpace nameSpace, String str) {
        this.namespace = nameSpace;
        this.f612a = str;
    }

    /* renamed from: a */
    static int m370a(String str) {
        if (str == null) {
            return 0;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            i = str.indexOf(46, i + 1);
            if (i == -1) {
                return i2 + 1;
            }
            i2++;
        }
    }

    /* renamed from: a */
    static NameSpace m371a(NameSpace nameSpace) {
        if (nameSpace.f622d) {
            return nameSpace;
        }
        if (!nameSpace.f621c || nameSpace.getParent() == null || !nameSpace.getParent().f622d) {
            return null;
        }
        return nameSpace.getParent();
    }

    /* renamed from: a */
    private Object m372a(CallStack callStack, Interpreter interpreter, boolean z, boolean z2) {
        Object obj;
        NameSpace nameSpace;
        boolean z3;
        if (this.f617g == null && !isCompound(this.f615d) && !z) {
            Object a = mo840a(callStack, this.namespace, interpreter, this.f615d, false);
            if (a != Primitive.VOID) {
                return m374a(this.f615d, f611f, a);
            }
        }
        String a2 = m375a(this.f615d, 1);
        if ((this.f617g == null || (this.f617g instanceof This)) && !z) {
            if (Interpreter.DEBUG) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("trying to resolve variable: ");
                stringBuffer.append(a2);
                Interpreter.debug(stringBuffer.toString());
            }
            if (this.f617g == null) {
                nameSpace = this.namespace;
                z3 = false;
            } else {
                nameSpace = ((This) this.f617g).f701a;
                z3 = true;
            }
            Object a3 = mo840a(callStack, nameSpace, interpreter, a2, z3);
            if (a3 != Primitive.VOID) {
                if (Interpreter.DEBUG) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("resolved variable: ");
                    stringBuffer2.append(a2);
                    stringBuffer2.append(" in namespace: ");
                    stringBuffer2.append(this.namespace);
                    Interpreter.debug(stringBuffer2.toString());
                }
                return m374a(a2, m378c(this.f615d), a3);
            }
        }
        if (this.f617g == null) {
            if (Interpreter.DEBUG) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("trying class: ");
                stringBuffer3.append(this.f615d);
                Interpreter.debug(stringBuffer3.toString());
            }
            Class cls = null;
            String str = null;
            int i = 1;
            while (i <= m370a(this.f615d)) {
                str = m375a(this.f615d, i);
                cls = this.namespace.getClass(str);
                if (cls != null) {
                    break;
                }
                i++;
            }
            if (cls != null) {
                return m374a(str, suffix(this.f615d, m370a(this.f615d) - i), new ClassIdentifier(cls));
            }
            if (Interpreter.DEBUG) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("not a class, trying var prefix ");
                stringBuffer4.append(this.f615d);
                Interpreter.debug(stringBuffer4.toString());
            }
        }
        if ((this.f617g == null || (this.f617g instanceof This)) && !z && z2) {
            NameSpace nameSpace2 = this.f617g == null ? this.namespace : ((This) this.f617g).f701a;
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("auto: ");
            stringBuffer5.append(a2);
            This a4 = new NameSpace(nameSpace2, stringBuffer5.toString()).mo645a(interpreter);
            nameSpace2.setVariable(a2, a4, false);
            return m374a(a2, m378c(this.f615d), a4);
        } else if (this.f617g == null) {
            if (!isCompound(this.f615d)) {
                return m374a(this.f615d, f611f, Primitive.VOID);
            }
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Class or variable not found: ");
            stringBuffer6.append(this.f615d);
            throw new UtilEvalError(stringBuffer6.toString());
        } else if (this.f617g == Primitive.NULL) {
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer7.append("Null Pointer while evaluating: ");
            stringBuffer7.append(this.f612a);
            throw new UtilTargetError(new NullPointerException(stringBuffer7.toString()));
        } else if (this.f617g == Primitive.VOID) {
            StringBuffer stringBuffer8 = new StringBuffer();
            stringBuffer8.append("Undefined variable or class name while evaluating: ");
            stringBuffer8.append(this.f612a);
            throw new UtilEvalError(stringBuffer8.toString());
        } else if (this.f617g instanceof Primitive) {
            StringBuffer stringBuffer9 = new StringBuffer();
            stringBuffer9.append("Can't treat primitive like an object. Error while evaluating: ");
            stringBuffer9.append(this.f612a);
            throw new UtilEvalError(stringBuffer9.toString());
        } else if (this.f617g instanceof ClassIdentifier) {
            Class targetClass = ((ClassIdentifier) this.f617g).getTargetClass();
            String a5 = m375a(this.f615d, 1);
            if (a5.equals("this")) {
                for (NameSpace nameSpace3 = this.namespace; nameSpace3 != null; nameSpace3 = nameSpace3.getParent()) {
                    if (nameSpace3.f624f != null && nameSpace3.f624f.getClass() == targetClass) {
                        return m374a(a5, m378c(this.f615d), nameSpace3.f624f);
                    }
                }
                StringBuffer stringBuffer10 = new StringBuffer();
                stringBuffer10.append("Can't find enclosing 'this' instance of class: ");
                stringBuffer10.append(targetClass);
                throw new UtilEvalError(stringBuffer10.toString());
            }
            try {
                if (Interpreter.DEBUG) {
                    StringBuffer stringBuffer11 = new StringBuffer();
                    stringBuffer11.append("Name call to getStaticFieldValue, class: ");
                    stringBuffer11.append(targetClass);
                    stringBuffer11.append(", field:");
                    stringBuffer11.append(a5);
                    Interpreter.debug(stringBuffer11.toString());
                }
                obj = Reflect.getStaticFieldValue(targetClass, a5);
            } catch (ReflectError e) {
                if (Interpreter.DEBUG) {
                    StringBuffer stringBuffer12 = new StringBuffer();
                    stringBuffer12.append("field reflect error: ");
                    stringBuffer12.append(e);
                    Interpreter.debug(stringBuffer12.toString());
                }
                obj = null;
            }
            if (obj == null) {
                StringBuffer stringBuffer13 = new StringBuffer();
                stringBuffer13.append(targetClass.getName());
                stringBuffer13.append("$");
                stringBuffer13.append(a5);
                Class cls2 = this.namespace.getClass(stringBuffer13.toString());
                if (cls2 != null) {
                    obj = new ClassIdentifier(cls2);
                }
            }
            if (obj != null) {
                return m374a(a5, m378c(this.f615d), obj);
            }
            StringBuffer stringBuffer14 = new StringBuffer();
            stringBuffer14.append("No static field or inner class: ");
            stringBuffer14.append(a5);
            stringBuffer14.append(" of ");
            stringBuffer14.append(targetClass);
            throw new UtilEvalError(stringBuffer14.toString());
        } else if (z) {
            StringBuffer stringBuffer15 = new StringBuffer();
            stringBuffer15.append(this.f612a);
            stringBuffer15.append(" does not resolve to a class name.");
            throw new UtilEvalError(stringBuffer15.toString());
        } else {
            String a6 = m375a(this.f615d, 1);
            if (!a6.equals("length") || !this.f617g.getClass().isArray()) {
                try {
                    return m374a(a6, m378c(this.f615d), Reflect.getObjectFieldValue(this.f617g, a6));
                } catch (ReflectError unused) {
                    StringBuffer stringBuffer16 = new StringBuffer();
                    stringBuffer16.append("Cannot access field: ");
                    stringBuffer16.append(a6);
                    stringBuffer16.append(", on object: ");
                    stringBuffer16.append(this.f617g);
                    throw new UtilEvalError(stringBuffer16.toString());
                }
            } else {
                return m374a(a6, m378c(this.f615d), new Primitive(Array.getLength(this.f617g)));
            }
        }
    }

    /* renamed from: a */
    private Object m373a(Interpreter interpreter, Object[] objArr, CallStack callStack, SimpleNode simpleNode) {
        if (Interpreter.DEBUG) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("invokeLocalMethod: ");
            stringBuffer.append(this.f612a);
            Interpreter.debug(stringBuffer.toString());
        }
        if (interpreter == null) {
            throw new InterpreterError("invokeLocalMethod: interpreter = null");
        }
        String str = this.f612a;
        Class[] types = Types.getTypes(objArr);
        try {
            BshMethod method = this.namespace.getMethod(str, types);
            if (method != null) {
                return method.invoke(objArr, interpreter, callStack, simpleNode);
            }
            interpreter.getClassManager();
            try {
                Object command = this.namespace.getCommand(str, types, interpreter);
                if (command == null) {
                    try {
                        BshMethod method2 = this.namespace.getMethod("invoke", new Class[]{null, null});
                        if (method2 != null) {
                            return method2.invoke(new Object[]{str, objArr}, interpreter, callStack, simpleNode);
                        }
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Command not found: ");
                        stringBuffer2.append(StringUtil.methodString(str, types));
                        throw new EvalError(stringBuffer2.toString(), simpleNode, callStack);
                    } catch (UtilEvalError e) {
                        throw e.toEvalError("Local method invocation", simpleNode, callStack);
                    }
                } else if (command instanceof BshMethod) {
                    return ((BshMethod) command).invoke(objArr, interpreter, callStack, simpleNode);
                } else {
                    if (command instanceof Class) {
                        try {
                            return Reflect.invokeCompiledCommand((Class) command, objArr, interpreter, callStack);
                        } catch (UtilEvalError e2) {
                            throw e2.toEvalError("Error invoking compiled command: ", simpleNode, callStack);
                        }
                    } else {
                        throw new InterpreterError("invalid command type");
                    }
                }
            } catch (UtilEvalError e3) {
                throw e3.toEvalError("Error loading command: ", simpleNode, callStack);
            }
        } catch (UtilEvalError e4) {
            throw e4.toEvalError("Local method invocation", simpleNode, callStack);
        }
    }

    /* renamed from: a */
    private Object m374a(String str, String str2, Object obj) {
        if (obj == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("lastEvalName = ");
            stringBuffer.append(str);
            throw new InterpreterError(stringBuffer.toString());
        }
        this.f616e = str;
        this.f615d = str2;
        this.f617g = obj;
        return obj;
    }

    /* renamed from: a */
    static String m375a(String str, int i) {
        if (i < 1) {
            return null;
        }
        int i2 = -1;
        int i3 = 0;
        do {
            i2 = str.indexOf(46, i2 + 1);
            if (i2 == -1) {
                break;
            }
            i3++;
        } while (i3 < i);
        return i2 == -1 ? str : str.substring(0, i2);
    }

    /* renamed from: a */
    private void m376a() {
        this.f615d = this.f612a;
        this.f617g = null;
        this.f618h = 0;
    }

    /* renamed from: b */
    static String m377b(String str) {
        if (!isCompound(str)) {
            return null;
        }
        return m375a(str, m370a(str) - 1);
    }

    /* renamed from: c */
    static String m378c(String str) {
        if (!isCompound(str)) {
            return null;
        }
        return suffix(str, m370a(str) - 1);
    }

    public static boolean isCompound(String str) {
        return str.indexOf(46) != -1;
    }

    public static String suffix(String str, int i) {
        if (i < 1) {
            return null;
        }
        int i2 = 0;
        int length = str.length() + 1;
        do {
            length = str.lastIndexOf(46, length - 1);
            if (length == -1) {
                break;
            }
            i2++;
        } while (i2 < i);
        return length == -1 ? str : str.substring(length + 1);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [bsh.CallStack] */
    /* JADX WARNING: type inference failed for: r4v0, types: [bsh.NameSpace] */
    /* JADX WARNING: type inference failed for: r5v0, types: [bsh.Interpreter] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r0v11, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13, types: [bsh.This] */
    /* JADX WARNING: type inference failed for: r3v17, types: [bsh.This] */
    /* JADX WARNING: type inference failed for: r3v18, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v21, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v24 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r3v25 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=bsh.CallStack, code=null, for r3v0, types: [bsh.CallStack] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=bsh.Interpreter, code=null, for r5v0, types: [bsh.Interpreter] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=bsh.NameSpace, code=null, for r4v0, types: [bsh.NameSpace] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v5
  assigns: [?[OBJECT, ARRAY], java.lang.Object, bsh.CallStack]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], java.lang.Object, bsh.CallStack]
  mth insns count: 120
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object mo840a(bsh.CallStack r3, bsh.NameSpace r4, bsh.Interpreter r5, java.lang.String r6, boolean r7) {
        /*
            r2 = this;
            java.lang.String r0 = "this"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0032
            if (r7 == 0) goto L_0x0012
            bsh.UtilEvalError r3 = new bsh.UtilEvalError
            java.lang.String r4 = "Redundant to call .this on This type"
            r3.<init>(r4)
            throw r3
        L_0x0012:
            bsh.This r3 = r4.mo645a(r5)
            bsh.NameSpace r4 = r3.getNameSpace()
            bsh.NameSpace r4 = m371a(r4)
            if (r4 == 0) goto L_0x0031
            java.lang.String r3 = r2.f615d
            boolean r3 = isCompound(r3)
            if (r3 == 0) goto L_0x002d
            bsh.This r3 = r4.mo645a(r5)
            return r3
        L_0x002d:
            java.lang.Object r3 = r4.mo852a()
        L_0x0031:
            return r3
        L_0x0032:
            java.lang.String r0 = "super"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0059
            bsh.This r3 = r4.getSuper(r5)
            bsh.NameSpace r4 = r3.getNameSpace()
            bsh.NameSpace r6 = r4.getParent()
            if (r6 == 0) goto L_0x0058
            bsh.NameSpace r6 = r4.getParent()
            boolean r6 = r6.f622d
            if (r6 == 0) goto L_0x0058
            bsh.NameSpace r3 = r4.getParent()
            bsh.This r3 = r3.mo645a(r5)
        L_0x0058:
            return r3
        L_0x0059:
            r0 = 0
            java.lang.String r1 = "global"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0066
            bsh.This r0 = r4.getGlobal(r5)
        L_0x0066:
            if (r0 != 0) goto L_0x00aa
            if (r7 == 0) goto L_0x00aa
            java.lang.String r1 = "namespace"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0074
            r0 = r4
            goto L_0x00aa
        L_0x0074:
            java.lang.String r1 = "variables"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0081
            java.lang.String[] r0 = r4.getVariableNames()
            goto L_0x00aa
        L_0x0081:
            java.lang.String r1 = "methods"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x008e
            java.lang.String[] r0 = r4.getMethodNames()
            goto L_0x00aa
        L_0x008e:
            java.lang.String r1 = "interpreter"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x00aa
            java.lang.String r0 = r2.f616e
            java.lang.String r1 = "this"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a2
            r0 = r5
            goto L_0x00aa
        L_0x00a2:
            bsh.UtilEvalError r3 = new bsh.UtilEvalError
            java.lang.String r4 = "Can only call .interpreter on literal 'this'"
            r3.<init>(r4)
            throw r3
        L_0x00aa:
            if (r0 != 0) goto L_0x00ec
            if (r7 == 0) goto L_0x00ec
            java.lang.String r1 = "caller"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x00ec
            java.lang.String r4 = r2.f616e
            java.lang.String r6 = "this"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x00d3
            java.lang.String r4 = r2.f616e
            java.lang.String r6 = "caller"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00cb
            goto L_0x00d3
        L_0x00cb:
            bsh.UtilEvalError r3 = new bsh.UtilEvalError
            java.lang.String r4 = "Can only call .caller on literal 'this' or literal '.caller'"
            r3.<init>(r4)
            throw r3
        L_0x00d3:
            if (r3 != 0) goto L_0x00dd
            bsh.InterpreterError r3 = new bsh.InterpreterError
            java.lang.String r4 = "no callstack"
            r3.<init>(r4)
            throw r3
        L_0x00dd:
            int r4 = r2.f618h
            int r4 = r4 + 1
            r2.f618h = r4
            bsh.NameSpace r3 = r3.get(r4)
            bsh.This r3 = r3.mo645a(r5)
            return r3
        L_0x00ec:
            if (r0 != 0) goto L_0x0114
            if (r7 == 0) goto L_0x0114
            java.lang.String r5 = "callstack"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0114
            java.lang.String r5 = r2.f616e
            java.lang.String r7 = "this"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x010c
            if (r3 != 0) goto L_0x0115
            bsh.InterpreterError r3 = new bsh.InterpreterError
            java.lang.String r4 = "no callstack"
            r3.<init>(r4)
            throw r3
        L_0x010c:
            bsh.UtilEvalError r3 = new bsh.UtilEvalError
            java.lang.String r4 = "Can only call .callstack on literal 'this'"
            r3.<init>(r4)
            throw r3
        L_0x0114:
            r3 = r0
        L_0x0115:
            if (r3 != 0) goto L_0x011b
            java.lang.Object r3 = r4.getVariable(r6)
        L_0x011b:
            if (r3 != 0) goto L_0x0134
            bsh.InterpreterError r3 = new bsh.InterpreterError
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            java.lang.String r5 = "null this field ref:"
            r4.append(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x0134:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Name.mo840a(bsh.CallStack, bsh.NameSpace, bsh.Interpreter, java.lang.String, boolean):java.lang.Object");
    }

    public Object invokeMethod(Interpreter interpreter, Object[] objArr, CallStack callStack, SimpleNode simpleNode) {
        String suffix = suffix(this.f612a, 1);
        BshClassManager classManager = interpreter.getClassManager();
        NameSpace pVar = callStack.top();
        if (this.f614c != null) {
            return Reflect.invokeStaticMethod(classManager, this.f614c, suffix, objArr);
        }
        if (!isCompound(this.f612a)) {
            return m373a(interpreter, objArr, callStack, simpleNode);
        }
        String b = m377b(this.f612a);
        if (b.equals("super") && m370a(this.f612a) == 2) {
            NameSpace a = m371a(pVar.mo645a(interpreter).getNameSpace());
            if (a != null) {
                return ClassGenerator.getClassGenerator().invokeSuperclassMethod(classManager, a.mo852a(), suffix, objArr);
            }
        }
        Name b2 = pVar.mo860b(b);
        Object object = b2.toObject(callStack, interpreter);
        if (object == Primitive.VOID) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Attempt to resolve method: ");
            stringBuffer.append(suffix);
            stringBuffer.append("() on undefined variable or class name: ");
            stringBuffer.append(b2);
            throw new UtilEvalError(stringBuffer.toString());
        } else if (!(object instanceof ClassIdentifier)) {
            if (object instanceof Primitive) {
                if (object == Primitive.NULL) {
                    throw new UtilTargetError(new NullPointerException("Null Pointer in Method Invocation"));
                } else if (Interpreter.DEBUG) {
                    Interpreter.debug("Attempt to access method on primitive... allowing bsh.Primitive to peek through for debugging");
                }
            }
            return Reflect.invokeObjectMethod(object, suffix, objArr, interpreter, callStack, simpleNode);
        } else {
            if (Interpreter.DEBUG) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("invokeMethod: trying static - ");
                stringBuffer2.append(b2);
                Interpreter.debug(stringBuffer2.toString());
            }
            Class targetClass = ((ClassIdentifier) object).getTargetClass();
            this.f614c = targetClass;
            if (targetClass != null) {
                return Reflect.invokeStaticMethod(classManager, targetClass, suffix, objArr);
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("invokeMethod: unknown target: ");
            stringBuffer3.append(b2);
            throw new UtilEvalError(stringBuffer3.toString());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|18|19|20|21|(1:23)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Class toClass() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.Class r0 = r3.f613b     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0009
            java.lang.Class r0 = r3.f613b     // Catch:{ all -> 0x005b }
            monitor-exit(r3)
            return r0
        L_0x0009:
            r3.m376a()     // Catch:{ all -> 0x005b }
            java.lang.String r0 = r3.f615d     // Catch:{ all -> 0x005b }
            java.lang.String r1 = "var"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x005b }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            r3.f613b = r1     // Catch:{ all -> 0x005b }
            monitor-exit(r3)
            return r1
        L_0x001b:
            bsh.NameSpace r0 = r3.namespace     // Catch:{ all -> 0x005b }
            java.lang.String r2 = r3.f615d     // Catch:{ all -> 0x005b }
            java.lang.Class r0 = r0.getClass(r2)     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x0035
            r2 = 1
            java.lang.Object r2 = r3.toObject(r1, r1, r2)     // Catch:{ UtilEvalError -> 0x002b }
            r1 = r2
        L_0x002b:
            boolean r2 = r1 instanceof bsh.ClassIdentifier     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x0035
            bsh.ClassIdentifier r1 = (bsh.ClassIdentifier) r1     // Catch:{ all -> 0x005b }
            java.lang.Class r0 = r1.getTargetClass()     // Catch:{ all -> 0x005b }
        L_0x0035:
            if (r0 != 0) goto L_0x0055
            java.lang.ClassNotFoundException r0 = new java.lang.ClassNotFoundException     // Catch:{ all -> 0x005b }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x005b }
            r1.<init>()     // Catch:{ all -> 0x005b }
            java.lang.String r2 = "Class: "
            r1.append(r2)     // Catch:{ all -> 0x005b }
            java.lang.String r2 = r3.f612a     // Catch:{ all -> 0x005b }
            r1.append(r2)     // Catch:{ all -> 0x005b }
            java.lang.String r2 = " not found in namespace"
            r1.append(r2)     // Catch:{ all -> 0x005b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x005b }
            r0.<init>(r1)     // Catch:{ all -> 0x005b }
            throw r0     // Catch:{ all -> 0x005b }
        L_0x0055:
            r3.f613b = r0     // Catch:{ all -> 0x005b }
            java.lang.Class r0 = r3.f613b     // Catch:{ all -> 0x005b }
            monitor-exit(r3)
            return r0
        L_0x005b:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.Name.toClass():java.lang.Class");
    }

    public synchronized LHS toLHS(CallStack callStack, Interpreter interpreter) {
        m376a();
        if (isCompound(this.f615d)) {
            Object obj = null;
            while (true) {
                try {
                    if (this.f615d != null) {
                        if (!isCompound(this.f615d)) {
                            break;
                        }
                        obj = m372a(callStack, interpreter, false, true);
                    }
                } catch (UtilEvalError e) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("LHS evaluation: ");
                    stringBuffer.append(e.getMessage());
                    throw new UtilEvalError(stringBuffer.toString());
                } catch (ReflectError e2) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Field access: ");
                    stringBuffer2.append(e2);
                    throw new UtilEvalError(stringBuffer2.toString());
                }
            }
            if (this.f615d == null && (obj instanceof ClassIdentifier)) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Can't assign to class: ");
                stringBuffer3.append(this.f612a);
                throw new UtilEvalError(stringBuffer3.toString());
            } else if (obj == null) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Error in LHS: ");
                stringBuffer4.append(this.f612a);
                throw new UtilEvalError(stringBuffer4.toString());
            } else if (obj instanceof This) {
                if (!this.f615d.equals("namespace") && !this.f615d.equals("variables") && !this.f615d.equals("methods")) {
                    if (!this.f615d.equals("caller")) {
                        Interpreter.debug("found This reference evaluating LHS");
                        return new LHS(((This) obj).f701a, this.f615d, !this.f616e.equals("super"));
                    }
                }
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Can't assign to special variable: ");
                stringBuffer5.append(this.f615d);
                throw new UtilEvalError(stringBuffer5.toString());
            } else if (this.f615d == null) {
                throw new InterpreterError("Internal error in lhs...");
            } else if (obj instanceof ClassIdentifier) {
                return Reflect.m726a(((ClassIdentifier) obj).getTargetClass(), this.f615d);
            } else {
                return Reflect.m727a(obj, this.f615d);
            }
        } else if (this.f615d.equals("this")) {
            throw new UtilEvalError("Can't assign to 'this'.");
        } else {
            return new LHS(this.namespace, this.f615d, false);
        }
    }

    public Object toObject(CallStack callStack, Interpreter interpreter) {
        return toObject(callStack, interpreter, false);
    }

    public synchronized Object toObject(CallStack callStack, Interpreter interpreter, boolean z) {
        Object obj;
        m376a();
        obj = null;
        while (this.f615d != null) {
            obj = m372a(callStack, interpreter, z, false);
        }
        if (obj == null) {
            throw new InterpreterError("null value in toObject()");
        }
        return obj;
    }

    public String toString() {
        return this.f612a;
    }
}
