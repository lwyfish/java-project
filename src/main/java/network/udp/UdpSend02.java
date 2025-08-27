package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 客户端（多发多收）
 */
public class UdpSend02 {
    public static void main(String[] args) throws IOException { // 异常处理
        Scanner scanner = new Scanner(System.in);
        DatagramSocket datagramSocket = new DatagramSocket(2223);

        // 客户端（发送）
        while (true) {
            String str = scanner.nextLine();
            if ("exit".equals(str)) {
                break;
            }
            // 数据内容、对方地址、对方端口
            DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(),
                    str.getBytes().length, InetAddress.getByName("127.0.0.1"), 1111); // 创建DatagramPacket（要发送的数据，数据的长度，Ip地址，端口）
            // 发送
            datagramSocket.send(datagramPacket);
        }
        // 发送完毕就不管了
		// 关闭
        datagramSocket.close();
    }
}
