package javabasic.binarysearch;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TimeRange {
    long start;
    long end;

    public TimeRange(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + ")";
    }
}

public class TimeSegmentation {

    /**
     * 把起始时间戳按照指定时间间隔分割成若干个时间段
     *
     * @param startTime 起始时间戳
     * @param interval  时间间隔（单位：秒）
     * @return 时间段列表
     */
    public static List<TimeRange> splitTime(long startTime, long endTime, int interval) {
        List<TimeRange> segments = new ArrayList<>();
        long intervalMs = interval * 1000L;
        // 调整起始时间，使其能被时间间隔整除
        long adjustedStart = startTime - (startTime % intervalMs);
        long current = adjustedStart;
        while (current < endTime) {
            long end = current + intervalMs;
            if (end > endTime) {
                end = endTime;
            }
            segments.add(new TimeRange(current, end));
            current = end;
        }
        return segments;
    }

    public static List<Long> splitTime1(long startTime, long endTime, int interval) {
        List<Long> segments = new ArrayList<>();
        // 不考虑毫秒
        startTime = startTime / 1000;
        endTime = endTime / 1000;

        // 第一个点
        segments.add(startTime);

        // 调整起始时间，使其能被时间间隔整除
        long firstStartTime = startTime - (startTime % interval);
        long firstEndTime = firstStartTime + interval;
        if (firstEndTime > startTime) {
            segments.add(firstEndTime);
        }

        long current = firstEndTime;
        while (current < endTime) {
            long end = current + interval;
            if (end > endTime) {
                end = endTime;
            }
            segments.add(end);
            current = end;
        }
        for (int i = 0; i < segments.size(); i++) {
            segments.set(i, segments.get(i) * 1000);
        }
        return segments;
    }

    /**
     * 使用二分法查找指定时间戳所在的时间段
     *
     * @param segments  时间段列表
     * @param timestamp 要查找的时间戳
     * @return 时间戳所在的时间段，如果未找到则返回 null
     */
    public static List<Long> findSegment(List<Long> segments, long timestamp) {
        int left = 0;
        int right = segments.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && timestamp >= segments.get(mid - 1) && timestamp <= segments.get(mid)) {
                return Arrays.asList(segments.get(mid - 1), segments.get(mid));
            } else if (mid == 0 && timestamp >= segments.get(mid) && timestamp <= segments.get(mid + 1)) {
                return Arrays.asList(segments.get(mid), segments.get(mid + 1));
            } else if (segments.get(mid) < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        test();
        test2();
    }

    public static void test() {
//        long startTime = System.currentTimeMillis();
//        long endTime = startTime + 6 * 1000;
        long startTime = 1744716613330L;
        long endTime = 1744716614330L;
//        int interval = 5;
        int interval = 86400;
        List<Long> spliceTime = splitTime1(startTime, endTime, interval);
        for (int i = 0; i < spliceTime.size(); i++) {
            long time = spliceTime.get(i);
            // 将时间戳转换为 Instant 对象
            Instant instant = Instant.ofEpochMilli(time);
            // 获取系统默认时区
            ZoneId zoneId = ZoneId.systemDefault();
            // 将 Instant 对象转换为 LocalDateTime 对象
            LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
            System.out.println(localDateTime);
        }
        System.out.println(spliceTime);
        // 这里输入需要省略后面的毫秒
        List<Long> segment = findSegment(spliceTime, 1734716613330L);
        System.out.println(segment);
    }

    public static void test1() {
        long startTime = System.currentTimeMillis() - 3600 * 1000; // 1 小时前
        int interval = 1800; // 30 分钟
        List<TimeRange> segments = splitTime(startTime, startTime, interval);
        System.out.println("分割后的时间段：");
        for (TimeRange segment : segments) {
            System.out.println(segment);
        }
    }

    public static void test2() {
        getTruncatedTime(LocalDateTime.now(), 3600);
    }

    public static LocalDateTime getTruncatedTime(LocalDateTime dateTime, int diff) {
        LocalTime time = dateTime.toLocalTime();
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = 0;
        if (diff > 3600) {
            hour = 0;
        }
        if (diff > 60) {
            minute = 0;
        }
        LocalTime truncatedTime = LocalTime.of(hour, minute, second);
        LocalDateTime truncatedDateTime = dateTime.with(truncatedTime);

        return truncatedDateTime;
    }

}
