package Control;

import Model.Water;
import java.util.Scanner;

public class WaterController {

    Scanner sc = new Scanner(System.in);

    public void startWaterService() {

        System.out.println("===== SERVICIO AGUA =====");

        System.out.print("Consumo de agua (m3): ");
        double realWater = sc.nextDouble();

        System.out.println("\nFrecuencia de lavado:");
        System.out.println("1. Bajo");
        System.out.println("2. Medio");
        System.out.println("3. Alto");
        int washingFrequency = sc.nextInt();

        System.out.println("\nUso de lavadora:");
        System.out.println("1. Poco");
        System.out.println("2. Normal");
        System.out.println("3. Mucho");
        int washingMachine = sc.nextInt();

        System.out.println("\nDuración de la ducha:");
        System.out.println("1. Corto");
        System.out.println("2. Medio");
        System.out.println("3. Largo");
        int showerTime = sc.nextInt();

        System.out.println("\nUso adicional de agua:");
        System.out.println("1. Ninguno");
        System.out.println("2. Jardín o patio");
        System.out.println("3. Piscina o carro");
        int additionalWater = sc.nextInt();

        Water water = new Water(
                realWater,
                washingFrequency,
                washingMachine,
                showerTime,
                additionalWater
        );

        System.out.println("\nPuntaje total: " + water.getPoints());

        System.out.println("Listo, servicio de agua registrado 👍");
    }
}