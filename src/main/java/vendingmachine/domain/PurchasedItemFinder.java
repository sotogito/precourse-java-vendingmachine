package vendingmachine.domain;

import vendingmachine.domain.product.Item;
import vendingmachine.domain.product.Items;

/**
 * 구매
 * 재고가 있는지 && 구매한 남은 잔액이 최소 상품보다 큰지
 * true, false
 */
public class PurchasedItemFinder {
    private final Items items;
    private final UserCashier userCashier;
    private final int minimumItemPrice;

    public PurchasedItemFinder(Items items, UserCashier userCashier, int minimumItemPrice) {
        this.items = items;
        this.userCashier = userCashier;
        this.minimumItemPrice = items.getMinimumItemPrice();
    }

    public boolean isQuitBuying(String itemName){
        Item boughtItem = findPurchasedItems(itemName);
        int itemPrice = boughtItem.getPrice();

        userCashier.decreaseAmountAsPriceOfItem(itemPrice);
        boughtItem.decreaseStock(1);

        if(boughtItem.isOutOfStock() ||
                userCashier.isLessAmountThanMinimumItemPrice(minimumItemPrice)){
            return true;
        }

        return false;
    }

    private Item findPurchasedItems(String itemName) {
        return items.findItemByName(itemName);
    }
}
