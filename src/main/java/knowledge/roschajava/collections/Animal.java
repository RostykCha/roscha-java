package knowledge.roschajava.collections;

import java.util.List;

public class Animal {
    private String name;
    private Integer age;
    private Boolean isDomestic;

    private static List<Animal> animalList = List.of(
        new Animal("Cow", 10, true)
        , new Animal("Dog", 5, true)
        , new Animal("Wolf", 9, false)
    );

    public Animal(String name, Integer age, Boolean isDomestic) {
        this.name = name;
        this.age = age;
        this.isDomestic = isDomestic;
    }

    public Animal() {
    }

    void eat() {
        System.out.println("Eating!");
    }

    public static List<Animal> getAnimalList() {
        return animalList;
    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getDomestic() {
        return isDomestic;
    }
}
