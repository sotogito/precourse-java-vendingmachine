package vendingmachine.controller;

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
        System.out.println(items);
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
