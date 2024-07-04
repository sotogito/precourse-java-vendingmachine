package vendingmachine.domain;

import vendingmachine.domain.product.Item;
import vendingmachine.domain.product.Items;

public class PurchasePossibilityValidator {
    private final Items items;
    private final UserCashier userCashier;

    public PurchasePossibilityValidator(Items items, UserCashier userCashier) {
        this.items = items;
        this.userCashier = userCashier;
    }

    public boolean canNotContinueBuying(Item item) {
        int minimumItemPrice = items.getMinimumItemPrice();
        return item.isOutOfStock() || userCashier.isLessAmountThanMinimumItemPrice(minimumItemPrice);
    }

}
