package DesignPattern.adapter;

import java.util.Scanner;

/**
 * 小明购买了一台新电脑，该电脑使用 TypeC 接口，他已经有了一个USB接口的充电器和数据线，为了确保新电脑可以使用现有的USB接口充电器和数据线，
 * 他购买了一个TypeC到USB的扩展坞。
 * 请你使用适配器模式设计并实现这个扩展坞系统，确保小明的新电脑既可以通过扩展坞使用现有的USB接口充电线和数据线，也可以使用TypeC接口充电。
 *
 * 目标：TypeC接口充电
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取连接次数
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            // 读取用户选择
            int choice = scanner.nextInt();
            // 根据用户的选择创建相应对象
            if (choice == 1) {
                TypeC newComputer = new Computer();
                newComputer.chargeTypeC();
            } else if (choice == 2) {
                UsbDevice usbDevice = new UsbDevice();
                Adaptor adaptor = new Adaptor(usbDevice);
                adaptor.chargeTypeC();
            }
        }
        scanner.close();
    }

}

interface TypeC {
    void chargeTypeC();
}

interface USB {
    void chargeUSB();
}

class Computer implements TypeC {
    @Override
    public void chargeTypeC() {
        System.out.println("TypeC");
    }
}

class UsbDevice implements USB {
    @Override
    public void chargeUSB() {
        System.out.println("USB Adapter");
    }
}

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