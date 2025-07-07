package javabasic.topN;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        Integer[] arr = {5, 3, 8, 1, 2};
        
        // 从小到大排序（自然顺序）
        Arrays.sort(arr, Comparator.naturalOrder());
        System.out.println("从小到大：" + Arrays.toString(arr)); // 输出：[1, 2, 3, 5, 8]
        
        // 从大到小排序
        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println("从大到小：" + Arrays.toString(arr)); // 输出：[8, 5, 3, 2, 1]
        
        // 等价写法（使用Lambda）
        Arrays.sort(arr, (a, b) -> b - a);
        System.out.println("从大到小（Lambda）：" + Arrays.toString(arr));
    }
}