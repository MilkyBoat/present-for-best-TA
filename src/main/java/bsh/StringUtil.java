package bsh;

import java.util.StringTokenizer;
import java.util.Vector;

public class StringUtil {
    public static String[] bubbleSort(String[] strArr) {
        boolean z;
        Vector vector = new Vector();
        for (String addElement : strArr) {
            vector.addElement(addElement);
        }
        int size = vector.size();
        for (boolean z2 = true; z2; z2 = z) {
            int i = 0;
            z = false;
            while (i < size - 1) {
                int i2 = i + 1;
                if (((String) vector.elementAt(i)).compareTo((String) vector.elementAt(i2)) > 0) {
                    String str = (String) vector.elementAt(i2);
                    vector.removeElementAt(i2);
                    vector.insertElementAt(str, i);
                    z = true;
                }
                i = i2;
            }
        }
        String[] strArr2 = new String[size];
        vector.copyInto(strArr2);
        return strArr2;
    }

    public static String maxCommonPrefix(String str, String str2) {
        int i = 0;
        while (str.regionMatches(0, str2, 0, i)) {
            i++;
        }
        return str.substring(0, i - 1);
    }

    public static String methodString(String str, Class[] clsArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("(");
        StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.toString());
        if (clsArr.length > 0) {
            stringBuffer2.append(" ");
        }
        int i = 0;
        while (i < clsArr.length) {
            Class cls = clsArr[i];
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(cls == null ? "null" : cls.getName());
            stringBuffer3.append(i < clsArr.length + -1 ? ", " : " ");
            stringBuffer2.append(stringBuffer3.toString());
            i++;
        }
        stringBuffer2.append(")");
        return stringBuffer2.toString();
    }

    public static String normalizeClassName(Class cls) {
        return Reflect.normalizeClassName(cls);
    }

    public static String[] split(String str, String str2) {
        Vector vector = new Vector();
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        while (stringTokenizer.hasMoreTokens()) {
            vector.addElement(stringTokenizer.nextToken());
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }
}
