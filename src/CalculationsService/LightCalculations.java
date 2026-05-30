package CalculationsService;

public class LightCalculations {
    private double baseConsumption;
    private int stratumAdjustment;
    private double score;
    private double expectedConsumption;
    private double percentage;
    private String classification;
    private String efficiencyLevel;
    private String recommendation;
    private String alert;

    public void calculateBaseConsumption(int numPerson) {

        baseConsumption =
                (numPerson * 28) + 15;

    }

    public void calculateStratumAdjustment(int stratum) {

        switch (stratum) {

            case 1:
                stratumAdjustment = -2;
                break;

            case 2:
                stratumAdjustment = -1;
                break;

            case 3:
                stratumAdjustment = 0;
                break;

            case 4:
                stratumAdjustment = 1;
                break;

            case 5:
                stratumAdjustment = 2;
                break;

            case 6:
                stratumAdjustment = 3;
                break;

            default:
                System.out.println("Estrato invalido");
                stratumAdjustment = 0;

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

    public void calculatePercentage(double realConsumption) {

        percentage =
                (realConsumption / expectedConsumption) * 100;

    }

    public void classifyConsumption() {

        if (percentage < 80) {

            classification = "Bajo";
            efficiencyLevel = "Alta";

            recommendation =
                    "Excelente uso de energia electrica.";

            alert =
                    "No se han detectado problemas.";

        }

        else if (percentage <= 110) {

            classification = "Medio";
            efficiencyLevel = "Media";

            recommendation =
                    "Mantener habitos actuales de consumo.";

            alert =
                    "Consumo dentro del rango normal.";

        }

        else {

            classification = "Alto";
            efficiencyLevel = "Baja";

            recommendation =
                    "El servicio de luz pudo haber sido alterado.";

            alert =
                    "ALERTA: consumo elevado de energia.";

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

