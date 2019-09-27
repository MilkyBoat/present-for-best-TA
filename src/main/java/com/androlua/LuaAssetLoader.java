package com.androlua;

import android.content.Context;
import com.luajava.JavaFunction;
import com.luajava.LuaState;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LuaAssetLoader extends JavaFunction {

    /* renamed from: a */
    private LuaState f2396a;

    /* renamed from: c */
    private Context f2397c;

    public LuaAssetLoader(LuaContext luaContext, LuaState luaState) {
        super(luaState);
        this.f2396a = luaState;
        this.f2397c = luaContext.getContext();
    }

    /* renamed from: a */
    private static byte[] m2181a(InputStream inputStream) {
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

    public int execute() {
        String luaState = this.f2396a.toString(-1);
        StringBuilder sb = new StringBuilder();
        sb.append(luaState.replace('.', '/'));
        sb.append(".lua");
        String sb2 = sb.toString();
        try {
            if (this.f2396a.LloadBuffer(readAsset(sb2), sb2) != 0) {
                LuaState luaState2 = this.f2396a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\n\t");
                sb3.append(this.f2396a.toString(-1));
                luaState2.pushString(sb3.toString());
            }
            return 1;
        } catch (IOException unused) {
            LuaState luaState3 = this.f2396a;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("\n\tno file '/assets/");
            sb4.append(sb2);
            sb4.append("'");
            luaState3.pushString(sb4.toString());
            return 1;
        }
    }

    public byte[] readAsset(String str) {
        InputStream open = this.f2397c.getAssets().open(str);
        byte[] a = m2181a(open);
        open.close();
        return a;
    }
}
