package View;

import Control.WaterController;
import Model.Result;

import javax.swing.*;
import java.awt.*;

public class WaterPanel extends JFrame {

    public WaterPanel() {

        ImageIcon icon =
                new ImageIcon(
                        "resources/app_icon.png");

        setIconImage(
                icon.getImage());

        setTitle(
                "Analisis de Agua");

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
                        "ANALISIS DE AGUA");

        title.setBounds(
                170,
                15,
                350,
                30);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        add(title);

        ImageIcon waterIcon =
                new ImageIcon(
                        "resources/water.png");

        Image waterImage =
                waterIcon.getImage()
                        .getScaledInstance(
                                100,
                                100,
                                Image.SCALE_SMOOTH);

        JLabel lblWaterIcon =
                new JLabel(
                        new ImageIcon(
                                waterImage));

        lblWaterIcon.setBounds(
                500,
                5,
                100,
                100);

        add(lblWaterIcon);

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

        JLabel lblRealWater =
                new JLabel(
                        "Consumo real de agua (m3):");

        lblRealWater.setBounds(
                20,
                180,
                180,
                25);

        JTextField txtRealWater =
                new JTextField();

        txtRealWater.setBounds(
                220,
                180,
                180,
                30);

        JLabel lblWashingFrequency =
                new JLabel(
                        "Frecuencia de lavado:");

        lblWashingFrequency.setBounds(
                20,
                230,
                180,
                25);

        JComboBox<String> cmbWashingFrequency =
                new JComboBox<>();

        cmbWashingFrequency.addItem(
                "Bajo");

        cmbWashingFrequency.addItem(
                "Medio");

        cmbWashingFrequency.addItem(
                "Alto");

        cmbWashingFrequency.setBounds(
                220,
                230,
                180,
                30);

        JLabel lblWashingMachine =
                new JLabel(
                        "Uso de la lavadora:");

        lblWashingMachine.setBounds(
                20,
                280,
                180,
                25);

        JComboBox<String> cmbWashingMachine =
                new JComboBox<>();

        cmbWashingMachine.addItem(
                "1-2 veces semana");

        cmbWashingMachine.addItem(
                "3-5 veces semana");

        cmbWashingMachine.addItem(
                "Diario");

        cmbWashingMachine.setBounds(
                220,
                280,
                180,
                30);

        JLabel lblShowerTime =
                new JLabel(
                        "Tiempo en la ducha:");

        lblShowerTime.setBounds(
                20,
                330,
                180,
                25);

        JComboBox<String> cmbShowerTime =
                new JComboBox<>();

        cmbShowerTime.addItem(
                "< 10 min");

        cmbShowerTime.addItem(
                "10 - 20 min");

        cmbShowerTime.addItem(
                "> 20 min");

        cmbShowerTime.setBounds(
                220,
                330,
                180,
                30);

        JLabel lblAdditionalWater =
                new JLabel(
                        "Uso adicional:");

        lblAdditionalWater.setBounds(
                20,
                380,
                180,
                25);

        JComboBox<String> cmbAdditionalWater =
                new JComboBox<>();

        cmbAdditionalWater.addItem(
                "Ninguno");

        cmbAdditionalWater.addItem(
                "Jardin o patio");

        cmbAdditionalWater.addItem(
                "Piscina o lavado de auto");

        cmbAdditionalWater.setBounds(
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

                double realWater =
                        Double.parseDouble(
                                txtRealWater.getText());

                int washingFrequency =
                        cmbWashingFrequency
                                .getSelectedIndex() + 1;

                int washingMachine =
                        cmbWashingMachine
                                .getSelectedIndex() + 1;

                int showerTime =
                        cmbShowerTime
                                .getSelectedIndex() + 1;

                int additionalWater =
                        cmbAdditionalWater
                                .getSelectedIndex() + 1;

                WaterController controller =
                        new WaterController();

                Result result =
                        controller.analyze(
                                stratum,
                                numPerson,
                                realWater,
                                washingFrequency,
                                washingMachine,
                                showerTime,
                                additionalWater
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

        add(lblRealWater);
        add(txtRealWater);

        add(lblWashingFrequency);
        add(cmbWashingFrequency);

        add(lblWashingMachine);
        add(cmbWashingMachine);

        add(lblShowerTime);
        add(cmbShowerTime);

        add(lblAdditionalWater);
        add(cmbAdditionalWater);

        add(btnAnalyze);

        add(scroll);

        setVisible(true);

    }

}