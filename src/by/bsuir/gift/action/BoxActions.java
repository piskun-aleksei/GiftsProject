package by.bsuir.gift.action;

import by.bsuir.gift.containers.CandiesBox;
import by.bsuir.gift.entity.Candy;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Алексей on 25.02.2016.
 */
public class BoxActions {

    static Logger logger = Logger.getLogger(BoxActions.class);

    public static int calculateBoxWeight(CandiesBox candies) {
        int sum = 0;
        for (int i = 0; i < candies.getCandies().size(); i++) {
            sum += candies.getCandies().get(i).getWeight();
        }
        logger.debug("Box weight has been calculated");
        return sum;
    }

    public static ArrayList<Candy> sortBoxByWeight(CandiesBox candies) {
        ArrayList<Candy> candiesToSort = new ArrayList<Candy>(candies.getCandies());
        for (int i = 0; i < candiesToSort.size(); i++) {
            for (int j = i + 1; j < candiesToSort.size(); j++) {
                if (candiesToSort.get(i).getWeight() < candiesToSort.get(j).getWeight()) {
                    Candy temp = candiesToSort.get(j);
                    candiesToSort.set(j, candiesToSort.get(i));
                    candiesToSort.set(i, temp);
                }
            }
        }
        logger.debug("Candies were sorted");
        return candiesToSort;
    }

    public static void findCandyBySugarPercentage(CandiesBox box, int sugarPercentageLow, int sugarPercentageHigh) {
        boolean candyFound = false;
        for (int i = 0; i < box.getCandies().size(); i++) {
            if (box.getCandies().get(i).getSugarPercentage() >= sugarPercentageLow && box.getCandies().get(i).getSugarPercentage() <= sugarPercentageHigh) {
                System.out.println("Candy found!\n" + box.getCandies().get(i).toString() + "\n");
                candyFound = true;
            }
        }
        if (!candyFound) {
            System.out.println("No candies found\n");
        }
    }

    public static void printCandiesInfo(CandiesBox box) {
        for (int i = 0; i < box.getCandies().size(); i++) {
            int candyNumber = i + 1;
            System.out.println("Candy number " + candyNumber + "\n" + box.getCandies().get(i).toString() + "\n");
        }
    }
}
