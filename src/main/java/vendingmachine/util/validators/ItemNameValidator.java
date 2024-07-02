package vendingmachine.util.validators;

import vendingmachine.domain.Item;
import vendingmachine.util.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemNameValidator {

    public static void validate(String name){
        validateStringLength(name);

    }

    private static void validateStringLength(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.ITEM_EMPTY);
        }
    }

    public  static void hasDuplicates(List<Item> items) {
        Set<Item> itemSet = new HashSet<>();
        for (Item item : items) {
            if (!itemSet.add(item)) {
                throw new IllegalArgumentException("중복된 값이 있어요.");
            }
        }
    }
}
