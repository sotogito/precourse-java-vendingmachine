package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.cashers.UserCashier;
import vendingmachine.domain.cashers.VendingMachineCashier;

import java.util.EnumMap;
import java.util.Map;

public class Output {
    public static void printError(String error) {
        System.out.print("[ERROR] " + error);
    }

    public static void printVendingMachineCoins(VendingMachineCashier vendingMachineCashier){
        System.out.println("자판기가 보유한 동전");
        System.out.println(vendingMachineCashier);
    }

    public static void printUserMoney(UserCashier userCashier){
        System.out.println("투입 금액: "+userCashier+"원");
    }

    public static void printBalanceCoin(EnumMap<Coin, Integer> balance){
        System.out.println("잔돈");
        for(Map.Entry<Coin, Integer> entry : balance.entrySet()){
            if (entry.getValue() > 0){
                System.out.println(entry.getKey().getAmount()+"원 - "+entry.getValue()+"개");
            }
        }


    }
}
