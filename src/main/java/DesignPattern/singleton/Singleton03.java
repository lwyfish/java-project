package DesignPattern.singleton;

public class Singleton03 {
    private static volatile Singleton03 instance;
    
    private Singleton03() {
        // 私有构造方法，防止外部实例化
    }
    
    public static Singleton03 getInstance() {
        if (instance == null) {
            synchronized (Singleton03.class) {
                if (instance == null) {
                    instance = new Singleton03();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton03 singleton = Singleton03.getInstance();
        Singleton03 instance = Singleton03.getInstance();
    }
}
