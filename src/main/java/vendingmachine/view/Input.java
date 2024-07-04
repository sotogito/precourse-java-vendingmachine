package vendingmachine.view;
import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.message.ErrorMessage;
import vendingmachine.util.message.ServiceMassage;

public class Input {

    public static int inputVendingMachineAmount(){
        System.out.print(ServiceMassage.INPUT_VENDINGMACINE_AMOUNT);
        try{
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new NumberFormatException(ErrorMessage.ONLY_NUMBER);
        }
    }

    public static String inputRegisterItem(){
        System.out.print(ServiceMassage.INPUT_REGISTER_ITEMS);
        return Console.readLine();
    }

    public static int inputUserAmount(){
        System.out.print(ServiceMassage.INPUT_USER_AMOUNT);
        try{
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new NumberFormatException(ErrorMessage.ONLY_NUMBER);
        }
    }

    public static String inputPurchaseItem(){
        System.out.print(ServiceMassage.INPUT_PURCHASE_ITEM_NAME);
        return Console.readLine();
    }
}
