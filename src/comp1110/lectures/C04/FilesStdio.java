package comp1110.lectures.C04;

import java.io.IOException;

public class FilesStdio {
    public static void main(String[] args) {
        try {
            int b;
            do {
                b = System.in.read();

                //System.out.write(b);
                System.out.println(String.format("%02X", b));
                System.out.flush();
            } while (b != -1); // b != 0xffffffff
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
