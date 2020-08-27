package demo.lock.v2;

public class Test {


//    https://www.cnblogs.com/durenniu/p/10949491.html
    /**
     * synchronized  三种用法
     *    对象锁： 当使用synchronized 修改时类普通方法时，那么当前加锁的级别就是实例对象，当多个线程并发访问该对象的同步方法、同步代码块时、会进行同步。
     *    类锁 ：  当使用synchronized修饰类静态方法时，那么当前加锁的级别就是类，当多个线程并发访问该类（所有实例对象）的同步方法以及同步代码块时,会进行同步。
     *    代码块： 当使用synchronized修饰代码块时，那么当前加锁级别就是synchronized(X) 中配置的x对象实例，当多个线程并发访问该对象的同步方法，会进行同步。
     *            同步代码块要注意的是不要使用String类型对象，因为String常量池的存在，所以很容易导致出问题。
     *    synchronized实现原理
     *            synchronized与其他锁不同，他是内置再jvm中的，从jvm规范中看，
     *            jvm基于进入和退出monitor对象来实现方法个代码块的同步，但两者的实现细节不一样
     *            代码块同步是使用monitor enter和monitor exit指令实现的
     *            而方法同步是使用另外一种方式实现的。monitorenter指令是在编译后插入到同步代码块的开始位置，
     *            而monitor exit 是插入到方法结束处和异常处 jvm要保证每个monitor enter必须要有对应的monitor exit 与之配对。
     *            任何对象都有一个monitor 与之关联， 当且一个monitor 被持有后，它将处于锁定状态。线程执行到monitor enter 指令时
     *            将会尝试获取对象所对应的monitor的所有权,即尝试获得对象的锁
     *
     *            方法及的同步是隐式的，即无须通过字节码指令来控制，它实现的方法调用和返回操作之中。
     *            虚拟机可以从方法常量池的方法表结构中的的ACC_SYNCHRONIZED访问标志得知一个方法是否声明为同步方法。
     *            当方法调用时，调用指令会检查方法的ACC_SYNCHRONIZED访问标志是否被设置，如果设置了，执行线程就要求先成功持有管程，
     *            然后才能执行方法，最后当方法完成(无论是正常完成还是非正常完成)时释放管程。
     *            在方法执行期间，执行线程持有了管程，其他任何线程都无法再获取到同一个管程。
     *            如果一个同步方法执行期间抛出了异常, 并且在方法内部无法处理此异常，那么这个同步方法所持有的管程将在异常抛到同步方法之外时
     *            自动释放
     *
     *
     *
     */


    static final Test object = new Test();
    static final Test object1 = new Test();

    public static void main(String[] args) throws InterruptedException {

        Test t = new Test();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t.test();
            }
        }).start();
    }

    int a(int a) {
        if (a == 0) {
            throw new NullPointerException();
        } else {
            return a;
        }
    }

    public void test() {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getId() + "获得锁");
                Thread.sleep(3000);

                System.out.println(Thread.currentThread().getId() + "释放锁");
            } catch (InterruptedException e) {

            }
        }
    }





    /**
     *
     * volatile
     *       可见性
     *            我们知道volatile可以看做一种synchronized的轻量级锁，他能保证并发时，被它修饰的共享而是先将系统内存的数据读到内部缓存变量的可见性,
     *            那么他是如何实现可见性的呢？
     *
     *             我们从jmm的角度来看一下,每个线程拥有自己的工作内存，实际上线程所修改的共享变量是从主内存中拷贝的副本,
     *             当一个共享变量被volatile修饰时,它会保证修改的值会立即被更新到主存,当有其他线程需要读取时,它回去内存中读取新值
     *
     * 实现原理
     *        被volatile修饰的共享变量再进行读写操作的时候：
     *              1、讲当前处理器缓存行的数据协会到系统内存
     *              2、这个协会内存的操作将会使在其他cpu里缓存了该内存地址的数据无效。
     *
     *              为了提高处理速度，处理器不直接和内存进行通信，而是现将系统内存数据读到内部缓存(L1,L2或其他)后在进行操作,
     *              但操作完不知道何时会写到内存。如果对声明volatile的变量进行写操作,jvm就会向处理器发送一条lock前缀的指令,
     *              将这个变量所在缓存行的数据写回到系统内存。但是,就算写回到内存,如果其他处理器缓存的值还是旧的,在执行计算操作就胡有问题。
     *              所以在多处理器下,为了保证各个处理器的缓存是一致的,就会实现缓存一致性协议,每个处理器通过嗅探在总线上传播的数据来检查自己的缓存
     *              是不是过期了,当处理器发现自己的缓存行对应的内存地址被修改,就会将当前处理器的缓存行设置成无效状态。当处理器对这个数据进行修改操作的时候，
     *              会重新从系统内存中吧数据读到处理器缓存里
     *
     *
     *
     *
     *
     *
     *
     *
     */


    /**
     *  锁的本质
     *    线程等待
     *        阻塞： 要阻塞或唤醒一个线程就需要操作系统介入,需要在用户态与核心太之间切换,这种切换会消耗大量的系统资源。
     *        如果线程状态切换是一个高频操作时，这将会消耗很多cpu处理时间，如果对于那些需要同步的简单的代码块,
     *        获取锁挂起操作消耗的时间比用户代码执行的时间还长,这种同步策略显然非常糟糕的。
     *
     *        自旋： 如果持有锁的线程能在很短时间内释放锁资源，那么那些等待竞争锁的线程就不需要做内核态和用户态之间的切换进入阻塞挂起状态,
     *              它们只需要等一等(自旋),等持有锁的线程释放锁后即可立即获取锁,这样就避免用户线程和内核的切换的消耗。（线程还是Runnable的，
     *              只是在执行空代码。当然一直自旋也会白白消耗计算资源。）
     *
     *
     */




















}
