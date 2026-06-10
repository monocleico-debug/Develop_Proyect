package Control;

import CalculationsService.Calculations;
import Model.Gas;
import Model.Result;
import Model.User;

public class GasController {

    public Result analyze(
            int stratum,
            int numPerson,
            double realGas,
            int cookingFrequency,
            int kitchenType,
            int usageTime) {

        User user =
                new User(
                        stratum,
                        numPerson);

        Gas gas =
                new Gas(
                        realGas,
                        cookingFrequency,
                        kitchenType,
                        usageTime);

        Calculations calc =
                new Calculations();

        calc.calculateBaseConsumption(
                user.getNumperson());

        calc.calculateStratumAdjustment(
                user.getStratum());

        calc.calculateScore(
                gas.getPoints());

        calc.calculateExpectedConsumption();

        calc.calculatePercentage(
                gas.getRealConsumption());

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