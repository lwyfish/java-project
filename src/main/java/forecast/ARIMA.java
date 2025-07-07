package forecast;

import java.util.Arrays;

public class ARIMA {
    private final int p; // 自回归阶数
    private final int d; // 差分阶数
    private final int q; // 移动平均阶数
    
    private double[] arParams; // 自回归参数
    private double[] maParams; // 移动平均参数
    private double intercept;  // 截距项
    private double[] residuals; // 残差
    
    public ARIMA(int p, int d, int q) {
        this.p = p;
        this.d = d;
        this.q = q;
        this.arParams = new double[p];
        this.maParams = new double[q];
        this.intercept = 0.0;
    }
    
    /**
     * 训练ARIMA模型
     * @param timeSeries 时间序列数据
     */
    public void train(double[] timeSeries) {
        // 1. 应用差分使时间序列平稳
        double[] differenced = timeSeries.clone();
        for (int i = 0; i < d; i++) {
            differenced = difference(differenced);
        }
        
        // 2. 估计AR和MA参数
        // 这里简化处理，实际应用中应该使用更复杂的估计方法
        // 例如最大似然估计或条件最小二乘法
        estimateParameters(differenced);
        
        // 3. 计算残差
        residuals = calculateResiduals(differenced);
    }
    
    /**
     * 对时间序列进行差分
     */
    private double[] difference(double[] series) {
        double[] diff = new double[series.length - 1];
        for (int i = 1; i < series.length; i++) {
            diff[i - 1] = series[i] - series[i - 1];
        }
        return diff;
    }
    
    /**
     * 估计AR和MA参数
     */
    private void estimateParameters(double[] series) {
        // 简化实现：使用Yule-Walker方程估计AR参数
        // 实际应用中应使用更精确的方法
        if (p > 0) {
            double[] acf = calculateACF(series, p);
            double[] phi = solveYuleWalker(acf);
            System.arraycopy(phi, 0, arParams, 0, p);
        }
        
        // 简化实现：MA参数设为0
        // 实际应用中应使用MLE或其他方法估计
        Arrays.fill(maParams, 0.0);
        
        // 计算截距项
        double mean = 0;
        for (double value : series) {
            mean += value;
        }
        mean /= series.length;
        intercept = mean;
    }
    
    /**
     * 计算自相关函数
     */
    private double[] calculateACF(double[] series, int maxLag) {
        double[] acf = new double[maxLag + 1];
        double mean = 0;
        for (double value : series) {
            mean += value;
        }
        mean /= series.length;
        
        double variance = 0;
        for (double value : series) {
            variance += Math.pow(value - mean, 2);
        }
        variance /= series.length;
        
        acf[0] = 1.0; // 自相关在lag=0时为1
        
        for (int lag = 1; lag <= maxLag; lag++) {
            double sum = 0;
            for (int i = 0; i < series.length - lag; i++) {
                sum += (series[i] - mean) * (series[i + lag] - mean);
            }
            acf[lag] = sum / (variance * (series.length - lag));
        }
        
        return acf;
    }
    
    /**
     * 求解Yule-Walker方程获取AR参数
     */
    private double[] solveYuleWalker(double[] acf) {
        int n = acf.length - 1;
        double[] phi = new double[n];
        
        // Levinson-Durbin递推算法
        double[] phiTemp = new double[n];
        double[] v = new double[n + 1];
        v[0] = 1.0;
        v[1] = 1.0 - acf[1] * acf[1];
        phi[0] = acf[1];
        
        for (int k = 1; k < n; k++) {
            double sum = 0;
            for (int j = 0; j < k; j++) {
                sum += phi[j] * acf[k - j];
            }
            phiTemp[k] = (acf[k + 1] - sum) / v[k];
            
            for (int j = 0; j < k; j++) {
                phiTemp[j] = phi[j] - phiTemp[k] * phi[k - j - 1];
            }
            
            for (int j = 0; j <= k; j++) {
                phi[j] = phiTemp[j];
            }
            
            v[k + 1] = v[k] * (1.0 - phi[k] * phi[k]);
        }
        
        return phi;
    }
    
    /**
     * 计算残差
     */
    private double[] calculateResiduals(double[] series) {
        int n = series.length;
        double[] residuals = new double[n];
        
        for (int i = 0; i < n; i++) {
            double prediction = intercept;
            
            // AR部分
            for (int j = 0; j < p && i > j; j++) {
                prediction += arParams[j] * series[i - j - 1];
            }
            
            // MA部分（简化为0）
            // 实际应用中应包含残差的历史值
            
            residuals[i] = series[i] - prediction;
        }
        
        return residuals;
    }
    
    /**
     * 预测未来值
     * @param steps 预测的步数
     * @return 预测值数组
     */
    public double[] forecast(int steps) {
        // 获取原始时间序列的最后d个值用于还原差分
        // 这里简化处理，实际应用中需要更复杂的逻辑
        
        double[] forecasts = new double[steps];
        
        // 预测差分序列
        for (int i = 0; i < steps; i++) {
            double forecast = intercept;
            
            // AR部分
            for (int j = 0; j < p; j++) {
                if (i > j) {
                    forecast += arParams[j] * forecasts[i - j - 1];
                } else {
                    // 使用训练数据的最后值
                    // 这里简化处理
                }
            }
            
            // MA部分（简化为0）
            
            forecasts[i] = forecast;
        }
        
        // 还原差分
        // 这里简化处理，实际应用中需要实现差分的逆操作
        
        return forecasts;
    }
    
    /**
     * 获取模型参数
     */
    public double[] getARParams() {
        return arParams.clone();
    }
    
    public double[] getMAParams() {
        return maParams.clone();
    }
    
    public double getIntercept() {
        return intercept;
    }
    
    public double[] getResiduals() {
        return residuals.clone();
    }
}
