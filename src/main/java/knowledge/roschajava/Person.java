package knowledge.roschajava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Person {
    private String name;
    private Integer age;
    private Boolean isPidar;


    public  void tellName(){
        System.out.println("My name is: " + name);
    }
}
