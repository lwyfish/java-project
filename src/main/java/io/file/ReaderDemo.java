package io.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入流
 *
 * @author lwy
 * @date 2026/08/01 17:25
 **/
public class ReaderDemo {
    public static void main(String[] args) {
        ReaderDemo readerDemo = new ReaderDemo();
        readerDemo.readerRead();
        readerDemo.bufferedReaderRead();
    }

    /**
     * 使用 FileReader 和字符数组读取文件
     */
    public void readerRead() {
//        try (FileReader fileReader = new FileReader("1.txt")) {
//            char[] buffer = new char[8192];
//            int len;
//            while ((len = fileReader.read(buffer)) != -1) {
//                System.out.print(new String(buffer, 0, len));
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try (FileReader fe = new FileReader("1.txt")) {
            int c;
            while ((c = fe.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
        }
    }

    /**
     * 使用 BufferedReader 按行读取文件
     */
    public void bufferedReaderRead() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("1.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
