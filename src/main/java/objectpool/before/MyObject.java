package objectpool.before;

// 定义对象类
public class MyObject {
    private int id;

    public MyObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void doSomething() {
        System.out.println("MyObject " + id + " is doing something.");
    }
}