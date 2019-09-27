package com.androlua;

import android.util.Log;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class LuaClient implements LuaGcable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnReadLineListener f2437a;

    /* renamed from: b */
    private Socket f2438b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public BufferedReader f2439c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public BufferedWriter f2440d;

    /* renamed from: e */
    private boolean f2441e;

    public interface OnReadLineListener {
        void onReadLine(LuaClient luaClient, SocketThread socketThread, String str);
    }

    private class SocketThread extends Thread {

        /* renamed from: b */
        private final Socket f2443b;

        public SocketThread(Socket socket) {
            this.f2443b = socket;
        }

        public boolean close() {
            try {
                this.f2443b.close();
                return true;
            } catch (Exception e) {
                C0029a.m806a(e);
                return false;
            }
        }

        public boolean flush() {
            try {
                LuaClient.this.f2440d.flush();
                return true;
            } catch (Exception e) {
                C0029a.m806a(e);
                return false;
            }
        }

        public boolean newLine() {
            try {
                LuaClient.this.f2440d.newLine();
                LuaClient.this.f2440d.flush();
                return true;
            } catch (Exception e) {
                C0029a.m806a(e);
                return false;
            }
        }

        public void run() {
            while (true) {
                try {
                    String readLine = LuaClient.this.f2439c.readLine();
                    if (readLine == null) {
                        return;
                    }
                    if (LuaClient.this.f2437a != null) {
                        LuaClient.this.f2437a.onReadLine(LuaClient.this, this, readLine);
                    }
                } catch (Exception e) {
                    C0029a.m806a(e);
                    return;
                }
            }
        }

        public boolean write(String str) {
            try {
                Log.i("lua", str);
                LuaClient.this.f2440d.write(str);
                return true;
            } catch (Exception e) {
                C0029a.m806a(e);
                return false;
            }
        }
    }

    public LuaClient() {
    }

    public LuaClient(LuaContext luaContext) {
        luaContext.regGc(this);
    }

    public boolean flush() {
        try {
            this.f2440d.flush();
            return true;
        } catch (Exception e) {
            C0029a.m806a(e);
            return false;
        }
    }

    /* renamed from: gc */
    public void mo2151gc() {
        stop();
        this.f2441e = true;
    }

    public boolean isGc() {
        return this.f2441e;
    }

    public boolean newLine() {
        try {
            this.f2440d.newLine();
            this.f2440d.flush();
            return true;
        } catch (Exception e) {
            C0029a.m806a(e);
            return false;
        }
    }

    public void setOnReadLineListener(OnReadLineListener onReadLineListener) {
        this.f2437a = onReadLineListener;
    }

    public boolean start(String str, int i) {
        if (this.f2438b != null) {
            return false;
        }
        try {
            this.f2438b = new Socket(str, i);
            this.f2439c = new BufferedReader(new InputStreamReader(this.f2438b.getInputStream()));
            this.f2440d = new BufferedWriter(new OutputStreamWriter(this.f2438b.getOutputStream()));
            new SocketThread(this.f2438b).start();
            return true;
        } catch (IOException e) {
            C0029a.m806a(e);
            return false;
        }
    }

    public boolean stop() {
        if (this.f2438b == null) {
            return false;
        }
        try {
            this.f2438b.close();
            return true;
        } catch (Exception e) {
            C0029a.m806a(e);
            return false;
        }
    }

    public boolean write(String str) {
        try {
            this.f2440d.write(str);
            return true;
        } catch (Exception e) {
            C0029a.m806a(e);
            return false;
        }
    }
}
