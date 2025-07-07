package javabasic;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lwy
 * @date 2025/06/09 16:57
 **/
public class demo3 {
    public static void main(String[] args) throws IOException {
        long l = calc2(new Byte("1"));
        System.out.println(l);
    }

    public static void calc1() {
        List<Object> objectList = new ArrayList();
        String a = "Hello World";
        Byte b = new Byte("1");
        objectList.add(a);
        objectList.add(b);
        for (Object o : objectList) {
//            long size = ObjectSizeCalculator.getObjectSize(o);
//            System.out.println(o + " Size: " + size + " bytes");
        }
    }

    public static long calc2(Object object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        try {
            oos.writeObject(object);
            return baos.toByteArray().length;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            oos.close();
            baos.close();
        }
        return 0L;
    }
}
