package javabasic.topN;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TopKMax {
    public static int[] findTopKMax(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0) {
            return new int[0];
        }

        // 创建容量为k的小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num); // 堆未满时直接添加
            } else if (num > minHeap.peek()) {
                minHeap.poll();     // 移除当前最小元素
                minHeap.offer(num); // 添加更大的元素
            }
        }

        // 结果按从大到小排序
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 3;
        int[] topK = findTopKMax(nums, k);
        System.out.println("最大的" + k + "个元素：");
        for (int num : topK) {
            System.out.print(num + " "); // 输出：6 5 4
        }
    }
}