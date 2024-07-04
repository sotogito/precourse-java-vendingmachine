package vendingmachine.util.validator;

import vendingmachine.util.message.ErrorMessage;

/**
 * 10의 단위인가
 * 범위 안에 들어 가는가
 */

public class CashValidator {

    private final static int UNit = 10;
    private final static int MIN = 10;
    private final static int MAX = 100000;

    public static void validate(int amount) {
        validateMultipleOf(amount);
        validateNumberInRange(amount);

    }

    private static void validateMultipleOf(int number) {
        if (number % UNit != 0) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_AMOUNT_TEN_MULTIPLE);
        }
    }

    private static void validateNumberInRange(int number) {
        if (number < 10 || number > 100000) {
            throw new IllegalArgumentException(
                    String.format("금액은 최소 %d원 부터 %d원 입니다.\n", MIN, MAX));
        }
    }


}
