package vendingmachine.domain.cashers;

import vendingmachine.domain.Coin;

import java.util.Arrays;
import java.util.EnumMap;

public class CashChangeCalculator {

    //UserCash에 변수로 달아두기
    //public static EnumMap<Coin,Integer> calculate(EnumMap<Coin,Integer> cashChange) {

    //}

    public EnumMap<Coin, Integer> calculate(int userCash,EnumMap<Coin, Integer> vendingMachineCash) {
        int amount = userCash;
        EnumMap<Coin, Integer> changeResult = new EnumMap<>(Coin.class);

        // 큰 동전부터 순서대로 처리
        Coin[] coins = Coin.values();
        Arrays.sort(coins, (a, b) -> b.getAmount() - a.getAmount());

        for (Coin coin : coins) {
            int availableCoins = vendingMachineCash.getOrDefault(coin, 0); // 사용 가능한 동전 개수
            int usedCoins = Math.min(amount / coin.getAmount(), availableCoins); // 사용할 수 있는 동전 개수

            if (usedCoins > 0) {
                changeResult.put(coin, usedCoins);
                amount -= usedCoins * coin.getAmount();
            }
        }

        if (amount > 0) {
            return changeResult;
        }

        return changeResult;
    }


}
