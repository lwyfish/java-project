package DesignPattern.observer;

class ConcreteObserver implements Observer {

    @Override
    public void update(String state) {
        System.out.println("ConcreteObserver state:" + state);
    }
}