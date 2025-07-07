package javabasic;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * isEmpty()	检查容器是否为空	对象本身不为 null，但内容为空（如空字符串、空集合、空数组等）。
 * isNotNull()	检查对象是否为 null	仅判断对象是否为 null，不关心内容是否为空。
 *
 * @author lwy
 * @date 2025/04/28 15:14
 **/
public class NullEmptyDemo {
    public static void main(String[] args) {

    }

    public static void test() {
        String str1 = null;
        String str2 = "";
        String str3 = "  "; // 空格字符串

        // isNotNull() 示例
        boolean notNull1 = str1 != null; // false
        boolean notNull2 = str2 != null; // true
        boolean notNull3 = str3 != null; // true

        // isEmpty() 示例
        boolean empty1 = str1 == null || str1.isEmpty(); // true（需先判 null）
        boolean empty2 = str2.isEmpty(); // true
        boolean empty3 = str3.isEmpty(); // false（空格字符串不为空）
    }
}
