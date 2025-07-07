package javabasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;

public class LogbackExample {
    // 获取 Logger 实例，通常使用当前类的全限定名作为参数
    private static final Logger logger = LoggerFactory.getLogger(LogbackExample.class);

    public static void main(String[] args) {
        // 记录不同级别的日志
        logger.trace("这是一条 TRACE 级别的日志");
        logger.debug("这是一条 DEBUG 级别的日志");
        logger.info("这是一条 INFO 级别的日志");
        logger.warn("这是一条 WARN 级别的日志");
        logger.error("这是一条 ERROR 级别的日志");

        // 记录带参数的日志，推荐使用这种方式，避免字符串拼接带来的性能开销
        String name = "John";
        int age = 30;
        logger.info("用户信息：姓名={}，年龄={}", name, age);

        // 记录异常信息
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            logger.error("发生异常：", e);
        }
    }
}