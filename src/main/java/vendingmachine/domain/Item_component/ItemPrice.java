package vendingmachine.domain.Item_component;

import vendingmachine.util.validators.CashValidator;
import vendingmachine.util.validators.Validator;
import vendingmachine.util.validators.VendingMachineCashValidator;

public class ItemPrice {

    private int price;

    public ItemPrice(int price) {
        validate(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return price+ "";
    }
    private void validate(int price){
        CashValidator validator = new VendingMachineCashValidator();
        validator.validate(price);

    }
}
