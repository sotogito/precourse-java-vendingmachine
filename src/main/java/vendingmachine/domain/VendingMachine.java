package vendingmachine.domain;

import vendingmachine.util.validator.CashValidator;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * 자판기 금액
 * 자판기 동전 리스트
 */

public class VendingMachine {
    private final int amount;
    private final EnumMap<Coin,Integer> amountCoins;

    public VendingMachine(int amount) {
        CashValidator.validate(amount);
        this.amount = amount;
        this.amountCoins = Coin.getVendingMachineRandomCoinList(amount);
    }

    //note 잔돈 반환
    //TODO 따로 계산 클래스를 만들어도 좋을 거 같다.
    public EnumMap<Coin, Integer> getUserChange(int userAmount) {
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

        if (userAmount > 0) {
            throw new IllegalArgumentException("The vending machine cannot provide the exact change for the user amount.");
        }

        return userChange;
    }
}
