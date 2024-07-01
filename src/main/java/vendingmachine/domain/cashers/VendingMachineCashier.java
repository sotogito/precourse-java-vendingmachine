package vendingmachine.domain.cashers;

import vendingmachine.domain.Coin;
import vendingmachine.util.message.ErrorMessage;
import vendingmachine.util.validators.CashValidator;
import vendingmachine.util.validators.VendingMachineCashValidator;

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

        for (Coin coin : Coin.values()) {
            int availableCoins = cash.getOrDefault(coin, 0); // 사용 가능한 동전 개수
            int usedCoins = Math.min(amount / coin.getAmount(), availableCoins); // 사용할 수 있는 동전 개수

            if (usedCoins > 0) {
                balance.put(coin, usedCoins);
                amount -= usedCoins * coin.getAmount();
            }
        }

        if (amount > 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT);
        }

        // cash 업데이트
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
