package knowledge.roschajava.streams;

import knowledge.roschajava.collections.Animal;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

    }

    void flatMapDemo(){
        List<Animal> list = Animal.getAnimalList();

        Set<String> nicknames = list.stream() // Stream<Animal>
            .map(Animal::getNicknames)  // Stream<List<String>>
            .flatMap(a -> a.stream()) // Stream<String>
            .collect(Collectors.toSet());

        System.out.println(nicknames);
    }

    void mapDemo() {
        List<Animal> list = Animal.getAnimalList();

        List<String> nameList = list.stream()
            .map(Animal::getName)
            .peek(System.out::println)
            .map(String::toUpperCase)
            .peek(System.out::println)
            .collect(Collectors.toList());

        System.out.println(nameList);
    }

    void streamDemo() {
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
