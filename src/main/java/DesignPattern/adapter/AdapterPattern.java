package DesignPattern.adapter;

/**
 * 适配器模式
 * 可以把适配器模式理解成拓展坞，起到转接的作用，原有的接口是USB，但是客户端需要使用type-c，
 * 便使用拓展坞提供一个type-c接口给客户端使用
 *
 * @author lwy
 * @date 2025/07/10 19:34
 **/
public class AdapterPattern {
    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Adaptee());
        adapter.request();
    }
}

/**
 * 目标接口
 */
interface Target {
    void request();
}

/**
 * 适配
 */
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

/**
 * 被适配类
 */
class Adaptee {
    public void specificRequest() {
        System.out.println("Specific request");
    }
}
