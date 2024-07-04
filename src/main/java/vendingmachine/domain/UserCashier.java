package vendingmachine.domain;

import vendingmachine.util.message.ErrorMessage;
import vendingmachine.util.message.ServiceMassage;
import vendingmachine.util.validator.CashValidator;

import java.util.EnumMap;

/**
 * 사용자가 가지고 있는 돈
 * 잔돈 반환
 */

public class UserCashier {
    private int amount;

    public UserCashier(int amount) {
        CashValidator.validate(amount);
        this.amount = amount;
    }


    //todo 잔돈을 반환
    public EnumMap<Coin,Integer> getChange(VendingMachine vendingMachine){
        return vendingMachine.getUserChange(this.amount);

    }

    public void decreaseAmountAsPriceOfItem(int itemPrice) {
        //todo 여기서에 구매할 수 있는지 판단?
        if(amount < itemPrice){
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_FUNDS_EXCEPTION);
        }
        amount -= itemPrice;
    }

    //note 더 구매 가능한지 조건
    public boolean isLessAmountThanMinimumItemPrice(int minimumItemPrice) {
        return amount < minimumItemPrice;
    }

    @Override
    public String toString() {
        return String.format(ServiceMassage.PRINT_USER_BALANCE, amount);
    }



}
