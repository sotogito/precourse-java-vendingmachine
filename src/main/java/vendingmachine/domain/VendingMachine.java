package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.util.message.ServiceMassage;
import vendingmachine.util.validator.CashValidator;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * 자판기 금액
 * 자판기 동전 리스트ss
 */

public class VendingMachine implements ChangeCalculator{
    private final int amount;
    private final EnumMap<Coin,Integer> amountCoins;

    public VendingMachine(int amount) {
        CashValidator.validate(amount);
        this.amount = amount;
        this.amountCoins = getChange(amount);

    }

    @Override
    public EnumMap<Coin, Integer> getChange(int amount){
        EnumMap<Coin, Integer> coinList = Coin.initCoinEnumMap();

        Coin[] coins = Coin.values();

        while (amount > 0) {
            int randomIndex = Randoms.pickNumberInRange(0, coins.length-1);
            Coin coin = coins[randomIndex];
            if (coin.getAmount() <= amount) {
                coinList.put(coin, coinList.getOrDefault(coin, 0) + 1);
                amount -= coin.getAmount();
            }
        }
        return coinList;

    }

    public EnumMap<Coin, Integer> getUserChange(int userAmount) {
        ChangeCalculator changeCalculator = new UserChangeCalculator(amountCoins);
        return changeCalculator.getChange(userAmount);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Coin, Integer> entry : amountCoins.entrySet()) {
            String printout = String.format(ServiceMassage.PRINT_COINS,entry.getKey().getAmount(),entry.getValue());
            builder.append(printout);
        }
        return builder.toString();
    }
}
