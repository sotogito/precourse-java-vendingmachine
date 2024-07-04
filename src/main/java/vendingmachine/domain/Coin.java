package vendingmachine.domain;

import java.util.EnumMap;
import camp.nextstep.edu.missionutils.Randoms;


/**
 * 자판기 랜덤 생성 동전 리스트 반환
 * CoinMap 반환
 */

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


    public EnumMap<Coin, Integer> getVendingMachineRandomCoinList(int amount) {
        EnumMap<Coin, Integer> coinList = new EnumMap<>(Coin.class);

        Coin[] coins = Coin.values();

        while (amount > 0) {
            int randomIndex = Randoms.pickNumberInRange(0, coins.length-1);
            Coin coin = coins[randomIndex];
            if (coin.amount <= amount) {
                coinList.put(coin, coinList.getOrDefault(coin, 0) + 1);
                amount -= coin.amount;
            }
        }
        return coinList;
    }
}
