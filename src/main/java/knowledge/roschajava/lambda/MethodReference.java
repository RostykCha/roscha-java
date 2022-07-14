package knowledge.roschajava.lambda;

import java.util.function.Consumer;

public class MethodReference {

    static void methodReferenceStatic(String s) {
        String result = "Hey I am static method! " + s;
        System.out.println(result);
    }

    void methodReferenceInstance(String s) {
        String result = "Hey I am instance method! " + s;
        System.out.println(result);
    }

    public static void main(String[] args) {
        MethodReference methodReference = new MethodReference();

        Consumer<String> staticConsumerReference = MethodReference::methodReferenceStatic;
        Consumer<String> instanceConsumerReference = methodReference::methodReferenceInstance;

        staticConsumerReference.andThen(instanceConsumerReference).accept("Dsfsd");

    }

}
