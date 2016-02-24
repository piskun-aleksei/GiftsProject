package by.bsuir.gift.entity;

import by.bsuir.gift.exception.InvalidNumberExceprion;

/**
 * Created by Алексей on 24.02.2016.
 */
public class Candy extends Entity {
    private String name;
    private int weight, sugarPercentage;

    public Candy(){
        super();
    }

    public Candy(String name, int scanCode, int weight, int sugarPercentage){
        super(scanCode);
        this.name = name;
        this.weight = weight;
        this.sugarPercentage = sugarPercentage;
    }

    public int getWeight(){

        return weight;
    }

    public String getName(){
        return name;
    }

    public int getSugarPercentage() {
        return sugarPercentage;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSugarPercentage(int sugarPercentage) {
        this.sugarPercentage = sugarPercentage;
    }
}
