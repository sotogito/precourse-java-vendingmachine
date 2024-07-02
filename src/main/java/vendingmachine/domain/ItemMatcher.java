package vendingmachine.domain;

import vendingmachine.domain.cashers.UserCashier;
import vendingmachine.util.message.ErrorMessage;

import java.util.HashMap;
import java.util.Map;

public class ItemMatcher {

    private final UserCashier userCashier;
    private final Map<String,Item> itemList = new HashMap<>();
    private int minAmount;
    private final Items items;


    public ItemMatcher(Items items, UserCashier userCashier) {
        this.items = items;
        initItemMap(items);
        this.userCashier = userCashier;
        this.minAmount = items.getMinAmount();
    }

    /**
     * 구매를 멈춰야하는 조건
     * 1. 구매했을 때의 남은 잔액이 최솟값보다 적을 때
     * 2. 구매했는데 앞으로 구매할 수 있는 상품중 최소 금액이 현재 사용자의 잔액보다 많을때
     */

    public boolean isCanMoreBuy(String input) {
        Item foundItem = itemList.get(input);
        if (foundItem == null) {
            throw new IllegalArgumentException(ErrorMessage.CANT_FIND_ITEM);
        }
        int foundItemPrice = foundItem.getPrice();


        if(isHaveNotBalance(foundItemPrice)){
            updateUserCashAndItemInventory(foundItem,foundItemPrice,1);
            return false;
        }

        updateUserCashAndItemInventory(foundItem,foundItemPrice,1);
        if(isNotInventory(foundItem)){
            minAmount = items.getMinAmount();
            if(isMoreLessUserMoneyForMinimumItemPrice()){
                return false;
            }
        }

        return true;
    }


    private void updateUserCashAndItemInventory(Item item,int price, int quantity){
        int change = userCashier.calculateBalance(price);
        if(change<0){
            throw new IllegalArgumentException("돈이 부족합니다.그지얌");
        }
        item.decreaseInventory(quantity);
        userCashier.updateMoney(price);
    }

    private boolean isMoreLessUserMoneyForMinimumItemPrice(){
        return userCashier.isMoreLessUserMoney(minAmount);
    }


    private boolean isNotInventory(Item item){
        return item.isNotInStock();
    }

    private boolean isHaveNotBalance(int foundItemPrice){
        return userCashier.isHaveNotBalance(foundItemPrice, minAmount);
    }

    private void initItemMap(Items items){
        for(Item itemComponent : items.getItems()){
            itemList.put(itemComponent.getName(),itemComponent);
        }
    }

}
