package javabasic;

import java.util.Objects;

/**
 * hashdemo
 *
 * @author lwy
 * @date 2025/05/08 17:42
 **/
public class HashDemo {
    public static void main(String[] args) {
        double pow = Math.pow(2, 64);
        System.out.println(pow);
        String a = "1";
//        int i = a.hashCode();
//        System.out.println(i);
        System.out.println(Objects.hash(a));
        System.out.println(Objects.hashCode(a));
        test();
    }

    public static void test() {
        //
        Person person = new Person();
        Person person2 = new Person();
        System.out.println(Objects.equals(person, person2));

        Person2 person3 = new Person2();
        Person2 person4 = new Person2();
        System.out.println(Objects.equals(person3, person4));
    }
}


class Person {
    private String name;
    private int age;

    // 构造方法、getter/setter 略

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class Person2 {
    private String name;
    private int age;
}