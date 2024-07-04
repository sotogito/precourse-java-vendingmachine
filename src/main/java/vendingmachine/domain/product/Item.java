package vendingmachine.domain.product;

import vendingmachine.domain.product.components.ItemName;
import vendingmachine.domain.product.components.ItemPrice;
import vendingmachine.domain.product.components.ItemStock;

/**
 * 수량 빼기
 * 가격 가져오기
 * 제고가 있는지

 */
public class Item {

    private final ItemName name;
    private final ItemPrice price;
    private ItemStock stock;

    public Item(String name, int price, int stock){
        this.name = new ItemName(name);
        this.price = new ItemPrice(price);
        this.stock = new ItemStock(stock);
    }

    public int getPrice(){
        return price.getPrice();
    }

    public String getName(){
        return name.getName();
    }

    public void decreaseStock(){
        stock.decreaseStock(1);
    }

    //note 더 구매 가능한지 조건
    public boolean isOutOfStock(){
        return stock.getStock() <= 0;
    }


}
