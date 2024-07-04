package vendingmachine.util.validator;

public class ItemNameValidator {

    private static final int ITEM_NAME_MAX_LENGTH = 25;

    public static void validate(String itemName) {
        validateNotEmpty(itemName);
        validateStringLength(itemName);
    }

    private static void validateNotEmpty(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("상품 이름이 비어있습니다.");
        }
    }

    private static void validateStringLength(String name){
        if(name.length() > ITEM_NAME_MAX_LENGTH){
            throw new IllegalArgumentException("상품 이름은 25자까지 입력 가능합니다.");
        }
    }
}
