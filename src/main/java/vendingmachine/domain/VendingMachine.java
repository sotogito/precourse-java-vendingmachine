package vendingmachine.domain;

import java.util.EnumMap;

/**
 * 자판기 금액
 * 자판기 동전 리스트
 */

public class VendingMachine {
    private final int amount;
    private final EnumMap<Coin,Integer> amountCoins;

    public VendingMachine(int amount) {
        this.amount = amount;
        this.amountCoins = Coin.getVendingMachineRandomCoinList(amount);
    }
}
