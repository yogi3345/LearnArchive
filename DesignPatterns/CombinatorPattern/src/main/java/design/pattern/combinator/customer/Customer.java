package design.pattern.combinator.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private int Id;
    private String name;
    private String email;
    private int age;
}
