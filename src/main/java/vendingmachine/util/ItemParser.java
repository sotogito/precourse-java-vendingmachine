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
        String name = itemData[0].trim();
        int price = Integer.parseInt(itemData[1]); //fixme 여기도 다 바꿔야함
        int quantity = Integer.parseInt(itemData[2]);

        return new Item(name, price, quantity);
    }

    private static String[][] getSplitData(String[] splitDataBySemicolon) {
        String[][] results = new String[splitDataBySemicolon.length][];

        for (int i = 0; i < splitDataBySemicolon.length; i++) {
            String data = splitDataBySemicolon[i]; //[이름,수량,가격]
            data = getDeleteBracketsData(data); // 이름,수량,가격
            String[] attributes = getSplitCommaData(data); //이름 수량 가격

            results[i] = attributes;
        }

        return results;
    }

    private static String[] getSplitCommaData(String data){
        String[] attributes = data.split(",");
        if (attributes.length != 3) {
            throw new IllegalArgumentException(", 콤마로 이름, 가격, 수량 3가지 요소를 구분해주세요.\n");
        }
        return attributes;
    }

    private static String getDeleteBracketsData(String data){
        if (data.startsWith("[") && data.endsWith("]")) {
            return data.replace("[", "").replace("]", "");
        } else {
            throw new IllegalArgumentException("대괄호로 [이름, 가격, 수량]을 감싸주세요.");
        }
    }

    private static String[] getSplitBySemicolonData(String data) throws IllegalArgumentException{
        String[] items = data.split(";");

        for(String item : items) {
            int leftBracketCount = countOccurrences(item, '[');
            int rightBracketCount = countOccurrences(item, ']');

            if(leftBracketCount > 1 || rightBracketCount > 1) {
                throw new IllegalArgumentException("세미콜론으로 아이템을 구분해주세요.");
            }
        }
        return items;
    }


    private static int countOccurrences(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
