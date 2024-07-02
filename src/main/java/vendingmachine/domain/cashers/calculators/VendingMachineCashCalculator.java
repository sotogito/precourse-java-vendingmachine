package vendingmachine.domain.cashers.calculators;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

import java.util.Arrays;
import java.util.EnumMap;

public class VendingMachineCashCalculator implements ChangeCalculator {


    @Override
    public EnumMap<Coin, Integer> calculate(int money,EnumMap<Coin, Integer> coinList) {
        EnumMap<Coin, Integer> result = coinList;

        Coin[] coins = Coin.values();
        Arrays.sort(coins, (a, b) -> b.getAmount() - a.getAmount()); //큰 동전부터 정렬

        while (money > 0) {
            Coin randomCoin = getRandomCoin(coins); //랜덤의 동전을 가져옴
            int coinValue = randomCoin.getAmount();

            System.out.println(coinValue);

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
        System.out.println(randomIndex);
        return coins[randomIndex];
    }




    /*
    @Override
    public  EnumMap<Coin, Integer> calculate(int money,EnumMap<Coin, Integer> coinList) {
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

     */

}
