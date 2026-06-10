package View;

import Control.GasController;
import Model.Result;

import javax.swing.*;
import java.awt.*;

public class GasPanel extends JFrame {

    public GasPanel() {

        setTitle("Analisis de Gas");

        setSize(650, 650);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);

        ImageIcon icon =
                new ImageIcon(
                        "resources/app_icon.png");

        setIconImage(
                icon.getImage());

        getContentPane().setBackground(
                new Color(205, 224, 237));

        JLabel title =
                new JLabel(
                        "ANALISIS DE GAS");

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

        ImageIcon gasIcon =
                new ImageIcon("resources/gas.png");

        Image gasImage =
                gasIcon.getImage()
                        .getScaledInstance(
                                100,
                                100,
                                Image.SCALE_SMOOTH);

        JLabel lblGasIcon =
                new JLabel(
                        new ImageIcon(
                                gasImage));

        lblGasIcon.setBounds(
                500,
                5,
                100,
                100);

        add(lblGasIcon);

        JLabel lblStratum =
                new JLabel("Estrato:");

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

        JLabel lblRealGas =
                new JLabel(
                        "Consumo real de gas (m³):");

        lblRealGas.setBounds(
                20,
                180,
                180,
                25);

        JTextField txtRealGas =
                new JTextField();

        txtRealGas.setBounds(
                220,
                180,
                180,
                30);

        JLabel lblCookingFrequency =
                new JLabel(
                        "Frecuencia de cocina:");

        lblCookingFrequency.setBounds(
                20,
                230,
                180,
                25);

        JComboBox<String> cmbCookingFrequency =
                new JComboBox<>();

        cmbCookingFrequency.addItem(
                "Bajo");

        cmbCookingFrequency.addItem(
                "Medio");

        cmbCookingFrequency.addItem(
                "Alto");

        cmbCookingFrequency.setBounds(
                220,
                230,
                180,
                30);

        JLabel lblKitchenType =
                new JLabel(
                        "Tipo de cocina:");

        lblKitchenType.setBounds(
                20,
                280,
                180,
                25);

        JComboBox<String> cmbKitchenType =
                new JComboBox<>();

        cmbKitchenType.addItem(
                "Basica");

        cmbKitchenType.addItem(
                "Normal");

        cmbKitchenType.addItem(
                "Avanzada");

        cmbKitchenType.setBounds(
                220,
                280,
                180,
                30);

        JLabel lblUsageTime =
                new JLabel(
                        "Tiempo de uso:");

        lblUsageTime.setBounds(
                20,
                330,
                180,
                25);

        JComboBox<String> cmbUsageTime =
                new JComboBox<>();

        cmbUsageTime.addItem(
                "< 1 Hora");

        cmbUsageTime.addItem(
                "1 - 2 Horas");

        cmbUsageTime.addItem(
                "> 2 Horas");

        cmbUsageTime.setBounds(
                220,
                330,
                180,
                30);

        JButton btnAnalyze =
                new JButton(
                        "Analizar");

        btnAnalyze.setBounds(
                240,
                390,
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
                450,
                590,
                130);

        btnAnalyze.addActionListener(e -> {

            try {

                int stratum =
                        Integer.parseInt(
                                txtStratum.getText());

                if (stratum < 1 || stratum > 6) {
                    throw new Exception();
                }

                int numPerson =
                        Integer.parseInt(
                                txtNumPerson.getText());

                if (numPerson <= 0) {
                    throw new Exception();
                }

                double realGas =
                        Double.parseDouble(
                                txtRealGas.getText());

                if (realGas <= 0) {
                    throw new Exception();
                }

                int cookingFrequency =
                        cmbCookingFrequency
                                .getSelectedIndex() + 1;

                int kitchenType =
                        cmbKitchenType
                                .getSelectedIndex() + 1;

                int usageTime =
                        cmbUsageTime
                                .getSelectedIndex() + 1;

                GasController controller =
                        new GasController();

                Result result =
                        controller.analyze(
                                stratum,
                                numPerson,
                                realGas,
                                cookingFrequency,
                                kitchenType,
                                usageTime
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

        add(lblRealGas);
        add(txtRealGas);

        add(lblCookingFrequency);
        add(cmbCookingFrequency);

        add(lblKitchenType);
        add(cmbKitchenType);

        add(lblUsageTime);
        add(cmbUsageTime);

        add(btnAnalyze);

        add(scroll);

        setVisible(true);

    }

}