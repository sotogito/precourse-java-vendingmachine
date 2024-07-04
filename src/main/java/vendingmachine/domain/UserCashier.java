package vendingmachine.domain;

/**
 * 사용자가 가지고 있는 돈
 */

public class UserCashier {
    private int amount;

    public UserCashier(int amount) {
        //todo 유효검사
        this.amount = amount;
    }


    public void decreaseAmountAsPriceOfItem(int itemPrice) {
        amount -= itemPrice;
    }


}
