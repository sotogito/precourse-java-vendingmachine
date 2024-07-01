package vendingmachine.domain;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

    @Test
    void getValue() {
        int inputMoney = 1860;
        Coin coin = Coin.COIN_10; // Enum의 인스턴스를 사용하여 메서드를 호출

        EnumMap<Coin, Integer> coinMap = coin.getVendingMachineCoins(inputMoney);

        int totalAmount = 0;
        for (Coin c : coinMap.keySet()) {
            totalAmount += c.getAmount() * coinMap.get(c);
        }

        // 입력된 금액과 총 금액이 일치하는지 확인
        assertEquals(inputMoney, totalAmount);

    }

}