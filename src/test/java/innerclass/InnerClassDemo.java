package innerclass;

/**
 * Java 内部类完整示例
 * 包含：非静态内部类、静态内部类、局部内部类、匿名内部类
 * @author lwy
 */
public class InnerClassDemo {
    // 外部类的成员变量（供内部类访问）
    private String outerField = "外部类成员变量";
    // 外部类的静态变量
    private static String staticOuterField = "外部类静态变量";

    // ====================== 1. 非静态内部类（成员内部类） ======================
    /**
     * 非静态内部类：依赖外部类实例，可直接访问外部类的所有成员（包括私有）
     * 不能定义static成员（static final常量除外）
     */
    class NonStaticInnerClass {
        // 非静态内部类的成员变量
        private String innerField = "非静态内部类成员变量";

        // 非静态内部类的方法
        public void show() {
            // 访问外部类的非静态成员
            System.out.println("访问外部类非静态成员：" + outerField);
            // 访问外部类的静态成员
            System.out.println("访问外部类静态成员：" + staticOuterField);
            // 访问自身成员
            System.out.println("访问自身成员：" + innerField);
            // 若内部类和外部类变量重名，用 外部类名.this.变量名 区分
            System.out.println("重名区分示例：" + InnerClassDemo.this.outerField);
        }
    }

    // ====================== 2. 静态内部类 ======================
    /**
     * 静态内部类：不依赖外部类实例，仅能访问外部类的静态成员
     * 可以定义static成员（和普通类一致）
     */
    static class StaticInnerClass {
        // 静态内部类的静态成员（合法）
        private static String staticInnerField = "静态内部类静态变量";
        // 静态内部类的非静态成员
        private String innerField = "静态内部类非静态变量";

        // 静态内部类的静态方法
        public static void staticShow() {
            // 只能访问外部类的静态成员（不能访问outerField）
            System.out.println("静态内部类静态方法访问外部静态成员：" + staticOuterField);
            System.out.println("访问自身静态成员：" + staticInnerField);
        }

        // 静态内部类的非静态方法
        public void show() {
            System.out.println("静态内部类非静态方法访问自身非静态成员：" + innerField);
            staticShow(); // 调用自身静态方法
        }
    }

    // ====================== 3. 局部内部类 ======================
    /**
     * 局部内部类：定义在方法内部，作用域仅限当前方法
     * 依赖外部类实例，不能定义static成员，可访问方法的final/effectively final变量
     */
    public void localInnerClassDemo() {
        // 方法局部变量（Java 8+ 自动为effectively final，无需显式加final）
        String localVar = "方法局部变量";

        // 局部内部类（仅在当前方法内可见）
        class LocalInnerClass {
            public void show() {
                // 访问外部类成员
                System.out.println("局部内部类访问外部类成员：" + outerField);
                // 访问方法局部变量（必须是final/effectively final）
                System.out.println("局部内部类访问方法局部变量：" + localVar);
            }
        }

        // 局部内部类只能在方法内创建实例并使用
        LocalInnerClass localInner = new LocalInnerClass();
        localInner.show();
    }

    // ====================== 4. 匿名内部类 ======================
    /**
     * 匿名内部类：无类名，直接继承类/实现接口，常用于简化代码（如线程、回调）
     * 一次性使用，不能定义构造方法，可访问外部final/effectively final变量
     */
    public void anonymousInnerClassDemo() {
        // 示例1：实现接口的匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类（实现Runnable）：" + outerField);
            }
        };
        new Thread(runnable).start();

        // 示例2：继承类的匿名内部类
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("匿名内部类（继承Thread）：" + staticOuterField);
            }
        };
        thread.start();
    }

    // ====================== 测试主方法 ======================
    public static void main(String[] args) {
        // 1. 测试非静态内部类：必须先创建外部类实例，再创建内部类实例
        InnerClassDemo.NonStaticInnerClass nonStaticInner = new InnerClassDemo().new NonStaticInnerClass();
        nonStaticInner.show();
        System.out.println("------------------------");

        // 2. 测试静态内部类：无需外部类实例，直接创建
        InnerClassDemo.StaticInnerClass.staticShow(); // 调用静态方法
        InnerClassDemo.StaticInnerClass staticInner = new InnerClassDemo.StaticInnerClass();
        staticInner.show(); // 调用非静态方法
        System.out.println("------------------------");

        // 3. 测试局部内部类
        new InnerClassDemo().localInnerClassDemo();
        System.out.println("------------------------");

        // 4. 测试匿名内部类
        new InnerClassDemo().anonymousInnerClassDemo();
    }
}