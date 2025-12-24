package DesignPattern.adapter;

/**
 * 目标：typec
 */
class Adaptor implements TypeC {
    private USB usb;

    public Adaptor(USB usb) {
        this.usb = usb;
    }

    @Override
    public void chargeTypeC() {
        usb.chargeUSB();
    }
}