package vendingmachine.util.validators;

import vendingmachine.util.message.ErrorMessage;

public class ItemNameValidator {

    public static void validate(String name){
        validateStringLength(name);

    }

    private static void validateStringLength(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.ITEM_EMPTY);
        }
    }
}
