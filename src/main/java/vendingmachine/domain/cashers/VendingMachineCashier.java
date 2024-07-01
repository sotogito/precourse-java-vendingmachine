package vendingmachine.domain.cashers;

import vendingmachine.domain.Coin;
import vendingmachine.util.validators.CashValidator;
import vendingmachine.util.validators.VendingMachineCashValidator;

import java.util.EnumMap;

public class VendingMachineCashier {

    private EnumMap<Coin, Integer> cash;

    public VendingMachineCashier(int money) {

        validate(money);
        cash = Coin.getVendingMachineCoins(money);
    }

    public void validate(int money){
        CashValidator validator = new VendingMachineCashValidator();
        validator.validate(money);
    }




}
