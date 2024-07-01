package vendingmachine.domain;

import vendingmachine.domain.cashers.UserCashier;
import vendingmachine.util.message.ErrorMessage;

import java.util.HashMap;
import java.util.Map;

public class ItemMatcher {

    //private CashChangeCalculator changeCalculator;
    private UserCashier userCashier;
    private Map<String,Item> itemList = new HashMap<>();
    private int minAmount;


    public ItemMatcher(Items items, UserCashier userCashier) {
        initItemMap(items);
        this.userCashier = userCashier;
        this.minAmount = items.getMinAmount();
    }

    //todo while(isCanMoreBuy)
    public boolean isCanMoreBuy(String input){
        //todo 입력한 상품 찾기
        /**
         * 입력한 상품 찾기 = map에서 찾기
         * 수량 -1 하기 = item.수량감소
         * 사용자 금액 - 삼품 가격하기
         *          = 유효성 검사하기 if(사용자금액!!){잔동 출력 false}
         *
         */

        Item foundItem = itemList.get(input);
        if(foundItem == null){
            throw new IllegalArgumentException(ErrorMessage.CANT_FIND_ITEM);
        }

        int foundItemPrice = foundItem.getPrice();

        //note 확인사항1. 재고가 더이상 있는지
        if(foundItem.decreaseInventoryAndCheckStock()){
            return false;
        }
        //todo 확인사항2. 최소금액이 되는지
        if(userCashier.isHaveNotBalance(foundItemPrice, minAmount)){
            return false;
        }
        userCashier.updateMoney(foundItemPrice);
        return true;

    }




    private void initItemMap(Items items){
        for(Item itemCom : items.getItems()){
            itemList.put(itemCom.getName(),itemCom);
        }
    }
}
