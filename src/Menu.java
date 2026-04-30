import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option;

        do{

            System.out.println("\n==============================");
            System.out.println("Analisis de Servicios Publicos");
            System.out.println("==============================");
            System.out.println("1. Gas");
            System.out.println("2. Agua");
            System.out.println("3. Luz");
            System.out.println("4. Internet");
            System.out.println("5. Salir");
            System.out.println("Elige una opcion: ");

            option = sc.nextInt();

            switch(option){

                case 1:
                    GasController g = new GasController();
                    g.iniciar();
                    break;

                case 2:
                    //Agua
                    break;

                case 3:
                    //Luz
                    break;

                case 4:
                    //Internet
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (option != 5);
        sc.close();

    }
}
