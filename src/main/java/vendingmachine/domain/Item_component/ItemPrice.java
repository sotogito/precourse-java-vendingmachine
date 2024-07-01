package vendingmachine.domain.Item_component;

public class ItemPrice {

    private int price;

    public ItemPrice(int price) {
        //todo 유효검사
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return price+ "";
    }
}
