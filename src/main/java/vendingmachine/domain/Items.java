package vendingmachine.domain;

import vendingmachine.util.validators.ItemNameValidator;

import java.util.*;

public class Items {

    private final List<Item> items;

    public Items(List<Item> items) {
        ItemNameValidator.hasDuplicates(items);
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }


    public int getMinAmount() {
        return items.stream()
                .filter(item -> !item.isNotInStock()) // 재고가 있는 경우만 처리
                .mapToInt(Item::getPrice) // Item 객체의 price 값을 int 스트림으로 변환
                .min() // 최소값 찾기
                .orElse(-1); // 값이 없으면 -1 반환
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Item item : items) {
            builder.append(item);
        }
        return builder.toString();
    }

}
