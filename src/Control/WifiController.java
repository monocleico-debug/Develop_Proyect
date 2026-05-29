package Control;

import Model.Wifi;
import java.util.Scanner;

public class WifiController {

    Scanner sc = new Scanner(System.in);

    public void startWifiService() {

        System.out.println("========== SERVICIO WIFI ==========");

        System.out.print("Ingrese la velocidad del internet (Mbps): ");
        double realWifi = sc.nextDouble();

        System.out.println("\nCantidad de dispositivos conectados:");
        System.out.println("1. Bajo");
        System.out.println("2. Medio");
        System.out.println("3. Alto");
        int connectedDevices = sc.nextInt();

        System.out.println("\nUso de streaming:");
        System.out.println("1. Bajo");
        System.out.println("2. Medio");
        System.out.println("3. Alto");
        int streamingUse = sc.nextInt();

        System.out.println("\nUso de videojuegos online:");
        System.out.println("1. Nunca");
        System.out.println("2. Ocasional");
        System.out.println("3. Frecuente");
        int gamingUse = sc.nextInt();

        System.out.println("\nHoras diarias de conexion:");
        System.out.println("1. Menos de 4 horas");
        System.out.println("2. 4 a 8 horas");
        System.out.println("3. Mas de 8 horas");
        int connectionHours = sc.nextInt();

        Wifi wifi = new Wifi(
                realWifi,
                connectedDevices,
                streamingUse,
                gamingUse,
                connectionHours
        );

        System.out.println("\nPuntaje total: " + wifi.getPoints());

        System.out.println("\nServicio wifi registrado correctamente.");
    }
}