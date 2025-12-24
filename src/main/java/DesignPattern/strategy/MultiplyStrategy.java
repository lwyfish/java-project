package DesignPattern.strategy;

/**
 * 乘法策略
 */
class MultiplyStrategy implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}