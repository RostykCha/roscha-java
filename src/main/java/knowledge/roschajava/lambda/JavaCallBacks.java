package knowledge.roschajava.lambda;

import java.util.function.Consumer;

public class JavaCallBacks {

    public static void main(String[] args) {
        hello("Rostik", null, value -> System.out.println("No second name for user " + value));
        hello("Rostik", null, value -> System.out.println("No surname for user " + value));
    }

    static void hello(String firstNAme, String lastName, Consumer<String> callback) {
        System.out.println(firstNAme);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstNAme);
        }

    }

}
