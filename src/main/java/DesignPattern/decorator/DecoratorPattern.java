package DesignPattern.decorator;

/**
 * 装饰器模式，类似与代理模式
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new ConcreteCoffee();
        milkCoffee milkCoffee = new milkCoffee(coffee);
        milkCoffee.drink();
    }
}

interface Coffee {
    void drink();
}

class ConcreteCoffee implements Coffee {
    @Override
    public void drink() {
        System.out.println("concreteCoffee");
    }
}

abstract class DecoratorCoffee implements Coffee {
    private Coffee coffee;

    public DecoratorCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void drink() {
        coffee.drink();
    }
}

/**
 * 具体装饰类
 */
class milkCoffee extends DecoratorCoffee {
    public milkCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void drink() {
        System.out.println("Before operation in ConcreteDecorator");
        super.drink();
        System.out.println("After operation in ConcreteDecorator");
    }
}

