package thread;

/**
 * @author lwy
 * @date 2025/11/05 15:51
 **/
public class test1 {
    public static void main(String[] args) {
        String str = "Java::Spring::Boot";

        if (str.startsWith("Java::")) {
            int startIndex = "Java".length(); // 起始索引：6
            // 找到 startIndex 后第一个 "::" 的位置（即"Spring"的结束位置）
            int endIndex = str.indexOf("::", startIndex);

            if (endIndex != -1) { // 确保找到分隔符（避免格式异常）
                String spring = str.substring(startIndex, endIndex);
                System.out.println("提取结果：" + spring); // 输出：Spring
            } else {
                System.out.println("字符串格式异常，未找到 Spring 后的分隔符");
            }
        }
    }
}
