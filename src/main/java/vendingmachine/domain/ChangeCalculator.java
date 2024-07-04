package vendingmachine.domain;

import java.util.EnumMap;

public interface ChangeCalculator {

    EnumMap<Coin,Integer> getChange(int amount);
}
