package bsh;

import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class CollectionManager {

    /* renamed from: a */
    private static CollectionManager f548a;

    public static class BasicBshIterator implements BshIterator {

        /* renamed from: a */
        Enumeration f553a;

        public BasicBshIterator(Object obj) {
            this.f553a = mo733a(obj);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Enumeration mo733a(Object obj) {
            if (obj == null) {
                throw new NullPointerException("Object arguments passed to the BasicBshIterator constructor cannot be null.");
            } else if (obj instanceof Enumeration) {
                return (Enumeration) obj;
            } else {
                if (obj instanceof Vector) {
                    return ((Vector) obj).elements();
                }
                if (obj.getClass().isArray()) {
                    return new Enumeration(this, obj) {

                        /* renamed from: a */
                        int f549a = 0;

                        /* renamed from: b */
                        int f550b = Array.getLength(this.f551c);

                        /* renamed from: c */
                        private final Object f551c;

                        /* renamed from: d */
                        private final BasicBshIterator f552d;

                        {
                            this.f552d = r1;
                            this.f551c = r2;
                        }

                        public boolean hasMoreElements() {
                            return this.f549a < this.f550b;
                        }

                        public Object nextElement() {
                            Object obj = this.f551c;
                            int i = this.f549a;
                            this.f549a = i + 1;
                            return Array.get(obj, i);
                        }
                    };
                }
                if (obj instanceof String) {
                    return mo733a(((String) obj).toCharArray());
                }
                if (obj instanceof StringBuffer) {
                    return mo733a(obj.toString().toCharArray());
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Cannot enumerate object of type ");
                stringBuffer.append(obj.getClass());
                throw new IllegalArgumentException(stringBuffer.toString());
            }
        }

        public boolean hasNext() {
            return this.f553a.hasMoreElements();
        }

        public Object next() {
            return this.f553a.nextElement();
        }
    }

    public static synchronized CollectionManager getCollectionManager() {
        CollectionManager collectionManager;
        synchronized (CollectionManager.class) {
            if (f548a == null && Capabilities.classExists("java.util.Collection")) {
                try {
                    f548a = (CollectionManager) Class.forName("bsh.collection.CollectionManagerImpl").newInstance();
                } catch (Exception e) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("unable to load CollectionManagerImpl: ");
                    stringBuffer.append(e);
                    Interpreter.debug(stringBuffer.toString());
                }
            }
            if (f548a == null) {
                f548a = new CollectionManager();
            }
            collectionManager = f548a;
        }
        return collectionManager;
    }

    public BshIterator getBshIterator(Object obj) {
        return new BasicBshIterator(obj);
    }

    public Object getFromMap(Object obj, Object obj2) {
        return ((Hashtable) obj).get(obj2);
    }

    public boolean isBshIterable(Object obj) {
        try {
            getBshIterator(obj);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public boolean isMap(Object obj) {
        return obj instanceof Hashtable;
    }

    public Object putInMap(Object obj, Object obj2, Object obj3) {
        return ((Hashtable) obj).put(obj2, obj3);
    }
}
