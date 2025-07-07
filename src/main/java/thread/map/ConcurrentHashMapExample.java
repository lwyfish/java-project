package thread.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        // 创建 ConcurrentHashMap 实例
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // 写入数据
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        // 读取数据
        Integer value = map.get("banana");
        System.out.println("Value of banana: " + value);

        // 检查键是否存在
        boolean containsKey = map.containsKey("apple");
        System.out.println("Map contains key 'apple': " + containsKey);

        // 删除键值对
        map.remove("cherry");
        System.out.println("After removing cherry, size of javabasic.map: " + map.size());
    }
}