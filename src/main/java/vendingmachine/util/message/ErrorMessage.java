package vendingmachine.util.message;

public class ErrorMessage {

    public final static String CANT_FIND_ITEM = "입력한 아이템을 찾을 수 없습니다\n";
    public final static String ONLY_NUMBER = "숫자만 입력 가능하빈다.\n";
    //todo String.formmat
    public final static String NOT_WITHIN_RANGE_VENDINGMACHINE_CASH = "10원부터 10만원까지 입력 가능합니다.\n";
    public final static String NOT_WITHIN_RANGE_USER_CASH = "삼품의 최소 금액부터 10만원까지 입력 가능합니다.\n";

    public final static String MONEY_UNIT = "10의 단위로 입력해주세요\n";

    public final static String NOT_WITHIN_INVENTORY = "1~50개의 수량만 추가할 수 있습니다.\n";
    public final static String ITEM_EMPTY = "아이템의 이름이 비어있어요\n";
}
