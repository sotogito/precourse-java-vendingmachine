package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

public class MainController {
    public void main(){
        VendingMachine vendingMachine = createVendingMachine();
        printVendingMachineCoins(vendingMachine);
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

    private void printVendingMachineCoins(VendingMachine vendingMachine){
        Output.printVendingMachineCoins(vendingMachine);
    }






}
