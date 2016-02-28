package by.bsuir.gift.reader;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 25.02.2016.
 */
public class CandiesFileReader {
    static Logger logger = Logger.getLogger(CandiesFileReader.class);
    private static final int NUMBER_OF_FIELDS = 5;
    private ArrayList<String[]> candiesInfo;

    public CandiesFileReader(){
        candiesInfo = new ArrayList<String[]>();
    }

    public void readInfoFromFile(String filePath){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        int currentLine = 0;
        boolean skipLine = false;
        List<String> lines = new ArrayList<String>();

        try {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
                if(!skipLine){
                    currentLine++;

                }
                else{
                    skipLine = false;
                    lines.clear();
                }
                if(currentLine == NUMBER_OF_FIELDS){
                    addCandy(lines.toArray(new String[lines.size()]));
                    currentLine = 0;
                    skipLine = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.clear();
        logger.debug("File has been read");
    }

    private void addCandy(String[] candyInfo) {
        candiesInfo.add(candyInfo);
        logger.debug("Candy added");
    }

    public ArrayList<String[]> getCandiesInfo(){
        return candiesInfo;
    }

   /* public void setCandiesInfo(ArrayList<String[]> candiesInfo){
        candiesInfo.clear();
        for(int i = 0; i < candiesInfo.size(); i++){
            this.candiesInfo.add(candiesInfo.get(i));
        }
    }*/
}
