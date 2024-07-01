package vendingmachine.domain.cashers;

import vendingmachine.domain.Coin;
import vendingmachine.util.validators.CashValidator;
import vendingmachine.util.validators.UserCashValidator;

import java.util.Map;

public class UserCashier {
    private int money;
    private CashChangeCalculator changeCalculator;

    public UserCashier(int money, int minItemPrice,CashChangeCalculator changeCalculator) {

        //todo 유효검사
        validate(money, minItemPrice);
        this.changeCalculator = changeCalculator;
    }


    public void updateMoney(int amount) {
        money -= amount;
    }


    public boolean isHaveNotBalance(int itemPrice,int miniTemPrice){
        return calculateBalance(itemPrice) < miniTemPrice;
    }


    public int calculateBalance(int amount) {
        return money - amount;
    }

    private void validate(int money, int minItemPrice) {
        CashValidator validator = new UserCashValidator();
        validator.validate(money);
        validator.validateNumberRange(money,minItemPrice,10000);
    }



    //public Map<Coin, Integer> calculateChangeCash(VendingMachineCashier vendingMachineCashier) {


    //}



}
