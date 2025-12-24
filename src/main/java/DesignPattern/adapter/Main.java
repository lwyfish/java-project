package DesignPattern.adapter;

import java.util.Scanner;

/**
 * 适配器模式
 * 可以把适配器模式理解成拓展坞，起到转接的作用，原有的接口是USB，但是客户端需要使用type-c，
 * 便使用拓展坞提供一个type-c接口给客户端使用
 * @author lwy
 * @date 2025/12/24 17:18
 **/
public class Main {
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
