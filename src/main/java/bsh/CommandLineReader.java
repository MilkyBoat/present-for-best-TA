package bsh;

import java.io.FilterReader;
import java.io.InputStreamReader;
import java.io.Reader;

class CommandLineReader extends FilterReader {

    /* renamed from: a */
    int f554a = 1;

    public CommandLineReader(Reader reader) {
        super(reader);
    }

    public static void main(String[] strArr) {
        while (true) {
            System.out.println(new CommandLineReader(new InputStreamReader(System.in)).read());
        }
    }

    public int read() {
        int read;
        if (this.f554a == 2) {
            this.f554a = 1;
            return 10;
        }
        do {
            read = this.in.read();
        } while (read == 13);
        if (read != 10) {
            this.f554a = 0;
            return read;
        } else if (this.f554a == 1) {
            this.f554a = 2;
            return 59;
        } else {
            this.f554a = 1;
            return read;
        }
    }

    public int read(char[] cArr, int i, int i2) {
        int read = read();
        if (read == -1) {
            return -1;
        }
        cArr[i] = (char) read;
        return 1;
    }
}
