package javabasic.generic;

import java.util.ArrayList;
import java.util.List;

public class Collections {
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            T t = src.get(i); // src 是 producer
            dest.add(t); // dest 是 consumer
        }
    }

    public static void main(String[] args) {
        // 创建源列表
        List<String> srcList = new ArrayList<>();
        srcList.add("A");
        srcList.add("B");
        srcList.add("C");

        // 创建目标列表（需要足够大的容量）
        List<String> destList = new ArrayList<>(srcList.size());
        // 初始化目标列表容量（如果使用固定大小列表如Arrays.asList，则不需要）
//        for (int i = 0; i < srcList.size(); i++) {
//            destList.add(null);
//        }
        destList.add("1");

        // 使用copy方法复制
        Collections.copy(destList, srcList);

        System.out.println("源列表: " + srcList);
        System.out.println("目标列表: " + destList);

    }
}