package DesignPattern.factory;

import smile.stat.Hypothesis;

/**
 * 抽象工厂
 * 在工厂方法模式中，每个具体工厂只负责创建单一的产品。但是如果有多类产品呢，比如说“手机”，一个品牌的手机有高端机、中低端机之分，
 * 这些具体的产品都需要建立一个单独的工厂类，但是它们都是相互关联的，都共同属于同一个品牌，这就可以使用到【抽象工厂模式】
 *
 * 简单工厂模式：一个工厂方法创建所有具体产品
 * 工厂方法模式：一个工厂方法创建一个具体产品
 * 抽象工厂模式：一个工厂方法可以创建一类具体产品
 * @author lwy
 * @date 2025/07/07 15:35
 **/
public class AbstaractFactory {
    interface ProductA {
        void display();
    }

    interface ProductB {

        void show();
    }

    class ProductA1 implements ProductA {

        @Override
        public void display() {
            System.out.println("display A1");
        }
    }

    class ProductB1 implements ProductB {
        @Override
        public void show() {
            System.out.println("show B1");
        }
    }

    interface Factory {
        ProductA createProductA();

        ProductB createProductB();
    }

    class ConcreteFactory1 implements Factory {

        @Override
        public ProductA createProductA() {
            return new ProductA1();
        }

        @Override
        public ProductB createProductB() {
            return new ProductB1();
        }
    }

    public static void main(String[] args) {
        ConcreteFactory1 concreteFactory1 = new AbstaractFactory().new ConcreteFactory1();
        ProductA productA = concreteFactory1.createProductA();
        ProductB productB = concreteFactory1.createProductB();
        productA.display();
        productB.show();
    }
}
