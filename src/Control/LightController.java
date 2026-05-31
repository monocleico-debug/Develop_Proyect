package Control;

import CalculationsService.LightCalculations;
import Model.Light;
import Model.Result;
import Model.User;

public class LightController {

    public Result analyze(
            int stratum,
            int persons,
            double realLight,
            int appliances,
            int airConditioner,
            int nightConsumption,
            int electronicsUsage) {

        User user =
                new User(
                        stratum,
                        persons);

        Light light =
                new Light(
                        realLight,
                        appliances,
                        airConditioner,
                        nightConsumption,
                        electronicsUsage);

        LightCalculations calc =
                new LightCalculations();

        calc.calculateBaseConsumption(
                user.getNumperson());

        calc.calculateStratumAdjustment(
                user.getStratum());

        calc.calculateScore(
                light.getPoints());

        calc.calculateExpectedConsumption();

        calc.calculatePercentage(
                light.getRealConsumption());

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
