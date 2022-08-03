package knowledge.roschajava.patterns.combinator;

import java.time.LocalDate;

import static knowledge.roschajava.patterns.combinator.CustomerRegistrationValidator.isAdult;
import static knowledge.roschajava.patterns.combinator.CustomerRegistrationValidator.isPhoneValid;

public class Main {

    public static void main(String[] args) {
        CustomerForCombinator customer = new CustomerForCombinator("Rostik",
            "rosgmail.com",
            "380876453",
            LocalDate.of(1997, 10, 6));

//        //Without Combinator Pattern
//        CustomerPlaneValidationService validationService = new CustomerPlaneValidationService();
//        System.out.println(validationService.isValid(customer));

        //Using Combinator Pattern
        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator.isEmailValid() // isEmailValid() lambda
            .and(isPhoneValid()) //  isEmailValid() lambda = true ? isPhoneValid() :  isEmailValid()
            .and(isAdult()) //  isEmailValid() lambda = true ? isAdult() :  isEmailValid()
            .apply(customer);
        System.out.println(result);
    }

}
