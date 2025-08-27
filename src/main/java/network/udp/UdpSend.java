package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 客户端
 */
public class UdpSend {
    public static void main(String[] args) throws IOException { // 异常处理
        String str = "法国的欢呼雀跃掩映着一个人的寂寥无言，梅西就这样孤独地站在原地，空空如也，满泪哀伤，仿佛是上天的安排，"
                + "在梅西告别世界杯的同一天，C罗也在这一天挥手再见，卡瓦尼用两粒精彩绝伦的进球终结了C罗的世界杯之梦，绝代双骄，同天告别，"
                + "这是猝不及防却必须承受的生命之重，31岁的梅西，33岁的C罗，他们真的已不再年轻，这一天，时光好像悄悄拉上了一代人青春的大幕，"
                + "无人知晓，最好的他们会否在四年之后等在下一个重逢的路口。人生里有这样一首诗：当我们拥有他时，还无法读懂，当我们读懂他时，"
                + "他却已悄然远走，这首诗，就是青春！惟愿岁月在匆匆无情中对他们写尽温柔，惟愿时光在飘飘风雨里让他们依旧坚守，"
                + "此时，讲不出再见，此刻，诉不尽离愁，一壶浊酒尽余欢，今宵别梦寒！";
        // 客户端（发送）
        DatagramSocket datagramSocket = new DatagramSocket(2222); // 创建DatagramSocket
        // 数据内容、对方地址、对方端口
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(),
                str.getBytes().length, InetAddress.getByName("127.0.0.1"), 1111); // 创建DatagramPacket（要发送的数据，数据的长度，Ip地址，端口）
		// 发送
        datagramSocket.send(datagramPacket);
		// 发送完毕就不管了
		// 关闭
        datagramSocket.close();
    }
}
