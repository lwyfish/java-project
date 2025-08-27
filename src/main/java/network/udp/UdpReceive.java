package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 服务端
 */
public class UdpReceive {
    public static void main(String[] args) throws IOException {
        // 创建服务端，端口号
        DatagramSocket datagramSocket = new DatagramSocket(1111);
        DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
        // 接收数据
        datagramSocket.receive(datagramPacket);
        // 获取数据
        byte[] arr = datagramPacket.getData();
        // 客户端的ip、端口号
        InetAddress address = datagramPacket.getAddress();
        int port = datagramPacket.getPort();
        System.out.println(address);
        System.out.println(port);

        // 获取有效长度
        int len = datagramPacket.getLength();
        // 接收多少，拿出多少
        System.out.println(new String(arr, 0, len));
        // 关闭
        datagramSocket.close();
    }
}
