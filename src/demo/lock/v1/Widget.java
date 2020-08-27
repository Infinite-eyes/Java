package demo.lock.v1;

public class Widget {
    //可重入锁
    public synchronized void doSomething(){
        System.out.println("方法1执行...");
        doOthers();
    }
    public synchronized void doOthers(){
        System.out.println("方法2执行...");
    }


}
