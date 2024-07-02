package vendingmachine.domain.cashers;

import vendingmachine.domain.Coin;
import vendingmachine.domain.cashers.calculators.CashChangeCalculator;
import vendingmachine.domain.cashers.calculators.ChangeCalculator;
import vendingmachine.domain.cashers.calculators.VendingMachineCashCalculator;
import vendingmachine.util.validators.CashValidator;
import vendingmachine.util.validators.VendingMachineCashValidator;

import java.util.EnumMap;

public class VendingMachineCashier {

    private final EnumMap<Coin, Integer> cash;
    private ChangeCalculator changeCalculator;

    public VendingMachineCashier(int money) {
        validate(money);
        changeCalculator = new VendingMachineCashCalculator(); //note 자판기 랜덤 coin 리스트
        cash = changeCalculator.calculate(money,Coin.getInitMap());
    }

    public EnumMap<Coin, Integer> calculateChangeAndUpdateVendingMachineCoin(int userCash) {
        changeCalculator = new CashChangeCalculator(); //note 사용자 잔액 coin 리스트
        EnumMap<Coin, Integer> changeCash = changeCalculator.calculate(userCash, cash);
        updateVendingMachineCoin(changeCash);
        return changeCash;
    }

    private void updateVendingMachineCoin(EnumMap<Coin, Integer> userChangeCash){
        for (Coin coin : userChangeCash.keySet()) {
            cash.put(coin, cash.get(coin) - userChangeCash.get(coin));
        }
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
