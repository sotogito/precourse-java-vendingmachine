package vendingmachine.domain.product;

import vendingmachine.util.validator.ItemNameValidator;

import java.util.List;

/**
 * input item 찾기
 * 최소 금액 반환하기
 */

public class Items {

    private List<Item> items;

    public Items(List<Item> items) {
        ItemNameValidator.validateNoDuplicates(items);
        this.items = items;
    }

    public Item findItemByName(String itemName){
        for (Item item : items) {
            if(item.getName().equals(itemName)){
                return item;
            }
        }
        throw new IllegalArgumentException("구매하신 아이템이 없습니다.");
    }

    public int getMinimumItemPrice(){
        int minPrice = Integer.MAX_VALUE;
        for (Item item : items) {
            if(!item.isOutOfStock()){
                if (item.getPrice() < minPrice) {
                    minPrice = item.getPrice();
                }
            }
        }
        return minPrice;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Item item : items) {
            builder.append(item.toString());
        }
        return builder.toString();
    }

}
