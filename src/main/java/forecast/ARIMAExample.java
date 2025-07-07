//package forecast;
//
//import java.util.Arrays;
//
//public class ARIMAExample {
//    public static void main(String[] args) {
//        // ʾ��ʱ����������
//        double[] timeSeries = {10, 12, 15, 13, 16, 18, 20, 19, 22, 25, 24, 28};
//
//        // ����ARIMAģ�� (p=1, d=1, q=1)
//        ARIMA arima = new ARIMA(1, 1, 1);
//
//        // ѵ��ģ��
//        arima.train(timeSeries);
//
//        // Ԥ��δ��3��ʱ���
//        double[] forecasts = arima.forecast(3);
//
//        System.out.println("Ԥ����:");
//        for (int i = 0; i < forecasts.length; i++) {
//            System.out.printf("δ����%d��ʱ���: %.2f%n", i + 1, forecasts[i]);
//        }
//
//        // ���ģ�Ͳ���
//        System.out.println("\nģ�Ͳ���:");
//        System.out.println("AR����: " + Arrays.toString(arima.getARParams()));
//        System.out.println("MA����: " + Arrays.toString(arima.getMAParams()));
//        System.out.println("�ؾ�: " + arima.getIntercept());
//    }
//}