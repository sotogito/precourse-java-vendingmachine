package vendingmachine.domain.product.components;

public class ItemStock {

    private int stock;

    public ItemStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock(int count) {
        stock -= count;
    }

}
