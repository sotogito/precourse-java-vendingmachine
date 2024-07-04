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
}
