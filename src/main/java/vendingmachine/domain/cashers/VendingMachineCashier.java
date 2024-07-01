package vendingmachine.domain.cashers;

import vendingmachine.domain.Coin;

import java.util.EnumMap;

public class VendingMachineCashier {

    private EnumMap<Coin, Integer> cash;

    public VendingMachineCashier(int money) {

        //유효검사
        cash = Coin.getVendingMachineCoins(money);
    }




}
