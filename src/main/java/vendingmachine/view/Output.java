package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.UserCashier;
import vendingmachine.domain.VendingMachine;
import vendingmachine.util.message.ServiceMassage;

import java.util.EnumMap;
import java.util.Map;

public class Output {

    public static void printError(String error) {
        System.out.print("[ERROR] " + error);
    }

    public static void printVendingMachineCoins(VendingMachine vendingMachine){
        System.out.println(ServiceMassage.PRINT_VENDINGMACHINE_COINS);
        System.out.println(vendingMachine);

    }

    public static void printUserBalance(UserCashier userCashier){
        System.out.println(userCashier);

    }

    public static void printUserChange(EnumMap<Coin,Integer> userChange){
        System.out.println(ServiceMassage.PRINT_CHANGE);
        for(Map.Entry<Coin,Integer> entry : userChange.entrySet()){
            if (entry.getValue() != 0) {
                System.out.printf(ServiceMassage.PRINT_COINS, entry.getKey().getAmount(), entry.getValue());
            }

        }

    }


}
