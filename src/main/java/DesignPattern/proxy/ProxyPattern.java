package DesignPattern.proxy;

/**
 * 代理模式
 * 代理模式Proxy Pattern是一种结构型设计模式，用于控制对其他对象的访问。
 * 在之前做一些操作，在之后做一些操作
 *
 * @author lwy
 * @date 2025/07/10 20:10
 **/
public class ProxyPattern {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.Request();
    }
}

interface Subject {
    void Request();
}

/**
 * 被代理对象
 */
class RealSubject implements Subject {

    @Override
    public void Request() {
        System.out.println("RealSubject Request");
    }
}

/**
 * 代理类
 */
class Proxy implements Subject {
    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void Request() {
        // 之前做操作
        System.out.println("before");

        realSubject.Request();

        // 之后做操作
        System.out.println("after");
    }
}