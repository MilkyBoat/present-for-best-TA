package com.androlua;

import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class LuaServer implements LuaGcable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ServerSocket f2592a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnReadLineListener f2593b;

    /* renamed from: c */
    private boolean f2594c;

    public interface OnReadLineListener {
        void onReadLine(LuaServer luaServer, SocketThread socketThread, String str);
    }

    private class ServerThread extends Thread {

        /* renamed from: b */
        private final ServerSocket f2596b;

        public ServerThread(ServerSocket serverSocket) {
            this.f2596b = serverSocket;
        }

        public void run() {
            while (true) {
                try {
                    new SocketThread(LuaServer.this.f2592a.accept()).start();
                } catch (Exception e) {
                    C0029a.m806a(e);
                }
            }
        }
    }

    private class SocketThread extends Thread {

        /* renamed from: b */
        private final Socket f2598b;

        /* renamed from: c */
        private BufferedWriter f2599c;

        public SocketThread(Socket socket) {
            this.f2598b = socket;
        }

        public boolean close() {
            try {
                this.f2598b.close();
                return true;
            } catch (Exception e) {
                C0029a.m806a(e);
                return false;
            }
        }

        public boolean flush() {
            try {
                this.f2599c.flush();
                return true;
            } catch (Exception e) {
                C0029a.m806a(e);
                return false;
            }
        }

        public boolean newLine() {
            try {
                this.f2599c.newLine();
                this.f2599c.flush();
                return true;
            } catch (Exception e) {
                C0029a.m806a(e);
                return false;
            }
        }

        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f2598b.getInputStream()));
                this.f2599c = new BufferedWriter(new OutputStreamWriter(this.f2598b.getOutputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return;
                    }
                    if (LuaServer.this.f2593b != null) {
                        LuaServer.this.f2593b.onReadLine(LuaServer.this, this, readLine);
                    }
                }
            } catch (Exception e) {
                C0029a.m806a(e);
            }
        }

        public boolean write(String str) {
            try {
                this.f2599c.write(str);
                return true;
            } catch (Exception e) {
                C0029a.m806a(e);
                return false;
            }
        }
    }

    public LuaServer() {
    }

    public LuaServer(LuaContext luaContext) {
        luaContext.regGc(this);
    }

    /* renamed from: gc */
    public void mo2151gc() {
        if (this.f2592a != null) {
            try {
                this.f2592a.close();
            } catch (Exception e) {
                C0029a.m806a(e);
            }
            this.f2594c = true;
        }
    }

    public boolean isGc() {
        return this.f2594c;
    }

    public void setOnReadLineListener(OnReadLineListener onReadLineListener) {
        this.f2593b = onReadLineListener;
    }

    public boolean start(int i) {
        if (this.f2592a != null) {
            return false;
        }
        try {
            this.f2592a = new ServerSocket(i);
            new ServerThread(this.f2592a).start();
            return true;
        } catch (Exception e) {
            C0029a.m806a(e);
            return false;
        }
    }

    public boolean stop() {
        try {
            this.f2592a.close();
            this.f2592a = null;
            return true;
        } catch (Exception e) {
            C0029a.m806a(e);
            return false;
        }
    }
}
