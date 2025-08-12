package javabasic;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;

public class FIFOCacheDemo {
    public static void main(String[] args) {
        // 1. 创建FIFOCache，设置容量为3（最多存储3个元素）
        Cache<String, String> fifoCache = CacheUtil.newFIFOCache(3);
        
        // 2. 放入元素
        fifoCache.put("a", "valueA");
        fifoCache.put("b", "valueB");
        fifoCache.put("c", "valueC");
        String s = fifoCache.get("11");
        System.out.println("放入3个元素后：" + fifoCache); // {a=valueA, b=valueB, c=valueC}
        
        // 3. 当放入第4个元素时，最早放入的"a"会被移除
        fifoCache.put("d", "valueD");
        System.out.println("放入第4个元素后：" + fifoCache); // {b=valueB, c=valueC, d=valueD}
        
        // 4. 获取元素
        String value = fifoCache.get("b");
        System.out.println("获取key为b的值：" + value); // valueB
        
        // 5. 移除元素
        fifoCache.remove("c");
        System.out.println("移除key为c后：" + fifoCache); // {b=valueB, d=valueD}
        
        // 6. 清空缓存
        fifoCache.clear();
        System.out.println("清空后：" + fifoCache); // {}
    }
}
