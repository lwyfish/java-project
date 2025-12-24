package DesignPattern.observer;

import java.util.ArrayList;
import java.util.List;

class ConcreteSubject implements Subject {
    // 观察者列表，用于存储所有注册的观察者
    private List<Observer> observerList = new ArrayList<>();
    // 主题的状态，当状态改变时会通知所有观察者
    private String state;

    /**
     * 注册观察者，将新的观察者添加到观察者列表中
     *
     * @param observer 要注册的观察者
     */
    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    /**
     * 移除观察者，从观察者列表中删除指定的观察者
     *
     * @param observer 要移除的观察者
     */
    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * 通知所有注册的观察者，调用每个观察者的update方法
     */
    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(state);
        }
    }

    /**
     * 设置主题的新状态，状态改变后自动通知所有观察者
     *
     * @param state 新的状态值
     */
    public void setState(String state) {
        this.state = state;
        notifyObserver();
    }
}
