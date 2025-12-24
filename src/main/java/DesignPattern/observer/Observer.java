package DesignPattern.observer;

/**
 * 观察者接口
 * 定义了观察者对象需要实现的更新方法
 */
interface Observer {
    /**
     * 当被观察对象状态发生变化时，调用此方法通知观察者
     * @param state 被观察对象的最新状态
     */
    void update(String state);
}