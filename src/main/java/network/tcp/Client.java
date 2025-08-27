package network.tcp;

import java.io.*;
import java.net.Socket;
 
public class Client {
    public static void main(String[] args) {
        try {
            // 创建Socket对象，指定服务端的IP地址和端口号
            Socket socket = new Socket("127.0.0.1", 12345);

            // 输出流
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("123");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}