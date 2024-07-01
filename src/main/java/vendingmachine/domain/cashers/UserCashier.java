package vendingmachine.domain.cashers;

import vendingmachine.domain.Coin;
import vendingmachine.util.validators.CashValidator;
import vendingmachine.util.validators.UserCashValidator;

import java.util.EnumMap;
import java.util.Map;

public class UserCashier {
    private int money;
    private CashChangeCalculator changeCalculator;

    public UserCashier(int money, int minItemPrice) {

        //todo 유효검사
        validate(money, minItemPrice);
        this.money = money;
    }

    public EnumMap<Coin, Integer> getBalance(VendingMachineCashier vendingMachineCashier) {
        return vendingMachineCashier.calculateBalance(money);
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



    @Override
    public String toString() {
        return money+"";
    }


}
