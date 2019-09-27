package com.androlua.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    /* renamed from: a */
    private static final Logger f2823a = Logger.getLogger(ZipUtil.class.getName());

    /* renamed from: b */
    private static final byte[] f2824b = new byte[4096];

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b A[SYNTHETIC, Splitter:B:25:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065 A[SYNTHETIC, Splitter:B:32:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0070 A[SYNTHETIC, Splitter:B:39:0x0070] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0060=Splitter:B:29:0x0060, B:22:0x0056=Splitter:B:22:0x0056} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m2386a(java.io.File r5, java.util.zip.ZipOutputStream r6, java.lang.String r7) {
        /*
            boolean r0 = r5.isFile()
            r1 = 0
            if (r0 == 0) goto L_0x0079
            r0 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x0055 }
            r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x0055 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x0055 }
            byte[] r4 = f2824b     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x0055 }
            int r4 = r4.length     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x0055 }
            r3.<init>(r2, r4)     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x0055 }
            java.lang.String r0 = r5.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            int r7 = r0.indexOf(r7)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            java.lang.String r5 = r5.substring(r7)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            java.io.PrintStream r7 = java.lang.System.out     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            r7.println(r5)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            java.util.zip.ZipEntry r7 = new java.util.zip.ZipEntry     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            r7.<init>(r5)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            r6.putNextEntry(r7)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
        L_0x0032:
            byte[] r5 = f2824b     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            byte[] r7 = f2824b     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            int r7 = r7.length     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            int r5 = r3.read(r5, r1, r7)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            r7 = -1
            if (r5 == r7) goto L_0x0044
            byte[] r7 = f2824b     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            r6.write(r7, r1, r5)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x004a }
            goto L_0x0032
        L_0x0044:
            if (r3 == 0) goto L_0x0093
            r3.close()     // Catch:{ IOException -> 0x0069 }
            return
        L_0x004a:
            r5 = move-exception
            goto L_0x006e
        L_0x004c:
            r5 = move-exception
            r0 = r3
            goto L_0x0056
        L_0x004f:
            r5 = move-exception
            r0 = r3
            goto L_0x0060
        L_0x0052:
            r5 = move-exception
            r3 = r0
            goto L_0x006e
        L_0x0055:
            r5 = move-exception
        L_0x0056:
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r5)     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0093
            r0.close()     // Catch:{ IOException -> 0x0069 }
            return
        L_0x005f:
            r5 = move-exception
        L_0x0060:
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r5)     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0093
            r0.close()     // Catch:{ IOException -> 0x0069 }
            return
        L_0x0069:
            r5 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r5)
            return
        L_0x006e:
            if (r3 == 0) goto L_0x0078
            r3.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r6 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r6)
        L_0x0078:
            throw r5
        L_0x0079:
            boolean r0 = r5.isDirectory()
            if (r0 == 0) goto L_0x0093
            java.io.File[] r5 = r5.listFiles()
            if (r5 == 0) goto L_0x0093
            int r0 = r5.length
            if (r0 <= 0) goto L_0x0093
            int r0 = r5.length
        L_0x0089:
            if (r1 >= r0) goto L_0x0093
            r2 = r5[r1]
            m2386a(r2, r6, r7)
            int r1 = r1 + 1
            goto L_0x0089
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.util.ZipUtil.m2386a(java.io.File, java.util.zip.ZipOutputStream, java.lang.String):void");
    }

    public static void append(String str, String str2) {
        ZipFile zipFile = new ZipFile(str);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
        Enumeration entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("copy: ");
            sb.append(zipEntry.getName());
            printStream.println(sb.toString());
            zipOutputStream.putNextEntry(zipEntry);
            if (!zipEntry.isDirectory()) {
                copy(zipFile.getInputStream(zipEntry), zipOutputStream);
            }
            zipOutputStream.closeEntry();
        }
        ZipEntry zipEntry2 = new ZipEntry(str2);
        PrintStream printStream2 = System.out;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("append: ");
        sb2.append(zipEntry2.getName());
        printStream2.println(sb2.toString());
        zipOutputStream.putNextEntry(zipEntry2);
        copy(new FileInputStream(new File(str2)), zipOutputStream);
        zipOutputStream.closeEntry();
        zipFile.close();
        zipOutputStream.close();
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) {
        while (true) {
            int read = inputStream.read(f2824b);
            if (read != -1) {
                outputStream.write(f2824b, 0, read);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ed, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ee, code lost:
        if (r2 == null) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f4, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f5, code lost:
        com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r4);
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010a A[SYNTHETIC, Splitter:B:44:0x010a] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0114 A[SYNTHETIC, Splitter:B:50:0x0114] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0129 A[SYNTHETIC, Splitter:B:58:0x0129] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:41:0x0105=Splitter:B:41:0x0105, B:47:0x010f=Splitter:B:47:0x010f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean unzip(java.io.File r4, java.lang.String r5) {
        /*
            boolean r0 = r4.exists()
            r1 = 0
            if (r0 != 0) goto L_0x0022
            java.util.logging.Logger r5 = f2823a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = r4.getName()
            r0.append(r4)
            java.lang.String r4 = " doesn't exist."
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.info(r4)
            return r1
        L_0x0022:
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x004e
            boolean r2 = r0.mkdirs()
            if (r2 != 0) goto L_0x004e
            java.util.logging.Logger r4 = f2823a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = "cann't create file "
            r5.append(r2)
            java.lang.String r0 = r0.getName()
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.info(r5)
            return r1
        L_0x004e:
            r0 = 0
            java.util.logging.Logger r2 = f2823a
            java.lang.String r3 = "start unzip file ..."
            r2.info(r3)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x010e, IOException -> 0x0104 }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x010e, IOException -> 0x0104 }
            java.util.zip.CheckedInputStream r4 = new java.util.zip.CheckedInputStream     // Catch:{ FileNotFoundException -> 0x010e, IOException -> 0x0104 }
            java.util.zip.Adler32 r3 = new java.util.zip.Adler32     // Catch:{ FileNotFoundException -> 0x010e, IOException -> 0x0104 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x010e, IOException -> 0x0104 }
            r4.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x010e, IOException -> 0x0104 }
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch:{ FileNotFoundException -> 0x010e, IOException -> 0x0104 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x010e, IOException -> 0x0104 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x010e, IOException -> 0x0104 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x010e, IOException -> 0x0104 }
        L_0x006f:
            java.util.zip.ZipEntry r4 = r2.getNextEntry()     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            if (r4 == 0) goto L_0x00ed
            java.lang.String r4 = r4.getName()     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r0.append(r5)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            java.lang.String r3 = "/"
            r0.append(r3)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r0.append(r4)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            java.lang.String r4 = r0.toString()     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            java.io.PrintStream r0 = java.lang.System.out     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r0.println(r4)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            java.io.File r0 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r0.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            java.io.File r0 = r0.getParentFile()     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            boolean r3 = r0.exists()     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            if (r3 != 0) goto L_0x00c7
            boolean r3 = r0.mkdirs()     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            if (r3 != 0) goto L_0x00c7
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            java.lang.String r3 = "create file "
            r5.append(r3)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            java.lang.String r0 = r0.getName()     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            java.lang.String r0 = " fail"
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            throw r4     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
        L_0x00c7:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r0.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            byte[] r3 = f2824b     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            int r3 = r3.length     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r4.<init>(r0, r3)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
        L_0x00d4:
            byte[] r0 = f2824b     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            byte[] r3 = f2824b     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            int r3 = r3.length     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            int r0 = r2.read(r0, r1, r3)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r3 = -1
            if (r0 == r3) goto L_0x00e6
            byte[] r3 = f2824b     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r4.write(r3, r1, r0)     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            goto L_0x00d4
        L_0x00e6:
            r4.flush()     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            r4.close()     // Catch:{ FileNotFoundException -> 0x00fe, IOException -> 0x00fb, all -> 0x00f9 }
            goto L_0x006f
        L_0x00ed:
            r1 = 1
            if (r2 == 0) goto L_0x0117
            r2.close()     // Catch:{ IOException -> 0x00f4 }
            goto L_0x0117
        L_0x00f4:
            r4 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r4)
            goto L_0x0117
        L_0x00f9:
            r4 = move-exception
            goto L_0x0127
        L_0x00fb:
            r4 = move-exception
            r0 = r2
            goto L_0x0105
        L_0x00fe:
            r4 = move-exception
            r0 = r2
            goto L_0x010f
        L_0x0101:
            r4 = move-exception
            r2 = r0
            goto L_0x0127
        L_0x0104:
            r4 = move-exception
        L_0x0105:
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r4)     // Catch:{ all -> 0x0101 }
            if (r0 == 0) goto L_0x0117
            r0.close()     // Catch:{ IOException -> 0x00f4 }
            goto L_0x0117
        L_0x010e:
            r4 = move-exception
        L_0x010f:
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r4)     // Catch:{ all -> 0x0101 }
            if (r0 == 0) goto L_0x0117
            r0.close()     // Catch:{ IOException -> 0x00f4 }
        L_0x0117:
            if (r1 == 0) goto L_0x0121
            java.util.logging.Logger r4 = f2823a
            java.lang.String r5 = "done."
        L_0x011d:
            r4.info(r5)
            return r1
        L_0x0121:
            java.util.logging.Logger r4 = f2823a
            java.lang.String r5 = "fail."
            goto L_0x011d
            return r1
        L_0x0127:
            if (r2 == 0) goto L_0x0131
            r2.close()     // Catch:{ IOException -> 0x012d }
            goto L_0x0131
        L_0x012d:
            r5 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r5)
        L_0x0131:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.util.ZipUtil.unzip(java.io.File, java.lang.String):boolean");
    }

    public static boolean unzip(String str, String str2) {
        return unzip(new File(str), str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e3 A[SYNTHETIC, Splitter:B:41:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0100 A[SYNTHETIC, Splitter:B:53:0x0100] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:45:0x00eb=Splitter:B:45:0x00eb, B:28:0x00cc=Splitter:B:28:0x00cc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zip(java.lang.String r4, java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 != 0) goto L_0x0023
            java.util.logging.Logger r5 = f2823a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r4 = " doesn't exist."
        L_0x0018:
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.info(r4)
            return r2
        L_0x0023:
            boolean r1 = r0.isDirectory()
            if (r1 != 0) goto L_0x0036
            java.util.logging.Logger r5 = f2823a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r4 = " is not a directory."
            goto L_0x0018
        L_0x0036:
            java.io.File r4 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r5 = "/"
            r1.append(r5)
            java.lang.String r5 = r0.getName()
            r1.append(r5)
            java.lang.String r5 = ".zip"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r4.<init>(r5)
            boolean r5 = r4.exists()
            if (r5 == 0) goto L_0x006f
            java.util.logging.Logger r5 = f2823a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = r4.getName()
            r0.append(r4)
            java.lang.String r4 = " is already exist."
            goto L_0x0018
        L_0x006f:
            java.io.File r5 = r4.getParentFile()
            boolean r5 = r5.exists()
            if (r5 != 0) goto L_0x0094
            java.io.File r5 = r4.getParentFile()
            boolean r5 = r5.mkdirs()
            if (r5 != 0) goto L_0x0094
            java.util.logging.Logger r5 = f2823a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "cann't create file "
            r0.append(r1)
            java.lang.String r4 = r4.getName()
            goto L_0x0018
        L_0x0094:
            java.util.logging.Logger r5 = f2823a
            java.lang.String r1 = "creating zip file..."
            r5.info(r1)
            r5 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00dd }
            r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00dd }
            java.util.zip.CheckedOutputStream r4 = new java.util.zip.CheckedOutputStream     // Catch:{ FileNotFoundException -> 0x00dd }
            java.util.zip.Adler32 r3 = new java.util.zip.Adler32     // Catch:{ FileNotFoundException -> 0x00dd }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x00dd }
            r4.<init>(r1, r3)     // Catch:{ FileNotFoundException -> 0x00dd }
            java.util.zip.ZipOutputStream r1 = new java.util.zip.ZipOutputStream     // Catch:{ FileNotFoundException -> 0x00dd }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x00dd }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00dd }
            r1.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00dd }
            r4 = 8
            r1.setMethod(r4)     // Catch:{ FileNotFoundException -> 0x00d8, all -> 0x00d5 }
            java.lang.String r4 = r0.getName()     // Catch:{ FileNotFoundException -> 0x00d8, all -> 0x00d5 }
            m2386a(r0, r1, r4)     // Catch:{ FileNotFoundException -> 0x00d8, all -> 0x00d5 }
            r2 = 1
            if (r1 == 0) goto L_0x00ee
            r1.closeEntry()     // Catch:{ IOException -> 0x00c8 }
            goto L_0x00cc
        L_0x00c8:
            r4 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r4)
        L_0x00cc:
            r1.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x00ee
        L_0x00d0:
            r4 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r4)
            goto L_0x00ee
        L_0x00d5:
            r4 = move-exception
            r5 = r1
            goto L_0x00fe
        L_0x00d8:
            r4 = move-exception
            r5 = r1
            goto L_0x00de
        L_0x00db:
            r4 = move-exception
            goto L_0x00fe
        L_0x00dd:
            r4 = move-exception
        L_0x00de:
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r4)     // Catch:{ all -> 0x00db }
            if (r5 == 0) goto L_0x00ee
            r5.closeEntry()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x00eb
        L_0x00e7:
            r4 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r4)
        L_0x00eb:
            r5.close()     // Catch:{ IOException -> 0x00d0 }
        L_0x00ee:
            if (r2 == 0) goto L_0x00f8
            java.util.logging.Logger r4 = f2823a
            java.lang.String r5 = "done."
        L_0x00f4:
            r4.info(r5)
            return r2
        L_0x00f8:
            java.util.logging.Logger r4 = f2823a
            java.lang.String r5 = "fail."
            goto L_0x00f4
            return r2
        L_0x00fe:
            if (r5 == 0) goto L_0x0110
            r5.closeEntry()     // Catch:{ IOException -> 0x0104 }
            goto L_0x0108
        L_0x0104:
            r0 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r0)
        L_0x0108:
            r5.close()     // Catch:{ IOException -> 0x010c }
            goto L_0x0110
        L_0x010c:
            r5 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r5)
        L_0x0110:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.util.ZipUtil.zip(java.lang.String, java.lang.String):boolean");
    }
}
