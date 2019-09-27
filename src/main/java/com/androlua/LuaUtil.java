package com.androlua;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.mobstat.Config;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import dalvik.system.DexFile;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LuaUtil {

    /* renamed from: a */
    private static final byte[] f2661a = new byte[4096];
    public static final HashMap<String, String> mFileTypes = new HashMap<>();

    static {
        mFileTypes.put("FFD8FF", "jpg");
        mFileTypes.put("89504E47", "png");
        mFileTypes.put("47494638", "gif");
        mFileTypes.put("49492A00", "tif");
        mFileTypes.put("424D", "bmp");
        mFileTypes.put("41433130", "dwg");
        mFileTypes.put("38425053", "psd");
        mFileTypes.put("7B5C727466", "rtf");
        mFileTypes.put("3C3F786D6C", "xml");
        mFileTypes.put("68746D6C3E", "html");
        mFileTypes.put("44656C69766572792D646174653A", "eml");
        mFileTypes.put("D0CF11E0", "doc");
        mFileTypes.put("5374616E64617264204A", "mdb");
        mFileTypes.put("252150532D41646F6265", Config.SESSTION_ACTIVITY_START);
        mFileTypes.put("255044462D312E", "pdf");
        mFileTypes.put("504B0304", "docx");
        mFileTypes.put("52617221", "rar");
        mFileTypes.put("57415645", "wav");
        mFileTypes.put("41564920", "avi");
        mFileTypes.put("2E524D46", "rm");
        mFileTypes.put("000001BA", "mpg");
        mFileTypes.put("000001B3", "mpg");
        mFileTypes.put("6D6F6F76", "mov");
        mFileTypes.put("3026B2758E66CF11", "asf");
        mFileTypes.put("4D546864", "mid");
        mFileTypes.put("1F8B08", "gz");
    }

    /* renamed from: a */
    private static String m2299a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase();
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005e A[SYNTHETIC, Splitter:B:25:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0068 A[SYNTHETIC, Splitter:B:32:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0073 A[SYNTHETIC, Splitter:B:39:0x0073] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0063=Splitter:B:29:0x0063, B:22:0x0059=Splitter:B:22:0x0059} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m2300a(java.io.File r5, java.util.zip.ZipOutputStream r6, java.lang.String r7) {
        /*
            boolean r0 = r5.isFile()
            r1 = 0
            if (r0 == 0) goto L_0x007c
            r0 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0058 }
            r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0058 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0058 }
            byte[] r4 = f2661a     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0058 }
            int r4 = r4.length     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0058 }
            r3.<init>(r2, r4)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0058 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            r0.append(r7)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            java.lang.String r5 = r5.getName()     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            r0.append(r5)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            java.lang.String r5 = r0.toString()     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            java.io.PrintStream r7 = java.lang.System.out     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            r7.println(r5)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            java.util.zip.ZipEntry r7 = new java.util.zip.ZipEntry     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            r7.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            r6.putNextEntry(r7)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
        L_0x0035:
            byte[] r5 = f2661a     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            byte[] r7 = f2661a     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            int r7 = r7.length     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            int r5 = r3.read(r5, r1, r7)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            r7 = -1
            if (r5 == r7) goto L_0x0047
            byte[] r7 = f2661a     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            r6.write(r7, r1, r5)     // Catch:{ FileNotFoundException -> 0x0052, IOException -> 0x004f, all -> 0x004d }
            goto L_0x0035
        L_0x0047:
            if (r3 == 0) goto L_0x00b8
            r3.close()     // Catch:{ IOException -> 0x006c }
            return
        L_0x004d:
            r5 = move-exception
            goto L_0x0071
        L_0x004f:
            r5 = move-exception
            r0 = r3
            goto L_0x0059
        L_0x0052:
            r5 = move-exception
            r0 = r3
            goto L_0x0063
        L_0x0055:
            r5 = move-exception
            r3 = r0
            goto L_0x0071
        L_0x0058:
            r5 = move-exception
        L_0x0059:
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r5)     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x00b8
            r0.close()     // Catch:{ IOException -> 0x006c }
            return
        L_0x0062:
            r5 = move-exception
        L_0x0063:
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r5)     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x00b8
            r0.close()     // Catch:{ IOException -> 0x006c }
            return
        L_0x006c:
            r5 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r5)
            return
        L_0x0071:
            if (r3 == 0) goto L_0x007b
            r3.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r6 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r6)
        L_0x007b:
            throw r5
        L_0x007c:
            boolean r0 = r5.isDirectory()
            if (r0 == 0) goto L_0x00b8
            java.io.File[] r5 = r5.listFiles()
            if (r5 == 0) goto L_0x00b8
            int r0 = r5.length
            if (r0 <= 0) goto L_0x00b8
            int r0 = r5.length
        L_0x008c:
            if (r1 >= r0) goto L_0x00b8
            r2 = r5[r1]
            boolean r3 = r2.isFile()
            if (r3 == 0) goto L_0x009a
            m2300a(r2, r6, r7)
            goto L_0x00b5
        L_0x009a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            java.lang.String r4 = r2.getName()
            r3.append(r4)
            java.lang.String r4 = "/"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            m2300a(r2, r6, r3)
        L_0x00b5:
            int r1 = r1 + 1
            goto L_0x008c
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaUtil.m2300a(java.io.File, java.util.zip.ZipOutputStream, java.lang.String):void");
    }

    /* renamed from: a */
    private boolean m2301a(int i, int i2, int[][] iArr, int i3, int i4) {
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i2 + i5;
            if (iArr[i][i6] != 1 || iArr[i + i4][i6] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void assetsToSD(Context context, String str, String str2) {
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        InputStream open = context.getAssets().open(str);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
                return;
            }
        }
    }

    public static Bitmap captureScreen(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        int pixelFormat = defaultDisplay.getPixelFormat();
        PixelFormat pixelFormat2 = new PixelFormat();
        PixelFormat.getPixelFormatInfo(pixelFormat, pixelFormat2);
        int i3 = pixelFormat2.bytesPerPixel;
        int i4 = i * i2;
        byte[] bArr = new byte[(i3 * i4)];
        try {
            Runtime.getRuntime().exec(new String[]{"/system/bin/su", "-c", "chmod 777 /dev/graphics/fb0"});
        } catch (IOException e) {
            C0029a.m806a(e);
        }
        try {
            new DataInputStream(new FileInputStream(new File("/dev/graphics/fb0"))).readFully(bArr);
        } catch (Exception e2) {
            C0029a.m806a(e2);
        }
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int i6 = i5 * 4;
            byte b = bArr[i6 + 2] & 255;
            iArr[i5] = ((bArr[i6 + 3] & 255) << 24) + ((bArr[i6] & 255) << 16) + ((bArr[i6 + 1] & 255) << 8) + b;
        }
        return Bitmap.createBitmap(iArr, i2, i, Bitmap.Config.ARGB_8888);
    }

    public static boolean copyDir(File file, File file2) {
        boolean z;
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            boolean z2 = true;
            if (listFiles != null && listFiles.length != 0) {
                for (File file3 : listFiles) {
                    z2 = copyDir(file3, new File(file2, file3.getName()));
                }
                return z2;
            } else if (file2.exists()) {
                return true;
            } else {
                z = file2.mkdirs();
            }
        } else {
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                z = copyFile((InputStream) new FileInputStream(file), (OutputStream) new FileOutputStream(file2));
            } catch (IOException e) {
                Log.i("lua", e.getMessage());
                return false;
            }
        }
        return z;
    }

    public static boolean copyDir(String str, String str2) {
        return copyDir(new File(str), new File(str2));
    }

    public static void copyFile(String str, String str2) {
        try {
            copyFile((InputStream) new FileInputStream(str), (OutputStream) new FileOutputStream(str2));
        } catch (IOException e) {
            Log.i("lua", e.getMessage());
        }
    }

    public static boolean copyFile(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return true;
                }
                outputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            Log.i("lua", e.getMessage());
            return false;
        }
    }

    public static String[] getAllName(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration entries = new DexFile(context.getPackageCodePath()).entries();
            while (entries.hasMoreElements()) {
                arrayList.add(entries.nextElement());
            }
        } catch (IOException e) {
            C0029a.m806a(e);
        }
        try {
            Enumeration entries2 = new ZipFile(str).entries();
            while (entries2.hasMoreElements()) {
                arrayList.add(((ZipEntry) entries2.nextElement()).getName().replaceAll("/", ".").replace(".class", BuildConfig.FLAVOR));
            }
        } catch (Exception e2) {
            C0029a.m806a(e2);
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public static String getFileHeader(InputStream inputStream) {
        String str;
        try {
            byte[] bArr = new byte[4];
            inputStream.read(bArr, 0, bArr.length);
            str = m2299a(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return str;
                } catch (IOException unused) {
                }
            }
        } catch (Exception unused2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            str = null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
        }
        return str;
    }

    public static String getFileMD5(File file) {
        try {
            return getFileMD5((InputStream) new FileInputStream(file));
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public static String getFileMD5(InputStream inputStream) {
        byte[] bArr = new byte[4096];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    String bigInteger = new BigInteger(1, instance.digest()).toString(16);
                    try {
                        return bigInteger;
                    } catch (Exception e) {
                        C0029a.m806a(e);
                        return bigInteger;
                    }
                }
            }
        } catch (Exception e2) {
            C0029a.m806a(e2);
            try {
                return null;
            } catch (Exception e3) {
                C0029a.m806a(e3);
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (Exception e4) {
                C0029a.m806a(e4);
            }
        }
    }

    public static String getFileMD5(String str) {
        return getFileMD5(new File(str));
    }

    public static String getFileSha1(File file) {
        try {
            return getFileSha1((InputStream) new FileInputStream(file));
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public static String getFileSha1(InputStream inputStream) {
        byte[] bArr = new byte[4096];
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    String bigInteger = new BigInteger(1, instance.digest()).toString(16);
                    try {
                        return bigInteger;
                    } catch (Exception e) {
                        C0029a.m806a(e);
                        return bigInteger;
                    }
                }
            }
        } catch (Exception e2) {
            C0029a.m806a(e2);
            try {
                return null;
            } catch (Exception e3) {
                C0029a.m806a(e3);
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (Exception e4) {
                C0029a.m806a(e4);
            }
        }
    }

    public static String getFileSha1(String str) {
        return getFileMD5(new File(str));
    }

    public static String getFileType(File file) {
        try {
            return (String) mFileTypes.get(getFileHeader(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            C0029a.m806a(e);
            return "unknown";
        }
    }

    public static String getFileType(InputStream inputStream) {
        return (String) mFileTypes.get(getFileHeader(inputStream));
    }

    public static String getFileType(String str) {
        try {
            return (String) mFileTypes.get(getFileHeader(new FileInputStream(str)));
        } catch (FileNotFoundException e) {
            C0029a.m806a(e);
            return "unknown";
        }
    }

    public static byte[] readAll(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static byte[] readAsset(Context context, String str) {
        InputStream open = context.getAssets().open(str);
        byte[] readAll = readAll(open);
        open.close();
        return readAll;
    }

    public static byte[] readZip(String str, String str2) {
        ZipFile zipFile = new ZipFile(str);
        return readAll(zipFile.getInputStream(zipFile.getEntry(str2)));
    }

    public static void rmDir(File file, String str) {
        if (file.isDirectory()) {
            for (File rmDir : file.listFiles()) {
                rmDir(rmDir, str);
            }
            file.delete();
        }
        if (file.getName().endsWith(str)) {
            file.delete();
        }
    }

    public static boolean rmDir(File file) {
        if (file.isDirectory()) {
            for (File rmDir : file.listFiles()) {
                rmDir(rmDir);
            }
        }
        return file.delete();
    }

    public static void unZip(String str) {
        unZip(str, new File(str).getParent(), BuildConfig.FLAVOR);
    }

    public static void unZip(String str, String str2) {
        unZip(str, str2, BuildConfig.FLAVOR);
    }

    public static void unZip(String str, String str2, String str3) {
        ZipFile zipFile = new ZipFile(str);
        Enumeration entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            String name = zipEntry.getName();
            if (name.startsWith(str3)) {
                if (zipEntry.isDirectory()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(File.separator);
                    sb.append(name);
                    File file = new File(sb.toString());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(File.separator);
                    sb2.append(name);
                    File parentFile = new File(sb2.toString()).getParentFile();
                    if (parentFile.exists() || parentFile.mkdirs()) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(File.separator);
                        sb3.append(name);
                        FileOutputStream fileOutputStream = new FileOutputStream(sb3.toString());
                        InputStream inputStream = zipFile.getInputStream(zipEntry);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.close();
                        inputStream.close();
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("create file ");
                        sb4.append(parentFile.getName());
                        sb4.append(" fail");
                        throw new RuntimeException(sb4.toString());
                    }
                }
            }
        }
        zipFile.close();
    }

    public static void unZip(String str, boolean z) {
        if (!z) {
            unZip(str);
            return;
        }
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf > 0) {
            name = name.substring(0, lastIndexOf);
        }
        int indexOf = name.indexOf("_");
        if (indexOf > 0) {
            name = name.substring(0, indexOf);
        }
        int indexOf2 = name.indexOf("(");
        if (indexOf2 > 0) {
            name = name.substring(0, indexOf2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(new File(str).getParent());
        sb.append(File.separator);
        sb.append(name);
        unZip(str, sb.toString(), BuildConfig.FLAVOR);
    }

    public static boolean zip(String str) {
        return zip(str, new File(str).getParent());
    }

    public static boolean zip(String str, String str2) {
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        sb.append(file.getName());
        sb.append(".zip");
        return zip(str, str2, sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0073 A[SYNTHETIC, Splitter:B:38:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081 A[SYNTHETIC, Splitter:B:46:0x0081] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:42:0x007b=Splitter:B:42:0x007b, B:23:0x005c=Splitter:B:23:0x005c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zip(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            java.io.File r3 = new java.io.File
            r3.<init>(r4, r5)
            java.io.File r4 = r3.getParentFile()
            boolean r4 = r4.exists()
            r5 = 0
            if (r4 != 0) goto L_0x0020
            java.io.File r4 = r3.getParentFile()
            boolean r4 = r4.mkdirs()
            if (r4 != 0) goto L_0x0020
            return r5
        L_0x0020:
            boolean r4 = r3.exists()
            if (r4 == 0) goto L_0x002b
            r3.createNewFile()     // Catch:{ IOException -> 0x002a }
            goto L_0x002b
        L_0x002a:
            return r5
        L_0x002b:
            r4 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x006d }
            r1.<init>(r3)     // Catch:{ FileNotFoundException -> 0x006d }
            java.util.zip.CheckedOutputStream r3 = new java.util.zip.CheckedOutputStream     // Catch:{ FileNotFoundException -> 0x006d }
            java.util.zip.Adler32 r2 = new java.util.zip.Adler32     // Catch:{ FileNotFoundException -> 0x006d }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x006d }
            r3.<init>(r1, r2)     // Catch:{ FileNotFoundException -> 0x006d }
            java.util.zip.ZipOutputStream r1 = new java.util.zip.ZipOutputStream     // Catch:{ FileNotFoundException -> 0x006d }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x006d }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x006d }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x006d }
            java.lang.String r4 = ""
            m2300a(r0, r1, r4)     // Catch:{ FileNotFoundException -> 0x0068, all -> 0x0065 }
            java.util.zip.Checksum r3 = r3.getChecksum()     // Catch:{ FileNotFoundException -> 0x0068, all -> 0x0065 }
            r3.getValue()     // Catch:{ FileNotFoundException -> 0x0068, all -> 0x0065 }
            r5 = 1
            if (r1 == 0) goto L_0x007e
            r1.closeEntry()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r3 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r3)
        L_0x005c:
            r1.close()     // Catch:{ IOException -> 0x0060 }
            return r5
        L_0x0060:
            r3 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r3)
            return r5
        L_0x0065:
            r3 = move-exception
            r4 = r1
            goto L_0x007f
        L_0x0068:
            r3 = move-exception
            r4 = r1
            goto L_0x006e
        L_0x006b:
            r3 = move-exception
            goto L_0x007f
        L_0x006d:
            r3 = move-exception
        L_0x006e:
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r3)     // Catch:{ all -> 0x006b }
            if (r4 == 0) goto L_0x007e
            r4.closeEntry()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r3 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r3)
        L_0x007b:
            r4.close()     // Catch:{ IOException -> 0x0060 }
        L_0x007e:
            return r5
        L_0x007f:
            if (r4 == 0) goto L_0x0091
            r4.closeEntry()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r5 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r5)
        L_0x0089:
            r4.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r4 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r4)
        L_0x0091:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaUtil.zip(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public int checkPixel(int i, int i2, int[][] iArr) {
        int i3 = iArr[i][i2];
        if (i2 + 30 < iArr[i].length) {
            int i4 = 0;
            for (int i5 = 1; i5 <= 30; i5++) {
                if (iArr[i][i2 + i5] == 0) {
                    i4++;
                }
            }
            if (i4 > 15) {
                return 0;
            }
        }
        return i3;
    }

    public int getDifferenceValue(String str, String str2) {
        new File(str);
        new File(str2);
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Bitmap decodeFile2 = BitmapFactory.decodeFile(str2);
            int width = decodeFile.getWidth();
            int height = decodeFile.getHeight();
            int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{width, height});
            for (int i = 1; i < width; i++) {
                for (int i2 = 1; i2 < height; i2++) {
                    if (decodeFile.getPixel(i, i2) == decodeFile2.getPixel(i, i2)) {
                        iArr[i - 1][i2 - 1] = 0;
                    } else {
                        iArr[i - 1][i2 - 1] = 1;
                    }
                }
            }
            int i3 = -1;
            int i4 = 0;
            int i5 = 999;
            while (i4 < iArr.length) {
                int i6 = i3;
                for (int i7 = 0; i7 < iArr[i4].length; i7++) {
                    if (iArr[i4][i7] == 1) {
                        iArr[i4][i7] = checkPixel(i4, i7, iArr);
                        if (iArr[i4][i7] == 1) {
                            if (i4 > i6) {
                                i6 = i4;
                            } else if (i4 < i5) {
                                i5 = i4;
                            }
                        }
                    }
                }
                i4++;
                i3 = i6;
            }
            return (i3 + i5) / 2;
        } catch (Exception e) {
            C0029a.m806a(e);
            return 0;
        }
    }

    public BitmapDrawable toBlack(String str, float f, int i, int i2) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        int width = decodeFile.getWidth();
        int height = decodeFile.getHeight();
        Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        int i3 = width * height;
        int[] iArr = new int[i3];
        float[] fArr = new float[i3];
        float[] fArr2 = new float[3];
        int i4 = 0;
        float f2 = 0.0f;
        while (i4 < height) {
            float f3 = f2;
            for (int i5 = 0; i5 < width; i5++) {
                Color.colorToHSV(decodeFile.getPixel(i5, i4), fArr2);
                fArr[(width * i4) + i5] = fArr2[2];
                f3 += fArr2[2];
            }
            i4++;
            f2 = f3;
        }
        float f4 = (f2 / ((float) i3)) * f;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, new int[]{width, height});
        for (int i6 = 0; i6 < height; i6++) {
            for (int i7 = 0; i7 < width; i7++) {
                int i8 = (width * i6) + i7;
                if (fArr[i8] > f4) {
                    iArr[i8] = -1;
                    iArr2[i7][i6] = 1;
                } else {
                    iArr[i8] = -16777216;
                    iArr2[i7][i6] = 0;
                }
            }
        }
        for (int i9 = width / 2; i9 < width - 10; i9++) {
            int i10 = width / 3;
            while (true) {
                if (i10 >= width) {
                    break;
                } else if (m2301a(i9, i10, iArr2, i, i2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i9);
                    sb.append(BuildConfig.FLAVOR);
                    Log.i("find_color", sb.toString());
                    break;
                } else {
                    i10++;
                }
            }
        }
        return new BitmapDrawable(Bitmap.createBitmap(iArr, width, height, Bitmap.Config.RGB_565));
    }
}
