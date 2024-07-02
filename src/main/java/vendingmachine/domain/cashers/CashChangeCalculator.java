package vendingmachine.domain.cashers;

import vendingmachine.domain.Coin;

import java.util.Arrays;
import java.util.EnumMap;

public class CashChangeCalculator {

    //UserCash에 변수로 달아두기
    //public static EnumMap<Coin,Integer> calculate(EnumMap<Coin,Integer> cashChange) {

    //}

    //note VendingMachine이 가지고 있는 동전 최소 개수로 반환하기
    public EnumMap<Coin, Integer> calculate(int userCash,EnumMap<Coin, Integer> vendingMachineCash) {
        int amount = userCash;
        EnumMap<Coin, Integer> changeResult = new EnumMap<>(Coin.class);

        Coin[] coins = Coin.values();
        Arrays.sort(coins, (a, b) -> b.getAmount() - a.getAmount());

        for (Coin coin : coins) {
            int availableCoins = vendingMachineCash.getOrDefault(coin, 0); // 자판기가 보유한 해당 동전의 개수
            int usedCoins = Math.min(amount / coin.getAmount(), availableCoins); // 사용할 수 있는 동전의 개수

            if (usedCoins > 0) { // 사용할 동전이 있으면
                changeResult.put(coin, usedCoins); // 잔돈 결과에 해당 동전의 사용 개수를 추가
                amount -= usedCoins * coin.getAmount(); // 사용한 동전의 금액만큼 amount에서 차감
            }
        }
        if (amount > 0) {
            return changeResult;
        }

        return changeResult;
    }


}
