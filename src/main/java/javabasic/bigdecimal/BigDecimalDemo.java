package javabasic.bigdecimal;

import java.math.BigDecimal;

/**
 * xxx
 *
 * @author lwy
 * @date 2025/05/08 11:36
 **/
public class BigDecimalDemo {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        /////////////////////创建0.1的方法////////////////////////
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            BigDecimal bigDecimal = new BigDecimal(0.1);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

        for (int i = 0; i < 100000; i++) {
            BigDecimal bigDecimal = BigDecimal.valueOf(0.1);
        }
        long t3 = System.currentTimeMillis();
        System.out.println(t3 - t2);

        /////////////////////创建0的方法////////////////////////
        long t11 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            BigDecimal bigDecimal = BigDecimal.valueOf(0);
        }
        long t12 = System.currentTimeMillis();
        System.out.println(t12 - t11);

        long t13 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            BigDecimal bigDecimal = BigDecimal.ZERO;
        }
        long t14 = System.currentTimeMillis();
        System.out.println(t14 - t13);
    }

}
