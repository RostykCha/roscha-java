package knowledge.roschajava.collections;

import java.util.List;

public class Animal {
    private String name;
    private Integer eatPerDayKg;
    private Integer age;
    private Boolean isDomestic;
    private List<String> nicknames;

    private static List<Animal> animalList = List.of(
        new Animal("Cow", 10, true, List.of("Mumu", "Woka", "Keli"), 20)
        , new Animal("Dog", 5, true, List.of("Petrushka", "Borka", "Archi"), 9)
        , new Animal("Wolf", 9, false, List.of("Akkela", "Humter", "Auf"), 12)
        , new Animal("Aligator", 9, false, List.of("Nil", "Brian", "Frank"), 30)
        , new Animal("Elephant", 15, false, List.of("Shon", "Bob", "Myke"), 90)
    );

    public Animal(String name, Integer age, Boolean isDomestic, List<String> nicknames, Integer eatPerDayKg) {
        this.name = name;
        this.age = age;
        this.isDomestic = isDomestic;
        this.nicknames = nicknames;
        this.eatPerDayKg = eatPerDayKg;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return String.format("name: %s; age: %s; domestic: %s and eats: %s kilograms per day", name, age, isDomestic, eatPerDayKg);
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

    public Integer getEatPerDayKg() {
        return eatPerDayKg;
    }
}
