import java.util.Scanner;

public class GasController {

    public void iniciar() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- ANALISIS DE GAS ---");

        // Datos del usuario
        System.out.print("Ingrese el estrato (1-6): ");
        int estrato = sc.nextInt();

        System.out.print("Ingrese numero de personas en el hogar: ");
        int personas = sc.nextInt();

        User user = new User(estrato, personas);


        System.out.print("Ingrese consumo real de gas (m3): ");
        double realGas = sc.nextDouble();

        System.out.println("\nFrecuencia de cocina:");
        System.out.println("1. Baja");
        System.out.println("2. Media");
        System.out.println("3. Alta");
        int cookingFrequency = sc.nextInt();

        System.out.println("\nTipo de cocina:");
        System.out.println("1. Basica");
        System.out.println("2. Normal");
        System.out.println("3. Avanzada");
        int kitchenType = sc.nextInt();

        System.out.println("\nTiempo de uso diario:");
        System.out.println("1. Menos de 1 hora");
        System.out.println("2. Entre 1 y 2 horas");
        System.out.println("3. Mas de 2 horas");
        int usageTime = sc.nextInt();

        Gas gas = new Gas(realGas, cookingFrequency, kitchenType, usageTime);


        Calculations calc = new Calculations();

        calc.calculateBaseConsumption(user.getNumperson());
        calc.calculateStratumAdjustment(user.getStratum());
        calc.calculateScore(gas.getPoints());
        calc.calculateExpectedConsumption();
        calc.calculatePercentage(gas.getRealGas());
        calc.classifyConsumption();


        Result result = new Result(
                calc.getBaseConsumption(),
                calc.getExpectedConsumption(),
                calc.getPercentage(),
                calc.getClassification()
        );

        System.out.println("\n===== RESULTADOS =====");
        result.showResults();
    }
}
