package demo.lock;

public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {

//        多线程之间按顺序调用, 实现 A->B->C 三个线程启动, 要求如下：
//        AA打印5次, BB打印10次, CC打印15次

        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print5();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print10();
            }
        }, "BB").start();


        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print15();
            }
        }, "CC").start();


    }

}
