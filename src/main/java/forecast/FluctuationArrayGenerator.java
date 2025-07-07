package forecast;

import java.util.Random;

public class FluctuationArrayGenerator {
    /**
     * 生成围绕基准值波动的数组（波动不超过±5%）
     * @param baseValue 基准值
     * @param length 数组长度
     * @return 波动数组
     */
    public static double[] generateFluctuationArray(double baseValue, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("数组长度必须大于0");
        }
        
        Random random = new Random();
        double[] result = new double[length];
        double fluctuationRange = baseValue * 0.05; // 5%波动范围
        
        for (int i = 0; i < length; i++) {
            // 生成-0.05到+0.05之间的随机比例
            double fluctuation = (random.nextDouble() * 0.1 - 0.05) * baseValue;
            result[i] = baseValue + fluctuation;
        }
        
        return result;
    }

    public static void main(String[] args) {
        double baseValue = 100.0;
        int length = 5;
        double[] array = generateFluctuationArray(baseValue, length);
        
        System.out.println("基准值: " + baseValue);
        System.out.println("生成的波动数组:");
        for (double num : array) {
            System.out.printf("%.2f (%.2f%%) ", num, ((num - baseValue)/baseValue)*100);
        }
    }
}