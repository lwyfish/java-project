package javabasic;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * typereference方法
 * 反序列化时使用
 *
 * @author lwy
 * @date 2025/08/27 17:11
 **/
public class TypeReferenceDemo {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        Cat before = new Cat("111", 20);
        String json = toJson(before);
        Cat after = fromJson(json, new TypeReference<Cat>() {
        });
        System.out.println(before);
        System.out.println(after);
    }

    public static <T> T fromJson(String s, TypeReference<T> type) throws JsonProcessingException {
        return objectMapper.readValue(s, type);
    }

    public static String toJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Cat {
    private String name;
    private int age;
}