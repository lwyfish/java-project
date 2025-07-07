package javabasic.topN;

import java.util.Collections;
import java.util.PriorityQueue;

public class TopKMin {
    public static int[] findTopKMin(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0) {
            return new int[0];
        }
        
        // 创建容量为k的大顶堆
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int num : nums) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num); // 堆未满时直接添加
            } else if (num < maxHeap.peek()) {
                maxHeap.poll();     // 移除当前最大元素
                maxHeap.offer(num); // 添加更小的元素
            }
        }
        
        // 结果按从小到大排序
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 3;
        int[] topK = findTopKMin(nums, k);
        System.out.println("最小的" + k + "个元素：");
        for (int num : topK) {
            System.out.print(num + " "); // 输出：1 2 3
        }
    }
}