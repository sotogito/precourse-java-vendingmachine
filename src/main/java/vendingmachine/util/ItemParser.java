package vendingmachine.util;

import vendingmachine.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemParser {

    public static List<Item> parseProducts(String data){
        List<Item> results = new ArrayList<>();

        String[] splitDataBySemicolon = getSplitBySemicolonData(data);
        String[][] splitData = getSplitData(splitDataBySemicolon);

        for(String[] itemData : splitData) {
            results.add(createItem(itemData));
        }
        return results;
    }

    private static Item createItem(String[] itemData){
        String name = itemData[0];
        int price = Integer.parseInt(itemData[1]);
        int quantity = Integer.parseInt(itemData[2]);

        return new Item(name, price, quantity);
    }

    private static String[][] getSplitData(String[] splitDataBySemicolon) {
        String[][] results = new String[splitDataBySemicolon.length][];

        for (int i = 0; i < splitDataBySemicolon.length; i++) {
            String data = splitDataBySemicolon[i]; //[이름,수량,가격]
            data = getDeleteBracketsData(data); // 이름,수량,가격
            String[] attributes = getSplitCommaData(data); //이름 수량 가격

            if (attributes.length != 3) {
                throw new IllegalArgumentException("[이름, 가격, 수량]대로 3가지 요소를 적어주세요");
            }
            results[i] = attributes;
        }

        return results;
    }

    private static String[] getSplitCommaData(String data){
        try{
            return data.split(",");
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(", 콤마로 이름, 가격, 수량을 구분해주세요.");
        }
    }

    private static String getDeleteBracketsData(String data){
        try{
            return data.replace("[", "").replace("]", "");
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("대괄호로 [이름,가격, 수량]을 감싸주세요");
        }
    }

    private static String[] getSplitBySemicolonData(String data) throws IllegalArgumentException{
        try{
            return data.split(";");
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("세미크론으로 아이템을 구분해주세요.");
        }
    }
}
