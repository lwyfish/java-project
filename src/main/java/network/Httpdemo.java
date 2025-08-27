package network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * http协议
 *
 * @author lwy
 * @date 2025/08/16 11:22
 **/
public class Httpdemo {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostAddress = localHost.getHostAddress();
            String hostName = localHost.getHostName();
            System.out.println("hostName" + hostName + "hostAddress" + hostAddress);

            // 根据ip或域名
            InetAddress ip2 = InetAddress.getByName("www.baidu.com");
            System.out.println(ip2);
            NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(localHost);
            InetAddress ip3 = InetAddress.getByName("10.10.10.123");
            // 目标.isReachable(源)
            boolean reachable = ip3.isReachable(byInetAddress, 0, 300);
            System.out.println(reachable);

        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
