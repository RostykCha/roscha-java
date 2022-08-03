package knowledge.roschajava.patterns.combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static knowledge.roschajava.patterns.combinator.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator
    extends Function<CustomerForCombinator, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> {
            System.out.println("isEmailValid lambda called");
            return customer.getEmail().contains("@") ?
                SUCCESS : EMAIL_NOT_VALID;
        };
    }

    static CustomerRegistrationValidator isPhoneValid() {
        return customer -> {
            System.out.println("isPhoneValid lambda called");
            return customer.getPhoneNumber().startsWith("+") ?
                SUCCESS : PHONE_NOT_VALID;
        };
    }

    static CustomerRegistrationValidator isAdult() {
        return customer -> {
            System.out.println("isAdult lambda called");
            return Period.between(customer.getDob(), LocalDate.now())
                .getYears() > 18 ? SUCCESS : IS_NOT_ADULT;
        };
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            System.out.println("and lambda called");
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_ADULT
    }

}
