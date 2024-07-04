package vendingmachine.domain;

import vendingmachine.domain.product.Item;
import vendingmachine.domain.product.Items;

public class PurchasePossibilityValidator implements PurchaseValidator{
    private final Items items;
    private final UserCashier userCashier;

    public PurchasePossibilityValidator(Items items, UserCashier userCashier) {
        this.items = items;
        this.userCashier = userCashier;
    }

    public boolean canNotContinueBuying(Item item) {
        int minimumItemPrice = items.getMinimumItemPrice();
        return isOUtOfStock(item) || isLessAmountThanMinimumItemPrice(userCashier,minimumItemPrice);
    }

    @Override
    public boolean isOUtOfStock(Item item){
        return item.isOutOfStock();
    }


    @Override
    public boolean  isLessAmountThanMinimumItemPrice(UserCashier userCashier, int minItemPrice){
        return userCashier.isLessAmountThanMinimumItemPrice(minItemPrice);
    }


}
