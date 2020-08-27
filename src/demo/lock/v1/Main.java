package demo.lock.v1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

//https://www.cnblogs.com/jyroy/p/11365935.html
public class Main {

    //悲观锁

    public synchronized void testMethod() {

    }

    //悲观锁
    private ReentrantLock lock = new ReentrantLock();

    public void modifyPublicResources() {
        lock.lock();
//        操作同步资源
        lock.unlock();
    }


    //乐观锁CAS  Compare And Swap（比较与交换)

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(); //需要保证多个线程使用同一个atomic integer
        atomicInteger.incrementAndGet();
//        unsafe： 获取并操作内存的数据。
//        valueOffset： 存储value在AtomicInteger中的偏移量。
//        value： 存储AtomicInteger的int值，该属性需要借助volatile关键字保证其在线程间是可见的。

    }

}
