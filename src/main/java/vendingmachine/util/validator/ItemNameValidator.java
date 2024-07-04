package vendingmachine.util.validator;

import vendingmachine.domain.product.Item;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemNameValidator {

    private static final int ITEM_NAME_MAX_LENGTH = 25;

    public static void validate(String itemName) {
        validateNotEmpty(itemName);
        validateStringLength(itemName);
    }

    public static void validateNoDuplicates(List<Item> items){
        Set<Item> set = new HashSet<>();
        for (Item item : items) {
            if (!set.add(item)) {
                throw new IllegalArgumentException("중복된 상품 있어요.\n");
            }
        }
    }

    private static void validateNotEmpty(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("상품 이름이 비어있습니다.\n");
        }
    }

    private static void validateStringLength(String name){
        if(name.length() > ITEM_NAME_MAX_LENGTH){
            throw new IllegalArgumentException("상품 이름은 25자까지 입력 가능합니다.\n");
        }
    }
}
