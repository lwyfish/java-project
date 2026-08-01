package io.file;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节输入流
 *
 * @author lwy
 * @date 2025/11/13 20:37
 **/
public class InputStreamDemo {

    public static void main(String[] args) throws IOException {
        InputStreamDemo inputStreamDemo = new InputStreamDemo();
        inputStreamDemo.inputStreamRead();
        inputStreamDemo.inputStreamReadBuffer();
    }

    /**
     * 读取1.txt中的数据
     * 强制转换为char类型的字符
     *
     * @throws IOException
     */
    public void inputStreamRead() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("1.txt")) {
            int b;
            // read() 1次读1个字符，读到最后是-1
            while ((b = fileInputStream.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (Exception e) {
        }
//        while (true) {
//            b = fileInputStream.read();
//            System.out.println((char) b);
//        }
    }

    /**
     * 使用buffer数组读取
     */
    public void inputStreamReadBuffer() {
        try (FileInputStream fileInputStream = new FileInputStream("1.txt")) {
            byte[] buffer = new byte[8192];
            // 自定义缓冲区
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                // 循环读取：每次往buffer塞满数据，len为本次读取字节数，读到末尾返回-1结束
                String s = new String(buffer, 0, len);
                System.out.println(s);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
