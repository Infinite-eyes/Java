package demo.file;

import java.io.File;

public class FileTest {


    public static void main(String args[]) {
        File file1 = new File(" ./test1.txt ");
//        File file2 = new File(" D://workspace//test//test1.txt ");
        File file2 = new File(" /Users/chenweiming ");

        System.out.println(" -----默认相对路径：取得路径不同------ ");
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(" -----默认绝对路径:取得路径相同------ ");
        System.out.println(file2.getPath());
        System.out.println(file2.getAbsolutePath());
    }

}
