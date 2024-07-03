package vendingmachine.domain;

import vendingmachine.domain.cashers.UserCashier;

public class InputFinder {

    //NOTE Map을 사용하지 않고 바로 구함

    private final UserCashier userCashier;
    private int minAmount;
    private final Items items;

    public InputFinder(Items items, UserCashier userCashier) {
        this.items = items;
        this.userCashier = userCashier;
    }

    public boolean isCanBuy(String input){
        Item item = items.findItem(input);
        int itemPrice = item.getPrice();

        if(isHaveNotBalance(itemPrice)){
            updateUserCashAndItemInventory(item,itemPrice,1);
            return false;
        }

        updateUserCashAndItemInventory(item,itemPrice,1);
        if(isNotInventory(item)){
            minAmount = items.getMinAmount();
            if(isMoreLessUserMoneyForMinimumItemPrice()){
                return false;
            }
            return false;
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



}
