package demo.object;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {


    public static void main(String[] args) {

        //v1 使用new关键字
//        Employee emp = new Employee();


        // v2.1 使用class类的 newInstance
//        try {
//            Employee emp2 = (Employee) Class.forName("demo.object.Employee").newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        // v2.2 使用class类的 newInstance
//        try {
//            Employee emp2 = Employee.class.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }


        //v3 使用Constructor类的newInstance方法
//        try {
//            Constructor<Employee> constructor = Employee.class.getConstructor();
//            Employee emp3 = constructor.newInstance();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        // v4使用clone 无论何时我们调用一个对象的clone方法，jvm就会创建一个新的对象，将前面对象的内容全部拷贝进去。用clone方法创建对象并不会调用任何构造函数。
//        Employee emp4 = emp3.clone()


        //v5 反序列化
//        try {
//            ObjectInputStream in =  new ObjectInputStream(new FileInputStream("data.obj"));
//
//            Employee emp5 = (Employee) in.readObject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


    }


}
