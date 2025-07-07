package forecast;

import java.util.ArrayList;
import java.util.List;

public class SinusoidalFluctuations {
    public static List<Double> generateSinusoidalFluctuations(double baseValue, int count, double amplitude, double frequency) {
        List<Double> values = new ArrayList<>();
        
        for (int i = 0; i < count; i++) {
            double fluctuation = amplitude * Math.sin(2 * Math.PI * frequency * i / count);
            values.add(baseValue + fluctuation);
        }
        
        return values;
    }

    public static void main(String[] args) {
        List<Double> sinusoidalValues = generateSinusoidalFluctuations(100.0, 100, 5.0, 0.1);
        System.out.println(sinusoidalValues);
    }
}