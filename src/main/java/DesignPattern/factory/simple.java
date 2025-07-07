package DesignPattern.factory;

/**
 * 简单工厂
 *
 * @author lwy
 * @date 2025/07/05 20:30
 **/
public class simple {

    interface Shape {
        void draw();
    }

    class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }
    class Rectangle implements Shape {

        @Override
        public void draw() {
            System.out.println("Drawing a Rectangle");
        }
    }

    class ShapeFactory {
        public Shape getShape(String shapeType) {
            if (shapeType == null) {
                return null;
            }
            if (shapeType.equalsIgnoreCase("CIRCLE")) {
                return new Circle();
            } else {
                return new Rectangle();
            }
        }

    }

    public static void main(String[] args) {
        A a = new A();
        // ShapeFactory 是非静态内部类，必须通过外部类的实例来创建。
//        ShapeFactory shapeFactory = new ShapeFactory();
        ShapeFactory shapeFactory = new simple().new ShapeFactory();
        shapeFactory.getShape("CIRCLE").draw();
    }


}

class A {

}