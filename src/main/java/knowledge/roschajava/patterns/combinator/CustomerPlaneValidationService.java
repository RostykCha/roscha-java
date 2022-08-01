package knowledge.roschajava.patterns.combinator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerPlaneValidationService {

    public boolean isValid(CustomerForCombinator customer) {
        return isEmailValid(customer.getEmail()) &&
            isPhoneNumberValid(customer.getPhoneNumber()) &&
            isAdult(customer.getDob());
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+");
    }

    private boolean isAdult(LocalDate dateBirth) {
        return Period.between(dateBirth, LocalDate.now()).getYears() > 18;
    }


}
