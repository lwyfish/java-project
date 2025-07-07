package forecast;

import smile.data.DataFrame;
import smile.data.formula.Formula;
import smile.regression.LinearModel;
import smile.regression.OLS;

public class Demo1 {
    public static void main(String[] args) {
        // 创建样本数据集：第一个元素是时间点，第二个元素是对应时刻的容量
        double[][] data = {
                {1, 10}, {2, 12}, {3, 15}, {4, 18},
                {5, 22}, {6, 25}, {7, 28}, {8, 32}, {9, 35}
        };

        // 创建DataFrame，假设有两列，第一列是时间（"Time"），第二列是容量（"Capacity"）
        DataFrame df = DataFrame.of(data, "Time", "Capacity");
        // 使用普通最小二乘法(OLS)进行线性回归
        LinearModel model = OLS.fit(Formula.lhs("Capacity"), df);
        // TODO:
//        model.update();

        // 输出模型参数
        System.out.println("Intercept: " + model.intercept());
        System.out.println("Coefficients: " + model.coefficients());

        // 预测未来的容量，例如时间点为10时的容量
        double futureTime = 10;
        double[] x = {futureTime}; // 对于一维输入特征，包装成数组
        double predictedCapacity = model.predict(x);
        System.out.println("Predicted capacity at time " + futureTime + ": " + predictedCapacity);
    }
}
