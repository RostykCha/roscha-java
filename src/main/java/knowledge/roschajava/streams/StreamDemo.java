package knowledge.roschajava.streams;

import knowledge.roschajava.collections.Animal;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = Animal.getAnimalList().stream()
            .filter(Animal::getDomestic)
            .collect(Collectors.toMap(Animal::getName, Animal::getAge));

        System.out.println(map);
    }

}
