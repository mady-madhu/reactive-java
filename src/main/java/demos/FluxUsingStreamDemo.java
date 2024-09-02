package demos;

import model.Employee;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.*;

public class FluxUsingStreamDemo {


    public static void main(String[] args) throws InterruptedException {

        Employee e1 = Employee.of(1, 20, 2000);
        Employee e2 = Employee.of(2, 30, 3000);
        Employee e3 = Employee.of(3, 40, 4000);
        Employee e4 = Employee.of(4, 50, 5000);
        List<Employee> employeeList = List.of(e1, e2, e3);

        Flux<Employee> employeeFlux = Flux.fromStream(employeeList.stream())
                .sort(Comparator.comparing(Employee::getAge))
                .filter(e -> e.getSalary() > 2000)
                .delayElements(Duration.ofSeconds(2));


        employeeFlux.subscribe(System.out::println);

        Thread.sleep(5000);


    }

}
