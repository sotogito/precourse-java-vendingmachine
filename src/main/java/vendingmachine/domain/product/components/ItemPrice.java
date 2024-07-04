package vendingmachine.domain.product.components;

import vendingmachine.util.validator.ItemPriceValidator;

public class ItemPrice {

    private final int price;

    public ItemPrice(int price) {
        ItemPriceValidator.validate(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
