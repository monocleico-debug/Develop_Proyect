package Control;

import CalculationsService.WaterCalculations;
import Model.Result;
import Model.User;
import Model.Water;

public class WaterController {

    public Result analyze(
            int stratum,
            int persons,
            double realWater,
            int washingFrequency,
            int washingMachine,
            int showerTime,
            int additionalWater) {

        User user =
                new User(
                        stratum,
                        persons);

        Water water =
                new Water(
                        realWater,
                        washingFrequency,
                        washingMachine,
                        showerTime,
                        additionalWater);

        WaterCalculations calc =
                new WaterCalculations();

        calc.calculateBaseConsumption(
                user.getNumperson());

        calc.calculateStratumAdjustment(
                user.getStratum());

        calc.calculateScore(
                water.getPoints());

        calc.calculateExpectedConsumption();

        calc.calculatePercentage(
                water.getRealConsumption());

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