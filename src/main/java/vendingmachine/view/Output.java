package vendingmachine.view;

import vendingmachine.domain.VendingMachine;
import vendingmachine.util.message.ServiceMassage;

public class Output {

    public static void printError(String error) {
        System.out.print("[ERROR] " + error);
    }

    public static void printVendingMachineCoins(VendingMachine vendingMachine){
        System.out.println(ServiceMassage.PRINT_VENDINGMACHINE_COINS);
        System.out.println(vendingMachine);

    }


}
