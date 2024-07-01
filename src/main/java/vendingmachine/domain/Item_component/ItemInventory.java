package vendingmachine.domain.Item_component;

public class ItemInventory {

    private int inventory;

    public ItemInventory(int inventory) {
        //todo 유효검사
        this.inventory = inventory;
    }

    public int getInventory() {
        return inventory;
    }

    public void decreaseInventory(int amount) {
        inventory -= amount;
    }

    @Override
    public String toString() {
        return inventory + "";
    }
}
