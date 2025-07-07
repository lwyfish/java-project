package DesignPattern.singleton;

public class Singleton02 {
    /**
     * 成员变量
     */
    private static Singleton02 instance;
    
    private Singleton02() {
        // 私有构造方法，防止外部实例化
    }
    // 使用了同步关键字来确保线程安全, 可能会影响性能
    public static synchronized Singleton02 getInstance() {
        if (instance == null) {
            instance = new Singleton02();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton02 singleton = Singleton02.getInstance();
        Singleton02 instance = Singleton02.getInstance();
    }
}
