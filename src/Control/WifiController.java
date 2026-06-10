package Control;

import CalculationsService.WifiCalculations;
import Model.Result;
import Model.User;
import Model.Wifi;

public class WifiController {

    public Result analyze(
            int stratum,
            int numPerson,
            double realWifi,
            int connectedDevices,
            int streamingUse,
            int gamingUse,
            int connectionHours) {

        User user =
                new User(
                        stratum,
                        numPerson);

        Wifi wifi =
                new Wifi(
                        realWifi,
                        connectedDevices,
                        streamingUse,
                        gamingUse,
                        connectionHours);

        WifiCalculations calc =
                new WifiCalculations();

        calc.calculateBaseConsumption(
                user.getNumperson());

        calc.calculateStratumAdjustment(
                user.getStratum());

        calc.calculateScore(
                wifi.getPoints());

        calc.calculateExpectedConsumption();

        calc.calculatePercentage(
                wifi.getRealConsumption());

        calc.classifyConsumption();

        return new Result(
                calc.getBaseConsumption(),
                calc.getExpectedConsumption(),
                calc.getPercentage(),
                calc.getClassification(),
                calc.getEfficiencyLevel(),
                calc.getRecommendation(),
                calc.getAlert()
        );

    }

}