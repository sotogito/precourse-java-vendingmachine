package vendingmachine.controller;

import vendingmachine.domain.Item;
import vendingmachine.domain.ItemMatcher;
import vendingmachine.domain.Items;
import vendingmachine.domain.cashers.UserCashier;
import vendingmachine.domain.cashers.VendingMachineCashier;
import vendingmachine.util.ItemParser;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

import java.util.List;

public class MainController {

    public void main() {
        VendingMachineCashier vendingMachineCashier = createVendingMachineCashier();

        Output.printVendingMachineCoins(vendingMachineCashier);

        Items items = createItems();


        UserCashier userCashier = createUserCashier(items.getMinAmount());
        ItemMatcher itemMatcher = createItemMatcher(items,userCashier);

        System.out.println(userCashier);

        Output.printUserMoney(userCashier);

        userBuyItem(itemMatcher, userCashier);
        Output.printBalanceCoin(userCashier.getBalance(vendingMachineCashier));


    }

    private ItemMatcher createItemMatcher(Items items, UserCashier userCashier) {
        return new ItemMatcher(items, userCashier);
    }

    private void userBuyItem(ItemMatcher itemMatcher,UserCashier userCashier){
        while (true){
            try{
                if(!itemMatcher.isCanMoreBuy(Input.inputUserBuyItem())){
                    break;
                }
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
            Output.printUserMoney(userCashier);
        }
        Output.printUserMoney(userCashier);

    }

    public UserCashier createUserCashier(int minItemPrice) {
        while (true){
            try{
                return new UserCashier(Input.inputUserMoney(),minItemPrice);
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }


    public Items createItems(){
        while (true) {
            try {
                return new Items(createItemList());
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private List<Item> createItemList(){
        while (true){
            try{
                return ItemParser.parseProducts(Input.inputVendingMachineItem());
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }

    private VendingMachineCashier createVendingMachineCashier(){
        while (true){
            try{
                return new VendingMachineCashier(Input.inputVendingMachineCash());
            }catch (IllegalArgumentException e){
                Output.printError(e.getMessage());
            }
        }
    }


}
