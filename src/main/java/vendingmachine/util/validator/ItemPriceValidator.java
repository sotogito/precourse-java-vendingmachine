package vendingmachine.util.validator;

import vendingmachine.util.message.ErrorMessage;

public class ItemPriceValidator {

    private final static int UNit = 10;
    private final static int MIN = 10;
    private final static int MAX = 50000;

    public static void validate(int price) {
        validateMultipleOf(price);
        validateNumberInRange(price);
    }

    private static void validateMultipleOf(int number) {
        if(number % UNit != 0){
            throw new IllegalArgumentException(ErrorMessage.ONLY_AMOUNT_TEN_MULTIPLE);
        }
    }

    private static void validateNumberInRange(int number) {
        if(number < MIN || number > MAX) {
            throw new IllegalArgumentException(
                    String.format("금액은 최소 %d원 부터 %d원 입니다.\n", MIN, MAX)
            );
        }
    }


}
