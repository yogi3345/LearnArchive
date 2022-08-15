package design.pattern.combinator;

import design.pattern.combinator.customer.Customer;

import java.util.List;
import java.util.stream.Collectors;

import static design.pattern.combinator.customer.validator.CustomerValidator.*;

public class CombinatorPattern {

    public static void main(String args[]) {
        Customer c1 = new Customer(101, "abc def", "s@g", 19);
        Customer c2 = new Customer(321, "dfvnh jhgg", "f@a", 15);
        Customer c3 = new Customer(156, "fbv sdfds", "frd", 25);
        Customer c4 = new Customer(104, "des", "v@a", 18);

        List<Customer> customers = List.of(c1, c2, c3, c4);

        var results =
                customers.stream().map(
                        customer -> validateName()
                                .and(validateEmail())
                                .and(validateAge())
                                .apply(customer))
                        .collect(Collectors.toList());
        results.forEach(System.out::println);
    }
}
