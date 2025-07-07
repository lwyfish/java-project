package javabasic.topN;

import java.util.*;

public class TopNWithPriorityQueue {
    public static <T> List<T> getTopN(Collection<T> collection, int n, Comparator<T> comparator) {
        // 创建最小堆（当需要取最大的N个元素时）
        PriorityQueue<T> heap = new PriorityQueue<>(comparator);

        for (T item : collection) {
            if (heap.size() < n) {
                heap.offer(item);
            } else if (comparator.compare(item, heap.peek()) > 0) {
                heap.poll();
                heap.offer(item);
            }
        }

        // 将结果转为List并排序（如果需要有序）
        List<T> result = new ArrayList<>(heap);
//        result.sort(comparator.reversed());
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(100, 10, 5, 8, 20, 3, 15, 7, 25, 18, 99);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        int compare = comparator.compare(100, 10);
        System.out.println("compare " + compare);

        // 获取最大的5个数
        List<Integer> a = getTopN(numbers, 5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println("Top 5 numbers: " + a); // [25, 20, 18, 15, 10]

        // 获取最大的5个数
        List<Integer> top5 = getTopN(numbers, 5, Comparator.naturalOrder());
        System.out.println("Top 5 numbers: " + top5); // [25, 20, 18, 15, 10]

        // 获取最小的3个数
        List<Integer> bottom3 = getTopN(numbers, 5, Comparator.reverseOrder());
        System.out.println("Bottom 3 numbers: " + bottom3); // [3, 5, 7]
    }
}