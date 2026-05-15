package Model;

public class Gas extends Service {

    private int cookingFrequency;
    private int kitchenType;
    private int usageTime;

    public Gas(double realGas,
               int cookingFrequency,
               int kitchenType,
               int usageTime) {

        setRealConsumption(realGas);

        this.cookingFrequency = cookingFrequency;
        this.kitchenType = kitchenType;
        this.usageTime = usageTime;

    }

    public int getPoints() {

        return cookingFrequency
                + kitchenType
                + usageTime;

    }

}
