package demo.dynamicproxy.proxy2;

import java.lang.reflect.Proxy;

public class JavaDynamicProxy {

    public static void main(String[] args) {
        JavaDeveloper zack = new JavaDeveloper("Zack");

        Developer zackProxy = (Developer) Proxy.newProxyInstance(zack.getClass().getClassLoader(),
                zack.getClass().getInterfaces(), (proxy, method, args1) -> {

                    if (method.getName().equals("code")) {
                        System.out.println("Zack is praying for the code!");
                        return method.invoke(zack, args1);
                    }
                    if (method.getName().equals("debug")) {
                        return method.invoke(zack, args1);
                    }
                    return null;
                });

        zackProxy.code();
        zackProxy.debug();


    }


}
