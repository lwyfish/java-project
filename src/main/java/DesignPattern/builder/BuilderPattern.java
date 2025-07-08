package DesignPattern.builder;

import lombok.Setter;
import lombok.ToString;

/**
 * 建造者模式
 * 产品Product：被构建的复杂对象, 包含多个组成部分。
 * 抽象建造者Builder: 定义构建产品各个部分的抽象接口和一个返回复杂产品的方法getResult
 * 具体建造者Concrete Builder：实现抽象建造者接口，构建产品的各个组成部分，并提供一个方法返回最终的产品。
 * 指导者Director：调用具体建造者的方法，按照一定的顺序或逻辑来构建产品。
 *
 * @author lwy
 * @date 2025/07/08 12:18
 **/
public class BuilderPattern {
    /**
     * 产品类
     */
    @ToString
    static class Product {
        @Setter
        private String partA;
        @Setter
        private String partB;
        @Setter
        private String partC;
    }

    /**
     * 抽象建造者类
     */
    interface Builder {
        void buildPartA();
        void buildPartB();
        void buildPartC();

        Product getResult();
    }

    /**
     * 具体建造者类
     */
    static class ConcreteBuilder implements Builder {
        /**
         * 初始化
         */
        private Product product = new Product();

        @Override
        public void buildPartA() {
            product.setPartA("partA");
            System.out.println("buildPartA");
        }

        @Override
        public void buildPartB() {
            product.setPartB("partB");
            System.out.println("buildPartB");
        }

        @Override
        public void buildPartC() {
            product.setPartC("partC");
            System.out.println("buildPartC");
        }

        @Override
        public Product getResult() {
            return product;
        }
    }

    /**
     * 指挥者类
     */
    static class Director {
        private Builder builder;

        /**
         * 构造方法
         * @param builder
         */
        public Director(Builder builder) {
            this.builder = builder;
        }

        public void construct() {
            builder.buildPartA();
            builder.buildPartB();
            builder.buildPartC();
        }
    }

    public static void main(String[] args) {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        Director director = new Director(concreteBuilder);
        director.construct();
        // 获取产品
        Product result = concreteBuilder.getResult();
        System.out.println(result);

    }

}
