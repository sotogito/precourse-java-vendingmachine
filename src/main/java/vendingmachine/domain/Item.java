package vendingmachine.domain;

import vendingmachine.domain.Item_component.ItemInventory;
import vendingmachine.domain.Item_component.ItemName;
import vendingmachine.domain.Item_component.ItemPrice;

public class Item {

    private ItemName name;
    private ItemPrice price;
    private ItemInventory inventory;

    public Item(String name, int price, int inventory) {
        this.name = new ItemName(name);
        this.price = new ItemPrice(price);
        this.inventory = new ItemInventory(inventory);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + inventory +
                '}';
    }
}
