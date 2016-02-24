package by.bsuir.gift.entity;

/**
 * Created by Алексей on 25.02.2016.
 */
public class JellyBean extends Candy {
    private String flavor;

    public JellyBean() {
        super();
    }

    public JellyBean(String name, int scanCode, int weight, int sugarPercentage, String flavor) {
        super(name, scanCode, weight, sugarPercentage);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
