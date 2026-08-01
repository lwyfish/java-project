package io.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流
 *
 * @author lwy
 * @date 2026/08/01 17:31
 **/
public class WriterDemo {
    public static void main(String[] args) {
        WriterDemo writerDemo = new WriterDemo();
        writerDemo.writerWrite();
        writerDemo.bufferedWriterWrite();
    }

    /**
     * 使用 FileWriter 将字符数据写入文件
     */
    public void writerWrite() {
        try (FileWriter fileWriter = new FileWriter("2.txt")) {
            fileWriter.write("Java IO 字符流写入测试");
            fileWriter.write(System.lineSeparator());
            fileWriter.write("第二行文本内容");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用 BufferedWriter 将字符数据追加写入文件
     */
    public void bufferedWriterWrite() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("2.txt", true))) {
            bufferedWriter.newLine();
            bufferedWriter.write("BufferedWriter 追加写入测试");
            bufferedWriter.newLine();
            bufferedWriter.write("第四行文本内容");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
