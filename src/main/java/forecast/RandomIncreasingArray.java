package forecast;

import java.util.Arrays;
import java.util.Random;

public class RandomIncreasingArray {
    public static void main(String[] args) {
        int length = 90; // 指定数组长度
        long min = 10;   // 指定最小值
        long max = 100;  // 指定最大值

        long[] array = generateRandomIncreasingArray(length, min, max);
        System.out.println(Arrays.toString(array));
    }

    public static long[] generateRandomIncreasingArray(int length, long min, long max) {
        if (length <= 0 || min >= max) {
            throw new IllegalArgumentException("数组长度必须大于0，且最小值必须小于最大值");
        }

        long[] array = new long[length];
        Random random = new Random();
        
        // 计算最大可能的总涨幅
        long totalPossibleIncrease = max - min;
        
        // 计算每个元素平均可以分配的涨幅空间
        double averageIncreasePerElement = (double) totalPossibleIncrease / (length - 1);
        
        // 第一个元素设为最小值
        array[0] = min;
        
        // 剩余可分配的涨幅
        long remainingIncrease = totalPossibleIncrease;
        
        // 生成中间元素
        for (int i = 1; i < length - 1; i++) {
            // 计算当前元素可能的最大涨幅，确保后续元素仍有增长空间
            int maxCurrentIncrease = (int) Math.min(
                remainingIncrease - (length - 1 - i), 
                averageIncreasePerElement * 2
            );
            
            // 如果最大涨幅小于等于0，说明剩余空间不足，直接分配剩余涨幅
            if (maxCurrentIncrease <= 0) {
                array[i] = array[i - 1] + 1;
                remainingIncrease -= 1;
            } else {
                // 随机生成一个合理的涨幅
                int currentIncrease = random.nextInt(maxCurrentIncrease) + 1;
                array[i] = array[i - 1] + currentIncrease;
                remainingIncrease -= currentIncrease;
            }
        }
        
        // 最后一个元素设为最大值，确保序列严格递增
        array[length - 1] = max;
        
        return array;
    }
}    