package DesignPattern.adapter;

class UsbDevice implements USB {
    @Override
    public void chargeUSB() {
        System.out.println("USB Adapter");
    }
}