package demo.covariance_contravariance;


import java.util.*;

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

public class Main {
//    Java中数组是协变的，可以向子类型的数组赋基类型的数组引用。

    public static void main(String[] args) {

        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();

        try {
            fruit[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            fruit[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void testListOut() {
//       arr 可以  list不行 协变
//        List<Fruit> fruitList = new ArrayList<Apple>(); //错误

        //不能add
        List<? extends Fruit> fruitList = new ArrayList<Apple>();
        // 编译错误
//        fruitList.add(new Apple());

        // 编译错误
//        fruitList.add(new Jonathan());
        // 编译错误
//        fruitList.add(new Fruit());
        // 编译错误
//        fruitList.add(new Object());

        Fruit fruit = fruitList.get(0);
        Object object = fruitList.get(0);

        // 编译错误
//        Apple apple = fruitList.get(0);

    }

    public void testListIn() {

        List<? super Apple> appleList = new ArrayList<>();

        // 编译错误
//        Fruit fruit = appleList.get(0);
//// 编译错误
//        Apple apple = appleList.get(0);
//// 编译错误
//        Jonathan jonathan = appleList.get(0);

        Object object = appleList.get(0);

        appleList.add(new Apple());

        appleList.add(new Jonathan());
//        // 编译错误
//        appleList.add(new Fruit());
//        // 编译错误
//        appleList.add(new Object());
    }


}


class ListDemo {

    //    java.uitl.Collections copy
//    dest为生产者只从其中取数据，src为消费者，只存放数据进去
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {

        int srcSize = src.size();
        if (srcSize > dest.size())
            throw new IndexOutOfBoundsException("Source dose not fit in dest");

        if (srcSize < 10 || (src instanceof RandomAccess && dest instanceof RandomAccess)) {
            for (int i = 0; i < srcSize; i++)
                dest.set(i, src.get(i));

        } else {
            ListIterator<? super T> di = dest.listIterator();
            ListIterator<? extends T> si = src.listIterator();
            for (int i = 0; i < srcSize; i++) {
                di.next();
                di.set(si.next());
            }
        }


    }
}

