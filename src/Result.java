public class Result {

    private double baseConsumption;
    private double expectedConsumption;
    private double percentage;
    private String classification;

    public Result(double baseConsumption, double expectedConsumption, double percentage, String classification) {
        this.baseConsumption = baseConsumption;
        this.expectedConsumption = expectedConsumption;
        this.percentage = percentage;
        this.classification = classification;
    }

    public void showResults() {
        System.out.println("Consumo base: " + baseConsumption);
        System.out.println("Consumo esperado: " + expectedConsumption);
        System.out.println("Porcentaje: " + percentage + "%");
        System.out.println("Clasificación: " + classification);
    }
}
