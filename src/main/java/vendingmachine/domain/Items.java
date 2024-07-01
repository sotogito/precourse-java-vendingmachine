package vendingmachine.domain;

import java.util.List;

public class Items {

    private List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
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
