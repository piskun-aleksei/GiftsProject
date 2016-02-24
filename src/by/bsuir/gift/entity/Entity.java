package by.bsuir.gift.entity;

/**
 * Created by Алексей on 22.02.2016.
 */
public class Entity {
    private int scanCode;

    public Entity(){    }

    public Entity(int scanCode){
        this.scanCode = scanCode;
    }

    public int getScanCode(){
        return scanCode;
    }

    public void setScanCode(int scanCode){
        this.scanCode = scanCode;
    }
}
