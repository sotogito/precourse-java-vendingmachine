package vendingmachine.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Random;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static EnumMap<Coin, Integer> getVendingMachineCoins(int money) {
        EnumMap<Coin, Integer> coinMap = new EnumMap<>(Coin.class);
        Coin[] coins = Coin.values();
        Arrays.sort(coins, (a, b) -> b.getAmount() - a.getAmount()); // 큰 동전부터 정렬

        for (Coin coin : coins) {
            int count = money / coin.getAmount();
            if (count > 0) {
                coinMap.put(coin, count);
                money -= count * coin.getAmount();
            }
        }

        return coinMap;
    }

    private static Coin getRandomCoin() {
        Coin[] coinsArray = Coin.values();
        int randomIndex = Randoms.pickNumberInRange(0, coinsArray.length - 1);
        return coinsArray[randomIndex];
    }




}
