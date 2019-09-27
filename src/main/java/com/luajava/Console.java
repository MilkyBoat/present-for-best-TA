package com.luajava;

import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Console {
    public static void main(String[] strArr) {
        try {
            LuaState newLuaState = LuaStateFactory.newLuaState();
            newLuaState.openLibs();
            if (strArr.length > 0) {
                for (int i = 0; i < strArr.length; i++) {
                    int LloadFile = newLuaState.LloadFile(strArr[i]);
                    if (LloadFile == 0) {
                        LloadFile = newLuaState.pcall(0, 0, 0);
                    }
                    if (LloadFile != 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error on file: ");
                        sb.append(strArr[i]);
                        sb.append(". ");
                        sb.append(newLuaState.toString(-1));
                        throw new LuaException(sb.toString());
                    }
                }
                return;
            }
            System.out.println("API Lua Java - console mode.");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            PrintStream printStream = System.out;
            String str = "> ";
            while (true) {
                printStream.print(str);
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.equals("exit")) {
                    newLuaState.close();
                } else {
                    int LloadBuffer = newLuaState.LloadBuffer(readLine.getBytes(), "from console");
                    if (LloadBuffer == 0) {
                        LloadBuffer = newLuaState.pcall(0, 0, 0);
                    }
                    if (LloadBuffer != 0) {
                        PrintStream printStream2 = System.err;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Error on line: ");
                        sb2.append(readLine);
                        printStream2.println(sb2.toString());
                        System.err.println(newLuaState.toString(-1));
                    }
                    printStream = System.out;
                    str = "> ";
                }
            }
            newLuaState.close();
        } catch (Exception e) {
            C0029a.m806a(e);
        }
    }
}
