package javabasic;

import java.io.*;

// 实现 Serializable 接口，使该类的对象可以被序列化
class User implements Serializable {
    private String username;
    // 使用 transient 关键字修饰 password 属性，使其不被序列化
    private transient String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class TransientExample {
    public static void main(String[] args) {
        User user = new User("JohnDoe", "secretpassword");

        try {
            // 序列化对象到文件
            FileOutputStream fileOut = new FileOutputStream("user.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(user);
            out.close();
            fileOut.close();
            System.out.println("对象已序列化到 user.ser 文件");

            // 从文件反序列化对象
            FileInputStream fileIn = new FileInputStream("user.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            User deserializedUser = (User) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("对象已从 user.ser 文件反序列化");

            // 输出反序列化后的对象信息
            System.out.println("用户名: " + deserializedUser.getUsername());
            System.out.println("密码: " + deserializedUser.getPassword());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}    