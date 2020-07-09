package demo.test_randomaccessfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo2 {

    public static void main(String[] args) {
        read();
        readBytes();
    }


    public static void read() {

        try {
            RandomAccessFile raf = new RandomAccessFile("writeByte.txt", "r");
            System.out.println((char) raf.read());
//            System.out.println(raf.readUTF());
            raf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readBytes() {

        try {
            RandomAccessFile raf = new RandomAccessFile("writeString.txt", "r");
            byte[] bytes = new byte[10];
//            int len = raf.read(bytes);
//            System.out.println("读取到的实际字节长度 " + len);
//            System.out.println(new String(bytes));
            System.out.println(raf.readUTF());
            raf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
