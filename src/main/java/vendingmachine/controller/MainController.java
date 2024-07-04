package vendingmachine.controller;

import vendingmachine.domain.PurchasedItemFinder;
import vendingmachine.domain.UserCashier;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.product.Item;
import vendingmachine.domain.product.ItemParser;
import vendingmachine.domain.product.Items;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

public class MainController {
    public void main(){
        VendingMachine vendingMachine = createVendingMachine();
        printVendingMachineCoins(vendingMachine);

        Items items = createItems();
        UserCashier userCashier = createUserCashier();
        PurchasedItemFinder finder = createPurchasedItemFinder(items, userCashier);

        userPurchaseLoop(finder,userCashier);

        Output.printUserBalance(userCashier);
        printUserChange(userCashier,vendingMachine);
    }

    private void userPurchaseLoop(PurchasedItemFinder finder,UserCashier userCashier){
        while (true){
            try{
                Output.printUserBalance(userCashier);
                if(finder.isQuitBuying(Input.inputPurchaseItem()))
                    return;
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }

    private void printUserChange(UserCashier userCashier,VendingMachine vendingMachine){
        Output.printUserChange(userCashier.getChange(vendingMachine));
    }

    private PurchasedItemFinder createPurchasedItemFinder(Items items, UserCashier userCashier){
        return new PurchasedItemFinder(items, userCashier);
    }

    private UserCashier createUserCashier(){
        while (true){
            try {
                return new UserCashier(Input.inputUserAmount());
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }

    private VendingMachine createVendingMachine(){
        while (true){
            try{
                return new VendingMachine(Input.inputVendingMachineAmount());

            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }

    private Items createItems(){
        while (true){
            try{
                return ItemParser.parseItems(Input.inputRegisterItem());
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }

    private void printVendingMachineCoins(VendingMachine vendingMachine){
        Output.printVendingMachineCoins(vendingMachine);
    }

}
