package knowledge.roschajava.lambda;

import java.util.*;
import java.util.function.*;

public class LambdaExample {


    public static void main(String[] args) {



    }

    static void unaryBinaryOperatorsFIDemo() {
        UnaryOperator<String> upperCaseFunction = s -> s.toUpperCase(Locale.ROOT);
        System.out.println(upperCaseFunction.apply("it works"));

        BinaryOperator<Integer> binaryOperatorMultiply = (i1, i2) -> i1 * i2;
        System.out.println(binaryOperatorMultiply.apply(5, 10));
    }

    static void functionFIDemo() {
        Function<String, String> toUpperCase = (s -> s.toUpperCase(Locale.ROOT).concat("F1"));
        Function<String, String> addString = (s -> s.concat("F2"));

        System.out.println("Result is: " + toUpperCase.andThen(addString).apply("it works "));
        System.out.println("Seconde result is: " + toUpperCase.compose(addString).apply("it works "));

        BiFunction<Integer, Integer, Integer> addTwoNumbers = (i1, i2) -> i1 + i2;

        System.out.println(addTwoNumbers.apply(5, 3));

    }

    static void predicateFIDemo() {
        Predicate<Integer> integerpredicateisdividedbytwo = (i) -> i % 2 == 0;

        Predicate<Integer> isDividedByFive = (i) -> i % 5 == 0;


        System.out.println(integerpredicateisdividedbytwo.test(4));

        System.out.println(integerpredicateisdividedbytwo.and(isDividedByFive).test(8));

        System.out.println(integerpredicateisdividedbytwo.negate().test(4));


        BiPredicate<Integer, Integer> areTheySumBiggerThanTen = (i, i2) -> i + i2 > 10;

        System.out.println(areTheySumBiggerThanTen.test(8, 5));
    }

    static void consumerFIDemo() {
        Consumer<String> consumersPrint = (s -> System.out.println(s + " First"));
        Consumer<String> consumerAdd = (s -> System.out.println(s + " Second"));
        BiConsumer<Integer, String> biConsumer = (integer, s) -> {
            System.out.println(String.format("ID is %s AND Value is %s", integer, s));
        };

        List<String> list = List.of("Ana", "Das", "Bob");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "\"GALANKA\"");

        list.forEach(consumersPrint.andThen(consumerAdd));

        list.forEach(s -> System.out.println(s + "  WOW!"));

        map.forEach(biConsumer);
    }

    static void supplierFIDemo(){
        Supplier<String> stringSupplier = () -> "ID:" + Math.random();
        System.out.println(stringSupplier.get());
    }

    static void general() {
        //before Java 8
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable 1");
            }
        };

        //after Java 8
        Runnable runnableLambda = () -> {
            System.out.println("runnableLambda");
        };

        //shorter

        new Thread(() -> System.out.println("shortVersion")).start();
        new Thread(runnable).start();
        new Thread(runnableLambda).start();

        Comparator<Integer> integerComparator = (a, b) -> a.compareTo(b);
    }

}
