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

    //note 무작위 coin 생성하기
    public static EnumMap<Coin, Integer> getVendingMachineCoins(int money) {
        EnumMap<Coin, Integer> result = new EnumMap<>(Coin.class);

        Coin[] coins = Coin.values();
        Arrays.sort(coins, (a, b) -> b.getAmount() - a.getAmount()); //큰 동전부터 정렬

        while (money > 0) {
            Coin randomCoin = getRandomCoin(coins); //랜덤의 동전을 가져옴
            int coinValue = randomCoin.getAmount();

            if (money >= coinValue) {
                int maxCount = money / coinValue; //최대로 구할 수 있는 개수
                int count = Randoms.pickNumberInRange(1, maxCount); //최대 개수에서 랜덤으로 가져감
                result.merge(randomCoin, count, Integer::sum);
                money -= count * coinValue;
            }
        }
        return result;
    }

    private static Coin getRandomCoin(Coin[] coins) {
        int randomIndex = Randoms.pickNumberInRange(0, coins.length - 1);
        return coins[randomIndex];
    }




}
