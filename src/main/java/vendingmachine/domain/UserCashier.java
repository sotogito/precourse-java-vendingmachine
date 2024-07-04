package vendingmachine.domain;

import vendingmachine.util.message.ErrorMessage;

import java.util.EnumMap;

/**
 * 사용자가 가지고 있는 돈
 * 잔돈 반환
 */

public class UserCashier {
    private int amount;

    public UserCashier(int amount) {
        //todo 유효검사
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


}
