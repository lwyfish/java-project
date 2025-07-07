package DesignPattern.singleton;

/**
 * 饿汉
 */
public class Singleton01 {
    private static final Singleton01 instance = new Singleton01();
    
    private Singleton01() {
        // 私有构造方法，防止外部实例化
    }

    /**
     * 静态方法
     * @return
     */
    public static Singleton01 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton01 instance = Singleton01.getInstance();
        Singleton01 instance2 = Singleton01.getInstance();
    }
}
