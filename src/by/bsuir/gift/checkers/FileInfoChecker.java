package by.bsuir.gift.checkers;

import by.bsuir.gift.exception.InvalidNumberException;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Алексей on 25.02.2016.
 */
public class FileInfoChecker {

    static Logger logger = Logger.getLogger(FileInfoChecker.class);

    public static boolean checkWeight(int weight) {
        if (weight > 0) {
            return true;
        }
        return false;
    }

    public static boolean checkScanCode(int scanCode) {
        if (scanCode > 99_999 && scanCode < 999_999) {
            return true;
        }
        return false;
    }

    public static boolean checkCacaoPercentage(int cacaoPercentage) {
        if (cacaoPercentage >= 0 && cacaoPercentage <= 100) {
            return true;
        }
        return false;
    }

    public static boolean checkSugarPercentage(int sugarPercentage) {
        if (sugarPercentage >= 0 && sugarPercentage <= 100) {
            return true;
        }
        return false;
    }

    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkCandyInfo(String[] candiesInfo) throws InvalidNumberException {
        if (FileInfoChecker.tryParseInt(candiesInfo[1]) && FileInfoChecker.tryParseInt(candiesInfo[2])
                && FileInfoChecker.tryParseInt(candiesInfo[3])) {
            if (checkScanCode(Integer.parseInt(candiesInfo[1])) && checkWeight(Integer.parseInt(candiesInfo[2]))
                    && checkSugarPercentage(Integer.parseInt(candiesInfo[3]))) {

                if (tryParseInt(candiesInfo[4])) {

                    if (checkCacaoPercentage(Integer.parseInt(candiesInfo[4]))) {
                        logger.debug("File checked");
                        return true;
                    } else {
                        throw new InvalidNumberException("Invalid number in file");
                    }

                } else {
                    logger.debug("File checked");
                    return true;
                }

            } else {
                throw new InvalidNumberException("Invalid number in file");
            }

        } else {
            return false;
        }
    }
}
