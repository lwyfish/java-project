package DesignPattern.strategy;

/**
 * 加法策略
 */
class SumStrategy implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}