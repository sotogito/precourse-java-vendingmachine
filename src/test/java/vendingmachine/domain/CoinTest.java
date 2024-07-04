package vendingmachine.domain;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

    @Test
    public void testGetVendingMachineRandomCoinList() {
        int testAmount = 500;
        EnumMap<Coin, Integer> result = Coin.COIN_500.getVendingMachineRandomCoinList(testAmount);

        int totalAmount = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getAmount() * entry.getValue())
                .sum();

        // Test if the total amount is equal to the input amount
        assertEquals(testAmount, totalAmount);

        // Test if the EnumMap is not empty
        assertFalse(result.isEmpty());

        // Print the result for manual verification
        result.forEach((coin, count) ->
                System.out.println(coin + ": " + count + "개")
        );
    }
}