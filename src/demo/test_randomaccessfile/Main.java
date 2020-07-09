package demo.test_randomaccessfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class Main {

    public static void main(String[] args) {
        writeByte();
        writeString();
        writeStringWithOffset();
    }


    public static void writeByte() {

        try {
            RandomAccessFile accessFile = new RandomAccessFile("writeByte.txt", "rw");
//            accessFile.writeUTF("97");
            accessFile.write(97);
            accessFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeString() {

        try {
            RandomAccessFile accessFile = new RandomAccessFile("writeString.txt", "rw");
//            accessFile.write("你喜欢Java不".getBytes());
            accessFile.writeUTF("你喜欢Java不");
            accessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeStringWithOffset() {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("writeStringWithOffset.tex", "rw");
            accessFile.write("hello".getBytes(), 1, 3);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}




