package vendingmachine.domain;

import vendingmachine.domain.product.Item;

public interface PurchaseValidator {
    boolean isOUtOfStock(Item item);
    boolean isLessAmountThanMinimumItemPrice(UserCashier userCashier, int minItemPrice);
}
