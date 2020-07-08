package demo.printtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2);
        Lock lock = new ReentrantLock(false);
        Runnable t1 = new MyRunnable("张三", 2000);
        Runnable t2 = new MyRunnable("李四", 3600);
        Runnable t3 = new MyRunnable("李五", 2700);
        Runnable t4 = new MyRunnable("李六", 600);
        Runnable t5 = new MyRunnable("李七", 1300);
        Runnable t6 = new MyRunnable("李八", 800);


//        Runnable t1 = new MyRunnable("张三", 2000, lock);
//        Runnable t2 = new MyRunnable("李四", 3600, lock);
//        Runnable t3 = new MyRunnable("李五", 2700, lock);
//        Runnable t4 = new MyRunnable("李六", 600, lock);
//        Runnable t5 = new MyRunnable("李七", 1300, lock);
//        Runnable t6 = new MyRunnable("李八", 800, lock);


        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);

        pool.shutdown();
    }


}


class MyRunnable implements Runnable {

    private static AtomicLong aLong = new AtomicLong(10000);
    private Lock lock;
    private String name;
    private int data;

    MyRunnable(String name, int data) {
//    MyRunnable(String name, int data, Lock lock) {
        this.name = name;
        this.data = data;
        this.lock = lock;
    }


    @Override
    public void run() {
//        lock.lock();
//        System.out.println(name + "运行了" + data + "，当前剩余金额：" + aLong.addAndGet(data));
//        lock.unlock();
//        该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
        Thread.yield();
        System.out.println(name + "运行了" + data + "。当前剩余金额：" + aLong.addAndGet(data));

    }
}
