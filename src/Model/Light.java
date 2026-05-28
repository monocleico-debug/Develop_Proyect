package Model;

public class Light extends Service {

    private int appliancesQuantity;
    private int airConditionUse;
    private int nightConsumption;
    private int electronicUseTime;

    public Light(double realLight,
                 int appliancesQuantity,
                 int airConditionUse,
                 int nightConsumption,
                 int electronicUsTime) {

        setRealConsumption(realLight);

        this.appliancesQuantity =
                appliancesQuantity;

        this.airConditionUse =
                airConditionUse;

        this.nightConsumption =
                nightConsumption;

        this.electronicUseTime =
                electronicUseTime;

    }

    public int getPoints() {

        return appliancesQuantity
                + airConditionUse
                + nightConsumption
                + electronicUseTime;

    }

}
