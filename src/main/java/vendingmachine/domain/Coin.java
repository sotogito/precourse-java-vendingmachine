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



    private static Coin getRandomCoin(Coin[] coins) {
        int randomIndex = Randoms.pickNumberInRange(0, coins.length - 1);
        return coins[randomIndex];
    }

    public static EnumMap<Coin, Integer> getInitMap() {
        EnumMap<Coin, Integer> result = new EnumMap<>(Coin.class);
        for (Coin coin : Coin.values()) {
            result.put(coin, 0);
        }
        return result;
    }




}
