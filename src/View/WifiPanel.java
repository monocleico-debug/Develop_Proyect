package View;

import Control.WifiController;
import Model.Result;

import javax.swing.*;
import java.awt.*;

public class WifiPanel extends JFrame {

    public WifiPanel() {

        setTitle(
                "Analisis de Internet");

        setSize(
                650,
                650);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setBackground(
                new Color(
                        205,
                        224,
                        237));

        JLabel title =
                new JLabel(
                        "ANALISIS DE INTERNET");

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
                new JLabel("Numero de personas:");

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

        JLabel lblRealWifi =
                new JLabel("Velocidad Internet (Mbps):");

        lblRealWifi.setBounds(
                20,
                180,
                180,
                25);

        JTextField txtRealWifi =
                new JTextField();

        txtRealWifi.setBounds(
                220,
                180,
                180,
                30);

        JLabel lblConnectedDevices =
                new JLabel("Dispositivos conectados:");

        lblConnectedDevices.setBounds(
                20,
                230,
                180,
                25);

        JComboBox<String> cmbConnectedDevices =
                new JComboBox<>();

        cmbConnectedDevices.addItem("1 - 3");
        cmbConnectedDevices.addItem("4 - 6");
        cmbConnectedDevices.addItem("Mas de 6");

        cmbConnectedDevices.setBounds(
                220,
                230,
                180,
                30);

        JLabel lblStreamingUse =
                new JLabel("Uso de streaming:");

        lblStreamingUse.setBounds(
                20,
                280,
                180,
                25);

        JComboBox<String> cmbStreamingUse =
                new JComboBox<>();

        cmbStreamingUse.addItem("Bajo");
        cmbStreamingUse.addItem("Medio");
        cmbStreamingUse.addItem("Alto");

        cmbStreamingUse.setBounds(
                220,
                280,
                180,
                30);

        JLabel lblGamingUse =
                new JLabel("Videojuegos online:");

        lblGamingUse.setBounds(
                20,
                330,
                180,
                25);

        JComboBox<String> cmbGamingUse =
                new JComboBox<>();

        cmbGamingUse.addItem("Nunca");
        cmbGamingUse.addItem("Ocasional");
        cmbGamingUse.addItem("Frecuente");

        cmbGamingUse.setBounds(
                220,
                330,
                180,
                30);

        JLabel lblConnectionHours =
                new JLabel("Horas de conexion:");

        lblConnectionHours.setBounds(
                20,
                380,
                180,
                25);

        JComboBox<String> cmbConnectionHours =
                new JComboBox<>();

        cmbConnectionHours.addItem("< 4 Horas");
        cmbConnectionHours.addItem("4 - 8 Horas");
        cmbConnectionHours.addItem("> 8 Horas");

        cmbConnectionHours.setBounds(
                220,
                380,
                180,
                30);

        JButton btnAnalyze =
                new JButton("Analizar");

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

        txtResult.setEditable(false);

        txtResult.setBorder(
                BorderFactory.createTitledBorder(
                        "Resultado del Analisis"));

        JScrollPane scroll =
                new JScrollPane(txtResult);

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

                double realWifi =
                        Double.parseDouble(
                                txtRealWifi.getText());

                if (realWifi <= 0) {
                    throw new Exception();
                }

                int connectedDevices =
                        cmbConnectedDevices.getSelectedIndex() + 1;

                int streamingUse =
                        cmbStreamingUse.getSelectedIndex() + 1;

                int gamingUse =
                        cmbGamingUse.getSelectedIndex() + 1;

                int connectionHours =
                        cmbConnectionHours.getSelectedIndex() + 1;

                WifiController controller =
                        new WifiController();

                Result result =
                        controller.analyze(
                                stratum,
                                numPerson,
                                realWifi,
                                connectedDevices,
                                streamingUse,
                                gamingUse,
                                connectionHours
                        );

                txtResult.setText(

                        "Consumo base: "
                                + result.getBaseConsumption()

                                + "\nConsumo esperado: "
                                + result.getExpectedConsumption()

                                + "\nPorcentaje: "
                                + String.format("%.2f",
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

        add(lblRealWifi);
        add(txtRealWifi);

        add(lblConnectedDevices);
        add(cmbConnectedDevices);

        add(lblStreamingUse);
        add(cmbStreamingUse);

        add(lblGamingUse);
        add(cmbGamingUse);

        add(lblConnectionHours);
        add(cmbConnectionHours);

        add(btnAnalyze);

        add(scroll);

        setVisible(true);

    }

}