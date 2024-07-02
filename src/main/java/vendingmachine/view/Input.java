package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.util.ItemParser;
import vendingmachine.util.message.ErrorMessage;

import java.util.List;

public class Input {

    public static int inputVendingMachineCash(){
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        try{
            return Integer.parseInt(Console.readLine());
        }catch(NumberFormatException e){
            throw new NumberFormatException(ErrorMessage.ONLY_NUMBER);
        }
    }

    public static String inputVendingMachineItem(){
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        return Console.readLine().trim();
    }

    public static int inputUserMoney(){
        System.out.println("투입 금액을 입력해 주세요.");
        try{
            return Integer.parseInt(Console.readLine());
        }catch(NumberFormatException e){
            throw new NumberFormatException(ErrorMessage.ONLY_NUMBER);
        }
    }

    public static String inputUserBuyItem(){
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine().trim();
    }




}
