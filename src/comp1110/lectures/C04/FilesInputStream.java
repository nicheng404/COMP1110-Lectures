package comp1110.lectures.C04;

import java.io.FileInputStream;
import java.io.IOException;

public class FilesInputStream {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("assets/hamlet.txt")) {
            for (int i = 0; i < 100; i++) {
                byte b = (byte) in.read();
                System.out.write(b);
            }
            System.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
