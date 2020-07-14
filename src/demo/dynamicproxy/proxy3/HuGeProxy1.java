package demo.dynamicproxy.proxy3;

import java.lang.reflect.Proxy;

public class HuGeProxy1 {

    private Star hg = new HuGe();

    public Star getProxy() {
        return (Star) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                hg.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    if (method.getName().equals("sing")) {
                        System.out.println("我是胡歌代理,唱歌时候出现");
                        return method.invoke(hg, args);
                    }
                    if (method.getName().equals("act")) {
                        System.out.println("我是胡歌代理,演戏时候出现");
                        return method.invoke(hg,args);
                    }
                    return null;
                });

    }


}
