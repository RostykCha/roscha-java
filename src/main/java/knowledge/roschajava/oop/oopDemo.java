package knowledge.roschajava.oop;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class oopDemo {
    static Person person = new Person("Alan", 35);
    static Person person2 = new Person("Alan", 35);
    static Person person3 = new Person("Mike", 15);
    static Person person4 = new Person("Cana", 23);
    static Person person5 = new Person("Bob", 23);

    public static void main(String[] args) {

    }

    static void mapPersonDemo() {
        List<Person> personList = new ArrayList<>(Arrays.asList(person, person2, person3, person4, person5));
        System.out.println(personList);

        Map<String, Person> personMap = personList.stream()
            .collect(Collectors.toMap(person1 -> person1.getName(),
                Function.identity(),
                (existing, replacement) -> existing
            ));

        System.out.println(personMap);
    }

    static void setPersonDemo() {
        List<Person> personList2 = new ArrayList<>(Arrays.asList(person, person2, person3, person4, person5));
        System.out.println(personList2);

        //Has unique values, not sorted
        HashSet<Person> personHashSet = new HashSet<>(personList2);
        System.out.println("HashSet: " + personHashSet);

        //Has unique values, sorted using Comparable
        TreeSet<Person> personTreeSet = new TreeSet<>(personList2);
        System.out.println("TreeSet: " + personTreeSet);
    }

    static void listPersonDemo() {
        System.out.println(person == person2);
        System.out.println(person.equals(person2));

        List<Person> personList = new ArrayList<>(Arrays.asList(person, person2, person3, person4, person5));
        System.out.println(personList);

        Collections.sort(personList);
        System.out.println(personList);
    }
}
