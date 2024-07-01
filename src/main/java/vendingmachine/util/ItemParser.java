package vendingmachine.util;

import vendingmachine.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemParser {

    public static List<Item> parseProducts(String data) {
        List<Item> products = new ArrayList<>();
        String[] productStrings = data.split("];\\[");

        for (String productString : productStrings) {
            productString = productString.replace("[", "").replace("]", "");
            String[] attributes = productString.split(",");

            String name = attributes[0];
            int price = Integer.parseInt(attributes[1]);
            int quantity = Integer.parseInt(attributes[2]);

            Item product = new Item(name, price, quantity);
            products.add(product);
        }

        return products;
    }
}
