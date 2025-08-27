import lombok.Getter;
import lombok.Setter;

/**
 * test
 *
 * @author lwy
 * @date 2025/08/23 14:50
 **/
public class test2 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        try {
            Person person1 = new Person();
            person1.setAge(null);

//        if (person1.getAge() > 5) {
//            System.out.println(">5");
//        }
            person1 = null;
            if (person1.getAge() > 5) {
                System.out.println(">5");
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }

    }
}
@Setter
@Getter
class Person{
    private Long age;
}
