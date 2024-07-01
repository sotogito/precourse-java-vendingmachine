package vendingmachine.domain.Item_component;

import vendingmachine.util.validators.ItemNameValidator;

public class ItemName {

    private String name;

    public ItemName(String name) {
        ItemNameValidator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
