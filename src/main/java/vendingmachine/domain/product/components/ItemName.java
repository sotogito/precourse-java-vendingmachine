package vendingmachine.domain.product.components;

import vendingmachine.util.validator.ItemNameValidator;

public class ItemName {

    private String name;

    public ItemName(String name) {
        ItemNameValidator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
