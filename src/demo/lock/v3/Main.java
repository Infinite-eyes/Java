package demo.lock.v3;

public class Main {


//    public static void main(String[] args) {
//        System.out.println("Main 线程 开始运行！");
//
//        Thread t1 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("t1 开始运行！");
//                System.out.println("t1 结束运行！");
//            }
//        };
//        t1.start();
//
//        System.out.println("Main 线程 结束运行！");
//
//    }

    public static void main(String[] args) {
        System.out.println("Main 线程 开始运行！");

        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("t1 开始运行！");
                System.out.println("t1 结束运行！");
            }
        };
        try {
            t1.start();
            t1.join();
        } catch (Exception e) {

        }
        System.out.println("Main 线程 结束运行！");
    }


}
