package vendingmachine.domain.product;

import java.util.ArrayList;
import java.util.List;

public class ItemParser {


    /*
    public static void main(String[] args) {
        Items items = parseItems("[사이다,1500,5];[사이다,1000,10]");

        System.out.println(items);
    }

     */



    public static Items parseItems(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력된 상품이 없습니다.\n");
        }

        String[] itemStrings = input.split(";");
        List<Item> itemList = new ArrayList<>();

        for (String itemString : itemStrings) {
            itemString = itemString.replace("[", "").replace("]", "");
            String[] itemDetails = itemString.split(",");

            if (itemDetails.length != 3) {
                throw new IllegalArgumentException("[상품이름,가격,수량] 순으로 입력하고 ; 로 구분 해주세요.\n");
            }

            try {
                String name = itemDetails[0];
                int price = Integer.parseInt(itemDetails[1]);
                int stock = Integer.parseInt(itemDetails[2]);
                itemList.add(new Item(name, price, stock));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("가격과 수량은 숫자로 입력해주세요.\n");
            }
        }

        return new Items(itemList);
    }
}
