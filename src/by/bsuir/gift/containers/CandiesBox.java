package by.bsuir.gift.containers;

import by.bsuir.gift.checkers.FileInfoChecker;
import by.bsuir.gift.entity.*;
import by.bsuir.gift.exception.InvalidNumberException;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Алексей on 25.02.2016.
 */
public class CandiesBox {

    static Logger logger = Logger.getLogger(CandiesBox.class);

    private ArrayList<Candy> candies;

    public CandiesBox() {
        candies = new ArrayList<Candy>();
    }

    public CandiesBox(ArrayList<String[]> candiesInfo) {
        for (int i = 0; i < candiesInfo.size(); i++) {
            try {
                if (FileInfoChecker.checkCandyInfo(candiesInfo.get(i))) {
                    if (FileInfoChecker.tryParseInt(candiesInfo.get(i)[4])) {
                        candies.add(new ChocolateBar(candiesInfo.get(i)[0], Integer.parseInt(candiesInfo.get(i)[3]),
                                Integer.parseInt(candiesInfo.get(i)[2]), Integer.parseInt(candiesInfo.get(i)[3]), Integer.parseInt(candiesInfo.get(i)[4])));
                        logger.debug("Candy (chocolate bar) has been added to collection");
                    } else {
                        candies.add(new JellyBean(candiesInfo.get(i)[0], Integer.parseInt(candiesInfo.get(i)[1]),
                                Integer.parseInt(candiesInfo.get(i)[2]), Integer.parseInt(candiesInfo.get(i)[3]), candiesInfo.get(i)[4]));
                        logger.debug("Candy (jelly bean) has been added to collection");
                    }
                }
            } catch (InvalidNumberException e) {
                logger.error("Invalid data was detected when adding a candy");
            }
        }
    }

    public void addCandy(String name, int scanCode, int weight, int sugarPercentage, int cocoaPercentage) {
        String[] checkCandy = {name, new Integer(scanCode).toString(), new Integer(weight).toString(),
                new Integer(sugarPercentage).toString(), new Integer(cocoaPercentage).toString()};
        try {
            if (FileInfoChecker.checkCandyInfo(checkCandy)) {
                candies.add(new ChocolateBar(name, scanCode, weight, sugarPercentage, cocoaPercentage));
                logger.debug("Candy (chocolate bar) has been added to collection");
            } else {
                logger.debug("Candy wasn't added");
            }
        } catch (InvalidNumberException e) {
            logger.error("Invalid data was detected when adding a candy");
        }
    }

    public void addCandy(String name, int scanCode, int weight, int sugarPercentage, String flavor) {
        String[] checkCandy = {name, new Integer(scanCode).toString(), new Integer(weight).toString(),
                new Integer(sugarPercentage).toString(), flavor};
        try {
            if (FileInfoChecker.checkCandyInfo(checkCandy)) {
                candies.add(new JellyBean(name, scanCode, weight, sugarPercentage, flavor));
                logger.debug("Candy (jelly bean) has been added to collection");
            } else {
                logger.debug("Candy wasn't added");
            }
        } catch (InvalidNumberException e) {
            logger.error("Invalid data was detected when adding a candy");
        }
    }

    public void addCandiesFromFile(ArrayList<String[]> candiesInfo) {
        for (int i = 0; i < candiesInfo.size(); i++) {
            try {
                if (FileInfoChecker.checkCandyInfo(candiesInfo.get(i))) {
                    if (FileInfoChecker.tryParseInt(candiesInfo.get(i)[4])) {
                        candies.add(new ChocolateBar(candiesInfo.get(i)[0], Integer.parseInt(candiesInfo.get(i)[3]),
                                Integer.parseInt(candiesInfo.get(i)[2]), Integer.parseInt(candiesInfo.get(i)[3]), Integer.parseInt(candiesInfo.get(i)[4])));
                        logger.debug("Candy (chocolate bar) has been added to collection");

                    } else {
                        candies.add(new JellyBean(candiesInfo.get(i)[0], Integer.parseInt(candiesInfo.get(i)[1]),
                                Integer.parseInt(candiesInfo.get(i)[2]), Integer.parseInt(candiesInfo.get(i)[3]), candiesInfo.get(i)[4]));
                        logger.debug("Candy (jelly bean) has been added to collection");
                    }
                }
            } catch (InvalidNumberException e) {
                logger.error("Invalid data was detected when adding a candy");
            }
        }
    }

    public void setCandies(ArrayList<Candy> candies) {
        this.candies.clear();
        for (int i = 0; i < candies.size(); i++) {
            this.candies.add(candies.get(i));
        }
        logger.debug("Candies are set");
    }

    public int getCandyWeight(int index) {
        return candies.get(index).getWeight();
    }

    public int getCandySugarPercentage(int index) {
        return candies.get(index).getSugarPercentage();
    }

    public String getCandyToString(int index) {
        return candies.get(index).toString();
    }

    public ArrayList<Candy> getCandies() {
        return candies;
    }
}
