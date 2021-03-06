package knowledge.roschajava.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Animal implements Comparable<Animal>, Comparator<Animal>, LivingCreature {
    private String name;
    private Integer eatPerDayKg;
    private Integer age;
    private Boolean isDomestic;
    private List<String> nicknames;

    private static List<Animal> animalList = new ArrayList<>(Arrays.asList(
        new Animal("Cow", 5, true, List.of("Mumu", "Woka", "Keli"), 20)
        , new Animal("Dog", 5, true, List.of("Petrushka", "Borka", "Archi"), 9)
        , new Animal("Wolf", 9, false, List.of("Akkela", "Humter", "Auf"), 12)
        , new Animal("Aligator", 9, false, List.of("Nil", "Brian", "Frank"), 30)
        , new Animal("Elephant", 15, false, List.of("Shon", "Bob", "Myke"), 90)
    ));


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


    @Override
    public void breathe() {
        System.out.println("I am Breathing!");
    }

    public void eat() {
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

    @Override
    public int compareTo(Animal o) {
        return this.getAge().compareTo(o.getAge());
    }

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
