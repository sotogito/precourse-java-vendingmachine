package vendingmachine.domain;

import java.util.List;
import java.util.Optional;

public class Items {

    private List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getMinAmount() {
        return items.stream()
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
