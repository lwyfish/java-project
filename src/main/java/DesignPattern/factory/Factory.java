package DesignPattern.factory;

/**
 * 工厂类方法
 *
 * @author lwy
 * @date 2025/07/07 14:46
 **/
public class Factory {
    interface Shape {
        void draw();
    }

    interface ShapeFactory {
        Shape createShape();
    }

    class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("draw a circle");
        }
    }

    class Rectangle implements Shape {

        @Override
        public void draw() {
            System.out.println("draw a rectangle");
        }
    }

    class CircleFactory implements ShapeFactory {

        @Override
        public Shape createShape() {
            return new Circle();
        }
    }

    class RectangleFactory implements ShapeFactory {

        @Override
        public Shape createShape() {
            return new Rectangle();
        }
    }

    public static void main(String[] args) {
        Factory.RectangleFactory rectangleFactory = new Factory().new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();
    }
}
