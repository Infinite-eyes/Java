package proxy2;

import java.lang.reflect.Proxy;

public class JavaDynamicProxy {

    public static void main(String[] args) {
        JavaDeveloper zack = new JavaDeveloper("Zack");


//        Developer zackProxy = Proxy.newProxyInstance(zack.getClass().getClassLoader(),
//                zack.getClass().getInterfaces(), (proxy, method, agrs) -> {
//                    if (method.getName().equals("code")) {
//                        System.out.println("Zack is praying for the code!");
//                        return method.invoke(zack, agrs);
//                    }
//                    if(method.getName().equals("debug")){
//
//                    }
//                });


    }


}
