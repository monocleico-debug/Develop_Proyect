package Model;

public class Result {

    private double baseConsumption;
    private double expectedConsumption;
    private double percentage;
    private String classification;
    private String efficiencyLevel;
    private String recommendation;
    private String alert;

    public Result(
            double baseConsumption,
            double expectedConsumption,
            double percentage,
            String classification,
            String efficiencyLevel,
            String recommendation,
            String alert) {

        this.baseConsumption = baseConsumption;
        this.expectedConsumption = expectedConsumption;
        this.percentage = percentage;
        this.classification = classification;
        this.efficiencyLevel = efficiencyLevel;
        this.recommendation = recommendation;
        this.alert = alert;

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
