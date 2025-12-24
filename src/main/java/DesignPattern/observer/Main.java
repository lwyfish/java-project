package DesignPattern.observer;

/**
 * 观察者模式
 * 简述：主题对象设置值后通知所有监听对象（观察者），
 * 主题对象：维护一个监听对象列表、一个状态值，一个通知方法
 * 监听对象：维护后续更新方法
 *
 * 定义了一种一对多的依赖关系，让多个观察者对象同时监听一个主题对象，
 * 当主题对象的状态发生变化时，所有依赖于它的观察者都得到通知并被自动更新。
 * <p>
 * Subject(主题)：也就是被观察的对象，它可以维护一组观察者，当主题本身发生改变时就会通知观察者。
 * Observer(观察者)：观察主题的对象，当“被观察”的主题发生变化时，观察者就会得到通知并执行相应的处理。
 * <p>
 * 使用观察者模式有很多好处，比如说观察者模式将主题和观察者之间的关系解耦，
 * 主题只需要关注自己的状态变化，而观察者只需要关注在主题状态变化时需要执行的操作，两者互不干扰，并且由于观察者和主题是相互独立的，
 * 可以轻松的增加和删除观察者，这样实现的系统更容易扩展和维护。
 */
public class Main {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        ConcreteObserver concreteObserver = new ConcreteObserver();
        ConcreteObserver2 ConcreteObserver2 = new ConcreteObserver2();

        concreteSubject.registerObserver(concreteObserver);
        concreteSubject.registerObserver(ConcreteObserver2);
        concreteSubject.setState("123");
    }
}
