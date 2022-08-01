package knowledge.roschajava.patterns.combinator;

import java.time.LocalDate;
import java.util.Objects;

public class CustomerForCombinator {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate dob;

    public CustomerForCombinator(String name, String email, String phoneNumber, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "CombinatorCustomer{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", dob=" + dob +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerForCombinator that = (CustomerForCombinator) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getDob(), that.getDob());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getPhoneNumber(), getDob());
    }
}
