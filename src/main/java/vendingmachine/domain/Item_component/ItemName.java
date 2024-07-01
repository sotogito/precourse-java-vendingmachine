package vendingmachine.domain.Item_component;

public class ItemName {

    private String name;

    public ItemName(String name) {
        //todo 유효검사
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
