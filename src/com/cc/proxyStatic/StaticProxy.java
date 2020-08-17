package com.cc.proxyStatic;

/**
 * 静态代理模式总结：
 *      真实对象和代理对象都要实现同一个接口
 *      真实对象专注做自己的事情
 */
public class StaticProxy {

    public static void main(String[] args) {

        new Thread( () -> System.out.println("我爱你") ).start();

        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}

/**
 * 结婚接口
 */
interface Marry {

    void HappyMarry();
}

/**
 * 真实角色
 */
class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("要结婚了，超级开心～");
    }
}

/**
 * 代理角色
 */
class WeddingCompany implements Marry {

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}
