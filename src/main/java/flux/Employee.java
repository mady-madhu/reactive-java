package flux;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Employee {

    private int id;
    private int age;
    private int salary;

}
