package View;

import Control.LightController;
import Model.Result;

import javax.swing.*;
import java.awt.*;

public class LightPanel extends JFrame {

    public LightPanel() {

        ImageIcon icon =
                new ImageIcon(
                        "resources/app_icon.png");

        setIconImage(
                icon.getImage());

        setTitle(
                "Analisis de Luz");

        setSize(
                650,
                650);

        setLayout(null);

        setLocationRelativeTo(
                null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setBackground(
                new Color(
                        205,
                        224,
                        237));

        JLabel title =
                new JLabel(
                        "ANALISIS DE LUZ");

        title.setBounds(
                180,
                15,
                300,
                30);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        add(title);

        ImageIcon lightIcon =
                new ImageIcon(
                        "resources/light.png");

        Image lightImage =
                lightIcon.getImage()
                        .getScaledInstance(
                                100,
                                100,
                                Image.SCALE_SMOOTH);

        JLabel lblLightIcon =
                new JLabel(
                        new ImageIcon(
                                lightImage));

        lblLightIcon.setBounds(
                500,
                5,
                100,
                100);

        add(lblLightIcon);

        JLabel lblStratum =
                new JLabel(
                        "Estrato:");

        lblStratum.setBounds(
                20,
                80,
                180,
                25);

        JTextField txtStratum =
                new JTextField();

        txtStratum.setBounds(
                220,
                80,
                180,
                30);

        JLabel lblNumPerson =
                new JLabel(
                        "Numero de personas:");

        lblNumPerson.setBounds(
                20,
                130,
                180,
                25);

        JTextField txtNumPerson =
                new JTextField();

        txtNumPerson.setBounds(
                220,
                130,
                180,
                30);

        JLabel lblRealLight =
                new JLabel(
                        "Consumo real (kWh):");

        lblRealLight.setBounds(
                20,
                180,
                180,
                25);

        JTextField txtRealLight =
                new JTextField();

        txtRealLight.setBounds(
                220,
                180,
                180,
                30);

        JLabel lblAppliances =
                new JLabel(
                        "Electrodomesticos:");

        lblAppliances.setBounds(
                20,
                230,
                180,
                25);

        JComboBox<String> cmbAppliances =
                new JComboBox<>();

        cmbAppliances.addItem(
                "Pocos");

        cmbAppliances.addItem(
                "Moderados");

        cmbAppliances.addItem(
                "Muchos");

        cmbAppliances.setBounds(
                220,
                230,
                180,
                30);

        JLabel lblAirConditioner =
                new JLabel(
                        "Uso aire acondicionado:");

        lblAirConditioner.setBounds(
                20,
                280,
                180,
                25);

        JComboBox<String> cmbAirConditioner =
                new JComboBox<>();

        cmbAirConditioner.addItem(
                "Nunca");

        cmbAirConditioner.addItem(
                "Ocasional");

        cmbAirConditioner.addItem(
                "Frecuente");

        cmbAirConditioner.setBounds(
                220,
                280,
                180,
                30);

        JLabel lblNightConsumption =
                new JLabel(
                        "Consumo nocturno:");

        lblNightConsumption.setBounds(
                20,
                330,
                180,
                25);

        JComboBox<String> cmbNightConsumption =
                new JComboBox<>();

        cmbNightConsumption.addItem(
                "Bajo");

        cmbNightConsumption.addItem(
                "Medio");

        cmbNightConsumption.addItem(
                "Alto");

        cmbNightConsumption.setBounds(
                220,
                330,
                180,
                30);

        JLabel lblElectronicsUsage =
                new JLabel(
                        "Uso de electronicos:");

        lblElectronicsUsage.setBounds(
                20,
                380,
                180,
                25);

        JComboBox<String> cmbElectronicsUsage =
                new JComboBox<>();

        cmbElectronicsUsage.addItem(
                "< 4 Horas");

        cmbElectronicsUsage.addItem(
                "4 - 8 Horas");

        cmbElectronicsUsage.addItem(
                "> 8 Horas");

        cmbElectronicsUsage.setBounds(
                220,
                380,
                180,
                30);

        JButton btnAnalyze =
                new JButton(
                        "Analizar");

        btnAnalyze.setBounds(
                240,
                440,
                150,
                40);

        btnAnalyze.setBackground(
                new Color(
                        0,
                        153,
                        76));

        btnAnalyze.setForeground(
                Color.WHITE);

        btnAnalyze.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14));

        JTextArea txtResult =
                new JTextArea();

        txtResult.setEditable(
                false);

        txtResult.setBorder(
                BorderFactory
                        .createTitledBorder(
                                "Resultado del Analisis"));

        JScrollPane scroll =
                new JScrollPane(
                        txtResult);

        scroll.setBounds(
                20,
                500,
                590,
                80);

        btnAnalyze.addActionListener(e -> {

            try {

                int stratum =
                        Integer.parseInt(
                                txtStratum.getText());

                int numPerson =
                        Integer.parseInt(
                                txtNumPerson.getText());

                double realLight =
                        Double.parseDouble(
                                txtRealLight.getText());

                int appliances =
                        cmbAppliances
                                .getSelectedIndex() + 1;

                int airConditioner =
                        cmbAirConditioner
                                .getSelectedIndex() + 1;

                int nightConsumption =
                        cmbNightConsumption
                                .getSelectedIndex() + 1;

                int electronicsUsage =
                        cmbElectronicsUsage
                                .getSelectedIndex() + 1;

                LightController controller =
                        new LightController();

                Result result =
                        controller.analyze(
                                stratum,
                                numPerson,
                                realLight,
                                appliances,
                                airConditioner,
                                nightConsumption,
                                electronicsUsage
                        );

                txtResult.setText(

                        "Consumo base: "
                                + result.getBaseConsumption()

                                + "\nConsumo esperado: "
                                + result.getExpectedConsumption()

                                + "\nPorcentaje: "
                                + String.format(
                                "%.2f",
                                result.getPercentage())
                                + "%"

                                + "\nClasificacion: "
                                + result.getClassification()

                                + "\nNivel de eficiencia: "
                                + result.getEfficiencyLevel()

                                + "\nRecomendacion: "
                                + result.getRecommendation()

                                + "\nAlerta: "
                                + result.getAlert()
                );

            }

            catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Datos invalidos",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

            }

        });

        add(lblStratum);
        add(txtStratum);

        add(lblNumPerson);
        add(txtNumPerson);

        add(lblRealLight);
        add(txtRealLight);

        add(lblAppliances);
        add(cmbAppliances);

        add(lblAirConditioner);
        add(cmbAirConditioner);

        add(lblNightConsumption);
        add(cmbNightConsumption);

        add(lblElectronicsUsage);
        add(cmbElectronicsUsage);

        add(btnAnalyze);

        add(scroll);

        setVisible(true);

    }

}