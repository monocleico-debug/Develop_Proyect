public class Gas {

    private double realGas; // m3
    private int cookingFrequency; // baja, media, alta
    private int kitchenType; // 1, 2, 3
    private int usageTime; // 1h, 1-2h, +2h

    public Gas(double realGas, int cookingFrequency, int kitchenType, int usageTime) {
        this.realGas = realGas;
        this.cookingFrequency = cookingFrequency;
        this.kitchenType = kitchenType;
        this.usageTime = usageTime;
    }

    public double getRealGas() {
        return realGas;
    }

    public int getPoints() {
        return cookingFrequency + kitchenType + usageTime; //puntos totales
    }
}
