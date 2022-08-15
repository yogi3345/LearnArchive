package design.pattern.combinator.customer.validator;

import design.pattern.combinator.customer.Customer;

import java.util.function.Function;

import static design.pattern.combinator.customer.validator.CustomerValidator.*;
import static design.pattern.combinator.customer.validator.CustomerValidator.ValidationResult.*;

@FunctionalInterface
public interface CustomerValidator extends Function<Customer, ValidationResult> {

    static CustomerValidator validateAge() {
        return customer -> customer.getAge() >=18 ? SUCCESS : NOT_AN_ADULT;
    }

    static CustomerValidator validateEmail() {
        return customer -> customer.getEmail().contains("@") ? SUCCESS : BAD_EMAIL_FORMAT;
    }

    static CustomerValidator validateName() {
        return customer -> customer.getName().split(" ").length >=2 ? SUCCESS : BAD_NAME_FORMAT;
    }

    default CustomerValidator and(CustomerValidator nextValidator) {
        return customer ->  {
            var result = this.apply(customer);
            return result.equals(SUCCESS) ? nextValidator.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        BAD_NAME_FORMAT,
        BAD_EMAIL_FORMAT,
        NOT_AN_ADULT
    }
}
