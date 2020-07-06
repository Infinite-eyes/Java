package demo.threadlocal;//https://www.jianshu.com/p/3c5d7f09dfbd


public class test {

    public static void main(String args[]) {
        final ThreadLocal<A> sThreadLocal = new ThreadLocal<A>();
        sThreadLocal.set(new A());
        sThreadLocal.get();
    }

    static class A {

    }
}


