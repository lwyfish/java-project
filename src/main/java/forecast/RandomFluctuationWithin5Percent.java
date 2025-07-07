package forecast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFluctuationWithin5Percent {
    public static List<Double> generateFluctuations(double baseValue, int count) {
        List<Double> values = new ArrayList<>();
        Random random = new Random();
        double maxFluctuation = baseValue * 0.02; // 5% of base value

        for (int i = 0; i < count; i++) {
            // Random fluctuation between [-5%, +5%]
            double fluctuation = (random.nextDouble() * 2 - 1) * maxFluctuation;
            values.add(baseValue + fluctuation);
        }

        return values;
    }

    public static void main(String[] args) {
        double baseValue = 100.0;
        int count = 100;
        List<Double> fluctuatingValues = generateFluctuations(baseValue, count);
        
        System.out.println("Base Value: " + baseValue);
        System.out.println("Fluctuating Values (±5%):");
        fluctuatingValues.forEach(value -> System.out.printf("%.2f\n", value));
    }
}