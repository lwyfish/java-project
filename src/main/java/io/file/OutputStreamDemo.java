package io.file;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lwy
 * @date 2026/08/01 17:07
 **/
public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
        OutputStreamDemo outputStreamDemo = new OutputStreamDemo();
        outputStreamDemo.outStreamWrite();
        outputStreamDemo.outStreamWriteBuffer();

    }

    /**
     * 使用 FileOutputStream 将字符串以字节流方式追加写入文件
     */
    public void outStreamWrite() {
        try (FileOutputStream fos = new FileOutputStream("2.txt", true)) {
            String context = "Java IO 字节流批量写入测试\n第二行文本内容";
            byte[] bytes = context.getBytes();
            fos.write(bytes);
            fos.flush();
        } catch (IOException e) {
        }
    }

    /**
     * 使用 BufferedOutputStream 缓冲字节流将字符串写入文件
     */
    public void outStreamWriteBuffer() {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("2.txt"));) {
            String context = "Java IO 字节流批量写入测试\n第二行文本内容";
            bos.write(context.getBytes());
        } catch (Exception e) {
        }
    }
}
