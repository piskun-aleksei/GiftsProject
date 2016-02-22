package by.bsuir.gift.main;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by Алексей on 22.02.2016.
 */
public class Main {
    static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args)
    {
        //DOMConfigurator is used to configure logger from xml configuration file
        DOMConfigurator.configure("log4j.xml");

        //Log in console in and log file
        logger.debug("Log4j appender configuration is successful !!");
    }
}
