package vendingmachine.util.validators;

import vendingmachine.util.message.ErrorMessage;

public class UserCashValidator implements CashValidator{
    @Override
    public void validate(int money) {
        validateMultipleOf(money);
    }

    @Override
    public void validateNumberRange(int money, int min, int max) {
        if(money < min || money > max) {
            throw new IllegalArgumentException(ErrorMessage.NOT_WITHIN_RANGE_USER_CASH);
        }
    }

    @Override
    public void validateMultipleOf(int money) {
        if(money % 10 != 0){
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT);
        }

    }
}
