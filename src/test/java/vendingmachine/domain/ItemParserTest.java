package vendingmachine.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemParserTest {
    @Test
    void parse() {
        String input =  "[콜라,1500,20];[사이다,1000,10]";

        List<Item> itemList =  ItemParser.parseProducts(input);

        Items items = new Items(itemList);


        String expectedOutput = "Product{name='콜라', price=1500, quantity=20}Product{name='사이다', price=1000, quantity=10}";

        assertEquals(expectedOutput, items.toString());
    }

}