package forecast;

import java.util.Random;

public class RangeArrayGenerator {
    /**
     * 生成一个指定长度的数组，数值在[min, max]范围内，相邻数值波动不超过30%
     * 
     * @param min 最小值
     * @param max 最大值
     * @param length 数组长度
     * @return 生成的数组
     */
    public static double[] generateArrayWithFluctuation(double min, double max, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("数组长度必须大于0");
        }
        if (min >= max) {
            throw new IllegalArgumentException("最小值必须小于最大值");
        }

        Random random = new Random();
        double[] result = new double[length];
        
        // 生成第一个随机值
        result[0] = min + (max - min) * random.nextDouble();
        
        for (int i = 1; i < length; i++) {
            // 计算允许的波动范围（当前值的±30%）
            double fluctuation = result[i - 1] * 0.1;
            double lowerBound = Math.max(min, result[i - 1] - fluctuation);
            double upperBound = Math.min(max, result[i - 1] + fluctuation);
            
            // 生成下一个值，确保在[min, max]范围内且波动不超过30%
            result[i] = lowerBound + (upperBound - lowerBound) * random.nextDouble();
        }
        
        return result;
    }

    public static void main(String[] args) {
        double[] array = generateArrayWithFluctuation(50, 150, 10);
        
        System.out.println("生成的数组：");
        for (double num : array) {
            System.out.printf("%.2f ", num);
        }
    }
}