package performance;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author lwy
 * @date 2025/05/14 14:01
 **/
public class testprefix {
    public static void main(String[] args) {
        // 示例：计算 25 分钟前的时间所属区间
        LocalDateTime startTime = LocalDateTime.now().minusMinutes(3000);
        System.out.println("开始时间: " + startTime);
        System.out.println("所属区间: " + getTimePeriod(startTime));
    }

    public static String getTimePeriod(LocalDateTime startTime) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(startTime, now);

        // 定义各时间段的阈值（Duration 对象）
        Duration thirtyMinutes = Duration.ofMinutes(30);
        Duration sixHours = Duration.ofHours(6);
        Duration oneDay = Duration.ofDays(1);
        Duration threeDays = Duration.ofDays(3);
        Duration sevenDays = Duration.ofDays(7);
        Duration fifteenDays = Duration.ofDays(15);
        Duration thirtyDays = Duration.ofDays(30);
        Duration threeMonths = Duration.ofDays(3 * 30); // 简化计算，每月按 30 天算
        Duration oneYear = Duration.ofDays(365);
        Duration threeYears = Duration.ofDays(3 * 365);

        // 按从短到长的顺序判断
        if (duration.compareTo(thirtyMinutes) <= 0) {
            return "最近30分钟";
        } else if (duration.compareTo(sixHours) <= 0) {
            return "最近6小时";
        } else if (duration.compareTo(oneDay) <= 0) {
            return "最近1天";
        } else if (duration.compareTo(threeDays) <= 0) {
            return "最近3天";
        } else if (duration.compareTo(sevenDays) <= 0) {
            return "最近7天";
        } else if (duration.compareTo(fifteenDays) <= 0) {
            return "最近15天";
        } else if (duration.compareTo(thirtyDays) <= 0) {
            return "最近30天";
        } else if (duration.compareTo(threeMonths) <= 0) {
            return "最近3月";
        } else if (duration.compareTo(oneYear) <= 0) {
            return "最近1年";
        } else if (duration.compareTo(threeYears) <= 0) {
            return "最近3年";
        } else {
            return "超过3年";
        }
    }

}
