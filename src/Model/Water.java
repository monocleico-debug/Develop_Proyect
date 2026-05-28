package Model;

public class Water extends Service {

    private int washingFrequency;
    private int washingMachine;
    private int showerTime;
    private int additionalWater;

    public Water(double realWater,
                 int washingFrequency,
                 int washingMachine,
                 int showerTime,
                 int additionalWater) {

        setRealConsumption(realWater);

        this.washingFrequency =
                washingFrequency;

        this.washingMachine =
                washingMachine;

        this.showerTime =
                showerTime;

        this.additionalWater =
                additionalWater;

    }

    public int getPoints() {

        return washingFrequency
                + washingMachine
                + showerTime
                + additionalWater;

    }

}