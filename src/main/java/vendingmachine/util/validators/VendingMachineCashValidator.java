package vendingmachine.util.validators;

import vendingmachine.util.message.ErrorMessage;

public class VendingMachineCashValidator implements CashValidator{

    public void validate(int money){
        validateMultipleOf(money);
        validateNumberRange(money,10,100000);

    }


    @Override
    public void validateNumberRange(int money, int min, int max) {
        if(money < min || money > min) {
            throw new IllegalArgumentException(ErrorMessage.NOT_WITHIN_RANGE_VENDINGMACHINE_CASH);
        }
    }

    @Override
    public void validateMultipleOf(int money) {
        if(money % 10 != 0){
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT);
        }

    }
}
