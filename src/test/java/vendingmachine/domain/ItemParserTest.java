package vendingmachine.domain;

import org.junit.jupiter.api.Test;
import vendingmachine.domain.product.ItemParser;

import static org.junit.jupiter.api.Assertions.*;

public class ItemParserTest {


    @Test
    public void testParseInvalidInputNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ItemParser.parseItems(null);
        });
        assertEquals("Input string cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testParseInvalidInputEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ItemParser.parseItems("");
        });
        assertEquals("Input string cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testParseInvalidInputFormat() {
        String input = "[콜라,1500,20];[사이다,1000]";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ItemParser.parseItems(input);
        });
        assertEquals("Each item must have a name, price, and stock", exception.getMessage());
    }

    @Test
    public void testParseInvalidInputNonIntegerPriceStock() {
        String input = "[콜라,1500a,20];[사이다,1000,10b]";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ItemParser.parseItems(input);
        });
        assertEquals("Price and stock must be integers", exception.getMessage());
    }
}
