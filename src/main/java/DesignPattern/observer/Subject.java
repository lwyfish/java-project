package DesignPattern.observer;


/**
 * 主题接口，定义了观察者模式中的主题行为
 * 主题可以注册、移除和通知观察者
 */
interface Subject {

    /**
     * 注册观察者到主题
     *
     * @param observer 需要注册的观察者
     */
    void registerObserver(Observer observer);

    /**
     * 从主题中移除观察者
     *
     * @param observer 需要移除的观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有已注册的观察者
     */
    void notifyObserver();
}