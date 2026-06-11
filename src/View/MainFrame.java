package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Analizador de Servicios Públicos");

        setSize(700, 500);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        getContentPane().setBackground(
                new Color(205, 224, 237));

        JLabel title =
                new JLabel(
                        "ANALIZADOR DE SERVICIOS PUBLICOS");

        title.setBounds(
                100,
                20,
                500,
                40);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        title.setHorizontalAlignment(
                SwingConstants.CENTER);

        add(title);

        JLabel subtitle =
                new JLabel(
                        "Seleccione un servicio para analizar");

        subtitle.setBounds(
                100,
                60,
                500,
                30);

        subtitle.setHorizontalAlignment(
                SwingConstants.CENTER);

        add(subtitle);

        JButton gasButton =
                new JButton("Gas");

        gasButton.setBounds(
                120,
                140,
                180,
                60);

        gasButton.setBackground(
                new Color(170, 225, 115));

        JButton waterButton =
                new JButton("Agua");

        waterButton.setBounds(
                380,
                140,
                180,
                60);

        waterButton.setBackground(
                new Color(112, 134, 234));

        JButton lightButton =
                new JButton("Luz");

        lightButton.setBounds(
                120,
                250,
                180,
                60);

        lightButton.setBackground(
                new Color(228, 212, 121));

        JButton wifiButton =
                new JButton("Internet");

        wifiButton.setBounds(
                380,
                250,
                180,
                60);

        wifiButton.setBackground(
                new Color(173, 127, 218));

        JButton exitButton =
                new JButton("Salir");

        exitButton.setBounds(
                250,
                370,
                180,
                50);

        add(gasButton);
        add(waterButton);
        add(lightButton);
        add(wifiButton);
        add(exitButton);

        gasButton.addActionListener(
                e -> new GasPanel()
        );

        waterButton.addActionListener(
                e -> new WaterPanel()
        );

        lightButton.addActionListener(
                e -> new LightPanel()
        );

        wifiButton.addActionListener(
                e -> new WifiPanel()
        );

        exitButton.addActionListener(
                e -> System.exit(0)
        );

        setVisible(true);

    }

}