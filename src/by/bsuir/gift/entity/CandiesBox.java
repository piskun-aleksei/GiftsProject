package by.bsuir.gift.entity;

import java.util.ArrayList;

/**
 * Created by Алексей on 25.02.2016.
 */
public class CandiesBox {
    private ArrayList<Candy> candies;

    public CandiesBox(){
        candies = new ArrayList<Candy>();
    }

    public void addCandy(String name, int scanCode, int weight, int sugarPercentage, int cocoaPercentage){
        candies.add(new ChocolateBar(name, scanCode, weight, sugarPercentage, cocoaPercentage));
    }

    public void addCandy(String name, int scanCode, int weight, int sugarPercentage, String flavor){
        candies.add(new JellyBean(name, scanCode, weight, sugarPercentage, flavor));
    }

    // toDo...
}
