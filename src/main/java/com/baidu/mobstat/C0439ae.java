package com.baidu.mobstat;

import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

/* renamed from: com.baidu.mobstat.ae */
class C0439ae extends ContextWrapper {
    public C0439ae() {
        super(null);
    }

    public File getDatabasePath(String str) {
        if (!"mounted".equals(C0507cs.m3081a())) {
            return null;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        sb.append(absolutePath);
        sb.append(File.separator);
        sb.append("backups/system");
        String sb2 = sb.toString();
        File file = new File(sb2);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(File.separator);
        sb3.append(str);
        File file2 = new File(sb3.toString());
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                C0465bd.m2913b((Throwable) e);
            }
        }
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
        File databasePath = getDatabasePath(str);
        if (databasePath != null && databasePath.canWrite()) {
            return SQLiteDatabase.openOrCreateDatabase(databasePath, null);
        }
        throw new RuntimeException("db path is null or path can not be write");
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        File databasePath = getDatabasePath(str);
        if (databasePath != null && databasePath.canWrite()) {
            return SQLiteDatabase.openOrCreateDatabase(databasePath, null);
        }
        throw new RuntimeException("db path is null or path can not be write");
    }
}
