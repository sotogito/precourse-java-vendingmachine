package vendingmachine.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class UserChangeCalculator implements ChangeCalculator {
    private final EnumMap<Coin,Integer> amountCoins;

    public UserChangeCalculator(EnumMap<Coin, Integer> amountCoins) {
        this.amountCoins = amountCoins;
    }

    public EnumMap<Coin, Integer> getChange(int userAmount){
        EnumMap<Coin, Integer> userChange = new EnumMap<>(Coin.class);
        Map<Coin, Integer> tempAmountCoins = new HashMap<>(amountCoins);

        Coin[] coins = Coin.values();

        for (Coin coin : coins) {
            while (userAmount >= coin.getAmount() && tempAmountCoins.getOrDefault(coin, 0) > 0) {
                userChange.put(coin, userChange.getOrDefault(coin, 0) + 1);
                tempAmountCoins.put(coin, tempAmountCoins.get(coin) - 1);
                userAmount -= coin.getAmount();
            }
        }

        return userChange;
    }

}
