package knowledge.roschajava.collections;

import java.util.List;

public class Animal {
    private String name;
    private Integer age;
    private Boolean isDomestic;
    private List<String> nicknames;

    private static List<Animal> animalList = List.of(
        new Animal("Cow", 10, true, List.of("Mumu", "Woka", "Keli"))
        , new Animal("Dog", 5, true, List.of("Petrushka", "Borka", "Archi"))
        , new Animal("Wolf", 9, false, List.of("Akkela", "Humter", "Auf"))
        , new Animal("Aligator", 9, false, List.of("Nil", "Brian", "Frank"))
        , new Animal("Elephant", 1, false, List.of("Shon", "Bob", "Myke"))
    );

    public Animal(String name, Integer age, Boolean isDomestic, List<String> nicknames) {
        this.name = name;
        this.age = age;
        this.isDomestic = isDomestic;
        this.nicknames = nicknames;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return String.format("name: %s; age: %s; domestic: %s", name, age, isDomestic);
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

    public List<String> getNicknames() {
        return nicknames;
    }

}
