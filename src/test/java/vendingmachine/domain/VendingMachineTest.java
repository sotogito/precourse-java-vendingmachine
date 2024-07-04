package vendingmachine.domain;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    /*
    @Test
    public void testGetUserChange() {
        EnumMap<Coin, Integer> initialCoins = new EnumMap<>(Coin.class);
        initialCoins.put(Coin.COIN_500, 2); // 2개
        initialCoins.put(Coin.COIN_100, 5); // 5개
        initialCoins.put(Coin.COIN_50, 10); // 10개
        initialCoins.put(Coin.COIN_10, 20); // 20개

        VendingMachine vm = new VendingMachine(50,initialCoins);
        UserCashier user = new UserCashier(880); // 사용자 금액

        EnumMap<Coin, Integer> change = user.getChange(vm);

        int totalChange = change.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getAmount() * entry.getValue())
                .sum();

        assertEquals(880, totalChange, "The total change should be equal to the user amount");

        // 반환된 동전의 개수 출력
        change.forEach((coin, count) ->
                System.out.println(coin + ": " + count + "개")
        );

        // 추가적인 검증 (예시)
        assertTrue(change.getOrDefault(Coin.COIN_500, 0) <= 2, "500원 동전의 개수가 올바른지 확인");
        assertTrue(change.getOrDefault(Coin.COIN_100, 0) <= 5, "100원 동전의 개수가 올바른지 확인");
        assertTrue(change.getOrDefault(Coin.COIN_50, 0) <= 10, "50원 동전의 개수가 올바른지 확인");
        assertTrue(change.getOrDefault(Coin.COIN_10, 0) <= 20, "10원 동전의 개수가 올바른지 확인");
    }

     */
}