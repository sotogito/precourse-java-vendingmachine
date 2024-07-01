package vendingmachine.domain.cashers;

import vendingmachine.domain.Coin;

import java.util.Map;

public class UserCashier {
    private int money;
    private CashChangeCalculator changeCalculator;

    public UserCashier(int money, CashChangeCalculator changeCalculator) {

        //todo 유효검사
        this.money = money;
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



    //public Map<Coin, Integer> calculateChangeCash(VendingMachineCashier vendingMachineCashier) {


    //}



}
