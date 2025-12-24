package DesignPattern.adapter;

class Computer implements TypeC {
    @Override
    public void chargeTypeC() {
        System.out.println("TypeC");
    }
}