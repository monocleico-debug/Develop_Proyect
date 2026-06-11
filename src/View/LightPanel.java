package View;

import Control.LightController;
import Model.Result;

import javax.swing.*;
import java.awt.*;

public class LightPanel extends JFrame {

    public LightPanel() {

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

        JLabel lblAppliancesQuantity =
                new JLabel(
                        "Electrodomesticos:");

        lblAppliancesQuantity.setBounds(
                20,
                230,
                180,
                25);

        JComboBox<String> cmbAppliancesQuantity =
                new JComboBox<>();

        cmbAppliancesQuantity.addItem(
                "Pocos");

        cmbAppliancesQuantity.addItem(
                "Moderados");

        cmbAppliancesQuantity.addItem(
                "Muchos");

        cmbAppliancesQuantity.setBounds(
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

        JLabel lblElectronicsUseTime =
                new JLabel(
                        "Uso de electronicos:");

        lblElectronicsUseTime.setBounds(
                20,
                380,
                180,
                25);

        JComboBox<String> cmbElectronicsUseTime =
                new JComboBox<>();

        cmbElectronicsUseTime.addItem(
                "< 4 Horas");

        cmbElectronicsUseTime.addItem(
                "4 - 8 Horas");

        cmbElectronicsUseTime.addItem(
                "> 8 Horas");

        cmbElectronicsUseTime.setBounds(
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

                if (stratum < 1 || stratum > 6) {
                    throw new Exception();
                }

                int numPerson =
                        Integer.parseInt(
                                txtNumPerson.getText());

                if (numPerson <= 0) {
                    throw new Exception();
                }

                double realLight =
                        Double.parseDouble(
                                txtRealLight.getText());

                if (realLight <= 0) {
                    throw new Exception();
                }

                int appliancesQuantity =
                        cmbAppliancesQuantity
                                .getSelectedIndex() + 1;

                int airConditioner =
                        cmbAirConditioner
                                .getSelectedIndex() + 1;

                int nightConsumption =
                        cmbNightConsumption
                                .getSelectedIndex() + 1;

                int electronicsUseTime =
                        cmbElectronicsUseTime
                                .getSelectedIndex() + 1;

                LightController controller =
                        new LightController();

                Result result =
                        controller.analyze(
                                stratum,
                                numPerson,
                                realLight,
                                appliancesQuantity,
                                airConditioner,
                                nightConsumption,
                                electronicsUseTime
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

        add(lblAppliancesQuantity);
        add(cmbAppliancesQuantity);

        add(lblAirConditioner);
        add(cmbAirConditioner);

        add(lblNightConsumption);
        add(cmbNightConsumption);

        add(lblElectronicsUseTime);
        add(cmbElectronicsUseTime);

        add(btnAnalyze);

        add(scroll);

        setVisible(true);

    }

}