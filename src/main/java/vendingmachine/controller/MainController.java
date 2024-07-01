package vendingmachine.controller;

import vendingmachine.domain.cashers.VendingMachineCashier;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

public class MainController {

    public void main(){
        VendingMachineCashier vendingMachineCashier = createVendingMachineCashier();
    }

    private VendingMachineCashier createVendingMachineCashier(){
        try{
            return new VendingMachineCashier(Input.inputVendingMachineCash());
        }catch (IllegalArgumentException e){
            Output.printError(e.getMessage());

        }
        return createVendingMachineCashier();
    }
}
