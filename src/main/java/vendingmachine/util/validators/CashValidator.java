package vendingmachine.util.validators;

public interface CashValidator {
    void validate(int money);
    void validateNumberRange(int money, int min, int max);
    void validateMultipleOf(int money);
}
