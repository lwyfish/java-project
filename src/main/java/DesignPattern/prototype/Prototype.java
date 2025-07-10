package DesignPattern.prototype;

import lombok.Getter;

/**
 * 原型
 * 原型模式一种创建型设计模式，该模式的核心思想是基于现有的对象创建新的对象，而不是从头开始创建。
 *
 * @author lwy
 * @date 2025/07/09 13:36
 **/
public class Prototype {
    public static void main(String[] args) {
        ConcretePrototype originalData = new ConcretePrototype("Original Data");
        ConcretePrototype clone = (ConcretePrototype) originalData.clone();
        System.out.println(clone.getData()); // 输出 "Original Data"
    }
}

abstract class PrototypeClass implements Cloneable {
    public abstract PrototypeClass clone();
}

class ConcretePrototype extends PrototypeClass {
    @Getter
    private String data;

    public ConcretePrototype(String data) {
        this.data = data;
    }

    @Override
    public PrototypeClass clone() {
        return new ConcretePrototype(this.data);
    }
}