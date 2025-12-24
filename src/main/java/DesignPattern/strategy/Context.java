package DesignPattern.strategy;


import lombok.Setter;

/**
 * 上下文
 */
class Context {
    @Setter
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execStrategy(int a, int b) {
        return strategy.calculate(a, b);
    }
}