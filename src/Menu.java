import Control.GasController;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    public Menu() {

        setTitle("Analisis de Servicios Publicos");

        setSize(400, 350);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(5,1,10,10));

        JButton gasButton =
                new JButton("Gas");

        JButton waterButton =
                new JButton("Agua");

        JButton lightButton =
                new JButton("Luz");

        JButton wifiButton =
                new JButton("Internet");

        JButton exitButton =
                new JButton("Salir");

        add(gasButton);
        add(waterButton);
        add(lightButton);
        add(wifiButton);
        add(exitButton);

        gasButton.addActionListener(e -> {

            GasController g =
                    new GasController();

            g.iniciar();

        });

        waterButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    null,
                    "Servicio Agua no disponible");

        });

        lightButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    null,
                    "Servicio Luz no disponible");

        });

        wifiButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    null,
                    "Servicio Internet no disponible");

        });

        exitButton.addActionListener(e -> {

            System.exit(0);

        });

        setVisible(true);

    }

    public static void main(String[] args) {

        new Menu();

    }

}
