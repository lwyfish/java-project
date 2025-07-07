package javabasic.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapMethodsExample {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        // 1. computeIfAbsent 方法
        // 这个方法的作用是检查映射中是否已经有了指定的键，如果有，它就会返回键对应的值。如果没有，它会使用给定的函数来计算值，然后将键与计算出来的值关联在一起

        HashMap<String, List<Integer>> hashMap = new HashMap<>();
        List<Integer> list = hashMap.getOrDefault("key", new ArrayList<>());
        list.add(1);
        // 更新hashmap
        hashMap.put("key", list);

        HashMap<String, List<Integer>> hashMap1 = new HashMap<>();
        // 使用 computeIfAbsent 方法优化操作
        hashMap1.computeIfAbsent("key", k -> new ArrayList<>()).add(1);
    }

    public static void test1() {
        // 1. 创建 HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 2. 添加元素
        System.out.println("--- 添加元素 ---");
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("cherry", 3);
        System.out.println("添加元素后: " + hashMap);

        // 3. 获取元素
        System.out.println("\n--- 获取元素 ---");
        Integer value = hashMap.get("apple");
        System.out.println("键 'apple' 对应的值: " + value);

        Integer defaultValue = hashMap.getOrDefault("date", 0);
        System.out.println("键 'date' 对应的值（若不存在返回默认值）: " + defaultValue);

        boolean hasKey = hashMap.containsKey("banana");
        System.out.println("是否包含键 'banana': " + hasKey);

        boolean hasValue = hashMap.containsValue(3);
        System.out.println("是否包含值 3: " + hasValue);

        // 4. 删除元素
        System.out.println("\n--- 删除元素 ---");
        Integer removedValue = hashMap.remove("cherry");
        System.out.println("移除键 'cherry'，对应的值为: " + removedValue);
        System.out.println("移除 'cherry' 后: " + hashMap);

        boolean removed = hashMap.remove("apple", 1);
        System.out.println("是否成功移除键 'apple' 且值为 1: " + removed);
        System.out.println("移除 'apple' 且值为 1 后: " + hashMap);

        // 5. 修改元素
        System.out.println("\n--- 修改元素 ---");
        hashMap.put("banana", 5);
        System.out.println("修改键 'banana' 的值为 5 后: " + hashMap);

        // 6. 遍历元素
        System.out.println("\n--- 遍历元素 ---");
        // 遍历键值对
        System.out.println("遍历键值对:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 遍历键
        System.out.println("\n遍历键:");
        for (String key : hashMap.keySet()) {
            System.out.println(key);
        }

        // 遍历值
        System.out.println("\n遍历值:");
        for (Integer val : hashMap.values()) {
            System.out.println(val);
        }

        // 7. 获取大小
        System.out.println("\n--- 获取大小 ---");
        int size = hashMap.size();
        System.out.println("HashMap 的大小: " + size);

        // 8. 清空 HashMap
        System.out.println("\n--- 清空 HashMap ---");
        hashMap.clear();
        System.out.println("清空后: " + hashMap);
    }
}