package vendingmachine.domain.cashers;

import vendingmachine.domain.Coin;

import java.util.EnumMap;

public interface ChangeCalculator {

    EnumMap<Coin, Integer> calculate(int userCash, EnumMap<Coin, Integer> coinList);
}
