package vendingmachine.domain.cashers;

import vendingmachine.domain.Coin;
import vendingmachine.util.message.ErrorMessage;
import vendingmachine.util.validators.CashValidator;
import vendingmachine.util.validators.VendingMachineCashValidator;

import java.util.Arrays;
import java.util.EnumMap;

public class VendingMachineCashier {

    private EnumMap<Coin, Integer> cash;

    public VendingMachineCashier(int money) {

        validate(money);
        cash = Coin.getVendingMachineCoins(money);
    }

    public EnumMap<Coin, Integer> calculateBalance(int userMoney) {
        int amount = userMoney;
        EnumMap<Coin, Integer> balance = new EnumMap<>(Coin.class);

        // 큰 동전부터 순서대로 처리
        Coin[] coins = Coin.values();
        Arrays.sort(coins, (a, b) -> b.getAmount() - a.getAmount());

        for (Coin coin : coins) {
            int availableCoins = cash.getOrDefault(coin, 0); // 사용 가능한 동전 개수
            int usedCoins = Math.min(amount / coin.getAmount(), availableCoins); // 사용할 수 있는 동전 개수

            if (usedCoins > 0) {
                balance.put(coin, usedCoins);
                amount -= usedCoins * coin.getAmount();
            }
        }

        // 남은 금액이 있으면 예외 발생 (남은 금액을 처리할 수 없는 경우)
        if (amount > 0) {
            return cash;
        }

        // 사용한 동전의 개수를 업데이트
        for (Coin coin : balance.keySet()) {
            cash.put(coin, cash.get(coin) - balance.get(coin));
        }

        return balance;
    }



    public void validate(int money){
        CashValidator validator = new VendingMachineCashValidator();
        validator.validate(money);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Coin coin : Coin.values()) {
            int count = cash.getOrDefault(coin, 0);
            sb.append(coin.getAmount()).append("원 - ").append(count).append("개\n");
        }
        return sb.toString();
    }




}
