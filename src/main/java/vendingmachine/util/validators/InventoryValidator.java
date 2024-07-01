package vendingmachine.util.validators;

import vendingmachine.util.message.ErrorMessage;

public class InventoryValidator {

    public static void validate(int number){
        validateNumberInRange(number);
    }

    private static void validateNumberInRange(int number) {
        if(number < 1 || number > 50) {
            throw new IllegalArgumentException(ErrorMessage.NOT_WITHIN_INVENTORY);
        }
    }
}
