package network.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String s = dis.readUTF();
            SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
            System.out.println(s);
            System.out.println(remoteSocketAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}