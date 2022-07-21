package knowledge.roschajava.streams;

import knowledge.roschajava.collections.Animal;
import knowledge.roschajava.collections.LivingCreature;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.getBirth();

        LivingCreature animal2 = new Animal();
    }

    static void parallelStream() {
        IntStream.rangeClosed(1, 10_000).sum();

    }

    static void partitionByStreamDemo() {
        List<Animal> animalList = Animal.getAnimalList();
        Map<Boolean, List<Animal>> partitionMap = animalList.stream()
            .collect(Collectors.partitioningBy(animal -> animal.getAge() > 10));
        System.out.println(partitionMap);
    }

    static void groupByStreamDemo() {
        List<Animal> animalList = Animal.getAnimalList();

        Map<String, List<Animal>> domesticMap = animalList.stream()
            .collect(Collectors.groupingBy(animal -> animal.getDomestic() ? "Domestic" : "Wild"));
        System.out.println(domesticMap);

        System.out.println();

        Map<String, List<Animal>> ageMap = animalList.stream()
            .collect(Collectors.groupingBy(animal -> animal.getAge() > 10 ? "OLD" : "YOUNG"));
        System.out.println(ageMap);

        System.out.println();

        Map<String, Map<String, List<Animal>>> map = animalList.stream()
            .collect(Collectors.groupingBy(animal -> animal.getDomestic() ? "Domestic" : "Wild",
                Collectors.groupingBy(animal -> animal.getAge() > 10 ? "Old" : "Young")));
        System.out.println(map);

        System.out.println();

        Map<String, Map<String, Long>> map1 = animalList.stream()
            .collect(Collectors.groupingBy(animal -> animal.getDomestic() ? "Domestic" : "Wild",
                Collectors.groupingBy(animal -> animal.getAge() > 10 ? "Old" : "Young",
                    Collectors.counting()
                )));
        System.out.println(map1);

        System.out.println();

        Map<String, Animal> oldest = animalList.stream()
            .collect(Collectors.groupingBy(animal -> animal.getDomestic() ? "Domestic" : "Wild",
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Animal::getAge)), Optional::get)
            ));

        System.out.println(oldest);
    }

    static void collectStreamDemo() {
        List<Animal> animalList = Animal.getAnimalList();

        //Joining
        String allName = animalList.stream().map(Animal::getName)
            .collect(Collectors.joining("; ", "(", ")"));
        System.out.println(allName);

        //Count
        Long oldAnimals = animalList.stream().filter(animal -> animal.getAge() > 10).count();
        System.out.println(oldAnimals);

        //Mapping
        List<String> nameList = animalList.stream()
            .map(Animal::getName)
            .collect(Collectors.toList());
        System.out.println(nameList);

        // Min/Max collector
        Animal oldestAnimal = animalList.stream().max(Comparator.comparing(Animal::getAge)).get();
        Animal youngestAnimal = animalList.stream().min(Comparator.comparing(Animal::getAge)).get();
        System.out.println(oldestAnimal);
        System.out.println(youngestAnimal);

    }

    static void intStreamDemo() {
        IntStream rangedIntStream = IntStream.range(1, 30); // from 1 to 29
        IntStream rangedClosedIntStream = IntStream.rangeClosed(1, 30); // from 1 to 30

        List<Integer> boxingList = rangedClosedIntStream
            //int
            .boxed()
            //Integer
            .collect(Collectors.toList());

        System.out.println(rangedIntStream.sum());

        List<Integer> ageList = Animal.getAnimalList().stream().map(Animal::getAge).collect(Collectors.toList());

        System.out.println("Average animal Age: " + ageList.stream().mapToInt(Integer::intValue).average().getAsDouble());
        System.out.println("Oldest animal Age: " + ageList.stream().mapToInt(Integer::intValue).max().getAsInt());
        System.out.println("Youngest animal Age: " + ageList.stream().mapToInt(Integer::intValue).min().getAsInt());

        System.out.println(ageList.stream().max(Comparator.comparing(Integer::intValue)));

        List<String> stringList = IntStream.rangeClosed(1, 10)
            .mapToObj((i) -> {
                return "ID:" + i;
            })
            .collect(Collectors.toList());
        System.out.println(stringList);
    }

    static void streamFactoryDemo() {
        Stream<String> stringStream = Stream.of("A", "C", "B");
        List<String> stringList = stringStream.collect(Collectors.toList());
        System.out.println(stringList);

        Stream<Integer> integerStream = Stream.iterate(1, x -> x + 1).limit(10);
        integerStream.forEach(integer -> System.out.println(integer));

        Supplier<Integer> integerSupplier = () -> new Random().nextInt();
        Stream.generate(integerSupplier)
            .limit(10)
            .forEach(integer -> System.out.println(integer));
    }

    static void findStreamDemo() {
        List<Animal> animalList = Animal.getAnimalList();

        Animal elephant = animalList.stream()
            .filter(animal -> animal.getName().equals("Elephant"))
            .findFirst()
            .get();

        System.out.println(elephant);
    }

    static void matchStreamDemo() {
        List<String> stringList = List.of("A", "B", "C");
        System.out.println(stringList.stream().allMatch(a -> a.equals("A")));
        System.out.println(stringList.stream().anyMatch(a -> a.equals("A")));
        System.out.println(stringList.stream().noneMatch(a -> a.equals("X")));
    }

    static void limitSkipStreamDemo() {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        integerList.stream().skip(3).forEach(integer -> System.out.println("Skipped logic: " + integer)); // will skip first 3 elements and proceed with rest remaining

        integerList.stream().limit(3).forEach(integer -> System.out.println("Limited logic: " + integer)); // will limit all elements to the first 3, all other will be ignored

    }

    static void reduceStreamDemo() {
        List<Integer> integerList = List.of(2, 4, 6);
        Integer l = integerList.stream()
            // 1 * 2 = 2;
            // 4 * 2 = 8;
            // 6 * 8 = 48;
            .reduce(1, (a, b) -> a * b);

        System.out.println(l);

        List<Animal> animalList = Animal.getAnimalList();
        Optional<Animal> oldestAnimalOptional = animalList.stream().reduce((animal, animal2) -> {
            if (animal.getAge() > animal2.getAge()) {
                return animal;
            } else {
                return animal2;
            }
        });

        System.out.println(oldestAnimalOptional.get());

        Integer totalKilogramsPerDayOfWild = animalList.stream()
            .filter(animal -> !animal.getDomestic())
            .map(Animal::getEatPerDayKg)
            .reduce(0, (integer, integer2) -> integer + integer2);
        System.out.println(totalKilogramsPerDayOfWild);

        animalList.stream()
            .map(animal -> animal.getAge())
            .reduce(0, (x, y) -> x > y ? x : y);

    }

    static void customStreamSortDemo() {
        List<Animal> animalList = Animal.getAnimalList();
        List<Animal> animalListSortedByAge = animalList.stream()
            .sorted(Comparator.comparing(Animal::getAge))
            .collect(Collectors.toList());
        System.out.println(animalListSortedByAge);
    }

    static void distinctSortedCountDemo() {
        List<String> stringList = List.of("a", "v", "c", "f", "d", "a", "s", "a", "b");

        List<String> sortedList = stringList.stream().sorted().collect(Collectors.toList());

        List<String> distinctSortedList = stringList.stream().sorted().distinct().collect(Collectors.toList());

        Long countNumber = sortedList.stream().distinct().count();

        System.out.println(stringList);
        System.out.println(sortedList);
        System.out.println(distinctSortedList);

        System.out.println(countNumber);
    }

    static void flatMapDemo() {
        List<Animal> list = Animal.getAnimalList();

        List<String> nicknames = list.stream() // Stream<Animal>
            .map(Animal::getNicknames)  // Stream<List<String>>
            .flatMap(a -> a.stream()) // Stream<String>
            .sorted()
            .collect(Collectors.toList());

        System.out.println(nicknames);
    }

    static void mapDemo() {
        List<Animal> list = Animal.getAnimalList();

        List<String> nameList = list.stream()
            .map(Animal::getName)
            .peek(System.out::println)
            .map(String::toUpperCase)
            .peek(System.out::println)
            .collect(Collectors.toList());

        System.out.println(nameList);
    }

    static void streamDemo() {
        Map<String, Integer> map = Animal.getAnimalList().stream() //Stream<Student>
            .peek(animal -> System.out.println("FIRST PEEK " + animal))
            .filter(Animal::getDomestic) //Stream<Student> INTERMEDIATE
            .peek(animal -> System.out.println("SECOND PEEK " + animal))
            .filter(animal -> animal.getAge() > 3) //Stream<Student> INTERMEDIATE
            .peek(animal -> System.out.println("THIRD PEEK " + animal))
            .collect(Collectors.toMap(Animal::getName, Animal::getAge)); //Map<String, Integer> TERMINAL

        System.out.println(map);
    }


}
