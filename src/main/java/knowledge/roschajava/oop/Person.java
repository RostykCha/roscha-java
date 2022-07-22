package knowledge.roschajava.oop;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    static {
        System.out.println("I am executed before the constructor bitch!");
    }

    public Person(String name, Integer age) {
        System.out.println(String.format("Constructor with next parameters %s , %s is called", name, age));
        this.name = name;
        this.age = age;
    }

    public void tellName() {
        System.out.println("My name is: " + name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Person otherPerson)) {
            return false;
        }
        return this.getName().equals(otherPerson.getName()) && this.getAge().equals(otherPerson.getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
