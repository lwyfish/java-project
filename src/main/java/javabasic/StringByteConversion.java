package javabasic;

import java.nio.charset.StandardCharsets;

public class StringByteConversion {
    public static void main(String[] args) {
        // 原始字符串
        String original = "你好，世界！";
        System.out.println("原始字符串: " + original);

        // 编码：字符串 → 字节数组
        byte[] bytes = original.getBytes(StandardCharsets.UTF_8);
        System.out.println("字节数组长度: " + bytes.length);

        // 解码：字节数组 → 字符串
        String restored = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("还原后的字符串: " + restored);

        // 验证是否相等
        System.out.println("是否还原成功: " + original.equals(restored)); // 输出: true
    }
}