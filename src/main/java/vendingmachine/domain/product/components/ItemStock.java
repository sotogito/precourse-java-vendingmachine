package vendingmachine.domain.product.components;

import vendingmachine.util.validator.ItemStockValidator;

public class ItemStock {

    private int stock;

    public ItemStock(int stock) {
        ItemStockValidator.validate(stock);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock(int count) {
        stock -= count;
    }

}
