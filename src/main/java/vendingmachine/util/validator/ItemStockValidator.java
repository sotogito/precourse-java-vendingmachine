package vendingmachine.util.validator;

import vendingmachine.util.message.ErrorMessage;

public class ItemStockValidator {

    private final static int MIN = 1;
    private final static int MAX = 50;

    public static void validate(int stock) {
        validateNumberInRange(stock);
    }


    private static void validateNumberInRange(int number) {
        if(number < MIN || number > MAX) {
            throw new IllegalArgumentException(
                    String.format("상품 등록 개수는 최소 %d개 부터 %d개 입니다.", MIN, MAX)
            );
        }
    }

}
