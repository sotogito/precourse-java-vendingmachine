package vendingmachine.controller;

import vendingmachine.domain.product.Item;
import vendingmachine.domain.product.Items;

import java.util.ArrayList;
import java.util.List;

public class ItemParser {
    public static Items parseItems(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        String[] itemStrings = input.split(";");
        List<Item> itemList = new ArrayList<>();

        for (String itemString : itemStrings) {
            itemString = itemString.replace("[", "").replace("]", "");
            String[] itemDetails = itemString.split(",");

            if (itemDetails.length != 3) {
                throw new IllegalArgumentException("Each item must have a name, price, and stock");
            }

            try {
                String name = itemDetails[0];
                int price = Integer.parseInt(itemDetails[1]);
                int stock = Integer.parseInt(itemDetails[2]);
                itemList.add(new Item(name, price, stock));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Price and stock must be integers");
            }
        }

        return new Items(itemList);
    }
}
