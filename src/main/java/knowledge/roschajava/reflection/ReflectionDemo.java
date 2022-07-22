package knowledge.roschajava.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReflectionDemo {

    public static void main(String[] args) {
        Field[] allFields = ReflectionPerson.class.getDeclaredFields();
        System.out.println(Arrays.stream(allFields).collect(Collectors.toList()));
    }

}
