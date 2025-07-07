package javabasic;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

/**
 * 单测的classpath顺序：1.优先是test
 *
 * @author lwy
 * @date 2025/04/27 17:40
 **/
public class classpathDemo {
    public static void main(String[] args) {
        String metricPath = ResourceUtils.CLASSPATH_URL_PREFIX + "metric/alarm.xml";
        try {
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources(metricPath);
            System.out.println(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("hello classpath");
    }
}
