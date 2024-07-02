package vendingmachine.domain;

import vendingmachine.domain.Item_component.ItemInventory;
import vendingmachine.domain.Item_component.ItemName;
import vendingmachine.domain.Item_component.ItemPrice;

public class Item {

    private final ItemName name;
    private final ItemPrice price;
    private final ItemInventory inventory;

    public Item(String name, int price, int inventory) {
        this.name = new ItemName(name);
        this.price = new ItemPrice(price);
        this.inventory = new ItemInventory(inventory);
    }

    public String getName() {
        return name.getName();
    }

    public int getPrice(){
        return price.getPrice();
    }

    public void decreaseInventory(int amount){
        inventory.decreaseInventory(amount);
    }

    public boolean isNotInStock(){
        return inventory.isNotInStock();
    }

    //todo 나누기
    public boolean decreaseInventoryAndCheckStock(){
        inventory.decreaseInventory(1);
        return inventory.isNotInStock();
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
