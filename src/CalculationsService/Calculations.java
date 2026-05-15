package CalculationsService;

public class Calculations {

    private double baseConsumption;
    private int stratumAdjustment;
    private double score;
    private double expectedConsumption;
    private double percentage;
    private String classification;
    private String efficiencyLevel;
    private String recommendation;
    private String alert;

    public void calculateBaseConsumption(
            int numPerson) {

        baseConsumption =
                (numPerson * 3.5) + 2;

    }

    public void calculateStratumAdjustment(
            int stratum) {

        switch (stratum) {

            case 1 -> stratumAdjustment = -2;
            case 2 -> stratumAdjustment = -1;
            case 3 -> stratumAdjustment = 0;
            case 4 -> stratumAdjustment = 1;
            case 5 -> stratumAdjustment = 2;
            case 6 -> stratumAdjustment = 3;
            default -> stratumAdjustment = 0;

        }

    }

    public void calculateScore(int totalPoints) {

        score = totalPoints * 0.8;

    }

    public void calculateExpectedConsumption() {

        expectedConsumption =
                baseConsumption
                        + stratumAdjustment
                        + score;

    }

    public void calculatePercentage(
            double realConsumption) {

        percentage =
                (realConsumption
                        / expectedConsumption) * 100;

    }

    public void classifyConsumption() {

        if (percentage < 80) {

            classification = "Bajo";
            efficiencyLevel = "Alta";

            recommendation =
                    "Excelente consumo.";

            alert =
                    "Sin alertas.";

        }

        else if (percentage <= 110) {

            classification = "Medio";
            efficiencyLevel = "Media";

            recommendation =
                    "Mantener hábitos.";

            alert =
                    "Consumo normal.";

        }

        else {

            classification = "Alto";
            efficiencyLevel = "Baja";

            recommendation =
                    "Reducir consumo.";

            alert =
                    "ALERTA: consumo elevado.";

        }

    }

    public double getBaseConsumption() {
        return baseConsumption;
    }

    public double getExpectedConsumption() {
        return expectedConsumption;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getClassification() {
        return classification;
    }

    public String getEfficiencyLevel() {
        return efficiencyLevel;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public String getAlert() {
        return alert;
    }

}