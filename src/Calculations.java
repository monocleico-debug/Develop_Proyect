public class Calculations {

    private double baseConsumption;
    private int stratumAdjustment;
    private double score;
    private double expectedConsumption;
    private double percentage;
    private String classification;

    public void calculateBaseConsumption(int numPerson) {
        baseConsumption = (numPerson * 3.5) + 2;
    }

    public void calculateStratumAdjustment(int stratum) {
        switch (stratum) {
            case 1: stratumAdjustment = -2; break;
            case 2: stratumAdjustment = -1; break;
            case 3: stratumAdjustment = 0; break;
            case 4: stratumAdjustment = 1; break;
            case 5: stratumAdjustment = 2; break;
            case 6: stratumAdjustment = 3; break;
            default: stratumAdjustment = 0;
        }
    }

    public void calculateScore(int totalPoints) {
        score = totalPoints * 0.8;
    }

    public void calculateExpectedConsumption() {
        expectedConsumption = baseConsumption + stratumAdjustment + score;
    }

    public void calculatePercentage(double realConsumption) {
        percentage = (realConsumption / expectedConsumption) * 100;
    }

    public void classifyConsumption() {
        if (percentage < 80) {
            classification = "Bajo";
        } else if (percentage <= 110) {
            classification = "Medio";
        } else {
            classification = "Alto";
        }
    }

    // Getters
    public double getBaseConsumption() { return baseConsumption; }
    public int getStratumAdjustment() { return stratumAdjustment; }
    public double getScore() { return score; }
    public double getExpectedConsumption() { return expectedConsumption; }
    public double getPercentage() { return percentage; }
    public String getClassification() { return classification; }
}