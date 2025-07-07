package javabasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lwy
 * @date 2025/06/09 16:57
 **/
public class demo4 {
    enum resTypeEnum{
        AAA((short)1);
        short code;
        resTypeEnum(short code){
            this.code = code;
        }
    }

    public static void main(String[] args) {

        String name = resTypeEnum.AAA.name();


        HashMap<String, List<String>> hashMap = new HashMap<>();
        List<String> stringsList = new ArrayList<>();
        stringsList.add("1");
        hashMap.put("key1", stringsList);


        // 获取，替换
        List<String> stringsNewList = new ArrayList<>();
        stringsNewList.add("2");

        List<String> key1 = hashMap.computeIfAbsent("key1", ignore -> new ArrayList<>());
        key1 = stringsNewList;
        hashMap.put("key1", stringsNewList);
        System.out.println(hashMap.get("key1"));

        hashMap.get("key1").add("3");
        System.out.println(hashMap.get("key1"));


    }
}
