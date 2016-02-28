package by.bsuir.gift.main;


import by.bsuir.gift.action.BoxActions;
import by.bsuir.gift.containers.CandiesBox;
import by.bsuir.gift.exception.InvalidNumberException;
import by.bsuir.gift.reader.CandiesFileReader;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.swing.*;

/**
 * Created by Алексей on 22.02.2016.
 */
public class Main {
    static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        //DOMConfigurator is used to configure logger from xml configuration file
        DOMConfigurator.configure("log4j.xml");

        //Log in console in and log file
        logger.debug("Log4j try");

        CandiesFileReader candiesFileReader = new CandiesFileReader();

        candiesFileReader.readInfoFromFile("files/file.txt");

        CandiesBox box = new CandiesBox();

        box.addCandiesFromFile(candiesFileReader.getCandiesInfo());

        BoxActions.printCandiesInfo(box);

        box.setCandies(BoxActions.sortBoxByWeight(box));

        BoxActions.printCandiesInfo(box);

        BoxActions.findCandyBySugarPercentage(box, 20, 40);
    }
}
