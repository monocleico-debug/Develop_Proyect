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

    public void showResults() {

        System.out.println(
                "Consumo base: "
                        + baseConsumption);

        System.out.println(
                "Consumo esperado: "
                        + expectedConsumption);

        System.out.println(
                "Porcentaje: "
                        + percentage + "%");

        System.out.println(
                "Clasificación: "
                        + classification);

        System.out.println(
                "Nivel de eficiencia: "
                        + efficiencyLevel);

        System.out.println(
                "Recomendación: "
                        + recommendation);

        System.out.println(
                "Alerta: "
                        + alert);

    }

}
