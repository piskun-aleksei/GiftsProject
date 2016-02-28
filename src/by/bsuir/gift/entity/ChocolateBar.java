package by.bsuir.gift.entity;

/**
 * Created by Алексей on 24.02.2016.
 */

public class ChocolateBar extends Candy {
    private int cocoaPercentage;

    public ChocolateBar() {
        super();
    }

    public ChocolateBar(String name, int scanCode, int weight, int sugarPercentage, int cocoaPercentage) {
        super(name, scanCode, weight, sugarPercentage);
        this.cocoaPercentage = cocoaPercentage;
    }

    public int getCocoaPercentage() {
        return cocoaPercentage;
    }

    public void setCocoaPercentage(int cocoaPercentage) {
        this.cocoaPercentage = cocoaPercentage;
    }

    @Override
    public String toString() {
        return "Candy name: " + this.getName() + "\nScan code: " + this.getScanCode() + "\nWeight: " + this.getWeight()
                + "\nSugar percentage: " + this.getSugarPercentage() + "\nCocoa percentage: " + this.getCocoaPercentage();
    }
}
