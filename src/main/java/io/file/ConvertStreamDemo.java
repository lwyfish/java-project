package io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * 转换流：连接字节流和字符流，并指定字符编码
 *
 * @author lwy
 * @date 2026/08/01 17:41
 **/
public class ConvertStreamDemo {
    public static void main(String[] args) {
        ConvertStreamDemo demo = new ConvertStreamDemo();
        demo.writeUtf8();
        demo.readUtf8();
        demo.convertGbkToUtf8();
    }

    /**
     * 使用 OutputStreamWriter 将字符按 UTF-8 编码写入文件
     */
    public void writeUtf8() {
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream("utf8.txt"), StandardCharsets.UTF_8)) {
            writer.write("Java IO 转换流测试");
            writer.write(System.lineSeparator());
            writer.write("使用 UTF-8 编码写入文件");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用 InputStreamReader 按 UTF-8 编码读取文件
     */
    public void readUtf8() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("utf8.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取 GBK 编码文件，并转换为 UTF-8 编码文件
     */
    public void convertGbkToUtf8() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("gbk.txt"), "GBK"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                     new FileOutputStream("converted-utf8.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
